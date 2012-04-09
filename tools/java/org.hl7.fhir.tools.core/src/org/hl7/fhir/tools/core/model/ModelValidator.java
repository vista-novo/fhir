package org.hl7.fhir.tools.core.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.tools.core.parser.TypeParser;

public class ModelValidator {

	private List<String> resources = new ArrayList<String>();
	private List<TypeDefn> datatypes = new ArrayList<TypeDefn>();
	private List<String> errors = new ArrayList<String>();
	private List<ConceptDomain> conceptDomains;

	public void setConceptDomains(List<ConceptDomain> conceptDomains) {
		this.conceptDomains = conceptDomains;
	}

	public void defineResource(String name) {
		this.resources.add(name);
	}

	public void setDataTypes(String[] names) throws Exception {
		TypeParser tp = new TypeParser();
		for (String tn : names) {
			datatypes.addAll(tp.parse(tn));
		}
	}

	public String[] check(ElementDefn root) {
		errors.clear();
		
		checkElement(root.getName(), root);
		return errors.toArray(new String[] {});
	}

	private void checkElement(String path, ElementDefn e) {
		rule(path, e.unbounded() || e.getMaxCardinality() == 1, "Max Cardinality must be 1 or unbounded");
		rule(path, e.getMinCardinality() == 0 || e.getMinCardinality() == 1, "Min Cardinality must be 0 or 1");
		rule(path, e.getConformance() != Conformance.Prohibited, "Prohibited is not allowed");
		if (e.getConformance() == Conformance.Mandatory && !e.unbounded())
		  rule(path, e.getMinCardinality() > 0, "Min Cardinality cannot be 0 when element is mandatory");
		if (e.getConformance() == Conformance.Conditional)
			rule(path, e.hasCondition(), "A conditional element must have a condition");
		if (!e.getName().equals("#"))
		rule(path, e.hasShortDefn() || e.getElements().size() > 0, "Must have a short defn unless child elements exist");
		checkType(path, e);
		if (e.hasConceptDomain())
		{
			ConceptDomain cd = getConceptDomainByName(conceptDomains, e.getConceptDomain());
			rule(path, cd  != null, "Unable to resolve concept domain "+e.getConceptDomain());
			if (cd != null)
		      rule(path, e.getBindingStrength() != BindingStrength.Extensible || (cd.getBindingType() == BindingType.CodeList && (e.hasType("Coding") || e.hasType("CodeableConcept"))), "A binding can only be extensible if an element has a type of Coding|CodeableConcept and the concept domain is bound directly to a code list.");
		}
		for (ElementDefn c : e.getElements()) {
			checkElement(path+"."+c.getName(), c);
		}
		
	}

	private void checkType(String path, ElementDefn e) {
		if (e.getTypes().size() == 0) {
			rule(path, path.contains("."), "Must have a type on a base element");
			rule(path, e.getName().equals("extensions") || e.getElements().size() > 0, "Must have a type unless sub-elements exist");
		} else {
			for (TypeDefn t : e.getTypes()) {
				String s = t.getName();
				if (s.charAt(0) == '@') {
					// validate path
				} else {
					if (s.charAt(0) == '#')
						s = s.substring(1);
					if (!typeIsSpecial(s)) {
						rule(path, typeExists(s), "Illegal Type '"+s+"'");
						if (s.equals("Resource")) {
							for (String p : t.getParams()) {
								rule(path, p.equals("Any") || resources.contains(p), "Unknown resource type "+p);
							}
						}
					}
				}
			}		
		}
		
	}

	private boolean typeIsSpecial(String name) {
		return (name.equals("xml:ID") || name.equals("xhtml") || name.equals("[param]") || name.equals("*"));
	}

	private boolean typeExists(String name) {
		for (TypeDefn t : datatypes)
			if (name.equals(t.getName()))
				return true;
		return false;
	}

	private void rule(String path, boolean b, String msg) {
		if (!b)
			errors.add(path+": "+msg);
		
	}
	
	private ConceptDomain getConceptDomainByName(List<ConceptDomain> tx, String conceptDomain) {		
		for (ConceptDomain cd : tx) {
			if (cd.getName().equals(conceptDomain))
				return cd; 
		}
		return null;
	}

}
