package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Mon, May 14, 2012 02:13+1000 for FHIR v0.01

import java.util.*;

/**
 * A concept that may be defined by a formal reference to a terminology or ontology, or may be provided by text
 */
public class CodeableConcept extends Type {

    /**
     * A reference to a code defined by a terminology system 
     */
    private List<Coding> coding = new ArrayList<Coding>();

    /**
     * A human language representation of the concept as seen/selected/uttered by the user who entered the data, and/or which represents the intended meaning of the user or concept
     */
    private String text;

    /**
     * Indicates which of the codes in the codings was chosen by a user, if one was chosen directly
     */
    private String primary;

    public List<Coding> getCoding() { 
      return this.coding;
    }

    public String getText() { 
      return this.text;
    }

    public void setText(String value) { 
      this.text = value;
    }

    public String getPrimary() { 
      return this.primary;
    }

    public void setPrimary(String value) { 
      this.primary = value;
    }


}

