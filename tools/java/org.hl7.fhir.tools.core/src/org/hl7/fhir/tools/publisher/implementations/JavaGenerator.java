package org.hl7.fhir.tools.publisher.implementations;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.tools.publisher.implementations.JavaResourceGenerator.JavaGenClass;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.ZipGenerator;

public class JavaGenerator extends BaseGenerator implements PlatformGenerator {

  private String javaDir;
  private String javaParserDir;

  public String getName() {
    return "java";
  }

  public String getDescription() {
    return "Resource Definitions + parser (+ more todo). The java reference implementation depends on XmlPull (http://www.xmlpull.org/) and the Apache Commons Codec library (http://commons.apache.org/codec/).";
  }

  public void generate(Definitions definitions, String destDir, String implDir, String version, Date genDate, Logger logger) throws Exception {
    char sl = File.separatorChar;
    javaDir       =  implDir+"org.hl7.fhir.instance"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"model"+sl;
    javaParserDir =  implDir+"org.hl7.fhir.instance"+sl+"src"+sl+"org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"formats"+sl;

    JavaFactoryGenerator jFactoryGen = new JavaFactoryGenerator(new FileOutputStream(javaDir+"ResourceFactory.java"));
    
    for (String n : definitions.getDefinedResources().keySet()) {
      ElementDefn root = definitions.getResourceDefn(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Resource, null, genDate, version);
      jFactoryGen.registerResource(n,  root.getName());
    }

    for (DefinedCode cd : definitions.getFutureResources().values()) {
      ElementDefn e = new ElementDefn();
      e.setName(cd.getCode());
      new JavaResourceGenerator(new FileOutputStream(javaDir+e.getName()+".java")).generate(e, definitions.getConceptDomains(), JavaGenClass.Resource, null, genDate, version);
      jFactoryGen.registerResource(cd.getCode(),  e.getName());
    }

    for (String n : definitions.getInfrastructure().keySet()) {
      ElementDefn root = definitions.getInfrastructure().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Structure, null, genDate, version);
      jFactoryGen.registerType(n,  root.getName());
    }
    for (String n : definitions.getTypes().keySet()) {
      ElementDefn root = definitions.getTypes().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Type, null, genDate, version);
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
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Constraint, cd, genDate, version);
      jFactoryGen.registerType(cd.getCode(), cd.getCode());      
    }
    
    for (String n : definitions.getStructures().keySet()) {
      ElementDefn root = definitions.getStructures().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getConceptDomains(), JavaGenClass.Type, null, genDate, version);
      jFactoryGen.registerType(n,  root.getName());
    }


    
    JavaParserXmlGenerator jParserGen = new JavaParserXmlGenerator(new FileOutputStream(javaParserDir+"XmlParser.java"));
    jParserGen.generate(definitions, version, genDate);    
    JavaComposerXmlGenerator jComposerGen = new JavaComposerXmlGenerator(new FileOutputStream(javaParserDir+"XmlComposer.java"));
    jComposerGen.generate(definitions, version, genDate);    
    jFactoryGen.generate(version, genDate);
    ZipGenerator zip = new ZipGenerator(destDir+"java.zip");
    zip.addFiles(implDir+"org.hl7.fhir.instance"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"model"+sl, "org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"model"+sl, ".java");
    zip.addFiles(implDir+"org.hl7.fhir.instance"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"formats"+sl, "org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"formats"+sl, ".java");
    zip.addFiles(implDir+"org.hl7.fhir.utilities"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"utilities"+sl, "org"+sl+"hl7"+sl+"fhir"+sl+"utilities"+sl, ".java");
    zip.addFiles(implDir+"org.hl7.fhir.utilities"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"utilities"+sl+"xhtml"+sl, "org"+sl+"hl7"+sl+"fhir"+sl+"utilities"+sl+"xhtml"+sl, ".java");
    zip.addFiles(implDir+"org.hl7.fhir.utilities"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"utilities"+sl+"xml"+sl, "org"+sl+"hl7"+sl+"fhir"+sl+"utilities"+sl+"xml"+sl, ".java");
    zip.close();
  }

  private String getTitle(String n) {
    return n.substring(0,1).toUpperCase()+n.substring(1);
  }

  public String getTitle() {
    return "Java";
  }

}
