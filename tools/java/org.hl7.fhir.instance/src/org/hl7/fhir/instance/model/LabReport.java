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

// Generated on Sun, Jun 24, 2012 20:48+1000 for FHIR v0.04

import java.util.*;

/**
 * The findings and interpretation of pathology tests performed on tissues and body fluids. This is typically done in a laboratory but may be done in other environments such as at the point of care
 */
public class LabReport extends Resource {

    public enum LabReportStatus {
        registered, // The existence of the result is registered, but there is no result yet available
        interim, // This is an initial or interim result: data may be missing or verification not been performed
        final_, // The result is complete and verified by the responsible pathologist
        amended, // The result has been modified subsequent to being Final, and is complete and verified by the responsible pathologist
        cancelled, // The result is unavailable because the test was not started or not completed (also sometimes called "aborted")
        withdrawn; // The result has been withdrawn following previous Final release
        public static LabReportStatus fromCode(String codeString) throws Exception {
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
        throw new Exception("Unknown LabReportStatus code '"+codeString+"'");
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

    public enum LabResultFlag {
        Minus, // 
        MinusMinus, // 
        MinusMinusMinus, // 
        Plus, // 
        PlusPlus, // 
        PlusPlusPlus, // 
        R, // Resistent
        S, // Moderately  Susceptible
        SS; // Very Susceptible
        public static LabResultFlag fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("-".equals(codeString))
          return Minus;
        if ("--".equals(codeString))
          return MinusMinus;
        if ("---".equals(codeString))
          return MinusMinusMinus;
        if ("+".equals(codeString))
          return Plus;
        if ("++".equals(codeString))
          return PlusPlus;
        if ("+++".equals(codeString))
          return PlusPlusPlus;
        if ("R".equals(codeString))
          return R;
        if ("S".equals(codeString))
          return S;
        if ("SS".equals(codeString))
          return SS;
        throw new Exception("Unknown LabResultFlag code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case Minus: return "-";
            case MinusMinus: return "--";
            case MinusMinusMinus: return "---";
            case Plus: return "+";
            case PlusPlus: return "++";
            case PlusPlusPlus: return "+++";
            case R: return "R";
            case S: return "S";
            case SS: return "SS";
            default: return "?";
          }
        }
    }

    public class RequestDetail extends Element {
        /**
         * The local ID assigned to the order by the order requester.
         */
        private Identifier requestOrderId;

        /**
         * The local ID assigned to the test order by the order filler, usually by the Laboratory Information System (LIS).
         */
        private Identifier receiverOrderId;

        /**
         * Identification of pathology test requested,
         */
        private List<CodeableConcept> requestTest = new ArrayList<CodeableConcept>();

        /**
         * Details of the clinician or organisation requesting the laboratory test.
         */
        private ResourceReference requester;

        /**
         * Details of the clinical information provided to the laboratory along with the original request
         */
        private ResourceReference clinicalInfo;

        public Identifier getRequestOrderId() { 
          return this.requestOrderId;
        }

        public void setRequestOrderId(Identifier value) { 
          this.requestOrderId = value;
        }

        public Identifier getReceiverOrderId() { 
          return this.receiverOrderId;
        }

        public void setReceiverOrderId(Identifier value) { 
          this.receiverOrderId = value;
        }

        public List<CodeableConcept> getRequestTest() { 
          return this.requestTest;
        }

        public ResourceReference getRequester() { 
          return this.requester;
        }

        public void setRequester(ResourceReference value) { 
          this.requester = value;
        }

        public ResourceReference getClinicalInfo() { 
          return this.clinicalInfo;
        }

        public void setClinicalInfo(ResourceReference value) { 
          this.clinicalInfo = value;
        }

    }

    public class ResultGroup extends Element {
        /**
         * A code or name that describes the group of results
         */
        private CodeableConcept name;

        /**
         * Details about the individual specimen to which these ‘Result group’ test results refer, where testing of multiple specimens is required.
         */
        private ResourceReference specimen;

        /**
         * Specific detailed result, including both the value of the result item, and additional information that may be useful for clinical interpretation. Results include whatever specific data items pathology labs report as part of the clinical service; it is not confined to measurements.
         */
        private List<Result> result = new ArrayList<Result>();

        public CodeableConcept getName() { 
          return this.name;
        }

        public void setName(CodeableConcept value) { 
          this.name = value;
        }

        public ResourceReference getSpecimen() { 
          return this.specimen;
        }

        public void setSpecimen(ResourceReference value) { 
          this.specimen = value;
        }

        public List<Result> getResult() { 
          return this.result;
        }

    }

    public class Result extends Element {
        /**
         * Identifies the meaning of the value
         */
        private CodeableConcept name;

        /**
         * Actual value of the result. Most result values will be numerical measurements, but others may be coded concepts, free text, or multimedia images
         */
        private Type value;

        /**
         * Flag indicating the abnormal status of the result
         */
        private LabResultFlag flag;

        /**
         * The status of the result value
         */
        private LabReportStatus status;

        /**
         * May include statements about significant, unexpected or unreliable. values, or information about the source of the value where this may be relevant to the interpretation of the result.
         */
        private String_ comments;

