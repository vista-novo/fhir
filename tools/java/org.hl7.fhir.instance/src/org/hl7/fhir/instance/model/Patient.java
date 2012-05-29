package org.hl7.fhir.instance.model;

// Copyright HL7 (http://hl7.org). Generated on Fri, May 18, 2012 22:20+1000 for FHIR v0.02

import java.util.*;

/**
 * A patient is a person or animal that is receiving care
 */
public class Patient extends Resource {

    /**
     * A linked patient record is a record that concerns the same patient. Records are linked after it is realised that at least one was created in error.
     */
    private List<ResourceReference> link = new ArrayList<ResourceReference>();

    /**
     * Whether the patient record is in use, or has been removed from active use
     */
    private Boolean active;

    /**
     * The person that this patient record is about
     */
    private ResourceReference person;

    /**
     * The animal that this patient record is about
     */
    private ResourceReference animal;

    /**
     * The provider for whom this is a patient record
     */
    private ResourceReference provider;

    /**
     * An identifier that applies to this person as a patient
     */
    private List<HumanId> identifier = new ArrayList<HumanId>();

    /**
     * Dietary restrictions for the patient
     */
    private CodeableConcept diet;

    /**
     * Confidentiality of the patient records
     */
    private CodeableConcept confidentiality;

    /**
     * The location of the paper record for the patient, if there is one
     */
    private CodeableConcept recordLocation;

    public List<ResourceReference> getLink() { 
      return this.link;
    }

    public Boolean getActive() { 
      return this.active;
    }

    public void setActive(Boolean value) { 
      this.active = value;
    }

    public ResourceReference getPerson() { 
      return this.person;
    }

    public void setPerson(ResourceReference value) { 
      this.person = value;
    }

    public ResourceReference getAnimal() { 
      return this.animal;
    }

    public void setAnimal(ResourceReference value) { 
      this.animal = value;
    }

    public ResourceReference getProvider() { 
      return this.provider;
    }

    public void setProvider(ResourceReference value) { 
      this.provider = value;
    }

    public List<HumanId> getIdentifier() { 
      return this.identifier;
    }

    public CodeableConcept getDiet() { 
      return this.diet;
    }

    public void setDiet(CodeableConcept value) { 
      this.diet = value;
    }

    public CodeableConcept getConfidentiality() { 
      return this.confidentiality;
    }

    public void setConfidentiality(CodeableConcept value) { 
      this.confidentiality = value;
    }

    public CodeableConcept getRecordLocation() { 
      return this.recordLocation;
    }

    public void setRecordLocation(CodeableConcept value) { 
      this.recordLocation = value;
    }


}

