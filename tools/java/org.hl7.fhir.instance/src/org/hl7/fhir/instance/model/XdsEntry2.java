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

// Generated on Thu, Jan 31, 2013 23:34+1100 for FHIR v0.07

import java.util.*;

/**
 * An entry in an XDS registry
 */
public class XdsEntry2 extends Resource {

    public enum XdsEntryAvailability {
        Approved, // 
        Deprecated, // 
        Null; // added to help the parsers
        public static XdsEntryAvailability fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Approved".equals(codeString))
          return Approved;
        if ("Deprecated".equals(codeString))
          return Deprecated;
        throw new Exception("Unknown XdsEntryAvailability code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case Approved: return "Approved";
            case Deprecated: return "Deprecated";
            default: return "?";
          }
        }
    }

  public class XdsEntryAvailabilityEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Approved".equals(codeString))
          return XdsEntryAvailability.Approved;
        if ("Deprecated".equals(codeString))
          return XdsEntryAvailability.Deprecated;
        throw new Exception("Unknown XdsEntryAvailability code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == XdsEntryAvailability.Approved)
        return "Approved";
      if (code == XdsEntryAvailability.Deprecated)
        return "Deprecated";
      return "?";
      }
    }

    /**
     * Document identifier as assigned by the source of the document. This identifier is version specific. This unique identifier may be used in the body of other Documents etc. to reference this document.
     */
    private Identifier id;

    /**
     * Document metadata that is used for searching for the document
     */
    private DocumentInformation information;

    /**
     * Code globally uniquely specifying the format of the document. Along with the information.type, it should provide sufficient information to allow any potential Document Consumer to know if it will be able to process the document. The formatCode shall be sufficiently specific to ensure processing/display by identifying a document encoding, structure and template (e.g., for a CDA Document, the fact that it complies with a CDA schema, possibly a template and the choice of a content-specific style sheet).
     */
    private Coding format;

    /**
     * Deprecated documents can be included in some responses
     */
    private Enumeration<XdsEntryAvailability> availability;

    /**
     * Folders that this document is registered in
     */
    private List<ResourceReference> folder = new ArrayList<ResourceReference>();

    /**
     * The subject of care information that the document is about. This is different from the documentInformation.subject because that never changes from what the document says. This value may be updated if the subject details are updated (e.g. merged) and will then differ from the original document
     */
    private ResourceReference subject;

    /**
     * Reference to the content, along with additional information such as size, hash, language etc.
     */
    private Attachment content;

    public Identifier getId() { 
      return this.id;
    }

    public void setId(Identifier value) { 
      this.id = value;
    }

    public DocumentInformation getInformation() { 
      return this.information;
    }

    public void setInformation(DocumentInformation value) { 
      this.information = value;
    }

    public Coding getFormat() { 
      return this.format;
    }

    public void setFormat(Coding value) { 
      this.format = value;
    }

    public Enumeration<XdsEntryAvailability> getAvailability() { 
      return this.availability;
    }

    public void setAvailability(Enumeration<XdsEntryAvailability> value) { 
      this.availability = value;
    }

    public XdsEntryAvailability getAvailabilitySimple() { 
      return this.availability == null ? null : this.availability.getValue();
    }

    public void setAvailabilitySimple(XdsEntryAvailability value) { 
      if (value == null)
        this.availability = null;
      else {
        if (this.availability == null)
          this.availability = new Enumeration<XdsEntryAvailability>();
        this.availability.setValue(value);
      }
    }

    public List<ResourceReference> getFolder() { 
      return this.folder;
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public Attachment getContent() { 
      return this.content;
    }

    public void setContent(Attachment value) { 
      this.content = value;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.XdsEntry2;
   }


}

