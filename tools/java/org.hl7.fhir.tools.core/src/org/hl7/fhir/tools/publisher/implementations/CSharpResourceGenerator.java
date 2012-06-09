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
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.utilities.Utilities;

public class CSharpResourceGenerator extends OutputStreamWriter {

	public enum GenClass
	{
		Resource, 		// Derives from Resource (has id, text, extensions)
		Structure,		// Derives from Element 
		Type, 			// Derives from Type (i.e. has dataAbsentReason)
		Ordered,		// Subclass of Type for ordered types
		Generic,		// Subclass of Type for generic types
		ConstrainedType // Constraint versions of other types (Count, Distance, Money)
	}
	
	
	private Map<ElementDefn, String> elementToGeneratedTypeMapping = new HashMap<ElementDefn, String>();
	private List<String> generatedTypesInScope = new ArrayList<String>();
	
	private List<ElementDefn> enumsToGenerate = new ArrayList<ElementDefn>();
	private List<String> enumNames = new ArrayList<String>();
	private List<ElementDefn> strucs = new ArrayList<ElementDefn>();

	public CSharpResourceGenerator(OutputStream out)
			throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}


	public void generate(ElementDefn root,
			Map<String, BindingSpecification> conceptDomains,
			GenClass generationType,
			Date genDate, String version) throws Exception 
	{
		elementToGeneratedTypeMapping.clear();
		generatedTypesInScope.clear();
		enumsToGenerate.clear();
		strucs.clear();
		enumNames.clear();

		generateHeader(version, genDate);
		beginClass(generationType, root.getName(), null, root.getDefinition());
		
		// First, descend into the element definition
		// and find all nested structs and enums.
		for (ElementDefn e : root.getElements()) {
			if (!e.isBaseResourceElement())
				scanNestedTypes(root, root.getName(), e, conceptDomains);
		}

		// Generate nested enums
		for (ElementDefn e : enumsToGenerate) 
		{
			generateEnum(e, conceptDomains);
		}
		
		// Generate nested structs (e.g. RequestDetail for LabReport)
		for (ElementDefn e : strucs) 
		{
			generateNestedClass(e);
		}

		// Generate the class' own properties
		for (ElementDefn e : root.getElements()) {
			if (!e.isBaseResourceElement())
				generateFieldAndProperty(root, e, "    ");
		}

		endClass();

		finish();

		flush();
		close();
	}


	
	public void generateConstraint( String className, String baseClassName,
			String description, Date genDate, String version) throws Exception, IOException
	{
		generateHeader(version, genDate);
		beginClass(GenClass.ConstrainedType, className, baseClassName,
					description);
		endClass();

		finish();

		flush();
		close();	
	}


	private void endClass() throws IOException {
		writeLn("");
		writeLn("  }");
		writeLn("");
	}


	
	private String TYPE_BASECLASSNAME = "FhirType";

	private void beginClass(GenClass generationType, 
			String className, String baseClassName, 
			String description) throws Exception, IOException {
		writeLn("/**");
		writeLn(" * " + description);
		writeLn(" */");
		
		String baseClass;
		
		switch( generationType )
		{
			case Resource:
				baseClass = "Resource";
				break;
			case Structure:
				baseClass = "Element";
				break;
			case Type:
				baseClass= TYPE_BASECLASSNAME;
				break;
			case Ordered:
				baseClass = "Ordered";
				break;
			case Generic:
				baseClass = TYPE_BASECLASSNAME;
				break;
			case ConstrainedType:
				baseClass = baseClassName;
				break;
			default:
				throw new Exception("Don't support that class of generation yet");
		}

		if( generationType == GenClass.Generic )
			className += "<T>";
		
		writeLn("  public partial class " + className + " : " + baseClass );
		writeLn("  {");
	}

		
	public void generateHeader(String version, Date genDate) throws Exception {
		writeLn("using System;");
		writeLn("using System.Collections.Generic;");
		writeLn("using HL7.Fhir.Instance.Support;");
		writeLn("using System.Xml.Linq;");
		writeLn("");
		writeLn("/*");
		writeLn(Config.FULL_LICENSE_CODE);
		writeLn("*/");
		writeLn("");
		writeLn("// Generated on " + Config.DATE_FORMAT().format(genDate)
				+ " for FHIR v" + version);
		writeLn("");
		writeLn("namespace HL7.Fhir.Instance.Model");
		writeLn("{");	// begin namespace
		writeLn("");
	}

	public void finish() throws Exception {
		writeLn("}");	// end namespace
		writeLn("");
	}
	
	private void generateEnum(ElementDefn e,
			Map<String, BindingSpecification> conceptDomains) throws Exception 
	{
		String tn = elementToGeneratedTypeMapping.get(e);
		
		BindingSpecification cd = BindingSpecification.getBindingFromList(conceptDomains,
				e.getBindingName());

		writeLn("    public enum " + tn);
		writeLn("    {");
		
		for (DefinedCode c : cd.getCodes()) 
		{
			String cc = cleanupCodeString( c.getCode() );		
			writeLn("      " + cc + ", // " + c.getDefinition());			
		}
		
		writeLn("    }");
		writeLn("");
	}

	
	private String cleanupCodeString( String code )
	{
		if(Utilities.isCSharpReservedWord(code))
			return code + "_";
	
		if (code.equals("<")) return "lessThan";
		else if (code.equals("<=")) return "lessOrEqual";
		else if (code.equals(">")) return "greaterThan";
		else if (code.equals(">=")) return "greaterOrEqual";
		else
			return code.replace("-", "Minus").replace("+", "Plus");
	}
	
	private void generateNestedClass(ElementDefn e) throws Exception {
		String tn = elementToGeneratedTypeMapping.get(e);
		
		writeLn("    public partial class " + tn + " : Element");
		writeLn("    {");
				
		for (ElementDefn c : e.getElements()) {
			generateFieldAndProperty(e, c, "      ");
		}
			
		writeLn("    }");
		writeLn("");
	}

	
	private void scanNestedTypes(ElementDefn root, String path, ElementDefn e,
			Map<String, BindingSpecification> conceptDomains) throws Exception
	{
		// If the element is a coded type with a binding AND the binding is an fixed
		// list of codes, add this element as an Enum-to-be-generated.
		if (e.isBoundCode()) 
		{
			BindingSpecification cd = BindingSpecification.getBindingFromList(conceptDomains,
					e.getBindingName());
	
			if (cd != null && cd.getBinding() == BindingSpecification.Binding.CodeList) 
			{
				String tn = getCodeListType(cd.getReference().substring(1));
				if (!enumNames.contains(tn)) {
					enumNames.add(tn);
					enumsToGenerate.add(e);
				}
			
				elementToGeneratedTypeMapping.put(e, tn);
				
				return;
			}
			
			// If the code is not bound, it will just appear as an unconstrained
			// "Code" type (or more probably mapped to string) in the generated code.
			// There will be no generated enum.
		}
				
		if (!e.hasNestedElements() )
			handleSingleElement(root, e);		
		else if( e.hasNestedElements() )
			handleComplexElement(root, path, e, conceptDomains);
		else
			throw new Exception("Internal error: impossible case in type declaration");	
	}


	private void handleComplexElement(ElementDefn root, String path,
			ElementDefn e, Map<String, BindingSpecification> conceptDomains)
			throws Exception {
		// It is a structure. The structured type gets the name of
		// the capitalized element name + "Component" appended.
		String tn = capitalize(e.getName()) + "Component";
		
		// If the structure has an existing name within the
		// nested classes, add A, B, C, .....
		if (generatedTypesInScope.contains(tn)) 
		{
			char i = 'A';
			while (generatedTypesInScope.contains(tn + i))
				i++;
			tn = tn + i;
		}

		strucs.add(e);
		elementToGeneratedTypeMapping.put(e, tn);
		generatedTypesInScope.add(tn);
		
		// Continue with nested elements
		for (ElementDefn c : e.getElements()) 
		{
			scanNestedTypes(root, path + capitalize(e.getName()), c,
					conceptDomains);
		}
	}


	private void handleSingleElement(ElementDefn root, ElementDefn e) throws Exception {
		String exceptionPrefix = root.getName() +
				" has element " + e.getName();
		
		// The element has no nested children, so should have
		// a type declaration (directly, or via the type declared
		// on some other element within the same resource).
		if( e.getTypes().isEmpty() )
			throw new Exception(exceptionPrefix + " which carries neither" +
				" a type nor child elements.");

		/* Syntax for type declarations
		 * 
		 *   typeSpec = '@' elementreference |
		 *   			'[param]' |
		 *   			'xhtml' |
		 *   			'xml:ID' |
		 *   			'Interval(' orderedType ')' |
		 *   			'Resource(' resourceParams ')' |
		 *   	    	type ('|' type)* | '*'
		 *   
		 *   resourceParams = resourceType ('|' resourceType)* | Any
		 *   type = primitiveType | dataType | structure
		 *   
		 *   NB: mapping of primitive types is dependent on
		 *   dataAbsenceAllowed. Is allowed, then the primitives must
		 *   be mapped to a subclass of Type, otherwise to the
		 *   corresponding C# primitive (or XsdDateTime).
		 */
		String tn = null;
		
		TypeRef type = e.getTypes().get(0);

		if( type.getName().startsWith("@"))
			tn = elementToGeneratedTypeMapping.get(
					root.getElementForPath(e.typeCode().substring(1)));
		else if( type.isUnboundGenericParam() )
			tn = "T";
		else if( type.isXhtml() )
			tn = "XNode";
		else if( type.isXmlId() )
			tn = "string";
		else if(type.getName().startsWith("Interval"))
			tn = buildIntervalMappedTypeName(type);
		else if(type.getName().startsWith("Resource"))
			tn = buildResourceReferenceTypename(type);
		else
			//Not a special case, must be a type/list of types
			tn = buildFhirTypeMappedName(e);
		
		elementToGeneratedTypeMapping.put(e, tn);
	}


	private String buildIntervalMappedTypeName(TypeRef type) throws Exception {
		String mappedParamType = 
			mapFHIRPrimitiveToCSharpType(type.getParams().get(0));
		
		if( mappedParamType != null )
			return "Interval<" + mappedParamType  + ">";
		else
		{
			throw new Exception("Interval<"+ type.getParams().get(0) +
					"> not supported, not a known primitive type.");
		}
	}


	private String buildFhirTypeMappedName(ElementDefn e) throws Exception {
		// If we have a list of alternate types, we can only
		// use the Type baseclass for polymorphic use.
		boolean isPolymorphicElement = 
				e.getTypes().size() > 1 || e.getTypes().get(0).isWildcardType(); 
				
		if ( isPolymorphicElement ) 
			return TYPE_BASECLASSNAME;

		// If it is one single specific type, generate this as type
		else
		{
			String typeName = e.getTypes().get(0).getName();
			
			// instant, date and dateTime are always mapped to the specially 
			// hand-crafted XsdDateTime in C#
			if( typeName.equals("date") || typeName.equals("dateTime") || 
					typeName.equals("instant") )
				return "XsdDateTime";
			
			// Primitives which are used without a dataAbsentReason
			// can be mapped to a C# specific primitive type.
			else if( TypeRef.isFhirPrimitiveType(typeName) &&
					!e.isAllowDAR() )
				return mapFHIRPrimitiveToCSharpType(typeName);
			
			else
				return buildCSharpTypeName(typeName);
		}		
	}

	
	private String buildCSharpTypeName(String tn)
	{
		// For now, just capitalize, but any namespace ambiguities must
		// now be resolved and commonly used names avoided. The name returned
		// here will be put verbatim in the source code for the class.
		if( tn.equals("dateTime") )
			return "DateTime_";
		if( tn.equals("string") )
			return "String_";
		if( tn.equals("integer") )
			return "Integer_";
		if( tn.equals("uri") )
			return "Uri_";
		
		 return capitalize(tn);
	}
	
	private String buildResourceReferenceTypename(TypeRef type) throws Exception 
	{
		// If this is a polymorphic Resource reference (Resource(A|B|....), 
		// or Resource(Any)), generate a reference to a polymorphic Resource.
		boolean isPolymorphicReference =
				type.getParams().size() > 1 || type.getParams().get(0).equals("Any");
				
		if( isPolymorphicReference ) 
		return "ResourceReference<Resource>";
		
		// If we are dealing with a Resource reference for a specific resource,
		// generate a reference with that specific typename.
		else 
			return "ResourceReference<" + buildCSharpTypeName(type.getParams().get(0)) + ">";
	}

	
	private String mapFHIRPrimitiveToCSharpType(String tn)
	{
		if (tn.equals("boolean"))
			return "bool";
		else if (tn.equals("integer"))
			return "int";
		else if (tn.equals("decimal"))
			return "decimal";
		else if (tn.equals("base64Binary"))
			return "byte[]";
		else if (tn.equals("instant"))
			return "DateTime";
		else if (tn.equals("string"))
			return "string";
		else if (tn.equals("uri"))
			return "System.Uri";
		else if (tn.equals("code"))
			return "string";
		else if (tn.equals("oid"))
			return "string";
		else if (tn.equals("uuid"))
			return "string";
		else if (tn.equals("sid"))
			return "string";
		else if (tn.equals("id"))
			return "string";
		else if (tn.equals("date"))
			return "XsdDateTime";
		else if (tn.equals("dateTime"))
			return "XsdDateTime";
		else
			return null;
	}
	

	private String getCodeListType(String binding) {
		StringBuilder b = new StringBuilder();
		boolean up = true;
		for (char ch : binding.toCharArray()) {
			if (ch == '-')
				up = true;
			else if (up) {
				b.append(Character.toUpperCase(ch));
				up = false;
			} else
				b.append(ch);
		}
		return b.toString();
	}


	private void generateFieldAndProperty(ElementDefn root, ElementDefn e, String indent) throws Exception {
		String tn = elementToGeneratedTypeMapping.get(e);

		writeLn(indent + "/**");
		writeLn(indent + " * " + e.getDefinition());
		writeLn(indent + " */");

		String propName = capitalize(getElementName(e.getName()));
		
		if( Utilities.isCSharpReservedWord(propName) )
			  propName += "_";
		
		// member names cannot have the same name as their enclosing class
		if( propName.equals(root.getName()) )
				propName += "Data";
		
		// Generate List<> + accessor for collection types
		if (e.unbounded()) 
		{		
			boolean isInternalReference = 
					tn == null && 
					e.typeCode().startsWith("@");
				
			String listType = isInternalReference ? root.getName() : tn;
			String fieldName = "_" + getElementName(e.getName()); 
			writeLn(indent + "private List<" + listType + "> "
						+ fieldName + " = new List<" + listType + ">();");
				
			write(indent + "public List<" + listType + "> " + propName);
			writeLn(" " + "{ get { return " + fieldName + "; } set { " + fieldName + " = value; } }");			
			writeLn("");
		} 
		
		// Single accessors otherwise
		else 
		{
			writeLn(indent + "public " + tn + " " + propName + " { get; set; }");		
			writeLn("");
		}
	}
	
	
	private String getElementName(String name) {
		  if (name.equals("[type]"))
			    return "value";
		  else
			  return name.replace("[x]", "");			    
	}
		
	private String capitalize(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	private void writeLn( String line ) throws IOException
	{
		write(line);
		write("\r\n");
	}
}
