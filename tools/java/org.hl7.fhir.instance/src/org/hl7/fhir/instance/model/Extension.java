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

// Generated on Fri, Jan 25, 2013 06:40+1100 for FHIR v0.07

import java.util.*;

import java.net.*;
/**
 * Optional Extensions Element - found in all resources
 */
public class Extension extends Element {

    /**
     * Source of the definition for the extension code - a logical name or a URL
     */
    private Uri url;

    /**
     * If this element is set to true, then the containing resource element and its children are only safe to process if the reader understands this extension. 
     */
    private Boolean mustUnderstand;

    /**
     * Value of extension - may be a resource or one of a constrained set of the data types (see Extensibility in the spec for list)
     */
    private org.hl7.fhir.instance.model.Type value;

    /**
     * Nested Complex extensions
     */
    private List<Extension> extension = new ArrayList<Extension>();

    public Uri getUrl() { 
      return this.url;
    }

    public void setUrl(Uri value) { 
      this.url = value;
    }

    public URI getUrlSimple() { 
      return this.url == null ? null : this.url.getValue();
    }

    public void setUrlSimple(URI value) { 
      if (value == null)
        this.url = null;
      else {
        if (this.url == null)
          this.url = new Uri();
        this.url.setValue(value);
      }
    }

    public Boolean getMustUnderstand() { 
      return this.mustUnderstand;
    }

    public void setMustUnderstand(Boolean value) { 
      this.mustUnderstand = value;
    }

    public boolean getMustUnderstandSimple() { 
      return this.mustUnderstand == null ? null : this.mustUnderstand.getValue();
    }

    public void setMustUnderstandSimple(boolean value) { 
      if (value == false)
        this.mustUnderstand = null;
      else {
        if (this.mustUnderstand == null)
          this.mustUnderstand = new Boolean();
        this.mustUnderstand.setValue(value);
      }
    }

    public org.hl7.fhir.instance.model.Type getValue() { 
      return this.value;
    }

    public void setValue(org.hl7.fhir.instance.model.Type value) { 
      this.value = value;
    }

    public List<Extension> getExtension() { 
      return this.extension;
    }


}

