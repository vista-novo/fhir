package org.hl7.fhir.definitions.generators.specification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.utilities.Utilities;

public class MappingsGenerator {

	String mappings;
	String mappingsList;
	
	public void generate(ResourceDefn resource) {
		StringBuilder s = new StringBuilder();
		List<String> maps = new ArrayList<String>();
		listKnownMappings(resource.getRoot(), maps);
		Collections.sort(maps);
		StringBuilder list = new StringBuilder();
		for (String m : maps) {
			list.append("|"+titleFor(m) + "#"+m);

			s.append("<a name=\""+m+"\"> </a><h3>Mappings for "+m.toUpperCase()+"</h3>");
			s.append("<table class=\"grid\">\r\n");
			genElement(s, 0, resource.getRoot(), m, true);
			s.append("</table>\r\n");
		}
	  mappings = s.toString();
	  mappingsList = list.length() == 0 ? "" : list.toString().substring(1);
	}

	public void generate(List<ElementDefn> elements) {
		StringBuilder s = new StringBuilder();
		List<String> maps = new ArrayList<String>();
		for (ElementDefn e : elements)
			listKnownMappings(e, maps);
		Collections.sort(maps);

		StringBuilder list = new StringBuilder();
		boolean first = true;
		for (String m : maps) {
			list.append("|"+titleFor(m) + "#"+m);
			s.append("<a name=\""+m+"\"> </a>\r\n");
			s.append("<h3>Mappings for "+titleFor(m)+"</h3>\r\n");
			s.append("<table class=\"grid\">\r\n");
			for (ElementDefn e : elements) 
				if (elementHasMapping(e, m)) {
				  genElement(s, 0, e, m, first);
				  first = false;
				}
			s.append("</table>\r\n");
		}
	  mappings = s.toString();
	  mappingsList = list.toString().substring(1);
	}
	

	private String titleFor(String m) {
		if (m.equals(ElementDefn.RIM_MAPPING))
			return "RIM";
		if (m.equals(ElementDefn.v2_MAPPING))
			return "HL7 v2";
		if (m.equals(ElementDefn.DICOM_MAPPING))
			return "DICOM";
		if (m.equals(ElementDefn.vCard_MAPPING))
			return "vCard";
		
		return m.toUpperCase();
	}

	private boolean elementHasMapping(ElementDefn e, String m) {
		if (e.getMappings().containsKey(m))
			return true;
		for (ElementDefn child : e.getElements())
			if (elementHasMapping(child, m))
				return true;
			
		return false;
	}

	private void genElement(StringBuilder s, int indent, ElementDefn elem, String m, boolean first) {
		s.append(" <tr><td>");
		for (int i = 0; i < indent; i++) {
			s.append("&nbsp;");
			s.append("&nbsp;");
			s.append("&nbsp;");
			s.append("&nbsp;");
		}
		if (indent == 0) 
  		   s.append("<b>"+elem.getName()+"</b>");
		else
		  s.append(elem.getName());
		s.append("</td><td>"+Utilities.escapeXml(elem.getMappings().get(m)).replace("\n", "<br/>\n")+"</td></tr>\r\n");
		for (ElementDefn child :elem.getElements()) {
			genElement(s, indent+1, child, m, false);
		}
	}

	private void listKnownMappings(ElementDefn e, List<String> maps) {
		for (String s : e.getMappings().keySet())
			if (!maps.contains(s))
				maps.add(s);
		for (ElementDefn c : e.getElements())
			listKnownMappings(c,  maps);		
	}

	public String getMappings() {
		return mappings;
	}

	public String getMappingsList() {
		return mappingsList;
	}

}
