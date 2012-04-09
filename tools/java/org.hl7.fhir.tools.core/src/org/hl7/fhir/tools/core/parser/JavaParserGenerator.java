package org.hl7.fhir.tools.core.parser;

import java.io.*;
import java.util.*;

import org.hl7.fhir.tools.core.model.*;
import org.hl7.fhir.tools.core.utilities.Utilities;

public class JavaParserGenerator extends JavaGenerator {


	private Map<ElementDefn, String> typeNames = new HashMap<ElementDefn, String>();

	private List<ElementDefn> strucs  = new ArrayList<ElementDefn>();
	
	
	public JavaParserGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out);
	}

	public Map<ElementDefn, String> getTypeNames() {
		return typeNames;
	}

	public void setTypeNames(Map<ElementDefn, String> typeNames) {
		this.typeNames = typeNames;
	}

	public void generate(ElementDefn root, List<ConceptDomain> conceptDomains) throws Exception {

		write("package org.hl7.fhir.instance.parser;\r\n");
		write("\r\n");
		write("import org.xmlpull.v1.XmlPullParser;\r\n");
		write("import org.hl7.fhir.instance.model.*;\r\n");
		if (hasNestedTypes(root, conceptDomains)) {
			write("import org.hl7.fhir.instance.model."+root.getName()+".*;\r\n");
		}
		write("\r\n");
		write("public class "+root.getName()+"Parser extends ResourceParser {\r\n");
		write("\r\n");

		write("    @Override\r\n");
		write("    public Resource parse(XmlPullParser xpp) throws Exception {\r\n");
		write("        "+root.getName()+" resource = new "+root.getName()+"();\r\n");

		write("        parseElementAttributes(xpp, resource);\r\n");
		write("        int eventType = nextNoWhitespace(xpp);\r\n");
		write("        while (eventType != XmlPullParser.END_TAG) {\r\n");
		boolean first = true;
		for (ElementDefn c : root.getElements()) {
			if (c.getTypes().size() == 1) {
				first = generateTypedElement(conceptDomains, first, c, "resource", "");
			} else if (c.getTypes().size() == 1) {
				first = generateMultiTypedElement(conceptDomains, first, c, "resource");
			} else if (c.getName().equals("extensions")){
				first = generateExtensions(first);
			} else {
				first = generateUntypedElement(conceptDomains, first, c, "resource");
			}
		}
		if (!first) {
			write("        	} else\r\n"); 
			write("        		throw new Exception(\"Bad Xml parsing "+root.getName()+"\");\r\n");
			write("        	eventType = nextNoWhitespace(xpp);\r\n");
		}
		write("        }\r\n");
		write("        if (!xpp.getName().equals(\""+root.getName()+"\"))\r\n");
		write("        	throw new Exception(\"problem reading XML at end of "+root.getName()+"\");\r\n");
		write("        return resource;\r\n");
		write("    }\r\n");
		write("\r\n");

		while (strucs.size() > 0) {
			generateType(root, strucs.get(0), conceptDomains);
			strucs.remove(0);
		}
		write("\r\n");
		write("}\r\n");
		write("\r\n");
		flush();

	}

	public void generateType(ElementDefn root, ElementDefn e, List<ConceptDomain> conceptDomains) throws Exception {
		String tn = typeNames.get(e);

		if (e.getElements().size() == 1 && e.getElements().get(0).getName().equals("#"))
			return;
		
		write("    public "+root.getName()+"."+tn+" parse"+tn+"(XmlPullParser xpp, "+root.getName()+" resource) throws Exception {\r\n");
		write("        "+root.getName()+"."+tn+" elem = resource.new "+tn+"();\r\n");

		write("        parseElementAttributes(xpp, elem);\r\n");
		write("        int eventType = nextNoWhitespace(xpp);\r\n");
		write("        while (eventType != XmlPullParser.END_TAG) {\r\n");
		boolean first = true;
		for (ElementDefn c : e.getElements()) {
			if (c.getTypes().size() == 1) {
				first = generateTypedElement(conceptDomains, first, c, "elem", root.getName()+".");
			} else if (c.getTypes().size() > 1) {
				first = generateMultiTypedElement(conceptDomains, first, c, "elem");
			} else {
				first = generateUntypedElement(conceptDomains, first, c, "elem");
			}
		}
		if (!first) {
			write("        	} else\r\n"); 
			write("        		throw new Exception(\"Bad Xml parsing "+e.getName()+"\");\r\n");
			write("        	eventType = nextNoWhitespace(xpp);\r\n");
		}
		write("        }\r\n");
		write("        return elem;\r\n");
		write("    }\r\n");
		write("\r\n");
	}

	public boolean generateExtensions(boolean first) throws Exception {
		if (first)
			write("        	if ");
		else
			write("        	} else if ");
		first = false;
		
		write("(eventType == XmlPullParser.START_TAG && xpp.getName().equals(\"extensions\")) {\r\n");

		write("        	    eventType = nextNoWhitespace(xpp);\r\n");
		write("        	    while (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\"extension\")) {\r\n");
		write("        	    	resource.getExtensions().add(parseExtension(xpp));\r\n");
		write("        	    	eventType = nextNoWhitespace(xpp);\r\n");
		write("        	    }\r\n");
		write("        	    if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals(\"extensions\"))\r\n");
		write("        	    	throw new Exception(\"XML Error in extensions\");\r\n");

		return first;
	}

	private boolean generateTypedElement(List<ConceptDomain> conceptDomains, boolean first, ElementDefn c, String focus, String prefix) throws IOException, Exception {
		if (first)
			write("        	if ");
		else
			write("        	} else if ");
		first = false;
		String tn = getTypeName(c);
		String p;
		if (tn.contains("<")) {
			String pn;
			if (c.getTypes().get(0).getParams().size() == 1)
				pn = getTypeName(c.getTypes().get(0).getParams().get(0));
			else
				pn = "Resource";
					
			if (c.getTypes().get(0).getName().equals("Interval"))
				p = "parseInterval(xpp, new Interval<"+pn+">(\""+pn+"\"))";
			else 
				p = "parseResourceReference(xpp, new ResourceReference<"+pn+">(\""+pn+"\"))";
		} else {
			String en = getEnumName(c, conceptDomains);
			if (en != null)
				p = prefix+en+".fromCode(parseString(xpp))";
			else
				p = "parse"+tn+"(xpp)";
		}
		if (c.unbounded()) {
			String enp = Utilities.pluralize(c.getName());
			write("(eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+enp+"\")) {\r\n");
			write("        		eventType = nextNoWhitespace(xpp);\r\n");
			write("        		while (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+c.getName()+"\")) {\r\n");
			write("        			"+focus+".get"+getTitle(getElementName(c.getName()))+"().add("+p+");\r\n");
			write("        			eventType = nextNoWhitespace(xpp);\r\n");
			write("        		}\r\n"); 
			write("        		if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals(\""+enp+"\"))\r\n"); 
			write("        			throw new Exception(\"XML Error in "+enp+"\");\r\n");
			
			// 					write("        		resource.get"+getTitle(getElementName(c.getName()))+"().add("+p+");\r\n");
		} else {
			write("(eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+c.getName()+"\")) {\r\n");
			write("        		"+focus+".set"+getTitle(getElementName(c.getName()))+"("+p+");\r\n");
		}
		return first;
	}

	private boolean generateMultiTypedElement(List<ConceptDomain> conceptDomains, boolean first, ElementDefn c, String focus) throws IOException, Exception {
		for (TypeDefn t : c.getTypes()) {
			if (first)
				write("        	if ");
			else
				write("        	} else if ");
			first = false;
			String tn = getTypename(t);
			String en = c.getName().replace("[x]", tn).replace("_", "").replace("<", "_").replace(">", "");
			String p;
			if (tn.contains("<")) {
				String pn;
				if (t.getParams().size() == 1)
					pn = getTypeName(t.getParams().get(0));
				else
					pn = "Resource";

				if (t.getName().equals("Interval"))
					p = "parseInterval(xpp, new Interval<"+pn+">(\""+pn+"\"))";
				else {
					System.out.println(t.getName());
					p = "parseResourceReference(xpp, new ResourceReference<"+pn+">(\""+pn+"\"))";
				}
			} else {
					p = "parse"+tn+"(xpp)";
			}

//			if (c.unbounded()) {
//				String enp = Utilities.pluralize(en);
//				write("(eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+enp+"\")) {\r\n");
//				write("        		eventType = nextNoWhitespace(xpp);\r\n");
//				write("        		while (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+en+"\")) {\r\n");
//				write("        			resource.get"+getTitle(getElementName(en))+"().add("+p+");\r\n");
//				write("        			eventType = nextNoWhitespace(xpp);\r\n");
//				write("        		}\r\n"); 
//				write("        		if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals(\""+enp+"\"))\r\n"); 
//				write("        			throw new Exception(\"XML Error in "+enp+"\");\r\n");
//
//				// 					write("        		resource.get"+getTitle(getElementName(c.getName()))+"().add("+p+");\r\n");
//			} else {
				write("(eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+en+"\")) {\r\n");
				write("        		"+focus+".set"+getTitle(getElementName(c.getName()))+"("+p+");\r\n");
//			}
		}
		return first;
	}

	private boolean generateUntypedElement(List<ConceptDomain> conceptDomains, boolean first, ElementDefn c, String focus) throws IOException, Exception {
		if (first)
			write("        	if ");
		else
			write("        	} else if ");
		first = false;
		String tn = typeNames.get(c);
		String p = "parse"+tn+"(xpp, resource)";
		strucs.add(c);
		if (c.unbounded()) {
			String enp = Utilities.pluralize(c.getName());
			write("(eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+enp+"\")) {\r\n");
			write("        		eventType = nextNoWhitespace(xpp);\r\n");
			write("        		while (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+c.getName()+"\")) {\r\n");
			write("        			"+focus+".get"+getTitle(getElementName(c.getName()))+"().add("+p+");\r\n");
			write("        			eventType = nextNoWhitespace(xpp);\r\n");
			write("        		}\r\n"); 
			write("        		if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals(\""+enp+"\"))\r\n"); 
			write("        			throw new Exception(\"XML Error in "+enp+"\");\r\n");
		} else {
			write("(eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+c.getName()+"\")) {\r\n");
			write("        		"+focus+".set"+getTitle(getElementName(c.getName()))+"("+p+");\r\n");
		}
		return first;
	}

    private boolean hasNestedTypes(ElementDefn root, List<ConceptDomain> conceptDomains) {
    	for (ElementDefn e : root.getElements()) {
    		if (getEnumName(e, conceptDomains) != null)
    			return true;
    	}
		return false;
	}

	private String getEnumName(ElementDefn e, List<ConceptDomain> conceptDomains) {
		if (e.typeCode().equals("code") && e.hasConceptDomain()) {
			ConceptDomain cd = getConceptDomain(conceptDomains, e.getConceptDomain());
			if (cd != null && cd.getBindingType() == BindingType.CodeList) {
				return getCodeListType(cd.getBinding());
			}
		}
		return null;
   
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

}
