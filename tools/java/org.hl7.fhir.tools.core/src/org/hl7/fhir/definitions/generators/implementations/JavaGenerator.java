package org.hl7.fhir.definitions.generators.implementations;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.hl7.fhir.definitions.generators.implementations.JavaResourceGenerator.JavaGenClass;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.definitions.parsers.TypeParser;
import org.hl7.fhir.utilities.IniFile;

public class JavaGenerator {

  public void generate(Definitions definitions, String javaDir, String javaParserDir, String tmpResDir, String dstDir, String version, String genDate) throws Exception {
    JavaFactoryGenerator jFactoryGen = new JavaFactoryGenerator(new FileOutputStream(javaDir+"ResourceFactory.java"));
    
    for (String n : definitions.getDefinedResources().keySet()) {
      ElementDefn root = definitions.getResourceDefn(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Resource, null);
      jFactoryGen.registerResource(n,  root.getName());
    }

    for (DefinedCode cd : definitions.getFutureResources().values()) {
      ElementDefn e = new ElementDefn();
      e.setName(cd.getCode());
      new JavaResourceGenerator(new FileOutputStream(javaDir+e.getName()+".java")).generate(e, definitions.getConceptDomains(), JavaGenClass.Resource, null);
      jFactoryGen.registerResource(cd.getCode(),  e.getName());
    }

    for (String n : definitions.getInfrastructure().keySet()) {
      ElementDefn root = definitions.getInfrastructure().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Structure, null);
      jFactoryGen.registerType(n,  root.getName());
    }
    for (String n : definitions.getTypes().keySet()) {
      ElementDefn root = definitions.getTypes().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Type, null);
      if (root.typeCode().equals("GenericType")) {
        for (TypeDefn td : definitions.getKnownTypes()) {
          if (td.getName().equals(root.getName()) && td.hasParams()) {
            for (String pt : td.getParams()) {
              jFactoryGen.registerType(n+"<"+getTitle(pt)+">", root.getName()+"<"+getTitle(pt)+">");
            }
          }
        }
      } else
        jFactoryGen.registerType(n,  root.getName());
    }
    for (DefinedCode cd : definitions.getConstraints().values()) {
      ElementDefn root = definitions.getTypes().get(cd.getComment()); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+cd.getCode()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Constraint, cd);
      jFactoryGen.registerType(cd.getCode(), cd.getCode());      
    }
    
    for (String n : definitions.getStructures().keySet()) {
      ElementDefn root = definitions.getStructures().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Type, null);
      jFactoryGen.registerType(n,  root.getName());
    }


    
    JavaParserXmlGenerator jParserGen = new JavaParserXmlGenerator(new FileOutputStream(javaParserDir+"XmlParser.java"));
    jParserGen.generate(definitions, version, genDate);
    
    // scratch directory from here on, to help with maintaining the reference model (these parts are maintained by hand) 
//    for (String n : ini.getPropertyNames("patterns")) { 
//      TypeDefn t = new TypeParser().parse(n).get(0);
//      ElementDefn el = definitions.getDefinedResources().get(t.getName());
//
//      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(tmpResDir+t.getName()+".java"));
//      jgen.generate(el, definitions.getConceptDomains());
//      JavaParserGenerator jpgen = new JavaParserGenerator(new FileOutputStream(tmpResDir+t.getName()+"Parser.java"));
//      jpgen.setTypeNames(jgen.getTypeNames());
//      jpgen.generate(el, definitions.getConceptDomains());
//    }
//    for (String n : ini.getPropertyNames("types")) { 
//      TypeDefn t = new TypeParser().parse(n).get(0);
//      ElementDefn el = definitions.getDefinedResources().get(t.getName());
//      if (el != null) {
//        JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(tmpResDir+t.getName()+".java"));
//        jgen.generate(el, definitions.getConceptDomains());
//        JavaParserGenerator jpgen = new JavaParserGenerator(new FileOutputStream(tmpResDir+t.getName()+"Parser.java"));
//        jpgen.setTypeNames(jgen.getTypeNames());
//        jpgen.generate(el, definitions.getConceptDomains());
//      } 
//    }
//    for (String n : ini.getPropertyNames("datatypes")) {
//      TypeDefn t = new TypeParser().parse(n).get(0);
//      ElementDefn el = definitions.getDefinedResources().get(t.getName());
//      if (el != null) {
//        JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(tmpResDir+t.getName()+".java"));
//        jgen.generate(el, definitions.getConceptDomains());
//        JavaParserGenerator jpgen = new JavaParserGenerator(new FileOutputStream(tmpResDir+t.getName()+"Parser.java"));
//        jpgen.setTypeNames(jgen.getTypeNames());
//        jpgen.generate(el, definitions.getConceptDomains());
//      } 
//    }
    
    jFactoryGen.generate();
//    jParserFactoryGen.generate();
    zipJavaFiles(javaDir, javaParserDir, dstDir);
    
  }

  private String getTitle(String n) {
    return n.substring(0,1).toUpperCase()+n.substring(1);
  }

  static final int BUFFER = 2048;

  private void zipJavaFiles(String javaDir, String javaParserDir, String dstDir) throws Exception {
    BufferedInputStream origin = null;
    FileOutputStream dest = new FileOutputStream(dstDir+"java.zip");
    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
    byte data[] = new byte[BUFFER];
    File f = new File(javaDir);
    String[] files = f.list();
    for (int i=0; i < files.length; i++) {
      if (files[i].endsWith(".java")) {
        FileInputStream fi = new FileInputStream(javaDir+files[i]);
        origin = new BufferedInputStream(fi, BUFFER);
        ZipEntry entry = new ZipEntry("model"+File.separator+files[i]);
        out.putNextEntry(entry);
        int count;
        while((count = origin.read(data, 0, BUFFER)) != -1) {
          out.write(data, 0, count);
        }
      }
    }

    f = new File(javaParserDir);
    files = f.list();
    for (int i=0; i < files.length; i++) {
      if (files[i].endsWith(".java")) {
        FileInputStream fi = new FileInputStream(javaParserDir+files[i]);
        origin = new BufferedInputStream(fi, BUFFER);
        ZipEntry entry = new ZipEntry("parser"+File.separator+files[i]);
        out.putNextEntry(entry);
        int count;
        while((count = origin.read(data, 0, BUFFER)) != -1) {
          out.write(data, 0, count);
        }
      }
    }
    out.close();

  }
  
}
