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

  /**
   * @param args
   */
  public static void main(String[] args) {
   
    FileInputStream in;
    try {
      File source = new CSFile(args[1]);
      File dest = new CSFile(args[2]);
      
      if (!source.exists())        
        throw new Exception("Source File \""+source.getAbsolutePath()+"\" not found");
      in = new CSFileInputStream(source);
      XmlParser p = new XmlParser();
      ResourceOrFeed rf = p.parseGeneral(in);
      if (args[0].equals("round")) {
        if (rf.getFeed() != null)
          new AtomComposer().compose(new FileOutputStream(dest), rf.getFeed(), true);
        else
          new XmlComposer().compose(new FileOutputStream(dest), rf.getResource(), true);
      } else if (args[0].equals("json")) {
        if (rf.getFeed() != null)
          new AtomComposer().compose(new FileOutputStream(dest), rf.getFeed(), true);
        else
          new JsonComposer().compose(new FileOutputStream(dest), rf.getResource());
      } else 
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

}
