package org.hl7.fhir.tools.publisher.implementations;

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
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.tools.publisher.implementations.JavaResourceGenerator.JavaGenClass;
import org.hl7.fhir.utilities.Utilities;

public class CSharpResourceGenerator extends OutputStreamWriter {

	private Map<ElementDefn, String> typeNames = new HashMap<ElementDefn, String>();
	private List<String> typeNameStrings = new ArrayList<String>();
	
	private List<ElementDefn> enums = new ArrayList<ElementDefn>();
	private List<String> enumNames = new ArrayList<String>();
	private List<ElementDefn> strucs = new ArrayList<ElementDefn>();

	public CSharpResourceGenerator(OutputStream out)
			throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}


	public void generate(ElementDefn root,
			Map<String, BindingSpecification> conceptDomains,
			Date genDate, String version) throws Exception 
	{
		typeNames.clear();
		typeNameStrings.clear();
		enums.clear();
		strucs.clear();
		enumNames.clear();

		generateHeader(version, genDate);
		beginClass(root.getName(), root.getDefinition());
		
		// First, descend into the element definition
		// and find all nested structs and enums.
		for (ElementDefn e : root.getElements()) {
			if (!e.isBaseResourceElement())
				scanNestedTypes(root, root.getName(), e, conceptDomains);
		}

		// Generate nested enums
		for (ElementDefn e : enums) 
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



	private void endClass() throws IOException {
		writeLn("");
		writeLn("  }");
		writeLn("");
	}



	private void beginClass(String className, String description) throws IOException {
		writeLn("/**");
		writeLn(" * " + description);
		writeLn(" */");
		
		writeLn("  public class " + className + " : Resource" );
		writeLn("  {");
	}

	
	public void generateHeader(String version, Date genDate) throws Exception {
		writeLn("using System;");
		writeLn("using System.Collections.Generic;");
		writeLn("");
		writeLn("/*");
		writeLn(Config.FULL_LICENSE_CODE);
		writeLn("*/");
		writeLn("");
		writeLn("// Generated on " + Config.DATE_FORMAT().format(genDate)
				+ " for FHIR v" + version);
		writeLn("");
		writeLn("namespace org.hl7.fhir.instance.model");
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
		String tn = typeNames.get(e);
		
		BindingSpecification cd = BindingSpecification.getBindingFromList(conceptDomains,
				e.getBindingName());

		writeLn("    public enum " + tn);
		writeLn("    {");
		
		for (DefinedCode c : cd.getCodes()) 
		{
			String cc = c.getCode();
			
			if (Utilities.isCSharpReservedWord(cc))
				cc = cc + "_";
			cc = cc.replace("-", "Minus").replace("+", "Plus");
			//TODO: Java version has extended mapping
			
			writeLn("      " + cc + ", // " + c.getDefinition());			
		}
		
		writeLn("    }");
		writeLn("");
	}

	
	private void generateNestedClass(ElementDefn e) throws Exception {
		String tn = typeNames.get(e);

		writeLn("    public class " + tn + " : Element");
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
					enums.add(e);
				}
				typeNames.put(e, tn);
				
				return;
			}
		}
		
		// If the element is atomic (either simple type or a resource reference)...
		if (e.getTypes().size() > 0) 
		{
			String tn = e.typeCode();
				
			// Returns null if the type is not recognized as a type that
			// directly maps to an underlying CSharp type.
			tn = mapFHIRPrimitiveToCSharpType(tn);
			
			// Not a (single) primitive type, but a named complex type
			// This can be a Resource, Interval or some other type.
			if( tn == null ) 
				tn = getTypeName(e);
			
			typeNames.put(e, tn);
		}
		
		// If the element has nested elements...
		else
		{
			boolean isInternalReference = 
					e.getElements().size() == 1	&& 
					e.getElements().get(0).getName().equals("#");
			
			if (isInternalReference)
			{
				String tn = typeNames.get(getElementForPath(root, e.getElements()
							.get(0).typeCode().substring(1)));
				typeNames.put(e, tn);
			} 
			else 
			{
				// It is a structure. The structured type gets the name of
				// the capitalized element name.
				String tn = capitalize(e.getName());

				if (tn.equals("Element"))
					tn = "Element_";
				
				strucs.add(e);

				// If the structure has an existing name within the
				// nested classes, add A, B, C, .....
				if (typeNameStrings.contains(tn)) 
				{
					char i = 'A';
					while (typeNameStrings.contains(tn + i))
						i++;
					tn = tn + i;
				}
				
				typeNames.put(e, tn);
				typeNameStrings.add(tn);
				
				// Continue with nested elements
				for (ElementDefn c : e.getElements()) 
				{
					scanNestedTypes(root, path + capitalize(e.getName()), c,
							conceptDomains);
				}
			}
		}
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
			return "Uri";
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
			return "string";
		else if (tn.equals("dateTime"))
			return "string";
		else
			return null;
	}
	
	
	private Object getElementForPath(ElementDefn root, String pathname)
			throws Exception 
	{
		String[] path = pathname.split("\\.");
	
		if (!path[0].equals(root.getName()))
			throw new Exception("Element Path '" + pathname
					+ "' is not legal in this context");
		
		ElementDefn res = root;
		
		for (int i = 1; i < path.length; i++) 
		{
			String en = path[i];
			if (en.length() == 0)
				throw new Exception("Improper path " + pathname);
		
			ElementDefn t = res.getElementByName(en);
			if (t == null) {
				throw new Exception("unable to resolve " + pathname);
			}
			
			res = t;
		}
		return res;
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
		String tn = typeNames.get(e);

		writeLn(indent + "/**");
		writeLn(indent + " * " + e.getDefinition());
		writeLn(indent + " */");

		// Generate List<> + accessor for collection types
		if (e.unbounded()) 
		{		
			boolean isInternalReference = 
					tn == null && 
					e.getElements().size() == 1 && 
					e.getElements().get(0).getName().equals("#");
			
			
			String listType = isInternalReference ? root.getName() : tn;
			String fieldName = "_" + getElementName(e.getName()); 
			writeLn(indent + "private List<" + listType + "> "
						+ fieldName + " = new List<" + listType + ">();");
				
			write(indent + "public List<" + listType + "> "
						+ capitalize(getElementName(e.getName())));
			writeLn(" " + "{ get { return " + fieldName + "; } set { " + fieldName + " = value; } }");			
			writeLn("");
		} 
		
		// Single accessors otherwise
		else 
		{
			writeLn(indent + "public " + tn + " " + capitalize(getElementName(e.getName())) + " { get; set; }");		
			writeLn("");
		}
	}
	
	
	private String getElementName(String name) {
		  if (name.equals("[type]"))
			    return "value";
		  else
		  {
			  if( Utilities.isCSharpReservedWord(name) )
				  name = name + "_";
				  
			  return name.replace("[x]", "");
		  }
			    
	}


	
	private String getTypeName(ElementDefn e) throws Exception {
		// If the element is a choice of more than one type,
		// this must be a list of datatypes. The type of the element
		// is set to polymorphic Type.
		if (e.getTypes().size() > 1) 
		{
			return "Type";
		}

		// The element has no type, so we cannot determine
		// a typename. Throw exception.
		else if (e.getTypes().size() == 0)
		{
			throw new Exception("not supported");
		} 
		
		// The element is a resource(reference) or another
		// unrecognized type.
		else
		{
			return getTypename(e.getTypes().get(0));
		}
	}

	
	private String getTypename(TypeDefn type) throws Exception {
		// The element is has 1 type parameter, which suggests
		// it is a Resourcereference or a parameterized Interval.
		// If not, this is not supported.
		if (type.getParams().size() == 1) 
		{
			if (type.getName().equals("Resource"))
				return "ResourceReference<"
						+ getTypeName(type.getParams().get(0)) + ">";
			else if (type.getName().equals("Interval"))
				return "Interval<" + getTypeName(type.getParams().get(0)) + ">";
			else
				throw new Exception("not supported");
		}
		
		// The element is a polymorphic Resource reference
		// Resource(A|B|....). Generate this a reference
		// to a "Resource".
		else if (type.getParams().size() > 1) 
		{
			if (type.getName().equals("Resource"))
				return "ResourceReference<Resource>";
			else
				throw new Exception("not supported");
		} 
		
		// Another non-parameterized type
		else 
		{
			return getTypeName(type.getName());
		}
	}

	
	private String getTypeName(String tn) 
	{	
		if (tn.equalsIgnoreCase("*"))
			return "Type";
		
		// TODO: Can this ever be "string"?
		// I think code more upstream already
		// handles this.		
		if (tn.equals("string")) 
			return "String_";
		
		if (tn.equalsIgnoreCase("xml:ID"))
			return "String";
		
		if (tn.equalsIgnoreCase("Xhtml"))
			return "XhtmlNode";

		// Type name Any means "Any resource"
		if (tn.equals("Any")) 
			return "Resource";
		
		// We don't know the type, just capitalize it.
		return capitalize(tn);
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
