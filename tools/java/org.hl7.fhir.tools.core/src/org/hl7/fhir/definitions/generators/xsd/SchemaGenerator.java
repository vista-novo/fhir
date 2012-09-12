package org.hl7.fhir.definitions.generators.xsd;
/*
Copyright (c) 2011-2012, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class SchemaGenerator {

  private String genDate;
  private String version;

  public void generate(Definitions definitions, IniFile ini, String tmpResDir, String xsdDir, String dstDir, String srcDir, String version, String genDate) throws Exception {
	  this.genDate = genDate;
	  this.version = version;

	  File dir = new File(xsdDir);
	  for (File f : dir.listFiles()) {
		  if (!f.isDirectory())
			  f.delete();
	  }

	  XSDBaseGenerator xsdb = new XSDBaseGenerator(new FileOutputStream(new File(xsdDir+"fhir-base.xsd")));
	  xsdb.setDefinitions(definitions);
	  xsdb.generate(version, genDate);
	  xsdb.close();

	  for (ResourceDefn root : definitions.getResources().values()) {
		  XSDGenerator sgen = new XSDGenerator(new FileOutputStream(new File(xsdDir+root.getName().toLowerCase()+".xsd")), definitions);
		  sgen.setDataTypes(definitions.getKnownTypes());
		  sgen.generate(root.getRoot(), definitions.getBindings(), version, genDate);
		  sgen.close();
	  }

	  for (String n : ini.getPropertyNames("schema")) {
		  String xsd = TextFile.fileToString(srcDir + n);
		  xsd = processSchemaIncludes(definitions, n, xsd);
		  TextFile.stringToFile(xsd, xsdDir + n);
	  }
	  produceAtomSchema(definitions, xsdDir, dstDir, srcDir);
	  produceCombinedSchema(definitions, xsdDir, dstDir, srcDir);

	  dir = new File(xsdDir);
	  for (File f : dir.listFiles()) {
		  if (!f.isDirectory())
			  Utilities.copyFile(f, new File(dstDir+f.getName()));
	  }
  }

  private void produceAtomSchema(Definitions definitions, String xsdDir, String dstDir, String srcDir) throws Exception {
    String src = TextFile.fileToString(srcDir + "atom-template.xsd");
    src = processSchemaIncludes(definitions, "atom-templates.xsd", src);
    TextFile.stringToFile(src, xsdDir + "fhir-atom.xsd");
  }

  private void produceCombinedSchema(Definitions definitions, String xsdDir, String dstDir, String srcDir) throws Exception {
    String src = TextFile.fileToString(srcDir + "fhir-all.xsd");
    src = processSchemaIncludes(definitions, "fhir-all.xsd", src);
    TextFile.stringToFile(src, xsdDir + "fhir-all.xsd");
  }

  private String processSchemaIncludes(Definitions definitions, String filename, String src) throws Exception {
    while (src.contains("<!--%") || src.contains("<%"))
    {
      int i2;
      String s1;
      String s2;
      String s3;

      int i1 = src.indexOf("<!--%");
      if (i1 > -1) {
        i2 = src.indexOf("%-->");
        s1 = src.substring(0, i1);
        s2 = src.substring(i1 + 5, i2).trim();
        s3 = src.substring(i2 + 4);
      } else {
        i1 = src.indexOf("<%");
        i2 = src.indexOf("%>");
        s1 = src.substring(0, i1);
        s2 = src.substring(i1 + 2, i2).trim();
        s3 = src.substring(i2 + 2);
      } 

      String[] com = s2.split(" ");
      if (com[0].equals("genDate"))
        src = s1+ genDate+s3;
      else if (com[0].equals("version"))
        src = s1+version+s3;
      else if (com[0].equals("resources")) {
        StringBuilder includes = new StringBuilder();
        for (String n : definitions.getResources().keySet()) // was ini.names of resources 
          includes.append("  <xs:include schemaLocation=\""+n.toLowerCase()+".xsd\"/>\r\n");
        src = s1+includes.toString()+s3;
      }
      else if (com[0].equals("atom.imports")) {
        StringBuilder includes = new StringBuilder();
        for (String n : definitions.getResources().keySet()) // was ini.names of resources 
          includes.append("  <xs:import namespace=\"http://hl7.org/fhir\" schemaLocation=\""+n+".xsd\"/>\r\n");
        src = s1+includes.toString()+s3;
      }
      else if (com[0].equals("atom.elements")) {
        StringBuilder includes = new StringBuilder();
        for (String n : definitions.getResources().keySet()) // was ini.names of resources 
          includes.append("      <xs:element ref=\"fhir:"+n+"\"/>\r\n");
        src = s1+includes.toString()+s3;
      }
      else if (com[0].equals("enum")) {
        Collection<DefinedCode> values;
        if (com[1].equals("resource")) {
          values = definitions.getKnownResources().values();          
        } else {
          values = definitions.getBindingByName(com[1]).getCodes();
        }
        StringBuilder enums = new StringBuilder();
        for (DefinedCode c : values) {
          enums.append("        <xs:enumeration value=\""+c.getCode()+"\">\r\n");
          enums.append("          <xs:annotation>\r\n");
          enums.append("            <xs:documentation>"+Utilities.escapeXml(c.getDefinition())+"</xs:documentation>\r\n");
          enums.append("          </xs:annotation>\r\n");
          enums.append("        </xs:enumeration>\r\n");
        }
        src = s1+enums.toString()+s3;
      }
      else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+filename);
    }
    return src;
  }  
}
