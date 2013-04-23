package org.hl7.fhir.convertors;

import java.io.InputStream;
import java.util.Calendar;
import java.util.UUID;

import org.hl7.fhir.instance.model.AtomEntry;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Demographics;
import org.hl7.fhir.instance.model.Document;
import org.hl7.fhir.instance.model.Factory;
import org.hl7.fhir.instance.model.Patient;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceFactory;
import org.w3c.dom.Element;

public class CCDAConverter {

	private CDAUtilities cda;
	private Convert convert;
	
	public AtomFeed convert(InputStream stream) throws Exception {

		cda = new CDAUtilities(stream);
		org.w3c.dom.Element doc = cda.getElement();
		cda.checkTemplateId(doc, "2.16.840.1.113883.10.20.22.1.1");
		convert = new Convert(cda);

		// check it's a CDA/CCD
		AtomFeed feed = new AtomFeed();
		feed.setUpdated(Calendar.getInstance());
		feed.setId(UUID.randomUUID().toString());
		
		feed.getEntryList().add(makeDocument(feed));
		feed.getEntryList().add(makeSubject());
		// process the contents
		return feed;
	}

	
	private AtomEntry wrapResource(Resource r, String title, String id) {
		AtomEntry e = new AtomEntry();
		e.setUpdated(Calendar.getInstance());
		e.setResource(r);
		e.setTitle(title);
		e.setId(id);
		e.setCategory(r.getResourceType().toString());
		return e;
	}

	private AtomEntry makeDocument(AtomFeed feed) throws Exception {
		Document d = (Document) ResourceFactory.createResource("Document");

		Element title = cda.getChild(cda.getElement(), "title");
		if (title == null) {
			feed.setTitle("Clinical Document (generated from CCDA document)");
		} else {
			feed.setTitle(title.getTextContent());
			d.setTitleSimple(title.getTextContent());			
		}
		d.setVersionId(convert.makeIdentifierFromII(cda.getChild(cda.getElement(), "id")));
		if (cda.getChild(cda.getElement(), "setId") != null)
			d.setId(convert.makeIdentifierFromII(cda.getChild(cda.getElement(), "setId")));
			
		d.setCreated(convert.makeInstantFromTS(cda.getChild(cda.getElement(), "effectiveTime")));
		d.setType(convert.makeCodeableConceptFromCD(cda.getChild(cda.getElement(), "code")));
		d.setConfidentiality(convert.makeCodingFromCV(cda.getChild(cda.getElement(), "confidentialityCode")));
		if (cda.getChild(cda.getElement(), "confidentialityCode") != null)
			d.setLanguageSimple(cda.getChild(cda.getElement(), "confidentialityCode").getAttribute("value")); // todo - fix streaming for this
		
		// main todo: fill out the narrative, but before we can do that, we have to convert everything else
    return wrapResource(d, "Document", UUID.randomUUID().toString());
	}

	private AtomEntry makeSubject() throws Exception {
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
		pat.getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/religious-affiliation", convert.makeCodeableConceptFromCD(cda.getChild(p, "religiousAffiliationCode"))));
		pat.getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/race", convert.makeCodeableConceptFromCD(cda.getChild(p, "raceCode"))));
		pat.getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/ethnic-group", convert.makeCodeableConceptFromCD(cda.getChild(p, "ethnicGroupCode"))));
		pat.getExtensions().add(Factory.newExtension("http://www.healthintersections.com.au/fhir/extensions/birthplace", convert.makeAddressFromAD(cda.getChild(p, new String[] {"birthplace", "place", "addr"}))));
		
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
		
		// todo: guardian
		
		return wrapResource(pat, "Subject", UUID.randomUUID().toString());
	}

}
