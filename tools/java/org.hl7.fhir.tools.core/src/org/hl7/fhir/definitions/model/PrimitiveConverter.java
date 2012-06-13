package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;
import org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn;


public class PrimitiveConverter 
{
	public static List<PrimitiveTypeDefn> buildPrimitiveTypesFromFhirModel( Collection<org.hl7.fhir.definitions.model.DefinedCode> primitives )
			throws Exception
	{
		List<PrimitiveTypeDefn> result = new ArrayList<PrimitiveTypeDefn>();
		
		for(org.hl7.fhir.definitions.model.DefinedCode primitive : primitives )
		{
			result.add(buildPrimitiveTypeFromFhirModel( primitive ) );
		}
		
		return result;
	}

	private static PrimitiveTypeDefn buildPrimitiveTypeFromFhirModel( org.hl7.fhir.definitions.model.DefinedCode primitive) 
			throws Exception
	{
		PrimitiveTypeDefn result = FhirFactory.eINSTANCE.createPrimitiveTypeDefn();
		
		result.setName( primitive.getCode() );
		result.setDefinition( primitive.getDefinition() );
		result.setComment( primitive.getComment() );
		
		if( primitive instanceof org.hl7.fhir.definitions.model.PrimitiveType )
		{
			result.setXsdtype( ((org.hl7.fhir.definitions.model.PrimitiveType)primitive).getSchemaType() );
			result.setPattern( null );
		}
		else if ( primitive instanceof org.hl7.fhir.definitions.model.DefinedStringPattern )
		{
			result.setXsdtype("string");
			result.setPattern( ((org.hl7.fhir.definitions.model.DefinedStringPattern)primitive).getRegex());
		}
		else
			throw new Exception( "Cannot build an eCore primitive type for unknown class " + primitive.getClass().getName() );

		return result;
	}
	
}
