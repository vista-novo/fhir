package org.hl7.fhir.instance.client;

import java.util.HashMap;

import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceReference;

public class FHIRClientManager {

	HashMap<String, FHIRClient> servers = new HashMap<String, FHIRClient>();
	
	public void RegisterServer(String baseUrl, FHIRClient server) throws EFhirClientException {
		if (servers.containsKey(baseUrl))
			throw new EFhirClientException("Duplicate Server Id");
		servers.add(baseUrl, server);
	}
	
	public FHIRClient resolveServer(ResourceReference ref) {
		return null;
		// todo
	}
	
	public Resource getResource(ResourceReference ref) {
		return null;
		// todo		
	}
}
