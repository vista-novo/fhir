package org.hl7.fhir.tools.publisher.implementations;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.definitions.Config;


public class JavaParserFactoryGenerator extends OutputStreamWriter {

	private Map<String, String> resources = new HashMap<String, String>(); 
	
	public JavaParserFactoryGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void registerResource(String name, String classname) {
		resources.put(name,  classname);
	}
	
	public void generate(String version, Date genDate) throws Exception {
     	write("package org.hl7.fhir.instance.parser;\r\n");
      write("\r\n/*\r\n"+Config.FULL_LICENSE_CODE+"*/\r\n\r\n");
      write("// Generated on "+Config.DATE_FORMAT().format(genDate)+" for FHIR v"+version+"\r\n\r\n");
		write("public class ResourceParserFactory {\r\n");
		write("\r\n");
		write("    public static ResourceParser createParser(String name) throws Exception {\r\n");
		for (String name : resources.keySet()) {
			write("        if (\""+name+"\".equals(name))\r\n");
			write("            return new "+resources.get(name)+"Parser();\r\n");
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
