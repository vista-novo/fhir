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
 * Significant health events and conditions for people related to the subject
 */
public class FamilyHistory extends Resource {

    public enum FamilialRelationship {
        mother, // Mother
        father, // Father
        sister, // Sister
        brother, // Brother
        matUncle, // Maternal Uncle
        matAunt, // Maternal Aunt
        matGFather, // Maternal GrandFather
        matGMother, // Maternal GrandMother
        patUncle, // Paternal Uncle
        patAunt, // Paternal Aunt
        patGFather, // Paternal GrandFather
        patGMother, // Paternal GrandMother
        Null; // added to help the parsers
        public static FamilialRelationship fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("mother".equals(codeString))
          return mother;
        if ("father".equals(codeString))
          return father;
        if ("sister".equals(codeString))
          return sister;
        if ("brother".equals(codeString))
          return brother;
        if ("matUncle".equals(codeString))
          return matUncle;
        if ("matAunt".equals(codeString))
          return matAunt;
        if ("matGFather".equals(codeString))
          return matGFather;
        if ("matGMother".equals(codeString))
          return matGMother;
        if ("patUncle".equals(codeString))
          return patUncle;
        if ("patAunt".equals(codeString))
          return patAunt;
        if ("patGFather".equals(codeString))
          return patGFather;
        if ("patGMother".equals(codeString))
          return patGMother;
        throw new Exception("Unknown FamilialRelationship code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case mother: return "mother";
            case father: return "father";
            case sister: return "sister";
            case brother: return "brother";
            case matUncle: return "matUncle";
            case matAunt: return "matAunt";
            case matGFather: return "matGFather";
            case matGMother: return "matGMother";
            case patUncle: return "patUncle";
            case patAunt: return "patAunt";
            case patGFather: return "patGFather";
            case patGMother: return "patGMother";
            default: return "?";
          }
        }
    }

  public class FamilialRelationshipEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("mother".equals(codeString))
          return FamilialRelationship.mother;
        if ("father".equals(codeString))
          return FamilialRelationship.father;
        if ("sister".equals(codeString))
          return FamilialRelationship.sister;
        if ("brother".equals(codeString))
          return FamilialRelationship.brother;
        if ("matUncle".equals(codeString))
          return FamilialRelationship.matUncle;
        if ("matAunt".equals(codeString))
          return FamilialRelationship.matAunt;
        if ("matGFather".equals(codeString))
          return FamilialRelationship.matGFather;
        if ("matGMother".equals(codeString))
          return FamilialRelationship.matGMother;
        if ("patUncle".equals(codeString))
          return FamilialRelationship.patUncle;
        if ("patAunt".equals(codeString))
          return FamilialRelationship.patAunt;
        if ("patGFather".equals(codeString))
          return FamilialRelationship.patGFather;
        if ("patGMother".equals(codeString))
          return FamilialRelationship.patGMother;
        throw new Exception("Unknown FamilialRelationship code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == FamilialRelationship.mother)
        return "mother";
      if (code == FamilialRelationship.father)
        return "father";
      if (code == FamilialRelationship.sister)
        return "sister";
      if (code == FamilialRelationship.brother)
        return "brother";
      if (code == FamilialRelationship.matUncle)
        return "matUncle";
      if (code == FamilialRelationship.matAunt)
        return "matAunt";
      if (code == FamilialRelationship.matGFather)
        return "matGFather";
      if (code == FamilialRelationship.matGMother)
        return "matGMother";
      if (code == FamilialRelationship.patUncle)
        return "patUncle";
      if (code == FamilialRelationship.patAunt)
        return "patAunt";
      if (code == FamilialRelationship.patGFather)
        return "patGFather";
      if (code == FamilialRelationship.patGMother)
        return "patGMother";
      return "?";
      }
    }

    public class FamilyHistoryRelationComponent extends Element {
        /**
         * Depending on the capabilities of the system creating the resource, the related person may be an identifiable (on a FHIR system) person, a specific person who is not formally identified or an unidentified person (eg aunt, brother etc). Hence this property is optional. If a real person, then it could either be a reference to the resource that identifies that person, or a contained reference. Examples of both are given
         */
        private ResourceReference relatedPerson;

        /**
         * The type of relationship this person has to the patient (father, mother, brother etc.) At the moment this is a code linking to a fixed set of values. I'm not sure if there is an international standard for this. A fixed (possibly extensible) set of codes feels better than a codeable concept for somehting like this...
         */
        private Enumeration<FamilialRelationship> relationship;

        /**
         * If this resource is indicating that the related person is deceased, then the the date of death - or age at death - can be indicated here. If present, a receiving system must understand what the resource is indicating. If the reason for death is known, then it can be indicated in the 'fatal' flag of the condition - in this case the deceased property should still be set.
         */
        private Type deceased;

        /**
         * This property allows a non condition-specific note to the made about the related person. Ideally, the note would be in the condition property, but this is not always possible.
         */
        private String_ note;

        /**
         * The significant problemss (or condition) that the family member had. This is a repeating section to allow a system to represent more than one condition per resource, though there is nothing stopping multiple resources - one per condition.
         */
        private List<FamilyHistoryRelationConditionComponent> condition = new ArrayList<FamilyHistoryRelationConditionComponent>();

        public ResourceReference getRelatedPerson() { 
          return this.relatedPerson;
        }

        public void setRelatedPerson(ResourceReference value) { 
          this.relatedPerson = value;
        }

        public Enumeration<FamilialRelationship> getRelationship() { 
          return this.relationship;
        }

        public void setRelationship(Enumeration<FamilialRelationship> value) { 
          this.relationship = value;
        }

        public FamilialRelationship getRelationshipSimple() { 
          return this.relationship == null ? null : this.relationship.getValue();
        }

        public void setRelationshipSimple(FamilialRelationship value) { 
          if (value == null)
            this.relationship = null;
          else {
            if (this.relationship == null)
              this.relationship = new Enumeration<FamilialRelationship>();
            this.relationship.setValue(value);
          }
        }

        public Type getDeceased() { 
          return this.deceased;
        }

        public void setDeceased(Type value) { 
          this.deceased = value;
        }

        public String_ getNote() { 
          return this.note;
        }

        public void setNote(String_ value) { 
          this.note = value;
        }

        public String getNoteSimple() { 
          return this.note == null ? null : this.note.getValue();
        }

        public void setNoteSimple(String value) { 
          if (value == null)
            this.note = null;
          else {
            if (this.note == null)
              this.note = new String_();
            this.note.setValue(value);
          }
        }

        public List<FamilyHistoryRelationConditionComponent> getCondition() { 
          return this.condition;
        }

  }

    public class FamilyHistoryRelationConditionComponent extends Element {
        /**
         * The actual condition specified. Could be a coded condition (like MI or Diabetes) or a less specific string like 'cancer' depending on how much is known about the condition and the capabilities of the creating system
         */
        private CodeableConcept type;

        /**
         * Indicates that the person died of this condition. The date of death is indicated by the deceased property. If present, a receiving system must understand it.
         */
        private Boolean fatal;

        /**
         * Either the age of onset or the date of onset can be recorded.
         */
        private Type onset;

        /**
         * An area where general notes can be placed about this specific condition.
         */
        private String_ note;

        public CodeableConcept getType() { 
          return this.type;
        }

        public void setType(CodeableConcept value) { 
          this.type = value;
        }

        public Boolean getFatal() { 
          return this.fatal;
        }

        public void setFatal(Boolean value) { 
          this.fatal = value;
        }

        public boolean getFatalSimple() { 
          return this.fatal == null ? null : this.fatal.getValue();
        }

        public void setFatalSimple(boolean value) { 
          if (value == false)
            this.fatal = null;
          else {
            if (this.fatal == null)
              this.fatal = new Boolean();
            this.fatal.setValue(value);
          }
        }

        public Type getOnset() { 
          return this.onset;
        }

        public void setOnset(Type value) { 
          this.onset = value;
        }

        public String_ getNote() { 
          return this.note;
        }

        public void setNote(String_ value) { 
          this.note = value;
        }

        public String getNoteSimple() { 
          return this.note == null ? null : this.note.getValue();
        }

        public void setNoteSimple(String value) { 
          if (value == null)
            this.note = null;
          else {
            if (this.note == null)
              this.note = new String_();
            this.note.setValue(value);
          }
        }

  }

    /**
     * The person who this history concerns
     */
    private ResourceReference subject;

    /**
     * The related person. Each FamilyHistory resource contains the entire family history for a single person.
     */
    private List<FamilyHistoryRelationComponent> relation = new ArrayList<FamilyHistoryRelationComponent>();

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public List<FamilyHistoryRelationComponent> getRelation() { 
      return this.relation;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.FamilyHistory;
   }


}

