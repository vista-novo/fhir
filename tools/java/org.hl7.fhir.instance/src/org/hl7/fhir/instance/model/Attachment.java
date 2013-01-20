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

// Generated on Sun, Jan 20, 2013 20:00+1100 for FHIR v0.07

/**
 * For referring to data content defined in other formats.
 */
public class Attachment extends Type {

    /**
     * Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data. Includes mime type parameters such as charset where appropriate
     */
    private Code contentType;

    /**
     * The actual data of the attachment - a sequence of bytes. In XML, represented using base64
     */
    private Base64Binary data;

    /**
     * An alternative location where the data can be accessed
     */
    private Uri url;

    /**
     * The number of bytes of data that make up this attachment.
     */
    private Integer size;

    /**
     * The calculated hash of the data using SHA-1. Represented using base64
     */
    private Base64Binary hash;

    /**
     * A label or set of text to display in place of the data
     */
    private String_ title;

    public Code getContentType() { 
      return this.contentType;
    }

    public void setContentType(Code value) { 
      this.contentType = value;
    }

    public Base64Binary getData() { 
      return this.data;
    }

    public void setData(Base64Binary value) { 
      this.data = value;
    }

    public Uri getUrl() { 
      return this.url;
    }

    public void setUrl(Uri value) { 
      this.url = value;
    }

    public Integer getSize() { 
      return this.size;
    }

    public void setSize(Integer value) { 
      this.size = value;
    }

    public Base64Binary getHash() { 
      return this.hash;
    }

    public void setHash(Base64Binary value) { 
      this.hash = value;
    }

    public String_ getTitle() { 
      return this.title;
    }

    public void setTitle(String_ value) { 
      this.title = value;
    }


}

