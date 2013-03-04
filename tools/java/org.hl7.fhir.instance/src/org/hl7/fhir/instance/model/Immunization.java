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

/**
 * An administered immunization
 */
public class Immunization extends Resource {

    public class Refusal extends Element {
        /**
         * Date of refusal
         */
        private DateTime date;

        /**
         * Refusal or exemption reason
         */
        private CodeableConcept reason;

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

        public CodeableConcept getReason() { 
          return this.reason;
        }

        public void setReason(CodeableConcept value) { 
          this.reason = value;
        }

  }

    public class Reaction extends Element {
        /**
         * Date of reaction to the immunization
         */
        private DateTime date;

        /**
         * Details of the reaction
         */
        private ResourceReference detail;

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

        public ResourceReference getDetail() { 
          return this.detail;
        }

        public void setDetail(ResourceReference value) { 
          this.detail = value;
        }

  }

    /**
     * Who this immunization was adminstered to
     */
    private ResourceReference subject;

    /**
     * Type of vaccine administered
     */
    private CodeableConcept type;

    /**
     * Date vaccine administered
     */
    private DateTime date;

    /**
     * True if this administration was reported rather than observed
     */
    private Boolean reported;

    /**
     * Dose number in the series
     */
    private Integer doseSequence;

    /**
     * Name of manufacturer
     */
    private ResourceReference manufacturer;

    /**
     * Lot number for vaccine
     */
    private String_ lotNumber;

    /**
     * Date vaccine batch expires
     */
    private Date expirationDate;

    /**
     * Body site where vaccine was administered
     */
    private CodeableConcept site;

    /**
     * Route of administration
     */
    private CodeableConcept route;

    /**
     * Clinician who ordered the vaccine
     */
    private ResourceReference requester;

    /**
     * Clinician that administered the vaccine
     */
    private ResourceReference performer;

    /**
     * Exemption(s)/ Parent Refusal(s) of Vaccine Product Type Administered
     */
    private Refusal refusal;

    /**
     * Categorical data indicating that an adverse event is associated in time to an immunization
     */
    private List<Reaction> reaction = new ArrayList<Reaction>();

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public CodeableConcept getType() { 
      return this.type;
    }

    public void setType(CodeableConcept value) { 
      this.type = value;
    }

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

    public Boolean getReported() { 
      return this.reported;
    }

    public void setReported(Boolean value) { 
      this.reported = value;
    }

    public boolean getReportedSimple() { 
      return this.reported == null ? null : this.reported.getValue();
    }

    public void setReportedSimple(boolean value) { 
      if (value == false)
        this.reported = null;
      else {
        if (this.reported == null)
          this.reported = new Boolean();
        this.reported.setValue(value);
      }
    }

    public Integer getDoseSequence() { 
      return this.doseSequence;
    }

    public void setDoseSequence(Integer value) { 
      this.doseSequence = value;
    }

    public int getDoseSequenceSimple() { 
      return this.doseSequence == null ? null : this.doseSequence.getValue();
    }

    public void setDoseSequenceSimple(int value) { 
      if (value == -1)
        this.doseSequence = null;
      else {
        if (this.doseSequence == null)
          this.doseSequence = new Integer();
        this.doseSequence.setValue(value);
      }
    }

    public ResourceReference getManufacturer() { 
      return this.manufacturer;
    }

    public void setManufacturer(ResourceReference value) { 
      this.manufacturer = value;
    }

    public String_ getLotNumber() { 
      return this.lotNumber;
    }

    public void setLotNumber(String_ value) { 
      this.lotNumber = value;
    }

    public String getLotNumberSimple() { 
      return this.lotNumber == null ? null : this.lotNumber.getValue();
    }

    public void setLotNumberSimple(String value) { 
      if (value == null)
        this.lotNumber = null;
      else {
        if (this.lotNumber == null)
          this.lotNumber = new String_();
        this.lotNumber.setValue(value);
      }
    }

    public Date getExpirationDate() { 
      return this.expirationDate;
    }

    public void setExpirationDate(Date value) { 
      this.expirationDate = value;
    }

    public String getExpirationDateSimple() { 
      return this.expirationDate == null ? null : this.expirationDate.getValue();
    }

    public void setExpirationDateSimple(String value) { 
      if (value == null)
        this.expirationDate = null;
      else {
        if (this.expirationDate == null)
          this.expirationDate = new Date();
        this.expirationDate.setValue(value);
      }
    }

    public CodeableConcept getSite() { 
      return this.site;
    }

    public void setSite(CodeableConcept value) { 
      this.site = value;
    }

    public CodeableConcept getRoute() { 
      return this.route;
    }

    public void setRoute(CodeableConcept value) { 
      this.route = value;
    }

    public ResourceReference getRequester() { 
      return this.requester;
    }

    public void setRequester(ResourceReference value) { 
      this.requester = value;
    }

    public ResourceReference getPerformer() { 
      return this.performer;
    }

    public void setPerformer(ResourceReference value) { 
      this.performer = value;
    }

    public Refusal getRefusal() { 
      return this.refusal;
    }

    public void setRefusal(Refusal value) { 
      this.refusal = value;
    }

    public List<Reaction> getReaction() { 
      return this.reaction;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Immunization;
   }


}

