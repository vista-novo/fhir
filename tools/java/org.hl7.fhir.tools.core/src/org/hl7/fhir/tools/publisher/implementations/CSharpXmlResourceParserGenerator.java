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
import org.hl7.fhir.utilities.Utilities;


public class CSharpXmlResourceParserGenerator extends GenBlock
{
	private CSharpModelResourceGenerator rgen;

	private Definitions definitions;
	
	
	public Definitions getDefinitions() {
		return definitions;
	}


	public CSharpXmlResourceParserGenerator(Definitions defs)
	{
		definitions = defs;
		rgen = new CSharpModelResourceGenerator(defs);
	}

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
			ln("public static partial class ResourceParser");
			bs("{");
				ln("public static Resource ParseResource(IFhirReader reader, ErrorList errors)");
				bs("{");
					ln("try");
					bs("{");
						ln("reader.MoveToContent();");
						ln();
						generateResourceCases(definitions.getLocalResources());
					es("}");
					ln("catch( Exception xe )");
					bs("{");
						ln("errors.Add( xe.Message, reader);");
						ln("return null;");
					es("}");
				es("}");
				
			ln();
			ln();
			generateDataParser();
			ln();
			generateCompositeParser();
			ln();
			generatePrimitiveParser();					
			es("}");
		es("}");
	
