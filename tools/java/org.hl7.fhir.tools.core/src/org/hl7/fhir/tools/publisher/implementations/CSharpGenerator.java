package org.hl7.fhir.tools.publisher.implementations;

import java.io.FileOutputStream;
import java.util.Date;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.ZipGenerator;

public class CSharpGenerator extends BaseGenerator implements PlatformGenerator {

  public void generate(Definitions definitions, String destDir, String implDir, String version, Date genDate, Logger logger) throws Exception {
    CSharpResourceGenerator cSharpGen = new CSharpResourceGenerator(new FileOutputStream(implDir+"Resources.cs"));
    cSharpGen.start();
    
    for (ElementDefn root : definitions.getDefinedResources().values()) {
      cSharpGen.generate(root, definitions.getConceptDomains());
    }
    for (DefinedCode n : definitions.getFutureResources().values()) {
      ElementDefn e = new ElementDefn();
      e.setName(n.getDefinition());
      cSharpGen.generate(e, definitions.getConceptDomains());
    }
    cSharpGen.finish();
    ZipGenerator zip = new ZipGenerator(destDir+"CSharp.zip");
    zip.addFiles(implDir, "", ".cs");
    zip.close();    
  }

  @Override
  public String getName() {
    return "csharp";
  }

  @Override
  public String getDescription() {
    return "Resource definitions (+ more todo)";
  }

  @Override
  public String getTitle() {
    return "C#";
  }


}
