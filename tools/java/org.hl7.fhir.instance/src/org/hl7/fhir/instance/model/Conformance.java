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

// Generated on Sat, Jan 19, 2013 17:09+1100 for FHIR v0.07

import java.util.*;

/**
 * A conformance statement about how an application or implementation supports FHIR or the set of requirements for a desired implementation
 */
public class Conformance extends Resource {

    public enum RestfulConformanceMode {
        client, // The application acts as a server for this resource
        server; // The application acts as a client for this resource
        public static RestfulConformanceMode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("client".equals(codeString))
          return client;
        if ("server".equals(codeString))
          return server;
        throw new Exception("Unknown RestfulConformanceMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case client: return "client";
            case server: return "server";
            default: return "?";
          }
        }
    }

    public enum RestfulOperation {
        read, // Read the current state of the resource
        vread, // Read the state of a specific version of the resource
        update, // Update an existing resource by its id (or create it if it is new)
        delete, // Delete a resource
        history, // Retrieve the update history for the resource
        validate, // Check that the content would be acceptable as an update
        updates, // Get a list of prior updates to resources of this type, optionally with some filter criteria
        create, // Create a new resource with a server assigned id
        search; // Supports search operations using the parameters described in the profile
        public static RestfulOperation fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("read".equals(codeString))
          return read;
        if ("vread".equals(codeString))
          return vread;
        if ("update".equals(codeString))
          return update;
        if ("delete".equals(codeString))
          return delete;
        if ("history".equals(codeString))
          return history;
        if ("validate".equals(codeString))
          return validate;
        if ("updates".equals(codeString))
          return updates;
        if ("create".equals(codeString))
          return create;
        if ("search".equals(codeString))
          return search;
        throw new Exception("Unknown RestfulOperation code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case read: return "read";
            case vread: return "vread";
            case update: return "update";
            case delete: return "delete";
            case history: return "history";
            case validate: return "validate";
            case updates: return "updates";
            case create: return "create";
            case search: return "search";
            default: return "?";
          }
        }
    }

    public enum MessageConformanceEventMode {
        sender, // The application sends requests and receives responses
        receiver; // The application receives requests and sends responses
        public static MessageConformanceEventMode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sender".equals(codeString))
          return sender;
        if ("receiver".equals(codeString))
          return receiver;
        throw new Exception("Unknown MessageConformanceEventMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case sender: return "sender";
            case receiver: return "receiver";
            default: return "?";
          }
        }
    }

    public enum DocumentMode {
        producer, // The application produces documents of the specified type
        consumer; // The application consumes documents of the specified type
        public static DocumentMode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("producer".equals(codeString))
          return producer;
        if ("consumer".equals(codeString))
          return consumer;
        throw new Exception("Unknown DocumentMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case producer: return "producer";
            case consumer: return "consumer";
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
        private Address address;

        /**
         * Contacts for Organization relevant to this conformance statement.  May be website, email, phone numbers, etc.
         */
        private List<Contact> contact = new ArrayList<Contact>();

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public Address getAddress() { 
          return this.address;
        }

        public void setAddress(Address value) { 
          this.address = value;
        }

        public List<Contact> getContact() { 
          return this.contact;
        }

    }

    public class Implementation extends Element {
        /**
         * Information about the specific implementation 
         */
        private String_ description;

        /**
         * The base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        private Uri url;

        public String_ getDescription() { 
          return this.description;
        }

        public void setDescription(String_ value) { 
          this.description = value;
        }

        public Uri getUrl() { 
          return this.url;
        }

        public void setUrl(Uri value) { 
          this.url = value;
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
         * Date this version of the software released
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

    public class Proposal extends Element {
        /**
         * Provides details about the intention and scope of the proposal
         */
        private String_ description;

        public String_ getDescription() { 
          return this.description;
        }

        public void setDescription(String_ value) { 
          this.description = value;
        }

    }

    public class Rest extends Element {
        /**
         * Identifies whether this portion of the statement is describing ability to initiate or receive restful operations
         */
        private RestfulConformanceMode mode;

        /**
         * Provides documentation about the system's restful capabilities that apply across all applications, such as security
         */
        private String_ documentation;

        /**
         * Identifies the restful capabilities of the solution for a specific resource type
         */
        private List<Resource> resource = new ArrayList<Resource>();

        public RestfulConformanceMode getMode() { 
          return this.mode;
        }

        public void setMode(RestfulConformanceMode value) { 
          this.mode = value;
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public List<Resource> getResource() { 
          return this.resource;
        }

    }

    public class Resource extends Element {
        /**
         * Identifies the resource exposed via the restful interface
         */
        private Code type;

        /**
         * Identifies the profile that describes the solution's support for the resource, including any constraints on cardinality, bindings, lengths or other limitations, along with the search parameters supported
         */
        private Uri profile;

        /**
         * Identifies a restful operation supported by the solution
         */
        private List<Operation> operation = new ArrayList<Operation>();

        /**
         * A flag for whether the server is able to return past versions as part of the vRead operation
         */
        private Boolean history;

        public Code getType() { 
          return this.type;
        }

        public void setType(Code value) { 
          this.type = value;
        }

        public Uri getProfile() { 
          return this.profile;
        }

        public void setProfile(Uri value) { 
          this.profile = value;
        }

        public List<Operation> getOperation() { 
          return this.operation;
        }

        public Boolean getHistory() { 
          return this.history;
        }

        public void setHistory(Boolean value) { 
          this.history = value;
        }

    }

    public class Operation extends Element {
        /**
         * Identifies which operation is supported
         */
        private RestfulOperation code;

        /**
         * Provides guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'
         */
        private String_ documentation;

        public RestfulOperation getCode() { 
          return this.code;
        }

        public void setCode(RestfulOperation value) { 
          this.code = value;
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

    }

    public class Messaging extends Element {
        /**
         * The address to which messages and/or replies are to be sent.
         */
        private Uri endpoint;

        /**
         * Provides documentation about the system's messaging capabilities for this endpoint not otherwise documented by the conformance statement.  For example, process for becoming an authorized messaging exchange partner.
         */
        private String_ documentation;

        /**
         * Describes the solution's support for an event at this end point.
         */
        private List<Event> event = new ArrayList<Event>();

        public Uri getEndpoint() { 
          return this.endpoint;
        }

        public void setEndpoint(Uri value) { 
          this.endpoint = value;
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public List<Event> getEvent() { 
          return this.event;
        }

    }

    public class Event extends Element {
        /**
         * Identifies the supported messaging event
         */
        private Code code;

        /**
         * The mode of this event declaration - whether application is sender or receiver
         */
        private MessageConformanceEventMode mode;

        /**
         * Identifies the messaging transport protocol(s) supported by this endpoint
         */
        private List<Coding> protocol = new ArrayList<Coding>();

        /**
         * Identifies the resource associated with the event.  This is the resource that defines the event.
         */
        private Code focus;

        /**
         * Information about the request for this event
         */
        private Uri request;

        /**
         * Information about the response for this event
         */
        private Uri response;

        /**
         * Guidance on how this event is handled, such as internal system trigger points, business rules, etc.
         */
        private String_ documentation;

        public Code getCode() { 
          return this.code;
        }

        public void setCode(Code value) { 
          this.code = value;
        }

        public MessageConformanceEventMode getMode() { 
          return this.mode;
        }

        public void setMode(MessageConformanceEventMode value) { 
          this.mode = value;
        }

        public List<Coding> getProtocol() { 
          return this.protocol;
        }

        public Code getFocus() { 
          return this.focus;
        }

        public void setFocus(Code value) { 
          this.focus = value;
        }

        public Uri getRequest() { 
          return this.request;
        }

        public void setRequest(Uri value) { 
          this.request = value;
        }

        public Uri getResponse() { 
          return this.response;
        }

        public void setResponse(Uri value) { 
          this.response = value;
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

    }

    public class Document extends Element {
        /**
         * The mode of this event declaration - whether application is sender or receiver
         */
        private DocumentMode mode;

        /**
         * Describes how the application supports or uses the specified document profile.  For example, when are documents created, what action is taken with consumed documents, etc.
         */
        private String_ documentation;

        /**
         * Constraint on a resource used in the document
         */
        private Uri profile;

        public DocumentMode getMode() { 
          return this.mode;
        }

        public void setMode(DocumentMode value) { 
          this.mode = value;
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public Uri getProfile() { 
          return this.profile;
        }

        public void setProfile(Uri value) { 
          this.profile = value;
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
     * Describes the implementation that is covered by this conformance statement.  Used when the profile describes the capabilities of a specific implementation instance.
     */
    private Implementation implementation;

    /**
     * Describes the software that is covered by this conformance statement.  Used when the profile describes the capabilities of a particular software version, independent of an installation.
     */
    private Software software;

    /**
     * Describes the proposed solution described by this conformance statement.  Used when the profile describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    private Proposal proposal;

    /**
     * The version of the FHIR specification on which this conformance profile is based
     */
    private Id version;

    /**
     * Whether the application accepts unknown non-"must understand" elements as part of a resource. This does not include extensions, but genuine new additions to a resource
     */
    private Boolean acceptUnknown;

    /**
     * Defines the restful capabilities of the solution, if any
     */
    private List<Rest> rest = new ArrayList<Rest>();

    /**
     * Describes the messaging capabilities of the solution
     */
    private List<Messaging> messaging = new ArrayList<Messaging>();

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

    public Implementation getImplementation() { 
      return this.implementation;
    }

    public void setImplementation(Implementation value) { 
      this.implementation = value;
    }

    public Software getSoftware() { 
      return this.software;
    }

    public void setSoftware(Software value) { 
      this.software = value;
    }

    public Proposal getProposal() { 
      return this.proposal;
    }

    public void setProposal(Proposal value) { 
      this.proposal = value;
    }

    public Id getVersion() { 
      return this.version;
    }

    public void setVersion(Id value) { 
      this.version = value;
    }

    public Boolean getAcceptUnknown() { 
      return this.acceptUnknown;
    }

    public void setAcceptUnknown(Boolean value) { 
      this.acceptUnknown = value;
    }

    public List<Rest> getRest() { 
      return this.rest;
    }

    public List<Messaging> getMessaging() { 
      return this.messaging;
    }

    public List<Document> getDocument() { 
      return this.document;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Conformance;
   }


}

