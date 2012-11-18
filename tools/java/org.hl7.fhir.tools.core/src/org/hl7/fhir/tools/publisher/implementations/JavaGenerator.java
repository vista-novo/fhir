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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.management.Attribute;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
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
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.ZipGenerator;

public class JavaGenerator extends BaseGenerator implements PlatformGenerator {

  private String rootDir;
  private String javaDir;
  private String javaParserDir;
  private Definitions definitions;
  private Logger logger;

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
    this.logger = logger;

    JavaFactoryGenerator jFactoryGen = new JavaFactoryGenerator(new FileOutputStream(javaDir+"ResourceFactory.java"));
    
    for (String n : definitions.getResources().keySet()) {
      ResourceDefn root = definitions.getResourceByName(n); 
      JavaResourceGenerator jrg = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jrg.generate(root.getRoot(), definitions.getBindings(), JavaGenClass.Resource, null, genDate, version);
      jrg.close();
      jFactoryGen.registerResource(n,  root.getName());
    }

    for (ResourceDefn resource : definitions.getFutureResources().values()) {
      ElementDefn e = new ElementDefn();
      e.setName(resource.getName());
      JavaResourceGenerator jrg = new JavaResourceGenerator(new FileOutputStream(javaDir+e.getName()+".java"));
      	jrg.generate(e, definitions.getBindings(), JavaGenClass.Resource, null, genDate, version);
      	jrg.close();
      jFactoryGen.registerResource(resource.getName(),  e.getName());
    }

