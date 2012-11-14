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

// Generated on Wed, Nov 14, 2012 12:51+1100 for FHIR v0.06

import java.util.*;

/**
 * Value Set - a set of defined codes from one or more code systems that may be bound to a context
 */
public class ValueSet extends Resource {

    public enum ValuesetStatus {
        draft, // This valueset is still under development
        testing, // This valueset was authored for testing purposes (or education/evaluation/evangelisation)
        production, // This valueset is ready for use in production systems
        withdrawn, // This valueset should no longer be used
        superseded; // This valueset has been replaced and a different valueset should be used in its place
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
        if ("superseded".equals(codeString))
          return superseded;
        throw new Exception("Unknown ValuesetStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case draft: return "draft";
            case testing: return "testing";
            case production: return "production";
            case withdrawn: return "withdrawn";
            case superseded: return "superseded";
            default: return "?";
          }
        }
    }

    public enum CodeSelectionMode {
        code, // Only this code is selected
        children, // Only the immediate children (codes with a is_a relationship) are selected, but not this code itself
        descendants, // All descendants of this code are selected, but not this code itself
        all; // This code and any descendants are selected
        public static CodeSelectionMode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("code".equals(codeString))
          return code;
        if ("children".equals(codeString))
          return children;
        if ("descendants".equals(codeString))
          return descendants;
        if ("all".equals(codeString))
          return all;
        throw new Exception("Unknown CodeSelectionMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case code: return "code";
            case children: return "children";
            case descendants: return "descendants";
            case all: return "all";
            default: return "?";
          }
        }
    }

    public enum FilterOperator {
        equal, // The property value has the concept specified by the value
        is_a, // The property value has a concept that has an is_a relationship with the value
        is_not_a, // The property value has a concept that does not have an is_a relationship with the value
        regex; // The property value representation matches the regex specified in the value
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
        private String_ name;

        /**
         * Some way of reaching or finding the author.
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

    public class Include extends Element {
        /**
         * The code system from which the selected codes come from
         */
        private Uri system;

        /**
         * The version of the code system that the codes are selected from
         */
        private String_ version;

        /**
         * The mode of selection - whether the code itself, and/or its descendants are being selected 
         */
        private CodeSelectionMode mode;

        /**
         * Specifies a code or concept to be included or excluded as specified by the mode from the value set
         */
        private List<Code> code = new ArrayList<Code>();

        /**
         * Select concepts by specify a matching criteria based on the properties defined by the system. If multiple filters are specified, they must all be true
         */
        private List<Filter> filter = new ArrayList<Filter>();

        public Uri getSystem() { 
          return this.system;
        }

        public void setSystem(Uri value) { 
          this.system = value;
        }

        public String_ getVersion() { 
          return this.version;
        }

        public void setVersion(String_ value) { 
          this.version = value;
        }

        public CodeSelectionMode getMode() { 
          return this.mode;
        }

        public void setMode(CodeSelectionMode value) { 
          this.mode = value;
        }

        public List<Code> getCode() { 
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
        private Code property;

        /**
         * The kind of operation to perform as part of the filter criteria
         */
        private FilterOperator op;

        /**
         * The match value may be either a code defined by the system, or a string value which is used a regex match on the literal string of the property value
         */
        private Code value;

        public Code getProperty() { 
          return this.property;
        }

        public void setProperty(Code value) { 
          this.property = value;
        }

        public FilterOperator getOp() { 
          return this.op;
        }

        public void setOp(FilterOperator value) { 
          this.op = value;
        }

        public Code getValue() { 
          return this.value;
        }

        public void setValue(Code value) { 
          this.value = value;
        }

    }

    /**
     * A free text natural language name describing the value set
     */
    private String_ name;

    /**
     * Details of the author who accepts responsibility for publishing the value set
     */
    private Author author;

    /**
     * A free text natural language description of the value set - contents, reason for definition, conditions of use, etc.
     */
    private String_ description;

    /**
     * The status of the value set
     */
    private ValuesetStatus status;

    /**
     * The date that the value set status was last changed
     */
    private DateTime date;

    /**
     * The identifier that is used to identify this value set when it is referenced in a specification, model, design or an instance 
     */
    private Id identifier;

    /**
     * The identifier that is used to identify this version of the value set when it is referenced in a specification, model, design, or instance
     */
    private Id version;

    /**
     * An assertion that this value set is a restriction on another value set - that it only includes codes that are part of the other value set. The value set itself must ensure that this is true - the contents of the value set are not automatically bounded by the contents of any value set identified here. This allows profile tooling to reason about the relationships between value sets without having to determine the value set contents
     */
    private List<Uri> restricts = new ArrayList<Uri>();

    /**
     * Includes the contents of the referenced value set as part of the contents of this value set
     */
    private List<Uri> import_ = new ArrayList<Uri>();

    /**
     * Include one or more codes from a code system
     */
    private List<Include> include = new ArrayList<Include>();

    /**
     * Exclude one or more codes from the value set
     */
    private List<Include> exclude = new ArrayList<Include>();

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

    public String_ getDescription() { 
      return this.description;
    }

    public void setDescription(String_ value) { 
      this.description = value;
    }

    public ValuesetStatus getStatus() { 
      return this.status;
    }

    public void setStatus(ValuesetStatus value) { 
      this.status = value;
    }

    public DateTime getDate() { 
      return this.date;
    }

    public void setDate(DateTime value) { 
      this.date = value;
    }

    public Id getIdentifier() { 
      return this.identifier;
    }

    public void setIdentifier(Id value) { 
      this.identifier = value;
    }

    public Id getVersion() { 
      return this.version;
    }

    public void setVersion(Id value) { 
      this.version = value;
    }

    public List<Uri> getRestricts() { 
      return this.restricts;
    }

    public List<Uri> getImport() { 
      return this.import_;
    }

    public List<Include> getInclude() { 
      return this.include;
    }

    public List<Include> getExclude() { 
      return this.exclude;
    }


}

