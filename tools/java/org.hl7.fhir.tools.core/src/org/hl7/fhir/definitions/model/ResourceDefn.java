package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDefn extends ElementDefn {
   private List<Example> examples = new ArrayList<Example>();
   private Map<String, Invariant> invariants = new HashMap<String, Invariant>();
   
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

  public Map<String, Invariant> getInvariants() {
    return invariants;
  } 
   
}
