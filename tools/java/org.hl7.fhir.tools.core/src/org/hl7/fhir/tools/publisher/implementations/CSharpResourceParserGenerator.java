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

import java.util.Date;
import java.util.List;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;


public class CSharpResourceParserGenerator extends GenBlock
{
	private CSharpResourceGenerator rgen = new CSharpResourceGenerator();
	
	public GenBlock generateCompositeParser( CompositeTypeDefn composite, Definitions definitions ) throws Exception
	{
		begin();
		
		inc( rgen.header(definitions.getDate(), definitions.getVersion() ) );
		ln();
		ln("using HL7.Fhir.Instance.Model;");
		ln("using System.Xml;");
		ln();
		ln("namespace HL7.Fhir.Instance.Parsers");
		bs("{");
			ln("/*");
			ln("* Parser for " + composite.getName() + " instances");
			ln("*/");
			ln("public static partial class Xml" + composite.getName() + "Parser");
			bs("{");
				compositeParserFunction(composite);
			es("}");
		es("}");
		return end();
	}

	
	public GenBlock compositeParserFunction( CompositeTypeDefn composite ) throws Exception
	{
		begin();
		
		String returnType = GeneratorUtils.buildFullyScopedTypeName(composite,composite.getName());
				
		ln("public static ");
			nl( returnType );
			nl(" ");
			nl("parse" + composite.getName());
			nl("( XmlTextReader reader)");
		bs("{");		
			ln("string id;");
			ln( returnType );
				nl(" result = ");
				nl("new " + returnType + "();");
	
				// Generate this classes properties
				if( composite.getElements().size() > 0)
					memberProperties( composite.getElements(), composite );
	
				ln("");
				ln("return result;");
		es("}");
		ln();
	
		// Generate the nested local types in this scope
		if( composite.getLocalCompositeTypes().size() > 0)
		{
			for( CompositeTypeDefn subtype : composite.getLocalCompositeTypes() )
				compositeParserFunction( subtype ); 			
		}
		
		return end();
	}

	
	
	public GenBlock memberProperties( List<ElementDefn> elements, 
								CompositeTypeDefn context ) throws Exception
	{
		begin();
		
		for( ElementDefn member : elements )
		{			
			ln("// Parse element " + member.getElementPath());
			if( member.getMaxCardinality() == 1 && member.getTypes().size() == 1 &&
					Character.isLowerCase( member.getTypes().get(0).getName().charAt(0) ) )
			{
				TypeRef tref = member.getTypes().get(0);
				
				ln("if( reader.LocalName == ");
					nl("\"" + member.getName() + "\"");
					nl(" && reader.NamespaceURI == XmlUtil.FHIRNS)");
				ln("	result." + 
					GeneratorUtils.generateCSharpMemberName(member.getParentType(), member.getName()) );
					nl(" = XmlPrimitiveParser.");
					nl("Parse");
					
					if( GeneratorUtils.isCodeWithCodeList(member.getParentType(), tref) )
					{
						String enumType = 
						   GeneratorUtils.buildFullyScopedEnumName(context, tref.getBindingRef());
											
						nl("Code<" + enumType + ">");
					}
					else
					{
						nl(GeneratorUtils.mapPrimitiveToFhirCSharpType(tref.getName()));
					}
					nl("(reader, out id);");
				
				if( member.getMinCardinality() == 1 )
				{
					ln("else");
					ln("; // string error = XmlUtil.ParseError(reader, ");
						nl("\"Missing required element '" + member.getName() + "'\");");
				}
				
				ln();
			}
			
//			if( member.getMaxCardinality() == -1 )  nl("List<");		
//			if( member.isAllowDAR() ) nl("Absentable<");
//
//			// Determine the most appropriate FHIR type to use for this
//			// (possibly polymorphic) element.
//			TypeRef tref = GeneratorUtils.getMostSpecializedCommonBaseForElement(member);
//			
//			if( tref.getName().equals(TypeRef.IDREF_PSEUDOTYPE_NAME) )
//				nl("string");
//			else if( GeneratorUtils.isCodeWithCodeList( member.getParentType(), tref ) )
//			{
//				nl("Code<" + GeneratorUtils.generateCSharpTypeName(tref.getBindingRef()) + ">");
//				//isNullable = false;
//			}
//			else 
//			{
//				nl( GeneratorUtils.generateCSharpTypeName(tref.getName()) );
//				//isNullable = mapsToNullableFhirPrimitive(tref.getName());
//			}
//						
//			if( member.isAllowDAR() ) nl(">");
//			if( member.getMaxCardinality() == -1 ) nl(">");
//		
//			// All generated members should be nullable, to indicate whether
//			// the element has data or not. This means cardinality needs to be 
//			// checked by the validation routines and is not converted to
//			// a structural aspect here.
//			//if( !isNullable ) nl("?");
//			
//			nl( " " + GeneratorUtils.generateCSharpMemberName(context, member.getName()) );
//			nl(" { get; set; }");
//			ln();
		}
		
		return end();
	}
	
	
//	private boolean mapsToNullableFhirPrimitive( String name )
//	{
//		return !(name.equals("boolean") ||
//			name.equals("integer") ||
//			name.equals("decimal")); 
//	}
	
}
