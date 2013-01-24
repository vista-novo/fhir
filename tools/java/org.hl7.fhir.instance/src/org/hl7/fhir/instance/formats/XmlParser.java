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

// Generated on Fri, Jan 25, 2013 06:40+1100 for FHIR v0.07

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
import org.xmlpull.v1.*;

public class XmlParser extends XmlParserBase {

  private boolean parseElementContent(int eventType, XmlPullParser xpp, Element res) throws Exception {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) 
      res.getExtensions().add(parseExtension(xpp));
    else
      return false;
      
    return true;
  }

  @SuppressWarnings("unchecked")
  private <E extends Enum<E>> Enumeration<E> parseEnumeration(XmlPullParser xpp, E item, EnumFactory e) throws Exception {
    Enumeration<E> res = new Enumeration<E>();
    parseElementAttributes(xpp, res);
    res.setValue((E) e.fromCode(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Integer parseInteger(XmlPullParser xpp) throws Exception {
    Integer res = new Integer();
    parseElementAttributes(xpp, res);
    res.setValue(parseIntegerPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DateTime parseDateTime(XmlPullParser xpp) throws Exception {
    DateTime res = new DateTime();
    parseElementAttributes(xpp, res);
    res.setValue(parseDateTimePrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Code parseCode(XmlPullParser xpp) throws Exception {
    Code res = new Code();
    parseElementAttributes(xpp, res);
    res.setValue(parseCodePrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Date parseDate(XmlPullParser xpp) throws Exception {
    Date res = new Date();
    parseElementAttributes(xpp, res);
    res.setValue(parseDatePrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Decimal parseDecimal(XmlPullParser xpp) throws Exception {
    Decimal res = new Decimal();
    parseElementAttributes(xpp, res);
    res.setValue(parseDecimalPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Uri parseUri(XmlPullParser xpp) throws Exception {
    Uri res = new Uri();
    parseElementAttributes(xpp, res);
    res.setValue(parseUriPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Id parseId(XmlPullParser xpp) throws Exception {
    Id res = new Id();
    parseElementAttributes(xpp, res);
    res.setValue(parseIdPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Base64Binary parseBase64Binary(XmlPullParser xpp) throws Exception {
    Base64Binary res = new Base64Binary();
    parseElementAttributes(xpp, res);
    res.setValue(parseBase64BinaryPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Oid parseOid(XmlPullParser xpp) throws Exception {
    Oid res = new Oid();
    parseElementAttributes(xpp, res);
    res.setValue(parseOidPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private String_ parseString(XmlPullParser xpp) throws Exception {
    String_ res = new String_();
    parseElementAttributes(xpp, res);
    res.setValue(parseStringPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Boolean parseBoolean(XmlPullParser xpp) throws Exception {
    Boolean res = new Boolean();
    parseElementAttributes(xpp, res);
    res.setValue(parseBooleanPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Uuid parseUuid(XmlPullParser xpp) throws Exception {
    Uuid res = new Uuid();
    parseElementAttributes(xpp, res);
    res.setValue(parseUuidPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Instant parseInstant(XmlPullParser xpp) throws Exception {
    Instant res = new Instant();
    parseElementAttributes(xpp, res);
    res.setValue(parseInstantPrimitive(xpp.getAttributeValue(null, "value")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Extension parseExtension(XmlPullParser xpp) throws Exception {
    Extension res = new Extension();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
        res.setUrl(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustUnderstand")) {
        res.setMustUnderstand(parseBoolean(xpp));
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setStatus(parseEnumeration(xpp, Narrative.NarrativeStatus.Null, new Narrative().new NarrativeStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("div")) {
        res.setDiv(parseXhtml(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("image")) {
        res.getImage().add(parseNarrativeImage(xpp, res));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setMimeType(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        res.setContent(parseBase64Binary(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setStart(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("end")) {
        res.setEnd(parseDateTime(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("display")) {
        res.setDisplay(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setValue(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comparator")) {
        res.setComparator(parseEnumeration(xpp, Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setCode(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("option")) {
        res.getOption().add(parseChoiceOption(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("isOrdered")) {
        res.setIsOrdered(parseBoolean(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Choice.Option parseChoiceOption(XmlPullParser xpp, Choice owner) throws Exception {
    Choice.Option res = owner.new Option();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("display")) {
        res.setDisplay(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Attachment parseAttachment(XmlPullParser xpp) throws Exception {
    Attachment res = new Attachment();
    parseTypeAttributes(xpp, res);
    if (xpp.getAttributeValue(null, "xml:Id") != null)
        res.setLanguage(Factory.newCode(xpp.getAttributeValue(null, "xml:Id")));
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contentType")) {
        res.setContentType(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("data")) {
        res.setData(parseBase64Binary(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
        res.setUrl(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("size")) {
        res.setSize(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hash")) {
        res.setHash(parseBase64Binary(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setType(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
        res.setUrl(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("display")) {
        res.setDisplay(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(parseEnumeration(xpp, Identifier.IdentifierUse.Null, new Identifier().new IdentifierUseEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("label")) {
        res.setLabel(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("assigner")) {
        res.setAssigner(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Age parseAge(XmlPullParser xpp) throws Exception {
    Age res = new Age();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comparator")) {
        res.setComparator(parseEnumeration(xpp, Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Count parseCount(XmlPullParser xpp) throws Exception {
    Count res = new Count();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comparator")) {
        res.setComparator(parseEnumeration(xpp, Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Money parseMoney(XmlPullParser xpp) throws Exception {
    Money res = new Money();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comparator")) {
        res.setComparator(parseEnumeration(xpp, Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Distance parseDistance(XmlPullParser xpp) throws Exception {
    Distance res = new Distance();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comparator")) {
        res.setComparator(parseEnumeration(xpp, Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Duration parseDuration(XmlPullParser xpp) throws Exception {
    Duration res = new Duration();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comparator")) {
        res.setComparator(parseEnumeration(xpp, Quantity.QuantityComparator.Null, new Quantity().new QuantityComparatorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCode(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Schedule parseSchedule(XmlPullParser xpp) throws Exception {
    Schedule res = new Schedule();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repeat")) {
        res.setRepeat(parseScheduleRepeat(xpp, res));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setFrequency(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("when")) {
        res.setWhen(parseEnumeration(xpp, Schedule.EventTiming.Null, new Schedule().new EventTimingEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("duration")) {
        res.setDuration(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("units")) {
        res.setUnits(parseEnumeration(xpp, Schedule.UnitsOfTime.Null, new Schedule().new UnitsOfTimeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("count")) {
        res.setCount(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("end")) {
        res.setEnd(parseDateTime(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Contact parseContact(XmlPullParser xpp) throws Exception {
    Contact res = new Contact();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("system")) {
        res.setSystem(parseEnumeration(xpp, Contact.ContactSystem.Null, new Contact().new ContactSystemEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(parseEnumeration(xpp, Contact.ContactUse.Null, new Contact().new ContactUseEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Address parseAddress(XmlPullParser xpp) throws Exception {
    Address res = new Address();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(parseEnumeration(xpp, Address.AddressUse.Null, new Address().new AddressUseEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("line")) {
        res.getLine().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("city")) {
        res.setCity(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("state")) {
        res.setState(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("zip")) {
        res.setZip(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("country")) {
        res.setCountry(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private HumanName parseHumanName(XmlPullParser xpp) throws Exception {
    HumanName res = new HumanName();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("use")) {
        res.setUse(parseEnumeration(xpp, HumanName.NameUse.Null, new HumanName().new NameUseEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
        res.setText(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("family")) {
        res.getFamily().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("given")) {
        res.getGiven().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prefix")) {
        res.getPrefix().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("suffix")) {
        res.getSuffix().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DocumentInformation parseDocumentInformation(XmlPullParser xpp) throws Exception {
    DocumentInformation res = new DocumentInformation();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("versionId")) {
        res.setVersionId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("created")) {
        res.setCreated(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("class")) {
        res.setClass_(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("confidentiality")) {
        res.setConfidentiality(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.getAuthor().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("attester")) {
        res.getAttester().add(parseDocumentInformationAttester(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("custodian")) {
        res.setCustodian(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.setEvent(parseDocumentInformationEvent(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounter")) {
        res.setEncounter(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("facilityType")) {
        res.setFacilityType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("practiceSetting")) {
        res.setPracticeSetting(parseCodeableConcept(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DocumentInformation.Attester parseDocumentInformationAttester(XmlPullParser xpp, DocumentInformation owner) throws Exception {
    DocumentInformation.Attester res = owner.new Attester();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(parseEnumeration(xpp, DocumentInformation.DocumentAttestationMode.Null, new DocumentInformation().new DocumentAttestationModeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("time")) {
        res.setTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("party")) {
        res.setParty(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DocumentInformation.Event parseDocumentInformationEvent(XmlPullParser xpp, DocumentInformation owner) throws Exception {
    DocumentInformation.Event res = owner.new Event();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("detail")) {
        res.getDetail().add(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Demographics parseDemographics(XmlPullParser xpp) throws Exception {
    Demographics res = new Demographics();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.getName().add(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("telecom")) {
        res.getTelecom().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("gender")) {
        res.setGender(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("birthDate")) {
        res.setBirthDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("deceased")) {
        res.setDeceased(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("maritalStatus")) {
        res.setMaritalStatus(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
        res.getLanguage().add(parseDemographicsLanguage(xpp, res));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Demographics.Language parseDemographicsLanguage(XmlPullParser xpp, Demographics owner) throws Exception {
    Demographics.Language res = owner.new Language();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("language")) {
        res.setLanguage(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("proficiencyLevel")) {
        res.setProficiencyLevel(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("preference")) {
        res.setPreference(parseBoolean(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private boolean parseResourceContent(int eventType, XmlPullParser xpp, Resource res) throws Exception {
    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extension")) { 
      res.getExtensions().add(parseExtension(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("text")) {
      res.setText(parseNarrative(xpp));
    } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contained")) {
      xpp.next();
      nextNoWhitespace(xpp);
      res.getContained().add(parse(xpp));
      xpp.next();
      nextNoWhitespace(xpp);
      xpp.next();
    } else
      return false;
      
    return true;
  }

  private CarePlan parseCarePlan(XmlPullParser xpp) throws Exception {
    CarePlan res = new CarePlan();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
        res.setPatient(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseEnumeration(xpp, CarePlan.CarePlanStatus.Null, new CarePlan().new CarePlanStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("modified")) {
        res.setModified(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("concern")) {
        res.getConcern().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("participant")) {
        res.getParticipant().add(parseCarePlanParticipant(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("goal")) {
        res.setGoal(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("activity")) {
        res.getActivity().add(parseCarePlanActivity(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private CarePlan.Participant parseCarePlanParticipant(XmlPullParser xpp, CarePlan owner) throws Exception {
    CarePlan.Participant res = owner.new Participant();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.setRole(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("member")) {
        res.setMember(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private CarePlan.Activity parseCarePlanActivity(XmlPullParser xpp, CarePlan owner) throws Exception {
    CarePlan.Activity res = owner.new Activity();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("category")) {
        res.setCategory(parseEnumeration(xpp, CarePlan.CarePlanActivityCategory.Null, new CarePlan().new CarePlanActivityCategoryEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prohibited")) {
        res.setProhibited(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("schedule")) {
        res.setSchedule(parseSchedule(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
        res.setLocation(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("performer")) {
        res.getPerformer().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("product")) {
        res.setProduct(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dailyAmount")) {
        res.setDailyAmount(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("quantity")) {
        res.setQuantity(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("action")) {
        res.getAction().add(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Provenance parseProvenance(XmlPullParser xpp) throws Exception {
    Provenance res = new Provenance();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
        res.setTarget(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("activity")) {
        res.setActivity(parseProvenanceActivity(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("party")) {
        res.getParty().add(parseProvenanceParty(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("signature")) {
        res.setSignature(parseString(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Provenance.Activity parseProvenanceActivity(XmlPullParser xpp, Provenance owner) throws Exception {
    Provenance.Activity res = owner.new Activity();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("recorded")) {
        res.setRecorded(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
        res.setLocation(parseProvenanceLocation(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("policy")) {
        res.setPolicy(parseUri(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Provenance.Location parseProvenanceLocation(XmlPullParser xpp, Provenance owner) throws Exception {
    Provenance.Location res = owner.new Location();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("coords")) {
        res.setCoords(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Provenance.Party parseProvenanceParty(XmlPullParser xpp, Provenance owner) throws Exception {
    Provenance.Party res = owner.new Party();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.setRole(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Device parseDevice(XmlPullParser xpp) throws Exception {
    Device res = new Device();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("manufacturer")) {
        res.setManufacturer(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("model")) {
        res.setModel(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identity")) {
        res.setIdentity(parseDeviceIdentity(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("owner")) {
        res.setOwner(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("assignedId")) {
        res.getAssignedId().add(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
        res.setLocation(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
        res.setPatient(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
        res.setUrl(parseUri(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Device.Identity parseDeviceIdentity(XmlPullParser xpp, Device owner) throws Exception {
    Device.Identity res = owner.new Identity();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("gtin")) {
        res.setGtin(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lot")) {
        res.setLot(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("serialNumber")) {
        res.setSerialNumber(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("expiry")) {
        res.setExpiry(parseDate(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Order parseOrder(XmlPullParser xpp) throws Exception {
    Order res = new Order();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.setSource(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
        res.setTarget(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("authority")) {
        res.setAuthority(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("payment")) {
        res.setPayment(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("when")) {
        res.setWhen(parseOrderWhen(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("detail")) {
        res.getDetail().add(parseResourceReference(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Order.When parseOrderWhen(XmlPullParser xpp, Order owner) throws Exception {
    Order.When res = owner.new When();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("schedule")) {
        res.setSchedule(parseSchedule(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Organization parseOrganization(XmlPullParser xpp) throws Exception {
    Organization res = new Organization();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.getName().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("telecom")) {
        res.getTelecom().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseEnumeration(xpp, Organization.RecordStatus.Null, new Organization().new RecordStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("accreditation")) {
        res.getAccreditation().add(parseOrganizationAccreditation(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relatedOrganization")) {
        res.getRelatedOrganization().add(parseOrganizationRelatedOrganization(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contactPerson")) {
        res.getContactPerson().add(parseOrganizationContactPerson(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("organization")) {
        res.setOrganization(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Organization.ContactPerson parseOrganizationContactPerson(XmlPullParser xpp, Organization owner) throws Exception {
    Organization.ContactPerson res = owner.new ContactPerson();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.setAddress(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("telecom")) {
        res.getTelecom().add(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("person")) {
        res.setPerson(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Prescription parsePrescription(XmlPullParser xpp) throws Exception {
    Prescription res = new Prescription();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseEnumeration(xpp, Prescription.PrescriptionStatus.Null, new Prescription().new PrescriptionStatusEnumFactory()));
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
      } else if (!parseResourceContent(eventType, xpp, res))
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
        res.setRepeats(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("quantity")) {
        res.setQuantity(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dispenser")) {
        res.setDispenser(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setDescription(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("totalPeriodicDose")) {
        res.setTotalPeriodicDose(parseRatio(xpp));
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setPrn(parseBoolean(xpp));
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
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Group parseGroup(XmlPullParser xpp) throws Exception {
    Group res = new Group();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseEnumeration(xpp, Group.GroupType.Null, new Group().new GroupTypeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("actual")) {
        res.setActual(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("quantity")) {
        res.setQuantity(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("characteristic")) {
        res.getCharacteristic().add(parseGroupCharacteristic(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("member")) {
        res.getMember().add(parseResourceReference(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Group.Characteristic parseGroupCharacteristic(XmlPullParser xpp, Group owner) throws Exception {
    Group.Characteristic res = owner.new Characteristic();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("exclude")) {
        res.setExclude(parseBoolean(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DiagnosticReport parseDiagnosticReport(XmlPullParser xpp) throws Exception {
    DiagnosticReport res = new DiagnosticReport();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseEnumeration(xpp, DiagnosticReport.ObservationStatus.Null, new DiagnosticReport().new ObservationStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("issued")) {
        res.setIssued(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("performer")) {
        res.setPerformer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reportId")) {
        res.setReportId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requestDetail")) {
        res.getRequestDetail().add(parseDiagnosticReportRequestDetail(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounter")) {
        res.setEncounter(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("serviceCategory")) {
        res.setServiceCategory(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("diagnosticTime")) {
        res.setDiagnosticTime(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("results")) {
        res.setResults(parseDiagnosticReportResults(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("image")) {
        res.getImage().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("conclusion")) {
        res.setConclusion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("codedDiagnosis")) {
        res.getCodedDiagnosis().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("representation")) {
        res.getRepresentation().add(parseAttachment(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DiagnosticReport.RequestDetail parseDiagnosticReportRequestDetail(XmlPullParser xpp, DiagnosticReport owner) throws Exception {
    DiagnosticReport.RequestDetail res = owner.new RequestDetail();
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
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("bodySite")) {
        res.setBodySite(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requester")) {
        res.setRequester(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("clinicalInfo")) {
        res.setClinicalInfo(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private DiagnosticReport.Results parseDiagnosticReportResults(XmlPullParser xpp, DiagnosticReport owner) throws Exception {
    DiagnosticReport.Results res = owner.new Results();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("specimen")) {
        res.setSpecimen(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("group")) {
        res.getGroup().add(parseDiagnosticReportResults(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("result")) {
        res.getResult().add(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private ValueSet parseValueSet(XmlPullParser xpp) throws Exception {
    ValueSet res = new ValueSet();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.setAuthor(parseValueSetAuthor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseEnumeration(xpp, ValueSet.ValuesetStatus.Null, new ValueSet().new ValuesetStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("restricts")) {
        res.getRestricts().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("import")) {
        res.getImport().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("include")) {
        res.getInclude().add(parseValueSetInclude(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("exclude")) {
        res.getExclude().add(parseValueSetInclude(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
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
        res.setReference(parseUri(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(parseEnumeration(xpp, ValueSet.CodeSelectionMode.Null, new ValueSet().new CodeSelectionModeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("filter")) {
        res.getFilter().add(parseValueSetFilter(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setProperty(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("op")) {
        res.setOp(parseEnumeration(xpp, ValueSet.FilterOperator.Null, new ValueSet().new FilterOperatorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("value")) {
        res.setValue(parseCode(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Coverage parseCoverage(XmlPullParser xpp) throws Exception {
    Coverage res = new Coverage();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("issuer")) {
        res.setIssuer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("plan")) {
        res.setPlan(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subplan")) {
        res.setSubplan(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dependent")) {
        res.setDependent(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("sequence")) {
        res.setSequence(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("planHolder")) {
        res.setPlanHolder(parseCoveragePlanHolder(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Coverage.PlanHolder parseCoveragePlanHolder(XmlPullParser xpp, Coverage owner) throws Exception {
    Coverage.PlanHolder res = owner.new PlanHolder();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseHumanName(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.setAddress(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("birthdate")) {
        res.setBirthdate(parseDate(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Test parseTest(XmlPullParser xpp) throws Exception {
    Test res = new Test();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stringErr")) {
        res.getStringErr().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stringCorr")) {
        res.getStringCorr().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("booleanErr")) {
        res.getBooleanErr().add(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("booleanCorr")) {
        res.getBooleanCorr().add(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("integerErr")) {
        res.getIntegerErr().add(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("integerCorr")) {
        res.getIntegerCorr().add(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("decimalErr")) {
        res.getDecimalErr().add(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("decimalCorr")) {
        res.getDecimalCorr().add(parseDecimal(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("b64Err")) {
        res.getB64Err().add(parseBase64Binary(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("b64Corr")) {
        res.getB64Corr().add(parseBase64Binary(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instantErr")) {
        res.getInstantErr().add(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instantCorr")) {
        res.getInstantCorr().add(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uriErr")) {
        res.getUriErr().add(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uriCorr")) {
        res.getUriCorr().add(parseUri(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private MedicationAdministration parseMedicationAdministration(XmlPullParser xpp) throws Exception {
    MedicationAdministration res = new MedicationAdministration();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("administrationEventStatus")) {
        res.setAdministrationEventStatus(parseEnumeration(xpp, MedicationAdministration.MedAdmStatus.Null, new MedicationAdministration().new MedAdmStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("isNegated")) {
        res.setIsNegated(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("negatedReason")) {
        res.getNegatedReason().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("effectiveTime")) {
        res.setEffectiveTime(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("method")) {
        res.setMethod(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("approachSite")) {
        res.setApproachSite(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("route")) {
        res.setRoute(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("administeredDose")) {
        res.setAdministeredDose(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("doseRate")) {
        res.setDoseRate(parseQuantity(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.getId().add(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prescription")) {
        res.setPrescription(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patient")) {
        res.setPatient(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("medication")) {
        res.getMedication().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounter")) {
        res.setEncounter(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("administrationDevice")) {
        res.getAdministrationDevice().add(parseResourceReference(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private SecurityEvent parseSecurityEvent(XmlPullParser xpp) throws Exception {
    SecurityEvent res = new SecurityEvent();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.setEvent(parseSecurityEventEvent(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("participant")) {
        res.getParticipant().add(parseSecurityEventParticipant(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.getSource().add(parseSecurityEventSource(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("object")) {
        res.getObject().add(parseSecurityEventObject(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private SecurityEvent.Event parseSecurityEventEvent(XmlPullParser xpp, SecurityEvent owner) throws Exception {
    SecurityEvent.Event res = owner.new Event();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("action")) {
        res.setAction(parseEnumeration(xpp, SecurityEvent.SecurityEventEventAction.Null, new SecurityEvent().new SecurityEventEventActionEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dateTime")) {
        res.setDateTime(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("outcome")) {
        res.setOutcome(parseEnumeration(xpp, SecurityEvent.SecurityEventEventOutcome.Null, new SecurityEvent().new SecurityEventEventOutcomeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCoding(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private SecurityEvent.Participant parseSecurityEventParticipant(XmlPullParser xpp, SecurityEvent owner) throws Exception {
    SecurityEvent.Participant res = owner.new Participant();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("userId")) {
        res.setUserId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("otherUserId")) {
        res.setOtherUserId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requestor")) {
        res.setRequestor(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.getRole().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("network")) {
        res.setNetwork(parseSecurityEventNetwork(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private SecurityEvent.Network parseSecurityEventNetwork(XmlPullParser xpp, SecurityEvent owner) throws Exception {
    SecurityEvent.Network res = owner.new Network();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseEnumeration(xpp, SecurityEvent.NetworkType.Null, new SecurityEvent().new NetworkTypeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private SecurityEvent.Source parseSecurityEventSource(XmlPullParser xpp, SecurityEvent owner) throws Exception {
    SecurityEvent.Source res = owner.new Source();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("site")) {
        res.setSite(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.getType().add(parseCoding(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private SecurityEvent.Object parseSecurityEventObject(XmlPullParser xpp, SecurityEvent owner) throws Exception {
    SecurityEvent.Object res = owner.new Object();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseEnumeration(xpp, SecurityEvent.ObjectType.Null, new SecurityEvent().new ObjectTypeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.setRole(parseEnumeration(xpp, SecurityEvent.ObjectRole.Null, new SecurityEvent().new ObjectRoleEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lifecycle")) {
        res.setLifecycle(parseEnumeration(xpp, SecurityEvent.ObjectLifecycle.Null, new SecurityEvent().new ObjectLifecycleEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("idType")) {
        res.setIdType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("sensitivity")) {
        res.setSensitivity(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("query")) {
        res.setQuery(parseBase64Binary(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private IssueReport parseIssueReport(XmlPullParser xpp) throws Exception {
    IssueReport res = new IssueReport();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("issue")) {
        res.getIssue().add(parseIssueReportIssue(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private IssueReport.Issue parseIssueReportIssue(XmlPullParser xpp, IssueReport owner) throws Exception {
    IssueReport.Issue res = owner.new Issue();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("severity")) {
        res.setSeverity(parseEnumeration(xpp, IssueReport.IssueSeverity.Null, new IssueReport().new IssueSeverityEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
        res.getLocation().add(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private List_ parseList_(XmlPullParser xpp) throws Exception {
    List_ res = new List_();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.setSource(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ordered")) {
        res.setOrdered(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(parseEnumeration(xpp, List_.ListMode.Null, new List_().new ListModeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("entry")) {
        res.getEntry().add(parseList_Entry(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("emptyReason")) {
        res.setEmptyReason(parseCodeableConcept(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private List_.Entry parseList_Entry(XmlPullParser xpp, List_ owner) throws Exception {
    List_.Entry res = owner.new Entry();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("flag")) {
        res.getFlag().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("deleted")) {
        res.setDeleted(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("item")) {
        res.setItem(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Conformance parseConformance(XmlPullParser xpp) throws Exception {
    Conformance res = new Conformance();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("publisher")) {
        res.setPublisher(parseConformancePublisher(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("implementation")) {
        res.setImplementation(parseConformanceImplementation(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("software")) {
        res.setSoftware(parseConformanceSoftware(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("proposal")) {
        res.setProposal(parseConformanceProposal(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("acceptUnknown")) {
        res.setAcceptUnknown(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("rest")) {
        res.getRest().add(parseConformanceRest(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("messaging")) {
        res.getMessaging().add(parseConformanceMessaging(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("document")) {
        res.getDocument().add(parseConformanceDocument(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setUrl(parseUri(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setReleaseDate(parseDateTime(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setMode(parseEnumeration(xpp, Conformance.RestfulConformanceMode.Null, new Conformance().new RestfulConformanceModeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseConformanceResource(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setType(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("operation")) {
        res.getOperation().add(parseConformanceOperation(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("history")) {
        res.setHistory(parseBoolean(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setCode(parseEnumeration(xpp, Conformance.RestfulOperation.Null, new Conformance().new RestfulOperationEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setEndpoint(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parseConformanceEvent(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setCode(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mode")) {
        res.setMode(parseEnumeration(xpp, Conformance.MessageConformanceEventMode.Null, new Conformance().new MessageConformanceEventModeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("protocol")) {
        res.getProtocol().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("focus")) {
        res.setFocus(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("request")) {
        res.setRequest(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("response")) {
        res.setResponse(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setMode(parseEnumeration(xpp, Conformance.DocumentMode.Null, new Conformance().new DocumentModeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseUri(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsEntry parseXdsEntry(XmlPullParser xpp) throws Exception {
    XdsEntry res = new XdsEntry();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("url")) {
        res.setUrl(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repositoryId")) {
        res.setRepositoryId(parseUri(xpp));
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
        res.setDocumentId(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("availability")) {
        res.setAvailability(parseEnumeration(xpp, XdsEntry.XdsEntryAvailability.Null, new XdsEntry().new XdsEntryAvailabilityEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("confidentialityCode")) {
        res.setConfidentialityCode(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("created")) {
        res.setCreated(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.getEvent().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("hash")) {
        res.setHash(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("size")) {
        res.setSize(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lang")) {
        res.setLang(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("folder")) {
        res.getFolder().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientId")) {
        res.setPatientId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("sourcePatientId")) {
        res.setSourcePatientId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientInfo")) {
        res.setPatientInfo(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        res.getAuthor().add(parseXdsEntryAuthor(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("authenticator")) {
        res.setAuthenticator(parseXdsEntryAuthenticator(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("facilityType")) {
        res.setFacilityType(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("practiceSetting")) {
        res.setPracticeSetting(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("homeCommunity")) {
        res.setHomeCommunity(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("service")) {
        res.setService(parseXdsEntryService(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setStart(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stop")) {
        res.setStop(parseDateTime(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Document parseDocument(XmlPullParser xpp) throws Exception {
    Document res = new Document();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("information")) {
        res.setInformation(parseDocumentInformation(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("replaces")) {
        res.setReplaces(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("provenance")) {
        res.getProvenance().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stylesheet")) {
        res.setStylesheet(parseAttachment(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("representation")) {
        res.setRepresentation(parseAttachment(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section")) {
        res.getSection().add(parseDocumentSection(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Document.Section parseDocumentSection(XmlPullParser xpp, Document owner) throws Exception {
    Document.Section res = owner.new Section();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        res.setContent(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("section")) {
        res.getSection().add(parseDocumentSection(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Message parseMessage(XmlPullParser xpp) throws Exception {
    Message res = new Message();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("instant")) {
        res.setInstant(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("event")) {
        res.setEvent(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("response")) {
        res.setResponse(parseMessageResponse(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("source")) {
        res.setSource(parseMessageSource(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("destination")) {
        res.setDestination(parseMessageDestination(xpp, res));
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
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Message.Response parseMessageResponse(XmlPullParser xpp, Message owner) throws Exception {
    Message.Response res = owner.new Response();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseEnumeration(xpp, Message.ResponseCode.Null, new Message().new ResponseCodeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Message.Source parseMessageSource(XmlPullParser xpp, Message owner) throws Exception {
    Message.Source res = owner.new Source();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("software")) {
        res.setSoftware(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("version")) {
        res.setVersion(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.setContact(parseContact(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("endpoint")) {
        res.setEndpoint(parseUri(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Message.Destination parseMessageDestination(XmlPullParser xpp, Message owner) throws Exception {
    Message.Destination res = owner.new Destination();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
        res.setTarget(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("endpoint")) {
        res.setEndpoint(parseUri(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile parseProfile(XmlPullParser xpp) throws Exception {
    Profile res = new Profile();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
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
        res.setBundle(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("resource")) {
        res.getResource().add(parseProfileResource(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("extensionDefn")) {
        res.getExtensionDefn().add(parseProfileExtensionDefn(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("binding")) {
        res.getBinding().add(parseProfileBinding(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
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
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("telecom")) {
        res.getTelecom().add(parseContact(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setCode(parseEnumeration(xpp, Profile.ResourceProfileStatus.Null, new Profile().new ResourceProfileStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comment")) {
        res.setComment(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setUri(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("prefix")) {
        res.setPrefix(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setType(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("purpose")) {
        res.setPurpose(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("element")) {
        res.getElement().add(parseProfileElement_(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("searchParam")) {
        res.getSearchParam().add(parseProfileSearchParam(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setBundled(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("closed")) {
        res.setClosed(parseBoolean(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setMin(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("max")) {
        res.setMax(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.getType().add(parseProfileType(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("nameReference")) {
        res.setNameReference(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("maxLength")) {
        res.setMaxLength(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("condition")) {
        res.getCondition().add(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("constraint")) {
        res.getConstraint().add(parseProfileConstraint(xpp, owner));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustSupport")) {
        res.setMustSupport(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mustUnderstand")) {
        res.setMustUnderstand(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("binding")) {
        res.setBinding(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("mapping")) {
        res.getMapping().add(parseProfileMapping(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setCode(parseCode(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("profile")) {
        res.setProfile(parseUri(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("severity")) {
        res.setSeverity(parseEnumeration(xpp, Profile.ConstraintSeverity.Null, new Profile().new ConstraintSeverityEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("human")) {
        res.setHuman(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("xpath")) {
        res.setXpath(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("ocl")) {
        res.setOcl(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Profile.SearchParam parseProfileSearchParam(XmlPullParser xpp, Profile owner) throws Exception {
    Profile.SearchParam res = owner.new SearchParam();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseEnumeration(xpp, Profile.SearchParamType.Null, new Profile().new SearchParamTypeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("repeats")) {
        res.setRepeats(parseEnumeration(xpp, Profile.SearchRepeatBehavior.Null, new Profile().new SearchRepeatBehaviorEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("documentation")) {
        res.setDocumentation(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseId(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contextType")) {
        res.setContextType(parseEnumeration(xpp, Profile.ExtensionContext.Null, new Profile().new ExtensionContextEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("context")) {
        res.getContext().add(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseProfileDefinition(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setType(parseEnumeration(xpp, Profile.BindingType.Null, new Profile().new BindingTypeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("isExtensible")) {
        res.setIsExtensible(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("conformance")) {
        res.setConformance(parseEnumeration(xpp, Profile.BindingConformance.Null, new Profile().new BindingConformanceEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reference")) {
        res.setReference(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("concept")) {
        res.getConcept().add(parseProfileConcept(xpp, owner));
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setSystem(parseUri(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("display")) {
        res.setDisplay(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("definition")) {
        res.setDefinition(parseString(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Observation parseObservation(XmlPullParser xpp) throws Exception {
    Observation res = new Observation();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("interpretation")) {
        res.setInterpretation(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "obtained")) {
        res.setObtained(parseType("obtained", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("issued")) {
        res.setIssued(parseInstant(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("status")) {
        res.setStatus(parseEnumeration(xpp, Observation.ObservationStatus.Null, new Observation().new ObservationStatusEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reliability")) {
        res.setReliability(parseEnumeration(xpp, Observation.ObservationReliability.Null, new Observation().new ObservationReliabilityEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("bodySite")) {
        res.setBodySite(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("method")) {
        res.setMethod(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.setIdentifier(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("performer")) {
        res.setPerformer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("referenceRange")) {
        res.getReferenceRange().add(parseObservationReferenceRange(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("component")) {
        res.getComponent().add(parseObservationComponent(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Observation.ReferenceRange parseObservationReferenceRange(XmlPullParser xpp, Observation owner) throws Exception {
    Observation.ReferenceRange res = owner.new ReferenceRange();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("meaning")) {
        res.setMeaning(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "range")) {
        res.setRange(parseType("range", xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Observation.Component parseObservationComponent(XmlPullParser xpp, Observation owner) throws Exception {
    Observation.Component res = owner.new Component();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
        res.setName(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "value")) {
        res.setValue(parseType("value", xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Immunization parseImmunization(XmlPullParser xpp) throws Exception {
    Immunization res = new Immunization();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("type")) {
        res.setType(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reported")) {
        res.setReported(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("doseSequence")) {
        res.setDoseSequence(parseInteger(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("manufacturer")) {
        res.setManufacturer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("lotNumber")) {
        res.setLotNumber(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("expirationDate")) {
        res.setExpirationDate(parseDate(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("site")) {
        res.setSite(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("route")) {
        res.setRoute(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("requester")) {
        res.setRequester(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("performer")) {
        res.setPerformer(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("refusal")) {
        res.setRefusal(parseImmunizationRefusal(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reaction")) {
        res.getReaction().add(parseImmunizationReaction(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Immunization.Refusal parseImmunizationRefusal(XmlPullParser xpp, Immunization owner) throws Exception {
    Immunization.Refusal res = owner.new Refusal();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("reason")) {
        res.setReason(parseCodeableConcept(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Immunization.Reaction parseImmunizationReaction(XmlPullParser xpp, Immunization owner) throws Exception {
    Immunization.Reaction res = owner.new Reaction();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("detail")) {
        res.setDetail(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Problem parseProblem(XmlPullParser xpp) throws Exception {
    Problem res = new Problem();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("encounter")) {
        res.setEncounter(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("asserter")) {
        res.setAsserter(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("dateAsserted")) {
        res.setDateAsserted(parseDate(xpp));
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
      } else if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, "abatement")) {
        res.setAbatement(parseType("abatement", xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("stage")) {
        res.setStage(parseProblemStage(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("evidence")) {
        res.getEvidence().add(parseProblemEvidence(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("location")) {
        res.getLocation().add(parseProblemLocation(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("relatedItem")) {
        res.getRelatedItem().add(parseProblemRelatedItem(xpp, res));
      } else if (!parseResourceContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.getDetails().add(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
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
      } else if (!parseElementContent(eventType, xpp, res))
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
        res.setType(parseEnumeration(xpp, Problem.ProblemRelationshipType.Null, new Problem().new ProblemRelationshipTypeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("target")) {
        res.setTarget(parseResourceReference(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private OrderResponse parseOrderResponse(XmlPullParser xpp) throws Exception {
    OrderResponse res = new OrderResponse();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("request")) {
        res.setRequest(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("date")) {
        res.setDate(parseDateTime(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("who")) {
        res.setWho(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("authority")) {
        res.setAuthority(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("cost")) {
        res.setCost(parseMoney(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.setCode(parseEnumeration(xpp, OrderResponse.OrderOutcomeCode.Null, new OrderResponse().new OrderOutcomeCodeEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("description")) {
        res.setDescription(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("fulfillment")) {
        res.getFulfillment().add(parseResourceReference(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Patient parsePatient(XmlPullParser xpp) throws Exception {
    Patient res = new Patient();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("link")) {
        res.getLink().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("active")) {
        res.setActive(parseBoolean(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseDemographics(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("animal")) {
        res.setAnimal(parsePatientAnimal(xpp, res));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("provider")) {
        res.setProvider(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("diet")) {
        res.setDiet(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("confidentiality")) {
        res.setConfidentiality(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("recordLocation")) {
        res.setRecordLocation(parseCodeableConcept(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Patient.Animal parsePatientAnimal(XmlPullParser xpp, Patient owner) throws Exception {
    Patient.Animal res = owner.new Animal();
    parseElementAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("species")) {
        res.setSpecies(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("breed")) {
        res.setBreed(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("genderStatus")) {
        res.setGenderStatus(parseCodeableConcept(xpp));
      } else if (!parseElementContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsEntry2 parseXdsEntry2(XmlPullParser xpp) throws Exception {
    XdsEntry2 res = new XdsEntry2();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id")) {
        res.setId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("information")) {
        res.setInformation(parseDocumentInformation(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("format")) {
        res.setFormat(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("availability")) {
        res.setAvailability(parseEnumeration(xpp, XdsEntry2.XdsEntryAvailability.Null, new XdsEntry2().new XdsEntryAvailabilityEnumFactory()));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("folder")) {
        res.getFolder().add(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("subject")) {
        res.setSubject(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        res.setContent(parseAttachment(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private Provider parseProvider(XmlPullParser xpp) throws Exception {
    Provider res = new Provider();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("identifier")) {
        res.getIdentifier().add(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("details")) {
        res.setDetails(parseDemographics(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("organization")) {
        res.setOrganization(parseResourceReference(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("role")) {
        res.getRole().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("specialty")) {
        res.getSpecialty().add(parseCodeableConcept(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("period")) {
        res.setPeriod(parsePeriod(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("address")) {
        res.getAddress().add(parseAddress(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("contact")) {
        res.getContact().add(parseContact(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  private XdsFolder parseXdsFolder(XmlPullParser xpp) throws Exception {
    XdsFolder res = new XdsFolder();
    parseResourceAttributes(xpp, res);
    xpp.next();
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("code")) {
        res.getCode().add(parseCoding(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("patientId")) {
        res.setPatientId(parseIdentifier(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("homeCommunity")) {
        res.setHomeCommunity(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("comments")) {
        res.setComments(parseString(xpp));
      } else if (!parseResourceContent(eventType, xpp, res))
        unknownContent(xpp);
      eventType = nextNoWhitespace(xpp);
    }
    xpp.next();
    return res;
  }

  @Override
  protected Resource parseResource(XmlPullParser xpp) throws Exception {
    if (xpp.getName().equals("CarePlan"))
      return parseCarePlan(xpp);
    else if (xpp.getName().equals("Provenance"))
      return parseProvenance(xpp);
    else if (xpp.getName().equals("Device"))
      return parseDevice(xpp);
    else if (xpp.getName().equals("Order"))
      return parseOrder(xpp);
    else if (xpp.getName().equals("Organization"))
      return parseOrganization(xpp);
    else if (xpp.getName().equals("Prescription"))
      return parsePrescription(xpp);
    else if (xpp.getName().equals("Group"))
      return parseGroup(xpp);
    else if (xpp.getName().equals("DiagnosticReport"))
      return parseDiagnosticReport(xpp);
    else if (xpp.getName().equals("ValueSet"))
      return parseValueSet(xpp);
    else if (xpp.getName().equals("Coverage"))
      return parseCoverage(xpp);
    else if (xpp.getName().equals("Test"))
      return parseTest(xpp);
    else if (xpp.getName().equals("MedicationAdministration"))
      return parseMedicationAdministration(xpp);
    else if (xpp.getName().equals("SecurityEvent"))
      return parseSecurityEvent(xpp);
    else if (xpp.getName().equals("IssueReport"))
      return parseIssueReport(xpp);
    else if (xpp.getName().equals("List"))
      return parseList_(xpp);
    else if (xpp.getName().equals("Conformance"))
      return parseConformance(xpp);
    else if (xpp.getName().equals("XdsEntry"))
      return parseXdsEntry(xpp);
    else if (xpp.getName().equals("Document"))
      return parseDocument(xpp);
    else if (xpp.getName().equals("Message"))
      return parseMessage(xpp);
    else if (xpp.getName().equals("Profile"))
      return parseProfile(xpp);
    else if (xpp.getName().equals("Observation"))
      return parseObservation(xpp);
    else if (xpp.getName().equals("Immunization"))
      return parseImmunization(xpp);
    else if (xpp.getName().equals("Problem"))
      return parseProblem(xpp);
    else if (xpp.getName().equals("OrderResponse"))
      return parseOrderResponse(xpp);
    else if (xpp.getName().equals("Patient"))
      return parsePatient(xpp);
    else if (xpp.getName().equals("XdsEntry2"))
      return parseXdsEntry2(xpp);
    else if (xpp.getName().equals("Provider"))
      return parseProvider(xpp);
    else if (xpp.getName().equals("XdsFolder"))
      return parseXdsFolder(xpp);
    else if (xpp.getName().equals("Binary"))
      return parseBinary(xpp);
    throw new Exception("Unknown resource type "+xpp.getName()+"");
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
    else if (xpp.getName().equals(prefix+"DocumentInformation"))
      return parseDocumentInformation(xpp);
    else if (xpp.getName().equals(prefix+"Demographics"))
      return parseDemographics(xpp);
    else if (xpp.getName().equals(prefix+"Integer"))
      return parseInteger(xpp);
    else if (xpp.getName().equals(prefix+"DateTime"))
      return parseDateTime(xpp);
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
      return parseString(xpp);
    else if (xpp.getName().equals(prefix+"Boolean"))
      return parseBoolean(xpp);
    else if (xpp.getName().equals(prefix+"Uuid"))
      return parseUuid(xpp);
    else if (xpp.getName().equals(prefix+"Instant"))
      return parseInstant(xpp);
    throw new Exception("Unknown type "+xpp.getName());
  }

  public Element parseFragment(XmlPullParser xpp, String type) throws Exception {
    if (type.equals("Extension"))
      return parseExtension(xpp);
    else if (type.equals("Narrative"))
      return parseNarrative(xpp);
    else if (type.equals("Period"))
      return parsePeriod(xpp);
    else if (type.equals("Coding"))
      return parseCoding(xpp);
    else if (type.equals("Range"))
      return parseRange(xpp);
    else if (type.equals("Quantity"))
      return parseQuantity(xpp);
    else if (type.equals("Choice"))
      return parseChoice(xpp);
    else if (type.equals("Attachment"))
      return parseAttachment(xpp);
    else if (type.equals("Ratio"))
      return parseRatio(xpp);
    else if (type.equals("ResourceReference"))
      return parseResourceReference(xpp);
    else if (type.equals("CodeableConcept"))
      return parseCodeableConcept(xpp);
    else if (type.equals("Identifier"))
      return parseIdentifier(xpp);
    else if (type.equals("Age"))
      return parseAge(xpp);
    else if (type.equals("Count"))
      return parseCount(xpp);
    else if (type.equals("Money"))
      return parseMoney(xpp);
    else if (type.equals("Distance"))
      return parseDistance(xpp);
    else if (type.equals("Duration"))
      return parseDuration(xpp);
    else if (type.equals("Schedule"))
      return parseSchedule(xpp);
    else if (type.equals("Contact"))
      return parseContact(xpp);
    else if (type.equals("Address"))
      return parseAddress(xpp);
    else if (type.equals("HumanName"))
      return parseHumanName(xpp);
    else if (type.equals("DocumentInformation"))
      return parseDocumentInformation(xpp);
    else if (type.equals("Demographics"))
      return parseDemographics(xpp);
    else if (type.equals("CarePlan"))
      return parseCarePlan(xpp);
    else if (type.equals("Provenance"))
      return parseProvenance(xpp);
    else if (type.equals("Device"))
      return parseDevice(xpp);
    else if (type.equals("Order"))
      return parseOrder(xpp);
    else if (type.equals("Organization"))
      return parseOrganization(xpp);
    else if (type.equals("Prescription"))
      return parsePrescription(xpp);
    else if (type.equals("Group"))
      return parseGroup(xpp);
    else if (type.equals("DiagnosticReport"))
      return parseDiagnosticReport(xpp);
    else if (type.equals("ValueSet"))
      return parseValueSet(xpp);
    else if (type.equals("Coverage"))
      return parseCoverage(xpp);
    else if (type.equals("Test"))
      return parseTest(xpp);
    else if (type.equals("MedicationAdministration"))
      return parseMedicationAdministration(xpp);
    else if (type.equals("SecurityEvent"))
      return parseSecurityEvent(xpp);
    else if (type.equals("IssueReport"))
      return parseIssueReport(xpp);
    else if (type.equals("List"))
      return parseList_(xpp);
    else if (type.equals("Conformance"))
      return parseConformance(xpp);
    else if (type.equals("XdsEntry"))
      return parseXdsEntry(xpp);
    else if (type.equals("Document"))
      return parseDocument(xpp);
    else if (type.equals("Message"))
      return parseMessage(xpp);
    else if (type.equals("Profile"))
      return parseProfile(xpp);
    else if (type.equals("Observation"))
      return parseObservation(xpp);
    else if (type.equals("Immunization"))
      return parseImmunization(xpp);
    else if (type.equals("Problem"))
      return parseProblem(xpp);
    else if (type.equals("OrderResponse"))
      return parseOrderResponse(xpp);
    else if (type.equals("Patient"))
      return parsePatient(xpp);
    else if (type.equals("XdsEntry2"))
      return parseXdsEntry2(xpp);
    else if (type.equals("Provider"))
      return parseProvider(xpp);
    else if (type.equals("XdsFolder"))
      return parseXdsFolder(xpp);
    else if (type.equals("integer"))
      return parseInteger(xpp);
    else if (type.equals("dateTime"))
      return parseDateTime(xpp);
    else if (type.equals("code"))
      return parseCode(xpp);
    else if (type.equals("date"))
      return parseDate(xpp);
    else if (type.equals("decimal"))
      return parseDecimal(xpp);
    else if (type.equals("uri"))
      return parseUri(xpp);
    else if (type.equals("id"))
      return parseId(xpp);
    else if (type.equals("base64Binary"))
      return parseBase64Binary(xpp);
    else if (type.equals("oid"))
      return parseOid(xpp);
    else if (type.equals("string"))
      return parseString(xpp);
    else if (type.equals("boolean"))
      return parseBoolean(xpp);
    else if (type.equals("uuid"))
      return parseUuid(xpp);
    else if (type.equals("instant"))
      return parseInstant(xpp);
    throw new Exception("Unknown type "+type);
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
    if (xpp.getName().equals(prefix+"DocumentInformation"))
      return true;
    if (xpp.getName().equals(prefix+"Demographics"))
      return true;
    if (xpp.getName().equals(prefix+"CarePlan"))
      return true;
    if (xpp.getName().equals(prefix+"Provenance"))
      return true;
    if (xpp.getName().equals(prefix+"Device"))
      return true;
    if (xpp.getName().equals(prefix+"Order"))
      return true;
    if (xpp.getName().equals(prefix+"Organization"))
      return true;
    if (xpp.getName().equals(prefix+"Prescription"))
      return true;
    if (xpp.getName().equals(prefix+"Group"))
      return true;
    if (xpp.getName().equals(prefix+"DiagnosticReport"))
      return true;
    if (xpp.getName().equals(prefix+"ValueSet"))
      return true;
    if (xpp.getName().equals(prefix+"Coverage"))
      return true;
    if (xpp.getName().equals(prefix+"Test"))
      return true;
    if (xpp.getName().equals(prefix+"MedicationAdministration"))
      return true;
    if (xpp.getName().equals(prefix+"SecurityEvent"))
      return true;
    if (xpp.getName().equals(prefix+"IssueReport"))
      return true;
    if (xpp.getName().equals(prefix+"List"))
      return true;
    if (xpp.getName().equals(prefix+"Conformance"))
      return true;
    if (xpp.getName().equals(prefix+"XdsEntry"))
      return true;
    if (xpp.getName().equals(prefix+"Document"))
      return true;
    if (xpp.getName().equals(prefix+"Message"))
      return true;
    if (xpp.getName().equals(prefix+"Profile"))
      return true;
    if (xpp.getName().equals(prefix+"Observation"))
      return true;
    if (xpp.getName().equals(prefix+"Immunization"))
      return true;
    if (xpp.getName().equals(prefix+"Problem"))
      return true;
    if (xpp.getName().equals(prefix+"OrderResponse"))
      return true;
    if (xpp.getName().equals(prefix+"Patient"))
      return true;
    if (xpp.getName().equals(prefix+"XdsEntry2"))
      return true;
    if (xpp.getName().equals(prefix+"Provider"))
      return true;
    if (xpp.getName().equals(prefix+"XdsFolder"))
      return true;
    if (xpp.getName().equals(prefix+"Integer"))
      return true;
    if (xpp.getName().equals(prefix+"DateTime"))
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

