package org.hl7.fhir.instance.client;

import java.util.Calendar;
import java.util.Map;

import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Conformance;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceType;

public class FHIRSimpleClient implements FHIRClient {

	@Override
	public Conformance getConformanceStatement() throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource read(ResourceType type, String id)
			throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource vread(ResourceType type, String id, String versionid)
			throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ResourceType type, String id, Resource resource)
			throws EFhirClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ResourceType type, String id)
			throws EFhirClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public String create(ResourceType type, Resource resource)
			throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AtomFeed history(Calendar lastUpdate, ResourceType type, String id)
			throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AtomFeed history(Calendar lastUpdate, ResourceType type)
			throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AtomFeed history(Calendar lastUpdate) throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AtomFeed search(ResourceType type, Map<String, String> params)
			throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AtomFeed batch(AtomFeed batch) throws EFhirClientException {
		// TODO Auto-generated method stub
		return null;
	}

}
