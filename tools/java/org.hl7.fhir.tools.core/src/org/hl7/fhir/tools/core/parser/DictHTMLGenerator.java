package org.hl7.fhir.tools.core.parser;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.tools.core.model.Conformance;
import org.hl7.fhir.tools.core.model.ElementDefn;
import org.hl7.fhir.tools.core.model.TypeDefn;
import org.hl7.fhir.tools.core.utilities.Utilities;

public class DictHTMLGenerator  extends OutputStreamWriter {

			
	public DictHTMLGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(ElementDefn root) throws Exception
	{
		write("<table class=\"dict\">\r\n");
		writeEntry(root.getName(), "1..1", Conformance.Mandatory, "", "", root);
		for (ElementDefn e : root.getElements()) {
		   generateElement(root.getName(), e);
		}
		write("</table>\r\n");
		write("\r\n");
		flush();
	}

	private void generateElement(String name, ElementDefn e) throws IOException {
		writeEntry(name+"."+e.getName(), e.describeCardinality(), e.getConformance(), describeType(e), e.getConceptDomain(), e);
		for (ElementDefn c : e.getElements())	{
		   generateElement(name+"."+e.getName(), c);
		}
	}

	private void writeEntry(String path, String cardinality, Conformance conformance, String type, String conceptDomain, ElementDefn e) throws IOException {
		write("  <tr><td colspan=2 class=\"structure\"><a name=\""+path+"\"></a>"+path+"</td></tr>\r\n");
		tableRow("Definition", e.getDefinition());
		tableRow("Cardinality", cardinality);
		tableRow("Conformance", conformance.fullName());
		tableRow("Condition", e.getCondition());
		tableRow("Type", type);
		tableRow("Concept Domain", conceptDomain);
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
          }		  first = false;
		}
		return b.toString();
	}
	
}
