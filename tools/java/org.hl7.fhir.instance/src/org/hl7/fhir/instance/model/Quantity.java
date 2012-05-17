package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Thu, May 17, 2012 17:40+1000 for FHIR v0.02

/**
 * A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitary units, and floating currencies
 */
public class Quantity extends Ordered {

    public enum QuantityStatus {
        lessThan, // The actual value is less than the given value
        lessOrEqual, // The actual value is less than or equal to the given value
        greaterOrEqual, // The actual value is greater than or equal to the given value
        greaterThan; // The actual value is greater than the given value
        public static QuantityStatus fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("<".equals(code))
          return lessThan;
        if ("<=".equals(code))
          return lessOrEqual;
        if (">=".equals(code))
          return greaterOrEqual;
        if (">".equals(code))
          return greaterThan;
        throw new Exception("Unknown QuantityStatus code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case lessThan: return "<";
            case lessOrEqual: return "<=";
            case greaterOrEqual: return ">=";
            case greaterThan: return ">";
            default: return "?";
          }
        }
    }

    /**
     * The value of the measured amount. The value includes an implicit precision in the presentation of the value
     */
    private java.math.BigDecimal value;

    /**
     * how the value should be understood and represented - whether the actual value is greater or less than the mesaure due to measurement issues
     */
    private QuantityStatus status;

    /**
     * A human readable form of the units
     */
    private String units;

    /**
     * A computer processible form of the units in some unit representation system
     */
    private String code;

    /**
     * The identification of the system that provides the coded form of the unit
     */
    private java.net.URI system;

    public java.math.BigDecimal getValue() { 
      return this.value;
    }

    public void setValue(java.math.BigDecimal value) { 
      this.value = value;
    }

    public QuantityStatus getStatus() { 
      return this.status;
    }

    public void setStatus(QuantityStatus value) { 
      this.status = value;
    }

    public String getUnits() { 
      return this.units;
    }

    public void setUnits(String value) { 
      this.units = value;
    }

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


}

