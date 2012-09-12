package org.hl7.fhir.definitions.parsers;

/*
 Copyright (c) 2011-2012, HL7, Inc
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, 
 are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
 list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
 this list of conditions and the following disclaimer in the documentation 
 and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
 endorse or promote products derived from this software without specific 
 prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 POSSIBILITY OF SUCH DAMAGE.

 */
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.EventDefn;
import org.hl7.fhir.definitions.model.EventUsage;
import org.hl7.fhir.definitions.model.Example;
import org.hl7.fhir.definitions.model.ExtensionDefn;
import org.hl7.fhir.definitions.model.Invariant;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.RegisteredProfile;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.SearchParameter;
import org.hl7.fhir.definitions.model.SearchParameter.SearchType;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.XLSXmlParser;
import org.hl7.fhir.utilities.XLSXmlParser.Sheet;

public class SpreadsheetParser {

	private String name;
	private XLSXmlParser xls;
	private List<EventDefn> events = new ArrayList<EventDefn>();
	private boolean isProfile;
	private String root;
	private Definitions definitions;
	private String title;
	private String folder;
	private Logger log;

	public SpreadsheetParser(InputStream in, String name,
			Definitions definitions, String root, Logger log) throws Exception {
		this.name = name;
		xls = new XLSXmlParser(in, name);
		this.root = root;
		this.definitions = definitions;
		if (name.indexOf('-') > 0)
			title = name.substring(0, name.indexOf('-'));
		else if (name.indexOf('.') > 0)
			title = name.substring(0, name.indexOf('.'));
		else
		  title = name;
		this.folder = root + title + File.separator;
		this.log = log;
	}


	public ElementDefn parseCompositeType(boolean allowDAR) throws Exception {
		isProfile = false;
		return parseCommonTypeColumns(allowDAR).getRoot();
	}

	private ResourceDefn parseCommonTypeColumns(boolean allowDAR) throws Exception {
		ResourceDefn resource = new ResourceDefn();
		
		Sheet sheet = xls.getSheets().get("Bindings");
		Map<String, BindingSpecification> typeLocalBindings = null;
		if (sheet != null)
			typeLocalBindings = readBindings(sheet);
			
		sheet = xls.getSheets().get("Invariants");
		Map<String,Invariant> invariants = null;
		if (sheet != null)
			invariants = readInvariants(sheet);
		
		sheet = xls.getSheets().get("Data Elements");
		for (int row = 0; row < sheet.rows.size(); row++) {
			processLine(resource, sheet, row, allowDAR, invariants);
		}
		
		for (Invariant inv : invariants.values()) {
		  if (Utilities.noString(inv.getContext())) 
		    log.log("Type "+resource.getRoot().getName()+" Invariant "+inv.getId()+" has no context");
		  else {
		    ElementDefn ed = findContext(resource.getRoot(), inv.getContext(), "Type "+resource.getRoot().getName()+" Invariant "+inv.getId()+" Context");
		    ed.getInvariants().put(inv.getId(), inv);
		    if (Utilities.noString(inv.getXpath()))
	        log.log("Type "+resource.getRoot().getName()+" Invariant "+inv.getId()+" ("+inv.getEnglish()+") has no XPath statement");
		    else if (inv.getXpath().contains("\""))
          log.log("Type "+resource.getRoot().getName()+" Invariant "+inv.getId()+" ("+inv.getEnglish()+") contains a \" character");
		  }
		}
		
		//TODO: Will fail if type has no root. - GG: so? when could that be
		// EK: Future types. But those won't get there.
		if( typeLocalBindings != null)
			resource.getRoot().getNestedBindings().putAll(typeLocalBindings);
		
		scanNestedTypes(resource, resource.getRoot(), resource.getName());
		
		return resource;
	}
	
	
	private void scanNestedTypes(ResourceDefn parent, ElementDefn root, String parentName) throws Exception
	{
		for( ElementDefn element : root.getElements() )
		{
			if( element.hasNestedElements() )
			{	
				String nestedTypeName;
				
				ElementDefn newCompositeType = new ElementDefn();
		
				// If user has given an explicit name, use it, otherwise  automatically
				// generated name for this nested type
				if( element.typeCode().startsWith("=") )
					nestedTypeName = element.typeCode().substring(1);
				else
				{
					nestedTypeName = parentName + Utilities.capitalize(element.getName());
					newCompositeType.setAnonymousTypedGroup(true);
				}
				
				// Add Component to the actually generated name to avoid
				// confusing between the element name and the element's type
				newCompositeType.setName(nestedTypeName+"Component");
				newCompositeType.setDefinition("A nested type in " + parent.getName() + ": "
								+ element.getDefinition() );
				newCompositeType.getElements().addAll(element.getElements());
			
				if( parent.getRoot().getNestedTypes().containsKey(nestedTypeName) )
					throw new Exception("Nested type " + nestedTypeName + 
							" already exist in resource " + parent.getName());
				
				parent.getRoot().getNestedTypes().put(nestedTypeName, newCompositeType );

				// Clear out the name of the local type, so old code
				// will not see a change.
				element.getTypes().clear();
				element.setDeclaredTypeName(newCompositeType.getName());
				
				scanNestedTypes( parent, element, nestedTypeName  );
			}
			
			resolveElementReferences(parent, element);
		}
	}
	
