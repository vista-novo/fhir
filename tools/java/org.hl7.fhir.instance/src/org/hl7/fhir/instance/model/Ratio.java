package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Thu, May 17, 2012 17:40+1000 for FHIR v0.02

/**
 * A ratio of two Quantity values - a numerator and a denominator. 
 */
public class Ratio extends Type {

    /**
     * The numerator
     */
    private Quantity numerator;

    /**
     * The denominator
     */
    private Quantity denominator;

    public Quantity getNumerator() { 
      return this.numerator;
    }

    public void setNumerator(Quantity value) { 
      this.numerator = value;
    }

    public Quantity getDenominator() { 
      return this.denominator;
    }

    public void setDenominator(Quantity value) { 
      this.denominator = value;
    }


}

