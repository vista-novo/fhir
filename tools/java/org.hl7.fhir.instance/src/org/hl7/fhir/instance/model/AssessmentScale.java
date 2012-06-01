package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2012, HL7, Inc
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

// Generated on Sat, Jun 2, 2012 08:18+1000 for FHIR v0.03

import java.util.*;

/**
 * Assessment scales or scores combine the findings of individual values into a total score which can be interpreted more easily against a reference population
 */
public class AssessmentScale extends Resource {

    public class Score extends Element {
        /**
         * A code that identifies the assessment scale that was performed
         */
        private CodeableConcept code;

        /**
         * The outcome of the assessment - some sort of score, or coded value outcome
         */
        private Type value;

        /**
         * Nested Scores - sub-scores that contribute to the overall score. A score is an aggregate based on a series of data
         */
        private List<Score> score = new ArrayList<Score>();

        /**
         * The actual data items from which the score is derived. Each score must have at least one data item on which it is based
         */
        private List<Measure> measure = new ArrayList<Measure>();

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public Type getValue() { 
          return this.value;
        }

        public void setValue(Type value) { 
          this.value = value;
        }

        public List<Score> getScore() { 
          return this.score;
        }

        public List<Measure> getMeasure() { 
          return this.measure;
        }

    }

    public class Measure extends Element {
        /**
         * Identifies the type of measure
         */
        private CodeableConcept code;

        /**
         * the value of the measure
         */
        private Type value;

        /**
         * when the value was measured
         */
        private DateTime time;

        /**
         * Reference to the actual measure in it's original context where additional information may be found
         */
        private ResourceReference source;

        public CodeableConcept getCode() { 
          return this.code;
        }

        public void setCode(CodeableConcept value) { 
          this.code = value;
        }

        public Type getValue() { 
          return this.value;
        }

        public void setValue(Type value) { 
          this.value = value;
        }

        public DateTime getTime() { 
          return this.time;
        }

        public void setTime(DateTime value) { 
          this.time = value;
        }

        public ResourceReference getSource() { 
          return this.source;
        }

        public void setSource(ResourceReference value) { 
          this.source = value;
        }

    }

    /**
     * The patient on which the assessment was performed
     */
    private ResourceReference subject;

    /**
     * The identity of the person who performed the clinical assessment - who takes responsibility for the final assessment
     */
    private ResourceReference performer;

    /**
     * The time that the assessment score was finalized
     */
    private String time;

    /**
     * Information of how the assessment was performed. 
     */
    private ResourceReference definition;

    /**
     * Interpretations of the outcome of the assesment scale by the performer
     */
    private List<CodeableConcept> interpretation = new ArrayList<CodeableConcept>();

    /**
     * A group that represents the actual score value
     */
    private Score score;

    /**
     * The reason that the assessment was performed
     */
    private String_ reason;

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

    public String getTime() { 
      return this.time;
    }

    public void setTime(String value) { 
      this.time = value;
    }

    public ResourceReference getDefinition() { 
      return this.definition;
    }

    public void setDefinition(ResourceReference value) { 
      this.definition = value;
    }

    public List<CodeableConcept> getInterpretation() { 
      return this.interpretation;
    }

    public Score getScore() { 
      return this.score;
    }

    public void setScore(Score value) { 
      this.score = value;
    }

    public String_ getReason() { 
      return this.reason;
    }

    public void setReason(String_ value) { 
      this.reason = value;
    }


}

