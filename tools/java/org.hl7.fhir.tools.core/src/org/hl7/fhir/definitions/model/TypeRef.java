package org.hl7.fhir.definitions.model;

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
import java.util.ArrayList;
import java.util.List;



/*
 * Syntax for type declarations
 * 
 * typeSpec = '@' elementreference | '[param]' | 'xhtml' | 'xml:ID' |
 * 'Interval(' orderedType ')' | 'Resource(' resourceParams ')' | type
 * ('|' type)* | '*'
 * 
 * resourceParams = resourceType ('|' resourceType)* | Any type =
 * primitiveType | dataType | structure
 * 
 * NB: mapping of primitive types is dependent on dataAbsenceAllowed. Is
 * allowed, then the primitives must be mapped to a subclass of Type,
 * otherwise to the corresponding C# primitive (or XsdDateTime).
 */

public class TypeRef {
	private String name;
	private List<String> params = new ArrayList<String>();

	public TypeRef()
	{
	}
	
	public TypeRef(String name)
	{
		this.name = name;
	}
	
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

	
	private String resolvedTypeName;
	
	public String getResolvedTypeName()
	{
		return resolvedTypeName;
	}
	
	public void setResolvedTypeName(String value)
	{
		resolvedTypeName = value;
	}
	
	public boolean isUnboundGenericParam() {
		return name.equals("[param]");
	}

	public boolean isXmlId() {
		return name.equalsIgnoreCase("xml:ID");
	}

	public boolean isXhtml() {
		return name.equalsIgnoreCase("xhtml");
	}

	public boolean isWildcardType() {
		return name.equals("*");
	}
	
	public boolean isResourceReference()
	{
		return name.equals("Resource");
	}

	public boolean isElementReference()
	{
		return name.startsWith("@");
	}
	
	public boolean isBoundGeneric()
	{
		return params.size() > 0;
	}
	
	public boolean isAnyResource()
	{
		return  isResourceReference() && 
				hasParams() && 
				getParams().size() == 1 &&
				getParams().get(0).equals("Any");
	}
	
	public boolean isSpecialType() {
		return isXmlId() || isXhtml() || isUnboundGenericParam()
				|| isWildcardType() || name.equals("Type")
				|| name.equals("GenericType") || isResourceReference();
	}

	public String summary() {
		String s = name;
		if (hasParams()) {
			s = s + "(";
			for (String p : params)
				s = s + p + ',';
			s = s.substring(0, s.length() - 1) + ')';
		}
		return s;
	}

	public String summaryFormal() {
		String s = name;
		if (hasParams()) {
			s = s + "(";
			for (String p : params)
				s = s + p + '|';
			s = s.substring(0, s.length() - 1) + ')';
		}
		return s;
	}

	public static boolean isFhirPrimitiveType(String tn) {
		return tn.equals("boolean") || tn.equals("integer")
				|| tn.equals("decimal") || tn.equals("base64Binary")
				|| tn.equals("instant") || tn.equals("string")
				|| tn.equals("uri") || tn.equals("code") || tn.equals("oid")
				|| tn.equals("uuid") || tn.equals("sid") || tn.equals("id")
				|| tn.equals("date") || tn.equals("dateTime");
	}
}
