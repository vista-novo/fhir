package org.hl7.fhir.definitions.parsers.converters;

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
import java.util.Collection;
import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.BindingStrength;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;
import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.utilities.Utilities;



/*
 * "Old" Syntax for type declarations in Fhir
 * 
 * typeSpec = '@' elementreference | '[param]' | 'xhtml' | 'xml:ID' |
 * 			'Interval(' orderedType ')' | 'Resource(' resourceParams ')' | 
 * 			type('|' type)* | '*'
 * 
 * resourceParams = resourceType ('|' resourceType)* | Any 
 * type = primitiveType | dataType | structure
 * 
 * NB: mapping of primitive types is dependent on dataAbsenceAllowed. Is
 * allowed, then the primitives must be mapped to a subclass of Type,
 * otherwise to the corresponding C# primitive (or XsdDateTime).
 */

public class TypeRefConverter 
{
	public static List<TypeRef> buildTypeRefsFromFhirModel( 
						List<org.hl7.fhir.definitions.model.TypeRef> refs ) throws Exception
	{
		List<TypeRef> result = new ArrayList<TypeRef>();

		for( org.hl7.fhir.definitions.model.TypeRef ref : refs )
		{
			result.addAll( buildTypeRefsFromFhirModel(ref) );
		}
		
		return result;
	}
	
	public static List<TypeRef> buildTypeRefsFromFhirModel( org.hl7.fhir.definitions.model.TypeRef ref )
			throws Exception
	{
		List<TypeRef> result = new ArrayList<TypeRef>();
				
		if( ref.isElementReference() )
		{
			TypeRef singleType = FhirFactory.eINSTANCE.createTypeRef();
			singleType.setName( ref.getResolvedTypeName() );
			result.add(singleType);			
		}
		else if( ref.isUnboundGenericParam() );		
		else if( ref.isXhtml() );
		else if( ref.isXmlId() );
		else if( ref.isBoundGeneric() )
		{
			// What looks like a single type, might actually be multiple declarations
			// if the type has multiple possible bound arguments like Resource(A|B|C). This
			// becomes three separate typerefs, TypeX(A), TypeX(B), etc.
			for( String param : ref.getParams() )
			{
				TypeRef boundRefType = FhirFactory.eINSTANCE.createTypeRef();

				boundRefType.setName(ref.getName());
				
				if( param.equalsIgnoreCase("Any") )
				{
					if( ref.isResourceReference() )
						boundRefType.setIsAnyResource(true);
					else
						throw new Exception( "Cannot specify Any as an argument to generic type " 
									+ ref.getName() );
					
				}
				else
					boundRefType.getParam().add(param);
				
				result.add(boundRefType);
			}
		}
		else if( ref.isWildcardType() )
		{
			TypeRef wildcardType = FhirFactory.eINSTANCE.createTypeRef();
			wildcardType.setIsAnyDataType(true);
			result.add(wildcardType);
		}
		else
		{
			TypeRef singleType = FhirFactory.eINSTANCE.createTypeRef();
			singleType.setName( ref.getName() );
			result.add(singleType);
		}

		
//	else if( fhirTypeName.equals("Any") )
//		result.setIsAnyResource(true);
//	else
//		result.setName(fhirTypeName);
		
		return result;
	}
	
	
	public static List<TypeRef> buildTypeRefsFromFhirTypeName( String fhirTypeName ) throws Exception
	{	
		org.hl7.fhir.definitions.model.TypeRef oldRef = new org.hl7.fhir.definitions.model.TypeRef();
		oldRef.setName(fhirTypeName);
		
		return buildTypeRefsFromFhirModel(oldRef);
	}


}
