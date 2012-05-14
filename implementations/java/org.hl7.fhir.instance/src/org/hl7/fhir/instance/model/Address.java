package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Mon, May 14, 2012 11:09+1000 for FHIR v0.01

import java.util.*;

/**
 * There is a variety of postal address formats defined around the world. This format defines a superset that is the basis for addresses all around the world 
 */
public class Address extends Type {

    public enum AddressUse {
        home, // A communication address at a home.
        work, // An office address. First choice for business related contacts during business hours.
        temp, // A temporary address. The period can provide more detailed information.
        old; // This address is no longer in use (or was never correct, but retained for records)
        public static AddressUse fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("home".equals(code))
          return home;
        if ("work".equals(code))
          return work;
        if ("temp".equals(code))
          return temp;
        if ("old".equals(code))
          return old;
        throw new Exception("Unknown AddressUse code '"+code+"'");
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

    public enum AddressPartType {
        part, // Part of an address line (typically used with an extension that further defines the meaning of the part).
        line, // A line of an address (typically used for street names & numbers, unit details, delivery hints etc) .
        city, // The name of the city, town, village, or other community or delivery centre.
        state, // sub-unit of a country with limited sovereignty in a federally organized country. A code may be used if codes are in common use (i.e. US 2 letter state codes).
        country, // Country. ISO 3166 3 letter codes can be used in place of a full country name.
        zip, // A postal code designating a region defined by the postal service.
        dpid; // A value that uniquely identifies the postal address. (often used in barcodes).
        public static AddressPartType fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("part".equals(code))
          return part;
        if ("line".equals(code))
          return line;
        if ("city".equals(code))
          return city;
        if ("state".equals(code))
          return state;
        if ("country".equals(code))
          return country;
        if ("zip".equals(code))
          return zip;
        if ("dpid".equals(code))
          return dpid;
        throw new Exception("Unknown AddressPartType code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case part: return "part";
            case line: return "line";
            case city: return "city";
            case state: return "state";
            case country: return "country";
            case zip: return "zip";
            case dpid: return "dpid";
            default: return "?";
          }
        }
    }

    public class Part extends Element {
        /**
         * Type of address part (see below)
         */
        private AddressPartType type;

        /**
         * The content of the address part
         */
        private String value;

        public AddressPartType getType() { 
          return this.type;
        }

        public void setType(AddressPartType value) { 
          this.type = value;
        }

        public String getValue() { 
          return this.value;
        }

        public void setValue(String value) { 
          this.value = value;
        }

    }

    /**
     * The use of this address
     */
    private AddressUse use;

    /**
     * a full text representation of the address
     */
    private String text;

    /**
     * A part of an address
     */
    private List<Part> part = new ArrayList<Part>();

    /**
     * Time period when address was/is in use
     */
    private Interval<DateTime> period;

    public AddressUse getUse() { 
      return this.use;
    }

    public void setUse(AddressUse value) { 
      this.use = value;
    }

    public String getText() { 
      return this.text;
    }

    public void setText(String value) { 
      this.text = value;
    }

    public List<Part> getPart() { 
      return this.part;
    }

    public Interval<DateTime> getPeriod() { 
      return this.period;
    }

    public void setPeriod(Interval<DateTime> value) { 
      this.period = value;
    }


}

