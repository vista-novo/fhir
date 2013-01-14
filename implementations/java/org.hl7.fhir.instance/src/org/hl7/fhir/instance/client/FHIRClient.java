package org.hl7.fhir.instance.client;

import java.util.Calendar;
import java.util.Map;

import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Conformance;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceType;

/**
 * Have one interface for each particular server
 * 
 * @author Grahame
 *
 */
public interface FHIRClient {

	// Get a conformance statement for the system
	public Conformance getConformanceStatement() throws EFhirClientException;
	
	// Read the current state of a resource
	public Resource read(ResourceType type, String id) throws EFhirClientException;
	
	// Read the state of a specific version of the resource
	public Resource vread(ResourceType type, String id, String versionid) throws EFhirClientException; 
	
    // Update an existing resource by its id (or create it if it is new)
	public void update(ResourceType type, String id, Resource resource) throws EFhirClientException;
	
	// Delete a resource
	public void delete(ResourceType type, String id) throws EFhirClientException; 

	// Create a new resource with a server assigned id
	public String create(ResourceType type, Resource resource) throws EFhirClientException;
	
	// Retrieve the update history for a resource, for a resource type, for all resources. LastUpdate can be null for all of these
	public AtomFeed history(Calendar lastUpdate, ResourceType type, String id) throws EFhirClientException;
	public AtomFeed history(Calendar lastUpdate, ResourceType type) throws EFhirClientException;
	public AtomFeed history(Calendar lastUpdate) throws EFhirClientException;
	
	// Search the resource type based on some filter criteria
	public AtomFeed search(ResourceType type, Map<String, String> params) throws EFhirClientException;
	
	// 	Update or create a set of resources
	public AtomFeed batch(AtomFeed batch) throws EFhirClientException;
	
}
