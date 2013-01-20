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
 * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively and are not formally or legally recognized.  I.e. A collection of entities that isn't an Organization
 */
public class Group extends Resource {

    public enum GroupType {
        person, // Group contains Person resources
        animal, // Group contains Animal resources
        device, // Group contains Device resources
        medication, // Group contains Medication resources
        food; // Group contains Food resources
        public static GroupType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("person".equals(codeString))
          return person;
        if ("animal".equals(codeString))
          return animal;
        if ("device".equals(codeString))
          return device;
        if ("medication".equals(codeString))
          return medication;
        if ("food".equals(codeString))
          return food;
        throw new Exception("Unknown GroupType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case person: return "person";
            case animal: return "animal";
            case device: return "device";
            case medication: return "medication";
            case food: return "food";
            default: return "?";
          }
        }
    }

    public class Characteristic extends Element {
        /**
         * Identifies the kind of trait being asserted
         */
        private CodeableConcept type;

        /**
         * The value of the trait that holds (or does not hold - see 'exclude') for members of the group
         */
        private Type value;

        /**
         * If true, indicates the characteristic is one that is NOT held by members of the group
         */
        private Boolean exclude;

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

        public Boolean getExclude() { 
          return this.exclude;
        }

        public void setExclude(Boolean value) { 
          this.exclude = value;
        }

    }

    /**
     * A unique business identifier for this group
     */
    private Identifier identifier;

    /**
     * Identifies the broad classification of the kind of resources the group includes
     */
    private GroupType type;

    /**
     * If true, indicates that the resource refers to a specific group of real individuals.  If false, the group defines a set of intended individuals
     */
    private Boolean actual;

    /**
     * Provides a specific type of resource the group includes.  E.g. "cow", "syringe", etc.
     */
    private CodeableConcept code;

    /**
     * A label assigned to the group for human identification and communication
     */
    private String_ name;

    /**
     * A count of the number of resource instances that are part of the group
     */
    private Integer quantity;

    /**
     * Identifies the traits shared by members of the group
     */
    private List<Characteristic> characteristic = new ArrayList<Characteristic>();

    /**
     * Identifies the resource instances that are members of the group.
     */
    private List<ResourceReference> member = new ArrayList<ResourceReference>();

    public Identifier getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(Identifier value) { 
      this.identifier = value;
    }

    public GroupType getType() { 
      return this.type;
    }

    public void setType(GroupType value) { 
      this.type = value;
    }

    public Boolean getActual() { 
      return this.actual;
    }

    public void setActual(Boolean value) { 
      this.actual = value;
    }

    public CodeableConcept getCode() { 
      return this.code;
    }

    public void setCode(CodeableConcept value) { 
      this.code = value;
    }

    public String_ getName() { 
      return this.name;
    }

    public void setName(String_ value) { 
      this.name = value;
    }

    public Integer getQuantity() { 
      return this.quantity;
    }

    public void setQuantity(Integer value) { 
      this.quantity = value;
    }

    public List<Characteristic> getCharacteristic() { 
      return this.characteristic;
    }

    public List<ResourceReference> getMember() { 
      return this.member;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Group;
   }


}

