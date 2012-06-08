package org.hl7.fhir.instance.model;

public abstract class Type extends Element {

	/**
	 * dataAbsentReason is defined here because it is used in many places that use this Type - but not all. 
	 * This can only be used in some places - consult the specification for further details
	 */
	private DataAbsentReason dataAbsentReason;
	
	public DataAbsentReason getDataAbsentReason() {
		return dataAbsentReason;
	}

	public void setDataAbsentReason(DataAbsentReason dataAbsentReason) {
		this.dataAbsentReason = dataAbsentReason;
	}

}