	private void resolveElementReferences(ResourceDefn parent, ElementDefn root)
			throws Exception 
	{
		for (TypeRef ref : root.getTypes()) {
			if (ref.isElementReference()) {
				ElementDefn referredElement = parent.getRoot()
						.getElementByName(ref.getName().substring(1));

				if (referredElement == null)
					throw new Exception("Element reference " + ref.getName()
							+ " cannot be found in type " + parent.getName());

				if (referredElement.getDeclaredTypeName() == null)
					throw new Exception(
							"Element reference "
									+ ref.getName()
									+ " in "
									+ parent.getName()
									+ " refers to an anonymous group of elements. Please specify names "
									+ " with the '=<name>' construct in the typename column.");

				ref.setResolvedTypeName(referredElement.getDeclaredTypeName());
			}
		}
	}
	
	
	public ResourceDefn parseResource() throws Exception {
		isProfile = false;
		ResourceDefn root = parseCommonTypeColumns(true);

		readEvents(xls.getSheets().get("Events"));
		readExamples(root, xls.getSheets().get("Examples"));
    readSearchParams(root, xls.getSheets().get("Search"));
    readProfiles(root, xls.getSheets().get("Profiles"));

		return root;
	}

	private void readProfiles(ResourceDefn defn, Sheet sheet) throws Exception {
    if (sheet != null) {
      for (int row = 0; row < sheet.rows.size(); row++) {
        String name = sheet.getColumn(row, "Name");
        if (name != null && !name.equals("")) {
          String desc = sheet.getColumn(row, "Description");
          if (desc == null || desc.equals(""))
            throw new Exception("Example " + name
                + " has no description parsing " + this.name);
          String title = sheet.getColumn(row, "Filename");
          File file = new File(folder
              + title+".xml");
          if (!file.exists())
            throw new Exception("Profile " + name + " file '"
                + file.getAbsolutePath()
                + "' not found parsing " + this.name);
          defn.getProfiles().add(
              new RegisteredProfile(name, desc, title, file.getAbsolutePath()));
        }
      }
    }
    
  }


  private Map<String,Invariant> readInvariants(Sheet sheet)
			throws Exception {
		Map<String,Invariant> result = new HashMap<String,Invariant>();
		
		for (int row = 0; row < sheet.rows.size(); row++) {
			Invariant inv = new Invariant();

			String s = sheet.getColumn(row, "Id");
			inv.setId(s);
			inv.setName(sheet.getColumn(row, "Name"));
			inv.setContext(sheet.getColumn(row, "Context"));
			inv.setEnglish(sheet.getColumn(row, "English"));
			inv.setXpath(sheet.getColumn(row, "XPath"));
			if (!Utilities.noString(sheet.getColumn(row,  "Schematron")))
			  log.log("Value found for schematron "+getLocation(row));  
			inv.setOcl(sheet.getColumn(row, "OCL"));
			if (s == null || s.equals("")
					|| result.containsKey(s))
				throw new Exception("duplicate or missing invariant id "
						+ getLocation(row));
			result.put(s, inv);
		}
		
		return result;
	}

