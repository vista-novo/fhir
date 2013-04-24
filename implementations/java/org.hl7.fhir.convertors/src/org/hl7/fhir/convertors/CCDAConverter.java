package org.hl7.fhir.convertors;

import java.io.InputStream;
import java.util.Calendar;
import java.util.UUID;

import org.hl7.fhir.instance.model.AtomEntry;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.CodeableConcept;
import org.hl7.fhir.instance.model.Coding;
import org.hl7.fhir.instance.model.Demographics;
import org.hl7.fhir.instance.model.Demographics.DemographicsLanguageComponent;
import org.hl7.fhir.instance.model.Document;
import org.hl7.fhir.instance.model.Document.DocumentAttestationMode;
import org.hl7.fhir.instance.model.Document.DocumentAttesterComponent;
import org.hl7.fhir.instance.model.Factory;
import org.hl7.fhir.instance.model.Organization;
import org.hl7.fhir.instance.model.Patient;
import org.hl7.fhir.instance.model.Practitioner;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceFactory;
import org.hl7.fhir.instance.model.Visit;
import org.w3c.dom.Element;

public class CCDAConverter {

	private CDAUtilities cda;
	private Convert convert;
	private AtomFeed feed;
	private Document document;
	public AtomFeed convert(InputStream stream) throws Exception {

		cda = new CDAUtilities(stream);
		org.w3c.dom.Element doc = cda.getElement();
		cda.checkTemplateId(doc, "2.16.840.1.113883.10.20.22.1.1");
		convert = new Convert(cda);

		// check it's a CDA/CCD
		feed = new AtomFeed();
		feed.setUpdated(Calendar.getInstance());
		feed.setId(UUID.randomUUID().toString());
		
		// process the header
		makeDocument();
		document.setSubject(Factory.makeResourceReference("Patient", makeSubject()));
		for (Element e : cda.getChildren(cda.getElement(), "author"))
			document.getAuthor().add(Factory.makeResourceReference("Provider", makeAuthor(e)));
		// todo: data enterer & informant goes in provenance
		document.setCustodian(Factory.makeResourceReference("Organization", makeOrganization(
				 cda.getDescendent(cda.getElement(), "custodian/assignedCustodian/representedCustodianOrganization"), "Custodian")));
		// todo: informationRecipient		
		for (Element e : cda.getChildren(cda.getElement(), "legalAuthenticator"))
			document.getAttester().add(makeAttester(e, DocumentAttestationMode.legal, "Legal Authenticator"));
		for (Element e : cda.getChildren(cda.getElement(), "authenticator"))
			document.getAttester().add(makeAttester(e, DocumentAttestationMode.professional, "Authenticator"));
		
		// process the contents
		return feed;
	}

	
	private String addResource(Resource r, String title, String id) {
		AtomEntry e = new AtomEntry();
		e.setUpdated(Calendar.getInstance());
		e.setResource(r);
		e.setTitle(title);
		e.setId(id);
		e.setCategory(r.getResourceType().toString());
		feed.getEntryList().add(e);
		return id;
	}

