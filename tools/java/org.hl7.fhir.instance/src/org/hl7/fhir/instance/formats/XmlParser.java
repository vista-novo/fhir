package org.hl7.fhir.instance.formats;

// Copyright HL7 (http://hl7.org). Generated on Fri, May 18, 2012 22:20+1000 for FHIR v0.02

import org.hl7.fhir.instance.model.*;
import org.xmlpull.v1.*;

public class XmlParser extends XmlParserBase {

  private Extension parseExtension(XmlPullParser xpp) throws Exception {
    Extension res = new Extension();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ref")) {
        res.setRef(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustUnderstand")) {
        res.setMustUnderstand(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtension().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Constraint parseConstraint(XmlPullParser xpp) throws Exception {
    Constraint res = new Constraint();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("purpose")) {
        res.setPurpose(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("element")) {
        res.getElement().add(parseConstraintElement_(xpp, res));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Constraint.Element_ parseConstraintElement_(XmlPullParser xpp, Constraint owner) throws Exception {
    Constraint.Element_ res = owner.new Element_();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("path")) {
        res.setPath(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("shortDefn")) {
        res.setShortDefn(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("min")) {
        res.setMin(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("max")) {
        res.setMax(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.getType().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("conformance")) {
        res.setConformance(Constraint.ConformanceType.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("condition")) {
        res.setCondition(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustSupport")) {
        res.setMustSupport(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustUnderstand")) {
        res.setMustUnderstand(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mapping")) {
        res.getMapping().add(parseConstraintMapping(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.setResource(parseConstraintResource(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("binding")) {
        res.setBinding(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        res.getContent().add(parseConstraintContent(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Constraint.Mapping parseConstraintMapping(XmlPullParser xpp, Constraint owner) throws Exception {
    Constraint.Mapping res = owner.new Mapping();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
        res.setTarget(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("map")) {
        res.setMap(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Constraint.Resource parseConstraintResource(XmlPullParser xpp, Constraint owner) throws Exception {
    Constraint.Resource res = owner.new Resource();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("aggregated")) {
        res.setAggregated(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Constraint.Content parseConstraintContent(XmlPullParser xpp, Constraint owner) throws Exception {
    Constraint.Content res = owner.new Content();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("nameReference")) {
        res.setNameReference(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Narrative parseNarrative(XmlPullParser xpp) throws Exception {
    Narrative res = new Narrative();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Narrative.NarrativeStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("xhtml")) {
        res.setXhtml(parseXhtml(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("image")) {
        res.getImage().add(parseNarrativeImage(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("map")) {
        res.getMap().add(parseNarrativeMap(xpp, res));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Narrative.Image parseNarrativeImage(XmlPullParser xpp, Narrative owner) throws Exception {
    Narrative.Image res = owner.new Image();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mimeType")) {
        res.setMimeType(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        res.setContent(parseBytes(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Narrative.Map parseNarrativeMap(XmlPullParser xpp, Narrative owner) throws Exception {
    Narrative.Map res = owner.new Map();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
        res.setData(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.setSource(Narrative.NarrativeMapSource.fromCode(parseString(xpp)));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Coding parseCoding(XmlPullParser xpp) throws Exception {
    Coding res = new Coding();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("display")) {
        res.setDisplay(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Interval<Quantity> parseInterval_Quantity(XmlPullParser xpp) throws Exception {
    Interval<Quantity> res = new Interval<Quantity>("Quantity");
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("low")) {
        res.setLow(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("high")) {
        res.setHigh(parseQuantity(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Interval<DateTime> parseInterval_DateTime(XmlPullParser xpp) throws Exception {
    Interval<DateTime> res = new Interval<DateTime>("DateTime");
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("low")) {
        res.setLow(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("high")) {
        res.setHigh(parseDateTime(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Interval<Date> parseInterval_Date(XmlPullParser xpp) throws Exception {
    Interval<Date> res = new Interval<Date>("Date");
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("low")) {
        res.setLow(parseDate(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("high")) {
        res.setHigh(parseDate(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Quantity parseQuantity(XmlPullParser xpp) throws Exception {
    Quantity res = new Quantity();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Quantity.QuantityStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Choice parseChoice(XmlPullParser xpp) throws Exception {
    Choice res = new Choice();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.getValue().add(parseChoiceValue(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("isOrdered")) {
        res.setIsOrdered(parseBool(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Choice.Value parseChoiceValue(XmlPullParser xpp, Choice owner) throws Exception {
    Choice.Value res = owner.new Value();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("display")) {
        res.setDisplay(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Attachment parseAttachment(XmlPullParser xpp) throws Exception {
    Attachment res = new Attachment();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mimeType")) {
        res.setMimeType(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
        res.setData(parseBytes(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
        res.setUrl(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hash")) {
        res.setHash(parseBytes(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lang")) {
        res.setLang(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Ratio parseRatio(XmlPullParser xpp) throws Exception {
    Ratio res = new Ratio();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("numerator")) {
        res.setNumerator(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("denominator")) {
        res.setDenominator(parseQuantity(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private CodeableConcept parseCodeableConcept(XmlPullParser xpp) throws Exception {
    CodeableConcept res = new CodeableConcept();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("coding")) {
        res.getCoding().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("primary")) {
        res.setPrimary(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Identifier parseIdentifier(XmlPullParser xpp) throws Exception {
    Identifier res = new Identifier();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Count parseCount(XmlPullParser xpp) throws Exception {
    Count res = new Count();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Quantity.QuantityStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Money parseMoney(XmlPullParser xpp) throws Exception {
    Money res = new Money();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Quantity.QuantityStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Distance parseDistance(XmlPullParser xpp) throws Exception {
    Distance res = new Distance();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Quantity.QuantityStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Duration parseDuration(XmlPullParser xpp) throws Exception {
    Duration res = new Duration();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Quantity.QuantityStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Schedule parseSchedule(XmlPullParser xpp) throws Exception {
    Schedule res = new Schedule();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parseInterval_DateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repeat")) {
        res.setRepeat(parseScheduleRepeat(xpp, res));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Schedule.Repeat parseScheduleRepeat(XmlPullParser xpp, Schedule owner) throws Exception {
    Schedule.Repeat res = owner.new Repeat();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("frequency")) {
        res.setFrequency(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("when")) {
        res.setWhen(Schedule.EventTiming.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("duration")) {
        res.setDuration(parseDuration(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("count")) {
        res.setCount(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("end")) {
        res.setEnd(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Contact parseContact(XmlPullParser xpp) throws Exception {
    Contact res = new Contact();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(Contact.ContactSystem.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(Contact.ContactUse.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_DateTime(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Address parseAddress(XmlPullParser xpp) throws Exception {
    Address res = new Address();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(Address.AddressUse.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("part")) {
        res.getPart().add(parseAddressPart(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_DateTime(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Address.Part parseAddressPart(XmlPullParser xpp, Address owner) throws Exception {
    Address.Part res = owner.new Part();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(Address.AddressPartType.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private HumanName parseHumanName(XmlPullParser xpp) throws Exception {
    HumanName res = new HumanName();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(HumanName.NameUse.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("part")) {
        res.getPart().add(parseHumanNamePart(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_DateTime(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private HumanName.Part parseHumanNamePart(XmlPullParser xpp, HumanName owner) throws Exception {
    HumanName.Part res = owner.new Part();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(HumanName.NamePartType.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private HumanId parseHumanId(XmlPullParser xpp) throws Exception {
    HumanId res = new HumanId();
    parseTypeAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_DateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("assigner")) {
        res.setAssigner(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Conformance parseConformance(XmlPullParser xpp) throws Exception {
    Conformance res = new Conformance();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("publisher")) {
        res.setPublisher(parseConformancePublisher(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("software")) {
        res.setSoftware(parseConformanceSoftware(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(Conformance.RestfulConformanceMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.getProfile().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.setResource(parseConstraint(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("operation")) {
        res.setOperation(parseConformanceOperation(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Conformance.Publisher parseConformancePublisher(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Publisher res = owner.new Publisher();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Conformance.Software parseConformanceSoftware(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Software res = owner.new Software();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("releaseDate")) {
        res.setReleaseDate(parseDateTime(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Conformance.Operation parseConformanceOperation(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Operation res = owner.new Operation();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("read")) {
        res.setRead(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("vread")) {
        res.setVread(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("update")) {
        res.setUpdate(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("delete")) {
        res.setDelete(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("validate")) {
        res.setValidate(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("history")) {
        res.setHistory(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("transaction")) {
        res.setTransaction(parseConformanceTransaction(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("search")) {
        res.setSearch(parseConformanceSearch(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("create")) {
        res.setCreate(parseConformanceCreate(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("updates")) {
        res.setUpdates(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("schema")) {
        res.setSchema(parseBoolean(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Conformance.Transaction parseConformanceTransaction(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Transaction res = owner.new Transaction();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.getName().add(parseCode(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Conformance.Search parseConformanceSearch(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Search res = owner.new Search();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("param")) {
        res.getParam().add(parseString_(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Conformance.Create parseConformanceCreate(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Create res = owner.new Create();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(Conformance.ResourceIdSource.fromCode(parseString(xpp)));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Document parseDocument(XmlPullParser xpp) throws Exception {
    Document res = new Document();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instant")) {
        res.setInstant(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("setId")) {
        res.setSetId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("replaces")) {
        res.setReplaces(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.getAuthor().add(parseDocumentAuthor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("attestor")) {
        res.getAttestor().add(parseDocumentAttestor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("recipient")) {
        res.getRecipient().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("custodian")) {
        res.setCustodian(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.setEvent(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounter")) {
        res.setEncounter(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section")) {
        res.getSection().add(parseDocumentSection(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Document.Author parseDocumentAuthor(XmlPullParser xpp, Document owner) throws Exception {
    Document.Author res = owner.new Author();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
        res.setTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("party")) {
        res.setParty(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Document.Attestor parseDocumentAttestor(XmlPullParser xpp, Document owner) throws Exception {
    Document.Attestor res = owner.new Attestor();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(Document.DocumentAuthenticationMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
        res.setTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("party")) {
        res.setParty(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Document.Section parseDocumentSection(XmlPullParser xpp, Document owner) throws Exception {
    Document.Section res = owner.new Section();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instant")) {
        res.setInstant(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseDocumentAuthorA(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("enterer")) {
        res.setEnterer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("informant")) {
        res.setInformant(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        res.setContent(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section")) {
        res.getSection().add(parseDocumentSection(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Document.AuthorA parseDocumentAuthorA(XmlPullParser xpp, Document owner) throws Exception {
    Document.AuthorA res = owner.new AuthorA();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
        res.setTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("party")) {
        res.setParty(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Message parseMessage(XmlPullParser xpp) throws Exception {
    Message res = new Message();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("threadId")) {
        res.setThreadId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instant")) {
        res.setInstant(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.setEvent(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("response")) {
        res.setResponse(parseMessageResponse(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.setSource(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("destination")) {
        res.setDestination(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("enterer")) {
        res.setEnterer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("responsible")) {
        res.setResponsible(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("effective")) {
        res.setEffective(parseInterval_DateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
        res.setData(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Message.Response parseMessageResponse(XmlPullParser xpp, Message owner) throws Exception {
    Message.Response res = owner.new Response();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(Message.ResponseCode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("duplicate")) {
        res.setDuplicate(parseBoolean(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Animal parseAnimal(XmlPullParser xpp) throws Exception {
    Animal res = new Animal();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.getName().add(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dob")) {
        res.setDob(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("species")) {
        res.setSpecies(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("strain")) {
        res.setStrain(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("gender")) {
        res.setGender(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relatedEntity")) {
        res.getRelatedEntity().add(parseAnimalRelatedEntity(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Animal.RelatedEntity parseAnimalRelatedEntity(XmlPullParser xpp, Animal owner) throws Exception {
    Animal.RelatedEntity res = owner.new RelatedEntity();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.setRole(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Agent parseAgent(XmlPullParser xpp) throws Exception {
    Agent res = new Agent();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("person")) {
        res.setPerson(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("organization")) {
        res.setOrganization(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.getRole().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_Date(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private MessageConformance parseMessageConformance(XmlPullParser xpp) throws Exception {
    MessageConformance res = new MessageConformance();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("publisher")) {
        res.setPublisher(parseMessageConformancePublisher(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("software")) {
        res.setSoftware(parseMessageConformanceSoftware(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.getProfile().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parseMessageConformanceEvent(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private MessageConformance.Publisher parseMessageConformancePublisher(XmlPullParser xpp, MessageConformance owner) throws Exception {
    MessageConformance.Publisher res = owner.new Publisher();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private MessageConformance.Software parseMessageConformanceSoftware(XmlPullParser xpp, MessageConformance owner) throws Exception {
    MessageConformance.Software res = owner.new Software();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("releaseDate")) {
        res.setReleaseDate(parseDateTime(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private MessageConformance.Event parseMessageConformanceEvent(XmlPullParser xpp, MessageConformance owner) throws Exception {
    MessageConformance.Event res = owner.new Event();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.setResource(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(MessageConformance.MessageConformanceEventMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("request")) {
        res.setRequest(parseMessageConformanceRequest(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("response")) {
        res.setResponse(parseMessageConformanceResponse(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private MessageConformance.Request parseMessageConformanceRequest(XmlPullParser xpp, MessageConformance owner) throws Exception {
    MessageConformance.Request res = owner.new Request();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseConstraint(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private MessageConformance.Response parseMessageConformanceResponse(XmlPullParser xpp, MessageConformance owner) throws Exception {
    MessageConformance.Response res = owner.new Response();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseConstraint(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Organization parseOrganization(XmlPullParser xpp) throws Exception {
    Organization res = new Organization();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.getName().add(parseOrganizationName(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("industryCode")) {
        res.setIndustryCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("accreditation")) {
        res.getAccreditation().add(parseOrganizationAccreditation(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relatedOrganization")) {
        res.getRelatedOrganization().add(parseOrganizationRelatedOrganization(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Organization.Name parseOrganizationName(XmlPullParser xpp, Organization owner) throws Exception {
    Organization.Name res = owner.new Name();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_Date(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Organization.Accreditation parseOrganizationAccreditation(XmlPullParser xpp, Organization owner) throws Exception {
    Organization.Accreditation res = owner.new Accreditation();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("institution")) {
        res.setInstitution(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_Date(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Organization.RelatedOrganization parseOrganizationRelatedOrganization(XmlPullParser xpp, Organization owner) throws Exception {
    Organization.RelatedOrganization res = owner.new RelatedOrganization();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_Date(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Prescription parsePrescription(XmlPullParser xpp) throws Exception {
    Prescription res = new Prescription();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Prescription.PrescriptionStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
        res.setPatient(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prescriber")) {
        res.setPrescriber(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prescribed")) {
        res.setPrescribed(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dispense")) {
        res.setDispense(parsePrescriptionDispense(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("medicine")) {
        res.setMedicine(parsePrescriptionMedicine(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("administrationRequest")) {
        res.setAdministrationRequest(parsePrescriptionAdministrationRequest(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Prescription.Dispense parsePrescriptionDispense(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.Dispense res = owner.new Dispense();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repeats")) {
        res.setRepeats(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("quantity")) {
        res.setQuantity(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dispenser")) {
        res.setDispenser(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Prescription.Medicine parsePrescriptionMedicine(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.Medicine res = owner.new Medicine();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("productCode")) {
        res.setProductCode(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("activeIngredient")) {
        res.getActiveIngredient().add(parsePrescriptionActiveIngredient(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("inactiveIngredient")) {
        res.getInactiveIngredient().add(parsePrescriptionInactiveIngredient(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Prescription.ActiveIngredient parsePrescriptionActiveIngredient(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.ActiveIngredient res = owner.new ActiveIngredient();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("productCode")) {
        res.setProductCode(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("quantity")) {
        res.setQuantity(parseRatio(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Prescription.InactiveIngredient parsePrescriptionInactiveIngredient(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.InactiveIngredient res = owner.new InactiveIngredient();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("productCode")) {
        res.setProductCode(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("quantity")) {
        res.setQuantity(parseRatio(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Prescription.AdministrationRequest parsePrescriptionAdministrationRequest(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.AdministrationRequest res = owner.new AdministrationRequest();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("totalPeriodicDosis")) {
        res.setTotalPeriodicDosis(parseRatio(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("start")) {
        res.setStart(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("end")) {
        res.setEnd(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("duration")) {
        res.setDuration(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("numberOfAdministrations")) {
        res.setNumberOfAdministrations(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dosageInstruction")) {
        res.getDosageInstruction().add(parsePrescriptionDosageInstruction(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Prescription.DosageInstruction parsePrescriptionDosageInstruction(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.DosageInstruction res = owner.new DosageInstruction();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("precondition")) {
        res.getPrecondition().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prn")) {
        res.setPrn(Prescription.BooleanYesNo.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("additionalInstruction")) {
        res.getAdditionalInstruction().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("route")) {
        res.setRoute(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "dose")) {
        res.setDose(parseType("dose", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("rate")) {
        res.setRate(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("schedule")) {
        res.getSchedule().add(parseSchedule(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Profile parseProfile(XmlPullParser xpp) throws Exception {
    Profile res = new Profile();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseProfileAuthor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("intention")) {
        res.setIntention(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("evidence")) {
        res.getEvidence().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Profile.ResourceProfileStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("endorser")) {
        res.getEndorser().add(parseProfileEndorser(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("changes")) {
        res.setChanges(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("supercedes")) {
        res.getSupercedes().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.getProfile().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseConstraint(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("binding")) {
        res.getBinding().add(parseProfileBinding(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Profile.Author parseProfileAuthor(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Author res = owner.new Author();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reference")) {
        res.getReference().add(parseUri(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Profile.Endorser parseProfileEndorser(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Endorser res = owner.new Endorser();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reference")) {
        res.setReference(parseUri(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Profile.Binding parseProfileBinding(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Binding res = owner.new Binding();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(Profile.BindingType.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reference")) {
        res.setReference(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCoding(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Lloyd parseLloyd(XmlPullParser xpp) throws Exception {
    Lloyd res = new Lloyd();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Woody parseWoody(XmlPullParser xpp) throws Exception {
    Woody res = new Woody();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Linda parseLinda(XmlPullParser xpp) throws Exception {
    Linda res = new Linda();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Ewout parseEwout(XmlPullParser xpp) throws Exception {
    Ewout res = new Ewout();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Patient parsePatient(XmlPullParser xpp) throws Exception {
    Patient res = new Patient();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("link")) {
        res.getLink().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("active")) {
        res.setActive(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("person")) {
        res.setPerson(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("animal")) {
        res.setAnimal(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("provider")) {
        res.setProvider(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("diet")) {
        res.setDiet(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("confidentiality")) {
        res.setConfidentiality(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("recordLocation")) {
        res.setRecordLocation(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Valueset parseValueset(XmlPullParser xpp) throws Exception {
    Valueset res = new Valueset();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private PaulK parsePaulK(XmlPullParser xpp) throws Exception {
    PaulK res = new PaulK();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Amnon parseAmnon(XmlPullParser xpp) throws Exception {
    Amnon res = new Amnon();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Person parsePerson(XmlPullParser xpp) throws Exception {
    Person res = new Person();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.getName().add(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dob")) {
        res.setDob(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("gender")) {
        res.setGender(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("religion")) {
        res.setReligion(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("race")) {
        res.getRace().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("qualification")) {
        res.getQualification().add(parsePersonQualification(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
        res.getLanguage().add(parsePersonLanguage(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relatedPerson")) {
        res.getRelatedPerson().add(parsePersonRelatedPerson(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Person.Qualification parsePersonQualification(XmlPullParser xpp, Person owner) throws Exception {
    Person.Qualification res = owner.new Qualification();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("institution")) {
        res.setInstitution(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parseInterval_Date(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Person.Language parsePersonLanguage(XmlPullParser xpp, Person owner) throws Exception {
    Person.Language res = owner.new Language();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(Person.LanguageUse.fromCode(parseString(xpp)));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private Person.RelatedPerson parsePersonRelatedPerson(XmlPullParser xpp, Person owner) throws Exception {
    Person.RelatedPerson res = owner.new RelatedPerson();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.setRole(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private LabReport parseLabReport(XmlPullParser xpp) throws Exception {
    LabReport res = new LabReport();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(LabReport.LabReportStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("issued")) {
        res.setIssued(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
        res.setPatient(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("admission")) {
        res.setAdmission(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("laboratory")) {
        res.setLaboratory(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reportId")) {
        res.setReportId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requestDetail")) {
        res.getRequestDetail().add(parseLabReportRequestDetail(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reportName")) {
        res.setReportName(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("service")) {
        res.setService(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("diagnosticTime")) {
        res.setDiagnosticTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("specimen")) {
        res.getSpecimen().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resultGroup")) {
        res.getResultGroup().add(parseLabReportResultGroup(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("conclusion")) {
        res.setConclusion(parseNarrative(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("codedDiagnosis")) {
        res.getCodedDiagnosis().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("representation")) {
        res.getRepresentation().add(parseAttachment(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private LabReport.RequestDetail parseLabReportRequestDetail(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.RequestDetail res = owner.new RequestDetail();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requestOrderId")) {
        res.setRequestOrderId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("receiverOrderId")) {
        res.setReceiverOrderId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requestTest")) {
        res.getRequestTest().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requester")) {
        res.setRequester(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("clinicalInfo")) {
        res.setClinicalInfo(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private LabReport.ResultGroup parseLabReportResultGroup(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.ResultGroup res = owner.new ResultGroup();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("specimen")) {
        res.setSpecimen(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("result")) {
        res.getResult().add(parseLabReportResult(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private LabReport.Result parseLabReportResult(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.Result res = owner.new Result();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("flag")) {
        res.setFlag(LabReport.LabResultFlag.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(LabReport.LabReportStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("referenceRange")) {
        res.getReferenceRange().add(parseLabReportReferenceRange(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private LabReport.ReferenceRange parseLabReportReferenceRange(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.ReferenceRange res = owner.new ReferenceRange();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("meaning")) {
        res.setMeaning(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "range")) {
        res.setRange(parseType("range", xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private DocumentConformance parseDocumentConformance(XmlPullParser xpp) throws Exception {
    DocumentConformance res = new DocumentConformance();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("publisher")) {
        res.setPublisher(parseDocumentConformancePublisher(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("software")) {
        res.setSoftware(parseDocumentConformanceSoftware(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.getProfile().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("document")) {
        res.getDocument().add(parseDocumentConformanceDocument(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensions")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extensions"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private DocumentConformance.Publisher parseDocumentConformancePublisher(XmlPullParser xpp, DocumentConformance owner) throws Exception {
    DocumentConformance.Publisher res = owner.new Publisher();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private DocumentConformance.Software parseDocumentConformanceSoftware(XmlPullParser xpp, DocumentConformance owner) throws Exception {
    DocumentConformance.Software res = owner.new Software();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("releaseDate")) {
        res.setReleaseDate(parseDateTime(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  private DocumentConformance.Document parseDocumentConformanceDocument(XmlPullParser xpp, DocumentConformance owner) throws Exception {
    DocumentConformance.Document res = owner.new Document();
    parseElementAttributes(xpp, res);
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("purpose")) {
        res.setPurpose(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseConstraint(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    return res;
  }

  @Override
  protected Resource parseResource(XmlPullParser xpp) throws Exception {
    if (xpp.getName().equals("Conformance"))
      return parseConformance(xpp);
    else if (xpp.getName().equals("Document"))
      return parseDocument(xpp);
    else if (xpp.getName().equals("Message"))
      return parseMessage(xpp);
    else if (xpp.getName().equals("Animal"))
      return parseAnimal(xpp);
    else if (xpp.getName().equals("Agent"))
      return parseAgent(xpp);
    else if (xpp.getName().equals("MessageConformance"))
      return parseMessageConformance(xpp);
    else if (xpp.getName().equals("Organization"))
      return parseOrganization(xpp);
    else if (xpp.getName().equals("Prescription"))
      return parsePrescription(xpp);
    else if (xpp.getName().equals("Profile"))
      return parseProfile(xpp);
    else if (xpp.getName().equals("Lloyd"))
      return parseLloyd(xpp);
    else if (xpp.getName().equals("Woody"))
      return parseWoody(xpp);
    else if (xpp.getName().equals("Linda"))
      return parseLinda(xpp);
    else if (xpp.getName().equals("Ewout"))
      return parseEwout(xpp);
    else if (xpp.getName().equals("Patient"))
      return parsePatient(xpp);
    else if (xpp.getName().equals("Valueset"))
      return parseValueset(xpp);
    else if (xpp.getName().equals("PaulK"))
      return parsePaulK(xpp);
    else if (xpp.getName().equals("Amnon"))
      return parseAmnon(xpp);
    else if (xpp.getName().equals("Person"))
      return parsePerson(xpp);
    else if (xpp.getName().equals("LabReport"))
      return parseLabReport(xpp);
    else if (xpp.getName().equals("DocumentConformance"))
      return parseDocumentConformance(xpp);
    return null;
  }

  protected Type parseType(String prefix, XmlPullParser xpp) throws Exception {
    if (xpp.getName().equals(prefix+"Coding"))
      return parseCoding(xpp);
    else if (xpp.getName().equals(prefix+"Interval_Quantity"))
      return parseInterval_Quantity(xpp);
    else if (xpp.getName().equals(prefix+"Interval_DateTime"))
      return parseInterval_DateTime(xpp);
    else if (xpp.getName().equals(prefix+"Interval_Date"))
      return parseInterval_Date(xpp);
    else if (xpp.getName().equals(prefix+"Quantity"))
      return parseQuantity(xpp);
    else if (xpp.getName().equals(prefix+"Choice"))
      return parseChoice(xpp);
    else if (xpp.getName().equals(prefix+"Attachment"))
      return parseAttachment(xpp);
    else if (xpp.getName().equals(prefix+"Ratio"))
      return parseRatio(xpp);
    else if (xpp.getName().equals(prefix+"CodeableConcept"))
      return parseCodeableConcept(xpp);
    else if (xpp.getName().equals(prefix+"Identifier"))
      return parseIdentifier(xpp);
    else if (xpp.getName().equals(prefix+"Count"))
      return parseCount(xpp);
    else if (xpp.getName().equals(prefix+"Money"))
      return parseMoney(xpp);
    else if (xpp.getName().equals(prefix+"Distance"))
      return parseDistance(xpp);
    else if (xpp.getName().equals(prefix+"Duration"))
      return parseDuration(xpp);
    else if (xpp.getName().equals(prefix+"Schedule"))
      return parseSchedule(xpp);
    else if (xpp.getName().equals(prefix+"Contact"))
      return parseContact(xpp);
    else if (xpp.getName().equals(prefix+"Address"))
      return parseAddress(xpp);
    else if (xpp.getName().equals(prefix+"HumanName"))
      return parseHumanName(xpp);
    else if (xpp.getName().equals(prefix+"HumanId"))
      return parseHumanId(xpp);
    else if (xpp.getName().equals(prefix+"Sid"))
      return parseSid(xpp);
    else if (xpp.getName().equals(prefix+"DateTime"))
      return parseDateTime(xpp);
    else if (xpp.getName().equals(prefix+"Integer"))
      return parseInteger(xpp);
    else if (xpp.getName().equals(prefix+"Code"))
      return parseCode(xpp);
    else if (xpp.getName().equals(prefix+"Date"))
      return parseDate(xpp);
    else if (xpp.getName().equals(prefix+"Decimal"))
      return parseDecimal(xpp);
    else if (xpp.getName().equals(prefix+"Uri"))
      return parseUri(xpp);
    else if (xpp.getName().equals(prefix+"Id"))
      return parseId(xpp);
    else if (xpp.getName().equals(prefix+"Base64Binary"))
      return parseBase64Binary(xpp);
    else if (xpp.getName().equals(prefix+"Oid"))
      return parseOid(xpp);
    else if (xpp.getName().equals(prefix+"String"))
      return parseString_(xpp);
    else if (xpp.getName().equals(prefix+"Boolean"))
      return parseBoolean(xpp);
    else if (xpp.getName().equals(prefix+"Uuid"))
      return parseUuid(xpp);
    else if (xpp.getName().equals(prefix+"Instant"))
      return parseInstant(xpp);
    throw new Exception("Unknown type "+xpp.getName());
  }

  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) {
        if (xpp.getName().equals(prefix+"Coding"))
      return true;
    if (xpp.getName().equals(prefix+"Interval_Quantity"))
      return true;
    if (xpp.getName().equals(prefix+"Interval_DateTime"))
      return true;
    if (xpp.getName().equals(prefix+"Interval_Date"))
      return true;
    if (xpp.getName().equals(prefix+"Quantity"))
      return true;
    if (xpp.getName().equals(prefix+"Choice"))
      return true;
    if (xpp.getName().equals(prefix+"Attachment"))
      return true;
    if (xpp.getName().equals(prefix+"Ratio"))
      return true;
    if (xpp.getName().equals(prefix+"CodeableConcept"))
      return true;
    if (xpp.getName().equals(prefix+"Identifier"))
      return true;
    if (xpp.getName().equals(prefix+"Count"))
      return true;
    if (xpp.getName().equals(prefix+"Money"))
      return true;
    if (xpp.getName().equals(prefix+"Distance"))
      return true;
    if (xpp.getName().equals(prefix+"Duration"))
      return true;
    if (xpp.getName().equals(prefix+"Schedule"))
      return true;
    if (xpp.getName().equals(prefix+"Contact"))
      return true;
    if (xpp.getName().equals(prefix+"Address"))
      return true;
    if (xpp.getName().equals(prefix+"HumanName"))
      return true;
    if (xpp.getName().equals(prefix+"HumanId"))
      return true;
    if (xpp.getName().equals(prefix+"Conformance"))
      return true;
    if (xpp.getName().equals(prefix+"Document"))
      return true;
    if (xpp.getName().equals(prefix+"Message"))
      return true;
    if (xpp.getName().equals(prefix+"Animal"))
      return true;
    if (xpp.getName().equals(prefix+"Agent"))
      return true;
    if (xpp.getName().equals(prefix+"MessageConformance"))
      return true;
    if (xpp.getName().equals(prefix+"Organization"))
      return true;
    if (xpp.getName().equals(prefix+"Prescription"))
      return true;
    if (xpp.getName().equals(prefix+"Profile"))
      return true;
    if (xpp.getName().equals(prefix+"Lloyd"))
      return true;
    if (xpp.getName().equals(prefix+"Woody"))
      return true;
    if (xpp.getName().equals(prefix+"Linda"))
      return true;
    if (xpp.getName().equals(prefix+"Ewout"))
      return true;
    if (xpp.getName().equals(prefix+"Patient"))
      return true;
    if (xpp.getName().equals(prefix+"Valueset"))
      return true;
    if (xpp.getName().equals(prefix+"PaulK"))
      return true;
    if (xpp.getName().equals(prefix+"Amnon"))
      return true;
    if (xpp.getName().equals(prefix+"Person"))
      return true;
    if (xpp.getName().equals(prefix+"LabReport"))
      return true;
    if (xpp.getName().equals(prefix+"DocumentConformance"))
      return true;
    if (xpp.getName().equals(prefix+"Sid"))
      return true;
    if (xpp.getName().equals(prefix+"DateTime"))
      return true;
    if (xpp.getName().equals(prefix+"Integer"))
      return true;
    if (xpp.getName().equals(prefix+"Code"))
      return true;
    if (xpp.getName().equals(prefix+"Date"))
      return true;
    if (xpp.getName().equals(prefix+"Decimal"))
      return true;
    if (xpp.getName().equals(prefix+"Uri"))
      return true;
    if (xpp.getName().equals(prefix+"Id"))
      return true;
    if (xpp.getName().equals(prefix+"Base64Binary"))
      return true;
    if (xpp.getName().equals(prefix+"Oid"))
      return true;
    if (xpp.getName().equals(prefix+"String"))
      return true;
    if (xpp.getName().equals(prefix+"Boolean"))
      return true;
    if (xpp.getName().equals(prefix+"Uuid"))
      return true;
    if (xpp.getName().equals(prefix+"Instant"))
      return true;
    return false;
  }
}

