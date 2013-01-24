package org.hl7.fhir.tools.publisher;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class DiagramGenerator {

  private PageProcessor page;
  
  
  public DiagramGenerator(PageProcessor page) {
    super();
    this.page = page;
  }

  public String generateFromSource(String title, String filename) throws Exception {
    String src = TextFile.fileToString(filename);
    if (src.startsWith("[diagram]")) {
      IniFile ini = new IniFile(filename);
      String[] classes = ini.getStringProperty("diagram", "classes").split(",");
      StringBuilder s = new StringBuilder();
      StringBuilder s2 = new StringBuilder();
      s.append("@startuml\r\n");
      s.append("title "+ini.getStringProperty("diagram", "title")+"\r\n");
      s.append("skinparam nodesep 10\r\n");
      s.append("skinparam ranksep 10\r\n");
      s.append("skinparam classBackgroundColor Aliceblue\r\n\r\n");
      s.append("skinparam classBorderColor Gray\r\n\r\n");
      s.append("skinparam classArrowColor Navy\r\n\r\n");

      List<org.hl7.fhir.definitions.model.ElementDefn> queue = new ArrayList<org.hl7.fhir.definitions.model.ElementDefn>();
      List<String> elementClasses = new ArrayList<String>();
      Map<org.hl7.fhir.definitions.model.ElementDefn, String> names = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>();
      Map<org.hl7.fhir.definitions.model.ElementDefn, String> defns = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>();
      s.append("\r\n"+s2);
      for (String c : classes) {
        queue.add(page.getDefinitions().getElementDefn(c));
        names.put(page.getDefinitions().getElementDefn(c), c);
        if (c.startsWith("Resourc"))
          defns.put(page.getDefinitions().getElementDefn(c), "resources-definitions.htm#"+c);
        else if (c.equals("Narrative")) 
            defns.put(page.getDefinitions().getElementDefn(c), "formats-definitions.htm#"+c);
        else if (c.equals("Extension")) 
            defns.put(page.getDefinitions().getElementDefn(c), "extensibility-definitions.htm#"+c);
        else
          defns.put(page.getDefinitions().getElementDefn(c), "datatypes-definitions.htm#"+c);
        s.append("Element <|-"+ini.getStringProperty("directions", c)+"- "+c+" << (D, #FFA500) >> \r\n"+s2);
      }
      while (queue.size() > 0) {
        org.hl7.fhir.definitions.model.ElementDefn r = queue.get(0);
        queue.remove(0);
        generateDiagramClass(r, queue, names, defns, s, s2, elementClasses, null, false, true);
      }  
      s.append("\r\n"+s2);
      s.append("hide methods\r\n");
      for (String en : elementClasses) {
        s.append("hide "+en+" circle\r\n");
      }
      s.append("hide Element circle\r\n");
      s.append("@enduml\r\n");
      return produceImageFromSource(title, s.toString(), page.getFolders().dstDir + title + ".png");
    } else {
      return produceImageFromSource(title, src, page.getFolders().dstDir + title + ".png");
    }
  }
  
  private String produceImageFromSource(String title, String src, String dest) throws Exception {
    // this is a time consuming step. We cache the last outcome
    String lastSrc = null;
    title = title.toLowerCase();
    if (new File(page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+title+".png").exists())
      lastSrc = TextFile.fileToString(page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+title+".plantuml-source");
    if (!src.equals(lastSrc)) {
      TextFile.stringToFile(src, page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+title+".plantuml-source");
      SourceStringReader rdr = new SourceStringReader(src);
      FileOutputStream png = new FileOutputStream(page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+title+".png");
      String map = rdr.generateImage(png);     
      TextFile.stringToFile(map, page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+title+".map");
    }
    Utilities.copyFile(new File(page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+title+".png"), new File(dest));
    String s = TextFile.fileToString(page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+title+".map");
    return s.substring(s.indexOf(")")+1).replace("name=\"plantuml_map\"", "name=\""+title+"\"");
  }

  public String generate(ResourceDefn resource, String n) throws Exception {
    StringBuilder s = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
    s.append("@startuml\r\n");
    s.append("title "+resource.getName()+"\r\n");
    s.append("skinparam nodesep 10\r\n");
    s.append("skinparam ranksep 10\r\n");
    s.append("skinparam classBackgroundColor Aliceblue\r\n\r\n");
    s.append("skinparam classBorderColor Gray\r\n\r\n");
    s.append("skinparam classArrowColor Navy\r\n\r\n");

    String defn = resource.getName().toLowerCase()+"-definitions.htm#"+resource.getName();
    
    List<org.hl7.fhir.definitions.model.ElementDefn> queue = new ArrayList<org.hl7.fhir.definitions.model.ElementDefn>();
    List<String> elementClasses = new ArrayList<String>();
    Map<org.hl7.fhir.definitions.model.ElementDefn, String> names = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
    Map<org.hl7.fhir.definitions.model.ElementDefn, String> defns = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
    queue.add(resource.getRoot());
    names.put(resource.getRoot(), resource.getName());
    defns.put(resource.getRoot(), defn);
    while (queue.size() > 0) {
      org.hl7.fhir.definitions.model.ElementDefn r = queue.get(0);
      queue.remove(0);
      generateDiagramClass(r, queue, names, defns, s, s2, elementClasses, resource.getRoot(), r == resource.getRoot(), true);
    }  
    s.append("\r\n"+s2);
    s.append("hide methods\r\n");
    for (String en : elementClasses) {
      s.append("hide "+en+" circle\r\n");
    }
    s.append("@enduml\r\n");
    return produceImageFromSource(resource.getName(), s.toString(), page.getFolders().dstDir + n + ".png");
    
  }
  
//  private void generateDiagram(org.hl7.fhir.definitions.model.ElementDefn element) throws Exception {
//    StringBuilder s = new StringBuilder();
//    StringBuilder s2 = new StringBuilder();
//    s.append("@startuml\r\n");
//    s.append("title "+element.getName()+"\r\n");
//    s.append("skinparam nodesep 10\r\n");
//    s.append("skinparam ranksep 10\r\n");
//    s.append("skinparam classBackgroundColor Aliceblue\r\n\r\n");
//    s.append("skinparam classBorderColor Gray\r\n\r\n");
//    s.append("skinparam classArrowColor Navy\r\n\r\n");
//
//    List<org.hl7.fhir.definitions.model.ElementDefn> queue = new ArrayList<org.hl7.fhir.definitions.model.ElementDefn>();
//    List<String> elementClasses = new ArrayList<String>();
//    Map<org.hl7.fhir.definitions.model.ElementDefn, String> names = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
//    Map<org.hl7.fhir.definitions.model.ElementDefn, String> defns = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
//    queue.add(element);
//    names.put(element, element.getName());
//    defns.put(element, "");
//    while (queue.size() > 0) {
//      org.hl7.fhir.definitions.model.ElementDefn r = queue.get(0);
//      queue.remove(0);
//      generateDiagramClass(r, queue, names, defns, s, s2, elementClasses, r == element, false);
//    }  
//    s.append("\r\n"+s2);
//    s.append("hide methods\r\n");
//    for (String en : elementClasses) {
//      s.append("hide "+en+" circle\r\n");
//    }
//    s.append("@enduml\r\n");
//    TextFile.stringToFile(s.toString(), page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+element.getName().toLowerCase()+".plantuml-source");
//    SourceStringReader rdr = new SourceStringReader(s.toString());
//    FileOutputStream png = new FileOutputStream(page.getFolders().dstDir + element.getName().toLowerCase() + ".png");
//    rdr.generateImage(png);
//    png = new FileOutputStream(page.getFolders().dstDir + element.getName().toLowerCase() + ".cmapx");
//    rdr.generateImage(png, new FileFormatOption(FileFormat.HTML));
////    FileOutputStream svg = new FileOutputStream(page.getFolders().dstDir + n + ".svg");
////    rdr.generateImage(svg, new FileFormatOption(FileFormat.SVG));
////    FileOutputStream xmi = new FileOutputStream(page.getFolders().dstDir + n + ".xmi");
////    rdr.generateImage(xmi, new FileFormatOption(FileFormat.XMI_STANDARD));
//  }
//  
  
  private void generateDiagramClass(org.hl7.fhir.definitions.model.ElementDefn r, List<org.hl7.fhir.definitions.model.ElementDefn> queue, 
      Map<org.hl7.fhir.definitions.model.ElementDefn, String> names, Map<org.hl7.fhir.definitions.model.ElementDefn, String> defns, 
      StringBuilder s, StringBuilder s2, List<String> elementClasses, ElementDefn root, boolean entry, boolean resource) throws Exception {
    String rn; 
    if (names.keySet().contains(r))
      rn = names.get(r);
    else 
      rn = Utilities.capitalize(r.getName());
    String dn;
    if (defns.keySet().contains(r))
      dn = defns.get(r);
    else 
      dn = "??";

    for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
      if (e.getTypes().size() == 0 || e.typeCode().startsWith("@") || page.getDefinitions().dataTypeIsSharedInfo(e.typeCode())) {
        String n;
        org.hl7.fhir.definitions.model.ElementDefn t = null;
        if (names.keySet().contains(e))
          n = names.get(e);
        else if (page.getDefinitions().dataTypeIsSharedInfo(e.typeCode())) {
          n = e.typeCode();
          t = page.getDefinitions().getElementDefn(n);
          names.put(t, n);
          queue.add(t);
        } else if (e.typeCode().startsWith("@")) {
          ElementDefn src = root.getElementForPath(e.typeCode().substring(1));
          n = names.get(src);          
        } else {
          n = Utilities.capitalize(e.getName());
          names.put(e, n);
          queue.add(e);
          defns.put(e, dn+"."+e.getName());
        }
        String ta = t != null ? "(D, #FFD700)" : "(E, Aliceblue)";
        if (page.getDefinitions().hasType(rn))
          s.append(rn+" << (D, #FFA500) >> *-"+e.getDir()+"- \""+e.describeCardinality()+"\" "+n+"  << "+ta+" >> : "+e.getName()+"\r\n");
        else if (!entry)
          s.append(rn+" << (E, Aliceblue) >>  *-"+e.getDir()+"- \""+e.describeCardinality()+"\" "+n+"  << "+ta+" >> : "+e.getName()+"\r\n");
        else if (resource)
          s.append(rn+" << (R, #FF7700) >> *-"+e.getDir()+"- \""+e.describeCardinality()+"\" "+n+"  << "+ta+" >> : "+e.getName()+"\r\n");
        else
          s.append(rn+" << (D, #FFA500) >> *-"+e.getDir()+"- \""+e.describeCardinality()+"\" "+n+"  << "+ta+" >> : "+e.getName()+"\r\n");
      }
    }
    s2.append("url of "+rn+" is [["+dn+"]]\r\n");
    if (entry)
      s2.append("class "+rn+" << (R, #FF7700) >> {\r\n");
    else if (page.getDefinitions().dataTypeIsSharedInfo(r.typeCode()) || page.getDefinitions().hasType(rn)) {
      s2.append("class "+rn+" << (D, #FFD700) >> {\r\n");
    } else {
      s2.append("class "+rn+" << (E, Aliceblue ) >> {\r\n");
      elementClasses.add(rn);
    }
    for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
      if (e.getTypes().size() > 0 && !e.typeCode().startsWith("@") && !page.getDefinitions().dataTypeIsSharedInfo(e.typeCode())) {
        s2.append(" "+e.getName()+" : "+e.typeCode()+" "+e.describeCardinality()+" [["+(dn+"."+e.getName()).replace("[", "_").replace("]", "_")+"]]\r\n");
      }
    }
    s2.append("  --\r\n}\r\n\r\n");
  }


