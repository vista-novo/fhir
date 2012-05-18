package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Fri, May 18, 2012 22:20+1000 for FHIR v0.02

import java.util.*;

/**
 * 
 */
public class Constraint extends Element {

    public enum ConformanceType {
        Mandatory, // The element is or must always be present without a dataAbsentReason
        Conditional, // The element may need to be present (with no dataAbsentReasons) depending on the condition
        Optional, // The element may or may not be present
        Prohibited; // The element can not present or will be rejected if received
        public static ConformanceType fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("Mandatory".equals(code))
          return Mandatory;
        if ("Conditional".equals(code))
          return Conditional;
        if ("Optional".equals(code))
          return Optional;
        if ("Prohibited".equals(code))
          return Prohibited;
        throw new Exception("Unknown ConformanceType code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case Mandatory: return "Mandatory";
            case Conditional: return "Conditional";
            case Optional: return "Optional";
            case Prohibited: return "Prohibited";
            default: return "?";
          }
        }
    }

    public class Element_ extends Element {
        /**
         * The path of the element (see the formal definitions)
         */
        private String path;

        /**
         * Name of constraint for unpicking - see above
         */
        private String name;

        /**
         * A concise definition that  is shown in the concise XML format that summarises profiles
         */
        private String shortDefn;

        /**
         * a more specific definition than the definition for the same element in the base resource. The definition must be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource
         */
        private String definition;

        /**
         * Comments about the use of the element, including notes about how to use the data properly, exceptions to proper use, etc
         */
        private String comments;

        /**
         * Minimum Cardinality
         */
        private int min;

        /**
         * Maximum Cardinality (a number or *)
         */
        private String max;

        /**
         * Type of the element
         */
        private List<String> type = new ArrayList<String>();

        /**
         * Mandatory|Conditional|Optional|Prohibited
         */
        private ConformanceType conformance;

        /**
         * Condition if conformance=Conditional
         */
        private String condition;

        /**
         * If the element must be usable
         */
        private boolean mustSupport;

        /**
         * If the element must be understood
         */
        private boolean mustUnderstand;

        /**
         * 
         */
        private List<Mapping> mapping = new ArrayList<Mapping>();

        /**
         * If context includes aggregation and type=Resource()
         */
        private Resource resource;

        /**
         * Value set id (only if coded)
         */
        private String binding;

        /**
         * Name (internal ref) or fixed value but not both
         */
        private List<Content> content = new ArrayList<Content>();

        public String getPath() { 
          return this.path;
        }

        public void setPath(String value) { 
          this.path = value;
        }

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public String getShortDefn() { 
          return this.shortDefn;
        }

        public void setShortDefn(String value) { 
          this.shortDefn = value;
        }

        public String getDefinition() { 
          return this.definition;
        }

        public void setDefinition(String value) { 
          this.definition = value;
        }

        public String getComments() { 
          return this.comments;
        }

        public void setComments(String value) { 
          this.comments = value;
        }

        public int getMin() { 
          return this.min;
        }

        public void setMin(int value) { 
          this.min = value;
        }

        public String getMax() { 
          return this.max;
        }

        public void setMax(String value) { 
          this.max = value;
        }

        public List<String> getType() { 
          return this.type;
        }

        public ConformanceType getConformance() { 
          return this.conformance;
        }

        public void setConformance(ConformanceType value) { 
          this.conformance = value;
        }

        public String getCondition() { 
          return this.condition;
        }

        public void setCondition(String value) { 
          this.condition = value;
        }

        public boolean getMustSupport() { 
          return this.mustSupport;
        }

        public void setMustSupport(boolean value) { 
          this.mustSupport = value;
        }

        public boolean getMustUnderstand() { 
          return this.mustUnderstand;
        }

        public void setMustUnderstand(boolean value) { 
          this.mustUnderstand = value;
        }

        public List<Mapping> getMapping() { 
          return this.mapping;
        }

        public Resource getResource() { 
          return this.resource;
        }

        public void setResource(Resource value) { 
          this.resource = value;
        }

        public String getBinding() { 
          return this.binding;
        }

        public void setBinding(String value) { 
          this.binding = value;
        }

        public List<Content> getContent() { 
          return this.content;
        }

    }

    public class Mapping extends Element {
        /**
         * Which mapping this is (v2, CDA, openEHR, etc)
         */
        private String target;

        /**
         * Details of the mapping
         */
        private String map;

        public String getTarget() { 
          return this.target;
        }

        public void setTarget(String value) { 
          this.target = value;
        }

        public String getMap() { 
          return this.map;
        }

        public void setMap(String value) { 
          this.map = value;
        }

    }

    public class Resource extends Element {
        /**
         * Whether this resource is aggregated
         */
        private boolean aggregated;

        /**
         * Reference to a Resource Profile
         */
        private java.net.URI profile;

        public boolean getAggregated() { 
          return this.aggregated;
        }

        public void setAggregated(boolean value) { 
          this.aggregated = value;
        }

        public java.net.URI getProfile() { 
          return this.profile;
        }

        public void setProfile(java.net.URI value) { 
          this.profile = value;
        }

    }

    public class Content extends Element {
        /**
         * to another element constraint (by element.name)
         */
        private String nameReference;

        /**
         * Fixed value: [as defined for type]
         */
        private Type value;

        public String getNameReference() { 
          return this.nameReference;
        }

        public void setNameReference(String value) { 
          this.nameReference = value;
        }

        public Type getValue() { 
          return this.value;
        }

        public void setValue(Type value) { 
          this.value = value;
        }

    }

    /**
     * The Type of the resource being described
     */
    private String type;

    /**
     * Reference to a resource profile which includes the constraint statement that applies to this resource
     */
    private java.net.URI profile;

    /**
     * The name of this aggregation profile
     */
    private String name;

    /**
     * Human summary: why describe this resource?
     */
    private String purpose;

    /**
     * 
     */
    private List<Element_> element = new ArrayList<Element_>();

    public String getType() { 
      return this.type;
    }

    public void setType(String value) { 
      this.type = value;
    }

    public java.net.URI getProfile() { 
      return this.profile;
    }

    public void setProfile(java.net.URI value) { 
      this.profile = value;
    }

    public String getName() { 
      return this.name;
    }

    public void setName(String value) { 
      this.name = value;
    }

    public String getPurpose() { 
      return this.purpose;
    }

    public void setPurpose(String value) { 
      this.purpose = value;
    }

    public List<Element_> getElement() { 
      return this.element;
    }


}

