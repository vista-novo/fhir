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

// Generated on Wed, Oct 3, 2012 17:55+1000 for FHIR v0.06

/**
 * For referring to data content defined in other formats.
 */
public class Attachment extends Type {

    /**
     * Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data
     */
    private String mimeType;

    /**
     * The actual data of the attachment - a sequence of bytes. In XML, represented using base64
     */
    private byte[] data;

    /**
     * An alternative location where the data can be accessed
     */
    private java.net.URI url;

    /**
     * The calculated hash of the data using SHA-256. In XML, represented using base64
     */
    private byte[] hash;

    /**
     * The language that the attachment is in
     */
    private String lang;

    /**
     * A label or set of text to display in place of the data
     */
    private String title;

    public String getMimeType() { 
      return this.mimeType;
    }

    public void setMimeType(String value) { 
      this.mimeType = value;
    }

    public byte[] getData() { 
      return this.data;
    }

    public void setData(byte[] value) { 
      this.data = value;
    }

    public java.net.URI getUrl() { 
      return this.url;
    }

    public void setUrl(java.net.URI value) { 
      this.url = value;
    }

    public byte[] getHash() { 
      return this.hash;
    }

    public void setHash(byte[] value) { 
      this.hash = value;
    }

    public String getLang() { 
      return this.lang;
    }

    public void setLang(String value) { 
      this.lang = value;
    }

    public String getTitle() { 
      return this.title;
    }

    public void setTitle(String value) { 
      this.title = value;
    }


}

