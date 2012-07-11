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

// Generated on Wed, Jul 11, 2012 23:44+1000 for FHIR v0.04

/**
 * A reference to a code defined by a terminology system 
 */
public class Coding extends Type {

    /**
     * A symbol in syntax defined by the system. The symbol may be a predefined code, or an expression in a syntax defined by the coding system
     */
    private String code;

    /**
     * The identification of the system that defines the meaning of the symbol in the code. Can be a simple list of enumerations, a list of codes with meanings, or all the way to a complex semantic web such as SNOMED-CT, whether classification, terminology, or ontology
     */
    private java.net.URI system;

    /**
     * Tracks which minor release is in use, or which the code was taken from. The format of the version is that specified by the code system, or if nothing is specified, the date of the release of that version. If the code system changes the meaning of an existing code, then this is not a minor release, and a system must change, not the version
     */
    private String version;

    /**
     * A representation of the meaning of the code in the system, following the rules laid out by the system. 
     */
    private String display;

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

    public String getVersion() { 
      return this.version;
    }

    public void setVersion(String value) { 
      this.version = value;
    }

    public String getDisplay() { 
      return this.display;
    }

    public void setDisplay(String value) { 
      this.display = value;
    }


}

