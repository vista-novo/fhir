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

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
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
		ln("using HL7.Fhir.Instance.Serializers;");
		ln();
		ln("namespace HL7.Fhir.Instance.Serializers");
		bs("{");		
			ln("/*");
			ln("* Starting point for serializing resources to JSON");
			ln("*/");
			ln("public static partial class JsonResourceSerializer");
			bs("{");
				resourceSerializer(definitions);
				ln();
				ln();
				compositeSerializer(definitions);
        		ln();
        		ln();
				dataSerializer(definitions);
			es("}");
		es("}");
	
		return end();
	}

	private void dataSerializer(Definitions definitions) throws Exception {
		ln("public static void SerializeData(IFhirWriter writer, Data type, bool asJsonObject=false)");
		bs("{");
			ln("if( typeof(Composite).IsAssignableFrom(type.GetType()) )");
			bs("{");
				ln("((Composite)type).ToJson(writer);");
				ln("return;");
			es("}");
			ln();
			generateSerializationCases(definitions.getPrimitives());
		es("}");
		ln();
		ln("public static void ToJson(this Data data, IFhirWriter writer, bool asJsonObject=false )");
		bs("{");
			ln("SerializeData(writer, data, asJsonObject);");
		es("}");
	}

	private void compositeSerializer(Definitions definitions) throws Exception {
		ln("public static void SerializeComposite(IFhirWriter writer, Composite type)");
		bs("{");
			List composites = new ArrayList();
			composites.addAll(definitions.getLocalCompositeTypes());
			composites.addAll(definitions.getLocalConstrainedTypes());
			generateSerializationCases(composites);
		es("}");
		ln("public static void ToJson(this Composite composite, IFhirWriter writer)");
		bs("{");
			ln("SerializeComposite(writer, composite);");
		es("}");
	}

	private void resourceSerializer(Definitions definitions) throws Exception {
		ln("public static void SerializeResource(IFhirWriter writer, Resource type)");
		bs("{");
			generateSerializationCases(definitions.getLocalResources());
		es("}");
		ln();
		ln("public static void ToJson(this Resource resource, IFhirWriter writer)");
		bs("{");
			ln("SerializeResource(writer, resource);");
		es("}");
	}
	
	private void generateSerializationCases(List<?> types) throws Exception
	{
		boolean firstTime = true;
		
		for( Object t : types)
		{
			TypeDefn type = (TypeDefn)t;
			
			if( firstTime )
				ln("if");
			else
				ln("else if");
			
			firstTime = false;
			String typeName = GeneratorUtils.buildFullyScopedTypeName(type);
			
			nl("(type.GetType() == typeof(");
				nl( typeName + "))");
			bs();
				ln("((" + typeName + ")type)");
				if( type.isPrimitive() )
					nl(".ToJson(writer,asJsonObject);");
				else
					nl(".ToJson(writer);");
			es();				
		}
		
		ln("else");
		bs();
			ln("throw new Exception(\"Encountered unknown type \" + ");
				nl("type.GetType().Name);");
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
		ln("using HL7.Fhir.Instance.Serializers;");
		
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
		
		ln("public static void ToJson(this ");
			nl(valueType);
			nl(" value, IFhirWriter writer)");
        bs("{");
            ln("Serialize" + composite.getName());
            	nl( "(writer, value);");
        es("}");
		ln();
		ln("public static void ");
			nl("Serialize" + composite.getName());
			nl("(IFhirWriter writer, ");
			nl(valueType);
			nl(" value)");
		bs("{");
			if( composite.isResource() )
			{
				// Resources, being top-level objects, have their
				// resource name as a single root member
				ln("writer.WriteStartRootObject(\"");
					nl(composite.getName());
					nl("\");");
			}
			ln("writer.WriteStartComplexContent();");	
			ln();
			
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
			
			ln("writer.WriteEndComplexContent();");
			
			if( composite.isResource() )
				ln("writer.WriteEndRootObject();");
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
			ln("// Serialize element " + member.getElementPath());	
			generateMemberSerializer(member);
		}
		         
		return end();
	}



	private boolean isResourceElement(ElementDefn element)
	{	
		CompositeTypeDefn parent = element.getParentType();
		
		// Elements that make up the contents of a resource are either 
		// direct children of a resource, or of a composite type nested
		// in a resource (=nested element groups, named or not)		
		if( parent.isResource() ) return true;
		
		if( !parent.isGloballyDefined() )
			return ((CompositeTypeDefn)parent.getContainingScope()).isResource();
			
		return false; 
	}

	private void generateMemberSerializer(ElementDefn member) throws Exception 
	{
		String propertyName = "value." + 
			GeneratorUtils.generateCSharpMemberName(member.getParentType(), member.getName());		
					
		if( member.isRepeating() )
		{
			ln("if(" + propertyName + " != null ");
				nl("&& " + propertyName + ".Count > 0)");
			bs("{");
				serializeRepeatingElement(member, propertyName);
			es("}");
		}
		else
		{		
			ln("if(" + propertyName + " != null)");
			bs("{");
				serializeSingleElement(member, propertyName);
			es("}");
		}			
					
		ln();
	}
	
	
	private void serializeRepeatingElement( ElementDefn member, String propertyName  ) throws Exception
	{	
		ln("writer.WriteStartArrayElement(");
			nl("\"" + member.getName() + "\"");
			nl(");");

		ln("foreach(var item in " + propertyName + ")");
		bs("{");
			ln("writer.WriteStartArrayMember(");
				nl("\"" + member.getName() + "\"");
				nl(");");
	
			buildSerializeStatement("item", member);
			
			ln("writer.WriteEndArrayMember();");
		es("}"); 
		
		ln("writer.WriteEndArrayElement();");
	}
	
	private void serializeSingleElement( ElementDefn member, String propertyName ) throws Exception
	{	
		ln("writer.WriteStartElement(");
			nl("\"" + member.getName() + "\"");
			nl(");");
												
		buildSerializeStatement(propertyName, member);
		
		ln("writer.WriteEndElement();");
	}


	private void buildSerializeStatement(String propertyName,
			ElementDefn member) throws Exception
	{
		TypeRef ref = GeneratorUtils.getMostSpecializedCommonBaseForElement(member);
		
		boolean isPrimitive = false;
		
		if( ref.getName() == TypeRef.PRIMITIVE_PSEUDOTYPE_NAME )
			isPrimitive = true;
		else if ( ref.getName() == TypeRef.DATA_PSEUDOTYPE_NAME )
			isPrimitive = true;
		else if( ref.getName() == TypeRef.COMPOSITE_PSEUDOTYPE_NAME )
			isPrimitive = false;
		else
		{
			TypeDefn defn = member.getParentType().resolveType(ref.getName());
			isPrimitive = defn.isPrimitive();
		}
	
		ln(propertyName);
		
		//Primitives inside datatypes cannot have id and/or 
		// dataAbsentReason so should be serialized as a simple value.
		if( isPrimitive && isResourceElement(member) )
			nl(".ToJson(writer,true);");
		else
		{
			nl(".ToJson(writer);");
		}
				
	}	
}
