package org.hl7.fhir.instance.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Map;

import org.hl7.fhir.instance.formats.XmlComposer;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Conformance;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceType;

/**
 * no security. no proxy
 * @author Grahame
 *
 */
public class FHIRSimpleClient implements FHIRClient {

	private String baseUrl;
	
	public FHIRSimpleClient(String baseUrl) throws MalformedURLException {
		super();
		this.baseUrl = baseUrl;
	}

	
	private HttpURLConnection makeClient(String tail) throws Exception {
		HttpURLConnection client = (HttpURLConnection) new URL(baseUrl+tail).openConnection();
		client.addRequestProperty("accept", "text/xml");
		return client;
	}
	
	
	@Override
	public Conformance getConformanceStatement() throws EFhirClientException {
		try {
			URLConnection client = makeClient("/metadata");
			return (Conformance) new XmlParser().parse(client.getInputStream());
		} catch (Exception e) {
			throw new EFhirClientException(e);
		}
	}

	@Override
	public Resource read(ResourceType type, String id) throws EFhirClientException {
		try {
			URLConnection client = makeClient("/"+type.toString().toLowerCase()+"/@"+id);
			return new XmlParser().parse(client.getInputStream());
		} catch (Exception e) {
			throw new EFhirClientException(e);
		}
	}

	@Override
	public Resource vread(ResourceType type, String id, String versionid) throws EFhirClientException {
		try {
			URLConnection client = makeClient("/"+type.toString().toLowerCase()+"/@"+id+"/history/@"+versionid);
			return new XmlParser().parse(client.getInputStream());
		} catch (Exception e) {
			throw new EFhirClientException(e);
		}
	}

	@Override
	public Resource update(String id, Resource resource) throws EFhirClientException {
		try {
			HttpURLConnection client = makeClient("/"+resource.getResourceType().toString().toLowerCase()+"/@"+id);
			client.setRequestMethod("PUT");
			client.setDoOutput(true); // Triggers POST.
			client.setRequestProperty("Content-Type", "text/xml+fhir;charset=UTF-8");
			OutputStream output = null;
			try {
				output = client.getOutputStream();
				new XmlComposer().compose(output, resource, false);
			} finally {
				if (output != null) 
					output.close();  
			}
			return new XmlParser().parse(client.getInputStream());		
		} catch (Exception e) {
			throw new EFhirClientException(e);
		}
	}

	@Override
	public void delete(ResourceType type, String id)
			throws EFhirClientException {
		// TODO Auto-generated method stub

	}

	@Override
	public String create(Resource resource)
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
