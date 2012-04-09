package org.hl7.fhir.tools.core.publish;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;

import org.w3c.dom.ls.LSInput;

public class MyLSInput implements LSInput {

	private FileInputStream stream;

	public MyLSInput(FileInputStream fileInputStream) {
		this.stream = fileInputStream;
	}

	@Override
	public String getBaseURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getByteStream() {
		return stream;
	}

	@Override
	public boolean getCertifiedText() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reader getCharacterStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPublicId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStringData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSystemId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBaseURI(String baseURI) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setByteStream(InputStream byteStream) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCertifiedText(boolean certifiedText) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCharacterStream(Reader characterStream) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEncoding(String encoding) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPublicId(String publicId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStringData(String stringData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSystemId(String systemId) {
		// TODO Auto-generated method stub

	}

}
