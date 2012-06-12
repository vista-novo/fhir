package org.hl7.fhir.definitions.generators.specification;
/*
Copyright (c) 2011-2012, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.utilities.Utilities;

public class DictXMLGenerator  extends OutputStreamWriter {

			
	private Map<String, BindingSpecification> conceptDomains;

	public DictXMLGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(Collection<ResourceDefn> resources, String author) throws Exception
	{
		write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		write("<resourceDefinitions xmlns=\"http://hl7.org/fhir\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://hl7.org/fhir definitions.xsd\">\r\n");
		write("  <author>"+author+"</author>\r\n");
		
		for (ResourceDefn resource : resources) 
		{
			ElementDefn root = resource.getRoot();
			write("  <resourceDefinition>\r\n");
			write("    <name>"+resource.getName()+"</name>\r\n");
			write("    <elementDefinitions>\r\n");
			
			writeEntry(root.getName(), 1, 1, null, "", root);
			for (ElementDefn e : root.getElements()) {
			   generateElement(root.getName(), e);
			}
			
			write("    </elementDefinitions>\r\n");
			write("  </resourceDefinition>\r\n");
		}
		if (conceptDomains != null) {
			for (BindingSpecification cd : conceptDomains.values()) {
				generateConceptDomain(cd);
			}
		}
		write("</resourceDefinitions>\r\n");
		write("\r\n");
		flush();
	}

	private void generateConceptDomain(BindingSpecification cd) throws Exception {
		write("  <conceptDomain>\r\n");
		write("    <name>"+Utilities.escapeXml(cd.getName())+"</name>\r\n");
		write("    <definition>"+Utilities.escapeXml(cd.getDefinition())+"</definition>\r\n");
    write("    <binding>"+cd.getBinding().toString()+"</binding>\r\n");
    if (cd.getBindingStrength() != null)
      write("    <bindingStrength>"+cd.getBindingStrength().toString()+"</bindingStrength>\r\n");
		if (cd.getBinding() == BindingSpecification.Binding.CodeList) {
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
		} else if (cd.getBinding() == BindingSpecification.Binding.Unbound) {
		
		} else {
			write("    <description>"+Utilities.escapeXml(cd.getDescription())+"</description>\r\n");
			write("    <reference>"+Utilities.escapeXml(cd.getReference())+"</reference>\r\n");
		} 
		
		write("  </conceptDomain>\r\n");
		
	}

	public void generate(ElementDefn root, String author) throws Exception
	{
		write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		write("<resourceDefinitions xmlns=\"http://hl7.org/fhir\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://hl7.org/fhir definitions.xsd\">\r\n");
		write("  <author>"+author+"</author>\r\n");
		write("  <resourceDefinition>\r\n");
		write("    <name>"+root.getName()+"</name>\r\n");
		write("    <elementDefinitions>\r\n");
		
		writeEntry(root.getName(), 1, 1, null, "", root);
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
		writeEntry(name+"."+e.getName(), e.getMinCardinality(), e.getMaxCardinality(), e.getTypes(), e.getBindingName(), e);
		for (ElementDefn c : e.getElements())	{
		   generateElement(name+"."+e.getName(), c);
		}
		
	}

	private void writeEntry(String path, Integer min, Integer max, List<TypeRef> types, String conceptDomain, ElementDefn e) throws IOException {
		write("      <elementDefinition>\r\n");
		write("        <name>"+Utilities.escapeXml(path)+"</name>\r\n");
		write("        <cardinality>\r\n");
		write("          <minOccurs>"+min.toString()+"</minOccurs>\r\n");
		if (max == null)
			write("          <maxOccurs>unbounded</maxOccurs>\r\n");
		else
			write("          <maxOccurs>"+max.toString()+"</maxOccurs>\r\n");
		write("        </cardinality>\r\n");
		write("        <condition>"+Utilities.escapeXml(e.getCondition())+"</condition>\r\n");
		if (types != null && types.size() > 0)
		{ 
			write("        <types>\r\n");
			for (TypeRef t : types)
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

	public void setConceptDomains(Map<String, BindingSpecification> conceptDomains) {
		this.conceptDomains = conceptDomains;
		
	}
}
