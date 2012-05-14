package org.hl7.fhir.instance.model;

import java.net.URI;
import java.net.URISyntaxException;

public class FactoryBase {

  public static String_ newString_(String value) {
    String_ s = new String_();
    s.setValue(value);
    return s;
  }

  public static Id newId(String value) {
    Id s = new Id();
    s.setValue(value);
    return s;
   }
  
  public static Uri newUri(String value) throws URISyntaxException {
    Uri s = new Uri();
    s.setValue(new URI(value));
    return s;
  }
  
  public static DateTime newDateTime(String value) {
    DateTime s = new DateTime();
    s.setValue(value);
    return s;
  }
}