	private void readSearchParams(ResourceDefn root2, Sheet sheet)
			throws Exception {
		root2.getSearchParams()
				.add(new SearchParameter(
						"n",
						"Starting offset of the first record to return in the search set",
						SearchType.integer));
		root2.getSearchParams()
				.add(new SearchParameter(
						"count",
						"Number of return records requested. The server is not bound to conform",
						SearchType.integer));
		root2.getSearchParams().add(
				new SearchParameter("id",
						"The id of the resource",
						SearchType.token));

		if (sheet != null)
			for (int row = 0; row < sheet.rows.size(); row++) {

				if (!sheet.hasColumn(row, "Name"))
					throw new Exception("Search Param has no name "
							+ getLocation(row));
				if (!sheet.hasColumn(row, "Description"))
					throw new Exception("Search Param has no dascription "
							+ getLocation(row));
				if (!sheet.hasColumn(row, "Type"))
					throw new Exception("Search Param has no type "
							+ getLocation(row));
				String n = sheet.getColumn(row, "Name");
				if (n.endsWith("-before") || n.endsWith("-before"))
					throw new Exception("Search Param includes relative time "
							+ getLocation(row));
				String d = sheet.getColumn(row, "Description");
				SearchType t = readSearchType(sheet.getColumn(row, "Type"), row);

				root2.getSearchParams().add(new SearchParameter(n, d, t));
			}
	}

	private SearchType readSearchType(String s, int row) throws Exception {
		if ("integer".equals(s))
			return SearchType.integer;
		if ("string".equals(s))
			return SearchType.string;
		if ("text".equals(s))
			return SearchType.text;
		if ("date".equals(s))
			return SearchType.date;
		if ("token".equals(s))
			return SearchType.token;
		if ("qtoken".equals(s))
			return SearchType.qtoken;
		throw new Exception("Unknown Search Type '" + s + "': "
				+ getLocation(row));
	}

	// Adds bindings to global definition.bindings. Returns list of
	// newly found bindings in the sheet.
	private Map<String, BindingSpecification> readBindings(Sheet sheet) throws Exception {
		Map<String, BindingSpecification> result = new HashMap<String,BindingSpecification>();
		
		for (int row = 0; row < sheet.rows.size(); row++) {
			BindingSpecification cd = new BindingSpecification();

			cd.setName(sheet.getColumn(row, "Binding Name"));
			cd.setDefinition(sheet.getColumn(row, "Definition"));
			cd.setBinding(BindingsParser.readBinding(sheet.getColumn(row,
					"Binding")));
			cd.setBindingStrength(BindingsParser.readBindingStrength(sheet
					.getColumn(row, "Binding Strength")));
			cd.setReference(sheet.getColumn(row, "Reference"));
			cd.setDescription(sheet.getColumn(row, "Description"));
			cd.setId(new BindingNameRegistry(root).idForName(cd.getName()));
			cd.setSource(name);

			if (cd.getBinding() == BindingSpecification.Binding.CodeList) {
				Sheet codes = xls.getSheets().get(
						cd.getReference().substring(1));
				if (codes == null)
					throw new Exception("code source sheet not found for "
							+ cd.getName() + ": " + cd.getReference());
				parseCodes(cd.getCodes(), codes);
			}
			if (definitions.getBindingByName(cd.getName()) != null) {
				throw new Exception("Definition of binding '"
						+ cd.getName()
						+ "' in "
						+ name
						+ " clashes with previous definition in "
						+ definitions.getBindingByName(cd.getName())
								.getSource());
			}
			definitions.getBindings().put(cd.getName(), cd);
			result.put(cd.getName(), cd);
		}
		
		return result;
	}

	private void parseCodes(List<DefinedCode> codes, Sheet sheet)
			throws Exception {
		for (int row = 0; row < sheet.rows.size(); row++) {
			DefinedCode c = new DefinedCode();
			c.setCode(sheet.getColumn(row, "Code"));
      c.setDisplay(sheet.getColumn(row, "Display"));
      c.setSystem(sheet.getColumn(row, "System"));
			c.setDefinition(sheet.getColumn(row, "Definition"));
			c.setComment(sheet.getColumn(row, "Comment"));
			codes.add(c);
		}
	}

