package org.hl7.fhir.tools.publisher.implementations;

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

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
import org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ResourceDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;


public class CSharpJsonResourceSerializerGenerator extends GenBlock
{
	private CSharpModelResourceGenerator rgen = new CSharpModelResourceGenerator();

	public GenBlock generateResourceSerializer( Definitions definitions ) throws Exception
	{
		begin();
		
		inc( rgen.header(definitions.getDate(), definitions.getVersion() ) );
		ln();
		ln("using HL7.Fhir.Instance.Model;");
		ln("using System.Xml;");
		ln("using Newtonsoft.Json;");
		ln();
		ln("namespace HL7.Fhir.Instance.Serializers");
		bs("{");		
			ln("/*");
			ln("* Starting point for serializing resources to JSON");
			ln("*/");
			ln("public static partial class JsonResourceSerializer");
			bs("{");
				ln("public static void SerializeResource(JsonWriter writer)");
				bs("{");
					generateResourceCases(definitions.getLocalResources());
				es("}");
				ln();
			es("}");
		es("}");
	
		return end();
	}
	
	
	private void generateResourceCases(List<ResourceDefn> localResources)
	{
		boolean firstTime = true;
		
		for( ResourceDefn resource : localResources)
		{
			if( firstTime )
				ln("if");
			else
				ln("else if");
			
			firstTime = false;
			
			nl("(r.GetType() == typeof(");
				nl( resource.getName() + "))");
			bs();
				ln("Json" + resource.getName() + "Serializer");
					nl(".Parse" + resource.getName());
					nl("(writer);");
			es();				
		}
		
		ln("else");
		bs();
			ln("throw new Exception(\"Encountered unknown resource type \" + ");
				nl("r.GetType().Name");
		es();
	}


	public GenBlock generateCompositeSerializer( CompositeTypeDefn composite, Definitions definitions ) throws Exception
	{
		begin();
		
		inc( rgen.header(definitions.getDate(), definitions.getVersion() ) );
		ln();
		ln("using HL7.Fhir.Instance.Model;");
		ln("using System.Xml;");
		ln("using Newtonsoft.Json;");
		ln();
		ln("namespace HL7.Fhir.Instance.Serializers");
		bs("{");
			ln("/*");
			ln("* JSon serializer for " + composite.getName() + " instances");
			ln("*/");
			ln("public static partial class Json" + composite.getName() + "Serializer");
			bs("{");
				compositeSerializerFunction(composite);
			es("}");
		es("}");
	
		return end();
	}

	
	public GenBlock compositeSerializerFunction( CompositeTypeDefn composite ) throws Exception
	{
		begin();
				
		String valueType = GeneratorUtils.buildFullyScopedTypeName(composite);
				
		ln("public static void ");
			nl("Serialize" + composite.getName());
			nl("(JsonWriter writer, ");
			nl(valueType);
			nl(" value)");
		bs("{");
			ln("writer.WriteStartObject();");
			
			if( !composite.isResource() )
			{
				ln("// Serialize element's id/dar attributes");
				ln("JsonUtil.SerializeAttributes(writer, value);");
				ln();
			}
  		
			// Generate this classes properties
			if( composite.getElements().size() > 0)
			{
				generateMemberSerializers( composite.getElements() );
				ln();
			}
			
			ln("writer.WriteEndObject();");
		es("}");
		ln();
	
		// Generate the nested local types in this scope
		if( composite.getLocalCompositeTypes().size() > 0)
		{
			for( CompositeTypeDefn subtype : composite.getLocalCompositeTypes() )
				compositeSerializerFunction( subtype ); 			
		}
		
		return end();
	}

	
	public GenBlock generateMemberSerializers( List<ElementDefn> elements ) throws Exception
	{
		begin();
				
		for( ElementDefn member : elements )
		{			
			if( member.getTypes().size() > 1 ) continue;
			
			ln("// Serialize element " + member.getElementPath());	
			generateMemberSerializer(member);
		}
		         
		return end();
	}


