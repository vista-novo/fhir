package org.hl7.fhir.definitions.generators.specification;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.utilities.Utilities;

public class DictHTMLGenerator  extends OutputStreamWriter {

			
	public DictHTMLGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(ElementDefn root) throws Exception
	{
		write("<table class=\"dict\">\r\n");
		writeEntry(root.getName(), "1..1", "", "", root);
		for (ElementDefn e : root.getElements()) {
		   generateElement(root.getName(), e);
		}
		write("</table>\r\n");
		write("\r\n");
		flush();
		close();
	}

	private void generateElement(String name, ElementDefn e) throws IOException {
		writeEntry(name+"."+e.getName(), e.describeCardinality(), describeType(e), e.getBindingName(), e);
		for (ElementDefn c : e.getElements())	{
		   generateElement(name+"."+e.getName(), c);
		}
	}

	private void writeEntry(String path, String cardinality, String type, String conceptDomain, ElementDefn e) throws IOException {
		write("  <tr><td colspan=\"2\" class=\"structure\"><b>"+path+"</b></td></tr>\r\n");
		tableRow("Definition", e.getDefinition());
		tableRow("Control", cardinality + (e.hasCondition() ? ": "+  e.getCondition(): ""));
		tableRow("Type", type + (conceptDomain != "" ? " from "+conceptDomain : ""));
		tableRow("Must Understand", displayBoolean(e.isMustUnderstand()));
		tableRow("Requirements", e.getRequirements());
		tableRow("Comments", e.getComments());
		tableRow("RIM Mapping", e.getRimMapping());
		tableRow("v2 Mapping", e.getV2Mapping());
		tableRow("To Do", e.getTodo());
		
	}
	
	private String displayBoolean(boolean mustUnderstand) {
		if (mustUnderstand)
			return "true";
		else
			return null;
	}

	private void tableRow(String name, String value) throws IOException {
		if (value != null && !"".equals(value))
			write("  <tr><td>"+name+"</td><td>"+Utilities.escapeXml(value)+"</td></tr>\r\n");
	}

	

	private String describeType(ElementDefn e) {
		StringBuilder b = new StringBuilder();
		boolean first = true;
		for (TypeRef t : e.getTypes())
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
          }		  first = false;
		}
		return b.toString();
	}
	
}
