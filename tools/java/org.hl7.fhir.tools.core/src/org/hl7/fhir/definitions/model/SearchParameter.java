package org.hl7.fhir.definitions.model;


public class SearchParameter {
  public enum SearchType {
    integer,  // search parameter must be a simple name 
    string,   // search parameter is a simple string, like a name part
    text,     // search parameter is into a long string - text filter
    date,     // search parameter is onto a date
    token,    // search parameter is on a fixed value string
    qtoken;   // search parameter is onto a pair of fixed value strings, space and value. Space is optional
  }
  private String code;
  private String description;
  private SearchType type;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public SearchType getType() {
    return type;
  }
  public void setType(SearchType type) {
    this.type = type;
  }
  public SearchParameter(String code, String description, SearchType type) {
    super();
    this.code = code;
    this.description = description;
    this.type = type;
  }  
  
}
