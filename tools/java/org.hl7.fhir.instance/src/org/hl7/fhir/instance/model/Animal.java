package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Fri, May 18, 2012 22:20+1000 for FHIR v0.02

import java.util.*;

/**
 * An animal that has relevance to the care process -usually this is for animals that are patients.
 */
public class Animal extends Resource {

    public class RelatedEntity extends Element {
        /**
         * Identifier for the entity
         */
        private HumanId id;

        /**
         * Type of relationship
         */
        private CodeableConcept role;

        /**
         * Name of the related entity
         */
        private HumanName name;

        /**
         * An address (usually human, but may be kin)
         */
        private List<Address> address = new ArrayList<Address>();

        /**
         * Contact details (usually for humans)
         */
        private List<Contact> contact = new ArrayList<Contact>();

        public HumanId getId() { 
          return this.id;
        }

        public void setId(HumanId value) { 
          this.id = value;
        }

        public CodeableConcept getRole() { 
          return this.role;
        }

        public void setRole(CodeableConcept value) { 
          this.role = value;
        }

        public HumanName getName() { 
          return this.name;
        }

        public void setName(HumanName value) { 
          this.name = value;
        }

        public List<Address> getAddress() { 
          return this.address;
        }

        public List<Contact> getContact() { 
          return this.contact;
        }

    }

    /**
     * Identifier for the animal that is used to identify the person across multiple disparate systems and also for face to face identification of the person
     */
    private List<HumanId> identifier = new ArrayList<HumanId>();

    /**
     * A name associated with the animal. The use code maiden does not apply.
     */
    private List<HumanName> name = new ArrayList<HumanName>();

    /**
     * The birth date for the animal
     */
    private DateTime dob;

    /**
     * Species for the animal
     */
    private CodeableConcept species;

    /**
     * Strain for the animal
     */
    private CodeableConcept strain;

    /**
     * Gender for the Animal
     */
    private CodeableConcept gender;

    /**
     * Kin, owner, care giver etc
     */
    private List<RelatedEntity> relatedEntity = new ArrayList<RelatedEntity>();

    public List<HumanId> getIdentifier() { 
      return this.identifier;
    }

    public List<HumanName> getName() { 
      return this.name;
    }

    public DateTime getDob() { 
      return this.dob;
    }

    public void setDob(DateTime value) { 
      this.dob = value;
    }

    public CodeableConcept getSpecies() { 
      return this.species;
    }

    public void setSpecies(CodeableConcept value) { 
      this.species = value;
    }

    public CodeableConcept getStrain() { 
      return this.strain;
    }

    public void setStrain(CodeableConcept value) { 
      this.strain = value;
    }

    public CodeableConcept getGender() { 
      return this.gender;
    }

    public void setGender(CodeableConcept value) { 
      this.gender = value;
    }

    public List<RelatedEntity> getRelatedEntity() { 
      return this.relatedEntity;
    }


}

