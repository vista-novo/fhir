package org.hl7.fhir.tools.core.model;

public enum Conformance {
  Unstated,
  Mandatory,
  Conditional,
  Optional,
  Prohibited;

  public String code() {
		switch (this) {
		case Unstated: return "";
		case Mandatory: return "mand";
		case Conditional: return "cond";
		case Optional: return "opt";
		case Prohibited: return "prohibited";
		default: 
			return "";
		}
	}
  
  public String fullName() {
		switch (this) {
		case Unstated: return "";
		case Mandatory: return "Mandatory";
		case Conditional: return "Conditional";
		case Optional: return "Optional";
		case Prohibited: return "Prohibited";
		default: 
			return "";
		}
	}
  
}
