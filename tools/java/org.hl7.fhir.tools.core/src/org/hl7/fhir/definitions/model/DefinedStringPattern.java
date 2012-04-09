package org.hl7.fhir.definitions.model;

public class DefinedStringPattern extends DefinedCode {
  private String regex;

  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

}
