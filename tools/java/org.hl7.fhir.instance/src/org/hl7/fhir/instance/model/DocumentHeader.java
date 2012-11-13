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

// Generated on Tue, Nov 13, 2012 15:23+1100 for FHIR v0.06

import java.util.*;

/**
 * A documentation of healthcare-related information that is assembled together into a single statement of meaning that establishes its own context. A document is composed of a set of resources that include both human and computer readable portions. A human may attest to the accuracy of the human readable portion, and may authenticate and/or sign the entire whole. A document may be kept as a set of logically linked resources, or they may be bundled together in an atom feed
 */
public class DocumentHeader extends Resource {

    public enum DocumentAuthenticationMode {
        personal, // The person authenticated the document in their personal capacity
        professional, // The person authenticated the document in their professional capacity
        legal, // The person authenticated the document and accepted legal responsibility for its content
        official; // The organization authenticated the document as consistent with their policies and procedures
        public static DocumentAuthenticationMode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("personal".equals(codeString))
          return personal;
        if ("professional".equals(codeString))
          return professional;
        if ("legal".equals(codeString))
          return legal;
        if ("official".equals(codeString))
          return official;
        throw new Exception("Unknown DocumentAuthenticationMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case personal: return "personal";
            case professional: return "professional";
            case legal: return "legal";
            case official: return "official";
            default: return "?";
          }
        }
    }

    public class Attester extends Element {
        /**
         * The type of attestation the authenticator offers
         */
        private DocumentAuthenticationMode mode;

        /**
         * When document was attested by the party
         */
        private DateTime time;

        /**
         * Who attested the document in the specified way
         */
        private ResourceReference party;

        public DocumentAuthenticationMode getMode() { 
          return this.mode;
        }

        public void setMode(DocumentAuthenticationMode value) { 
          this.mode = value;
        }

        public DateTime getTime() { 
          return this.time;
        }

        public void setTime(DateTime value) { 
          this.time = value;
        }

        public ResourceReference getParty() { 
          return this.party;
        }

        public void setParty(ResourceReference value) { 
          this.party = value;
        }

    }

    public class Section extends Element {
        /**
         * A code identifying the kind of content contained within the section
         */
        private CodeableConcept type;

        /**
         * Identifies when the content of the section was created
         */
        private Instant instant;

        /**
         * Identifies who is responsible for the information in the section.  (Not necessarily who typed it in.)
         */
        private ResourceReference author;

        /**
         * The person or device that performed the data entry leading to this section. Where there is more than one candidate, pick the most proximal to the document creation. 
         */
        private ResourceReference enterer;

        /**
         * Identifies the primary subject of the section.  
         */
        private ResourceReference subject;

        /**
         * Identifies the source that recounted the information recorded
         */
        private ResourceReference informant;

        /**
         * Identifies the discrete data that provides the content for the section.
         */
        private ResourceReference content;

        /**
         * Provides the text view of the section.
         */
        private Narrative text;

        /**
         * Identifies a subtopic within the section as part of the document's table of contents
         */
        private List<Section> section = new ArrayList<Section>();

        public CodeableConcept getType() { 
          return this.type;
        }

        public void setType(CodeableConcept value) { 
          this.type = value;
        }

        public Instant getInstant() { 
          return this.instant;
        }

        public void setInstant(Instant value) { 
          this.instant = value;
        }

        public ResourceReference getAuthor() { 
          return this.author;
        }

        public void setAuthor(ResourceReference value) { 
          this.author = value;
        }

        public ResourceReference getEnterer() { 
          return this.enterer;
        }

        public void setEnterer(ResourceReference value) { 
          this.enterer = value;
        }

        public ResourceReference getSubject() { 
          return this.subject;
        }

        public void setSubject(ResourceReference value) { 
          this.subject = value;
        }

        public ResourceReference getInformant() { 
          return this.informant;
        }

        public void setInformant(ResourceReference value) { 
          this.informant = value;
        }

        public ResourceReference getContent() { 
          return this.content;
        }

        public void setContent(ResourceReference value) { 
          this.content = value;
        }

        public Narrative getText() { 
          return this.text;
        }

        public void setText(Narrative value) { 
          this.text = value;
        }

        public List<Section> getSection() { 
          return this.section;
        }

    }

    /**
     * the document creation time, when the document first came into being. Where the CDA document is a transform from an original document in some other format, the ClinicalDocument.effectiveTime is the time the original document is created.
     */
    private Instant instant;

    /**
     * Specifying the particular kind of document (e.g. History and Physical, Discharge Summary, Progress Note)
     */
    private CodeableConcept type;

    /**
     * Official human-readable label for the document
     */
    private String_ title;

    /**
     * Identifies the document this document supersedes, if any.
     */
    private Id replaces;

    /**
     * The person or device that performed the data entry leading to this document. Where there is more than one candidate, pick the most proximal to the document creation or capture on a per-section basis. 
     */
    private ResourceReference enterer;

    /**
     * Identifies the primary subject of the document.  
     */
    private ResourceReference subject;

    /**
     * Identifies the source that recounted the information recorded
     */
    private ResourceReference informant;

    /**
     * Identifies who is responsible for the information in the document.  (Not necessarily who typed it in.)
     */
    private List<ResourceReference> author = new ArrayList<ResourceReference>();

    /**
     * A participant who has attested to the accuracy of the document
     */
    private List<Attester> attester = new ArrayList<Attester>();

    /**
     * Identifies the people and organisations for whom the document is intended
     */
    private List<ResourceReference> recipient = new ArrayList<ResourceReference>();

    /**
     * Identifies the organization or group who is responsible for ongoing maintenance of and access to the document.
     */
    private ResourceReference custodian;

    /**
     * The main Act, such as a colonoscopy or an appendectomy, being documented
     */
    private ResourceReference context;

    /**
     * Describes the clinical encounter or type of care this document is associated with.
     */
    private ResourceReference encounter;

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

    public Instant getInstant() { 
      return this.instant;
    }

    public void setInstant(Instant value) { 
      this.instant = value;
    }

    public CodeableConcept getType() { 
      return this.type;
    }

    public void setType(CodeableConcept value) { 
      this.type = value;
    }

    public String_ getTitle() { 
      return this.title;
    }

    public void setTitle(String_ value) { 
      this.title = value;
    }

    public Id getReplaces() { 
      return this.replaces;
    }

    public void setReplaces(Id value) { 
      this.replaces = value;
    }

    public ResourceReference getEnterer() { 
      return this.enterer;
    }

    public void setEnterer(ResourceReference value) { 
      this.enterer = value;
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getInformant() { 
      return this.informant;
    }

    public void setInformant(ResourceReference value) { 
      this.informant = value;
    }

    public List<ResourceReference> getAuthor() { 
      return this.author;
    }

    public List<Attester> getAttester() { 
      return this.attester;
    }

    public List<ResourceReference> getRecipient() { 
      return this.recipient;
    }

    public ResourceReference getCustodian() { 
      return this.custodian;
    }

    public void setCustodian(ResourceReference value) { 
      this.custodian = value;
    }

    public ResourceReference getContext() { 
      return this.context;
    }

    public void setContext(ResourceReference value) { 
      this.context = value;
    }

    public ResourceReference getEncounter() { 
      return this.encounter;
    }

    public void setEncounter(ResourceReference value) { 
      this.encounter = value;
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


}

