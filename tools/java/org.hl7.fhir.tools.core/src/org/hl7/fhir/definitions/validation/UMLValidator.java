package org.hl7.fhir.definitions.validation;
/*
Copyright (c) 2011-2012, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UMLValidator {

  private final class namespaceInfo implements NamespaceContext {
    public Iterator getPrefixes(String arg0) {
      return null;
    }

    public String getPrefix(String arg0) {
      return "UML";
    }

    public String getNamespaceURI(String arg0) {
      return "omg.org/UML1.3";
    }
  }

  private ElementDefn elementDefn; 
  private String filename; 
  private List<String> errors;
  private Document xdoc;
  private XPath xpath;

  public UMLValidator(ElementDefn elementDefn, String filename, List<String> errors) {
    this.elementDefn = elementDefn; 
    this.filename = filename;
    this.errors = errors;
  }

  public void validate() {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true); 
      DocumentBuilder builder = factory.newDocumentBuilder();
      xdoc = builder.parse(new CSFileInputStream(filename));
      XPathFactory xpfactory = XPathFactory.newInstance();
      xpath = xpfactory.newXPath();
      xpath = xpfactory.newXPath();

      xpath.setNamespaceContext(new namespaceInfo());
      Node src = (Node) xpath.evaluate("/XMI/XMI.header/XMI.documentation/XMI.exporter", xdoc, XPathConstants.NODE);
      condition("Enterprise Architect".equals(src.getTextContent()), "Unable to recognise UML source file");
      Element clss = (Element) xpath.evaluate("//UML:Class[@name='"+elementDefn.getName()+"']", xdoc, XPathConstants.NODE);
      if (condition(clss != null, "Unable to find UML Class definition for "+elementDefn.getName())) {
        // for this class, we also check that it has an inheritance relationship with "Resource"        
        NodeList gens = (NodeList) xpath.evaluate("//UML:Generalization", xdoc, XPathConstants.NODESET);
        if (condition(gens.getLength() > 0, "Unable to find specialisation relationship from Resource to "+elementDefn.getName()) && condition(gens.getLength() == 1, "Multiple Generalisation relationships found")) {
          Map<String, String> tags = readTags(gens.item(0));
          condition(tags.get("ea_sourceName").equals(elementDefn.getName()), "Generalization element does not start at the profile base");
          condition(tags.get("ea_targetName").equals("Resource"), "Generalization element does not point to Resource");
        }
        checkClassDefinition(clss, elementDefn, true);
      }
    } catch (Exception e) {
      errors.add("Resource "+ elementDefn.getName()+": "+e.getMessage());
    }
  }

//  private boolean xAttr(Node root, String xp, String attrName, String value, String message) throws Exception {
//    Node e = (Node) xpath.evaluate(xp, root, XPathConstants.NODE);
//    return condition(e!= null && value.equals(((Element)e).getAttribute(attrName)), message);   
//  }

  private Map<String, String> readTags(Node item) {
    Map<String, String> res = new HashMap<String, String>();
    Node n = item.getFirstChild();
    while (n != null) {
      if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals("UML:ModelElement.taggedValue")) {
        Node c = n.getFirstChild();
        while (c != null) {
          if (c.getNodeType() == Node.ELEMENT_NODE && c.getNodeName().equals("UML:TaggedValue")) {
            res.put(((Element) c).getAttribute("tag"), ((Element) c).getAttribute("value")); 
          }
          c = c.getNextSibling();
        }
      }
      n = n.getNextSibling();
    }
    return res;
  }

  private class PositionSorter implements Comparator<Element> {

    public int compare(Element o1, Element o2) {
      Map<String, String> tags1 = readTags(o1);
      Map<String, String> tags2 = readTags(o2);
      return Integer.valueOf(tags1.get("position")).compareTo(Integer.valueOf(tags2.get("position")));
    }
    
  }

  private void checkClassDefinition(Element clss, ElementDefn e, boolean root) throws Exception {
    condition(!"true".equals(clss.getAttribute("abstract")), "Resource Classes cannot be abstract");
    condition("public".equals(clss.getAttribute("visibility")), "Resource Classes must be public");
    
    if (e.usesCompositeType())
      return; // don't check this 
    
    Map<String, ElementDefn> allDefns = new HashMap<String, ElementDefn>();
    List<ElementDefn> attrDefns = new ArrayList<ElementDefn>();
    for (ElementDefn c : e.getElements()) 
      if (!root || !(c.getName().equals("id") || c.getName().equals("extension") || c.getName().equals("text"))) {
        allDefns.put(c.getName(), c);
        if (c.getElements().size() == 0)
        attrDefns.add(c);
      }
          
    String cn = clss.getAttribute("name");
    NodeList attrsUmlList = (NodeList) xpath.evaluate("//UML:Class[@name='"+cn+"']/UML:Classifier.feature/UML:Attribute", xdoc, XPathConstants.NODESET);
    List<Element> attrsUml = new ArrayList<Element>();
    for (int i = 0; i < attrsUmlList.getLength(); i++) 
      attrsUml.add((Element) attrsUmlList.item(i));
    Collections.sort(attrsUml, new PositionSorter());
    
    int x = 0;
    for (Element attrUML : attrsUml) {
      if (condition(allDefns.containsKey(attrUML.getAttribute("name")), "UML contains attribute "+cn+"."+attrUML.getAttribute("name")+" which is not in content model")) {
        Map<String, String> tags = readTags(attrUML);
        ElementDefn dO = attrDefns.size() > x ? attrDefns.get(x) : null;
        condition(dO != null && dO.getName().equals(attrUML.getAttribute("name")), "UML attribute "+cn+"."+attrUML.getAttribute("name")+" is out of order ("+Integer.toString(x)+")");
        checkAttribute(attrUML, tags, allDefns.get(attrUML.getAttribute("name")), cn);
        allDefns.remove(attrUML.getAttribute("name"));
      }      
      x++;
    }

    NodeList associations = (NodeList) xpath.evaluate("//UML:Association[UML:ModelElement.taggedValue[UML:TaggedValue[@tag='ea_targetName' and @value='"+cn+"']]]", xdoc, XPathConstants.NODESET);
    for (int i = 0; i < associations.getLength(); i++) {
      Element assocUML = (Element) associations.item(i);
      String n = getAssociationName(assocUML);
      if (condition(allDefns.containsKey(n), "UML contains association "+cn+"."+n+" which is not in content model")) {
        checkAssociation(assocUML, allDefns.get(n), cn, n);
        allDefns.remove(n);       
      }
      
    }
    
    for (String n : allDefns.keySet()) {
      condition(false, "UML attribute "+cn+"."+n+" missing");
    }
//    
//    for (ElementDefn c : e.getElements()) {
//      if (root && c.getName().equals("id")) {
//        // we don't expect to find this one 
//      } else if (c.getElements().size() == 0) {
//        Element ua = (Element) attrs.item(i);
//        if (condition(ua.getAttribute("name").equals(c.getName()), "Attibute names do not match on class "+clss.getAttribute("name")+"- expected '"+c.getName()+"', got '"+ua.getAttribute("name")+"'")) {
//          i++;
//        }
//      } else {
//        
//      }
//    }
//    
  
  }

  private void checkAssociation(Element assocUML, ElementDefn e, String cn, String an) throws Exception {
    Map<String, String> tags = readTags(assocUML);
    String targetClass = tags.get("ea_sourceName");
    
    checkAttr(assocUML, "visibility", "public", cn, an, "must be public");
    checkAttr(assocUML, "isAbstract", "false", cn, an, "must be not be abstract");
    checkTag(tags, "ea_type", "Aggregation", true, cn, an, "must be an aggregation");
    checkTag(tags, "direction", "Source -> Destination", true, cn, an, "direction is wrong");

    Element source = (Element) xpath.evaluate("UML:Association.connection/UML:AssociationEnd[UML:ModelElement.taggedValue/UML:TaggedValue/@value='source']", assocUML, XPathConstants.NODE);
    tags = readTags(source);
    checkAttr(source, "visibility", "public", cn, an, "must be public (source)");
    String card = e.getMinCardinality().toString()+".."+(e.getMaxCardinality() == null ? "*" : e.getMaxCardinality().toString());
//    if (card.equals("1..1"))
//      card = "1";
    checkAttr(source, "multiplicity", card, cn, an, "cardinality must be "+card+" but is "+source.getAttribute("multiplicity"));
    checkAttr(source, "aggregation", "none", cn, an, "must not be aggregated (source)");
    checkAttr(source, "isOrdered", "false", cn, an, "must not be ordered (source)"); // actually, it would be better if it were, but it litters the diagrams. for now, impose consistency
    checkAttr(source, "changeable", "none", cn, an, "must have changeable = none (source)");
    checkAttr(source, "targetScope", "instance", cn, an, "must have instance scope (source)");
    checkAttr(source, "isNavigable", "false", cn, an, "must not be navigable in reverse (source)");
    checkTag(tags, "containment", "Unspecified", true, cn, an, "containment must be unspecified (source)");
    
    Element target = (Element) xpath.evaluate("UML:Association.connection/UML:AssociationEnd[UML:ModelElement.taggedValue/UML:TaggedValue/@value='target']", assocUML, XPathConstants.NODE);
    tags = readTags(target);
    checkAttr(target, "visibility", "public", cn, an, "must be public (target)");
    checkAttr(target, "aggregation", "composite", cn, an, "must have aggregation = composite (target)");
    checkAttr(target, "isOrdered", "false", cn, an, "must not be ordered (target)");
    checkAttr(target, "changeable", "none", cn, an, "must have changeable = none (target)");
    checkAttr(target, "targetScope", "instance", cn, an, "must have instance scope (target)");
    checkAttr(target, "isNavigable", "true", cn, an, "must be navigable (target)");
    checkTag(tags, "containment", "Unspecified", true, cn, an, "containment must be unspecified (target)");

    Element clss = (Element) xpath.evaluate("//UML:Class[@name='"+targetClass+"']", xdoc, XPathConstants.NODE);
    if (condition(clss != null, "Unable to find class "+targetClass)) 
       checkClassDefinition(clss, e, false);    
  }

  private String getAssociationName(Element assocUML) throws Exception {
    Node node = (Node) xpath.evaluate("UML:Association.connection/UML:AssociationEnd[UML:ModelElement.taggedValue/UML:TaggedValue/@value='source']", assocUML, XPathConstants.NODE);
    if (node == null)
      return "";
    else 
      return ((Element) node).getAttribute("name");
  }

  private void checkAttribute(Element attrUML, Map<String, String> tags, ElementDefn e, String cn) {
    String an = attrUML.getAttribute("name");
    checkAttr(attrUML, "changeable", "none", cn, an, "must have changeable = none");
    checkAttr(attrUML, "visibility", "public", cn, an, "must have be public");
    checkAttr(attrUML, "ownerScope", "instance", cn, an, "must have instance scope");
    checkAttr(attrUML, "targetScope", "instance", cn, an, "must have instance scope");

    checkTag(tags, "type", e.typeCode(), true, cn, an, "type must be "+e.typeCode()+" but is "+tags.get("type"));
    checkTag(tags, "derived", "0", true, cn, an, "must not be derived");
    checkTag(tags, "length", "0", false, cn, an, "length must be 0"); 
    checkTag(tags, "ordered", "0", true, cn, an, "must not be ordered");
    checkTag(tags, "precision", "0", false, cn, an, "precision must be 0"); 
    checkTag(tags, "scale", "0", false, cn, an, "scale must be 0"); 
    checkTag(tags, "collection", "false", true, cn, an, "must not be a collection");
    checkTag(tags, "lowerBound", Integer.toString(e.getMinCardinality()), true, cn, an, "lowerBound must be "+Integer.toString(e.getMinCardinality()));

    if (e.getMaxCardinality() == null)
      checkTag(tags, "upperBound", "*", true, cn, an, "upperBound must be *");
    else
      checkTag(tags, "upperBound", e.getMaxCardinality().toString(), true, cn, an, "upperBound must be "+e.getMaxCardinality().toString());
    checkTag(tags, "duplicates", "0", true, cn, an, "duplicates must be 0");    
  }

 
  private void checkTag(Map<String, String> tags, String name, String value, boolean present, String className, String attrName, String msg) {
    boolean hasTag = tags.containsKey(name);
    if (hasTag)
      condition(value.equals(tags.get(name)), "UML attribute "+className+"."+attrName+" "+msg);
    else if (present)
      condition(value.equals(tags.get(name)), "UML attribute "+className+"."+attrName+" "+msg);    
  }

  private void checkAttr(Element elem, String name, String value, String className, String attrName, String msg) {
    condition(value.equals(elem.getAttribute(name)), "UML attribute "+className+"."+attrName+" "+msg);    
  }

  private boolean condition(boolean test, String message) {
    if (!test)
      errors.add("Resource "+ elementDefn.getName()+": "+message);
    return test;
    
  }

}
