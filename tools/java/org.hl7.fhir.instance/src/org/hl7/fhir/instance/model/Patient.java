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

// Generated on Sat, Jan 19, 2013 17:09+1100 for FHIR v0.07

import java.util.*;

/**
 * A patient is a person or animal that is receiving care
 */
public class Patient extends Resource {

    public class Animal extends Element {
        /**
         * Identifies the high level categorization of the kind of animal
         */
        private CodeableConcept species;

        /**
         * Identifies the detailed categorization of the kind of animal.
         */
        private CodeableConcept breed;

        /**
         * Indicates the current state of the animal's reproductive organs
         */
        private CodeableConcept genderStatus;

        public CodeableConcept getSpecies() { 
          return this.species;
        }

        public void setSpecies(CodeableConcept value) { 
          this.species = value;
        }

        public CodeableConcept getBreed() { 
          return this.breed;
        }

        public void setBreed(CodeableConcept value) { 
          this.breed = value;
        }

        public CodeableConcept getGenderStatus() { 
          return this.genderStatus;
        }

        public void setGenderStatus(CodeableConcept value) { 
          this.genderStatus = value;
        }

    }

    /**
     * A linked patient record is a record that concerns the same patient. Records are linked after it is realized that at least one was created in error.
     */
    private List<ResourceReference> link = new ArrayList<ResourceReference>();

    /**
     * Whether the patient record is in use, or has been removed from active use
     */
    private Boolean active;

    /**
     * An identifier that applies to this person as a patient
     */
    private List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * Patient Demographic details
     */
    private Demographics details;

    /**
     * This element has a value if the patient is an animal
     */
    private Animal animal;

    /**
     * The provider for whom this is a patient record
     */
    private ResourceReference provider;

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

    public List<Identifier> getIdentifier() { 
      return this.identifier;
    }

    public Demographics getDetails() { 
      return this.details;
    }

    public void setDetails(Demographics value) { 
      this.details = value;
    }

    public Animal getAnimal() { 
      return this.animal;
    }

    public void setAnimal(Animal value) { 
      this.animal = value;
    }

    public ResourceReference getProvider() { 
      return this.provider;
    }

    public void setProvider(ResourceReference value) { 
      this.provider = value;
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

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Patient;
   }


}

