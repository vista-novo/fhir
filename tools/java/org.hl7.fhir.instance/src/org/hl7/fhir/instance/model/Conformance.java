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

// Generated on Sat, Jul 7, 2012 09:49+1000 for FHIR v0.04

import java.util.*;

/**
 * A conformance statement about how an application supports FHIR
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

    public class Publisher extends Element {
        /**
         * Name of Organization
         */
        private String name;

        /**
         * Address of Organization
         */
        private List<Address> address = new ArrayList<Address>();

        /**
         * Contacts for Organization
         */
        private List<Contact> contact = new ArrayList<Contact>();

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
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
        private String name;

        /**
         * Version covered by this statement
         */
        private String version;

        /**
         * Date this version released
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

    public class Rest extends Element {
        /**
         * client | server
         */
        private RestfulConformanceMode mode;

        /**
         * resource served on the REST interface
         */
        private List<Resource> resource = new ArrayList<Resource>();

        public RestfulConformanceMode getMode() { 
          return this.mode;
        }

        public void setMode(RestfulConformanceMode value) { 
          this.mode = value;
        }

        public List<Resource> getResource() { 
          return this.resource;
        }

    }

    public class Resource extends Element {
        /**
         * resource type
         */
        private String type;

        /**
         * Additional other profiles that apply to this conformance statement.
         */
        private java.net.URI profile;

        /**
         * if supported
         */
        private boolean update;

        /**
         * if supported
         */
        private boolean delete;

        /**
         * if supported
         */
        private boolean validate;

        /**
         * if supported
         */
        private boolean history;

        /**
         * only if supported
         */
        private Search search;

        /**
         * if supported
         */
        private boolean create;

        /**
         * if supported
         */
        private boolean updates;

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

        public boolean getUpdate() { 
          return this.update;
        }

        public void setUpdate(boolean value) { 
          this.update = value;
        }

        public boolean getDelete() { 
          return this.delete;
        }

        public void setDelete(boolean value) { 
          this.delete = value;
        }

        public boolean getValidate() { 
          return this.validate;
        }

        public void setValidate(boolean value) { 
          this.validate = value;
        }

        public boolean getHistory() { 
          return this.history;
        }

        public void setHistory(boolean value) { 
          this.history = value;
        }

        public Search getSearch() { 
          return this.search;
        }

        public void setSearch(Search value) { 
          this.search = value;
        }

        public boolean getCreate() { 
          return this.create;
        }

        public void setCreate(boolean value) { 
          this.create = value;
        }

        public boolean getUpdates() { 
          return this.updates;
        }

        public void setUpdates(boolean value) { 
          this.updates = value;
        }

    }

    public class Search extends Element {
        /**
         * search params supported
         */
        private List<Param> param = new ArrayList<Param>();

        public List<Param> getParam() { 
          return this.param;
        }

    }

    public class Param extends Element {
        /**
         * name of search parameter
         */
        private String name;

        /**
         * contents and meaning of search parameter
         */
        private String documentation;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
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
         * Actual endpoint being described
         */
        private java.net.URI endpoint;

        /**
         * The code for the event
         */
        private List<Event> event = new ArrayList<Event>();

        public java.net.URI getEndpoint() { 
          return this.endpoint;
        }

        public void setEndpoint(java.net.URI value) { 
          this.endpoint = value;
        }

        public List<Event> getEvent() { 
          return this.event;
        }

    }

    public class Event extends Element {
        /**
         * The focal resource for the event
         */
        private String code;

        /**
         * The mode of this event declaration - whether application is sender or receiver
         */
        private MessageConformanceEventMode mode;

        /**
         * if the event code supports multiple resources
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

    }

    public class Document extends Element {
        /**
         * Name for this particular document profile
         */
        private String name;

        /**
         * Human description of this particular profile
         */
        private String purpose;

        /**
         * Constraint on a resource used in the document
         */
        private java.net.URI profile;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public String getPurpose() { 
          return this.purpose;
        }

        public void setPurpose(String value) { 
          this.purpose = value;
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
     * The software that is covered by this conformance statement
     */
    private Software software;

    /**
     * The version of the FHIR specification on which this conformance profile is based
     */
    private String version;

    /**
     * Whether the application accepts unknown elements as part of a resource. This does not include extensions, but genuine new additions to a resource
     */
    private boolean acceptUnknown;

    /**
     * if the endpoint is a RESTful one
     */
    private Rest rest;

    /**
     * An event supported by the application
     */
    private Messaging messaging;

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

    public Software getSoftware() { 
      return this.software;
    }

    public void setSoftware(Software value) { 
      this.software = value;
    }

    public String getVersion() { 
      return this.version;
    }

    public void setVersion(String value) { 
      this.version = value;
    }

    public boolean getAcceptUnknown() { 
      return this.acceptUnknown;
    }

    public void setAcceptUnknown(boolean value) { 
      this.acceptUnknown = value;
    }

    public Rest getRest() { 
      return this.rest;
    }

    public void setRest(Rest value) { 
      this.rest = value;
    }

    public Messaging getMessaging() { 
      return this.messaging;
    }

    public void setMessaging(Messaging value) { 
      this.messaging = value;
    }

    public List<Document> getDocument() { 
      return this.document;
    }


}

