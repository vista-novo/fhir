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
import java.util.List;
import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;



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
	

	
	// Some TypeRefs, like "*" are actually short-hands fo multiple TypeRefs: 
	// "*" will be expanded to pseudo-types Primitive | Composite | (NOT)Resource(Any)(NOT). Therefore,
	// although this method takes one single model.TypeRef, it can return
	// multiple eCore.TypeRefs.
	public static List<TypeRef> buildTypeRefsFromFhirModel( org.hl7.fhir.definitions.model.TypeRef original )
			throws Exception
	{
		List<TypeRef> result = new ArrayList<TypeRef>();
		List<org.hl7.fhir.definitions.model.TypeRef> expandedTypeRefs = expandMultiTypeRef(original);
		
		for( org.hl7.fhir.definitions.model.TypeRef ref : expandedTypeRefs )
		{
			TypeRef convertedType = FhirFactory.eINSTANCE.createTypeRef();
			
			if( ref.isElementReference() )
				convertedType.setName( ref.getResolvedTypeName() );
			else if( ref.isIdRef() )
				convertedType.setName( TypeRef.IDREF_PSEUDOTYPE_NAME );
			else
			{
				// Excel mentions "Resource", but this is actually a "ResourceReference"
				if( ref.isResourceReference() )
				{
					convertedType.setName(TypeRef.RESOURCEREF_TYPE_NAME);
					
					if( !ref.isAnyResource() )					
						convertedType.getResourceParams().addAll(ref.getParams());					
				}
				else
					convertedType.setName( ref.getName() );
			}
			
			result.add(convertedType);
		}
		
		return result;
	}
	
	
//	private static boolean checkIsPseudoType( TypeRef candidate )
//	{
//		return
//			candidate.getName().equals(TypeRef.PRIMITIVE_PSEUDOTYPE_NAME) ||
//			candidate.getName().equals(TypeRef.COMPOSITE_PSEUDOTYPE_NAME) ||
//			candidate.getName().equals(TypeRef.XHTML_PSEUDOTYPE_NAME) ||
//			candidate.getName().equals(TypeRef.IDREF_PSEUDOTYPE_NAME);
//	}
	
	
	private static List<org.hl7.fhir.definitions.model.TypeRef> 
			expandMultiTypeRef( org.hl7.fhir.definitions.model.TypeRef ref )
	{
		List<org.hl7.fhir.definitions.model.TypeRef> expandedTypeRefs = 
				new ArrayList<org.hl7.fhir.definitions.model.TypeRef>();
		
		if( ref.isWildcardType() )
		{
			// "*" becomes pseudo-types Primitive | Composite | Resource(Any)
			org.hl7.fhir.definitions.model.TypeRef primitivePseudoType = 
					new org.hl7.fhir.definitions.model.TypeRef();
			primitivePseudoType.setName( TypeRef.PRIMITIVE_PSEUDOTYPE_NAME );
			expandedTypeRefs.add(primitivePseudoType);
			
			org.hl7.fhir.definitions.model.TypeRef compositePseudoType = 
					new org.hl7.fhir.definitions.model.TypeRef();
			compositePseudoType.setName( TypeRef.COMPOSITE_PSEUDOTYPE_NAME );
			expandedTypeRefs.add(compositePseudoType);
			
			// Note: we use the type "Resource" here and not "ResourceRef"
			// since it is called "Resource" in the Excel. This type is
			// then mapped to the pseudotype "ResourceRef" pseudotype
			// in the next stages of processing.
			// IMPORTANT: Removed this, allowing Resource where we put *
			// gives confusing results, many times double inclusions.
			// So * is now Primitive | Composite
//			org.hl7.fhir.definitions.model.TypeRef resourceRefPseudoType = 
//					new org.hl7.fhir.definitions.model.TypeRef();
//			resourceRefPseudoType.setName( "Resource" );
//			resourceRefPseudoType.getParams().add( org.hl7.fhir.definitions.model.TypeRef.ANY_RESOURCE_GENERIC_ARG );
//			expandedTypeRefs.add(resourceRefPseudoType);
		}
//		else if( ref.isBoundGeneric() && ref.hasParams() &&
//					ref.getParams().size() > 1)
//		{
//			// TypeX(A|B|C) becomes TypeX(A) | TypeX(B) | TypeX(C)
//			for( String param : ref.getParams() )
//			{
//				org.hl7.fhir.definitions.model.TypeRef newRef = 
//						new org.hl7.fhir.definitions.model.TypeRef();
//
//				newRef.setName(ref.getName());
//				newRef.getParams().add(param);
//				
//				expandedTypeRefs.add(newRef);
//			}				
//		}
		else
		{
			// Do nothing
			expandedTypeRefs.add(ref);
		}
		
		return expandedTypeRefs;
	}


	public static List<TypeRef> buildTypeRefsFromFhirTypeName( String fhirTypeName ) throws Exception
	{	
		org.hl7.fhir.definitions.model.TypeRef oldRef = new org.hl7.fhir.definitions.model.TypeRef();
		oldRef.setName(fhirTypeName);
		
		return buildTypeRefsFromFhirModel(oldRef);
	}
}
