package org.hl7.fhir.definitions.generators.specification;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.utilities.Utilities;

public class XmlSpecGenerator extends OutputStreamWriter {


	public XmlSpecGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(ElementDefn root) throws Exception
	{

		String rn;
		if (root.getTypes().get(0).getName().equals("Type") || (root.getTypes().get(0).getName().equals("Structure")))
			rn = "x";
		else
			rn = root.getName();
		write("<pre>\r\n");

		write("&lt;");
		if (rn == null || "x".equals(rn))
			write("<b>");
		else
			write("<a href=\"#"+root.getName()+"\" title=\""+Utilities.escapeXml(root.getDefinition())+"\" class=\"dict\"><b>");
		write(rn);
		if (rn == null || "x".equals(rn))
			write("</b>");
		else
			write("</b></a>");

		write(" xmlns=\"http://hl7.org/fhir\"&gt;\r\n");

		for (ElementDefn elem : root.getElements())
		{
			generateElem(elem, 1, rn, root.getName());
		}

		write("&lt;/");
		write(rn);
		write("&gt;\r\n");
		write("</pre>\r\n");
		flush();
		close();
	}

	public void generate(ProfileDefn profile) throws Exception {
		generate(profile.getResources().get(0));
	}

	private void generateElem(ElementDefn elem, int indent, String rootName, String pathName) throws Exception {
		//		if ((!elem.unbounded() && 1 == elem.getMaxCardinality()) || elem.isNolist() || Config.SUPPRESS_WRAPPER_ELEMENTS)
		generateCoreElem(elem, indent, rootName, pathName);
		//		else
		//			generateWrapperElem(elem, indent, rootName, pathName);

	}

	//	private void generateWrapperElem(ElementDefn elem, int indent, String rootName,	String pathName) throws Exception {
	//		for (int i= 0; i < indent; i++)
	//		{
	//		  write(" ");
	//		}
	//		write("&lt;"+Utilities.pluralizeMe(elem.getName()));
	//		write(" <font color=\"darkgreen\">type=\"list\"</font>&gt;  <font color=\"Gray\">&lt;!-- "+elem.textForCardinality()+" --&gt;</font>\r\n");
	//		
	//		generateCoreElem(elem, indent+1, rootName, pathName);
	//		
	//		for (int i= 0; i < indent; i++)
	//		{
	//		  write(" ");
	//		}
	//		write("&lt;/"+Utilities.pluralizeMe(elem.getName())+"&gt;\r\n");
	//	}


