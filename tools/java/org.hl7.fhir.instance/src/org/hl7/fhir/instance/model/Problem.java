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
 * Use to record detailed information about problems or diagnoses recognised by a clinician. There are many uses including: recording a Diagnosis during an Encounter; populating a Problem List or a Summary Statement, such as a Discharge Summary
 */
public class Problem extends Resource {

    public enum ProblemRelationshipType {
        dueMinusto, // 
        follows, // 
        Null; // added to help the parsers
        public static ProblemRelationshipType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("due-to".equals(codeString))
          return dueMinusto;
        if ("follows".equals(codeString))
          return follows;
        throw new Exception("Unknown ProblemRelationshipType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case dueMinusto: return "due-to";
            case follows: return "follows";
            default: return "?";
          }
        }
    }

  public class ProblemRelationshipTypeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("due-to".equals(codeString))
          return ProblemRelationshipType.dueMinusto;
        if ("follows".equals(codeString))
          return ProblemRelationshipType.follows;
        throw new Exception("Unknown ProblemRelationshipType code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ProblemRelationshipType.dueMinusto)
        return "due-to";
      if (code == ProblemRelationshipType.follows)
        return "follows";
      return "?";
      }
    }

    public class Stage extends Element {
        /**
         * A simple summary of the stage such as "Stage 3". The determination of the stage is disease-specific
         */
        private CodeableConcept summary;

        /**
         * Reference to a formal record of the evidence on which the staging assessment is based
         */
        private List<ResourceReference> assessment = new ArrayList<ResourceReference>();

        public CodeableConcept getSummary() { 
          return this.summary;
        }

        public void setSummary(CodeableConcept value) { 
          this.summary = value;
        }

        public List<ResourceReference> getAssessment() { 
          return this.assessment;
        }

  }

    public class Evidence extends Element {
        /**
         * A manifestion or symptom that led to the recording of this problem/diagnosis
         */
        private CodeableConcept code;

        /**
         * Links to other relevant information, including pathology reports
         */
        private List<ResourceReference> details = new ArrayList<ResourceReference>();

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public List<ResourceReference> getDetails() { 
          return this.details;
        }

  }

    public class Location extends Element {
        /**
         * Code that identifies the structural location
         */
        private CodeableConcept code;

        /**
         * Detailed and structured anatomical location information
         */
        private ResourceReference details;

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public ResourceReference getDetails() { 
          return this.details;
        }

        public void setDetails(ResourceReference value) { 
          this.details = value;
        }

  }

    public class RelatedItem extends Element {
        /**
         * The type of relationship that this problem/diagnosis has to the related item
         */
        private Enumeration<ProblemRelationshipType> type;

        /**
         * Target of the relationship
         */
        private ResourceReference target;

        public Enumeration<ProblemRelationshipType> getType() { 
          return this.type;
        }

        public void setType(Enumeration<ProblemRelationshipType> value) { 
          this.type = value;
        }

        public ProblemRelationshipType getTypeSimple() { 
          return this.type == null ? null : this.type.getValue();
        }

        public void setTypeSimple(ProblemRelationshipType value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<ProblemRelationshipType>();
            this.type.setValue(value);
          }
        }

        public ResourceReference getTarget() { 
          return this.target;
        }

        public void setTarget(ResourceReference value) { 
          this.target = value;
        }

  }

    /**
     * Subject of this problem
     */
    private ResourceReference subject;

    /**
     * Encounter during which the problem was first asserted
     */
    private ResourceReference encounter;

    /**
     * Person who asserts this problem
     */
    private ResourceReference asserter;

    /**
     * Estimated or actual date the problem/diagnosis was first detected/suspected
     */
    private Date dateAsserted;

    /**
     * Identification of the problem or diagnosis.
     */
    private CodeableConcept code;

    /**
     * A category assigned to the problem/diagnosis. E.g. finding | problem | diagnosis | concern | condition
     */
    private CodeableConcept category;

    /**
     * The clinical status of the problem or diagnosis
     */
    private Code status;

    /**
     * The degree of confidence that this problem/diagnosis is correct
     */
    private CodeableConcept certainty;

    /**
     * A subjective assessment of the severity of the Problem/Diagnosis as evaluated by the clinician.
     */
    private CodeableConcept severity;

    /**
     * Estimated or actual date the problem/diagnosis began, in the opinion of the clinician
     */
    private Type onset;

    /**
     * The date or estimated date that the problem/diagnosis resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - problems are never really resolved, but they can abate.
     */
    private Type abatement;

    /**
     * Clinical stage or grade of a problem/diagnosis. May include formal severity assessments
     */
    private Stage stage;

    /**
     * Supporting Evidence / manfiestions that are the basis on which this problem/diagnosis is suspected or confirmed
     */
    private List<Evidence> evidence = new ArrayList<Evidence>();

    /**
     * The anatomical location where this problem/diagnosis manifests itself
     */
    private List<Location> location = new ArrayList<Location>();

    /**
     * Further problems, diagnoses, procedures or events that are related in some way to this problem/diagnosis, or the substance that caused/triggered this problem
     */
    private List<RelatedItem> relatedItem = new ArrayList<RelatedItem>();

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getEncounter() { 
      return this.encounter;
    }

    public void setEncounter(ResourceReference value) { 
      this.encounter = value;
    }

    public ResourceReference getAsserter() { 
      return this.asserter;
    }

    public void setAsserter(ResourceReference value) { 
      this.asserter = value;
    }

    public Date getDateAsserted() { 
      return this.dateAsserted;
    }

    public void setDateAsserted(Date value) { 
      this.dateAsserted = value;
    }

    public String getDateAssertedSimple() { 
      return this.dateAsserted == null ? null : this.dateAsserted.getValue();
    }

    public void setDateAssertedSimple(String value) { 
      if (value == null)
        this.dateAsserted = null;
      else {
        if (this.dateAsserted == null)
          this.dateAsserted = new Date();
        this.dateAsserted.setValue(value);
      }
    }

    public CodeableConcept getCode() { 
      return this.code;
    }

    public void setCode(CodeableConcept value) { 
      this.code = value;
    }

    public CodeableConcept getCategory() { 
      return this.category;
    }

    public void setCategory(CodeableConcept value) { 
      this.category = value;
    }

    public Code getStatus() { 
      return this.status;
    }

    public void setStatus(Code value) { 
      this.status = value;
    }

    public String getStatusSimple() { 
      return this.status == null ? null : this.status.getValue();
    }

    public void setStatusSimple(String value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Code();
        this.status.setValue(value);
      }
    }

    public CodeableConcept getCertainty() { 
      return this.certainty;
    }

    public void setCertainty(CodeableConcept value) { 
      this.certainty = value;
    }

    public CodeableConcept getSeverity() { 
      return this.severity;
    }

    public void setSeverity(CodeableConcept value) { 
      this.severity = value;
    }

    public Type getOnset() { 
      return this.onset;
    }

    public void setOnset(Type value) { 
      this.onset = value;
    }

    public Type getAbatement() { 
      return this.abatement;
    }

    public void setAbatement(Type value) { 
      this.abatement = value;
    }

    public Stage getStage() { 
      return this.stage;
    }

    public void setStage(Stage value) { 
      this.stage = value;
    }

    public List<Evidence> getEvidence() { 
      return this.evidence;
    }

    public List<Location> getLocation() { 
      return this.location;
    }

    public List<RelatedItem> getRelatedItem() { 
      return this.relatedItem;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Problem;
   }


}

