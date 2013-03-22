package org.hl7.fhir.instance.formats;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Resource;

public abstract class ParserBase extends XmlBase {

  public class ResourceOrFeed {
    protected Resource resource;
    protected AtomFeed feed;
    public Resource getResource() {
      return resource;
    }
    public AtomFeed getFeed() {
      return feed;
    }
  }
  

  protected Map<String, Object> idMap = new HashMap<String, Object>();

//protected Element resolveElement(String id) {
//  return idMap.get(id);
//}


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
