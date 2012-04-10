package org.hl7.fhir.tools.core.parser;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.tools.core.model.ElementDefn;
import org.hl7.fhir.tools.core.model.TypeDefn;

public class CSVGenerator extends OutputStreamWriter {

			
	public CSVGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(ElementDefn root) throws Exception
	{
		write("Element,Card.,Conf.,Type,Concept Domain,Must Understand,Short Name,Definition,Requirements,Comments,RIM Mapping,v2 Mapping,To Do,Committee Notes\r\n");

		write(""+root.getName()+",1..1,Mandatory,,,,,"+checkNull(root.getDefinition())+","+checkNull(root.getRequirements())+","+checkNull(root.getComments())+","+checkNull(root.getRimMapping())+","+checkNull(root.getV2Mapping())+","+checkNull(root.getTodo())+","+checkNull(root.getCommitteeNotes())+"\r\n");
		for (ElementDefn e : root.getElements()) {
		   generateElement(root.getName(), e);
		}
		flush();
	}

	private void generateElement(String name, ElementDefn e) throws IOException {
		write(name+"."+e.getName()+","+e.describeCardinality()+","+e.getConformance().fullName()+","+checkNull(describeType(e))+","+checkNull(e.getConceptDomain())+","+checkBoolean(e.isMustUnderstand())+","+e.getShortDefn()+","+checkNull(e.getDefinition())+","+checkNull(e.getRequirements())+","+checkNull(e.getComments())+","+checkNull(e.getRimMapping())+","+checkNull(e.getV2Mapping())+","+checkNull(e.getTodo())+","+checkNull(e.getCommitteeNotes())+"\r\n");
		for (ElementDefn c : e.getElements())	{
		   generateElement(name+"."+e.getName(), c);
		}
	}


	private String checkBoolean(boolean mustUnderstand) {
		if (mustUnderstand)
			return "true";
		else 
			return "";
	}

	private String checkNull(String s) {
		if (s == null || "".equals(s))
			return "";
		else
		   return "\""+s+"\"";
	}

	private String describeType(ElementDefn e) {
		StringBuilder b = new StringBuilder();
		boolean first = true;
		for (TypeDefn t : e.getTypes())
		{
		  if (!first)
			  b.append("|");
          b.append(t.getName());
          if (t.hasParams()) {
              b.append("(");
              boolean firstp = true;
              for (String p : t.getParams()) {
            	  if (!firstp)
            		  b.append("|");
            	  b.append(p);
            	  firstp = false;
              }
              b.append(")");
          }
		  first = false;
		}
		return b.toString();
	}
	

}
