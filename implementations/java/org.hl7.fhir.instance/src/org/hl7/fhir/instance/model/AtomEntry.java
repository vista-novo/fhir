package org.hl7.fhir.instance.model;

import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class AtomEntry {
  private String id;
  private String versionId;
  private String title;
  private String link;
  private String category;
  private String authorName;
  private String authorUri;
  private java.util.Date published;
  private java.util.Date updated;
  private Resource resource;
  private XhtmlNode summary;
  
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getVersionId() {
    return versionId;
  }
  public void setVersionId(String versionId) {
    this.versionId = versionId;
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
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getAuthorName() {
    return authorName;
  }
  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }
  public String getAuthorUri() {
    return authorUri;
  }
  public void setAuthorUri(String authorUri) {
    this.authorUri = authorUri;
  }
  public java.util.Date getPublished() {
    return published;
  }
  public void setPublished(java.util.Date published) {
    this.published = published;
  }
  public java.util.Date getUpdated() {
    return updated;
  }
  public void setUpdated(java.util.Date updated) {
    this.updated = updated;
  }
  public Resource getResource() {
    return resource;
  }
  public void setResource(Resource resource) {
    this.resource = resource;
  }
  public XhtmlNode getSummary() {
    return summary;
  }
  public void setSummary(XhtmlNode summary) {
    this.summary = summary;
  }
  
  
  
}
