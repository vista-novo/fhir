package org.hl7.fhir.tools.core.parser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.tools.core.model.BindingType;
import org.hl7.fhir.tools.core.model.ConceptDomain;

public class ConceptDomainsParser extends CSVReader {

	public ConceptDomainsParser(InputStream in) {
		super(in);
	}

	public List<ConceptDomain> parse() throws Exception {
		List<ConceptDomain> results = new ArrayList<ConceptDomain>();
		ConceptDomain n = new ConceptDomain();
		n.setName("*unbound*");
		n.setBindingType(BindingType.Unbound);
		results.add(n);
		

		String[] titles = parseLine();
		while (ready())
		{
		  String[] values = parseLine();
		  processLine(results, titles, values);
		}		
		return results;
	}
	
	private void processLine(List<ConceptDomain> results, String[] titles, String[] values) throws Exception {
		ConceptDomain cd = new ConceptDomain();
		cd.setName(getColumn(titles, values, "Concept Domain"));
		cd.setDefinition(getColumn(titles, values, "Definition"));
		cd.setBindingType(readBinding(getColumn(titles, values, "Binding Type")));
		cd.setBinding(getColumn(titles, values, "Binding"));
		cd.setDetails(getColumn(titles, values, "Binding Details"));
		results.add(cd);
	}

	private BindingType readBinding(String s) throws Exception {

		s = s.toLowerCase();
		if (s == null || "".equals(s))
			return BindingType.Unbound;
		if (s.equals("code list"))
			return BindingType.CodeList;
		if (s.equals("preferred"))
			return BindingType.Preferred;
		if (s.equals("reference"))
			return BindingType.Reference;
		if (s.equals("special"))
			return BindingType.Special;
		if (s.equals("external"))
			return BindingType.External;
		if (s.equals("suggestion"))
			return BindingType.Suggestion;
		throw new Exception("Unknown Binding Type: "+s);
	}
	
}
