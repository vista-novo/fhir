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

// Generated on Sat, Nov 17, 2012 08:35+1100 for FHIR v0.06

import java.util.*;

/**
 * There is a variety of postal address formats defined around the world. This format defines a superset that is the basis for addresses all around the world 
 */
public class Address extends Type {

    public enum AddressUse {
        home, // A communication address at a home
        work, // An office address. First choice for business related contacts during business hours
        temp, // A temporary address. The period can provide more detailed information
        old; // This address is no longer in use (or was never correct, but retained for records)
        public static AddressUse fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("home".equals(codeString))
          return home;
        if ("work".equals(codeString))
          return work;
        if ("temp".equals(codeString))
          return temp;
        if ("old".equals(codeString))
          return old;
        throw new Exception("Unknown AddressUse code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case home: return "home";
            case work: return "work";
            case temp: return "temp";
            case old: return "old";
            default: return "?";
          }
        }
    }

    /**
     * Identifies the intended purpose of this address
     */
    private AddressUse use;

    /**
     * a full text representation of the address
     */
    private String_ text;

    /**
     * Part of an address line
     */
    private List<String_> part = new ArrayList<String_>();

    /**
     * A line of an address (typically used for street names & numbers, unit details, delivery hints, etc.) .
     */
    private List<String_> line = new ArrayList<String_>();

    /**
     * The name of the city, town, village, or other community or delivery centre.
     */
    private String_ city;

    /**
     * Sub-unit of a country with limited sovereignty in a federally organized country. A code may be used if codes are in common use (i.e. US 2 letter state codes).
     */
    private String_ state;

    /**
     * A postal code designating a region defined by the postal service.
     */
    private String_ zip;

    /**
     * Country. ISO 3166 3 letter codes can be used in place of a full country name.
     */
    private String_ country;

    /**
     * A value that uniquely identifies the postal address. (Often used in barcodes). 
     */
    private String_ dpid;

    /**
     * Time period when address was/is in use
     */
    private Period period;

    public AddressUse getUse() { 
      return this.use;
    }

    public void setUse(AddressUse value) { 
      this.use = value;
    }

    public String_ getText() { 
      return this.text;
    }

    public void setText(String_ value) { 
      this.text = value;
    }

    public List<String_> getPart() { 
      return this.part;
    }

    public List<String_> getLine() { 
      return this.line;
    }

    public String_ getCity() { 
      return this.city;
    }

    public void setCity(String_ value) { 
      this.city = value;
    }

    public String_ getState() { 
      return this.state;
    }

    public void setState(String_ value) { 
      this.state = value;
    }

    public String_ getZip() { 
      return this.zip;
    }

    public void setZip(String_ value) { 
      this.zip = value;
    }

    public String_ getCountry() { 
      return this.country;
    }

    public void setCountry(String_ value) { 
      this.country = value;
    }

    public String_ getDpid() { 
      return this.dpid;
    }

    public void setDpid(String_ value) { 
      this.dpid = value;
    }

    public Period getPeriod() { 
      return this.period;
    }

    public void setPeriod(Period value) { 
      this.period = value;
    }


}

