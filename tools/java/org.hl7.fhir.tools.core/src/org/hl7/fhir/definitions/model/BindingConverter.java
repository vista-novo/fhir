package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.BindingStrength;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;


public class BindingConverter 
{
	public static List<BindingDefn> buildBindingsFromFhirModel( Collection<org.hl7.fhir.definitions.model.BindingSpecification> bindings )
	{
		List<BindingDefn> result = new ArrayList<BindingDefn>();
		
	    for (org.hl7.fhir.definitions.model.BindingSpecification binding : bindings) 
	    {
	    	if( !binding.getName().equals("*unbound*") )
	    	{
	    		result.add(buildBindingFromFhirModel(binding));
	    	}
	    }
	    
	    return result;
	}
	
	public static BindingDefn buildBindingFromFhirModel( org.hl7.fhir.definitions.model.BindingSpecification spec )
	{
		BindingDefn result = FhirFactory.eINSTANCE.createBindingDefn();
		
		result.setId( Integer.parseInt( spec.getId() ) );
		result.setName( spec.getName() );
		result.setDescription( spec.getDescription() );
		result.setBinding( BindingType.get(spec.getBinding().ordinal()) );
		result.setStrength( BindingStrength.get(spec.getBindingStrength().ordinal()) );

		String artifact = spec.getReference();
		if( artifact != null && artifact.startsWith("#"))
			artifact = artifact.substring(1);
		
		result.setArtifactName( artifact );
		result.setDescription( spec.getDescription() );
		result.setSource( spec.getSource() );
		result.setDefinition( spec.getDefinition() );
	
		for( org.hl7.fhir.definitions.model.DefinedCode code : spec.getCodes() )
		{
			DefinedCode convertedCode = convertFromFhirDefinedCode( code );
			result.getCodes().add( convertedCode );
		}
		
		return result;
	}

	
	public static DefinedCode convertFromFhirDefinedCode( org.hl7.fhir.definitions.model.DefinedCode code) 
	{
		DefinedCode result = FhirFactory.eINSTANCE.createDefinedCode();
		
		result.setCode( code.getCode() );
		result.setDefinition( code.getDefinition() );
		result.setComment( code.getComment() );
		
		return  result;
	}
}
