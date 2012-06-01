package org.hl7.fhir.definitions.generators.specification;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.BindingSpecification;
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

	public class MyCompare implements Comparator<BindingSpecification> {

		public int compare(BindingSpecification arg0, BindingSpecification arg1) {
			return txusages.get(arg0).get(0).path.compareTo(txusages.get(arg1).get(0).path);
		}

	}

	char c = 'A';
	private Map<BindingSpecification, List<CDUsage>> txusages = new HashMap<BindingSpecification, List<CDUsage>>(); 
	
	public TerminologyNotesGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(ElementDefn root, Map<String, BindingSpecification> tx) throws Exception
	{
		scan(root, root.getName(), tx);
		gen(txusages);
		flush();
		close();
	}

	private void gen(Map<BindingSpecification, List<CDUsage>> txusages2) throws Exception {
		List<BindingSpecification> cds = new ArrayList<BindingSpecification>();
		cds.addAll(txusages.keySet());
		if (cds.size() == 0)
			return;
		
		Collections.sort(cds, new MyCompare());
		write("<p>\r\nTerminology Bindings\r\n</p>\r\n<ul>\r\n");
		for (BindingSpecification cd : cds) {
			String path;
			List<CDUsage> list = txusages.get(cd);
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
	
			if (cd.getName().equals("*unbound*")) {
				write("  <li>"+path+" not bound to a concept domain (Error)</li>\r\n");
			} else if (cd.getBinding() == BindingSpecification.Binding.Unbound) {
				write("  <li>"+path+" bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\"</li>\r\n");
			} else if (cd.getBinding() == BindingSpecification.Binding.CodeList) {
				String sid = "";
				if (!list.get(1).element.typeCode().equals("code")) {
					sid = "urn:hl7-org:sid/fhir/"+cd.getBinding();
//					if (!sids.contains(sid))
//						sids.put(sid, new DefinedCode())
					sid = " (sid = "+sid+")";
				}
					
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
						write("    <tr><td>"+Utilities.escapeXml(c.getCode())+"</td><td>"+Utilities.escapeXml(c.getDefinition())+"</td><td>"+Utilities.escapeXml(c.getComment())+"</td></tr>");
					else if (hasDefinition)
						write("    <tr><td>"+Utilities.escapeXml(c.getCode())+"</td><td colspan=\"2\">"+Utilities.escapeXml(c.getDefinition())+"</td></tr>");
					else
						write("    <tr><td colspan=\"3\">"+Utilities.escapeXml(c.getCode())+"</td></tr>");
				}
				write("    </table>\r\n");
				write("  </li>\r\n");
				
      } else if (cd.getBinding() == BindingSpecification.Binding.Special) {
        if (cd.getName().equals("MessageEvent"))
          write("<li>"+path+" bound to the concept domain <i>MessageEvent</i> which has the allowed values defined for <a href=\"message.htm#Events\"> Event List in the messaging framework</a></li>\r\n");
        else if (cd.getName().equals("ResourceType"))
          write("  <li>"+path+" bound to the concept domain <i>ResourceType</i> which has the allowed values of <a href=\"terminologies.htm#ResourceType\"> any defined Resource Type name</a></li>\r\n");
        else 
          write("  <li>"+path+" bound to the concept domain <i>DataType</i> which has the allowed values of <a href=\"datatypes.htm\"> any defined data Type name</a> (including <a href=\"xml.htm#Resource\">Resource</a>)</li>\r\n");
        
			} else {
			  if (cd.getBindingStrength() == BindingSpecification.BindingStrength.Required)
	        write("  <li>"+path+" is bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\". For example values, see "+ref(cd)+"</li>\r\n");
			  else if (cd.getBindingStrength() == BindingSpecification.BindingStrength.Preferred)
	        write("  <li>"+path+" is bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\". If an appropriate code exists in "+ref(cd)+" then it should be used</li>\r\n");
			  else // if (cd.getBindingStrength() = ConceptDomain.BindingStrength.Suggested)
	        write("  <li>"+path+" is bound to the concept domain <i>"+Utilities.escapeXml(cd.getName())+"</i>: \""+Utilities.escapeXml(cd.getDefinition())+"\". A good candidate for codes is "+ref(cd)+"</li>\r\n");
			}
		}
		write("</ul>\r\n");
		
	}

	private String ref(BindingSpecification cd) {
    if (cd.hasReference())
      return "<a href=\""+cd.getReference()+"\">"+Utilities.escapeXml(cd.getDescription())+"</a>";
    else
      return Utilities.escapeXml(cd.getDescription());
  }


	private void scan(ElementDefn e, String path, Map<String, BindingSpecification> tx) throws Exception {
		if (e.hasBinding()) {
			BindingSpecification cd = getConceptDomainByName(tx, e.getBindingName());
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

	private BindingSpecification getConceptDomainByName(Map<String, BindingSpecification> tx, String conceptDomain) throws Exception {		
		for (BindingSpecification cd : tx.values()) {
			if (cd.getName().equals(conceptDomain))
				return cd; 
		}
		throw new Exception("Unable to find Concept Domain "+conceptDomain);
	}
	
	
}
