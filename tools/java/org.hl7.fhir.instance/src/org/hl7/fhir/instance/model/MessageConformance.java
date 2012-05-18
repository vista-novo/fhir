package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Fri, May 18, 2012 22:20+1000 for FHIR v0.02

import java.util.*;

/**
 * A conformance statement about how an application uses FHIR messaging
 */
public class MessageConformance extends Resource {

    public enum MessageConformanceEventMode {
        sender, // The application sends requests and receives responses
        receiver; // The application receives requests and sends responses
        public static MessageConformanceEventMode fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("sender".equals(code))
          return sender;
        if ("receiver".equals(code))
          return receiver;
        throw new Exception("Unknown MessageConformanceEventMode code '"+code+"'");
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

    public class Event extends Element {
        /**
         * The code for the event
         */
        private Code code;

        /**
         * The focal resource for the event
         */
        private Code resource;

        /**
         * The mode of this event declaration - whether application is sender or receiver
         */
        private MessageConformanceEventMode mode;

        /**
         * Information about the request for this event
         */
        private Request request;

        /**
         * Information about the response for this event
         */
        private Response response;

        public Code getCode() { 
          return this.code;
        }

        public void setCode(Code value) { 
          this.code = value;
        }

        public Code getResource() { 
          return this.resource;
        }

        public void setResource(Code value) { 
          this.resource = value;
        }

        public MessageConformanceEventMode getMode() { 
          return this.mode;
        }

        public void setMode(MessageConformanceEventMode value) { 
          this.mode = value;
        }

        public Request getRequest() { 
          return this.request;
        }

        public void setRequest(Request value) { 
          this.request = value;
        }

        public Response getResponse() { 
          return this.response;
        }

        public void setResponse(Response value) { 
          this.response = value;
        }

    }

    public class Request extends Element {
        /**
         * Constraint on a resource used in the event request
         */
        private List<Constraint> resource = new ArrayList<Constraint>();

        public List<Constraint> getResource() { 
          return this.resource;
        }

    }

    public class Response extends Element {
        /**
         * Constraint on a resource used in the event response
         */
        private List<Constraint> resource = new ArrayList<Constraint>();

        public List<Constraint> getResource() { 
          return this.resource;
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
     * Additional other profiles that apply to this conformance statement.
     */
    private List<Uri> profile = new ArrayList<Uri>();

    /**
     * An event supported by the application
     */
    private List<Event> event = new ArrayList<Event>();

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

    public List<Uri> getProfile() { 
      return this.profile;
    }

    public List<Event> getEvent() { 
      return this.event;
    }


}

