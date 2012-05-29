package org.hl7.fhir.instance.model;

// Copyright HL7 (http://hl7.org). Generated on Fri, May 18, 2012 22:20+1000 for FHIR v0.02

import java.util.*;

/**
 * Optional Extensions Element - found in all resources
 */
public class Extension extends Element {

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
     * If this element is set to true, then the resource data is only safe to process if the reader understands this extension. 
     */
    private boolean mustUnderstand;

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

    public boolean getMustUnderstand() { 
      return this.mustUnderstand;
    }

    public void setMustUnderstand(boolean value) { 
      this.mustUnderstand = value;
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