	public ProfileDefn parseProfile(Definitions definitions) throws Exception {
		isProfile = true;
		ProfileDefn p = new ProfileDefn();

		Sheet sheet = xls.getSheets().get("Metadata");
		for (int row = 0; row < sheet.rows.size(); row++) {
			String n = sheet.getColumn(row, "Name");
			String v = sheet.getColumn(row, "Value");
			if (n != null && v != null) {
				if (p.getMetadata().containsKey(n))
					p.getMetadata().get(n).add(v);
				else {
					ArrayList<String> vl = new ArrayList<String>();
					vl.add(v);
					p.getMetadata().put(n, vl);
				}
			}
		}

    sheet = xls.getSheets().get("Invariants");
    Map<String,Invariant> invariants = null;
    if (sheet != null)
      invariants = readInvariants(sheet);
		
		if (p.getMetadata().containsKey("resource")) {
		  for (String n : p.getMetadata().get("resource")) {
		    ResourceDefn resource = new ResourceDefn();
		    sheet = xls.getSheets().get(n);
		    for (int row = 0; row < sheet.rows.size(); row++) {
		      processLine(resource, sheet, row, true, invariants);
		    }
		    sheet = xls.getSheets().get(n + "-Extensions");
		    if (sheet != null) {
		      for (int row = 0; row < sheet.rows.size(); row++) {
		        p.getExtensions().add(processExtension(
		            resource.getRoot().getElementByName("extensions"),
		            sheet, row, definitions,
		            p.metadata("extension.uri")));
		      }
		    }
		    p.getResources().add(resource);
		  }
		}

    sheet = xls.getSheets().get("Extensions");
    if (sheet != null) {
      for (int row = 0; row < sheet.rows.size(); row++) {
        p.getExtensions().add(processExtension(null,
            sheet, row, definitions,
            p.metadata("extension.uri")));
      }
    }

    sheet = xls.getSheets().get("Bindings");
    if (sheet != null)
      p.getBindings().addAll(readBindings(sheet).values());
      
		return p;
	}

	private void readExamples(ResourceDefn defn, Sheet sheet) throws Exception {
		if (sheet != null) {
			for (int row = 0; row < sheet.rows.size(); row++) {
				String name = sheet.getColumn(row, "Name");
				if (name != null && !name.equals("")) {
					String desc = sheet.getColumn(row, "Description");
					if (desc == null || desc.equals(""))
						throw new Exception("Example " + name
								+ " has no description parsing " + this.name);
					File file = new File(folder
							+ sheet.getColumn(row, "Filename"));
					String type = sheet.getColumn(row, "Type");
					if (!file.exists() && !"tool".equals(type))
						throw new Exception("Example " + name + " file '"
								+ file.getAbsolutePath()
								+ "' not found parsing " + this.name);
					defn.getExamples().add(
							new Example(name, desc, file, type, parseBoolean(sheet.getColumn(row, "In Book"), row, false)));
				}
			}
		}
		if (defn.getExamples().size() == 0) {
			File file = new File(folder + title + "-example.xml");
			if (!file.exists())
				throw new Exception("Example (file '" + file.getAbsolutePath()
						+ "') not found parsing " + this.name);
			defn.getExamples().add(
					new Example("General", "Example of " + title, file, null,
							true));
		}		
	}

	
	
	
	private void readEvents(Sheet sheet) throws Exception {
		if (sheet != null) {
			for (int row = 0; row < sheet.rows.size(); row++) {
				String code = sheet.getColumn(row, "Event Code");
				if (code != null && !code.equals("")) {
					EventDefn e = new EventDefn();
					events.add(e);
					e.setCode(code);
					e.setDefinition(sheet.getColumn(row, "Description"));
					EventUsage u = new EventUsage();
					e.getUsages().add(u);
					u.setNotes(sheet.getColumn(row, "Notes"));
					for (String s : sheet.getColumn(row, "Request Resources")
							.split(",")) {
						s = s.trim();
						if (s != "")
							u.getRequestResources().add(s);
					}
					for (String s : sheet
							.getColumn(row, "Request Aggregations").split("\n")) {
						s = s.trim();
						if (s != "")
							u.getRequestAggregations().add(s);
					}
					for (String s : sheet.getColumn(row, "Response Resources")
							.split(",")) {
						s = s.trim();
						if (s != "")
							u.getResponseResources().add(s);
					}
					for (String s : sheet.getColumn(row,
							"Response Aggregations").split("\n")) {
						s = s.trim();
						if (s != "")
							u.getResponseAggregations().add(s);
					}
					for (String s : sheet.getColumn(row, "Follow Ups").split(
							",")) {
						s = s.trim();
						if (s != "")
							e.getFollowUps().add(s);
					}

				}
			}
		}
	}

