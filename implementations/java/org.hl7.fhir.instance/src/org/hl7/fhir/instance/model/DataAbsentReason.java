package org.hl7.fhir.instance.model;
/*
Copyright (c) 2011-2012, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/

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
