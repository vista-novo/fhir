package org.hl7.fhir.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

public class MyURIResolver implements URIResolver {

  private String path;
  
  
  public MyURIResolver(String path) {
    super();
    this.path = path;
  }


  @Override
  public Source resolve(String arg0, String arg1) throws TransformerException {
    try {
      return new StreamSource(new FileInputStream(arg0.contains(File.separator) ? arg0 : path+arg0));
    } catch (FileNotFoundException e) {
      throw new TransformerException(e);
    }
  }

}