package org.hl7.fhir.convertors;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.hl7.fhir.instance.model.AtomEntry;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Patient;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceFactory;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class CCDConverter {

	public AtomFeed convert(InputStream stream) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document xdoc = builder.parse(stream);
		basicChecks(xdoc);

		// check it's a CDA/CCD
		AtomFeed feed = new AtomFeed();
		feed.getEntryList().add(makeDocument(xdoc));
		feed.getEntryList().add(makeSubject());
		// process the contents
		return feed;
	}

	private void basicChecks(Document xdoc) {
		// TODO Auto-generated method stub
		
	}
	
	private AtomEntry wrapResource(Resource r) {
		AtomEntry e = new AtomEntry();
		e.setResource(r);
		return e;
	}

	private AtomEntry makeDocument(Document xdoc) throws Exception {
		Resource r = ResourceFactory.createResource("Document");
        return wrapResource(r);
	}

	private AtomEntry makeSubject() throws Exception {
		Patient p = (Patient) ResourceFactory.createResource("Patient");
        return wrapResource(p);
	}

}
