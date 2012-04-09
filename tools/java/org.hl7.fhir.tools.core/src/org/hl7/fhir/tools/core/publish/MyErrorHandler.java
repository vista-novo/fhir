package org.hl7.fhir.tools.core.publish;

import java.util.*;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyErrorHandler implements ErrorHandler {

	private boolean trackErrors;
	private List<String> errors = new ArrayList<String>();
	
	public MyErrorHandler(boolean trackErrors) {
		this.trackErrors = trackErrors;
	}

	@Override
	public void error(SAXParseException arg0) throws SAXException {
		if (trackErrors) {
		  System.out.println("error: " + arg0.toString());
		  errors.add(arg0.toString());
		}
	}

	@Override
	public void fatalError(SAXParseException arg0) throws SAXException {
		System.out.println("fatal error: " + arg0.toString());

	}

	public List<String> getErrors() {
		return errors;
	}

	@Override
	public void warning(SAXParseException arg0) throws SAXException {
	//	System.out.println("warning: " + arg0.toString());

	}

}