	private void generateMemberSerializer(ElementDefn member) throws Exception 
	{
		// First determine the possible names of the properties in the
		// instance, which might be multiple because of polymorph elements 
		Map<String,TypeRef> possibleElementNames = 
			GeneratorUtils.determinePossibleElementNames(member.getParentType(),
				member.getName(), member.getTypes());

		String propertyName = "value." + 
			GeneratorUtils.generateCSharpMemberName(member.getParentType(), member.getName());		
			
		if( member.isRepeating() )
		{
			ln("if(" + propertyName + " != null ");
				nl("&& " + propertyName + ".Count > 0)");
			bs();
				serializeRepeatingElement(member, propertyName);
			es();
		}
		else
		{		
			ln("if(" + propertyName + " != null)");
			bs();
				serializeSingleElement(member, propertyName);
			es();
		}			
					
		ln();
	}
	
	
	private void serializeRepeatingElement( ElementDefn member, String propertyName  ) throws Exception
	{	
	}
	
	private void serializeSingleElement( ElementDefn member, String propertyName ) throws Exception
	{
		TypeRef ref = member.getTypes().get(0);
		CompositeTypeDefn composite = member.getParentType();
				
		TypeDefn typeToParse = composite.resolveType(ref.getName());
					
		if( typeToParse.isPrimitive() )
		{
			ln("JsonUtil.SerializePrimitiveElement(writer, ");
				nl(propertyName + ", ");			
				nl("\"" + member.getName() + "\"" );
				nl(");");			
		}
		else 
		{
			String parserName;
				
			if( composite.isGloballyDefined() )
				// A type defined on the global level, child of Definitions
				parserName = "Json" + composite.getName() + "Serializer";	
			else
				// 	A type defined inside a globally defined composite 
				parserName = "Json" + ((CompositeTypeDefn)composite.getScope()).getName() + "Serializer";
		
			ln(parserName);
				nl(".Serialize");
				nl(composite.getName());
				nl("(writer, ");
				nl(propertyName + ")");
		}
	}
	
	
	private String buildConstrainedParserCall(ConstrainedTypeDefn constrained) throws Exception
	{
		CompositeTypeDefn baseType = 
			((CompositeTypeDefn)constrained.getScope().resolveType(constrained.getBaseType().getName()));
		
		// Generate upcast to constrained type 
		String result = "(" + GeneratorUtils.buildFullyScopedTypeName(constrained) + ")"
				+ buildCompositeParserCall( baseType );
				
		return result;
	}
	
	
	private String buildCompositeParserCall(CompositeTypeDefn composite) throws Exception
	{		
		StringBuilder result = new StringBuilder();
		
		if( composite.isGloballyDefined() )
		{
			// A type defined on the global level, child of Definitions
			result.append("Xml" + composite.getName() + "Parser" );	
		}
		else
		{
			// A type defined inside a globally defined composite 
			result.append("Xml" + ((CompositeTypeDefn)composite.getScope()).getName() + "Parser");
		}

		result.append(".Parse" + composite.getName() );
		result.append("(reader, errors)");
		
		return result.toString(); 
	}
	

	private String buildEnumeratedCodeParserCall(NameScope scope, TypeRef ref) throws Exception
	{
		StringBuffer result = new StringBuffer();
		
		result.append("XmlPrimitiveParser.Parse");
		
		BindingDefn binding = scope.resolveBinding(ref.getBindingRef());
		String enumType = GeneratorUtils.buildFullyScopedEnumName(binding);
								
		result.append("Code<" + enumType + ">");
		result.append("(reader, errors)");
		
		return result.toString();
	}

	private String buildPrimitiveParserCall(PrimitiveTypeDefn primitive) throws Exception 
	{
		return "XmlPrimitiveParser.Parse" +
				GeneratorUtils.mapPrimitiveToFhirCSharpType(primitive.getName()) +
				"(reader, errors)";
	}
}
