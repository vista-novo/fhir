package org.hl7.fhir.tools.publisher.implementations;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


public class JavaFactoryGenerator extends OutputStreamWriter {

  private Map<String, String> resources = new HashMap<String, String>(); 
  private Map<String, String> types = new HashMap<String, String>(); 
	
	public JavaFactoryGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

  public void registerResource(String name, String classname) {
    resources.put(name,  classname);
  }
  
  public void registerType(String name, String classname) {
    types.put(name,  classname);
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
    write("    public static Element createType(String name) throws Exception {\r\n");
    for (String name : types.keySet()) {
      write("        if (\""+name+"\".equals(name))\r\n");
      String t = types.get(name);
      if (t.contains("<"))
        write("            return new "+t+"(\""+t.substring(t.indexOf('<')+1).replace(">", "")+"\");\r\n");
      else
        write("            return new "+t+"();\r\n");
    }    
    write("        else\r\n");
    write("            throw new Exception(\"Unknown Type Name '\"+name+\"'\");\r\n");
    write("    }\r\n");
    write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();
		close();
	}
	
}
