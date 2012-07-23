package org.hl7.fhir.utilities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

public class ZipURIResolver implements URIResolver {

  private Map<String, byte[]> files;
  
  
  public ZipURIResolver(Map<String, byte[]> files) {
    super();
    this.files = files;
  }


  @Override
  public Source resolve(String arg0, String arg1) throws TransformerException {
    try {
      byte[] bs = files.get(arg0);
      return new StreamSource(new ByteArrayInputStream(bs));
    } catch (Exception e) {
      throw new TransformerException(e);
    }
  }

}