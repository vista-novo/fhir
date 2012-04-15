package org.hl7.fhir.utilities.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.w3c.dom.Comment;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class XmlGenerator {


	private XMLWriter xml;
	
	public void generate(Element element, File file, String defaultNamespace, String elementName) throws Exception {
		
		OutputStream stream = new FileOutputStream(file);
		
		
		xml = new XMLWriter(stream, "UTF-8");
		xml.start();
		xml.setDefaultNamespace(defaultNamespace);

		xml.open(defaultNamespace, elementName);
		processContents(element);
		xml.close();
		xml.flush();
	}
	
	public void generate(Element element, File file) throws Exception {
		OutputStream stream = new FileOutputStream(file);
		
		xml = new XMLWriter(stream, "UTF-8");
		xml.start();
		xml.setDefaultNamespace(element.getNamespaceURI());
		processElement(element);
		xml.flush();
	}
	
	private void processContents(Element element) throws Exception {
		Node node = element.getFirstChild();
		while (node != null) {
			switch (node.getNodeType()) {
			case Node.ELEMENT_NODE:
				processElement((Element) node);
				break;
			case Node.TEXT_NODE:
				processText(node);
				break;
			case Node.COMMENT_NODE:
				processComment((Comment) node);
				break;
			default:
				throw new Exception("unhandled node type "+Integer.toString(node.getNodeType()));
			}
				
		    node = node.getNextSibling();
		}
	}
	
	private void processComment(Comment node) throws Exception {
		xml.comment(node.getNodeValue(), true);
	}

	private void processElement(Element element) throws Exception {
		if (!element.getNamespaceURI().equals(xml.getDefaultNamespace()))
			xml.setDefaultNamespace(element.getNamespaceURI());

		processAttributes(element);
		xml.open(element.getNamespaceURI(), element.getLocalName());
	
		processContents(element);
		
		xml.close();
	}

	private void processText(Node node) throws Exception {
		xml.text(node.getNodeValue());
	}

	private void processAttributes(Element element) throws Exception {
		NamedNodeMap nodes = element.getAttributes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node attr = nodes.item(i);
			if (attr.getNamespaceURI() != null) {
				//xml.namespace(attr.getNamespaceURI());
     			//xml.attribute(attr.getNamespaceURI(), attr.getLocalName(), attr.getNodeValue());
			} else 
     			xml.attribute(attr.getLocalName(), attr.getNodeValue());
		}
		
	}


}
