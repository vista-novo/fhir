package org.hl7.fhir.tools.core.model;

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
}
