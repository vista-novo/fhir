package org.hl7.fhir.instance.model;

// © HL7 (http://www.hl7.org)  Generated on 10:56 Apr 10, 2012 for FHIR v0.01

/**
 * A set of ordered values defined by a low and high limit. The values may be of type Quantity, date, or dateTime
 */
public class Interval<T extends Ordered> extends Type {

    /**
     * The low value. The boundary is inclusive.
     */
    private T low;

    /**
     * The high value. The boundary is inclusive. See discussion in specification regarding how the high value boundary is interpreted for dates
     */
    private T high;

    public T getLow() { 
      return this.low;
    }

    public void setLow(T value) { 
      this.low = value;
    }

    public T getHigh() { 
      return this.high;
    }

    public void setHigh(T value) { 
      this.high = value;
    }


}

