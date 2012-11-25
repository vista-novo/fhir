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

// Generated on Sun, Nov 25, 2012 14:16+1100 for FHIR v0.06

import java.util.*;

/**
 * Describes a document: the context and searchable metadata for a document
 */
public class DocumentInformation extends Type {

    public class Attester extends Element {
        /**
         * The type of attestation the authenticator offers
         */
        private Code mode;

        /**
         * When document was attested by the party
         */
        private DateTime time;

        /**
         * Who attested the document in the specified way
         */
        private ResourceReference party;

        public Code getMode() { 
          return this.mode;
        }

        public void setMode(Code value) { 
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

    /**
     * The identifier for the document as assigned by the souces system when the document was created
     */
    private Identifier documentId;

    /**
     * the document creation time, when the document first came into being. Where the document is a transform from an original document in some other format, the ClinicalDocument.effectiveTime is the time the original document is created.
     */
    private Instant instant;

    /**
     * Specifies the particular kind of document (e.g. History and Physical, Discharge Summary, Progress Note)
     */
    private CodeableConcept type;

    /**
     * Official human-readable label for the document
     */
    private String_ title;

    /**
     * Identifies the primary subject of the document.  
     */
    private ResourceReference subject;

    /**
     * Identifies who is responsible for the information in the document.  (Not necessarily who typed it in.)
     */
    private List<ResourceReference> author = new ArrayList<ResourceReference>();

    /**
     * A participant who has attested to the accuracy of the document
     */
    private List<Attester> attester = new ArrayList<Attester>();

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

    public Identifier getDocumentId() { 
      return this.documentId;
    }

    public void setDocumentId(Identifier value) { 
      this.documentId = value;
    }

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

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public List<ResourceReference> getAuthor() { 
      return this.author;
    }

    public List<Attester> getAttester() { 
      return this.attester;
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


}

