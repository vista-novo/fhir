package org.hl7.fhir.tools.publisher;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.Example;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.utilities.xml.XhtmlGeneratorAdorner;
import org.hl7.fhir.utilities.xml.XhtmlGenerator;
import org.w3c.dom.Element;

public class ExampleAdorner implements XhtmlGeneratorAdorner {

  
  public enum State {
    Unknown,
    Feed, 
    Element,
    Reference
  }

  private class ExampleAdornerState extends XhtmlGeneratorAdornerState {

    private State state;
    private ElementDefn definition;

    public ExampleAdornerState(State state, ElementDefn definition, String prefix, String suffix) {
      super(prefix, suffix);
      this.state = state;
      this.definition = definition;
    }

    public State getState() {
      return state;
    }

    public ElementDefn getDefinition() {
      return definition;
    }
    
    
    
  }
  private Definitions definitions;

  public ExampleAdorner(Definitions definitions) {
    this.definitions = definitions;
  }

  public XhtmlGeneratorAdornerState getState(XhtmlGenerator ref, XhtmlGeneratorAdornerState state, Element node) throws Exception {
    if (state == null) {
      if (node == null)
        return new ExampleAdornerState(State.Unknown, null, "", "");
      else if (node.getLocalName().equals("feed"))
        return new ExampleAdornerState(State.Feed, null, "", "");
      else if (definitions.hasResource(node.getLocalName()))
        return new ExampleAdornerState(State.Element, definitions.getResourceByName(node.getLocalName()).getRoot(), "", "");
      else 
        return new ExampleAdornerState(State.Unknown, null, "", "");
    } else {
      ExampleAdornerState s = (ExampleAdornerState) state;
      if (s.getState() == State.Feed) {
        if (definitions.hasResource(node.getLocalName()))
          return new ExampleAdornerState(State.Element, definitions.getResourceByName(node.getLocalName()).getRoot(), "", "");
        else if (node.getLocalName().equals("id") && !node.getTextContent().startsWith("http://"))
          return new ExampleAdornerState(State.Feed, null, "<a name=\""+node.getTextContent()+"\"></a>", "");
        else
          return new ExampleAdornerState(State.Feed, null, "", "");
      } else if (s.getState() == State.Element) {
        ElementDefn e = s.getDefinition().getElementByName(node.getLocalName());
        if (e == null)
          return new ExampleAdornerState(State.Unknown, null, "", "");
        if (!e.isBaseResourceElement() && e.typeCode().contains("Resource"))
          return new ExampleAdornerState(State.Reference, e, "", "");
        else 
          return new ExampleAdornerState(State.Element, e, "", "");
      } else if (s.getState() == State.Reference) {
        if (node.getLocalName().equals("type"))
          return new ExampleAdornerState(State.Reference, s.getDefinition(), "<a href=\""+node.getTextContent().toLowerCase()+".htm\">", "</a>");
        if (node.getLocalName().equals("id"))
        {
          String id = node.getTextContent();
          String type = XMLUtil.getNamedChild((Element) node.getParentNode(), "type").getTextContent();
          ResourceDefn r = definitions.getResourceByName(type);
          if (r == null) 
            throw new Exception("unable to find type "+type);
          for (Example e : r.getExamples()) {
            if (id.equals(e.getId()))
              return new ExampleAdornerState(State.Reference, s.getDefinition(), "<a href=\""+e.getFileTitle()+".xml.htm\">", "</a>");
            if (e.getXml().getDocumentElement().getLocalName().equals("feed")) {
              List<Element> entries = new ArrayList<Element>();
              XMLUtil.getNamedChildren(e.getXml().getDocumentElement(), "entry", entries);
              for (Element c : entries) {
                if (id.equals(XMLUtil.getNamedChild(c, "id").getTextContent()))
                  return new ExampleAdornerState(State.Reference, s.getDefinition(), "<a href=\""+e.getFileTitle()+".xml.htm#"+id+"\">", "</a>");
                }
              }
            }
          return new ExampleAdornerState(State.Reference, s.getDefinition(), "<font color=\"red\">", "</font>");
        }
        else
          return new ExampleAdornerState(State.Reference, s.getDefinition(), "", "");
      } else // if (s.getState() == State.Unknown) {
        return new ExampleAdornerState(State.Unknown, null, "", "");
    }
  }

}