		return end();
	}
	
	
	private GenBlock buildPolymorphParser(String polymorphTypeName, List composites) throws Exception {
		begin();
		
		ln("public static ");
			nl(polymorphTypeName);
			nl(" Parse");
			nl(polymorphTypeName);
			nl("(IFhirReader reader, ErrorList errors)");
		bs("{");							
			generatePolymorphCases(composites);
		es("}");
				
		return end();
	}
	

	private GenBlock generateDataParser() throws Exception
	{
		List composites = new ArrayList();
		composites.addAll(getDefinitions().getLocalCompositeTypes());
		composites.addAll(getDefinitions().getLocalConstrainedTypes());
		composites.addAll(getDefinitions().getPrimitives());

		return buildPolymorphParser("Data", composites);
	}


	private GenBlock generateCompositeParser() throws Exception
	{
		List composites = new ArrayList();
		composites.addAll(getDefinitions().getLocalCompositeTypes());
		composites.addAll(getDefinitions().getLocalConstrainedTypes());
	
		return buildPolymorphParser("Composite", composites);
	}

	private GenBlock generatePrimitiveParser() throws Exception
	{				
		return buildPolymorphParser("Primitive", getDefinitions().getPrimitives());
	}
	
	
	private void generatePolymorphCases(List<?> types) throws Exception
	{
		boolean firstTime = true;
		
		for( Object t : types )
		{
			TypeDefn type = (TypeDefn)t;
			
			if( firstTime )
				ln("if");
			else
				ln("else if");
			
			firstTime = false;
			
			nl("( XmlUtils.IsAtElementEndingWith(reader, \"");
				nl( Utilities.capitalize(type.getName()) );
				nl("\" ))");
			bs();
				ln("return ");
					nl( buildParserCall(type) );
					nl(";");
			es();				
		}
		
		ln("else");
		bs("{");
			ln("errors.Add(String.Format(");
				nl("\"Encountered unrecognized datatype '{0}'\",");
		        nl("	reader.CurrentElementName), reader);");
		    ln("return null;");
		es("}");
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
			
			nl("( XmlUtils.IsAtElement(reader, \"");
				nl( resource.getName() );
				nl("\" ) )");
			bs();
				ln("return " + resource.getName() + "Parser");
					nl(".Parse" + resource.getName());
					nl("(reader, errors);");
			es();				
		}
		
		ln("else");
		bs("{");
			ln("errors.Add(String.Format(");
				nl("\"Encountered unrecognized resource '{0}'\",");
		        nl("	reader.CurrentElementName), reader);");
		    ln("return null;");
		es("}");
	}


	public GenBlock generateConstrainedParser( ConstrainedTypeDefn constrained ) throws Exception
	{
		CompositeTypeDefn baseType = (CompositeTypeDefn)
				getDefinitions().findType(constrained.getBaseType().getFullName());

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
			ln("public static partial class " + constrained.getName() + "Parser");
			bs("{");	
				String returnType = GeneratorUtils.buildFullyScopedTypeName(constrained);
					
			ln("public static ");
				nl( returnType );
				nl(" ");
				nl("Parse" + constrained.getName());
				nl("(IFhirReader reader, ErrorList errors, ");
				nl(returnType + " existingInstance = null )");
			bs("{");	
				ln( returnType );
					nl(" result = existingInstance != null ? existingInstance : ");
					nl("new " + returnType + "();");
					
					ln(buildCompositeOrConstrainedParserCall(baseType, "result"));
						nl(";");
				
				ln("return result;");
			es("}");
			ln();		
			es("}");
		es("}");
	
		return end();
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
			ln("public static partial class " + composite.getName() + "Parser");
			bs("{");
				compositeParserFunction(composite);
			es("}");
		es("}");
	
		return end();
	}
	
	
	private GenBlock compositeParserFunction( CompositeTypeDefn composite ) throws Exception
	{
		begin();
		
		String returnType = GeneratorUtils.buildFullyScopedTypeName(composite);
				
		ln("public static ");
			nl( returnType );
			nl(" ");
			nl("Parse" + composite.getName());
			nl("(IFhirReader reader, ErrorList errors, ");
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
		ln("string en = reader.CurrentElementName;");
		ln();

        ln("// Read id/dar from element's attributes and read starttag");
        ln("string refId; string dar;");
        ln("bool hasContent = reader.ReadStartComplexContent(out refId, out dar);");
        if( !composite.isResource() )
        {
	        ln("result.ReferralId = refId;");
	        ln("result.Dar = (DataAbsentReason?)Code<DataAbsentReason>.Parse(dar);");
	    }
		ln();            
		ln("// If this is an empty (xml) node, return immediately");
        ln("if (!hasContent) return result;");
		ln();
  				
		// Generate this classes properties
		if( composite.getElements().size() > 0)
		{
			generateMemberParsers( composite.getElements() );
			ln();
		}
		ln("// Read endtag");
		ln("reader.ReadEndComplexContent();");
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
		
		ln("if( !XmlUtils.IsAtEndElement(reader, en) )" );
        bs("{");
			ln("errors.Add(String.Format(");
				nl("\"Encountered unrecognized element '{0}' while parsing '{1}'\",");
                nl("	reader.CurrentElementName, en), reader);");
            ln("reader.SkipContents(en);");
            ln("result = null;");
		es("}");
	         
		return end();
	}


	private void generateMemberParser(ElementDefn member) throws Exception 
	{
		// First determine the possible names of the properties in the
		// instance, which might be multiple because of polymorph elements 
		ln("if( " );		
		nl( buildCheckForElementClause(member,false) );
		nl(" )");
		
		if( member.isRepeating() )
			parseRepeatingElement(member);
		else
			parseSingleElement(member);			
					
		ln();
	}
	
	

	private void parseRepeatingElement(ElementDefn member) throws Exception
	{
		String resultMember = "result." + GeneratorUtils.generateCSharpMemberName(member);
		TypeRef resultType = GeneratorUtils.getMostSpecializedCommonBaseForElement(getDefinitions(),member);
		
		bs("{");
			// Allocate an List in the property we are going to fill. 
			ln(resultMember);
				nl(" = new List<");
				nl(GeneratorUtils.buildFullyScopedTypeName(resultType));
				nl(">();");
			ln("reader.ReadStartArray();");
			ln();
			ln("while( ");
				nl( buildCheckForElementClause(member,true) );
				nl(" )");
			
			bs();
				ln(resultMember + ".Add(");
					nl( buildParserCall(member) );
					nl(");");
			es();
			ln();
			ln("reader.ReadEndArray();");
		es("}");
	}
	
	
	private void parseSingleElement( ElementDefn member ) throws Exception
	{
		bs();
		ln("result." + GeneratorUtils.generateCSharpMemberName(member) );
			nl(" = ");
			nl( buildParserCall(member) );
			nl(";");
		es();
	}
	
	
	private String buildParserCall(TypeDefn def) throws Exception
	{
		if( def.isComposite() || def.isConstrained() )
			return buildCompositeOrConstrainedParserCall(def); 
		else if( def.isPrimitive() )
			return buildPrimitiveParserCall((PrimitiveTypeDefn)def);
		else
			throw new Exception( "Cannot handle category of type " + def.getName() + " to generate parser call." );
	}
	
	
	private String buildParserCall(ElementDefn member) throws Exception
	{
		TypeRef resultTypeRef = GeneratorUtils.getMostSpecializedCommonBaseForElement(getDefinitions(),member);
				
		// Check specials cases: parsing of enumerated codes and
		// polymorph properties of type Data, Composite or Primitive
		if( !member.isPolymorph() && GeneratorUtils.isCodeWithCodeList(getDefinitions(), member.getTypes().get(0)) )
			return buildEnumeratedCodeParserCall(member.getTypes().get(0));
		else if( resultTypeRef.getName().equals(TypeRef.PRIMITIVE_PSEUDOTYPE_NAME) ||
				resultTypeRef.getName().equals(TypeRef.COMPOSITE_PSEUDOTYPE_NAME) ||
				resultTypeRef.getName().equals(TypeRef.DATA_PSEUDOTYPE_NAME) )
			return buildPolymorphParserCall(resultTypeRef);

		TypeDefn resultType = getDefinitions().findType(resultTypeRef.getFullName());
		
		return buildParserCall(resultType);
	}
	
	private String buildCheckForElementClause( ElementDefn member, Boolean inArray )
	{
		String clause = null;
		
		// Check for exception: XHTML elements are in XHTML namespace
		if( !member.isPolymorph() && member.getTypes().get(0).getName().equals(TypeRef.XHTML_PSEUDOTYPE_NAME) )
			clause = "XmlUtils.IsAtXhtmlElement";
		else
		{
			if( !inArray  )
				clause = "XmlUtils.IsAtElement";
			else
				clause = "XmlUtils.IsAtArrayElement";
		}
		clause += "(reader, \"" + member.getName() + "\"";
					
		if( !member.isPolymorph() ) 
			clause += ")";
		else
			clause += ", true)";
		
		return clause;
	}
	
	
	private String buildCompositeOrConstrainedParserCall(TypeDefn type) throws Exception
	{
		return buildCompositeOrConstrainedParserCall(type, null);
	}
	
	private String buildCompositeOrConstrainedParserCall(TypeDefn type, String existingInstanceName) throws Exception
	{		
		StringBuilder result = new StringBuilder();
		
		if( type.isGloballyDefined() )
		{
			// A type defined on the global level, child of Definitions
			result.append(type.getName() + "Parser" );	
		}
		else
		{
			// A type defined inside a globally defined composite 
			result.append(((CompositeTypeDefn)type.getScope()).getName() + "Parser");
		}

		result.append(".Parse" + type.getName() );
		
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
	

	private String buildEnumeratedCodeParserCall(TypeRef ref) throws Exception
	{
		StringBuffer result = new StringBuffer();
		
		result.append("PrimitiveParser.Parse");
		
		BindingDefn binding = getDefinitions().findBinding(ref.getFullBindingRef());
		
		String enumType = GeneratorUtils.buildFullyScopedTypeName(binding.getFullName());
								
		result.append("Code<" + enumType + ">");
		result.append("(reader, errors)");
		
		return result.toString();
	}

	private String buildPrimitiveParserCall(PrimitiveTypeDefn primitive) throws Exception 
	{
		return "PrimitiveParser.Parse" +
				GeneratorUtils.mapPrimitiveToFhirCSharpType(primitive.getName()) +
				"(reader, errors)";
	}
	
	private String buildPolymorphParserCall(TypeRef type) throws Exception 
	{
		return "ResourceParser.Parse" +	type.getName() + "(reader, errors)";
	}
}
