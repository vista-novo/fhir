package org.hl7.fhir.tools.publisher;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.generators.specification.DictHTMLGenerator;
import org.hl7.fhir.definitions.generators.specification.TerminologyNotesGenerator;
import org.hl7.fhir.definitions.generators.specification.XmlSpecGenerator;
import org.hl7.fhir.definitions.model.ConceptDomain;
import org.hl7.fhir.definitions.model.ConceptDomain.Binding;
import org.hl7.fhir.definitions.model.ConceptDomain.BindingStrength;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.EventDefn;
import org.hl7.fhir.definitions.model.EventUsage;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.definitions.parsers.TypeParser;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.Utilities;

public class PageProcessor implements Logger  {

  private Definitions definitions;
  private FolderManager folders;
  private String version;
  private Navigation navigation;
  private List<PlatformGenerator> referenceImplementations = new ArrayList<PlatformGenerator>();
  private IniFile ini;
  private Date genDate = new Date();
  
  
  private String dictForDt(String dt) throws Exception {
    
    File tmp = File.createTempFile("tmp", ".tmp");
    FileOutputStream fos = new FileOutputStream(tmp);
    DictHTMLGenerator gen = new DictHTMLGenerator(fos);
    TypeParser tp = new TypeParser();
    TypeDefn t = tp.parse(dt).get(0);
    ElementDefn e = definitions.getElementDefn(t.getName());
    if (e == null)
      throw new Exception("unable to find definition for "+dt);
    gen.generate(e);
    fos.close();
    String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
    tmp.delete();
    return val; 
    
  }

  private String tsForDt(String dt) throws Exception {
    File tmp = File.createTempFile("tmp", ".tmp");
    FileOutputStream fos = new FileOutputStream(tmp);
    TerminologyNotesGenerator gen = new TerminologyNotesGenerator(fos);
    TypeParser tp = new TypeParser();
    TypeDefn t = tp.parse(dt).get(0);
    ElementDefn e = definitions.getElementDefn(t.getName());
    if (e == null)
      throw new Exception("unable to find definition for "+dt);
    gen.generate(e, definitions.getConceptDomains());
    fos.close();
    String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
    tmp.delete();
    return val;
  }

  
  private String xmlForDt(String dt) throws Exception {
    File tmp = File.createTempFile("tmp", ".tmp");
    FileOutputStream fos = new FileOutputStream(tmp);
    XmlSpecGenerator gen = new XmlSpecGenerator(fos);
    TypeParser tp = new TypeParser();
    TypeDefn t = tp.parse(dt).get(0);
    ElementDefn e = definitions.getElementDefn(t.getName());
    if (e == null)
      throw new Exception("unable to find definition for "+dt);
    gen.generate(e);
    fos.close();
    String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
    tmp.delete();
    return val; 
  }

  private String generateSideBar() {
    StringBuilder s = new StringBuilder();
    s.append("<div class=\"sidebar\">\r\n");
    for (Navigation.Category c : navigation.getCategories()) {
      s.append("  <h2>"+c.getName()+"</h2>\r\n");
      s.append("  <ul>\r\n");
      for (Navigation.Entry e : c.getEntries()) {
        if (e.getLink() != null)
          s.append("    <li><a href=\""+e.getLink()+".htm\">"+e.getName()+"</a></li>\r\n");
        else
          s.append("    <li>"+e.getName()+"</li>\r\n");
      }
      s.append("  </ul>\r\n");
    }
    s.append("</div>\r\n");
    return s.toString();
  }

  private String combineNotes(List<String> followUps, String notes) {
    String s = "";
    if (notes != null && !notes.equals(""))
      s = notes;
    if (followUps.size() > 0)
      if (s != "")
        s = s + "<br/>Follow ups: "+Utilities.asCSV(followUps);
      else
        s = "Follow ups: "+Utilities.asCSV(followUps);
    return s;      
  }

  private String describeMsg(List<String> resources, List<String> aggregations) {
    if (resources.size() == 0 && aggregations.size() == 0)
      return "<font color=\"silver\">--</font>";
    else {
      String s = resources.size() == 0 ? "" : Utilities.asCSV(resources);
      
      if (aggregations.size() == 0)
        return s;
      else
        return s + "<br/>"+Utilities.asHtmlBr("&nbsp;"+resources.get(0), aggregations)+"";
    }      
  }


