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

// Generated on Sun, Apr 14, 2013 21:55+1000 for FHIR v0.08

import java.util.*;

/**
 * Describes the event of a patient being given a dose of a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.

Related resources tie this event to the authorizing prescription, and the specific visit between patient and health care practitioner
 */
public class MedicationAdministration extends Resource {

    public enum MedAdmStatus {
        active, // The administration of the medication has started and is currently in progress.
        paused, // The administration of the medication has started but is currently stopped with a firm intention of restarting.
        completed, // The administration of the medication has finished
        nullified, // The administration of the medication was recorded in error and the record should now be disregarded.
        Null; // added to help the parsers
        public static MedAdmStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return active;
        if ("paused".equals(codeString))
          return paused;
        if ("completed".equals(codeString))
          return completed;
        if ("nullified".equals(codeString))
          return nullified;
        throw new Exception("Unknown MedAdmStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case active: return "active";
            case paused: return "paused";
            case completed: return "completed";
            case nullified: return "nullified";
            default: return "?";
          }
        }
    }

  public class MedAdmStatusEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return MedAdmStatus.active;
        if ("paused".equals(codeString))
          return MedAdmStatus.paused;
        if ("completed".equals(codeString))
          return MedAdmStatus.completed;
        if ("nullified".equals(codeString))
          return MedAdmStatus.nullified;
        throw new Exception("Unknown MedAdmStatus code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == MedAdmStatus.active)
        return "active";
      if (code == MedAdmStatus.paused)
        return "paused";
      if (code == MedAdmStatus.completed)
        return "completed";
      if (code == MedAdmStatus.nullified)
        return "nullified";
      return "?";
      }
    }

    /**
     * Will generally be set to show that the administration has been completed.  For some long running administrations such as infusions it is possible for an administration to be started but not completed or it may be paused while some other process is under way.
     */
    private Enumeration<MedAdmStatus> administrationEventStatus;

    /**
     * Set this to true if the record is saying that the medication was NOT administered.
     */
    private Boolean isNegated;

    /**
     * A code indicating why the administration has been negated.

Use only if isNegated is set to TRUE
     */
    private List<CodeableConcept> negatedReason = new ArrayList<CodeableConcept>();

    /**
     * An interval of time during which the administration takes place.  For many administrations, such as swallowing a tablet the lower and upper values of the interval will be the same.
     */
    private Period effectiveTime;

    /**
     * A coded value indicating the method by which the medication is introduced into or onto the body. Most commonly used for injections.  Examples:  Slow Push; Deep IV.

Terminologies used often pre-coordinate this term with the route and or form of administration.
     */
    private CodeableConcept method;

    /**
     * A coded value indicating the location on the body where the medication is introduced into or onto the body.   Where the code system indicates laterality by means of a separate coded concept this must be post-coordinated with the code indicating the location.
     */
    private CodeableConcept approachSite;

    /**
     * A coded value indicating the path in or on the body by which the medication is introduced into or onto the body.  Where the code system indicates laterality by means of a separate coded concept this must be post-coordinated with the code indicating the route.
     */
    private CodeableConcept route;

    /**
     * The amount of a medication administered to the patient as a single amount.
     */
    private Quantity administeredDose;

    /**
     * The amount of a medication administered to the patient over a period of time.

Example 250ml/30min
     */
    private Quantity doseRate;

    /**
     * External identifier - FHIR will generate its own internal IDs (probably URLs) which do not need to be explicitly managed by the resource.  The identifier here is one that would be used by another non-FHIR system - for example an automated medication pump would provide a record each time it operated; an administration while the patient was off the ward might be made with a different system and entered after the event.  Particularly important if these records have to be updated.
     */
    private List<Identifier> id = new ArrayList<Identifier>();

    /**
     * A link to a resource that provides the original request, instruction and authority to perform the administration.
     */
    private ResourceReference prescription;

    /**
     * A link to a resource representing the person to whom the medication was given.
     */
    private ResourceReference patient;

    /**
     * This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.
     */
    private List<CodeableConcept> medication = new ArrayList<CodeableConcept>();

    /**
     * An identifier or a link to a resource that identifies the particular occurrence of contact between patient and health care practitioner.
     */
    private Identifier visit;

    /**
     * An identifier or a link to a resource that identifies a device used in administering the medication to the patient.
     */
    private List<ResourceReference> administrationDevice = new ArrayList<ResourceReference>();

    public Enumeration<MedAdmStatus> getAdministrationEventStatus() { 
      return this.administrationEventStatus;
    }

    public void setAdministrationEventStatus(Enumeration<MedAdmStatus> value) { 
      this.administrationEventStatus = value;
    }

    public MedAdmStatus getAdministrationEventStatusSimple() { 
      return this.administrationEventStatus == null ? null : this.administrationEventStatus.getValue();
    }

    public void setAdministrationEventStatusSimple(MedAdmStatus value) { 
      if (value == null)
        this.administrationEventStatus = null;
      else {
        if (this.administrationEventStatus == null)
          this.administrationEventStatus = new Enumeration<MedAdmStatus>();
        this.administrationEventStatus.setValue(value);
      }
    }

    public Boolean getIsNegated() { 
      return this.isNegated;
    }

    public void setIsNegated(Boolean value) { 
      this.isNegated = value;
    }

    public boolean getIsNegatedSimple() { 
      return this.isNegated == null ? null : this.isNegated.getValue();
    }

    public void setIsNegatedSimple(boolean value) { 
      if (value == false)
        this.isNegated = null;
      else {
        if (this.isNegated == null)
          this.isNegated = new Boolean();
        this.isNegated.setValue(value);
      }
    }

    public List<CodeableConcept> getNegatedReason() { 
      return this.negatedReason;
    }

    public Period getEffectiveTime() { 
      return this.effectiveTime;
    }

    public void setEffectiveTime(Period value) { 
      this.effectiveTime = value;
    }

    public CodeableConcept getMethod() { 
      return this.method;
    }

    public void setMethod(CodeableConcept value) { 
      this.method = value;
    }

    public CodeableConcept getApproachSite() { 
      return this.approachSite;
    }

    public void setApproachSite(CodeableConcept value) { 
      this.approachSite = value;
    }

    public CodeableConcept getRoute() { 
      return this.route;
    }

    public void setRoute(CodeableConcept value) { 
      this.route = value;
    }

    public Quantity getAdministeredDose() { 
      return this.administeredDose;
    }

    public void setAdministeredDose(Quantity value) { 
      this.administeredDose = value;
    }

    public Quantity getDoseRate() { 
      return this.doseRate;
    }

    public void setDoseRate(Quantity value) { 
      this.doseRate = value;
    }

    public List<Identifier> getId() { 
      return this.id;
    }

    public ResourceReference getPrescription() { 
      return this.prescription;
    }

    public void setPrescription(ResourceReference value) { 
      this.prescription = value;
    }

    public ResourceReference getPatient() { 
      return this.patient;
    }

    public void setPatient(ResourceReference value) { 
      this.patient = value;
    }

    public List<CodeableConcept> getMedication() { 
      return this.medication;
    }

    public Identifier getVisit() { 
      return this.visit;
    }

    public void setVisit(Identifier value) { 
      this.visit = value;
    }

    public List<ResourceReference> getAdministrationDevice() { 
      return this.administrationDevice;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationAdministration;
   }


}

