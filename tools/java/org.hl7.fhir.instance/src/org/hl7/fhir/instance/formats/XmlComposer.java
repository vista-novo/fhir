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

// Generated on Sun, Jul 15, 2012 22:42+1000 for FHIR v0.04

import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.Boolean;
import java.net.*;

public class XmlComposer extends XmlComposerBase {

  private void composeExtension(String name, Extension element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeURI("profile", element.getProfile());
      composeString("ref", element.getRef());
      composeBool("mustUnderstand", element.getMustUnderstand());
      composeType("value", element.getValue());
      if (element.getExtension().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtension()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      xml.close(FHIR_NS, name);
    }
  }

  private void composeNarrative(String name, Narrative element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeXhtml("div", element.getDiv());
      for (Narrative.Image e : element.getImage()) 
        composeNarrativeImage("image", e);
      for (Narrative.Map e : element.getMap()) 
        composeNarrativeMap("map", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeNarrativeImage(String name, Narrative.Image element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("mimeType", element.getMimeType());
      composeBytes("content", element.getContent());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeNarrativeMap(String name, Narrative.Map element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("text", element.getText());
      composeString("data", element.getData());
      if (element.getSource() != null)
        composeString("source", element.getSource().toCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePeriod(String name, Period element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("start", element.getStart());
      composeString("end", element.getEnd());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCoding(String name, Coding element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      composeString("display", element.getDisplay());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeRange(String name, Range element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeQuantity("low", element.getLow());
      composeQuantity("high", element.getHigh());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeQuantity(String name, Quantity element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeChoice(String name, Choice element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      for (Choice.Value e : element.getValue()) 
        composeChoiceValue("value", e);
      composeBool("isOrdered", element.getIsOrdered());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeChoiceValue(String name, Choice.Value element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeString("display", element.getDisplay());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAttachment(String name, Attachment element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("mimeType", element.getMimeType());
      composeBytes("data", element.getData());
      composeURI("url", element.getUrl());
      composeBytes("hash", element.getHash());
      composeString("lang", element.getLang());
      composeString("title", element.getTitle());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeRatio(String name, Ratio element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeQuantity("numerator", element.getNumerator());
      composeQuantity("denominator", element.getDenominator());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeResourceReference(String name, ResourceReference element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("type", element.getType());
      composeURI("id", element.getId());
      composeURI("version", element.getVersion());
      composeString("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCodeableConcept(String name, CodeableConcept element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      for (Coding e : element.getCoding()) 
        composeCoding("coding", e);
      composeString("text", element.getText());
      composeString("primary", element.getPrimary());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeIdentifier(String name, Identifier element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeURI("system", element.getSystem());
      composeString("id", element.getId());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCount(String name, Count element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMoney(String name, Money element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDistance(String name, Distance element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDuration(String name, Duration element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getRange() != null)
        composeString("range", element.getRange().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSchedule(String name, Schedule element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      for (Period e : element.getEvent()) 
        composePeriod("event", e);
      composeScheduleRepeat("repeat", element.getRepeat());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeScheduleRepeat(String name, Schedule.Repeat element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeInt("frequency", element.getFrequency());
      if (element.getWhen() != null)
        composeString("when", element.getWhen().toCode());
      composeDuration("duration", element.getDuration());
      composeInt("count", element.getCount());
      composeString("end", element.getEnd());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeContact(String name, Contact element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getSystem() != null)
        composeString("system", element.getSystem().toCode());
      composeString("value", element.getValue());
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAddress(String name, Address element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      composeString("text", element.getText());
      for (Address.Part e : element.getPart()) 
        composeAddressPart("part", e);
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAddressPart(String name, Address.Part element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeString("value", element.getValue());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeHumanName(String name, HumanName element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      composeString("text", element.getText());
      for (HumanName.Part e : element.getPart()) 
        composeHumanNamePart("part", e);
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeHumanNamePart(String name, HumanName.Part element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeString("value", element.getValue());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeHumanId(String name, HumanId element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeCoding("type", element.getType());
      composeIdentifier("identifier", element.getIdentifier());
      composePeriod("period", element.getPeriod());
      composeResourceReference("assigner", element.getAssigner());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformance(String name, Conformance element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeString("date", element.getDate());
      composeConformancePublisher("publisher", element.getPublisher());
      composeConformanceImplementation("implementation", element.getImplementation());
      composeConformanceSoftware("software", element.getSoftware());
      composeConformanceProposal("proposal", element.getProposal());
      composeString("version", element.getVersion());
      composeBool("acceptUnknown", element.getAcceptUnknown());
      for (Conformance.Rest e : element.getRest()) 
        composeConformanceRest("rest", e);
      for (Conformance.Messaging e : element.getMessaging()) 
        composeConformanceMessaging("messaging", e);
      for (Conformance.Document e : element.getDocument()) 
        composeConformanceDocument("document", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformancePublisher(String name, Conformance.Publisher element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeAddress("address", element.getAddress());
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceImplementation(String name, Conformance.Implementation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("description", element.getDescription());
      composeURI("url", element.getUrl());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceSoftware(String name, Conformance.Software element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeString("releaseDate", element.getReleaseDate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceProposal(String name, Conformance.Proposal element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("description", element.getDescription());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceRest(String name, Conformance.Rest element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      composeString("documentation", element.getDocumentation());
      for (Conformance.Resource e : element.getResource()) 
        composeConformanceResource("resource", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceResource(String name, Conformance.Resource element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("type", element.getType());
      composeURI("profile", element.getProfile());
      for (Conformance.Operation e : element.getOperation()) 
        composeConformanceOperation("operation", e);
      composeConformanceSearch("search", element.getSearch());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceOperation(String name, Conformance.Operation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getCode() != null)
        composeString("code", element.getCode().toCode());
      composeString("documentation", element.getDocumentation());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceSearch(String name, Conformance.Search element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("documentation", element.getDocumentation());
      for (Conformance.Param e : element.getParam()) 
        composeConformanceParam("param", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceParam(String name, Conformance.Param element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeString("documentation", element.getDocumentation());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceMessaging(String name, Conformance.Messaging element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeURI("endpoint", element.getEndpoint());
      composeString("documentation", element.getDocumentation());
      for (Conformance.Event e : element.getEvent()) 
        composeConformanceEvent("event", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceEvent(String name, Conformance.Event element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      for (Coding e : element.getProtocol()) 
        composeCoding("protocol", e);
      composeString("focus", element.getFocus());
      composeURI("request", element.getRequest());
      composeURI("response", element.getResponse());
      composeString("documentation", element.getDocumentation());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceDocument(String name, Conformance.Document element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      composeString("documentation", element.getDocumentation());
      composeURI("profile", element.getProfile());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocument(String name, Document element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeDate("instant", element.getInstant());
      composeCodeableConcept("type", element.getType());
      composeString_("title", element.getTitle());
      composeString("replaces", element.getReplaces());
      composeResourceReference("subject", element.getSubject());
      for (Document.Author e : element.getAuthor()) 
        composeDocumentAuthor("author", e);
      for (Document.Attester e : element.getAttester()) 
        composeDocumentAttester("attester", e);
      for (ResourceReference e : element.getRecipient()) 
        composeResourceReference("recipient", e);
      composeResourceReference("custodian", element.getCustodian());
      composeResourceReference("event", element.getEvent());
      composeResourceReference("encounter", element.getEncounter());
      composeAttachment("stylesheet", element.getStylesheet());
      composeAttachment("representation", element.getRepresentation());
      for (Document.Section e : element.getSection()) 
        composeDocumentSection("section", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentAuthor(String name, Document.Author element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeDateTime("time", element.getTime());
      composeResourceReference("party", element.getParty());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentAttester(String name, Document.Attester element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      composeDateTime("time", element.getTime());
      composeResourceReference("party", element.getParty());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentSection(String name, Document.Section element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("type", element.getType());
      composeInstant("instant", element.getInstant());
      composeDocumentAuthorA("author", element.getAuthor());
      composeResourceReference("enterer", element.getEnterer());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("informant", element.getInformant());
      composeResourceReference("content", element.getContent());
      for (Document.Section e : element.getSection()) 
        composeDocumentSection("section", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentAuthorA(String name, Document.AuthorA element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeDateTime("time", element.getTime());
      composeResourceReference("party", element.getParty());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessage(String name, Message element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeString("threadId", element.getThreadId());
      composeDate("instant", element.getInstant());
      composeString("event", element.getEvent());
      composeMessageResponse("response", element.getResponse());
      composeMessageSource("source", element.getSource());
      composeMessageDestination("destination", element.getDestination());
      composeResourceReference("enterer", element.getEnterer());
      composeResourceReference("author", element.getAuthor());
      composeResourceReference("responsible", element.getResponsible());
      composePeriod("effective", element.getEffective());
      composeCodeableConcept("reason", element.getReason());
      for (ResourceReference e : element.getData()) 
        composeResourceReference("data", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageResponse(String name, Message.Response element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      if (element.getCode() != null)
        composeString("code", element.getCode().toCode());
      composeBool("duplicate", element.getDuplicate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageSource(String name, Message.Source element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeString("software", element.getSoftware());
      composeString_("version", element.getVersion());
      composeContact("contact", element.getContact());
      composeURI("endpoint", element.getEndpoint());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageDestination(String name, Message.Destination element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeResourceReference("target", element.getTarget());
      composeURI("endpoint", element.getEndpoint());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAnimal(String name, Animal element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      for (HumanName e : element.getName()) 
        composeHumanName("name", e);
      composeDateTime("dob", element.getDob());
      composeCodeableConcept("species", element.getSpecies());
      composeCodeableConcept("strain", element.getStrain());
      composeCodeableConcept("gender", element.getGender());
      for (Animal.RelatedEntity e : element.getRelatedEntity()) 
        composeAnimalRelatedEntity("relatedEntity", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAnimalRelatedEntity(String name, Animal.RelatedEntity element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanId("identifier", element.getIdentifier());
      composeCodeableConcept("role", element.getRole());
      composeHumanName("name", element.getName());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAgent(String name, Agent element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeResourceReference("person", element.getPerson());
      composeResourceReference("organization", element.getOrganization());
      for (CodeableConcept e : element.getRole()) 
        composeCodeableConcept("role", e);
      composePeriod("period", element.getPeriod());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganization(String name, Organization element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      for (Organization.Name e : element.getName()) 
        composeOrganizationName("name", e);
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      composeCodeableConcept("code", element.getCode());
      composeCodeableConcept("industryCode", element.getIndustryCode());
      for (Organization.Accreditation e : element.getAccreditation()) 
        composeOrganizationAccreditation("accreditation", e);
      for (Organization.RelatedOrganization e : element.getRelatedOrganization()) 
        composeOrganizationRelatedOrganization("relatedOrganization", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationName(String name, Organization.Name element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("value", element.getValue());
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationAccreditation(String name, Organization.Accreditation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("identifier", element.getIdentifier());
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("institution", element.getInstitution());
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationRelatedOrganization(String name, Organization.RelatedOrganization element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanId("identifier", element.getIdentifier());
      composeCodeableConcept("code", element.getCode());
      composeString_("name", element.getName());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescription(String name, Prescription element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
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
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionDispense(String name, Prescription.Dispense element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeInt("repeats", element.getRepeats());
      composeQuantity("quantity", element.getQuantity());
      composeResourceReference("dispenser", element.getDispenser());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionMedicine(String name, Prescription.Medicine element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("identification", element.getIdentification());
      for (Prescription.ActiveIngredient e : element.getActiveIngredient()) 
        composePrescriptionActiveIngredient("activeIngredient", e);
      for (Prescription.InactiveIngredient e : element.getInactiveIngredient()) 
        composePrescriptionInactiveIngredient("inactiveIngredient", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionActiveIngredient(String name, Prescription.ActiveIngredient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("identification", element.getIdentification());
      composeRatio("quantity", element.getQuantity());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionInactiveIngredient(String name, Prescription.InactiveIngredient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("identification", element.getIdentification());
      composeRatio("quantity", element.getQuantity());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionAdministrationRequest(String name, Prescription.AdministrationRequest element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("description", element.getDescription());
      composeRatio("totalPeriodicDosis", element.getTotalPeriodicDosis());
      composeDateTime("start", element.getStart());
      composeDateTime("end", element.getEnd());
      composeQuantity("duration", element.getDuration());
      composeInteger("numberOfAdministrations", element.getNumberOfAdministrations());
      for (Prescription.DosageInstruction e : element.getDosageInstruction()) 
        composePrescriptionDosageInstruction("dosageInstruction", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionDosageInstruction(String name, Prescription.DosageInstruction element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (CodeableConcept e : element.getPrecondition()) 
        composeCodeableConcept("precondition", e);
      composeBool("prn", element.getPrn());
      for (CodeableConcept e : element.getAdditionalInstruction()) 
        composeCodeableConcept("additionalInstruction", e);
      composeCodeableConcept("route", element.getRoute());
      composeType("dose", element.getDose());
      composeQuantity("rate", element.getRate());
      for (Schedule e : element.getSchedule()) 
        composeSchedule("schedule", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfile(String name, Profile element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeProfileAuthor("author", element.getAuthor());
      composeString("description", element.getDescription());
      for (Coding e : element.getCode()) 
        composeCoding("code", e);
      composeProfileStatus("status", element.getStatus());
      for (Profile.Import e : element.getImport()) 
        composeProfileImport("import", e);
      composeString("bundle", element.getBundle());
      for (Profile.Resource e : element.getResource()) 
        composeProfileResource("resource", e);
      for (Profile.ExtensionDefn e : element.getExtensionDefn()) 
        composeProfileExtensionDefn("extensionDefn", e);
      for (Profile.Binding e : element.getBinding()) 
        composeProfileBinding("binding", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileAuthor(String name, Profile.Author element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      for (URI e : element.getReference()) 
        composeURI("reference", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileStatus(String name, Profile.Status element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getCode() != null)
        composeString("code", element.getCode().toCode());
      composeString("date", element.getDate());
      composeString("comment", element.getComment());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileImport(String name, Profile.Import element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeURI("uri", element.getUri());
      composeString("prefix", element.getPrefix());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileResource(String name, Profile.Resource element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("type", element.getType());
      composeURI("profile", element.getProfile());
      composeString("name", element.getName());
      composeString("purpose", element.getPurpose());
      for (Profile.Element_ e : element.getElement()) 
        composeProfileElement_("element", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileElement_(String name, Profile.Element_ element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("path", element.getPath());
      composeString("name", element.getName());
      composeProfileDefinition("definition", element.getDefinition());
      composeBool("bundled", element.getBundled());
      composeBool("closed", element.getClosed());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileDefinition(String name, Profile.Definition element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("short", element.getShort());
      composeString("formal", element.getFormal());
      composeString("comments", element.getComments());
      composeString("requirements", element.getRequirements());
      for (String e : element.getSynonym()) 
        composeString("synonym", e);
      composeInt("min", element.getMin());
      composeString("max", element.getMax());
      for (Profile.Type e : element.getType()) 
        composeProfileType("type", e);
      composeString("nameReference", element.getNameReference());
      composeType("value", element.getValue());
      composeInt("maxLength", element.getMaxLength());
      composeBool("dataAbsentReason", element.getDataAbsentReason());
      for (String e : element.getCondition()) 
        composeString("condition", e);
      for (Profile.Constraint e : element.getConstraint()) 
        composeProfileConstraint("constraint", e);
      composeBool("mustSupport", element.getMustSupport());
      composeBool("mustUnderstand", element.getMustUnderstand());
      composeString("binding", element.getBinding());
      for (Profile.Mapping e : element.getMapping()) 
        composeProfileMapping("mapping", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileType(String name, Profile.Type element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeURI("profile", element.getProfile());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileConstraint(String name, Profile.Constraint element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeString("name", element.getName());
      composeString("severity", element.getSeverity());
      composeString("human", element.getHuman());
      composeString("xpath", element.getXpath());
      composeString("ocl", element.getOcl());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileMapping(String name, Profile.Mapping element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("target", element.getTarget());
      composeString("map", element.getMap());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileExtensionDefn(String name, Profile.ExtensionDefn element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      for (String e : element.getContext()) 
        composeString("context", e);
      if (element.getContextType() != null)
        composeString("contextType", element.getContextType().toCode());
      composeProfileDefinition("definition", element.getDefinition());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileBinding(String name, Profile.Binding element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeString("definition", element.getDefinition());
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeBool("isExtensible", element.getIsExtensible());
      if (element.getConformance() != null)
        composeString("conformance", element.getConformance().toCode());
      composeURI("reference", element.getReference());
      for (Profile.Concept e : element.getConcept()) 
        composeProfileConcept("concept", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileConcept(String name, Profile.Concept element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeURI("system", element.getSystem());
      composeString("display", element.getDisplay());
      composeString("definition", element.getDefinition());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSet(String name, ValueSet element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeString("name", element.getName());
      composeValueSetAuthor("author", element.getAuthor());
      composeString("description", element.getDescription());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString("date", element.getDate());
      composeString("identifier", element.getIdentifier());
      composeString("version", element.getVersion());
      for (URI e : element.getRestricts()) 
        composeURI("restricts", e);
      for (URI e : element.getImport()) 
        composeURI("import", e);
      for (ValueSet.Include e : element.getInclude()) 
        composeValueSetInclude("include", e);
      for (ValueSet.Include e : element.getExclude()) 
        composeValueSetInclude("exclude", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSetAuthor(String name, ValueSet.Author element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeURI("reference", element.getReference());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSetInclude(String name, ValueSet.Include element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeURI("system", element.getSystem());
      composeString("version", element.getVersion());
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      for (String e : element.getCode()) 
        composeString("code", e);
      for (ValueSet.Filter e : element.getFilter()) 
        composeValueSetFilter("filter", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeValueSetFilter(String name, ValueSet.Filter element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("property", element.getProperty());
      if (element.getOp() != null)
        composeString("op", element.getOp().toCode());
      composeString("value", element.getValue());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePatient(String name, Patient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      for (ResourceReference e : element.getLink()) 
        composeResourceReference("link", e);
      composeBool("active", element.getActive());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("provider", element.getProvider());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      composeCodeableConcept("diet", element.getDiet());
      composeCodeableConcept("confidentiality", element.getConfidentiality());
      composeCodeableConcept("recordLocation", element.getRecordLocation());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAssessmentScale(String name, AssessmentScale element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("performer", element.getPerformer());
      composeString("time", element.getTime());
      composeResourceReference("definition", element.getDefinition());
      for (CodeableConcept e : element.getInterpretation()) 
        composeCodeableConcept("interpretation", e);
      composeAssessmentScaleScore("score", element.getScore());
      composeString_("reason", element.getReason());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAssessmentScaleScore(String name, AssessmentScale.Score element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("code", element.getCode());
      composeType("value", element.getValue());
      for (AssessmentScale.Score e : element.getScore()) 
        composeAssessmentScaleScore("score", e);
      for (AssessmentScale.Measure e : element.getMeasure()) 
        composeAssessmentScaleMeasure("measure", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAssessmentScaleMeasure(String name, AssessmentScale.Measure element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("code", element.getCode());
      composeType("value", element.getValue());
      composeDateTime("time", element.getTime());
      composeResourceReference("source", element.getSource());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePerson(String name, Person element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      for (HumanName e : element.getName()) 
        composeHumanName("name", e);
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      composeDateTime("dob", element.getDob());
      composeCodeableConcept("gender", element.getGender());
      composeCodeableConcept("religion", element.getReligion());
      for (CodeableConcept e : element.getRace()) 
        composeCodeableConcept("race", e);
      for (Person.Qualification e : element.getQualification()) 
        composePersonQualification("qualification", e);
      for (Person.Language e : element.getLanguage()) 
        composePersonLanguage("language", e);
      for (Person.RelatedPerson e : element.getRelatedPerson()) 
        composePersonRelatedPerson("relatedPerson", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePersonQualification(String name, Person.Qualification element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("identifier", element.getIdentifier());
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("institution", element.getInstitution());
      composePeriod("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePersonLanguage(String name, Person.Language element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePersonRelatedPerson(String name, Person.RelatedPerson element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanId("identifier", element.getIdentifier());
      composeCodeableConcept("role", element.getRole());
      composeHumanName("name", element.getName());
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReport(String name, LabReport element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("id", element.getId());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeDate("issued", element.getIssued());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("admission", element.getAdmission());
      composeResourceReference("laboratory", element.getLaboratory());
      composeIdentifier("reportId", element.getReportId());
      for (LabReport.RequestDetail e : element.getRequestDetail()) 
        composeLabReportRequestDetail("requestDetail", e);
      composeCodeableConcept("reportName", element.getReportName());
      composeCodeableConcept("service", element.getService());
      composeString("diagnosticTime", element.getDiagnosticTime());
      for (ResourceReference e : element.getSpecimen()) 
        composeResourceReference("specimen", e);
      for (LabReport.ResultGroup e : element.getResultGroup()) 
        composeLabReportResultGroup("resultGroup", e);
      composeString_("conclusion", element.getConclusion());
      for (CodeableConcept e : element.getCodedDiagnosis()) 
        composeCodeableConcept("codedDiagnosis", e);
      for (Attachment e : element.getRepresentation()) 
        composeAttachment("representation", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extension");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extension");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportRequestDetail(String name, LabReport.RequestDetail element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("requestOrderId", element.getRequestOrderId());
      composeIdentifier("receiverOrderId", element.getReceiverOrderId());
      for (CodeableConcept e : element.getRequestTest()) 
        composeCodeableConcept("requestTest", e);
      composeResourceReference("requester", element.getRequester());
      composeResourceReference("clinicalInfo", element.getClinicalInfo());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportResultGroup(String name, LabReport.ResultGroup element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("name", element.getName());
      composeResourceReference("specimen", element.getSpecimen());
      for (LabReport.Result e : element.getResult()) 
        composeLabReportResult("result", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportResult(String name, LabReport.Result element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      if (element.getFlag() != null)
        composeString("flag", element.getFlag().toCode());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString_("comments", element.getComments());
      for (LabReport.ReferenceRange e : element.getReferenceRange()) 
        composeLabReportReferenceRange("referenceRange", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLabReportReferenceRange(String name, LabReport.ReferenceRange element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCodeableConcept("meaning", element.getMeaning());
      composeType("range", element.getRange());
      xml.close(FHIR_NS, name);
    }
  }

  @Override
  protected void composeResource(Resource resource) throws Exception {
    if (resource instanceof Conformance)
      composeConformance("Conformance", (Conformance)resource);
    else if (resource instanceof Document)
      composeDocument("Document", (Document)resource);
    else if (resource instanceof Message)
      composeMessage("Message", (Message)resource);
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
    else if (resource instanceof Patient)
      composePatient("Patient", (Patient)resource);
    else if (resource instanceof AssessmentScale)
      composeAssessmentScale("AssessmentScale", (AssessmentScale)resource);
    else if (resource instanceof Person)
      composePerson("Person", (Person)resource);
    else if (resource instanceof LabReport)
      composeLabReport("LabReport", (LabReport)resource);
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

