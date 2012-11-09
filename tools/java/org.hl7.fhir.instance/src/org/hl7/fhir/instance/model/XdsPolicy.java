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

// Generated on Sun, Sep 23, 2012 21:28+1000 for FHIR v0.06

import java.util.*;

/**
 * An entry in an XDS registry
 */
public class XdsPolicy extends Resource {

    public class CodeType extends Element {
        /**
         * the id of the code list
         */
        private Uri id;

        /**
         * the name of this code list
         */
        private String_ name;

        /**
         * comments about use of code
         */
        private String_ comments;

        /**
         * codes in the code list
         */
        private List<Coding> code = new ArrayList<Coding>();

        /**
         * a value set that defines the code
         */
        private ResourceReference valueset;

        public Uri getId() { 
          return this.id;
        }

        public void setId(Uri value) { 
          this.id = value;
        }

        public String_ getName() { 
          return this.name;
        }

        public void setName(String_ value) { 
          this.name = value;
        }

        public String_ getComments() { 
          return this.comments;
        }

        public void setComments(String_ value) { 
          this.comments = value;
        }

        public List<Coding> getCode() { 
          return this.code;
        }

        public ResourceReference getValueset() { 
          return this.valueset;
        }

        public void setValueset(ResourceReference value) { 
          this.valueset = value;
        }

    }

    public class MimeType extends Element {
        /**
         * a mime type (type/subtype)
         */
        private String_ value;

        /**
         * associated file extension (suggested)
         */
        private String_ ext;

        public String_ getValue() { 
          return this.value;
        }

        public void setValue(String_ value) { 
          this.value = value;
        }

        public String_ getExt() { 
          return this.ext;
        }

        public void setExt(String_ value) { 
          this.ext = value;
        }

    }

    public class Authority extends Element {
        /**
         * the authority as represented in v2 (HD)
         */
        private String_ v2;

        /**
         * the OID for the authority (FHIR/CDA)
         */
        private Uri value;

        public String_ getV2() { 
          return this.v2;
        }

        public void setV2(String_ value) { 
          this.v2 = value;
        }

        public Uri getValue() { 
          return this.value;
        }

        public void setValue(Uri value) { 
          this.value = value;
        }

    }

    /**
     * A set of codes that can be used in an entry
     */
    private List<CodeType> codeType = new ArrayList<CodeType>();

    /**
     * mime types supported by the registry
     */
    private List<MimeType> mimeType = new ArrayList<MimeType>();

    /**
     * A defined authority
     */
    private List<Authority> authority = new ArrayList<Authority>();

    public List<CodeType> getCodeType() { 
      return this.codeType;
    }

    public List<MimeType> getMimeType() { 
      return this.mimeType;
    }

    public List<Authority> getAuthority() { 
      return this.authority;
    }


}