  public String processPageIncludes(String file, String src) throws Exception {
    while (src.contains("<%"))
    {
      int i1 = src.indexOf("<%");
      int i2 = src.indexOf("%>");
      String s1 = src.substring(0, i1);
      String s2 = src.substring(i1 + 2, i2).trim();
      String s3 = src.substring(i2+2);
      String name = file.substring(0,file.indexOf(".")); 

      String[] com = s2.split(" ");
      if (com.length == 2 && com[0].equals("dt")) 
        src = s1+xmlForDt(com[1])+tsForDt(com[1])+s3;
      else if (com.length == 2 && com[0].equals("dictionary"))
        src = s1+dictForDt(com[1])+s3;
      else if (com.length != 1)
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
      else if (com[0].equals("header"))
        src = s1+Utilities.fileToString(folders.srcDir + "header.htm")+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
      else if (com[0].equals("sidebar"))
        src = s1+generateSideBar()+s3;
      else if (com[0].equals("title"))
        src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
      else if (com[0].equals("name"))
        src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+version+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
      else if (com[0].equals("maindiv"))
        src = s1+"<div class=\"content\">"+s3;
      else if (com[0].equals("/maindiv"))
        src = s1+"</div>"+s3;
      else if (com[0].equals("events"))
        src = s1 + getEventsTable()+ s3;
      else if (com[0].equals("resourcecodes"))
        src = s1 + genResCodes() + s3;
      else if (com[0].equals("bindingtable"))
        src = s1 + genBindingTable() + s3;
      else if (com[0].equals("resimplall"))
        src = s1 + genResImplList() + s3;
      else if (com[0].equals("impllist"))
        src = s1 + genReferenceImplList() + s3;

      else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
    }
    return src;
  }

  private String genBindingTable() {
    StringBuilder s = new StringBuilder();
    s.append("<table class=\"codes\">\r\n");
    List<String> names = new ArrayList<String>();
    names.addAll(definitions.getConceptDomains().keySet());
    Collections.sort(names);
    for (String n : names) {
      if (!n.startsWith("*")) {
        ConceptDomain cd = definitions.getConceptDomainByName(n);
        s.append("  <tr><td title=\""+Utilities.escapeXml(cd.getDefinition())+"\">"+cd.getName()+"</td><td>");
        if (cd.getBinding() == Binding.Unbound) {
          s.append("Definition: "+Utilities.escapeXml(cd.getDefinition()));
        } else if (cd.getBinding() == Binding.CodeList) {
          if (cd.getBindingStrength() == BindingStrength.Preferred)
            s.append("Preferred codes: ");
          else if (cd.getBindingStrength() == BindingStrength.Suggested)
            s.append("Suggested codes: ");
          else // if (cd.getBindingStrength() == BindingStrength.Required)
            s.append("Required codes: ");
          s.append("    <table class=\"codes\">\r\n");
          boolean hasComment = false;
          boolean hasDefinition = false;
          for (DefinedCode c : cd.getCodes()) {
            hasComment = hasComment || c.hasComment();
            hasDefinition = hasDefinition || c.hasDefinition();
          }
          for (DefinedCode c : cd.getCodes()) {
            if (hasComment)
              s.append("    <tr><td>"+Utilities.escapeXml(c.getCode())+"</td><td>"+Utilities.escapeXml(c.getDefinition())+"</td><td>"+Utilities.escapeXml(c.getComment())+"</td></tr>");
            else if (hasDefinition)
              s.append("    <tr><td>"+Utilities.escapeXml(c.getCode())+"</td><td colspan=\"2\">"+Utilities.escapeXml(c.getDefinition())+"</td></tr>");
            else
              s.append("    <tr><td colspan=\"3\">"+Utilities.escapeXml(c.getCode())+"</td></tr>");
          }
          s.append("    </table>\r\n");
        } else if (cd.getBinding() == Binding.ValueSet) {
          if (cd.getBindingStrength() == BindingStrength.Preferred)
            s.append("Preferred codes: ");
          else if (cd.getBindingStrength() == BindingStrength.Suggested)
            s.append("Suggested codes: ");
          else // if (cd.getBindingStrength() == BindingStrength.Required)
            s.append("Required codes: ");
          if (cd.hasReference())
            s.append("<a href=\""+cd.getReference()+"\">Value Set "+cd.getDescription()+"</a>");
          else
            s.append("Value Set "+cd.getDescription());
        } else if (cd.getBinding() == Binding.Reference) {
          s.append("See <a href=\""+cd.getReference()+"\">"+cd.getReference()+"</a>");
        } else if (cd.getBinding() == Binding.Special) {
          if (cd.getName().equals("MessageEvent"))
            s.append("See the <a href=\"messaging.htm#Events\"> Event List </a>in the messaging framework");
          else if (cd.getName().equals("ResourceType"))
            s.append("See the <a href=\"terminologies.htm#ResourceType\"> list of defined Resource Types</a>");
          else 
            s.append("<a href=\"datatypes.htm\">Any defined data Type name</a> (including <a href=\"xml.htm#Resource\">Resource</a>)");
        }        
        s.append("</td></tr>\r\n");
      }
      
    }
    s.append("</table>\r\n");
    return s.toString();
  }

