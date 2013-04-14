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

/**
 * Significant health events and conditions for people related to the subject
 */
public class FamilyHistory extends Resource {

    public enum FamilialRelationship {
        mother, // Mother
        father, // Father
        sister, // Sister
        brother, // Brother
        uncle, // Uncle
        aunt, // Auth
        gFather, // GrandFather
        gMother, // GrandMother
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
        if ("uncle".equals(codeString))
          return uncle;
        if ("aunt".equals(codeString))
          return aunt;
        if ("gFather".equals(codeString))
          return gFather;
        if ("gMother".equals(codeString))
          return gMother;
        throw new Exception("Unknown FamilialRelationship code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case mother: return "mother";
            case father: return "father";
            case sister: return "sister";
            case brother: return "brother";
            case uncle: return "uncle";
            case aunt: return "aunt";
            case gFather: return "gFather";
            case gMother: return "gMother";
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
        if ("uncle".equals(codeString))
          return FamilialRelationship.uncle;
        if ("aunt".equals(codeString))
          return FamilialRelationship.aunt;
        if ("gFather".equals(codeString))
          return FamilialRelationship.gFather;
        if ("gMother".equals(codeString))
          return FamilialRelationship.gMother;
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
      if (code == FamilialRelationship.uncle)
        return "uncle";
      if (code == FamilialRelationship.aunt)
        return "aunt";
      if (code == FamilialRelationship.gFather)
        return "gFather";
      if (code == FamilialRelationship.gMother)
        return "gMother";
      return "?";
      }
    }

    /**
     * The person who this history concerns
     */
    private ResourceReference subject;

    /**
     * If the person does not have an identity (ie they are not recorded in the system, then use an inline reference (see example)
     */
    private ResourceReference relatedPerson;

    /**
     * The type of relationship this person has to the patient (father, mother, brother etc.) At the moment this is a code linking to a fixed set of values. I'm not sure if there is an international standard for this. A fixed (possibly extensible) set of codes feels better than a codeable concept for somehting like this...
     */
    private Enumeration<FamilialRelationship> relationship;

    /**
     * The significant problem (or condition) that the family member had
     */
    private CodeableConcept condition;

    /**
     * The person died of the condition in this item
     */
    private Boolean isDeath;

    /**
     * Euither the age of onset or the date of onset can be recorded.
     */
    private Type onset;

    /**
     * An area where general notes can be placed
     */
    private String_ note;

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

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

    public CodeableConcept getCondition() { 
      return this.condition;
    }

    public void setCondition(CodeableConcept value) { 
      this.condition = value;
    }

    public Boolean getIsDeath() { 
      return this.isDeath;
    }

    public void setIsDeath(Boolean value) { 
      this.isDeath = value;
    }

    public boolean getIsDeathSimple() { 
      return this.isDeath == null ? null : this.isDeath.getValue();
    }

    public void setIsDeathSimple(boolean value) { 
      if (value == false)
        this.isDeath = null;
      else {
        if (this.isDeath == null)
          this.isDeath = new Boolean();
        this.isDeath.setValue(value);
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

  @Override
  public ResourceType getResourceType() {
    return ResourceType.FamilyHistory;
   }


}

