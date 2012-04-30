package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on 19:37 Apr 30, 2012 for FHIR v0.01

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
         * Name this constraint for re-use & unrolling
         */
        private String name;

        /**
         * Human summary: why describe this element?
         */
        private String purpose;

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
        private String type;

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
         * More specific definition
         */
        private String definition;

        /**
         * 
         */
        private List<Mapping> mapping = new ArrayList<Mapping>();

        /**
         * If context includes aggregation and type=Resource()
         */
        private Aggregation aggregation;

        /**
         * Value set id (only if coded)
         */
        private String valueSet;

        /**
         * 
         */
        private List<Value> value = new ArrayList<Value>();

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

        public String getPurpose() { 
          return this.purpose;
        }

        public void setPurpose(String value) { 
          this.purpose = value;
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

        public String getType() { 
          return this.type;
        }

        public void setType(String value) { 
          this.type = value;
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

        public String getDefinition() { 
          return this.definition;
        }

        public void setDefinition(String value) { 
          this.definition = value;
        }

        public List<Mapping> getMapping() { 
          return this.mapping;
        }

        public Aggregation getAggregation() { 
          return this.aggregation;
        }

        public void setAggregation(Aggregation value) { 
          this.aggregation = value;
        }

        public String getValueSet() { 
          return this.valueSet;
        }

        public void setValueSet(String value) { 
          this.valueSet = value;
        }

        public List<Value> getValue() { 
          return this.value;
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

    public class Aggregation extends Element {
        /**
         * Whether this resource is aggregated
         */
        private boolean aggregated;

        /**
         * Reference to a Named Resource Profile
         */
        private String name;

        public boolean getAggregated() { 
          return this.aggregated;
        }

        public void setAggregated(boolean value) { 
          this.aggregated = value;
        }

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

    }

    public class Value extends Element {
        /**
         * Reference to another element by element.name
         */
        private String name;

        /**
         * Fixed value: [as defined for type]
         */
        private Type value;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
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
     * The name of an aggregation profile
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

