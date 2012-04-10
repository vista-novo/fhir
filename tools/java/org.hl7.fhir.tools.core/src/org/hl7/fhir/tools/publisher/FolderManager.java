package org.hl7.fhir.tools.publisher;

import java.io.File;

public class FolderManager {

  
  /**
   * 
   */
  private char sl;
  
  public FolderManager(String root) {
    super();
    sl = File.separatorChar;
    rootDir = root+sl;
    srcDir = root+sl+"source"+sl;
    termDir = srcDir+"terminologies"+sl;
    dtDir = srcDir+"datatypes"+sl;
    imgDir = root+sl+"images"+sl;
    xsdDir = root+sl+"schema"+sl;
    tmpResDir = xsdDir+"datatypes"+sl;
    dstDir = root+sl+"publish"+sl;
    umlDir = root+sl+"uml"+sl;
//    javaDir       =  root+sl+"tools"+sl+"java"+sl+"org.hl7.fhir.tools.core"+sl+"src"+ sl+"org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"model"+sl;
//    javaParserDir =  root+sl+"tools"+sl+"java"+sl+"org.hl7.fhir.tools.core"+sl+"src"+sl+"org"+sl+"hl7"+sl+"fhir"+sl+"instance"+sl+"formats"+sl;
//    cSharpDir      = root+sl+"tools"+sl+"csharp"+sl+"FHIR"+sl+"FHIR"+sl;
//    delphiDir      = root+sl+"tools"+sl+"delphi"+sl;
  }
  
  public String srcDir;
  public String imgDir;
  public String xsdDir;
  public String dstDir;
  public String umlDir;
  public String rootDir;
  public String termDir;
  public String dtDir;
  public String tmpResDir;
  
  public String implDir(String name) {
    return rootDir+"implementations"+sl+name+sl;
  }
  
}