package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

public class EventDefn {

  private String code;
  private String definition;
  private List<EventUsage> usages = new ArrayList<EventUsage>();
  private List<String> followUps = new ArrayList<String>();
  
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getDefinition() {
    return definition;
  }
  public void setDefinition(String definition) {
    this.definition = definition;
  }
  public List<EventUsage> getUsages() {
    return usages;
  }
  public List<String> getFollowUps() {
    return followUps;
  }
  
  
  
}
