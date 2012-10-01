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

// Generated on Sun, Sep 16, 2012 06:55+1000 for FHIR v0.06

/**
 * An identifier that humans use. This is different from a system identifier because identifiers that humans use are regularly changed or retired due to human intervention and error. Note that a human identifier may be a system identifier on some master system but becomes a human identifier elsewhere due to how it is exchanged between humans. Driver's license numbers are a good example of this. Also, because human mediated identifiers are often invoked as implicit links to external business processes, such identifiers are often associated with multiple different resources. 
 */
public class HumanId extends Type {

    /**
     * The type of the identifier - to allow a particular identifier to be selected elsewhere
     */
    private Coding type;

    /**
     * The identifier itself
     */
    private Identifier identifier;

    /**
     * Time period during which identifier was valid for use
     */
    private Period period;

    /**
     * Organisation that issued/manages the identifier
     */
    private ResourceReference assigner;

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

    public Period getPeriod() { 
      return this.period;
    }

    public void setPeriod(Period value) { 
      this.period = value;
    }

    public ResourceReference getAssigner() { 
      return this.assigner;
    }

    public void setAssigner(ResourceReference value) { 
      this.assigner = value;
    }


}

