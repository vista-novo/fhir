package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on 23:50 Apr 10, 2012 for FHIR v0.01

import java.util.*;

/**
 * Optional Extensions Element - found in all resources
 */
public class Extension extends Element {

    public enum ExtensionState {
        mustMinusunderstand, // The extension contains information that qualifies or negates another element, and must be understood by an application process the resource
        superceded; // The extension has been promoted into the main content of the resource, and the content is found at the reference. The extension continues to be defined for backward compatibility
        public static ExtensionState fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("must-understand".equals(code))
          return mustMinusunderstand;
        if ("superceded".equals(code))
          return superceded;
        throw new Exception("Unknown ExtensionState code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case mustMinusunderstand: return "must-understand";
            case superceded: return "superceded";
            default: return "?";
          }
        }
    }

    /**
     * The code that identifies the meaning of the extension by reference to the definitions
     */
    private String code;

    /**
     * Source of the definition for the code - a namespace or a URL
     */
    private java.net.URI definition;

    /**
     * Internal reference to context of the extension - a pointer to an xml:id in the same resource
     */
    private String ref;

    /**
     * The state or the extension - whether readers must must understand, or whether it's superceded by being defined in the resource
     */
    private ExtensionState state;

    /**
     * Value of extension - any of the types defined in the data types
     */
    private Type value;

    /**
     * Nested Extensions - further extensions that are part of the extension
     */
    private List<Extension> extension = new ArrayList<Extension>();

    public String getCode() { 
      return this.code;
    }

    public void setCode(String value) { 
      this.code = value;
    }

    public java.net.URI getDefinition() { 
      return this.definition;
    }

    public void setDefinition(java.net.URI value) { 
      this.definition = value;
    }

    public String getRef() { 
      return this.ref;
    }

    public void setRef(String value) { 
      this.ref = value;
    }

    public ExtensionState getState() { 
      return this.state;
    }

    public void setState(ExtensionState value) { 
      this.state = value;
    }

    public Type getValue() { 
      return this.value;
    }

    public void setValue(Type value) { 
      this.value = value;
    }

    public List<Extension> getExtension() { 
      return this.extension;
    }


}

