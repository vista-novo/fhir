package org.hl7.fhir.tools.publisher.implementations;

import java.io.FileOutputStream;
import java.util.Date;

import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.ZipGenerator;

public class ECoreOclGenerator extends BaseGenerator implements PlatformGenerator {

  public String getName() {
    return "ecore";
  }

  public String getTitle() {
    return "ECore";
  }

  public String getDescription() {
    return "Formal Object Definitions in OCLinECore text format - under development";
  }

  public void generate(Definitions definitions, String destDir, String implDir, String version, Date genDate, Logger logger) throws Exception {
    new ECoreOclFormatGenerator(new FileOutputStream(implDir+"eCore.txt")).generate(definitions, version, genDate);

    ZipGenerator zip = new ZipGenerator(destDir+"ecore.zip");
    zip.addFiles(implDir, "", ".txt");
    zip.close();    
    
  }

}
