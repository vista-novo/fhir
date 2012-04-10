package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on 23:50 Apr 10, 2012 for FHIR v0.01

import java.util.*;

/**
 * Directions provided by a prescribing practitioner for a specific medication to be administered to an individual
 */
public class Prescription extends Resource {

    public enum PrescriptionStatus {
        active, // Patient is using the prescribed medicin
        completed; // Prescription is no longer current
        public static PrescriptionStatus fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("active".equals(code))
          return active;
        if ("completed".equals(code))
          return completed;
        throw new Exception("Unknown PrescriptionStatus code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case active: return "active";
            case completed: return "completed";
            default: return "?";
          }
        }
    }

    public enum BooleanYesNo {
        yes, // TRUE
        no; // FALSE
        public static BooleanYesNo fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("yes".equals(code))
          return yes;
        if ("no".equals(code))
          return no;
        throw new Exception("Unknown BooleanYesNo code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case yes: return "yes";
            case no: return "no";
            default: return "?";
          }
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
         * Person to fullfil the requested dispense
         */
        private ResourceReference dispenser;

        public Integer getRepeats() { 
          return this.repeats;
        }

        public void setRepeats(Integer value) { 
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
         * Coded representation of medicine
         */
        private Coding productCode;

        /**
         * Textual description of medicine, including strength and ingredients
         */
        private String_ description;

        /**
         * The substance in the medication formulation that is pharmaceutically active and is responsible for the medication's therapeutic effect
         */
        private List<ActiveIngredient> activeIngredient = new ArrayList<ActiveIngredient>();

        /**
         * Ingredients in the medication that are not active
         */
        private List<InactiveIngredient> inactiveIngredient = new ArrayList<InactiveIngredient>();

        public Coding getProductCode() { 
          return this.productCode;
        }

        public void setProductCode(Coding value) { 
          this.productCode = value;
        }

        public String_ getDescription() { 
          return this.description;
        }

        public void setDescription(String_ value) { 
          this.description = value;
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
        private Coding productCode;

        /**
         * Quantity of active ingredient expressed in relation to the whole of the prepared medicine
         */
        private Ratio quantity;

        public Coding getProductCode() { 
          return this.productCode;
        }

        public void setProductCode(Coding value) { 
          this.productCode = value;
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
        private Coding productCode;

        /**
         * Quantity of inactive ingredient expressed in relation to the whole of the prepared medicine
         */
        private Ratio quantity;

        public Coding getProductCode() { 
          return this.productCode;
        }

        public void setProductCode(Coding value) { 
          this.productCode = value;
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
        private String_ description;

        /**
         * Total dose per day/week or other period when more specific information is missing or cannot be expressed using the timing specifications.
         */
        private Ratio totalPeriodicDosis;

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

        public Ratio getTotalPeriodicDosis() { 
          return this.totalPeriodicDosis;
        }

        public void setTotalPeriodicDosis(Ratio value) { 
          this.totalPeriodicDosis = value;
        }

        public DateTime getStart() { 
          return this.start;
        }

        public void setStart(DateTime value) { 
          this.start = value;
        }

        public DateTime getEnd() { 
          return this.end;
        }

        public void setEnd(DateTime value) { 
          this.end = value;
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
        private BooleanYesNo prn;

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

        public BooleanYesNo getPrn() { 
          return this.prn;
        }

        public void setPrn(BooleanYesNo value) { 
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
    private DateTime prescribed;

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

    public DateTime getPrescribed() { 
      return this.prescribed;
    }

    public void setPrescribed(DateTime value) { 
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

