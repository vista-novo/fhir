package org.hl7.fhir.tools.core.parser;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.tools.core.model.BindingType;
import org.hl7.fhir.tools.core.model.ConceptDomain;
import org.hl7.fhir.tools.core.model.DefinedCode;
import org.hl7.fhir.tools.core.model.ElementDefn;
import org.hl7.fhir.tools.core.utilities.Utilities;

public class JavaResourceGenerator extends JavaGenerator {

	public JavaResourceGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out);
	}

	private Map<ElementDefn, String> typeNames = new HashMap<ElementDefn, String>();

	private List<ElementDefn> enums = new ArrayList<ElementDefn>();
	private List<String> enumNames = new ArrayList<String>();
	private List<ElementDefn> strucs  = new ArrayList<ElementDefn>();
	
	
	public Map<ElementDefn, String> getTypeNames() {
		return typeNames;
	}

	public void generate(ElementDefn root, List<ConceptDomain> conceptDomains) throws Exception {
		typeNames.clear();
		enums.clear();
		strucs.clear();
		enumNames.clear();

		write("package org.hl7.fhir.instance.model;\r\n");
		write("\r\n");
		if (hasList(root)) {
			write("import java.util.*;\r\n");
			write("\r\n");
		}
		write("public class "+root.getName()+" extends Resource {\r\n");
		write("\r\n");

		for (ElementDefn e : root.getElements()) {
			if (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text"))
				scanNestedTypes(root, root.getName(), e, conceptDomains);
		}
		for (ElementDefn e : enums) {
			generateEnum(e, conceptDomains);
		}
		for (ElementDefn e : strucs) {
			generateType(e);
		}
		
		for (ElementDefn e : root.getElements()) {
			if (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text"))
				generateField(e, "    ");
		}
		
		for (ElementDefn e : root.getElements()) {
			if (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text"))
				generateAccessors(e, "    ");
		}
		
//		generateSetters(root, "    ");
		
		write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();

	}

//	private void generateSetters(ElementDefn root, String indent) throws Exception {
//		boolean first = true;
//		if (root.getElements().size() == 0)
//			return;
//		
//		boolean generics = false;
//		for (ElementDefn e : root.getElements()) 
//			if (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text")) 
//				if (typeNames.get(e).contains("<"))
//					generics = true;
//
//		if (generics)
//			write(indent+"@SuppressWarnings(\"unchecked\")\r\n");
//		write(indent+"public void setProperty(String name, Object value) throws Exception {\r\n");
//		for (ElementDefn e : root.getElements()) {
//			if (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text")) {
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
			if (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text")) {
				if (e.unbounded() || hasListInner(e))
					return true;
			}
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

	private void generateEnum(ElementDefn e, List<ConceptDomain> conceptDomains) throws Exception {
		String tn = typeNames.get(e);
		ConceptDomain cd = getConceptDomain(conceptDomains, e.getConceptDomain());
		
		write("    public enum "+tn+" {\r\n");
		int l = cd.getCodes().size();
		int i = 0;
		for (DefinedCode c : cd.getCodes()) {
			i++;
			String cc = c.getCode();
			if (Utilities.isJavaReservedWord(cc))
				cc = cc + "_";
			cc = cc.replace("-", "Minus").replace("+", "Plus");
			if (i == l)
				write("        "+cc+"; // "+c.getDefinition()+"\r\n");
			else
				write("        "+cc+", // "+c.getDefinition()+"\r\n");
		}
		
		
        write("        public static "+tn+" fromCode(String code) throws Exception {\r\n");
		write("            if (code == null || \"\".equals(code))\r\n");
		write("                return null;\r\n");
		for (DefinedCode c : cd.getCodes()) {
			String cc = c.getCode();
			if (Utilities.isJavaReservedWord(cc))
				cc = cc + "_";
			cc = cc.replace("-", "Minus").replace("+", "Plus");
			write("        if (\""+c.getCode()+"\".equals(code))\r\n");
			write("          return "+cc+";\r\n");
		}		
		write("        throw new Exception(\"Unknown "+tn+" code '\"+code+\"'\");\r\n");
		write("        }\r\n");	

		write("    }\r\n");
		write("\r\n");
	
	}

	private void generateType(ElementDefn e) throws Exception {
		String tn = typeNames.get(e);
		
		write("    public class "+tn+" extends Element {\r\n");
		for (ElementDefn c : e.getElements()) {
			generateField(c, "        ");
		}
		for (ElementDefn c : e.getElements()) {
				generateAccessors(c, "        ");
		}
		write("    }\r\n");
		write("\r\n");
		
	}

	private void scanNestedTypes(ElementDefn root, String path, ElementDefn e, List<ConceptDomain> conceptDomains) throws Exception {
		String tn = null;
		if (e.typeCode().equals("code") && e.hasConceptDomain()) {
			ConceptDomain cd = getConceptDomain(conceptDomains, e.getConceptDomain());
			if (cd != null && cd.getBindingType() == BindingType.CodeList) {
				tn = getCodeListType(cd.getBinding());
				if (!enumNames.contains(tn)) {
					enumNames.add(tn);
					enums.add(e);
				}
				typeNames.put(e,  tn);
			}
		}
		if (tn == null) {
			if (e.getTypes().size() > 0) {
				tn = getTypeName(e);
				typeNames.put(e,  tn);
			} else {
				if (e.getElements().size() == 1 && e.getElements().get(0).getName().equals("#")) {
					tn = typeNames.get(getElementForPath(root, e.getElements().get(0).typeCode().substring(1)));
					typeNames.put(e,  tn);
				} else {
					tn = path+getTitle(e.getName());
					strucs.add(e);
					typeNames.put(e,  tn);
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

	private ConceptDomain getConceptDomain(List<ConceptDomain> conceptDomains, String conceptDomain) {
		for (ConceptDomain cd : conceptDomains)
			if (cd.getName().equals(conceptDomain))
				return cd;
		return null;
	}

	private void generateField(ElementDefn e, String indent) throws Exception {
		String tn = typeNames.get(e);

		if (e.unbounded()) {
			write(indent+"/**\r\n");
			write(indent+" * "+e.getDefinition()+"\r\n");
			write(indent+" */\r\n");
			write(indent+"private List<"+tn+"> "+getElementName(e.getName())+" = new ArrayList<"+tn+">();\r\n");
			write("\r\n");
		} else {
			write(indent+"/**\r\n");
			write(indent+" * "+e.getDefinition()+"\r\n");
			write(indent+" */\r\n");
			write(indent+"private "+tn+" "+getElementName(e.getName())+";\r\n");
			write("\r\n");
		}

	}



	private void generateAccessors(ElementDefn e, String indent) throws Exception {
		String tn = typeNames.get(e);

		if (e.unbounded()) {
			write(indent+"public List<"+tn+"> get"+getTitle(getElementName(e.getName()))+"() { \r\n");
			write(indent+"  return this."+getElementName(e.getName())+";\r\n");
			write(indent+"}\r\n");
			write("\r\n");
		} else {
			write(indent+"public "+tn+" get"+getTitle(getElementName(e.getName()))+"() { \r\n");
			write(indent+"  return this."+getElementName(e.getName())+";\r\n");
			write(indent+"}\r\n");
			write("\r\n");
			write(indent+"public void set"+getTitle(getElementName(e.getName()))+"("+tn+" value) { \r\n");
			write(indent+"  this."+getElementName(e.getName())+" = value;\r\n");
			write(indent+"}\r\n");
			write("\r\n");
		}

	}


}