  private String getEventsTable() {
    List<String> codes = new ArrayList<String>();
    codes.addAll(definitions.getEvents().keySet());
    Collections.sort(codes);
    StringBuilder s = new StringBuilder();
    s.append("<table class=\"grid\">\r\n");
    s.append(" <tr><th>Code</th><th>Description</th><th>Request</th><th>Response</th><th>Notes</th></tr>\r\n");
    for (String c : codes) {
      EventDefn e = definitions.getEvents().get(c);
      if (e.getUsages().size() == 1) {
        EventUsage u = e.getUsages().get(0);
        s.append(" <tr><td>"+e.getCode()+"</td><td>"+e.getDefinition()+"</td>");
        s.append("<td>"+describeMsg(u.getRequestResources(), u.getRequestAggregations())+"</td><td>"+
            describeMsg(u.getResponseResources(), u.getResponseAggregations())+"</td><td>"+
            combineNotes(e.getFollowUps(), u.getNotes())+"</td></tr>\r\n");
      } else {
        boolean first = true;
        for (EventUsage u : e.getUsages()) {
          if (first)
            s.append(" <tr><td rowspan=\""+Integer.toString(e.getUsages().size())+"\">"+e.getCode()+"</td><td rowspan=\""+Integer.toString(e.getUsages().size())+"\">"+e.getDefinition()+"</td>");
          else
            s.append(" <tr>");
          first = false;
          s.append("<td>"+describeMsg(u.getRequestResources(), u.getRequestAggregations())+"</td><td>"+
              describeMsg(u.getResponseResources(), u.getResponseAggregations())+"</td><td>"+
              combineNotes(e.getFollowUps(), u.getNotes())+"</td></tr>\r\n");
        }
      }
    }
    s.append("</table>\r\n");
    return s.toString();
  }

  private String genResCodes() {
    StringBuilder html = new StringBuilder();
    List<String> names = new ArrayList<String>();
    names.addAll(definitions.getKnownResources().keySet());
    Collections.sort(names);
    for (String n : names) {
      DefinedCode c = definitions.getKnownResources().get(n);
      html.append("  <tr><td><a href=\""+c.getComment()+".htm\">"+c.getCode()+"</a></td><td>"+Utilities.escapeXml(c.getDefinition())+"</td></tr>");
    }       
    return html.toString();
  }

  private String genResImplList() {
    StringBuilder html = new StringBuilder();
    List<String> res = new ArrayList<String>();
    for (ElementDefn n: definitions.getDefinedResources().values())
      res.add(n.getName());
    for (DefinedCode c : definitions.getKnownResources().values()) {
      if (res.contains(c.getComment()))
        html.append("  <tr><td>"+c.getCode()+"</td><td><a href=\""+c.getComment()+".dict.xml\">Definitions</a></td><td><a href=\""+c.getComment()+".xsd\">Schema</a></td><td><a href=\""+c.getComment()+".xml\">Example</a></td><td><a href=\""+c.getComment()+".json\">JSON Example</a></td>\r\n");
    }       
    return html.toString();

  }

  private String genReferenceImplList() {
    StringBuilder s = new StringBuilder();
    for (PlatformGenerator gen : referenceImplementations) {
      s.append("<li><b><a href=\""+gen.getName()+".zip\">"+gen.getTitle()+"</a></b>: "+Utilities.escapeXml(gen.getDescription())+"</li>\r\n");
    }
    return s.toString();
  }


