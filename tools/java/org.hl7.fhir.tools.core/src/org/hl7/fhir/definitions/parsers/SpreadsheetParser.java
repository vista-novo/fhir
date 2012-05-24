package org.hl7.fhir.definitions.parsers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.EventDefn;
import org.hl7.fhir.definitions.model.EventUsage;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.instance.model.Profile.BindingType;
import org.hl7.fhir.tools.publisher.FolderManager;
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

	public SpreadsheetParser(InputStream in, String name, Definitions definitions, String root) throws Exception {
		this.name = name;
		xls = new XLSXmlParser(in, name);    
		this.root = root;
		this.definitions = definitions;
	}


	public ElementDefn parse() throws Exception {
		isProfile = false;
		ElementDefn root = new ElementDefn();
		Sheet sheet = xls.getSheets().get("Bindings");
		if (sheet != null)
		  readBindings(sheet);
		sheet = xls.getSheets().get("Data Elements");
		for (int row = 0; row < sheet.rows.size(); row++) {
			processLine(root, sheet, row);
		}
		readEvents(xls.getSheets().get("Events"));
		return root;
	}

	private void readBindings(Sheet sheet) throws Exception {
    for (int row = 0; row < sheet.rows.size(); row++) {
      BindingSpecification cd = new BindingSpecification();

      cd.setName(sheet.getColumn(row, "Binding Name"));
      cd.setDefinition(sheet.getColumn(row, "Definition"));
      cd.setBinding(BindingsParser.readBinding(sheet.getColumn(row, "Binding")));
      cd.setBindingStrength(BindingsParser.readBindingStrength(sheet.getColumn(row, "Binding Strength")));
      cd.setReference(sheet.getColumn(row, "Reference"));
      cd.setDescription(sheet.getColumn(row, "Description"));
      cd.setId(new BindingNameRegistry(root).idForName(cd.getName()));
      cd.setSource(name);
     
      if (definitions.getBindingByName(cd.getName()) != null) {
        throw new Exception("Definition of binding '"+cd.getName()+"' in "+name+" clashes with previous definition in "+definitions.getBindingByName(cd.getName()).getSource());
      }
      definitions.getBindings().put(cd.getName(), cd);
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

		for (String n : p.getMetadata().get("resource")) {
			ElementDefn e = new ElementDefn();
			sheet = xls.getSheets().get(n);
			for (int row = 0; row < sheet.rows.size(); row++) {
				processLine(e, sheet, row);
			}
			sheet = xls.getSheets().get(n+"-Extensions");
			if (sheet != null) {
				for (int row = 0; row < sheet.rows.size(); row++) {
					processExtension(e.getElementByName("extensions"), sheet, row, definitions, p.metadata("extension.uri"));
				}
			}
			p.getResources().add(e);
		}
		return p;
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
					for (String s : sheet.getColumn(row, "Request Resources").split(",")) {
						s = s.trim();
						if (s != "")
							u.getRequestResources().add(s);
					}
					for (String s : sheet.getColumn(row, "Request Aggregations").split("\n")) {
						s = s.trim();
						if (s != "")
							u.getRequestAggregations().add(s);
					}
					for (String s : sheet.getColumn(row, "Response Resources").split(",")) {
						s = s.trim();
						if (s != "")
							u.getResponseResources().add(s);
					}
					for (String s : sheet.getColumn(row, "Response Aggregations").split("\n")) {
						s = s.trim();
						if (s != "")
							u.getResponseAggregations().add(s);
					}
					for (String s : sheet.getColumn(row, "Follow Ups").split(",")) {
						s = s.trim();
						if (s != "")
							e.getFollowUps().add(s);
					}



				}
			}      
		}
	}

	private void processLine(ElementDefn root, Sheet sheet, int row) throws Exception {
		ElementDefn e;
		String path = sheet.getColumn(row, "Element");
		String profileName = isProfile  ? sheet.getColumn(row, "Profile Name") : "";
		if (!path.contains(".")) {
			e = root;
			if (root.hasName())
				throw new Exception("Definitions in "+getLocation(row)+" contain two roots: "+path+" in "+root.getName());
			e.setName(path);
		} else {
			e = makeFromPath(root, path, row, profileName);
		}

		String[] card = sheet.getColumn(row, "Card.").split("\\.\\.");
		if (card.length != 2 || !Utilities.IsInteger(card[0]) || (!"*".equals(card[1]) && !Utilities.IsInteger(card[1])))
			throw new Exception("Unable to parse Cardinality '"+sheet.getColumn(row, "Card.")+"' "+sheet.getColumn(row, "Card.")+" in "+getLocation(row)+" on "+path);
		e.setProfileName(profileName);
		e.setMinCardinality(Integer.parseInt(card[0]));
		e.setMaxCardinality("*".equals(card[1]) ? null : Integer.parseInt(card[1]));
		e.setConformance(pickConformance(sheet.getColumn(row, "Conf."), row));
		String t = sheet.getColumn(row, "Type");
		TypeParser tp = new TypeParser();
		e.getTypes().addAll(tp.parse(t));
		e.setCondition(sheet.getColumn(row, "Condition"));
		e.setBindingName(sheet.getColumn(row, "Concept Domain"));
		if (!"".equals(sheet.getColumn(row, "Binding Strength")))
			throw new Exception("Element definition binding strength is not supported in "+path);

		// TODO: Next line seems to be duplicated under this group of statements
		e.setMustUnderstand(parseBoolean(sheet.getColumn(row, "Must Understand")));
		e.setShortDefn(sheet.getColumn(row, "Short Name"));
		e.setDefinition(sheet.getColumn(row, "Definition"));
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
		String s = sheet.getColumn(row, "Must Understand").toLowerCase();
		if (s.equals("false") || s.equals("0") || s.equals("f") || s.equals("n") || s.equals("no"))
			e.setMustUnderstand(false);
		else if (s.equals("true") || s.equals("1") || s.equals("t") || s.equals("y") || s.equals("yes"))
			e.setMustUnderstand(true);
		else if (!"".equals(s))
			throw new Exception("unable to process Must Understand flag: "+s+" in "+getLocation(row));

	}

	private void processExtension(ElementDefn extensions, Sheet sheet, int row, Definitions definitions, String uri) throws Exception {
		ElementDefn e;
		String path = sheet.getColumn(row, "Code");
		e = makeExtension(extensions, path, row, definitions);

		String[] card = sheet.getColumn(row, "Card.").split("\\.\\.");
		if (card.length != 2 || !Utilities.IsInteger(card[0]) || (!"*".equals(card[1]) && !Utilities.IsInteger(card[1])))
			throw new Exception("Unable to parse Cardinality "+sheet.getColumn(row, "Card.")+" in "+getLocation(row));
		e.setTarget(sheet.getColumn(row, "Target"));
		e.setMinCardinality(Integer.parseInt(card[0]));
		e.setMaxCardinality("*".equals(card[1]) ? null : Integer.parseInt(card[1]));
		e.setConformance(pickConformance(sheet.getColumn(row, "Conf."), row));
		e.setCondition(sheet.getColumn(row, "Condition"));
		e.setBindingName(sheet.getColumn(row, "Concept Domain"));
		if (!"".equals(sheet.getColumn(row, "Binding Strength")))
			throw new Exception("Element definition binding strength is not supported");
		e.setMustUnderstand(parseBoolean(sheet.getColumn(row, "Must Understand")));
		e.setDefinition(sheet.getColumn(row, "Definition"));
		e.setRequirements(sheet.getColumn(row, "Requirements"));
		e.setComments(sheet.getColumn(row, "Comments"));
		e.setRimMapping(sheet.getColumn(row, "RIM Mapping"));
		e.setV2Mapping(sheet.getColumn(row, "v2 Mapping"));
		e.setTodo(sheet.getColumn(row, "To Do"));
		e.setExample(sheet.getColumn(row, "Example"));
		e.setCommitteeNotes(sheet.getColumn(row, "Committee Notes"));
		String s = sheet.getColumn(row, "Must Understand").toLowerCase();
		if (s.equals("false") || s.equals("0") || s.equals("f") || s.equals("n") || s.equals("no"))
			e.setMustUnderstand(false);
		else if (s.equals("true") || s.equals("1") || s.equals("t") || s.equals("y") || s.equals("yes"))
			e.setMustUnderstand(true);
		else if (!"".equals(s))
			throw new Exception("unable to process Must Understand flag: "+s+" in "+getLocation(row));

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


	private ElementDefn makeFromPath(ElementDefn root, String pathname, int row, String profileName) throws Exception {
		String[] path = pathname.split("\\.");
		boolean n = false;
		if (!path[0].equals(root.getName()))
			throw new Exception("Element Path '"+pathname+"' is not legal in this context in "+getLocation(row));
		ElementDefn res = root;
		for (int i = 1; i < path.length; i++)
		{
			String en = path[i];
			boolean noListWrapper = false;
			if (en.length() == 0)
				throw new Exception("Improper path "+pathname+" in "+getLocation(row));
			if (en.charAt(en.length() - 1) == '*') {
				noListWrapper = true;
				en = en.substring(0, en.length()-1);
			}
			ElementDefn t = res.getElementByName(en);
			
			boolean isUnpickingElement =
					t != null &&
					(i == path.length - 1) && 
					!t.getProfileName().equals("") && 
					!t.getProfileName().equals(profileName);
			
			if (t == null || isUnpickingElement ) {
				if (n) 
					throw new Exception("Internal Logic error "+pathname+" @ " +getLocation(row));
				n = true;
				if (i < path.length - 1) 
					throw new Exception("Encounter Element "+pathname+" before all the elements in the path are defined in "+getLocation(row));
				t = new ElementDefn();
				t.setName(en);
				t.setNoListWrapper(noListWrapper);
				res.getElements().add(t);        
			}
			res = t; 
		}
		if (!n) 
			throw new Exception("Duplicate Row name "+pathname+" @ " +getLocation(row));
		return res;
	}

	private ElementDefn makeExtension(ElementDefn root, String pathname, int row, Definitions definitions) throws Exception {
		String[] path = pathname.split("\\.");

		ElementDefn res = root;
		for (int i = 0; i < path.length; i++)
		{
			String en = path[i];

			ElementDefn t = res.getElementByProfileName(en);
			if (t == null) {
				if (i < path.length - 1) 
					throw new Exception("Encounter Element "+pathname+" before all the elements in the path are defined in "+getLocation(row));
				t = new ElementDefn(definitions.getInfrastructure().get("Extensions"));
				t.setName("extension");
				t.setProfileName(en);
				t.getElementByName("code").setValue(en);
				res.getElements().add(t);
			}
			res = t; 
		}
		return res;
	}


	private ElementDefn.Conformance pickConformance(String s, int row) throws Exception {
		s = s.toLowerCase();
		if (s == null || "".equals(s))
			return ElementDefn.Conformance.Unstated;
		if (s.equals("opt"))
			return ElementDefn.Conformance.Optional;
		if (s.equals("mand"))
			return ElementDefn.Conformance.Mandatory;
		if (s.equals("cond"))
			return ElementDefn.Conformance.Conditional;
		if (s.equals("optional"))
			return ElementDefn.Conformance.Optional;
		if (s.equals("mandatory"))
			return ElementDefn.Conformance.Mandatory;
		if (s.equals("conditional"))
			return ElementDefn.Conformance.Conditional;
		if (s.equals("prohibited"))
			return ElementDefn.Conformance.Prohibited;
		throw new Exception("Unknown Conformance flag: "+s+" in "+getLocation(row));
	}


	protected boolean parseBoolean(String column) {
		if (column == null)
			return false;
		else if (column.equalsIgnoreCase("y") || column.equalsIgnoreCase("yes") || column.equalsIgnoreCase("true") || column.equalsIgnoreCase("1"))
			return true;
		else
			return false;
	}  

	private String getLocation(int row) {
		return name+", row "+Integer.toString(row);
	}

	public List<EventDefn> getEvents() {
		return events;
	}





}
