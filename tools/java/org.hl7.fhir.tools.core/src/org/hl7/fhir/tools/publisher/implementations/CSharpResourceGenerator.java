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
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;


public class CSharpResourceGenerator extends GenBlock
{
	public GenBlock generateComposite( CompositeTypeDefn composite, 
			Definitions definitions, 
			Map<ElementDefn, GeneratorUtils.NamedElementGroup> nestedElements )
	{
		begin();
		
		header(definitions.getDate(), definitions.getVersion());
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			compositeClass( composite, nestedElements ); 
		es("}");
		
		return end();
	}

	
	public GenBlock generateGlobalEnums( List<BindingDefn> globalEnums, 
			Definitions definitions )
	{
		begin();
		
		header(definitions.getDate(), definitions.getVersion());
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			enums(globalEnums); 
		es("}");
		
		return end();
	}

	

	public GenBlock generateConstrained( ConstrainedTypeDefn constrained, 
			Definitions definitions)
	{
		begin();
		
		header(definitions.getDate(), definitions.getVersion());
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			ln("/*");
			ln("* " +  constrained.getAnnotations().getDefinition());
			ln("*/");
			ln("public partial class " +  GeneratorUtils.generateCSharpTypeName(constrained.getName()) );
				nl(" : ");
				nl(GeneratorUtils.generateCSharpTypeName(constrained.getBaseType().getName()));
			bs("{");
				ln("// TODO: Add code to enforce these constraints:");
				for( Invariant inv : constrained.getDetails() ) 
					ln("// * " + inv.getHuman() );
			es("}");
		es("}");
				
		return end();
	}
	
	public GenBlock header(Date genDate, String version)
	{
		begin();
		
		ln("using System;");
		ln("using System.Collections.Generic;");
		ln("using HL7.Fhir.Instance.Support;");
		ln("using System.Xml.Linq;");
		ln();
		ln("/*");
		ln(Config.FULL_LICENSE_CODE);
		ln("*/");
		ln();
		ln("//");
		ln("// Generated on " + Config.DATE_FORMAT().format(genDate));
				nl(" for FHIR v" + version);
		ln("//");
		
		return end();
	}
	
	public GenBlock compositeClass( CompositeTypeDefn composite,
			Map<ElementDefn, GeneratorUtils.NamedElementGroup> nestedElements)
	{
		begin();
		
		ln("/*");
		ln("* " + composite.getAnnotations().getDefinition());
		ln("*/");
		
		// If this is a generic type, also generate an empty
		// base class which is not generic for the purpose of
		// polymorphic properties
		if( composite.isGenericType() )
			genericBaseClass(composite);

		// Generate the class itself		
		compositeClassHeader( composite );
		bs("{");		
			// Generate local bindings
			if( composite.getBindings().size() > 0)
				enums( composite.getBindings() );
		
			// Generate the nested local types in this scope
			if( composite.getLocalCompositeTypes().size() > 0)
				nestedLocalTypes( composite.getLocalCompositeTypes(), nestedElements ); 
		
			// Generate the nested types that correspond to anonymous
			// nested blocks (Elements with children).
			if( nestedElements != null && nestedElements.values().size() > 0 )
				nestedComponents( nestedElements.values(), nestedElements, composite );
		
			// Generate this classes properties
			if( composite.getElements().size() > 0)
				memberProperties( composite.getElements(), nestedElements, composite  );	
		es("}");
		ln();
		
		return end();
	}

	
	public GenBlock memberProperties( List<ElementDefn> elements, Map<ElementDefn, GeneratorUtils.NamedElementGroup> nestedElements,
					CompositeTypeDefn context )
	{
		begin();
		
		for( ElementDefn member : elements )
		{
			ln("// " + member.getAnnotation().getShortDefinition());
			ln("public ");
			if( member.getMaxCardinality() == -1 ) nl("List<");
			if( member.isAllowDAR() ) nl("Absentable<");
			
			if( nestedElements.containsKey(member) ) 
				nl(nestedElements.get(member).getName());
			else if( member.getTypes().size() == 1 && member.getTypes().get(0).isUnboundGeneric() ) 
				nl("T");
			else if( member.isXhtmlElement() ) 
				nl("XDocument");
			else if( member.isXmlIdElement() ) 
				nl("string");
			else if( member.isBoundCode() ) 
			{
				BindingDefn binding = member.getParentType()
						.resolveBinding(member.getBinding().getName());
				
				if( binding != null &&  binding.getBinding() == BindingType.CODE_LIST )
					nl("Code<" + GeneratorUtils.generateCSharpTypeName(binding.getName()) + ">");
				else 
					nl("Code");
			} 
			else if( member.getTypes().size() == 1 ) 
			{
				nl( GeneratorUtils.generateCSharpTypeName(member.getTypes().get(0).getName()) );
				if( member.getTypes().get(0).isGenericTypeRef() ) 
				{ 
					nl("<");
					nl(GeneratorUtils.generateCSharpTypeName(member.getTypes().get(0).getBoundParam()));
					nl(">");
				}	
			} 
			else 
			{
				nl(GeneratorUtils.generateCSharpTypeName(
						GeneratorUtils.getMostSpecializedCommonBaseForElement(member).getName()));
			}

			if( member.isAllowDAR() ) nl(">");
			if( member.getMaxCardinality() == -1 ) nl(">");
			
			nl( " " + GeneratorUtils.generateCSharpMemberName(context, member.getName()) );
			nl(" { get; set; }");
			ln();
		}
		
		return end();
	}
	
