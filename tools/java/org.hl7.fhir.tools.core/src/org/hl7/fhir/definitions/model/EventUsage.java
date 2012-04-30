package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

public class EventUsage {

  private String notes;
  private List<String> requestResources = new ArrayList<String>();
  private List<String> requestAggregations = new ArrayList<String>();
  private List<String> responseResources = new ArrayList<String>();
  private List<String> responseAggregations = new ArrayList<String>();
  
  public String getNotes() {
    return notes;
  }
  public void setNotes(String notes) {
    this.notes = notes;
  }
  public List<String> getRequestResources() {
    return requestResources;
  }
  public List<String> getRequestAggregations() {
    return requestAggregations;
  }
  public List<String> getResponseResources() {
    return responseResources;
  }
  public List<String> getResponseAggregations() {
    return responseAggregations;
  }
  
}
