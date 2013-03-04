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

// Generated on Mon, Mar 4, 2013 20:03+1100 for FHIR v0.07

import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.DateTime;
import org.hl7.fhir.instance.model.Code;
import org.hl7.fhir.instance.model.Date;
import org.hl7.fhir.instance.model.Decimal;
import org.hl7.fhir.instance.model.Uri;
import org.hl7.fhir.instance.model.Id;
import org.hl7.fhir.instance.model.Base64Binary;
import org.hl7.fhir.instance.model.Oid;
import org.hl7.fhir.instance.model.String_;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Uuid;
import org.hl7.fhir.instance.model.Instant;
import org.hl7.fhir.instance.model.*;
import org.json.*;

public class JsonParser extends JsonParserBase {

  protected void parseElementProperties(JSONObject json, Element element) throws Exception {
    super.parseElementProperties(json, element);
    if (json.has("extension")) {
      JSONArray array = json.getJSONArray("extension");
      for (int i = 0; i < array.length(); i++) {
        element.getExtensions().add(parseExtension(array.getJSONObject(i)));
      }
    };
  }

  protected void parseTypeProperties(JSONObject json, Element element) throws Exception {
    parseElementProperties(json, element);
  }

  @SuppressWarnings("unchecked")
  private <E extends Enum<E>> Enumeration<E> parseEnumeration(JSONObject json, E item, EnumFactory e) throws Exception {
    Enumeration<E> res = new Enumeration<E>();
    parseElementProperties(json, res);
    if (json.has("value"))
    res.setValue((E) e.fromCode(json.getString("value")));
    return res;
  }

