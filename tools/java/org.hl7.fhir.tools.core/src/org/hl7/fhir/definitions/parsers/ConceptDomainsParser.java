package org.hl7.fhir.definitions.parsers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.tools.publisher.FolderManager;

public class ConceptDomainsParser extends CSVReader {

	private String root;

  public ConceptDomainsParser(InputStream in, String root) {
		super(in);
		this.root = root;
	}

	public List<BindingSpecification> parse() throws Exception {
		List<BindingSpecification> results = new ArrayList<BindingSpecification>();
		BindingSpecification n = new BindingSpecification();
		n.setName("*unbound*");
		n.setBinding(BindingSpecification.Binding.Unbound);
		results.add(n);
		

		String[] titles = parseLine();
		while (ready())
		{
		  String[] values = parseLine();
		  processLine(results, titles, values);
		}		
		return results;
	}
	
	private void processLine(List<BindingSpecification> results, String[] titles, String[] values) throws Exception {
		BindingSpecification cd = new BindingSpecification();
    cd.setName(getColumn(titles, values, "Binding Name"));
		cd.setDefinition(getColumn(titles, values, "Definition"));
    cd.setBinding(readBinding(getColumn(titles, values, "Binding")));
    cd.setBindingStrength(readBindingStrength(getColumn(titles, values, "Binding Strength")));
    cd.setReference(getColumn(titles, values, "Reference"));
    cd.setDescription(getColumn(titles, values, "Description"));
    cd.setId(new BindingNameRegistry(root).idForName(cd.getName()));
    cd.setSource("concept-domains.csv");
		results.add(cd);
	}

	public static BindingSpecification.Binding readBinding(String s) throws Exception {
		s = s.toLowerCase();
		if (s == null || "".equals(s) || "unbound".equals(s))
			return BindingSpecification.Binding.Unbound;
		if (s.equals("code list"))
			return BindingSpecification.Binding.CodeList;
		if (s.equals("special"))
			return BindingSpecification.Binding.Special;
		if (s.equals("reference"))
			return BindingSpecification.Binding.Reference;
		if (s.equals("value set"))
			return BindingSpecification.Binding.ValueSet;
		throw new Exception("Unknown Binding: "+s);
	}
		
	public static BindingSpecification.BindingStrength readBindingStrength(String s) throws Exception {
    s = s.toLowerCase();
    if (s == null || "".equals(s))
      return BindingSpecification.BindingStrength.Unstated;
    if (s.equals("required"))
      return BindingSpecification.BindingStrength.Required;
    if (s.equals("preferred"))
      return BindingSpecification.BindingStrength.Preferred;
    if (s.equals("suggested"))
      return BindingSpecification.BindingStrength.Suggested;
    throw new Exception("Unknown Binding Strength: "+s);
  }
}
