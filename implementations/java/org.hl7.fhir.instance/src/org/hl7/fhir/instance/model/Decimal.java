/**
 * 
 */
package org.hl7.fhir.instance.model;

import java.math.BigDecimal;

/**
 * @author Grahame
 *
 */
public class Decimal extends Ordered {

	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	} 
	
}
