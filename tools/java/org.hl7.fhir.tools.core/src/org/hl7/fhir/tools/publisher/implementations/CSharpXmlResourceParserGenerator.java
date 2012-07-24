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


public class CSharpXmlResourceParserGenerator extends GenBlock
{
	private CSharpModelResourceGenerator rgen = new CSharpModelResourceGenerator();

	public GenBlock generateResourceParser( Definitions definitions ) throws Exception
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
			ln("* Starting point for parsing resources");
			ln("*/");
			ln("public static partial class XmlResourceParser");
			bs("{");
				ln("public static Resource ParseResource(XmlReader reader, ErrorList errors)");
				bs("{");
					ln("try");
					bs("{");
						ln("reader.MoveToContent();");
						ln();
						generateResourceCases(definitions.getLocalResources());
					es("}");
					ln("catch( XmlException xe )");
					bs("{");
						ln("errors.Add( xe.Message, (IXmlLineInfo)reader);");
						ln("return null;");
					es("}");
				es("}");
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
			
			nl("( reader.NodeType == XmlNodeType.Element && reader.LocalName == \"");
				nl( resource.getName() );
				nl("\" && reader.NamespaceURI == Util.FHIRNS )");
			bs();
				ln("return Xml" + resource.getName() + "Parser");
					nl(".Parse" + resource.getName());
					nl("(reader, errors);");
			es();				
		}
		
		ln("else");
		bs("{");
			ln("errors.Add(String.Format(");
				nl("\"Encountered unrecognized resource '{0}'\",");
		        nl("	reader.LocalName), (IXmlLineInfo)reader);");
		    ln("return null;");
		es("}");
	}


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


	public GenBlock generateConstrainedParser( ConstrainedTypeDefn constrained, Definitions definitions ) throws Exception
	{
		CompositeTypeDefn baseType = 
				((CompositeTypeDefn)constrained.getScope().resolveType(constrained.getBaseType().getName()));

		begin();
		
		inc( rgen.header(definitions.getDate(), definitions.getVersion() ) );
		ln();
		ln("using HL7.Fhir.Instance.Model;");
		ln("using System.Xml;");
		ln();
		ln("namespace HL7.Fhir.Instance.Parsers");
		bs("{");
			ln("/*");
			ln("* Parser for constrained " + constrained.getName() + " instances");
			ln("*/");
			ln("public static partial class Xml" + constrained.getName() + "Parser");
			bs("{");	
				String returnType = GeneratorUtils.buildFullyScopedTypeName(constrained);
					
			ln("public static ");
				nl( returnType );
				nl(" ");
				nl("Parse" + constrained.getName());
				nl("(XmlReader reader, ErrorList errors, ");
				nl(returnType + " existingInstance = null )");
			bs("{");	
				ln( returnType );
					nl(" result = existingInstance != null ? existingInstance : ");
					nl("new " + returnType + "();");
					
					ln(buildCompositeParserCall(baseType, "result"));
						nl(";");
				
				ln("return result;");
			es("}");
			ln();		
			es("}");
		es("}");
	
		return end();
	}
	
	
	public GenBlock compositeParserFunction( CompositeTypeDefn composite ) throws Exception
	{
		begin();
		
		String returnType = GeneratorUtils.buildFullyScopedTypeName(composite);
				
		ln("public static ");
			nl( returnType );
			nl(" ");
			nl("Parse" + composite.getName());
			nl("(XmlReader reader, ErrorList errors, ");
			nl(returnType + " existingInstance = null )");
		bs("{");	
			ln( returnType );
				nl(" result = existingInstance != null ? existingInstance : ");
				nl("new " + returnType + "();");
				
			buildCompositeElementParser(composite);
			
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


	private void buildCompositeElementParser(CompositeTypeDefn composite)
			throws Exception {
		ln("string en = reader.LocalName;");
		ln("string ns = reader.NamespaceURI;");
		ln();
		if( !composite.isResource() )
		{
			ln("// Read id/dar from element's attributes");
		    ln("ElementContent attrs = XmlUtils.ParseElementContent(reader, errors);");
		    ln("if (attrs.Id != null) result.ReferralId = attrs.Id;");
		    ln("if (attrs.Dar.HasValue) result.Dar = attrs.Dar;");
			ln();
		}
  
		ln("// If this is an empty node, return immediately");
		ln("if (reader.IsEmptyElement) return result;");
		ln();
		ln("// Read starttag and start parsing");
		ln("reader.Read();");
		ln();
		
		// Generate this classes properties
		if( composite.getElements().size() > 0)
		{
			generateMemberParsers( composite.getElements() );
			ln();
		}
		ln("// Read endtag");
		ln("reader.Read();");
		ln();
	}

	
	
	public GenBlock generateMemberParsers( List<ElementDefn> elements ) throws Exception
	{
		begin();
				
		for( ElementDefn member : elements )
		{			
			ln("// Parse element " + member.getElementPath());	
			generateMemberParser(member);
		}
		
		ln("if( !XmlUtils.IsEndElement(reader,en,ns) )" );
        bs("{");
			ln("errors.Add(String.Format(");
				nl("\"Encountered unrecognized element '{0}' while parsing '{1}'\",");
                nl("	reader.LocalName, en), (IXmlLineInfo)reader);");
            ln("while (!XmlUtils.IsEndElement(reader, en, ns) || reader.EOF)");
            ln("	reader.Skip();");
            ln("result = null;");
		es("}");
	         
		return end();
	}


	private void generateMemberParser(ElementDefn member) throws Exception 
	{
		// First determine the possible names of the properties in the
		// instance, which might be multiple because of polymorph elements 
		Map<String,TypeRef> possibleElementNames = 
			GeneratorUtils.determinePossibleElementNames(member.getParentType(),
				member.getName(), member.getTypes());

		ln("if( " );		
		nl( buildCheckForElementClause(possibleElementNames.keySet()) );
		nl(" )");
		
		if( member.isRepeating() )
		{
			TypeRef resultType = GeneratorUtils.getMostSpecializedCommonBaseForElement(member);
			parseRepeatingElement(member.getParentType(), possibleElementNames,
					member.getName(), resultType );
		}
		else
			parseSingleElement(member.getParentType(), possibleElementNames, member.getName());			
					
		ln();
	}
	
	
	private String buildCheckForElementClause( Collection<String> possibleElementNames )
	{
		String clause = "reader.NodeType == XmlNodeType.Element && " +
							"reader.NamespaceURI == Util.FHIRNS && ";
		
		if( possibleElementNames.size() > 1 ) clause += "(";
		boolean firstClause = true;
		
		for( String name : possibleElementNames )
		{
			if( !firstClause ) clause += " || ";
			firstClause = false;
			
			clause += "reader.LocalName == \"" + name + "\"";
		}

		if( possibleElementNames.size() > 1 ) clause += ")";
		
		return clause;
	}

	private void parseRepeatingElement( CompositeTypeDefn scope, 
					Map<String,TypeRef> possibleElementNames,  
					String memberName, TypeRef resultType  ) throws Exception
	{

		String resultMember = "result." + 
				GeneratorUtils.generateCSharpMemberName(scope, memberName);
		
		bs("{");
			// Allocate an List in the property we are going to fill. 
			ln(resultMember);
				nl(" = ");
				nl("new List<");
//				if( allowDar ) nl("Absentable<");
					nl(GeneratorUtils.buildFullyScopedTypeName(scope,resultType));
//				if( allowDar ) nl(">");
					nl(">();");
			ln();
			ln("while( ");
				nl( buildCheckForElementClause(possibleElementNames.keySet()) );
				nl(" )");
			
			if( possibleElementNames.size() > 1 ) 
				bs("{");
			else
				bs();
	
			// Add the found element to the list.
			// Check for all posibilities in a polymorphic type,
			// or just grab the value when its not polymorphic.
			for( String name : possibleElementNames.keySet() )
			{
				if( possibleElementNames.size() > 1 )
				{
					ln("if( reader.LocalName == \"" + name + "\")" );
					bs();
				}
				ln(resultMember + ".Add(");
				nl( buildParserCall(scope, possibleElementNames.get(name)) );
				nl(");");
				if( possibleElementNames.size() > 1 )
				{
					es();
				}
			}
				
			if( possibleElementNames.size() > 1 ) 
				es("}");
			else
				es();
		es("}");
	}
	
	private void parseSingleElement( CompositeTypeDefn scope, Map<String,TypeRef> possibleElementNames,
					String memberName ) throws Exception
	{
		if( possibleElementNames.size() > 1 )
			bs("{");
			
		// Check for all posibilities in a polymorphic type,
		// or just grab the value when its not polymorphic.
		for( String name : possibleElementNames.keySet() )
		{
			if( possibleElementNames.size() > 1 )
			{
				ln("if( reader.LocalName == \"" + name + "\")" );
			}
			bs();
				ln("result." + 
					GeneratorUtils.generateCSharpMemberName(scope, memberName) );
				nl(" = ");
				nl( buildParserCall(scope, possibleElementNames.get(name)) );
				nl(";");
			es();
		}
		
		if( possibleElementNames.size() > 1 )
			es("}");
	}
	
	
	private String buildParserCall(NameScope resolver, TypeRef ref) throws Exception
	{
		TypeDefn typeToParse = resolver.resolveType(ref.getName());
				
		if( GeneratorUtils.isCodeWithCodeList(resolver, ref) )
			return buildEnumeratedCodeParserCall(resolver,ref);	
		else if( typeToParse.isPrimitive() )
			return buildPrimitiveParserCall((PrimitiveTypeDefn)typeToParse);
//		else if( typeToParse.isConstrained() )
//			return buildConstrainedParserCall((ConstrainedTypeDefn)typeToParse);
		else if( typeToParse.isComposite() || typeToParse.isConstrained() )
			return buildCompositeParserCall(typeToParse); 
		else
			throw new Exception( "Cannot handle category of type " + typeToParse.getName() + " to generate parser call." );
			
	}
	
	
//	private String buildConstrainedParserCall(ConstrainedTypeDefn constrained) throws Exception
//	{
//		CompositeTypeDefn baseType = 
//			((CompositeTypeDefn)constrained.getScope().resolveType(constrained.getBaseType().getName()));
//		
//		// Generate upcast to constrained type 
//		String result = "(" + GeneratorUtils.buildFullyScopedTypeName(constrained) + ")"
//				+ buildCompositeParserCall( baseType );
//				
//		return result;
//	}
	
	private String buildCompositeParserCall(TypeDefn composite) throws Exception
	{
		return buildCompositeParserCall(composite, null);
	}
	
	private String buildCompositeParserCall(TypeDefn composite, String existingInstanceName) throws Exception
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
		
		if( existingInstanceName == null )
			result.append("(reader, errors)");
		else
		{
			result.append("(reader, errors, ");
			result.append(existingInstanceName);
			result.append(")");
		}
		
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
