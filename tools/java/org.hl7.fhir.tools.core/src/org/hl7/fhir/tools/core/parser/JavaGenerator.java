package org.hl7.fhir.tools.core.parser;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.tools.core.model.ElementDefn;
import org.hl7.fhir.tools.core.model.TypeDefn;

public class JavaGenerator extends OutputStreamWriter {

	public JavaGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	
	protected String getElementName(String name) {
		return name.replace("[x]", "");
	}

	protected String getTypeName(ElementDefn e) throws Exception {
		if (e.getTypes().size() > 1) {
			return "Type";
		} else if (e.getTypes().size() == 0) {
			throw new Exception("not supported");
		} else {
			return getTypename(e.getTypes().get(0));
		}
	}

	protected String getTypename(TypeDefn type) throws Exception {
		if (type.getParams().size() == 1) {			
			if (type.getName().equals("Resource"))
				return "ResourceReference<"+getTypeName(type.getParams().get(0))+">";
			else if (type.getName().equals("Interval"))
				return "Interval<"+getTypeName(type.getParams().get(0))+">";
			else
				throw new Exception("not supported");
		} else if (type.getParams().size() > 1) {
			if (type.getName().equals("Resource"))
				return "ResourceReference<Resource>";
			else
				throw new Exception("not supported");
		} else {
			return getTypeName(type.getName());
		}
	}

	protected String getTypeName(String tn) {
		if (tn.equals("string")) {
			return "String_";
		} else if (tn.equals("Any")) {
			return "Resource";
		} else {
			return getTitle(tn);
		}
	}

	protected String getTitle(String name) {
		return name.substring(0, 1).toUpperCase()+ name.substring(1);
	}
}
