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

// Generated on Sun, Jan 20, 2013 20:00+1100 for FHIR v0.07

import java.util.*;

/**
 * A description of an individual who is involved in healthcare processes. The individual may be a patient, a provider of care services, or related to a patient in some way or other. 
 */
public class Demographics extends Type {

    public class Language extends Element {
        /**
         * The ISO-639-1 alpha 2 code in lower case for the language, optionally followed by a hyphen and the ISO-3166-1 alpha 2 code for the region in upper case. E.g. "en" for English, or "en-US" for American English versus "en-EN" for England English
         */
        private CodeableConcept language;

        /**
         * A value representing the person's method of expression of this language. Examples: expressed spoken, expressed written, expressed signed, received spoken, received written, received signed
         */
        private CodeableConcept mode;

        /**
         * A code that describes how well the language is spoken
         */
        private CodeableConcept proficiencyLevel;

        /**
         * Indicates whether or not the Person prefers this language (over other languages he masters up a certain level)
         */
        private Boolean preference;

        public CodeableConcept getLanguage() { 
          return this.language;
        }

        public void setLanguage(CodeableConcept value) { 
          this.language = value;
        }

        public CodeableConcept getMode() { 
          return this.mode;
        }

        public void setMode(CodeableConcept value) { 
          this.mode = value;
        }

        public CodeableConcept getProficiencyLevel() { 
          return this.proficiencyLevel;
        }

        public void setProficiencyLevel(CodeableConcept value) { 
          this.proficiencyLevel = value;
        }

        public Boolean getPreference() { 
          return this.preference;
        }

        public void setPreference(Boolean value) { 
          this.preference = value;
        }

    }

    /**
     * A name associated with the individual. 
     */
    private List<HumanName> name = new ArrayList<HumanName>();

    /**
     * A contact detail (e.g. a telephone number or an email address) by which the individual may be contacted. 
     */
    private List<Contact> telecom = new ArrayList<Contact>();

    /**
     * Administrative Gender - the gender that the patient is considered to have for administration / record keeping purposes
     */
    private Coding gender;

    /**
     * The birth date for the individual, to the degre of precision now
     */
    private DateTime birthDate;

    /**
     * Indicates if the individual is deceased or not
     */
    private Boolean deceased;

    /**
     * One or more addresses for the individual
     */
    private List<Address> address = new ArrayList<Address>();

    /**
     * This field contains a patient's marital (civil) status.
     */
    private CodeableConcept maritalStatus;

    /**
     * A language spoken by the person, with proficiency
     */
    private List<Language> language = new ArrayList<Language>();

    public List<HumanName> getName() { 
      return this.name;
    }

    public List<Contact> getTelecom() { 
      return this.telecom;
    }

    public Coding getGender() { 
      return this.gender;
    }

    public void setGender(Coding value) { 
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

