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

// Generated on Mon, May 6, 2013 01:45+1000 for FHIR v0.08

import java.util.*;

/**
 * Research study
 */
public class Study extends Resource {

    public enum StudyTreatmentRole {
        investigational, // 
        comparative, // 
        current, // 
        Null; // added to help the parsers
        public static StudyTreatmentRole fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("investigational".equals(codeString))
          return investigational;
        if ("comparative".equals(codeString))
          return comparative;
        if ("current".equals(codeString))
          return current;
        throw new Exception("Unknown StudyTreatmentRole code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case investigational: return "investigational";
            case comparative: return "comparative";
            case current: return "current";
            default: return "?";
          }
        }
    }

  public class StudyTreatmentRoleEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("investigational".equals(codeString))
          return StudyTreatmentRole.investigational;
        if ("comparative".equals(codeString))
          return StudyTreatmentRole.comparative;
        if ("current".equals(codeString))
          return StudyTreatmentRole.current;
        throw new Exception("Unknown StudyTreatmentRole code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == StudyTreatmentRole.investigational)
        return "investigational";
      if (code == StudyTreatmentRole.comparative)
        return "comparative";
      if (code == StudyTreatmentRole.current)
        return "current";
      return "?";
      }
    }

    public class StudyTreatmentComponent extends Element {
        /**
         * investigational | comparative | current
         */
        private Enumeration<StudyTreatmentRole> role;

        /**
         * Treatment details
         */
        private ActivityDefinition detail;

        public Enumeration<StudyTreatmentRole> getRole() { 
          return this.role;
        }

        public void setRole(Enumeration<StudyTreatmentRole> value) { 
          this.role = value;
        }

        public StudyTreatmentRole getRoleSimple() { 
          return this.role == null ? null : this.role.getValue();
        }

        public void setRoleSimple(StudyTreatmentRole value) { 
          if (value == null)
            this.role = null;
          else {
            if (this.role == null)
              this.role = new Enumeration<StudyTreatmentRole>();
            this.role.setValue(value);
          }
        }

        public ActivityDefinition getDetail() { 
          return this.detail;
        }

        public void setDetail(ActivityDefinition value) { 
          this.detail = value;
        }

  }

    public class StudyInterventionComponent extends Element {
        /**
         * What kind of intervention
         */
        private CodeableConcept type;

        /**
         * e.g. cross-over | factorial | parallel | single group
         */
        private CodeableConcept model;

        /**
         * Are study participants randomly assigned?
         */
        private Boolean randomized;

        /**
         * e.g. open label | double blind | single blind
         */
        private CodeableConcept blindingScheme;

        /**
         * What portion of subjects receive therapy?
         */
        private Type randomizationQuotient;

        public CodeableConcept getType() { 
          return this.type;
        }

        public void setType(CodeableConcept value) { 
          this.type = value;
        }

        public CodeableConcept getModel() { 
          return this.model;
        }

        public void setModel(CodeableConcept value) { 
          this.model = value;
        }

        public Boolean getRandomized() { 
          return this.randomized;
        }

        public void setRandomized(Boolean value) { 
          this.randomized = value;
        }

        public boolean getRandomizedSimple() { 
          return this.randomized == null ? null : this.randomized.getValue();
        }

        public void setRandomizedSimple(boolean value) { 
          if (value == false)
            this.randomized = null;
          else {
            if (this.randomized == null)
              this.randomized = new Boolean();
            this.randomized.setValue(value);
          }
        }

        public CodeableConcept getBlindingScheme() { 
          return this.blindingScheme;
        }

        public void setBlindingScheme(CodeableConcept value) { 
          this.blindingScheme = value;
        }

        public Type getRandomizationQuotient() { 
          return this.randomizationQuotient;
        }

        public void setRandomizationQuotient(Type value) { 
          this.randomizationQuotient = value;
        }

  }

    /**
     * Id for study
     */
    private List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * Who's responsible?
     */
    private String_ sponsor;

    /**
     * Name of study
     */
    private String_ title;

    /**
     * Description of study
     */
    private String_ description;

    /**
     * e.g. interventional | observational | expanded access
     */
    private CodeableConcept type;

    /**
     * Condition(s) addressed
     */
    private List<CodeableConcept> condition = new ArrayList<CodeableConcept>();

    /**
     * Focal treatments for study
     */
    private List<StudyTreatmentComponent> treatment = new ArrayList<StudyTreatmentComponent>();

    /**
     * e.g. placebo | active | historical | uncontrolled | dose comparison
     */
    private List<CodeableConcept> controlType = new ArrayList<CodeableConcept>();

    /**
     * Describes the desired state that will exist if the study achieves what it intends.  Objectives should be listed in order of importantance with primary objective first.
     */
    private List<String_> objective = new ArrayList<String_>();

    /**
     * How will we know if it's accomplished?
     */
    private List<String_> outcomeMeasure = new ArrayList<String_>();

    /**
     * Describes the group or groups that
     */
    private List<ResourceReference> eligibility = new ArrayList<ResourceReference>();

    /**
     * When will/did study begin & end
     */
    private Period period;

    /**
     * How long it will run
     */
    private Duration duration;

    /**
     * Intended # of subjects
     */
    private Integer plannedEnrollment;

    /**
     * Information for interventional studies
     */
    private StudyInterventionComponent intervention;

    /**
     * What steps are to be followed for participants in study?
     */
    private List<ResourceReference> protocol = new ArrayList<ResourceReference>();

    /**
     * What data is submitted
     */
    private ResourceReference dataStructure;

    /**
     * Data collected during study
     */
    private List<ResourceReference> data = new ArrayList<ResourceReference>();

    public List<Identifier> getIdentifier() { 
      return this.identifier;
    }

    public String_ getSponsor() { 
      return this.sponsor;
    }

    public void setSponsor(String_ value) { 
      this.sponsor = value;
    }

    public String getSponsorSimple() { 
      return this.sponsor == null ? null : this.sponsor.getValue();
    }

    public void setSponsorSimple(String value) { 
      if (value == null)
        this.sponsor = null;
      else {
        if (this.sponsor == null)
          this.sponsor = new String_();
        this.sponsor.setValue(value);
      }
    }

    public String_ getTitle() { 
      return this.title;
    }

    public void setTitle(String_ value) { 
      this.title = value;
    }

    public String getTitleSimple() { 
      return this.title == null ? null : this.title.getValue();
    }

    public void setTitleSimple(String value) { 
      if (value == null)
        this.title = null;
      else {
        if (this.title == null)
          this.title = new String_();
        this.title.setValue(value);
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

    public CodeableConcept getType() { 
      return this.type;
    }

    public void setType(CodeableConcept value) { 
      this.type = value;
    }

    public List<CodeableConcept> getCondition() { 
      return this.condition;
    }

    public List<StudyTreatmentComponent> getTreatment() { 
      return this.treatment;
    }

    public List<CodeableConcept> getControlType() { 
      return this.controlType;
    }

    public List<String_> getObjective() { 
      return this.objective;
    }

    public List<String_> getOutcomeMeasure() { 
      return this.outcomeMeasure;
    }

    public List<ResourceReference> getEligibility() { 
      return this.eligibility;
    }

    public Period getPeriod() { 
      return this.period;
    }

    public void setPeriod(Period value) { 
      this.period = value;
    }

    public Duration getDuration() { 
      return this.duration;
    }

    public void setDuration(Duration value) { 
      this.duration = value;
    }

    public Integer getPlannedEnrollment() { 
      return this.plannedEnrollment;
    }

    public void setPlannedEnrollment(Integer value) { 
      this.plannedEnrollment = value;
    }

    public int getPlannedEnrollmentSimple() { 
      return this.plannedEnrollment == null ? null : this.plannedEnrollment.getValue();
    }

    public void setPlannedEnrollmentSimple(int value) { 
      if (value == -1)
        this.plannedEnrollment = null;
      else {
        if (this.plannedEnrollment == null)
          this.plannedEnrollment = new Integer();
        this.plannedEnrollment.setValue(value);
      }
    }

    public StudyInterventionComponent getIntervention() { 
      return this.intervention;
    }

    public void setIntervention(StudyInterventionComponent value) { 
      this.intervention = value;
    }

    public List<ResourceReference> getProtocol() { 
      return this.protocol;
    }

    public ResourceReference getDataStructure() { 
      return this.dataStructure;
    }

    public void setDataStructure(ResourceReference value) { 
      this.dataStructure = value;
    }

    public List<ResourceReference> getData() { 
      return this.data;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Study;
   }


}

