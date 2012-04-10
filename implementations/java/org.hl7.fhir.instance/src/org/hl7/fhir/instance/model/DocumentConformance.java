package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on 23:50 Apr 10, 2012 for FHIR v0.01

import java.util.*;

/**
 * A conformance statement about how one or more FHIR documents
 */
public class DocumentConformance extends Resource {

    public class Publisher extends Element {
        /**
         * Name of Organization
         */
        private String_ name;

        /**
         * Address of Organization
         */
        private List<Address> address = new ArrayList<Address>();

        /**
         * Contacts for Organization
         */
        private List<Contact> contact = new ArrayList<Contact>();

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public List<Address> getAddress() { 
          return this.address;
        }

        public List<Contact> getContact() { 
          return this.contact;
        }

    }

    public class Software extends Element {
        /**
         * Name software is known by
         */
        private String_ name;

        /**
         * Version covered by this statement
         */
        private String_ version;

        /**
         * Date this version released
         */
        private DateTime releaseDate;

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public String_ getVersion() { 
          return this.version;
        }

        public void setVersion(String_ value) { 
          this.version = value;
        }

        public DateTime getReleaseDate() { 
          return this.releaseDate;
        }

        public void setReleaseDate(DateTime value) { 
          this.releaseDate = value;
        }

    }

    public class Document extends Element {
        /**
         * Name for this particular document profile
         */
        private String_ name;

        /**
         * Human description of this particular profile
         */
        private String_ purpose;

        /**
         * Constraint on a resource used in the document
         */
        private List<Constraint> resource = new ArrayList<Constraint>();

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public String_ getPurpose() { 
          return this.purpose;
        }

        public void setPurpose(String_ value) { 
          this.purpose = value;
        }

        public List<Constraint> getResource() { 
          return this.resource;
        }

    }

    /**
     * Date that this conformance statement is published
     */
    private DateTime date;

    /**
     * The organization that publishes this conformance statement
     */
    private Publisher publisher;

    /**
     * The software that is covered by this conformance statement
     */
    private Software software;

    /**
     * A document definition
     */
    private List<Document> document = new ArrayList<Document>();

    public DateTime getDate() { 
      return this.date;
    }

    public void setDate(DateTime value) { 
      this.date = value;
    }

    public Publisher getPublisher() { 
      return this.publisher;
    }

    public void setPublisher(Publisher value) { 
      this.publisher = value;
    }

    public Software getSoftware() { 
      return this.software;
    }

    public void setSoftware(Software value) { 
      this.software = value;
    }

    public List<Document> getDocument() { 
      return this.document;
    }


}