	private void generateCoreElem(ElementDefn elem, int indent, String rootName, String pathName) throws Exception {
//		if (elem.getConformance() == ElementDefn.Conformance.Prohibited)
//			return;

		boolean listed = false;
		for (int i= 0; i < indent; i++)
		{
			write(" ");
		}
		if (elem.isInherited())
		  write("<i class=\"inherited\">");
		String en = elem.getName();
		if (en.contains("[x]") && elem.getTypes().size() == 1 && !elem.typeCode().equals("*"))
			en = en.replace("[x]", elem.typeCode());

		// Contents of element are defined elsewhere in the same resource
		if (en.equals("#"))
		{
			write(" <font color=\"Gray\">&lt;!-- Content as for "+elem.typeCode().substring(1)+" --&gt;</font>\r\n");
			return;
		}

		if (rootName == null || "x".equals(rootName))
			write("&lt;");
		else if (elem.isMustUnderstand() || elem.isMustSupport() )
      write("&lt;<a href=\"#"+pathName+"."+en+"\" title=\""+Utilities.escapeXml(elem.getDefinition() +" (this element must be supported or understood)")+"\" class=\"dict\"><u>");
		else 
			write("&lt;<a href=\"#"+pathName+"."+en+"\" title=\""+Utilities.escapeXml(elem.getDefinition())+"\" class=\"dict\">");

		// element contains xhtml
		if (elem.typeCode().equals("xhtml")) 
		{
			write("<b>div</b> xmlns=\"http://www.w3.org/1999/xhtml\"> <font color=\"Gray\">&lt;!--</font> <a href=\"xml.htm#Control\" class=\"cf\">mand</a> <font color=\"navy\">"+Utilities.escapeXml(elem.getShortDefn())+"</font><font color=\"Gray\">&lt; --&gt;</font> &lt;/div&gt;\r\n");
		} 
		// element has a constraint which fixes its value
		else if (elem.hasValue()) 
		{
		  if (elem.isMustUnderstand() || elem.isMustSupport() )
		    write(en+"</u></a>&gt;");
		  else
		    write(en+"</a>&gt;");
		        
			if (elem.typeCode().equals("CodeableConcept"))
			  write(renderCodeableConcept(indent, elem.getValue())+"&lt;"+en+"/&gt;\r\n");
			else if (elem.typeCode().equals("Quantity"))
				write(renderQuantity(indent, elem.getValue())+"&lt;"+en+"/&gt;\r\n");
			else
				write(elem.getValue()+"&lt;"+en+"/&gt;\r\n");
		} 
		else 
		{
		  write("<b>"+en);
			if (rootName == null || "x".equals(rootName))
				write("</b>");
  	  else if (elem.isMustUnderstand() || elem.isMustSupport() )
        write("</b></u></a>");
	    else     
				write("</b></a>");
//			disable 18-May 2012 Grahame - don't recall why we mark an element as having an id or not, and appears to be non-functional
//			if (elem.getId() != null)
//			{
//				write(" id=\""+elem.getId()+"\"");
//			}
			if (elem.isAllowDAR())
			  write(" <font color=\"red\" title=\"dataAbsentReason attribute is allowed\">d?</font>");
			write("&gt;");
			
			// If this is an unrolled element, show its profile name
			if (elem.getProfileName() != null && !elem.getProfileName().equals(""))
				write(" <font color=\"Gray\">&lt;!--</font> <font color=\"blue\">\""+elem.getProfileName()+"\"</font>  <font color=\"Gray\"> --&gt;</font>");
	
			// For simple elements without nested content, render the optionality etc. within a comment
			if( elem.getElements().isEmpty())
				write("<font color=\"Gray\">&lt;!--</font>");
//			if (elem.getConformance() != ElementDefn.Conformance.Unstated)
//			{
//				write(" ");
//				write("<a href=\"xml.htm#Control\" class=\"cf\">" + elem.getConformance().code() + "</a>");
//			}

			if( elem.hasAggregation() )
			{
				write(" aggregated");
			}
						
			if (elem.typeCode().startsWith("@")) {
        writeCardinality(elem);
        listed = true;
			} else if (!elem.getTypes().isEmpty()  &&
					!(elem.getTypes().size() == 1 && elem.getTypes().get(0).getName().equals("*")))
			{
  	    writeCardinality(elem);
			  listed = true;
				write(" <font color=\"darkgreen\">");
				int i = 0;
				int d = elem.getTypes().size() / 2;
				for (TypeDefn t : elem.getTypes())
				{
					if (i > 0)
						write("|");
					if (elem.getTypes().size() > 5 && i == d)
						write("\r\n              ");
					if (t.getName().equals("xhtml") || t.getName().equals("list"))
						write(t.getName());
//					else if (!t.getName().equals("Resource"))
//					  write("<a href=\""+getSrcFile(t.getName())+".htm#"+t.getName()+"\">Resource</a>");
					else
					  write("<a href=\""+getSrcFile(t.getName())+".htm#"+t.getName()+"\">"+t.getName()+"</a>");
					if (t.hasParams()) 
					{
						write("(");
						boolean firstp = true;
						for (String p : t.getParams()) {
							if (!firstp)
								write("|");
							
							//TODO: There has to be an aggregation specification per t.getParams()
							if( elem.hasAggregation() )
							{
								//TODO: This should link to the documentation of the profile as specified
								//in the aggregation. For now it links to the base resource.
								write("<a href=\""+getSrcFile(p)+".htm#"+p+"\">"+elem.getAggregation()+"</a>");
							}
							else
								write("<a href=\""+getSrcFile(p)+".htm#"+p+"\">"+p+"</a>");
							
							firstp = false;
						}
						write(")");
					}
					
					
					i++;
				}
				write("</font>");
			} else if (elem.getName().equals("extensions")) {
				write(" <a href=\"extensibility.htm\"><font color=\"navy\">See Extensions</font></a> ");
			} else if (elem.getTypes().size() == 1 && elem.getTypes().get(0).getName().equals("*")) {
        writeCardinality(elem);
        listed = true;
			}

			write(" ");
			if (elem.getElements().isEmpty())
			{
				if ("See Extensions".equals(elem.getShortDefn()))
					write(" <a href=\"extensibility.htm\"><font color=\"navy\">"+Utilities.escapeXml(elem.getShortDefn())+"</font></a> ");
				else {
					write("<font color=\"navy\">"+Utilities.escapeXml(elem.getShortDefn())+"</font>");
				}
			}
			else
			{
				if (elem.unbounded() && !listed) { // isNolist()) {
					if (elem.typeCode().startsWith("@")) {
						write(" <font color=\"Gray\">&lt;!--");
						writeCardinality(elem);
						write(""+Utilities.escapeXml(elem.getShortDefn())+" --&gt;</font>");
					} else if (elem.hasShortDefn()) {
					  write(" <font color=\"Gray\">&lt;!--");
            writeCardinality(elem);
					  write(" "+Utilities.escapeXml(elem.getShortDefn())+" --&gt;</font>");
					} else {
					  write(" <font color=\"Gray\">&lt;!--");
            writeCardinality(elem);
					  write(" --&gt;</font>");
					}
				} else if (elem.hasShortDefn())
					write(" <font color=\"Gray\">&lt;!-- "+Utilities.escapeXml(elem.getShortDefn())+" --&gt;</font>");
				write("\r\n");

				for (ElementDefn child : elem.getElements())
				{
					generateElem(child, indent + 1, rootName, pathName+"."+en);
				}

				for (int i= 0; i < indent; i++)
				{
					write(" ");
				}
			}

			if( elem.getElements().isEmpty())
					write("<font color=\"Gray\"> --&gt;</font>");
			write("&lt;/");
			write(en);
			write("&gt;");
	    if (elem.isInherited())
	      write("</i>");
      write("\r\n");

		}
	}

