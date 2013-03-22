package org.hl7.fhir.utilities.xml;

import org.w3c.dom.Element;

public interface XhtmlGeneratorAdorner {

  public class XhtmlGeneratorAdornerState {
    private String prefix;
    private String suffix;
    public XhtmlGeneratorAdornerState(String prefix, String suffix) {
      super();
      this.prefix = prefix;
      this.suffix = suffix;
    }
    public String getPrefix() {
      return prefix;
    }
    public String getSuffix() {
      return suffix;
    }
  }
  
  XhtmlGeneratorAdornerState getState(XhtmlGenerator ref, XhtmlGeneratorAdornerState state, Element node) throws Exception;
  XhtmlGeneratorAdornerState getAttributeMarkup(XhtmlGenerator xhtmlGenerator, XhtmlGeneratorAdornerState state, Element node, String nodeName, String textContent) throws Exception;

}

