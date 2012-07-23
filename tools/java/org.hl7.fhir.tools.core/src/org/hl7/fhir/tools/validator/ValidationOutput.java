package org.hl7.fhir.tools.validator;

import java.io.OutputStreamWriter;

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
  
  
  
  
  
  public String getSource() {
    return source;
  }
  public void setSource(String source) {
    this.source = source;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public Strength getLevel() {
    return level;
  }
  public void setLevel(Strength level) {
    this.level = level;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String summary() {
    return level.toString()+": "+message+" @ "+location;
  }
  public void xml(OutputStreamWriter w) {
    // TODO Auto-generated method stub
    
  }
  
  
}
