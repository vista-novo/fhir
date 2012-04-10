package org.hl7.fhir.tools.publisher;

import java.util.Date;

import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.utilities.Logger;

public interface PlatformGenerator {

  /**
   * @return The name of the generator - used to show progress in log reports - must be a valid java token, and a filename, all lowercase    
   */
  public String getName();

  /**
   * Formal name under which the implementation is shown in FHIR 
   * @return
   */
  public String getTitle();
  
  /**
   * @return a string description of what the reference implementation produces for an implementer, along with an estimate of status, and dependencies
   */
  public String getDescription();
  
  /**
   * Actually generate the reference implementation. The reference generator must generate a zip file [name].zip in the dst dir where
   * [name] is the name returned by getName(), and the zip file contains the contents of the reference implementation. The routine should 
   * throw an exception if the generation fails.
   * 
   * @param definitions - the logical definitions that are FHIR
   * @param destDir - the destination directory, where the .zip file is to go (has a path separator appended)
   * @param implDir - the folder in the /implementations directory in the FHIR subversion tree, if the generator wants to store stuff in subversion (has a path separator appended)
   * @param version - the version of FHIR that is being published
   * @param genDate - the official date of publication (the start of the build process)
   * @param logger - so that the generator can log issues/errors/progress to the same place as the overall build process
   */
  public void generate(Definitions definitions, String destDir, String implDir, String version, Date genDate, Logger logger)  throws Exception;

  
}
