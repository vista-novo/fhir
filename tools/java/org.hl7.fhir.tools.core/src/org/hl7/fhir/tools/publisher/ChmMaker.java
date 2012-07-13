package org.hl7.fhir.tools.publisher;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.Example;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.tools.publisher.Navigation.Category;
import org.hl7.fhir.utilities.TextFile;
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
    
    for (ResourceDefn root : definitions.getResources().values())
      registerElementDefnInIndex(root.getRoot(), root.getName().toLowerCase()+".htm", root.getName());
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
        page.log("Not producing CHM - Help Compiler not found");
        return;
      }
    }

    // if not windows then....?
    Utilities.clearDirectory(folders.rootDir+"temp\\chm");
    File chm = new File(folders.dstDir+"fhir.chm");
    chm.delete();
    if (chm.exists()) {
      throw new Exception("Deleting CHM file failed");
    }

    String[] files = new File(folders.dstDir).list();
    for (String f : files) {
      if ((!f.endsWith("htm") || f.endsWith("xml.htm")) && !f.matches(Config.VERSION_REGEX) && !f.equals("html")  && !f.equals("examples"))
        Utilities.copyFile(new File(folders.dstDir+f), new File(folders.rootDir+"temp\\chm\\"+f));
    }
    
    String src = TextFile.fileToString(folders.rootDir+"\\tools\\chm\\fhir.hhp");
    TextFile.stringToFile(src.replace("%fhir%", folders.dstDir), folders.rootDir+"\\temp\\chm\\fhir.hhp");
    Utilities.copyFile(new File(folders.rootDir+"\\tools\\chm\\words.stp"), new File(folders.rootDir+"\\temp\\chm\\words.stp"));
    StringBuilder s = new StringBuilder();
    buildHHC(s);
    TextFile.stringToFile(s.toString(), folders.rootDir+"\\temp\\chm\\fhir.hhc");
    s = new StringBuilder();
    buildHHK(s);
    TextFile.stringToFile(s.toString(), folders.rootDir+"\\temp\\chm\\fhir.hhk");

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

  private void buildHHC(StringBuilder s) throws Exception {
    List<String> links = new ArrayList<String>();

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
      if (c.getLink() != null) {
        Utilities.copyFile(new File(folders.dstDir+"print-"+c.getLink()+".htm"), new File(folders.rootDir+"\\temp\\chm\\"+c.getLink()+".htm"));
        links.add(c.getLink());
        s.append("       <param name=\"Local\" value=\""+c.getLink()+".htm\">\r\n");
      }

      s.append("    </OBJECT>\r\n");
      s.append("  <UL>\r\n");
      for (Navigation.Entry e : c.getEntries()) {
        s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
        s.append("       <param name=\"Name\" value=\""+e.getName()+"\">\r\n");
        if (e.getLink() != null) {
          Utilities.copyFile(new File(folders.dstDir+"print-"+e.getLink()+".htm"), new File(folders.rootDir+"\\temp\\chm\\"+e.getLink()+".htm"));
          s.append("       <param name=\"Local\" value=\""+e.getLink()+".htm\">\r\n");
          links.add(e.getLink());
        }
        s.append("      </OBJECT>\r\n");
        for (Navigation.Entry ce : e.getEntries()) {
          s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
          s.append("       <param name=\"Name\" value=\""+ce.getName()+"\">\r\n");
          s.append("       <param name=\"Local\" value=\""+ce.getLink()+".htm\">\r\n");
          s.append("      </OBJECT>\r\n");
          Utilities.copyFile(new File(folders.dstDir+"print-"+ce.getLink()+".htm"), new File(folders.rootDir+"\\temp\\chm\\"+ce.getLink()+".htm"));
          links.add(ce.getLink());
        }
      }
      if (c.getEntries().size() ==0 && c.getLink().equals("resources")) {
        List<String> list = new ArrayList<String>();
        list.addAll(page.getDefinitions().getResources().keySet());
        Collections.sort(list);
        
        for (String rn : list) {
          if (!links.contains(rn.toLowerCase())) {
            ResourceDefn r = page.getDefinitions().getResourceByName(rn);
            s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
            s.append("       <param name=\"Name\" value=\""+r.getName()+"\">\r\n");
            s.append("       <param name=\"Local\" value=\""+rn.toLowerCase()+".htm\">\r\n");
            s.append("      </OBJECT>\r\n");
            Utilities.copyFile(new File(folders.dstDir+"print-"+rn.toLowerCase()+".htm"), new File(folders.rootDir+"\\temp\\chm\\"+rn.toLowerCase()+".htm"));
          }
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
    names.addAll(definitions.getResources().keySet());
    Collections.sort(names);
    for (String name : names) {
      for (Example e : definitions.getResources().get(name).getExamples()) {
        s.append("      <LI> <OBJECT type=\"text/sitemap\">\r\n");
        s.append("         <param name=\"Name\" value=\""+e.getName()+"\">\r\n");
        s.append("         <param name=\"Local\" value=\""+e.getFileTitle()+".xml.htm\">\r\n");
        s.append("        </OBJECT>\r\n");
      }
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
