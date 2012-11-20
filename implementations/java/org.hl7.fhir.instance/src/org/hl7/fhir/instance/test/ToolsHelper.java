package org.hl7.fhir.instance.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hl7.fhir.instance.formats.AtomComposer;
import org.hl7.fhir.instance.formats.JsonComposer;
import org.hl7.fhir.instance.formats.XmlComposer;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.formats.XmlParserBase.ResourceOrFeed;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.hl7.fhir.utilities.TextFile;


public class ToolsHelper {

  public static void main(String[] args) {
//    StringBuilder b = new StringBuilder();
//    for (String a : args)
//      b.append(", "+a);
//    System.err.print("Tool Helper: "+b.toString().substring(2));
    
    try {
      ToolsHelper self = new ToolsHelper();
      if (args[0].equals("round")) 
        self.executeRoundTrip(args);
      else if (args[0].equals("json")) 
        self.executeJson(args);
      else 
        throw new Exception("Unknown command '"+args[0]+"'");
    } catch (Throwable e) {
      try {
        e.printStackTrace();
        TextFile.stringToFile(e.toString(), args[1]+".err");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }

  public void executeRoundTrip(String[] args) throws Exception {
    FileInputStream in;
    File source = new CSFile(args[1]);
    File dest = new CSFile(args[2]);

    if (!source.exists())        
      throw new Exception("Source File \""+source.getAbsolutePath()+"\" not found");
    in = new CSFileInputStream(source);
    XmlParser p = new XmlParser();
    ResourceOrFeed rf = p.parseGeneral(in);
    if (rf.getFeed() != null)
      new AtomComposer().compose(new FileOutputStream(dest), rf.getFeed(), true);
    else
      new XmlComposer().compose(new FileOutputStream(dest), rf.getResource(), true);
  }

  public void executeJson(String[] args) throws Exception {
    FileInputStream in;
    File source = new CSFile(args[1]);
    File dest = new CSFile(args[2]);

    if (!source.exists())        
      throw new Exception("Source File \""+source.getAbsolutePath()+"\" not found");
    in = new CSFileInputStream(source);
    XmlParser p = new XmlParser();
    ResourceOrFeed rf = p.parseGeneral(in);
    if (rf.getFeed() != null)
      new JsonComposer().compose(new FileOutputStream(dest), rf.getFeed());
    else
      new JsonComposer().compose(new FileOutputStream(dest), rf.getResource());
  }

}