/*
 * Candidate diagram source for Alex Henket. Retired for now
  private void generateDiagramSource(ResourceDefn resource) throws Exception {
    XMLWriter w = new XMLWriter(new FileOutputStream(page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+resource.getName().toLowerCase()+".diagram-source"), "UTF-8");
    w.setPretty(true);
    w.start();
    w.attribute("name", resource.getName());
    w.open("diagram");
    List<org.hl7.fhir.definitions.model.ElementDefn> queue = new ArrayList<org.hl7.fhir.definitions.model.ElementDefn>();
    Map<org.hl7.fhir.definitions.model.ElementDefn, String> names = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
    queue.add(resource.getRoot());
    names.put(resource.getRoot(), resource.getName());
    while (queue.size() > 0) {
      org.hl7.fhir.definitions.model.ElementDefn r = queue.get(0);
      queue.remove(0);
      generateDiagramClass(r, queue, names, w, r == resource.getRoot());
    }
    w.close("diagram");
    w.close();
  }

  private void generateDiagramClass(org.hl7.fhir.definitions.model.ElementDefn r, List<org.hl7.fhir.definitions.model.ElementDefn> queue, Map<org.hl7.fhir.definitions.model.ElementDefn, String> names, XMLWriter w, boolean entry) throws Exception {
    w.attribute("name", names.get(r));
    if (entry) 
      w.attribute("entry", "yes");
    w.open("class");
    for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
      if (e.getTypes().size() > 0) {
        w.attribute("name", e.getName());
        w.attribute("type", e.typeCode());
        w.attribute("cardinality", e.describeCardinality());
        w.open("attribute");
        w.close("attribute");        
      }
    }
    for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
      if (e.getTypes().size() == 0) {
        w.attribute("name", e.getName());
        w.attribute("cardinality", e.describeCardinality());
        String n;
        if (names.keySet().contains(e))
          n = names.get(e);
        else {
          n = Utilities.capitalize(e.getName());
          names.put(e, n);
          queue.add(e);
        }
        w.attribute("target", n);
        w.open("association");
        w.close("association");
        //queue.add(e);
      }
    }
    w.close("class");
    
  }
*/
  

}
