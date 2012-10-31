package org.hl7.fhir.utilities;

import java.io.File;


public class CSFile extends File {

  /**
   * 
   */
  private static final long serialVersionUID = -2017155765132460726L;

  public CSFile(String pathname) {
    super(pathname);
    if (exists()) {
      String n = getName();
      File f = new File(getParent());
      String[] l = f.list();
      boolean ok = false;
      for (String n1 : l) {
        if (n1.equals(n))
          ok = true;
      }
      if (!ok)
        throw new Error("Case mismatch of file "+ pathname);
    }
  }

  
}
