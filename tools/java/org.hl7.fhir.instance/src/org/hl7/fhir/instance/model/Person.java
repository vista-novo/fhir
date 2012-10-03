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

// Generated on Wed, Oct 3, 2012 17:55+1000 for FHIR v0.06

import java.util.*;

/**
 * A person who is involved in the healthcare process
 */
public class Person extends Resource {

    public enum LanguageUse {
        none, // The person does not speak the language at all
        poor, // The person has minimal functional capability in the language
        useable, // The person can use the language, but may not be full conversant, particularly with regards to health concepts
        fluent; // The person is fully capable of using the language
        public static LanguageUse fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("none".equals(codeString))
          return none;
        if ("poor".equals(codeString))
          return poor;
        if ("useable".equals(codeString))
          return useable;
        if ("fluent".equals(codeString))
          return fluent;
        throw new Exception("Unknown LanguageUse code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case none: return "none";
            case poor: return "poor";
            case useable: return "useable";
            case fluent: return "fluent";
            default: return "?";
          }
        }
    }

    public class ContactParty extends Element {
        /**
         * The type of the contact party
         */
        private CodeableConcept role;

        /**
         * The name of the contact party
         */
        private HumanName name;

        /**
         * The address of the contact party
         */
        private List<Address> address = new ArrayList<Address>();

        /**
         * The telecommunication addresses of the contact party, e.g. phone, fax, email etcetera
         */
        private List<Contact> telecom = new ArrayList<Contact>();

        /**
         * Reference to the Person|Organization|Agent resource that is the contact party
         */
        private ResourceReference party;

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

        public List<Contact> getTelecom() { 
          return this.telecom;
        }

        public ResourceReference getParty() { 
          return this.party;
        }

        public void setParty(ResourceReference value) { 
          this.party = value;
        }

    }

    public class Language extends Element {
        /**
         * A code that identifies the language
         */
        private String code;

        /**
         * A code that describes how well the language is spoken
         */
        private LanguageUse level;

        public String getCode() { 
          return this.code;
        }

        public void setCode(String value) { 
          this.code = value;
        }

        public LanguageUse getLevel() { 
          return this.level;
        }

        public void setLevel(LanguageUse value) { 
          this.level = value;
        }

    }

    /**
     * Identifier for the person that is used to identify the person across multiple disparate systems and also for face to face identification of the person
     */
    private List<HumanId> identifier = new ArrayList<HumanId>();

    /**
     * A name associated with the person
     */
    private List<HumanName> name = new ArrayList<HumanName>();

    /**
     * A contact detail for the person
     */
    private List<Contact> telecom = new ArrayList<Contact>();

    /**
     * Administrative Gender
     */
    private CodeableConcept gender;

    /**
     * The birth date for the person
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
    private DateTime maritalStatus;

    /**
     * A generic contact party for the person. 
     */
    private List<ContactParty> contactParty = new ArrayList<ContactParty>();

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

    public DateTime getMaritalStatus() { 
      return this.maritalStatus;
    }

    public void setMaritalStatus(DateTime value) { 
      this.maritalStatus = value;
    }

    public List<ContactParty> getContactParty() { 
      return this.contactParty;
    }

    public List<Language> getLanguage() { 
      return this.language;
    }


}

