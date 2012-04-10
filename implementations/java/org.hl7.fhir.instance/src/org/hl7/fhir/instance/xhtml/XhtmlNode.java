package org.hl7.fhir.instance.xhtml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XhtmlNode {

  private NodeType nodeType;
  private String name;
  private Map<String, String> Attributes = new HashMap<String, String>();
  public List<XhtmlNode> childNodes = new ArrayList<XhtmlNode>();
  public String content;



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
    this.content = content;
  }

  public XhtmlNode addTag(String name)
  {
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Element);
    node.setName(name);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addComment(String content)
  {
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Comment);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }

  public XhtmlNode addText(String content)
  {
    XhtmlNode node = new XhtmlNode();
    node.setNodeType(NodeType.Text);
    node.setContent(content);
    childNodes.add(node);
    return node;
  }

  public boolean allChildrenAreText()
  {
    boolean res = true;
    for (XhtmlNode n : childNodes)
      res = res && n.getNodeType() == NodeType.Text;
    return res;
  }

  public XhtmlNode Element(String name)
  {
    for (XhtmlNode n : childNodes)
      if (n.getName().equals(name)) 
        return n;
    return null;
  }

}
