package org.hl7.fhir.utilities.xhtml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XhtmlNode {

  public static final String NBSP = Character.toString((char)0xa0);
  
  private NodeType nodeType;
  private String name;
  private Map<String, String> Attributes = new HashMap<String, String>();
  private List<XhtmlNode> childNodes = new ArrayList<XhtmlNode>();
  private String content;


  public NodeType getNodeType() {
    return nodeType;
  }

  public void setNodeType(NodeType nodeType) {
    this.nodeType = nodeType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, String> getAttributes() {
    return Attributes;
  }

  public List<XhtmlNode> getChildNodes() {
    return childNodes;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    if (!(nodeType != NodeType.Text || nodeType != NodeType.Comment)) 
      throw new Error("Wrong node type");
    this.content = content;
  }

  public XhtmlNode addTag(String name)
  {

    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type. is "+nodeType.toString());
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Element);
    node.setName(name);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addTag(int index, String name)
  {

    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type. is "+nodeType.toString());
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Element);
    node.setName(name);
    childNodes.add(index, node);
    return node;
  }

  public XhtmlNode addComment(String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Comment);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addDocType(String content)
  {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.DocType);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addInstruction(String content)
  {
    if (!(nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Instruction);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }




  public XhtmlNode addText(String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (content == null)
      throw new Error("Content cannot be null");
    
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Text);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addText(int index, String content)
  {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (content == null)
      throw new Error("Content cannot be null");
    
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Text);
    node.setContent(content);
    childNodes.add(index, node);
    return node;
  }

  public boolean allChildrenAreText()
  {
    boolean res = true;
    for (XhtmlNode n : childNodes)
      res = res && n.getNodeType() == NodeType.Text;
    return res;
  }

  public XhtmlNode getElement(String name)
  {
    for (XhtmlNode n : childNodes)
      if (n.getNodeType() == NodeType.Element && name.equals(n.getName())) 
        return n;
    return null;
  }

  public String allText() {
    StringBuilder b = new StringBuilder();
    for (XhtmlNode n : childNodes)
      if (n.getNodeType() == NodeType.Text)
        b.append(n.getContent());
      else if (n.getNodeType() == NodeType.Element)
        b.append(n.allText());
    return b.toString();
  }

  public void attribute(String name, String value) {
    if (!(nodeType == NodeType.Element || nodeType == NodeType.Document)) 
      throw new Error("Wrong node type");
    if (name == null)
      throw new Error("name is null");
    if (value == null)
      throw new Error("value is null");
    Attributes.put(name, value);
  }
}
