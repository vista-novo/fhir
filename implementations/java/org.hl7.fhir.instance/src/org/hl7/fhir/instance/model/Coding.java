package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on 19:37 Apr 30, 2012 for FHIR v0.01

/**
 * A reference to a code defined by a terminology system 
 */
public class Coding extends Type {

    /**
     * A symbol in syntax defined by the system. The symbol may be a predefined code, or an expression in a syntax defined by the coding system
     */
    private String code;

    /**
     * The identification of the system that defines the meaning of the symbol in the code. Can be a simple list of enumerations, a list of codes with meanings, or all the way to a complex semantic web such as SNOMED-CT, whether classification, terminology, or ontology
     */
    private java.net.URI system;

    /**
     * A representation of the meaning of the code in the system, following the rules laid out by the system. 
     */
    private String display;

    public String getCode() { 
      return this.code;
    }

    public void setCode(String value) { 
      this.code = value;
    }

    public java.net.URI getSystem() { 
      return this.system;
    }

    public void setSystem(java.net.URI value) { 
      this.system = value;
    }

    public String getDisplay() { 
      return this.display;
    }

    public void setDisplay(String value) { 
      this.display = value;
    }


}

