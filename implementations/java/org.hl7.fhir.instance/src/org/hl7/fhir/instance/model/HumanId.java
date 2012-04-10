package org.hl7.fhir.instance.model;

// © HL7 (http://www.hl7.org)  Generated on 10:56 Apr 10, 2012 for FHIR v0.01

/**
 * An identifier that humans use. This is different to a system identifier because identifiers that humans use are regularly changed or retired due to human intervention and error. Note that an human identifier may be a system identifier on some master system, but becomes a human identifier elsewhere due to how it is exchanged between humans. Driver's license nunmbers are a good example of this. Also, because human mediated identifiers are often invoked as implicit links to external business processes, such identifiers are often associated with multiple different resources. 
 */
public class HumanId extends Type {

    /**
     * The type of the identifier - to allow a particular identifier to be picked elsewhere
     */
    private Coding type;

    /**
     * The Actual identifier
     */
    private Identifier identifier;

    /**
     * Time period during which identifier was valid for use
     */
    private Interval<DateTime> period;

    /**
     * Organisation that issued/manages the identifier
     */
    private ResourceReference assigner;

    public Coding getType() { 
      return this.type;
    }

    public void setType(Coding value) { 
      this.type = value;
    }

    public Identifier getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(Identifier value) { 
      this.identifier = value;
    }

    public Interval<DateTime> getPeriod() { 
      return this.period;
    }

    public void setPeriod(Interval<DateTime> value) { 
      this.period = value;
    }

    public ResourceReference getAssigner() { 
      return this.assigner;
    }

    public void setAssigner(ResourceReference value) { 
      this.assigner = value;
    }


}

