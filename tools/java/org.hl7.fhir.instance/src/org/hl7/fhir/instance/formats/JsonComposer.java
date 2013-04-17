package org.hl7.fhir.instance.formats;

/*
  Copyright (c) 2011-2013, HL7, Inc.
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

// Generated on Sun, Apr 14, 2013 21:55+1000 for FHIR v0.08

import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.utilities.Utilities;
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || value.getValue() != null)) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || !Utilities.noString(value.getValue()))) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || !Utilities.noString(value.getValue()))) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || !Utilities.noString(value.getValue()))) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || value.getValue() != null)) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || value.getValue() != null)) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || !Utilities.noString(value.getValue()))) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || value.getValue() != null)) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || !Utilities.noString(value.getValue()))) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || !Utilities.noString(value.getValue()))) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || !Utilities.noString(value.getValue()))) {
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
    if (value != null && (!Utilities.noString(value.getXmlId()) || value.hasExtensions() || value.getValue() != null)) {
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
      if (element.getBlob().size() > 0) {
        openArray("blob");
        for (Narrative.NarrativeBlobComponent e : element.getBlob()) 
          composeNarrativeNarrativeBlobComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeNarrativeNarrativeBlobComponent(String name, Narrative.NarrativeBlobComponent element) throws Exception {
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
        for (Choice.ChoiceOptionComponent e : element.getOption()) 
          composeChoiceChoiceOptionComponent(null, e);
        closeArray();
      };
      composeBoolean("isOrdered", element.getIsOrdered());
      close();
    }
  }

  private void composeChoiceChoiceOptionComponent(String name, Choice.ChoiceOptionComponent element) throws Exception {
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
      composeScheduleScheduleRepeatComponent("repeat", element.getRepeat());
      close();
    }
  }

  private void composeScheduleScheduleRepeatComponent(String name, Schedule.ScheduleRepeatComponent element) throws Exception {
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

  private void composeDemographics(String name, Demographics element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
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
      composeCoding("gender", element.getGender());
      composeDateTime("birthDate", element.getBirthDate());
      composeBoolean("deceased", element.getDeceased());
      if (element.getAddress().size() > 0) {
        openArray("address");
        for (Address e : element.getAddress()) 
          composeAddress(null, e);
        closeArray();
      };
      if (element.getPhoto().size() > 0) {
        openArray("photo");
        for (ResourceReference e : element.getPhoto()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeCodeableConcept("maritalStatus", element.getMaritalStatus());
      if (element.getLanguage().size() > 0) {
        openArray("language");
        for (Demographics.DemographicsLanguageComponent e : element.getLanguage()) 
          composeDemographicsDemographicsLanguageComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDemographicsDemographicsLanguageComponent(String name, Demographics.DemographicsLanguageComponent element) throws Exception {
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

  private void composeProvenance(String name, Provenance element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("target", element.getTarget());
      composeProvenanceProvenanceActivityComponent("activity", element.getActivity());
      if (element.getParty().size() > 0) {
        openArray("party");
        for (Provenance.ProvenancePartyComponent e : element.getParty()) 
          composeProvenanceProvenancePartyComponent(null, e);
        closeArray();
      };
      composeString("signature", element.getSignature());
      close();
    }
  }

  private void composeProvenanceProvenanceActivityComponent(String name, Provenance.ProvenanceActivityComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composePeriod("period", element.getPeriod());
      composeInstant("recorded", element.getRecorded());
      composeCodeableConcept("reason", element.getReason());
      composeProvenanceProvenanceActivityLocationComponent("location", element.getLocation());
      composeUri("policy", element.getPolicy());
      close();
    }
  }

  private void composeProvenanceProvenanceActivityLocationComponent(String name, Provenance.ProvenanceActivityLocationComponent element) throws Exception {
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

  private void composeProvenanceProvenancePartyComponent(String name, Provenance.ProvenancePartyComponent element) throws Exception {
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
        for (CarePlan.CarePlanParticipantComponent e : element.getParticipant()) 
          composeCarePlanCarePlanParticipantComponent(null, e);
        closeArray();
      };
      if (element.getGoal().size() > 0) {
        openArray("goal");
        for (CarePlan.CarePlanGoalComponent e : element.getGoal()) 
          composeCarePlanCarePlanGoalComponent(null, e);
        closeArray();
      };
      if (element.getActivity().size() > 0) {
        openArray("activity");
        for (CarePlan.CarePlanActivityComponent e : element.getActivity()) 
          composeCarePlanCarePlanActivityComponent(null, e);
        closeArray();
      };
      composeString("notes", element.getNotes());
      close();
    }
  }

  private void composeCarePlanCarePlanParticipantComponent(String name, CarePlan.CarePlanParticipantComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("role", element.getRole());
      composeResourceReference("member", element.getMember());
      close();
    }
  }

  private void composeCarePlanCarePlanGoalComponent(String name, CarePlan.CarePlanGoalComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("description", element.getDescription());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new CarePlan().new CarePlanGoalStatusEnumFactory());
      composeString("notes", element.getNotes());
      close();
    }
  }

  private void composeCarePlanCarePlanActivityComponent(String name, CarePlan.CarePlanActivityComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getCategory() != null)
        composeEnumeration("category", element.getCategory(), new CarePlan().new CarePlanActivityCategoryEnumFactory());
      composeCodeableConcept("code", element.getCode());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new CarePlan().new CarePlanActivityStatusEnumFactory());
      composeBoolean("prohibited", element.getProhibited());
      composeType("timing", element.getTiming());
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
      if (element.getActionTaken().size() > 0) {
        openArray("actionTaken");
        for (ResourceReference e : element.getActionTaken()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeString("notes", element.getNotes());
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
      composeDeviceDeviceIdentityComponent("identity", element.getIdentity());
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

  private void composeDeviceDeviceIdentityComponent(String name, Device.DeviceIdentityComponent element) throws Exception {
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
      composeOrderOrderWhenComponent("when", element.getWhen());
      if (element.getDetail().size() > 0) {
        openArray("detail");
        for (ResourceReference e : element.getDetail()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeOrderOrderWhenComponent(String name, Order.OrderWhenComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeSchedule("schedule", element.getSchedule());
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
      composePrescriptionPrescriptionDispenseComponent("dispense", element.getDispense());
      composePrescriptionPrescriptionMedicineComponent("medicine", element.getMedicine());
      composePrescriptionPrescriptionAdministrationRequestComponent("administrationRequest", element.getAdministrationRequest());
      composeCodeableConcept("reason", element.getReason());
      close();
    }
  }

  private void composePrescriptionPrescriptionDispenseComponent(String name, Prescription.PrescriptionDispenseComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeInteger("repeats", element.getRepeats());
      composeQuantity("quantity", element.getQuantity());
      composeResourceReference("dispenser", element.getDispenser());
      close();
    }
  }

  private void composePrescriptionPrescriptionMedicineComponent(String name, Prescription.PrescriptionMedicineComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("identification", element.getIdentification());
      if (element.getActiveIngredient().size() > 0) {
        openArray("activeIngredient");
        for (Prescription.PrescriptionMedicineActiveIngredientComponent e : element.getActiveIngredient()) 
          composePrescriptionPrescriptionMedicineActiveIngredientComponent(null, e);
        closeArray();
      };
      if (element.getInactiveIngredient().size() > 0) {
        openArray("inactiveIngredient");
        for (Prescription.PrescriptionMedicineInactiveIngredientComponent e : element.getInactiveIngredient()) 
          composePrescriptionPrescriptionMedicineInactiveIngredientComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composePrescriptionPrescriptionMedicineActiveIngredientComponent(String name, Prescription.PrescriptionMedicineActiveIngredientComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      close();
    }
  }

  private void composePrescriptionPrescriptionMedicineInactiveIngredientComponent(String name, Prescription.PrescriptionMedicineInactiveIngredientComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("identification", element.getIdentification());
      composeType("quantity", element.getQuantity());
      close();
    }
  }

  private void composePrescriptionPrescriptionAdministrationRequestComponent(String name, Prescription.PrescriptionAdministrationRequestComponent element) throws Exception {
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
        for (Prescription.PrescriptionAdministrationRequestDosageInstructionComponent e : element.getDosageInstruction()) 
          composePrescriptionPrescriptionAdministrationRequestDosageInstructionComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composePrescriptionPrescriptionAdministrationRequestDosageInstructionComponent(String name, Prescription.PrescriptionAdministrationRequestDosageInstructionComponent element) throws Exception {
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
      composeCodeableConcept("type", element.getType());
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
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Organization().new RecordStatusEnumFactory());
      if (element.getAccreditation().size() > 0) {
        openArray("accreditation");
        for (Organization.OrganizationAccreditationComponent e : element.getAccreditation()) 
          composeOrganizationOrganizationAccreditationComponent(null, e);
        closeArray();
      };
      if (element.getRelatedOrganization().size() > 0) {
        openArray("relatedOrganization");
        for (Organization.OrganizationRelatedOrganizationComponent e : element.getRelatedOrganization()) 
          composeOrganizationOrganizationRelatedOrganizationComponent(null, e);
        closeArray();
      };
      if (element.getContactPerson().size() > 0) {
        openArray("contactPerson");
        for (Organization.OrganizationContactPersonComponent e : element.getContactPerson()) 
          composeOrganizationOrganizationContactPersonComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeOrganizationOrganizationAccreditationComponent(String name, Organization.OrganizationAccreditationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeIdentifier("identifier", element.getIdentifier());
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("issuer", element.getIssuer());
      composePeriod("period", element.getPeriod());
      close();
    }
  }

  private void composeOrganizationOrganizationRelatedOrganizationComponent(String name, Organization.OrganizationRelatedOrganizationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeResourceReference("organization", element.getOrganization());
      composeCodeableConcept("relation", element.getRelation());
      close();
    }
  }

  private void composeOrganizationOrganizationContactPersonComponent(String name, Organization.OrganizationContactPersonComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("type", element.getType());
      composeDemographics("details", element.getDetails());
      close();
    }
  }

  private void composeProcedure(String name, Procedure element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeProcedureProcedureDescriptionComponent("description", element.getDescription());
      composeString("indication", element.getIndication());
      if (element.getPerformer().size() > 0) {
        openArray("performer");
        for (Procedure.ProcedurePerformerComponent e : element.getPerformer()) 
          composeProcedureProcedurePerformerComponent(null, e);
        closeArray();
      };
      composePeriod("date", element.getDate());
      composeResourceReference("visit", element.getVisit());
      composeString("outcome", element.getOutcome());
      if (element.getReport().size() > 0) {
        openArray("report");
        for (ResourceReference e : element.getReport()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getComplication().size() > 0) {
        openArray("complication");
        for (String_ e : element.getComplication()) 
          composeString(null, e);
        closeArray();
      };
      composeString("followUp", element.getFollowUp());
      if (element.getRelatedItem().size() > 0) {
        openArray("relatedItem");
        for (Procedure.ProcedureRelatedItemComponent e : element.getRelatedItem()) 
          composeProcedureProcedureRelatedItemComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProcedureProcedureDescriptionComponent(String name, Procedure.ProcedureDescriptionComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("type", element.getType());
      composeString("notes", element.getNotes());
      if (element.getBodySite().size() > 0) {
        openArray("bodySite");
        for (CodeableConcept e : element.getBodySite()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProcedureProcedurePerformerComponent(String name, Procedure.ProcedurePerformerComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeResourceReference("person", element.getPerson());
      composeCodeableConcept("role", element.getRole());
      close();
    }
  }

  private void composeProcedureProcedureRelatedItemComponent(String name, Procedure.ProcedureRelatedItemComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Procedure().new ProcedureRelationshipTypeEnumFactory());
      composeResourceReference("target", element.getTarget());
      close();
    }
  }

  private void composeSubstance(String name, Substance element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeIdentifier("identifier", element.getIdentifier());
      composeString("name", element.getName());
      composeCoding("type", element.getType());
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
        for (Group.GroupCharacteristicComponent e : element.getCharacteristic()) 
          composeGroupGroupCharacteristicComponent(null, e);
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

  private void composeGroupGroupCharacteristicComponent(String name, Group.GroupCharacteristicComponent element) throws Exception {
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
        for (DiagnosticReport.DiagnosticReportRequestDetailComponent e : element.getRequestDetail()) 
          composeDiagnosticReportDiagnosticReportRequestDetailComponent(null, e);
        closeArray();
      };
      composeCodeableConcept("serviceCategory", element.getServiceCategory());
      composeDateTime("diagnosticTime", element.getDiagnosticTime());
      composeDiagnosticReportResultGroupComponent("results", element.getResults());
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

  private void composeDiagnosticReportDiagnosticReportRequestDetailComponent(String name, DiagnosticReport.DiagnosticReportRequestDetailComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeResourceReference("visit", element.getVisit());
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

  private void composeDiagnosticReportResultGroupComponent(String name, DiagnosticReport.ResultGroupComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("name", element.getName());
      composeResourceReference("specimen", element.getSpecimen());
      if (element.getGroup().size() > 0) {
        openArray("group");
        for (DiagnosticReport.ResultGroupComponent e : element.getGroup()) 
          composeDiagnosticReportResultGroupComponent(null, e);
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
      if (element.getAuthor().size() > 0) {
        openArray("author");
        for (ValueSet.AuthorComponent e : element.getAuthor()) 
          composeValueSetAuthorComponent(null, e);
        closeArray();
      };
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
        for (ValueSet.ConceptSetComponent e : element.getInclude()) 
          composeValueSetConceptSetComponent(null, e);
        closeArray();
      };
      if (element.getExclude().size() > 0) {
        openArray("exclude");
        for (ValueSet.ConceptSetComponent e : element.getExclude()) 
          composeValueSetConceptSetComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeValueSetAuthorComponent(String name, ValueSet.AuthorComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeString("role", element.getRole());
      if (element.getTelecom().size() > 0) {
        openArray("telecom");
        for (Contact e : element.getTelecom()) 
          composeContact(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeValueSetConceptSetComponent(String name, ValueSet.ConceptSetComponent element) throws Exception {
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
        for (ValueSet.ConceptSetFilterComponent e : element.getFilter()) 
          composeValueSetConceptSetFilterComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeValueSetConceptSetFilterComponent(String name, ValueSet.ConceptSetFilterComponent element) throws Exception {
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
      composeCoverageCoveragePlanHolderComponent("planHolder", element.getPlanHolder());
      close();
    }
  }

  private void composeCoverageCoveragePlanHolderComponent(String name, Coverage.CoveragePlanHolderComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeHumanName("name", element.getName());
      composeAddress("address", element.getAddress());
      composeDate("birthdate", element.getBirthdate());
      close();
    }
  }

  private void composeDeviceLog(String name, DeviceLog element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeInstant("instant", element.getInstant());
      composeResourceReference("capabilities", element.getCapabilities());
      composeResourceReference("subject", element.getSubject());
      if (element.getItem().size() > 0) {
        openArray("item");
        for (DeviceLog.DeviceLogItemComponent e : element.getItem()) 
          composeDeviceLogDeviceLogItemComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDeviceLogDeviceLogItemComponent(String name, DeviceLog.DeviceLogItemComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("key", element.getKey());
      composeString("value", element.getValue());
      if (element.getFlag().size() > 0) {
        openArray("flag");
        for (Enumeration<DeviceLog.DeviceValueFlag> e : element.getFlag()) 
          composeEnumeration(null, e, new DeviceLog().new DeviceValueFlagEnumFactory());
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
      composeIdentifier("visit", element.getVisit());
      if (element.getAdministrationDevice().size() > 0) {
        openArray("administrationDevice");
        for (ResourceReference e : element.getAdministrationDevice()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDeviceCapabilities(String name, DeviceCapabilities element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeString("name", element.getName());
      composeCodeableConcept("type", element.getType());
      composeString("manufacturer", element.getManufacturer());
      composeResourceReference("identity", element.getIdentity());
      if (element.getCompartment().size() > 0) {
        openArray("compartment");
        for (DeviceCapabilities.DeviceCapabilitiesCompartmentComponent e : element.getCompartment()) 
          composeDeviceCapabilitiesDeviceCapabilitiesCompartmentComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDeviceCapabilitiesDeviceCapabilitiesCompartmentComponent(String name, DeviceCapabilities.DeviceCapabilitiesCompartmentComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      if (element.getChannel().size() > 0) {
        openArray("channel");
        for (DeviceCapabilities.DeviceCapabilitiesCompartmentChannelComponent e : element.getChannel()) 
          composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelComponent(String name, DeviceCapabilities.DeviceCapabilitiesCompartmentChannelComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      if (element.getMetric().size() > 0) {
        openArray("metric");
        for (DeviceCapabilities.DeviceCapabilitiesCompartmentChannelMetricComponent e : element.getMetric()) 
          composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelMetricComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelMetricComponent(String name, DeviceCapabilities.DeviceCapabilitiesCompartmentChannelMetricComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeString("key", element.getKey());
      composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelMetricInfoComponent("info", element.getInfo());
      if (element.getFacet().size() > 0) {
        openArray("facet");
        for (DeviceCapabilities.DeviceCapabilitiesCompartmentChannelMetricFacetComponent e : element.getFacet()) 
          composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelMetricFacetComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelMetricInfoComponent(String name, DeviceCapabilities.DeviceCapabilitiesCompartmentChannelMetricInfoComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new DeviceCapabilities().new DeviceDataTypeEnumFactory());
      composeString("units", element.getUnits());
      composeCode("ucum", element.getUcum());
      composeUri("system", element.getSystem());
      close();
    }
  }

  private void composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelMetricFacetComponent(String name, DeviceCapabilities.DeviceCapabilitiesCompartmentChannelMetricFacetComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeString("key", element.getKey());
      composeDeviceCapabilitiesDeviceCapabilitiesCompartmentChannelMetricInfoComponent("info", element.getInfo());
      close();
    }
  }

  private void composeSecurityEvent(String name, SecurityEvent element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeSecurityEventSecurityEventEventComponent("event", element.getEvent());
      if (element.getParticipant().size() > 0) {
        openArray("participant");
        for (SecurityEvent.SecurityEventParticipantComponent e : element.getParticipant()) 
          composeSecurityEventSecurityEventParticipantComponent(null, e);
        closeArray();
      };
      composeSecurityEventSecurityEventSourceComponent("source", element.getSource());
      if (element.getObject().size() > 0) {
        openArray("object");
        for (SecurityEvent.SecurityEventObjectComponent e : element.getObject()) 
          composeSecurityEventSecurityEventObjectComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeSecurityEventSecurityEventEventComponent(String name, SecurityEvent.SecurityEventEventComponent element) throws Exception {
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

  private void composeSecurityEventSecurityEventParticipantComponent(String name, SecurityEvent.SecurityEventParticipantComponent element) throws Exception {
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
      composeCodeableConcept("mediaId", element.getMediaId());
      composeSecurityEventSecurityEventParticipantNetworkComponent("network", element.getNetwork());
      close();
    }
  }

  private void composeSecurityEventSecurityEventParticipantNetworkComponent(String name, SecurityEvent.SecurityEventParticipantNetworkComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new SecurityEvent().new NetworkTypeEnumFactory());
      composeString("id", element.getId());
      close();
    }
  }

  private void composeSecurityEventSecurityEventSourceComponent(String name, SecurityEvent.SecurityEventSourceComponent element) throws Exception {
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

  private void composeSecurityEventSecurityEventObjectComponent(String name, SecurityEvent.SecurityEventObjectComponent element) throws Exception {
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
        for (IssueReport.IssueReportIssueComponent e : element.getIssue()) 
          composeIssueReportIssueReportIssueComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeIssueReportIssueReportIssueComponent(String name, IssueReport.IssueReportIssueComponent element) throws Exception {
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
        for (List_.ListEntryComponent e : element.getEntry()) 
          composeList_ListEntryComponent(null, e);
        closeArray();
      };
      composeCodeableConcept("emptyReason", element.getEmptyReason());
      close();
    }
  }

  private void composeList_ListEntryComponent(String name, List_.ListEntryComponent element) throws Exception {
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

  private void composeQuestionnaire(String name, Questionnaire element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new Questionnaire().new ObservationStatusEnumFactory());
      composeInstant("authored", element.getAuthored());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("author", element.getAuthor());
      composeResourceReference("source", element.getSource());
      composeCodeableConcept("name", element.getName());
      composeIdentifier("identifier", element.getIdentifier());
      composeResourceReference("visit", element.getVisit());
      if (element.getAnswer().size() > 0) {
        openArray("answer");
        for (Questionnaire.AnswerComponent e : element.getAnswer()) 
          composeQuestionnaireAnswerComponent(null, e);
        closeArray();
      };
      if (element.getSection().size() > 0) {
        openArray("section");
        for (Questionnaire.SectionComponent e : element.getSection()) 
          composeQuestionnaireSectionComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeQuestionnaireAnswerComponent(String name, Questionnaire.AnswerComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      composeResourceReference("evidence", element.getEvidence());
      composeString("remarks", element.getRemarks());
      close();
    }
  }

  private void composeQuestionnaireSectionComponent(String name, Questionnaire.SectionComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("name", element.getName());
      if (element.getAnswer().size() > 0) {
        openArray("answer");
        for (Questionnaire.AnswerComponent e : element.getAnswer()) 
          composeQuestionnaireAnswerComponent(null, e);
        closeArray();
      };
      if (element.getSection().size() > 0) {
        openArray("section");
        for (Questionnaire.SectionComponent e : element.getSection()) 
          composeQuestionnaireSectionComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composePicture(String name, Picture element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeDateTime("dateTime", element.getDateTime());
      composeResourceReference("operator", element.getOperator());
      composeIdentifier("identifier", element.getIdentifier());
      composeIdentifier("accessionNo", element.getAccessionNo());
      composeIdentifier("studyId", element.getStudyId());
      composeIdentifier("seriesId", element.getSeriesId());
      composeCodeableConcept("method", element.getMethod());
      composeResourceReference("requester", element.getRequester());
      if (element.getModality() != null)
        composeEnumeration("modality", element.getModality(), new Picture().new ImageModality3EnumFactory());
      composeString("deviceName", element.getDeviceName());
      composeInteger("height", element.getHeight());
      composeInteger("width", element.getWidth());
      composeInteger("bits", element.getBits());
      composeInteger("frames", element.getFrames());
      composeDuration("frameDelay", element.getFrameDelay());
      composeCodeableConcept("view", element.getView());
      composeAttachment("content", element.getContent());
      close();
    }
  }

  private void composeConformance(String name, Conformance element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeDateTime("date", element.getDate());
      composeConformanceConformancePublisherComponent("publisher", element.getPublisher());
      composeConformanceConformanceSoftwareComponent("software", element.getSoftware());
      composeConformanceConformanceImplementationComponent("implementation", element.getImplementation());
      composeConformanceConformanceProposalComponent("proposal", element.getProposal());
      composeId("version", element.getVersion());
      composeBoolean("acceptUnknown", element.getAcceptUnknown());
      if (element.getFormat().size() > 0) {
        openArray("format");
        for (Code e : element.getFormat()) 
          composeCode(null, e);
        closeArray();
      };
      if (element.getRest().size() > 0) {
        openArray("rest");
        for (Conformance.ConformanceRestComponent e : element.getRest()) 
          composeConformanceConformanceRestComponent(null, e);
        closeArray();
      };
      if (element.getMessaging().size() > 0) {
        openArray("messaging");
        for (Conformance.ConformanceMessagingComponent e : element.getMessaging()) 
          composeConformanceConformanceMessagingComponent(null, e);
        closeArray();
      };
      if (element.getDocument().size() > 0) {
        openArray("document");
        for (Conformance.ConformanceDocumentComponent e : element.getDocument()) 
          composeConformanceConformanceDocumentComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceConformancePublisherComponent(String name, Conformance.ConformancePublisherComponent element) throws Exception {
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

  private void composeConformanceConformanceSoftwareComponent(String name, Conformance.ConformanceSoftwareComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      composeDateTime("releaseDate", element.getReleaseDate());
      close();
    }
  }

  private void composeConformanceConformanceImplementationComponent(String name, Conformance.ConformanceImplementationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("description", element.getDescription());
      composeUri("url", element.getUrl());
      composeConformanceConformanceSoftwareComponent("software", element.getSoftware());
      close();
    }
  }

  private void composeConformanceConformanceProposalComponent(String name, Conformance.ConformanceProposalComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("description", element.getDescription());
      close();
    }
  }

  private void composeConformanceConformanceRestComponent(String name, Conformance.ConformanceRestComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Conformance().new RestfulConformanceModeEnumFactory());
      composeString("documentation", element.getDocumentation());
      composeConformanceConformanceRestSecurityComponent("security", element.getSecurity());
      if (element.getResource().size() > 0) {
        openArray("resource");
        for (Conformance.ConformanceRestResourceComponent e : element.getResource()) 
          composeConformanceConformanceRestResourceComponent(null, e);
        closeArray();
      };
      composeBoolean("batch", element.getBatch());
      composeBoolean("history", element.getHistory());
      close();
    }
  }

  private void composeConformanceConformanceRestSecurityComponent(String name, Conformance.ConformanceRestSecurityComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getService().size() > 0) {
        openArray("service");
        for (CodeableConcept e : element.getService()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeString("description", element.getDescription());
      if (element.getCertificate().size() > 0) {
        openArray("certificate");
        for (Conformance.ConformanceRestSecurityCertificateComponent e : element.getCertificate()) 
          composeConformanceConformanceRestSecurityCertificateComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceConformanceRestSecurityCertificateComponent(String name, Conformance.ConformanceRestSecurityCertificateComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("type", element.getType());
      composeBase64Binary("blob", element.getBlob());
      close();
    }
  }

  private void composeConformanceConformanceRestResourceComponent(String name, Conformance.ConformanceRestResourceComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("type", element.getType());
      composeUri("profile", element.getProfile());
      if (element.getOperation().size() > 0) {
        openArray("operation");
        for (Conformance.ConformanceRestResourceOperationComponent e : element.getOperation()) 
          composeConformanceConformanceRestResourceOperationComponent(null, e);
        closeArray();
      };
      composeBoolean("readHistory", element.getReadHistory());
      if (element.getSearchInclude().size() > 0) {
        openArray("searchInclude");
        for (String_ e : element.getSearchInclude()) 
          composeString(null, e);
        closeArray();
      };
      if (element.getSearchParam().size() > 0) {
        openArray("searchParam");
        for (Conformance.ConformanceRestResourceSearchParamComponent e : element.getSearchParam()) 
          composeConformanceConformanceRestResourceSearchParamComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceConformanceRestResourceOperationComponent(String name, Conformance.ConformanceRestResourceOperationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getCode() != null)
        composeEnumeration("code", element.getCode(), new Conformance().new RestfulOperationEnumFactory());
      composeString("documentation", element.getDocumentation());
      close();
    }
  }

  private void composeConformanceConformanceRestResourceSearchParamComponent(String name, Conformance.ConformanceRestResourceSearchParamComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeUri("source", element.getSource());
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Conformance().new SearchParamTypeEnumFactory());
      if (element.getRepeats() != null)
        composeEnumeration("repeats", element.getRepeats(), new Conformance().new SearchRepeatBehaviorEnumFactory());
      composeString("documentation", element.getDocumentation());
      if (element.getTarget().size() > 0) {
        openArray("target");
        for (Code e : element.getTarget()) 
          composeCode(null, e);
        closeArray();
      };
      if (element.getChain().size() > 0) {
        openArray("chain");
        for (String_ e : element.getChain()) 
          composeString(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceConformanceMessagingComponent(String name, Conformance.ConformanceMessagingComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeUri("endpoint", element.getEndpoint());
      composeString("documentation", element.getDocumentation());
      if (element.getEvent().size() > 0) {
        openArray("event");
        for (Conformance.ConformanceMessagingEventComponent e : element.getEvent()) 
          composeConformanceConformanceMessagingEventComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeConformanceConformanceMessagingEventComponent(String name, Conformance.ConformanceMessagingEventComponent element) throws Exception {
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

  private void composeConformanceConformanceDocumentComponent(String name, Conformance.ConformanceDocumentComponent element) throws Exception {
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

  private void composeDocument(String name, Document element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
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
        for (Document.DocumentAttesterComponent e : element.getAttester()) 
          composeDocumentDocumentAttesterComponent(null, e);
        closeArray();
      };
      composeResourceReference("custodian", element.getCustodian());
      composeDocumentDocumentEventComponent("event", element.getEvent());
      composeResourceReference("visit", element.getVisit());
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
        for (Document.SectionComponent e : element.getSection()) 
          composeDocumentSectionComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDocumentDocumentAttesterComponent(String name, Document.DocumentAttesterComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getMode() != null)
        composeEnumeration("mode", element.getMode(), new Document().new DocumentAttestationModeEnumFactory());
      composeDateTime("time", element.getTime());
      composeResourceReference("party", element.getParty());
      close();
    }
  }

  private void composeDocumentDocumentEventComponent(String name, Document.DocumentEventComponent element) throws Exception {
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

  private void composeDocumentSectionComponent(String name, Document.SectionComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("content", element.getContent());
      if (element.getSection().size() > 0) {
        openArray("section");
        for (Document.SectionComponent e : element.getSection()) 
          composeDocumentSectionComponent(null, e);
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
      composeMessageMessageResponseComponent("response", element.getResponse());
      composeMessageMessageSourceComponent("source", element.getSource());
      composeMessageMessageDestinationComponent("destination", element.getDestination());
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

  private void composeMessageMessageResponseComponent(String name, Message.MessageResponseComponent element) throws Exception {
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

  private void composeMessageMessageSourceComponent(String name, Message.MessageSourceComponent element) throws Exception {
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

  private void composeMessageMessageDestinationComponent(String name, Message.MessageDestinationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeResourceReference("target", element.getTarget());
      composeUri("endpoint", element.getEndpoint());
      close();
    }
  }

  private void composeFamilyHistory(String name, FamilyHistory element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("relatedPerson", element.getRelatedPerson());
      if (element.getRelationship() != null)
        composeEnumeration("relationship", element.getRelationship(), new FamilyHistory().new FamilialRelationshipEnumFactory());
      composeCodeableConcept("condition", element.getCondition());
      composeBoolean("isDeath", element.getIsDeath());
      composeType("onset", element.getOnset());
      composeString("note", element.getNote());
      close();
    }
  }

  private void composeProfile(String name, Profile element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeString("name", element.getName());
      composeString("version", element.getVersion());
      if (element.getAuthor().size() > 0) {
        openArray("author");
        for (Profile.AuthorComponent e : element.getAuthor()) 
          composeProfileAuthorComponent(null, e);
        closeArray();
      };
      composeString("description", element.getDescription());
      if (element.getCode().size() > 0) {
        openArray("code");
        for (Coding e : element.getCode()) 
          composeCoding(null, e);
        closeArray();
      };
      composeProfileProfileStatusComponent("status", element.getStatus());
      if (element.getImport().size() > 0) {
        openArray("import");
        for (Profile.ProfileImportComponent e : element.getImport()) 
          composeProfileProfileImportComponent(null, e);
        closeArray();
      };
      composeCode("bundle", element.getBundle());
      if (element.getStructure().size() > 0) {
        openArray("structure");
        for (Profile.ProfileStructureComponent e : element.getStructure()) 
          composeProfileProfileStructureComponent(null, e);
        closeArray();
      };
      if (element.getExtensionDefn().size() > 0) {
        openArray("extensionDefn");
        for (Profile.ProfileExtensionDefnComponent e : element.getExtensionDefn()) 
          composeProfileProfileExtensionDefnComponent(null, e);
        closeArray();
      };
      if (element.getBinding().size() > 0) {
        openArray("binding");
        for (Profile.ProfileBindingComponent e : element.getBinding()) 
          composeProfileProfileBindingComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileAuthorComponent(String name, Profile.AuthorComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeString("role", element.getRole());
      if (element.getTelecom().size() > 0) {
        openArray("telecom");
        for (Contact e : element.getTelecom()) 
          composeContact(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileProfileStatusComponent(String name, Profile.ProfileStatusComponent element) throws Exception {
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

  private void composeProfileProfileImportComponent(String name, Profile.ProfileImportComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeUri("uri", element.getUri());
      composeString("prefix", element.getPrefix());
      close();
    }
  }

  private void composeProfileProfileStructureComponent(String name, Profile.ProfileStructureComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("type", element.getType());
      composeString("name", element.getName());
      composeString("purpose", element.getPurpose());
      composeUri("profile", element.getProfile());
      if (element.getElement().size() > 0) {
        openArray("element");
        for (Profile.ElementComponent e : element.getElement()) 
          composeProfileElementComponent(null, e);
        closeArray();
      };
      if (element.getSearchParam().size() > 0) {
        openArray("searchParam");
        for (Profile.ProfileStructureSearchParamComponent e : element.getSearchParam()) 
          composeProfileProfileStructureSearchParamComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileElementComponent(String name, Profile.ElementComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("path", element.getPath());
      composeString("name", element.getName());
      composeProfileElementDefinitionComponent("definition", element.getDefinition());
      composeBoolean("bundled", element.getBundled());
      close();
    }
  }

  private void composeProfileElementDefinitionComponent(String name, Profile.ElementDefinitionComponent element) throws Exception {
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
        for (Profile.TypeRefComponent e : element.getType()) 
          composeProfileTypeRefComponent(null, e);
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
        for (Profile.ElementDefinitionConstraintComponent e : element.getConstraint()) 
          composeProfileElementDefinitionConstraintComponent(null, e);
        closeArray();
      };
      composeBoolean("mustSupport", element.getMustSupport());
      composeBoolean("mustUnderstand", element.getMustUnderstand());
      composeString("binding", element.getBinding());
      if (element.getMapping().size() > 0) {
        openArray("mapping");
        for (Profile.ElementDefinitionMappingComponent e : element.getMapping()) 
          composeProfileElementDefinitionMappingComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileTypeRefComponent(String name, Profile.TypeRefComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("code", element.getCode());
      composeUri("profile", element.getProfile());
      close();
    }
  }

  private void composeProfileElementDefinitionConstraintComponent(String name, Profile.ElementDefinitionConstraintComponent element) throws Exception {
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

  private void composeProfileElementDefinitionMappingComponent(String name, Profile.ElementDefinitionMappingComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("target", element.getTarget());
      composeString("map", element.getMap());
      close();
    }
  }

  private void composeProfileProfileStructureSearchParamComponent(String name, Profile.ProfileStructureSearchParamComponent element) throws Exception {
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

  private void composeProfileProfileExtensionDefnComponent(String name, Profile.ProfileExtensionDefnComponent element) throws Exception {
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
      composeProfileElementDefinitionComponent("definition", element.getDefinition());
      close();
    }
  }

  private void composeProfileProfileBindingComponent(String name, Profile.ProfileBindingComponent element) throws Exception {
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
        for (Profile.CodeDefinitionComponent e : element.getConcept()) 
          composeProfileCodeDefinitionComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProfileCodeDefinitionComponent(String name, Profile.CodeDefinitionComponent element) throws Exception {
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

  private void composeLocation(String name, Location element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeString("name", element.getName());
      composeString("description", element.getDescription());
      if (element.getType().size() > 0) {
        openArray("type");
        for (CodeableConcept e : element.getType()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeContact("telecom", element.getTelecom());
      composeAddress("address", element.getAddress());
      composeLocationLocationPositionComponent("position", element.getPosition());
      composeResourceReference("provider", element.getProvider());
      composeBoolean("active", element.getActive());
      composeResourceReference("partOf", element.getPartOf());
      close();
    }
  }

  private void composeLocationLocationPositionComponent(String name, Location.LocationPositionComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDecimal("longitude", element.getLongitude());
      composeDecimal("latitude", element.getLatitude());
      composeDecimal("altitude", element.getAltitude());
      close();
    }
  }

  private void composeAllergyIntolerance(String name, AllergyIntolerance element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getCriticality() != null)
        composeEnumeration("criticality", element.getCriticality(), new AllergyIntolerance().new CriticalityEnumFactory());
      if (element.getSensitivityType() != null)
        composeEnumeration("sensitivityType", element.getSensitivityType(), new AllergyIntolerance().new SensitivitytypeEnumFactory());
      composeDateTime("recordedDate", element.getRecordedDate());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new AllergyIntolerance().new SensitivitystatusEnumFactory());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("recorder", element.getRecorder());
      composeResourceReference("substance", element.getSubstance());
      if (element.getReactions().size() > 0) {
        openArray("reactions");
        for (ResourceReference e : element.getReactions()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getSensitivityTest().size() > 0) {
        openArray("sensitivityTest");
        for (ResourceReference e : element.getSensitivityTest()) 
          composeResourceReference(null, e);
        closeArray();
      };
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
      composeType("applies", element.getApplies());
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
        for (Observation.ObservationReferenceRangeComponent e : element.getReferenceRange()) 
          composeObservationObservationReferenceRangeComponent(null, e);
        closeArray();
      };
      if (element.getComponent().size() > 0) {
        openArray("component");
        for (Observation.ObservationComponentComponent e : element.getComponent()) 
          composeObservationObservationComponentComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeObservationObservationReferenceRangeComponent(String name, Observation.ObservationReferenceRangeComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("meaning", element.getMeaning());
      composeType("range", element.getRange());
      close();
    }
  }

  private void composeObservationObservationComponentComponent(String name, Observation.ObservationComponentComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("name", element.getName());
      composeType("value", element.getValue());
      close();
    }
  }

  private void composeVisit(String name, Visit element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeCodeableConcept("state", element.getState());
      composeCodeableConcept("setting", element.getSetting());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("responsible", element.getResponsible());
      composeResourceReference("fulfills", element.getFulfills());
      composePeriod("period", element.getPeriod());
      composeDuration("length", element.getLength());
      composeResourceReference("contact", element.getContact());
      composeVisitVisitAdmissionComponent("admission", element.getAdmission());
      composeResourceReference("indication", element.getIndication());
      if (element.getLocation().size() > 0) {
        openArray("location");
        for (Visit.VisitLocationComponent e : element.getLocation()) 
          composeVisitVisitLocationComponent(null, e);
        closeArray();
      };
      composeVisitVisitDischargeComponent("discharge", element.getDischarge());
      close();
    }
  }

  private void composeVisitVisitAdmissionComponent(String name, Visit.VisitAdmissionComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeResourceReference("admitter", element.getAdmitter());
      composeResourceReference("origin", element.getOrigin());
      close();
    }
  }

  private void composeVisitVisitLocationComponent(String name, Visit.VisitLocationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeResourceReference("location", element.getLocation());
      composeType("bed", element.getBed());
      composeDateTime("period", element.getPeriod());
      composeResourceReference("responsible", element.getResponsible());
      close();
    }
  }

  private void composeVisitVisitDischargeComponent(String name, Visit.VisitDischargeComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeResourceReference("discharger", element.getDischarger());
      composeResourceReference("contact", element.getContact());
      composeResourceReference("destination", element.getDestination());
      close();
    }
  }

  private void composeDocumentReference(String name, DocumentReference element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeIdentifier("id", element.getId());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeResourceReference("subject", element.getSubject());
      composeCodeableConcept("type", element.getType());
      if (element.getCategory().size() > 0) {
        openArray("category");
        for (ResourceReference e : element.getCategory()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getAuthor().size() > 0) {
        openArray("author");
        for (ResourceReference e : element.getAuthor()) 
          composeResourceReference(null, e);
        closeArray();
      };
      composeResourceReference("custodian", element.getCustodian());
      composeResourceReference("authenticator", element.getAuthenticator());
      composeDateTime("created", element.getCreated());
      composeInstant("indexed", element.getIndexed());
      if (element.getStatus() != null)
        composeEnumeration("status", element.getStatus(), new DocumentReference().new DocumentReferenceStatusEnumFactory());
      composeCodeableConcept("docStatus", element.getDocStatus());
      composeResourceReference("supercedes", element.getSupercedes());
      composeString("description", element.getDescription());
      composeCodeableConcept("confidentiality", element.getConfidentiality());
      composeCode("primaryLanguage", element.getPrimaryLanguage());
      composeCode("format", element.getFormat());
      composeInteger("size", element.getSize());
      composeString("hash", element.getHash());
      composeUri("location", element.getLocation());
      composeDocumentReferenceDocumentReferenceServiceComponent("service", element.getService());
      composeDocumentReferenceDocumentReferenceContextComponent("context", element.getContext());
      close();
    }
  }

  private void composeDocumentReferenceDocumentReferenceServiceComponent(String name, DocumentReference.DocumentReferenceServiceComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("type", element.getType());
      if (element.getParameter().size() > 0) {
        openArray("parameter");
        for (DocumentReference.DocumentReferenceServiceParameterComponent e : element.getParameter()) 
          composeDocumentReferenceDocumentReferenceServiceParameterComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeDocumentReferenceDocumentReferenceServiceParameterComponent(String name, DocumentReference.DocumentReferenceServiceParameterComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeString("name", element.getName());
      composeString("value", element.getValue());
      close();
    }
  }

  private void composeDocumentReferenceDocumentReferenceContextComponent(String name, DocumentReference.DocumentReferenceContextComponent element) throws Exception {
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
      composeCodeableConcept("facilityType", element.getFacilityType());
      close();
    }
  }

  private void composeImmunization(String name, Immunization element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("requester", element.getRequester());
      composeResourceReference("performer", element.getPerformer());
      composeResourceReference("manufacturer", element.getManufacturer());
      composeResourceReference("location", element.getLocation());
      composeDateTime("date", element.getDate());
      composeBoolean("reported", element.getReported());
      composeCode("vaccineType", element.getVaccineType());
      composeString("lotNumber", element.getLotNumber());
      composeDate("expirationDate", element.getExpirationDate());
      composeCode("site", element.getSite());
      composeCode("route", element.getRoute());
      composeQuantity("doseQuantity", element.getDoseQuantity());
      composeImmunizationImmunizationRefusalComponent("refusal", element.getRefusal());
      if (element.getReaction().size() > 0) {
        openArray("reaction");
        for (Immunization.ImmunizationReactionComponent e : element.getReaction()) 
          composeImmunizationImmunizationReactionComponent(null, e);
        closeArray();
      };
      composeImmunizationImmunizationVaccinationProtocolComponent("vaccinationProtocol", element.getVaccinationProtocol());
      close();
    }
  }

  private void composeImmunizationImmunizationRefusalComponent(String name, Immunization.ImmunizationRefusalComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("reason", element.getReason());
      close();
    }
  }

  private void composeImmunizationImmunizationReactionComponent(String name, Immunization.ImmunizationReactionComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDateTime("date", element.getDate());
      composeResourceReference("detail", element.getDetail());
      composeBoolean("reported", element.getReported());
      close();
    }
  }

  private void composeImmunizationImmunizationVaccinationProtocolComponent(String name, Immunization.ImmunizationVaccinationProtocolComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeInteger("doseSequence", element.getDoseSequence());
      composeString("description", element.getDescription());
      composeResourceReference("authority", element.getAuthority());
      composeString("series", element.getSeries());
      composeInteger("seriesDoses", element.getSeriesDoses());
      composeCode("doseTarget", element.getDoseTarget());
      composeCode("doseStatus", element.getDoseStatus());
      composeCode("doseStatusReason", element.getDoseStatusReason());
      close();
    }
  }

  private void composeImmunizationProfile(String name, ImmunizationProfile element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      if (element.getRecommendation().size() > 0) {
        openArray("recommendation");
        for (ImmunizationProfile.ImmunizationProfileRecommendationComponent e : element.getRecommendation()) 
          composeImmunizationProfileImmunizationProfileRecommendationComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeImmunizationProfileImmunizationProfileRecommendationComponent(String name, ImmunizationProfile.ImmunizationProfileRecommendationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDateTime("recommendationDate", element.getRecommendationDate());
      composeCode("vaccineType", element.getVaccineType());
      composeInteger("doseNumber", element.getDoseNumber());
      composeCode("forecastStatus", element.getForecastStatus());
      if (element.getDateCriterion().size() > 0) {
        openArray("dateCriterion");
        for (ImmunizationProfile.ImmunizationProfileRecommendationDateCriterionComponent e : element.getDateCriterion()) 
          composeImmunizationProfileImmunizationProfileRecommendationDateCriterionComponent(null, e);
        closeArray();
      };
      composeImmunizationProfileImmunizationProfileRecommendationProtocolComponent("protocol", element.getProtocol());
      if (element.getSupportingImmunization().size() > 0) {
        openArray("supportingImmunization");
        for (ResourceReference e : element.getSupportingImmunization()) 
          composeResourceReference(null, e);
        closeArray();
      };
      if (element.getSupportingAdverseEventReport().size() > 0) {
        openArray("supportingAdverseEventReport");
        for (ImmunizationProfile.ImmunizationProfileRecommendationSupportingAdverseEventReportComponent e : element.getSupportingAdverseEventReport()) 
          composeImmunizationProfileImmunizationProfileRecommendationSupportingAdverseEventReportComponent(null, e);
        closeArray();
      };
      if (element.getSupportingPatientObservation().size() > 0) {
        openArray("supportingPatientObservation");
        for (ResourceReference e : element.getSupportingPatientObservation()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeImmunizationProfileImmunizationProfileRecommendationDateCriterionComponent(String name, ImmunizationProfile.ImmunizationProfileRecommendationDateCriterionComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCode("code", element.getCode());
      composeDateTime("value", element.getValue());
      close();
    }
  }

  private void composeImmunizationProfileImmunizationProfileRecommendationProtocolComponent(String name, ImmunizationProfile.ImmunizationProfileRecommendationProtocolComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeInteger("doseSequence", element.getDoseSequence());
      composeString("description", element.getDescription());
      composeResourceReference("authority", element.getAuthority());
      composeString("series", element.getSeries());
      close();
    }
  }

  private void composeImmunizationProfileImmunizationProfileRecommendationSupportingAdverseEventReportComponent(String name, ImmunizationProfile.ImmunizationProfileRecommendationSupportingAdverseEventReportComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getId().size() > 0) {
        openArray("id");
        for (Id e : element.getId()) 
          composeId(null, e);
        closeArray();
      };
      composeCode("reportType", element.getReportType());
      composeDateTime("reportDate", element.getReportDate());
      composeString("text", element.getText());
      if (element.getReaction().size() > 0) {
        openArray("reaction");
        for (ResourceReference e : element.getReaction()) 
          composeResourceReference(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProblem(String name, Problem element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("visit", element.getVisit());
      composeResourceReference("asserter", element.getAsserter());
      composeDate("dateAsserted", element.getDateAsserted());
      composeCodeableConcept("code", element.getCode());
      composeCodeableConcept("category", element.getCategory());
      composeCode("status", element.getStatus());
      composeCodeableConcept("certainty", element.getCertainty());
      composeCodeableConcept("severity", element.getSeverity());
      composeType("onset", element.getOnset());
      composeType("abatement", element.getAbatement());
      composeProblemProblemStageComponent("stage", element.getStage());
      if (element.getEvidence().size() > 0) {
        openArray("evidence");
        for (Problem.ProblemEvidenceComponent e : element.getEvidence()) 
          composeProblemProblemEvidenceComponent(null, e);
        closeArray();
      };
      if (element.getLocation().size() > 0) {
        openArray("location");
        for (Problem.ProblemLocationComponent e : element.getLocation()) 
          composeProblemProblemLocationComponent(null, e);
        closeArray();
      };
      if (element.getRelatedItem().size() > 0) {
        openArray("relatedItem");
        for (Problem.ProblemRelatedItemComponent e : element.getRelatedItem()) 
          composeProblemProblemRelatedItemComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeProblemProblemStageComponent(String name, Problem.ProblemStageComponent element) throws Exception {
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

  private void composeProblemProblemEvidenceComponent(String name, Problem.ProblemEvidenceComponent element) throws Exception {
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

  private void composeProblemProblemLocationComponent(String name, Problem.ProblemLocationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composeResourceReference("details", element.getDetails());
      close();
    }
  }

  private void composeProblemProblemRelatedItemComponent(String name, Problem.ProblemRelatedItemComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getType() != null)
        composeEnumeration("type", element.getType(), new Problem().new ProblemRelationshipTypeEnumFactory());
      composeResourceReference("target", element.getTarget());
      close();
    }
  }

  private void composeCategory(String name, Category element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      if (element.getCode().size() > 0) {
        openArray("code");
        for (CodeableConcept e : element.getCode()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeString("title", element.getTitle());
      composeResourceReference("subject", element.getSubject());
      close();
    }
  }

  private void composeSpecimen(String name, Specimen element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeIdentifier("identifier", element.getIdentifier());
      close();
    }
  }

  private void composeDeviceObservation(String name, DeviceObservation element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeCodeableConcept("code", element.getCode());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeInstant("issued", element.getIssued());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("device", element.getDevice());
      if (element.getMeasurement().size() > 0) {
        openArray("measurement");
        for (ResourceReference e : element.getMeasurement()) 
          composeResourceReference(null, e);
        closeArray();
      };
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
      if (element.getContact().size() > 0) {
        openArray("contact");
        for (Patient.ContactComponent e : element.getContact()) 
          composePatientContactComponent(null, e);
        closeArray();
      };
      composePatientAnimalComponent("animal", element.getAnimal());
      composeResourceReference("provider", element.getProvider());
      composeType("multipleBirth", element.getMultipleBirth());
      composeDateTime("deceasedDate", element.getDeceasedDate());
      composeCodeableConcept("diet", element.getDiet());
      close();
    }
  }

  private void composePatientContactComponent(String name, Patient.ContactComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      if (element.getRelationship().size() > 0) {
        openArray("relationship");
        for (CodeableConcept e : element.getRelationship()) 
          composeCodeableConcept(null, e);
        closeArray();
      };
      composeDemographics("details", element.getDetails());
      composeResourceReference("organization", element.getOrganization());
      close();
    }
  }

  private void composePatientAnimalComponent(String name, Patient.AnimalComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("species", element.getSpecies());
      composeCodeableConcept("breed", element.getBreed());
      composeCodeableConcept("genderStatus", element.getGenderStatus());
      close();
    }
  }

  private void composePractitioner(String name, Practitioner element) throws Exception {
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
      if (element.getQualification().size() > 0) {
        openArray("qualification");
        for (Practitioner.PractitionerQualificationComponent e : element.getQualification()) 
          composePractitionerPractitionerQualificationComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composePractitionerPractitionerQualificationComponent(String name, Practitioner.PractitionerQualificationComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      composePeriod("period", element.getPeriod());
      composeResourceReference("issuer", element.getIssuer());
      close();
    }
  }

  private void composeImagingStudy(String name, ImagingStudy element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeDateTime("dateTime", element.getDateTime());
      composeResourceReference("subject", element.getSubject());
      composeOid("uid", element.getUid());
      if (element.getIdentifier().size() > 0) {
        openArray("identifier");
        for (Identifier e : element.getIdentifier()) 
          composeIdentifier(null, e);
        closeArray();
      };
      composeResourceReference("requester", element.getRequester());
      composeIdentifier("accessionNo", element.getAccessionNo());
      composeString("clinicalInformation", element.getClinicalInformation());
      if (element.getProcedure().size() > 0) {
        openArray("procedure");
        for (Coding e : element.getProcedure()) 
          composeCoding(null, e);
        closeArray();
      };
      composeResourceReference("interpreter", element.getInterpreter());
      composeString("description", element.getDescription());
      if (element.getSeries().size() > 0) {
        openArray("series");
        for (ImagingStudy.ImagingStudySeriesComponent e : element.getSeries()) 
          composeImagingStudyImagingStudySeriesComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeImagingStudyImagingStudySeriesComponent(String name, ImagingStudy.ImagingStudySeriesComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeInteger("number", element.getNumber());
      if (element.getModality() != null)
        composeEnumeration("modality", element.getModality(), new ImagingStudy().new ImageModalityEnumFactory());
      composeDateTime("datetime", element.getDatetime());
      composeOid("uid", element.getUid());
      composeString("description", element.getDescription());
      composeCoding("bodySite", element.getBodySite());
      if (element.getImage().size() > 0) {
        openArray("image");
        for (ImagingStudy.ImagingStudySeriesImageComponent e : element.getImage()) 
          composeImagingStudyImagingStudySeriesImageComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeImagingStudyImagingStudySeriesImageComponent(String name, ImagingStudy.ImagingStudySeriesImageComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeInteger("number", element.getNumber());
      composeDateTime("dateTime", element.getDateTime());
      composeOid("uid", element.getUid());
      composeOid("dicomClass", element.getDicomClass());
      composeUri("url", element.getUrl());
      close();
    }
  }

  private void composeAdverseReaction(String name, AdverseReaction element) throws Exception {
    if (element != null) {
      open(name);
      composeResourceElements(element);
      composeDateTime("reactionDate", element.getReactionDate());
      composeResourceReference("subject", element.getSubject());
      composeResourceReference("substance", element.getSubstance());
      composeBoolean("didNotOccurFlag", element.getDidNotOccurFlag());
      composeResourceReference("recorder", element.getRecorder());
      if (element.getSymptom().size() > 0) {
        openArray("symptom");
        for (AdverseReaction.AdverseReactionSymptomComponent e : element.getSymptom()) 
          composeAdverseReactionAdverseReactionSymptomComponent(null, e);
        closeArray();
      };
      if (element.getExposure().size() > 0) {
        openArray("exposure");
        for (AdverseReaction.AdverseReactionExposureComponent e : element.getExposure()) 
          composeAdverseReactionAdverseReactionExposureComponent(null, e);
        closeArray();
      };
      close();
    }
  }

  private void composeAdverseReactionAdverseReactionSymptomComponent(String name, AdverseReaction.AdverseReactionSymptomComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeCodeableConcept("code", element.getCode());
      if (element.getSeverity() != null)
        composeEnumeration("severity", element.getSeverity(), new AdverseReaction().new ReactionSeverityEnumFactory());
      close();
    }
  }

  private void composeAdverseReactionAdverseReactionExposureComponent(String name, AdverseReaction.AdverseReactionExposureComponent element) throws Exception {
    if (element != null) {
      open(name);
      composeElement(element);
      composeDateTime("exposureDate", element.getExposureDate());
      if (element.getExposureType() != null)
        composeEnumeration("exposureType", element.getExposureType(), new AdverseReaction().new ExposureTypeEnumFactory());
      composeResourceReference("substance", element.getSubstance());
      close();
    }
  }

  @Override
  protected void composeResource(Resource resource) throws Exception {
    if (resource instanceof Provenance)
      composeProvenance("Provenance", (Provenance)resource);
    else if (resource instanceof CarePlan)
      composeCarePlan("CarePlan", (CarePlan)resource);
    else if (resource instanceof Device)
      composeDevice("Device", (Device)resource);
    else if (resource instanceof Order)
      composeOrder("Order", (Order)resource);
    else if (resource instanceof Prescription)
      composePrescription("Prescription", (Prescription)resource);
    else if (resource instanceof Organization)
      composeOrganization("Organization", (Organization)resource);
    else if (resource instanceof Procedure)
      composeProcedure("Procedure", (Procedure)resource);
    else if (resource instanceof Substance)
      composeSubstance("Substance", (Substance)resource);
    else if (resource instanceof Group)
      composeGroup("Group", (Group)resource);
    else if (resource instanceof DiagnosticReport)
      composeDiagnosticReport("DiagnosticReport", (DiagnosticReport)resource);
    else if (resource instanceof ValueSet)
      composeValueSet("ValueSet", (ValueSet)resource);
    else if (resource instanceof Test)
      composeTest("Test", (Test)resource);
    else if (resource instanceof Coverage)
      composeCoverage("Coverage", (Coverage)resource);
    else if (resource instanceof DeviceLog)
      composeDeviceLog("DeviceLog", (DeviceLog)resource);
    else if (resource instanceof MedicationAdministration)
      composeMedicationAdministration("MedicationAdministration", (MedicationAdministration)resource);
    else if (resource instanceof DeviceCapabilities)
      composeDeviceCapabilities("DeviceCapabilities", (DeviceCapabilities)resource);
    else if (resource instanceof SecurityEvent)
      composeSecurityEvent("SecurityEvent", (SecurityEvent)resource);
    else if (resource instanceof IssueReport)
      composeIssueReport("IssueReport", (IssueReport)resource);
    else if (resource instanceof List_)
      composeList_("List", (List_)resource);
    else if (resource instanceof Questionnaire)
      composeQuestionnaire("Questionnaire", (Questionnaire)resource);
    else if (resource instanceof Picture)
      composePicture("Picture", (Picture)resource);
    else if (resource instanceof Conformance)
      composeConformance("Conformance", (Conformance)resource);
    else if (resource instanceof Document)
      composeDocument("Document", (Document)resource);
    else if (resource instanceof Message)
      composeMessage("Message", (Message)resource);
    else if (resource instanceof FamilyHistory)
      composeFamilyHistory("FamilyHistory", (FamilyHistory)resource);
    else if (resource instanceof Profile)
      composeProfile("Profile", (Profile)resource);
    else if (resource instanceof Location)
      composeLocation("Location", (Location)resource);
    else if (resource instanceof AllergyIntolerance)
      composeAllergyIntolerance("AllergyIntolerance", (AllergyIntolerance)resource);
    else if (resource instanceof Observation)
      composeObservation("Observation", (Observation)resource);
    else if (resource instanceof Visit)
      composeVisit("Visit", (Visit)resource);
    else if (resource instanceof DocumentReference)
      composeDocumentReference("DocumentReference", (DocumentReference)resource);
    else if (resource instanceof Immunization)
      composeImmunization("Immunization", (Immunization)resource);
    else if (resource instanceof ImmunizationProfile)
      composeImmunizationProfile("ImmunizationProfile", (ImmunizationProfile)resource);
    else if (resource instanceof Problem)
      composeProblem("Problem", (Problem)resource);
    else if (resource instanceof Category)
      composeCategory("Category", (Category)resource);
    else if (resource instanceof Specimen)
      composeSpecimen("Specimen", (Specimen)resource);
    else if (resource instanceof DeviceObservation)
      composeDeviceObservation("DeviceObservation", (DeviceObservation)resource);
    else if (resource instanceof OrderResponse)
      composeOrderResponse("OrderResponse", (OrderResponse)resource);
    else if (resource instanceof Patient)
      composePatient("Patient", (Patient)resource);
    else if (resource instanceof Practitioner)
      composePractitioner("Practitioner", (Practitioner)resource);
    else if (resource instanceof ImagingStudy)
      composeImagingStudy("ImagingStudy", (ImagingStudy)resource);
    else if (resource instanceof AdverseReaction)
      composeAdverseReaction("AdverseReaction", (AdverseReaction)resource);
    else if (resource instanceof Binary)
      composeBinary("Binary", (Binary)resource);
    else
      throw new Exception("Unhanded resource type "+resource.getClass().getName());
  }

  protected void composeNamedResource(String name, Resource resource) throws Exception {
    if (resource instanceof Provenance)
      composeProvenance(name, (Provenance)resource);
    else if (resource instanceof CarePlan)
      composeCarePlan(name, (CarePlan)resource);
    else if (resource instanceof Device)
      composeDevice(name, (Device)resource);
    else if (resource instanceof Order)
      composeOrder(name, (Order)resource);
    else if (resource instanceof Prescription)
      composePrescription(name, (Prescription)resource);
    else if (resource instanceof Organization)
      composeOrganization(name, (Organization)resource);
    else if (resource instanceof Procedure)
      composeProcedure(name, (Procedure)resource);
    else if (resource instanceof Substance)
      composeSubstance(name, (Substance)resource);
    else if (resource instanceof Group)
      composeGroup(name, (Group)resource);
    else if (resource instanceof DiagnosticReport)
      composeDiagnosticReport(name, (DiagnosticReport)resource);
    else if (resource instanceof ValueSet)
      composeValueSet(name, (ValueSet)resource);
    else if (resource instanceof Test)
      composeTest(name, (Test)resource);
    else if (resource instanceof Coverage)
      composeCoverage(name, (Coverage)resource);
    else if (resource instanceof DeviceLog)
      composeDeviceLog(name, (DeviceLog)resource);
    else if (resource instanceof MedicationAdministration)
      composeMedicationAdministration(name, (MedicationAdministration)resource);
    else if (resource instanceof DeviceCapabilities)
      composeDeviceCapabilities(name, (DeviceCapabilities)resource);
    else if (resource instanceof SecurityEvent)
      composeSecurityEvent(name, (SecurityEvent)resource);
    else if (resource instanceof IssueReport)
      composeIssueReport(name, (IssueReport)resource);
    else if (resource instanceof List_)
      composeList_(name, (List_)resource);
    else if (resource instanceof Questionnaire)
      composeQuestionnaire(name, (Questionnaire)resource);
    else if (resource instanceof Picture)
      composePicture(name, (Picture)resource);
    else if (resource instanceof Conformance)
      composeConformance(name, (Conformance)resource);
    else if (resource instanceof Document)
      composeDocument(name, (Document)resource);
    else if (resource instanceof Message)
      composeMessage(name, (Message)resource);
    else if (resource instanceof FamilyHistory)
      composeFamilyHistory(name, (FamilyHistory)resource);
    else if (resource instanceof Profile)
      composeProfile(name, (Profile)resource);
    else if (resource instanceof Location)
      composeLocation(name, (Location)resource);
    else if (resource instanceof AllergyIntolerance)
      composeAllergyIntolerance(name, (AllergyIntolerance)resource);
    else if (resource instanceof Observation)
      composeObservation(name, (Observation)resource);
    else if (resource instanceof Visit)
      composeVisit(name, (Visit)resource);
    else if (resource instanceof DocumentReference)
      composeDocumentReference(name, (DocumentReference)resource);
    else if (resource instanceof Immunization)
      composeImmunization(name, (Immunization)resource);
    else if (resource instanceof ImmunizationProfile)
      composeImmunizationProfile(name, (ImmunizationProfile)resource);
    else if (resource instanceof Problem)
      composeProblem(name, (Problem)resource);
    else if (resource instanceof Category)
      composeCategory(name, (Category)resource);
    else if (resource instanceof Specimen)
      composeSpecimen(name, (Specimen)resource);
    else if (resource instanceof DeviceObservation)
      composeDeviceObservation(name, (DeviceObservation)resource);
    else if (resource instanceof OrderResponse)
      composeOrderResponse(name, (OrderResponse)resource);
    else if (resource instanceof Patient)
      composePatient(name, (Patient)resource);
    else if (resource instanceof Practitioner)
      composePractitioner(name, (Practitioner)resource);
    else if (resource instanceof ImagingStudy)
      composeImagingStudy(name, (ImagingStudy)resource);
    else if (resource instanceof AdverseReaction)
      composeAdverseReaction(name, (AdverseReaction)resource);
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

