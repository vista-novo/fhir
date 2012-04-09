package org.hl7.fhir.definitions.generators.specification;

import java.io.*;
import java.util.*;

import org.hl7.fhir.definitions.model.ConceptDomain;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.utilities.Utilities;

public class TerminologyNotesGenerator extends OutputStreamWriter {

	public class CDUsage {
		public CDUsage(String path, ElementDefn element) {
			this.path = path;
			this.element = element;
		}
		private String path;
		private ElementDefn element;
	}

	public class MyCompare implements Comparator<ConceptDomain> {

		@Override
		public int compare(ConceptDomain arg0, ConceptDomain arg1) {
			return txusages.get(arg0).get(0).path.compareTo(txusages.get(arg1).get(0).path);
		}

	}

	char c = 'A';
	private Map<ConceptDomain, List<CDUsage>> txusages = new HashMap<ConceptDomain, List<CDUsage>>(); 
	
	public TerminologyNotesGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(ElementDefn root, Map<String, ConceptDomain> tx) throws Exception
	{
		scan(root, root.getName(), tx);
		gen(txusages);
		flush();
		close();
	}

	private void gen(Map<ConceptDomain, List<CDUsage>> txusages2) throws Exception {
		List<ConceptDomain> cds = new ArrayList<ConceptDomain>();
		cds.addAll(txusages.keySet());
		if (cds.size() == 0)
			return;
		
		Collections.sort(cds, new MyCompare());
		write("<p>\r\nTerminology Bindings\r\n</p>\r\n<ul>\r\n");
		for (ConceptDomain cd : cds) {
			String path;
			List<CDUsage> list = txusages.get(cd);
			for (int i = 2; i < list.size(); i++) {
				if (list.get(i).element.getBindingStrength() != list.get(1).element.getBindingStrength())
					throw new Exception("Mixed binding strengths on one concept domain in one type - not yet supported by the build process");
			}
			for (int i = 2; i < list.size(); i++) {
				if (!list.get(i).element.typeCode().equals(list.get(1).element.typeCode()))
					throw new Exception("Mixed types on one concept domain in one type - not yet supported by the build process");
			}

			if (list.size() == 2)
				path = list.get(1).path+" is ";
			else {
				path = list.get(1).path;
				for (int i = 2; i < list.size() - 1; i++) {
					path = path+", "+list.get(i).path;
				}
				path = path+" and "+list.get(list.size()-1).path+" are ";
			}
			ElementDefn.BindingStrength bs = list.get(1).element.getBindingStrength();

			if (cd.getName().equals("*unbound*")) {
				write("  <li>"+path+" not bound to a concept domain</li>\r\n");
			} else if (cd.getBindingType() == ConceptDomain.BindingType.Unbound) {
				write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\"</li>\r\n");
			} else if (cd.getBindingType() == ConceptDomain.BindingType.CodeList) {
				String sid = "";
				if (!list.get(1).element.typeCode().equals("code")) {
					sid = "urn:hl7-org:sid/fhir/"+cd.getBinding();
//					if (!sids.contains(sid))
//						sids.put(sid, new DefinedCode())
					sid = " (sid = "+sid+")";
				}
					
				if (bs == ElementDefn.BindingStrength.Extensible)
					write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\""+sid+". Use one of these values if possible:\r\n");
				else
					write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\""+sid+". Possible values:\r\n");
				write("    <table class=\"codes\">\r\n");
				boolean hasComment = false;
				boolean hasDefinition = false;
				for (DefinedCode c : cd.getCodes()) {
					hasComment = hasComment || c.hasComment();
					hasDefinition = hasDefinition || c.hasDefinition();
				}
//				if (hasComment)
//					write("    <tr><td><b>Code</b></td><td><b>Title</b></td><td><b>Comment</b></td></tr>");
//				else if (hasDefinition)
//					write("    <tr><td><b>Code</b></td><td colspan=\"2\"><b>Title</b></td></tr>");
					

				for (DefinedCode c : cd.getCodes()) {
					if (hasComment)
						write("    <tr><td>"+c.getCode()+"</td><td>"+Utilities.escapeXml(c.getDefinition())+"</td><td>"+Utilities.escapeXml(c.getComment())+"</td></tr>");
					else if (hasDefinition)
						write("    <tr><td>"+c.getCode()+"</td><td colspan=\"2\">"+Utilities.escapeXml(c.getDefinition())+"</td></tr>");
					else
						write("    <tr><td colspan=\"3\">"+c.getCode()+"</td></tr>");
				}
				write("    </table>\r\n");
				write("  </li>\r\n");
				
			} else if (cd.getBindingType() == ConceptDomain.BindingType.Reference) {
				write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\". For example values, see "+Utilities.escapeXml(cd.getBinding())+"</li>\r\n");
			} else if (cd.getBindingType() == ConceptDomain.BindingType.Preferred) {
				write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\". If an appropriate code exists in "+Utilities.escapeXml(cd.getBinding())+" then it should be used</li>\r\n");
			} else if (cd.getBindingType() == ConceptDomain.BindingType.Suggestion) {
				write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\". A good candidate for codes is "+Utilities.escapeXml(cd.getBinding())+"</li>\r\n");
			} else if (cd.getBindingType() == ConceptDomain.BindingType.External) {
				write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\". The possible values are those specified in "+makeLink(Utilities.escapeXml(cd.getBinding()), cd.getDetails())+"</li>\r\n");
			} else if (cd.getBindingType() == ConceptDomain.BindingType.Special) {
				if (cd.getName().equals("MessageEvent"))
					write("<li>"+path+" bound to the concept domain <i>MessageEvent</i> which has the allowed values defined for <a href=\"messaging.htm#Events\"> Event List in the messaging framework</a></li>\r\n");
				else if (cd.getName().equals("ResourceType"))
					write("  <li>"+path+" bound to the concept domain <i>ResourceType</i> which has the allowed values of <a href=\"terminologies.htm#ResourceType\"> any defined Resource Type name</a></li>\r\n");
				else 
					write("  <li>"+path+" bound to the concept domain <i>DataType</i> which has the allowed values of <a href=\"datatypes.htm\"> any defined data Type name</a> (including <a href=\"xml.htm#resource\">Resource</a>)</li>\r\n");
				
			} 
		}
		write("</ul>\r\n");
		
	}

	private String makeLink(String html, String details) {
		if (details == null || "".equals(details))
			return html;
		else
			return "<a href=\""+details+"\" target=\"_blank\">"+html+"</a>";
			
	}

	private void scan(ElementDefn e, String path, Map<String, ConceptDomain> tx) throws Exception {
		if (e.hasConceptDomain()) {
			ConceptDomain cd = getConceptDomainByName(tx, e.getConceptDomain());
			if (!txusages.containsKey(cd)) {
				txusages.put(cd, new ArrayList<CDUsage>());
				c++;
				txusages.get(cd).add(new CDUsage(String.valueOf(c), null));						
			}
			txusages.get(cd).add(new CDUsage(path, e));			
		}
		for (ElementDefn c : e.getElements()) {
			scan(c, path+"."+c.getName(), tx);
		}
		
	}

	private ConceptDomain getConceptDomainByName(Map<String, ConceptDomain> tx, String conceptDomain) throws Exception {		
		for (ConceptDomain cd : tx.values()) {
			if (cd.getName().equals(conceptDomain))
				return cd; 
		}
		throw new Exception("Unable to find Concept Domain "+conceptDomain);
	}
	
	
}
