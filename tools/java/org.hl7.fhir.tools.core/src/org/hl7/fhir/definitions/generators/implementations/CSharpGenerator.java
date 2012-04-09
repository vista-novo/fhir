package org.hl7.fhir.definitions.generators.implementations;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.utilities.IniFile;

public class CSharpGenerator {

  static final int BUFFER = 2048;

  private void zipCSharpFiles(String cSharpDir, String dstDir) throws Exception {
    BufferedInputStream origin = null;
    FileOutputStream dest = new FileOutputStream(dstDir+"csharp.zip");
    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
    byte data[] = new byte[BUFFER];
    File f = new File(cSharpDir);
    String files[] = f.list();
    for (int i=0; i < files.length; i++) {
      if (files[i].endsWith(".cs")) {
        FileInputStream fi = new FileInputStream(cSharpDir+files[i]);
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

  public void generate(Definitions definitions, String cSharpDir, String dstDir, String version, String genDate) throws Exception {
    CSharpResourceGenerator cSharpGen = new CSharpResourceGenerator(new FileOutputStream(cSharpDir+"Resources.cs"));
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
    zipCSharpFiles(cSharpDir, dstDir);    
  }

}
