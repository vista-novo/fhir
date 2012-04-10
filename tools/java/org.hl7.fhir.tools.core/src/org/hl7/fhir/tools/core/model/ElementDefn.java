package org.hl7.fhir.tools.core.model;

import java.util.ArrayList;
import java.util.List;

public class ElementDefn {
	private List<TypeDefn> types = new ArrayList<TypeDefn>();
	private Conformance conformance;
	private Integer minCardinality;
	private Integer maxCardinality;
	private String id;
	private String conceptDomain;
	private BindingStrength bindingStrength;
	private String name;
	private String shortDefn;
	private String definition;
	private String requirements; 
	private boolean mustUnderstand;
	private String rimMapping;
	private String comments; 
	private String v2Mapping;
	private String todo;
	private String committeeNotes;
	private String condition;
	private boolean nolist; 
	
	public boolean isNolist() {
		return nolist;
	}

	public void setNolist(boolean nolist) {
		this.nolist = nolist;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean hasCondition() {
	    return condition != null && !"".equals(condition);
	}
	
	public boolean isMustUnderstand() {
		return mustUnderstand;
	}

	public void setMustUnderstand(boolean mustUnderstand) {
		this.mustUnderstand = mustUnderstand;
	}

	   
    public String getTodo() {
		return todo;
	}



	public void setTodo(String todo) {
		this.todo = todo;
	}



	public String getCommitteeNotes() {
		return committeeNotes;
	}



	public void setCommitteeNotes(String committeeNotes) {
		this.committeeNotes = committeeNotes;
	}

	   public String getDefinition() {
		return (definition == null || "".equals(definition)) ? shortDefn : definition;
	}



	public void setDefinition(String definition) {
		this.definition = definition;
	}



	public String getRequirements() {
		return requirements;
	}



	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}



	public String getRimMapping() {
		return rimMapping;
	}



	public void setRimMapping(String rimMapping) {
		this.rimMapping = rimMapping;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public String getV2Mapping() {
		return v2Mapping;
	}



	public void setV2Mapping(String v2Mapping) {
		this.v2Mapping = v2Mapping;
	}



	public void setElements(List<ElementDefn> elements) {
		this.elements = elements;
	}

	private List<ElementDefn> elements = new ArrayList<ElementDefn>();

	      
	   
	   public List<ElementDefn> getElements()
	   {
	     return elements ;
	   }



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public boolean hasName() {
		return this.name != null && !this.name.equals("");
	}
	
	public String getShortDefn() {
		return shortDefn;
	}

    public void setShortDefn(String shortDefn) {
	    this.shortDefn = shortDefn;
	}

    public boolean hasShortDefn() {
	    return shortDefn != null && !"".equals(shortDefn);
	}



    public ElementDefn getElementByName(String name) {
    	for (ElementDefn e : elements) {
    		if (e.getName().equalsIgnoreCase(name))
    			return e;
    		if (e.getName().length() > name.length() && e.getName().substring(0, name.length()).equalsIgnoreCase(name) && e.getElements().size() == 1 && e.getElements().get(0).getName().equalsIgnoreCase(name))
    			return e.getElements().get(0);
    		}
    	return null;
    }


    public String getConceptDomain() {
    	return conceptDomain;
    }
    
    public void setConceptDomain(String conceptDomain) {
    	this.conceptDomain = conceptDomain;
	}
    
    public String getId() {
    	return id;
	}

    public void setId(String id) {
    	this.id = id;
	}

    public List<TypeDefn> getTypes() {
	    return types;
	}
   
   

    public Conformance getConformance()	  {
	    return conformance;
    }

    public void setConformance(Conformance conformance)	  {
	    this.conformance = conformance;
    }

    public Integer getMinCardinality() {
    	return minCardinality;
    }

	public void setMinCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
	}
	
	public Integer getMaxCardinality() {
		return maxCardinality;
	}
	
	public void setMaxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
	}
	
	public String describeCardinality() {
		if (maxCardinality == null)
			return minCardinality.toString()+"..*";
	else
		return minCardinality.toString()+".."+maxCardinality.toString();
	}
	
	public String textForCardinality() {
		if (maxCardinality != null)
			return "??";
	if (minCardinality == 0)
		return "Zero+";
	else
		return "One+";
	}

	public boolean hasDefinition() {
		return (this.definition != null && !this.definition.equals("")) || (shortDefn != null && !this.shortDefn.equals(""));
	}

	public boolean unbounded() {
		return maxCardinality == null;
	}

	public boolean hasConceptDomain() {
		return conceptDomain != null && !conceptDomain.equals("");
	}

	public BindingStrength getBindingStrength() {
		return bindingStrength;
	}

	public void setBindingStrength(BindingStrength bindingStrength) {
		this.bindingStrength = bindingStrength;
	}

	public boolean hasType(String name) {
		return types.size() == 1 && types.get(0).getName().equals(name);
	}

	public String typeCode() {
		StringBuilder tn = new StringBuilder();
		boolean first = true;
		for (TypeDefn t : types) {
			if (!first)
				tn.append("|");
			first = false;
			tn.append(t.getName());
			if (t.hasParams()) {
				boolean f = true;
				for (String s : t.getParams()) {
					if (!f)
						tn.append("|");
					f = false;
					tn.append(s);
				}
			}
		}
		return tn.toString();
	}


}