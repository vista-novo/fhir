package org.hl7.fhir.definitions.generators.specification;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.ConceptDomain;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.utilities.Utilities;

public class DictXMLGenerator  extends OutputStreamWriter {

			
	private Map<String, ConceptDomain> conceptDomains;

	public DictXMLGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(Collection<ElementDefn> roots, String author) throws Exception
	{
		write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		write("<resourceDefinitions xmlns=\"http://www.hl7.org/fhir\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.hl7.org/fhir definitions.xsd\">\r\n");
		write("  <author>"+author+"</author>\r\n");
		
		for (ElementDefn root : roots) {
			write("  <resourceDefinition>\r\n");
			write("    <name>"+root.getName()+"</name>\r\n");
			write("    <elementDefinitions>\r\n");
			
			writeEntry(root.getName(), 1, 1, ElementDefn.Conformance.Mandatory, null, "", root);
			for (ElementDefn e : root.getElements()) {
			   generateElement(root.getName(), e);
			}
			
			write("    </elementDefinitions>\r\n");
			write("  </resourceDefinition>\r\n");
		}
		if (conceptDomains != null) {
			for (ConceptDomain cd : conceptDomains.values()) {
				generateConceptDomain(cd);
			}
		}
		write("</resourceDefinitions>\r\n");
		write("\r\n");
		flush();
	}

	private void generateConceptDomain(ConceptDomain cd) throws Exception {
		write("  <conceptDomain>\r\n");
		write("    <name>"+Utilities.escapeXml(cd.getName())+"</name>\r\n");
		write("    <definition>"+Utilities.escapeXml(cd.getDefinition())+"</definition>\r\n");
		write("    <binding>"+cd.getBindingType().toString()+"</binding>\r\n");
		if (cd.getBindingType() == ConceptDomain.BindingType.CodeList) {
			write("    <list>\r\n");
			write("      <sid>urn:hl7-org:sid/fhir/"+cd.getBinding()+"</sid>\r\n");
			for (DefinedCode c : cd.getCodes()) {
				write("      <item>\r\n");
				write("        <code>"+Utilities.escapeXml(c.getCode())+"</code>\r\n");
				if (c.hasDefinition())
					write("        <definition>"+Utilities.escapeXml(c.getDefinition())+"</definition>\r\n");
				if (c.hasComment())
					write("        <comments>"+Utilities.escapeXml(c.getComment())+"</comments>\r\n");
				write("      </item>\r\n");
			}
			write("    </list>\r\n");
		} else if (cd.getBindingType() == ConceptDomain.BindingType.Unbound) {
		
		} else if (cd.getBindingType() == ConceptDomain.BindingType.External) {
			write("    <description>"+Utilities.escapeXml(cd.getBinding())+"</description>\r\n");
			write("    <reference>"+Utilities.escapeXml(cd.getDetails())+"</reference>\r\n");
		} else if (cd.getBindingType() == ConceptDomain.BindingType.Preferred) {
			write("    <source>"+Utilities.escapeXml(cd.getBinding())+"</source>\r\n");
		} else if (cd.getBindingType() == ConceptDomain.BindingType.Reference) {
			write("    <source>"+Utilities.escapeXml(cd.getBinding())+"</source>\r\n");
		} else if (cd.getBindingType() == ConceptDomain.BindingType.Special) {
			write("    <value>"+Utilities.escapeXml(cd.getBinding())+"</value>\r\n");
		} else if (cd.getBindingType() == ConceptDomain.BindingType.Suggestion) {
			write("    <source>"+Utilities.escapeXml(cd.getBinding())+"</source>\r\n");
		} else
			throw new Exception("Unknown binding type "+cd.getBindingType().toString());
		
		write("  </conceptDomain>\r\n");
		
	}

	public void generate(ElementDefn root, String author) throws Exception
	{
		write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		write("<resourceDefinitions xmlns=\"http://www.hl7.org/fhir\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.hl7.org/fhir definitions.xsd\">\r\n");
		write("  <author>"+author+"</author>\r\n");
		write("  <resourceDefinition>\r\n");
		write("    <name>"+root.getName()+"</name>\r\n");
		write("    <elementDefinitions>\r\n");
		
		writeEntry(root.getName(), 1, 1, ElementDefn.Conformance.Mandatory, null, "", root);
		for (ElementDefn e : root.getElements()) {
		   generateElement(root.getName(), e);
		}
		
		write("    </elementDefinitions>\r\n");
		write("  </resourceDefinition>\r\n");
		write("</resourceDefinitions>\r\n");
		write("\r\n");
		flush();
		close();
	}

	private void generateElement(String name, ElementDefn e) throws IOException {
		writeEntry(name+"."+e.getName(), e.getMinCardinality(), e.getMaxCardinality(), e.getConformance(), e.getTypes(), e.getConceptDomain(), e);
		for (ElementDefn c : e.getElements())	{
		   generateElement(name+"."+e.getName(), c);
		}
		
	}

	private void writeEntry(String path, Integer min, Integer max, ElementDefn.Conformance conformance, List<TypeDefn> types, String conceptDomain, ElementDefn e) throws IOException {
		write("      <elementDefinition>\r\n");
		write("        <name>"+Utilities.escapeXml(path)+"</name>\r\n");
		write("        <cardinality>\r\n");
		write("          <minOccurs>"+min.toString()+"</minOccurs>\r\n");
		if (max == null)
			write("          <maxOccurs>unbounded</maxOccurs>\r\n");
		else
			write("          <maxOccurs>"+max.toString()+"</maxOccurs>\r\n");
		write("        </cardinality>\r\n");
		write("        <conformance>"+Utilities.escapeXml(conformance.fullName())+"</conformance>\r\n");
		write("        <condition>"+Utilities.escapeXml(e.getCondition())+"</condition>\r\n");
		if (types != null && types.size() > 0)
		{ 
			write("        <types>\r\n");
			for (TypeDefn t : types)
			{
				if (t.hasParams()) {
					write("          <type>"+t.getName()+"(");
		            boolean firstp = true;
		            for (String p : t.getParams()) {
		            	if (!firstp)
		            		write("|");
		            	write(p);
		            	firstp = false;
		            }
					write(")</type>\r\n");
				}
				else
					write("          <type>"+t.getName()+"</type>\r\n");
			}
			
			write("        </types>\r\n");
		}
		if (hasValue(conceptDomain))
			write("        <conceptDomain>"+Utilities.escapeXml(conceptDomain)+"</conceptDomain>\r\n");
		write("        <mustUnderstand>"+Boolean.toString(e.isMustUnderstand())+"</mustUnderstand>\r\n");
		write("        <definition>"+Utilities.escapeXml(e.getDefinition())+"</definition>\r\n");
		write("        <requirements>"+Utilities.escapeXml(e.getRequirements())+"</requirements>\r\n");
		if (hasValue(e.getComments()))
			write("        <comments>"+Utilities.escapeXml(e.getComments())+"</comments>\r\n");
		write("        <rim>"+Utilities.escapeXml(e.getRimMapping())+"</rim>\r\n");
		if (hasValue(e.getV2Mapping()))
			write("        <v2>"+Utilities.escapeXml(e.getV2Mapping())+"</v2>\r\n");
		if (hasValue(e.getTodo()))
			write("        <todo>"+Utilities.escapeXml(e.getTodo())+"</todo>\r\n");
		write("      </elementDefinition>\r\n");
		
	}
	
	
	private boolean hasValue(String s) {
		return s != null && !"".equals(s);
	}

	public void setConceptDomains(Map<String, ConceptDomain> conceptDomains) {
		this.conceptDomains = conceptDomains;
		
	}
}
