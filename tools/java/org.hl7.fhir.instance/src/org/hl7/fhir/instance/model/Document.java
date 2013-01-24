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

// Generated on Fri, Jan 25, 2013 00:43+1100 for FHIR v0.07

import java.util.*;

/**
 * A documentation of healthcare-related information that is assembled together into a single statement of meaning that establishes its own context. A document is composed of a set of resources that include both human and computer readable portions. A human may attest to the accuracy of the human readable portion and may authenticate and/or sign the entire whole. A document may be kept as a set of logically linked resources, or they may be bundled together in an atom feed
 */
public class Document extends Resource {

    public class Section extends Element {
        /**
         * A code identifying the kind of content contained within the section
         */
        private CodeableConcept code;

        /**
         * Identifies the primary subject of the section.  
         */
        private ResourceReference subject;

        /**
         * Identifies the discrete data that provides the content for the section.
         */
        private ResourceReference content;

        /**
         * Identifies a subtopic within the section as part of the document's table of contents
         */
        private List<Section> section = new ArrayList<Section>();

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public ResourceReference getSubject() { 
          return this.subject;
        }

        public void setSubject(ResourceReference value) { 
          this.subject = value;
        }

        public ResourceReference getContent() { 
          return this.content;
        }

        public void setContent(ResourceReference value) { 
          this.content = value;
        }

        public List<Section> getSection() { 
          return this.section;
        }

  }

    /**
     * Defines the medata and context for this document
     */
    private DocumentInformation information;

    /**
     * Identifies the document this document supersedes, if any.
     */
    private Id replaces;

    /**
     * Additional provenance about the document and the resources that are the sections
     */
    private List<ResourceReference> provenance = new ArrayList<ResourceReference>();

    /**
     * A fixed stylesheet to use when rendering the documents
     */
    private Attachment stylesheet;

    /**
     * An alternative representation of the document that can be used in place of the html based rendering
     */
    private Attachment representation;

    /**
     * Identifies a main topic within the document's table of contents
     */
    private List<Section> section = new ArrayList<Section>();

    public DocumentInformation getInformation() { 
      return this.information;
    }

    public void setInformation(DocumentInformation value) { 
      this.information = value;
    }

    public Id getReplaces() { 
      return this.replaces;
    }

    public void setReplaces(Id value) { 
      this.replaces = value;
    }

    public String getReplacesSimple() { 
      return this.replaces == null ? null : this.replaces.getValue();
    }

    public void setReplacesSimple(String value) { 
      if (value == null)
        this.replaces = null;
      else {
        if (this.replaces == null)
          this.replaces = new Id();
        this.replaces.setValue(value);
      }
    }

    public List<ResourceReference> getProvenance() { 
      return this.provenance;
    }

    public Attachment getStylesheet() { 
      return this.stylesheet;
    }

    public void setStylesheet(Attachment value) { 
      this.stylesheet = value;
    }

    public Attachment getRepresentation() { 
      return this.representation;
    }

    public void setRepresentation(Attachment value) { 
      this.representation = value;
    }

    public List<Section> getSection() { 
      return this.section;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Document;
   }


}

