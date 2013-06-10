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

// Generated on Mon, Jun 10, 2013 20:06+1000 for FHIR v0.09

import java.util.*;

/**
 * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, etc
 */
public class Organization extends Resource {

    public class OrganizationAccreditationComponent extends Element {
        /**
         * The identifier of the accreditation
         */
        protected Identifier identifier;

        /**
         * The type of the accreditation
         */
        protected CodeableConcept code;

        /**
         * The organization that conferred/confers the accreditation
         */
        protected ResourceReference issuer;

        /**
         * The period for which the accreditation is held
         */
        protected Period period;

        public Identifier getIdentifier() { 
          return this.identifier;
        }

        public void setIdentifier(Identifier value) { 
          this.identifier = value;
        }

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public ResourceReference getIssuer() { 
          return this.issuer;
        }

        public void setIssuer(ResourceReference value) { 
          this.issuer = value;
        }

        public Period getPeriod() { 
          return this.period;
        }

        public void setPeriod(Period value) { 
          this.period = value;
        }

      public OrganizationAccreditationComponent copy(Organization e) {
        OrganizationAccreditationComponent dst = e.new OrganizationAccreditationComponent();
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.code = code == null ? null : code.copy();
        dst.issuer = issuer == null ? null : issuer.copy();
        dst.period = period == null ? null : period.copy();
        return dst;
      }

  }

    public class OrganizationContactEntityComponent extends Element {
        /**
         * Indicates a purpose for which the contact can be reached
         */
        protected CodeableConcept type;

        /**
         * A name associated with the contact
         */
        protected HumanName name;

        /**
         * A contact detail (e.g. a telephone number or an email address) by which the party may be contacted.
         */
        protected List<Contact> telecom = new ArrayList<Contact>();

        /**
         * Visiting or postal addresses for the contact
         */
        protected Address address;

        public CodeableConcept getType() { 
          return this.type;
        }

        public void setType(CodeableConcept value) { 
          this.type = value;
        }

        public HumanName getName() { 
          return this.name;
        }

        public void setName(HumanName value) { 
          this.name = value;
        }

        public List<Contact> getTelecom() { 
          return this.telecom;
        }

        public Address getAddress() { 
          return this.address;
        }

        public void setAddress(Address value) { 
          this.address = value;
        }

      public OrganizationContactEntityComponent copy(Organization e) {
        OrganizationContactEntityComponent dst = e.new OrganizationContactEntityComponent();
        dst.type = type == null ? null : type.copy();
        dst.name = name == null ? null : name.copy();
        dst.telecom = new ArrayList<Contact>();
        for (Contact i : telecom)
          dst.telecom.add(i.copy());
        dst.address = address == null ? null : address.copy();
        return dst;
      }

  }

    /**
     * Identifier for the organization that is used to identify the organization across multiple disparate systems
     */
    protected List<Identifier> identifier = new ArrayList<Identifier>();

    /**
     * A name associated with the organization
     */
    protected List<String_> name = new ArrayList<String_>();

    /**
     * The kind of organization that this is
     */
    protected CodeableConcept type;

    /**
     * An address for the organization
     */
    protected List<Address> address = new ArrayList<Address>();

    /**
     * A contact detail for the organization
     */
    protected List<Contact> telecom = new ArrayList<Contact>();

    /**
     * Whether the organization's record is still in active use
     */
    protected Boolean active;

    /**
     * The qualifications/certifications an organization has, including format educational achievements, accreditations and current certifications. All these qualifications may be used to determine what roles the organization may play in a healthcare environment
     */
    protected List<OrganizationAccreditationComponent> accreditation = new ArrayList<OrganizationAccreditationComponent>();

    /**
     * The organization of which this organization forms a part
     */
    protected ResourceReference partOf;

    /**
     * Contact for the organization for a certain purpose
     */
    protected List<OrganizationContactEntityComponent> contactEntity = new ArrayList<OrganizationContactEntityComponent>();

    public List<Identifier> getIdentifier() { 
      return this.identifier;
    }

    public List<String_> getName() { 
      return this.name;
    }

    public CodeableConcept getType() { 
      return this.type;
    }

    public void setType(CodeableConcept value) { 
      this.type = value;
    }

    public List<Address> getAddress() { 
      return this.address;
    }

    public List<Contact> getTelecom() { 
      return this.telecom;
    }

    public Boolean getActive() { 
      return this.active;
    }

    public void setActive(Boolean value) { 
      this.active = value;
    }

    public boolean getActiveSimple() { 
      return this.active == null ? null : this.active.getValue();
    }

    public void setActiveSimple(boolean value) { 
      if (value == false)
        this.active = null;
      else {
        if (this.active == null)
          this.active = new Boolean();
        this.active.setValue(value);
      }
    }

    public List<OrganizationAccreditationComponent> getAccreditation() { 
      return this.accreditation;
    }

    public ResourceReference getPartOf() { 
      return this.partOf;
    }

    public void setPartOf(ResourceReference value) { 
      this.partOf = value;
    }

    public List<OrganizationContactEntityComponent> getContactEntity() { 
      return this.contactEntity;
    }

      public Organization copy() {
        Organization dst = new Organization();
        dst.identifier = new ArrayList<Identifier>();
        for (Identifier i : identifier)
          dst.identifier.add(i.copy());
        dst.name = new ArrayList<String_>();
        for (String_ i : name)
          dst.name.add(i.copy());
        dst.type = type == null ? null : type.copy();
        dst.address = new ArrayList<Address>();
        for (Address i : address)
          dst.address.add(i.copy());
        dst.telecom = new ArrayList<Contact>();
        for (Contact i : telecom)
          dst.telecom.add(i.copy());
        dst.active = active == null ? null : active.copy();
        dst.accreditation = new ArrayList<OrganizationAccreditationComponent>();
        for (OrganizationAccreditationComponent i : accreditation)
          dst.accreditation.add(i.copy(dst));
        dst.partOf = partOf == null ? null : partOf.copy();
        dst.contactEntity = new ArrayList<OrganizationContactEntityComponent>();
        for (OrganizationContactEntityComponent i : contactEntity)
          dst.contactEntity.add(i.copy(dst));
        return dst;
      }

      protected Organization typedCopy() {
        return copy();
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Organization;
   }


}

