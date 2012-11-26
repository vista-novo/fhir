package org.hl7.fhir.tools.publisher;

public class TocEntry {

  private String value;
  private String text;
  private String link;
  public TocEntry(String value, String text, String link) {
    super();
    this.value = value;
    this.text = text;
    this.link = link;
  }
  public String getValue() {
    return value;
  }
  public String getText() {
    return text;
  }
  public String getLink() {
    return link;
  }
  
  
}
