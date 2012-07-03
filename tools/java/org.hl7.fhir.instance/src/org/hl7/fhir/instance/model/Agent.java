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

// Generated on Sat, Jun 30, 2012 08:13+1000 for FHIR v0.04

import java.util.*;

/**
 * A person who represents an organisation, and is authorised to perform actions on it's behalf
 */
public class Agent extends Resource {

    /**
     * The person who acts as the agent
     */
    private ResourceReference person;

    /**
     * The organisation that is being represented
     */
    private ResourceReference organization;

    /**
     * The way in which the person represents the organisation - what role do they have?
     */
    private List<CodeableConcept> role = new ArrayList<CodeableConcept>();

    /**
     * The time period during which the agent was/is authorised to represent the organisation.
     */
    private Interval<Date> period;

    /**
     * An identifier that applies to this person in this role
     */
    private List<HumanId> identifier = new ArrayList<HumanId>();

    /**
     * A postal address for this person playing this role
     */
    private List<Address> address = new ArrayList<Address>();

    /**
     * A contact detail address for this person playing this role
     */
    private List<Contact> contact = new ArrayList<Contact>();

    public ResourceReference getPerson() { 
      return this.person;
    }

    public void setPerson(ResourceReference value) { 
      this.person = value;
    }

    public ResourceReference getOrganization() { 
      return this.organization;
    }

    public void setOrganization(ResourceReference value) { 
      this.organization = value;
    }

    public List<CodeableConcept> getRole() { 
      return this.role;
    }

    public Interval<Date> getPeriod() { 
      return this.period;
    }

    public void setPeriod(Interval<Date> value) { 
      this.period = value;
    }

    public List<HumanId> getIdentifier() { 
      return this.identifier;
    }

    public List<Address> getAddress() { 
      return this.address;
    }

    public List<Contact> getContact() { 
      return this.contact;
    }


}

