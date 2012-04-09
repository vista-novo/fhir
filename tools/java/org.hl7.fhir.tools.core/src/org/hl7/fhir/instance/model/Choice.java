package org.hl7.fhir.instance.model;

import java.util.*;

/**
 * A code taken from a short list of codes that are not defined in a formal code system
 */
public class Choice extends Type {

    public class Value extends Element {
        /**
         * A possible code or value that the user could have chosen
         */
        private String code;

        /**
         * A set of words associated with the code to give it meaning, if any exist
         */
        private String display;

        public String getCode() { 
          return this.code;
        }

        public void setCode(String value) { 
          this.code = value;
        }

        public String getDisplay() { 
          return this.display;
        }

        public void setDisplay(String value) { 
          this.display = value;
        }

    }

    /**
     * The code or value that the user selected from the list of possible codes
     */
    private String code;

    /**
     * A list of possible values for the code
     */
    private List<Value> value = new ArrayList<Value>();

    /**
     * Whether the order of the values has an assigned meaning
     */
    private boolean isOrdered;

    public String getCode() { 
      return this.code;
    }

    public void setCode(String value) { 
      this.code = value;
    }

    public List<Value> getValue() { 
      return this.value;
    }

    public boolean getIsOrdered() { 
      return this.isOrdered;
    }

    public void setIsOrdered(boolean value) { 
      this.isOrdered = value;
    }


}

