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

// Generated on Thu, Nov 8, 2012 23:13+1100 for FHIR v0.06

import java.util.*;

/**
 * An entry in an XDS registry
 */
public class XdsEntry extends Resource {

    public enum XdsEntryAvailability {
        Approved, // 
        Deprecated; // 
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

    public class Author extends Element {
        /**
         * Represents the name of the human and/or machine that authored the document  within the authorInstitution
         */
        private HumanName name;

        /**
         * Represents the id of the human and/or machine that authored the document  within the authorInstitution
         */
        private Identifier id;

        /**
         * A code that represents the role of the author with respect to the patient when the document was created.
         */
        private List<String> role = new ArrayList<String>();

        /**
         * Represents a specific specialty within a healthcare facility under which the human and/or machines authored the document
         */
        private List<String> specialty = new ArrayList<String>();

        /**
         * Represents a specific healthcare facility under which the human and/or machines authored the document.  A specific case is that of homecare. 
         */
        private List<Institution> institution = new ArrayList<Institution>();

        /**
         * Represents the telecommunications address (e.g. email) of the document author, intended to assist with automated routing of other messages intended for the document author
         */
        private List<Contact> contact = new ArrayList<Contact>();

        public HumanName getName() { 
          return this.name;
        }

        public void setName(HumanName value) { 
          this.name = value;
        }

        public Identifier getId() { 
          return this.id;
        }

        public void setId(Identifier value) { 
          this.id = value;
        }

        public List<String> getRole() { 
          return this.role;
        }

        public List<String> getSpecialty() { 
          return this.specialty;
        }

        public List<Institution> getInstitution() { 
          return this.institution;
        }

        public List<Contact> getContact() { 
          return this.contact;
        }

    }

    public class Institution extends Element {
        /**
         * id of facility
         */
        private Identifier id;

        /**
         * name of facility
         */
        private String name;

        public Identifier getId() { 
          return this.id;
        }

        public void setId(Identifier value) { 
          this.id = value;
        }

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

    }

    public class Authenticator extends Element {
        /**
         * id of authenticator
         */
        private Identifier id;

        /**
         * name of authenticator
         */
        private HumanName name;

        public Identifier getId() { 
          return this.id;
        }

        public void setId(Identifier value) { 
          this.id = value;
        }

        public HumanName getName() { 
          return this.name;
        }

        public void setName(HumanName value) { 
          this.name = value;
        }

    }

    public class Service extends Element {
        /**
         * Start time
         */
        private String start;

        /**
         * Stop time
         */
        private String stop;

        public String getStart() { 
          return this.start;
        }

        public void setStart(String value) { 
          this.start = value;
        }

        public String getStop() { 
          return this.stop;
        }

        public void setStop(String value) { 
          this.stop = value;
        }

    }

    /**
     * A URL that is used to access the document content directly. If this is not provided, the document may be found be searching the repositoryId for the documentId
     */
    private java.net.URI url;

    /**
     * The globally unique identifier of the repository where the document is stored, assigned by the Document Repository. This unique identifier for the Document Repository may be used to identify and connect to the specific Document Repository where the document is stored once its metadata has been retrieved from a Document Registry
     */
    private java.net.URI repositoryId;

    /**
     * MIME type of the document in the Repository.
     */
    private String mimeType;

    /**
     * Code globally uniquely specifying the format of the document. Along with the typeCode, it should provide sufficient information to allow any potential XDS Document Consumer to know if it will be able to process the document. The formatCode shall be sufficiently specific to ensure processing/display by identifying a document encoding, structure and template (e.g., for a CDA Document, the fact that it complies with a CDA schema, possibly a template and the choice of a content-specific style sheet).
     */
    private Coding format;

    /**
     * The code specifying the particular kind of document (e.g., Prescription, Discharge Summary, Report). It is suggested that the XDS Affinity Domain draws these values from a coding scheme providing a coarse level of granularity (about 10 to 100 entries). Shall have a single value.
     */
    private Coding class_;

    /**
     * The code specifying the precise kind of document (e.g., Pulmonary History and Physical, Discharge Summary, Ultrasound Report).
     */
    private Coding type;

    /**
     * Represents the title of the document.
     */
    private String title;

    /**
     * The globally unique identifier assigned by the document creator to this document. This unique identifier may be used in the body of other XDS Documents to reference this document.
     */
    private java.net.URI documentId;

    /**
     * deprecated documents can be included in some responses
     */
    private XdsEntryAvailability availability;

    /**
     * The code specifying the level of confidentiality of the XDS Document. These codes are specific to an XDS Affinity Domain.
     */
    private Coding confidentialityCode;

    /**
     * Represents the time the author created the document in the Document Source
     */
    private java.util.Calendar created;

    /**
     * This list of codes represents the main clinical acts, such as a colonoscopy or an appendectomy, being documented. In some cases, the event is inherent in the typeCode, such as a "History and Physical Report" in which the procedure being documented is necessarily a "History and Physical" act.
     */
    private List<Coding> event = new ArrayList<Coding>();

    /**
     * Hash key of the XDS Document itself
     */
    private String hash;

    /**
     * Size in bytes of the byte stream that was provided in the Register and Provide Transaction and stored by the XDS Document Repository. This value is computed by the Document Repository and included in the Register Documents Set Transaction.
     */
    private String size;

