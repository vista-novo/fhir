package org.hl7.fhir.definitions.parsers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.ConceptDomain;

public class ConceptDomainsParser extends CSVReader {

	public ConceptDomainsParser(InputStream in) {
		super(in);
	}

	public List<ConceptDomain> parse() throws Exception {
		List<ConceptDomain> results = new ArrayList<ConceptDomain>();
		ConceptDomain n = new ConceptDomain();
		n.setName("*unbound*");
		n.setBindingType(ConceptDomain.BindingType.Unbound);
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

	private ConceptDomain.BindingType readBinding(String s) throws Exception {

		s = s.toLowerCase();
		if (s == null || "".equals(s))
			return ConceptDomain.BindingType.Unbound;
		if (s.equals("code list"))
			return ConceptDomain.BindingType.CodeList;
		if (s.equals("preferred"))
			return ConceptDomain.BindingType.Preferred;
		if (s.equals("reference"))
			return ConceptDomain.BindingType.Reference;
		if (s.equals("special"))
			return ConceptDomain.BindingType.Special;
		if (s.equals("external"))
			return ConceptDomain.BindingType.External;
		if (s.equals("suggestion"))
			return ConceptDomain.BindingType.Suggestion;
		throw new Exception("Unknown Binding Type: "+s);
	}
	
}
