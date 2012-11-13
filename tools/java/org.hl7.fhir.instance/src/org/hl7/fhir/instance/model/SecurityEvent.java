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

// Generated on Tue, Nov 13, 2012 15:23+1100 for FHIR v0.06

import java.util.*;

/**
 * A record of an event 
 */
public class SecurityEvent extends Resource {

    public enum SecurityEventEventAction {
        C, // Create
        R, // Read/View/Print/Query
        U, // Update
        D, // Delete
        E; // Execute
        public static SecurityEventEventAction fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("C".equals(codeString))
          return C;
        if ("R".equals(codeString))
          return R;
        if ("U".equals(codeString))
          return U;
        if ("D".equals(codeString))
          return D;
        if ("E".equals(codeString))
          return E;
        throw new Exception("Unknown SecurityEventEventAction code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case C: return "C";
            case R: return "R";
            case U: return "U";
            case D: return "D";
            case E: return "E";
            default: return "?";
          }
        }
    }

    public enum SecurityEventEventOutcome {
        _0, // Success
        _4, // Minor failure
        _8, // Serious failure
        _12; // Major failure
        public static SecurityEventEventOutcome fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("0".equals(codeString))
          return _0;
        if ("4".equals(codeString))
          return _4;
        if ("8".equals(codeString))
          return _8;
        if ("12".equals(codeString))
          return _12;
        throw new Exception("Unknown SecurityEventEventOutcome code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _0: return "0";
            case _4: return "4";
            case _8: return "8";
            case _12: return "12";
            default: return "?";
          }
        }
    }

    public enum NetworkType {
        name, // Machine Name, including DNS name
        ip, // IP Address
        phone; // Telephone Number
        public static NetworkType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("name".equals(codeString))
          return name;
        if ("ip".equals(codeString))
          return ip;
        if ("phone".equals(codeString))
          return phone;
        throw new Exception("Unknown NetworkType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case name: return "name";
            case ip: return "ip";
            case phone: return "phone";
            default: return "?";
          }
        }
    }

    public enum ObjectType {
        _1, // Person
        _2, // System Object
        _3, // Organization
        _4; // Other
        public static ObjectType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("1".equals(codeString))
          return _1;
        if ("2".equals(codeString))
          return _2;
        if ("3".equals(codeString))
          return _3;
        if ("4".equals(codeString))
          return _4;
        throw new Exception("Unknown ObjectType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _1: return "1";
            case _2: return "2";
            case _3: return "3";
            case _4: return "4";
            default: return "?";
          }
        }
    }

    public enum ObjectRole {
        _1, // Patient
        _2, // Location
        _3, // Report
        _4, // Resource
        _5, // Master file
        _6, // User
        _7, // List
        _8, // Doctor
        _9, // Subscriber
        _10, // Guarantor
        _11, // Security User Entity
        _12, // Security User Group
        _13, // Security Resource
        _14, // Security Granularity Definition
        _15, // Provider
        _16, // Data Destination
        _17, // Data Repository
        _18, // Schedule
        _19, // Customer
        _20, // Job
        _21, // Job Stream
        _22, // Table
        _23, // Routing Criteria
        _24; // Query
        public static ObjectRole fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("1".equals(codeString))
          return _1;
        if ("2".equals(codeString))
          return _2;
        if ("3".equals(codeString))
          return _3;
        if ("4".equals(codeString))
          return _4;
        if ("5".equals(codeString))
          return _5;
        if ("6".equals(codeString))
          return _6;
        if ("7".equals(codeString))
          return _7;
        if ("8".equals(codeString))
          return _8;
        if ("9".equals(codeString))
          return _9;
        if ("10".equals(codeString))
          return _10;
        if ("11".equals(codeString))
          return _11;
        if ("12".equals(codeString))
          return _12;
        if ("13".equals(codeString))
          return _13;
        if ("14".equals(codeString))
          return _14;
        if ("15".equals(codeString))
          return _15;
        if ("16".equals(codeString))
          return _16;
        if ("17".equals(codeString))
          return _17;
        if ("18".equals(codeString))
          return _18;
        if ("19".equals(codeString))
          return _19;
        if ("20".equals(codeString))
          return _20;
        if ("21".equals(codeString))
          return _21;
        if ("22".equals(codeString))
          return _22;
        if ("23".equals(codeString))
          return _23;
        if ("24".equals(codeString))
          return _24;
        throw new Exception("Unknown ObjectRole code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _1: return "1";
            case _2: return "2";
            case _3: return "3";
            case _4: return "4";
            case _5: return "5";
            case _6: return "6";
            case _7: return "7";
            case _8: return "8";
            case _9: return "9";
            case _10: return "10";
            case _11: return "11";
            case _12: return "12";
            case _13: return "13";
            case _14: return "14";
            case _15: return "15";
            case _16: return "16";
            case _17: return "17";
            case _18: return "18";
            case _19: return "19";
            case _20: return "20";
            case _21: return "21";
            case _22: return "22";
            case _23: return "23";
            case _24: return "24";
            default: return "?";
          }
        }
    }

    public enum ObjectLifecycle {
        _1, // Origination / Creation
        _2, // Import / Copy from original
        _3, // Amendment
        _4, // Verification
        _5, // Translation
        _6, // Access / Use
        _7, // De-identification
        _8, // Aggregation, summarization, derivation
        _9, // Report
        _10, // Export / Copy to target
        _11, // Disclosure
        _12, // Receipt of disclosure
        _13, // Archiving
        _14, // Logical deletion
        _15; // Permanent erasure / Physical destruction
        public static ObjectLifecycle fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("1".equals(codeString))
          return _1;
        if ("2".equals(codeString))
          return _2;
        if ("3".equals(codeString))
          return _3;
        if ("4".equals(codeString))
          return _4;
        if ("5".equals(codeString))
          return _5;
        if ("6".equals(codeString))
          return _6;
        if ("7".equals(codeString))
          return _7;
        if ("8".equals(codeString))
          return _8;
        if ("9".equals(codeString))
          return _9;
        if ("10".equals(codeString))
          return _10;
        if ("11".equals(codeString))
          return _11;
        if ("12".equals(codeString))
          return _12;
        if ("13".equals(codeString))
          return _13;
        if ("14".equals(codeString))
          return _14;
        if ("15".equals(codeString))
          return _15;
        throw new Exception("Unknown ObjectLifecycle code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _1: return "1";
            case _2: return "2";
            case _3: return "3";
            case _4: return "4";
            case _5: return "5";
            case _6: return "6";
            case _7: return "7";
            case _8: return "8";
            case _9: return "9";
            case _10: return "10";
            case _11: return "11";
            case _12: return "12";
            case _13: return "13";
            case _14: return "14";
            case _15: return "15";
            default: return "?";
          }
        }
    }

    public class Event extends Element {
        /**
         * Identifier for a specific audited event
         */
        private Coding id;

        /**
         * Indicator for type of action performed during the event that generated the audit
         */
        private SecurityEventEventAction action;

        /**
         * The time when the event occurred on the source
         */
        private Instant dateTime;

        /**
         * Indicates whether the event succeeded or failed
         */
        private SecurityEventEventOutcome outcome;

        /**
         * Identifier for the category of event
         */
        private List<Coding> code = new ArrayList<Coding>();

        public Coding getId() { 
          return this.id;
        }

        public void setId(Coding value) { 
          this.id = value;
        }

        public SecurityEventEventAction getAction() { 
          return this.action;
        }

        public void setAction(SecurityEventEventAction value) { 
          this.action = value;
        }

        public Instant getDateTime() { 
          return this.dateTime;
        }

        public void setDateTime(Instant value) { 
          this.dateTime = value;
        }

        public SecurityEventEventOutcome getOutcome() { 
          return this.outcome;
        }

        public void setOutcome(SecurityEventEventOutcome value) { 
          this.outcome = value;
        }

        public List<Coding> getCode() { 
          return this.code;
        }

    }

    public class Participant extends Element {
        /**
         * Unique identifier for the user actively participating in the event
         */
        private String_ userId;

        /**
         * User identifier text string from authentication system. This identifier would be one known to a common authentication system (e.g., single sign-on), if available
         */
        private String_ otherUserId;

        /**
         * human-meaningful name for the user
         */
        private String_ name;

        /**
         * Indicator that the user is or is not the requestor, or initiator, for the event being audited.
         */
        private Boolean requestor;

        /**
         * Specification of the role(s) the user plays when performing the event, as assigned in role-based access control security
         */
        private List<Coding> role = new ArrayList<Coding>();

        /**
         * logical network location for application activity
         */
        private Network network;

        public String_ getUserId() { 
          return this.userId;
        }

        public void setUserId(String_ value) { 
          this.userId = value;
        }

        public String_ getOtherUserId() { 
          return this.otherUserId;
        }

        public void setOtherUserId(String_ value) { 
          this.otherUserId = value;
        }

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public Boolean getRequestor() { 
          return this.requestor;
        }

        public void setRequestor(Boolean value) { 
          this.requestor = value;
        }

        public List<Coding> getRole() { 
          return this.role;
        }

        public Network getNetwork() { 
          return this.network;
        }

        public void setNetwork(Network value) { 
          this.network = value;
        }

    }

    public class Network extends Element {
        /**
         * An identifier for the type of network access point that originated the audit event
         */
        private NetworkType type;

        /**
         * An identifier for the network access point of the user device for the audit event
         */
        private String_ id;

        public NetworkType getType() { 
          return this.type;
        }

        public void setType(NetworkType value) { 
          this.type = value;
        }

        public String_ getId() { 
          return this.id;
        }

        public void setId(String_ value) { 
          this.id = value;
        }

    }

    public class Source extends Element {
        /**
         * Logical source location within the healthcare enterprise network
         */
        private String_ site;

        /**
         * Identifier of the source where the event originated
         */
        private String_ id;

        /**
         * Code specifying the type of source where event originated
         */
        private List<Coding> type = new ArrayList<Coding>();

        public String_ getSite() { 
          return this.site;
        }

        public void setSite(String_ value) { 
          this.site = value;
        }

        public String_ getId() { 
          return this.id;
        }

        public void setId(String_ value) { 
          this.id = value;
        }

        public List<Coding> getType() { 
          return this.type;
        }

    }

    public class Object extends Element {
        /**
         * object type being audited
         */
        private ObjectType type;

        /**
         * Code representing the functional application role of Participant Object being audited
         */
        private ObjectRole role;

        /**
         * Identifier for the data life-cycle stage for the participant object
         */
        private ObjectLifecycle lifecycle;

        /**
         * Describes the identifier that is contained in Participant Object ID
         */
        private Coding idType;

        /**
         * Identifies a specific instance of the participant object
         */
        private String_ id;

        /**
         * Denotes policy-defined sensitivity for the Participant Object ID such as VIP, HIV status, mental health status, or similar topics
         */
        private String_ sensitivity;

        /**
         * An instance-specific descriptor of the Participant Object ID audited, such as a person's name
         */
        private String_ name;

        /**
         * The actual query for a query-type participant object
         */
        private Base64Binary query;

        public ObjectType getType() { 
          return this.type;
        }

        public void setType(ObjectType value) { 
          this.type = value;
        }

        public ObjectRole getRole() { 
          return this.role;
        }

        public void setRole(ObjectRole value) { 
          this.role = value;
        }

        public ObjectLifecycle getLifecycle() { 
          return this.lifecycle;
        }

        public void setLifecycle(ObjectLifecycle value) { 
          this.lifecycle = value;
        }

        public Coding getIdType() { 
          return this.idType;
        }

        public void setIdType(Coding value) { 
          this.idType = value;
        }

        public String_ getId() { 
          return this.id;
        }

        public void setId(String_ value) { 
          this.id = value;
        }

        public String_ getSensitivity() { 
          return this.sensitivity;
        }

        public void setSensitivity(String_ value) { 
          this.sensitivity = value;
        }

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public Base64Binary getQuery() { 
          return this.query;
        }

        public void setQuery(Base64Binary value) { 
          this.query = value;
        }

    }

    /**
     * identifies the name, action type, time, and disposition of the audited event
     */
    private Event event;

    /**
     * a person, or a hardware device or software process
     */
    private List<Participant> participant = new ArrayList<Participant>();

    /**
     * application systems and processes
     */
    private List<Source> source = new ArrayList<Source>();

    /**
     * specific instances of data or objects that have been accessed
     */
    private List<Object> object = new ArrayList<Object>();

    public Event getEvent() { 
      return this.event;
    }

    public void setEvent(Event value) { 
      this.event = value;
    }

    public List<Participant> getParticipant() { 
      return this.participant;
    }

    public List<Source> getSource() { 
      return this.source;
    }

    public List<Object> getObject() { 
      return this.object;
    }


}

