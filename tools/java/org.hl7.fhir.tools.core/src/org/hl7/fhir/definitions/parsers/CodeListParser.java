package org.hl7.fhir.definitions.parsers;

import java.io.InputStream;
import java.util.List;

import org.hl7.fhir.definitions.model.DefinedCode;

public class CodeListParser  extends CSVReader {

	public CodeListParser(InputStream in) {
		super(in);
	}

	public void parse(List<DefinedCode> codes) throws Exception {
		String[] titles = parseLine();
		while (ready())
		{
		  String[] values = parseLine();
		  processLine(codes, titles, values);
		}				
	}

	private void processLine(List<DefinedCode> codes, String[] titles, String[] values) throws Exception {
		DefinedCode c = new DefinedCode();
		c.setCode(getColumn(titles, values, "Code"));
		c.setDefinition(getColumn(titles, values, "Definition"));
		c.setComment(getColumn(titles, values, "Comment"));
		codes.add(c);
	}
	
}
