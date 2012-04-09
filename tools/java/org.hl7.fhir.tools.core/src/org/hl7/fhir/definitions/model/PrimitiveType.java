package org.hl7.fhir.definitions.model;

public class PrimitiveType extends DefinedCode {

  private String schemaType;

  public PrimitiveType() {
    super();
  }

  public PrimitiveType(String code, String definition, String comment) {
    super(code, definition, comment);
  }

  public void setSchemaType(String value) {
    schemaType = value;
    
  }

  public String getSchemaType() {
    return schemaType;
  }

  
}
