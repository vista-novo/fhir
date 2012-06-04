package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

public class TypeRef {
	private String name;
	private List<String> params = new ArrayList<String>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getParams() {
		return params;
	}

	public boolean hasParams() {
		return params.size() > 0;
	}
	
	public boolean isUnboundGenericParam()
	{
		return name.equals("[param]");
	}
	
	public boolean isXmlId()
	{
		return name.equalsIgnoreCase("xml:ID");
	}

	public boolean isXhtml()
	{
		return name.equalsIgnoreCase("xhtml");
	}
	
	public boolean isWildcardType()
	{
		return name.equals("*");
	}
  
	public boolean isSpecialType()
	{
		return 	isXmlId() || 
				isXhtml() || 
				isUnboundGenericParam() || 
				isWildcardType() || 
				name.equals("Type") || 
				name.equals("GenericType") || 
				name.equals("Resource");
	}
	
	public String summary() {
	    String s = name;
	    if (hasParams()) {
	      s = s + "(";
	      for (String p : params)
	        s = s + p+',';
	      s = s.substring(0, s.length()-1)+')';
	    }
	    return s;
	}
  
	public String summaryFormal() {
    String s = name;
    if (hasParams()) {
      s = s + "(";
      for (String p : params)
        s = s + p+'|';
      s = s.substring(0, s.length()-1)+')';
    }
    return s;
  }
	
	public static boolean isFhirPrimitiveType(String tn)
	{
		return  tn.equals("boolean") || tn.equals("integer") ||
				tn.equals("decimal") || tn.equals("base64Binary") ||
				tn.equals("instant") || tn.equals("string") || tn.equals("uri") ||
				tn.equals("code") || tn.equals("oid") || tn.equals("uuid") ||
				tn.equals("sid") || tn.equals("id") || tn.equals("date") ||
				tn.equals("dateTime");
	}
}
