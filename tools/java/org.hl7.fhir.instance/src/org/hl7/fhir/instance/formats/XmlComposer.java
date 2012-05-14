package org.hl7.fhir.instance.formats;

// Copyright HL7 (http://www.hl7.org). Generated on Mon, May 14, 2012 23:22+1000 for FHIR v0.01

import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.Boolean;

public class XmlComposer extends XmlComposerBase {

  private void composeExtension(String name, Extension element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeUri("definition", element.getDefinition());
      composeString("ref", element.getRef());
      if (element.getState() != null)
        composeString("state", element.getState().toCode());
      composeType("value", element.getValue());
      if (element.getExtension().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtension()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConstraint(String name, Constraint element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("type", element.getType());
      composeUri("profile", element.getProfile());
      composeString("name", element.getName());
      composeString("purpose", element.getPurpose());
      for (Constraint.Element_ e : element.getElement()) 
        composeConstraintElement_("element", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConstraintElement_(String name, Constraint.Element_ element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("path", element.getPath());
      composeString("name", element.getName());
      composeString("purpose", element.getPurpose());
      composeInt("min", element.getMin());
      composeString("max", element.getMax());
      composeString("type", element.getType());
      if (element.getConformance() != null)
        composeString("conformance", element.getConformance().toCode());
      composeString("condition", element.getCondition());
      composeBool("mustSupport", element.getMustSupport());
      composeBool("mustUnderstand", element.getMustUnderstand());
      composeString("definition", element.getDefinition());
      for (Constraint.Mapping e : element.getMapping()) 
        composeConstraintMapping("mapping", e);
      composeConstraintResource("resource", element.getResource());
      composeString("valueSet", element.getValueSet());
      for (Constraint.Value e : element.getValue()) 
        composeConstraintValue("value", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConstraintMapping(String name, Constraint.Mapping element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("target", element.getTarget());
      composeString("map", element.getMap());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConstraintResource(String name, Constraint.Resource element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeBool("aggregated", element.getAggregated());
      composeUri("profile", element.getProfile());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConstraintValue(String name, Constraint.Value element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("name", element.getName());
      composeType("", element.getValue());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeNarrative(String name, Narrative element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeXhtml("xhtml", element.getXhtml());
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

  private void composeCoding(String name, Coding element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
      composeString("display", element.getDisplay());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeInterval_Quantity(String name, Interval<Quantity> element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeQuantity("low", element.getLow());
      composeQuantity("high", element.getHigh());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeInterval_DateTime(String name, Interval<DateTime> element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDateTime("low", element.getLow());
      composeDateTime("high", element.getHigh());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeInterval_Date(String name, Interval<Date> element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeDate("low", element.getLow());
      composeDate("high", element.getHigh());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeQuantity(String name, Quantity element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
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
      composeUri("url", element.getUrl());
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
      composeUri("system", element.getSystem());
      composeString("id", element.getId());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeCount(String name, Count element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMoney(String name, Money element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDistance(String name, Distance element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDuration(String name, Duration element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      composeBigDecimal("value", element.getValue());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeString("units", element.getUnits());
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeSchedule(String name, Schedule element) throws Exception {
    if (element != null) {
      composeTypeAttributes(element);
      xml.open(FHIR_NS, name);
      for (Interval<DateTime> e : element.getEvent()) 
        composeInterval_DateTime("event", e);
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
      composeInterval_DateTime("period", element.getPeriod());
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
      composeInterval_DateTime("period", element.getPeriod());
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
      composeInterval_DateTime("period", element.getPeriod());
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
      composeInterval_DateTime("period", element.getPeriod());
      composeResourceReference("assigner", element.getAssigner());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformance(String name, Conformance element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      composeDateTime("date", element.getDate());
      composeConformancePublisher("publisher", element.getPublisher());
      composeConformanceSoftware("software", element.getSoftware());
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      for (Uri e : element.getProfile()) 
        composeUri("profile", e);
      composeConstraint("resource", element.getResource());
      composeConformanceOperation("operation", element.getOperation());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformancePublisher(String name, Conformance.Publisher element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceSoftware(String name, Conformance.Software element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      composeString_("version", element.getVersion());
      composeDateTime("releaseDate", element.getReleaseDate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceOperation(String name, Conformance.Operation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeBoolean("read", element.getRead());
      composeBoolean("vread", element.getVread());
      composeBoolean("update", element.getUpdate());
      composeBoolean("delete", element.getDelete());
      composeBoolean("validate", element.getValidate());
      composeBoolean("history", element.getHistory());
      composeConformanceTransaction("transaction", element.getTransaction());
      composeConformanceSearch("search", element.getSearch());
      composeConformanceCreate("create", element.getCreate());
      composeBoolean("updates", element.getUpdates());
      composeBoolean("schema", element.getSchema());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceTransaction(String name, Conformance.Transaction element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (Code e : element.getName()) 
        composeCode("name", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceSearch(String name, Conformance.Search element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (String_ e : element.getParam()) 
        composeString_("param", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeConformanceCreate(String name, Conformance.Create element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      if (element.getId() != null)
        composeString("id", element.getId().toCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocument(String name, Document element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      composeInstant("instant", element.getInstant());
      composeCodeableConcept("type", element.getType());
      composeString_("title", element.getTitle());
      composeId("setId", element.getSetId());
      composeInteger("version", element.getVersion());
      composeId("replaces", element.getReplaces());
      composeResourceReference("subject", element.getSubject());
      for (Document.Author e : element.getAuthor()) 
        composeDocumentAuthor("author", e);
      for (Document.Attestor e : element.getAttestor()) 
        composeDocumentAttestor("attestor", e);
      for (ResourceReference e : element.getRecipient()) 
        composeResourceReference("recipient", e);
      composeResourceReference("custodian", element.getCustodian());
      composeResourceReference("event", element.getEvent());
      composeResourceReference("encounter", element.getEncounter());
      for (Document.Section e : element.getSection()) 
        composeDocumentSection("section", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
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

  private void composeDocumentAttestor(String name, Document.Attestor element) throws Exception {
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
      composeId("id", element.getId());
      composeId("threadId", element.getThreadId());
      composeInstant("instant", element.getInstant());
      composeCode("event", element.getEvent());
      composeMessageResponse("response", element.getResponse());
      composeResourceReference("source", element.getSource());
      composeResourceReference("destination", element.getDestination());
      composeResourceReference("enterer", element.getEnterer());
      composeResourceReference("author", element.getAuthor());
      composeResourceReference("responsible", element.getResponsible());
      composeInterval_DateTime("effective", element.getEffective());
      composeCodeableConcept("reason", element.getReason());
      composeResourceReference("data", element.getData());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageResponse(String name, Message.Response element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      if (element.getCode() != null)
        composeString("code", element.getCode().toCode());
      composeBoolean("duplicate", element.getDuplicate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAnimal(String name, Animal element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
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
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeAnimalRelatedEntity(String name, Animal.RelatedEntity element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanId("id", element.getId());
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
      composeId("id", element.getId());
      composeResourceReference("person", element.getPerson());
      composeResourceReference("organization", element.getOrganization());
      for (CodeableConcept e : element.getRole()) 
        composeCodeableConcept("role", e);
      composeInterval_Date("period", element.getPeriod());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageConformance(String name, MessageConformance element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      composeDateTime("date", element.getDate());
      composeMessageConformancePublisher("publisher", element.getPublisher());
      composeMessageConformanceSoftware("software", element.getSoftware());
      for (Uri e : element.getProfile()) 
        composeUri("profile", e);
      for (MessageConformance.Event e : element.getEvent()) 
        composeMessageConformanceEvent("event", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageConformancePublisher(String name, MessageConformance.Publisher element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageConformanceSoftware(String name, MessageConformance.Software element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      composeString_("version", element.getVersion());
      composeDateTime("releaseDate", element.getReleaseDate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageConformanceEvent(String name, MessageConformance.Event element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("code", element.getCode());
      composeCode("resource", element.getResource());
      if (element.getMode() != null)
        composeString("mode", element.getMode().toCode());
      composeMessageConformanceRequest("request", element.getRequest());
      composeMessageConformanceResponse("response", element.getResponse());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageConformanceRequest(String name, MessageConformance.Request element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (Constraint e : element.getResource()) 
        composeConstraint("resource", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeMessageConformanceResponse(String name, MessageConformance.Response element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      for (Constraint e : element.getResource()) 
        composeConstraint("resource", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganization(String name, Organization element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
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
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationName(String name, Organization.Name element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("value", element.getValue());
      composeInterval_Date("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationAccreditation(String name, Organization.Accreditation element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("id", element.getId());
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("institution", element.getInstitution());
      composeInterval_Date("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeOrganizationRelatedOrganization(String name, Organization.RelatedOrganization element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanId("id", element.getId());
      composeCodeableConcept("code", element.getCode());
      composeString_("name", element.getName());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      composeInterval_Date("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescription(String name, Prescription element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("prescriber", element.getPrescriber());
      composeDateTime("prescribed", element.getPrescribed());
      composePrescriptionDispense("dispense", element.getDispense());
      composePrescriptionMedicine("medicine", element.getMedicine());
      composePrescriptionAdministrationRequest("administrationRequest", element.getAdministrationRequest());
      composeCodeableConcept("reason", element.getReason());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionDispense(String name, Prescription.Dispense element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeInteger("repeats", element.getRepeats());
      composeQuantity("quantity", element.getQuantity());
      composeResourceReference("dispenser", element.getDispenser());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionMedicine(String name, Prescription.Medicine element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCoding("productCode", element.getProductCode());
      composeString_("description", element.getDescription());
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
      composeCoding("productCode", element.getProductCode());
      composeRatio("quantity", element.getQuantity());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePrescriptionInactiveIngredient(String name, Prescription.InactiveIngredient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCoding("productCode", element.getProductCode());
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
      if (element.getPrn() != null)
        composeString("prn", element.getPrn().toCode());
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
      composeId("id", element.getId());
      composeString_("name", element.getName());
      composeProfileAuthor("author", element.getAuthor());
      composeString_("intention", element.getIntention());
      for (Coding e : element.getCode()) 
        composeCoding("code", e);
      composeString_("description", element.getDescription());
      for (Uri e : element.getEvidence()) 
        composeUri("evidence", e);
      composeString_("comments", element.getComments());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeDateTime("date", element.getDate());
      for (Profile.Endorser e : element.getEndorser()) 
        composeProfileEndorser("endorser", e);
      composeString_("changes", element.getChanges());
      for (Uri e : element.getSupercedes()) 
        composeUri("supercedes", e);
      for (Uri e : element.getProfile()) 
        composeUri("profile", e);
      for (Constraint e : element.getResource()) 
        composeConstraint("resource", e);
      for (Profile.Binding e : element.getBinding()) 
        composeProfileBinding("binding", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileAuthor(String name, Profile.Author element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      for (Uri e : element.getReference()) 
        composeUri("reference", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileEndorser(String name, Profile.Endorser element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      composeUri("reference", element.getReference());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeProfileBinding(String name, Profile.Binding element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      if (element.getType() != null)
        composeString("type", element.getType().toCode());
      composeString_("details", element.getDetails());
      composeUri("reference", element.getReference());
      for (Coding e : element.getCode()) 
        composeCoding("code", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeLloyd(String name, Lloyd element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeWoody(String name, Woody element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeEwout(String name, Ewout element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePatient(String name, Patient element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      for (ResourceReference e : element.getLink()) 
        composeResourceReference("link", e);
      composeBoolean("active", element.getActive());
      composeResourceReference("person", element.getPerson());
      composeResourceReference("animal", element.getAnimal());
      composeResourceReference("provider", element.getProvider());
      for (HumanId e : element.getIdentifier()) 
        composeHumanId("identifier", e);
      composeCodeableConcept("diet", element.getDiet());
      composeCodeableConcept("confidentiality", element.getConfidentiality());
      composeCodeableConcept("recordLocation", element.getRecordLocation());
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePerson(String name, Person element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
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
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePersonQualification(String name, Person.Qualification element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeIdentifier("id", element.getId());
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("institution", element.getInstitution());
      composeInterval_Date("period", element.getPeriod());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePersonLanguage(String name, Person.Language element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeCode("code", element.getCode());
      if (element.getUse() != null)
        composeString("use", element.getUse().toCode());
      xml.close(FHIR_NS, name);
    }
  }

  private void composePersonRelatedPerson(String name, Person.RelatedPerson element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeHumanId("id", element.getId());
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
      composeId("id", element.getId());
      if (element.getStatus() != null)
        composeString("status", element.getStatus().toCode());
      composeInstant("issued", element.getIssued());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("admission", element.getAdmission());
      composeResourceReference("laboratory", element.getLaboratory());
      composeId("reportId", element.getReportId());
      for (LabReport.RequestDetail e : element.getRequestDetail()) 
        composeLabReportRequestDetail("requestDetail", e);
      composeCodeableConcept("reportName", element.getReportName());
      composeCodeableConcept("service", element.getService());
      composeDateTime("diagnosticTime", element.getDiagnosticTime());
      for (ResourceReference e : element.getSpecimen()) 
        composeResourceReference("specimen", e);
      for (LabReport.ResultGroup e : element.getResultGroup()) 
        composeLabReportResultGroup("resultGroup", e);
      composeNarrative("conclusion", element.getConclusion());
      for (CodeableConcept e : element.getCodedDiagnosis()) 
        composeCodeableConcept("codedDiagnosis", e);
      for (Attachment e : element.getRepresentation()) 
        composeAttachment("representation", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
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

  private void composeDocumentConformance(String name, DocumentConformance element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeId("id", element.getId());
      composeDateTime("date", element.getDate());
      composeDocumentConformancePublisher("publisher", element.getPublisher());
      composeDocumentConformanceSoftware("software", element.getSoftware());
      for (Uri e : element.getProfile()) 
        composeUri("profile", e);
      for (DocumentConformance.Document e : element.getDocument()) 
        composeDocumentConformanceDocument("document", e);
      if (element.getExtensions().size() > 0) {
        xml.open(FHIR_NS, "extensions");
        for (Extension e : element.getExtensions()) 
          composeExtension("extension", e);
        xml.close(FHIR_NS, "extensions");
      }
      composeNarrative("text", element.getText());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentConformancePublisher(String name, DocumentConformance.Publisher element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      for (Address e : element.getAddress()) 
        composeAddress("address", e);
      for (Contact e : element.getContact()) 
        composeContact("contact", e);
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentConformanceSoftware(String name, DocumentConformance.Software element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      composeString_("version", element.getVersion());
      composeDateTime("releaseDate", element.getReleaseDate());
      xml.close(FHIR_NS, name);
    }
  }

  private void composeDocumentConformanceDocument(String name, DocumentConformance.Document element) throws Exception {
    if (element != null) {
      composeElementAttributes(element);
      xml.open(FHIR_NS, name);
      composeString_("name", element.getName());
      composeString_("purpose", element.getPurpose());
      for (Constraint e : element.getResource()) 
        composeConstraint("resource", e);
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
    else if (resource instanceof MessageConformance)
      composeMessageConformance("MessageConformance", (MessageConformance)resource);
    else if (resource instanceof Organization)
      composeOrganization("Organization", (Organization)resource);
    else if (resource instanceof Prescription)
      composePrescription("Prescription", (Prescription)resource);
    else if (resource instanceof Profile)
      composeProfile("Profile", (Profile)resource);
    else if (resource instanceof Lloyd)
      composeLloyd("Lloyd", (Lloyd)resource);
    else if (resource instanceof Woody)
      composeWoody("Woody", (Woody)resource);
    else if (resource instanceof Ewout)
      composeEwout("Ewout", (Ewout)resource);
    else if (resource instanceof Patient)
      composePatient("Patient", (Patient)resource);
    else if (resource instanceof Person)
      composePerson("Person", (Person)resource);
    else if (resource instanceof LabReport)
      composeLabReport("LabReport", (LabReport)resource);
    else if (resource instanceof DocumentConformance)
      composeDocumentConformance("DocumentConformance", (DocumentConformance)resource);
    else
      throw new Exception("Unhanded resource type");
  }

  @SuppressWarnings("unchecked")
  protected void composeType(String prefix, Type type) throws Exception {
    if (type == null)
      ;
    else if (type instanceof Coding)
       composeCoding(prefix+"Coding", (Coding) type);
    else if (type instanceof Interval && ((Interval<Ordered>) type).getType().equals("Quantity"))
      composeInterval_Quantity(prefix+"Interval_Quantity", (Interval<Quantity>) type);
    else if (type instanceof Interval && ((Interval<Ordered>) type).getType().equals("DateTime"))
      composeInterval_DateTime(prefix+"Interval_DateTime", (Interval<DateTime>) type);
    else if (type instanceof Interval && ((Interval<Ordered>) type).getType().equals("Date"))
      composeInterval_Date(prefix+"Interval_Date", (Interval<Date>) type);
    else if (type instanceof Quantity)
       composeQuantity(prefix+"Quantity", (Quantity) type);
    else if (type instanceof Choice)
       composeChoice(prefix+"Choice", (Choice) type);
    else if (type instanceof Attachment)
       composeAttachment(prefix+"Attachment", (Attachment) type);
    else if (type instanceof Ratio)
       composeRatio(prefix+"Ratio", (Ratio) type);
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

