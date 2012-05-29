package org.hl7.fhir.instance.model;

// Copyright HL7 (http://hl7.org). Generated on Fri, May 18, 2012 22:20+1000 for FHIR v0.02

/**
 * A technical identifier - identifies some entity uniquely and unambiguously
 */
public class Identifier extends Type {

    /**
     * Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data
     */
    private java.net.URI system;

    /**
     * The actual data of the attachment
     */
    private String id;

    public java.net.URI getSystem() { 
      return this.system;
    }

    public void setSystem(java.net.URI value) { 
      this.system = value;
    }

    public String getId() { 
      return this.id;
    }

    public void setId(String value) { 
      this.id = value;
    }


}

