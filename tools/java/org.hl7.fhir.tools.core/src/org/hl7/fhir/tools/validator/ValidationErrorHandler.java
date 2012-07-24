package org.hl7.fhir.tools.validator;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidationErrorHandler implements ErrorHandler {

  private List<ValidationOutput> outputs;

  public ValidationErrorHandler(List<ValidationOutput> outputs) {
    this.outputs = outputs;
  }

  public void error(SAXParseException arg0) throws SAXException {
    ValidationOutput o = new ValidationOutput();
    o.setLevel(ValidationOutput.Strength.Error);
    o.setLocation("line "+Integer.toString(arg0.getLineNumber())+", column "+Integer.toString(arg0.getColumnNumber()));
    o.setMessage(arg0.getMessage());
    outputs.add(o);
  }

  public void fatalError(SAXParseException arg0) throws SAXException {
    ValidationOutput o = new ValidationOutput();
    o.setLevel(ValidationOutput.Strength.Fatal);
    o.setLocation("line "+Integer.toString(arg0.getLineNumber())+", column "+Integer.toString(arg0.getColumnNumber()));
    o.setMessage(arg0.getMessage());
    outputs.add(o);
  }

  public void warning(SAXParseException arg0) throws SAXException {
    ValidationOutput o = new ValidationOutput();
    o.setLevel(ValidationOutput.Strength.Warning);
    o.setLocation("line "+Integer.toString(arg0.getLineNumber())+", column "+Integer.toString(arg0.getColumnNumber()));
    o.setMessage(arg0.getMessage());
    outputs.add(o);
  }

}
