package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on 23:50 Apr 10, 2012 for FHIR v0.01

import java.util.*;

/**
 * A conformance statement returned by request in an RESTful framework
 */
public class Conformance extends Resource {

    public enum RestfulConformanceMode {
        client, // The application acts as a server for this resource
        server; // The application acts as a client for this resource
        public static RestfulConformanceMode fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("client".equals(code))
          return client;
        if ("server".equals(code))
          return server;
        throw new Exception("Unknown RestfulConformanceMode code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case client: return "client";
            case server: return "server";
            default: return "?";
          }
        }
    }

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

    public class Operation extends Element {
        /**
         * if supported
         */
        private Boolean read;

        /**
         * if supported
         */
        private Boolean vread;

        /**
         * if supported
         */
        private Boolean update;

        /**
         * if supported
         */
        private Boolean delete;

        /**
         * if supported
         */
        private Boolean validate;

        /**
         * if supported
         */
        private Boolean history;

        /**
         * only if supported
         */
        private Transaction transaction;

        /**
         * only if supported
         */
        private Search search;

        /**
         * if supported
         */
        private Create create;

        /**
         * if supported
         */
        private Boolean updates;

        /**
         * if supported
         */
        private Boolean schema;

        public Boolean getRead() { 
          return this.read;
        }

        public void setRead(Boolean value) { 
          this.read = value;
        }

        public Boolean getVread() { 
          return this.vread;
        }

        public void setVread(Boolean value) { 
          this.vread = value;
        }

        public Boolean getUpdate() { 
          return this.update;
        }

        public void setUpdate(Boolean value) { 
          this.update = value;
        }

        public Boolean getDelete() { 
          return this.delete;
        }

        public void setDelete(Boolean value) { 
          this.delete = value;
        }

        public Boolean getValidate() { 
          return this.validate;
        }

        public void setValidate(Boolean value) { 
          this.validate = value;
        }

        public Boolean getHistory() { 
          return this.history;
        }

        public void setHistory(Boolean value) { 
          this.history = value;
        }

        public Transaction getTransaction() { 
          return this.transaction;
        }

        public void setTransaction(Transaction value) { 
          this.transaction = value;
        }

        public Search getSearch() { 
          return this.search;
        }

        public void setSearch(Search value) { 
          this.search = value;
        }

        public Create getCreate() { 
          return this.create;
        }

        public void setCreate(Create value) { 
          this.create = value;
        }

        public Boolean getUpdates() { 
          return this.updates;
        }

        public void setUpdates(Boolean value) { 
          this.updates = value;
        }

        public Boolean getSchema() { 
          return this.schema;
        }

        public void setSchema(Boolean value) { 
          this.schema = value;
        }

    }

    public class Transaction extends Element {
        /**
         * transaction names supported
         */
        private List<Code> name = new ArrayList<Code>();

        public List<Code> getName() { 
          return this.name;
        }

    }

    public class Search extends Element {
        /**
         * search params supported
         */
        private List<String_> param = new ArrayList<String_>();

        public List<String_> getParam() { 
          return this.param;
        }

    }

    public class Create extends Element {
        /**
         * source of id: client | server | either
         */
        private Code id;

        public Code getId() { 
          return this.id;
        }

        public void setId(Code value) { 
          this.id = value;
        }

    }

    /**
     * Date that the conformance statement is published
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
     * client | server
     */
    private RestfulConformanceMode mode;

    /**
     * Resource Type with constraints
     */
    private Constraint resource;

    /**
     * 
     */
    private Operation operation;

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

    public RestfulConformanceMode getMode() { 
      return this.mode;
    }

    public void setMode(RestfulConformanceMode value) { 
      this.mode = value;
    }

    public Constraint getResource() { 
      return this.resource;
    }

    public void setResource(Constraint value) { 
      this.resource = value;
    }

    public Operation getOperation() { 
      return this.operation;
    }

    public void setOperation(Operation value) { 
      this.operation = value;
    }


}