	private void makeDocument() throws Exception {
		document = (Document) ResourceFactory.createResource("Document");
    addResource(document, "Document", UUID.randomUUID().toString());

		Element title = cda.getChild(cda.getElement(), "title");
		if (title == null) {
			feed.setTitle("Clinical Document (generated from CCDA document)");
		} else {
			feed.setTitle(title.getTextContent());
			document.setTitleSimple(title.getTextContent());			
		}
		document.setVersionId(convert.makeIdentifierFromII(cda.getChild(cda.getElement(), "id")));
		if (cda.getChild(cda.getElement(), "setId") != null)
			document.setId(convert.makeIdentifierFromII(cda.getChild(cda.getElement(), "setId")));
			
		document.setCreated(convert.makeInstantFromTS(cda.getChild(cda.getElement(), "effectiveTime")));
		document.setType(convert.makeCodeableConceptFromCD(cda.getChild(cda.getElement(), "code")));
		document.setConfidentiality(convert.makeCodingFromCV(cda.getChild(cda.getElement(), "confidentialityCode")));
		if (cda.getChild(cda.getElement(), "confidentialityCode") != null)
			document.setLanguageSimple(cda.getChild(cda.getElement(), "confidentialityCode").getAttribute("value")); // todo - fix streaming for this
		
		Element ee = cda.getChild(cda.getElement(), "componentOf");
		if (ee != null)
			ee = cda.getChild(ee, "encompassingEncounter");
		if (ee != null) {
			Visit visit = new Visit();
			for (Element e : cda.getChildren(ee, "id"))
				visit.getIdentifier().add(convert.makeIdentifierFromII(e));
			visit.setPeriod(convert.makePeriodFromIVL(cda.getChild(ee, "effectiveTime")));
			document.setEvent(document.new DocumentEventComponent());
			document.getEvent().getCode().add(convert.makeCodeableConceptFromCD(cda.getChild(ee, "code")));
			document.getEvent().setPeriod(visit.getPeriod());
			document.getEvent().getDetail().add(Factory.makeResourceReference("Visit", addResource(visit, "Encounter", UUID.randomUUID().toString())));			
		}
		
		// main todo: fill out the narrative, but before we can do that, we have to convert everything else
	}

	private String makeSubject() throws Exception {
		Element rt = cda.getChild(cda.getElement(), "recordTarget");
		Element pr = cda.getChild(rt, "patientRole");
		Element p = cda.getChild(pr, "patient");
		
		Patient pat = (Patient) ResourceFactory.createResource("Patient");
		for (Element e : cda.getChildren(pr, "id"))
			pat.getIdentifier().add(convert.makeIdentifierFromII(e));

		pat.setDetails(new Demographics());
		for (Element e : cda.getChildren(pr, "addr"))
			pat.getDetails().getAddress().add(convert.makeAddressFromAD(e));
		for (Element e : cda.getChildren(pr, "telecom"))
			pat.getDetails().getTelecom().add(convert.makeContactFromTEL(e));
		for (Element e : cda.getChildren(p, "name"))
			pat.getDetails().getName().add(convert.makeNameFromEN(e));
		pat.getDetails().setGender(convert.makeCodingFromCV(cda.getChild(p, "administrativeGenderCode")));
		pat.getDetails().setBirthDate(convert.makeDateTimeFromTS(cda.getChild(p, "birthTime")));
		pat.getDetails().setMaritalStatus(convert.makeCodeableConceptFromCD(cda.getChild(p, "maritalStatusCode")));
		pat.getDetails().getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/religious-affiliation", convert.makeCodeableConceptFromCD(cda.getChild(p, "religiousAffiliationCode"))));
		pat.getDetails().getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/race", convert.makeCodeableConceptFromCD(cda.getChild(p, "raceCode"))));
		pat.getDetails().getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/ethnic-group", convert.makeCodeableConceptFromCD(cda.getChild(p, "ethnicGroupCode"))));
		pat.getDetails().getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/birthplace", convert.makeAddressFromAD(cda.getChild(p, new String[] {"birthplace", "place", "addr"}))));
		
		Patient.ContactComponent guardian = pat.new ContactComponent();
		guardian.setDetails(new Demographics());
		pat.getContact().add(guardian);
		guardian.getRelationship().add(Factory.newCodeableConcept("GUARD", "urn:oid:2.16.840.1.113883.5.110", "guardian"));
		Element g = cda.getChild(p, "guardian");
		for (Element e : cda.getChildren(g, "addr"))
			guardian.getDetails().getAddress().add(convert.makeAddressFromAD(e));
		for (Element e : cda.getChildren(g, "telecom"))
			guardian.getDetails().getTelecom().add(convert.makeContactFromTEL(e));
		g = cda.getChild(g, "guardianPerson");
		for (Element e : cda.getChildren(g, "name"))
			guardian.getDetails().getName().add(convert.makeNameFromEN(e));

	  DemographicsLanguageComponent lang = pat.getDetails().new DemographicsLanguageComponent();
	  pat.getDetails().getLanguage().add(lang);
	  Element l = cda.getChild(p, "languageCommunication");
	  CodeableConcept cc = new CodeableConcept();
	  Coding c = new Coding();
	  c.setCodeSimple(cda.getChild(l, "languageCode").getAttribute("code"));
	  cc.getCoding().add(c);
		lang.setLanguage(cc); 

		lang.setMode(convert.makeCodeableConceptFromCD(cda.getChild(l, "modeCode")));
		lang.setProficiencyLevel(convert.makeCodeableConceptFromCD(cda.getChild(l, "modeCode")));
		pat.getDetails().getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/religious-affiliation", convert.makeCodeableConceptFromCD(cda.getChild(p, "religiousAffiliationCode"))));
		pat.setProvider(Factory.makeResourceReference("Organization", makeOrganization(cda.getChild(pr, "providerOrganization"), "Provider")));
		return addResource(pat, "Subject", UUID.randomUUID().toString());
	}


