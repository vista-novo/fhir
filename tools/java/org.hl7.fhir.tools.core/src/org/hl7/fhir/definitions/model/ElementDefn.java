package org.hl7.fhir.definitions.model;

/*
 Copyright (c) 2011-2012, HL7, Inc
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, 
 are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
 list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
 this list of conditions and the following disclaimer in the documentation 
 and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
 endorse or promote products derived from this software without specific 
 prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 POSSIBILITY OF SUCH DAMAGE.

 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.instance.model.Profile.Element_;

public class ElementDefn {

	private List<TypeRef> types = new ArrayList<TypeRef>();
	private List<ElementDefn> elements = new ArrayList<ElementDefn>();

	private Integer minCardinality;
	private Integer maxCardinality;
	private Invariant invariant; // a reference to an invariant defined on another element, but which constrains this one
	private boolean mustUnderstand;
	private boolean mustSupport;

	// private String id;
	private String bindingName;
	private String dir;
	private String name;
	private String shortDefn;
	private String definition;
	private String requirements;
	private String rimMapping;
	private String comments;
	private String v2Mapping;
	private String todo;
	private String committeeNotes;
	private String condition;
	private String example;
	private String profileName; // only in a profile, for unpicking
	private String value; // only in a profile
	private String aggregation; // only in a profile
	private Element_ derivation;
	private boolean inherited; // in a profile, was this element add from the
								// base definition (true) or was it specifically
								// constrained in the profile (false)

	public ElementDefn() {
		super();
	}

	public ElementDefn(ElementDefn pattern) {
		super();
		types.addAll(pattern.types);
		for (ElementDefn c : pattern.getElements())
			elements.add(new ElementDefn(c));

		minCardinality = pattern.minCardinality;
		maxCardinality = pattern.maxCardinality;
		invariant = pattern.invariant;
		mustUnderstand = pattern.mustUnderstand;
		mustSupport = pattern.mustSupport;

		bindingName = pattern.bindingName;
		name = pattern.name;
		shortDefn = pattern.shortDefn;
		definition = pattern.definition;
		requirements = pattern.requirements;
		rimMapping = pattern.rimMapping;
		comments = pattern.comments;
		v2Mapping = pattern.v2Mapping;
		todo = pattern.todo;
		committeeNotes = pattern.committeeNotes;
		condition = pattern.condition;
		example = pattern.example;
		profileName = pattern.profileName;
		value = pattern.value;
		inherited = pattern.inherited;

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
		return (definition == null || "".equals(definition)) ? shortDefn
				: definition;
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

	public List<ElementDefn> getElements() {
		return elements;
	}

	public boolean hasNestedElements() {
		return elements != null && !elements.isEmpty();
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
		String n = name.contains(".") ? name.substring(0, name.indexOf("."))
				: name;
		String t = name.contains(".") ? name.substring(name.indexOf(".") + 1)
				: null;
		if (n.equals(this.name) && t != null)
			return getElementByName(t);

		for (int i = elements.size() - 1; i >= 0; i--) {
			ElementDefn e = elements.get(i);
			if (e.getName().equalsIgnoreCase(n))
				return t == null ? e : e.getElementByName(t);
			if (e.getName().length() > name.length()
					&& e.getName().substring(0, name.length())
							.equalsIgnoreCase(name)
					&& e.getElements().size() == 1
					&& e.getElements().get(0).getName().equalsIgnoreCase(name))
				return e.getElements().get(0);
		}
		return null;
	}

	public ElementDefn getElementByProfileName(String name) {
		for (int i = elements.size() - 1; i >= 0; i--) {
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

	// public String getId() {
	// return id;
	// }
	//
	// public void setId(String id) {
	// this.id = id;
	// }


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
			return minCardinality.toString() + "..*";
		else
			return minCardinality.toString() + ".." + maxCardinality.toString();
	}

	// public String textForCardinality() {
	// if (maxCardinality != null) {
	// if (maxCardinality == 1)
	// if (minCardinality == 0)
	// return "?One";
	// else
	// return "One";
	// else
	// return "??";
	// } else if (minCardinality == 0)
	// return "Zero+";
	// else
	// return "One+";
	// }

	public boolean hasDefinition() {
		return (this.definition != null && !this.definition.equals(""))
				|| (shortDefn != null && !this.shortDefn.equals(""));
	}

	public boolean unbounded() {
		return maxCardinality == null;
	}

	public boolean hasBinding() {
		return bindingName != null && !bindingName.equals("");
	}

	// If an element with children explicitly declares a typename
	// ('=<typename>' in Excel "Type" column), a resource-local type is
	// defined and its name stored on the parent element.
	private String declaredTypeName = null;
	
	public String getDeclaredTypeName()
	{
		return declaredTypeName;
	}
	
	public void setDeclaredTypeName(String typeName)
	{
		this.declaredTypeName = typeName;
	}
	
	
	private boolean isAnonymousTypedGroup = false;
	
	public boolean isAnonymousTypedGroup()
	{
		return this.isAnonymousTypedGroup;
	}
	
	public void setAnonymousTypedGroup(boolean value)
	{
		this.isAnonymousTypedGroup = value;
	}

	public List<TypeRef> getTypes() {
		return types;
	}
	
	public boolean hasType(String name) {
		return types.size() == 1 && types.get(0).getName().equals(name);
	}

	public String typeCode() {
		StringBuilder tn = new StringBuilder();
		boolean first = true;
		for (TypeRef t : types) {
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

	
	public boolean usesCompositeType() {
		return this.typeCode().startsWith("@");
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAggregation() {
		return aggregation;
	}

	public void setAggregation(String aggregation) {
		this.aggregation = aggregation;
	}

	public boolean hasAggregation() {
		return aggregation != null && !aggregation.equals("");
	}

	public boolean hasValue() {
		return value != null && !value.equals("");
	}

	public void ban() {
		minCardinality = 0;
		maxCardinality = 0;
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

	/**
	 * Warning: this method is only safe to call if the owner element has type
	 * "resource". The element names "id" and "text" are used in other contexts
	 * for valid element names
	 * 
	 * @return if this element is a standard Resource element like 'id',
	 *         'extension' and 'text'
	 */
	public boolean isBaseResourceElement() {
		return getName().equals("id") || getName().equals("extension")
				|| getName().equals("text");
	}

	public boolean isBoundCode() {
		return typeCode().equals("code") && hasBinding();
	}

	public Invariant getInvariant() {
		return invariant;
	}

	public void setInvariant(Invariant invariant) {
		this.invariant = invariant;
	}

	public boolean isMustSupport() {
		return mustSupport;
	}

	public void setMustSupport(boolean mustSupport) {
		this.mustSupport = mustSupport;
	}


	public boolean isXhtmlElement() {
		return !types.isEmpty() && types.get(0).isXhtml();
	}

	
	public ElementDefn getElementForPath(String pathname) throws Exception {
		String[] path = pathname.split("\\.");

		if (!path[0].equals(getName()))
			throw new Exception("Element Path '" + pathname
					+ "' is not legal in this context");

		ElementDefn res = this;

		for (int i = 1; i < path.length; i++) {
			String en = path[i];
			if (en.length() == 0)
				throw new Exception("Improper path " + pathname);

			ElementDefn t = res.getElementByName(en);
			if (t == null) {
				throw new Exception("unable to resolve " + pathname);
			}

			res = t;
		}

		return res;
	}

	
	   /**** 
	    * Helper data for mapping the current model definitions to the
	    * eCore model. Are valid if this ElementDefn is the root of a type
	    * 	NestedTypes() - The nested groups of elements which are reused within
	    * 					the same resource/composite type and have been given an
	    * 					explicit name using the new '=<typename>' construct.
	    * 	NestedBindings() - The bindings as defined on the "Bindings" tab in
	    * 					the resource/composite type specification xls.
	    *   Invariants()  - The variants as referred to by the elements of
	    *   				a resource or composite type
	    *   AcceptableGenericTypes() - The types that may be uses as generic parameter
	    *   				to this type, as specified in fhir.ini (e.g. Interval(dateTime))			
	    ****/
	      
	   private Map<String, ElementDefn> nestedTypes = new HashMap<String, ElementDefn>();
	   
	   public Map<String, ElementDefn> getNestedTypes()
	   {
		   return nestedTypes;
	   }
	   
	   public boolean hasNestedType(String typename)
	   {
		   return nestedTypes.containsKey(typename);
	   }

	   
	   private Map<String, BindingSpecification> nestedBindings = new HashMap<String, BindingSpecification>();
	   
	   public Map<String, BindingSpecification> getNestedBindings()
	   {
		   return nestedBindings;
	   }

	   private Map<String, Invariant> invariants = new HashMap<String, Invariant>();

	   public Map<String, Invariant> getInvariants() 
	   {
			    return invariants;
	   }
	   
	   private List<String> acceptableGenericTypes = new ArrayList<String>();

	   public List<String> getAcceptableGenericTypes()
	   {
		   return acceptableGenericTypes;
	   }

    public boolean isXmlIDRef() {
      return typeCode().equals("idref");
    }

    public boolean hasComments() {
      return comments != null && !"".equals(comments);
    }

    public boolean hasBindingName() {
      return bindingName != null && !"".equals(bindingName);
    }

    public boolean hasRimMapping() {
      return rimMapping != null && !"".equals(rimMapping);
    }

    public String getDir() {
      return dir;
    }

    public void setDir(String dir) {
      this.dir = dir;
    }
    
}

