package org.hl7.fhir.definitions.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.EventDefn;
import org.hl7.fhir.definitions.model.EventUsage;
import org.hl7.fhir.definitions.model.Example;
import org.hl7.fhir.definitions.model.Invariant;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.SearchParameter;
import org.hl7.fhir.definitions.model.SearchParameter.SearchType;
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

	public SpreadsheetParser(InputStream in, String name, Definitions definitions, String root) throws Exception {
		this.name = name;
		xls = new XLSXmlParser(in, name);    
		this.root = root;
		this.definitions = definitions;
		if (name.indexOf('-') > 0)
		  title = name.substring(0, name.indexOf('-'));
		else
	    title = name.substring(0, name.indexOf('.'));
		this.folder = root+title+File.separator;
	}


  public ElementDefn parseType() throws Exception {
    isProfile = false;
    ResourceDefn root = new ResourceDefn();
    Sheet sheet = xls.getSheets().get("Bindings");
    if (sheet != null)
      readBindings(sheet);
    sheet = xls.getSheets().get("Invariants");
    if (sheet != null)
      readInvariants(root, sheet);
    
    sheet = xls.getSheets().get("Data Elements");
    for (int row = 0; row < sheet.rows.size(); row++) {
      processLine(root, sheet, row, false);
    }
    
    return root;
  }

  public ResourceDefn parseResource() throws Exception {
    isProfile = false;
    ResourceDefn root = new ResourceDefn();
    Sheet sheet = xls.getSheets().get("Bindings");
    if (sheet != null)
      readBindings(sheet);
    sheet = xls.getSheets().get("Invariants");
    if (sheet != null)
      readInvariants(root, sheet);

    sheet = xls.getSheets().get("Data Elements");
    for (int row = 0; row < sheet.rows.size(); row++) {
      processLine(root, sheet, row, true);
    }
    readEvents(xls.getSheets().get("Events"));
    readExamples(root, xls.getSheets().get("Examples"));
    readSearchParams(root, xls.getSheets().get("Search"));
    return root;
  }

  private void readInvariants(ResourceDefn root2, Sheet sheet) throws Exception {
    for (int row = 0; row < sheet.rows.size(); row++) {
      Invariant inv = new Invariant();

      String s = sheet.getColumn(row, "Id");
      inv.setName(sheet.getColumn(row, "Name"));
      inv.setContext(sheet.getColumn(row, "Context"));
      inv.setEnglish(sheet.getColumn(row, "English"));
      inv.setXpath(sheet.getColumn(row, "XPath"));
      inv.setOcl(sheet.getColumn(row, "OCL"));
      if (s == null || s.equals("") || root2.getInvariants().containsKey(s))
        throw new Exception("duplicate or missing invariant id "+getLocation(row));
      root2.getInvariants().put(s, inv);
    }
  }

  private void readSearchParams(ResourceDefn root2, Sheet sheet) throws Exception {
    root2.getSearchParams().add(new SearchParameter("n", "Starting offset of the first record to return in the search set", SearchType.integer));
    root2.getSearchParams().add(new SearchParameter("count", "Number of return records requested. The server is not bound to conform", SearchType.integer));
    root2.getSearchParams().add(new SearchParameter("id", "An identifier associated with the resource", SearchType.token));
    
    if (sheet != null)
      for (int row = 0; row < sheet.rows.size(); row++) {

        if (!sheet.hasColumn(row, "Name"))
          throw new Exception("Search Param has no name "+getLocation(row));
        if (!sheet.hasColumn(row, "Description"))
          throw new Exception("Search Param has no dascription "+getLocation(row));
        if (!sheet.hasColumn(row, "Type"))
          throw new Exception("Search Param has no type "+getLocation(row));
        String n = sheet.getColumn(row, "Name");
        if (n.endsWith("-before") || n.endsWith("-before"))
          throw new Exception("Search Param includes relative time "+getLocation(row));
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
    throw new Exception("Unknown Search Type '"+s+"': "+getLocation(row));
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
      
      if (cd.getBinding() == BindingSpecification.Binding.CodeList) {
        Sheet codes = xls.getSheets().get(cd.getReference().substring(1));
        if (codes == null)
          throw new Exception("code source sheet not found for "+cd.getName()+": "+cd.getReference());
        parseCodes(cd.getCodes(), codes);
      }     
      if (definitions.getBindingByName(cd.getName()) != null) {
        throw new Exception("Definition of binding '"+cd.getName()+"' in "+name+" clashes with previous definition in "+definitions.getBindingByName(cd.getName()).getSource());
      }
      definitions.getBindings().put(cd.getName(), cd);
    }
    
  }


  private void parseCodes(List<DefinedCode> codes, Sheet sheet) throws Exception {
    for (int row = 0; row < sheet.rows.size(); row++) {
      DefinedCode c = new DefinedCode();
      c.setCode(sheet.getColumn(row, "Code"));
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

		for (String n : p.getMetadata().get("resource")) {
		  ResourceDefn e = new ResourceDefn();
			sheet = xls.getSheets().get(n);
			for (int row = 0; row < sheet.rows.size(); row++) {
				processLine(e, sheet, row, true);
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


  private void readExamples(ResourceDefn defn, Sheet sheet) throws Exception {
    if (sheet != null) {
      for (int row = 0; row < sheet.rows.size(); row++) {
        String name = sheet.getColumn(row, "Name");
        if (name != null && !name.equals("")) {
          String desc = sheet.getColumn(row, "Description");
          if (desc == null || desc.equals(""))
            throw new Exception("Example "+name+" has no description parsing "+this.name);
          File file = new File(folder+sheet.getColumn(row, "Filename"));
          if (!file.exists())
            throw new Exception("Example "+name+" file '"+file.getAbsolutePath()+"' not found parsing "+this.name);
          defn.getExamples().add(new Example(name, desc, file, sheet.getColumn(row, "Type"), parseBoolean(sheet.getColumn(row, "In Book"), row, false)));
        }
      }         
    }
    if (defn.getExamples().size() == 0) {
      File file = new File(folder+title+"-example.xml");
      if (!file.exists())
        throw new Exception("Example (file '"+file.getAbsolutePath()+"') not found parsing "+this.name);
      defn.getExamples().add(new Example("General", "Example of "+title, file, null, true));
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

	private void processLine(ResourceDefn root, Sheet sheet, int row, boolean allowDAR) throws Exception {
		ElementDefn e;
		String path = sheet.getColumn(row, "Element");
		if (path.contains("#"))
		  throw new Exception("Old path style @ "+getLocation(row));
		
		String profileName = isProfile  ? sheet.getColumn(row, "Profile Name") : "";
		if (!path.contains(".")) {
			e = root;
			if (root.hasName())
				throw new Exception("Definitions in "+getLocation(row)+" contain two roots: "+path+" in "+root.getName());
			e.setName(path);
		} else {
			e = makeFromPath(root, path, row, profileName);
		}

		String c = sheet.getColumn(row, "Card.");
		if (c == null || c.equals("")) {
		  if (e != root)
		    throw new Exception("Missing cardinality");
	    e.setMinCardinality(1);
	    e.setMaxCardinality(1);
		} else { 
		  String[] card = c.split("\\.\\.");
		  if (card.length != 2 || !Utilities.IsInteger(card[0]) || (!"*".equals(card[1]) && !Utilities.IsInteger(card[1])))
		    throw new Exception("Unable to parse Cardinality '"+c+"' "+c+" in "+getLocation(row)+" on "+path);
	    e.setMinCardinality(Integer.parseInt(card[0]));
	    e.setMaxCardinality("*".equals(card[1]) ? null : Integer.parseInt(card[1]));
		}
		e.setProfileName(profileName);
		
    e.setAllowDAR(allowDAR && parseBoolean(sheet.getColumn(row, "DAR?"), row, true));
		e.setMustUnderstand(parseBoolean(sheet.getColumn(row, "Must Understand"), row, false));
    e.setMustSupport(parseBoolean(sheet.getColumn(row, "Must Support"), row, false));
    String s = sheet.getColumn(row, "Condition");
    if (s != null && !s.equals(""))
      throw new Exception("Found Condition in spreadsheet "+getLocation(row));
    s = sheet.getColumn(row, "Inv.");
    if (s != null && !s.equals("")) {
      Invariant inv = root.getInvariants().get(s);
      if (inv == null)
        throw new Exception("unable to find Invariant '"+s+"' "+getLocation(row));
      e.setInvariant(inv);
    }
    

		String t = sheet.getColumn(row, "Type");
		TypeParser tp = new TypeParser();
		e.getTypes().addAll(tp.parse(t));
		if (sheet.hasColumn(row, "Concept Domain"))
      throw new Exception("Column 'Concept Domain' has been retired in "+path);
		
		e.setBindingName(sheet.getColumn(row, "Binding"));
		if (!"".equals(sheet.getColumn(row, "Binding Strength")))
			throw new Exception("Element definition binding strength is not supported in "+path);

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
    e.setAllowDAR(parseBoolean(sheet.getColumn(row, "DAR?"), row, true));
		e.setCondition(sheet.getColumn(row, "Condition"));
		e.setBindingName(sheet.getColumn(row, "Concept Domain"));
		if (!"".equals(sheet.getColumn(row, "Binding Strength")))
			throw new Exception("Element definition binding strength is not supported");
		e.setMustUnderstand(parseBoolean(sheet.getColumn(row, "Must Understand"), row, false));
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
			if (en.length() == 0)
				throw new Exception("Improper path "+pathname+" in "+getLocation(row));
			if (en.charAt(en.length() - 1) == '*') {
				throw new Exception("no list wrapper found "+getLocation(row));
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


	protected boolean parseBoolean(String s, int row, boolean def) throws Exception {
	  s = s.toLowerCase();
		if (s == null || s.equals(""))
			return def;
		else if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true") || s.equalsIgnoreCase("1"))
			return true;
		else if (s.equals("false") || s.equals("0") || s.equals("f") || s.equals("n") || s.equals("no"))
		  return false;
		else
	    throw new Exception("unable to process boolean value: "+s+" in "+getLocation(row));
	}  

	private String getLocation(int row) {
		return name+", row "+Integer.toString(row+2);
	}

	public List<EventDefn> getEvents() {
		return events;
	}





}
