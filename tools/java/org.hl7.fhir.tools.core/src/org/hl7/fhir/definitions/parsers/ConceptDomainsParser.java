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
		n.setBinding(ConceptDomain.Binding.Unbound);
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
    cd.setId(getColumn(titles, values, "Id"));
    cd.setName(getColumn(titles, values, "Concept Domain"));
		cd.setDefinition(getColumn(titles, values, "Definition"));
    cd.setBinding(readBinding(getColumn(titles, values, "Binding")));
    cd.setBindingStrength(readBindingStrength(getColumn(titles, values, "Binding Strength")));
    cd.setReference(getColumn(titles, values, "Reference"));
    cd.setDescription(getColumn(titles, values, "Description"));
		results.add(cd);
	}

	private ConceptDomain.Binding readBinding(String s) throws Exception {
		s = s.toLowerCase();
		if (s == null || "".equals(s) || "unbound".equals(s))
			return ConceptDomain.Binding.Unbound;
		if (s.equals("code list"))
			return ConceptDomain.Binding.CodeList;
		if (s.equals("code reference list"))
			return ConceptDomain.Binding.CodeReference;
		if (s.equals("single code"))
			return ConceptDomain.Binding.SingleCode;
		if (s.equals("special"))
			return ConceptDomain.Binding.Special;
		if (s.equals("reference"))
			return ConceptDomain.Binding.Reference;
		if (s.equals("value set"))
			return ConceptDomain.Binding.ValueSet;
		throw new Exception("Unknown Binding: "+s);
	}
		
  private ConceptDomain.BindingStrength readBindingStrength(String s) throws Exception {
    s = s.toLowerCase();
    if (s == null || "".equals(s))
      return ConceptDomain.BindingStrength.Unstated;
    if (s.equals("required"))
      return ConceptDomain.BindingStrength.Required;
    if (s.equals("preferred"))
      return ConceptDomain.BindingStrength.Preferred;
    if (s.equals("suggested"))
      return ConceptDomain.BindingStrength.Suggested;
    throw new Exception("Unknown Binding Strength: "+s);
  }
}
