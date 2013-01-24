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

import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.Boolean;
import java.net.*;
import java.math.*;

public class JsonComposer extends JsonComposerBase {

  private void composeElement(Element element) throws Exception {
    if (element.getXmlId() != null)
      prop("_id", element.getXmlId());
    if (element.getExtensions().size() > 0) {
      openArray("extension");
      for (Extension ex : element.getExtensions())
        composeExtension(null, ex);
      closeArray();
    }
  }

  private <E extends Enum<E>> void composeEnumeration(String name, Enumeration<E> value, EnumFactory e) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", e.toCode(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeInteger(String name, Integer value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeDateTime(String name, DateTime value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeCode(String name, Code value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeDate(String name, Date value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeDecimal(String name, Decimal value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeUri(String name, Uri value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeId(String name, Id value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeBase64Binary(String name, Base64Binary value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeOid(String name, Oid value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeString(String name, String_ value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeBoolean(String name, Boolean value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeUuid(String name, Uuid value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeInstant(String name, Instant value) throws Exception {
    if (value != null) {
      open(name);
      composeElement(value);
      if (value.getValue() != null) 
        prop("value", toString(value.getValue()));

      if (value.getExtensions().size() > 0) {
        openArray("extension");
        for (Extension ex : value.getExtensions())
          composeExtension(null, ex);
        closeArray();
      }    
      close();
    }    
  }    

  private void composeExtension(String name, Extension element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeUri("url", element.getUrl());
      composeBoolean("mustUnderstand", element.getMustUnderstand());
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
      composeElement(element);
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Narrative().new NarrativeStatusEnumFactory());
      composeXhtml("div", element.getDiv());
      if (element.getImage().size() > 0) {
        openArray("image");
        for (Narrative.Image e : element.getImage()) 
          composeNarrativeImage(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeNarrativeImage(String name, Narrative.Image element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("mimeType", element.getMimeType());
      composeBase64Binary("content", element.getContent());
      close();
    }
  }

  private void composePeriod(String name, Period element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDateTime("start", element.getStart());
      composeDateTime("end", element.getEnd());
      close();
    }
  }

  private void composeCoding(String name, Coding element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      composeString("display", element.getDisplay());
      close();
    }
  }

  private void composeRange(String name, Range element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeQuantity("low", element.getLow());
      composeQuantity("high", element.getHigh());
      close();
    }
  }

  private void composeQuantity(String name, Quantity element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Quantity().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      close();
    }
  }

  private void composeChoice(String name, Choice element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("code", element.getCode());
      if (element.getOption().size() > 0) {
        openArray("option");
        for (Choice.Option e : element.getOption()) 
          composeChoiceOption(null, e);
        closeArray();
      };
      composeBoolean("isOrdered", element.getIsOrdered());
      close();
    }
  }

  private void composeChoiceOption(String name, Choice.Option element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("code", element.getCode());
      composeString("display", element.getDisplay());
      close();
    }
  }

  private void composeAttachment(String name, Attachment element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("contentType", element.getContentType());
      composeCode("language", element.getLanguage());
      composeBase64Binary("data", element.getData());
      composeUri("url", element.getUrl());
      composeInteger("size", element.getSize());
      composeBase64Binary("hash", element.getHash());
      composeString("title", element.getTitle());
      close();
    }
  }

  private void composeRatio(String name, Ratio element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeQuantity("numerator", element.getNumerator());
      composeQuantity("denominator", element.getDenominator());
      close();
    }
  }

  private void composeResourceReference(String name, ResourceReference element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("type", element.getType());
      composeUri("url", element.getUrl());
      composeString("display", element.getDisplay());
      close();
    }
  }

  private void composeCodeableConcept(String name, CodeableConcept element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
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
      composeElement(element);
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new Identifier().new IdentifierUseEnumFactory());
      composeString("label", element.getLabel());
      composeUri("system", element.getSystem());
      composeString("id", element.getId());
      composePeriod("period", element.getPeriod());
      composeResourceReference("assigner", element.getAssigner());
      close();
    }
  }

  private void composeAge(String name, Age element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Age().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      close();
    }
  }

  private void composeCount(String name, Count element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Count().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      close();
    }
  }

  private void composeMoney(String name, Money element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Money().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      close();
    }
  }

  private void composeDistance(String name, Distance element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Distance().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      close();
    }
  }

  private void composeDuration(String name, Duration element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDecimal("value", element.getValue());
      if (element.getComparator() != null)
        composeEnumeration("comparator", element.getComparator(), new Duration().new QuantityComparatorEnumFactory());
      composeString("units", element.getUnits());
      composeUri("system", element.getSystem());
      composeCode("code", element.getCode());
      close();
    }
  }

  private void composeSchedule(String name, Schedule element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
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
      composeElement(element);
      composeInteger("frequency", element.getFrequency());
      if (element.getWhen() != null)
        composeEnumeration("when", element.getWhen(), new Schedule().new EventTimingEnumFactory());
      composeDecimal("duration", element.getDuration());
      if (element.getUnits() != null)
        composeEnumeration("units", element.getUnits(), new Schedule().new UnitsOfTimeEnumFactory());
      composeInteger("count", element.getCount());
      composeDateTime("end", element.getEnd());
      close();
    }
  }

  private void composeContact(String name, Contact element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getSystem() != null)
        composeEnumeration("system", element.getSystem(), new Contact().new ContactSystemEnumFactory());
      composeString("value", element.getValue());
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new Contact().new ContactUseEnumFactory());
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeAddress(String name, Address element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new Address().new AddressUseEnumFactory());
      composeString("text", element.getText());
      if (element.getLine().size() > 0) {
        openArray("line");
        for (String_ e : element.getLine()) 
          composeString(null, e);
        closeArray();
      };
      composeString("city", element.getCity());
      composeString("state", element.getState());
      composeString("zip", element.getZip());
      composeString("country", element.getCountry());
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeHumanName(String name, HumanName element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getUse() != null)
        composeEnumeration("use", element.getUse(), new HumanName().new NameUseEnumFactory());
      composeString("text", element.getText());
      if (element.getFamily().size() > 0) {
        openArray("family");
        for (String_ e : element.getFamily()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getGiven().size() > 0) {
        openArray("given");
        for (String_ e : element.getGiven()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getPrefix().size() > 0) {
        openArray("prefix");
        for (String_ e : element.getPrefix()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getSuffix().size() > 0) {
        openArray("suffix");
        for (String_ e : element.getSuffix()) 
          composeString(null, e);
        closeArray();
      };
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeDocumentInformation(String name, DocumentInformation element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeIdentifier("id", element.getId());
      composeIdentifier("versionId", element.getVersionId());
      composeInstant("created", element.getCreated());
      composeCoding("class", element.getClass_());
      composeCodeableConcept("type", element.getType());
      composeString("title", element.getTitle());
      composeCoding("confidentiality", element.getConfidentiality());
      composeResourceReference("subject", element.getSubject());
      if (element.getAuthor().size() > 0) {
        openArray("author");
        for (ResourceReference e : element.getAuthor()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getAttester().size() > 0) {
        openArray("attester");
        for (DocumentInformation.Attester e : element.getAttester()) 
          composeDocumentInformationAttester(null, e);
        closeArray();
      };
      composeResourceReference("custodian", element.getCustodian());
      composeDocumentInformationEvent("event", element.getEvent());
      composeResourceReference("encounter", element.getEncounter());
      composeCodeableConcept("facilityType", element.getFacilityType());
      composeCodeableConcept("practiceSetting", element.getPracticeSetting());
      close();
    }
  }

  private void composeDocumentInformationAttester(String name, DocumentInformation.Attester element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new DocumentInformation().new DocumentAttestationModeEnumFactory());
      composeDateTime("time", element.getTime());
      composeResourceReference("party", element.getParty());
      close();
    }
  }

  private void composeDocumentInformationEvent(String name, DocumentInformation.Event element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getCode().size() > 0) {
        openArray("code");
        for (CodeableConcept e : element.getCode()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composePeriod("period", element.getPeriod());
      if (element.getDetail().size() > 0) {
        openArray("detail");
        for (ResourceReference e : element.getDetail()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDemographics(String name, Demographics element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
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
      composeCoding("gender", element.getGender());
      composeDateTime("birthDate", element.getBirthDate());
      composeBoolean("deceased", element.getDeceased());
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      composeCodeableConcept("maritalStatus", element.getMaritalStatus());
      if (element.getLanguage().size() > 0) {
        openArray("language");
        for (Demographics.Language e : element.getLanguage()) 
          composeDemographicsLanguage(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDemographicsLanguage(String name, Demographics.Language element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("language", element.getLanguage());
      composeCodeableConcept("mode", element.getMode());
      composeCodeableConcept("proficiencyLevel", element.getProficiencyLevel());
      composeBoolean("preference", element.getPreference());
      close();
    }
  }

  private void composeResourceElements(Resource element) throws Exception {
    composeElement(element);
    if (element.getText() != null)
      composeNarrative("text", element.getText());
    if (element.getContained().size() > 0) {
      openArray("contained");
      for (Resource r : element.getContained()) {
        if (r.getXmlId() == null)
          throw new Exception("Contained Resource has no id - one must be assigned"); // we can't assign one here - what points to it?
        open(null);
        composeResource(r);
        close();
      }
      closeArray();
    }
  }

  private void composeCarePlan(String name, CarePlan element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeIdentifier("identifier", element.getIdentifier());
      composeResourceReference("patient", element.getPatient());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new CarePlan().new CarePlanStatusEnumFactory());
      composePeriod("period", element.getPeriod());
      composeDateTime("modified", element.getModified());
      if (element.getConcern().size() > 0) {
        openArray("concern");
        for (ResourceReference e : element.getConcern()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getParticipant().size() > 0) {
        openArray("participant");
        for (CarePlan.Participant e : element.getParticipant()) 
          composeCarePlanParticipant(null, e);
        closeArray();
      };
      composeString("goal", element.getGoal());
      if (element.getActivity().size() > 0) {
        openArray("activity");
        for (CarePlan.Activity e : element.getActivity()) 
          composeCarePlanActivity(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeCarePlanParticipant(String name, CarePlan.Participant element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("role", element.getRole());
      composeResourceReference("member", element.getMember());
      close();
    }
  }

  private void composeCarePlanActivity(String name, CarePlan.Activity element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getCategory() != null)
        composeEnumeration("category", element.getCategory(), new CarePlan().new CarePlanActivityCategoryEnumFactory());
      composeCodeableConcept("code", element.getCode());
      composeBoolean("prohibited", element.getProhibited());
      composeSchedule("schedule", element.getSchedule());
      composeResourceReference("location", element.getLocation());
      if (element.getPerformer().size() > 0) {
        openArray("performer");
        for (ResourceReference e : element.getPerformer()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeResourceReference("product", element.getProduct());
      composeQuantity("dailyAmount", element.getDailyAmount());
      composeQuantity("quantity", element.getQuantity());
      composeString("details", element.getDetails());
      if (element.getAction().size() > 0) {
        openArray("action");
        for (ResourceReference e : element.getAction()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProvenance(String name, Provenance element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("target", element.getTarget());
      composeProvenanceActivity("activity", element.getActivity());
      if (element.getParty().size() > 0) {
        openArray("party");
        for (Provenance.Party e : element.getParty()) 
          composeProvenanceParty(null, e);
        closeArray();
      };
      composeString("signature", element.getSignature());
      close();
    }
  }

  private void composeProvenanceActivity(String name, Provenance.Activity element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composePeriod("period", element.getPeriod());
      composeInstant("recorded", element.getRecorded());
      composeCodeableConcept("reason", element.getReason());
      composeProvenanceLocation("location", element.getLocation());
      composeUri("policy", element.getPolicy());
      close();
    }
  }

  private void composeProvenanceLocation(String name, Provenance.Location element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("type", element.getType());
      composeIdentifier("id", element.getId());
      composeString("description", element.getDescription());
      composeString("coords", element.getCoords());
      close();
    }
  }

  private void composeProvenanceParty(String name, Provenance.Party element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCoding("role", element.getRole());
      composeCoding("type", element.getType());
      composeUri("id", element.getId());
      composeString("description", element.getDescription());
      close();
    }
  }

  private void composeDevice(String name, Device element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeCodeableConcept("type", element.getType());
      composeString("manufacturer", element.getManufacturer());
      composeString("model", element.getModel());
      composeString("version", element.getVersion());
      composeDeviceIdentity("identity", element.getIdentity());
      composeResourceReference("owner", element.getOwner());
      if (element.getAssignedId().size() > 0) {
        openArray("assignedId");
        for (Identifier e : element.getAssignedId()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeResourceReference("location", element.getLocation());
      composeResourceReference("patient", element.getPatient());
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Contact e : element.getContact()) 
          composeContact(null, e);
        closeArray();
      };
      composeUri("url", element.getUrl());
      close();
    }
  }

  private void composeDeviceIdentity(String name, Device.Identity element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("gtin", element.getGtin());
      composeString("lot", element.getLot());
      composeString("serialNumber", element.getSerialNumber());
      composeDate("expiry", element.getExpiry());
      close();
    }
  }

  private void composeOrder(String name, Order element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeDateTime("date", element.getDate());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("source", element.getSource());
      composeResourceReference("target", element.getTarget());
      composeString("reason", element.getReason());
      composeResourceReference("authority", element.getAuthority());
      composeResourceReference("payment", element.getPayment());
      composeOrderWhen("when", element.getWhen());
      if (element.getDetail().size() > 0) {
        openArray("detail");
        for (ResourceReference e : element.getDetail()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeOrderWhen(String name, Order.When element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeSchedule("schedule", element.getSchedule());
      close();
    }
  }

  private void composeOrganization(String name, Organization element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      if (element.getName().size() > 0) {
        openArray("name");
        for (String_ e : element.getName()) 
          composeString(null, e);
        closeArray();
      };
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
      composeCodeableConcept("type", element.getType());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Organization().new RecordStatusEnumFactory());
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
      if (element.getContactPerson().size() > 0) {
        openArray("contactPerson");
        for (Organization.ContactPerson e : element.getContactPerson()) 
          composeOrganizationContactPerson(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeOrganizationAccreditation(String name, Organization.Accreditation element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
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
      composeElement(element);
      composeResourceReference("organization", element.getOrganization());
      composeCodeableConcept("type", element.getType());
      close();
    }
  }

  private void composeOrganizationContactPerson(String name, Organization.ContactPerson element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("type", element.getType());
      composeAddress("address", element.getAddress());
      if (element.getTelecom().size() > 0) {
        openArray("telecom");
        for (Contact e : element.getTelecom()) 
          composeContact(null, e);
        closeArray();
      };
      composeHumanName("name", element.getName());
      composeResourceReference("person", element.getPerson());
      close();
    }
  }

  private void composePrescription(String name, Prescription element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Prescription().new PrescriptionStatusEnumFactory());
      composeResourceReference("patient", element.getPatient());
      composeResourceReference("prescriber", element.getPrescriber());
      composeDateTime("prescribed", element.getPrescribed());
      composePrescriptionDispense("dispense", element.getDispense());
      composePrescriptionMedicine("medicine", element.getMedicine());
      composePrescriptionAdministrationRequest("administrationRequest", element.getAdministrationRequest());
      composeCodeableConcept("reason", element.getReason());
      close();
    }
  }

  private void composePrescriptionDispense(String name, Prescription.Dispense element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeInteger("repeats", element.getRepeats());
      composeQuantity("quantity", element.getQuantity());
      composeResourceReference("dispenser", element.getDispenser());
      close();
    }
  }

  private void composePrescriptionMedicine(String name, Prescription.Medicine element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
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
      composeElement(element);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      close();
    }
  }

  private void composePrescriptionInactiveIngredient(String name, Prescription.InactiveIngredient element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      close();
    }
  }

  private void composePrescriptionAdministrationRequest(String name, Prescription.AdministrationRequest element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("description", element.getDescription());
      composeRatio("totalPeriodicDose", element.getTotalPeriodicDose());
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
      composeElement(element);
      if (element.getPrecondition().size() > 0) {
        openArray("precondition");
        for (CodeableConcept e : element.getPrecondition()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeBoolean("prn", element.getPrn());
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

  private void composeGroup(String name, Group element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeIdentifier("identifier", element.getIdentifier());
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Group().new GroupTypeEnumFactory());
      composeBoolean("actual", element.getActual());
      composeCodeableConcept("code", element.getCode());
      composeString("name", element.getName());
      composeInteger("quantity", element.getQuantity());
      if (element.getCharacteristic().size() > 0) {
        openArray("characteristic");
        for (Group.Characteristic e : element.getCharacteristic()) 
          composeGroupCharacteristic(null, e);
        closeArray();
      };
      if (element.getMember().size() > 0) {
        openArray("member");
        for (ResourceReference e : element.getMember()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeGroupCharacteristic(String name, Group.Characteristic element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("type", element.getType());
      composeType("value", element.getValue());
      composeBoolean("exclude", element.getExclude());
      close();
    }
  }

  private void composeDiagnosticReport(String name, DiagnosticReport element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new DiagnosticReport().new ObservationStatusEnumFactory());
      composeInstant("issued", element.getIssued());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("performer", element.getPerformer());
      composeIdentifier("reportId", element.getReportId());
      if (element.getRequestDetail().size() > 0) {
        openArray("requestDetail");
        for (DiagnosticReport.RequestDetail e : element.getRequestDetail()) 
          composeDiagnosticReportRequestDetail(null, e);
        closeArray();
      };
      composeResourceReference("encounter", element.getEncounter());
      composeCodeableConcept("serviceCategory", element.getServiceCategory());
      composeDateTime("diagnosticTime", element.getDiagnosticTime());
      composeDiagnosticReportResults("results", element.getResults());
      if (element.getImage().size() > 0) {
        openArray("image");
        for (ResourceReference e : element.getImage()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeString("conclusion", element.getConclusion());
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
      close();
    }
  }

  private void composeDiagnosticReportRequestDetail(String name, DiagnosticReport.RequestDetail element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeIdentifier("requestOrderId", element.getRequestOrderId());
      composeIdentifier("receiverOrderId", element.getReceiverOrderId());
      if (element.getRequestTest().size() > 0) {
        openArray("requestTest");
        for (CodeableConcept e : element.getRequestTest()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeCodeableConcept("bodySite", element.getBodySite());
      composeResourceReference("requester", element.getRequester());
      composeString("clinicalInfo", element.getClinicalInfo());
      close();
    }
  }

  private void composeDiagnosticReportResults(String name, DiagnosticReport.Results element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("name", element.getName());
      composeResourceReference("specimen", element.getSpecimen());
      if (element.getGroup().size() > 0) {
        openArray("group");
        for (DiagnosticReport.Results e : element.getGroup()) 
          composeDiagnosticReportResults(null, e);
        closeArray();
      };
      if (element.getResult().size() > 0) {
        openArray("result");
        for (ResourceReference e : element.getResult()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeValueSet(String name, ValueSet element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeString("name", element.getName());
      composeValueSetAuthor("author", element.getAuthor());
      composeString("description", element.getDescription());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new ValueSet().new ValuesetStatusEnumFactory());
      composeDateTime("date", element.getDate());
      composeString("identifier", element.getIdentifier());
      composeString("version", element.getVersion());
      if (element.getRestricts().size() > 0) {
        openArray("restricts");
        for (Uri e : element.getRestricts()) 
          composeUri(null, e);
        closeArray();
      };
      if (element.getImport().size() > 0) {
        openArray("import");
        for (Uri e : element.getImport()) 
          composeUri(null, e);
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
      close();
    }
  }

  private void composeValueSetAuthor(String name, ValueSet.Author element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeUri("reference", element.getReference());
      close();
    }
  }

  private void composeValueSetInclude(String name, ValueSet.Include element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeUri("system", element.getSystem());
      composeString("version", element.getVersion());
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new ValueSet().new CodeSelectionModeEnumFactory());
      if (element.getCode().size() > 0) {
        openArray("code");
        for (Code e : element.getCode()) 
          composeCode(null, e);
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
      composeElement(element);
      composeCode("property", element.getProperty());
      if (element.getOp() != null)
        composeEnumeration("op", element.getOp(), new ValueSet().new FilterOperatorEnumFactory());
      composeCode("value", element.getValue());
      close();
    }
  }

  private void composeCoverage(String name, Coverage element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("issuer", element.getIssuer());
      composePeriod("period", element.getPeriod());
      composeCoding("type", element.getType());
      composeIdentifier("identifier", element.getIdentifier());
      composeIdentifier("plan", element.getPlan());
      composeIdentifier("subplan", element.getSubplan());
      composeInteger("dependent", element.getDependent());
      composeInteger("sequence", element.getSequence());
      composeCoveragePlanHolder("planHolder", element.getPlanHolder());
      close();
    }
  }

  private void composeCoveragePlanHolder(String name, Coverage.PlanHolder element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeHumanName("name", element.getName());
      composeAddress("address", element.getAddress());
      composeDate("birthdate", element.getBirthdate());
      close();
    }
  }

  private void composeTest(String name, Test element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getStringErr().size() > 0) {
        openArray("stringErr");
        for (String_ e : element.getStringErr()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getStringCorr().size() > 0) {
        openArray("stringCorr");
        for (String_ e : element.getStringCorr()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getBooleanErr().size() > 0) {
        openArray("booleanErr");
        for (Boolean e : element.getBooleanErr()) 
          composeBoolean(null, e);
        closeArray();
      };
      if (element.getBooleanCorr().size() > 0) {
        openArray("booleanCorr");
        for (Boolean e : element.getBooleanCorr()) 
          composeBoolean(null, e);
        closeArray();
      };
      if (element.getIntegerErr().size() > 0) {
        openArray("integerErr");
        for (Integer e : element.getIntegerErr()) 
          composeInteger(null, e);
        closeArray();
      };
      if (element.getIntegerCorr().size() > 0) {
        openArray("integerCorr");
        for (Integer e : element.getIntegerCorr()) 
          composeInteger(null, e);
        closeArray();
      };
      if (element.getDecimalErr().size() > 0) {
        openArray("decimalErr");
        for (Decimal e : element.getDecimalErr()) 
          composeDecimal(null, e);
        closeArray();
      };
      if (element.getDecimalCorr().size() > 0) {
        openArray("decimalCorr");
        for (Decimal e : element.getDecimalCorr()) 
          composeDecimal(null, e);
        closeArray();
      };
      if (element.getB64Err().size() > 0) {
        openArray("b64Err");
        for (Base64Binary e : element.getB64Err()) 
          composeBase64Binary(null, e);
        closeArray();
      };
      if (element.getB64Corr().size() > 0) {
        openArray("b64Corr");
        for (Base64Binary e : element.getB64Corr()) 
          composeBase64Binary(null, e);
        closeArray();
      };
      if (element.getInstantErr().size() > 0) {
        openArray("instantErr");
        for (Instant e : element.getInstantErr()) 
          composeInstant(null, e);
        closeArray();
      };
      if (element.getInstantCorr().size() > 0) {
        openArray("instantCorr");
        for (Instant e : element.getInstantCorr()) 
          composeInstant(null, e);
        closeArray();
      };
      if (element.getUriErr().size() > 0) {
        openArray("uriErr");
        for (Uri e : element.getUriErr()) 
          composeUri(null, e);
        closeArray();
      };
      if (element.getUriCorr().size() > 0) {
        openArray("uriCorr");
        for (Uri e : element.getUriCorr()) 
          composeUri(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeMedicationAdministration(String name, MedicationAdministration element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getAdministrationEventStatus() != null)
        composeEnumeration("administrationEventStatus", element.getAdministrationEventStatus(), new MedicationAdministration().new MedAdmStatusEnumFactory());
      composeBoolean("isNegated", element.getIsNegated());
      if (element.getNegatedReason().size() > 0) {
        openArray("negatedReason");
        for (CodeableConcept e : element.getNegatedReason()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composePeriod("effectiveTime", element.getEffectiveTime());
      composeCodeableConcept("method", element.getMethod());
      composeCodeableConcept("approachSite", element.getApproachSite());
      composeCodeableConcept("route", element.getRoute());
      composeQuantity("administeredDose", element.getAdministeredDose());
      composeQuantity("doseRate", element.getDoseRate());
      if (element.getId().size() > 0) {
        openArray("id");
        for (Identifier e : element.getId()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeResourceReference("prescription", element.getPrescription());
      composeResourceReference("patient", element.getPatient());
      if (element.getMedication().size() > 0) {
        openArray("medication");
        for (CodeableConcept e : element.getMedication()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeIdentifier("encounter", element.getEncounter());
      if (element.getAdministrationDevice().size() > 0) {
        openArray("administrationDevice");
        for (ResourceReference e : element.getAdministrationDevice()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeSecurityEvent(String name, SecurityEvent element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeSecurityEventEvent("event", element.getEvent());
      if (element.getParticipant().size() > 0) {
        openArray("participant");
        for (SecurityEvent.Participant e : element.getParticipant()) 
          composeSecurityEventParticipant(null, e);
        closeArray();
      };
      if (element.getSource().size() > 0) {
        openArray("source");
        for (SecurityEvent.Source e : element.getSource()) 
          composeSecurityEventSource(null, e);
        closeArray();
      };
      if (element.getObject().size() > 0) {
        openArray("object");
        for (SecurityEvent.Object e : element.getObject()) 
          composeSecurityEventObject(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeSecurityEventEvent(String name, SecurityEvent.Event element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCoding("id", element.getId());
      if (element.getAction() != null)
        composeEnumeration("action", element.getAction(), new SecurityEvent().new SecurityEventEventActionEnumFactory());
      composeInstant("dateTime", element.getDateTime());
      if (element.getOutcome() != null)
        composeEnumeration("outcome", element.getOutcome(), new SecurityEvent().new SecurityEventEventOutcomeEnumFactory());
      if (element.getCode().size() > 0) {
        openArray("code");
        for (Coding e : element.getCode()) 
          composeCoding(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeSecurityEventParticipant(String name, SecurityEvent.Participant element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("userId", element.getUserId());
      composeString("otherUserId", element.getOtherUserId());
      composeString("name", element.getName());
      composeBoolean("requestor", element.getRequestor());
      if (element.getRole().size() > 0) {
        openArray("role");
        for (Coding e : element.getRole()) 
          composeCoding(null, e);
        closeArray();
      };
      composeSecurityEventNetwork("network", element.getNetwork());
      close();
    }
  }

  private void composeSecurityEventNetwork(String name, SecurityEvent.Network element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new SecurityEvent().new NetworkTypeEnumFactory());
      composeString("id", element.getId());
      close();
    }
  }

  private void composeSecurityEventSource(String name, SecurityEvent.Source element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("site", element.getSite());
      composeString("id", element.getId());
      if (element.getType().size() > 0) {
        openArray("type");
        for (Coding e : element.getType()) 
          composeCoding(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeSecurityEventObject(String name, SecurityEvent.Object element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new SecurityEvent().new ObjectTypeEnumFactory());
      if (element.getRole() != null)
        composeEnumeration("role", element.getRole(), new SecurityEvent().new ObjectRoleEnumFactory());
      if (element.getLifecycle() != null)
        composeEnumeration("lifecycle", element.getLifecycle(), new SecurityEvent().new ObjectLifecycleEnumFactory());
      composeCoding("idType", element.getIdType());
      composeString("id", element.getId());
      composeString("sensitivity", element.getSensitivity());
      composeString("name", element.getName());
      composeBase64Binary("query", element.getQuery());
      close();
    }
  }

  private void composeIssueReport(String name, IssueReport element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getIssue().size() > 0) {
        openArray("issue");
        for (IssueReport.Issue e : element.getIssue()) 
          composeIssueReportIssue(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeIssueReportIssue(String name, IssueReport.Issue element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getSeverity() != null)
        composeEnumeration("severity", element.getSeverity(), new IssueReport().new IssueSeverityEnumFactory());
      composeCodeableConcept("type", element.getType());
      composeString("details", element.getDetails());
      if (element.getLocation().size() > 0) {
        openArray("location");
        for (String_ e : element.getLocation()) 
          composeString(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeList_(String name, List_ element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("source", element.getSource());
      composeDateTime("date", element.getDate());
      composeBoolean("ordered", element.getOrdered());
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new List_().new ListModeEnumFactory());
      if (element.getEntry().size() > 0) {
        openArray("entry");
        for (List_.Entry e : element.getEntry()) 
          composeList_Entry(null, e);
        closeArray();
      };
      composeCodeableConcept("emptyReason", element.getEmptyReason());
      close();
    }
  }

  private void composeList_Entry(String name, List_.Entry element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getFlag().size() > 0) {
        openArray("flag");
        for (CodeableConcept e : element.getFlag()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeBoolean("deleted", element.getDeleted());
      composeResourceReference("item", element.getItem());
      close();
    }
  }

  private void composeConformance(String name, Conformance element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeDateTime("date", element.getDate());
      composeConformancePublisher("publisher", element.getPublisher());
      composeConformanceImplementation("implementation", element.getImplementation());
      composeConformanceSoftware("software", element.getSoftware());
      composeConformanceProposal("proposal", element.getProposal());
      composeId("version", element.getVersion());
      composeBoolean("acceptUnknown", element.getAcceptUnknown());
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
      close();
    }
  }

  private void composeConformancePublisher(String name, Conformance.Publisher element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
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
      composeElement(element);
      composeString("description", element.getDescription());
      composeUri("url", element.getUrl());
      close();
    }
  }

  private void composeConformanceSoftware(String name, Conformance.Software element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeDateTime("releaseDate", element.getReleaseDate());
      close();
    }
  }

  private void composeConformanceProposal(String name, Conformance.Proposal element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("description", element.getDescription());
      close();
    }
  }

  private void composeConformanceRest(String name, Conformance.Rest element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Conformance().new RestfulConformanceModeEnumFactory());
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
      composeElement(element);
      composeCode("type", element.getType());
      composeUri("profile", element.getProfile());
      if (element.getOperation().size() > 0) {
        openArray("operation");
        for (Conformance.Operation e : element.getOperation()) 
          composeConformanceOperation(null, e);
        closeArray();
      };
      composeBoolean("history", element.getHistory());
      close();
    }
  }

  private void composeConformanceOperation(String name, Conformance.Operation element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new Conformance().new RestfulOperationEnumFactory());
      composeString("documentation", element.getDocumentation());
      close();
    }
  }

  private void composeConformanceMessaging(String name, Conformance.Messaging element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeUri("endpoint", element.getEndpoint());
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
      composeElement(element);
      composeCode("code", element.getCode());
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Conformance().new MessageConformanceEventModeEnumFactory());
      if (element.getProtocol().size() > 0) {
        openArray("protocol");
        for (Coding e : element.getProtocol()) 
          composeCoding(null, e);
        closeArray();
      };
      composeCode("focus", element.getFocus());
      composeUri("request", element.getRequest());
      composeUri("response", element.getResponse());
      composeString("documentation", element.getDocumentation());
      close();
    }
  }

  private void composeConformanceDocument(String name, Conformance.Document element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Conformance().new DocumentModeEnumFactory());
      composeString("documentation", element.getDocumentation());
      composeUri("profile", element.getProfile());
      close();
    }
  }

  private void composeXdsEntry(String name, XdsEntry element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeUri("url", element.getUrl());
      composeUri("repositoryId", element.getRepositoryId());
      composeString("mimeType", element.getMimeType());
      composeCoding("format", element.getFormat());
      composeCoding("class", element.getClass_());
      composeCoding("type", element.getType());
      composeString("title", element.getTitle());
      composeUri("documentId", element.getDocumentId());
      if (element.getAvailability() != null)
        composeEnumeration("availability", element.getAvailability(), new XdsEntry().new XdsEntryAvailabilityEnumFactory());
      composeCoding("confidentialityCode", element.getConfidentialityCode());
      composeInstant("created", element.getCreated());
      if (element.getEvent().size() > 0) {
        openArray("event");
        for (Coding e : element.getEvent()) 
          composeCoding(null, e);
        closeArray();
      };
      composeString("hash", element.getHash());
      composeString("size", element.getSize());
      composeString("lang", element.getLang());
      if (element.getFolder().size() > 0) {
        openArray("folder");
        for (ResourceReference e : element.getFolder()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeIdentifier("patientId", element.getPatientId());
      composeIdentifier("sourcePatientId", element.getSourcePatientId());
      composeResourceReference("patientInfo", element.getPatientInfo());
      if (element.getAuthor().size() > 0) {
        openArray("author");
        for (XdsEntry.Author e : element.getAuthor()) 
          composeXdsEntryAuthor(null, e);
        closeArray();
      };
      composeXdsEntryAuthenticator("authenticator", element.getAuthenticator());
      composeCoding("facilityType", element.getFacilityType());
      composeCoding("practiceSetting", element.getPracticeSetting());
      composeUri("homeCommunity", element.getHomeCommunity());
      composeXdsEntryService("service", element.getService());
      composeString("comments", element.getComments());
      close();
    }
  }

  private void composeXdsEntryAuthor(String name, XdsEntry.Author element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeHumanName("name", element.getName());
      composeIdentifier("id", element.getId());
      if (element.getRole().size() > 0) {
        openArray("role");
        for (String_ e : element.getRole()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getSpecialty().size() > 0) {
        openArray("specialty");
        for (String_ e : element.getSpecialty()) 
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
      composeElement(element);
      composeIdentifier("id", element.getId());
      composeString("name", element.getName());
      close();
    }
  }

  private void composeXdsEntryAuthenticator(String name, XdsEntry.Authenticator element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeIdentifier("id", element.getId());
      composeHumanName("name", element.getName());
      close();
    }
  }

  private void composeXdsEntryService(String name, XdsEntry.Service element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDateTime("start", element.getStart());
      composeDateTime("stop", element.getStop());
      close();
    }
  }

  private void composeDocument(String name, Document element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeDocumentInformation("information", element.getInformation());
      composeId("replaces", element.getReplaces());
      if (element.getProvenance().size() > 0) {
        openArray("provenance");
        for (ResourceReference e : element.getProvenance()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeAttachment("stylesheet", element.getStylesheet());
      composeAttachment("representation", element.getRepresentation());
      if (element.getSection().size() > 0) {
        openArray("section");
        for (Document.Section e : element.getSection()) 
          composeDocumentSection(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDocumentSection(String name, Document.Section element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("content", element.getContent());
      if (element.getSection().size() > 0) {
        openArray("section");
        for (Document.Section e : element.getSection()) 
          composeDocumentSection(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeMessage(String name, Message element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeId("id", element.getId());
      composeInstant("instant", element.getInstant());
      composeCode("event", element.getEvent());
      composeMessageResponse("response", element.getResponse());
      composeMessageSource("source", element.getSource());
      composeMessageDestination("destination", element.getDestination());
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
      close();
    }
  }

  private void composeMessageResponse(String name, Message.Response element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeId("id", element.getId());
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new Message().new ResponseCodeEnumFactory());
      composeResourceReference("details", element.getDetails());
      close();
    }
  }

  private void composeMessageSource(String name, Message.Source element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeString("software", element.getSoftware());
      composeString("version", element.getVersion());
      composeContact("contact", element.getContact());
      composeUri("endpoint", element.getEndpoint());
      close();
    }
  }

  private void composeMessageDestination(String name, Message.Destination element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeResourceReference("target", element.getTarget());
      composeUri("endpoint", element.getEndpoint());
      close();
    }
  }

  private void composeProfile(String name, Profile element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
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
      composeCode("bundle", element.getBundle());
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
      close();
    }
  }

  private void composeProfileAuthor(String name, Profile.Author element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      if (element.getTelecom().size() > 0) {
        openArray("telecom");
        for (Contact e : element.getTelecom()) 
          composeContact(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileStatus(String name, Profile.Status element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new Profile().new ResourceProfileStatusEnumFactory());
      composeDateTime("date", element.getDate());
      composeString("comment", element.getComment());
      close();
    }
  }

  private void composeProfileImport(String name, Profile.Import element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeUri("uri", element.getUri());
      composeString("prefix", element.getPrefix());
      close();
    }
  }

  private void composeProfileResource(String name, Profile.Resource element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("type", element.getType());
      composeUri("profile", element.getProfile());
      composeString("name", element.getName());
      composeString("purpose", element.getPurpose());
      if (element.getElement().size() > 0) {
        openArray("element");
        for (Profile.Element_ e : element.getElement()) 
          composeProfileElement_(null, e);
        closeArray();
      };
      if (element.getSearchParam().size() > 0) {
        openArray("searchParam");
        for (Profile.SearchParam e : element.getSearchParam()) 
          composeProfileSearchParam(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileElement_(String name, Profile.Element_ element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("path", element.getPath());
      composeString("name", element.getName());
      composeProfileDefinition("definition", element.getDefinition());
      composeBoolean("bundled", element.getBundled());
      composeBoolean("closed", element.getClosed());
      close();
    }
  }

  private void composeProfileDefinition(String name, Profile.Definition element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("short", element.getShort());
      composeString("formal", element.getFormal());
      composeString("comments", element.getComments());
      composeString("requirements", element.getRequirements());
      if (element.getSynonym().size() > 0) {
        openArray("synonym");
        for (String_ e : element.getSynonym()) 
          composeString(null, e);
        closeArray();
      };
      composeInteger("min", element.getMin());
      composeString("max", element.getMax());
      if (element.getType().size() > 0) {
        openArray("type");
        for (Profile.Type e : element.getType()) 
          composeProfileType(null, e);
        closeArray();
      };
      composeString("nameReference", element.getNameReference());
      composeType("value", element.getValue());
      composeInteger("maxLength", element.getMaxLength());
      if (element.getCondition().size() > 0) {
        openArray("condition");
        for (Id e : element.getCondition()) 
          composeId(null, e);
        closeArray();
      };
      if (element.getConstraint().size() > 0) {
        openArray("constraint");
        for (Profile.Constraint e : element.getConstraint()) 
          composeProfileConstraint(null, e);
        closeArray();
      };
      composeBoolean("mustSupport", element.getMustSupport());
      composeBoolean("mustUnderstand", element.getMustUnderstand());
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
      composeElement(element);
      composeCode("code", element.getCode());
      composeUri("profile", element.getProfile());
      close();
    }
  }

  private void composeProfileConstraint(String name, Profile.Constraint element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeId("id", element.getId());
      composeString("name", element.getName());
      if (element.getSeverity() != null)
        composeEnumeration("severity", element.getSeverity(), new Profile().new ConstraintSeverityEnumFactory());
      composeString("human", element.getHuman());
      composeString("xpath", element.getXpath());
      composeString("ocl", element.getOcl());
      close();
    }
  }

  private void composeProfileMapping(String name, Profile.Mapping element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("target", element.getTarget());
      composeString("map", element.getMap());
      close();
    }
  }

  private void composeProfileSearchParam(String name, Profile.SearchParam element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Profile().new SearchParamTypeEnumFactory());
      if (element.getRepeats() != null)
        composeEnumeration("repeats", element.getRepeats(), new Profile().new SearchRepeatBehaviorEnumFactory());
      composeString("documentation", element.getDocumentation());
      close();
    }
  }

  private void composeProfileExtensionDefn(String name, Profile.ExtensionDefn element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeId("id", element.getId());
      if (element.getContextType() != null)
        composeEnumeration("contextType", element.getContextType(), new Profile().new ExtensionContextEnumFactory());
      if (element.getContext().size() > 0) {
        openArray("context");
        for (String_ e : element.getContext()) 
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
      composeElement(element);
      composeString("name", element.getName());
      composeString("definition", element.getDefinition());
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Profile().new BindingTypeEnumFactory());
      composeBoolean("isExtensible", element.getIsExtensible());
      if (element.getConformance() != null)
        composeEnumeration("conformance", element.getConformance(), new Profile().new BindingConformanceEnumFactory());
      composeUri("reference", element.getReference());
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
      composeElement(element);
      composeString("code", element.getCode());
      composeUri("system", element.getSystem());
      composeString("display", element.getDisplay());
      composeString("definition", element.getDefinition());
      close();
    }
  }

  private void composeObservation(String name, Observation element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      composeCodeableConcept("interpretation", element.getInterpretation());
      composeString("comments", element.getComments());
      composeType("obtained", element.getObtained());
      composeInstant("issued", element.getIssued());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Observation().new ObservationStatusEnumFactory());
      if (element.getReliability() != null)
        composeEnumeration("reliability", element.getReliability(), new Observation().new ObservationReliabilityEnumFactory());
      composeCodeableConcept("bodySite", element.getBodySite());
      composeCodeableConcept("method", element.getMethod());
      composeIdentifier("identifier", element.getIdentifier());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("performer", element.getPerformer());
      if (element.getReferenceRange().size() > 0) {
        openArray("referenceRange");
        for (Observation.ReferenceRange e : element.getReferenceRange()) 
          composeObservationReferenceRange(null, e);
        closeArray();
      };
      if (element.getComponent().size() > 0) {
        openArray("component");
        for (Observation.Component e : element.getComponent()) 
          composeObservationComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeObservationReferenceRange(String name, Observation.ReferenceRange element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("meaning", element.getMeaning());
      composeType("range", element.getRange());
      close();
    }
  }

  private void composeObservationComponent(String name, Observation.Component element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      close();
    }
  }

  private void composeImmunization(String name, Immunization element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeCodeableConcept("type", element.getType());
      composeDateTime("date", element.getDate());
      composeBoolean("reported", element.getReported());
      composeInteger("doseSequence", element.getDoseSequence());
      composeResourceReference("manufacturer", element.getManufacturer());
      composeString("lotNumber", element.getLotNumber());
      composeDate("expirationDate", element.getExpirationDate());
      composeCodeableConcept("site", element.getSite());
      composeCodeableConcept("route", element.getRoute());
      composeResourceReference("requester", element.getRequester());
      composeResourceReference("performer", element.getPerformer());
      composeImmunizationRefusal("refusal", element.getRefusal());
      if (element.getReaction().size() > 0) {
        openArray("reaction");
        for (Immunization.Reaction e : element.getReaction()) 
          composeImmunizationReaction(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeImmunizationRefusal(String name, Immunization.Refusal element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDateTime("date", element.getDate());
      composeCodeableConcept("reason", element.getReason());
      close();
    }
  }

  private void composeImmunizationReaction(String name, Immunization.Reaction element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDateTime("date", element.getDate());
      composeResourceReference("detail", element.getDetail());
      close();
    }
  }

  private void composeProblem(String name, Problem element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("encounter", element.getEncounter());
      composeResourceReference("asserter", element.getAsserter());
      composeDate("dateAsserted", element.getDateAsserted());
      composeCodeableConcept("code", element.getCode());
      composeCodeableConcept("category", element.getCategory());
      composeCode("status", element.getStatus());
      composeCodeableConcept("certainty", element.getCertainty());
      composeCodeableConcept("severity", element.getSeverity());
      composeType("onset", element.getOnset());
      composeType("abatement", element.getAbatement());
      composeProblemStage("stage", element.getStage());
      if (element.getEvidence().size() > 0) {
        openArray("evidence");
        for (Problem.Evidence e : element.getEvidence()) 
          composeProblemEvidence(null, e);
        closeArray();
      };
      if (element.getLocation().size() > 0) {
        openArray("location");
        for (Problem.Location e : element.getLocation()) 
          composeProblemLocation(null, e);
        closeArray();
      };
      if (element.getRelatedItem().size() > 0) {
        openArray("relatedItem");
        for (Problem.RelatedItem e : element.getRelatedItem()) 
          composeProblemRelatedItem(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProblemStage(String name, Problem.Stage element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
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
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      if (element.getDetails().size() > 0) {
        openArray("details");
        for (ResourceReference e : element.getDetails()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProblemLocation(String name, Problem.Location element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("details", element.getDetails());
      close();
    }
  }

  private void composeProblemRelatedItem(String name, Problem.RelatedItem element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Problem().new ProblemRelationshipTypeEnumFactory());
      composeResourceReference("target", element.getTarget());
      close();
    }
  }

  private void composeOrderResponse(String name, OrderResponse element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("request", element.getRequest());
      composeDateTime("date", element.getDate());
      composeResourceReference("who", element.getWho());
      composeResourceReference("authority", element.getAuthority());
      composeMoney("cost", element.getCost());
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new OrderResponse().new OrderOutcomeCodeEnumFactory());
      composeString("description", element.getDescription());
      if (element.getFulfillment().size() > 0) {
        openArray("fulfillment");
        for (ResourceReference e : element.getFulfillment()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composePatient(String name, Patient element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getLink().size() > 0) {
        openArray("link");
        for (ResourceReference e : element.getLink()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeBoolean("active", element.getActive());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeDemographics("details", element.getDetails());
      composePatientAnimal("animal", element.getAnimal());
      composeResourceReference("provider", element.getProvider());
      composeCodeableConcept("diet", element.getDiet());
      composeCodeableConcept("confidentiality", element.getConfidentiality());
      composeCodeableConcept("recordLocation", element.getRecordLocation());
      close();
    }
  }

  private void composePatientAnimal(String name, Patient.Animal element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("species", element.getSpecies());
      composeCodeableConcept("breed", element.getBreed());
      composeCodeableConcept("genderStatus", element.getGenderStatus());
      close();
    }
  }

  private void composeXdsEntry2(String name, XdsEntry2 element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeIdentifier("id", element.getId());
      composeDocumentInformation("information", element.getInformation());
      composeCoding("format", element.getFormat());
      if (element.getAvailability() != null)
        composeEnumeration("availability", element.getAvailability(), new XdsEntry2().new XdsEntryAvailabilityEnumFactory());
      if (element.getFolder().size() > 0) {
        openArray("folder");
        for (ResourceReference e : element.getFolder()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeResourceReference("subject", element.getSubject());
      composeAttachment("content", element.getContent());
      close();
    }
  }

  private void composeProvider(String name, Provider element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeDemographics("details", element.getDetails());
      composeResourceReference("organization", element.getOrganization());
      if (element.getRole().size() > 0) {
        openArray("role");
        for (CodeableConcept e : element.getRole()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      if (element.getSpecialty().size() > 0) {
        openArray("specialty");
        for (CodeableConcept e : element.getSpecialty()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composePeriod("period", element.getPeriod());
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

  private void composeXdsFolder(String name, XdsFolder element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
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
      close();
    }
  }

  @Override
  protected void composeResource(Resource resource) throws Exception {
    if (resource instanceof CarePlan)
      composeCarePlan("CarePlan", (CarePlan)resource);
    else if (resource instanceof Provenance)
      composeProvenance("Provenance", (Provenance)resource);
    else if (resource instanceof Device)
      composeDevice("Device", (Device)resource);
    else if (resource instanceof Order)
      composeOrder("Order", (Order)resource);
    else if (resource instanceof Organization)
      composeOrganization("Organization", (Organization)resource);
    else if (resource instanceof Prescription)
      composePrescription("Prescription", (Prescription)resource);
    else if (resource instanceof Group)
      composeGroup("Group", (Group)resource);
    else if (resource instanceof DiagnosticReport)
      composeDiagnosticReport("DiagnosticReport", (DiagnosticReport)resource);
    else if (resource instanceof ValueSet)
      composeValueSet("ValueSet", (ValueSet)resource);
    else if (resource instanceof Coverage)
      composeCoverage("Coverage", (Coverage)resource);
    else if (resource instanceof Test)
      composeTest("Test", (Test)resource);
    else if (resource instanceof MedicationAdministration)
      composeMedicationAdministration("MedicationAdministration", (MedicationAdministration)resource);
    else if (resource instanceof SecurityEvent)
      composeSecurityEvent("SecurityEvent", (SecurityEvent)resource);
    else if (resource instanceof IssueReport)
      composeIssueReport("IssueReport", (IssueReport)resource);
    else if (resource instanceof List_)
      composeList_("List", (List_)resource);
    else if (resource instanceof Conformance)
      composeConformance("Conformance", (Conformance)resource);
    else if (resource instanceof XdsEntry)
      composeXdsEntry("XdsEntry", (XdsEntry)resource);
    else if (resource instanceof Document)
      composeDocument("Document", (Document)resource);
    else if (resource instanceof Message)
      composeMessage("Message", (Message)resource);
    else if (resource instanceof Profile)
      composeProfile("Profile", (Profile)resource);
    else if (resource instanceof Observation)
      composeObservation("Observation", (Observation)resource);
    else if (resource instanceof Immunization)
      composeImmunization("Immunization", (Immunization)resource);
    else if (resource instanceof Problem)
      composeProblem("Problem", (Problem)resource);
    else if (resource instanceof OrderResponse)
      composeOrderResponse("OrderResponse", (OrderResponse)resource);
    else if (resource instanceof Patient)
      composePatient("Patient", (Patient)resource);
    else if (resource instanceof XdsEntry2)
      composeXdsEntry2("XdsEntry2", (XdsEntry2)resource);
    else if (resource instanceof Provider)
      composeProvider("Provider", (Provider)resource);
    else if (resource instanceof XdsFolder)
      composeXdsFolder("XdsFolder", (XdsFolder)resource);
    else if (resource instanceof Binary)
      composeBinary("Binary", (Binary)resource);
    else
      throw new Exception("Unhanded resource type "+resource.getClass().getName());
  }

  protected void composeNamedResource(String name, Resource resource) throws Exception {
    if (resource instanceof CarePlan)
      composeCarePlan(name, (CarePlan)resource);
    else if (resource instanceof Provenance)
      composeProvenance(name, (Provenance)resource);
    else if (resource instanceof Device)
      composeDevice(name, (Device)resource);
    else if (resource instanceof Order)
      composeOrder(name, (Order)resource);
    else if (resource instanceof Organization)
      composeOrganization(name, (Organization)resource);
    else if (resource instanceof Prescription)
      composePrescription(name, (Prescription)resource);
    else if (resource instanceof Group)
      composeGroup(name, (Group)resource);
    else if (resource instanceof DiagnosticReport)
      composeDiagnosticReport(name, (DiagnosticReport)resource);
    else if (resource instanceof ValueSet)
      composeValueSet(name, (ValueSet)resource);
    else if (resource instanceof Coverage)
      composeCoverage(name, (Coverage)resource);
    else if (resource instanceof Test)
      composeTest(name, (Test)resource);
    else if (resource instanceof MedicationAdministration)
      composeMedicationAdministration(name, (MedicationAdministration)resource);
    else if (resource instanceof SecurityEvent)
      composeSecurityEvent(name, (SecurityEvent)resource);
    else if (resource instanceof IssueReport)
      composeIssueReport(name, (IssueReport)resource);
    else if (resource instanceof List_)
      composeList_(name, (List_)resource);
    else if (resource instanceof Conformance)
      composeConformance(name, (Conformance)resource);
    else if (resource instanceof XdsEntry)
      composeXdsEntry(name, (XdsEntry)resource);
    else if (resource instanceof Document)
      composeDocument(name, (Document)resource);
    else if (resource instanceof Message)
      composeMessage(name, (Message)resource);
    else if (resource instanceof Profile)
      composeProfile(name, (Profile)resource);
    else if (resource instanceof Observation)
      composeObservation(name, (Observation)resource);
    else if (resource instanceof Immunization)
      composeImmunization(name, (Immunization)resource);
    else if (resource instanceof Problem)
      composeProblem(name, (Problem)resource);
    else if (resource instanceof OrderResponse)
      composeOrderResponse(name, (OrderResponse)resource);
    else if (resource instanceof Patient)
      composePatient(name, (Patient)resource);
    else if (resource instanceof XdsEntry2)
      composeXdsEntry2(name, (XdsEntry2)resource);
    else if (resource instanceof Provider)
      composeProvider(name, (Provider)resource);
    else if (resource instanceof XdsFolder)
      composeXdsFolder(name, (XdsFolder)resource);
    else if (resource instanceof Binary)
      composeBinary(name, (Binary)resource);
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
    else if (type instanceof DocumentInformation)
       composeDocumentInformation(prefix+"DocumentInformation", (DocumentInformation) type);
    else if (type instanceof Demographics)
       composeDemographics(prefix+"Demographics", (Demographics) type);
    else if (type instanceof Integer)
       composeInteger(prefix+"Integer", (Integer) type);
    else if (type instanceof DateTime)
       composeDateTime(prefix+"DateTime", (DateTime) type);
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
       composeString(prefix+"String", (String_) type);
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

