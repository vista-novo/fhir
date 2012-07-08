package org.hl7.fhir.utilities;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class TextStreamWriter extends OutputStreamWriter {

  public TextStreamWriter(OutputStream out) throws UnsupportedEncodingException {
    super(out, "UTF-8");
  }

  private String indent = "";
  
  protected void ln(String line) throws IOException {
    write(indent+line+"\r\n");
  }
  
  protected void ln_i(String line) throws IOException {
    ln(line);
    indent = indent + "  ";
  }
  
  protected void ln_o(String line) throws IOException {
    indent = indent.substring(0, indent.length()-2);
    ln(line);
  }
  
}
