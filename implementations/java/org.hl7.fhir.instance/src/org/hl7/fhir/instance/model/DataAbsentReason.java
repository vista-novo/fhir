package org.hl7.fhir.instance.model;

public enum DataAbsentReason {
	unknown, //	The value is not known
	  asked, //		The source human does not know the value
	  temp, //		There is reason to expect (from the workflow) that the value may become known
	  notasked, //		The workflow didn't lead to this value being known
	masked, //	 	The information is not available due to security, privacy or related reasons
	unsupported, //	 	The source system wasn't capable of supporting this element
	astext, //	 	The content of the data is represented as text (see below)
	error; //	 	Some system or workflow process error means that the information is not available
	
	public static DataAbsentReason fromCode(String code) throws Exception {
		if (code == null || "".equals(code))
			return null;
		if ("unknown".equals(code))
			return unknown;
		if ("asked".equals(code))
			return asked;
		if ("temp".equals(code))
			return temp;
		if ("notasked".equals(code))
			return notasked;
		if ("masked".equals(code))
			return masked;
		if ("unknown".equals(code))
			return unknown;
		if ("unsupported".equals(code))
			return unsupported;
		if ("astext".equals(code))
			return astext;
		if ("error".equals(code))
			return error;
		throw new Exception("Unknown dataAbsentReason code '"+code+"'");
	}
	
	public String toCode() {
	  switch (this) {
	  case unknown: return "unknown";
	  case asked: return "asked";
	  case temp: return "temp";
	  case notasked: return "notasked";
	  case masked: return "masked";
	  case unsupported: return "unsupported";
	  case astext: return "astext";
	  case error: return "error";
	  default: return "?";
	  }
	}
}
