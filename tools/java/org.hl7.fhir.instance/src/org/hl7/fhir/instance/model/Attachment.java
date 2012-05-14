package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Mon, May 14, 2012 23:22+1000 for FHIR v0.01

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
     * A name to display in place of the data
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

