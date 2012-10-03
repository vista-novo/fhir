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
import org.xmlpull.v1.*;

public class XmlParser extends XmlParserBase {

  private Extension parseExtension(XmlPullParser xpp) throws Exception {
    Extension res = new Extension();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ref")) {
        res.setRef(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustUnderstand")) {
        res.setMustUnderstand(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtension().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Narrative parseNarrative(XmlPullParser xpp) throws Exception {
    Narrative res = new Narrative();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Narrative.NarrativeStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div")) {
        res.setDiv(parseXhtml(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("image")) {
        res.getImage().add(parseNarrativeImage(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("map")) {
        res.getMap().add(parseNarrativeMap(xpp, res));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Narrative.Image parseNarrativeImage(XmlPullParser xpp, Narrative owner) throws Exception {
    Narrative.Image res = owner.new Image();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Narrative.Map parseNarrativeMap(XmlPullParser xpp, Narrative owner) throws Exception {
    Narrative.Map res = owner.new Map();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Period parsePeriod(XmlPullParser xpp) throws Exception {
    Period res = new Period();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("start")) {
        res.setStart(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("end")) {
        res.setEnd(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Coding parseCoding(XmlPullParser xpp) throws Exception {
    Coding res = new Coding();
    parseTypeAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Range parseRange(XmlPullParser xpp) throws Exception {
    Range res = new Range();
    parseTypeAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Quantity parseQuantity(XmlPullParser xpp) throws Exception {
    Quantity res = new Quantity();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
        res.setRange(Quantity.QuantityRange.fromCode(parseString(xpp)));
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
    xpp.next();
    return res;
  }

  private Choice parseChoice(XmlPullParser xpp) throws Exception {
    Choice res = new Choice();
    parseTypeAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Choice.Value parseChoiceValue(XmlPullParser xpp, Choice owner) throws Exception {
    Choice.Value res = owner.new Value();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Attachment parseAttachment(XmlPullParser xpp) throws Exception {
    Attachment res = new Attachment();
    parseTypeAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Ratio parseRatio(XmlPullParser xpp) throws Exception {
    Ratio res = new Ratio();
    parseTypeAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private ResourceReference parseResourceReference(XmlPullParser xpp) throws Exception {
    ResourceReference res = new ResourceReference();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private CodeableConcept parseCodeableConcept(XmlPullParser xpp) throws Exception {
    CodeableConcept res = new CodeableConcept();
    parseTypeAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Identifier parseIdentifier(XmlPullParser xpp) throws Exception {
    Identifier res = new Identifier();
    parseTypeAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Age parseAge(XmlPullParser xpp) throws Exception {
    Age res = new Age();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
        res.setRange(Quantity.QuantityRange.fromCode(parseString(xpp)));
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
    xpp.next();
    return res;
  }

  private Count parseCount(XmlPullParser xpp) throws Exception {
    Count res = new Count();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
        res.setRange(Quantity.QuantityRange.fromCode(parseString(xpp)));
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
    xpp.next();
    return res;
  }

  private Money parseMoney(XmlPullParser xpp) throws Exception {
    Money res = new Money();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
        res.setRange(Quantity.QuantityRange.fromCode(parseString(xpp)));
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
    xpp.next();
    return res;
  }

  private Distance parseDistance(XmlPullParser xpp) throws Exception {
    Distance res = new Distance();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
        res.setRange(Quantity.QuantityRange.fromCode(parseString(xpp)));
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
    xpp.next();
    return res;
  }

  private Duration parseDuration(XmlPullParser xpp) throws Exception {
    Duration res = new Duration();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("range")) {
        res.setRange(Quantity.QuantityRange.fromCode(parseString(xpp)));
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
    xpp.next();
    return res;
  }

  private Schedule parseSchedule(XmlPullParser xpp) throws Exception {
    Schedule res = new Schedule();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repeat")) {
        res.setRepeat(parseScheduleRepeat(xpp, res));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Schedule.Repeat parseScheduleRepeat(XmlPullParser xpp, Schedule owner) throws Exception {
    Schedule.Repeat res = owner.new Repeat();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Contact parseContact(XmlPullParser xpp) throws Exception {
    Contact res = new Contact();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(Contact.ContactSystem.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(Contact.ContactUse.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Address parseAddress(XmlPullParser xpp) throws Exception {
    Address res = new Address();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(Address.AddressUse.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("part")) {
        res.getPart().add(parseAddressPart(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Address.Part parseAddressPart(XmlPullParser xpp, Address owner) throws Exception {
    Address.Part res = owner.new Part();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private HumanName parseHumanName(XmlPullParser xpp) throws Exception {
    HumanName res = new HumanName();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(HumanName.NameUse.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("part")) {
        res.getPart().add(parseHumanNamePart(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private HumanName.Part parseHumanNamePart(XmlPullParser xpp, HumanName owner) throws Exception {
    HumanName.Part res = owner.new Part();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private HumanId parseHumanId(XmlPullParser xpp) throws Exception {
    HumanId res = new HumanId();
    parseTypeAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("assigner")) {
        res.setAssigner(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsEntry parseXdsEntry(XmlPullParser xpp) throws Exception {
    XdsEntry res = new XdsEntry();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repositoryId")) {
        res.setRepositoryId(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mimeType")) {
        res.setMimeType(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("format")) {
        res.setFormat(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("class")) {
        res.setClass_(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentId")) {
        res.setDocumentId(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("availability")) {
        res.setAvailability(XdsEntry.XdsEntryAvailability.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("confidentiality")) {
        res.getConfidentiality().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("created")) {
        res.setCreated(parseInstantSimple(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hash")) {
        res.setHash(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("size")) {
        res.setSize(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
        res.setLanguage(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("folder")) {
        res.getFolder().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientId")) {
        res.setPatientId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("sourcePatientId")) {
        res.setSourcePatientId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientInfo")) {
        res.setPatientInfo(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseXdsEntryAuthor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("authenticator")) {
        res.setAuthenticator(parseXdsEntryAuthenticator(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("facilityType")) {
        res.setFacilityType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("practiceSetting")) {
        res.setPracticeSetting(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("homeCommunity")) {
        res.setHomeCommunity(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("service")) {
        res.setService(parseXdsEntryService(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsEntry.Author parseXdsEntryAuthor(XmlPullParser xpp, XdsEntry owner) throws Exception {
    XdsEntry.Author res = owner.new Author();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.getRole().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("specialty")) {
        res.getSpecialty().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("institution")) {
        res.getInstitution().add(parseXdsEntryInstitution(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsEntry.Institution parseXdsEntryInstitution(XmlPullParser xpp, XdsEntry owner) throws Exception {
    XdsEntry.Institution res = owner.new Institution();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsEntry.Authenticator parseXdsEntryAuthenticator(XmlPullParser xpp, XdsEntry owner) throws Exception {
    XdsEntry.Authenticator res = owner.new Authenticator();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseHumanName(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsEntry.Service parseXdsEntryService(XmlPullParser xpp, XdsEntry owner) throws Exception {
    XdsEntry.Service res = owner.new Service();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("start")) {
        res.setStart(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stop")) {
        res.setStop(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance parseConformance(XmlPullParser xpp) throws Exception {
    Conformance res = new Conformance();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("publisher")) {
        res.setPublisher(parseConformancePublisher(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("implementation")) {
        res.setImplementation(parseConformanceImplementation(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("software")) {
        res.setSoftware(parseConformanceSoftware(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("proposal")) {
        res.setProposal(parseConformanceProposal(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("acceptUnknown")) {
        res.setAcceptUnknown(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("rest")) {
        res.getRest().add(parseConformanceRest(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("messaging")) {
        res.getMessaging().add(parseConformanceMessaging(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("document")) {
        res.getDocument().add(parseConformanceDocument(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Publisher parseConformancePublisher(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Publisher res = owner.new Publisher();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.setAddress(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Implementation parseConformanceImplementation(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Implementation res = owner.new Implementation();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
        res.setUrl(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Software parseConformanceSoftware(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Software res = owner.new Software();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("releaseDate")) {
        res.setReleaseDate(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Proposal parseConformanceProposal(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Proposal res = owner.new Proposal();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Rest parseConformanceRest(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Rest res = owner.new Rest();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(Conformance.RestfulConformanceMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseConformanceResource(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Resource parseConformanceResource(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Resource res = owner.new Resource();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("operation")) {
        res.getOperation().add(parseConformanceOperation(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("search")) {
        res.setSearch(parseConformanceSearch(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Operation parseConformanceOperation(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Operation res = owner.new Operation();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(Conformance.RestfulOperation.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Search parseConformanceSearch(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Search res = owner.new Search();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("param")) {
        res.getParam().add(parseConformanceParam(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Param parseConformanceParam(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Param res = owner.new Param();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Messaging parseConformanceMessaging(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Messaging res = owner.new Messaging();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("endpoint")) {
        res.setEndpoint(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parseConformanceEvent(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Event parseConformanceEvent(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Event res = owner.new Event();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(Conformance.MessageConformanceEventMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("protocol")) {
        res.getProtocol().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("focus")) {
        res.setFocus(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("request")) {
        res.setRequest(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("response")) {
        res.setResponse(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance.Document parseConformanceDocument(XmlPullParser xpp, Conformance owner) throws Exception {
    Conformance.Document res = owner.new Document();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(Conformance.DocumentMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DocumentHeader parseDocumentHeader(XmlPullParser xpp) throws Exception {
    DocumentHeader res = new DocumentHeader();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instant")) {
        res.setInstant(parseInstantSimple(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("replaces")) {
        res.setReplaces(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("enterer")) {
        res.setEnterer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("informant")) {
        res.setInformant(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.getAuthor().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("attester")) {
        res.getAttester().add(parseDocumentHeaderAttester(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("recipient")) {
        res.getRecipient().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("custodian")) {
        res.setCustodian(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("context")) {
        res.setContext(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounter")) {
        res.setEncounter(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stylesheet")) {
        res.setStylesheet(parseAttachment(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("representation")) {
        res.setRepresentation(parseAttachment(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section")) {
        res.getSection().add(parseDocumentHeaderSection(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DocumentHeader.Attester parseDocumentHeaderAttester(XmlPullParser xpp, DocumentHeader owner) throws Exception {
    DocumentHeader.Attester res = owner.new Attester();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(DocumentHeader.DocumentAuthenticationMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
        res.setTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("party")) {
        res.setParty(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DocumentHeader.Section parseDocumentHeaderSection(XmlPullParser xpp, DocumentHeader owner) throws Exception {
    DocumentHeader.Section res = owner.new Section();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instant")) {
        res.setInstant(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("enterer")) {
        res.setEnterer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("informant")) {
        res.setInformant(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        res.setContent(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section")) {
        res.getSection().add(parseDocumentHeaderSection(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Device parseDevice(XmlPullParser xpp) throws Exception {
    Device res = new Device();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("manufacturer")) {
        res.setManufacturer(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("model")) {
        res.setModel(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("serialNumber")) {
        res.setSerialNumber(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("owner")) {
        res.setOwner(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("assignedId")) {
        res.getAssignedId().add(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
        res.setLocation(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.setAddress(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Animal parseAnimal(XmlPullParser xpp) throws Exception {
    Animal res = new Animal();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
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
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Animal.RelatedEntity parseAnimalRelatedEntity(XmlPullParser xpp, Animal owner) throws Exception {
    Animal.RelatedEntity res = owner.new RelatedEntity();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseHumanId(xpp));
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
    xpp.next();
    return res;
  }

  private Agent parseAgent(XmlPullParser xpp) throws Exception {
    Agent res = new Agent();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("person")) {
        res.setPerson(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("organization")) {
        res.setOrganization(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.getRole().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Organization parseOrganization(XmlPullParser xpp) throws Exception {
    Organization res = new Organization();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
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
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Organization.Name parseOrganizationName(XmlPullParser xpp, Organization owner) throws Exception {
    Organization.Name res = owner.new Name();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Organization.Accreditation parseOrganizationAccreditation(XmlPullParser xpp, Organization owner) throws Exception {
    Organization.Accreditation res = owner.new Accreditation();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("institution")) {
        res.setInstitution(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Organization.RelatedOrganization parseOrganizationRelatedOrganization(XmlPullParser xpp, Organization owner) throws Exception {
    Organization.RelatedOrganization res = owner.new RelatedOrganization();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Prescription parsePrescription(XmlPullParser xpp) throws Exception {
    Prescription res = new Prescription();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(Prescription.PrescriptionStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
        res.setPatient(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prescriber")) {
        res.setPrescriber(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prescribed")) {
        res.setPrescribed(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dispense")) {
        res.setDispense(parsePrescriptionDispense(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("medicine")) {
        res.setMedicine(parsePrescriptionMedicine(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("administrationRequest")) {
        res.setAdministrationRequest(parsePrescriptionAdministrationRequest(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Prescription.Dispense parsePrescriptionDispense(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.Dispense res = owner.new Dispense();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repeats")) {
        res.setRepeats(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("quantity")) {
        res.setQuantity(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dispenser")) {
        res.setDispenser(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Prescription.Medicine parsePrescriptionMedicine(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.Medicine res = owner.new Medicine();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identification")) {
        res.setIdentification(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("activeIngredient")) {
        res.getActiveIngredient().add(parsePrescriptionActiveIngredient(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("inactiveIngredient")) {
        res.getInactiveIngredient().add(parsePrescriptionInactiveIngredient(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Prescription.ActiveIngredient parsePrescriptionActiveIngredient(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.ActiveIngredient res = owner.new ActiveIngredient();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identification")) {
        res.setIdentification(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "quantity")) {
        res.setQuantity(parseType("quantity", xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Prescription.InactiveIngredient parsePrescriptionInactiveIngredient(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.InactiveIngredient res = owner.new InactiveIngredient();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identification")) {
        res.setIdentification(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "quantity")) {
        res.setQuantity(parseType("quantity", xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Prescription.AdministrationRequest parsePrescriptionAdministrationRequest(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.AdministrationRequest res = owner.new AdministrationRequest();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Prescription.DosageInstruction parsePrescriptionDosageInstruction(XmlPullParser xpp, Prescription owner) throws Exception {
    Prescription.DosageInstruction res = owner.new DosageInstruction();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("precondition")) {
        res.getPrecondition().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prn")) {
        res.setPrn(parseBool(xpp));
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
    xpp.next();
    return res;
  }

  private Profile parseProfile(XmlPullParser xpp) throws Exception {
    Profile res = new Profile();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseProfileAuthor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseProfileStatus(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("import")) {
        res.getImport().add(parseProfileImport(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("bundle")) {
        res.setBundle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseProfileResource(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensionDefn")) {
        res.getExtensionDefn().add(parseProfileExtensionDefn(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("binding")) {
        res.getBinding().add(parseProfileBinding(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Author parseProfileAuthor(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Author res = owner.new Author();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reference")) {
        res.getReference().add(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Status parseProfileStatus(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Status res = owner.new Status();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(Profile.ResourceProfileStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comment")) {
        res.setComment(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Import parseProfileImport(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Import res = owner.new Import();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uri")) {
        res.setUri(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prefix")) {
        res.setPrefix(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Resource parseProfileResource(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Resource res = owner.new Resource();
    parseElementAttributes(xpp, res);
    xpp.next();
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
        res.getElement().add(parseProfileElement_(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Element_ parseProfileElement_(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Element_ res = owner.new Element_();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("path")) {
        res.setPath(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseProfileDefinition(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("bundled")) {
        res.setBundled(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("closed")) {
        res.setClosed(parseBool(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Definition parseProfileDefinition(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Definition res = owner.new Definition();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("short")) {
        res.setShort(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("formal")) {
        res.setFormal(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requirements")) {
        res.setRequirements(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("synonym")) {
        res.getSynonym().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("min")) {
        res.setMin(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("max")) {
        res.setMax(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.getType().add(parseProfileType(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("nameReference")) {
        res.setNameReference(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("maxLength")) {
        res.setMaxLength(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dataAbsentReason")) {
        res.setDataAbsentReason(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("condition")) {
        res.getCondition().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("constraint")) {
        res.getConstraint().add(parseProfileConstraint(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustSupport")) {
        res.setMustSupport(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustUnderstand")) {
        res.setMustUnderstand(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("binding")) {
        res.setBinding(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mapping")) {
        res.getMapping().add(parseProfileMapping(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Type parseProfileType(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Type res = owner.new Type();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Constraint parseProfileConstraint(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Constraint res = owner.new Constraint();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("severity")) {
        res.setSeverity(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("human")) {
        res.setHuman(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("xpath")) {
        res.setXpath(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ocl")) {
        res.setOcl(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Mapping parseProfileMapping(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Mapping res = owner.new Mapping();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private Profile.ExtensionDefn parseProfileExtensionDefn(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.ExtensionDefn res = owner.new ExtensionDefn();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contextType")) {
        res.setContextType(Profile.ExtensionContext.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("context")) {
        res.getContext().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseProfileDefinition(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Binding parseProfileBinding(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Binding res = owner.new Binding();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(Profile.BindingType.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("isExtensible")) {
        res.setIsExtensible(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("conformance")) {
        res.setConformance(Profile.BindingConformance.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reference")) {
        res.setReference(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("concept")) {
        res.getConcept().add(parseProfileConcept(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.Concept parseProfileConcept(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.Concept res = owner.new Concept();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("display")) {
        res.setDisplay(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private ValueSet parseValueSet(XmlPullParser xpp) throws Exception {
    ValueSet res = new ValueSet();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseValueSetAuthor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(ValueSet.ValuesetStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("restricts")) {
        res.getRestricts().add(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("import")) {
        res.getImport().add(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("include")) {
        res.getInclude().add(parseValueSetInclude(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("exclude")) {
        res.getExclude().add(parseValueSetInclude(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private ValueSet.Author parseValueSetAuthor(XmlPullParser xpp, ValueSet owner) throws Exception {
    ValueSet.Author res = owner.new Author();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reference")) {
        res.setReference(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private ValueSet.Include parseValueSetInclude(XmlPullParser xpp, ValueSet owner) throws Exception {
    ValueSet.Include res = owner.new Include();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(ValueSet.CodeSelectionMode.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("filter")) {
        res.getFilter().add(parseValueSetFilter(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private ValueSet.Filter parseValueSetFilter(XmlPullParser xpp, ValueSet owner) throws Exception {
    ValueSet.Filter res = owner.new Filter();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("property")) {
        res.setProperty(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("op")) {
        res.setOp(ValueSet.FilterOperator.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Problem parseProblem(XmlPullParser xpp) throws Exception {
    Problem res = new Problem();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("category")) {
        res.setCategory(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("certainty")) {
        res.setCertainty(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("severity")) {
        res.setSeverity(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "onset")) {
        res.setOnset(parseType("onset", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dateFound")) {
        res.setDateFound(parseDate(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "abatement")) {
        res.setAbatement(parseType("abatement", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stage")) {
        res.setStage(parseProblemStage(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("evidence")) {
        res.getEvidence().add(parseProblemEvidence(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
        res.setLocation(parseProblemLocation(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relatedItem")) {
        res.getRelatedItem().add(parseProblemRelatedItem(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Problem.Stage parseProblemStage(XmlPullParser xpp, Problem owner) throws Exception {
    Problem.Stage res = owner.new Stage();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("summary")) {
        res.setSummary(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("assessment")) {
        res.getAssessment().add(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Problem.Evidence parseProblemEvidence(XmlPullParser xpp, Problem owner) throws Exception {
    Problem.Evidence res = owner.new Evidence();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Problem.Location parseProblemLocation(XmlPullParser xpp, Problem owner) throws Exception {
    Problem.Location res = owner.new Location();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Problem.RelatedItem parseProblemRelatedItem(XmlPullParser xpp, Problem owner) throws Exception {
    Problem.RelatedItem res = owner.new RelatedItem();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(Problem.ProblemRelationshipType.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
        res.setTarget(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Test parseTest(XmlPullParser xpp) throws Exception {
    Test res = new Test();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stringErr")) {
        res.getStringErr().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stringCorr")) {
        res.getStringCorr().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("booleanErr")) {
        res.getBooleanErr().add(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("booleanCorr")) {
        res.getBooleanCorr().add(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("integerErr")) {
        res.getIntegerErr().add(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("integerCorr")) {
        res.getIntegerCorr().add(parseInt(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("decimalErr")) {
        res.getDecimalErr().add(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("decimalCorr")) {
        res.getDecimalCorr().add(parseBigDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("b64Err")) {
        res.getB64Err().add(parseBytes(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("b64Corr")) {
        res.getB64Corr().add(parseBytes(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instantErr")) {
        res.getInstantErr().add(parseInstantSimple(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instantCorr")) {
        res.getInstantCorr().add(parseInstantSimple(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uriErr")) {
        res.getUriErr().add(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uriCorr")) {
        res.getUriCorr().add(parseURI(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private MessageHeader parseMessageHeader(XmlPullParser xpp) throws Exception {
    MessageHeader res = new MessageHeader();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instant")) {
        res.setInstant(parseInstantSimple(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.setEvent(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("response")) {
        res.setResponse(parseMessageHeaderResponse(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.setSource(parseMessageHeaderSource(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("destination")) {
        res.setDestination(parseMessageHeaderDestination(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("enterer")) {
        res.setEnterer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("receiver")) {
        res.setReceiver(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("responsible")) {
        res.setResponsible(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("effective")) {
        res.setEffective(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
        res.getData().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private MessageHeader.Response parseMessageHeaderResponse(XmlPullParser xpp, MessageHeader owner) throws Exception {
    MessageHeader.Response res = owner.new Response();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(MessageHeader.ResponseCode.fromCode(parseString(xpp)));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private MessageHeader.Source parseMessageHeaderSource(XmlPullParser xpp, MessageHeader owner) throws Exception {
    MessageHeader.Source res = owner.new Source();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("software")) {
        res.setSoftware(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.setContact(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("endpoint")) {
        res.setEndpoint(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private MessageHeader.Destination parseMessageHeaderDestination(XmlPullParser xpp, MessageHeader owner) throws Exception {
    MessageHeader.Destination res = owner.new Destination();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
        res.setTarget(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("endpoint")) {
        res.setEndpoint(parseURI(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Patient parsePatient(XmlPullParser xpp) throws Exception {
    Patient res = new Patient();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("link")) {
        res.getLink().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("active")) {
        res.setActive(parseBool(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
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
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private AssessmentScale parseAssessmentScale(XmlPullParser xpp) throws Exception {
    AssessmentScale res = new AssessmentScale();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("performer")) {
        res.setPerformer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
        res.setTime(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("interpretation")) {
        res.getInterpretation().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("score")) {
        res.setScore(parseAssessmentScaleScore(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private AssessmentScale.Score parseAssessmentScaleScore(XmlPullParser xpp, AssessmentScale owner) throws Exception {
    AssessmentScale.Score res = owner.new Score();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("score")) {
        res.getScore().add(parseAssessmentScaleScore(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("measure")) {
        res.getMeasure().add(parseAssessmentScaleMeasure(xpp, owner));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private AssessmentScale.Measure parseAssessmentScaleMeasure(XmlPullParser xpp, AssessmentScale owner) throws Exception {
    AssessmentScale.Measure res = owner.new Measure();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
        res.setTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.setSource(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Person parsePerson(XmlPullParser xpp) throws Exception {
    Person res = new Person();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseHumanId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.getName().add(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("telecom")) {
        res.getTelecom().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("gender")) {
        res.setGender(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("birthDate")) {
        res.setBirthDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("deceased")) {
        res.setDeceased(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("maritalStatus")) {
        res.setMaritalStatus(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contactParty")) {
        res.getContactParty().add(parsePersonContactParty(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
        res.getLanguage().add(parsePersonLanguage(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Person.ContactParty parsePersonContactParty(XmlPullParser xpp, Person owner) throws Exception {
    Person.ContactParty res = owner.new ContactParty();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.setRole(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("telecom")) {
        res.getTelecom().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("party")) {
        res.setParty(parseResourceReference(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Person.Language parsePersonLanguage(XmlPullParser xpp, Person owner) throws Exception {
    Person.Language res = owner.new Language();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("level")) {
        res.setLevel(Person.LanguageUse.fromCode(parseString(xpp)));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private LabReport parseLabReport(XmlPullParser xpp) throws Exception {
    LabReport res = new LabReport();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(LabReport.LabReportStatus.fromCode(parseString(xpp)));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("issued")) {
        res.setIssued(parseInstantSimple(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
        res.setPatient(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("admission")) {
        res.setAdmission(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("laboratory")) {
        res.setLaboratory(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reportId")) {
        res.setReportId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requestDetail")) {
        res.getRequestDetail().add(parseLabReportRequestDetail(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reportName")) {
        res.setReportName(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("service")) {
        res.setService(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("diagnosticTime")) {
        res.setDiagnosticTime(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("specimen")) {
        res.getSpecimen().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resultGroup")) {
        res.getResultGroup().add(parseLabReportResultGroup(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("conclusion")) {
        res.setConclusion(parseString_(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("codedDiagnosis")) {
        res.getCodedDiagnosis().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("representation")) {
        res.getRepresentation().add(parseAttachment(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private LabReport.RequestDetail parseLabReportRequestDetail(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.RequestDetail res = owner.new RequestDetail();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private LabReport.ResultGroup parseLabReportResultGroup(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.ResultGroup res = owner.new ResultGroup();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private LabReport.Result parseLabReportResult(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.Result res = owner.new Result();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private LabReport.ReferenceRange parseLabReportReferenceRange(XmlPullParser xpp, LabReport owner) throws Exception {
    LabReport.ReferenceRange res = owner.new ReferenceRange();
    parseElementAttributes(xpp, res);
    xpp.next();
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
    xpp.next();
    return res;
  }

  private XdsFolder parseXdsFolder(XmlPullParser xpp) throws Exception {
    XdsFolder res = new XdsFolder();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientId")) {
        res.setPatientId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("homeCommunity")) {
        res.setHomeCommunity(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) {
          res.getExtensions().add(parseExtension(xpp));
          xpp.next();
          eventType = nextNoWhitespace(xpp);
        }
        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals("extension"))
          throw new Exception("XML Error in requestDetails");
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseNarrative(xpp));
      } else
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  @Override
  protected Resource parseResource(XmlPullParser xpp) throws Exception {
    if (xpp.getName().equals("XdsEntry"))
      return parseXdsEntry(xpp);
    else if (xpp.getName().equals("Conformance"))
      return parseConformance(xpp);
    else if (xpp.getName().equals("DocumentHeader"))
      return parseDocumentHeader(xpp);
    else if (xpp.getName().equals("Device"))
      return parseDevice(xpp);
    else if (xpp.getName().equals("Animal"))
      return parseAnimal(xpp);
    else if (xpp.getName().equals("Agent"))
      return parseAgent(xpp);
    else if (xpp.getName().equals("Organization"))
      return parseOrganization(xpp);
    else if (xpp.getName().equals("Prescription"))
      return parsePrescription(xpp);
    else if (xpp.getName().equals("Profile"))
      return parseProfile(xpp);
    else if (xpp.getName().equals("ValueSet"))
      return parseValueSet(xpp);
    else if (xpp.getName().equals("Problem"))
      return parseProblem(xpp);
    else if (xpp.getName().equals("Test"))
      return parseTest(xpp);
    else if (xpp.getName().equals("MessageHeader"))
      return parseMessageHeader(xpp);
    else if (xpp.getName().equals("Patient"))
      return parsePatient(xpp);
    else if (xpp.getName().equals("AssessmentScale"))
      return parseAssessmentScale(xpp);
    else if (xpp.getName().equals("Person"))
      return parsePerson(xpp);
    else if (xpp.getName().equals("LabReport"))
      return parseLabReport(xpp);
    else if (xpp.getName().equals("XdsFolder"))
      return parseXdsFolder(xpp);
    return null;
  }

  protected Type parseType(String prefix, XmlPullParser xpp) throws Exception {
    if (xpp.getName().equals(prefix+"Period"))
      return parsePeriod(xpp);
    else if (xpp.getName().equals(prefix+"Coding"))
      return parseCoding(xpp);
    else if (xpp.getName().equals(prefix+"Range"))
      return parseRange(xpp);
    else if (xpp.getName().equals(prefix+"Quantity"))
      return parseQuantity(xpp);
    else if (xpp.getName().equals(prefix+"Choice"))
      return parseChoice(xpp);
    else if (xpp.getName().equals(prefix+"Attachment"))
      return parseAttachment(xpp);
    else if (xpp.getName().equals(prefix+"Ratio"))
      return parseRatio(xpp);
    else if (xpp.getName().equals(prefix+"ResourceReference"))
      return parseResourceReference(xpp);
    else if (xpp.getName().equals(prefix+"CodeableConcept"))
      return parseCodeableConcept(xpp);
    else if (xpp.getName().equals(prefix+"Identifier"))
      return parseIdentifier(xpp);
    else if (xpp.getName().equals(prefix+"Age"))
      return parseAge(xpp);
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
        if (xpp.getName().equals(prefix+"Period"))
      return true;
    if (xpp.getName().equals(prefix+"Coding"))
      return true;
    if (xpp.getName().equals(prefix+"Range"))
      return true;
    if (xpp.getName().equals(prefix+"Quantity"))
      return true;
    if (xpp.getName().equals(prefix+"Choice"))
      return true;
    if (xpp.getName().equals(prefix+"Attachment"))
      return true;
    if (xpp.getName().equals(prefix+"Ratio"))
      return true;
    if (xpp.getName().equals(prefix+"ResourceReference"))
      return true;
    if (xpp.getName().equals(prefix+"CodeableConcept"))
      return true;
    if (xpp.getName().equals(prefix+"Identifier"))
      return true;
    if (xpp.getName().equals(prefix+"Age"))
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
    if (xpp.getName().equals(prefix+"XdsEntry"))
      return true;
    if (xpp.getName().equals(prefix+"Conformance"))
      return true;
    if (xpp.getName().equals(prefix+"DocumentHeader"))
      return true;
    if (xpp.getName().equals(prefix+"Device"))
      return true;
    if (xpp.getName().equals(prefix+"Animal"))
      return true;
    if (xpp.getName().equals(prefix+"Agent"))
      return true;
    if (xpp.getName().equals(prefix+"Organization"))
      return true;
    if (xpp.getName().equals(prefix+"Prescription"))
      return true;
    if (xpp.getName().equals(prefix+"Profile"))
      return true;
    if (xpp.getName().equals(prefix+"ValueSet"))
      return true;
    if (xpp.getName().equals(prefix+"Problem"))
      return true;
    if (xpp.getName().equals(prefix+"Test"))
      return true;
    if (xpp.getName().equals(prefix+"MessageHeader"))
      return true;
    if (xpp.getName().equals(prefix+"Patient"))
      return true;
    if (xpp.getName().equals(prefix+"AssessmentScale"))
      return true;
    if (xpp.getName().equals(prefix+"Person"))
      return true;
    if (xpp.getName().equals(prefix+"LabReport"))
      return true;
    if (xpp.getName().equals(prefix+"XdsFolder"))
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