  String processPageIncludesForPrinting(String file, String src) throws Exception {
    while (src.contains("<%"))
    {
      int i1 = src.indexOf("<%");
      int i2 = src.indexOf("%>");
      String s1 = src.substring(0, i1);
      String s2 = src.substring(i1 + 2, i2).trim();
      String s3 = src.substring(i2+2);
      String name = file.substring(0,file.indexOf(".")); 

      String[] com = s2.split(" ");
      if (com.length == 2 && com[0].equals("dt"))
        src = s1+xmlForDt(com[1])+tsForDt(com[1])+s3;
      else if (com.length == 2 && com[0].equals("dictionary"))
        src = s1+dictForDt(com[1])+s3;
      else if (com.length != 1)
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
      else if (com[0].equals("header"))
        src = s1+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
      else if (com[0].equals("sidebar"))
        src = s1+s3;
      else if (com[0].equals("title"))
        src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
      else if (com[0].equals("name"))
        src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
      else if (com[0].equals("maindiv"))
        src = s1+s3;
      else if (com[0].equals("/maindiv"))
        src = s1+s3;
      else if (com[0].equals("events"))
        src = s1 + getEventsTable()+ s3;
      else if (com[0].equals("resourcecodes"))
        src = s1 + genResCodes() + s3;
      else if (com[0].equals("bindingtable"))
        src = s1 + genBindingTable() + s3;
      else if (com[0].equals("resimplall"))
        src = s1 + genResImplList() + s3;
      else if (com[0].equals("impllist"))
        src = s1 + genReferenceImplList() + s3;
      else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
    }
    return src;
  } 

  String processPageIncludesForBook(String file, String src) throws Exception {
    while (src.contains("<%"))
    {
      int i1 = src.indexOf("<%");
      int i2 = src.indexOf("%>");
      String s1 = src.substring(0, i1);
      String s2 = src.substring(i1 + 2, i2).trim();
      String s3 = src.substring(i2+2);
      String name = file.substring(0,file.indexOf(".")); 

      String[] com = s2.split(" ");
      if (com.length == 2 && com[0].equals("dt"))
        src = s1+xmlForDt(com[1])+tsForDt(com[1])+s3;
      else if (com.length == 2 && com[0].equals("dictionary"))
        src = s1+dictForDt(com[1])+s3;
      else if (com.length != 1)
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
      else if (com[0].equals("header"))
        src = s1+s3;
      else if (com[0].equals("footer"))
        src = s1+s3;
      else if (com[0].equals("sidebar"))
        src = s1+s3;
      else if (com[0].equals("title"))
        src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
      else if (com[0].equals("name"))
        src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
      else if (com[0].equals("maindiv"))
        src = s1+s3;
      else if (com[0].equals("/maindiv"))
        src = s1+s3;
      else if (com[0].equals("events"))
        src = s1 + getEventsTable()+ s3;
      else if (com[0].equals("resourcecodes"))
        src = s1 + genResCodes() + s3;
      else if (com[0].equals("bindingtable"))
        src = s1 + genBindingTable() + s3;
      else if (com[0].equals("resimplall"))
        src = s1 + genResImplList() + s3;
      else if (com[0].equals("impllist"))
        src = s1 + genReferenceImplList() + s3;
      else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
    }
    return src;
  } 



