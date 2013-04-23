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

// Generated on Tue, Apr 23, 2013 10:10+1000 for FHIR v0.08

import java.util.*;

/**
 * An interaction between a patient and healthcare participant(s) for the purpose of providing patient service(s) or assessing the health status of a patient.
 */
public class Visit extends Resource {

    public class VisitAdmissionComponent extends Element {
        /**
         * The practitioner responsible for admission
         */
        private ResourceReference admitter;

        /**
         * The location the patient came from before admission
         */
        private ResourceReference origin;

        public ResourceReference getAdmitter() { 
          return this.admitter;
        }

        public void setAdmitter(ResourceReference value) { 
          this.admitter = value;
        }

        public ResourceReference getOrigin() { 
          return this.origin;
        }

        public void setOrigin(ResourceReference value) { 
          this.origin = value;
        }

  }

    public class VisitLocationComponent extends Element {
        /**
         * The location the visit takes place
         */
        private ResourceReference location;

        /**
         * A name of specific label for the bed the patient was in on the location
         */
        private Type bed;

        /**
         * Time period during which the patient was present at the location
         */
        private DateTime period;

        /**
         * Practitioner responsible for the patient during his stay at this location
         */
        private ResourceReference responsible;

        public ResourceReference getLocation() { 
          return this.location;
        }

        public void setLocation(ResourceReference value) { 
          this.location = value;
        }

        public Type getBed() { 
          return this.bed;
        }

        public void setBed(Type value) { 
          this.bed = value;
        }

        public DateTime getPeriod() { 
          return this.period;
        }

        public void setPeriod(DateTime value) { 
          this.period = value;
        }

        public String getPeriodSimple() { 
          return this.period == null ? null : this.period.getValue();
        }

        public void setPeriodSimple(String value) { 
          if (value == null)
            this.period = null;
          else {
            if (this.period == null)
              this.period = new DateTime();
            this.period.setValue(value);
          }
        }

        public ResourceReference getResponsible() { 
          return this.responsible;
        }

        public void setResponsible(ResourceReference value) { 
          this.responsible = value;
        }

  }

    public class VisitDischargeComponent extends Element {
        /**
         * Practitioner responsible for the patient during the discharge
         */
        private ResourceReference discharger;

        /**
         * Contact person to inform about the discharge
         */
        private ResourceReference contact;

        /**
         * Location the patient is discharged to
         */
        private ResourceReference destination;

        public ResourceReference getDischarger() { 
          return this.discharger;
        }

        public void setDischarger(ResourceReference value) { 
          this.discharger = value;
        }

        public ResourceReference getContact() { 
          return this.contact;
        }

        public void setContact(ResourceReference value) { 
          this.contact = value;
        }

        public ResourceReference getDestination() { 
          return this.destination;
        }

        public void setDestination(ResourceReference value) { 
          this.destination = value;
        }

  }

    /**
     * Identifier(s) by which this visit is known
     */
    private List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * E.g. active, aborted, finished
     */
    private CodeableConcept state;

    /**
     * Kind of environment the visit takes place in, e.g. inpatient, ambulatory, home, or virtual
     */
    private CodeableConcept setting;

    /**
     * The patient present at the visit
     */
    private ResourceReference subject;

    /**
     * The main practitioner responsible for providing the service
     */
    private ResourceReference responsible;

    /**
     * The appointment that scheduled this visit
     */
    private ResourceReference fulfills;

    /**
     * Period during which the visit lasted
     */
    private Period period;

    /**
     * Quantity of time the visit lasted. This excludes the time during leaves of absence.
     */
    private Duration length;

    /**
     * Emergency contact during the visit
     */
    private ResourceReference contact;

    /**
     * Details about an admission to a clinic
     */
    private VisitAdmissionComponent admission;

    /**
     * Reason the visit takes place
     */
    private ResourceReference indication;

    /**
     * List of locations the patient has been at.
     */
    private List<VisitLocationComponent> location = new ArrayList<VisitLocationComponent>();

    /**
     * Details about a discharge from a clinic
     */
    private VisitDischargeComponent discharge;

    public List<Identifier> getIdentifier() { 
      return this.identifier;
    }

    public CodeableConcept getState() { 
      return this.state;
    }

    public void setState(CodeableConcept value) { 
      this.state = value;
    }

    public CodeableConcept getSetting() { 
      return this.setting;
    }

    public void setSetting(CodeableConcept value) { 
      this.setting = value;
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getResponsible() { 
      return this.responsible;
    }

    public void setResponsible(ResourceReference value) { 
      this.responsible = value;
    }

    public ResourceReference getFulfills() { 
      return this.fulfills;
    }

    public void setFulfills(ResourceReference value) { 
      this.fulfills = value;
    }

    public Period getPeriod() { 
      return this.period;
    }

    public void setPeriod(Period value) { 
      this.period = value;
    }

    public Duration getLength() { 
      return this.length;
    }

    public void setLength(Duration value) { 
      this.length = value;
    }

    public ResourceReference getContact() { 
      return this.contact;
    }

    public void setContact(ResourceReference value) { 
      this.contact = value;
    }

    public VisitAdmissionComponent getAdmission() { 
      return this.admission;
    }

    public void setAdmission(VisitAdmissionComponent value) { 
      this.admission = value;
    }

    public ResourceReference getIndication() { 
      return this.indication;
    }

    public void setIndication(ResourceReference value) { 
      this.indication = value;
    }

    public List<VisitLocationComponent> getLocation() { 
      return this.location;
    }

    public VisitDischargeComponent getDischarge() { 
      return this.discharge;
    }

    public void setDischarge(VisitDischargeComponent value) { 
      this.discharge = value;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Visit;
   }


}

