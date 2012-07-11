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
import java.io.OutputStream;
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

public class JavaResourceGenerator extends JavaBaseGenerator {

	public enum JavaGenClass { Structure, Type, Resource, Constraint }
	private JavaGenClass clss;

	public JavaResourceGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out);
	}

	private Map<ElementDefn, String> typeNames = new HashMap<ElementDefn, String>();
	private List<String> typeNameStrings = new ArrayList<String>();

	private List<ElementDefn> enums = new ArrayList<ElementDefn>();
	private List<String> enumNames = new ArrayList<String>();
	private List<ElementDefn> strucs  = new ArrayList<ElementDefn>();


	public Map<ElementDefn, String> getTypeNames() {
		return typeNames;
	}

	public void generate(ElementDefn root, Map<String, BindingSpecification> conceptDomains, JavaGenClass clss, DefinedCode cd, Date genDate, String version) throws Exception {
		typeNames.clear();
		typeNameStrings.clear();
		enums.clear();
		strucs.clear();
		enumNames.clear();
		this.clss = clss;

		write("package org.hl7.fhir.instance.model;\r\n");
		write("\r\n/*\r\n"+Config.FULL_LICENSE_CODE+"*/\r\n\r\n");
		write("// Generated on "+Config.DATE_FORMAT().format(genDate)+" for FHIR v"+version+"\r\n\r\n");
		if (hasList(root) || hasXhtml(root)) {
			if (hasList(root))
				write("import java.util.*;\r\n");
			if (hasXhtml(root))
				write("import org.hl7.fhir.utilities.xhtml.XhtmlNode;\r\n");
			write("\r\n");
		}

		write("/**\r\n");
		write(" * "+root.getDefinition()+"\r\n");
		write(" */\r\n");
		if (clss == JavaGenClass.Resource)
			write("public class "+upFirst(root.getName())+" extends Resource {\r\n");
		else if (clss == JavaGenClass.Structure)
			write("public class "+upFirst(root.getName())+" extends Element {\r\n");
		else if (clss == JavaGenClass.Constraint)
			write("public class "+upFirst(cd.getCode())+" extends "+upFirst(root.getName())+" {\r\n");
		else  if (root.typeCode().equals("GenericType")) {
			write("public class "+upFirst(root.getName())+"<T extends Ordered> extends Type {\r\n");
			write("  private String type;\r\n");
			write("  public String getType() {\r\n");
			write("    return type;\r\n");
			write("  };\r\n");
			write("\r\n");
			write("  public Interval(String type) {\r\n");
			write("    super();\r\n");
			write("    this.type = type;\r\n");
			write("  };\r\n");
			write("  \r\n");
		} else if (root.getName().equals("Quantity"))
			write("public class "+upFirst(root.getName())+" extends Type {\r\n");
		else
			write("public class "+upFirst(root.getName())+" extends Type {\r\n");
		write("\r\n");

		if (clss != JavaGenClass.Constraint) {
			for (ElementDefn e : root.getElements()) {
				if (clss != JavaGenClass.Resource || (!e.getName().equals("id") && !e.getName().equals("extension") && !e.getName().equals("text")))
					scanNestedTypes(root, root.getName(), e, conceptDomains);
			}
			for (ElementDefn e : enums) {
				generateEnum(e, conceptDomains);
			}
			for (ElementDefn e : strucs) {
				generateType(e);
			}

			for (ElementDefn e : root.getElements()) {
				if (clss != JavaGenClass.Resource || (!e.getName().equals("id") && !e.getName().equals("extension") && !e.getName().equals("text")))
					generateField(root, e, "    ");
			}

			for (ElementDefn e : root.getElements()) {
				if (clss != JavaGenClass.Resource || (!e.getName().equals("id") && !e.getName().equals("extension") && !e.getName().equals("text")))
					generateAccessors(root, e, "    ");
			}
		}

		write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();

	}

	private String upFirst(String name) {
		return name.substring(0,1).toUpperCase()+name.substring(1);
	}

	//	private void generateSetters(ElementDefn root, String indent) throws Exception {
	//		boolean first = true;
	//		if (root.getElements().size() == 0)
	//			return;
	//		
	//		boolean generics = false;
	//		for (ElementDefn e : root.getElements()) 
	//			if (!e.getName().equals("id") && !e.getName().equals("extension") && !e.getName().equals("text")) 
	//				if (typeNames.get(e).contains("<"))
	//					generics = true;
	//
	//		if (generics)
	//			write(indent+"@SuppressWarnings(\"unchecked\")\r\n");
	//		write(indent+"public void setProperty(String name, Object value) throws Exception {\r\n");
	//		for (ElementDefn e : root.getElements()) {
	//			if (!e.getName().equals("id") && !e.getName().equals("extension") && !e.getName().equals("text")) {
	//				if (first)
	//					write(indent+"    if (\""+e.getName()+"\".equals(name))\r\n");
	//				else
	//					write(indent+"    else if (\""+e.getName()+"\".equals(name))\r\n");
	//				first = false;
	//				if (e.unbounded())
	//					write(indent+"        get"+getTitle(getElementName(e.getName()))+"().add(("+typeNames.get(e)+") value);\r\n");
	//				else
	//					write(indent+"        set"+getTitle(getElementName(e.getName()))+"(("+typeNames.get(e)+") value);\r\n");
	//			}
	//		}
	//		write(indent+"    else\r\n");
	//		write(indent+"        super.setProperty(name, value);\r\n");
	//		write(indent+"}\r\n");
	//		write("\r\n");
	//	}



	private boolean hasList(ElementDefn root) {
		for (ElementDefn e : root.getElements()) {
			if (!e.getName().equals("id") && !e.getName().equals("text")) {
				if (e.unbounded() || hasListInner(e))
					return true;
			}
		}
		return false;
	}

	private boolean hasXhtml(ElementDefn root) {
		for (ElementDefn e : root.getElements()) {
			if (e.isXhtmlElement() || hasXhtmlInner(e))
				return true;
		}
		return false;
	}

	private boolean hasListInner(ElementDefn e) {
		for (ElementDefn c : e.getElements()) {
			if (c.unbounded() || hasListInner(c))
				return true;
		}

		return false;
	}

	private boolean hasXhtmlInner(ElementDefn e) {
		for (ElementDefn c : e.getElements()) {
			if (c.isXhtmlElement() || hasXhtmlInner(c))
				return true;
		}

		return false;
	}

	private void generateEnum(ElementDefn e, Map<String, BindingSpecification> conceptDomains) throws Exception {
		String tn = typeNames.get(e);
		BindingSpecification cd = getConceptDomain(conceptDomains, e.getBindingName());

		write("    public enum "+tn+" {\r\n");
		int l = cd.getCodes().size();
		int i = 0;
		for (DefinedCode c : cd.getCodes()) {
			i++;
			String cc = c.getCode();
			if (GeneratorUtils.isJavaReservedWord(cc))
				cc = cc + "_";
			if (cc.equals("<"))
				cc = "lessThan";
			else if (cc.equals("<="))
				cc = "lessOrEqual";
			else if (cc.equals(">"))
				cc = "greaterThan";
			else if (cc.equals(">="))
				cc = "greaterOrEqual";
      else if (cc.equals("="))
        cc = "equal";
			else
				cc = cc.replace("-", "Minus").replace("+", "Plus");
			if (i == l)
				write("        "+cc+"; // "+c.getDefinition()+"\r\n");
			else
				write("        "+cc+", // "+c.getDefinition()+"\r\n");
		}


		write("        public static "+tn+" fromCode(String codeString) throws Exception {\r\n");
		write("            if (codeString == null || \"\".equals(codeString))\r\n");
		write("                return null;\r\n");
		for (DefinedCode c : cd.getCodes()) {
			String cc = c.getCode();
			if (GeneratorUtils.isJavaReservedWord(cc))
				cc = cc + "_";
			if (cc.equals("<"))
				cc = "lessThan";
			else if (cc.equals("<="))
				cc = "lessOrEqual";
			else if (cc.equals(">"))
				cc = "greaterThan";
			else if (cc.equals(">="))
				cc = "greaterOrEqual";
      else if (cc.equals("="))
        cc = "equal";
			else
				cc = cc.replace("-", "Minus").replace("+", "Plus");
			write("        if (\""+c.getCode()+"\".equals(codeString))\r\n");
			write("          return "+cc+";\r\n");
		}		
		write("        throw new Exception(\"Unknown "+tn+" code '\"+codeString+\"'\");\r\n");
		write("        }\r\n");	

		write("        public String toCode() {\r\n");
		write("          switch (this) {\r\n");
		for (DefinedCode c : cd.getCodes()) {
			String cc = c.getCode();
			if (GeneratorUtils.isJavaReservedWord(cc))
				cc = cc + "_";
			if (cc.equals("<"))
				cc = "lessThan";
			else if (cc.equals("<="))
				cc = "lessOrEqual";
			else if (cc.equals(">"))
				cc = "greaterThan";
			else if (cc.equals(">="))
				cc = "greaterOrEqual";
      else if (cc.equals("="))
        cc = "equal";
			else
				cc = cc.replace("-", "Minus").replace("+", "Plus");
			write("            case "+cc+": return \""+c.getCode()+"\";\r\n");
		}   
		write("            default: return \"?\";\r\n");
		write("          }\r\n"); 
		write("        }\r\n"); 

		write("    }\r\n");
		write("\r\n");

	}

	private void generateType(ElementDefn e) throws Exception {
		String tn = typeNames.get(e);

		write("    public class "+tn+" extends Element {\r\n");
		for (ElementDefn c : e.getElements()) {
			generateField(e, c, "        ");
		}
		for (ElementDefn c : e.getElements()) {
			generateAccessors(e, c, "        ");
		}
		write("    }\r\n");
		write("\r\n");

	}

	private void scanNestedTypes(ElementDefn root, String path, ElementDefn e, Map<String, BindingSpecification> conceptDomains) throws Exception {
		String tn = null;
		if (e.typeCode().equals("code") && e.hasBinding()) {
			BindingSpecification cd = getConceptDomain(conceptDomains, e.getBindingName());
			if (cd != null && cd.getBinding() == BindingSpecification.Binding.CodeList) {
				tn = getCodeListType(cd.getReference().substring(1));
				if (!enumNames.contains(tn)) {
					enumNames.add(tn);
					enums.add(e);
				}
				typeNames.put(e,  tn);
			}
		}
		if (tn == null) {
			if (e.getTypes().size() > 0 && !e.usesCompositeType()) {
				tn = e.typeCode();
				if (clss != JavaGenClass.Resource || !e.isAllowDAR()) {
					if (tn.equals("boolean")) tn = "boolean";
					else if (tn.equals("integer")) tn = "int";
					else if (tn.equals("decimal")) tn = "java.math.BigDecimal";
					else if (tn.equals("base64Binary")) tn = "byte[]";
					else if (tn.equals("instant")) tn = "java.util.Calendar";
					else if (tn.equals("string")) tn = "String";
					else if (tn.equals("uri")) tn = "java.net.URI";
					else if (tn.equals("code")) tn = "String";
					else if (tn.equals("oid")) tn = "String";
          else if (tn.equals("uuid")) tn = "String";
          else if (tn.equals("idref")) tn = "String";
					else if (tn.equals("sid")) tn = "String";
					else if (tn.equals("id")) tn = "String";
					else if (tn.equals("date")) tn = "String";
					else if (tn.equals("dateTime")) tn = "String";
					else 
						tn = getTypeName(e);
				} else 
					tn = getTypeName(e);
				if (e.getTypes().get(0).isUnboundGenericParam())
					tn = "T";
				else if (e.getTypes().get(0).isIdRef())
					tn ="String";
				else if (e.isXhtmlElement()) 
					tn = "XhtmlNode";
				else if (e.getTypes().get(0).isWildcardType())
					tn ="Type";

				typeNames.put(e,  tn);
			} else {
				if (e.usesCompositeType()) {
					tn = typeNames.get(getElementForPath(root, e.typeCode().substring(1)));
					typeNames.put(e,  tn);
				} else {
					tn = getTitle(e.getName());
					if (tn.equals("Element"))
						tn = "Element_";
					strucs.add(e);
					if (typeNameStrings.contains(tn)) {
						char i = 'A';
						while (typeNameStrings.contains(tn+i))
							i++;
						tn = tn + i;
					}
					typeNames.put(e,  tn);
					typeNameStrings.add(tn);
					for (ElementDefn c : e.getElements()) {
						scanNestedTypes(root, path+getTitle(e.getName()), c, conceptDomains);
					}
				}
			}
		}
	}

	private Object getElementForPath(ElementDefn root, String pathname) throws Exception {
		String[] path = pathname.split("\\.");
		if (!path[0].equals(root.getName()))
			throw new Exception("Element Path '"+pathname+"' is not legal in this context");
		ElementDefn res = root;
		for (int i = 1; i < path.length; i++)
		{
			String en = path[i];
			if (en.length() == 0)
				throw new Exception("Improper path "+pathname);
			ElementDefn t = res.getElementByName(en);
			if (t == null) {
				throw new Exception("unable to resolve "+pathname);
			}
			res = t; 
		}
		return res;

	}

	private String getCodeListType(String binding) {
		StringBuilder b = new StringBuilder();
		boolean up = true;
		for (char ch: binding.toCharArray()) {
			if (ch == '-')
				up = true;
			else if (up) {
				b.append(Character.toUpperCase(ch));
				up = false;
			}
			else				
				b.append(ch);
		}
		return b.toString();
	}

	private BindingSpecification getConceptDomain(Map<String, BindingSpecification> conceptDomains, String conceptDomain) {
		for (BindingSpecification cd : conceptDomains.values())
			if (cd.getName().equals(conceptDomain))
				return cd;
		return null;
	}

	private void generateField(ElementDefn root, ElementDefn e, String indent) throws Exception {
		String tn = typeNames.get(e);

		if (e.unbounded()) {
			write(indent+"/**\r\n");
			write(indent+" * "+e.getDefinition()+"\r\n");
			write(indent+" */\r\n");
			if (tn == null && e.usesCompositeType())
				write(indent+"/*1*/private List<"+root.getName()+"> "+getElementName(e.getName(), true)+" = new ArrayList<"+root.getName()+">();\r\n");
			else
				write(indent+"private List<"+tn+"> "+getElementName(e.getName(), true)+" = new ArrayList<"+tn+">();\r\n");
			write("\r\n");
		} else {
			write(indent+"/**\r\n");
			write(indent+" * "+e.getDefinition()+"\r\n");
			write(indent+" */\r\n");
			write(indent+"private "+tn+" "+getElementName(e.getName(), true)+";\r\n");
			write("\r\n");
		}

	}



	private void generateAccessors(ElementDefn root, ElementDefn e, String indent) throws Exception {
		String tn = typeNames.get(e);

		if (e.unbounded()) {
			if (tn == null && e.usesCompositeType())
				write(indent+"/*2*/public List<"+root.getName()+"> get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
			else
				write(indent+"public List<"+tn+"> get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
			write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");
			write(indent+"}\r\n");
			write("\r\n");
		} else {
			write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName(), false))+"() { \r\n");
			write(indent+"  return this."+getElementName(e.getName(), true)+";\r\n");
			write(indent+"}\r\n");
			write("\r\n");
			write(indent+"public void set"+getTitle(getElementName(e.getName(), false))+"("+tn+" value) { \r\n");
			write(indent+"  this."+getElementName(e.getName(), true)+" = value;\r\n");
			write(indent+"}\r\n");
			write("\r\n");
		}

	}


}
