package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on 22:50 Apr 29, 2012 for FHIR v0.01

import java.util.*;

/**
 * A documentation of clinical observations and services that are aggregated together into a single statement of clinical meaning that establishes it's own context. A clinical document is composed of a set of resources that include both human and computer readable portions. A human must attest to the accuracy of the human readable portion, and may authenticate and/or sign the entire whole
 */
public class Document extends Resource {

    public enum DocumentAuthenticationMode {
        personal, // The person authenticated the document in their personal capacity
        professional, // The person authenticated the document in their professional capacity
        legal, // The person authenticated the document and accepted legal responsibility for it's content
        official; // The organization authenticated the document as consistent with their policies and procedures
        public static DocumentAuthenticationMode fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("personal".equals(code))
          return personal;
        if ("professional".equals(code))
          return professional;
        if ("legal".equals(code))
          return legal;
        if ("official".equals(code))
          return official;
        throw new Exception("Unknown DocumentAuthenticationMode code '"+code+"'");
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

    public class Author extends Element {
        /**
         * When authoring happened
         */
        private DateTime time;

        /**
         * who/what authored the final document
         */
        private ResourceReference party;

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

    public class Attestor extends Element {
        /**
         * The type of attestation the authenticator offers
         */
        private DocumentAuthenticationMode mode;

        /**
         * When document attested
         */
        private DateTime time;

        /**
         * who attested the document
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
         * type of section (recommended)
         */
        private CodeableConcept type;

        /**
         * the section creation time (sections are often re-used in several documents).
         */
        private Instant instant;

        /**
         * if section author different to document
         */
        private AuthorA author;

        /**
         * The person or device that performed the data entry leading to this section. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
         */
        private ResourceReference enterer;

        /**
         * if section different to document
         */
        private ResourceReference subject;

        /**
         * provided information in section
         */
        private ResourceReference informant;

        /**
         * the actual content of the section
         */
        private ResourceReference content;

        /**
         * nested Section
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

        public AuthorA getAuthor() { 
          return this.author;
        }

        public void setAuthor(AuthorA value) { 
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

        public List<Section> getSection() { 
          return this.section;
        }

    }

    public class AuthorA extends Element {
        /**
         * When authoring happened
         */
        private DateTime time;

        /**
         * who/what authored the section
         */
        private ResourceReference party;

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

    /**
     * the document creation time, when the document first came into being. Where the CDA document is a transform from an original document in some other format, the ClinicalDocument.effectiveTime is the time the original document is created.
     */
    private Instant instant;

    /**
     * specifying the particular kind of document (e.g. History and Physical, Discharge Summary, Progress Note)
     */
    private CodeableConcept type;

    /**
     * the title of the document
     */
    private String_ title;

    /**
     * Represents an identifier that is common across all document revisions
     */
    private Id setId;

    /**
     * used to version successive replacement documents
     */
    private Integer version;

    /**
     * If this document replaces another
     */
    private Id replaces;

    /**
     * who the document is about
     */
    private ResourceReference subject;

    /**
     * Author (contributed content to document)
     */
    private List<Author> author = new ArrayList<Author>();

    /**
     * a participant who has attested to the accuracy of the document
     */
    private List<Attestor> attestor = new ArrayList<Attestor>();

    /**
     * expected to receive a copy 
     */
    private List<ResourceReference> recipient = new ArrayList<ResourceReference>();

    /**
     * org which maintains the document.
     */
    private ResourceReference custodian;

    /**
     * the main Act, such as a colonoscopy or an appendectomy, being documented
     */
    private ResourceReference event;

    /**
     * context of the document
     */
    private ResourceReference encounter;

    /**
     * Document is broken into sections
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

    public Id getSetId() { 
      return this.setId;
    }

    public void setSetId(Id value) { 
      this.setId = value;
    }

    public Integer getVersion() { 
      return this.version;
    }

    public void setVersion(Integer value) { 
      this.version = value;
    }

    public Id getReplaces() { 
      return this.replaces;
    }

    public void setReplaces(Id value) { 
      this.replaces = value;
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public List<Author> getAuthor() { 
      return this.author;
    }

    public List<Attestor> getAttestor() { 
      return this.attestor;
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

    public ResourceReference getEvent() { 
      return this.event;
    }

    public void setEvent(ResourceReference value) { 
      this.event = value;
    }

    public ResourceReference getEncounter() { 
      return this.encounter;
    }

    public void setEncounter(ResourceReference value) { 
      this.encounter = value;
    }

    public List<Section> getSection() { 
      return this.section;
    }


}

