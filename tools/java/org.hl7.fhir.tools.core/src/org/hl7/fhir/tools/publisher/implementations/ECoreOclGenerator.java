package org.hl7.fhir.tools.publisher.implementations;

import java.io.FileOutputStream;
import java.util.Date;

import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.utilities.Logger;

public class ECoreOclGenerator extends BaseGenerator implements PlatformGenerator {

  @Override
  public String getName() {
    return "ecore";
  }

  @Override
  public String getTitle() {
    return "ECore";
  }

  @Override
  public String getDescription() {
    return "Formal Object Definitions in OCLinECore text format - under development";
  }

  @Override
  public void generate(Definitions definitions, String destDir, String implDir, String version, Date genDate, Logger logger) throws Exception {
    new ECoreOclFormatGenerator(new FileOutputStream(implDir+"eCore.txt")).generate(definitions, version, genDate);

  }

}
