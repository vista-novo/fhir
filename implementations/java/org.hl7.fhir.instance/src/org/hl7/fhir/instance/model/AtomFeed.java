package org.hl7.fhir.instance.model;

import java.util.ArrayList;
import java.util.List;

public class AtomFeed {
  private String id;
  private String title;
  private String link;
  private java.util.Date updated;

  private List<AtomEntry> entryList = new ArrayList<AtomEntry>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public java.util.Date getUpdated() {
    return updated;
  }

  public void setUpdated(java.util.Date updated) {
    this.updated = updated;
  }

  public List<AtomEntry> getEntryList() {
    return entryList;
  }
  
  
}
