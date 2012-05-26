package org.hl7.fhir.tools.publisher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.tools.publisher.Navigation.Category;
import org.hl7.fhir.utilities.Utilities;

public class ChmMaker {

  private Navigation navigation;
  private FolderManager folders;
  private Definitions definitions;
  private PageProcessor page;
  
  private HashMap<String, HashMap<String, String>> keywords = new HashMap<String, HashMap<String, String>>();
  
  
  public ChmMaker(Navigation navigation, FolderManager folders,  Definitions definitions, PageProcessor page) {
    super();
    this.navigation = navigation;
    this.folders = folders;
    this.definitions = definitions;
    this.page = page;
    
    for (ElementDefn root : definitions.getDefinedResources().values())
      registerElementDefnInIndex(root, root.getName().toLowerCase()+".htm", root.getName());
    for (ElementDefn root : definitions.getInfrastructure().values())
      registerElementDefnInIndex(root, "xml.htm", root.getName());
    for (ElementDefn root : definitions.getTypes().values())
      registerElementDefnInIndex(root, "datatypes.htm", root.getName());
    for (DefinedCode c : definitions.getPrimitives().values())
      registerKeyWord(c.getCode(), "datatypes.htm", "Data Types");
    
  }

  public void produce() throws Exception {
    String hhc = "C:\\Program Files (x86)\\HTML Help Workshop\\hhc.exe";
    if (!(new File(hhc).exists())) {
      hhc = "C:\\Program Files\\HTML Help Workshop\\hhc.exe";
      if (!(new File(hhc).exists())) {
        throw new Exception("Not producing CHM - Help Compiler not found");
      }
    }

    // if not windows then....?
    Utilities.clearDirectory(folders.rootDir+"temp\\chm");
    File chm = new File(folders.dstDir+"fhir.chm");
    chm.delete();
    if (chm.exists()) {
      List<String> command = new ArrayList<String>();
      command.add("cmd");
      command.add("del");
      command.add(folders.dstDir+"fhir.chm");
   
      ProcessBuilder builder = new ProcessBuilder(command);
      builder.directory(new File(folders.dstDir));
      final Process process = builder.start();
      process.waitFor();
      
      if (chm.exists()) 
        throw new Exception("Deleting CHM file failed");
    }

    String[] files = new File(folders.dstDir).list();
    for (String f : files) {
      if ((!f.endsWith("htm") || f.endsWith("xml.htm")) && !f.matches(Config.VERSION_REGEX))
        Utilities.copyFile(new File(folders.dstDir+f), new File(folders.rootDir+"temp\\chm\\"+f));
    }
    
    String src = Utilities.fileToString(folders.rootDir+"\\tools\\chm\\fhir.hhp");
    Utilities.stringToFile(src.replace("%fhir%", folders.dstDir), folders.rootDir+"\\temp\\chm\\fhir.hhp");
    Utilities.copyFile(new File(folders.rootDir+"\\tools\\chm\\words.stp"), new File(folders.rootDir+"\\temp\\chm\\words.stp"));
    StringBuilder s = new StringBuilder();
    buildHHC(s);
    Utilities.stringToFile(s.toString(), folders.rootDir+"\\temp\\chm\\fhir.hhc");
    s = new StringBuilder();
    buildHHK(s);
    Utilities.stringToFile(s.toString(), folders.rootDir+"\\temp\\chm\\fhir.hhk");

    List<String> command = new ArrayList<String>();
    command.add(hhc);
    command.add(folders.rootDir+"\\temp\\chm\\fhir.hhp");
 
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.directory(new File(folders.rootDir+"\\temp\\chm"));

    final Process process = builder.start();
    page.log("wait: "+Integer.toString(process.waitFor()));
    if (!chm.exists())
      throw new Exception("Generation of CHM file failed");
  }

  private void buildHHK(StringBuilder s) {
    s.append("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n");
    s.append("<HTML>\r\n");
    s.append("<HEAD>\r\n");
    s.append("<meta name=\"GENERATOR\" content=\"Microsoft&reg; HTML Help Workshop 4.1\">\r\n");
    s.append("<!-- Sitemap 1.0 -->\r\n");
    s.append("</HEAD><BODY>\r\n");
    s.append("<UL>\r\n");
    List<String> names = new ArrayList<String>();
    names.addAll(keywords.keySet());
    Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
    
    for (String k : names) {
      s.append("  <LI> <OBJECT type=\"text/sitemap\">\r\n");
      s.append("      <param name=\"Name\" value=\""+k+"\">\r\n");
      for (String r : keywords.get(k).keySet()) {
        s.append("     <param name=\"Name\" value=\""+keywords.get(k).get(r)+"\">\r\n");
        s.append("     <param name=\"Local\" value=\""+r+"\">\r\n");
      }

      s.append("    </OBJECT>\r\n");
    }
    s.append("</UL>\r\n");
    s.append("</BODY></HTML>\r\n");
  }

