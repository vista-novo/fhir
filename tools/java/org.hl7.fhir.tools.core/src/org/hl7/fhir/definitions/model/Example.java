package org.hl7.fhir.definitions.model;

import java.io.File;

public class Example {
  private String name;
  private String description;
  private File path;
  private String xhtm;
  private String type;
  private boolean inBook;
  
  public Example(String name, String description, File path, String type, boolean inBook) {
    super();
    this.name = name;
    this.description = description;
    this.path = path;
    this.type = type;
    this.inBook = inBook;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public File getPath() {
    return path;
  }
  public void setPath(File path) {
    this.path = path;
  }
  public String getFileTitle() {
    String s = path.getName();
    return s.substring(0, s.indexOf("."));
  }
  public void setXhtm(String content) {
   xhtm = content;
    
  }
  public String getXhtm() {
    return xhtm;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public boolean isInBook() {
    return inBook;
  }
  public void setInBook(boolean inBook) {
    this.inBook = inBook;
  }
  
  
}
