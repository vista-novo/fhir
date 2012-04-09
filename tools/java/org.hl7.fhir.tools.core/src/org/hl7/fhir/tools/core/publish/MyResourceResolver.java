package org.hl7.fhir.tools.core.publish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.w3c.dom.ls.*;

public class MyResourceResolver implements LSResourceResolver {

	private String dir;
	
	public MyResourceResolver(String dir) {
		this.dir = dir;
	}

	@Override
	public LSInput resolveResource(final String type, final String namespaceURI, final String publicId, String systemId, final String baseURI) {
		System.out.println(type+", "+namespaceURI+", "+publicId+", "+systemId+", "+baseURI);
		if (!(namespaceURI.equals("http://www.hl7.org/fhir") || namespaceURI.equals("http://www.w3.org/1999/xhtml")))
			return null;
	    try {
			return new MyLSInput(new FileInputStream(new File(dir + systemId)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


}