  private Integer parseInteger(JSONObject json) throws Exception {
    Integer res = new Integer();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseIntegerPrimitive(json.getString("value")));
    return res;
  }

  private DateTime parseDateTime(JSONObject json) throws Exception {
    DateTime res = new DateTime();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDateTimePrimitive(json.getString("value")));
    return res;
  }

  private Code parseCode(JSONObject json) throws Exception {
    Code res = new Code();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseCodePrimitive(json.getString("value")));
    return res;
  }

  private Date parseDate(JSONObject json) throws Exception {
    Date res = new Date();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDatePrimitive(json.getString("value")));
    return res;
  }

  private Decimal parseDecimal(JSONObject json) throws Exception {
    Decimal res = new Decimal();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimalPrimitive(json.getString("value")));
    return res;
  }

  private Uri parseUri(JSONObject json) throws Exception {
    Uri res = new Uri();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseUriPrimitive(json.getString("value")));
    return res;
  }

  private Id parseId(JSONObject json) throws Exception {
    Id res = new Id();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseIdPrimitive(json.getString("value")));
    return res;
  }

  private Base64Binary parseBase64Binary(JSONObject json) throws Exception {
    Base64Binary res = new Base64Binary();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseBase64BinaryPrimitive(json.getString("value")));
    return res;
  }

  private Oid parseOid(JSONObject json) throws Exception {
    Oid res = new Oid();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseOidPrimitive(json.getString("value")));
    return res;
  }

  private String_ parseString(JSONObject json) throws Exception {
    String_ res = new String_();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseStringPrimitive(json.getString("value")));
    return res;
  }

  private Boolean parseBoolean(JSONObject json) throws Exception {
    Boolean res = new Boolean();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseBooleanPrimitive(json.getString("value")));
    return res;
  }

  private Uuid parseUuid(JSONObject json) throws Exception {
    Uuid res = new Uuid();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseUuidPrimitive(json.getString("value")));
    return res;
  }

  private Instant parseInstant(JSONObject json) throws Exception {
    Instant res = new Instant();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseInstantPrimitive(json.getString("value")));
    return res;
  }

  private Extension parseExtension(JSONObject json) throws Exception {
    Extension res = new Extension();
    parseElementProperties(json, res);
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("mustUnderstand"))
      res.setMustUnderstand(parseBoolean(json.getJSONObject("mustUnderstand")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("extension")) {
      JSONArray array = json.getJSONArray("extension");
      for (int i = 0; i < array.length(); i++) {
        res.getExtension().add(parseExtension(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Narrative parseNarrative(JSONObject json) throws Exception {
    Narrative res = new Narrative();
    parseElementProperties(json, res);
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Narrative.NarrativeStatus.Null, new Narrative().new NarrativeStatusEnumFactory()));
    if (json.has("div"))
      res.setDiv(parseXhtml(json.getString("div")));
    if (json.has("blob")) {
      JSONArray array = json.getJSONArray("blob");
      for (int i = 0; i < array.length(); i++) {
        res.getBlob().add(parseNarrativeBlob(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Narrative.Blob parseNarrativeBlob(JSONObject json, Narrative owner) throws Exception {
    Narrative.Blob res = owner.new Blob();
    parseElementProperties(json, res);
    if (json.has("mimeType"))
      res.setMimeType(parseCode(json.getJSONObject("mimeType")));
    if (json.has("content"))
      res.setContent(parseBase64Binary(json.getJSONObject("content")));
    return res;
  }

  private Period parsePeriod(JSONObject json) throws Exception {
    Period res = new Period();
    parseTypeProperties(json, res);
    if (json.has("start"))
      res.setStart(parseDateTime(json.getJSONObject("start")));
    if (json.has("end"))
      res.setEnd(parseDateTime(json.getJSONObject("end")));
    return res;
  }

  private Coding parseCoding(JSONObject json) throws Exception {
    Coding res = new Coding();
    parseTypeProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    return res;
  }

  private Range parseRange(JSONObject json) throws Exception {
    Range res = new Range();
    parseTypeProperties(json, res);
    if (json.has("low"))
      res.setLow(parseQuantity(json.getJSONObject("low")));
    if (json.has("high"))
      res.setHigh(parseQuantity(json.getJSONObject("high")));
    return res;
  }

  private Quantity parseQuantity(JSONObject json) throws Exception {
    Quantity res = new Quantity();
    parseTypeProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Choice parseChoice(JSONObject json) throws Exception {
    Choice res = new Choice();
    parseTypeProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("option")) {
      JSONArray array = json.getJSONArray("option");
      for (int i = 0; i < array.length(); i++) {
        res.getOption().add(parseChoiceOption(array.getJSONObject(i), res));
      }
    };
    if (json.has("isOrdered"))
      res.setIsOrdered(parseBoolean(json.getJSONObject("isOrdered")));
    return res;
  }

  private Choice.Option parseChoiceOption(JSONObject json, Choice owner) throws Exception {
    Choice.Option res = owner.new Option();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    return res;
  }

  private Attachment parseAttachment(JSONObject json) throws Exception {
    Attachment res = new Attachment();
    parseTypeProperties(json, res);
    if (json.has("contentType"))
      res.setContentType(parseCode(json.getJSONObject("contentType")));
    if (json.has("language"))
      res.setLanguage(parseCode(json.getJSONObject("language")));
    if (json.has("data"))
      res.setData(parseBase64Binary(json.getJSONObject("data")));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("size"))
      res.setSize(parseInteger(json.getJSONObject("size")));
    if (json.has("hash"))
      res.setHash(parseBase64Binary(json.getJSONObject("hash")));
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    return res;
  }

  private Ratio parseRatio(JSONObject json) throws Exception {
    Ratio res = new Ratio();
    parseTypeProperties(json, res);
    if (json.has("numerator"))
      res.setNumerator(parseQuantity(json.getJSONObject("numerator")));
    if (json.has("denominator"))
      res.setDenominator(parseQuantity(json.getJSONObject("denominator")));
    return res;
  }

  private ResourceReference parseResourceReference(JSONObject json) throws Exception {
    ResourceReference res = new ResourceReference();
    parseTypeProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    return res;
  }

  private CodeableConcept parseCodeableConcept(JSONObject json) throws Exception {
    CodeableConcept res = new CodeableConcept();
    parseTypeProperties(json, res);
    if (json.has("coding")) {
      JSONArray array = json.getJSONArray("coding");
      for (int i = 0; i < array.length(); i++) {
        res.getCoding().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("text"))
      res.setText(parseString(json.getJSONObject("text")));
    if (json.has("primary"))
      res.setPrimary(parseString(json.getJSONObject("primary")));
    return res;
  }

  private Identifier parseIdentifier(JSONObject json) throws Exception {
    Identifier res = new Identifier();
    parseTypeProperties(json, res);
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), Identifier.IdentifierUse.Null, new Identifier().new IdentifierUseEnumFactory()));
    if (json.has("label"))
      res.setLabel(parseString(json.getJSONObject("label")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("id"))
      res.setId(parseString(json.getJSONObject("id")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("assigner"))
      res.setAssigner(parseResourceReference(json.getJSONObject("assigner")));
    return res;
  }

  private Age parseAge(JSONObject json) throws Exception {
    Age res = new Age();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Count parseCount(JSONObject json) throws Exception {
    Count res = new Count();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Money parseMoney(JSONObject json) throws Exception {
    Money res = new Money();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Distance parseDistance(JSONObject json) throws Exception {
    Distance res = new Distance();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Duration parseDuration(JSONObject json) throws Exception {
    Duration res = new Duration();
    parseElementProperties(json, res);
    if (json.has("value"))
      res.setValue(parseDecimal(json.getJSONObject("value")));
    if (json.has("comparator"))
      res.setComparator(parseEnumeration(json.getJSONObject("comparator"), Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
    if (json.has("units"))
      res.setUnits(parseString(json.getJSONObject("units")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    return res;
  }

  private Schedule parseSchedule(JSONObject json) throws Exception {
    Schedule res = new Schedule();
    parseElementProperties(json, res);
    if (json.has("event")) {
      JSONArray array = json.getJSONArray("event");
      for (int i = 0; i < array.length(); i++) {
        res.getEvent().add(parsePeriod(array.getJSONObject(i)));
      }
    };
    if (json.has("repeat"))
      res.setRepeat(parseScheduleRepeat(json.getJSONObject("repeat"), res));
    return res;
  }

  private Schedule.Repeat parseScheduleRepeat(JSONObject json, Schedule owner) throws Exception {
    Schedule.Repeat res = owner.new Repeat();
    parseElementProperties(json, res);
    if (json.has("frequency"))
      res.setFrequency(parseInteger(json.getJSONObject("frequency")));
    if (json.has("when"))
      res.setWhen(parseEnumeration(json.getJSONObject("when"), Schedule.EventTiming.Null, new Schedule().new EventTimingEnumFactory()));
    if (json.has("duration"))
      res.setDuration(parseDecimal(json.getJSONObject("duration")));
    if (json.has("units"))
      res.setUnits(parseEnumeration(json.getJSONObject("units"), Schedule.UnitsOfTime.Null, new Schedule().new UnitsOfTimeEnumFactory()));
    if (json.has("count"))
      res.setCount(parseInteger(json.getJSONObject("count")));
    if (json.has("end"))
      res.setEnd(parseDateTime(json.getJSONObject("end")));
    return res;
  }

  private Contact parseContact(JSONObject json) throws Exception {
    Contact res = new Contact();
    parseElementProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseEnumeration(json.getJSONObject("system"), Contact.ContactSystem.Null, new Contact().new ContactSystemEnumFactory()));
    if (json.has("value"))
      res.setValue(parseString(json.getJSONObject("value")));
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), Contact.ContactUse.Null, new Contact().new ContactUseEnumFactory()));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private Address parseAddress(JSONObject json) throws Exception {
    Address res = new Address();
    parseElementProperties(json, res);
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), Address.AddressUse.Null, new Address().new AddressUseEnumFactory()));
    if (json.has("text"))
      res.setText(parseString(json.getJSONObject("text")));
    if (json.has("line")) {
      JSONArray array = json.getJSONArray("line");
      for (int i = 0; i < array.length(); i++) {
        res.getLine().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("city"))
      res.setCity(parseString(json.getJSONObject("city")));
    if (json.has("state"))
      res.setState(parseString(json.getJSONObject("state")));
    if (json.has("zip"))
      res.setZip(parseString(json.getJSONObject("zip")));
    if (json.has("country"))
      res.setCountry(parseString(json.getJSONObject("country")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private HumanName parseHumanName(JSONObject json) throws Exception {
    HumanName res = new HumanName();
    parseElementProperties(json, res);
    if (json.has("use"))
      res.setUse(parseEnumeration(json.getJSONObject("use"), HumanName.NameUse.Null, new HumanName().new NameUseEnumFactory()));
    if (json.has("text"))
      res.setText(parseString(json.getJSONObject("text")));
    if (json.has("family")) {
      JSONArray array = json.getJSONArray("family");
      for (int i = 0; i < array.length(); i++) {
        res.getFamily().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("given")) {
      JSONArray array = json.getJSONArray("given");
      for (int i = 0; i < array.length(); i++) {
        res.getGiven().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("prefix")) {
      JSONArray array = json.getJSONArray("prefix");
      for (int i = 0; i < array.length(); i++) {
        res.getPrefix().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("suffix")) {
      JSONArray array = json.getJSONArray("suffix");
      for (int i = 0; i < array.length(); i++) {
        res.getSuffix().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private DocumentInformation parseDocumentInformation(JSONObject json) throws Exception {
    DocumentInformation res = new DocumentInformation();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseIdentifier(json.getJSONObject("id")));
    if (json.has("versionId"))
      res.setVersionId(parseIdentifier(json.getJSONObject("versionId")));
    if (json.has("created"))
      res.setCreated(parseInstant(json.getJSONObject("created")));
    if (json.has("class"))
      res.setClass_(parseCoding(json.getJSONObject("class")));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    if (json.has("confidentiality"))
      res.setConfidentiality(parseCoding(json.getJSONObject("confidentiality")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("author")) {
      JSONArray array = json.getJSONArray("author");
      for (int i = 0; i < array.length(); i++) {
        res.getAuthor().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("attester")) {
      JSONArray array = json.getJSONArray("attester");
      for (int i = 0; i < array.length(); i++) {
        res.getAttester().add(parseDocumentInformationAttester(array.getJSONObject(i), res));
      }
    };
    if (json.has("custodian"))
      res.setCustodian(parseResourceReference(json.getJSONObject("custodian")));
    if (json.has("event"))
      res.setEvent(parseDocumentInformationEvent(json.getJSONObject("event"), res));
    if (json.has("encounter"))
      res.setEncounter(parseResourceReference(json.getJSONObject("encounter")));
    if (json.has("facilityType"))
      res.setFacilityType(parseCodeableConcept(json.getJSONObject("facilityType")));
    if (json.has("practiceSetting"))
      res.setPracticeSetting(parseCodeableConcept(json.getJSONObject("practiceSetting")));
    return res;
  }

  private DocumentInformation.Attester parseDocumentInformationAttester(JSONObject json, DocumentInformation owner) throws Exception {
    DocumentInformation.Attester res = owner.new Attester();
    parseElementProperties(json, res);
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), DocumentInformation.DocumentAttestationMode.Null, new DocumentInformation().new DocumentAttestationModeEnumFactory()));
    if (json.has("time"))
      res.setTime(parseDateTime(json.getJSONObject("time")));
    if (json.has("party"))
      res.setParty(parseResourceReference(json.getJSONObject("party")));
    return res;
  }

  private DocumentInformation.Event parseDocumentInformationEvent(JSONObject json, DocumentInformation owner) throws Exception {
    DocumentInformation.Event res = owner.new Event();
    parseElementProperties(json, res);
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("detail")) {
      JSONArray array = json.getJSONArray("detail");
      for (int i = 0; i < array.length(); i++) {
        res.getDetail().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Demographics parseDemographics(JSONObject json) throws Exception {
    Demographics res = new Demographics();
    parseElementProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("name")) {
      JSONArray array = json.getJSONArray("name");
      for (int i = 0; i < array.length(); i++) {
        res.getName().add(parseHumanName(array.getJSONObject(i)));
      }
    };
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("gender"))
      res.setGender(parseCoding(json.getJSONObject("gender")));
    if (json.has("birthDate"))
      res.setBirthDate(parseDateTime(json.getJSONObject("birthDate")));
    if (json.has("deceased"))
      res.setDeceased(parseBoolean(json.getJSONObject("deceased")));
    if (json.has("address")) {
      JSONArray array = json.getJSONArray("address");
      for (int i = 0; i < array.length(); i++) {
        res.getAddress().add(parseAddress(array.getJSONObject(i)));
      }
    };
    if (json.has("photo")) {
      JSONArray array = json.getJSONArray("photo");
      for (int i = 0; i < array.length(); i++) {
        res.getPhoto().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("maritalStatus"))
      res.setMaritalStatus(parseCodeableConcept(json.getJSONObject("maritalStatus")));
    if (json.has("language")) {
      JSONArray array = json.getJSONArray("language");
      for (int i = 0; i < array.length(); i++) {
        res.getLanguage().add(parseDemographicsLanguage(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Demographics.Language parseDemographicsLanguage(JSONObject json, Demographics owner) throws Exception {
    Demographics.Language res = owner.new Language();
    parseElementProperties(json, res);
    if (json.has("language"))
      res.setLanguage(parseCodeableConcept(json.getJSONObject("language")));
    if (json.has("mode"))
      res.setMode(parseCodeableConcept(json.getJSONObject("mode")));
    if (json.has("proficiencyLevel"))
      res.setProficiencyLevel(parseCodeableConcept(json.getJSONObject("proficiencyLevel")));
    if (json.has("preference"))
      res.setPreference(parseBoolean(json.getJSONObject("preference")));
    return res;
  }

  protected void parseResourceProperties(JSONObject json, Resource res) throws Exception {
    parseElementProperties(json, res); 
    if (json.has("language"))
      res.setLanguage(parseCode(json.getJSONObject("language")));
    if (json.has("text"))
      res.setText(parseNarrative(json.getJSONObject("text")));
    if (json.has("contained")) {
      JSONArray array = json.getJSONArray("contained");
      for (int i = 0; i < array.length(); i++) {
        res.getContained().add(parseResource(array.getJSONObject(i)));
      }
    };
  }

  private CarePlan parseCarePlan(JSONObject json) throws Exception {
    CarePlan res = new CarePlan();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), CarePlan.CarePlanStatus.Null, new CarePlan().new CarePlanStatusEnumFactory()));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("modified"))
      res.setModified(parseDateTime(json.getJSONObject("modified")));
    if (json.has("concern")) {
      JSONArray array = json.getJSONArray("concern");
      for (int i = 0; i < array.length(); i++) {
        res.getConcern().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("participant")) {
      JSONArray array = json.getJSONArray("participant");
      for (int i = 0; i < array.length(); i++) {
        res.getParticipant().add(parseCarePlanParticipant(array.getJSONObject(i), res));
      }
    };
    if (json.has("goal")) {
      JSONArray array = json.getJSONArray("goal");
      for (int i = 0; i < array.length(); i++) {
        res.getGoal().add(parseCarePlanGoal(array.getJSONObject(i), res));
      }
    };
    if (json.has("activity")) {
      JSONArray array = json.getJSONArray("activity");
      for (int i = 0; i < array.length(); i++) {
        res.getActivity().add(parseCarePlanActivity(array.getJSONObject(i), res));
      }
    };
    if (json.has("notes"))
      res.setNotes(parseString(json.getJSONObject("notes")));
    return res;
  }

  private CarePlan.Participant parseCarePlanParticipant(JSONObject json, CarePlan owner) throws Exception {
    CarePlan.Participant res = owner.new Participant();
    parseElementProperties(json, res);
    if (json.has("role"))
      res.setRole(parseCodeableConcept(json.getJSONObject("role")));
    if (json.has("member"))
      res.setMember(parseResourceReference(json.getJSONObject("member")));
    return res;
  }

  private CarePlan.Goal parseCarePlanGoal(JSONObject json, CarePlan owner) throws Exception {
    CarePlan.Goal res = owner.new Goal();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), CarePlan.CarePlanGoalStatus.Null, new CarePlan().new CarePlanGoalStatusEnumFactory()));
    if (json.has("notes"))
      res.setNotes(parseString(json.getJSONObject("notes")));
    return res;
  }

  private CarePlan.Activity parseCarePlanActivity(JSONObject json, CarePlan owner) throws Exception {
    CarePlan.Activity res = owner.new Activity();
    parseElementProperties(json, res);
    if (json.has("category"))
      res.setCategory(parseEnumeration(json.getJSONObject("category"), CarePlan.CarePlanActivityCategory.Null, new CarePlan().new CarePlanActivityCategoryEnumFactory()));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), CarePlan.CarePlanActivityStatus.Null, new CarePlan().new CarePlanActivityStatusEnumFactory()));
    if (json.has("prohibited"))
      res.setProhibited(parseBoolean(json.getJSONObject("prohibited")));
    Type timing = parseType("timing", json);
    if (timing != null)
      res.setTiming(timing);
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("performer")) {
      JSONArray array = json.getJSONArray("performer");
      for (int i = 0; i < array.length(); i++) {
        res.getPerformer().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("product"))
      res.setProduct(parseResourceReference(json.getJSONObject("product")));
    if (json.has("dailyAmount"))
      res.setDailyAmount(parseQuantity(json.getJSONObject("dailyAmount")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("details"))
      res.setDetails(parseString(json.getJSONObject("details")));
    if (json.has("actionTaken")) {
      JSONArray array = json.getJSONArray("actionTaken");
      for (int i = 0; i < array.length(); i++) {
        res.getActionTaken().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("notes"))
      res.setNotes(parseString(json.getJSONObject("notes")));
    return res;
  }

  private Provenance parseProvenance(JSONObject json) throws Exception {
    Provenance res = new Provenance();
    parseResourceProperties(json, res);
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    if (json.has("activity"))
      res.setActivity(parseProvenanceActivity(json.getJSONObject("activity"), res));
    if (json.has("party")) {
      JSONArray array = json.getJSONArray("party");
      for (int i = 0; i < array.length(); i++) {
        res.getParty().add(parseProvenanceParty(array.getJSONObject(i), res));
      }
    };
    if (json.has("signature"))
      res.setSignature(parseString(json.getJSONObject("signature")));
    return res;
  }

  private Provenance.Activity parseProvenanceActivity(JSONObject json, Provenance owner) throws Exception {
    Provenance.Activity res = owner.new Activity();
    parseElementProperties(json, res);
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("recorded"))
      res.setRecorded(parseInstant(json.getJSONObject("recorded")));
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    if (json.has("location"))
      res.setLocation(parseProvenanceLocation(json.getJSONObject("location"), owner));
    if (json.has("policy"))
      res.setPolicy(parseUri(json.getJSONObject("policy")));
    return res;
  }

  private Provenance.Location parseProvenanceLocation(JSONObject json, Provenance owner) throws Exception {
    Provenance.Location res = owner.new Location();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("id"))
      res.setId(parseIdentifier(json.getJSONObject("id")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("coords"))
      res.setCoords(parseString(json.getJSONObject("coords")));
    return res;
  }

  private Provenance.Party parseProvenanceParty(JSONObject json, Provenance owner) throws Exception {
    Provenance.Party res = owner.new Party();
    parseElementProperties(json, res);
    if (json.has("role"))
      res.setRole(parseCoding(json.getJSONObject("role")));
    if (json.has("type"))
      res.setType(parseCoding(json.getJSONObject("type")));
    if (json.has("id"))
      res.setId(parseUri(json.getJSONObject("id")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    return res;
  }

  private Device parseDevice(JSONObject json) throws Exception {
    Device res = new Device();
    parseResourceProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("manufacturer"))
      res.setManufacturer(parseString(json.getJSONObject("manufacturer")));
    if (json.has("model"))
      res.setModel(parseString(json.getJSONObject("model")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("identity"))
      res.setIdentity(parseDeviceIdentity(json.getJSONObject("identity"), res));
    if (json.has("owner"))
      res.setOwner(parseResourceReference(json.getJSONObject("owner")));
    if (json.has("assignedId")) {
      JSONArray array = json.getJSONArray("assignedId");
      for (int i = 0; i < array.length(); i++) {
        res.getAssignedId().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("location"))
      res.setLocation(parseResourceReference(json.getJSONObject("location")));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("contact")) {
      JSONArray array = json.getJSONArray("contact");
      for (int i = 0; i < array.length(); i++) {
        res.getContact().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    return res;
  }

  private Device.Identity parseDeviceIdentity(JSONObject json, Device owner) throws Exception {
    Device.Identity res = owner.new Identity();
    parseElementProperties(json, res);
    if (json.has("gtin"))
      res.setGtin(parseString(json.getJSONObject("gtin")));
    if (json.has("lot"))
      res.setLot(parseString(json.getJSONObject("lot")));
    if (json.has("serialNumber"))
      res.setSerialNumber(parseString(json.getJSONObject("serialNumber")));
    if (json.has("expiry"))
      res.setExpiry(parseDate(json.getJSONObject("expiry")));
    return res;
  }

  private Order parseOrder(JSONObject json) throws Exception {
    Order res = new Order();
    parseResourceProperties(json, res);
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("source"))
      res.setSource(parseResourceReference(json.getJSONObject("source")));
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    if (json.has("reason"))
      res.setReason(parseString(json.getJSONObject("reason")));
    if (json.has("authority"))
      res.setAuthority(parseResourceReference(json.getJSONObject("authority")));
    if (json.has("payment"))
      res.setPayment(parseResourceReference(json.getJSONObject("payment")));
    if (json.has("when"))
      res.setWhen(parseOrderWhen(json.getJSONObject("when"), res));
    if (json.has("detail")) {
      JSONArray array = json.getJSONArray("detail");
      for (int i = 0; i < array.length(); i++) {
        res.getDetail().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Order.When parseOrderWhen(JSONObject json, Order owner) throws Exception {
    Order.When res = owner.new When();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("schedule"))
      res.setSchedule(parseSchedule(json.getJSONObject("schedule")));
    return res;
  }

  private Organization parseOrganization(JSONObject json) throws Exception {
    Organization res = new Organization();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("name")) {
      JSONArray array = json.getJSONArray("name");
      for (int i = 0; i < array.length(); i++) {
        res.getName().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("address")) {
      JSONArray array = json.getJSONArray("address");
      for (int i = 0; i < array.length(); i++) {
        res.getAddress().add(parseAddress(array.getJSONObject(i)));
      }
    };
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Organization.RecordStatus.Null, new Organization().new RecordStatusEnumFactory()));
    if (json.has("accreditation")) {
      JSONArray array = json.getJSONArray("accreditation");
      for (int i = 0; i < array.length(); i++) {
        res.getAccreditation().add(parseOrganizationAccreditation(array.getJSONObject(i), res));
      }
    };
    if (json.has("relatedOrganization")) {
      JSONArray array = json.getJSONArray("relatedOrganization");
      for (int i = 0; i < array.length(); i++) {
        res.getRelatedOrganization().add(parseOrganizationRelatedOrganization(array.getJSONObject(i), res));
      }
    };
    if (json.has("contactPerson")) {
      JSONArray array = json.getJSONArray("contactPerson");
      for (int i = 0; i < array.length(); i++) {
        res.getContactPerson().add(parseOrganizationContactPerson(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Organization.Accreditation parseOrganizationAccreditation(JSONObject json, Organization owner) throws Exception {
    Organization.Accreditation res = owner.new Accreditation();
    parseElementProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("issuer"))
      res.setIssuer(parseResourceReference(json.getJSONObject("issuer")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private Organization.RelatedOrganization parseOrganizationRelatedOrganization(JSONObject json, Organization owner) throws Exception {
    Organization.RelatedOrganization res = owner.new RelatedOrganization();
    parseElementProperties(json, res);
    if (json.has("organization"))
      res.setOrganization(parseResourceReference(json.getJSONObject("organization")));
    if (json.has("relation"))
      res.setRelation(parseCodeableConcept(json.getJSONObject("relation")));
    return res;
  }

  private Organization.ContactPerson parseOrganizationContactPerson(JSONObject json, Organization owner) throws Exception {
    Organization.ContactPerson res = owner.new ContactPerson();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("details"))
      res.setDetails(parseDemographics(json.getJSONObject("details")));
    return res;
  }

  private Prescription parsePrescription(JSONObject json) throws Exception {
    Prescription res = new Prescription();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Prescription.PrescriptionStatus.Null, new Prescription().new PrescriptionStatusEnumFactory()));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("prescriber"))
      res.setPrescriber(parseResourceReference(json.getJSONObject("prescriber")));
    if (json.has("prescribed"))
      res.setPrescribed(parseDateTime(json.getJSONObject("prescribed")));
    if (json.has("dispense"))
      res.setDispense(parsePrescriptionDispense(json.getJSONObject("dispense"), res));
    if (json.has("medicine"))
      res.setMedicine(parsePrescriptionMedicine(json.getJSONObject("medicine"), res));
    if (json.has("administrationRequest"))
      res.setAdministrationRequest(parsePrescriptionAdministrationRequest(json.getJSONObject("administrationRequest"), res));
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    return res;
  }

  private Prescription.Dispense parsePrescriptionDispense(JSONObject json, Prescription owner) throws Exception {
    Prescription.Dispense res = owner.new Dispense();
    parseElementProperties(json, res);
    if (json.has("repeats"))
      res.setRepeats(parseInteger(json.getJSONObject("repeats")));
    if (json.has("quantity"))
      res.setQuantity(parseQuantity(json.getJSONObject("quantity")));
    if (json.has("dispenser"))
      res.setDispenser(parseResourceReference(json.getJSONObject("dispenser")));
    return res;
  }

  private Prescription.Medicine parsePrescriptionMedicine(JSONObject json, Prescription owner) throws Exception {
    Prescription.Medicine res = owner.new Medicine();
    parseElementProperties(json, res);
    if (json.has("identification"))
      res.setIdentification(parseCodeableConcept(json.getJSONObject("identification")));
    if (json.has("activeIngredient")) {
      JSONArray array = json.getJSONArray("activeIngredient");
      for (int i = 0; i < array.length(); i++) {
        res.getActiveIngredient().add(parsePrescriptionActiveIngredient(array.getJSONObject(i), owner));
      }
    };
    if (json.has("inactiveIngredient")) {
      JSONArray array = json.getJSONArray("inactiveIngredient");
      for (int i = 0; i < array.length(); i++) {
        res.getInactiveIngredient().add(parsePrescriptionInactiveIngredient(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Prescription.ActiveIngredient parsePrescriptionActiveIngredient(JSONObject json, Prescription owner) throws Exception {
    Prescription.ActiveIngredient res = owner.new ActiveIngredient();
    parseElementProperties(json, res);
    if (json.has("identification"))
      res.setIdentification(parseCodeableConcept(json.getJSONObject("identification")));
    Type quantity = parseType("quantity", json);
    if (quantity != null)
      res.setQuantity(quantity);
    return res;
  }

  private Prescription.InactiveIngredient parsePrescriptionInactiveIngredient(JSONObject json, Prescription owner) throws Exception {
    Prescription.InactiveIngredient res = owner.new InactiveIngredient();
    parseElementProperties(json, res);
    if (json.has("identification"))
      res.setIdentification(parseCodeableConcept(json.getJSONObject("identification")));
    Type quantity = parseType("quantity", json);
    if (quantity != null)
      res.setQuantity(quantity);
    return res;
  }

  private Prescription.AdministrationRequest parsePrescriptionAdministrationRequest(JSONObject json, Prescription owner) throws Exception {
    Prescription.AdministrationRequest res = owner.new AdministrationRequest();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("totalPeriodicDose"))
      res.setTotalPeriodicDose(parseRatio(json.getJSONObject("totalPeriodicDose")));
    if (json.has("start"))
      res.setStart(parseDateTime(json.getJSONObject("start")));
    if (json.has("end"))
      res.setEnd(parseDateTime(json.getJSONObject("end")));
    if (json.has("duration"))
      res.setDuration(parseQuantity(json.getJSONObject("duration")));
    if (json.has("numberOfAdministrations"))
      res.setNumberOfAdministrations(parseInteger(json.getJSONObject("numberOfAdministrations")));
    if (json.has("dosageInstruction")) {
      JSONArray array = json.getJSONArray("dosageInstruction");
      for (int i = 0; i < array.length(); i++) {
        res.getDosageInstruction().add(parsePrescriptionDosageInstruction(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Prescription.DosageInstruction parsePrescriptionDosageInstruction(JSONObject json, Prescription owner) throws Exception {
    Prescription.DosageInstruction res = owner.new DosageInstruction();
    parseElementProperties(json, res);
    if (json.has("precondition")) {
      JSONArray array = json.getJSONArray("precondition");
      for (int i = 0; i < array.length(); i++) {
        res.getPrecondition().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("prn"))
      res.setPrn(parseBoolean(json.getJSONObject("prn")));
    if (json.has("additionalInstruction")) {
      JSONArray array = json.getJSONArray("additionalInstruction");
      for (int i = 0; i < array.length(); i++) {
        res.getAdditionalInstruction().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    Type dose = parseType("dose", json);
    if (dose != null)
      res.setDose(dose);
    if (json.has("rate"))
      res.setRate(parseQuantity(json.getJSONObject("rate")));
    if (json.has("schedule")) {
      JSONArray array = json.getJSONArray("schedule");
      for (int i = 0; i < array.length(); i++) {
        res.getSchedule().add(parseSchedule(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Group parseGroup(JSONObject json) throws Exception {
    Group res = new Group();
    parseResourceProperties(json, res);
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Group.GroupType.Null, new Group().new GroupTypeEnumFactory()));
    if (json.has("actual"))
      res.setActual(parseBoolean(json.getJSONObject("actual")));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("quantity"))
      res.setQuantity(parseInteger(json.getJSONObject("quantity")));
    if (json.has("characteristic")) {
      JSONArray array = json.getJSONArray("characteristic");
      for (int i = 0; i < array.length(); i++) {
        res.getCharacteristic().add(parseGroupCharacteristic(array.getJSONObject(i), res));
      }
    };
    if (json.has("member")) {
      JSONArray array = json.getJSONArray("member");
      for (int i = 0; i < array.length(); i++) {
        res.getMember().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Group.Characteristic parseGroupCharacteristic(JSONObject json, Group owner) throws Exception {
    Group.Characteristic res = owner.new Characteristic();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("exclude"))
      res.setExclude(parseBoolean(json.getJSONObject("exclude")));
    return res;
  }

  private DiagnosticReport parseDiagnosticReport(JSONObject json) throws Exception {
    DiagnosticReport res = new DiagnosticReport();
    parseResourceProperties(json, res);
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), DiagnosticReport.ObservationStatus.Null, new DiagnosticReport().new ObservationStatusEnumFactory()));
    if (json.has("issued"))
      res.setIssued(parseInstant(json.getJSONObject("issued")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("performer"))
      res.setPerformer(parseResourceReference(json.getJSONObject("performer")));
    if (json.has("reportId"))
      res.setReportId(parseIdentifier(json.getJSONObject("reportId")));
    if (json.has("requestDetail")) {
      JSONArray array = json.getJSONArray("requestDetail");
      for (int i = 0; i < array.length(); i++) {
        res.getRequestDetail().add(parseDiagnosticReportRequestDetail(array.getJSONObject(i), res));
      }
    };
    if (json.has("serviceCategory"))
      res.setServiceCategory(parseCodeableConcept(json.getJSONObject("serviceCategory")));
    if (json.has("diagnosticTime"))
      res.setDiagnosticTime(parseDateTime(json.getJSONObject("diagnosticTime")));
    if (json.has("results"))
      res.setResults(parseDiagnosticReportResults(json.getJSONObject("results"), res));
    if (json.has("image")) {
      JSONArray array = json.getJSONArray("image");
      for (int i = 0; i < array.length(); i++) {
        res.getImage().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("conclusion"))
      res.setConclusion(parseString(json.getJSONObject("conclusion")));
    if (json.has("codedDiagnosis")) {
      JSONArray array = json.getJSONArray("codedDiagnosis");
      for (int i = 0; i < array.length(); i++) {
        res.getCodedDiagnosis().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("representation")) {
      JSONArray array = json.getJSONArray("representation");
      for (int i = 0; i < array.length(); i++) {
        res.getRepresentation().add(parseAttachment(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private DiagnosticReport.RequestDetail parseDiagnosticReportRequestDetail(JSONObject json, DiagnosticReport owner) throws Exception {
    DiagnosticReport.RequestDetail res = owner.new RequestDetail();
    parseElementProperties(json, res);
    if (json.has("encounter"))
      res.setEncounter(parseResourceReference(json.getJSONObject("encounter")));
    if (json.has("requestOrderId"))
      res.setRequestOrderId(parseIdentifier(json.getJSONObject("requestOrderId")));
    if (json.has("receiverOrderId"))
      res.setReceiverOrderId(parseIdentifier(json.getJSONObject("receiverOrderId")));
    if (json.has("requestTest")) {
      JSONArray array = json.getJSONArray("requestTest");
      for (int i = 0; i < array.length(); i++) {
        res.getRequestTest().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("bodySite"))
      res.setBodySite(parseCodeableConcept(json.getJSONObject("bodySite")));
    if (json.has("requester"))
      res.setRequester(parseResourceReference(json.getJSONObject("requester")));
    if (json.has("clinicalInfo"))
      res.setClinicalInfo(parseString(json.getJSONObject("clinicalInfo")));
    return res;
  }

  private DiagnosticReport.Results parseDiagnosticReportResults(JSONObject json, DiagnosticReport owner) throws Exception {
    DiagnosticReport.Results res = owner.new Results();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    if (json.has("specimen"))
      res.setSpecimen(parseResourceReference(json.getJSONObject("specimen")));
    if (json.has("group")) {
      JSONArray array = json.getJSONArray("group");
      for (int i = 0; i < array.length(); i++) {
        res.getGroup().add(parseDiagnosticReportResults(array.getJSONObject(i), owner));
      }
    };
    if (json.has("result")) {
      JSONArray array = json.getJSONArray("result");
      for (int i = 0; i < array.length(); i++) {
        res.getResult().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private ValueSet parseValueSet(JSONObject json) throws Exception {
    ValueSet res = new ValueSet();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("author")) {
      JSONArray array = json.getJSONArray("author");
      for (int i = 0; i < array.length(); i++) {
        res.getAuthor().add(parseValueSetAuthor(array.getJSONObject(i), res));
      }
    };
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), ValueSet.ValuesetStatus.Null, new ValueSet().new ValuesetStatusEnumFactory()));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("identifier"))
      res.setIdentifier(parseString(json.getJSONObject("identifier")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("restricts")) {
      JSONArray array = json.getJSONArray("restricts");
      for (int i = 0; i < array.length(); i++) {
        res.getRestricts().add(parseUri(array.getJSONObject(i)));
      }
    };
    if (json.has("import")) {
      JSONArray array = json.getJSONArray("import");
      for (int i = 0; i < array.length(); i++) {
        res.getImport().add(parseUri(array.getJSONObject(i)));
      }
    };
    if (json.has("include")) {
      JSONArray array = json.getJSONArray("include");
      for (int i = 0; i < array.length(); i++) {
        res.getInclude().add(parseValueSetInclude(array.getJSONObject(i), res));
      }
    };
    if (json.has("exclude")) {
      JSONArray array = json.getJSONArray("exclude");
      for (int i = 0; i < array.length(); i++) {
        res.getExclude().add(parseValueSetInclude(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private ValueSet.Author parseValueSetAuthor(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.Author res = owner.new Author();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("role"))
      res.setRole(parseString(json.getJSONObject("role")));
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private ValueSet.Include parseValueSetInclude(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.Include res = owner.new Include();
    parseElementProperties(json, res);
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), ValueSet.CodeSelectionMode.Null, new ValueSet().new CodeSelectionModeEnumFactory()));
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCode(array.getJSONObject(i)));
      }
    };
    if (json.has("filter")) {
      JSONArray array = json.getJSONArray("filter");
      for (int i = 0; i < array.length(); i++) {
        res.getFilter().add(parseValueSetFilter(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ValueSet.Filter parseValueSetFilter(JSONObject json, ValueSet owner) throws Exception {
    ValueSet.Filter res = owner.new Filter();
    parseElementProperties(json, res);
    if (json.has("property"))
      res.setProperty(parseCode(json.getJSONObject("property")));
    if (json.has("op"))
      res.setOp(parseEnumeration(json.getJSONObject("op"), ValueSet.FilterOperator.Null, new ValueSet().new FilterOperatorEnumFactory()));
    if (json.has("value"))
      res.setValue(parseCode(json.getJSONObject("value")));
    return res;
  }

  private Coverage parseCoverage(JSONObject json) throws Exception {
    Coverage res = new Coverage();
    parseResourceProperties(json, res);
    if (json.has("issuer"))
      res.setIssuer(parseResourceReference(json.getJSONObject("issuer")));
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    if (json.has("type"))
      res.setType(parseCoding(json.getJSONObject("type")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("plan"))
      res.setPlan(parseIdentifier(json.getJSONObject("plan")));
    if (json.has("subplan"))
      res.setSubplan(parseIdentifier(json.getJSONObject("subplan")));
    if (json.has("dependent"))
      res.setDependent(parseInteger(json.getJSONObject("dependent")));
    if (json.has("sequence"))
      res.setSequence(parseInteger(json.getJSONObject("sequence")));
    if (json.has("planHolder"))
      res.setPlanHolder(parseCoveragePlanHolder(json.getJSONObject("planHolder"), res));
    return res;
  }

  private Coverage.PlanHolder parseCoveragePlanHolder(JSONObject json, Coverage owner) throws Exception {
    Coverage.PlanHolder res = owner.new PlanHolder();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseHumanName(json.getJSONObject("name")));
    if (json.has("address"))
      res.setAddress(parseAddress(json.getJSONObject("address")));
    if (json.has("birthdate"))
      res.setBirthdate(parseDate(json.getJSONObject("birthdate")));
    return res;
  }

  private Test parseTest(JSONObject json) throws Exception {
    Test res = new Test();
    parseResourceProperties(json, res);
    if (json.has("stringErr")) {
      JSONArray array = json.getJSONArray("stringErr");
      for (int i = 0; i < array.length(); i++) {
        res.getStringErr().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("stringCorr")) {
      JSONArray array = json.getJSONArray("stringCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getStringCorr().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("booleanErr")) {
      JSONArray array = json.getJSONArray("booleanErr");
      for (int i = 0; i < array.length(); i++) {
        res.getBooleanErr().add(parseBoolean(array.getJSONObject(i)));
      }
    };
    if (json.has("booleanCorr")) {
      JSONArray array = json.getJSONArray("booleanCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getBooleanCorr().add(parseBoolean(array.getJSONObject(i)));
      }
    };
    if (json.has("integerErr")) {
      JSONArray array = json.getJSONArray("integerErr");
      for (int i = 0; i < array.length(); i++) {
        res.getIntegerErr().add(parseInteger(array.getJSONObject(i)));
      }
    };
    if (json.has("integerCorr")) {
      JSONArray array = json.getJSONArray("integerCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getIntegerCorr().add(parseInteger(array.getJSONObject(i)));
      }
    };
    if (json.has("decimalErr")) {
      JSONArray array = json.getJSONArray("decimalErr");
      for (int i = 0; i < array.length(); i++) {
        res.getDecimalErr().add(parseDecimal(array.getJSONObject(i)));
      }
    };
    if (json.has("decimalCorr")) {
      JSONArray array = json.getJSONArray("decimalCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getDecimalCorr().add(parseDecimal(array.getJSONObject(i)));
      }
    };
    if (json.has("b64Err")) {
      JSONArray array = json.getJSONArray("b64Err");
      for (int i = 0; i < array.length(); i++) {
        res.getB64Err().add(parseBase64Binary(array.getJSONObject(i)));
      }
    };
    if (json.has("b64Corr")) {
      JSONArray array = json.getJSONArray("b64Corr");
      for (int i = 0; i < array.length(); i++) {
        res.getB64Corr().add(parseBase64Binary(array.getJSONObject(i)));
      }
    };
    if (json.has("instantErr")) {
      JSONArray array = json.getJSONArray("instantErr");
      for (int i = 0; i < array.length(); i++) {
        res.getInstantErr().add(parseInstant(array.getJSONObject(i)));
      }
    };
    if (json.has("instantCorr")) {
      JSONArray array = json.getJSONArray("instantCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getInstantCorr().add(parseInstant(array.getJSONObject(i)));
      }
    };
    if (json.has("uriErr")) {
      JSONArray array = json.getJSONArray("uriErr");
      for (int i = 0; i < array.length(); i++) {
        res.getUriErr().add(parseUri(array.getJSONObject(i)));
      }
    };
    if (json.has("uriCorr")) {
      JSONArray array = json.getJSONArray("uriCorr");
      for (int i = 0; i < array.length(); i++) {
        res.getUriCorr().add(parseUri(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private MedicationAdministration parseMedicationAdministration(JSONObject json) throws Exception {
    MedicationAdministration res = new MedicationAdministration();
    parseResourceProperties(json, res);
    if (json.has("administrationEventStatus"))
      res.setAdministrationEventStatus(parseEnumeration(json.getJSONObject("administrationEventStatus"), MedicationAdministration.MedAdmStatus.Null, new MedicationAdministration().new MedAdmStatusEnumFactory()));
    if (json.has("isNegated"))
      res.setIsNegated(parseBoolean(json.getJSONObject("isNegated")));
    if (json.has("negatedReason")) {
      JSONArray array = json.getJSONArray("negatedReason");
      for (int i = 0; i < array.length(); i++) {
        res.getNegatedReason().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("effectiveTime"))
      res.setEffectiveTime(parsePeriod(json.getJSONObject("effectiveTime")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("approachSite"))
      res.setApproachSite(parseCodeableConcept(json.getJSONObject("approachSite")));
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    if (json.has("administeredDose"))
      res.setAdministeredDose(parseQuantity(json.getJSONObject("administeredDose")));
    if (json.has("doseRate"))
      res.setDoseRate(parseQuantity(json.getJSONObject("doseRate")));
    if (json.has("id")) {
      JSONArray array = json.getJSONArray("id");
      for (int i = 0; i < array.length(); i++) {
        res.getId().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("prescription"))
      res.setPrescription(parseResourceReference(json.getJSONObject("prescription")));
    if (json.has("patient"))
      res.setPatient(parseResourceReference(json.getJSONObject("patient")));
    if (json.has("medication")) {
      JSONArray array = json.getJSONArray("medication");
      for (int i = 0; i < array.length(); i++) {
        res.getMedication().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("encounter"))
      res.setEncounter(parseIdentifier(json.getJSONObject("encounter")));
    if (json.has("administrationDevice")) {
      JSONArray array = json.getJSONArray("administrationDevice");
      for (int i = 0; i < array.length(); i++) {
        res.getAdministrationDevice().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Encounter parseEncounter(JSONObject json) throws Exception {
    Encounter res = new Encounter();
    parseResourceProperties(json, res);
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("date"))
      res.setDate(parsePeriod(json.getJSONObject("date")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("participant")) {
      JSONArray array = json.getJSONArray("participant");
      for (int i = 0; i < array.length(); i++) {
        res.getParticipant().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private SecurityEvent parseSecurityEvent(JSONObject json) throws Exception {
    SecurityEvent res = new SecurityEvent();
    parseResourceProperties(json, res);
    if (json.has("event"))
      res.setEvent(parseSecurityEventEvent(json.getJSONObject("event"), res));
    if (json.has("participant")) {
      JSONArray array = json.getJSONArray("participant");
      for (int i = 0; i < array.length(); i++) {
        res.getParticipant().add(parseSecurityEventParticipant(array.getJSONObject(i), res));
      }
    };
    if (json.has("source"))
      res.setSource(parseSecurityEventSource(json.getJSONObject("source"), res));
    if (json.has("object")) {
      JSONArray array = json.getJSONArray("object");
      for (int i = 0; i < array.length(); i++) {
        res.getObject().add(parseSecurityEventObject(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private SecurityEvent.Event parseSecurityEventEvent(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.Event res = owner.new Event();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseCoding(json.getJSONObject("id")));
    if (json.has("action"))
      res.setAction(parseEnumeration(json.getJSONObject("action"), SecurityEvent.SecurityEventEventAction.Null, new SecurityEvent().new SecurityEventEventActionEnumFactory()));
    if (json.has("dateTime"))
      res.setDateTime(parseInstant(json.getJSONObject("dateTime")));
    if (json.has("outcome"))
      res.setOutcome(parseEnumeration(json.getJSONObject("outcome"), SecurityEvent.SecurityEventEventOutcome.Null, new SecurityEvent().new SecurityEventEventOutcomeEnumFactory()));
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCoding(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private SecurityEvent.Participant parseSecurityEventParticipant(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.Participant res = owner.new Participant();
    parseElementProperties(json, res);
    if (json.has("userId"))
      res.setUserId(parseString(json.getJSONObject("userId")));
    if (json.has("otherUserId"))
      res.setOtherUserId(parseString(json.getJSONObject("otherUserId")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("requestor"))
      res.setRequestor(parseBoolean(json.getJSONObject("requestor")));
    if (json.has("role")) {
      JSONArray array = json.getJSONArray("role");
      for (int i = 0; i < array.length(); i++) {
        res.getRole().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("mediaId"))
      res.setMediaId(parseCodeableConcept(json.getJSONObject("mediaId")));
    if (json.has("network"))
      res.setNetwork(parseSecurityEventNetwork(json.getJSONObject("network"), owner));
    return res;
  }

  private SecurityEvent.Network parseSecurityEventNetwork(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.Network res = owner.new Network();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), SecurityEvent.NetworkType.Null, new SecurityEvent().new NetworkTypeEnumFactory()));
    if (json.has("id"))
      res.setId(parseString(json.getJSONObject("id")));
    return res;
  }

  private SecurityEvent.Source parseSecurityEventSource(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.Source res = owner.new Source();
    parseElementProperties(json, res);
    if (json.has("site"))
      res.setSite(parseString(json.getJSONObject("site")));
    if (json.has("id"))
      res.setId(parseString(json.getJSONObject("id")));
    if (json.has("type")) {
      JSONArray array = json.getJSONArray("type");
      for (int i = 0; i < array.length(); i++) {
        res.getType().add(parseCoding(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private SecurityEvent.Object parseSecurityEventObject(JSONObject json, SecurityEvent owner) throws Exception {
    SecurityEvent.Object res = owner.new Object();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), SecurityEvent.ObjectType.Null, new SecurityEvent().new ObjectTypeEnumFactory()));
    if (json.has("role"))
      res.setRole(parseEnumeration(json.getJSONObject("role"), SecurityEvent.ObjectRole.Null, new SecurityEvent().new ObjectRoleEnumFactory()));
    if (json.has("lifecycle"))
      res.setLifecycle(parseEnumeration(json.getJSONObject("lifecycle"), SecurityEvent.ObjectLifecycle.Null, new SecurityEvent().new ObjectLifecycleEnumFactory()));
    if (json.has("idType"))
      res.setIdType(parseCoding(json.getJSONObject("idType")));
    if (json.has("id"))
      res.setId(parseString(json.getJSONObject("id")));
    if (json.has("sensitivity"))
      res.setSensitivity(parseString(json.getJSONObject("sensitivity")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("query"))
      res.setQuery(parseBase64Binary(json.getJSONObject("query")));
    return res;
  }

  private IssueReport parseIssueReport(JSONObject json) throws Exception {
    IssueReport res = new IssueReport();
    parseResourceProperties(json, res);
    if (json.has("issue")) {
      JSONArray array = json.getJSONArray("issue");
      for (int i = 0; i < array.length(); i++) {
        res.getIssue().add(parseIssueReportIssue(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private IssueReport.Issue parseIssueReportIssue(JSONObject json, IssueReport owner) throws Exception {
    IssueReport.Issue res = owner.new Issue();
    parseElementProperties(json, res);
    if (json.has("severity"))
      res.setSeverity(parseEnumeration(json.getJSONObject("severity"), IssueReport.IssueSeverity.Null, new IssueReport().new IssueSeverityEnumFactory()));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("details"))
      res.setDetails(parseString(json.getJSONObject("details")));
    if (json.has("location")) {
      JSONArray array = json.getJSONArray("location");
      for (int i = 0; i < array.length(); i++) {
        res.getLocation().add(parseString(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private List_ parseList_(JSONObject json) throws Exception {
    List_ res = new List_();
    parseResourceProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("source"))
      res.setSource(parseResourceReference(json.getJSONObject("source")));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("ordered"))
      res.setOrdered(parseBoolean(json.getJSONObject("ordered")));
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), List_.ListMode.Null, new List_().new ListModeEnumFactory()));
    if (json.has("entry")) {
      JSONArray array = json.getJSONArray("entry");
      for (int i = 0; i < array.length(); i++) {
        res.getEntry().add(parseList_Entry(array.getJSONObject(i), res));
      }
    };
    if (json.has("emptyReason"))
      res.setEmptyReason(parseCodeableConcept(json.getJSONObject("emptyReason")));
    return res;
  }

  private List_.Entry parseList_Entry(JSONObject json, List_ owner) throws Exception {
    List_.Entry res = owner.new Entry();
    parseElementProperties(json, res);
    if (json.has("flag")) {
      JSONArray array = json.getJSONArray("flag");
      for (int i = 0; i < array.length(); i++) {
        res.getFlag().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("deleted"))
      res.setDeleted(parseBoolean(json.getJSONObject("deleted")));
    if (json.has("item"))
      res.setItem(parseResourceReference(json.getJSONObject("item")));
    return res;
  }

  private Questionnaire parseQuestionnaire(JSONObject json) throws Exception {
    Questionnaire res = new Questionnaire();
    parseResourceProperties(json, res);
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Questionnaire.ObservationStatus.Null, new Questionnaire().new ObservationStatusEnumFactory()));
    if (json.has("authored"))
      res.setAuthored(parseInstant(json.getJSONObject("authored")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("author"))
      res.setAuthor(parseResourceReference(json.getJSONObject("author")));
    if (json.has("source"))
      res.setSource(parseResourceReference(json.getJSONObject("source")));
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("encounter"))
      res.setEncounter(parseResourceReference(json.getJSONObject("encounter")));
    if (json.has("answer")) {
      JSONArray array = json.getJSONArray("answer");
      for (int i = 0; i < array.length(); i++) {
        res.getAnswer().add(parseQuestionnaireAnswer(array.getJSONObject(i), res));
      }
    };
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseQuestionnaireSection(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Questionnaire.Answer parseQuestionnaireAnswer(JSONObject json, Questionnaire owner) throws Exception {
    Questionnaire.Answer res = owner.new Answer();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("evidence"))
      res.setEvidence(parseResourceReference(json.getJSONObject("evidence")));
    return res;
  }

  private Questionnaire.Section parseQuestionnaireSection(JSONObject json, Questionnaire owner) throws Exception {
    Questionnaire.Section res = owner.new Section();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    if (json.has("answer")) {
      JSONArray array = json.getJSONArray("answer");
      for (int i = 0; i < array.length(); i++) {
        res.getAnswer().add(parseQuestionnaireAnswer(array.getJSONObject(i), owner));
      }
    };
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseQuestionnaireSection(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Picture parsePicture(JSONObject json) throws Exception {
    Picture res = new Picture();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("dateTime"))
      res.setDateTime(parseDateTime(json.getJSONObject("dateTime")));
    if (json.has("operator"))
      res.setOperator(parseResourceReference(json.getJSONObject("operator")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("accessionNo"))
      res.setAccessionNo(parseIdentifier(json.getJSONObject("accessionNo")));
    if (json.has("studyId"))
      res.setStudyId(parseIdentifier(json.getJSONObject("studyId")));
    if (json.has("seriesId"))
      res.setSeriesId(parseIdentifier(json.getJSONObject("seriesId")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("requester"))
      res.setRequester(parseResourceReference(json.getJSONObject("requester")));
    if (json.has("modality"))
      res.setModality(parseEnumeration(json.getJSONObject("modality"), Picture.ImageModality3.Null, new Picture().new ImageModality3EnumFactory()));
    if (json.has("deviceName"))
      res.setDeviceName(parseString(json.getJSONObject("deviceName")));
    if (json.has("height"))
      res.setHeight(parseInteger(json.getJSONObject("height")));
    if (json.has("width"))
      res.setWidth(parseInteger(json.getJSONObject("width")));
    if (json.has("bits"))
      res.setBits(parseInteger(json.getJSONObject("bits")));
    if (json.has("frames"))
      res.setFrames(parseInteger(json.getJSONObject("frames")));
    if (json.has("frameDelay"))
      res.setFrameDelay(parseDuration(json.getJSONObject("frameDelay")));
    if (json.has("view"))
      res.setView(parseCodeableConcept(json.getJSONObject("view")));
    if (json.has("content"))
      res.setContent(parseAttachment(json.getJSONObject("content")));
    return res;
  }

  private XdsEntry parseXdsEntry(JSONObject json) throws Exception {
    XdsEntry res = new XdsEntry();
    parseResourceProperties(json, res);
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("repositoryId"))
      res.setRepositoryId(parseUri(json.getJSONObject("repositoryId")));
    if (json.has("mimeType"))
      res.setMimeType(parseString(json.getJSONObject("mimeType")));
    if (json.has("format"))
      res.setFormat(parseCoding(json.getJSONObject("format")));
    if (json.has("class"))
      res.setClass_(parseCoding(json.getJSONObject("class")));
    if (json.has("type"))
      res.setType(parseCoding(json.getJSONObject("type")));
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    if (json.has("documentId"))
      res.setDocumentId(parseUri(json.getJSONObject("documentId")));
    if (json.has("availability"))
      res.setAvailability(parseEnumeration(json.getJSONObject("availability"), XdsEntry.XdsEntryAvailability.Null, new XdsEntry().new XdsEntryAvailabilityEnumFactory()));
    if (json.has("confidentialityCode"))
      res.setConfidentialityCode(parseCoding(json.getJSONObject("confidentialityCode")));
    if (json.has("created"))
      res.setCreated(parseInstant(json.getJSONObject("created")));
    if (json.has("event")) {
      JSONArray array = json.getJSONArray("event");
      for (int i = 0; i < array.length(); i++) {
        res.getEvent().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("hash"))
      res.setHash(parseString(json.getJSONObject("hash")));
    if (json.has("size"))
      res.setSize(parseString(json.getJSONObject("size")));
    if (json.has("lang"))
      res.setLang(parseString(json.getJSONObject("lang")));
    if (json.has("folder")) {
      JSONArray array = json.getJSONArray("folder");
      for (int i = 0; i < array.length(); i++) {
        res.getFolder().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("patientId"))
      res.setPatientId(parseIdentifier(json.getJSONObject("patientId")));
    if (json.has("sourcePatientId"))
      res.setSourcePatientId(parseIdentifier(json.getJSONObject("sourcePatientId")));
    if (json.has("patientInfo"))
      res.setPatientInfo(parseResourceReference(json.getJSONObject("patientInfo")));
    if (json.has("author")) {
      JSONArray array = json.getJSONArray("author");
      for (int i = 0; i < array.length(); i++) {
        res.getAuthor().add(parseXdsEntryAuthor(array.getJSONObject(i), res));
      }
    };
    if (json.has("authenticator"))
      res.setAuthenticator(parseXdsEntryAuthenticator(json.getJSONObject("authenticator"), res));
    if (json.has("facilityType"))
      res.setFacilityType(parseCoding(json.getJSONObject("facilityType")));
    if (json.has("practiceSetting"))
      res.setPracticeSetting(parseCoding(json.getJSONObject("practiceSetting")));
    if (json.has("homeCommunity"))
      res.setHomeCommunity(parseUri(json.getJSONObject("homeCommunity")));
    if (json.has("service"))
      res.setService(parseXdsEntryService(json.getJSONObject("service"), res));
    if (json.has("comments"))
      res.setComments(parseString(json.getJSONObject("comments")));
    return res;
  }

  private XdsEntry.Author parseXdsEntryAuthor(JSONObject json, XdsEntry owner) throws Exception {
    XdsEntry.Author res = owner.new Author();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseHumanName(json.getJSONObject("name")));
    if (json.has("id"))
      res.setId(parseIdentifier(json.getJSONObject("id")));
    if (json.has("role")) {
      JSONArray array = json.getJSONArray("role");
      for (int i = 0; i < array.length(); i++) {
        res.getRole().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("specialty")) {
      JSONArray array = json.getJSONArray("specialty");
      for (int i = 0; i < array.length(); i++) {
        res.getSpecialty().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("institution")) {
      JSONArray array = json.getJSONArray("institution");
      for (int i = 0; i < array.length(); i++) {
        res.getInstitution().add(parseXdsEntryInstitution(array.getJSONObject(i), owner));
      }
    };
    if (json.has("contact")) {
      JSONArray array = json.getJSONArray("contact");
      for (int i = 0; i < array.length(); i++) {
        res.getContact().add(parseContact(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private XdsEntry.Institution parseXdsEntryInstitution(JSONObject json, XdsEntry owner) throws Exception {
    XdsEntry.Institution res = owner.new Institution();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseIdentifier(json.getJSONObject("id")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    return res;
  }

  private XdsEntry.Authenticator parseXdsEntryAuthenticator(JSONObject json, XdsEntry owner) throws Exception {
    XdsEntry.Authenticator res = owner.new Authenticator();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseIdentifier(json.getJSONObject("id")));
    if (json.has("name"))
      res.setName(parseHumanName(json.getJSONObject("name")));
    return res;
  }

  private XdsEntry.Service parseXdsEntryService(JSONObject json, XdsEntry owner) throws Exception {
    XdsEntry.Service res = owner.new Service();
    parseElementProperties(json, res);
    if (json.has("start"))
      res.setStart(parseDateTime(json.getJSONObject("start")));
    if (json.has("stop"))
      res.setStop(parseDateTime(json.getJSONObject("stop")));
    return res;
  }

  private Conformance parseConformance(JSONObject json) throws Exception {
    Conformance res = new Conformance();
    parseResourceProperties(json, res);
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("publisher"))
      res.setPublisher(parseConformancePublisher(json.getJSONObject("publisher"), res));
    if (json.has("software"))
      res.setSoftware(parseConformanceSoftware(json.getJSONObject("software"), res));
    if (json.has("implementation"))
      res.setImplementation(parseConformanceImplementation(json.getJSONObject("implementation"), res));
    if (json.has("proposal"))
      res.setProposal(parseConformanceProposal(json.getJSONObject("proposal"), res));
    if (json.has("version"))
      res.setVersion(parseId(json.getJSONObject("version")));
    if (json.has("acceptUnknown"))
      res.setAcceptUnknown(parseBoolean(json.getJSONObject("acceptUnknown")));
    if (json.has("format")) {
      JSONArray array = json.getJSONArray("format");
      for (int i = 0; i < array.length(); i++) {
        res.getFormat().add(parseCode(array.getJSONObject(i)));
      }
    };
    if (json.has("rest")) {
      JSONArray array = json.getJSONArray("rest");
      for (int i = 0; i < array.length(); i++) {
        res.getRest().add(parseConformanceRest(array.getJSONObject(i), res));
      }
    };
    if (json.has("messaging")) {
      JSONArray array = json.getJSONArray("messaging");
      for (int i = 0; i < array.length(); i++) {
        res.getMessaging().add(parseConformanceMessaging(array.getJSONObject(i), res));
      }
    };
    if (json.has("document")) {
      JSONArray array = json.getJSONArray("document");
      for (int i = 0; i < array.length(); i++) {
        res.getDocument().add(parseConformanceDocument(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Conformance.Publisher parseConformancePublisher(JSONObject json, Conformance owner) throws Exception {
    Conformance.Publisher res = owner.new Publisher();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("address"))
      res.setAddress(parseAddress(json.getJSONObject("address")));
    if (json.has("contact")) {
      JSONArray array = json.getJSONArray("contact");
      for (int i = 0; i < array.length(); i++) {
        res.getContact().add(parseContact(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Conformance.Software parseConformanceSoftware(JSONObject json, Conformance owner) throws Exception {
    Conformance.Software res = owner.new Software();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("releaseDate"))
      res.setReleaseDate(parseDateTime(json.getJSONObject("releaseDate")));
    return res;
  }

  private Conformance.Implementation parseConformanceImplementation(JSONObject json, Conformance owner) throws Exception {
    Conformance.Implementation res = owner.new Implementation();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    if (json.has("software"))
      res.setSoftware(parseConformanceSoftware(json.getJSONObject("software"), owner));
    return res;
  }

  private Conformance.Proposal parseConformanceProposal(JSONObject json, Conformance owner) throws Exception {
    Conformance.Proposal res = owner.new Proposal();
    parseElementProperties(json, res);
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    return res;
  }

  private Conformance.Rest parseConformanceRest(JSONObject json, Conformance owner) throws Exception {
    Conformance.Rest res = owner.new Rest();
    parseElementProperties(json, res);
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), Conformance.RestfulConformanceMode.Null, new Conformance().new RestfulConformanceModeEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("security"))
      res.setSecurity(parseConformanceSecurity(json.getJSONObject("security"), owner));
    if (json.has("resource")) {
      JSONArray array = json.getJSONArray("resource");
      for (int i = 0; i < array.length(); i++) {
        res.getResource().add(parseConformanceResource(array.getJSONObject(i), owner));
      }
    };
    if (json.has("batch"))
      res.setBatch(parseBoolean(json.getJSONObject("batch")));
    if (json.has("history"))
      res.setHistory(parseBoolean(json.getJSONObject("history")));
    return res;
  }

  private Conformance.Security parseConformanceSecurity(JSONObject json, Conformance owner) throws Exception {
    Conformance.Security res = owner.new Security();
    parseElementProperties(json, res);
    if (json.has("service")) {
      JSONArray array = json.getJSONArray("service");
      for (int i = 0; i < array.length(); i++) {
        res.getService().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("certificate")) {
      JSONArray array = json.getJSONArray("certificate");
      for (int i = 0; i < array.length(); i++) {
        res.getCertificate().add(parseConformanceCertificate(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Conformance.Certificate parseConformanceCertificate(JSONObject json, Conformance owner) throws Exception {
    Conformance.Certificate res = owner.new Certificate();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("blob"))
      res.setBlob(parseBase64Binary(json.getJSONObject("blob")));
    return res;
  }

  private Conformance.Resource parseConformanceResource(JSONObject json, Conformance owner) throws Exception {
    Conformance.Resource res = owner.new Resource();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("profile"))
      res.setProfile(parseUri(json.getJSONObject("profile")));
    if (json.has("operation")) {
      JSONArray array = json.getJSONArray("operation");
      for (int i = 0; i < array.length(); i++) {
        res.getOperation().add(parseConformanceOperation(array.getJSONObject(i), owner));
      }
    };
    if (json.has("readHistory"))
      res.setReadHistory(parseBoolean(json.getJSONObject("readHistory")));
    if (json.has("searchInclude")) {
      JSONArray array = json.getJSONArray("searchInclude");
      for (int i = 0; i < array.length(); i++) {
        res.getSearchInclude().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("searchParam")) {
      JSONArray array = json.getJSONArray("searchParam");
      for (int i = 0; i < array.length(); i++) {
        res.getSearchParam().add(parseConformanceSearchParam(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Conformance.Operation parseConformanceOperation(JSONObject json, Conformance owner) throws Exception {
    Conformance.Operation res = owner.new Operation();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), Conformance.RestfulOperation.Null, new Conformance().new RestfulOperationEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    return res;
  }

  private Conformance.SearchParam parseConformanceSearchParam(JSONObject json, Conformance owner) throws Exception {
    Conformance.SearchParam res = owner.new SearchParam();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("source"))
      res.setSource(parseUri(json.getJSONObject("source")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Conformance.SearchParamType.Null, new Conformance().new SearchParamTypeEnumFactory()));
    if (json.has("repeats"))
      res.setRepeats(parseEnumeration(json.getJSONObject("repeats"), Conformance.SearchRepeatBehavior.Null, new Conformance().new SearchRepeatBehaviorEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("target")) {
      JSONArray array = json.getJSONArray("target");
      for (int i = 0; i < array.length(); i++) {
        res.getTarget().add(parseCode(array.getJSONObject(i)));
      }
    };
    if (json.has("chain")) {
      JSONArray array = json.getJSONArray("chain");
      for (int i = 0; i < array.length(); i++) {
        res.getChain().add(parseString(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Conformance.Messaging parseConformanceMessaging(JSONObject json, Conformance owner) throws Exception {
    Conformance.Messaging res = owner.new Messaging();
    parseElementProperties(json, res);
    if (json.has("endpoint"))
      res.setEndpoint(parseUri(json.getJSONObject("endpoint")));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("event")) {
      JSONArray array = json.getJSONArray("event");
      for (int i = 0; i < array.length(); i++) {
        res.getEvent().add(parseConformanceEvent(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Conformance.Event parseConformanceEvent(JSONObject json, Conformance owner) throws Exception {
    Conformance.Event res = owner.new Event();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), Conformance.MessageConformanceEventMode.Null, new Conformance().new MessageConformanceEventModeEnumFactory()));
    if (json.has("protocol")) {
      JSONArray array = json.getJSONArray("protocol");
      for (int i = 0; i < array.length(); i++) {
        res.getProtocol().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("focus"))
      res.setFocus(parseCode(json.getJSONObject("focus")));
    if (json.has("request"))
      res.setRequest(parseUri(json.getJSONObject("request")));
    if (json.has("response"))
      res.setResponse(parseUri(json.getJSONObject("response")));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    return res;
  }

  private Conformance.Document parseConformanceDocument(JSONObject json, Conformance owner) throws Exception {
    Conformance.Document res = owner.new Document();
    parseElementProperties(json, res);
    if (json.has("mode"))
      res.setMode(parseEnumeration(json.getJSONObject("mode"), Conformance.DocumentMode.Null, new Conformance().new DocumentModeEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    if (json.has("profile"))
      res.setProfile(parseUri(json.getJSONObject("profile")));
    return res;
  }

  private Document parseDocument(JSONObject json) throws Exception {
    Document res = new Document();
    parseResourceProperties(json, res);
    if (json.has("information"))
      res.setInformation(parseDocumentInformation(json.getJSONObject("information")));
    if (json.has("replaces"))
      res.setReplaces(parseId(json.getJSONObject("replaces")));
    if (json.has("provenance")) {
      JSONArray array = json.getJSONArray("provenance");
      for (int i = 0; i < array.length(); i++) {
        res.getProvenance().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("stylesheet"))
      res.setStylesheet(parseAttachment(json.getJSONObject("stylesheet")));
    if (json.has("representation"))
      res.setRepresentation(parseAttachment(json.getJSONObject("representation")));
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseDocumentSection(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Document.Section parseDocumentSection(JSONObject json, Document owner) throws Exception {
    Document.Section res = owner.new Section();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("content"))
      res.setContent(parseResourceReference(json.getJSONObject("content")));
    if (json.has("section")) {
      JSONArray array = json.getJSONArray("section");
      for (int i = 0; i < array.length(); i++) {
        res.getSection().add(parseDocumentSection(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Message parseMessage(JSONObject json) throws Exception {
    Message res = new Message();
    parseResourceProperties(json, res);
    if (json.has("id"))
      res.setId(parseId(json.getJSONObject("id")));
    if (json.has("instant"))
      res.setInstant(parseInstant(json.getJSONObject("instant")));
    if (json.has("event"))
      res.setEvent(parseCode(json.getJSONObject("event")));
    if (json.has("response"))
      res.setResponse(parseMessageResponse(json.getJSONObject("response"), res));
    if (json.has("source"))
      res.setSource(parseMessageSource(json.getJSONObject("source"), res));
    if (json.has("destination"))
      res.setDestination(parseMessageDestination(json.getJSONObject("destination"), res));
    if (json.has("enterer"))
      res.setEnterer(parseResourceReference(json.getJSONObject("enterer")));
    if (json.has("author"))
      res.setAuthor(parseResourceReference(json.getJSONObject("author")));
    if (json.has("receiver"))
      res.setReceiver(parseResourceReference(json.getJSONObject("receiver")));
    if (json.has("responsible"))
      res.setResponsible(parseResourceReference(json.getJSONObject("responsible")));
    if (json.has("effective"))
      res.setEffective(parsePeriod(json.getJSONObject("effective")));
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    if (json.has("data")) {
      JSONArray array = json.getJSONArray("data");
      for (int i = 0; i < array.length(); i++) {
        res.getData().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Message.Response parseMessageResponse(JSONObject json, Message owner) throws Exception {
    Message.Response res = owner.new Response();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseId(json.getJSONObject("id")));
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), Message.ResponseCode.Null, new Message().new ResponseCodeEnumFactory()));
    if (json.has("details"))
      res.setDetails(parseResourceReference(json.getJSONObject("details")));
    return res;
  }

  private Message.Source parseMessageSource(JSONObject json, Message owner) throws Exception {
    Message.Source res = owner.new Source();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("software"))
      res.setSoftware(parseString(json.getJSONObject("software")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("contact"))
      res.setContact(parseContact(json.getJSONObject("contact")));
    if (json.has("endpoint"))
      res.setEndpoint(parseUri(json.getJSONObject("endpoint")));
    return res;
  }

  private Message.Destination parseMessageDestination(JSONObject json, Message owner) throws Exception {
    Message.Destination res = owner.new Destination();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    if (json.has("endpoint"))
      res.setEndpoint(parseUri(json.getJSONObject("endpoint")));
    return res;
  }

  private Location parseLocation(JSONObject json) throws Exception {
    Location res = new Location();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("type")) {
      JSONArray array = json.getJSONArray("type");
      for (int i = 0; i < array.length(); i++) {
        res.getType().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("address"))
      res.setAddress(parseAddress(json.getJSONObject("address")));
    if (json.has("telecom"))
      res.setTelecom(parseContact(json.getJSONObject("telecom")));
    if (json.has("provider"))
      res.setProvider(parseResourceReference(json.getJSONObject("provider")));
    if (json.has("active"))
      res.setActive(parseBoolean(json.getJSONObject("active")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    return res;
  }

  private Profile parseProfile(JSONObject json) throws Exception {
    Profile res = new Profile();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("version"))
      res.setVersion(parseString(json.getJSONObject("version")));
    if (json.has("author")) {
      JSONArray array = json.getJSONArray("author");
      for (int i = 0; i < array.length(); i++) {
        res.getAuthor().add(parseProfileAuthor(array.getJSONObject(i), res));
      }
    };
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("status"))
      res.setStatus(parseProfileStatus(json.getJSONObject("status"), res));
    if (json.has("import")) {
      JSONArray array = json.getJSONArray("import");
      for (int i = 0; i < array.length(); i++) {
        res.getImport().add(parseProfileImport(array.getJSONObject(i), res));
      }
    };
    if (json.has("bundle"))
      res.setBundle(parseCode(json.getJSONObject("bundle")));
    if (json.has("constraint")) {
      JSONArray array = json.getJSONArray("constraint");
      for (int i = 0; i < array.length(); i++) {
        res.getConstraint().add(parseProfileConstraint(array.getJSONObject(i), res));
      }
    };
    if (json.has("extensionDefn")) {
      JSONArray array = json.getJSONArray("extensionDefn");
      for (int i = 0; i < array.length(); i++) {
        res.getExtensionDefn().add(parseProfileExtensionDefn(array.getJSONObject(i), res));
      }
    };
    if (json.has("binding")) {
      JSONArray array = json.getJSONArray("binding");
      for (int i = 0; i < array.length(); i++) {
        res.getBinding().add(parseProfileBinding(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Profile.Author parseProfileAuthor(JSONObject json, Profile owner) throws Exception {
    Profile.Author res = owner.new Author();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("role"))
      res.setRole(parseString(json.getJSONObject("role")));
    if (json.has("telecom")) {
      JSONArray array = json.getJSONArray("telecom");
      for (int i = 0; i < array.length(); i++) {
        res.getTelecom().add(parseContact(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Profile.Status parseProfileStatus(JSONObject json, Profile owner) throws Exception {
    Profile.Status res = owner.new Status();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), Profile.ResourceProfileStatus.Null, new Profile().new ResourceProfileStatusEnumFactory()));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("comment"))
      res.setComment(parseString(json.getJSONObject("comment")));
    return res;
  }

  private Profile.Import parseProfileImport(JSONObject json, Profile owner) throws Exception {
    Profile.Import res = owner.new Import();
    parseElementProperties(json, res);
    if (json.has("uri"))
      res.setUri(parseUri(json.getJSONObject("uri")));
    if (json.has("prefix"))
      res.setPrefix(parseString(json.getJSONObject("prefix")));
    return res;
  }

  private Profile.Constraint parseProfileConstraint(JSONObject json, Profile owner) throws Exception {
    Profile.Constraint res = owner.new Constraint();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseCode(json.getJSONObject("type")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("purpose"))
      res.setPurpose(parseString(json.getJSONObject("purpose")));
    if (json.has("profile"))
      res.setProfile(parseUri(json.getJSONObject("profile")));
    if (json.has("element")) {
      JSONArray array = json.getJSONArray("element");
      for (int i = 0; i < array.length(); i++) {
        res.getElement().add(parseProfileElement_(array.getJSONObject(i), owner));
      }
    };
    if (json.has("searchParam")) {
      JSONArray array = json.getJSONArray("searchParam");
      for (int i = 0; i < array.length(); i++) {
        res.getSearchParam().add(parseProfileSearchParam(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Profile.Element_ parseProfileElement_(JSONObject json, Profile owner) throws Exception {
    Profile.Element_ res = owner.new Element_();
    parseElementProperties(json, res);
    if (json.has("path"))
      res.setPath(parseString(json.getJSONObject("path")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("definition"))
      res.setDefinition(parseProfileDefinition(json.getJSONObject("definition"), owner));
    if (json.has("bundled"))
      res.setBundled(parseBoolean(json.getJSONObject("bundled")));
    return res;
  }

  private Profile.Definition parseProfileDefinition(JSONObject json, Profile owner) throws Exception {
    Profile.Definition res = owner.new Definition();
    parseElementProperties(json, res);
    if (json.has("short"))
      res.setShort(parseString(json.getJSONObject("short")));
    if (json.has("formal"))
      res.setFormal(parseString(json.getJSONObject("formal")));
    if (json.has("comments"))
      res.setComments(parseString(json.getJSONObject("comments")));
    if (json.has("requirements"))
      res.setRequirements(parseString(json.getJSONObject("requirements")));
    if (json.has("synonym")) {
      JSONArray array = json.getJSONArray("synonym");
      for (int i = 0; i < array.length(); i++) {
        res.getSynonym().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("min"))
      res.setMin(parseInteger(json.getJSONObject("min")));
    if (json.has("max"))
      res.setMax(parseString(json.getJSONObject("max")));
    if (json.has("type")) {
      JSONArray array = json.getJSONArray("type");
      for (int i = 0; i < array.length(); i++) {
        res.getType().add(parseProfileType(array.getJSONObject(i), owner));
      }
    };
    if (json.has("nameReference"))
      res.setNameReference(parseString(json.getJSONObject("nameReference")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("maxLength"))
      res.setMaxLength(parseInteger(json.getJSONObject("maxLength")));
    if (json.has("condition")) {
      JSONArray array = json.getJSONArray("condition");
      for (int i = 0; i < array.length(); i++) {
        res.getCondition().add(parseId(array.getJSONObject(i)));
      }
    };
    if (json.has("constraint")) {
      JSONArray array = json.getJSONArray("constraint");
      for (int i = 0; i < array.length(); i++) {
        res.getConstraint().add(parseProfileConstraintA(array.getJSONObject(i), owner));
      }
    };
    if (json.has("mustSupport"))
      res.setMustSupport(parseBoolean(json.getJSONObject("mustSupport")));
    if (json.has("mustUnderstand"))
      res.setMustUnderstand(parseBoolean(json.getJSONObject("mustUnderstand")));
    if (json.has("binding"))
      res.setBinding(parseString(json.getJSONObject("binding")));
    if (json.has("mapping")) {
      JSONArray array = json.getJSONArray("mapping");
      for (int i = 0; i < array.length(); i++) {
        res.getMapping().add(parseProfileMapping(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Profile.Type parseProfileType(JSONObject json, Profile owner) throws Exception {
    Profile.Type res = owner.new Type();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCode(json.getJSONObject("code")));
    if (json.has("profile"))
      res.setProfile(parseUri(json.getJSONObject("profile")));
    return res;
  }

  private Profile.ConstraintA parseProfileConstraintA(JSONObject json, Profile owner) throws Exception {
    Profile.ConstraintA res = owner.new ConstraintA();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseId(json.getJSONObject("id")));
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("severity"))
      res.setSeverity(parseEnumeration(json.getJSONObject("severity"), Profile.ConstraintSeverity.Null, new Profile().new ConstraintSeverityEnumFactory()));
    if (json.has("human"))
      res.setHuman(parseString(json.getJSONObject("human")));
    if (json.has("xpath"))
      res.setXpath(parseString(json.getJSONObject("xpath")));
    if (json.has("ocl"))
      res.setOcl(parseString(json.getJSONObject("ocl")));
    return res;
  }

  private Profile.Mapping parseProfileMapping(JSONObject json, Profile owner) throws Exception {
    Profile.Mapping res = owner.new Mapping();
    parseElementProperties(json, res);
    if (json.has("target"))
      res.setTarget(parseString(json.getJSONObject("target")));
    if (json.has("map"))
      res.setMap(parseString(json.getJSONObject("map")));
    return res;
  }

  private Profile.SearchParam parseProfileSearchParam(JSONObject json, Profile owner) throws Exception {
    Profile.SearchParam res = owner.new SearchParam();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Profile.SearchParamType.Null, new Profile().new SearchParamTypeEnumFactory()));
    if (json.has("repeats"))
      res.setRepeats(parseEnumeration(json.getJSONObject("repeats"), Profile.SearchRepeatBehavior.Null, new Profile().new SearchRepeatBehaviorEnumFactory()));
    if (json.has("documentation"))
      res.setDocumentation(parseString(json.getJSONObject("documentation")));
    return res;
  }

  private Profile.ExtensionDefn parseProfileExtensionDefn(JSONObject json, Profile owner) throws Exception {
    Profile.ExtensionDefn res = owner.new ExtensionDefn();
    parseElementProperties(json, res);
    if (json.has("id"))
      res.setId(parseId(json.getJSONObject("id")));
    if (json.has("contextType"))
      res.setContextType(parseEnumeration(json.getJSONObject("contextType"), Profile.ExtensionContext.Null, new Profile().new ExtensionContextEnumFactory()));
    if (json.has("context")) {
      JSONArray array = json.getJSONArray("context");
      for (int i = 0; i < array.length(); i++) {
        res.getContext().add(parseString(array.getJSONObject(i)));
      }
    };
    if (json.has("definition"))
      res.setDefinition(parseProfileDefinition(json.getJSONObject("definition"), owner));
    return res;
  }

  private Profile.Binding parseProfileBinding(JSONObject json, Profile owner) throws Exception {
    Profile.Binding res = owner.new Binding();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseString(json.getJSONObject("name")));
    if (json.has("definition"))
      res.setDefinition(parseString(json.getJSONObject("definition")));
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Profile.BindingType.Null, new Profile().new BindingTypeEnumFactory()));
    if (json.has("isExtensible"))
      res.setIsExtensible(parseBoolean(json.getJSONObject("isExtensible")));
    if (json.has("conformance"))
      res.setConformance(parseEnumeration(json.getJSONObject("conformance"), Profile.BindingConformance.Null, new Profile().new BindingConformanceEnumFactory()));
    if (json.has("reference"))
      res.setReference(parseUri(json.getJSONObject("reference")));
    if (json.has("concept")) {
      JSONArray array = json.getJSONArray("concept");
      for (int i = 0; i < array.length(); i++) {
        res.getConcept().add(parseProfileConcept(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private Profile.Concept parseProfileConcept(JSONObject json, Profile owner) throws Exception {
    Profile.Concept res = owner.new Concept();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseString(json.getJSONObject("code")));
    if (json.has("system"))
      res.setSystem(parseUri(json.getJSONObject("system")));
    if (json.has("display"))
      res.setDisplay(parseString(json.getJSONObject("display")));
    if (json.has("definition"))
      res.setDefinition(parseString(json.getJSONObject("definition")));
    return res;
  }

  private Observation parseObservation(JSONObject json) throws Exception {
    Observation res = new Observation();
    parseResourceProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    if (json.has("interpretation"))
      res.setInterpretation(parseCodeableConcept(json.getJSONObject("interpretation")));
    if (json.has("comments"))
      res.setComments(parseString(json.getJSONObject("comments")));
    Type obtained = parseType("obtained", json);
    if (obtained != null)
      res.setObtained(obtained);
    if (json.has("issued"))
      res.setIssued(parseInstant(json.getJSONObject("issued")));
    if (json.has("status"))
      res.setStatus(parseEnumeration(json.getJSONObject("status"), Observation.ObservationStatus.Null, new Observation().new ObservationStatusEnumFactory()));
    if (json.has("reliability"))
      res.setReliability(parseEnumeration(json.getJSONObject("reliability"), Observation.ObservationReliability.Null, new Observation().new ObservationReliabilityEnumFactory()));
    if (json.has("bodySite"))
      res.setBodySite(parseCodeableConcept(json.getJSONObject("bodySite")));
    if (json.has("method"))
      res.setMethod(parseCodeableConcept(json.getJSONObject("method")));
    if (json.has("identifier"))
      res.setIdentifier(parseIdentifier(json.getJSONObject("identifier")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("performer"))
      res.setPerformer(parseResourceReference(json.getJSONObject("performer")));
    if (json.has("referenceRange")) {
      JSONArray array = json.getJSONArray("referenceRange");
      for (int i = 0; i < array.length(); i++) {
        res.getReferenceRange().add(parseObservationReferenceRange(array.getJSONObject(i), res));
      }
    };
    if (json.has("component")) {
      JSONArray array = json.getJSONArray("component");
      for (int i = 0; i < array.length(); i++) {
        res.getComponent().add(parseObservationComponent(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Observation.ReferenceRange parseObservationReferenceRange(JSONObject json, Observation owner) throws Exception {
    Observation.ReferenceRange res = owner.new ReferenceRange();
    parseElementProperties(json, res);
    if (json.has("meaning"))
      res.setMeaning(parseCodeableConcept(json.getJSONObject("meaning")));
    Type range = parseType("range", json);
    if (range != null)
      res.setRange(range);
    return res;
  }

  private Observation.Component parseObservationComponent(JSONObject json, Observation owner) throws Exception {
    Observation.Component res = owner.new Component();
    parseElementProperties(json, res);
    if (json.has("name"))
      res.setName(parseCodeableConcept(json.getJSONObject("name")));
    Type value = parseType("value", json);
    if (value != null)
      res.setValue(value);
    return res;
  }

  private Immunization parseImmunization(JSONObject json) throws Exception {
    Immunization res = new Immunization();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("type"))
      res.setType(parseCodeableConcept(json.getJSONObject("type")));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("reported"))
      res.setReported(parseBoolean(json.getJSONObject("reported")));
    if (json.has("doseSequence"))
      res.setDoseSequence(parseInteger(json.getJSONObject("doseSequence")));
    if (json.has("manufacturer"))
      res.setManufacturer(parseResourceReference(json.getJSONObject("manufacturer")));
    if (json.has("lotNumber"))
      res.setLotNumber(parseString(json.getJSONObject("lotNumber")));
    if (json.has("expirationDate"))
      res.setExpirationDate(parseDate(json.getJSONObject("expirationDate")));
    if (json.has("site"))
      res.setSite(parseCodeableConcept(json.getJSONObject("site")));
    if (json.has("route"))
      res.setRoute(parseCodeableConcept(json.getJSONObject("route")));
    if (json.has("requester"))
      res.setRequester(parseResourceReference(json.getJSONObject("requester")));
    if (json.has("performer"))
      res.setPerformer(parseResourceReference(json.getJSONObject("performer")));
    if (json.has("refusal"))
      res.setRefusal(parseImmunizationRefusal(json.getJSONObject("refusal"), res));
    if (json.has("reaction")) {
      JSONArray array = json.getJSONArray("reaction");
      for (int i = 0; i < array.length(); i++) {
        res.getReaction().add(parseImmunizationReaction(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Immunization.Refusal parseImmunizationRefusal(JSONObject json, Immunization owner) throws Exception {
    Immunization.Refusal res = owner.new Refusal();
    parseElementProperties(json, res);
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("reason"))
      res.setReason(parseCodeableConcept(json.getJSONObject("reason")));
    return res;
  }

  private Immunization.Reaction parseImmunizationReaction(JSONObject json, Immunization owner) throws Exception {
    Immunization.Reaction res = owner.new Reaction();
    parseElementProperties(json, res);
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("detail"))
      res.setDetail(parseResourceReference(json.getJSONObject("detail")));
    return res;
  }

  private Problem parseProblem(JSONObject json) throws Exception {
    Problem res = new Problem();
    parseResourceProperties(json, res);
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("encounter"))
      res.setEncounter(parseResourceReference(json.getJSONObject("encounter")));
    if (json.has("asserter"))
      res.setAsserter(parseResourceReference(json.getJSONObject("asserter")));
    if (json.has("dateAsserted"))
      res.setDateAsserted(parseDate(json.getJSONObject("dateAsserted")));
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("category"))
      res.setCategory(parseCodeableConcept(json.getJSONObject("category")));
    if (json.has("status"))
      res.setStatus(parseCode(json.getJSONObject("status")));
    if (json.has("certainty"))
      res.setCertainty(parseCodeableConcept(json.getJSONObject("certainty")));
    if (json.has("severity"))
      res.setSeverity(parseCodeableConcept(json.getJSONObject("severity")));
    Type onset = parseType("onset", json);
    if (onset != null)
      res.setOnset(onset);
    Type abatement = parseType("abatement", json);
    if (abatement != null)
      res.setAbatement(abatement);
    if (json.has("stage"))
      res.setStage(parseProblemStage(json.getJSONObject("stage"), res));
    if (json.has("evidence")) {
      JSONArray array = json.getJSONArray("evidence");
      for (int i = 0; i < array.length(); i++) {
        res.getEvidence().add(parseProblemEvidence(array.getJSONObject(i), res));
      }
    };
    if (json.has("location")) {
      JSONArray array = json.getJSONArray("location");
      for (int i = 0; i < array.length(); i++) {
        res.getLocation().add(parseProblemLocation(array.getJSONObject(i), res));
      }
    };
    if (json.has("relatedItem")) {
      JSONArray array = json.getJSONArray("relatedItem");
      for (int i = 0; i < array.length(); i++) {
        res.getRelatedItem().add(parseProblemRelatedItem(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private Problem.Stage parseProblemStage(JSONObject json, Problem owner) throws Exception {
    Problem.Stage res = owner.new Stage();
    parseElementProperties(json, res);
    if (json.has("summary"))
      res.setSummary(parseCodeableConcept(json.getJSONObject("summary")));
    if (json.has("assessment")) {
      JSONArray array = json.getJSONArray("assessment");
      for (int i = 0; i < array.length(); i++) {
        res.getAssessment().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Problem.Evidence parseProblemEvidence(JSONObject json, Problem owner) throws Exception {
    Problem.Evidence res = owner.new Evidence();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("details")) {
      JSONArray array = json.getJSONArray("details");
      for (int i = 0; i < array.length(); i++) {
        res.getDetails().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Problem.Location parseProblemLocation(JSONObject json, Problem owner) throws Exception {
    Problem.Location res = owner.new Location();
    parseElementProperties(json, res);
    if (json.has("code"))
      res.setCode(parseCodeableConcept(json.getJSONObject("code")));
    if (json.has("details"))
      res.setDetails(parseResourceReference(json.getJSONObject("details")));
    return res;
  }

  private Problem.RelatedItem parseProblemRelatedItem(JSONObject json, Problem owner) throws Exception {
    Problem.RelatedItem res = owner.new RelatedItem();
    parseElementProperties(json, res);
    if (json.has("type"))
      res.setType(parseEnumeration(json.getJSONObject("type"), Problem.ProblemRelationshipType.Null, new Problem().new ProblemRelationshipTypeEnumFactory()));
    if (json.has("target"))
      res.setTarget(parseResourceReference(json.getJSONObject("target")));
    return res;
  }

  private OrderResponse parseOrderResponse(JSONObject json) throws Exception {
    OrderResponse res = new OrderResponse();
    parseResourceProperties(json, res);
    if (json.has("request"))
      res.setRequest(parseResourceReference(json.getJSONObject("request")));
    if (json.has("date"))
      res.setDate(parseDateTime(json.getJSONObject("date")));
    if (json.has("who"))
      res.setWho(parseResourceReference(json.getJSONObject("who")));
    if (json.has("authority"))
      res.setAuthority(parseResourceReference(json.getJSONObject("authority")));
    if (json.has("cost"))
      res.setCost(parseMoney(json.getJSONObject("cost")));
    if (json.has("code"))
      res.setCode(parseEnumeration(json.getJSONObject("code"), OrderResponse.OrderOutcomeCode.Null, new OrderResponse().new OrderOutcomeCodeEnumFactory()));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("fulfillment")) {
      JSONArray array = json.getJSONArray("fulfillment");
      for (int i = 0; i < array.length(); i++) {
        res.getFulfillment().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    return res;
  }

  private Patient parsePatient(JSONObject json) throws Exception {
    Patient res = new Patient();
    parseResourceProperties(json, res);
    if (json.has("link")) {
      JSONArray array = json.getJSONArray("link");
      for (int i = 0; i < array.length(); i++) {
        res.getLink().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("active"))
      res.setActive(parseBoolean(json.getJSONObject("active")));
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("details"))
      res.setDetails(parseDemographics(json.getJSONObject("details")));
    if (json.has("contact")) {
      JSONArray array = json.getJSONArray("contact");
      for (int i = 0; i < array.length(); i++) {
        res.getContact().add(parsePatientContact(array.getJSONObject(i), res));
      }
    };
    if (json.has("animal"))
      res.setAnimal(parsePatientAnimal(json.getJSONObject("animal"), res));
    if (json.has("provider"))
      res.setProvider(parseResourceReference(json.getJSONObject("provider")));
    Type multipleBirth = parseType("multipleBirth", json);
    if (multipleBirth != null)
      res.setMultipleBirth(multipleBirth);
    if (json.has("deceasedDate"))
      res.setDeceasedDate(parseDateTime(json.getJSONObject("deceasedDate")));
    if (json.has("diet"))
      res.setDiet(parseCodeableConcept(json.getJSONObject("diet")));
    return res;
  }

  private Patient.Contact parsePatientContact(JSONObject json, Patient owner) throws Exception {
    Patient.Contact res = owner.new Contact();
    parseElementProperties(json, res);
    if (json.has("relationship")) {
      JSONArray array = json.getJSONArray("relationship");
      for (int i = 0; i < array.length(); i++) {
        res.getRelationship().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("details"))
      res.setDetails(parseDemographics(json.getJSONObject("details")));
    if (json.has("organization"))
      res.setOrganization(parseResourceReference(json.getJSONObject("organization")));
    return res;
  }

  private Patient.Animal parsePatientAnimal(JSONObject json, Patient owner) throws Exception {
    Patient.Animal res = owner.new Animal();
    parseElementProperties(json, res);
    if (json.has("species"))
      res.setSpecies(parseCodeableConcept(json.getJSONObject("species")));
    if (json.has("breed"))
      res.setBreed(parseCodeableConcept(json.getJSONObject("breed")));
    if (json.has("genderStatus"))
      res.setGenderStatus(parseCodeableConcept(json.getJSONObject("genderStatus")));
    return res;
  }

  private ImagingStudy parseImagingStudy(JSONObject json) throws Exception {
    ImagingStudy res = new ImagingStudy();
    parseResourceProperties(json, res);
    if (json.has("dateTime"))
      res.setDateTime(parseDateTime(json.getJSONObject("dateTime")));
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("uid"))
      res.setUid(parseOid(json.getJSONObject("uid")));
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("requester"))
      res.setRequester(parseResourceReference(json.getJSONObject("requester")));
    if (json.has("accessionNo"))
      res.setAccessionNo(parseIdentifier(json.getJSONObject("accessionNo")));
    if (json.has("clinicalInformation"))
      res.setClinicalInformation(parseString(json.getJSONObject("clinicalInformation")));
    if (json.has("procedure")) {
      JSONArray array = json.getJSONArray("procedure");
      for (int i = 0; i < array.length(); i++) {
        res.getProcedure().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("interpreter"))
      res.setInterpreter(parseResourceReference(json.getJSONObject("interpreter")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("series")) {
      JSONArray array = json.getJSONArray("series");
      for (int i = 0; i < array.length(); i++) {
        res.getSeries().add(parseImagingStudySeries(array.getJSONObject(i), res));
      }
    };
    return res;
  }

  private ImagingStudy.Series parseImagingStudySeries(JSONObject json, ImagingStudy owner) throws Exception {
    ImagingStudy.Series res = owner.new Series();
    parseElementProperties(json, res);
    if (json.has("number"))
      res.setNumber(parseInteger(json.getJSONObject("number")));
    if (json.has("modality"))
      res.setModality(parseEnumeration(json.getJSONObject("modality"), ImagingStudy.ImageModality.Null, new ImagingStudy().new ImageModalityEnumFactory()));
    if (json.has("datetime"))
      res.setDatetime(parseDateTime(json.getJSONObject("datetime")));
    if (json.has("uid"))
      res.setUid(parseOid(json.getJSONObject("uid")));
    if (json.has("description"))
      res.setDescription(parseString(json.getJSONObject("description")));
    if (json.has("bodySite"))
      res.setBodySite(parseCoding(json.getJSONObject("bodySite")));
    if (json.has("image")) {
      JSONArray array = json.getJSONArray("image");
      for (int i = 0; i < array.length(); i++) {
        res.getImage().add(parseImagingStudyImage(array.getJSONObject(i), owner));
      }
    };
    return res;
  }

  private ImagingStudy.Image parseImagingStudyImage(JSONObject json, ImagingStudy owner) throws Exception {
    ImagingStudy.Image res = owner.new Image();
    parseElementProperties(json, res);
    if (json.has("number"))
      res.setNumber(parseInteger(json.getJSONObject("number")));
    if (json.has("dateTime"))
      res.setDateTime(parseDateTime(json.getJSONObject("dateTime")));
    if (json.has("uid"))
      res.setUid(parseOid(json.getJSONObject("uid")));
    if (json.has("dicomClass"))
      res.setDicomClass(parseOid(json.getJSONObject("dicomClass")));
    if (json.has("url"))
      res.setUrl(parseUri(json.getJSONObject("url")));
    return res;
  }

  private XdsEntry2 parseXdsEntry2(JSONObject json) throws Exception {
    XdsEntry2 res = new XdsEntry2();
    parseResourceProperties(json, res);
    if (json.has("id"))
      res.setId(parseIdentifier(json.getJSONObject("id")));
    if (json.has("information"))
      res.setInformation(parseDocumentInformation(json.getJSONObject("information")));
    if (json.has("format"))
      res.setFormat(parseCoding(json.getJSONObject("format")));
    if (json.has("availability"))
      res.setAvailability(parseEnumeration(json.getJSONObject("availability"), XdsEntry2.XdsEntryAvailability.Null, new XdsEntry2().new XdsEntryAvailabilityEnumFactory()));
    if (json.has("folder")) {
      JSONArray array = json.getJSONArray("folder");
      for (int i = 0; i < array.length(); i++) {
        res.getFolder().add(parseResourceReference(array.getJSONObject(i)));
      }
    };
    if (json.has("subject"))
      res.setSubject(parseResourceReference(json.getJSONObject("subject")));
    if (json.has("content"))
      res.setContent(parseAttachment(json.getJSONObject("content")));
    return res;
  }

  private Provider parseProvider(JSONObject json) throws Exception {
    Provider res = new Provider();
    parseResourceProperties(json, res);
    if (json.has("identifier")) {
      JSONArray array = json.getJSONArray("identifier");
      for (int i = 0; i < array.length(); i++) {
        res.getIdentifier().add(parseIdentifier(array.getJSONObject(i)));
      }
    };
    if (json.has("details"))
      res.setDetails(parseDemographics(json.getJSONObject("details")));
    if (json.has("organization"))
      res.setOrganization(parseResourceReference(json.getJSONObject("organization")));
    if (json.has("role")) {
      JSONArray array = json.getJSONArray("role");
      for (int i = 0; i < array.length(); i++) {
        res.getRole().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("specialty")) {
      JSONArray array = json.getJSONArray("specialty");
      for (int i = 0; i < array.length(); i++) {
        res.getSpecialty().add(parseCodeableConcept(array.getJSONObject(i)));
      }
    };
    if (json.has("period"))
      res.setPeriod(parsePeriod(json.getJSONObject("period")));
    return res;
  }

  private XdsFolder parseXdsFolder(JSONObject json) throws Exception {
    XdsFolder res = new XdsFolder();
    parseResourceProperties(json, res);
    if (json.has("code")) {
      JSONArray array = json.getJSONArray("code");
      for (int i = 0; i < array.length(); i++) {
        res.getCode().add(parseCoding(array.getJSONObject(i)));
      }
    };
    if (json.has("title"))
      res.setTitle(parseString(json.getJSONObject("title")));
    if (json.has("patientId"))
      res.setPatientId(parseIdentifier(json.getJSONObject("patientId")));
    if (json.has("homeCommunity"))
      res.setHomeCommunity(parseString(json.getJSONObject("homeCommunity")));
    if (json.has("comments"))
      res.setComments(parseString(json.getJSONObject("comments")));
    return res;
  }

  @Override
  protected Resource parseResource(JSONObject json) throws Exception {
    if (json.has("CarePlan"))
      return parseCarePlan(json.getJSONObject("CarePlan"));
    else if (json.has("Provenance"))
      return parseProvenance(json.getJSONObject("Provenance"));
    else if (json.has("Device"))
      return parseDevice(json.getJSONObject("Device"));
    else if (json.has("Order"))
      return parseOrder(json.getJSONObject("Order"));
    else if (json.has("Organization"))
      return parseOrganization(json.getJSONObject("Organization"));
    else if (json.has("Prescription"))
      return parsePrescription(json.getJSONObject("Prescription"));
    else if (json.has("Group"))
      return parseGroup(json.getJSONObject("Group"));
    else if (json.has("DiagnosticReport"))
      return parseDiagnosticReport(json.getJSONObject("DiagnosticReport"));
    else if (json.has("ValueSet"))
      return parseValueSet(json.getJSONObject("ValueSet"));
    else if (json.has("Coverage"))
      return parseCoverage(json.getJSONObject("Coverage"));
    else if (json.has("Test"))
      return parseTest(json.getJSONObject("Test"));
    else if (json.has("MedicationAdministration"))
      return parseMedicationAdministration(json.getJSONObject("MedicationAdministration"));
    else if (json.has("Encounter"))
      return parseEncounter(json.getJSONObject("Encounter"));
    else if (json.has("SecurityEvent"))
      return parseSecurityEvent(json.getJSONObject("SecurityEvent"));
    else if (json.has("IssueReport"))
      return parseIssueReport(json.getJSONObject("IssueReport"));
    else if (json.has("List"))
      return parseList_(json.getJSONObject("List"));
    else if (json.has("Questionnaire"))
      return parseQuestionnaire(json.getJSONObject("Questionnaire"));
    else if (json.has("Picture"))
      return parsePicture(json.getJSONObject("Picture"));
    else if (json.has("XdsEntry"))
      return parseXdsEntry(json.getJSONObject("XdsEntry"));
    else if (json.has("Conformance"))
      return parseConformance(json.getJSONObject("Conformance"));
    else if (json.has("Document"))
      return parseDocument(json.getJSONObject("Document"));
    else if (json.has("Message"))
      return parseMessage(json.getJSONObject("Message"));
    else if (json.has("Location"))
      return parseLocation(json.getJSONObject("Location"));
    else if (json.has("Profile"))
      return parseProfile(json.getJSONObject("Profile"));
    else if (json.has("Observation"))
      return parseObservation(json.getJSONObject("Observation"));
    else if (json.has("Immunization"))
      return parseImmunization(json.getJSONObject("Immunization"));
    else if (json.has("Problem"))
      return parseProblem(json.getJSONObject("Problem"));
    else if (json.has("OrderResponse"))
      return parseOrderResponse(json.getJSONObject("OrderResponse"));
    else if (json.has("Patient"))
      return parsePatient(json.getJSONObject("Patient"));
    else if (json.has("ImagingStudy"))
      return parseImagingStudy(json.getJSONObject("ImagingStudy"));
    else if (json.has("XdsEntry2"))
      return parseXdsEntry2(json.getJSONObject("XdsEntry2"));
    else if (json.has("Provider"))
      return parseProvider(json.getJSONObject("Provider"));
    else if (json.has("XdsFolder"))
      return parseXdsFolder(json.getJSONObject("XdsFolder"));
    else if (json.has("Binary"))
      return parseBinary(json.getJSONObject("Binary"));
    throw new Exception("Unknown.Unrecognised resource type");
  }

  protected Type parseType(String prefix, JSONObject json) throws Exception {
    if (json.has(prefix+"Period"))
      return parsePeriod(json.getJSONObject(prefix+"Period"));
    else if (json.has(prefix+"Coding"))
      return parseCoding(json.getJSONObject(prefix+"Coding"));
    else if (json.has(prefix+"Range"))
      return parseRange(json.getJSONObject(prefix+"Range"));
    else if (json.has(prefix+"Quantity"))
      return parseQuantity(json.getJSONObject(prefix+"Quantity"));
    else if (json.has(prefix+"Choice"))
      return parseChoice(json.getJSONObject(prefix+"Choice"));
    else if (json.has(prefix+"Attachment"))
      return parseAttachment(json.getJSONObject(prefix+"Attachment"));
    else if (json.has(prefix+"Ratio"))
      return parseRatio(json.getJSONObject(prefix+"Ratio"));
    else if (json.has(prefix+"ResourceReference"))
      return parseResourceReference(json.getJSONObject(prefix+"ResourceReference"));
    else if (json.has(prefix+"CodeableConcept"))
      return parseCodeableConcept(json.getJSONObject(prefix+"CodeableConcept"));
    else if (json.has(prefix+"Identifier"))
      return parseIdentifier(json.getJSONObject(prefix+"Identifier"));
    else if (json.has(prefix+"Age"))
      return parseAge(json.getJSONObject(prefix+"Age"));
    else if (json.has(prefix+"Count"))
      return parseCount(json.getJSONObject(prefix+"Count"));
    else if (json.has(prefix+"Money"))
      return parseMoney(json.getJSONObject(prefix+"Money"));
    else if (json.has(prefix+"Distance"))
      return parseDistance(json.getJSONObject(prefix+"Distance"));
    else if (json.has(prefix+"Duration"))
      return parseDuration(json.getJSONObject(prefix+"Duration"));
    else if (json.has(prefix+"Schedule"))
      return parseSchedule(json.getJSONObject(prefix+"Schedule"));
    else if (json.has(prefix+"Contact"))
      return parseContact(json.getJSONObject(prefix+"Contact"));
    else if (json.has(prefix+"Address"))
      return parseAddress(json.getJSONObject(prefix+"Address"));
    else if (json.has(prefix+"HumanName"))
      return parseHumanName(json.getJSONObject(prefix+"HumanName"));
    else if (json.has(prefix+"DocumentInformation"))
      return parseDocumentInformation(json.getJSONObject(prefix+"DocumentInformation"));
    else if (json.has(prefix+"Demographics"))
      return parseDemographics(json.getJSONObject(prefix+"Demographics"));
    else if (json.has(prefix+"Integer"))
      return parseInteger(json.getJSONObject(prefix+"Integer"));
    else if (json.has(prefix+"DateTime"))
      return parseDateTime(json.getJSONObject(prefix+"DateTime"));
    else if (json.has(prefix+"Code"))
      return parseCode(json.getJSONObject(prefix+"Code"));
    else if (json.has(prefix+"Date"))
      return parseDate(json.getJSONObject(prefix+"Date"));
    else if (json.has(prefix+"Decimal"))
      return parseDecimal(json.getJSONObject(prefix+"Decimal"));
    else if (json.has(prefix+"Uri"))
      return parseUri(json.getJSONObject(prefix+"Uri"));
    else if (json.has(prefix+"Id"))
      return parseId(json.getJSONObject(prefix+"Id"));
    else if (json.has(prefix+"Base64Binary"))
      return parseBase64Binary(json.getJSONObject(prefix+"Base64Binary"));
    else if (json.has(prefix+"Oid"))
      return parseOid(json.getJSONObject(prefix+"Oid"));
    else if (json.has(prefix+"String"))
      return parseString(json.getJSONObject(prefix+"String"));
    else if (json.has(prefix+"Boolean"))
      return parseBoolean(json.getJSONObject(prefix+"Boolean"));
    else if (json.has(prefix+"Uuid"))
      return parseUuid(json.getJSONObject(prefix+"Uuid"));
    else if (json.has(prefix+"Instant"))
      return parseInstant(json.getJSONObject(prefix+"Instant"));
    return null;
  }

  private boolean hasTypeName(JSONObject json, String prefix) {
        if (json.has(prefix+"Period"))
      return true;
    if (json.has(prefix+"Coding"))
      return true;
    if (json.has(prefix+"Range"))
      return true;
    if (json.has(prefix+"Quantity"))
      return true;
    if (json.has(prefix+"Choice"))
      return true;
    if (json.has(prefix+"Attachment"))
      return true;
    if (json.has(prefix+"Ratio"))
      return true;
    if (json.has(prefix+"ResourceReference"))
      return true;
    if (json.has(prefix+"CodeableConcept"))
      return true;
    if (json.has(prefix+"Identifier"))
      return true;
    if (json.has(prefix+"Age"))
      return true;
    if (json.has(prefix+"Count"))
      return true;
    if (json.has(prefix+"Money"))
      return true;
    if (json.has(prefix+"Distance"))
      return true;
    if (json.has(prefix+"Duration"))
      return true;
    if (json.has(prefix+"Schedule"))
      return true;
    if (json.has(prefix+"Contact"))
      return true;
    if (json.has(prefix+"Address"))
      return true;
    if (json.has(prefix+"HumanName"))
      return true;
    if (json.has(prefix+"DocumentInformation"))
      return true;
    if (json.has(prefix+"Demographics"))
      return true;
    if (json.has(prefix+"CarePlan"))
      return true;
    if (json.has(prefix+"Provenance"))
      return true;
    if (json.has(prefix+"Device"))
      return true;
    if (json.has(prefix+"Order"))
      return true;
    if (json.has(prefix+"Organization"))
      return true;
    if (json.has(prefix+"Prescription"))
      return true;
    if (json.has(prefix+"Group"))
      return true;
    if (json.has(prefix+"DiagnosticReport"))
      return true;
    if (json.has(prefix+"ValueSet"))
      return true;
    if (json.has(prefix+"Coverage"))
      return true;
    if (json.has(prefix+"Test"))
      return true;
    if (json.has(prefix+"MedicationAdministration"))
      return true;
    if (json.has(prefix+"Encounter"))
      return true;
    if (json.has(prefix+"SecurityEvent"))
      return true;
    if (json.has(prefix+"IssueReport"))
      return true;
    if (json.has(prefix+"List"))
      return true;
    if (json.has(prefix+"Questionnaire"))
      return true;
    if (json.has(prefix+"Picture"))
      return true;
    if (json.has(prefix+"XdsEntry"))
      return true;
    if (json.has(prefix+"Conformance"))
      return true;
    if (json.has(prefix+"Document"))
      return true;
    if (json.has(prefix+"Message"))
      return true;
    if (json.has(prefix+"Location"))
      return true;
    if (json.has(prefix+"Profile"))
      return true;
    if (json.has(prefix+"Observation"))
      return true;
    if (json.has(prefix+"Immunization"))
      return true;
    if (json.has(prefix+"Problem"))
      return true;
    if (json.has(prefix+"OrderResponse"))
      return true;
    if (json.has(prefix+"Patient"))
      return true;
    if (json.has(prefix+"ImagingStudy"))
      return true;
    if (json.has(prefix+"XdsEntry2"))
      return true;
    if (json.has(prefix+"Provider"))
      return true;
    if (json.has(prefix+"XdsFolder"))
      return true;
    if (json.has(prefix+"Integer"))
      return true;
    if (json.has(prefix+"DateTime"))
      return true;
    if (json.has(prefix+"Code"))
      return true;
    if (json.has(prefix+"Date"))
      return true;
    if (json.has(prefix+"Decimal"))
      return true;
    if (json.has(prefix+"Uri"))
      return true;
    if (json.has(prefix+"Id"))
      return true;
    if (json.has(prefix+"Base64Binary"))
      return true;
    if (json.has(prefix+"Oid"))
      return true;
    if (json.has(prefix+"String"))
      return true;
    if (json.has(prefix+"Boolean"))
      return true;
    if (json.has(prefix+"Uuid"))
      return true;
    if (json.has(prefix+"Instant"))
      return true;
    return false;
  }
}