	private void processLine(ResourceDefn root, Sheet sheet, int row,
			boolean allowDAR, Map<String, Invariant> invariants) throws Exception {
		ElementDefn e;
		String path = sheet.getColumn(row, "Element");
		if (path.contains("#"))
			throw new Exception("Old path style @ " + getLocation(row));

		String profileName = isProfile ? sheet.getColumn(row, "Profile Name")
				: "";
		
		boolean isRoot = !path.contains(".");
		
		if (isRoot) {
			if (root.getRoot() != null)
				throw new Exception("Definitions in " + getLocation(row)
						+ " contain two roots: " + path + " in "
						+ root.getName());

			root.setName(path);
			e = new ElementDefn();
			e.setName(path);
			root.setRoot(e);
		} else {
			e = makeFromPath(root.getRoot(), path, row, profileName, true);
		}

		String c = sheet.getColumn(row, "Card.");
		if (c == null || c.equals("")) {
			if (!isRoot)
				throw new Exception("Missing cardinality");
			e.setMinCardinality(1);
			e.setMaxCardinality(1);
		} else {
			String[] card = c.split("\\.\\.");
			if (card.length != 2 || !Utilities.IsInteger(card[0])
					|| (!"*".equals(card[1]) && !Utilities.IsInteger(card[1])))
				throw new Exception("Unable to parse Cardinality '" + c + "' "
						+ c + " in " + getLocation(row) + " on " + path);
			e.setMinCardinality(Integer.parseInt(card[0]));
			e.setMaxCardinality("*".equals(card[1]) ? null : Integer
					.parseInt(card[1]));
		}
		e.setProfileName(profileName);

		e.setAllowDAR(allowDAR
				&& parseBoolean(sheet.getColumn(row, "DAR?"), row, true));
		e.setMustUnderstand(parseBoolean(
				sheet.getColumn(row, "Must Understand"), row, false));
		e.setMustSupport(parseBoolean(sheet.getColumn(row, "Must Support"),
				row, false));
		String s = sheet.getColumn(row, "Condition");
		if (s != null && !s.equals(""))
			throw new Exception("Found Condition in spreadsheet "
					+ getLocation(row));
		s = sheet.getColumn(row, "Inv.");
		if (s != null && !s.equals("")) {
			Invariant inv = invariants.get(s);
			if (inv == null)
				throw new Exception("unable to find Invariant '" + s + "' "
						+ getLocation(row));
			e.setInvariant(inv);
		}

		String t = sheet.getColumn(row, "Type");
		TypeParser tp = new TypeParser();
		e.getTypes().addAll(tp.parse(t));
		
		if (sheet.hasColumn(row, "Concept Domain"))
			throw new Exception("Column 'Concept Domain' has been retired in "
					+ path);

		e.setBindingName(sheet.getColumn(row, "Binding"));
		if (!"".equals(sheet.getColumn(row, "Binding Strength")))
			throw new Exception(
					"Element definition binding strength is not supported in "
							+ path);

		e.setShortDefn(sheet.getColumn(row, "Short Name"));
		e.setDefinition(sheet.getColumn(row, "Definition"));
		
		if (isRoot) {
			root.setDefinition(e.getDefinition());
		} 
		
		e.setRequirements(sheet.getColumn(row, "Requirements"));
		e.setComments(sheet.getColumn(row, "Comments"));
		e.setRimMapping(sheet.getColumn(row, "RIM Mapping"));
		e.setV2Mapping(sheet.getColumn(row, "v2 Mapping"));
		e.setTodo(sheet.getColumn(row, "To Do"));
		e.setExample(sheet.getColumn(row, "Example"));
		e.setCommitteeNotes(sheet.getColumn(row, "Committee Notes"));
		if (isProfile) {
			e.setValue(sheet.getColumn(row, "Value"));
			e.setAggregation(sheet.getColumn(row, "Aggregation"));
		}
	}

