package org.hl7.fhir.definitions;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Config {

  public static final boolean SUPPRESS_WRAPPER_ELEMENTS = true;
  public static final boolean SHOW_SINGLE_CARDINALITIES = false;
  public static final SimpleDateFormat DATE_FORMAT() {
    return new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US"));
  }

}