        /**
         * Guidance on how to interpret the value by comparison to a normal or recommended range
         */
        private List<ReferenceRange> referenceRange = new ArrayList<ReferenceRange>();

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

        public LabResultFlag getFlag() { 
          return this.flag;
        }

        public void setFlag(LabResultFlag value) { 
          this.flag = value;
        }

        public LabReportStatus getStatus() { 
          return this.status;
        }

        public void setStatus(LabReportStatus value) { 
          this.status = value;
        }

        public String_ getComments() { 
          return this.comments;
        }

        public void setComments(String_ value) { 
          this.comments = value;
        }

        public List<ReferenceRange> getReferenceRange() { 
          return this.referenceRange;
        }

    }

    public class ReferenceRange extends Element {
        /**
         * Code for the meaning of the reference range
         */
        private CodeableConcept meaning;

        /**
         * Actual value of the reference range.  May be a quantity (<20mg/L), an interval (10-20 umol/L), or some text
         */
        private Type range;

        public CodeableConcept getMeaning() { 
          return this.meaning;
        }

        public void setMeaning(CodeableConcept value) { 
          this.meaning = value;
        }

        public Type getRange() { 
          return this.range;
        }

        public void setRange(Type value) { 
          this.range = value;
        }

    }

    /**
     * The status of the pathology test result as a whole
     */
    private LabReportStatus status;

    /**
     * The date and/or time that the result was issued from the source for the recorded ‘Test result status
     */
    private java.util.Date issued;

    /**
     * The patient about who the report is about
     */
    private ResourceReference patient;

    /**
     * The admission that this diagnostic investigation is associated with
     */
    private ResourceReference admission;

    /**
     * The laboratory service that issued the report
     */
    private ResourceReference laboratory;

    /**
     * The local ID assigned to the report by the order filler, usually by the Laboratory Information System (LIS).
     */
    private Identifier reportId;

    /**
     * Details concerning a single pathology test requested.
     */
    private List<RequestDetail> requestDetail = new ArrayList<RequestDetail>();

    /**
     * Identification of the pathology test performed, sometimes including specimen type.
     */
    private CodeableConcept reportName;

    /**
     * The diagnostic service that performs the examination e.g. biochemistry, haematology.
     */
    private CodeableConcept service;

    /**
     * The diagnostically relevant time for this report
     */
    private String diagnosticTime;

    /**
     * Details about the specimen if all individual test results are derived from the same specimen
     */
    private List<ResourceReference> specimen = new ArrayList<ResourceReference>();

    /**
     * A group of results. Results may be grouped by specimen, or by some value in LabReport.resultGroup.name to describe what binds all the results together.
     */
    private List<ResultGroup> resultGroup = new ArrayList<ResultGroup>();

    /**
     * Concise and clinically contextualised narrative interpretation of the pathology test results.
     */
    private String_ conclusion;

    /**
     * Codes for the conclusion
     */
    private List<CodeableConcept> codedDiagnosis = new ArrayList<CodeableConcept>();

    /**
     * Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they must be semantically equivalent.
     */
    private List<Attachment> representation = new ArrayList<Attachment>();

    public LabReportStatus getStatus() { 
      return this.status;
    }

    public void setStatus(LabReportStatus value) { 
      this.status = value;
    }

    public java.util.Date getIssued() { 
      return this.issued;
    }

    public void setIssued(java.util.Date value) { 
      this.issued = value;
    }

    public ResourceReference getPatient() { 
      return this.patient;
    }

    public void setPatient(ResourceReference value) { 
      this.patient = value;
    }

    public ResourceReference getAdmission() { 
      return this.admission;
    }

    public void setAdmission(ResourceReference value) { 
      this.admission = value;
    }

    public ResourceReference getLaboratory() { 
      return this.laboratory;
    }

    public void setLaboratory(ResourceReference value) { 
      this.laboratory = value;
    }

    public Identifier getReportId() { 
      return this.reportId;
    }

    public void setReportId(Identifier value) { 
      this.reportId = value;
    }

    public List<RequestDetail> getRequestDetail() { 
      return this.requestDetail;
    }

    public CodeableConcept getReportName() { 
      return this.reportName;
    }

    public void setReportName(CodeableConcept value) { 
      this.reportName = value;
    }

    public CodeableConcept getService() { 
      return this.service;
    }

    public void setService(CodeableConcept value) { 
      this.service = value;
    }

    public String getDiagnosticTime() { 
      return this.diagnosticTime;
    }

    public void setDiagnosticTime(String value) { 
      this.diagnosticTime = value;
    }

    public List<ResourceReference> getSpecimen() { 
      return this.specimen;
    }

    public List<ResultGroup> getResultGroup() { 
      return this.resultGroup;
    }

    public String_ getConclusion() { 
      return this.conclusion;
    }

    public void setConclusion(String_ value) { 
      this.conclusion = value;
    }

    public List<CodeableConcept> getCodedDiagnosis() { 
      return this.codedDiagnosis;
    }

    public List<Attachment> getRepresentation() { 
      return this.representation;
    }


}

