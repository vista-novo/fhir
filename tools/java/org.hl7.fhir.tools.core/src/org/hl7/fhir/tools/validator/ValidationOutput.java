package org.hl7.fhir.tools.validator;

public class ValidationOutput {

  public enum Strength {
    Fatal,
    Error,
    Warning,
    Hint,
    Limitation
  }
  
  private String source;
  private String location;
  private Strength level;
  private String message;
}
