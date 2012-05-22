package org.hl7.fhir.tools.publisher.implementations;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.ConceptDomain;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.utilities.Utilities;

public class CSharpResourceGenerator extends OutputStreamWriter {


	private Map<ElementDefn, String> typeNames = new HashMap<ElementDefn, String>();

	private List<ElementDefn> enums = new ArrayList<ElementDefn>();
	private List<String> enumNames = new ArrayList<String>();
	private List<ElementDefn> strucs  = new ArrayList<ElementDefn>();
	
	public CSharpResourceGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void start(String version, Date genDate) throws Exception {
		write("using System;\r\n");
		write("using System.Collections.Generic;\r\n");
    write("\r\n/*\r\n"+Config.FULL_LICENSE_CODE+"*/\r\n\r\n");
    write("// Generated on "+Config.DATE_FORMAT().format(genDate)+" for FHIR v"+version+"\r\n\r\n");
		write("namespace org.hl7.fhir.instance.model\r\n");
		write("{\r\n");
		write("\r\n");
	}

	public void finish() throws Exception {
		write("}\r\n");
		write("\r\n");
		flush();
		close();
	}
	
	public void generate(ElementDefn root, Map<String, ConceptDomain> conceptDomains) throws Exception {
		typeNames.clear();
		enums.clear();
		strucs.clear();
		enumNames.clear();

		write("  public class "+root.getName()+" : Resource {\r\n");
		write("  \r\n");

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

		write("\r\n");
		write("  }\r\n");
		write("\r\n");
		flush();

	}

	private void generateEnum(ElementDefn e, Map<String, ConceptDomain> conceptDomains) throws Exception {
		String tn = typeNames.get(e);
		ConceptDomain cd = getConceptDomain(conceptDomains, e.getConceptDomain());
		
		write("    public enum "+tn+"\r\n    {\r\n");
		int l = cd.getCodes().size();
		int i = 0;
		for (DefinedCode c : cd.getCodes()) {
			i++;
			String cc = c.getCode();
			if (Utilities.isJavaReservedWord(cc))
				cc = cc + "_";
			cc = cc.replace("-", "Minus").replace("+", "Plus");
			if (i == l)
				write("      "+cc+" // "+c.getDefinition()+"\r\n");
			else
				write("      "+cc+", // "+c.getDefinition()+"\r\n");
		}
		write("    }\r\n");
		write("\r\n");
	
	}

	private void generateType(ElementDefn e) throws Exception {
		String tn = typeNames.get(e);
		
		write("    public class "+tn+" : Element\r\n    {\r\n");
		if (hasLists(e)) {
			write("      public "+tn+"()\r\n");
			write("      {\r\n");
			for (ElementDefn c : e.getElements()) {
				if (c.unbounded()) {
					write("        "+getElementName(c.getName())+" = new List<"+typeNames.get(c)+">();\r\n");					
				}
			}
			write("      }\r\n");
			write("\r\n");
			
		}
		for (ElementDefn c : e.getElements()) {
			generateField(c, "      ");
		}

		write("    }\r\n");
		write("\r\n");
		
	}

	private boolean hasLists(ElementDefn e) {
		for (ElementDefn c : e.getElements()) {
			if (c.unbounded())
				return true;
		}
		return false;
	}

	private void scanNestedTypes(ElementDefn root, String path, ElementDefn e, Map<String, ConceptDomain> conceptDomains) throws Exception {
		String tn = null;
		if (e.typeCode().equals("code") && e.hasConceptDomain()) {
			ConceptDomain cd = getConceptDomain(conceptDomains, e.getConceptDomain());
			if (cd != null && cd.getBinding() == ConceptDomain.Binding.CodeList) {
				tn = getCodeListType(cd.getReference());
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

	private ConceptDomain getConceptDomain(Map<String, ConceptDomain> conceptDomains, String conceptDomain) {
		for (ConceptDomain cd : conceptDomains.values())
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
			write(indent+"public List<"+tn+"> "+getElementName(e.getName())+" { get; private set; }\r\n");
			write("\r\n");
		} else {
			write(indent+"/**\r\n");
			write(indent+" * "+e.getDefinition()+"\r\n");
			write(indent+" */\r\n");
			write(indent+"public "+tn+" "+getElementName(e.getName())+" { get; set; }\r\n");
			write("\r\n");
		}

	}

	private String getTitle(String name) {
		return name.substring(0, 1).toUpperCase()+ name.substring(1);
	}

	private String getElementName(String name) {
		if (Utilities.isCSharpReservedWord(name))
			return name+"_";
		return name.replace("[x]", "");
	}

	private String getTypeName(ElementDefn e) throws Exception {
		if (e.getTypes().size() > 1) {
			return "Type";
		} else if (e.getTypes().size() == 0) {
			throw new Exception("not supported");
		} else {
			return getTypename(e.getTypes().get(0));
		}
	}

	private String getTypename(TypeDefn type) throws Exception {
		if (type.getParams().size() == 1) {			
			if (type.getName().equals("Resource"))
				return "ResourceReference<"+getTypeName(type.getParams().get(0))+">";
			else if (type.getName().equals("Interval"))
				return "Interval<"+getTypeName(type.getParams().get(0))+">";
			else
				throw new Exception("not supported");
		} else if (type.getParams().size() > 1) {
			if (type.getName().equals("Resource"))
				return "ResourceReference<Resource>";
			else
				throw new Exception("not supported");
		} else {
			return getTypeName(type.getName());
		}
	}

	private String getTypeName(String tn) {
		if (tn.equals("string")) {
			return "String_";
		} else if (tn.equals("Any")) {
			return "Resource";
		} else {
			return getTitle(tn);
		}
	}


}
