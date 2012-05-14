package org.hl7.fhir.instance.model;

import java.util.*;

public class Resource extends Element {

	/**
	 * Master resource Id, in all resources
	 */
	private Id id;
	
	/**
	 * Extensions
	 */
	private List<Extension> extensions = new ArrayList<Extension>();
	
	/**
	 * Text summary of resource, for human interpretation
	 */
	private Narrative text;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Narrative getText() {
		return text;
	}

	public void setText(Narrative text) {
		this.text = text;
	}

	public List<Extension> getExtensions() {
		return extensions;
	}
	
	
}
