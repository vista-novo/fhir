package org.hl7.fhir.tools.core.model;

import java.util.ArrayList;
import java.util.List;

public class ConceptDomain {
	private String name;
	private String definition;
	private BindingType bindingType;
	private String binding;
	private String details;
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	private List<DefinedCode> codes = new ArrayList<DefinedCode>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefinition() {
		return definition;
	}
	public List<DefinedCode> getCodes() {
		return codes;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public BindingType getBindingType() {
		return bindingType;
	}
	public void setBindingType(BindingType binding) {
		this.bindingType = binding;
	}
	public String getBinding() {
		return binding;
	}
	public void setBinding(String binding) {
		this.binding = binding;
	}
	
	

}
