package org.hl7.fhir.definitions.generators.specification;

import java.io.*;

import org.hl7.fhir.definitions.model.*;
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
			write("<a href=\"#"+root.getName()+"\" title=\""+root.getDefinition()+"\" class=\"dict\"><b>");
		write(rn);
		if (rn != null)
			write("</b></a>");
		else
			write("</b>");
			
		write(" xmlns=\"http://www.hl7.org/fhir\"&gt;\r\n");
		
		for (ElementDefn elem : root.getElements())
		{
		  generateElem(elem, 2, rn, root.getName());
		}

		write("&lt;/");
		write(rn);
		write("&gt;\r\n");
		write("</pre>\r\n");
		flush();
		close();
	}

	private void generateElem(ElementDefn elem, int indent, String rootName, String pathName) throws Exception {
		if ((!elem.unbounded() && 1 == elem.getMaxCardinality()) || elem.isNolist())
			generateCoreElem(elem, indent, rootName, pathName);
		else
			generateWrapperElem(elem, indent, rootName, pathName);
		
	}
	
	private void generateWrapperElem(ElementDefn elem, int indent, String rootName,	String pathName) throws Exception {
		for (int i= 0; i < indent; i++)
		{
		  write(" ");
		}
		write("&lt;"+Utilities.pluralize(elem.getName()));
		write(" <font color=\"darkgreen\">type=\"list\"</font>&gt;  <font color=\"Gray\">&lt;!-- "+elem.textForCardinality()+" --&gt;</font>\r\n");
		
		generateCoreElem(elem, indent+1, rootName, pathName);
		
		for (int i= 0; i < indent; i++)
		{
		  write(" ");
		}
		write("&lt;/"+Utilities.pluralize(elem.getName())+"&gt;\r\n");
	}


	private void generateCoreElem(ElementDefn elem, int indent, String rootName, String pathName) throws Exception {
		for (int i= 0; i < indent; i++)
		{
		  write(" ");
		}
		
		if (elem.getName().equals("#"))
		{
			write("<font color=\"Gray\">&lt;!-- <a style=\"color: grey;\" href=\""+getSrcFile(elem.getTypes().get(0).getName().substring(1))+".htm"+elem.getTypes().get(0).getName()+"\">"+Utilities.escapeXml(elem.getShortDefn())+"</a> --&gt;</font>\r\n");
			return;
		}
		if (rootName == null || "x".equals(rootName))
		    write("&lt;<b>");
		else
			write("&lt;<a href=\"#"+pathName+"."+elem.getName()+"\" title=\""+Utilities.escapeXml(elem.getDefinition())+"\" class=\"dict\"><b>");
		write(elem.getName());
		if (rootName != null)
			write("</b></a>");
		else
			write("</b>");
		if (elem.getId() != null)
		{
			write(" id=\""+elem.getId()+"\"");
		}
		write("&gt;");
		if (elem.getConformance() != ElementDefn.Conformance.Unstated)
		{
			write(" ");
			write("<a href=\"xml.htm#Control\" class=\"cf\">" + elem.getConformance().code() + "</a>");
		}
		
		if (!elem.getTypes().isEmpty() && !(elem.getTypes().size() == 1 && elem.getTypes().get(0).getName().equals("*")))
		{
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
				else
				  write("<a href=\""+getSrcFile(t.getName())+".htm#"+t.getName()+"\">"+t.getName()+"</a>");
				if (t.hasParams()) 
				{
					write("(");
					boolean firstp = true;
					for (String p : t.getParams()) {
						if (!firstp)
							write("|");
						write("<a href=\""+getSrcFile(p)+".htm#"+p+"\">"+p+"</a>");
						firstp = false;
					}
					write(")");
				}
				i++;
			}
			write("</font>");
		}
		
		write(" ");
		if (elem.getElements().isEmpty())
		{
			if ("See Extensions".equals(elem.getShortDefn()))
				write(" <a href=\"extensibility.htm\"><font color=\"navy\">"+Utilities.escapeXml(elem.getShortDefn())+"</font></a> ");
			else
			write("<font color=\"navy\">"+Utilities.escapeXml(elem.getShortDefn())+"</font>");
			write("&lt;/");
			write(elem.getName());
			write("&gt;\r\n");
		}
		else
		{
			if (elem.isNolist()) {
				if (elem.hasShortDefn())
					write("  <font color=\"Gray\">&lt;!-- "+elem.textForCardinality()+" "+Utilities.escapeXml(elem.getShortDefn())+" --&gt;</font>");
				else
					write("  <font color=\"Gray\">&lt;!-- "+elem.textForCardinality()+" --&gt;</font>");
			} else if (elem.hasShortDefn())
				write("  <font color=\"Gray\">&lt;!-- "+Utilities.escapeXml(elem.getShortDefn())+" --&gt;</font>");
			write("\r\n");

			for (ElementDefn child : elem.getElements())
			{
				generateElem(child, indent + 1, rootName, pathName+"."+elem.getName());
			}
			
			for (int i= 0; i < indent; i++)
			{
			  write(" ");
			}
			write("&lt;/");
			write(elem.getName());
			write("&gt;\r\n");

		}
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
		if (name.equals("base64Binary")) return "datatypes";
		if (name.equals("datetime")) return "datatypes";
		if (name.equals("string")) return "datatypes";
		if (name.equals("uri")) return "datatypes";
		if (name.equals("code")) return "datatypes";
		if (name.equals("oid")) return "datatypes";
		if (name.equals("uuid")) return "datatypes";
		if (name.equals("sid")) return "datatypes";
		if (name.equals("id")) return "datatypes";
		if (name.equals("humanDate")) return "datatypes";	
		if (name.equals("narrative")) return "xml";
		if (name.equals("Resource")) return "xml";
		if (name.equals("Constraint")) return "constraint";
		if (name.equals("resourceType")) return "terminologies";
			return name;
			
	}
}