  String processResourceIncludes(String name, ElementDefn root, String xml, String tx, String dict, String src, String introduction) throws Exception {
    while (src.contains("<%"))
    {
      int i1 = src.indexOf("<%");
      int i2 = src.indexOf("%>");
      String s1 = src.substring(0, i1);
      String s2 = src.substring(i1 + 2, i2).trim();
      String s3 = src.substring(i2+2);

      String[] com = s2.split(" ");
      if (com.length != 1)
        throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+name);
      else if (com[0].equals("header"))
        src = s1+Utilities.fileToString(folders.srcDir + "header.htm")+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
      else if (com[0].equals("sidebar"))
        src = s1+generateSideBar()+s3;
      else if (com[0].equals("title"))
        src = s1+root.getName()+s3;
      else if (com[0].equals("introduction")) 
        src = s1+introduction+s3;
      else if (com[0].equals("name"))
        src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
      else if (com[0].equals("definition"))
        src = s1+root.getDefinition()+s3;
      else if (com[0].equals("xml"))
        src = s1+xml+s3;
      else if (com[0].equals("tx"))
        src = s1+tx+s3;
      else if (com[0].equals("plural"))
        src = s1+Utilities.pluralizeMe(name)+s3;
      else if (com[0].equals("notes")) {
        if (new File(folders.sndBoxDir + name+File.separatorChar+name+"-notes.xhtml").exists())
          src = s1+Utilities.fileToString(folders.sndBoxDir + name+File.separatorChar+name+"-notes.xhtml")+s3;
        else
          src = s1+Utilities.fileToString(folders.srcDir + name+File.separatorChar+name+"-notes.xhtml")+s3;
      } else if (com[0].equals("dictionary"))
        src = s1+dict+s3;
      else if (com[0].equals("resurl")) {
        if (isSpecial(name))
          src = s1+"This special resource has no associated URL"+s3;
        else
          src = s1+"The resource name as it appears in a <a href=\"http.htm\"> RESTful URL</a> is /"+name+"/"+s3;
      } else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+name);

    }
    return src;
  }

  String processProfileIncludes(String filename, ProfileDefn profile, String xml, String src) throws Exception {
    while (src.contains("<%"))
    {
      int i1 = src.indexOf("<%");
      int i2 = src.indexOf("%>");
      String s1 = src.substring(0, i1);
      String s2 = src.substring(i1 + 2, i2).trim();
      String s3 = src.substring(i2+2);

      String[] com = s2.split(" ");
      if (com.length != 1)
        throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+filename);
      else if (com[0].equals("header"))
        src = s1+Utilities.fileToString(folders.srcDir + "header.htm")+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
      else if (com[0].equals("sidebar"))
        src = s1+generateSideBar()+s3;
      else if (com[0].equals("title"))
        src = s1+profile.getMetadata().get("name").get(0)+s3;
      else if (com[0].equals("name"))
        src = s1+filename+s3;
      else if (com[0].equals("date")) {
        Date d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(profile.getMetadata().get("date").get(0));
        src = s1+Config.DATE_FORMAT().format(d)+s3;
      } else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
      else if (com[0].equals("definition"))
        src = s1+profile.getMetadata().get("description").get(0)+s3;
      else if (com[0].equals("status"))
        src = s1+describeStatus(profile.getMetadata().get("status").get(0))+s3;
      else if (com[0].equals("author"))
        src = s1+profile.getMetadata().get("author.name").get(0)+s3;
      else if (com[0].equals("xml"))
        src = s1+xml+s3;
      else if (com[0].equals("profilelist"))
        src = s1+"profiles the "+profile.getMetadata().get("resource").get(0)+" Resource"+s3;
      else if (com[0].equals("tx"))
        src = s1+"todo"+s3;
      else if (com[0].equals("plural"))
        src = s1+Utilities.pluralizeMe(filename)+s3;
      else if (com[0].equals("notes"))
        src = s1+"todo" /*Utilities.fileToString(folders.srcDir + filename+File.separatorChar+filename+".htm")*/ +s3;
      else if (com[0].equals("dictionary"))
        src = s1+"todo"+s3;
      else if (com[0].equals("resurl")) {
          src = s1+"The id of this profile is "+profile.getMetadata().get("id").get(0)+s3;
      } else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+filename);
    }
    return src;
  }

  private boolean isSpecial(String name) {
    return definitions.getSpecialResources().containsKey(name);
  }   


  private String describeStatus(String s) {
    if (s.equals("draft"))
      return "as a draft";
    if (s.equals("testing"))
      return "for testing";
    if (s.equals("production"))
      return "for production use";
    if (s.equals("withdrawn"))
      return "as withdrawn from use";
    if (s.equals("superceded"))
      return "as superceded";
    return "with unknown status '" +s+'"';
  }

  public Definitions getDefinitions() {
    return definitions;
  }

  public FolderManager getFolders() {
    return folders;
  }

  public String getVersion() {
    return version;
  }

  public Navigation getNavigation() {
    return navigation;
  }

  public List<PlatformGenerator> getReferenceImplementations() {
    return referenceImplementations;
  }

  public IniFile getIni() {
    return ini;
  }

  public void setDefinitions(Definitions definitions) {
    this.definitions = definitions;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public void setFolders(FolderManager folders) {
    this.folders = folders;
  }

  public void setIni(IniFile ini) {
    this.ini = ini;
  }

  public Date getGenDate() {
    return genDate;
  }

  public void log(String content) {
    System.out.println(content);        
  }

  public void setNavigation(Navigation navigation) {
    this.navigation = navigation;
  }
  
}