	private ExtensionDefn processExtension(ElementDefn extensions, Sheet sheet, int row,	Definitions definitions, String uri) throws Exception {
	  // first, we build the extension definition
	  org.hl7.fhir.definitions.model.ExtensionDefn ex = new org.hl7.fhir.definitions.model.ExtensionDefn();
	  ex.setCode(sheet.getColumn(row, "Code"));
    ex.setType(readContextType(sheet.getColumn(row, "Context Type"), row));
    ex.setContext(sheet.getColumn(row, "Context"));
	  ElementDefn exe = new ElementDefn();
	  exe.setName(sheet.getColumn(row, "Code"));
	  ex.setDefinition(exe);
	  
    if (!"".equals(sheet.getColumn(row, "Concept Domain")))
      throw new Exception(
          "Element definition Concept Domain is not supported");

    String[] card = sheet.getColumn(row, "Card.").split("\\.\\.");
    if (card.length != 2 || !Utilities.IsInteger(card[0])
        || (!"*".equals(card[1]) && !Utilities.IsInteger(card[1])))
      throw new Exception("Unable to parse Cardinality "
          + sheet.getColumn(row, "Card.") + " in " + getLocation(row));
    exe.setMinCardinality(Integer.parseInt(card[0]));
    exe.setMaxCardinality("*".equals(card[1]) ? null : Integer.parseInt(card[1]));
    exe.setAllowDAR(parseBoolean(sheet.getColumn(row, "DAR?"), row, true));
    exe.setCondition(sheet.getColumn(row, "Condition"));
    exe.setBindingName(sheet.getColumn(row, "Binding"));
    exe.setMustUnderstand(parseBoolean(sheet.getColumn(row, "Must Understand"), row, false));
    exe.setDefinition(sheet.getColumn(row, "Definition"));
    exe.setRequirements(sheet.getColumn(row, "Requirements"));
    exe.setComments(sheet.getColumn(row, "Comments"));
    exe.setRimMapping(sheet.getColumn(row, "RIM Mapping"));
    exe.setV2Mapping(sheet.getColumn(row, "v2 Mapping"));
    exe.setTodo(sheet.getColumn(row, "To Do"));
    exe.setExample(sheet.getColumn(row, "Example"));
    exe.setCommitteeNotes(sheet.getColumn(row, "Committee Notes"));
    exe.setShortDefn(sheet.getColumn(row, "Short Name"));
    String s = sheet.getColumn(row, "Must Understand").toLowerCase();
    if (s.equals("false") || s.equals("0") || s.equals("f")
        || s.equals("n") || s.equals("no"))
      exe.setMustUnderstand(false);
    else if (s.equals("true") || s.equals("1") || s.equals("t")
        || s.equals("y") || s.equals("yes"))
      exe.setMustUnderstand(true);
    else if (!"".equals(s))
      throw new Exception("unable to process Must Understand flag: " + s
          + " in " + getLocation(row));
    exe.getTypes().addAll(new TypeParser().parse(sheet.getColumn(row, "Type")));
	  
	  if (extensions != null) {
	    // if we got an extensions element, split this in.... 

	    ElementDefn e;
	    String path = sheet.getColumn(row, "Code");
	    e = makeExtension(extensions, path, row, definitions);
	    e.setMinCardinality(exe.getMinCardinality());
	    e.setMaxCardinality(exe.getMaxCardinality());
	    e.setAllowDAR(exe.isAllowDAR());
	    e.setCondition(exe.getCondition());
	    e.setBindingName(sheet.getColumn(row, "Binding"));
	    e.setMustUnderstand(exe.isMustUnderstand());
	    e.setDefinition(exe.getDefinition());
	    e.setRequirements(exe.getRequirements());
	    e.setComments(exe.getComments());
	    e.setRimMapping(exe.getRimMapping());
	    e.setV2Mapping(exe.getV2Mapping());
	    e.setTodo(exe.getTodo());
	    e.setExample(exe.getExample());
	    e.setCommitteeNotes(exe.getCommitteeNotes());
	    e.setMustUnderstand(exe.isMustUnderstand());



	    e.getTypes().clear();
	    e.getElementByName("definition").setValue(uri);
	    e.getElementByName("ref").ban();
	    if (e.isMustUnderstand())
	      e.getElementByName("mustUnderstand").setValue("true");
	    else
	      e.getElementByName("mustUnderstand").ban();
	    ElementDefn v = e.getElementByName("value[x]");
	    v.setShortDefn(sheet.getColumn(row, "Short Name"));
	    e.setShortDefn("");
	    v.getTypes().clear();
	    String t = sheet.getColumn(row, "Type");
	    if (t.equals(""))
	      v.ban();
	    else {
	      TypeParser tp = new TypeParser();
	      v.getTypes().addAll(tp.parse(t));
	    }
	    e.getElements().remove(e.getElementByName("extension"));
	  }
	  return ex;
	}

