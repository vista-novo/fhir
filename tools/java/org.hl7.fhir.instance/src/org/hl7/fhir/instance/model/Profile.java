package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2012, HL7, Inc.
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

// Generated on Fri, Oct 26, 2012 20:23+1100 for FHIR v0.06

import java.util.*;

/**
 * A Resource Profile - a statement of use of FHIR. May include constraints on Resources, Terminology Binding Statements and Extension Definitions
 */
public class Profile extends Resource {

    public enum ResourceProfileStatus {
        draft, // This profile is still under development
        testing, // this profile was authored for testing purposes (or education/evaluation/marketing)
        review, // This profile is undergoing review to check that it is ready for production use
        production, // This profile is ready for use in production systems
        withdrawn, // This profile has been withdrawn
        superseded; // This profile was superseded by a more recent version
        public static ResourceProfileStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return draft;
        if ("testing".equals(codeString))
          return testing;
        if ("review".equals(codeString))
          return review;
        if ("production".equals(codeString))
          return production;
        if ("withdrawn".equals(codeString))
          return withdrawn;
        if ("superseded".equals(codeString))
          return superseded;
        throw new Exception("Unknown ResourceProfileStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case draft: return "draft";
            case testing: return "testing";
            case review: return "review";
            case production: return "production";
            case withdrawn: return "withdrawn";
            case superseded: return "superseded";
            default: return "?";
          }
        }
    }

    public enum ExtensionContext {
        resource, // The context is all elements matching a particular resource element path
        datatype, // The context is all nodes matching a particular data type element path (root or repeating element) or all elements referencing a particular primitive data type (expressed as the datatype name)
        mapping, // The context is all nodes whose mapping to a specified reference model corresponds to a particular mapping structure.  The context identifies the mapping target. The mapping should clearly identify where such an extension could be used, though this 
        extension; // The context is a particular extension from a particular profile.  Expressed as uri#name, where uri identifies the profile and #name identifies the extension code
        public static ExtensionContext fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("resource".equals(codeString))
          return resource;
        if ("datatype".equals(codeString))
          return datatype;
        if ("mapping".equals(codeString))
          return mapping;
        if ("extension".equals(codeString))
          return extension;
        throw new Exception("Unknown ExtensionContext code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case resource: return "resource";
            case datatype: return "datatype";
            case mapping: return "mapping";
            case extension: return "extension";
            default: return "?";
          }
        }
    }

    public enum BindingType {
        valueset, // The binding name has an associated URL which is a reference to a Value Set Resource that provides a formal definition of the set of possible codes
        codelist, // The binding name is associated with a simple list of codes, and definitions from some identified code system (SID, URI, OID, UUID). In resource definitions, the system reference may be omitted, and a list of custom codes with definitions supplied (this is for status and workflow fields that applications need to know)
        reference, // The binding name has an associated URL which refers to some external standard or specification that defines the possible codes
        special; // The binding points to a list of concepts defined as part of FHIR itself (see below for possible values)
        public static BindingType fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("valueset".equals(codeString))
          return valueset;
        if ("codelist".equals(codeString))
          return codelist;
        if ("reference".equals(codeString))
          return reference;
        if ("special".equals(codeString))
          return special;
        throw new Exception("Unknown BindingType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case valueset: return "valueset";
            case codelist: return "codelist";
            case reference: return "reference";
            case special: return "special";
            default: return "?";
          }
        }
    }

    public enum BindingConformance {
        required, // Only codes in the specified set are allowed.  If the binding is extensible, other codes may be used for concepts not covered by the bound set of codes.
        preferred, // For greater interoperability, implementers are strongly encouraged to use the bound set of codes, however alternate codes may be used in profiles if necessary without being considered non-conformant.
        example; // The codes in the set are an example to illustrate the meaning of the field. There is no particular preference for its use
        public static BindingConformance fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("required".equals(codeString))
          return required;
        if ("preferred".equals(codeString))
          return preferred;
        if ("example".equals(codeString))
          return example;
        throw new Exception("Unknown BindingConformance code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case required: return "required";
            case preferred: return "preferred";
            case example: return "example";
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
        private List<java.net.URI> reference = new ArrayList<java.net.URI>();

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public List<java.net.URI> getReference() { 
          return this.reference;
        }

    }

    public class Status extends Element {
        /**
         * A coded value for the position of the profile within its life-cycle
         */
        private ResourceProfileStatus code;

        /**
         * The date that the current value for status was applied to the profile
         */
        private String date;

        /**
         * Additional commentary related to the profile's status
         */
        private String comment;

        public ResourceProfileStatus getCode() { 
          return this.code;
        }

        public void setCode(ResourceProfileStatus value) { 
          this.code = value;
        }

        public String getDate() { 
          return this.date;
        }

        public void setDate(String value) { 
          this.date = value;
        }

        public String getComment() { 
          return this.comment;
        }

        public void setComment(String value) { 
          this.comment = value;
        }

    }

    public class Import extends Element {
        /**
         * The identifier for the profile, ideally the URL it can be retrieved from.
         */
        private java.net.URI uri;

        /**
         * The short label used for display of the profile when uniquely identifying imported extensions
         */
        private String prefix;

        public java.net.URI getUri() { 
          return this.uri;
        }

        public void setUri(java.net.URI value) { 
          this.uri = value;
        }

        public String getPrefix() { 
          return this.prefix;
        }

        public void setPrefix(String value) { 
          this.prefix = value;
        }

    }

    public class Resource extends Element {
        /**
         * The Type of the resource being described
         */
        private String type;

        /**
         * Reference to a resource profile that includes the constraint statement that applies to this resource
         */
        private java.net.URI profile;

        /**
         * The name of this resource constraint statement (to refer to it from other resource constraints)
         */
        private String name;

        /**
         * Human summary: why describe this resource?
         */
        private String purpose;

        /**
         * Captures constraints on each element within the resource
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
         * A unique name referring to a specific set of constraints applied to this element.
         */
        private String name;

        /**
         * Definition of the content of the element to provide a more specific definition than that contained for the element in the base resource.
         */
        private Definition definition;

        /**
         * Whether the Resource that is the value for this element is included in the bundle, if the profile is specifying a bundle
         */
        private java.lang.Boolean bundled;

        /**
         * Indicates whether the set of slices defined is "exhaustive".  I.e. Have all the possible variants for the repeating element been defined?  If true, then no new slices can be created off the base element in derived profiles - though existing slices can be further sliced if they are defined as repeating elements.
         */
        private java.lang.Boolean closed;

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

        public Definition getDefinition() { 
          return this.definition;
        }

        public void setDefinition(Definition value) { 
          this.definition = value;
        }

        public java.lang.Boolean getBundled() { 
          return this.bundled;
        }

        public void setBundled(java.lang.Boolean value) { 
          this.bundled = value;
        }

        public java.lang.Boolean getClosed() { 
          return this.closed;
        }

        public void setClosed(java.lang.Boolean value) { 
          this.closed = value;
        }

    }

    public class Definition extends Element {
        /**
         * A concise definition that  is shown in the concise XML format that summarises profiles
         */
        private String short_;

        /**
         *  The definition must be consistent with the base definition, but convey the meaning of the element in the particular context of use of the resource
         */
        private String formal;

        /**
         * Comments about the use of the element, including notes about how to use the data properly, exceptions to proper use, etc.
         */
        private String comments;

        /**
         * Explains why this element is needed and why it's been constrained as it has
         */
        private String requirements;

        /**
         * Identifies additional names by which this element might also be known
         */
        private List<String> synonym = new ArrayList<String>();

        /**
         * The minimum number of times this element must appear in the instance
         */
        private java.lang.Integer min;

        /**
         * The maximum number of times this element is permitted to appear in the instance
         */
        private String max;

        /**
         * The data type or resource that the value of this element is permitted to be
         */
        private List<Type> type = new ArrayList<Type>();

        /**
         * Identifies the name of a slice defined elsewhere in the profile whose constraints should be applied to the current element 
         */
        private String nameReference;

        /**
         * Specifies a value that must hold for this element in the instance.
         */
        private org.hl7.fhir.instance.model.Type value;

        /**
         * Indicates the shortest length that must be supported by conformant instances without truncation.
         */
        private java.lang.Integer maxLength;

        /**
         * If true then the dataAbsentReason attribute is permitted, otherwise not
         */
        private java.lang.Boolean dataAbsentReason;

        /**
         * A reference to an invariant that may make additional statements about the cardinality in the instance
         */
        private List<String> condition = new ArrayList<String>();

        /**
         * Formal constraints such as co-occurrence and other constraints that can be computationally evaluated within the context of the instance.
         */
        private List<Constraint> constraint = new ArrayList<Constraint>();

        /**
         * If true, conformant resource authors must be capable of providing a value for the element and resource consumers must be capable of extracting and doing something useful with the data element.  If false, the element may be ignored and not supported.
         */
        private java.lang.Boolean mustSupport;

        /**
         * If true, the element cannot be ignored by systems unless they recognize the element and a pre-determination has been made that it is not relevant to their particular system.
         */
        private java.lang.Boolean mustUnderstand;

        /**
         * Identifies the set of codes that applies to this element if a data type supporting codes is used.
         */
        private String binding;

        /**
         * Identifies a concept from an external specification that roughly corresponds to this element.
         */
        private List<Mapping> mapping = new ArrayList<Mapping>();

        public String getShort() { 
          return this.short_;
        }

        public void setShort(String value) { 
          this.short_ = value;
        }

        public String getFormal() { 
          return this.formal;
        }

        public void setFormal(String value) { 
          this.formal = value;
        }

        public String getComments() { 
          return this.comments;
        }

        public void setComments(String value) { 
          this.comments = value;
        }

        public String getRequirements() { 
          return this.requirements;
        }

        public void setRequirements(String value) { 
          this.requirements = value;
        }

        public List<String> getSynonym() { 
          return this.synonym;
        }

        public java.lang.Integer getMin() { 
          return this.min;
        }

        public void setMin(java.lang.Integer value) { 
          this.min = value;
        }

        public String getMax() { 
          return this.max;
        }

        public void setMax(String value) { 
          this.max = value;
        }

        public List<Type> getType() { 
          return this.type;
        }

        public String getNameReference() { 
          return this.nameReference;
        }

        public void setNameReference(String value) { 
          this.nameReference = value;
        }

        public org.hl7.fhir.instance.model.Type getValue() { 
          return this.value;
        }

        public void setValue(org.hl7.fhir.instance.model.Type value) { 
          this.value = value;
        }

        public java.lang.Integer getMaxLength() { 
          return this.maxLength;
        }

        public void setMaxLength(java.lang.Integer value) { 
          this.maxLength = value;
        }

        public java.lang.Boolean getDataAbsentReason() { 
          return this.dataAbsentReason;
        }

        public void setDataAbsentReason(java.lang.Boolean value) { 
          this.dataAbsentReason = value;
        }

        public List<String> getCondition() { 
          return this.condition;
        }

        public List<Constraint> getConstraint() { 
          return this.constraint;
        }

        public java.lang.Boolean getMustSupport() { 
          return this.mustSupport;
        }

        public void setMustSupport(java.lang.Boolean value) { 
          this.mustSupport = value;
        }

        public java.lang.Boolean getMustUnderstand() { 
          return this.mustUnderstand;
        }

        public void setMustUnderstand(java.lang.Boolean value) { 
          this.mustUnderstand = value;
        }

        public String getBinding() { 
          return this.binding;
        }

        public void setBinding(String value) { 
          this.binding = value;
        }

        public List<Mapping> getMapping() { 
          return this.mapping;
        }

    }

    public class Type extends Element {
        /**
         * Data type or Resource
         */
        private String code;

        /**
         * Identifies a profile that must hold for resources referenced as the type of this element.
         */
        private java.net.URI profile;

        public String getCode() { 
          return this.code;
        }

        public void setCode(String value) { 
          this.code = value;
        }

        public java.net.URI getProfile() { 
          return this.profile;
        }

        public void setProfile(java.net.URI value) { 
          this.profile = value;
        }

    }

    public class Constraint extends Element {
        /**
         * Allows identification of which elements have their cardinalities impacted by the constraint.  Will not be referenced for constraints that do not affect cardinality.
         */
        private String id;

        /**
         * Used to label the constraint in OCL or in short displays incapable of displaying the full human description
         */
        private String name;

        /**
         * Identifies the impact constraint violation has on the conformance of the instance.
         */
        private String severity;

        /**
         * This is the text that describes the constraint in messages identifying that the constraint has been violated 
         */
        private String human;

        /**
         * XPath expression of constraint
         */
        private String xpath;

        /**
         * OCL expression of constraint
         */
        private String ocl;

        public String getId() { 
          return this.id;
        }

        public void setId(String value) { 
          this.id = value;
        }

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public String getSeverity() { 
          return this.severity;
        }

        public void setSeverity(String value) { 
          this.severity = value;
        }

        public String getHuman() { 
          return this.human;
        }

        public void setHuman(String value) { 
          this.human = value;
        }

        public String getXpath() { 
          return this.xpath;
        }

        public void setXpath(String value) { 
          this.xpath = value;
        }

        public String getOcl() { 
          return this.ocl;
        }

        public void setOcl(String value) { 
          this.ocl = value;
        }

    }

    public class Mapping extends Element {
        /**
         * The name of the specification is mapping is being expressed to.
         */
        private String target;

        /**
         * Expresses what part of the target specification corresponds to this element
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

    public class ExtensionDefn extends Element {
        /**
         * A unique code (within the profile) used to identify the extension.
         */
        private String code;

        /**
         * Identifies the type of context to which the extension applies
         */
        private ExtensionContext contextType;

        /**
         * Identifies the types of resource or data type elements to which the extension can be applied.
         */
        private List<String> context = new ArrayList<String>();

        /**
         * Definition of the extension and its content
         */
        private Definition definition;

        public String getCode() { 
          return this.code;
        }

        public void setCode(String value) { 
          this.code = value;
        }

        public ExtensionContext getContextType() { 
          return this.contextType;
        }

        public void setContextType(ExtensionContext value) { 
          this.contextType = value;
        }

        public List<String> getContext() { 
          return this.context;
        }

        public Definition getDefinition() { 
          return this.definition;
        }

        public void setDefinition(Definition value) { 
          this.definition = value;
        }

    }

    public class Binding extends Element {
        /**
         * The name to be associated with this set of codes.
         */
        private String name;

        /**
         * Describes the intended use of this particular set of codes
         */
        private String definition;

        /**
         * Identifies how the set of codes for this binding is being defined.
         */
        private BindingType type;

        /**
         * If true, then conformant systems may use additional codes or (where the data type permits) text alone to convey concepts not covered by the set of codes identified in the binding.  If false, then conformant systems are constrained to the provided codes alone.
         */
        private java.lang.Boolean isExtensible;

        /**
         * Indicates the degree of conformance expectations associated with this binding
         */
        private BindingConformance conformance;

        /**
         * Points to the value set or external definition that identifies the set of codes to be used.
         */
        private java.net.URI reference;

        /**
         * Identifies the codes forming the code list for the binding
         */
        private List<Concept> concept = new ArrayList<Concept>();

        public String getName() { 
          return this.name;
        }

        public void setName(String value) { 
          this.name = value;
        }

        public String getDefinition() { 
          return this.definition;
        }

        public void setDefinition(String value) { 
          this.definition = value;
        }

        public BindingType getType() { 
          return this.type;
        }

        public void setType(BindingType value) { 
          this.type = value;
        }

        public java.lang.Boolean getIsExtensible() { 
          return this.isExtensible;
        }

        public void setIsExtensible(java.lang.Boolean value) { 
          this.isExtensible = value;
        }

        public BindingConformance getConformance() { 
          return this.conformance;
        }

        public void setConformance(BindingConformance value) { 
          this.conformance = value;
        }

        public java.net.URI getReference() { 
          return this.reference;
        }

        public void setReference(java.net.URI value) { 
          this.reference = value;
        }

        public List<Concept> getConcept() { 
          return this.concept;
        }

    }

    public class Concept extends Element {
        /**
         * Identifies the code referenced or being defined as part of the binding
         */
        private String code;

        /**
         * Identifies the system in which the referenced code is defined.
         */
        private java.net.URI system;

        /**
         * Identifies the text to be displayed to the user for this code.  If none provided, then the code itself is displayed.
         */
        private String display;

        /**
         * A free-text description of the meaning of this code
         */
        private String definition;

        public String getCode() { 
          return this.code;
        }

        public void setCode(String value) { 
          this.code = value;
        }

        public java.net.URI getSystem() { 
          return this.system;
        }

        public void setSystem(java.net.URI value) { 
          this.system = value;
        }

        public String getDisplay() { 
          return this.display;
        }

        public void setDisplay(String value) { 
          this.display = value;
        }

        public String getDefinition() { 
          return this.definition;
        }

        public void setDefinition(String value) { 
          this.definition = value;
        }

    }

    /**
     * A free text natural language name identifying the Profile
     */
    private String name;

    /**
     * The official version of this profile - for external version specific references
     */
    private String version;

    /**
     * Details of the author who accepts responsibility for publishing the profile
     */
    private Author author;

    /**
     * A free text natural language description of the profile and its use
     */
    private String description;

    /**
     * A set of terms from external terminologies that may be used to assist with indexing and searching of templates.
     */
    private List<Coding> code = new ArrayList<Coding>();

    /**
     * Indicates where the profile exists in its overall life-cycle
     */
    private Status status;

    /**
     * Other profiles that define extensions and bindings that are used in this profile
     */
    private List<Import> import_ = new ArrayList<Import>();

    /**
     * If this profile describes a bundle, the first resource in the bundle (usually a MessageHeader or a DocumentHeader)
     */
    private String bundle;

    /**
     * A constraint statement about what contents a profile may have
     */
    private List<Resource> resource = new ArrayList<Resource>();

    /**
     * An extension defined as part of the profile
     */
    private List<ExtensionDefn> extensionDefn = new ArrayList<ExtensionDefn>();

    /**
     * Defines a linkage between a vocabulary binding name used in the profile (or expected to be used in profile importing this one) and a value set or code list.
     */
    private List<Binding> binding = new ArrayList<Binding>();

    public String getName() { 
      return this.name;
    }

    public void setName(String value) { 
      this.name = value;
    }

    public String getVersion() { 
      return this.version;
    }

    public void setVersion(String value) { 
      this.version = value;
    }

    public Author getAuthor() { 
      return this.author;
    }

    public void setAuthor(Author value) { 
      this.author = value;
    }

    public String getDescription() { 
      return this.description;
    }

    public void setDescription(String value) { 
      this.description = value;
    }

    public List<Coding> getCode() { 
      return this.code;
    }

    public Status getStatus() { 
      return this.status;
    }

    public void setStatus(Status value) { 
      this.status = value;
    }

    public List<Import> getImport() { 
      return this.import_;
    }

    public String getBundle() { 
      return this.bundle;
    }

    public void setBundle(String value) { 
      this.bundle = value;
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

