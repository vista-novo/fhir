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
 * Directions provided by a prescribing practitioner for a specific medication to be administered (and possibly) supplied to an individual
 */
public class Prescription extends Resource {

    public enum PrescriptionStatus {
        active, // Patient is using the prescribed medicine
        completed, // Prescription is no longer current
        Null; // added to help the parsers
        public static PrescriptionStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return active;
        if ("completed".equals(codeString))
          return completed;
        throw new Exception("Unknown PrescriptionStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case active: return "active";
            case completed: return "completed";
            default: return "?";
          }
        }
    }

  public class PrescriptionStatusEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return PrescriptionStatus.active;
        if ("completed".equals(codeString))
          return PrescriptionStatus.completed;
        throw new Exception("Unknown PrescriptionStatus code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == PrescriptionStatus.active)
        return "active";
      if (code == PrescriptionStatus.completed)
        return "completed";
      return "?";
      }
    }

    public class Dispense extends Element {
        /**
         * Requested number of repeats
         */
        private Integer repeats;

        /**
         * Requested quantity per repeat
         */
        private Quantity quantity;

        /**
         * Person to fulfill the requested dispense
         */
        private ResourceReference dispenser;

        public Integer getRepeats() { 
          return this.repeats;
        }

        public void setRepeats(Integer value) { 
          this.repeats = value;
        }

        public int getRepeatsSimple() { 
          return this.repeats == null ? null : this.repeats.getValue();
        }

        public void setRepeatsSimple(int value) { 
          if (value == -1)
            this.repeats = null;
          else {
            if (this.repeats == null)
              this.repeats = new Integer();
            this.repeats.setValue(value);
          }
        }

        public Quantity getQuantity() { 
          return this.quantity;
        }

        public void setQuantity(Quantity value) { 
          this.quantity = value;
        }

        public ResourceReference getDispenser() { 
          return this.dispenser;
        }

        public void setDispenser(ResourceReference value) { 
          this.dispenser = value;
        }

  }

    public class Medicine extends Element {
        /**
         * Text and or Code(s) that identify the medicine
         */
        private CodeableConcept identification;

        /**
         * The substance in the medication formulation that is pharmaceutically active and is responsible for the medication's therapeutic effect
         */
        private List<ActiveIngredient> activeIngredient = new ArrayList<ActiveIngredient>();

        /**
         * Ingredients in the medication that are not active
         */
        private List<InactiveIngredient> inactiveIngredient = new ArrayList<InactiveIngredient>();

        public CodeableConcept getIdentification() { 
          return this.identification;
        }

        public void setIdentification(CodeableConcept value) { 
          this.identification = value;
        }

        public List<ActiveIngredient> getActiveIngredient() { 
          return this.activeIngredient;
        }

        public List<InactiveIngredient> getInactiveIngredient() { 
          return this.inactiveIngredient;
        }

  }

    public class ActiveIngredient extends Element {
        /**
         * Coded representation of active ingredient
         */
        private CodeableConcept identification;

        /**
         * Quantity of active ingredient expressed in relation to the whole of the prepared medicine
         */
        private Type quantity;

        public CodeableConcept getIdentification() { 
          return this.identification;
        }

        public void setIdentification(CodeableConcept value) { 
          this.identification = value;
        }

        public Type getQuantity() { 
          return this.quantity;
        }

        public void setQuantity(Type value) { 
          this.quantity = value;
        }

  }

    public class InactiveIngredient extends Element {
        /**
         * Coded representation of the inactive ingredient
         */
        private CodeableConcept identification;

        /**
         * Quantity of inactive ingredient expressed in relation to the whole of the prepared medicine
         */
        private Type quantity;

        public CodeableConcept getIdentification() { 
          return this.identification;
        }

        public void setIdentification(CodeableConcept value) { 
          this.identification = value;
        }

        public Type getQuantity() { 
          return this.quantity;
        }

        public void setQuantity(Type value) { 
          this.quantity = value;
        }

  }

    public class AdministrationRequest extends Element {
        /**
         * Textual description of the use of the medication.
         */
        private String_ description;

        /**
         * Total dose per day/week or other period when more specific information is missing or cannot be expressed using the timing specifications.
         */
        private Ratio totalPeriodicDose;

        /**
         * First moment on which medication should be taken
         */
        private DateTime start;

        /**
         * Last moment on which medication should be taken
         */
        private DateTime end;

        /**
         * Total duration of administration
         */
        private Quantity duration;

        /**
         * Maximum number of separate administrations before the instruction ends.
         */
        private Integer numberOfAdministrations;

        /**
         * Specification of dose and schedule for administration
         */
        private List<DosageInstruction> dosageInstruction = new ArrayList<DosageInstruction>();

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

        public Ratio getTotalPeriodicDose() { 
          return this.totalPeriodicDose;
        }

        public void setTotalPeriodicDose(Ratio value) { 
          this.totalPeriodicDose = value;
        }

        public DateTime getStart() { 
          return this.start;
        }

        public void setStart(DateTime value) { 
          this.start = value;
        }

        public String getStartSimple() { 
          return this.start == null ? null : this.start.getValue();
        }

        public void setStartSimple(String value) { 
          if (value == null)
            this.start = null;
          else {
            if (this.start == null)
              this.start = new DateTime();
            this.start.setValue(value);
          }
        }

        public DateTime getEnd() { 
          return this.end;
        }

        public void setEnd(DateTime value) { 
          this.end = value;
        }

        public String getEndSimple() { 
          return this.end == null ? null : this.end.getValue();
        }

        public void setEndSimple(String value) { 
          if (value == null)
            this.end = null;
          else {
            if (this.end == null)
              this.end = new DateTime();
            this.end.setValue(value);
          }
        }

        public Quantity getDuration() { 
          return this.duration;
        }

        public void setDuration(Quantity value) { 
          this.duration = value;
        }

        public Integer getNumberOfAdministrations() { 
          return this.numberOfAdministrations;
        }

        public void setNumberOfAdministrations(Integer value) { 
          this.numberOfAdministrations = value;
        }

        public int getNumberOfAdministrationsSimple() { 
          return this.numberOfAdministrations == null ? null : this.numberOfAdministrations.getValue();
        }

        public void setNumberOfAdministrationsSimple(int value) { 
          if (value == -1)
            this.numberOfAdministrations = null;
          else {
            if (this.numberOfAdministrations == null)
              this.numberOfAdministrations = new Integer();
            this.numberOfAdministrations.setValue(value);
          }
        }

        public List<DosageInstruction> getDosageInstruction() { 
          return this.dosageInstruction;
        }

  }

    public class DosageInstruction extends Element {
        /**
         * Precondition for starting the administration specified in this instruction
         */
        private List<CodeableConcept> precondition = new ArrayList<CodeableConcept>();

        /**
         * As required (from Latin Pro Re Nate): Specifies whether administration is given to a fixed schedule (No) or only when the the state and symptoms of the patient at the time require it (Yes).
         */
        private Boolean prn;

        /**
         * Additional details to guide administration. Especially relevant for medicine administered by patient
         */
        private List<CodeableConcept> additionalInstruction = new ArrayList<CodeableConcept>();

        /**
         * Route of administration (oral, nasal, intravenous)
         */
        private CodeableConcept route;

        /**
         * Dose per administration, expressed in units of the (prepared) product
         */
        private Type dose;

        /**
         * Flow-rate for IV
         */
        private Quantity rate;

        /**
         * Schedule for administration. If multiple are given, they are considered to be active in parallel
         */
        private List<Schedule> schedule = new ArrayList<Schedule>();

        public List<CodeableConcept> getPrecondition() { 
          return this.precondition;
        }

        public Boolean getPrn() { 
          return this.prn;
        }

        public void setPrn(Boolean value) { 
          this.prn = value;
        }

        public boolean getPrnSimple() { 
          return this.prn == null ? null : this.prn.getValue();
        }

        public void setPrnSimple(boolean value) { 
          if (value == false)
            this.prn = null;
          else {
            if (this.prn == null)
              this.prn = new Boolean();
            this.prn.setValue(value);
          }
        }

        public List<CodeableConcept> getAdditionalInstruction() { 
          return this.additionalInstruction;
        }

        public CodeableConcept getRoute() { 
          return this.route;
        }

        public void setRoute(CodeableConcept value) { 
          this.route = value;
        }

        public Type getDose() { 
          return this.dose;
        }

        public void setDose(Type value) { 
          this.dose = value;
        }

        public Quantity getRate() { 
          return this.rate;
        }

        public void setRate(Quantity value) { 
          this.rate = value;
        }

        public List<Schedule> getSchedule() { 
          return this.schedule;
        }

  }

    /**
     * A identifier used in an external system and associated with this medication
     */
    private List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * Actual status of the prescription
     */
    private Enumeration<PrescriptionStatus> status;

    /**
     * The patient the prescription is prescribing medicine for
     */
    private ResourceReference patient;

    /**
     * The clinician or doctor prescribing the medication
     */
    private ResourceReference prescriber;

    /**
     * Date/time on which the prescription was written
     */
    private DateTime prescribed;

    /**
     * Details of the dispense as requested by the prescriber
     */
    private Dispense dispense;

    /**
     * The one single medicine, vaccine or other product prescribed in this prescription.
     */
    private Medicine medicine;

    /**
     * Instructions for the use of the medication. Includes details about the timing schedule, dose amounts and additional usage instructions.
     */
    private AdministrationRequest administrationRequest;

    /**
     * Diagnosis which is the reason for prescribing this medicine
     */
    private CodeableConcept reason;

    public List<Identifier> getIdentifier() { 
      return this.identifier;
    }

    public Enumeration<PrescriptionStatus> getStatus() { 
      return this.status;
    }

    public void setStatus(Enumeration<PrescriptionStatus> value) { 
      this.status = value;
    }

    public PrescriptionStatus getStatusSimple() { 
      return this.status == null ? null : this.status.getValue();
    }

    public void setStatusSimple(PrescriptionStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<PrescriptionStatus>();
        this.status.setValue(value);
      }
    }

    public ResourceReference getPatient() { 
      return this.patient;
    }

    public void setPatient(ResourceReference value) { 
      this.patient = value;
    }

    public ResourceReference getPrescriber() { 
      return this.prescriber;
    }

    public void setPrescriber(ResourceReference value) { 
      this.prescriber = value;
    }

    public DateTime getPrescribed() { 
      return this.prescribed;
    }

    public void setPrescribed(DateTime value) { 
      this.prescribed = value;
    }

    public String getPrescribedSimple() { 
      return this.prescribed == null ? null : this.prescribed.getValue();
    }

    public void setPrescribedSimple(String value) { 
      if (value == null)
        this.prescribed = null;
      else {
        if (this.prescribed == null)
          this.prescribed = new DateTime();
        this.prescribed.setValue(value);
      }
    }

    public Dispense getDispense() { 
      return this.dispense;
    }

    public void setDispense(Dispense value) { 
      this.dispense = value;
    }

    public Medicine getMedicine() { 
      return this.medicine;
    }

    public void setMedicine(Medicine value) { 
      this.medicine = value;
    }

    public AdministrationRequest getAdministrationRequest() { 
      return this.administrationRequest;
    }

    public void setAdministrationRequest(AdministrationRequest value) { 
      this.administrationRequest = value;
    }

    public CodeableConcept getReason() { 
      return this.reason;
    }

    public void setReason(CodeableConcept value) { 
      this.reason = value;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Prescription;
   }


}

