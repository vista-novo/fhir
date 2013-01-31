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

// Generated on Thu, Jan 31, 2013 23:34+1100 for FHIR v0.07

public class ResourceFactory {

    public static Resource createResource(String name) throws Exception {
        if ("Provenance".equals(name))
            return new Provenance();
        if ("CarePlan".equals(name))
            return new CarePlan();
        if ("Device".equals(name))
            return new Device();
        if ("Food".equals(name))
            return new Food();
        if ("Order".equals(name))
            return new Order();
        if ("Prescription".equals(name))
            return new Prescription();
        if ("Organization".equals(name))
            return new Organization();
        if ("Request".equals(name))
            return new Request();
        if ("Procedure".equals(name))
            return new Procedure();
        if ("Substance".equals(name))
            return new Substance();
        if ("DiagnosticReport".equals(name))
            return new DiagnosticReport();
        if ("Group".equals(name))
            return new Group();
        if ("Medication".equals(name))
            return new Medication();
        if ("ValueSet".equals(name))
            return new ValueSet();
        if ("Test".equals(name))
            return new Test();
        if ("Coverage".equals(name))
            return new Coverage();
        if ("MedicationAdministration".equals(name))
            return new MedicationAdministration();
        if ("Encounter".equals(name))
            return new Encounter();
        if ("SecurityEvent".equals(name))
            return new SecurityEvent();
        if ("IssueReport".equals(name))
            return new IssueReport();
        if ("AnatomicalLocation".equals(name))
            return new AnatomicalLocation();
        if ("List".equals(name))
            return new List_();
        if ("Picture".equals(name))
            return new Picture();
        if ("Conformance".equals(name))
            return new Conformance();
        if ("XdsEntry".equals(name))
            return new XdsEntry();
        if ("Document".equals(name))
            return new Document();
        if ("Message".equals(name))
            return new Message();
        if ("Location".equals(name))
            return new Location();
        if ("Profile".equals(name))
            return new Profile();
        if ("Admission".equals(name))
            return new Admission();
        if ("Observation".equals(name))
            return new Observation();
        if ("InterestOfCare".equals(name))
            return new InterestOfCare();
        if ("Immunization".equals(name))
            return new Immunization();
        if ("Problem".equals(name))
            return new Problem();
        if ("Specimen".equals(name))
            return new Specimen();
        if ("OrderResponse".equals(name))
            return new OrderResponse();
        if ("Patient".equals(name))
            return new Patient();
        if ("XdsEntry2".equals(name))
            return new XdsEntry2();
        if ("ImagingStudy".equals(name))
            return new ImagingStudy();
        if ("Provider".equals(name))
            return new Provider();
        if ("XdsFolder".equals(name))
            return new XdsFolder();
        else
            throw new Exception("Unknown Resource Name '"+name+"'");
    }

    public static Element createType(String name) throws Exception {
        if ("Period".equals(name))
            return new Period();
        if ("Coding".equals(name))
            return new Coding();
        if ("Range".equals(name))
            return new Range();
        if ("Age".equals(name))
            return new Age();
        if ("Count".equals(name))
            return new Count();
        if ("Quantity".equals(name))
            return new Quantity();
        if ("Attachment".equals(name))
            return new Attachment();
        if ("Money".equals(name))
            return new Money();
        if ("Distance".equals(name))
            return new Distance();
        if ("Contact".equals(name))
            return new Contact();
        if ("Demographics".equals(name))
            return new Demographics();
        if ("Extension".equals(name))
            return new Extension();
        if ("Schedule".equals(name))
            return new Schedule();
        if ("Choice".equals(name))
            return new Choice();
        if ("HumanName".equals(name))
            return new HumanName();
        if ("Address".equals(name))
            return new Address();
        if ("Duration".equals(name))
            return new Duration();
        if ("Ratio".equals(name))
            return new Ratio();
        if ("ResourceReference".equals(name))
            return new ResourceReference();
        if ("CodeableConcept".equals(name))
            return new CodeableConcept();
        if ("DocumentInformation".equals(name))
            return new DocumentInformation();
        if ("Identifier".equals(name))
            return new Identifier();
        if ("Narrative".equals(name))
            return new Narrative();
        else
            throw new Exception("Unknown Type Name '"+name+"'");
    }

}

