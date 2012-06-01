package org.hl7.fhir.instance.model;

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

// Generated on Sat, Jun 2, 2012 08:18+1000 for FHIR v0.03

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

    public enum ExtensionContextType {
        resource, // The extension can be used in the resource or resources provided in the path. The path consists of one or more resource names, seaprated by commas
        datatype, // The extension can be used anywhere a data type is used. The path has the form [DataType](.name) where (.name) is used to refer to a context within the data type
        elements, // the extension is used on one or elements in one or more resources. The path consists of a series of element paths separated by commas
        mapping, // The extension is allowed to be used anywhere that makes sense given the identified mapping. The path identifies the mapping by name. The mapping should clearly identify where such an extension could be used, though this may not be computable
        extension; // The extension identifies another extension. The path consists of uri#name, where uri identifies the profile, and #name identifies the extension
        public static ExtensionContextType fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("resource".equals(code))
          return resource;
        if ("datatype".equals(code))
          return datatype;
        if ("elements".equals(code))
          return elements;
        if ("mapping".equals(code))
          return mapping;
        if ("extension".equals(code))
          return extension;
        throw new Exception("Unknown ExtensionContextType code '"+code+"'");
        }
        public String toCode() {
          switch (this) {
            case resource: return "resource";
            case datatype: return "datatype";
            case elements: return "elements";
            case mapping: return "mapping";
            case extension: return "extension";
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
        private String name;

        /**
         * Reference to the author to assist a user in finding and communicating with the author
         */
        private java.net.URI reference;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public java.net.URI getReference() { 
          return this.reference;
        }

        public void setReference(java.net.URI value) { 
          this.reference = value;
        }

    }

    public class Endorser extends Element {
        /**
         * The name of the endorsing body
         */
        private String name;

        /**
         * Reference to the author to assist a user in finding and communicating with the endorsing body
         */
        private java.net.URI reference;

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public java.net.URI getReference() { 
          return this.reference;
        }

        public void setReference(java.net.URI value) { 
          this.reference = value;
        }

    }

    public class Resource extends Element {
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

    public class Element_ extends Element {
        /**
         * The path identifies the element
         */
        private String path;

        /**
         * Name of constraint for slicing - see above
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
         * if @dataAbsentReason is allowed
         */
        private boolean dataAbsentReason;

        /**
         * A reference to an invariant that may make additional statements about the cardinality in the instance
         */
        private String condition;

        /**
         * Xpath condition that must evaluate to true
         */
        private List<String> constraint = new ArrayList<String>();

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
        private ResourceA resource;

        /**
         * Value set id (only if coded)
         */
        private String binding;

        /**
         * Name (internal ref) or fixed value but not both
         */
        private List<Content> content = new ArrayList<Content>();

        /**
         * if list, whether derived profiles can slice more
         */
        private boolean closed;

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

        public boolean getDataAbsentReason() { 
          return this.dataAbsentReason;
        }

        public void setDataAbsentReason(boolean value) { 
          this.dataAbsentReason = value;
        }

        public String getCondition() { 
          return this.condition;
        }

        public void setCondition(String value) { 
          this.condition = value;
        }

        public List<String> getConstraint() { 
          return this.constraint;
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

        public ResourceA getResource() { 
          return this.resource;
        }

        public void setResource(ResourceA value) { 
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

        public boolean getClosed() { 
          return this.closed;
        }

        public void setClosed(boolean value) { 
          this.closed = value;
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

    public class ResourceA extends Element {
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

    public class ExtensionDefn extends Element {
        /**
         * How the path of the extension is understood
         */
        private ExtensionContextType contextType;

        /**
         * Details of the extension
         */
        private Element_ element;

        public ExtensionContextType getContextType() { 
          return this.contextType;
        }

        public void setContextType(ExtensionContextType value) { 
          this.contextType = value;
        }

        public Element_ getElement() { 
          return this.element;
        }

        public void setElement(Element_ value) { 
          this.element = value;
        }

    }

    public class Binding extends Element {
        /**
         * The name of the concept domain that this profile is declaring a constraint on
         */
        private String name;

        /**
         * The form of the binding
         */
        private ConceptBindingType type;

        /**
         * extra details - see notes
         */
        private String details;

        /**
         * source of binding content
         */
        private java.net.URI reference;

        /**
         * enumerated codes that are the binding
         */
        private List<Coding> code = new ArrayList<Coding>();

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public ConceptBindingType getType() { 
          return this.type;
        }

        public void setType(ConceptBindingType value) { 
          this.type = value;
        }

        public String getDetails() { 
          return this.details;
        }

        public void setDetails(String value) { 
          this.details = value;
        }

        public java.net.URI getReference() { 
          return this.reference;
        }

        public void setReference(java.net.URI value) { 
          this.reference = value;
        }

        public List<Coding> getCode() { 
          return this.code;
        }

    }

    /**
     * A free text natural language name identifying the Template.
     */
    private String name;

    /**
     * Details of the author who accepts responsibility for publishing the profile
     */
    private Author author;

    /**
     * A free text natural language description of the intent and scope of the Template. The purpose is to provide the author’s initial intent for the Template in the language specified below.
     */
    private String intention;

    /**
     * A set of terms from a controlled reference terminology that may be used to assist with indexing and searching of templates
     */
    private List<Coding> code = new ArrayList<Coding>();

    /**
     * A free text natural language description of the Template. Generally, this field should be used for things such as goals, variable lists, instructions for clinical use and interpretation, literature, examples from paper world, mapping from natural language to HL7 and the model itself, etc
     */
    private String description;

    /**
     * A description, reference or link to a published medical knowledge that was used in the definition of this Template
     */
    private List<java.net.URI> evidence = new ArrayList<java.net.URI>();

    /**
     * A statement regarding when this Template should not be used, or may be used erroneously. To define roles where the Template should not be used, or should be used with care. This field is used to expand in detail on the iIntention
     */
    private String comments;

    /**
     * draft | testing | production | withdrawn | superceded
     */
    private ResourceProfileStatus status;

    /**
     * The date that the current value for publicationStatus was applied to the Template
     */
    private String date;

    /**
     * A list of bodies who have reviewed the Template for clinical accuracy and relevance, and endorsed it for use.
     */
    private List<Endorser> endorser = new ArrayList<Endorser>();

    /**
     * A free text description describing the changes in this version of the profile as compared to the previous version. 
     */
    private String changes;

    /**
     * A template that is superceded by this template (may be a  previous version)
     */
    private List<java.net.URI> supercedes = new ArrayList<java.net.URI>();

    /**
     * Additional other profiles that apply to this conformance statement.
     */
    private List<java.net.URI> profile = new ArrayList<java.net.URI>();

    /**
     * Resource Type with constraints
     */
    private List<Resource> resource = new ArrayList<Resource>();

    /**
     * Definition of an extension
     */
    private List<ExtensionDefn> extensionDefn = new ArrayList<ExtensionDefn>();

    /**
     * 
     */
    private List<Binding> binding = new ArrayList<Binding>();

    public String getName() { 
      return this.name;
    }

    public void setName(String value) { 
      this.name = value;
    }

    public Author getAuthor() { 
      return this.author;
    }

    public void setAuthor(Author value) { 
      this.author = value;
    }

    public String getIntention() { 
      return this.intention;
    }

    public void setIntention(String value) { 
      this.intention = value;
    }

    public List<Coding> getCode() { 
      return this.code;
    }

    public String getDescription() { 
      return this.description;
    }

    public void setDescription(String value) { 
      this.description = value;
    }

    public List<java.net.URI> getEvidence() { 
      return this.evidence;
    }

    public String getComments() { 
      return this.comments;
    }

    public void setComments(String value) { 
      this.comments = value;
    }

    public ResourceProfileStatus getStatus() { 
      return this.status;
    }

    public void setStatus(ResourceProfileStatus value) { 
      this.status = value;
    }

    public String getDate() { 
      return this.date;
    }

    public void setDate(String value) { 
      this.date = value;
    }

    public List<Endorser> getEndorser() { 
      return this.endorser;
    }

    public String getChanges() { 
      return this.changes;
    }

    public void setChanges(String value) { 
      this.changes = value;
    }

    public List<java.net.URI> getSupercedes() { 
      return this.supercedes;
    }

    public List<java.net.URI> getProfile() { 
      return this.profile;
    }

    public List<Resource> getResource() { 
      return this.resource;
    }

    public List<ExtensionDefn> getExtensionDefn() { 
      return this.extensionDefn;
    }

    public List<Binding> getBinding() { 
      return this.binding;
    }


}

