package org.hl7.fhir.definitions.parsers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.EventDefn;
import org.hl7.fhir.definitions.model.EventUsage;
import org.hl7.fhir.definitions.parsers.XLSXmlParser.Sheet;
import org.hl7.fhir.utilities.Utilities;


public class SpreadsheetParser {

  private String name;
  private XLSXmlParser xls;
  private List<EventDefn> events = new ArrayList<EventDefn>();
  
  public SpreadsheetParser(InputStream in, String name) throws Exception {
    this.name = name;
    xls = new XLSXmlParser(in, name);    
  }

  public ElementDefn parse() throws Exception {
    ElementDefn root = new ElementDefn();
    Sheet sheet = xls.getSheets().get("Data Elements");
    for (int row = 0; row < sheet.rows.size(); row++) {
      processLine(root, sheet, row);
    }
    readEvents(xls.getSheets().get("Events"));
    return root;
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
    if (!path.contains(".")) {
      e = root;
      if (root.hasName())
        throw new Exception("Definitions in "+getLocation(row)+" contain two roots: "+path+" in "+root.getName());
      e.setName(path);
    } else {
      e = makeFromPath(root, path, row);
    }
    
    String[] card = sheet.getColumn(row, "Card.").split("\\.\\.");
    if (card.length != 2 || !Utilities.IsInteger(card[0]) || (!"*".equals(card[1]) && !Utilities.IsInteger(card[1])))
      throw new Exception("Unable to parse Cardinality "+sheet.getColumn(row, "Card.")+" in "+getLocation(row));
    e.setMinCardinality(Integer.parseInt(card[0]));
    e.setMaxCardinality("*".equals(card[1]) ? null : Integer.parseInt(card[1]));
    e.setConformance(pickConformance(sheet.getColumn(row, "Conf."), row));
    String t = sheet.getColumn(row, "Type");
    TypeParser tp = new TypeParser();
    e.getTypes().addAll(tp.parse(t));
    e.setCondition(sheet.getColumn(row, "Condition"));
    e.setConceptDomain(sheet.getColumn(row, "Concept Domain"));
    e.setBindingStrength(pickBindingStrength(sheet.getColumn(row, "Binding Strength"), row));
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
    String s = sheet.getColumn(row, "Must Understand").toLowerCase();
    if (s.equals("false") || s.equals("0") || s.equals("f") || s.equals("n"))
      e.setMustUnderstand(false);
    else if (s.equals("true") || s.equals("1") || s.equals("t") || s.equals("y"))
      e.setMustUnderstand(true);
    else if (!"".equals(s))
      throw new Exception("unable to process Must Understand flag: "+s+" in "+getLocation(row));
    
  }


  private ElementDefn.BindingStrength pickBindingStrength(String s, int row) throws Exception {
    s = s.toLowerCase();
    if (s == null || "".equals(s))
      return ElementDefn.BindingStrength.Unspecified;
    if (s.equals("closed"))
      return ElementDefn.BindingStrength.Closed;
    if (s.equals("extensible"))
      return ElementDefn.BindingStrength.Extensible;
    throw new Exception("Unknown Binding Strength: "+s+" in "+getLocation(row));
  }

  private ElementDefn makeFromPath(ElementDefn root, String pathname, int row) throws Exception {
    String[] path = pathname.split("\\.");
    if (!path[0].equals(root.getName()))
      throw new Exception("Element Path '"+pathname+"' is not legal in this context in "+getLocation(row));
    ElementDefn res = root;
    for (int i = 1; i < path.length; i++)
    {
      String en = path[i];
      boolean nolist = false;
      if (en.length() == 0)
        throw new Exception("Improper path "+pathname+" in "+getLocation(row));
      if (en.charAt(en.length() - 1) == '*') {
        nolist = true;
        en = en.substring(0, en.length()-1);
      }
      ElementDefn t = res.getElementByName(en);
      if (t == null) {
        if (i < path.length - 1) 
          throw new Exception("Encounter Element "+pathname+" before all the elements in the path are defined in "+getLocation(row));
        t = new ElementDefn();
        t.setName(en);
        t.setNolist(nolist);
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
