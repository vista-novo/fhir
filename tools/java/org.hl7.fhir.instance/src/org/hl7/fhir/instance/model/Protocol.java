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
 * A definition of behaviors to be taken in particular circumstnaces, often including conditions, options and other decision points
 */
public class Protocol extends Resource {

    public enum ProtocolType {
        condition, // The protocol describes the steps to manage a particular health condition including monitoring, treatment, mitigation and/or follow-up
        device, // The protocol describes the appropriate use of a particular device (medical device, software, etc.)
        drug, // The protocol describes the appropriate use of a particular medication including indications for use, dosages, treatment cycles, etc.
        study, // The protocol describes the set of steps to occur for study subjects enrolled in an interventional study
        Null; // added to help the parsers
        public static ProtocolType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("condition".equals(codeString))
          return condition;
        if ("device".equals(codeString))
          return device;
        if ("drug".equals(codeString))
          return drug;
        if ("study".equals(codeString))
          return study;
        throw new Exception("Unknown ProtocolType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case condition: return "condition";
            case device: return "device";
            case drug: return "drug";
            case study: return "study";
            default: return "?";
          }
        }
    }

  public class ProtocolTypeEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("condition".equals(codeString))
          return ProtocolType.condition;
        if ("device".equals(codeString))
          return ProtocolType.device;
        if ("drug".equals(codeString))
          return ProtocolType.drug;
        if ("study".equals(codeString))
          return ProtocolType.study;
        throw new Exception("Unknown ProtocolType code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ProtocolType.condition)
        return "condition";
      if (code == ProtocolType.device)
        return "device";
      if (code == ProtocolType.drug)
        return "drug";
      if (code == ProtocolType.study)
        return "study";
      return "?";
      }
    }

    public enum ProtocolStatus {
        draft, // This protocol is still under development
        testing, // This protocol was authored for testing purposes (or education/evaluation/marketing)
        review, // This protocol is undergoing review to check that it is ready for production use
        production, // This protocol is ready for use in production systems
        withdrawn, // This protocol has been withdrawn and should no longer be used
        superseded, // This protocol has been replaced and a different protocol should be used in its place
        Null; // added to help the parsers
        public static ProtocolStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return draft;
        if ("testing".equals(codeString))
          return testing;
        if ("review".equals(codeString))
          return review;
        if ("production".equals(codeString))
          return production;
        if ("withdrawn".equals(codeString))
          return withdrawn;
        if ("superseded".equals(codeString))
          return superseded;
        throw new Exception("Unknown ProtocolStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case draft: return "draft";
            case testing: return "testing";
            case review: return "review";
            case production: return "production";
            case withdrawn: return "withdrawn";
            case superseded: return "superseded";
            default: return "?";
          }
        }
    }

  public class ProtocolStatusEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return ProtocolStatus.draft;
        if ("testing".equals(codeString))
          return ProtocolStatus.testing;
        if ("review".equals(codeString))
          return ProtocolStatus.review;
        if ("production".equals(codeString))
          return ProtocolStatus.production;
        if ("withdrawn".equals(codeString))
          return ProtocolStatus.withdrawn;
        if ("superseded".equals(codeString))
          return ProtocolStatus.superseded;
        throw new Exception("Unknown ProtocolStatus code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ProtocolStatus.draft)
        return "draft";
      if (code == ProtocolStatus.testing)
        return "testing";
      if (code == ProtocolStatus.review)
        return "review";
      if (code == ProtocolStatus.production)
        return "production";
      if (code == ProtocolStatus.withdrawn)
        return "withdrawn";
      if (code == ProtocolStatus.superseded)
        return "superseded";
      return "?";
      }
    }

    public class ProtocolStepComponent extends Element {
        /**
         * Label for step
         */
        private String_ name;

        /**
         * Human description of activity
         */
        private String_ description;

        /**
         * How long does step last?
         */
        private Duration duration;

        /**
         * Rules prior to execution
         */
        private ProtocolStepPreconditionComponent precondition;

        /**
         * Indicates the conditions that must be met for activities that are part of this time point to terminate.
         */
        private ProtocolStepPreconditionComponent exit;

        /**
         * First activity within timepoint
         */
        private String_ firstActivity;

        /**
         * Activities that occur within timepoint
         */
        private List<ProtocolStepActivityComponent> activity = new ArrayList<ProtocolStepActivityComponent>();

        /**
         * What happens next?
         */
        private List<ProtocolStepNextComponent> next = new ArrayList<ProtocolStepNextComponent>();

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public String getNameSimple() { 
          return this.name == null ? null : this.name.getValue();
        }

        public void setNameSimple(String value) { 
          if (value == null)
            this.name = null;
          else {
            if (this.name == null)
              this.name = new String_();
            this.name.setValue(value);
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

        public Duration getDuration() { 
          return this.duration;
        }

        public void setDuration(Duration value) { 
          this.duration = value;
        }

        public ProtocolStepPreconditionComponent getPrecondition() { 
          return this.precondition;
        }

        public void setPrecondition(ProtocolStepPreconditionComponent value) { 
          this.precondition = value;
        }

        public ProtocolStepPreconditionComponent getExit() { 
          return this.exit;
        }

        public void setExit(ProtocolStepPreconditionComponent value) { 
          this.exit = value;
        }

        public String_ getFirstActivity() { 
          return this.firstActivity;
        }

        public void setFirstActivity(String_ value) { 
          this.firstActivity = value;
        }

        public String getFirstActivitySimple() { 
          return this.firstActivity == null ? null : this.firstActivity.getValue();
        }

        public void setFirstActivitySimple(String value) { 
          if (value == null)
            this.firstActivity = null;
          else {
            if (this.firstActivity == null)
              this.firstActivity = new String_();
            this.firstActivity.setValue(value);
          }
        }

        public List<ProtocolStepActivityComponent> getActivity() { 
          return this.activity;
        }

        public List<ProtocolStepNextComponent> getNext() { 
          return this.next;
        }

  }

    public class ProtocolStepPreconditionComponent extends Element {
        /**
         * Human-readable description of the condition
         */
        private String_ description;

        /**
         * Defines the name/value pair that must hold for the condition to be met.
         */
        private ProtocolStepPreconditionConditionComponent condition;

        /**
         * Lists a set of conditions that must all be met
         */
        private List<ProtocolStepPreconditionComponent> intersection = new ArrayList<ProtocolStepPreconditionComponent>();

        /**
         * Lists alternative conditions, at least one of must be met
         */
        private List<ProtocolStepPreconditionComponent> union = new ArrayList<ProtocolStepPreconditionComponent>();

        /**
         * Lists conditions of which none must be met
         */
        private List<ProtocolStepPreconditionComponent> exclude = new ArrayList<ProtocolStepPreconditionComponent>();

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

        public ProtocolStepPreconditionConditionComponent getCondition() { 
          return this.condition;
        }

        public void setCondition(ProtocolStepPreconditionConditionComponent value) { 
          this.condition = value;
        }

        public List<ProtocolStepPreconditionComponent> getIntersection() { 
          return this.intersection;
        }

        public List<ProtocolStepPreconditionComponent> getUnion() { 
          return this.union;
        }

        public List<ProtocolStepPreconditionComponent> getExclude() { 
          return this.exclude;
        }

  }

    public class ProtocolStepPreconditionConditionComponent extends Element {
        /**
         * The type of observation, test or other assertion being evaluated by the condition.
         */
        private CodeableConcept type;

        /**
         * Indicates what value the observation/test/assertion must have in order for the condition to be considered to be satisfied.
         */
        private Type value;

        public CodeableConcept getType() { 
          return this.type;
        }

        public void setType(CodeableConcept value) { 
          this.type = value;
        }

        public Type getValue() { 
          return this.value;
        }

        public void setValue(Type value) { 
          this.value = value;
        }

  }

    public class ProtocolStepActivityComponent extends Element {
        /**
         * What can be done instead?
         */
        private List<String_> alternative = new ArrayList<String_>();

        /**
         * Activities that are part of this activity
         */
        private List<ProtocolStepActivityComponentComponent> component = new ArrayList<ProtocolStepActivityComponentComponent>();

        /**
         * What happens next
         */
        private List<String_> following = new ArrayList<String_>();

        /**
         * Indicates the length of time to wait between the conditions being satisfied for the activity to start and the actual start of the activity.
         */
        private Duration wait;

        /**
         * Information about the nature of the activity, including type, timing and other qualifiers
         */
        private ActivityDefinition detail;

        public List<String_> getAlternative() { 
          return this.alternative;
        }

        public List<ProtocolStepActivityComponentComponent> getComponent() { 
          return this.component;
        }

        public List<String_> getFollowing() { 
          return this.following;
        }

        public Duration getWait() { 
          return this.wait;
        }

        public void setWait(Duration value) { 
          this.wait = value;
        }

        public ActivityDefinition getDetail() { 
          return this.detail;
        }

        public void setDetail(ActivityDefinition value) { 
          this.detail = value;
        }

  }

    public class ProtocolStepActivityComponentComponent extends Element {
        /**
         * Order of occurrence
         */
        private Integer sequence;

        /**
         * Component activity
         */
        private String_ activity;

        public Integer getSequence() { 
          return this.sequence;
        }

        public void setSequence(Integer value) { 
          this.sequence = value;
        }

        public int getSequenceSimple() { 
          return this.sequence == null ? null : this.sequence.getValue();
        }

        public void setSequenceSimple(int value) { 
          if (value == -1)
            this.sequence = null;
          else {
            if (this.sequence == null)
              this.sequence = new Integer();
            this.sequence.setValue(value);
          }
        }

        public String_ getActivity() { 
          return this.activity;
        }

        public void setActivity(String_ value) { 
          this.activity = value;
        }

        public String getActivitySimple() { 
          return this.activity == null ? null : this.activity.getValue();
        }

        public void setActivitySimple(String value) { 
          if (value == null)
            this.activity = null;
          else {
            if (this.activity == null)
              this.activity = new String_();
            this.activity.setValue(value);
          }
        }

  }

    public class ProtocolStepNextComponent extends Element {
        /**
         * Description of what happens next
         */
        private String_ description;

        /**
         * Id of following step
         */
        private String_ id;

        /**
         * Condition in which next step is executed
         */
        private ProtocolStepPreconditionComponent condition;

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

        public String_ getId() { 
          return this.id;
        }

        public void setId(String_ value) { 
          this.id = value;
        }

        public String getIdSimple() { 
          return this.id == null ? null : this.id.getValue();
        }

        public void setIdSimple(String value) { 
          if (value == null)
            this.id = null;
          else {
            if (this.id == null)
              this.id = new String_();
            this.id.setValue(value);
          }
        }

        public ProtocolStepPreconditionComponent getCondition() { 
          return this.condition;
        }

        public void setCondition(ProtocolStepPreconditionComponent value) { 
          this.condition = value;
        }

  }

    /**
     * Name of protocol
     */
    private String_ title;

    /**
     * condition | device | drug | study
     */
    private Enumeration<ProtocolType> type;

    /**
     * Current status
     */
    private Enumeration<ProtocolStatus> status;

    /**
     * Who wrote protocol?
     */
    private ResourceReference author;

    /**
     * When is protocol to be used?
     */
    private String_ purpose;

    /**
     * What does protocol deal with?
     */
    private ResourceReference subject;

    /**
     * To whom does Protocol apply?
     */
    private ResourceReference group;

    /**
     * What's done as part of protocol
     */
    private List<ProtocolStepComponent> step = new ArrayList<ProtocolStepComponent>();

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

    public Enumeration<ProtocolType> getType() { 
      return this.type;
    }

    public void setType(Enumeration<ProtocolType> value) { 
      this.type = value;
    }

    public ProtocolType getTypeSimple() { 
      return this.type == null ? null : this.type.getValue();
    }

    public void setTypeSimple(ProtocolType value) { 
      if (value == null)
        this.type = null;
      else {
        if (this.type == null)
          this.type = new Enumeration<ProtocolType>();
        this.type.setValue(value);
      }
    }

    public Enumeration<ProtocolStatus> getStatus() { 
      return this.status;
    }

    public void setStatus(Enumeration<ProtocolStatus> value) { 
      this.status = value;
    }

    public ProtocolStatus getStatusSimple() { 
      return this.status == null ? null : this.status.getValue();
    }

    public void setStatusSimple(ProtocolStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<ProtocolStatus>();
        this.status.setValue(value);
      }
    }

    public ResourceReference getAuthor() { 
      return this.author;
    }

    public void setAuthor(ResourceReference value) { 
      this.author = value;
    }

    public String_ getPurpose() { 
      return this.purpose;
    }

    public void setPurpose(String_ value) { 
      this.purpose = value;
    }

    public String getPurposeSimple() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    public void setPurposeSimple(String value) { 
      if (value == null)
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new String_();
        this.purpose.setValue(value);
      }
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getGroup() { 
      return this.group;
    }

    public void setGroup(ResourceReference value) { 
      this.group = value;
    }

    public List<ProtocolStepComponent> getStep() { 
      return this.step;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Protocol;
   }


}