	private String makeOrganization(Element org, String name) throws Exception {
	  Organization o = new Organization();
		for (Element e : cda.getChildren(org, "id"))
			o.getIdentifier().add(convert.makeIdentifierFromII(e));
		for (Element e : cda.getChildren(org, "name"))
			o.getName().add(Factory.newString_(e.getTextContent()));
		for (Element e : cda.getChildren(org, "addr"))
			o.getAddress().add(convert.makeAddressFromAD(e));
		for (Element e : cda.getChildren(org, "telecom"))
			o.getTelecom().add(convert.makeContactFromTEL(e));

	  return addResource(o, name, UUID.randomUUID().toString());
  }

	private String makeAuthor(Element auth) throws Exception {
		Element aa = cda.getChild(auth, "assignedAuthor");
		Element ap = cda.getChild(aa, "assignedPerson");
		
		Practitioner  pr = (Practitioner) ResourceFactory.createResource("Practitioner");
		for (Element e : cda.getChildren(aa, "id"))
			pr.getIdentifier().add(convert.makeIdentifierFromII(e));
		pr.setDetails(new Demographics());
		for (Element e : cda.getChildren(aa, "addr"))
			pr.getDetails().getAddress().add(convert.makeAddressFromAD(e));
		for (Element e : cda.getChildren(aa, "telecom"))
			pr.getDetails().getTelecom().add(convert.makeContactFromTEL(e));
		for (Element e : cda.getChildren(ap, "name"))
			pr.getDetails().getName().add(convert.makeNameFromEN(e));

	  return addResource(pr, "Author", UUID.randomUUID().toString());
	}


	private DocumentAttesterComponent makeAttester(Element a1, DocumentAttestationMode mode, String title) throws Exception {
		Practitioner  pr = (Practitioner) ResourceFactory.createResource("Practitioner");
		Element ass = cda.getChild(a1, "assignedEntity");
		for (Element e : cda.getChildren(ass, "id"))
			pr.getIdentifier().add(convert.makeIdentifierFromII(e));
		pr.setDetails(new Demographics());
		for (Element e : cda.getChildren(ass, "addr"))
			pr.getDetails().getAddress().add(convert.makeAddressFromAD(e));
		for (Element e : cda.getChildren(ass, "telecom"))
			pr.getDetails().getTelecom().add(convert.makeContactFromTEL(e));
		Element ap = cda.getChild(ass, "assignedPerson");
		for (Element e : cda.getChildren(ap, "name"))
			pr.getDetails().getName().add(convert.makeNameFromEN(e));
		

		DocumentAttesterComponent att = document.new DocumentAttesterComponent();
		att.setModeSimple(mode);
		att.setTime(convert.makeDateTimeFromTS(cda.getChild(a1,"time")));
	  att.setParty(Factory.makeResourceReference("Practitioner", addResource(pr, title, UUID.randomUUID().toString())));
	  return att;
  }


}
