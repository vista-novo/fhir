package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2012, HL7, Inc
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

// Generated on Sat, Jun 2, 2012 08:18+1000 for FHIR v0.03

import java.util.*;

/**
 * A message that contains FHIR resources
 */
public class Message extends Resource {

    public enum ResponseCode {
        ok, // The message was accepted and processed without error
        error, // Some internal unexpected error occured - wait and try again. Note - this is usually used for things like database unavailable, which may be expected to resolve, though human intervention may be required
        rejection, // The message was rejected because of some content in it. There is no point in re-sending without change. The response narrative must describe what the issue is
        rules, // The message was rejected because of some event-specific business rules, and it may be possible to modify the request and re-submit (as a different request). The response data must clarify what the change would be, as described by the event definition
        undeliverable; // A middleware agent was unable to deliver the message to it's supposed destination
        public static ResponseCode fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("ok".equals(code))
          return ok;
        if ("error".equals(code))
          return error;
        if ("rejection".equals(code))
          return rejection;
        if ("rules".equals(code))
          return rules;
        if ("undeliverable".equals(code))
          return undeliverable;
        throw new Exception("Unknown ResponseCode code '"+code+"'");
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

        /**
         * True if this is not the first response, because the request message has been received more than once
         */
        private boolean duplicate;

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

        public boolean getDuplicate() { 
          return this.duplicate;
        }

        public void setDuplicate(boolean value) { 
          this.duplicate = value;
        }

    }

    public class Source extends Element {
        /**
         * Name of system
         */
        private String name;

        /**
         * Name of software running the system
         */
        private String software;

        /**
         * Version of software running
         */
        private String_ version;

        /**
         * Human contact for problems
         */
        private Contact contact;

        /**
         * Actual message source address (if applicable)
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
         * Name of system
         */
        private String name;

        /**
         * particular delivery destination within the destination
         */
        private ResourceReference target;

        /**
         * Actual destination address (if applicable)
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
     * Id of the thread - a series of messages that pertain to the same logical sequence, and are all identified by the same thread identifier
     */
    private String threadId;

    /**
     * Instant the message was sent
     */
    private java.util.Date instant;

    /**
     * Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification
     */
    private String event;

    /**
     * Information about the the message that this message is a response to - if it is a response
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
     * The person or device that performd the data entry leading to this message. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
     */
    private ResourceReference enterer;

    /**
     * The logical author of the message - the person or device that decided it should happen. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
     */
    private ResourceReference author;

    /**
     * The person or organization that accepts overall responsbility for the contents of the message. The implication is that the message event happened under the policies of the responsible party
     */
    private ResourceReference responsible;

    /**
     * The effective time - the real world time of the even that the message represents. Usually this is just a starting time, but some message events also have an end time (do x for period y)
     */
    private Interval<DateTime> effective;

    /**
     * The cause of the event - a reason for why this message is being sent
     */
    private CodeableConcept reason;

    /**
     * The actual data of the message - a reference to the focus class of the message. 
     */
    private List<ResourceReference> data = new ArrayList<ResourceReference>();

    public String getThreadId() { 
      return this.threadId;
    }

    public void setThreadId(String value) { 
      this.threadId = value;
    }

    public java.util.Date getInstant() { 
      return this.instant;
    }

    public void setInstant(java.util.Date value) { 
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

    public ResourceReference getResponsible() { 
      return this.responsible;
    }

    public void setResponsible(ResourceReference value) { 
      this.responsible = value;
    }

    public Interval<DateTime> getEffective() { 
      return this.effective;
    }

    public void setEffective(Interval<DateTime> value) { 
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

