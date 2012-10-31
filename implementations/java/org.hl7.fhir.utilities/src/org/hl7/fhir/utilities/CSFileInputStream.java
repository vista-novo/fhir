package org.hl7.fhir.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CSFileInputStream extends FileInputStream {

  public CSFileInputStream(File arg0) throws FileNotFoundException {
    super(arg0);
    if (!(arg0 instanceof CSFile))
      throw new Error("Must use CSFile. used "+arg0.getClass().getName()+" for "+arg0.getAbsolutePath());
  }

  public CSFileInputStream(String arg0) throws FileNotFoundException {
    super(new CSFile(arg0));
  }

}
