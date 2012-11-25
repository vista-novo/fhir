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

// Generated on Sun, Nov 25, 2012 14:16+1100 for FHIR v0.06

import java.util.*;

/**
 * Financial instrument by which payment information for health care
 */
public class Coverage extends Resource {

    public class PlanHolder extends Element {
        /**
         * The name of the PolicyHolder
         */
        private HumanName name;

        /**
         * The mailing address, typically home, of the PolicyHolder
         */
        private Address address;

        /**
         * The date of birth of the PolicyHolder
         */
        private Date birthdate;

        public HumanName getName() { 
          return this.name;
        }

        public void setName(HumanName value) { 
          this.name = value;
        }

        public Address getAddress() { 
          return this.address;
        }

        public void setAddress(Address value) { 
          this.address = value;
        }

        public Date getBirthdate() { 
          return this.birthdate;
        }

        public void setBirthdate(Date value) { 
          this.birthdate = value;
        }

    }

    /**
     * The program or plan underwriter or payor.
     */
    private ResourceReference issuer;

    /**
     * Time period during which the coverage is in force. A msiing start date indicates the start date isn't know, a missing end date means the coverage is continuing to be in force.
     */
    private Period period;

    /**
     * The type of coverage: social program, medical plan, accident coverage (workers compensation, auto), group health. 
     */
    private Coding type;

    /**
     * The main, may be the only, identifier for the coverage - often referred to as a Subscriber Id, Certificate number or Personal Health Number or Case ID.
     */
    private Identifier identifier;

    /**
     * Identifies a style or collective of coverage issues by the underwriter, for example my be used to identify a class of coverage or employer group. May also be referred to as a Policy or Group ID.
     */
    private Identifier plan;

    /**
     * Identifies a sub-style or sub-collective of coverage issues by the underwriter, for example my be used to identify a specific employer group within a class of employers. May be refered to as a Section or Divsiion ID.
     */
    private Identifier subplan;

    /**
     * A unique identifier for a dependant under the coverage.
     */
    private Integer dependant;

    /**
     * An optional counter for a particular instance of the identified coverage which increments upon each renewal.
     */
    private Integer sequence;

    /**
     * Planholder information
     */
    private PlanHolder planHolder;

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

    public Coding getType() { 
      return this.type;
    }

    public void setType(Coding value) { 
      this.type = value;
    }

    public Identifier getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(Identifier value) { 
      this.identifier = value;
    }

    public Identifier getPlan() { 
      return this.plan;
    }

    public void setPlan(Identifier value) { 
      this.plan = value;
    }

    public Identifier getSubplan() { 
      return this.subplan;
    }

    public void setSubplan(Identifier value) { 
      this.subplan = value;
    }

    public Integer getDependant() { 
      return this.dependant;
    }

    public void setDependant(Integer value) { 
      this.dependant = value;
    }

    public Integer getSequence() { 
      return this.sequence;
    }

    public void setSequence(Integer value) { 
      this.sequence = value;
    }

    public PlanHolder getPlanHolder() { 
      return this.planHolder;
    }

    public void setPlanHolder(PlanHolder value) { 
      this.planHolder = value;
    }


}

