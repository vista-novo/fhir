package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Mon, May 14, 2012 23:22+1000 for FHIR v0.01

import java.util.*;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * A human readable formatted text, including images
 */
public class Narrative extends Element {

    public enum NarrativeStatus {
        generated, // The contents of the narrative are entirely generated from the structured data in the resource.
        extensions, // The contents of the narrative are entirely generated from the structured data in the resource, and some of the structured data is contained in extensions
        additional; // The contents of the narrative contain additional information not found in the structured data
        public static NarrativeStatus fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("generated".equals(code))
          return generated;
        if ("extensions".equals(code))
          return extensions;
        if ("additional".equals(code))
          return additional;
        throw new Exception("Unknown NarrativeStatus code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case generated: return "generated";
            case extensions: return "extensions";
            case additional: return "additional";
            default: return "?";
          }
        }
    }

    public enum NarrativeMapSource {
        text, // The text is the original data
        data; // The data is the original data
        public static NarrativeMapSource fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("text".equals(code))
          return text;
        if ("data".equals(code))
          return data;
        throw new Exception("Unknown NarrativeMapSource code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case text: return "text";
            case data: return "data";
            default: return "?";
          }
        }
    }

    public class Image extends Element {
        /**
         * mime type of image
         */
        private String mimeType;

        /**
         * base64 image data
         */
        private byte[] content;

        public String getMimeType() { 
          return this.mimeType;
        }

        public void setMimeType(String value) { 
          this.mimeType = value;
        }

        public byte[] getContent() { 
          return this.content;
        }

        public void setContent(byte[] value) { 
          this.content = value;
        }

    }

    public class Map extends Element {
        /**
         * The narrative end of the mapping
         */
        private String text;

        /**
         * The resource element end of the mapping
         */
        private String data;

        /**
         * Which end of the mapping is the source
         */
        private NarrativeMapSource source;

        public String getText() { 
          return this.text;
        }

        public void setText(String value) { 
          this.text = value;
        }

        public String getData() { 
          return this.data;
        }

        public void setData(String value) { 
          this.data = value;
        }

        public NarrativeMapSource getSource() { 
          return this.source;
        }

        public void setSource(NarrativeMapSource value) { 
          this.source = value;
        }

    }

    /**
     * The status of the narrative - whether it is entirely generated (from just the defined data or the extensions too), or whether a human authored it, and it may contain additional data
     */
    private NarrativeStatus status;

    /**
     * The actual narrative content, a stripped down version of XHTML
     */
    private XhtmlNode xhtml;

    /**
     * An image referred to directly in the xhtml
     */
    private List<Image> image = new ArrayList<Image>();

    /**
     * A map from the narrative contents to the resource elements - an assertion that the text describes the some content as the data item describes
     */
    private List<Map> map = new ArrayList<Map>();

    public NarrativeStatus getStatus() { 
      return this.status;
    }

    public void setStatus(NarrativeStatus value) { 
      this.status = value;
    }

    public XhtmlNode getXhtml() { 
      return this.xhtml;
    }

    public void setXhtml(XhtmlNode value) { 
      this.xhtml = value;
    }

    public List<Image> getImage() { 
      return this.image;
    }

    public List<Map> getMap() { 
      return this.map;
    }


}

