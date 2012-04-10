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

public class JavaGenerator extends BaseGenerator implements PlatformGenerator {

  private String javaDir;
  private String javaParserDir;

  @Override
  public String getName() {
    return "java";
  }

  @Override
  public String getDescription() {
    return "Resource Definitions + parser (+ more todo). The java reference implementation depends on XmlPull and the Apache Commons Codec library.";
  }

  @Override
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
    zipFiles(implDir+"org.hl7.fhir.instance"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl, new String[] {"model", "formats"}, destDir+"java.zip");      
  }

  private String getTitle(String n) {
    return n.substring(0,1).toUpperCase()+n.substring(1);
  }

  @Override
  public String getTitle() {
    return "Java";
  }

}
