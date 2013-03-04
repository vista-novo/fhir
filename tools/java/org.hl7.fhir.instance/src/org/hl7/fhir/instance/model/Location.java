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

// Generated on Mon, Mar 4, 2013 20:03+1100 for FHIR v0.07

import java.util.*;

/**
 * A place at which services may be provided by, or on behalf of, an Organization
 */
public class Location extends Resource {

    /**
     * Name of the location
     */
    private String_ name;

    /**
     * Classification of the location
     */
    private List<CodeableConcept> type = new ArrayList<CodeableConcept>();

    /**
     * Physical location
     */
    private Address address;

    /**
     * The contact details of the main communication devices present at the location
     */
    private Contact telecom;

    /**
     * The organization that provides services at the location
     */
    private ResourceReference provider;

    /**
     * Whether the location is still used to provide services
     */
    private Boolean active;

    /**
     * Description of the location
     */
    private String_ description;

    public String_ getName() { 
      return this.name;
    }

    public void setName(String_ value) { 
      this.name = value;
    }

    public String getNameSimple() { 
      return this.name == null ? null : this.name.getValue();
    }

    public void setNameSimple(String value) { 
      if (value == null)
        this.name = null;
      else {
        if (this.name == null)
          this.name = new String_();
        this.name.setValue(value);
      }
    }

    public List<CodeableConcept> getType() { 
      return this.type;
    }

    public Address getAddress() { 
      return this.address;
    }

    public void setAddress(Address value) { 
      this.address = value;
    }

    public Contact getTelecom() { 
      return this.telecom;
    }

    public void setTelecom(Contact value) { 
      this.telecom = value;
    }

    public ResourceReference getProvider() { 
      return this.provider;
    }

    public void setProvider(ResourceReference value) { 
      this.provider = value;
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

    public String_ getDescription() { 
      return this.description;
    }

    public void setDescription(String_ value) { 
      this.description = value;
    }

    public String getDescriptionSimple() { 
      return this.description == null ? null : this.description.getValue();
    }

    public void setDescriptionSimple(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new String_();
        this.description.setValue(value);
      }
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Location;
   }


}

