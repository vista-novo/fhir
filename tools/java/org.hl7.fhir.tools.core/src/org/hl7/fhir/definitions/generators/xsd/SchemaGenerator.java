package org.hl7.fhir.definitions.generators.xsd;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Utilities;

public class SchemaGenerator {

  private String genDate;
  private String version;

  public void generate(Definitions definitions, IniFile ini, String tmpResDir, String xsdDir, String dstDir, String srcDir, String version, String genDate) throws Exception {
    this.genDate = genDate;
    this.version = version;
    
    XSDBaseGenerator xsdb = new XSDBaseGenerator(new FileOutputStream(new File(xsdDir+"fhir-base.xsd")));
    xsdb.setDefinitions(definitions);
    xsdb.generate(version, genDate);
    
    for (ElementDefn root : definitions.getDefinedResources().values()) {
      XSDGenerator sgen = new XSDGenerator(new FileOutputStream(new File(xsdDir+root.getName()+".xsd")));
      sgen.setDataTypes(definitions.getKnownTypes());
      sgen.generate(root, definitions.getConceptDomains(), version, genDate);

      sgen = new XSDGenerator(new FileOutputStream(new File(dstDir+root.getName()+".xsd")));
      sgen.setDataTypes(definitions.getKnownTypes());
      sgen.generate(root, definitions.getConceptDomains(), version, genDate);
    }

    for (String n : ini.getPropertyNames("schema")) {
        String xsd = Utilities.fileToString(srcDir + n);
        xsd = processSchemaIncludes(definitions, n, xsd);
        Utilities.stringToFile(xsd, dstDir + n);
        Utilities.stringToFile(xsd, xsdDir + n);  
    }
    
    produceCombinedSchema(definitions, xsdDir, dstDir, srcDir);
    
  }

  private void produceCombinedSchema(Definitions definitions, String xsdDir, String dstDir, String srcDir) throws Exception {
    String src = Utilities.fileToString(srcDir + "fhir-all.xsd");
    src = processSchemaIncludes(definitions, "fhir-all.xsd", src);
    Utilities.stringToFile(src, dstDir + "fhir-all.xsd");
    Utilities.stringToFile(src, xsdDir + "fhir-all.xsd");
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
        src = s1+genDate+s3;
      else if (com[0].equals("version"))
        src = s1+version+s3;
      else if (com[0].equals("resources")) {
        StringBuilder includes = new StringBuilder();
        for (String n : definitions.getDefinedResources().keySet()) // was ini.names of resources 
          includes.append("  <xs:include schemaLocation=\""+n+".xsd\"/>\r\n");
        src = s1+includes.toString()+s3;
      }
      else if (com[0].equals("enum")) {
        Collection<DefinedCode> values;
        if (com[1].equals("resource")) {
          values = definitions.getKnownResources().values();          
        } else {
          values = definitions.getConceptDomainByName(com[1]).getCodes();
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
