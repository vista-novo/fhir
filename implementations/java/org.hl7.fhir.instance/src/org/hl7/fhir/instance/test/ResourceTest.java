package org.hl7.fhir.instance.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hl7.fhir.instance.formats.XmlComposer;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.model.Resource;

public class ResourceTest {

  private File source;

  public File getSource() {
    return source;
  }

  public void setSource(File source) {
    this.source = source;
  }
  
  public void test() throws Exception {
    
    XmlParser xml = new XmlParser();
    xml.setAllowUnknownContent(false);
    Resource resource = xml.parse(new FileInputStream(source));
    
    FileOutputStream out = new FileOutputStream(source.getAbsoluteFile()+".out.xml");
    XmlComposer xml1 = new XmlComposer();
    xml1.compose(out, resource, true);
    
  }
}
