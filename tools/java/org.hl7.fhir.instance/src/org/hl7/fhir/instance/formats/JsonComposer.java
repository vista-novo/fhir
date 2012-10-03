package org.hl7.fhir.instance.formats;

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

// Generated on Wed, Oct 3, 2012 17:55+1000 for FHIR v0.06

import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.Boolean;
import java.net.*;

public class JsonComposer extends JsonComposerBase {

  private void composeExtension(String name, Extension element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("code", element.getCode());
      composeURI("profile", element.getProfile());
      composeString("ref", element.getRef());
      composeBool("mustUnderstand", element.getMustUnderstand());
      composeType("value", element.getValue());
      if (element.getExtension().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtension()) 
          composeExtension(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeNarrative(String name, Narrative element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeXhtml("div", element.getDiv());
      if (element.getImage().size() > 0) {
        openArray("image");
        for (Narrative.Image e : element.getImage()) 
          composeNarrativeImage(null, e);
        closeArray();
      };
      if (element.getMap().size() > 0) {
        openArray("map");
        for (Narrative.Map e : element.getMap()) 
          composeNarrativeMap(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeNarrativeImage(String name, Narrative.Image element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("mimeType", element.getMimeType());
      composeBytes("content", element.getContent());
      close();
    }
  }

  private void composeNarrativeMap(String name, Narrative.Map element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("text", element.getText());
      composeString("data", element.getData());
      if (element.getSource() != null)
        composeString("source", element.getSource().toCode());
      close();
    }
  }

  private void composePeriod(String name, Period element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeString("start", element.getStart());
      composeString("end", element.getEnd());
      close();
    }
  }

  private void composeCoding(String name, Coding element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      composeString("display", element.getDisplay());
      close();
    }
  }

  private void composeRange(String name, Range element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeQuantity("low", element.getLow());
      composeQuantity("high", element.getHigh());
      close();
    }
  }