    for (String n : definitions.getInfrastructure().keySet()) {
      ElementDefn root = definitions.getInfrastructure().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getBindings(), JavaGenClass.Structure, null, genDate, version);
      jgen.close();
      jFactoryGen.registerType(n,  root.getName());
    }
    for (String n : definitions.getTypes().keySet()) {
      ElementDefn root = definitions.getTypes().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getBindings(), JavaGenClass.Type, null, genDate, version);
      jgen.close();
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
      jgen.close();
    }
    
    for (String n : definitions.getStructures().keySet()) {
      ElementDefn root = definitions.getStructures().get(n); 
      JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
      jgen.generate(root, definitions.getBindings(), JavaGenClass.Type, null, genDate, version);
      jFactoryGen.registerType(n,  root.getName());
      jgen.close();
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
    jjComposerGen.close();
    jComposerGen.close();
    jParserGen.close();
    jFactoryGen.close();
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
	  char sc = File.separatorChar;

	  
	  
    int r = ToolProvider.getSystemJavaCompiler().run(null, null, null, rootDir+"implementations"+sc+"java"+sc+"org.hl7.fhir.instance"+sc+"src"+sc+"org"+sc+"hl7"+sc+"fhir"+sc+"instance"+sc+"model"+sc+"Type.java");
    return r == 0;
  }
  
  public boolean compile(String rootDir, List<String> errors) throws Exception {
    this.rootDir = rootDir;
    char sc = File.separatorChar;
    List<File> classes = new ArrayList<File>();

    for (String n : definitions.getResources().keySet()) 
      classes.add(new File(javaDir+definitions.getResourceByName(n).getName()+".java"));
    for (ResourceDefn resource : definitions.getFutureResources().values()) 
      classes.add(new File(javaDir+resource.getName()+".java"));
    for (String n : definitions.getInfrastructure().keySet()) 
      classes.add(new File(javaDir+ definitions.getInfrastructure().get(n).getName()+".java"));
    for (String n : definitions.getTypes().keySet()) 
      classes.add(new File(javaDir+ definitions.getTypes().get(n).getName()+".java"));
    for (DefinedCode cd : definitions.getConstraints().values()) 
      classes.add(new File(javaDir+ cd.getCode()+".java"));
    for (String n : definitions.getStructures().keySet()) 
      classes.add(new File(javaDir+ definitions.getStructures().get(n).getName()+".java"));

    classes.add(new File(javaParserDir+"XmlParser.java"));
    classes.add(new File(javaParserDir+"XmlComposer.java"));
    classes.add(new File(javaParserDir+"JsonComposer.java"));
    classes.add(new File(javaDir+"ResourceFactory.java"));

    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    
    Iterable<? extends JavaFileObject> units = fileManager.getJavaFileObjectsFromFiles(classes);
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
    JavaCompiler.CompilationTask task = ToolProvider.getSystemJavaCompiler().getTask(null, null, diagnostics, null, null, units);
    Boolean result = task.call();
    if (!result) {
      for (Diagnostic<? extends JavaFileObject> t : diagnostics.getDiagnostics()) {
        logger.log(t.toString());
      }
    }

    // now, we pack a jar with what we need for testing:
    Manifest manifest = new Manifest();
    manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
    manifest.getMainAttributes().put(Attributes.Name.CLASS_PATH, ".");
    manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, "org.hl7.fhir.instance.test.ToolsHelper");
    
    JarOutputStream jar = new JarOutputStream(new FileOutputStream(rootDir+File.separator+"publish"+File.separator+"org.hl7.fhir.tools.jar"), manifest);
    List<String> names = new ArrayList<String>();
    names.add("META-INF/");
    names.add("META-INF/MANIFEST.MF");
    AddJarToJar(jar, rootDir+"tools"+sc+"java"+sc+"imports"+sc+"xpp3-1.1.3.4.O.jar", names);
    AddJarToJar(jar, rootDir+"tools"+sc+"java"+sc+"imports"+sc+"commons-codec-1.3.jar", names);
    
    AddToJar(jar, new File(rootDir+"implementations"+sc+"java"+sc+"org.hl7.fhir.utilities"+sc+"bin"), (rootDir+"implementations"+sc+"java"+sc+"org.hl7.fhir.utilities"+sc+"bin"+sc+"").length(), names);
    // by adding source first, we add all the newly built classes, and these are not updated when the older stuff is included
    AddToJar(jar, new File(rootDir+"implementations"+sc+"java"+sc+"org.hl7.fhir.instance"+sc+"src"), (rootDir+"implementations"+sc+"java"+sc+"org.hl7.fhir.instance"+sc+"src"+sc+"").length(), names);
    AddToJar(jar, new File(rootDir+"tools"+sc+"java"+sc+"org.hl7.fhir.instance"+sc+"bin"), (rootDir+"tools"+sc+"java"+sc+"org.hl7.fhir.instance"+sc+"bin"+sc+"").length(), names);
    jar.close();
    
    return result;
  }

  
  private void AddJarToJar(JarOutputStream jar, String name, List<String> names) throws Exception {
    ZipInputStream zip = new ZipInputStream(new FileInputStream(name));
    ZipEntry ze = null;
    while ((ze = zip.getNextEntry()) != null) {
      String n = ze.getName();
      if (!names.contains(n)) {
        names.add(n);
        JarEntry jarAdd = new JarEntry(n);
        jarAdd.setTime(ze.getTime());
        jar.putNextEntry(jarAdd);
        for (int c = zip.read(); c != -1; c = zip.read()) {
          jar.write(c);
        }
      }
      zip.closeEntry();
    }
    zip.close();
  }


  private static int BUFFER_SIZE = 10240;
  private void AddToJar(JarOutputStream jar, File file, int rootLen, List<String> names) throws Exception {
    if (file.isDirectory()) {
      String name = file.getPath().replace("\\", "/");
      if (!name.isEmpty())
      {
        if (!name.endsWith("/"))
          name += "/";
        String n = name.substring(rootLen);
        if (n.length() > 0 && !names.contains(n)) {
          names.add(n);
          JarEntry entry = new JarEntry(n);
          entry.setTime(file.lastModified());
          jar.putNextEntry(entry);
          jar.closeEntry();
        }
      }
      for (File f: file.listFiles())
        if (f.getName().endsWith(".class") || f.getName().endsWith(".jar") || f.isDirectory())
          AddToJar(jar, f, rootLen, names);    
    } else {
      String n = file.getPath().substring(rootLen).replace("\\", "/");
      if (!names.contains(n)) {
        names.add(n);
        JarEntry jarAdd = new JarEntry(n);
        jarAdd.setTime(file.lastModified());
        jar.putNextEntry(jarAdd);

        // Write file to archive
        byte buffer[] = new byte[BUFFER_SIZE];
        FileInputStream in = new FileInputStream(file);
        while (true) {
          int nRead = in.read(buffer, 0, buffer.length);
          if (nRead <= 0)
            break;
          jar.write(buffer, 0, nRead);
        }
        in.close();
        jar.closeEntry();
      }
    }
  }

 
  public boolean doesTest() {
    return true;
  }

  public void loadAndSave(String rootDir, String sourceFile, String destFile) throws Exception {
    // execute the jar file javatest.jar
    // it will produce either the specified output file, or [output file].err with an exception
    // 
    File file = new File(destFile);
    if (file.exists())
      file.delete();
    file = new File(destFile+".err");
    if (file.exists())
      file.delete();
    
    List<String> command = new ArrayList<String>();
    command.add("java");
    command.add("-jar");
    command.add("org.hl7.fhir.tools.jar");
    command.add("round");
    command.add(sourceFile);
    command.add(destFile);

    ProcessBuilder builder = new ProcessBuilder(command);
    builder.directory(new File(rootDir));
//    String cp = System.getProperty("java.class.path");
//    cp += "C:\\workspace\\projects\\org.hl7.fhir\\tools\\java\\imports";
//    builder.environment().put()

    final Process process = builder.start();
    process.waitFor();
    if (new File(destFile+".err").exists())
      throw new Exception(TextFile.fileToString(destFile+".err"));
    if (!(new File(destFile).exists()))
        throw new Exception("Neither output nor error file created");
      
    
//    // todo: what does it mean to load classes that have the same name as classes already in the build path?
//    // for now, we use what's bound in, even though it runs a cycle behind
//    FileInputStream in = new CSFileInputStream(sourceFile);
//    XmlParser p = new XmlParser();
//    ResourceOrFeed rf =  p.parseGeneral(in);
//    if (rf.getFeed() != null)
//      new AtomComposer().compose(new FileOutputStream(destFile), rf.getFeed(), true);
//    else
//      new XmlComposer().compose(new FileOutputStream(destFile), rf.getResource(), true);
//    
//    if (rf.getFeed() != null)
//      new JsonComposer().compose(new FileOutputStream(sourceFile+".json"), rf.getFeed());
//    else
//      new JsonComposer().compose(new FileOutputStream(sourceFile+".json"), rf.getResource());
  }
}
