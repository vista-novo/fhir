package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.instance.model.Constraint.Element_;

public class ElementDefn {
  
  
  public enum Conformance { Unstated, Mandatory, Conditional, Optional, Prohibited;
    public String code() {
      switch (this) {
      case Unstated: return "";
      case Mandatory: return "mand";
      case Conditional: return "cond";
      case Optional: return "opt";
      case Prohibited: return "prohibited";
      default: 
        return "";
      }
    }
    public String fullName() {
      switch (this) {
      case Unstated: return "";
      case Mandatory: return "Mandatory";
      case Conditional: return "Conditional";
      case Optional: return "Optional";
      case Prohibited: return "Prohibited";
      default: 
        return "";
      }
    }
  }
  
	private List<TypeDefn> types = new ArrayList<TypeDefn>();
	private List<ElementDefn> elements = new ArrayList<ElementDefn>();
	private Conformance conformance;
	private Integer minCardinality;
	private Integer maxCardinality; 
//	private String id;
	private String bindingName;
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
	private String example;
	private boolean nolist; // this field is flagged for deletion - no longer used
	private String profileName; // only in a profile, for unpicking
	private String target; // only in extensions
	private String value; // only in a profile
	private String aggregation; //only in a profile
	private Element_ derivation;
	private boolean inherited; // in a profile, was this element add from the base definition (true) or was it specifically constrained in the profile (false)
	
	public ElementDefn() {
	  super();
	}

	public ElementDefn(ElementDefn pattern) {
	  super();
	  types.addAll(pattern.types);
	  for (ElementDefn c : pattern.getElements())
	    elements.add(new ElementDefn(c));

	  conformance = pattern.conformance;
	  minCardinality = pattern.minCardinality;
	  maxCardinality = pattern.maxCardinality;
//	  id = pattern.id;
	  bindingName = pattern.bindingName;
	  name = pattern.name;
	  shortDefn = pattern.shortDefn;
	  definition = pattern.definition;
	  requirements = pattern.requirements; 
	  mustUnderstand = pattern.mustUnderstand;
	  rimMapping = pattern.rimMapping;
	  comments = pattern.comments; 
	  v2Mapping = pattern.v2Mapping;
	  todo = pattern.todo;
	  committeeNotes = pattern.committeeNotes;
	  condition = pattern.condition;
	  example = pattern.example;
	  nolist = pattern.nolist; 
	  profileName = pattern.profileName;
	  target = pattern.target; 
	  value = pattern.value; 
	  inherited = pattern.inherited;
    
	}
	 
  public boolean isNolist() {
		return nolist;
	}

	public void setNoListWrapper(boolean nolist) {
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
      String n = name.contains(".") ? name.substring(0, name.indexOf(".")) : name;
      String t = name.contains(".") ? name.substring(name.indexOf(".")+1) : null;
      if (n.equals(this.name) && t != null)
        return getElementByName(t);
      
      for (int i = elements.size()-1; i >= 0; i--) {
        ElementDefn e = elements.get(i);
        if (e.getName().equalsIgnoreCase(n))
          return t == null ? e : e.getElementByName(t);
        if (e.getName().length() > name.length() && e.getName().substring(0, name.length()).equalsIgnoreCase(name) && e.getElements().size() == 1 && e.getElements().get(0).getName().equalsIgnoreCase(name))
          return e.getElements().get(0);
      }
      return null;
    }

    public ElementDefn getElementByProfileName(String name) {
      for (int i = elements.size()-1; i >= 0; i--) {
        ElementDefn e = elements.get(i);
        if (e.getProfileName().equalsIgnoreCase(name))
          return e;
      }
      return null;
    }

    public String getBindingName() {
    	return bindingName;
    }
    
    public void setBindingName(String conceptDomain) {
    	this.bindingName = conceptDomain;
	}
    
//    public String getId() {
//    	return id;
//	}
//
//    public void setId(String id) {
//    	this.id = id;
//	}

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
	  if (maxCardinality != null) {
	    if (maxCardinality == 1)
	      if (minCardinality == 0)
	        return "?One";
	      else
	        return "One";
	    else
	      return "??";
	  } else if (minCardinality == 0)
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
		return bindingName != null && !bindingName.equals("");
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
        tn.append("(");
				boolean f = true;
				for (String s : t.getParams()) {
					if (!f)
						tn.append("|");
					f = false;
					tn.append(s);
				}
        tn.append(")");
			}
		}
		return tn.toString();
	}

  public String getExample() {
    return example;
  }

  public void setExample(String example) {
    this.example = example;
  }

  public String getProfileName() {
    return profileName;
  }

  public void setProfileName(String profileName) {
    this.profileName = profileName;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getAggregation()
  {
	  return aggregation;
  }
  
  public void setAggregation(String aggregation) 
  {
	  this.aggregation = aggregation;
  }  

  public boolean hasAggregation()
  {
	  return aggregation != null && !aggregation.equals("");
  }
  
  public boolean hasValue() {
    return value != null && !value.equals("");
  }

  public void ban() {
    minCardinality = 0;
    maxCardinality = 0;
    conformance = Conformance.Prohibited;
  }

  public void setDerivation(Element_ derivation) {
    this.derivation = derivation;    
  }

  public boolean isInherited() {
    return inherited;
  }

  public void setInherited(boolean inherited) {
    this.inherited = inherited;
  }

  public Element_ getDerivation() {
    return derivation;
  }
 
  
  // Returns true is this element is a standard Resource element 
  // like 'id', 'extensions' and 'text'
  public boolean isBaseResourceElement()
  {
	  return	getName().equals("id") ||
			  	getName().equals("extensions") ||
			  	getName().equals("text");
  }
  
  public boolean isBoundCode()
  {
	  return typeCode().equals("code") && hasConceptDomain();
  }
}