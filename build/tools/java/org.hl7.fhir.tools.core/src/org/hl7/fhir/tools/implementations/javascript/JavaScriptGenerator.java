package org.hl7.fhir.tools.implementations.javascript;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.tools.implementations.BaseGenerator;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.utilities.Logger;

public class JavaScriptGenerator extends BaseGenerator implements PlatformGenerator {

  @Override
  public String getName() {
    return "javascript";
  }

  @Override
  public String getTitle() {
    return "JavaScript";
  }

  @Override
  public String getDescription() {
    return "Generates Mongoose models for FHIR resources";
  }

  @Override
  public boolean isECoreGenerator() {
    return false;
  }

  @Override
  public void generate(Definitions definitions, String destDir, String implDir, String version, Date genDate, Logger logger, String svnRevision)
      throws Exception {
    char separator = File.separatorChar;
    String baseDir = implDir + separator + "app";
    File modelDir = new File(baseDir + separator + "models");
    if (! modelDir.exists()) {
      modelDir.mkdirs();
    }
    Map<String, ResourceDefn> namesAndDefinitions = definitions.getResources();
    for (String name : namesAndDefinitions.keySet()) {
      ResourceDefn resourceDefinition = namesAndDefinitions.get(name);
      File modelFile = new File(modelDir.getPath() + separator + name + ".js");
      MongooseModel model = new MongooseModel(name, resourceDefinition, modelFile);
      model.generate();
    }
  }

  @Override
  public void generate(org.hl7.fhir.definitions.ecore.fhir.Definitions definitions, String destDir, String implDir, Logger logger) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean doesCompile() {
    return false;
  }

  @Override
  public boolean compile(String rootDir, List<String> errors) throws Exception {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean doesTest() {
    return false;
  }

  @Override
  public void loadAndSave(String rootDir, String sourceFile, String destFile) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public String checkFragments(String rootDir, String fragmentsXml) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}
