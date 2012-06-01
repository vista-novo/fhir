package org.hl7.fhir.definitions.validation;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;

public class ModelValidator {

  private Definitions definitions;
	private List<String> errors = new ArrayList<String>();

	
	public ModelValidator(Definitions definitions) {
	  super();
	  this.definitions = definitions;
	}

//	public void setConceptDomains(List<ConceptDomain> conceptDomains) {
//		this.conceptDomains = conceptDomains;
//	}
//
//	public void defineResource(String name) {
//		this.resources.add(name);
//	}
//
//	public void setDataTypes(String[] names) throws Exception {
//		TypeParser tp = new TypeParser();
//		for (String tn : names) {
//			datatypes.addAll(tp.parse(tn));
//		}
//	}

	public List<String> check(String name, ElementDefn root) {
		errors.clear();
		checkElement(root.getName(), root);
		return errors;
	}

	private void checkElement(String path, ElementDefn e) {
		rule(path, e.unbounded() || e.getMaxCardinality() == 1, "Max Cardinality must be 1 or unbounded");
		rule(path, e.getMinCardinality() == 0 || e.getMinCardinality() == 1, "Min Cardinality must be 0 or 1");
//		if (e.getConformance() == ElementDefn.Conformance.Mandatory && !e.unbounded())
//		  rule(path, e.getMinCardinality() > 0, "Min Cardinality cannot be 0 when element is mandatory");
		if (!e.getName().equals("#"))
		rule(path, e.hasShortDefn() || e.getElements().size() > 0, "Must have a short defn unless child elements exist");
		checkType(path, e);
		if (e.hasConceptDomain())
		{
			BindingSpecification cd = definitions.getBindingByName(e.getBindingName());
			rule(path, cd  != null, "Unable to resolve concept domain "+e.getBindingName());
//			if (cd != null)
//		      rule(path, (cd.getBinding() == ConceptDomain.Binding.CodeList && (e.hasType("Coding") || e.hasType("CodeableConcept"))), "A binding can only be extensible if an element has a type of Coding|CodeableConcept and the concept domain is bound directly to a code list.");
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
								rule(path, p.equals("Any") || definitions.hasResource(p), "Unknown resource type "+p);
							}
						}
					}
				}
			}		
		}
		
	}

	private boolean typeIsSpecial(String name) {
		return (name.equals("xml:ID") || name.equals("xhtml") || name.equals("[param]") || name.equals("*")) || name.equals("Type") || name.equals("GenericType") || name.equals("Resource");
	}

	private boolean typeExists(String name) {
		return definitions.hasType(name);
	}

	private void rule(String path, boolean b, String msg) {
		if (!b)
			errors.add(path+": "+msg);
		
	}
	
	
}
