package org.hl7.fhir.instance.model;

// © HL7 (http://www.hl7.org)  Generated on 10:56 Apr 10, 2012 for FHIR v0.01

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
    }

    public class Response extends Element {
        /**
         * The id of the message that this a response to
         */
        private Id id;

        /**
         * Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not
         */
        private ResponseCode code;

        /**
         * True if this is not the first response, because the request message has been received more than once
         */
        private Boolean duplicate;

        public Id getId() { 
          return this.id;
        }

        public void setId(Id value) { 
          this.id = value;
        }

        public ResponseCode getCode() { 
          return this.code;
        }

        public void setCode(ResponseCode value) { 
          this.code = value;
        }

        public Boolean getDuplicate() { 
          return this.duplicate;
        }

        public void setDuplicate(Boolean value) { 
          this.duplicate = value;
        }

    }

    /**
     * Id of the thread - a series of messages that pertain to the same logical sequence, and are all identified by the same thread identifier
     */
    private Id threadId;

    /**
     * Instant the message was sent
     */
    private Instant instant;

    /**
     * Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification
     */
    private Code event;

    /**
     * Information about the the message that this message is a response to - if it is a response
     */
    private Response response;

    /**
     * The source application from which this message originated
     */
    private ResourceReference source;

    /**
     * The destination application which the message is intended for
     */
    private ResourceReference destination;

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
    private ResourceReference data;

    public Id getThreadId() { 
      return this.threadId;
    }

    public void setThreadId(Id value) { 
      this.threadId = value;
    }

    public Instant getInstant() { 
      return this.instant;
    }

    public void setInstant(Instant value) { 
      this.instant = value;
    }

    public Code getEvent() { 
      return this.event;
    }

    public void setEvent(Code value) { 
      this.event = value;
    }

    public Response getResponse() { 
      return this.response;
    }

    public void setResponse(Response value) { 
      this.response = value;
    }

    public ResourceReference getSource() { 
      return this.source;
    }

    public void setSource(ResourceReference value) { 
      this.source = value;
    }

    public ResourceReference getDestination() { 
      return this.destination;
    }

    public void setDestination(ResourceReference value) { 
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

    public ResourceReference getData() { 
      return this.data;
    }

    public void setData(ResourceReference value) { 
      this.data = value;
    }


}

