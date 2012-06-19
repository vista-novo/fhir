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

// Generated on Sun, Jun 17, 2012 00:08+1000 for FHIR v0.04

import java.util.*;

/**
 * Directions provided by a prescribing practitioner for a specific medication to be administered to an individual
 */
public class Prescription extends Resource {

    public enum PrescriptionStatus {
        active, // Patient is using the prescribed medicin
        completed; // Prescription is no longer current
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

    public class Dispense extends Element {
        /**
         * Requested number of repeats
         */
        private int repeats;

        /**
         * Requested quantity per repeat
         */
        private Quantity quantity;

        /**
         * Person to fullfil the requested dispense
         */
        private ResourceReference dispenser;

        public int getRepeats() { 
          return this.repeats;
        }

        public void setRepeats(int value) { 
          this.repeats = value;
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
        private Ratio quantity;

        public CodeableConcept getIdentification() { 
          return this.identification;
        }

        public void setIdentification(CodeableConcept value) { 
          this.identification = value;
        }

        public Ratio getQuantity() { 
          return this.quantity;
        }

        public void setQuantity(Ratio value) { 
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
        private Ratio quantity;

        public CodeableConcept getIdentification() { 
          return this.identification;
        }

        public void setIdentification(CodeableConcept value) { 
          this.identification = value;
        }

        public Ratio getQuantity() { 
          return this.quantity;
        }

        public void setQuantity(Ratio value) { 
          this.quantity = value;
        }

    }

    public class AdministrationRequest extends Element {
        /**
         * Textual description of the use of the medication.
         */
        private String description;

        /**
         * Total dose per day/week or other period when more specific information is missing or cannot be expressed using the timing specifications.
         */
        private Ratio totalPeriodicDosis;

        /**
         * First moment on which medication should be taken
         */
        private String start;

        /**
         * Last moment on which medication should be taken
         */
        private String end;

        /**
         * Total duration of administration
         */
        private Quantity duration;

        /**
         * Maximum number of separate administrations before the instruction ends.
         */
        private int numberOfAdministrations;

        /**
         * Specification of dose and schedule for administration
         */
        private List<DosageInstruction> dosageInstruction = new ArrayList<DosageInstruction>();

        public String getDescription() { 
          return this.description;
        }

        public void setDescription(String value) { 
          this.description = value;
        }

        public Ratio getTotalPeriodicDosis() { 
          return this.totalPeriodicDosis;
        }

        public void setTotalPeriodicDosis(Ratio value) { 
          this.totalPeriodicDosis = value;
        }

        public String getStart() { 
          return this.start;
        }

        public void setStart(String value) { 
          this.start = value;
        }

        public String getEnd() { 
          return this.end;
        }

        public void setEnd(String value) { 
          this.end = value;
        }

        public Quantity getDuration() { 
          return this.duration;
        }

        public void setDuration(Quantity value) { 
          this.duration = value;
        }

        public int getNumberOfAdministrations() { 
          return this.numberOfAdministrations;
        }

        public void setNumberOfAdministrations(int value) { 
          this.numberOfAdministrations = value;
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
         * Pro re nate, "If necessary": Specifies whether administration depens on the state and symptoms of the patient
         */
        private boolean prn;

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
         * Schedule for administration. If multiple are given, they are considered to be active in parrallel
         */
        private List<Schedule> schedule = new ArrayList<Schedule>();

        public List<CodeableConcept> getPrecondition() { 
          return this.precondition;
        }

        public boolean getPrn() { 
          return this.prn;
        }

        public void setPrn(boolean value) { 
          this.prn = value;
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
    private List<HumanId> identifier = new ArrayList<HumanId>();

    /**
     * Actual status of the prescription
     */
    private PrescriptionStatus status;

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
    private String prescribed;

    /**
     * Details of the dispense as requested by the prescriber
     */
    private Dispense dispense;

    /**
     * The one single medicatine, vaccine or therapeutic good prescribed in this prescription.
     */
    private Medicine medicine;

    /**
     * Instructions for the use of the medication. Includes details about the timing schedule, dosis amounts and additional usage instructions.
     */
    private AdministrationRequest administrationRequest;

    /**
     * Diagnosis which is the reason for prescribing this medicine
     */
    private CodeableConcept reason;

    public List<HumanId> getIdentifier() { 
      return this.identifier;
    }

    public PrescriptionStatus getStatus() { 
      return this.status;
    }

    public void setStatus(PrescriptionStatus value) { 
      this.status = value;
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

    public String getPrescribed() { 
      return this.prescribed;
    }

    public void setPrescribed(String value) { 
      this.prescribed = value;
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


}

