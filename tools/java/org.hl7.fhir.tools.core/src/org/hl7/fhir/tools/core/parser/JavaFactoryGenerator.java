package org.hl7.fhir.tools.core.parser;

import java.io.*;
import java.util.*;


public class JavaFactoryGenerator extends OutputStreamWriter {

	private Map<String, String> resources = new HashMap<String, String>(); 
	
	public JavaFactoryGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void registerResource(String name, String classname) {
		resources.put(name,  classname);
	}
	
	public void generate() throws Exception {
		write("package org.hl7.fhir.instance.model;\r\n");
		write("\r\n");
		write("public class ResourceFactory {\r\n");
		write("\r\n");
		write("    public static Resource createResource(String name) throws Exception {\r\n");
		for (String name : resources.keySet()) {
			write("        if (\""+name+"\".equals(name))\r\n");
			write("            return new "+resources.get(name)+"();\r\n");
		}
		
		write("        else\r\n");
		write("            throw new Exception(\"Unknown Resource Name '\"+name+\"'\");\r\n");
		write("    }\r\n");
		write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();
		close();
	}
	
}
