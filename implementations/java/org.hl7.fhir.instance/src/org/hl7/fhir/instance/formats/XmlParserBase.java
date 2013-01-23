package org.hl7.fhir.instance.formats;
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

import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.xmlpull.v1.XmlPullParser;

public abstract class XmlParserBase extends XmlBase {


  public class ResourceOrFeed {
    private Resource resource;
    private AtomFeed feed;
    public Resource getResource() {
      return resource;
    }
    public AtomFeed getFeed() {
      return feed;
    }
  }
  
  private Map<String, Object> idMap = new HashMap<String, Object>();

  /** -- worker routines --------------------------------------------------- */
  
//  private Element resolveElement(String id) {
//    return idMap.get(id);
//  }

  protected void parseTypeAttributes(XmlPullParser xpp, Type t) throws Exception {
    parseElementAttributes(xpp, t);
  }

  protected void parseElementAttributes(XmlPullParser xpp, Element e) throws Exception {
    if (xpp.getAttributeValue(null, "id") != null) {
      e.setXmlId(xpp.getAttributeValue(null, "id"));
      idMap.put(e.getXmlId(), e);
    }
  }




  private String pathForLocation(XmlPullParser xpp) {
    return xpp.getPositionDescription();
  }
  
  abstract protected Resource parseResource(XmlPullParser xpp) throws Exception;

