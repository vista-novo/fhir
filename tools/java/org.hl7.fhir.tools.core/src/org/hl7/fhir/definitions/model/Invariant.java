package org.hl7.fhir.definitions.model;

public class Invariant {

  private String name;
  private String context;
  private String english;
  private String ocl;
  private String xpath;
  
  private ElementDefn element;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

  public String getEnglish() {
    return english;
  }

  public void setEnglish(String english) {
    this.english = english;
  }

  public String getOcl() {
    return ocl;
  }

  public void setOcl(String ocl) {
    this.ocl = ocl;
  }

  public String getXpath() {
    return xpath;
  }

  public void setXpath(String xpath) {
    this.xpath = xpath;
  }

  public ElementDefn getElement() {
    return element;
  }

  public void setElement(ElementDefn element) {
    this.element = element;
  }
  
  
}