  private void buildHHC(StringBuilder s) throws IOException {
    s.append("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n");
    s.append("<HTML>\r\n");
    s.append("<HEAD>\r\n");
    s.append("<meta name=\"GENERATOR\" content=\"Microsoft&reg; HTML Help Workshop 4.1\">\r\n");
    s.append("<!-- Sitemap 1.0 -->\r\n");
    s.append("</HEAD><BODY>\r\n");
    s.append("<OBJECT type=\"text/site properties\">\r\n");
    s.append("  <param name=\"Window Styles\" value=\"0x800025\">\r\n");
    s.append("</OBJECT>\r\n");
    s.append("<UL>\r\n");
    for (Category c : navigation.getCategories()) {
      s.append("  <LI> <OBJECT type=\"text/sitemap\">\r\n");
      s.append("      <param name=\"Name\" value=\""+c.getName()+"\">\r\n");
      s.append("    </OBJECT>\r\n");
      s.append("  <UL>\r\n");
      for (Navigation.Entry e : c.getEntries()) {
        s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
        s.append("       <param name=\"Name\" value=\""+e.getName()+"\">\r\n");
        if (e.getLink() != null) {
          Utilities.copyFile(new File(folders.dstDir+"print-"+e.getLink()+".htm"), new File(folders.rootDir+"\\temp\\chm\\"+e.getLink()+".htm"));
          s.append("       <param name=\"Local\" value=\""+e.getLink()+".htm\">\r\n");
        }
        s.append("      </OBJECT>\r\n");
        for (Navigation.Entry ce : e.getEntries()) {
          s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
          s.append("       <param name=\"Name\" value=\""+ce.getName()+"\">\r\n");
          s.append("       <param name=\"Local\" value=\""+ce.getLink()+".htm\">\r\n");
          s.append("      </OBJECT>\r\n");
          Utilities.copyFile(new File(folders.dstDir+"print-"+ce.getLink()+".htm"), new File(folders.rootDir+"\\temp\\chm\\"+ce.getLink()+".htm"));
        }
      }
      s.append("  </UL>\r\n");
    }
    s.append("  <LI> <OBJECT type=\"text/sitemap\">\r\n");
    s.append("      <param name=\"Name\" value=\"Appendices\">\r\n");
    s.append("    </OBJECT>\r\n");
    s.append("  <UL>\r\n");
    s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
    s.append("       <param name=\"Name\" value=\"Examples\">\r\n");
    s.append("      </OBJECT>\r\n");
    s.append("    <UL>\r\n");
    List<String> names = new ArrayList<String>();
    names.addAll(definitions.getDefinedResources().keySet());
    Collections.sort(names);
    for (String name : names) {
      s.append("      <LI> <OBJECT type=\"text/sitemap\">\r\n");
      s.append("         <param name=\"Name\" value=\""+definitions.getDefinedResources().get(name).getName()+"\">\r\n");
      s.append("         <param name=\"Local\" value=\""+name.toLowerCase()+".xml.htm\">\r\n");
      s.append("        </OBJECT>\r\n");
    }

    s.append("    </UL>\r\n");
    s.append("  </UL>\r\n");
    s.append("</UL>\r\n");
    s.append("</BODY></HTML>\r\n");
  }

  private void registerElementDefnInIndex(ElementDefn n, String filename, String title) {
    registerKeyWord(n.getName(), filename, title);
    for (ElementDefn c : n.getElements())
      registerElementDefnInIndex(c, filename, title);   
  }
  
  void registerKeyWord(String word, String filename, String title) {
    word = word.trim();
    if (!filename.endsWith(".htm"))
      filename = filename + ".htm";
    HashMap<String, String> entry = keywords.get(word);
    if (entry == null) {
      entry = new HashMap<String, String>();
      keywords.put(word,  entry);
    }
    if (!entry.containsKey(filename)) 
      entry.put(filename, title);
  }
  

}
