package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

public class TypeDefn {
	private String name;
	private List<String> params = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getParams() {
		return params;
	}

	public boolean hasParams() {
		return params.size() > 0;
	}
  public String summary() {
    String s = name;
    if (hasParams()) {
      s = s + "(";
      for (String p : params)
        s = s + p+',';
      s = s.substring(0, s.length()-1)+')';
    }
    return s;
  }
  public String summaryFormal() {
    String s = name;
    if (hasParams()) {
      s = s + "(";
      for (String p : params)
        s = s + p+'|';
      s = s.substring(0, s.length()-1)+')';
    }
    return s;
  }
}
