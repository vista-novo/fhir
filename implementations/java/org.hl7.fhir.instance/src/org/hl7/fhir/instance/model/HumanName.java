package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Mon, May 14, 2012 11:22+1000 for FHIR v0.01

import java.util.*;

/**
 * A name of a human, or a name given to an animal by a human.
 */
public class HumanName extends Type {

    public enum NameUse {
        usual, // Known as/conventional/the one you normally use
        official, // The formal name as registered in an official (government) registry, but which name might not be commonly used. May be called legal name.
        temp, // A temporary name. A name valid time can provide more detailed information. This may also be used for temporary names assigned at birth or in emergency situations.
        anonymous, // Anonymous assigned name, alias, or pseudonym (used to protect a person's identity for privacy reasons)
        old, // This name is no longer in use (or was never correct, but retained for records)
        maiden; // A name used prior to marriage. Marriage naming customs vary greatly around the world. This name use is for use by applications that collect and store maiden names. Though the concept of maiden name is often gender specific, the use of this term is not gender specific. The use of this term does not imply any particular history for a person‘s name, nor should the maiden name be determined algorithmically
        public static NameUse fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("usual".equals(code))
          return usual;
        if ("official".equals(code))
          return official;
        if ("temp".equals(code))
          return temp;
        if ("anonymous".equals(code))
          return anonymous;
        if ("old".equals(code))
          return old;
        if ("maiden".equals(code))
          return maiden;
        throw new Exception("Unknown NameUse code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case usual: return "usual";
            case official: return "official";
            case temp: return "temp";
            case anonymous: return "anonymous";
            case old: return "old";
            case maiden: return "maiden";
            default: return "?";
          }
        }
    }

    public enum NamePartType {
        family, // Family name, this is the name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first name of his father.
        given, // Given name. NOTE Not to be called first name since given names do not always come first. .
        title; // Part of the name that is acquired as a title due to academic, legal, employment or nobility status etc. NOTE Title name parts include name parts that come after the name, such as qualifications.
        public static NamePartType fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("family".equals(code))
          return family;
        if ("given".equals(code))
          return given;
        if ("title".equals(code))
          return title;
        throw new Exception("Unknown NamePartType code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case family: return "family";
            case given: return "given";
            case title: return "title";
            default: return "?";
          }
        }
    }

    public class Part extends Element {
        /**
         * Type of name part
         */
        private NamePartType type;

        /**
         * The content of the name part
         */
        private String value;

        public NamePartType getType() { 
          return this.type;
        }

        public void setType(NamePartType value) { 
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
     * The use of this name
     */
    private NameUse use;

    /**
     * a full text representation of the name
     */
    private String text;

    /**
     * A part of a name
     */
    private List<Part> part = new ArrayList<Part>();

    /**
     * Time period when name was/is in use
     */
    private Interval<DateTime> period;

    public NameUse getUse() { 
      return this.use;
    }

    public void setUse(NameUse value) { 
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

