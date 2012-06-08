package org.hl7.fhir.instance.model;

public class ResourceReference extends Type {

  /**
   * The type of the resource
   */
  private String type;
  
	/**
	 * Id of the reference
	 */
	private String id;

	/**
	 * Specific version Id of resource referenced
	 */
	private String version;

	/**
	 * Text alternative for the resource
	 */
	private String text;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

	
}
