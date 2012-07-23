package org.hl7.fhir.utilities;

import java.io.InputStream;
import java.io.Reader;

import org.w3c.dom.ls.LSInput;

public class SchemaInputSource implements LSInput {

	private InputStream stream;

	public SchemaInputSource(InputStream inputStream) {
		this.stream = inputStream;
	}

	public String getBaseURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public InputStream getByteStream() {
		return stream;
	}

	public boolean getCertifiedText() {
		// TODO Auto-generated method stub
		return false;
	}

	public Reader getCharacterStream() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPublicId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStringData() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSystemId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBaseURI(String baseURI) {
		// TODO Auto-generated method stub

	}

	public void setByteStream(InputStream byteStream) {
		// TODO Auto-generated method stub

	}

	public void setCertifiedText(boolean certifiedText) {
		// TODO Auto-generated method stub

	}

	public void setCharacterStream(Reader characterStream) {
		// TODO Auto-generated method stub

	}

	public void setEncoding(String encoding) {
		// TODO Auto-generated method stub

	}

	public void setPublicId(String publicId) {
		// TODO Auto-generated method stub

	}

	public void setStringData(String stringData) {
		// TODO Auto-generated method stub

	}

	public void setSystemId(String systemId) {
		// TODO Auto-generated method stub

	}
}