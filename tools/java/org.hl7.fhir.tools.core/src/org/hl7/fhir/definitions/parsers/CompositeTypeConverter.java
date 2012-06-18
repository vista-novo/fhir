package org.hl7.fhir.definitions.parsers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.Annotations;
import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingStrength;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;
import org.hl7.fhir.definitions.ecore.fhir.util.FhirAdapterFactory;
import org.hl7.fhir.utilities.Utilities;

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

public class CompositeTypeConverter
{
	public static List<CompositeTypeDefn> buildCompositeTypesFromFhirModel( 
			Collection<org.hl7.fhir.definitions.model.ElementDefn> types )
	{
		List<CompositeTypeDefn> result = new ArrayList<CompositeTypeDefn>();
		
	    for (org.hl7.fhir.definitions.model.ElementDefn type : types) 
	    {
	    	result.add( buildCompositeTypeFromFhirModel(type) );
	    }
	    
	    return result;
	}
	
	
	public static CompositeTypeDefn buildCompositeTypeFromFhirModel( 
			org.hl7.fhir.definitions.model.ElementDefn type )
	{
		CompositeTypeDefn result = FhirFactory.eINSTANCE.createCompositeTypeDefn();
		
		result.setName( type.getName() );
		
		Annotations ann = buildAnnotationsFromFhirElement(type);		
		result.setAnnotations( ann );

		result.getBindings().addAll( 
				BindingConverter.buildBindingsFromFhirModel( type.getNestedBindings().values() ));

		result.getInvariants().addAll( 
				buildInvariantsFromFhirModel( type.getInvariants().values() ) );
	
		for( String typeName : type.getAcceptableGenericTypes() )
			result.getAllowedGenericTypes().add( buildTypeRef(typeName) );
		
		result.getElements().addAll( buildElementDefnsFromFhirModel( type.getElements() ) );
		
		
		//TODO: Add type-local types from type.getNestedTypes() to new CompositeType
		
		return result;
	}


	private static Annotations buildAnnotationsFromFhirElement(
			org.hl7.fhir.definitions.model.ElementDefn type) {
		Annotations ann = FhirFactory.eINSTANCE.createAnnotations();
		ann.setShortDefinition( Utilities.cleanupTextString(type.getShortDefn()) );
		ann.setDefinition( Utilities.cleanupTextString(type.getDefinition()) );
		ann.setComment( Utilities.cleanupTextString(type.getComments()) );
		ann.setRequirements( Utilities.cleanupTextString(type.getRequirements()) );
		ann.setV2Mapping( Utilities.cleanupTextString(type.getV2Mapping()) );
		ann.setRimMapping( Utilities.cleanupTextString(type.getRimMapping()) );
		ann.setTodo( Utilities.cleanupTextString(type.getTodo()) );
		ann.setCommitteeNotes( Utilities.cleanupTextString(type.getCommitteeNotes()) );
		return ann;
	}
	


	public static List<ElementDefn> buildElementDefnsFromFhirModel(
			List<org.hl7.fhir.definitions.model.ElementDefn> elements) {

		List<ElementDefn> result = new ArrayList<ElementDefn>();
		
		for( org.hl7.fhir.definitions.model.ElementDefn element : elements )
			result.add( buildElementDefnFromFhirModel( element) );
		
		return result;
	}


	public static ElementDefn buildElementDefnFromFhirModel(
			org.hl7.fhir.definitions.model.ElementDefn element) {

		ElementDefn result = FhirFactory.eINSTANCE.createElementDefn();
		
		result.setName( element.getName() );
		Annotations ann = buildAnnotationsFromFhirElement(element);
		
		result.setAnnotation(ann);
		result.setAllowDAR( element.isAllowDAR() );
		result.setMustUnderstand( element.isMustUnderstand() );
		result.setMustSupport( element.isMustSupport() );
		
		
		result.setMinCardinality( element.getMinCardinality() );
		
		if( element.getMaxCardinality() != null )
			result.setMaxCardinality( element.getMaxCardinality() );
		else
			result.setMaxCardinality(-1);	// Adapt eCore convention for '*'
		
		
		if( !element.getElements().isEmpty() )
			result.getElements().addAll( buildElementDefnsFromFhirModel(element.getElements()));
		
		return result;
	}


	public static List<Invariant> buildInvariantsFromFhirModel( Collection<org.hl7.fhir.definitions.model.Invariant> invariants )
	{
		List<Invariant> result = new ArrayList<Invariant>();
		
		for( org.hl7.fhir.definitions.model.Invariant invariant : invariants )
			result.add( buildInvariantFromFhirModel(invariant) );
		
		return result;
	}


	public static Invariant buildInvariantFromFhirModel( org.hl7.fhir.definitions.model.Invariant invariant) {
		Invariant result = FhirFactory.eINSTANCE.createInvariant();
		
		// In the old model, Id was actually a short identifying name
		// and Name contained a short description.
		result.setName( invariant.getId() );
		result.setDescription( Utilities.cleanupTextString(invariant.getName()) );
		result.setHuman( Utilities.cleanupTextString(invariant.getEnglish()) );
		result.setOcl( Utilities.cleanupTextString(invariant.getOcl()) );
		result.setXpath( Utilities.cleanupTextString(invariant.getXpath()) );

		return result;
	}
	
	
	public static TypeRef buildTypeRef( String fhirTypeName )
	{
		TypeRef result = FhirFactory.eINSTANCE.createTypeRef();
		
		if( fhirTypeName.equals("*") )
			result.setIsAnyDataType(true);
		else if( fhirTypeName.equals("Any") )
			result.setIsAnyResource(true);
		else
			result.setName(fhirTypeName);
		
		return result;
	}

}
