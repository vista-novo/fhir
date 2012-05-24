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
public class BindingSpecification {
  
  public enum Binding {
    Unbound,
    CodeList, 
    ValueSet,
    Reference,
    Special
  }
  
  public enum BindingStrength {
    Unstated,
    Required,
    Preferred,
    Suggested
  }

  
  private String id;
  private String name;
	private String definition;
	private Binding binding;
  private BindingStrength bindingStrength;
	private String reference;
	private String description;
	private String source; // for useful error messages during build
	
  private List<DefinedCode> codes = new ArrayList<DefinedCode>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public void setDefinition(String definition) {
    this.definition = definition;
  }

  public Binding getBinding() {
    return binding;
  }

  public void setBinding(Binding binding) {
    this.binding = binding;
  }

  public BindingStrength getBindingStrength() {
    return bindingStrength;
  }

  public void setBindingStrength(BindingStrength bindingStrength) {
    this.bindingStrength = bindingStrength;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<DefinedCode> getCodes() {
    return codes;
  }
	
	public boolean hasReference() {
	  return !(reference == null || reference.equals(""));
	}

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

}
