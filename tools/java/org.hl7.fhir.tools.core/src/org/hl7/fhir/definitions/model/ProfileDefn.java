package org.hl7.fhir.definitions.model;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.hl7.fhir.instance.model.Id;

public class ProfileDefn {


  private List<ElementDefn> resources = new ArrayList<ElementDefn>();
  private Map<String, ArrayList<String>> metadata = new HashMap<String, ArrayList<String>>();
  
  public Map<String, ArrayList<String>> getMetadata() {
    return metadata;
  }

  public List<ElementDefn> getResources() {
    return resources;
  }

  public String metadata(String name) {
    if (!metadata.containsKey(name))
      return "";
    ArrayList<String> a = metadata.get(name);
    if (a.size() == 1) 
      return a.get(0);
    else
      return "";
  }

  public boolean hasMetadata(String name) {
    String s = metadata(name);
    return (s != null && !s.equals(""));
  }

  public void putMetadata(String name, String value) {
    ArrayList<String> a;
    if (metadata.containsKey(name))
      a = metadata.get(name);
    else {
      a = new ArrayList<String>();
      metadata.put(name, a);
    }
    a.add(value);
  }


  
  
}
