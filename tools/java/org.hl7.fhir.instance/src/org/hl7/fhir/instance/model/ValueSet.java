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

// Generated on Sun, Jun 24, 2012 20:48+1000 for FHIR v0.04

import java.util.*;

/**
 * Value Set - a set of defined codes that may be bound to a context
 */
public class ValueSet extends Resource {

    public enum ValuesetStatus {
        draft, // This valueset is still under development
        testing, // this valueset was authored for testing purposes (or education/evaluation/evangelisation)
        production, // This valueset is ready for use in production systems
        withdrawn, // This valueset has been withdrawn
        superceded; // This valueset was superceded by a more recent version
        public static ValuesetStatus fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return draft;
        if ("testing".equals(codeString))
          return testing;
        if ("production".equals(codeString))
          return production;
        if ("withdrawn".equals(codeString))
          return withdrawn;
        if ("superceded".equals(codeString))
          return superceded;
        throw new Exception("Unknown ValuesetStatus code '"+codeString+"'");
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

    public enum CodeSelectionMode {
        code, // Only this code is selected
        children, // Only the immediate children (codes with a is_a relationship) are selected, but not this code itself
        descendents, // All descendents of this code are selected, but not this code itself
        all; // this code and any descendents are selected
        public static CodeSelectionMode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("code".equals(codeString))
          return code;
        if ("children".equals(codeString))
          return children;
        if ("descendents".equals(codeString))
          return descendents;
        if ("all".equals(codeString))
          return all;
        throw new Exception("Unknown CodeSelectionMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case code: return "code";
            case children: return "children";
            case descendents: return "descendents";
            case all: return "all";
            default: return "?";
          }
        }
    }

    public enum FilterOperator {
        equal, // the property value has the concept specified by the value
        is_a, // the property value has a concept that has an is_a relationship with the value
        is_not_a, // the property value has a concept that does not have an is_a relationship with the value
        regex; // the property value represenation matches the regex specified in the value
        public static FilterOperator fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return equal;
        if ("is_a".equals(codeString))
          return is_a;
        if ("is_not_a".equals(codeString))
          return is_not_a;
        if ("regex".equals(codeString))
          return regex;
        throw new Exception("Unknown FilterOperator code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case equal: return "=";
            case is_a: return "is_a";
            case is_not_a: return "is_not_a";
            case regex: return "regex";
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

    public class Include extends Element {
        /**
         * The code system from which the selected codes come from
         */
        private java.net.URI system;

        /**
         * The version of the code system that the codes are selected from
         */
        private String version;

        /**
         * The mode of selection - whether the code itself, and/or it's descendents are being selected 
         */
        private CodeSelectionMode mode;

        /**
         * Specifies a code or concept to be included or excluded as specified by the mode from the value set
         */
        private List<String> code = new ArrayList<String>();

        /**
         * Select concepts by specify a matching criteria based on the properties defined by the system. If multiple filters are specified, they must all be true
         */
        private List<Filter> filter = new ArrayList<Filter>();

        public java.net.URI getSystem() { 
          return this.system;
        }

        public void setSystem(java.net.URI value) { 
          this.system = value;
        }

        public String getVersion() { 
          return this.version;
        }

        public void setVersion(String value) { 
          this.version = value;
        }

        public CodeSelectionMode getMode() { 
          return this.mode;
        }

        public void setMode(CodeSelectionMode value) { 
          this.mode = value;
        }

        public List<String> getCode() { 
          return this.code;
        }

        public List<Filter> getFilter() { 
          return this.filter;
        }

    }

    public class Filter extends Element {
        /**
         * A code that identifies a property defined in the code system
         */
        private String property;

        /**
         * the kind of operation to perform as part of the filter criteria
         */
        private FilterOperator op;

        /**
         * the match value may be either a code defined by the system, or a string value which is used a regex match on the literal string of the property value
         */
        private String value;

        public String getProperty() { 
          return this.property;
        }

        public void setProperty(String value) { 
          this.property = value;
        }

        public FilterOperator getOp() { 
          return this.op;
        }

        public void setOp(FilterOperator value) { 
          this.op = value;
        }

        public String getValue() { 
          return this.value;
        }

        public void setValue(String value) { 
          this.value = value;
        }

    }

    /**
     * A free text natural language name identifying the value set.
     */
    private String name;

    /**
     * Details of the author who accepts responsibility for publishing the value set
     */
    private Author author;

    /**
     * A free text natural language description of the value set - contents, reason for definition, conditions of use etc
     */
    private String description;

    /**
     * The status of the value set
     */
    private ValuesetStatus status;

    /**
     * The date that the value set was last published
     */
    private String date;

    /**
     * The identifier that is used to identify this value set when it is referenced in a specification, model, design or an instance 
     */
    private String identifier;

    /**
     * The identifier that is used to identify this version of the value set when it is referenced in a specification, model, design, or instance
     */
    private String version;

    /**
     * An assertion that this value set is a restriction on another value set - that it only includes codes that are part of the other value set. The value set itself must ensure that this is true - the contents of the value set are not automatically bounded by the contents of any value set identified here. This allows profile tooling to reason about the relationships between value sets without having to determine the value set contents
     */
    private List<java.net.URI> restricts = new ArrayList<java.net.URI>();

    /**
     * Includes the contents of the referenced value set as part of the contents of this value set
     */
    private List<java.net.URI> import_ = new ArrayList<java.net.URI>();

    /**
     * Include one or more codes from a code system
     */
    private List<Include> include = new ArrayList<Include>();

    /**
     * Exclude one or more codes from the value set
     */
    private List<Include> exclude = new ArrayList<Include>();

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

    public String getDescription() { 
      return this.description;
    }

    public void setDescription(String value) { 
      this.description = value;
    }

    public ValuesetStatus getStatus() { 
      return this.status;
    }

    public void setStatus(ValuesetStatus value) { 
      this.status = value;
    }

    public String getDate() { 
      return this.date;
    }

    public void setDate(String value) { 
      this.date = value;
    }

    public String getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(String value) { 
      this.identifier = value;
    }

    public String getVersion() { 
      return this.version;
    }

    public void setVersion(String value) { 
      this.version = value;
    }

    public List<java.net.URI> getRestricts() { 
      return this.restricts;
    }

    public List<java.net.URI> getImport() { 
      return this.import_;
    }

    public List<Include> getInclude() { 
      return this.include;
    }

    public List<Include> getExclude() { 
      return this.exclude;
    }


}

