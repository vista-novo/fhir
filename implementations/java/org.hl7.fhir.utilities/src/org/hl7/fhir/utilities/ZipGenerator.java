package org.hl7.fhir.utilities;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipGenerator {

  FileOutputStream dest;
  ZipOutputStream out;
  
  public ZipGenerator(String filename) throws Exception {
    dest = new FileOutputStream(filename);
    out = new ZipOutputStream(new BufferedOutputStream(dest));
  
  }

  public void close() throws Exception {
    out.close();
  }
  
  static final int BUFFER = 2048;

  public void addFiles(String actualDir, String statedDir, String ext) throws Exception {
    byte data[] = new byte[BUFFER];
    File f = new File(actualDir);
    String files[] = f.list();
    for (int i=0; i < files.length; i++) {
      if ((ext == null && new File(actualDir+files[i]).isFile()) || (ext != null && files[i].endsWith(ext))) {
        FileInputStream fi = new FileInputStream(actualDir+files[i]);
        BufferedInputStream origin = new BufferedInputStream(fi, BUFFER);
        ZipEntry entry = new ZipEntry(statedDir+files[i]);
        out.putNextEntry(entry);
        int count;
        while((count = origin.read(data, 0, BUFFER)) != -1) {
          out.write(data, 0, count);
        }
      }
    }
  }

  public void addFileSource(String path, String cnt) throws Exception {
    File tmp = File.createTempFile("tmp", ".tmp");
    TextFile.stringToFile(cnt, tmp.getAbsolutePath());
    addFileName(path, tmp.getAbsolutePath());
  }

  public void addFileName(String statedPath, String actualPath) throws Exception {
    byte data[] = new byte[BUFFER];
    FileInputStream fi = new FileInputStream(actualPath);
    BufferedInputStream origin = new BufferedInputStream(fi, BUFFER);
    ZipEntry entry = new ZipEntry(statedPath);
    out.putNextEntry(entry);
    int count;
    while((count = origin.read(data, 0, BUFFER)) != -1) {
      out.write(data, 0, count);
    }
  }
  
}
