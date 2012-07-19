package org.hl7.fhir.tools.publisher.implementations;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.tools.ToolProvider;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.instance.formats.AtomComposer;
//import org.hl7.fhir.instance.formats.JsonComposer;
import org.hl7.fhir.instance.formats.XmlComposer;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.formats.XmlParserBase.ResourceOrFeed;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.tools.publisher.implementations.JavaResourceGenerator.JavaGenClass;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.ZipGenerator;

public class JavaGenerator extends BaseGenerator implements PlatformGenerator {

  private String javaDir;
  private String javaParserDir;
  private Definitions definitions;

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
    this.definitions = definitions;

    JavaFactoryGenerator jFactoryGen = new JavaFactoryGenerator(new FileOutputStream(javaDir+"ResourceFactory.java"));
    
    for (String n : definitions.getResources().keySet()) {
      ResourceDefn root = definitions.getResourceByName(n); 
      new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"))
      	.generate(root.getRoot(), definitions.getBindings(), JavaGenClass.Resource, null, genDate, version);
      jFactoryGen.registerResource(n,  root.getName());
    }

    for (ResourceDefn resource : definitions.getFutureResources().values()) {
      ElementDefn e = new ElementDefn();
      e.setName(resource.getName());
      new JavaResourceGenerator(new FileOutputStream(javaDir+e.getName()+".java"))
      	.generate(e, definitions.getBindings(), JavaGenClass.Resource, null, genDate, version);
      jFactoryGen.registerResource(resource.getName(),  e.getName());
    }

    for (String n : definitions.getInfrastructure().keySet()) {
      ElementDefn root = definitions.getInfrastructure().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getBindings(), JavaGenClass.Structure, null, genDate, version);
      jFactoryGen.registerType(n,  root.getName());
    }
    for (String n : definitions.getTypes().keySet()) {
      ElementDefn root = definitions.getTypes().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getBindings(), JavaGenClass.Type, null, genDate, version);
      if (root.typeCode().equals("GenericType")) {
        for (TypeRef td : definitions.getKnownTypes()) {
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
      jgen.generate(root, definitions.getBindings(), JavaGenClass.Constraint, cd, genDate, version);
      jFactoryGen.registerType(cd.getCode(), cd.getCode());      
    }
    
    for (String n : definitions.getStructures().keySet()) {
      ElementDefn root = definitions.getStructures().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getBindings(), JavaGenClass.Type, null, genDate, version);
      jFactoryGen.registerType(n,  root.getName());
    }


    
    JavaParserXmlGenerator jParserGen = new JavaParserXmlGenerator(new FileOutputStream(javaParserDir+"XmlParser.java"));
    jParserGen.generate(definitions, version, genDate);    
    JavaComposerXmlGenerator jComposerGen = new JavaComposerXmlGenerator(new FileOutputStream(javaParserDir+"XmlComposer.java"));
    jComposerGen.generate(definitions, version, genDate);    
    JavaComposerJsonGenerator jjComposerGen = new JavaComposerJsonGenerator(new FileOutputStream(javaParserDir+"JsonComposer.java"));
    jjComposerGen.generate(definitions, version, genDate);    
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

  public boolean isECoreGenerator() {
    return false;
  }

  public void generate(org.hl7.fhir.definitions.ecore.fhir.Definitions definitions, String destDir,
      String implDir, Logger logger) throws Exception {
    throw new UnsupportedOperationException("Java generator uses ElementDefn-style definitions.");	
  }

  public boolean doesCompile() {
    return ToolProvider.getSystemJavaCompiler() != null;
  }

  public boolean c(String name) {
    int r = ToolProvider.getSystemJavaCompiler().run(null, null, null, "C:\\workspace\\projects\\org.hl7.fhir\\implementations\\java\\org.hl7.fhir.instance\\src\\org\\hl7\\fhir\\instance\\model\\Type.java");
    return r == 0;
  }
  
  public boolean compile(List<String> errors) throws Exception {
    boolean ok = true;
    for (String n : definitions.getResources().keySet()) 
      ok = ok && c(javaDir+definitions.getResourceByName(n).getName()+".java");
    for (ResourceDefn resource : definitions.getFutureResources().values()) 
      ok = ok && c(javaDir+resource.getName()+".java");
    for (String n : definitions.getInfrastructure().keySet()) 
      ok = ok && c(javaDir+ definitions.getInfrastructure().get(n).getName()+".java");
    for (String n : definitions.getTypes().keySet()) 
      ok = ok && c(javaDir+ definitions.getTypes().get(n).getName()+".java");
    for (DefinedCode cd : definitions.getConstraints().values()) 
      ok = ok && c(javaDir+ cd.getCode()+".java");
    for (String n : definitions.getStructures().keySet()) 
      ok = ok && c(javaDir+ definitions.getStructures().get(n).getName()+".java");

    ok = ok && c(javaParserDir+"XmlParser.java");
    ok = ok && c(javaParserDir+"XmlComposer.java");
    ok = ok && c(javaDir+"ResourceFactory.java");
    
    return ok;
  }

  public boolean doesTest() {
    return true;
  }

  public void loadAndSave(String sourceFile, String destFile) throws Exception {
    // todo: what does it mean to load classes that have the same name as classes already in the build path?
    // for now, we use what's bound in, even though it runs a cycle behind

    FileInputStream in = new FileInputStream(sourceFile);
    XmlParser p = new XmlParser();
    ResourceOrFeed rf =  p.parseGeneral(in);
    if (rf.getFeed() != null)
      new AtomComposer().compose(new FileOutputStream(destFile), rf.getFeed(), true);
    else
      new XmlComposer().compose(new FileOutputStream(destFile), rf.getResource(), true);
    
//    if (rf.getFeed() != null)
//      new JsonComposer().compose(new FileOutputStream(sourceFile+".json"), rf.getFeed());
//    else
//      new JsonComposer().compose(new FileOutputStream(sourceFile+".json"), rf.getResource());
  }
}