	private void nestedLocalTypes( List<CompositeTypeDefn> nestedTypes, 
			Map<ElementDefn, GeneratorUtils.NamedElementGroup> nestedElements)
	{
		begin();

		for( CompositeTypeDefn nested : nestedTypes )
		{
			compositeClass( nested, nestedElements );
			ln();
		}
		
		end();
	}
	
	private void nestedComponents( Collection<GeneratorUtils.NamedElementGroup> nestedGroups,
			Map<ElementDefn, GeneratorUtils.NamedElementGroup> nestedElements,
						CompositeTypeDefn composite ) 
	{
		begin();

		for( GeneratorUtils.NamedElementGroup group : nestedGroups )
		{
			ln("public class " +
					GeneratorUtils.generateCSharpTypeName(group.getName()) );
			bs("{");
				memberProperties( group.getElements(), nestedElements, composite  );
			es("}");
			ln();
		}
			
		end();
	}
		
	
	public GenBlock genericBaseClass( CompositeTypeDefn genericType )
	{
		begin();
		
		ln("public partial class " + genericType.getName() + "{ }");
		
		return end();
	}
	
	private void compositeClassHeader(CompositeTypeDefn composite)
	{
		ln( "public partial class " +
				GeneratorUtils.generateCSharpTypeName(composite.getName()) );
		
		// Optionally, add generic parameter
		if( composite.isGenericType() ) nl("<T>");
		
		// Derive from appropriate baseclass
		nl(" : ");
		
		if( composite.isGenericType() ) 
			nl( composite.getName() );
		else if( composite.isResource() ) 
			nl( "Resource" );
		else if( composite.isComposite() ) 
			nl( "Composite" );
	}
	
	public GenBlock enums( List<BindingDefn> bindings )
	{
		begin();
		
		for( BindingDefn binding : bindings ) 
		{
			if( binding.getBinding() == BindingType.CODE_LIST )
			{	
				ln("/*");
				ln("* " + binding.getAnnotations().getDefinition() );
				ln("*/");
				ln("public enum " + 
						GeneratorUtils.generateCSharpTypeName(binding.getName()));
				bs("{");
					for( DefinedCode code : binding.getCodes() ) 
					{
						String definition = code.getDefinition();
						
						ln(GeneratorUtils.generateCSharpMemberName(null,code.getCode()) + ",");
						
						if( definition != null )
							nl(" // " + code.getDefinition());		
					}
				es("}");
				ln();
			}

		}
	
		return end();
	}
}
