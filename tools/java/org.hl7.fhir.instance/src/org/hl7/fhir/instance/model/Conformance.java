package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2013, HL7, Inc.
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

// Generated on Sun, Apr 14, 2013 21:55+1000 for FHIR v0.08

import java.util.*;

import java.net.*;
/**
 * A conformance statement about how an application or implementation supports FHIR or the set of requirements for a desired implementation
 */
public class Conformance extends Resource {

    public enum RestfulConformanceMode {
        client, // The application acts as a server for this resource
        server, // The application acts as a client for this resource
        Null; // added to help the parsers
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

  public class RestfulConformanceModeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("client".equals(codeString))
          return RestfulConformanceMode.client;
        if ("server".equals(codeString))
          return RestfulConformanceMode.server;
        throw new Exception("Unknown RestfulConformanceMode code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == RestfulConformanceMode.client)
        return "client";
      if (code == RestfulConformanceMode.server)
        return "server";
      return "?";
      }
    }

    public enum RestfulOperation {
        read, // Read the current state of the resource
        vread, // Read the state of a specific version of the resource
        update, // Update an existing resource by its id (or create it if it is new)
        delete, // Delete a resource
        historyMinusinstance, // Retrieve the update history for a resource instance
        validate, // Check that the content would be acceptable as an update
        historyMinustype, // Get a list of updates to resources of this type
        create, // Create a new resource with a server assigned id
        search, // Supports search operations using the parameters described in the profile
        Null; // added to help the parsers
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
        if ("history-instance".equals(codeString))
          return historyMinusinstance;
        if ("validate".equals(codeString))
          return validate;
        if ("history-type".equals(codeString))
          return historyMinustype;
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
            case historyMinusinstance: return "history-instance";
            case validate: return "validate";
            case historyMinustype: return "history-type";
            case create: return "create";
            case search: return "search";
            default: return "?";
          }
        }
    }

  public class RestfulOperationEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("read".equals(codeString))
          return RestfulOperation.read;
        if ("vread".equals(codeString))
          return RestfulOperation.vread;
        if ("update".equals(codeString))
          return RestfulOperation.update;
        if ("delete".equals(codeString))
          return RestfulOperation.delete;
        if ("history-instance".equals(codeString))
          return RestfulOperation.historyMinusinstance;
        if ("validate".equals(codeString))
          return RestfulOperation.validate;
        if ("history-type".equals(codeString))
          return RestfulOperation.historyMinustype;
        if ("create".equals(codeString))
          return RestfulOperation.create;
        if ("search".equals(codeString))
          return RestfulOperation.search;
        throw new Exception("Unknown RestfulOperation code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == RestfulOperation.read)
        return "read";
      if (code == RestfulOperation.vread)
        return "vread";
      if (code == RestfulOperation.update)
        return "update";
      if (code == RestfulOperation.delete)
        return "delete";
      if (code == RestfulOperation.historyMinusinstance)
        return "history-instance";
      if (code == RestfulOperation.validate)
        return "validate";
      if (code == RestfulOperation.historyMinustype)
        return "history-type";
      if (code == RestfulOperation.create)
        return "create";
      if (code == RestfulOperation.search)
        return "search";
      return "?";
      }
    }

    public enum SearchParamType {
        integer, // Search parameter must be a simple whole number
        string, // Search parameter is a simple string, like a name part (search usually functions on partial matches)
        text, // Search parameter is on a long string (i.e. a text filter type search)
        date, // Search parameter is on a date (and should support -before and -after variants). The date format is the standard XML format, though other formats may be supported
        token, // Search parameter is on a fixed value string (i.e. search has an exact match)
        qtoken, // Search parameter is a pair of fixed value strings, namespace and value, separated by a "#". The namespace is usually a uri, such as one of the defined code systems and is optional when searching
        Null; // added to help the parsers
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

  public class SearchParamTypeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("integer".equals(codeString))
          return SearchParamType.integer;
        if ("string".equals(codeString))
          return SearchParamType.string;
        if ("text".equals(codeString))
          return SearchParamType.text;
        if ("date".equals(codeString))
          return SearchParamType.date;
        if ("token".equals(codeString))
          return SearchParamType.token;
        if ("qtoken".equals(codeString))
          return SearchParamType.qtoken;
        throw new Exception("Unknown SearchParamType code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == SearchParamType.integer)
        return "integer";
      if (code == SearchParamType.string)
        return "string";
      if (code == SearchParamType.text)
        return "text";
      if (code == SearchParamType.date)
        return "date";
      if (code == SearchParamType.token)
        return "token";
      if (code == SearchParamType.qtoken)
        return "qtoken";
      return "?";
      }
    }

    public enum SearchRepeatBehavior {
        single, // The search parameter may only occur once
        union, // When the search parameter occurs more than once, match resources with any of the values
        intersection, // When the search parameter occurs more than once, match resources with all of the values
        Null; // added to help the parsers
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

  public class SearchRepeatBehaviorEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("single".equals(codeString))
          return SearchRepeatBehavior.single;
        if ("union".equals(codeString))
          return SearchRepeatBehavior.union;
        if ("intersection".equals(codeString))
          return SearchRepeatBehavior.intersection;
        throw new Exception("Unknown SearchRepeatBehavior code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == SearchRepeatBehavior.single)
        return "single";
      if (code == SearchRepeatBehavior.union)
        return "union";
      if (code == SearchRepeatBehavior.intersection)
        return "intersection";
      return "?";
      }
    }

    public enum MessageConformanceEventMode {
        sender, // The application sends requests and receives responses
        receiver, // The application receives requests and sends responses
        Null; // added to help the parsers
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

  public class MessageConformanceEventModeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sender".equals(codeString))
          return MessageConformanceEventMode.sender;
        if ("receiver".equals(codeString))
          return MessageConformanceEventMode.receiver;
        throw new Exception("Unknown MessageConformanceEventMode code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == MessageConformanceEventMode.sender)
        return "sender";
      if (code == MessageConformanceEventMode.receiver)
        return "receiver";
      return "?";
      }
    }

    public enum DocumentMode {
        producer, // The application produces documents of the specified type
        consumer, // The application consumes documents of the specified type
        Null; // added to help the parsers
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

  public class DocumentModeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("producer".equals(codeString))
          return DocumentMode.producer;
        if ("consumer".equals(codeString))
          return DocumentMode.consumer;
        throw new Exception("Unknown DocumentMode code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == DocumentMode.producer)
        return "producer";
      if (code == DocumentMode.consumer)
        return "consumer";
      return "?";
      }
    }

    public class ConformancePublisherComponent extends Element {
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

        public String getNameSimple() { 
          return this.name == null ? null : this.name.getValue();
        }

        public void setNameSimple(String value) { 
          if (value == null)
            this.name = null;
          else {
            if (this.name == null)
              this.name = new String_();
            this.name.setValue(value);
          }
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

    public class ConformanceSoftwareComponent extends Element {
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

        public String getNameSimple() { 
          return this.name == null ? null : this.name.getValue();
        }

        public void setNameSimple(String value) { 
          if (value == null)
            this.name = null;
          else {
            if (this.name == null)
              this.name = new String_();
            this.name.setValue(value);
          }
        }

        public String_ getVersion() { 
          return this.version;
        }

        public void setVersion(String_ value) { 
          this.version = value;
        }

        public String getVersionSimple() { 
          return this.version == null ? null : this.version.getValue();
        }

        public void setVersionSimple(String value) { 
          if (value == null)
            this.version = null;
          else {
            if (this.version == null)
              this.version = new String_();
            this.version.setValue(value);
          }
        }

        public DateTime getReleaseDate() { 
          return this.releaseDate;
        }

        public void setReleaseDate(DateTime value) { 
          this.releaseDate = value;
        }

        public String getReleaseDateSimple() { 
          return this.releaseDate == null ? null : this.releaseDate.getValue();
        }

        public void setReleaseDateSimple(String value) { 
          if (value == null)
            this.releaseDate = null;
          else {
            if (this.releaseDate == null)
              this.releaseDate = new DateTime();
            this.releaseDate.setValue(value);
          }
        }

  }

    public class ConformanceImplementationComponent extends Element {
        /**
         * Information about the specific installation that this conformance statement relates to
         */
        private String_ description;

        /**
         * The base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        private Uri url;

        /**
         * The software running this instance
         */
        private ConformanceSoftwareComponent software;

        public String_ getDescription() { 
          return this.description;
        }

        public void setDescription(String_ value) { 
          this.description = value;
        }

        public String getDescriptionSimple() { 
          return this.description == null ? null : this.description.getValue();
        }

        public void setDescriptionSimple(String value) { 
          if (value == null)
            this.description = null;
          else {
            if (this.description == null)
              this.description = new String_();
            this.description.setValue(value);
          }
        }

        public Uri getUrl() { 
          return this.url;
        }

        public void setUrl(Uri value) { 
          this.url = value;
        }

        public URI getUrlSimple() { 
          return this.url == null ? null : this.url.getValue();
        }

        public void setUrlSimple(URI value) { 
          if (value == null)
            this.url = null;
          else {
            if (this.url == null)
              this.url = new Uri();
            this.url.setValue(value);
          }
        }

        public ConformanceSoftwareComponent getSoftware() { 
          return this.software;
        }

        public void setSoftware(ConformanceSoftwareComponent value) { 
          this.software = value;
        }

  }

    public class ConformanceProposalComponent extends Element {
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

        public String getDescriptionSimple() { 
          return this.description == null ? null : this.description.getValue();
        }

        public void setDescriptionSimple(String value) { 
          if (value == null)
            this.description = null;
          else {
            if (this.description == null)
              this.description = new String_();
            this.description.setValue(value);
          }
        }

  }

    public class ConformanceRestComponent extends Element {
        /**
         * Identifies whether this portion of the statement is describing ability to initiate or receive restful operations
         */
        private Enumeration<RestfulConformanceMode> mode;

        /**
         * Provides documentation about the system's restful capabilities that apply across all applications, such as security
         */
        private String_ documentation;

        /**
         * Information about security of implementation
         */
        private ConformanceRestSecurityComponent security;

        /**
         * Identifies the restful capabilities of the solution for a specific resource type
         */
        private List<ConformanceRestResourceComponent> resource = new ArrayList<ConformanceRestResourceComponent>();

        /**
         * If batches are supported
         */
        private Boolean batch;

        /**
         * If a system wide history list is supported
         */
        private Boolean history;

        public Enumeration<RestfulConformanceMode> getMode() { 
          return this.mode;
        }

        public void setMode(Enumeration<RestfulConformanceMode> value) { 
          this.mode = value;
        }

        public RestfulConformanceMode getModeSimple() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        public void setModeSimple(RestfulConformanceMode value) { 
          if (value == null)
            this.mode = null;
          else {
            if (this.mode == null)
              this.mode = new Enumeration<RestfulConformanceMode>();
            this.mode.setValue(value);
          }
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public String getDocumentationSimple() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        public void setDocumentationSimple(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new String_();
            this.documentation.setValue(value);
          }
        }

        public ConformanceRestSecurityComponent getSecurity() { 
          return this.security;
        }

        public void setSecurity(ConformanceRestSecurityComponent value) { 
          this.security = value;
        }

        public List<ConformanceRestResourceComponent> getResource() { 
          return this.resource;
        }

        public Boolean getBatch() { 
          return this.batch;
        }

        public void setBatch(Boolean value) { 
          this.batch = value;
        }

        public boolean getBatchSimple() { 
          return this.batch == null ? null : this.batch.getValue();
        }

        public void setBatchSimple(boolean value) { 
          if (value == false)
            this.batch = null;
          else {
            if (this.batch == null)
              this.batch = new Boolean();
            this.batch.setValue(value);
          }
        }

        public Boolean getHistory() { 
          return this.history;
        }

        public void setHistory(Boolean value) { 
          this.history = value;
        }

        public boolean getHistorySimple() { 
          return this.history == null ? null : this.history.getValue();
        }

        public void setHistorySimple(boolean value) { 
          if (value == false)
            this.history = null;
          else {
            if (this.history == null)
              this.history = new Boolean();
            this.history.setValue(value);
          }
        }

  }

    public class ConformanceRestSecurityComponent extends Element {
        /**
         * What type of security services are supported/required
         */
        private List<CodeableConcept> service = new ArrayList<CodeableConcept>();

        /**
         * General description of how security works
         */
        private String_ description;

        /**
         * Certificates associated with security profiles
         */
        private List<ConformanceRestSecurityCertificateComponent> certificate = new ArrayList<ConformanceRestSecurityCertificateComponent>();

        public List<CodeableConcept> getService() { 
          return this.service;
        }

        public String_ getDescription() { 
          return this.description;
        }

        public void setDescription(String_ value) { 
          this.description = value;
        }

        public String getDescriptionSimple() { 
          return this.description == null ? null : this.description.getValue();
        }

        public void setDescriptionSimple(String value) { 
          if (value == null)
            this.description = null;
          else {
            if (this.description == null)
              this.description = new String_();
            this.description.setValue(value);
          }
        }

        public List<ConformanceRestSecurityCertificateComponent> getCertificate() { 
          return this.certificate;
        }

  }

    public class ConformanceRestSecurityCertificateComponent extends Element {
        /**
         * Mime type for certificate
         */
        private Code type;

        /**
         * Actual certificate
         */
        private Base64Binary blob;

        public Code getType() { 
          return this.type;
        }

        public void setType(Code value) { 
          this.type = value;
        }

        public String getTypeSimple() { 
          return this.type == null ? null : this.type.getValue();
        }

        public void setTypeSimple(String value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Code();
            this.type.setValue(value);
          }
        }

        public Base64Binary getBlob() { 
          return this.blob;
        }

        public void setBlob(Base64Binary value) { 
          this.blob = value;
        }

        public byte[] getBlobSimple() { 
          return this.blob == null ? null : this.blob.getValue();
        }

        public void setBlobSimple(byte[] value) { 
          if (value == null)
            this.blob = null;
          else {
            if (this.blob == null)
              this.blob = new Base64Binary();
            this.blob.setValue(value);
          }
        }

  }

    public class ConformanceRestResourceComponent extends Element {
        /**
         * Identifies the resource exposed via the restful interface
         */
        private Code type;

        /**
         * Identifies the profile that describes the solution's support for the resource, including any constraints on cardinality, bindings, lengths or other limitations
         */
        private Uri profile;

        /**
         * Identifies a restful operation supported by the solution
         */
        private List<ConformanceRestResourceOperationComponent> operation = new ArrayList<ConformanceRestResourceOperationComponent>();

        /**
         * A flag for whether the server is able to return past versions as part of the vRead operation
         */
        private Boolean readHistory;

        /**
         * _include values supported by the server
         */
        private List<String_> searchInclude = new ArrayList<String_>();

        /**
         * Defines additional search parameters for implementations to support and/or make use of
         */
        private List<ConformanceRestResourceSearchParamComponent> searchParam = new ArrayList<ConformanceRestResourceSearchParamComponent>();

        public Code getType() { 
          return this.type;
        }

        public void setType(Code value) { 
          this.type = value;
        }

        public String getTypeSimple() { 
          return this.type == null ? null : this.type.getValue();
        }

        public void setTypeSimple(String value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Code();
            this.type.setValue(value);
          }
        }

        public Uri getProfile() { 
          return this.profile;
        }

        public void setProfile(Uri value) { 
          this.profile = value;
        }

        public URI getProfileSimple() { 
          return this.profile == null ? null : this.profile.getValue();
        }

        public void setProfileSimple(URI value) { 
          if (value == null)
            this.profile = null;
          else {
            if (this.profile == null)
              this.profile = new Uri();
            this.profile.setValue(value);
          }
        }

        public List<ConformanceRestResourceOperationComponent> getOperation() { 
          return this.operation;
        }

        public Boolean getReadHistory() { 
          return this.readHistory;
        }

        public void setReadHistory(Boolean value) { 
          this.readHistory = value;
        }

        public boolean getReadHistorySimple() { 
          return this.readHistory == null ? null : this.readHistory.getValue();
        }

        public void setReadHistorySimple(boolean value) { 
          if (value == false)
            this.readHistory = null;
          else {
            if (this.readHistory == null)
              this.readHistory = new Boolean();
            this.readHistory.setValue(value);
          }
        }

        public List<String_> getSearchInclude() { 
          return this.searchInclude;
        }

        public List<ConformanceRestResourceSearchParamComponent> getSearchParam() { 
          return this.searchParam;
        }

  }

    public class ConformanceRestResourceOperationComponent extends Element {
        /**
         * Identifies which operation is supported
         */
        private Enumeration<RestfulOperation> code;

        /**
         * Provides guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'
         */
        private String_ documentation;

        public Enumeration<RestfulOperation> getCode() { 
          return this.code;
        }

        public void setCode(Enumeration<RestfulOperation> value) { 
          this.code = value;
        }

        public RestfulOperation getCodeSimple() { 
          return this.code == null ? null : this.code.getValue();
        }

        public void setCodeSimple(RestfulOperation value) { 
          if (value == null)
            this.code = null;
          else {
            if (this.code == null)
              this.code = new Enumeration<RestfulOperation>();
            this.code.setValue(value);
          }
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public String getDocumentationSimple() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        public void setDocumentationSimple(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new String_();
            this.documentation.setValue(value);
          }
        }

  }

    public class ConformanceRestResourceSearchParamComponent extends Element {
        /**
         * Corresponds to the name of the standard or custom search parameter
         */
        private String_ name;

        /**
         * A formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter
         */
        private Uri source;

        /**
         * The type of value a search parameter refers to, and how the content is interpreted
         */
        private Enumeration<SearchParamType> type;

        /**
         * Whether multiple uses of the parameter are allowed in searches, and if they are, how the multiple values are understood
         */
        private Enumeration<SearchRepeatBehavior> repeats;

        /**
         * For standard parameters, provides additional information on how the parameter is used in this solution.  For custom parameters, provides a description of what the parameter does
         */
        private String_ documentation;

        /**
         * Types of resource (if a resource reference)
         */
        private List<Code> target = new ArrayList<Code>();

        /**
         * Chained names supported
         */
        private List<String_> chain = new ArrayList<String_>();

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public String getNameSimple() { 
          return this.name == null ? null : this.name.getValue();
        }

        public void setNameSimple(String value) { 
          if (value == null)
            this.name = null;
          else {
            if (this.name == null)
              this.name = new String_();
            this.name.setValue(value);
          }
        }

        public Uri getSource() { 
          return this.source;
        }

        public void setSource(Uri value) { 
          this.source = value;
        }

        public URI getSourceSimple() { 
          return this.source == null ? null : this.source.getValue();
        }

        public void setSourceSimple(URI value) { 
          if (value == null)
            this.source = null;
          else {
            if (this.source == null)
              this.source = new Uri();
            this.source.setValue(value);
          }
        }

        public Enumeration<SearchParamType> getType() { 
          return this.type;
        }

        public void setType(Enumeration<SearchParamType> value) { 
          this.type = value;
        }

        public SearchParamType getTypeSimple() { 
          return this.type == null ? null : this.type.getValue();
        }

        public void setTypeSimple(SearchParamType value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<SearchParamType>();
            this.type.setValue(value);
          }
        }

        public Enumeration<SearchRepeatBehavior> getRepeats() { 
          return this.repeats;
        }

        public void setRepeats(Enumeration<SearchRepeatBehavior> value) { 
          this.repeats = value;
        }

        public SearchRepeatBehavior getRepeatsSimple() { 
          return this.repeats == null ? null : this.repeats.getValue();
        }

        public void setRepeatsSimple(SearchRepeatBehavior value) { 
          if (value == null)
            this.repeats = null;
          else {
            if (this.repeats == null)
              this.repeats = new Enumeration<SearchRepeatBehavior>();
            this.repeats.setValue(value);
          }
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public String getDocumentationSimple() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        public void setDocumentationSimple(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new String_();
            this.documentation.setValue(value);
          }
        }

        public List<Code> getTarget() { 
          return this.target;
        }

        public List<String_> getChain() { 
          return this.chain;
        }

  }

    public class ConformanceMessagingComponent extends Element {
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
        private List<ConformanceMessagingEventComponent> event = new ArrayList<ConformanceMessagingEventComponent>();

        public Uri getEndpoint() { 
          return this.endpoint;
        }

        public void setEndpoint(Uri value) { 
          this.endpoint = value;
        }

        public URI getEndpointSimple() { 
          return this.endpoint == null ? null : this.endpoint.getValue();
        }

        public void setEndpointSimple(URI value) { 
          if (value == null)
            this.endpoint = null;
          else {
            if (this.endpoint == null)
              this.endpoint = new Uri();
            this.endpoint.setValue(value);
          }
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public String getDocumentationSimple() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        public void setDocumentationSimple(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new String_();
            this.documentation.setValue(value);
          }
        }

        public List<ConformanceMessagingEventComponent> getEvent() { 
          return this.event;
        }

  }

    public class ConformanceMessagingEventComponent extends Element {
        /**
         * Identifies the supported messaging event
         */
        private Code code;

        /**
         * The mode of this event declaration - whether application is sender or receiver
         */
        private Enumeration<MessageConformanceEventMode> mode;

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

        public String getCodeSimple() { 
          return this.code == null ? null : this.code.getValue();
        }

        public void setCodeSimple(String value) { 
          if (value == null)
            this.code = null;
          else {
            if (this.code == null)
              this.code = new Code();
            this.code.setValue(value);
          }
        }

        public Enumeration<MessageConformanceEventMode> getMode() { 
          return this.mode;
        }

        public void setMode(Enumeration<MessageConformanceEventMode> value) { 
          this.mode = value;
        }

        public MessageConformanceEventMode getModeSimple() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        public void setModeSimple(MessageConformanceEventMode value) { 
          if (value == null)
            this.mode = null;
          else {
            if (this.mode == null)
              this.mode = new Enumeration<MessageConformanceEventMode>();
            this.mode.setValue(value);
          }
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

        public String getFocusSimple() { 
          return this.focus == null ? null : this.focus.getValue();
        }

        public void setFocusSimple(String value) { 
          if (value == null)
            this.focus = null;
          else {
            if (this.focus == null)
              this.focus = new Code();
            this.focus.setValue(value);
          }
        }

        public Uri getRequest() { 
          return this.request;
        }

        public void setRequest(Uri value) { 
          this.request = value;
        }

        public URI getRequestSimple() { 
          return this.request == null ? null : this.request.getValue();
        }

        public void setRequestSimple(URI value) { 
          if (value == null)
            this.request = null;
          else {
            if (this.request == null)
              this.request = new Uri();
            this.request.setValue(value);
          }
        }

        public Uri getResponse() { 
          return this.response;
        }

        public void setResponse(Uri value) { 
          this.response = value;
        }

        public URI getResponseSimple() { 
          return this.response == null ? null : this.response.getValue();
        }

        public void setResponseSimple(URI value) { 
          if (value == null)
            this.response = null;
          else {
            if (this.response == null)
              this.response = new Uri();
            this.response.setValue(value);
          }
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public String getDocumentationSimple() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        public void setDocumentationSimple(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new String_();
            this.documentation.setValue(value);
          }
        }

  }

    public class ConformanceDocumentComponent extends Element {
        /**
         * The mode of this event declaration - whether application is sender or receiver
         */
        private Enumeration<DocumentMode> mode;

        /**
         * Describes how the application supports or uses the specified document profile.  For example, when are documents created, what action is taken with consumed documents, etc.
         */
        private String_ documentation;

        /**
         * Constraint on a resource used in the document
         */
        private Uri profile;

        public Enumeration<DocumentMode> getMode() { 
          return this.mode;
        }

        public void setMode(Enumeration<DocumentMode> value) { 
          this.mode = value;
        }

        public DocumentMode getModeSimple() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        public void setModeSimple(DocumentMode value) { 
          if (value == null)
            this.mode = null;
          else {
            if (this.mode == null)
              this.mode = new Enumeration<DocumentMode>();
            this.mode.setValue(value);
          }
        }

        public String_ getDocumentation() { 
          return this.documentation;
        }

        public void setDocumentation(String_ value) { 
          this.documentation = value;
        }

        public String getDocumentationSimple() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        public void setDocumentationSimple(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new String_();
            this.documentation.setValue(value);
          }
        }

        public Uri getProfile() { 
          return this.profile;
        }

        public void setProfile(Uri value) { 
          this.profile = value;
        }

        public URI getProfileSimple() { 
          return this.profile == null ? null : this.profile.getValue();
        }

        public void setProfileSimple(URI value) { 
          if (value == null)
            this.profile = null;
          else {
            if (this.profile == null)
              this.profile = new Uri();
            this.profile.setValue(value);
          }
        }

  }

    /**
     * Date that the conformance statement is published
     */
    private DateTime date;

    /**
     * The organization that publishes this conformance statement
     */
    private ConformancePublisherComponent publisher;

    /**
     * Describes the software that is covered by this conformance statement.  Used when the profile describes the capabilities of a particular software version, independent of an installation.
     */
    private ConformanceSoftwareComponent software;

    /**
     * Used when the statement describes the capabilities of a specific implementation instance - i.e. a particular installation, rather than the capabilities of a software program
     */
    private ConformanceImplementationComponent implementation;

    /**
     * Describes the proposed solution described by this conformance statement.  Used when the profile describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    private ConformanceProposalComponent proposal;

    /**
     * The version of the FHIR specification on which this conformance statement is based
     */
    private Id version;

    /**
     * Whether the application accepts unknown non-"must understand" elements as part of a resource. This does not include extensions, but genuine new additions to a resource
     */
    private Boolean acceptUnknown;

    /**
     * The formats supported by this implementation
     */
    private List<Code> format = new ArrayList<Code>();

    /**
     * Defines the restful capabilities of the solution, if any
     */
    private List<ConformanceRestComponent> rest = new ArrayList<ConformanceRestComponent>();

    /**
     * Describes the messaging capabilities of the solution
     */
    private List<ConformanceMessagingComponent> messaging = new ArrayList<ConformanceMessagingComponent>();

    /**
     * A document definition
     */
    private List<ConformanceDocumentComponent> document = new ArrayList<ConformanceDocumentComponent>();

    public DateTime getDate() { 
      return this.date;
    }

    public void setDate(DateTime value) { 
      this.date = value;
    }

    public String getDateSimple() { 
      return this.date == null ? null : this.date.getValue();
    }

    public void setDateSimple(String value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTime();
        this.date.setValue(value);
      }
    }

    public ConformancePublisherComponent getPublisher() { 
      return this.publisher;
    }

    public void setPublisher(ConformancePublisherComponent value) { 
      this.publisher = value;
    }

    public ConformanceSoftwareComponent getSoftware() { 
      return this.software;
    }

    public void setSoftware(ConformanceSoftwareComponent value) { 
      this.software = value;
    }

    public ConformanceImplementationComponent getImplementation() { 
      return this.implementation;
    }

    public void setImplementation(ConformanceImplementationComponent value) { 
      this.implementation = value;
    }

    public ConformanceProposalComponent getProposal() { 
      return this.proposal;
    }

    public void setProposal(ConformanceProposalComponent value) { 
      this.proposal = value;
    }

    public Id getVersion() { 
      return this.version;
    }

    public void setVersion(Id value) { 
      this.version = value;
    }

    public String getVersionSimple() { 
      return this.version == null ? null : this.version.getValue();
    }

    public void setVersionSimple(String value) { 
      if (value == null)
        this.version = null;
      else {
        if (this.version == null)
          this.version = new Id();
        this.version.setValue(value);
      }
    }

    public Boolean getAcceptUnknown() { 
      return this.acceptUnknown;
    }

    public void setAcceptUnknown(Boolean value) { 
      this.acceptUnknown = value;
    }

    public boolean getAcceptUnknownSimple() { 
      return this.acceptUnknown == null ? null : this.acceptUnknown.getValue();
    }

    public void setAcceptUnknownSimple(boolean value) { 
      if (value == false)
        this.acceptUnknown = null;
      else {
        if (this.acceptUnknown == null)
          this.acceptUnknown = new Boolean();
        this.acceptUnknown.setValue(value);
      }
    }

    public List<Code> getFormat() { 
      return this.format;
    }

    public List<ConformanceRestComponent> getRest() { 
      return this.rest;
    }

    public List<ConformanceMessagingComponent> getMessaging() { 
      return this.messaging;
    }

    public List<ConformanceDocumentComponent> getDocument() { 
      return this.document;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Conformance;
   }


}

