package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

public class ResourceDefn extends ElementDefn {
   private List<Example> examples = new ArrayList<Example>();
   private boolean sandbox;

  public List<Example> getExamples() {
    return examples;
  }

  public boolean isSandbox() {
    return sandbox;
  }

  public void setSandbox(boolean sandbox) {
    this.sandbox = sandbox;
  } 
   
}
