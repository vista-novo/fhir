package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A concept domain - a use of terminology in FHIR.
 * A concept domain has a name, a definition, and information about what is in it (bindingType and binding/details, and maybe a list of defined codes) 
 * 
 * Technically, a concept domain is a facade on the full model in the core principles
 * 
 * @author Grahame
 *
 */
public class ConceptDomain {
  
  public enum BindingType {
    Unbound,
    CodeList,
    Reference,
    Preferred,
    Suggestion,
    Special, 
    External
  }

  
	private String name;
	private String definition;
	private BindingType bindingType;
	private String binding;
	private String details;
  private List<DefinedCode> codes = new ArrayList<DefinedCode>();
	
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
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