    /**
     * Specifies the human language of character data in the document. The values of the attribute are language identifiers as described by the IETF (Internet Engineering Task Force) RFC 3066.
     */
    private String language;

    /**
     * Folders that this document is registered in
     */
    private List<ResourceReference> folder = new ArrayList<ResourceReference>();

    /**
     * The patientId represents the subject of care of the document. This identifier shall be from the Assigning Authority Domain supporting the XDS Affinity Domain in which the Document Registry operates.
     */
    private Identifier patientId;

    /**
     * The sourcePatientId represents the subject of care medical record Identifier (e.g., Patient Id) in the local patient Identifier Domain of the Document Source.
     */
    private Identifier sourcePatientId;

    /**
     * This is a reference to the demographics information of the person to whose medical record this document belongs, as the Document Source knew it at the time of Submission. This information typically includes: the patient first and last name, sex, 
and birth date
     */
    private ResourceReference patientInfo;

    /**
     * Represents the humans and/or machines that authored the document
     */
    private List<Author> author = new ArrayList<Author>();

    /**
     * Represents a participant who has legally authenticated or attested the document within the authorInstitution. Legal authentication implies that a document has been signed manually or electronically by the legalAuthenticator.
     */
    private Authenticator authenticator;

    /**
     * This code represents the type of organizational setting of the clinical encounter during which the documented act occurred
     */
    private Coding facilityType;

    /**
     * The code specifying the clinical specialty where the act that resulted in the document was performed (e.g., Family Practice, Laboratory, Radiology).
     */
    private Coding practiceSetting;

    /**
     * A globally unique identifier for a community. 
     */
    private java.net.URI homeCommunity;

    /**
     * Represents the time of the service being documented took place (clinically significant, but not necessarily when the document was produced or approved).
     */
    private Service service;

    /**
     * Comments associated with the Document.
     */
    private String comments;

    public java.net.URI getUrl() { 
      return this.url;
    }

    public void setUrl(java.net.URI value) { 
      this.url = value;
    }

    public java.net.URI getRepositoryId() { 
      return this.repositoryId;
    }

    public void setRepositoryId(java.net.URI value) { 
      this.repositoryId = value;
    }

    public String getMimeType() { 
      return this.mimeType;
    }

    public void setMimeType(String value) { 
      this.mimeType = value;
    }

    public Coding getFormat() { 
      return this.format;
    }

    public void setFormat(Coding value) { 
      this.format = value;
    }

    public Coding getClass_() { 
      return this.class_;
    }

    public void setClass_(Coding value) { 
      this.class_ = value;
    }

    public Coding getType() { 
      return this.type;
    }

    public void setType(Coding value) { 
      this.type = value;
    }

    public String getTitle() { 
      return this.title;
    }

    public void setTitle(String value) { 
      this.title = value;
    }

    public java.net.URI getDocumentId() { 
      return this.documentId;
    }

    public void setDocumentId(java.net.URI value) { 
      this.documentId = value;
    }

    public XdsEntryAvailability getAvailability() { 
      return this.availability;
    }

    public void setAvailability(XdsEntryAvailability value) { 
      this.availability = value;
    }

    public Coding getConfidentialityCode() { 
      return this.confidentialityCode;
    }

    public void setConfidentialityCode(Coding value) { 
      this.confidentialityCode = value;
    }

    public java.util.Calendar getCreated() { 
      return this.created;
    }

    public void setCreated(java.util.Calendar value) { 
      this.created = value;
    }

    public List<Coding> getEvent() { 
      return this.event;
    }

    public String getHash() { 
      return this.hash;
    }

    public void setHash(String value) { 
      this.hash = value;
    }

    public String getSize() { 
      return this.size;
    }

    public void setSize(String value) { 
      this.size = value;
    }

    public String getLanguage() { 
      return this.language;
    }

    public void setLanguage(String value) { 
      this.language = value;
    }

    public List<ResourceReference> getFolder() { 
      return this.folder;
    }

    public Identifier getPatientId() { 
      return this.patientId;
    }

    public void setPatientId(Identifier value) { 
      this.patientId = value;
    }

    public Identifier getSourcePatientId() { 
      return this.sourcePatientId;
    }

    public void setSourcePatientId(Identifier value) { 
      this.sourcePatientId = value;
    }

    public ResourceReference getPatientInfo() { 
      return this.patientInfo;
    }

    public void setPatientInfo(ResourceReference value) { 
      this.patientInfo = value;
    }

    public List<Author> getAuthor() { 
      return this.author;
    }

    public Authenticator getAuthenticator() { 
      return this.authenticator;
    }

    public void setAuthenticator(Authenticator value) { 
      this.authenticator = value;
    }

    public Coding getFacilityType() { 
      return this.facilityType;
    }

    public void setFacilityType(Coding value) { 
      this.facilityType = value;
    }

    public Coding getPracticeSetting() { 
      return this.practiceSetting;
    }

    public void setPracticeSetting(Coding value) { 
      this.practiceSetting = value;
    }

    public java.net.URI getHomeCommunity() { 
      return this.homeCommunity;
    }

    public void setHomeCommunity(java.net.URI value) { 
      this.homeCommunity = value;
    }

    public Service getService() { 
      return this.service;
    }

    public void setService(Service value) { 
      this.service = value;
    }

    public String getComments() { 
      return this.comments;
    }

    public void setComments(String value) { 
      this.comments = value;
    }


}