	private ExtensionDefn.ContextType readContextType(String value, int row) throws Exception {
    if (value.equals("Resource"))
      return ExtensionDefn.ContextType.Resource;
    if (value.equals("DataType") || value.equals("Data Type"))
      return ExtensionDefn.ContextType.DataType;
    if (value.equals("Elements"))
      return ExtensionDefn.ContextType.Elements;
    if (value.equals("Mapping"))
      return ExtensionDefn.ContextType.Mapping;
    if (value.equals("Extension"))
      return ExtensionDefn.ContextType.Extension;
	  
    throw new Exception("Unable to read context type '"+value+"' at "+getLocation(row));
  }

	 private ElementDefn findContext(ElementDefn root, String pathname, String source) throws Exception {
	    String[] path = pathname.split("\\.");
	    
	    if (!path[0].equals(root.getName()))
	      throw new Exception("Element Path '" + pathname + "' is not legal found at " + source);
	    ElementDefn res = root;
	    for (int i = 1; i < path.length; i++) {
	      String en = path[i];
	      if (en.length() == 0)
	        throw new Exception("Improper path " + pathname + " found at " + source);
	      if (en.charAt(en.length() - 1) == '*') 
	        throw new Exception("no-list wrapper found at " + source);

	      ElementDefn t = res.getElementByName(en);

	      if (t == null) {
          throw new Exception("Reference to undefined Element "+ pathname+ " found at " + source);
	      }
	      res = t;
	    }
	    return res;
	  }
  private ElementDefn makeFromPath(ElementDefn root, String pathname,
			int row, String profileName, boolean allowMake) throws Exception {
		String[] path = pathname.split("\\.");
		boolean n = false;
		if (!path[0].equals(root.getName()))
			throw new Exception("Element Path '" + pathname
					+ "' is not legal in this context in " + getLocation(row));
		ElementDefn res = root;
		for (int i = 1; i < path.length; i++) {
			String en = path[i];
			if (en.length() == 0)
				throw new Exception("Improper path " + pathname + " in "
						+ getLocation(row));
			if (en.charAt(en.length() - 1) == '*') {
				throw new Exception("no list wrapper found " + getLocation(row));
			}
			ElementDefn t = res.getElementByName(en);

			boolean isUnpickingElement = t != null && (i == path.length - 1)
					&& !t.getProfileName().equals("")
					&& !t.getProfileName().equals(profileName);

			if (t == null || isUnpickingElement) {
				if (n)
					throw new Exception("Internal Logic error " + pathname
							+ " @ " + getLocation(row));
				n = true;
				if (i < path.length - 1)
					throw new Exception("Encounter Element "+ pathname+ " before all the elements in the path are defined in "+ getLocation(row));
			  if (!allowMake)
          throw new Exception("Reference to undefined Element "+ pathname+ " in "+ getLocation(row));
			    
				t = new ElementDefn();
				t.setName(en);
				res.getElements().add(t);
			}
			res = t;
		}
		if (!n)
			throw new Exception("Duplicate Row name " + pathname + " @ "
					+ getLocation(row));
		return res;
	}

	private ElementDefn makeExtension(ElementDefn root, String pathname,
			int row, Definitions definitions) throws Exception {
		String[] path = pathname.split("\\.");

		ElementDefn res = root;
		for (int i = 0; i < path.length; i++) {
			String en = path[i];

			ElementDefn t = res.getElementByProfileName(en);
			if (t == null) {
				if (i < path.length - 1)
					throw new Exception(
							"Encounter Element "
									+ pathname
									+ " before all the elements in the path are defined in "
									+ getLocation(row));
				t = new ElementDefn(definitions.getInfrastructure().get(
						"Extensions"));
				t.setName("extension");
				t.setProfileName(en);
				t.getElementByName("code").setValue(en);
				res.getElements().add(t);
			}
			res = t;
		}
		return res;
	}

	protected boolean parseBoolean(String s, int row, boolean def)
			throws Exception {
		s = s.toLowerCase();
		if (s == null || s.equals(""))
			return def;
		else if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes")
				|| s.equalsIgnoreCase("true") || s.equalsIgnoreCase("1"))
			return true;
		else if (s.equals("false") || s.equals("0") || s.equals("f")
				|| s.equals("n") || s.equals("no"))
			return false;
		else
			throw new Exception("unable to process boolean value: " + s
					+ " in " + getLocation(row));
	}

	private String getLocation(int row) {
		return name + ", row " + Integer.toString(row + 2);
	}

	public List<EventDefn> getEvents() {
		return events;
	}

}
