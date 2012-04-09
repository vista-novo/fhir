package org.hl7.fhir.definitions.model;

public class DefinedCode {

	private String code;
	private String definition;
	private String comment;
	
	public DefinedCode(String code, String definition, String comment) {
		super();
		this.code = code;
		this.definition = definition;
		this.comment = comment;
	}
	
	public DefinedCode() {
		super();
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public boolean hasDefinition() {
		return definition != null && !definition.equals("");
	}
	public boolean hasComment() {
		return comment != null && !comment.equals("");
	}
}
