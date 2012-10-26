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

// Generated on Fri, Oct 26, 2012 20:23+1100 for FHIR v0.06

import java.util.*;

/**
 * A transmission requesting action on a bundle of one or more resources or a response to such a request
 */
public class MessageHeader extends Resource {

    public enum ResponseCode {
        ok, // The message was accepted and processed without error
        error, // Some internal unexpected error occurred - wait and try again. Note - this is usually used for things like database unavailable, which may be expected to resolve, though human intervention may be required
        rejection, // The message was rejected because of some content in it. There is no point in re-sending without change. The response narrative must describe what the issue is
        rules, // The message was rejected because of some event-specific business rules, and it may be possible to modify the request and re-submit (as a different request). The response data must clarify what the change would be, as described by the event definition
        undeliverable; // A middleware agent was unable to deliver the message to its intended destination
        public static ResponseCode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ok".equals(codeString))
          return ok;
        if ("error".equals(codeString))
          return error;
        if ("rejection".equals(codeString))
          return rejection;
        if ("rules".equals(codeString))
          return rules;
        if ("undeliverable".equals(codeString))
          return undeliverable;
        throw new Exception("Unknown ResponseCode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ok: return "ok";
            case error: return "error";
            case rejection: return "rejection";
            case rules: return "rules";
            case undeliverable: return "undeliverable";
            default: return "?";
          }
        }
    }

    public class Response extends Element {
        /**
         * The id of the message that this a response to
         */
        private String id;

        /**
         * Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not
         */
        private ResponseCode code;

        public String getId() { 
          return this.id;
        }

        public void setId(String value) { 
          this.id = value;
        }

        public ResponseCode getCode() { 
          return this.code;
        }

        public void setCode(ResponseCode value) { 
          this.code = value;
        }

    }

    public class Source extends Element {
        /**
         * Human readable name for the target system
         */
        private String name;

        /**
         * May include configuration or other information useful in debugging.
         */
        private String software;

        /**
         * Can convey versions of multiple systems in situations where a message passes through multiple hands.
         */
        private String_ version;

        /**
         * An e-mail, phone, website or other contact point to use to resolve issues with message communications.
         */
        private Contact contact;

        /**
         * Identifies the routing target to send acknowledgements to.
         */
        private java.net.URI endpoint;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public String getSoftware() { 
          return this.software;
        }

        public void setSoftware(String value) { 
          this.software = value;
        }

        public String_ getVersion() { 
          return this.version;
        }

        public void setVersion(String_ value) { 
          this.version = value;
        }

        public Contact getContact() { 
          return this.contact;
        }

        public void setContact(Contact value) { 
          this.contact = value;
        }

        public java.net.URI getEndpoint() { 
          return this.endpoint;
        }

        public void setEndpoint(java.net.URI value) { 
          this.endpoint = value;
        }

    }

    public class Destination extends Element {
        /**
         * Human readable name for the source system
         */
        private String name;

        /**
         * Identifies the target end system in situations where the initial message transmission is to an intermediary system.
         */
        private ResourceReference target;

        /**
         * Indicates where the message should be routed to.
         */
        private java.net.URI endpoint;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public ResourceReference getTarget() { 
          return this.target;
        }

        public void setTarget(ResourceReference value) { 
          this.target = value;
        }

        public java.net.URI getEndpoint() { 
          return this.endpoint;
        }

        public void setEndpoint(java.net.URI value) { 
          this.endpoint = value;
        }

    }

    /**
     * Instant the message was sent
     */
    private java.util.Calendar instant;

    /**
     * Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification
     */
    private String event;

    /**
     * Information about the message that this message is a response to.  Only present if this message is a response.
     */
    private Response response;

    /**
     * The source application from which this message originated
     */
    private Source source;

    /**
     * The destination application which the message is intended for
     */
    private Destination destination;

    /**
     * The person or device that performed the data entry leading to this MessageHeader. Where there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other enterers in extensions
     */
    private ResourceReference enterer;

    /**
     * The logical author of the message - the person or device that decided the described event should happen. Where there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other authors in extensions
     */
    private ResourceReference author;

    /**
     * Allows data conveyed by a message to be addressed to a particular person or department when routing to a specific application isn't sufficient.
     */
    private ResourceReference receiver;

    /**
     * The person or organization that accepts overall responsibility for the contents of the MessageHeader. The implication is that the message event happened under the policies of the responsible party
     */
    private ResourceReference responsible;

    /**
     * The effective time - the real world time of the event that the message represents. Usually this is just a starting time, but some message events also have an end time (do x for period y)
     */
    private Period effective;

    /**
     * The cause of the event - a reason for the event that is a focus of this message occurred
     */
    private CodeableConcept reason;

    /**
     * The actual data of the message - a reference to the root/focus class of the event. 
     */
    private List<ResourceReference> data = new ArrayList<ResourceReference>();

    public java.util.Calendar getInstant() { 
      return this.instant;
    }

    public void setInstant(java.util.Calendar value) { 
      this.instant = value;
    }

    public String getEvent() { 
      return this.event;
    }

    public void setEvent(String value) { 
      this.event = value;
    }

    public Response getResponse() { 
      return this.response;
    }

    public void setResponse(Response value) { 
      this.response = value;
    }

    public Source getSource() { 
      return this.source;
    }

    public void setSource(Source value) { 
      this.source = value;
    }

    public Destination getDestination() { 
      return this.destination;
    }

    public void setDestination(Destination value) { 
      this.destination = value;
    }

    public ResourceReference getEnterer() { 
      return this.enterer;
    }

    public void setEnterer(ResourceReference value) { 
      this.enterer = value;
    }

    public ResourceReference getAuthor() { 
      return this.author;
    }

    public void setAuthor(ResourceReference value) { 
      this.author = value;
    }

    public ResourceReference getReceiver() { 
      return this.receiver;
    }

    public void setReceiver(ResourceReference value) { 
      this.receiver = value;
    }

    public ResourceReference getResponsible() { 
      return this.responsible;
    }

    public void setResponsible(ResourceReference value) { 
      this.responsible = value;
    }

    public Period getEffective() { 
      return this.effective;
    }

    public void setEffective(Period value) { 
      this.effective = value;
    }

    public CodeableConcept getReason() { 
      return this.reason;
    }

    public void setReason(CodeableConcept value) { 
      this.reason = value;
    }

    public List<ResourceReference> getData() { 
      return this.data;
    }


}