  private void composeQuantity(String name, Quantity element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      close();
    }
  }

  private void composeChoice(String name, Choice element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeString("code", element.getCode());
      if (element.getValue().size() > 0) {
        openArray("value");
        for (Choice.Value e : element.getValue()) 
          composeChoiceValue(null, e);
        closeArray();
      };
      composeBool("isOrdered", element.getIsOrdered());
      close();
    }
  }

  private void composeChoiceValue(String name, Choice.Value element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("code", element.getCode());
      composeString("display", element.getDisplay());
      close();
    }
  }

  private void composeAttachment(String name, Attachment element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeString("mimeType", element.getMimeType());
      composeBytes("data", element.getData());
      composeURI("url", element.getUrl());
      composeBytes("hash", element.getHash());
      composeString("lang", element.getLang());
      composeString("title", element.getTitle());
      close();
    }
  }

  private void composeRatio(String name, Ratio element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeQuantity("numerator", element.getNumerator());
      composeQuantity("denominator", element.getDenominator());
      close();
    }
  }

  private void composeResourceReference(String name, ResourceReference element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeString("type", element.getType());
      composeURI("id", element.getId());
      composeURI("version", element.getVersion());
      composeString("text", element.getText());
      close();
    }
  }

  private void composeCodeableConcept(String name, CodeableConcept element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      if (element.getCoding().size() > 0) {
        openArray("coding");
        for (Coding e : element.getCoding()) 
          composeCoding(null, e);
        closeArray();
      };
      composeString("text", element.getText());
      composeString("primary", element.getPrimary());
      close();
    }
  }

  private void composeIdentifier(String name, Identifier element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeURI("system", element.getSystem());
      composeString("id", element.getId());
      close();
    }
  }

  private void composeAge(String name, Age element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      close();
    }
  }

  private void composeCount(String name, Count element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      close();
    }
  }

  private void composeMoney(String name, Money element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      close();
    }
  }

  private void composeDistance(String name, Distance element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      close();
    }
  }

  private void composeDuration(String name, Duration element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      close();
    }
  }

  private void composeSchedule(String name, Schedule element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      if (element.getEvent().size() > 0) {
        openArray("event");
        for (Period e : element.getEvent()) 
          composePeriod(null, e);
        closeArray();
      };
      composeScheduleRepeat("repeat", element.getRepeat());
      close();
    }
  }

  private void composeScheduleRepeat(String name, Schedule.Repeat element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeInt("frequency", element.getFrequency());
      if (element.getWhen() != null)
        composeString("when", element.getWhen().toCode());
      composeDuration("duration", element.getDuration());
      composeInt("count", element.getCount());
      composeString("end", element.getEnd());
      close();
    }
  }

  private void composeContact(String name, Contact element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      if (element.getSystem() != null)
        composeString("system", element.getSystem().toCode());
      composeString("value", element.getValue());
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeAddress(String name, Address element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      composeString("text", element.getText());
      if (element.getPart().size() > 0) {
        openArray("part");
        for (Address.Part e : element.getPart()) 
          composeAddressPart(null, e);
        closeArray();
      };
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeAddressPart(String name, Address.Part element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeString("value", element.getValue());
      close();
    }
  }

  private void composeHumanName(String name, HumanName element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      composeString("text", element.getText());
      if (element.getPart().size() > 0) {
        openArray("part");
        for (HumanName.Part e : element.getPart()) 
          composeHumanNamePart(null, e);
        closeArray();
      };
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeHumanNamePart(String name, HumanName.Part element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeString("value", element.getValue());
      close();
    }
  }

  private void composeHumanId(String name, HumanId element) throws Exception {
    if (element != null) {
      open(name);
      composeTypeAttributes(element);
      composeCoding("type", element.getType());
      composeIdentifier("identifier", element.getIdentifier());
      composePeriod("period", element.getPeriod());
      composeResourceReference("assigner", element.getAssigner());
      close();
    }
  }

  private void composeXdsEntry(String name, XdsEntry element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeURI("repositoryId", element.getRepositoryId());
      composeString("mimeType", element.getMimeType());
      composeCoding("format", element.getFormat());
      composeCoding("class", element.getClass_());
      composeCoding("type", element.getType());
      composeString("title", element.getTitle());
      composeURI("documentId", element.getDocumentId());
      if (element.getAvailability() != null)
        composeString("availability", element.getAvailability().toCode());
      if (element.getConfidentiality().size() > 0) {
        openArray("confidentiality");
        for (Coding e : element.getConfidentiality()) 
          composeCoding(null, e);
        closeArray();
      };
      composeDate("created", element.getCreated());
      if (element.getEvent().size() > 0) {
        openArray("event");
        for (Coding e : element.getEvent()) 
          composeCoding(null, e);
        closeArray();
      };
      composeString("hash", element.getHash());
      composeString("size", element.getSize());
      composeString("language", element.getLanguage());
      if (element.getFolder().size() > 0) {
        openArray("folder");
        for (ResourceReference e : element.getFolder()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeIdentifier("patientId", element.getPatientId());
      composeIdentifier("sourcePatientId", element.getSourcePatientId());
      composeResourceReference("patientInfo", element.getPatientInfo());
      composeXdsEntryAuthor("author", element.getAuthor());
      composeXdsEntryAuthenticator("authenticator", element.getAuthenticator());
      composeCoding("facilityType", element.getFacilityType());
      composeCoding("practiceSetting", element.getPracticeSetting());
      composeString("homeCommunity", element.getHomeCommunity());
      composeXdsEntryService("service", element.getService());
      composeString("comments", element.getComments());
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeXdsEntryAuthor(String name, XdsEntry.Author element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeHumanName("name", element.getName());
      composeIdentifier("id", element.getId());
      if (element.getRole().size() > 0) {
        openArray("role");
        for (String e : element.getRole()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getSpecialty().size() > 0) {
        openArray("specialty");
        for (String e : element.getSpecialty()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getInstitution().size() > 0) {
        openArray("institution");
        for (XdsEntry.Institution e : element.getInstitution()) 
          composeXdsEntryInstitution(null, e);
        closeArray();
      };
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeXdsEntryInstitution(String name, XdsEntry.Institution element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeIdentifier("id", element.getId());
      composeString("name", element.getName());
      close();
    }
  }

  private void composeXdsEntryAuthenticator(String name, XdsEntry.Authenticator element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeIdentifier("id", element.getId());
      composeHumanName("name", element.getName());
      close();
    }
  }

  private void composeXdsEntryService(String name, XdsEntry.Service element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("start", element.getStart());
      composeString("stop", element.getStop());
      close();
    }
  }

  private void composeConformance(String name, Conformance element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeString("date", element.getDate());
      composeConformancePublisher("publisher", element.getPublisher());
      composeConformanceImplementation("implementation", element.getImplementation());
      composeConformanceSoftware("software", element.getSoftware());
      composeConformanceProposal("proposal", element.getProposal());
      composeString("version", element.getVersion());
      composeBool("acceptUnknown", element.getAcceptUnknown());
      if (element.getRest().size() > 0) {
        openArray("rest");
        for (Conformance.Rest e : element.getRest()) 
          composeConformanceRest(null, e);
        closeArray();
      };
      if (element.getMessaging().size() > 0) {
        openArray("messaging");
        for (Conformance.Messaging e : element.getMessaging()) 
          composeConformanceMessaging(null, e);
        closeArray();
      };
      if (element.getDocument().size() > 0) {
        openArray("document");
        for (Conformance.Document e : element.getDocument()) 
          composeConformanceDocument(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeConformancePublisher(String name, Conformance.Publisher element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      composeAddress("address", element.getAddress());
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceImplementation(String name, Conformance.Implementation element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("description", element.getDescription());
      composeURI("url", element.getUrl());
      close();
    }
  }

  private void composeConformanceSoftware(String name, Conformance.Software element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeString("releaseDate", element.getReleaseDate());
      close();
    }
  }

  private void composeConformanceProposal(String name, Conformance.Proposal element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("description", element.getDescription());
      close();
    }
  }

  private void composeConformanceRest(String name, Conformance.Rest element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      composeString("documentation", element.getDocumentation());
      if (element.getResource().size() > 0) {
        openArray("resource");
        for (Conformance.Resource e : element.getResource()) 
          composeConformanceResource(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceResource(String name, Conformance.Resource element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("type", element.getType());
      composeURI("profile", element.getProfile());
      if (element.getOperation().size() > 0) {
        openArray("operation");
        for (Conformance.Operation e : element.getOperation()) 
          composeConformanceOperation(null, e);
        closeArray();
      };
      composeConformanceSearch("search", element.getSearch());
      close();
    }
  }

  private void composeConformanceOperation(String name, Conformance.Operation element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getCode() != null)
        composeString("code", element.getCode().toCode());
      composeString("documentation", element.getDocumentation());
      close();
    }
  }

  private void composeConformanceSearch(String name, Conformance.Search element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("documentation", element.getDocumentation());
      if (element.getParam().size() > 0) {
        openArray("param");
        for (Conformance.Param e : element.getParam()) 
          composeConformanceParam(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceParam(String name, Conformance.Param element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      composeString("documentation", element.getDocumentation());
      close();
    }
  }

  private void composeConformanceMessaging(String name, Conformance.Messaging element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeURI("endpoint", element.getEndpoint());
      composeString("documentation", element.getDocumentation());
      if (element.getEvent().size() > 0) {
        openArray("event");
        for (Conformance.Event e : element.getEvent()) 
          composeConformanceEvent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceEvent(String name, Conformance.Event element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("code", element.getCode());
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      if (element.getProtocol().size() > 0) {
        openArray("protocol");
        for (Coding e : element.getProtocol()) 
          composeCoding(null, e);
        closeArray();
      };
      composeString("focus", element.getFocus());
      composeURI("request", element.getRequest());
      composeURI("response", element.getResponse());
      composeString("documentation", element.getDocumentation());
      close();
    }
  }

  private void composeConformanceDocument(String name, Conformance.Document element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      composeString("documentation", element.getDocumentation());
      composeURI("profile", element.getProfile());
      close();
    }
  }

  private void composeDocumentHeader(String name, DocumentHeader element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeDate("instant", element.getInstant());
      composeCodeableConcept("type", element.getType());
      composeString_("title", element.getTitle());
      composeString("replaces", element.getReplaces());
      composeResourceReference("enterer", element.getEnterer());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("informant", element.getInformant());
      if (element.getAuthor().size() > 0) {
        openArray("author");
        for (ResourceReference e : element.getAuthor()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getAttester().size() > 0) {
        openArray("attester");
        for (DocumentHeader.Attester e : element.getAttester()) 
          composeDocumentHeaderAttester(null, e);
        closeArray();
      };
      if (element.getRecipient().size() > 0) {
        openArray("recipient");
        for (ResourceReference e : element.getRecipient()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeResourceReference("custodian", element.getCustodian());
      composeResourceReference("context", element.getContext());
      composeResourceReference("encounter", element.getEncounter());
      composeAttachment("stylesheet", element.getStylesheet());
      composeAttachment("representation", element.getRepresentation());
      if (element.getSection().size() > 0) {
        openArray("section");
        for (DocumentHeader.Section e : element.getSection()) 
          composeDocumentHeaderSection(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeDocumentHeaderAttester(String name, DocumentHeader.Attester element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      composeDateTime("time", element.getTime());
      composeResourceReference("party", element.getParty());
      close();
    }
  }

  private void composeDocumentHeaderSection(String name, DocumentHeader.Section element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("type", element.getType());
      composeInstant("instant", element.getInstant());
      composeResourceReference("author", element.getAuthor());
      composeResourceReference("enterer", element.getEnterer());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("informant", element.getInformant());
      composeResourceReference("content", element.getContent());
      composeNarrative("text", element.getText());
      if (element.getSection().size() > 0) {
        openArray("section");
        for (DocumentHeader.Section e : element.getSection()) 
          composeDocumentHeaderSection(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDevice(String name, Device element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeCodeableConcept("type", element.getType());
      composeString_("manufacturer", element.getManufacturer());
      composeString_("model", element.getModel());
      composeString_("version", element.getVersion());
      composeString_("serialNumber", element.getSerialNumber());
      composeResourceReference("owner", element.getOwner());
      if (element.getAssignedId().size() > 0) {
        openArray("assignedId");
        for (Identifier e : element.getAssignedId()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeResourceReference("location", element.getLocation());
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      composeContact("address", element.getAddress());
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeAnimal(String name, Animal element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (HumanId e : element.getIdentifier()) 
          composeHumanId(null, e);
        closeArray();
      };
      if (element.getName().size() > 0) {
        openArray("name");
        for (HumanName e : element.getName()) 
          composeHumanName(null, e);
        closeArray();
      };
      composeDateTime("dob", element.getDob());
      composeCodeableConcept("species", element.getSpecies());
      composeCodeableConcept("strain", element.getStrain());
      composeCodeableConcept("gender", element.getGender());
      if (element.getRelatedEntity().size() > 0) {
        openArray("relatedEntity");
        for (Animal.RelatedEntity e : element.getRelatedEntity()) 
          composeAnimalRelatedEntity(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeAnimalRelatedEntity(String name, Animal.RelatedEntity element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeHumanId("identifier", element.getIdentifier());
      composeCodeableConcept("role", element.getRole());
      composeHumanName("name", element.getName());
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeAgent(String name, Agent element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeResourceReference("person", element.getPerson());
      composeResourceReference("organization", element.getOrganization());
      if (element.getRole().size() > 0) {
        openArray("role");
        for (CodeableConcept e : element.getRole()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composePeriod("period", element.getPeriod());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (HumanId e : element.getIdentifier()) 
          composeHumanId(null, e);
        closeArray();
      };
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeOrganization(String name, Organization element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (HumanId e : element.getIdentifier()) 
          composeHumanId(null, e);
        closeArray();
      };
      if (element.getName().size() > 0) {
        openArray("name");
        for (Organization.Name e : element.getName()) 
          composeOrganizationName(null, e);
        closeArray();
      };
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      composeCodeableConcept("code", element.getCode());
      composeCodeableConcept("industryCode", element.getIndustryCode());
      if (element.getAccreditation().size() > 0) {
        openArray("accreditation");
        for (Organization.Accreditation e : element.getAccreditation()) 
          composeOrganizationAccreditation(null, e);
        closeArray();
      };
      if (element.getRelatedOrganization().size() > 0) {
        openArray("relatedOrganization");
        for (Organization.RelatedOrganization e : element.getRelatedOrganization()) 
          composeOrganizationRelatedOrganization(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeOrganizationName(String name, Organization.Name element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("value", element.getValue());
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeOrganizationAccreditation(String name, Organization.Accreditation element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeIdentifier("identifier", element.getIdentifier());
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("institution", element.getInstitution());
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeOrganizationRelatedOrganization(String name, Organization.RelatedOrganization element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeHumanId("identifier", element.getIdentifier());
      composeCodeableConcept("code", element.getCode());
      composeString_("name", element.getName());
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composePrescription(String name, Prescription element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (HumanId e : element.getIdentifier()) 
          composeHumanId(null, e);
        closeArray();
      };
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("prescriber", element.getPrescriber());
      composeString("prescribed", element.getPrescribed());
      composePrescriptionDispense("dispense", element.getDispense());
      composePrescriptionMedicine("medicine", element.getMedicine());
      composePrescriptionAdministrationRequest("administrationRequest", element.getAdministrationRequest());
      composeCodeableConcept("reason", element.getReason());
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composePrescriptionDispense(String name, Prescription.Dispense element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeInt("repeats", element.getRepeats());
      composeQuantity("quantity", element.getQuantity());
      composeResourceReference("dispenser", element.getDispenser());
      close();
    }
  }

  private void composePrescriptionMedicine(String name, Prescription.Medicine element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("identification", element.getIdentification());
      if (element.getActiveIngredient().size() > 0) {
        openArray("activeIngredient");
        for (Prescription.ActiveIngredient e : element.getActiveIngredient()) 
          composePrescriptionActiveIngredient(null, e);
        closeArray();
      };
      if (element.getInactiveIngredient().size() > 0) {
        openArray("inactiveIngredient");
        for (Prescription.InactiveIngredient e : element.getInactiveIngredient()) 
          composePrescriptionInactiveIngredient(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composePrescriptionActiveIngredient(String name, Prescription.ActiveIngredient element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      close();
    }
  }

  private void composePrescriptionInactiveIngredient(String name, Prescription.InactiveIngredient element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      close();
    }
  }

  private void composePrescriptionAdministrationRequest(String name, Prescription.AdministrationRequest element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString_("description", element.getDescription());
      composeRatio("totalPeriodicDosis", element.getTotalPeriodicDosis());
      composeDateTime("start", element.getStart());
      composeDateTime("end", element.getEnd());
      composeQuantity("duration", element.getDuration());
      composeInteger("numberOfAdministrations", element.getNumberOfAdministrations());
      if (element.getDosageInstruction().size() > 0) {
        openArray("dosageInstruction");
        for (Prescription.DosageInstruction e : element.getDosageInstruction()) 
          composePrescriptionDosageInstruction(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composePrescriptionDosageInstruction(String name, Prescription.DosageInstruction element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getPrecondition().size() > 0) {
        openArray("precondition");
        for (CodeableConcept e : element.getPrecondition()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeBool("prn", element.getPrn());
      if (element.getAdditionalInstruction().size() > 0) {
        openArray("additionalInstruction");
        for (CodeableConcept e : element.getAdditionalInstruction()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeCodeableConcept("route", element.getRoute());
      composeType("dose", element.getDose());
      composeQuantity("rate", element.getRate());
      if (element.getSchedule().size() > 0) {
        openArray("schedule");
        for (Schedule e : element.getSchedule()) 
          composeSchedule(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfile(String name, Profile element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeProfileAuthor("author", element.getAuthor());
      composeString("description", element.getDescription());
      if (element.getCode().size() > 0) {
        openArray("code");
        for (Coding e : element.getCode()) 
          composeCoding(null, e);
        closeArray();
      };
      composeProfileStatus("status", element.getStatus());
      if (element.getImport().size() > 0) {
        openArray("import");
        for (Profile.Import e : element.getImport()) 
          composeProfileImport(null, e);
        closeArray();
      };
      composeString("bundle", element.getBundle());
      if (element.getResource().size() > 0) {
        openArray("resource");
        for (Profile.Resource e : element.getResource()) 
          composeProfileResource(null, e);
        closeArray();
      };
      if (element.getExtensionDefn().size() > 0) {
        openArray("extensionDefn");
        for (Profile.ExtensionDefn e : element.getExtensionDefn()) 
          composeProfileExtensionDefn(null, e);
        closeArray();
      };
      if (element.getBinding().size() > 0) {
        openArray("binding");
        for (Profile.Binding e : element.getBinding()) 
          composeProfileBinding(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeProfileAuthor(String name, Profile.Author element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      if (element.getReference().size() > 0) {
        openArray("reference");
        for (URI e : element.getReference()) 
          composeURI(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileStatus(String name, Profile.Status element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getCode() != null)
        composeString("code", element.getCode().toCode());
      composeString("date", element.getDate());
      composeString("comment", element.getComment());
      close();
    }
  }

  private void composeProfileImport(String name, Profile.Import element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeURI("uri", element.getUri());
      composeString("prefix", element.getPrefix());
      close();
    }
  }

  private void composeProfileResource(String name, Profile.Resource element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("type", element.getType());
      composeURI("profile", element.getProfile());
      composeString("name", element.getName());
      composeString("purpose", element.getPurpose());
      if (element.getElement().size() > 0) {
        openArray("element");
        for (Profile.Element_ e : element.getElement()) 
          composeProfileElement_(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileElement_(String name, Profile.Element_ element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("path", element.getPath());
      composeString("name", element.getName());
      composeProfileDefinition("definition", element.getDefinition());
      composeBool("bundled", element.getBundled());
      composeBool("closed", element.getClosed());
      close();
    }
  }

  private void composeProfileDefinition(String name, Profile.Definition element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("short", element.getShort());
      composeString("formal", element.getFormal());
      composeString("comments", element.getComments());
      composeString("requirements", element.getRequirements());
      if (element.getSynonym().size() > 0) {
        openArray("synonym");
        for (String e : element.getSynonym()) 
          composeString(null, e);
        closeArray();
      };
      composeInt("min", element.getMin());
      composeString("max", element.getMax());
      if (element.getType().size() > 0) {
        openArray("type");
        for (Profile.Type e : element.getType()) 
          composeProfileType(null, e);
        closeArray();
      };
      composeString("nameReference", element.getNameReference());
      composeType("value", element.getValue());
      composeInt("maxLength", element.getMaxLength());
      composeBool("dataAbsentReason", element.getDataAbsentReason());
      if (element.getCondition().size() > 0) {
        openArray("condition");
        for (String e : element.getCondition()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getConstraint().size() > 0) {
        openArray("constraint");
        for (Profile.Constraint e : element.getConstraint()) 
          composeProfileConstraint(null, e);
        closeArray();
      };
      composeBool("mustSupport", element.getMustSupport());
      composeBool("mustUnderstand", element.getMustUnderstand());
      composeString("binding", element.getBinding());
      if (element.getMapping().size() > 0) {
        openArray("mapping");
        for (Profile.Mapping e : element.getMapping()) 
          composeProfileMapping(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileType(String name, Profile.Type element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("code", element.getCode());
      composeURI("profile", element.getProfile());
      close();
    }
  }

  private void composeProfileConstraint(String name, Profile.Constraint element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeString("name", element.getName());
      composeString("severity", element.getSeverity());
      composeString("human", element.getHuman());
      composeString("xpath", element.getXpath());
      composeString("ocl", element.getOcl());
      close();
    }
  }

  private void composeProfileMapping(String name, Profile.Mapping element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("target", element.getTarget());
      composeString("map", element.getMap());
      close();
    }
  }

  private void composeProfileExtensionDefn(String name, Profile.ExtensionDefn element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("code", element.getCode());
      if (element.getContextType() != null)
        composeString("contextType", element.getContextType().toCode());
      if (element.getContext().size() > 0) {
        openArray("context");
        for (String e : element.getContext()) 
          composeString(null, e);
        closeArray();
      };
      composeProfileDefinition("definition", element.getDefinition());
      close();
    }
  }

  private void composeProfileBinding(String name, Profile.Binding element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      composeString("definition", element.getDefinition());
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeBool("isExtensible", element.getIsExtensible());
      if (element.getConformance() != null)
        composeString("conformance", element.getConformance().toCode());
      composeURI("reference", element.getReference());
      if (element.getConcept().size() > 0) {
        openArray("concept");
        for (Profile.Concept e : element.getConcept()) 
          composeProfileConcept(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileConcept(String name, Profile.Concept element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      composeString("display", element.getDisplay());
      composeString("definition", element.getDefinition());
      close();
    }
  }

  private void composeValueSet(String name, ValueSet element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeString("name", element.getName());
      composeValueSetAuthor("author", element.getAuthor());
      composeString("description", element.getDescription());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString("date", element.getDate());
      composeString("identifier", element.getIdentifier());
      composeString("version", element.getVersion());
      if (element.getRestricts().size() > 0) {
        openArray("restricts");
        for (URI e : element.getRestricts()) 
          composeURI(null, e);
        closeArray();
      };
      if (element.getImport().size() > 0) {
        openArray("import");
        for (URI e : element.getImport()) 
          composeURI(null, e);
        closeArray();
      };
      if (element.getInclude().size() > 0) {
        openArray("include");
        for (ValueSet.Include e : element.getInclude()) 
          composeValueSetInclude(null, e);
        closeArray();
      };
      if (element.getExclude().size() > 0) {
        openArray("exclude");
        for (ValueSet.Include e : element.getExclude()) 
          composeValueSetInclude(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeValueSetAuthor(String name, ValueSet.Author element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      composeURI("reference", element.getReference());
      close();
    }
  }

  private void composeValueSetInclude(String name, ValueSet.Include element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeURI("system", element.getSystem());
      composeString("version", element.getVersion());
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      if (element.getCode().size() > 0) {
        openArray("code");
        for (String e : element.getCode()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getFilter().size() > 0) {
        openArray("filter");
        for (ValueSet.Filter e : element.getFilter()) 
          composeValueSetFilter(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeValueSetFilter(String name, ValueSet.Filter element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("property", element.getProperty());
      if (element.getOp() != null)
        composeString("op", element.getOp().toCode());
      composeString("value", element.getValue());
      close();
    }
  }

  private void composeProblem(String name, Problem element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeCodeableConcept("code", element.getCode());
      composeCodeableConcept("category", element.getCategory());
      composeCode("status", element.getStatus());
      composeCodeableConcept("certainty", element.getCertainty());
      composeCodeableConcept("severity", element.getSeverity());
      composeType("onset", element.getOnset());
      composeDate("dateFound", element.getDateFound());
      composeType("abatement", element.getAbatement());
      composeProblemStage("stage", element.getStage());
      if (element.getEvidence().size() > 0) {
        openArray("evidence");
        for (Problem.Evidence e : element.getEvidence()) 
          composeProblemEvidence(null, e);
        closeArray();
      };
      composeProblemLocation("location", element.getLocation());
      if (element.getRelatedItem().size() > 0) {
        openArray("relatedItem");
        for (Problem.RelatedItem e : element.getRelatedItem()) 
          composeProblemRelatedItem(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeProblemStage(String name, Problem.Stage element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("summary", element.getSummary());
      if (element.getAssessment().size() > 0) {
        openArray("assessment");
        for (ResourceReference e : element.getAssessment()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProblemEvidence(String name, Problem.Evidence element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("details", element.getDetails());
      close();
    }
  }

  private void composeProblemLocation(String name, Problem.Location element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("details", element.getDetails());
      close();
    }
  }

  private void composeProblemRelatedItem(String name, Problem.RelatedItem element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeResourceReference("target", element.getTarget());
      close();
    }
  }

  private void composeTest(String name, Test element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getStringErr().size() > 0) {
        openArray("stringErr");
        for (String e : element.getStringErr()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getStringCorr().size() > 0) {
        openArray("stringCorr");
        for (String e : element.getStringCorr()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getBooleanErr().size() > 0) {
        openArray("booleanErr");
        for (java.lang.Boolean e : element.getBooleanErr()) 
          composeBool(null, e);
        closeArray();
      };
      if (element.getBooleanCorr().size() > 0) {
        openArray("booleanCorr");
        for (java.lang.Boolean e : element.getBooleanCorr()) 
          composeBool(null, e);
        closeArray();
      };
      if (element.getIntegerErr().size() > 0) {
        openArray("integerErr");
        for (int e : element.getIntegerErr()) 
          composeInt(null, e);
        closeArray();
      };
      if (element.getIntegerCorr().size() > 0) {
        openArray("integerCorr");
        for (int e : element.getIntegerCorr()) 
          composeInt(null, e);
        closeArray();
      };
      if (element.getDecimalErr().size() > 0) {
        openArray("decimalErr");
        for (java.math.BigDecimal e : element.getDecimalErr()) 
          composeBigDecimal(null, e);
        closeArray();
      };
      if (element.getDecimalCorr().size() > 0) {
        openArray("decimalCorr");
        for (java.math.BigDecimal e : element.getDecimalCorr()) 
          composeBigDecimal(null, e);
        closeArray();
      };
      if (element.getB64Err().size() > 0) {
        openArray("b64Err");
        for (byte[] e : element.getB64Err()) 
          composeBytes(null, e);
        closeArray();
      };
      if (element.getB64Corr().size() > 0) {
        openArray("b64Corr");
        for (byte[] e : element.getB64Corr()) 
          composeBytes(null, e);
        closeArray();
      };
      if (element.getInstantErr().size() > 0) {
        openArray("instantErr");
        for (java.util.Calendar e : element.getInstantErr()) 
          composeDate(null, e);
        closeArray();
      };
      if (element.getInstantCorr().size() > 0) {
        openArray("instantCorr");
        for (java.util.Calendar e : element.getInstantCorr()) 
          composeDate(null, e);
        closeArray();
      };
      if (element.getUriErr().size() > 0) {
        openArray("uriErr");
        for (URI e : element.getUriErr()) 
          composeURI(null, e);
        closeArray();
      };
      if (element.getUriCorr().size() > 0) {
        openArray("uriCorr");
        for (URI e : element.getUriCorr()) 
          composeURI(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeMessageHeader(String name, MessageHeader element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeDate("instant", element.getInstant());
      composeString("event", element.getEvent());
      composeMessageHeaderResponse("response", element.getResponse());
      composeMessageHeaderSource("source", element.getSource());
      composeMessageHeaderDestination("destination", element.getDestination());
      composeResourceReference("enterer", element.getEnterer());
      composeResourceReference("author", element.getAuthor());
      composeResourceReference("receiver", element.getReceiver());
      composeResourceReference("responsible", element.getResponsible());
      composePeriod("effective", element.getEffective());
      composeCodeableConcept("reason", element.getReason());
      if (element.getData().size() > 0) {
        openArray("data");
        for (ResourceReference e : element.getData()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeMessageHeaderResponse(String name, MessageHeader.Response element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getCode() != null)
        composeString("code", element.getCode().toCode());
      close();
    }
  }

  private void composeMessageHeaderSource(String name, MessageHeader.Source element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      composeString("software", element.getSoftware());
      composeString_("version", element.getVersion());
      composeContact("contact", element.getContact());
      composeURI("endpoint", element.getEndpoint());
      close();
    }
  }

  private void composeMessageHeaderDestination(String name, MessageHeader.Destination element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("name", element.getName());
      composeResourceReference("target", element.getTarget());
      composeURI("endpoint", element.getEndpoint());
      close();
    }
  }

  private void composePatient(String name, Patient element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getLink().size() > 0) {
        openArray("link");
        for (ResourceReference e : element.getLink()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeBool("active", element.getActive());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("provider", element.getProvider());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (HumanId e : element.getIdentifier()) 
          composeHumanId(null, e);
        closeArray();
      };
      composeCodeableConcept("diet", element.getDiet());
      composeCodeableConcept("confidentiality", element.getConfidentiality());
      composeCodeableConcept("recordLocation", element.getRecordLocation());
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeAssessmentScale(String name, AssessmentScale element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("performer", element.getPerformer());
      composeString("time", element.getTime());
      composeResourceReference("definition", element.getDefinition());
      if (element.getInterpretation().size() > 0) {
        openArray("interpretation");
        for (CodeableConcept e : element.getInterpretation()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeAssessmentScaleScore("score", element.getScore());
      composeString_("reason", element.getReason());
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeAssessmentScaleScore(String name, AssessmentScale.Score element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("code", element.getCode());
      composeType("value", element.getValue());
      if (element.getScore().size() > 0) {
        openArray("score");
        for (AssessmentScale.Score e : element.getScore()) 
          composeAssessmentScaleScore(null, e);
        closeArray();
      };
      if (element.getMeasure().size() > 0) {
        openArray("measure");
        for (AssessmentScale.Measure e : element.getMeasure()) 
          composeAssessmentScaleMeasure(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeAssessmentScaleMeasure(String name, AssessmentScale.Measure element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("code", element.getCode());
      composeType("value", element.getValue());
      composeDateTime("time", element.getTime());
      composeResourceReference("source", element.getSource());
      close();
    }
  }

  private void composePerson(String name, Person element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (HumanId e : element.getIdentifier()) 
          composeHumanId(null, e);
        closeArray();
      };
      if (element.getName().size() > 0) {
        openArray("name");
        for (HumanName e : element.getName()) 
          composeHumanName(null, e);
        closeArray();
      };
      if (element.getTelecom().size() > 0) {
        openArray("telecom");
        for (Contact e : element.getTelecom()) 
          composeContact(null, e);
        closeArray();
      };
      composeCodeableConcept("gender", element.getGender());
      composeDateTime("birthDate", element.getBirthDate());
      composeBoolean("deceased", element.getDeceased());
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      composeDateTime("maritalStatus", element.getMaritalStatus());
      if (element.getContactParty().size() > 0) {
        openArray("contactParty");
        for (Person.ContactParty e : element.getContactParty()) 
          composePersonContactParty(null, e);
        closeArray();
      };
      if (element.getLanguage().size() > 0) {
        openArray("language");
        for (Person.Language e : element.getLanguage()) 
          composePersonLanguage(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composePersonContactParty(String name, Person.ContactParty element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("role", element.getRole());
      composeHumanName("name", element.getName());
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      if (element.getTelecom().size() > 0) {
        openArray("telecom");
        for (Contact e : element.getTelecom()) 
          composeContact(null, e);
        closeArray();
      };
      composeResourceReference("party", element.getParty());
      close();
    }
  }

  private void composePersonLanguage(String name, Person.Language element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("code", element.getCode());
      if (element.getLevel() != null)
        composeString("level", element.getLevel().toCode());
      close();
    }
  }

  private void composeLabReport(String name, LabReport element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeDate("issued", element.getIssued());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("admission", element.getAdmission());
      composeResourceReference("laboratory", element.getLaboratory());
      composeIdentifier("reportId", element.getReportId());
      if (element.getRequestDetail().size() > 0) {
        openArray("requestDetail");
        for (LabReport.RequestDetail e : element.getRequestDetail()) 
          composeLabReportRequestDetail(null, e);
        closeArray();
      };
      composeCodeableConcept("reportName", element.getReportName());
      composeCodeableConcept("service", element.getService());
      composeString("diagnosticTime", element.getDiagnosticTime());
      if (element.getSpecimen().size() > 0) {
        openArray("specimen");
        for (ResourceReference e : element.getSpecimen()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getResultGroup().size() > 0) {
        openArray("resultGroup");
        for (LabReport.ResultGroup e : element.getResultGroup()) 
          composeLabReportResultGroup(null, e);
        closeArray();
      };
      composeString_("conclusion", element.getConclusion());
      if (element.getCodedDiagnosis().size() > 0) {
        openArray("codedDiagnosis");
        for (CodeableConcept e : element.getCodedDiagnosis()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      if (element.getRepresentation().size() > 0) {
        openArray("representation");
        for (Attachment e : element.getRepresentation()) 
          composeAttachment(null, e);
        closeArray();
      };
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  private void composeLabReportRequestDetail(String name, LabReport.RequestDetail element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeIdentifier("requestOrderId", element.getRequestOrderId());
      composeIdentifier("receiverOrderId", element.getReceiverOrderId());
      if (element.getRequestTest().size() > 0) {
        openArray("requestTest");
        for (CodeableConcept e : element.getRequestTest()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeResourceReference("requester", element.getRequester());
      composeResourceReference("clinicalInfo", element.getClinicalInfo());
      close();
    }
  }

  private void composeLabReportResultGroup(String name, LabReport.ResultGroup element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("name", element.getName());
      composeResourceReference("specimen", element.getSpecimen());
      if (element.getResult().size() > 0) {
        openArray("result");
        for (LabReport.Result e : element.getResult()) 
          composeLabReportResult(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeLabReportResult(String name, LabReport.Result element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      if (element.getFlag() != null)
        composeString("flag", element.getFlag().toCode());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString_("comments", element.getComments());
      if (element.getReferenceRange().size() > 0) {
        openArray("referenceRange");
        for (LabReport.ReferenceRange e : element.getReferenceRange()) 
          composeLabReportReferenceRange(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeLabReportReferenceRange(String name, LabReport.ReferenceRange element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeCodeableConcept("meaning", element.getMeaning());
      composeType("range", element.getRange());
      close();
    }
  }

  private void composeXdsFolder(String name, XdsFolder element) throws Exception {
    if (element != null) {
      open(name);
      composeElementAttributes(element);
      composeString("id", element.getId());
      if (element.getCode().size() > 0) {
        openArray("code");
        for (Coding e : element.getCode()) 
          composeCoding(null, e);
        closeArray();
      };
      composeString("title", element.getTitle());
      composeIdentifier("patientId", element.getPatientId());
      composeString("homeCommunity", element.getHomeCommunity());
      composeString("comments", element.getComments());
      if (element.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension e : element.getExtensions()) 
          composeExtension(null, e);
        closeArray();
      };
      composeNarrative("text", element.getText());
      close();
    }
  }

  @Override
  protected void composeResource(Resource resource) throws Exception {
    if (resource instanceof XdsEntry)
      composeXdsEntry("XdsEntry", (XdsEntry)resource);
    else if (resource instanceof Conformance)
      composeConformance("Conformance", (Conformance)resource);
    else if (resource instanceof DocumentHeader)
      composeDocumentHeader("DocumentHeader", (DocumentHeader)resource);
    else if (resource instanceof Device)
      composeDevice("Device", (Device)resource);
    else if (resource instanceof Animal)
      composeAnimal("Animal", (Animal)resource);
    else if (resource instanceof Agent)
      composeAgent("Agent", (Agent)resource);
    else if (resource instanceof Organization)
      composeOrganization("Organization", (Organization)resource);
    else if (resource instanceof Prescription)
      composePrescription("Prescription", (Prescription)resource);
    else if (resource instanceof Profile)
      composeProfile("Profile", (Profile)resource);
    else if (resource instanceof ValueSet)
      composeValueSet("ValueSet", (ValueSet)resource);
    else if (resource instanceof Problem)
      composeProblem("Problem", (Problem)resource);
    else if (resource instanceof Test)
      composeTest("Test", (Test)resource);
    else if (resource instanceof MessageHeader)
      composeMessageHeader("MessageHeader", (MessageHeader)resource);
    else if (resource instanceof Patient)
      composePatient("Patient", (Patient)resource);
    else if (resource instanceof AssessmentScale)
      composeAssessmentScale("AssessmentScale", (AssessmentScale)resource);
    else if (resource instanceof Person)
      composePerson("Person", (Person)resource);
    else if (resource instanceof LabReport)
      composeLabReport("LabReport", (LabReport)resource);
    else if (resource instanceof XdsFolder)
      composeXdsFolder("XdsFolder", (XdsFolder)resource);
    else
      throw new Exception("Unhanded resource type "+resource.getClass().getName());
  }

  @SuppressWarnings("unchecked")
  protected void composeType(String prefix, Type type) throws Exception {
    if (type == null)
      ;
    else if (type instanceof Period)
       composePeriod(prefix+"Period", (Period) type);
    else if (type instanceof Coding)
       composeCoding(prefix+"Coding", (Coding) type);
    else if (type instanceof Range)
       composeRange(prefix+"Range", (Range) type);
    else if (type instanceof Quantity)
       composeQuantity(prefix+"Quantity", (Quantity) type);
    else if (type instanceof Choice)
       composeChoice(prefix+"Choice", (Choice) type);
    else if (type instanceof Attachment)
       composeAttachment(prefix+"Attachment", (Attachment) type);
    else if (type instanceof Ratio)
       composeRatio(prefix+"Ratio", (Ratio) type);
    else if (type instanceof ResourceReference)
       composeResourceReference(prefix+"ResourceReference", (ResourceReference) type);
    else if (type instanceof CodeableConcept)
       composeCodeableConcept(prefix+"CodeableConcept", (CodeableConcept) type);
    else if (type instanceof Identifier)
       composeIdentifier(prefix+"Identifier", (Identifier) type);
    else if (type instanceof Age)
       composeAge(prefix+"Age", (Age) type);
    else if (type instanceof Count)
       composeCount(prefix+"Count", (Count) type);
    else if (type instanceof Money)
       composeMoney(prefix+"Money", (Money) type);
    else if (type instanceof Distance)
       composeDistance(prefix+"Distance", (Distance) type);
    else if (type instanceof Duration)
       composeDuration(prefix+"Duration", (Duration) type);
    else if (type instanceof Schedule)
       composeSchedule(prefix+"Schedule", (Schedule) type);
    else if (type instanceof Contact)
       composeContact(prefix+"Contact", (Contact) type);
    else if (type instanceof Address)
       composeAddress(prefix+"Address", (Address) type);
    else if (type instanceof HumanName)
       composeHumanName(prefix+"HumanName", (HumanName) type);
    else if (type instanceof HumanId)
       composeHumanId(prefix+"HumanId", (HumanId) type);
    else if (type instanceof Sid)
       composeSid(prefix+"Sid", (Sid) type);
    else if (type instanceof DateTime)
       composeDateTime(prefix+"DateTime", (DateTime) type);
    else if (type instanceof Integer)
       composeInteger(prefix+"Integer", (Integer) type);
    else if (type instanceof Code)
       composeCode(prefix+"Code", (Code) type);
    else if (type instanceof Date)
       composeDate(prefix+"Date", (Date) type);
    else if (type instanceof Decimal)
       composeDecimal(prefix+"Decimal", (Decimal) type);
    else if (type instanceof Uri)
       composeUri(prefix+"Uri", (Uri) type);
    else if (type instanceof Id)
       composeId(prefix+"Id", (Id) type);
    else if (type instanceof Base64Binary)
       composeBase64Binary(prefix+"Base64Binary", (Base64Binary) type);
    else if (type instanceof Oid)
       composeOid(prefix+"Oid", (Oid) type);
    else if (type instanceof String_)
       composeString_(prefix+"String", (String_) type);
    else if (type instanceof Boolean)
       composeBoolean(prefix+"Boolean", (Boolean) type);
    else if (type instanceof Uuid)
       composeUuid(prefix+"Uuid", (Uuid) type);
    else if (type instanceof Instant)
       composeInstant(prefix+"Instant", (Instant) type);
    else
      throw new Exception("Unhanded type");
  }

}

