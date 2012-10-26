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

// Generated on Sat, Oct 27, 2012 08:45+1100 for FHIR v0.06

import java.util.*;

/**
 * A conformance statement about how an application or implementation supports FHIR or the set of requirements for a desired implementation.
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
        create; // Create a new resource with a server assigned id
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
            default: return "?";
          }
        }
    }

    public enum SearchParamType {
        integer, // search parameter must be a simple whole number
        string, // search parameter is a simple string, like a name part (search usually functions on partial matches)
        text, // search parameter is into a long string (i.e. a text filter type search)
        date, // search parameter is onto a date (and should support -before and -after variants). The date format is the standard XML format, thoughother formats may be supported
        token, // search parameter is on a fixed value string (i.e. search has an exact match)
        qtoken; // search parameter is a pair of fixed value strings, namespace and value, separated by a "#". The namespace is usually a uri, such as one of the defined code systems and is optional when searching
        public static SearchParamType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("integer".equals(codeString))
          return integer;
        if ("string".equals(codeString))
          return string;
        if ("text".equals(codeString))
          return text;
        if ("date".equals(codeString))
          return date;
        if ("token".equals(codeString))
          return token;
        if ("qtoken".equals(codeString))
          return qtoken;
        throw new Exception("Unknown SearchParamType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case integer: return "integer";
            case string: return "string";
            case text: return "text";
            case date: return "date";
            case token: return "token";
            case qtoken: return "qtoken";
            default: return "?";
          }
        }
    }

    public enum SearchRepeatBehavior {
        single, // the search parameter may only be used once
        union, // when the search parameter is used more than once, match resources with any of the values
        intersection; // when the search parameter is used more than once, match resources with all of the values
        public static SearchRepeatBehavior fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("single".equals(codeString))
          return single;
        if ("union".equals(codeString))
          return union;
        if ("intersection".equals(codeString))
          return intersection;
        throw new Exception("Unknown SearchRepeatBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case single: return "single";
            case union: return "union";
            case intersection: return "intersection";
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
        private String name;

        /**
         * Address of Organization
         */
        private Address address;

        /**
         * Contacts for Organization relevant to this conformance statement.  May be website, email, phone numbers, etc.
         */
        private List<Contact> contact = new ArrayList<Contact>();

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
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
        private String description;

        /**
         * The base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        private java.net.URI url;

        public String getDescription() { 
          return this.description;
        }

        public void setDescription(String value) { 
          this.description = value;
        }

        public java.net.URI getUrl() { 
          return this.url;
        }

        public void setUrl(java.net.URI value) { 
          this.url = value;
        }

    }

    public class Software extends Element {
        /**
         * Name software is known by
         */
        private String name;

        /**
         * Version covered by this statement
         */
        private String version;

        /**
         * Date this version of the software released
         */
        private String releaseDate;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public String getVersion() { 
          return this.version;
        }

        public void setVersion(String value) { 
          this.version = value;
        }

        public String getReleaseDate() { 
          return this.releaseDate;
        }

        public void setReleaseDate(String value) { 
          this.releaseDate = value;
        }

    }

    public class Proposal extends Element {
        /**
         * Provides details about the intention and scope of the proposal
         */
        private String description;

        public String getDescription() { 
          return this.description;
        }

        public void setDescription(String value) { 
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
        private String documentation;

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

        public String getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String value) { 
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
        private String type;

        /**
         * Identifies the profile that describes the solution's support for the resource, including any constraints on cardinality, bindings, lengths or other limitations
         */
        private java.net.URI profile;

        /**
         * Identifies a restful operation supported by the solution
         */
        private List<Operation> operation = new ArrayList<Operation>();

        /**
         * A flag for whether the server is able to return past versions as part of the vRead operation
         */
        private java.lang.Boolean history;

        /**
         * If present, indicates that search operations are supported on the resource and describes the search capabilities.
         */
        private Search search;

        public String getType() { 
          return this.type;
        }

        public void setType(String value) { 
          this.type = value;
        }

        public java.net.URI getProfile() { 
          return this.profile;
        }

        public void setProfile(java.net.URI value) { 
          this.profile = value;
        }

        public List<Operation> getOperation() { 
          return this.operation;
        }

        public java.lang.Boolean getHistory() { 
          return this.history;
        }

        public void setHistory(java.lang.Boolean value) { 
          this.history = value;
        }

        public Search getSearch() { 
          return this.search;
        }

        public void setSearch(Search value) { 
          this.search = value;
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
        private String documentation;

        public RestfulOperation getCode() { 
          return this.code;
        }

        public void setCode(RestfulOperation value) { 
          this.code = value;
        }

        public String getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String value) { 
          this.documentation = value;
        }

    }

    public class Search extends Element {
        /**
         * Provides solution-specific information on searching that isn't tied to a single parameter.  For example, security requirements for executing search, allowed combinations of parameters, etc.
         */
        private String documentation;

        /**
         * Identifies all of the search parameters supported, including standard ones as well as those specific to this solution.
         */
        private List<Param> param = new ArrayList<Param>();

        public String getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String value) { 
          this.documentation = value;
        }

        public List<Param> getParam() { 
          return this.param;
        }

    }

    public class Param extends Element {
        /**
         * Corresponds to the name of the standard or custom search parameter
         */
        private String name;

        /**
         * The type of value a search parameter refers to, and how the content is interpreted
         */
        private SearchParamType type;

        /**
         * Whether multiple uses of the parameter are allowed in searches, and if they are, how the multiple values are understood.
         */
        private SearchRepeatBehavior repeats;

        /**
         * For standard parameters, provides additional information on how the parameter is used in this solution.  For custom parameters, provides a description of what the parameter does
         */
        private String documentation;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public SearchParamType getType() { 
          return this.type;
        }

        public void setType(SearchParamType value) { 
          this.type = value;
        }

        public SearchRepeatBehavior getRepeats() { 
          return this.repeats;
        }

        public void setRepeats(SearchRepeatBehavior value) { 
          this.repeats = value;
        }

        public String getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String value) { 
          this.documentation = value;
        }

    }

    public class Messaging extends Element {
        /**
         * The address to which messages and/or replies are to be sent.
         */
        private java.net.URI endpoint;

        /**
         * Provides documentation about the system's messaging capabilities for this endpoint not otherwise documented by the conformance statement.  For example, process for becoming an authorized messaging exchange partner.
         */
        private String documentation;

        /**
         * Describes the solution's support for an event at this end point.
         */
        private List<Event> event = new ArrayList<Event>();

        public java.net.URI getEndpoint() { 
          return this.endpoint;
        }

        public void setEndpoint(java.net.URI value) { 
          this.endpoint = value;
        }

        public String getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String value) { 
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
        private String code;

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
        private String focus;

        /**
         * Information about the request for this event
         */
        private java.net.URI request;

        /**
         * Information about the response for this event
         */
        private java.net.URI response;

        /**
         * Guidance on how this event is handled, such as internal system trigger points, business rules, etc.
         */
        private String documentation;

        public String getCode() { 
          return this.code;
        }

        public void setCode(String value) { 
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

        public String getFocus() { 
          return this.focus;
        }

        public void setFocus(String value) { 
          this.focus = value;
        }

        public java.net.URI getRequest() { 
          return this.request;
        }

        public void setRequest(java.net.URI value) { 
          this.request = value;
        }

        public java.net.URI getResponse() { 
          return this.response;
        }

        public void setResponse(java.net.URI value) { 
          this.response = value;
        }

        public String getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String value) { 
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
        private String documentation;

        /**
         * Constraint on a resource used in the document
         */
        private java.net.URI profile;

        public DocumentMode getMode() { 
          return this.mode;
        }

        public void setMode(DocumentMode value) { 
          this.mode = value;
        }

        public String getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String value) { 
          this.documentation = value;
        }

        public java.net.URI getProfile() { 
          return this.profile;
        }

        public void setProfile(java.net.URI value) { 
          this.profile = value;
        }

    }

    /**
     * Date that the conformance statement is published
     */
    private String date;

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
    private String version;

    /**
     * Whether the application accepts unknown non-"must understand" elements as part of a resource. This does not include extensions, but genuine new additions to a resource
     */
    private java.lang.Boolean acceptUnknown;

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

    public String getDate() { 
      return this.date;
    }

    public void setDate(String value) { 
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

    public String getVersion() { 
      return this.version;
    }

    public void setVersion(String value) { 
      this.version = value;
    }

    public java.lang.Boolean getAcceptUnknown() { 
      return this.acceptUnknown;
    }

    public void setAcceptUnknown(java.lang.Boolean value) { 
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


}

