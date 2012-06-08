/**
 * 
 */
package org.hl7.fhir.instance.model;

import java.util.Date;

/**
 * @author Grahame
 *
 */
public class Instant extends Ordered {

	private Date value;

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	} 
	
}
