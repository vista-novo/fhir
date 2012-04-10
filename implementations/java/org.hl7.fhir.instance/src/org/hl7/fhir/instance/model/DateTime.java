/**
 * 
 */
package org.hl7.fhir.instance.model;

/**
 * @author Grahame
 *
 */
public class DateTime extends Ordered {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
