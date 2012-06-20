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

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public abstract class XmlParserBase extends XmlBase {


 

  private Map<String, Object> idMap = new HashMap<String, Object>();

  /** -- worker routines --------------------------------------------------- */
  
//  private Element resolveElement(String id) {
//    return idMap.get(id);
//  }

  protected void parseTypeAttributes(XmlPullParser xpp, Type t) throws Exception {
    if (xpp.getAttributeValue(null, "dataAbsentReason") != null)
      t.setDataAbsentReason(DataAbsentReason.fromCode(xpp.getAttributeValue(null, "dataAbsentReason")));
    if (xpp.getAttributeValue(null, "xml:Id") != null) {
      t.setXmlId(xpp.getAttributeValue(null, "xml:Id"));
      idMap.put(t.getXmlId(), t);
    }
  }

  protected void parseElementAttributes(XmlPullParser xpp, Element e) throws Exception {
    if (xpp.getAttributeValue(null, "xml:Id") != null) {
      e.setXmlId(xpp.getAttributeValue(null, "xml:Id"));
      idMap.put(e.getXmlId(), e);
    }
  }




  private String pathForLocation(XmlPullParser xpp) {
    return xpp.getPositionDescription();
  }
  
  abstract protected Resource parseResource(XmlPullParser xpp) throws Exception;

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
  
  protected Id parseId(XmlPullParser xpp) throws Exception {
    Id result = new Id();
    parseTypeAttributes(xpp, result);
    result.setValue(parseString(xpp));
    return result;
  }


  protected String parseString(XmlPullParser xpp) throws Exception {
    String id = xpp.getAttributeValue(null, "xml:Id");	      
    if (xpp.next() != XmlPullParser.TEXT)
      throw new Exception("No text in String");
    String res = xpp.getText();
    if (xpp.next() != XmlPullParser.END_TAG)
      throw new Exception("Bad String Structure");
    xpp.next();
    if (id != null) 
        idMap.put(id, res);
    return res;
  }

  protected String_ parseString_(XmlPullParser xpp) throws Exception {
    String_ result = new String_();
    parseTypeAttributes(xpp, result);
    result.setValue(parseString(xpp));
    return result;    
  }
  
  protected Code parseCode(XmlPullParser xpp) throws Exception {
    Code result = new Code();
    parseTypeAttributes(xpp, result);
    result.setValue(parseString(xpp));
    return result;    
  }
  
  protected Instant parseInstant(XmlPullParser xpp) throws Exception {
	    Instant result = new Instant();
	    parseTypeAttributes(xpp, result);
	    result.setValue(xmlToDate(parseString(xpp)));
	    return result;    
	  }
	  
  protected java.util.Date parseInstantSimple(XmlPullParser xpp) throws Exception {
	  return xmlToDate(parseString(xpp));    
  }
	  
  
  protected URI parseURI(XmlPullParser xpp) throws Exception {
    return new URI(parseString(xpp));
  }
  
  protected XhtmlNode parseXhtml(XmlPullParser xpp) throws Exception {
    XhtmlParser prsr = new XhtmlParser();
    return prsr.parseHtmlNode(xpp);
  }


  protected BigDecimal parseBigDecimal(XmlPullParser xpp) throws Exception {
    return new BigDecimal(parseString(xpp));
  }  

  protected byte[] parseBytes(XmlPullParser xpp) throws Exception {
    return Base64.decodeBase64(parseString(xpp).getBytes());
  }

  protected Integer parseInteger(XmlPullParser xpp) throws Exception {
    String id = xpp.getAttributeValue(null, "xml:Id");	      
    Integer result = new Integer();
    parseTypeAttributes(xpp, result);
    result.setValue(parseInt(xpp));
    if (id != null) 
        idMap.put(id, result);
    return result;    
  }
 
  protected int parseInt(XmlPullParser xpp) throws Exception {
    return java.lang.Integer.valueOf(parseString(xpp));
  }
   
  protected boolean parseBool(XmlPullParser xpp) throws Exception {
    return java.lang.Boolean.valueOf(parseString(xpp));
  }

  protected Boolean parseBoolean(XmlPullParser xpp) throws Exception {
    Boolean result = new Boolean();
    parseTypeAttributes(xpp, result);
    result.setValue(parseBool(xpp));
    return result;    
  }

  protected DateTime parseDateTime(XmlPullParser xpp) throws Exception {
    DateTime result = new DateTime();
    parseTypeAttributes(xpp, result);
    result.setValue(parseString(xpp));
    return result;
  }
  
  protected Date parseDate(XmlPullParser xpp) throws Exception {
    Date result = new Date();
    parseTypeAttributes(xpp, result);
    result.setValue(parseString(xpp));
    return result;
  }
 
  protected ResourceReference parseResourceReference(XmlPullParser xpp) throws Exception {
    ResourceReference res = new ResourceReference();
    parseTypeAttributes(xpp, res);

    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id"))
        res.setId(parseString(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version"))
        res.setVersion(parseString(xpp));
      else if(eventType == XmlPullParser.START_TAG && xpp.getName().equals("text"))
        res.setText(parseString(xpp));
      else
        throw new Exception("Bad Xml parsing Agent");
      eventType = nextNoWhitespace(xpp);
    }

    return res;
  }

  protected Sid parseSid(XmlPullParser xpp) throws Exception {
    Sid result = new Sid();
    parseTypeAttributes(xpp, result);
    result.setValue(parseURI(xpp));
    return result;
  }
  protected Decimal parseDecimal(XmlPullParser xpp) throws Exception {
    Decimal result = new Decimal();
    parseTypeAttributes(xpp, result);
    result.setValue(parseBigDecimal(xpp));
    return result;
  }
  protected Uri parseUri(XmlPullParser xpp) throws Exception {
    Uri result = new Uri();
    parseTypeAttributes(xpp, result);
    result.setValue(parseURI(xpp));
    return result;
  }
  protected Base64Binary parseBase64Binary(XmlPullParser xpp) throws Exception {
    Base64Binary result = new Base64Binary();
    parseTypeAttributes(xpp, result);
    result.setValue(parseBytes(xpp));
    return result;
  }
  protected Oid parseOid(XmlPullParser xpp) throws Exception {
    Oid result = new Oid();
    parseTypeAttributes(xpp, result);
    result.setValue(parseString(xpp));
    return result;
  }
  protected Uuid parseUuid(XmlPullParser xpp) throws Exception {
    Uuid result = new Uuid();
    parseTypeAttributes(xpp, result);
    result.setValue(parseString(xpp));
    return result;
  }
  
}