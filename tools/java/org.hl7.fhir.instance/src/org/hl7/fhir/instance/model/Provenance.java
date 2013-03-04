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

// Generated on Mon, Mar 4, 2013 20:03+1100 for FHIR v0.07

import java.util.*;

import java.net.*;
/**
 * Provenance information associated with another resource that can be used to help determine its reliability or trace where the information in it came from. The focus of the provenance resource is record keeping, audit and traceability, not clinical meaning
 */
public class Provenance extends Resource {

    public class Activity extends Element {
        /**
         * The period during which the activity occurred
         */
        private Period period;

        /**
         * The instant of time at which the activity was recorded
         */
        private Instant recorded;

        /**
         * The reason that the activity was taking place
         */
        private CodeableConcept reason;

        /**
         * Where the activity occurred, if relevant
         */
        private Location location;

        /**
         * Policy or plan the activity was defined by
         */
        private Uri policy;

        public Period getPeriod() { 
          return this.period;
        }

        public void setPeriod(Period value) { 
          this.period = value;
        }

        public Instant getRecorded() { 
          return this.recorded;
        }

        public void setRecorded(Instant value) { 
          this.recorded = value;
        }

        public Calendar getRecordedSimple() { 
          return this.recorded == null ? null : this.recorded.getValue();
        }

        public void setRecordedSimple(Calendar value) { 
          if (value == null)
            this.recorded = null;
          else {
            if (this.recorded == null)
              this.recorded = new Instant();
            this.recorded.setValue(value);
          }
        }

        public CodeableConcept getReason() { 
          return this.reason;
        }

        public void setReason(CodeableConcept value) { 
          this.reason = value;
        }

        public Location getLocation() { 
          return this.location;
        }

        public void setLocation(Location value) { 
          this.location = value;
        }

        public Uri getPolicy() { 
          return this.policy;
        }

        public void setPolicy(Uri value) { 
          this.policy = value;
        }

        public URI getPolicySimple() { 
          return this.policy == null ? null : this.policy.getValue();
        }

        public void setPolicySimple(URI value) { 
          if (value == null)
            this.policy = null;
          else {
            if (this.policy == null)
              this.policy = new Uri();
            this.policy.setValue(value);
          }
        }

  }

    public class Location extends Element {
        /**
         * The type of location - a classification of the kind of location at which the activity took place
         */
        private CodeableConcept type;

        /**
         * An identifier for the location
         */
        private Identifier id;

        /**
         * Human readable description of location at which the activity occurred
         */
        private String_ description;

        /**
         * Geospatial coordinates of the location
         */
        private String_ coords;

        public CodeableConcept getType() { 
          return this.type;
        }

        public void setType(CodeableConcept value) { 
          this.type = value;
        }

        public Identifier getId() { 
          return this.id;
        }

        public void setId(Identifier value) { 
          this.id = value;
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

        public String_ getCoords() { 
          return this.coords;
        }

        public void setCoords(String_ value) { 
          this.coords = value;
        }

        public String getCoordsSimple() { 
          return this.coords == null ? null : this.coords.getValue();
        }

        public void setCoordsSimple(String value) { 
          if (value == null)
            this.coords = null;
          else {
            if (this.coords == null)
              this.coords = new String_();
            this.coords.setValue(value);
          }
        }

  }

    public class Party extends Element {
        /**
         * The role that the participant played
         */
        private Coding role;

        /**
         * The type of the participant
         */
        private Coding type;

        /**
         * Identity of participant. May be a logical or physical uri and maybe absolute or relative
         */
        private Uri id;

        /**
         * Human readable description of the participant
         */
        private String_ description;

        public Coding getRole() { 
          return this.role;
        }

        public void setRole(Coding value) { 
          this.role = value;
        }

        public Coding getType() { 
          return this.type;
        }

        public void setType(Coding value) { 
          this.type = value;
        }

        public Uri getId() { 
          return this.id;
        }

        public void setId(Uri value) { 
          this.id = value;
        }

        public URI getIdSimple() { 
          return this.id == null ? null : this.id.getValue();
        }

        public void setIdSimple(URI value) { 
          if (value == null)
            this.id = null;
          else {
            if (this.id == null)
              this.id = new Uri();
            this.id.setValue(value);
          }
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

  }

    /**
     * The resource that this provenance information pertains to
     */
    private ResourceReference target;

    /**
     * The activity that was being undertaken that led to the creation of the resource being referenced
     */
    private Activity activity;

    /**
     * An entity that is involved in the provenance of the target resource
     */
    private List<Party> party = new ArrayList<Party>();

    /**
     * A digital signature on the target resource. The signature should reference a participant by xml:id
     */
    private String_ signature;

    public ResourceReference getTarget() { 
      return this.target;
    }

    public void setTarget(ResourceReference value) { 
      this.target = value;
    }

    public Activity getActivity() { 
      return this.activity;
    }

    public void setActivity(Activity value) { 
      this.activity = value;
    }

    public List<Party> getParty() { 
      return this.party;
    }

    public String_ getSignature() { 
      return this.signature;
    }

    public void setSignature(String_ value) { 
      this.signature = value;
    }

    public String getSignatureSimple() { 
      return this.signature == null ? null : this.signature.getValue();
    }

    public void setSignatureSimple(String value) { 
      if (value == null)
        this.signature = null;
      else {
        if (this.signature == null)
          this.signature = new String_();
        this.signature.setValue(value);
      }
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Provenance;
   }


}

