package org.hl7.fhir.instance.model;

import java.util.*;

/**
 * A concept that may be defined by a formal reference to a terminology or ontology, or may be provided by text
 */
public class CodeableConcept extends Type {

    public class Coding extends Element {
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

