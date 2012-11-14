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

// Generated on Wed, Nov 14, 2012 12:51+1100 for FHIR v0.06

import java.util.*;

/**
 * A person who is involved in the healthcare process
 */
public class Person extends Resource {

    public class Language extends Element {
        /**
         * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case. E.g. "en" for English, or "en-US" for American English versus "en-EN" for England English
         */
        private CodeableConcept languageCode;

        /**
         * A value representing the person's method of expression of this language. Examples: expressed spoken, expressed written, expressed signed, received spoken, received written, received signed
         */
        private CodeableConcept modeCode;

        /**
         * A code that describes how well the language is spoken
         */
        private CodeableConcept proficiencyLevelCode;

        /**
         * Indicates whether or not the Person prefers this language (over other languages he masters up a certain level)
         */
        private Boolean preferenceInd;

        public CodeableConcept getLanguageCode() { 
          return this.languageCode;
        }

        public void setLanguageCode(CodeableConcept value) { 
          this.languageCode = value;
        }

        public CodeableConcept getModeCode() { 
          return this.modeCode;
        }

        public void setModeCode(CodeableConcept value) { 
          this.modeCode = value;
        }

        public CodeableConcept getProficiencyLevelCode() { 
          return this.proficiencyLevelCode;
        }

        public void setProficiencyLevelCode(CodeableConcept value) { 
          this.proficiencyLevelCode = value;
        }

        public Boolean getPreferenceInd() { 
          return this.preferenceInd;
        }

        public void setPreferenceInd(Boolean value) { 
          this.preferenceInd = value;
        }

    }

    /**
     * Identifier for a person within a particular scope.
     */
    private List<HumanId> identifier = new ArrayList<HumanId>();

    /**
     * A name associated with the person
     */
    private List<HumanName> name = new ArrayList<HumanName>();

    /**
     * A contact detail for the person, e.g. a telephone number or an email address.
     */
    private List<Contact> telecom = new ArrayList<Contact>();

    /**
     * Administrative Gender
     */
    private CodeableConcept gender;

    /**
     * The birth date for the person.
     */
    private DateTime birthDate;

    /**
     * Indicates if the Person deceased or not
     */
    private Boolean deceased;

    /**
     * An address for the person
     */
    private List<Address> address = new ArrayList<Address>();

    /**
     * This field contains the patient's marital (civil) status.
     */
    private CodeableConcept maritalStatus;

    /**
     * A language spoken by the person, with proficiency
     */
    private List<Language> language = new ArrayList<Language>();

    public List<HumanId> getIdentifier() { 
      return this.identifier;
    }

    public List<HumanName> getName() { 
      return this.name;
    }

    public List<Contact> getTelecom() { 
      return this.telecom;
    }

    public CodeableConcept getGender() { 
      return this.gender;
    }

    public void setGender(CodeableConcept value) { 
      this.gender = value;
    }

    public DateTime getBirthDate() { 
      return this.birthDate;
    }

    public void setBirthDate(DateTime value) { 
      this.birthDate = value;
    }

    public Boolean getDeceased() { 
      return this.deceased;
    }

    public void setDeceased(Boolean value) { 
      this.deceased = value;
    }

    public List<Address> getAddress() { 
      return this.address;
    }

    public CodeableConcept getMaritalStatus() { 
      return this.maritalStatus;
    }

    public void setMaritalStatus(CodeableConcept value) { 
      this.maritalStatus = value;
    }

    public List<Language> getLanguage() { 
      return this.language;
    }


}

