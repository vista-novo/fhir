package org.hl7.fhir.instance.model;

// Copyright HL7 (http://www.hl7.org). Generated on Mon, May 14, 2012 02:13+1000 for FHIR v0.01

import java.util.*;

/**
 * A Resource Profile - a statement of constraint on one or more Resources and/or Concept Domains
 */
public class Profile extends Resource {

    public enum ResourceProfileStatus {
        draft, // This profile is still under development
        testing, // this profile was authored for testing purposes (or education/evaluation/evangelisation)
        production, // This profile is ready for use in production systems
        withdrawn, // This profile has been withdrawn
        superceded; // This profile was superceded by a more recent version
        public static ResourceProfileStatus fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("draft".equals(code))
          return draft;
        if ("testing".equals(code))
          return testing;
        if ("production".equals(code))
          return production;
        if ("withdrawn".equals(code))
          return withdrawn;
        if ("superceded".equals(code))
          return superceded;
        throw new Exception("Unknown ResourceProfileStatus code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case draft: return "draft";
            case testing: return "testing";
            case production: return "production";
            case withdrawn: return "withdrawn";
            case superceded: return "superceded";
            default: return "?";
          }
        }
    }

    public enum ConceptBindingType {
        Unbound, // The concept domain is not bound to anything
        CodeList, // The concept domain is bound to a list of supplied codes - only those codes are allowed
        Reference, // The concept domain references some external definition by a provided reference
        Preferred, // The concept domain references a set of preferred terms
        Suggestion, // This profile was superceded by a more recent version
        External; // The concept domain is defined by an external authority identified in the reference
        public static ConceptBindingType fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("Unbound".equals(code))
          return Unbound;
        if ("CodeList".equals(code))
          return CodeList;
        if ("Reference".equals(code))
          return Reference;
        if ("Preferred".equals(code))
          return Preferred;
        if ("Suggestion".equals(code))
          return Suggestion;
        if ("External".equals(code))
          return External;
        throw new Exception("Unknown ConceptBindingType code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case Unbound: return "Unbound";
            case CodeList: return "CodeList";
            case Reference: return "Reference";
            case Preferred: return "Preferred";
            case Suggestion: return "Suggestion";
            case External: return "External";
            default: return "?";
          }
        }
    }

    public class Author extends Element {
        /**
         * The name of the author
         */
        private String_ name;

        /**
         * Reference to the author to assist a user in finding and communicating with the author
         */
        private List<Uri> reference = new ArrayList<Uri>();

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public List<Uri> getReference() { 
          return this.reference;
        }

    }

    public class Endorser extends Element {
        /**
         * The name of the endorsing body
         */
        private String_ name;

        /**
         * Reference to the author to assist a user in finding and communicating with the endorsing body
         */
        private Uri reference;

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public Uri getReference() { 
          return this.reference;
        }

        public void setReference(Uri value) { 
          this.reference = value;
        }

    }

    public class Binding extends Element {
        /**
         * The name of the concept domain that this profile is declaring a constraint on
         */
        private String_ name;

        /**
         * The form of the binding
         */
        private ConceptBindingType type;

        /**
         * extra details - see notes
         */
        private String_ details;

        /**
         * source of binding content
         */
        private Uri reference;

        /**
         * enumerated codes that are the binding
         */
        private List<Coding> code = new ArrayList<Coding>();

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public ConceptBindingType getType() { 
          return this.type;
        }

        public void setType(ConceptBindingType value) { 
          this.type = value;
        }

        public String_ getDetails() { 
          return this.details;
        }

        public void setDetails(String_ value) { 
          this.details = value;
        }

        public Uri getReference() { 
          return this.reference;
        }

        public void setReference(Uri value) { 
          this.reference = value;
        }

        public List<Coding> getCode() { 
          return this.code;
        }

    }

    /**
     * A free text natural language name identifying the Template.
     */
    private String_ name;

    /**
     * Details of the author who accepts responsibility for publishing the profile
     */
    private Author author;

    /**
     * A free text natural language description of the intent and scope of the Template. The purpose is to provide the author’s initial intent for the Template in the language specified below.
     */
    private String_ intention;

    /**
     * A set of terms from a controlled reference terminology that may be used to assist with indexing and searching of templates
     */
    private List<Coding> code = new ArrayList<Coding>();

    /**
     * A free text natural language description of the Template. Generally, this field should be used for things such as goals, variable lists, instructions for clinical use and interpretation, literature, examples from paper world, mapping from natural language to HL7 and the model itself, etc
     */
    private String_ description;

    /**
     * A description, reference or link to a published medical knowledge that was used in the definition of this Template
     */
    private List<Uri> evidence = new ArrayList<Uri>();

    /**
     * A statement regarding when this Template should not be used, or may be used erroneously. To define roles where the Template should not be used, or should be used with care. This field is used to expand in detail on the iIntention
     */
    private String_ comments;

    /**
     * draft | testing | production | withdrawn | superceded
     */
    private ResourceProfileStatus status;

    /**
     * The date that the current value for publicationStatus was applied to the Template
     */
    private DateTime date;

    /**
     * A list of bodies who have reviewed the Template for clinical accuracy and relevance, and endorsed it for use.
     */
    private List<Endorser> endorser = new ArrayList<Endorser>();

    /**
     * A free text description describing the changes in this version of the profile as compared to the previous version. 
     */
    private String_ changes;

    /**
     * A template that is supercded by this template (maybe a  previous version)
     */
    private List<Uri> supercedes = new ArrayList<Uri>();

    /**
     * Additional other profiles that apply to this conformance statement.
     */
    private List<Uri> profile = new ArrayList<Uri>();

    /**
     * Resource Type with constraints
     */
    private List<Constraint> resource = new ArrayList<Constraint>();

    /**
     * 
     */
    private List<Binding> binding = new ArrayList<Binding>();

    public String_ getName() { 
      return this.name;
    }

    public void setName(String_ value) { 
      this.name = value;
    }

    public Author getAuthor() { 
      return this.author;
    }

    public void setAuthor(Author value) { 
      this.author = value;
    }

    public String_ getIntention() { 
      return this.intention;
    }

    public void setIntention(String_ value) { 
      this.intention = value;
    }

    public List<Coding> getCode() { 
      return this.code;
    }

    public String_ getDescription() { 
      return this.description;
    }

    public void setDescription(String_ value) { 
      this.description = value;
    }

    public List<Uri> getEvidence() { 
      return this.evidence;
    }

    public String_ getComments() { 
      return this.comments;
    }

    public void setComments(String_ value) { 
      this.comments = value;
    }

    public ResourceProfileStatus getStatus() { 
      return this.status;
    }

    public void setStatus(ResourceProfileStatus value) { 
      this.status = value;
    }

    public DateTime getDate() { 
      return this.date;
    }

    public void setDate(DateTime value) { 
      this.date = value;
    }

    public List<Endorser> getEndorser() { 
      return this.endorser;
    }

    public String_ getChanges() { 
      return this.changes;
    }

    public void setChanges(String_ value) { 
      this.changes = value;
    }

    public List<Uri> getSupercedes() { 
      return this.supercedes;
    }

    public List<Uri> getProfile() { 
      return this.profile;
    }

    public List<Constraint> getResource() { 
      return this.resource;
    }

    public List<Binding> getBinding() { 
      return this.binding;
    }


}

