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
 * Simple assertions and measurements made about a patient, device or other subject
 */
public class SimpleObservation extends Resource {

    public class Component extends Element {
        /**
         * Identifies what type of sub-observation was performed
         */
        private CodeableConcept type;

        /**
         * The information determined as a result of making the sub-observation
         */
        private Type value;

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

    }

    /**
     * A unique identifier for the simple observation
     */
    private Identifier identifier;

    /**
     * Identifies what type of observation was performed
     */
    private CodeableConcept type;

    /**
     * Indicates where on the subject's body the observation was made.
     */
    private CodeableConcept bodySite;

    /**
     * Indicates the mechanism used to perform the observation
     */
    private CodeableConcept method;

    /**
     * The time or time-period the observed value is asserted as being true
     */
    private Type valid;

    /**
     * The thing the observation is being made about
     */
    private ResourceReference subject;

    /**
     * Who was responsible for asserting the observed value as "true"
     */
    private ResourceReference performer;

    /**
     * The information determined as a result of making the observation
     */
    private Type value;

    /**
     * The assessment made based on the result of the observation.
     */
    private CodeableConcept interpretation;

    /**
     * For numeric results, indicates the boundaries within which "normal" values should occur
     */
    private List<Range> normalRange = new ArrayList<Range>();

    /**
     * Component observation
     */
    private List<Component> component = new ArrayList<Component>();

    public Identifier getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(Identifier value) { 
      this.identifier = value;
    }

    public CodeableConcept getType() { 
      return this.type;
    }

    public void setType(CodeableConcept value) { 
      this.type = value;
    }

    public CodeableConcept getBodySite() { 
      return this.bodySite;
    }

    public void setBodySite(CodeableConcept value) { 
      this.bodySite = value;
    }

    public CodeableConcept getMethod() { 
      return this.method;
    }

    public void setMethod(CodeableConcept value) { 
      this.method = value;
    }

    public Type getValid() { 
      return this.valid;
    }

    public void setValid(Type value) { 
      this.valid = value;
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getPerformer() { 
      return this.performer;
    }

    public void setPerformer(ResourceReference value) { 
      this.performer = value;
    }

    public Type getValue() { 
      return this.value;
    }

    public void setValue(Type value) { 
      this.value = value;
    }

    public CodeableConcept getInterpretation() { 
      return this.interpretation;
    }

    public void setInterpretation(CodeableConcept value) { 
      this.interpretation = value;
    }

    public List<Range> getNormalRange() { 
      return this.normalRange;
    }

    public List<Component> getComponent() { 
      return this.component;
    }


}

