package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {


  private List<ElementDefn> resources = new ArrayList<ElementDefn>();
  private Map<String, ArrayList<String>> metadata = new HashMap<String, ArrayList<String>>();
  
  public Map<String, ArrayList<String>> getMetadata() {
    return metadata;
  }

  public List<ElementDefn> getResources() {
    return resources;
  }


  
  
}
