package org.hl7.fhir.tools.validator;

import java.util.List;

/**
 * A service that will validate one or more FHIR resources against 
 * the specification
 * 
 * @author Grahame
 *
 */
public class Validator {

  public static void main(String[] args) throws Exception {
  }

  /**
   * The source (file name, folder name, url) of the FHIR source. This can be the 
   * fhir url, an alternative url of a local copy of the fhir spec, the name of 
   * a zip file containing the fhir spec, the name of a directory containing the
   * fhir spec 
   */
  private String source;
  
  /**
   * The name of the resource/feed to validate. this can a file name, a zip file, 
   * a url. If the source identifies a collection of resources and/or feeds, they
   * will all be validated
   */
  private String focus;
  
  /**
   * A list of output messages from the validator
   */
  private List<ValidationOutput> outputs;
  
  public void process() {
    // done...
  }
}
