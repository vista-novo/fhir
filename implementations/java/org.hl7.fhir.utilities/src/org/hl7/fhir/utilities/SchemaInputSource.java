package org.hl7.fhir.utilities;

import java.io.InputStream;
import java.io.Reader;

import org.w3c.dom.ls.LSInput;

public class SchemaInputSource implements LSInput {

	private InputStream stream;
  private String publicId;
  private String systemId;
  private String namespaceURI;

	public SchemaInputSource(InputStream inputStream, String publicId, String systemId, String namespaceURI) {
		this.stream = inputStream;
		this.publicId = publicId;
		this.systemId = systemId;
		this.namespaceURI = namespaceURI;
	}

	public String getBaseURI() {
	  return namespaceURI;
	}

	public InputStream getByteStream() {
		return stream;
	}

	public boolean getCertifiedText() {
    throw new Error("Not implemented yet");
	}

	public Reader getCharacterStream() {
    return null;
	}

	public String getEncoding() {
    return "UTF-8";
	}

	public String getPublicId() {
    return publicId;
	}

	public String getStringData() {
    return null;
	}

	public String getSystemId() {
    return systemId;
	}

	public void setBaseURI(String baseURI) {
    throw new Error("Not implemented yet");
	}

	public void setByteStream(InputStream byteStream) {
    throw new Error("Not implemented yet");
	}

	public void setCertifiedText(boolean certifiedText) {
    throw new Error("Not implemented yet");
	}

	public void setCharacterStream(Reader characterStream) {
    throw new Error("Not implemented yet");
	}

	public void setEncoding(String encoding) {
    throw new Error("Not implemented yet");
	}

	public void setPublicId(String publicId) {
    throw new Error("Not implemented yet");
	}

	public void setStringData(String stringData) {
    throw new Error("Not implemented yet");
	}

	public void setSystemId(String systemId) {
    throw new Error("Not implemented yet");
	}
}