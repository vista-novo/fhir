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
 * A set of answers to predefined lists of questions. The answers may be grouped into coherent subsets, corresponding to the structure of the grouping of the underlying questions.
 */
public class Questionnaire extends Resource {

    public enum ObservationStatus {
        registered, // The existence of the observation is registered, but there is no result yet available
        interim, // This is an initial or interim observation: data may be incomplete or unverified
        final_, // The observation is complete and verified by an authorised person
        amended, // The observation has been modified subsequent to being Final, and is complete and verified by an authorised person
        cancelled, // The observation is unavailable because the measurement was not started or not completed (also sometimes called "aborted")
        withdrawn, // The observation has been withdrawn following previous Final release
        Null; // added to help the parsers
        public static ObservationStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return registered;
        if ("interim".equals(codeString))
          return interim;
        if ("final".equals(codeString))
          return final_;
        if ("amended".equals(codeString))
          return amended;
        if ("cancelled".equals(codeString))
          return cancelled;
        if ("withdrawn".equals(codeString))
          return withdrawn;
        throw new Exception("Unknown ObservationStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case registered: return "registered";
            case interim: return "interim";
            case final_: return "final";
            case amended: return "amended";
            case cancelled: return "cancelled";
            case withdrawn: return "withdrawn";
            default: return "?";
          }
        }
    }

  public class ObservationStatusEnumFactory implements EnumFactory {
    public Enum<?> fromCode(String codeString) throws Exception {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return ObservationStatus.registered;
        if ("interim".equals(codeString))
          return ObservationStatus.interim;
        if ("final".equals(codeString))
          return ObservationStatus.final_;
        if ("amended".equals(codeString))
          return ObservationStatus.amended;
        if ("cancelled".equals(codeString))
          return ObservationStatus.cancelled;
        if ("withdrawn".equals(codeString))
          return ObservationStatus.withdrawn;
        throw new Exception("Unknown ObservationStatus code '"+codeString+"'");
        }
    public String toCode(Enum<?> code) throws Exception {
      if (code == ObservationStatus.registered)
        return "registered";
      if (code == ObservationStatus.interim)
        return "interim";
      if (code == ObservationStatus.final_)
        return "final";
      if (code == ObservationStatus.amended)
        return "amended";
      if (code == ObservationStatus.cancelled)
        return "cancelled";
      if (code == ObservationStatus.withdrawn)
        return "withdrawn";
      return "?";
      }
    }

    public class Answer extends Element {
        /**
         * Code of the answer which can be used to relate an answer to a question in the questionnaire
         */
        private CodeableConcept name;

        /**
         * The actual answer data
         */
        private Type value;

        /**
         * Data captured from the care process which supports the given answer.
         */
        private ResourceReference evidence;

        public CodeableConcept getName() { 
          return this.name;
        }

        public void setName(CodeableConcept value) { 
          this.name = value;
        }

        public Type getValue() { 
          return this.value;
        }

        public void setValue(Type value) { 
          this.value = value;
        }

        public ResourceReference getEvidence() { 
          return this.evidence;
        }

        public void setEvidence(ResourceReference value) { 
          this.evidence = value;
        }

  }

    public class Section extends Element {
        /**
         * Structured name for a section of a predefined list of questions this questionnaire is responding to.
         */
        private CodeableConcept name;

        /**
         * Answers to questions on a section of a questionnaire
         */
        private List<Answer> answer = new ArrayList<Answer>();

        /**
         * A sub-section within a section in a questionnaire
         */
        private List<Section> section = new ArrayList<Section>();

        public CodeableConcept getName() { 
          return this.name;
        }

        public void setName(CodeableConcept value) { 
          this.name = value;
        }

        public List<Answer> getAnswer() { 
          return this.answer;
        }

        public List<Section> getSection() { 
          return this.section;
        }

  }

    /**
     * The status of the questionnaire as a whole
     */
    private Enumeration<ObservationStatus> status;

    /**
     * The date and/or time that this version of the questionnaire was authored
     */
    private Instant authored;

    /**
     * The subject of the questionnaires: this is the patient that the answers apply to, but this person is not necessarily the source of information
     */
    private ResourceReference subject;

    /**
     * Person that collected the answers to the questions in the Questionnaire
     */
    private ResourceReference author;

    /**
     * The person that answered the questions about the subject. Only used when this is not the subject him/herself
     */
    private ResourceReference source;

    /**
     * Structured name for a predefined list of questions this questionnaire is responding to
     */
    private CodeableConcept name;

    /**
     * An identifier that identifier this specific set of answers
     */
    private Identifier identifier;

    /**
     * Encounter during which this questionnaireanswers were collected. When there were multiple encounters, this is the one considered most relevant to the context of the answers.
     */
    private ResourceReference encounter;

    /**
     * Answers to questions on a questionnaire
     */
    private List<Answer> answer = new ArrayList<Answer>();

    /**
     * A group of anwers to a possibly similarly grouped set of question in the questionnaire
     */
    private List<Section> section = new ArrayList<Section>();

    public Enumeration<ObservationStatus> getStatus() { 
      return this.status;
    }

    public void setStatus(Enumeration<ObservationStatus> value) { 
      this.status = value;
    }

    public ObservationStatus getStatusSimple() { 
      return this.status == null ? null : this.status.getValue();
    }

    public void setStatusSimple(ObservationStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<ObservationStatus>();
        this.status.setValue(value);
      }
    }

    public Instant getAuthored() { 
      return this.authored;
    }

    public void setAuthored(Instant value) { 
      this.authored = value;
    }

    public Calendar getAuthoredSimple() { 
      return this.authored == null ? null : this.authored.getValue();
    }

    public void setAuthoredSimple(Calendar value) { 
      if (value == null)
        this.authored = null;
      else {
        if (this.authored == null)
          this.authored = new Instant();
        this.authored.setValue(value);
      }
    }

    public ResourceReference getSubject() { 
      return this.subject;
    }

    public void setSubject(ResourceReference value) { 
      this.subject = value;
    }

    public ResourceReference getAuthor() { 
      return this.author;
    }

    public void setAuthor(ResourceReference value) { 
      this.author = value;
    }

    public ResourceReference getSource() { 
      return this.source;
    }

    public void setSource(ResourceReference value) { 
      this.source = value;
    }

    public CodeableConcept getName() { 
      return this.name;
    }

    public void setName(CodeableConcept value) { 
      this.name = value;
    }

    public Identifier getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(Identifier value) { 
      this.identifier = value;
    }

    public ResourceReference getEncounter() { 
      return this.encounter;
    }

    public void setEncounter(ResourceReference value) { 
      this.encounter = value;
    }

    public List<Answer> getAnswer() { 
      return this.answer;
    }

    public List<Section> getSection() { 
      return this.section;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Questionnaire;
   }


}

