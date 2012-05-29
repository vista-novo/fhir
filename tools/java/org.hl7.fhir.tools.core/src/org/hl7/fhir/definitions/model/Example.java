package org.hl7.fhir.definitions.model;

import java.io.File;

public class Example {
  private String name;
  private String description;
  private File path;
  public Example(String name, String description, File path) {
    super();
    this.name = name;
    this.description = description;
    this.path = path;
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
  
  
}
