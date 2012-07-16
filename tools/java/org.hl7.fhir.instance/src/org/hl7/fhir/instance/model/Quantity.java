package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2012, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Mon, Jul 16, 2012 14:43+1000 for FHIR v0.04

/**
 * A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies
 */
public class Quantity extends Type {

    public enum QuantityRange {
        lessThan, // The actual value is less than the given value
        lessOrEqual, // The actual value is less than or equal to the given value
        greaterOrEqual, // The actual value is greater than or equal to the given value
        greaterThan; // The actual value is greater than the given value
        public static QuantityRange fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("<".equals(codeString))
          return lessThan;
        if ("<=".equals(codeString))
          return lessOrEqual;
        if (">=".equals(codeString))
          return greaterOrEqual;
        if (">".equals(codeString))
          return greaterThan;
        throw new Exception("Unknown QuantityRange code '"+codeString+"'");
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
     * How the value should be understood and represented - whether the actual value is greater or less than the measure due to measurement issues
     */
    private QuantityRange range;

    /**
     * A human readable form of the units
     */
    private String units;

    /**
     * A computer processable form of the units in some unit representation system
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

    public QuantityRange getRange() { 
      return this.range;
    }

    public void setRange(QuantityRange value) { 
      this.range = value;
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

