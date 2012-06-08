package org.hl7.fhir.instance.formats;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class XmlBase {
  protected static final String FHIR_NS = "http://hl7.org/fhir";
  protected static final String ATOM_NS = "http://www.w3.org/2005/Atom";
  protected static final String GDATA_NS = "http://schemas.google.com/g/2005";
  private static final String XML_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
  
  protected XmlPullParser loadXml(InputStream stream) throws Exception {
    BufferedInputStream input = new BufferedInputStream(stream);
    XmlPullParserFactory factory = XmlPullParserFactory.newInstance(System.getProperty(XmlPullParserFactory.PROPERTY_NAME), null);
    factory.setNamespaceAware(true);
    XmlPullParser xpp = factory.newPullParser();
    xpp.setInput(input, null);
    xpp.next();
    
    return xpp;
  }
 
  protected int nextNoWhitespace(XmlPullParser xpp) throws Exception {
    int eventType = xpp.next();
    while (eventType == XmlPullParser.TEXT && xpp.isWhitespace())
      eventType = xpp.next();
    return eventType;
  }

  
  private boolean allowUnknownContent;
  public boolean isAllowUnknownContent() {
    return allowUnknownContent;
  }
  public void setAllowUnknownContent(boolean allowUnknownContent) {
    this.allowUnknownContent = allowUnknownContent;
  }
  
  protected String dateToXml(java.util.Date date) {
    // there's a better way to do this in java 1.7, but for now going java 1.7 is too hard for implementers
    String res = new SimpleDateFormat(XML_DATE_PATTERN).format(date);
    return res.substring(0, 22)+":"+res.substring(22);  
  }
  
  protected java.util.Date xmlToDate(String date) throws ParseException {
    // there's a better way to do this in java 1.7, but for now going java 1.7 is too hard for implementers
    date = date.substring(0, 22)+date.substring(23);  
    return new SimpleDateFormat(XML_DATE_PATTERN).parse(date);
  }
}
