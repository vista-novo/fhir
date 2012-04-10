package org.hl7.fhir.tools.publisher.implementations;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class BaseGenerator {

  static final int BUFFER = 2048;

  public void zipFiles(String srcDir, String dstFilename) throws Exception {
    BufferedInputStream origin = null;
    FileOutputStream dest = new FileOutputStream(dstFilename);
    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
    byte data[] = new byte[BUFFER];
    File f = new File(srcDir);
    String files[] = f.list();
    for (int i=0; i < files.length; i++) {
      if (files[i].endsWith(".pas")) {
        FileInputStream fi = new FileInputStream(srcDir+files[i]);
        origin = new BufferedInputStream(fi, BUFFER);
        ZipEntry entry = new ZipEntry(files[i]);
        out.putNextEntry(entry);
        int count;
        while((count = origin.read(data, 0, BUFFER)) != -1) {
          out.write(data, 0, count);
        }
      }
    }
    out.close();
  }

  protected void zipFiles(String rootDir, String[] subdirs, String dstDir) throws Exception {
    BufferedInputStream origin = null;
    FileOutputStream dest = new FileOutputStream(dstDir+"java.zip");
    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
    byte data[] = new byte[BUFFER];
    
    for (String sub : subdirs) {
      File f = new File(rootDir+File.separator+sub+File.separator);
      String[] files = f.list();
      for (int i=0; i < files.length; i++) {
        if (files[i].endsWith(".java")) {
          FileInputStream fi = new FileInputStream(rootDir+File.separator+sub+File.separator+files[i]);
          origin = new BufferedInputStream(fi, BUFFER);
          ZipEntry entry = new ZipEntry(sub+File.separator+files[i]);
          out.putNextEntry(entry);
          int count;
          while((count = origin.read(data, 0, BUFFER)) != -1) {
            out.write(data, 0, count);
          }
        }
      }
    }

    out.close();

  }
  

}
