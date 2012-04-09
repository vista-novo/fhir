package org.hl7.fhir.tools.core.parser;

import java.io.InputStream;

import org.hl7.fhir.tools.core.model.BindingStrength;
import org.hl7.fhir.tools.core.model.Conformance;
import org.hl7.fhir.tools.core.model.ElementDefn;
import org.hl7.fhir.tools.core.utilities.Utilities;

public class CSVParser  extends CSVReader {

	public CSVParser(InputStream in) {
		super(in);
	}

	public ElementDefn parse() throws Exception {
		ElementDefn root = new ElementDefn();
		String[] titles = parseLine();
		while (ready())
		{
		  String[] values = parseLine();
		  processLine(root, titles, values);
		}		
		return root;
	}

	private void processLine(ElementDefn root, String[] titles, String[] values) throws Exception {
		ElementDefn e;
		String path = getColumn(titles, values, "Element");
		if (!path.contains(".")) {
			e = root;
			if (root.hasName())
				throw new Exception("Definitions contain two roots: "+path+" in "+root.getName());
			e.setName(path);
		} else {
			e = makeFromPath(root, path);
		}
		
		String[] card = getColumn(titles, values, "Card.").split("\\.\\.");
		if (card.length != 2 || !Utilities.IsInteger(card[0]) || (!"*".equals(card[1]) && !Utilities.IsInteger(card[1])))
			throw new Exception("Unable to parse Cardinality "+getColumn(titles, values, "Card."));
		e.setMinCardinality(Integer.parseInt(card[0]));
		e.setMaxCardinality("*".equals(card[1]) ? null : Integer.parseInt(card[1]));
		e.setConformance(pickConformance(getColumn(titles, values, "Conf.")));
		String t = getColumn(titles, values, "Type");
		TypeParser tp = new TypeParser();
		e.getTypes().addAll(tp.parse(t));
		e.setCondition(getColumn(titles, values, "Condition"));
		e.setConceptDomain(getColumn(titles, values, "Concept Domain"));
		e.setBindingStrength(pickBindingStrength(getColumn(titles, values, "Binding Strength")));
		e.setMustUnderstand(parseBoolean(getColumn(titles, values, "Must Understand")));
		e.setShortDefn(getColumn(titles, values, "Short Name"));
		e.setDefinition(getColumn(titles, values, "Definition"));
		e.setRequirements(getColumn(titles, values, "Requirements"));
		e.setComments(getColumn(titles, values, "Comments"));
		e.setRimMapping(getColumn(titles, values, "RIM Mapping"));
		e.setV2Mapping(getColumn(titles, values, "v2 Mapping"));
		e.setTodo(getColumn(titles, values, "To Do"));
		e.setCommitteeNotes(getColumn(titles, values, "Committee Notes"));
		String s = getColumn(titles, values, "Must Understand").toLowerCase();
		if (s.equals("false") || s.equals("0") || s.equals("f") || s.equals("n"))
			e.setMustUnderstand(false);
		else if (s.equals("true") || s.equals("1") || s.equals("t") || s.equals("y"))
			e.setMustUnderstand(true);
		else if (!"".equals(s))
			throw new Exception("unable to process Must Understand flag: "+s);
	}


	private BindingStrength pickBindingStrength(String s) throws Exception {
		s = s.toLowerCase();
		if (s == null || "".equals(s))
			return BindingStrength.Unspecified;
		if (s.equals("closed"))
			return BindingStrength.Closed;
		if (s.equals("extensible"))
			return BindingStrength.Extensible;
		throw new Exception("Unknown Binding Strength: "+s);
	}

	private ElementDefn makeFromPath(ElementDefn root, String pathname) throws Exception {
		String[] path = pathname.split("\\.");
		if (!path[0].equals(root.getName()))
			throw new Exception("Element Path '"+pathname+"' is not legal in this context");
		ElementDefn res = root;
		for (int i = 1; i < path.length; i++)
		{
			String en = path[i];
			boolean nolist = false;
			if (en.length() == 0)
				throw new Exception("Improper path "+pathname);
			if (en.charAt(en.length() - 1) == '*') {
				nolist = true;
				en = en.substring(0, en.length()-1);
			}
			ElementDefn t = res.getElementByName(en);
			if (t == null) {
				if (i < path.length - 1) 
					throw new Exception("Encounter Element "+pathname+" before all the elements in the path are defined");
				t = new ElementDefn();
				t.setName(en);
				t.setNolist(nolist);
				res.getElements().add(t);
			}
			res = t; 
		}
		return res;
	}


	private Conformance pickConformance(String s) throws Exception {
		s = s.toLowerCase();
		if (s == null || "".equals(s))
			return Conformance.Unstated;
		if (s.equals("opt"))
			return Conformance.Optional;
		if (s.equals("mand"))
			return Conformance.Mandatory;
		if (s.equals("cond"))
			return Conformance.Conditional;
		if (s.equals("optional"))
			return Conformance.Optional;
		if (s.equals("mandatory"))
			return Conformance.Mandatory;
		if (s.equals("conditional"))
			return Conformance.Conditional;
		if (s.equals("prohibited"))
			return Conformance.Prohibited;
		throw new Exception("Unknown Conformance flag: "+s);
	}


	
	

}
