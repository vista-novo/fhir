package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

public class ResourceDefn extends ElementDefn {
   private List<Example> examples = new ArrayList<Example>();

  public List<Example> getExamples() {
    return examples;
  } 
   
}
