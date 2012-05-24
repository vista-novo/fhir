package org.hl7.fhir.definitions.parsers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.utilities.XLSXmlParser;
import org.hl7.fhir.utilities.XLSXmlParser.Sheet;

public class BindingsParser {

  private InputStream file;
  private String filename;
  private String root;

  public BindingsParser(InputStream file, String filename, String root) {
    this.file = file;
		this.filename = filename;
		this.root = root;
	}

	public List<BindingSpecification> parse() throws Exception {
		List<BindingSpecification> results = new ArrayList<BindingSpecification>();
		BindingSpecification n = new BindingSpecification();
		n.setName("*unbound*");
		n.setBinding(BindingSpecification.Binding.Unbound);
		results.add(n);
		
		XLSXmlParser xls = new XLSXmlParser(file, filename);
		Sheet sheet = xls.getSheets().get("Bindings");

    for (int row = 0; row < sheet.rows.size(); row++) {
		  processLine(results, sheet, row);
		}		
		return results;
	}
	
	private void processLine(List<BindingSpecification> results, Sheet sheet, int row) throws Exception {
		BindingSpecification cd = new BindingSpecification();
    cd.setName(sheet.getColumn(row, "Binding Name"));
		cd.setDefinition(sheet.getColumn(row, "Definition"));
    cd.setBinding(readBinding(sheet.getColumn(row, "Binding")));
    cd.setBindingStrength(readBindingStrength(sheet.getColumn(row, "Binding Strength")));
    cd.setReference(sheet.getColumn(row, "Reference"));
    cd.setDescription(sheet.getColumn(row, "Description"));
    cd.setId(new BindingNameRegistry(root).idForName(cd.getName()));
    cd.setSource(filename);
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