  private void writeCardinality(ElementDefn elem) throws IOException {
    if (elem.getInvariant() != null)
      write(" <font color=\"deeppink\" title=\""+Utilities.escapeXml(elem.getInvariant().getEnglish())+"\"><b>"+elem.describeCardinality()+"</b></font>");
    else
      write(" <font color=\"brown\"><b>"+elem.describeCardinality()+"</b></font>");
  }


	private String renderCodeableConcept(int indent, String value) throws Exception {
		StringBuilder s = new StringBuilder();
		for (int i= 0; i < indent; i++)
			s.append(" ");
		String ind = s.toString();
		s = new StringBuilder();
		String[] parts = value.split("#");
		if (parts.length != 2)
			throw new Exception("unable to parse fixed code "+value);
		String sys = parts[0];
		String c = parts[1];
		parts = c.split("\\|");
		if (parts.length != 2)
			throw new Exception("unable to parse fixed code "+value);

		s.append("\r\n"+ind+"  &lt;coding&gt;");  
		s.append("\r\n"+ind+"    &lt;code&gt;"+parts[0]+"&lt;/code&gt;");  
		s.append("\r\n"+ind+"    &lt;system&gt;"+sys+"&lt;/system&gt;");  
		s.append("\r\n"+ind+"    &lt;display&gt;"+parts[1]+"&lt;/display&gt;");  
		s.append("\r\n"+ind+"  &lt;/coding&gt;");  
		s.append("\r\n"+ind);
		return s.toString();
	}

	private String renderQuantity(int indent, String value) throws Exception {
		StringBuilder s = new StringBuilder();
		for (int i= 0; i < indent; i++)
			s.append(" ");
		String ind = s.toString();
		s = new StringBuilder();
		String f = null;
		if (!Character.isDigit(value.charAt(0)))
		{
			f = value.substring(0, 1);
			value = value.substring(1);
		}
		String[] parts = value.split(" ");
		if (parts.length != 2)
			throw new Exception("unable to parse fixed quantity value "+value);
		String v = parts[0];
		String u = parts[1];
		s.append("\r\n"+ind+"  &lt;value&gt;"+v+"&lt;/value&gt;");  
		if (f != null)
			s.append("\r\n"+ind+"  &lt;status&gt;"+Utilities.escapeXml(Utilities.escapeXml(f))+"&lt;/status&gt;");  
		s.append("\r\n"+ind+"  &lt;units&gt;"+u+"&lt;/units&gt;");  
		s.append("\r\n"+ind+"  &lt;code&gt;"+u+"&lt;/code&gt;");  
		s.append("\r\n"+ind+"  &lt;system&gt;urn:hl7-org:sid/ucum&lt;/system&gt;");  
		s.append("\r\n"+ind);
		return s.toString();
	}

	private String getSrcFile(String name) throws Exception {
		if (name == null)
			throw new Exception("unknown null type");
		if (name.equals("Attachment")) return "datatypes"; 	
		if (name.equals("Identifier")) return "datatypes"; 	
		if (name.equals("Interval")) return "datatypes"; 	
		if (name.equals("HumanId")) return "datatypes"; 	
		if (name.equals("Contact")) return "datatypes";
		if (name.equals("CodeableConcept")) return "datatypes"; 	
		if (name.equals("Quantity")) return "datatypes"; 	
		if (name.equals("Ratio")) return "datatypes"; 	
		if (name.equals("HumanName")) return "datatypes"; 	
		if (name.equals("Location")) return "datatypes";
		if (name.equals("Coding")) return "datatypes"; 	
		if (name.equals("Choice")) return "datatypes"; 		
		if (name.equals("Address")) return "datatypes"; 	
		if (name.equals("boolean")) return "datatypes";	
		if (name.equals("integer")) return "datatypes";	
    if (name.equals("decimal")) return "datatypes";
    if (name.equals("instant")) return "datatypes";
		if (name.equals("base64Binary")) return "datatypes";
		if (name.equals("datetime")) return "datatypes";
		if (name.equals("string")) return "datatypes";
		if (name.equals("uri")) return "datatypes";
		if (name.equals("code")) return "datatypes";
		if (name.equals("oid")) return "datatypes";
		if (name.equals("uuid")) return "datatypes";
		if (name.equals("sid")) return "datatypes";
		if (name.equals("id")) return "datatypes";
    if (name.equals("date")) return "datatypes";  
    if (name.equals("dateTime")) return "datatypes";  
		if (name.equals("narrative")) return "xml";
		if (name.equals("Resource")) return "xml";
		if (name.equals("Constraint")) return "constraint";
		if (name.equals("resourceType")) return "terminologies";
		return name;

	}
}
