package org.hl7.fhir.instance.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hl7.fhir.instance.formats.AtomComposer;
import org.hl7.fhir.instance.formats.JsonComposer;
import org.hl7.fhir.instance.formats.XmlComposer;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.formats.XmlParserBase.ResourceOrFeed;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.w3c.dom.Document;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


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
      else if (args[0].equals("fragments")) 
          self.executeFragments(args);
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

  protected XmlPullParser loadXml(InputStream stream) throws Exception {
	BufferedInputStream input = new BufferedInputStream(stream);
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
    factory.setNamespaceAware(true);
    XmlPullParser xpp = factory.newPullParser();
    xpp.setInput(input, "UTF-8");
    xpp.next();
    return xpp;
  }
	 
  protected int nextNoWhitespace(XmlPullParser xpp) throws Exception {
    int eventType = xpp.getEventType();
    while (eventType == XmlPullParser.TEXT && xpp.isWhitespace())
      eventType = xpp.next();
    return eventType;
  }
  
  private void executeFragments(String[] args) throws Exception {
    try {
      File source = new CSFile(args[1]);
      File dest = new CSFile(args[2]);
      if (!source.exists())        
        throw new Exception("Source File \""+source.getAbsolutePath()+"\" not found");
      XmlPullParser xpp = loadXml(new FileInputStream(source));
      nextNoWhitespace(xpp);
      if (!xpp.getName().equals("tests"))
        throw new Exception("Unable to parse file - starts with "+xpp.getName());
      xpp.next();
      nextNoWhitespace(xpp);
      StringBuilder s = new StringBuilder();
      s.append("<results>\r\n");
      int fail = 0;
      while (xpp.getEventType() == XmlPullParser.START_TAG && xpp.getName().equals("test")) {
        String id = xpp.getAttributeValue(null, "id");
        String type = xpp.getAttributeValue(null, "type");
        // test
        xpp.next();
        nextNoWhitespace(xpp);
        // pre
        xpp.next();
        nextNoWhitespace(xpp);
        XmlParser p = new XmlParser();
        try {
          p.parseFragment(xpp, type);
          s.append("<result id=\""+id+"\" outcome=\"ok\"/>\r\n");
          nextNoWhitespace(xpp);
        } catch (Exception e) {
          s.append("<result id=\""+id+"\" outcome=\"error\" msg=\""+Utilities.escapeXml(e.getMessage())+"\"/>\r\n");
          fail++;
        }
        while (xpp.getEventType() != XmlPullParser.END_TAG || !xpp.getName().equals("pre")) 
          xpp.next();
        xpp.next();
        nextNoWhitespace(xpp);
        xpp.next();
        nextNoWhitespace(xpp);
      }
      s.append("</results>\r\n");

      System.out.println("done (fail = "+Integer.toString(fail)+")");
      TextFile.stringToFile(s.toString(), args[2]);
    } catch (Exception e) {
      e.printStackTrace();
      TextFile.stringToFile(e.getMessage(), args[2]);
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