  public ResourceOrFeed parseGeneral(InputStream input) throws Exception {
    XmlPullParser xpp = loadXml(input);
    ResourceOrFeed r = new ResourceOrFeed();
    
    if (xpp.getNamespace().equals(FHIR_NS))
      r.resource = parseResource(xpp);
    else if (xpp.getNamespace().equals(ATOM_NS)) 
      r.feed = new AtomParser().parse(xpp);
    else
      throw new Exception("This does not appear to be a FHIR resource (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return r;    
  }

  public Resource parse(InputStream input) throws Exception {
    XmlPullParser xpp = loadXml(input);
  
    if (!xpp.getNamespace().equals(FHIR_NS))
      throw new Exception("This does not appear to be a FHIR resource (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return parseResource(xpp);
  }

  public Resource parse(XmlPullParser xpp) throws Exception {
    if (!xpp.getNamespace().equals(FHIR_NS))
      throw new Exception("This does not appear to be a FHIR resource (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return parseResource(xpp);
  }

  
  protected void unknownContent(XmlPullParser xpp) throws Exception {
    if (!isAllowUnknownContent())
      throw new Exception("Unknown Content "+xpp.getName()+" @ "+pathForLocation(xpp));
  }
  
//  protected Id parseId(XmlPullParser xpp) throws Exception {
//    Id result = new Id();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseString(xpp));
//    return result;
//  }
//
//  protected abstract void parseExtensions(int eventType, XmlPullParser xpp, List<Extension> extensions) throws Exception;
//
//  protected String parseString(XmlPullParser xpp) throws Exception {
//    String id = xpp.getAttributeValue(null, "id");	
//    String res = xpp.getAttributeValue(null, "value");
//    int eventType = xpp.next();
//    if (eventType == XmlPullParser.TEXT)
//      throw new Exception("No text is allowed String");
//    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) 
//      parseExtensions(eventType, xpp, res.getExtensions());
//    if (xpp.next() != XmlPullParser.END_TAG)
//      throw new Exception("Bad String Structure");
//    xpp.next();
//    if (id != null) 
//        idMap.put(id, res);
//    return res;
//  }
//
//
//  protected String_ parseString_(XmlPullParser xpp) throws Exception {
//    String_ result = new String_();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseString(xpp));
//    return result;    
//  }
//  
//  
//  protected Code parseCode(XmlPullParser xpp) throws Exception {
//    Code result = new Code();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseString(xpp));
//    return result;    
//  }
//  
//  protected Instant parseInstant(XmlPullParser xpp) throws Exception {
//	    Instant result = new Instant();
//	    parseTypeAttributes(xpp, result);
//	    result.setValue(xmlToDate(parseString(xpp)));	    
//	    return result;    
//	  }
//	  
//  protected java.util.Calendar parseInstantSimple(XmlPullParser xpp) throws Exception {
//	  return xmlToDate(parseString(xpp));    
//  }
//	  
//   
  protected XhtmlNode parseXhtml(XmlPullParser xpp) throws Exception {
    XhtmlParser prsr = new XhtmlParser();
    return prsr.parseHtmlNode(xpp);
  }


//  protected BigDecimal parseBigDecimal(XmlPullParser xpp) throws Exception {
//    return new BigDecimal(parseString(xpp));
//  }  
//
//  protected byte[] parseBytes(XmlPullParser xpp) throws Exception {
//    return Base64.decodeBase64(parseString(xpp).getBytes());
//  }
//
//  protected Integer parseInteger(XmlPullParser xpp) throws Exception {
//    Integer result = new Integer();
//    parseTypeAttributes(xpp, result);
//    String s = parseString(xpp);
//    result.setValue(new java.lang.Integer(s.startsWith("+") ? s.substring(1) : s));
//    result.setOriginal(s);
//    return result;    
//  }
// 
////  protected java.lang.Integer parseInt(XmlPullParser xpp) throws Exception {
////  }
////   
//  protected Boolean parseBool(XmlPullParser xpp) throws Exception {
//    return parseBoolean(xpp);
//  }
//
//  protected Boolean parseBoolean(XmlPullParser xpp) throws Exception {
//    Boolean result = new Boolean();
//    parseTypeAttributes(xpp, result);
//    String s = parseString(xpp);
//    result.setValue(java.lang.Boolean.valueOf(s));
//    result.setOriginal(s);
//    return result;    
//  }
//
//  protected DateTime parseDateTime(XmlPullParser xpp) throws Exception {
//    DateTime result = new DateTime();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseString(xpp));
//    return result;
//  }
//  
//  protected Date parseDate(XmlPullParser xpp) throws Exception {
//    Date result = new Date();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseString(xpp));
//    return result;
//  }
//
//
//  protected Sid parseSid(XmlPullParser xpp) throws Exception {
//    Sid result = new Sid();
//    parseTypeAttributes(xpp, result);
//    result.setValue(new URI(parseString(xpp)));
//    return result;
//  }
//  protected Decimal parseDecimal(XmlPullParser xpp) throws Exception {
//    Decimal result = new Decimal();
//    parseTypeAttributes(xpp, result);
//    String s = parseString(xpp);
//    result.setValue(new BigDecimal(s));
//    result.setOriginal(s);
//    return result;
//  }
//  protected Uri parseUri(XmlPullParser xpp) throws Exception {
//    Uri result = new Uri();
//    parseTypeAttributes(xpp, result);
//    result.setValue(new URI(parseString(xpp)));
//    return result;
//  }
//  protected Uri parseURI(XmlPullParser xpp) throws Exception {
//    Uri result = new Uri();
//    parseTypeAttributes(xpp, result);
//    result.setValue(new URI(parseString(xpp)));
//    return result;
//  }
//  protected Base64Binary parseBase64Binary(XmlPullParser xpp) throws Exception {
//    Base64Binary result = new Base64Binary();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseBytes(xpp));
//    return result;
//  }
//  protected Oid parseOid(XmlPullParser xpp) throws Exception {
//    Oid result = new Oid();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseString(xpp));
//    return result;
//  }
//  protected Uuid parseUuid(XmlPullParser xpp) throws Exception {
//    Uuid result = new Uuid();
//    parseTypeAttributes(xpp, result);
//    result.setValue(parseString(xpp));
//    return result;
//  }
//
  
  
  protected int parseIntegerPrimitive(String value) {
    return java.lang.Integer.parseInt(value);
  }

  protected String parseDateTimePrimitive(String value) {
    return value;
  }


  protected String parseCodePrimitive(String value) {
    return value;
  }

  protected String parseDatePrimitive(String value) {
    return value;
  }

  protected BigDecimal parseDecimalPrimitive(String value) {
    return new BigDecimal(value);
  }

  protected URI parseUriPrimitive(String value) throws Exception {
    return new URI(value);
  }

  protected byte[] parseBase64BinaryPrimitive(String value) {
    return Base64.decodeBase64(value.getBytes());
  }
  
  protected String parseOidPrimitive(String value) {
    return value;
  }

  protected boolean parseBooleanPrimitive(String value) {
    return java.lang.Boolean.valueOf(value);
  }
  
  protected Calendar parseInstantPrimitive(String value) throws Exception {
    return xmlToDate(value);
  }

  protected String parseIdPrimitive(String value) {
    return value;
  }

  protected String parseStringPrimitive(String value) {
    return value;
  }

  protected String parseUuidPrimitive(String value) {
    return value;
  }

  
}