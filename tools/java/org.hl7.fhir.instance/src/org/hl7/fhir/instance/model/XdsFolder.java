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

// Generated on Sun, Nov 25, 2012 14:16+1100 for FHIR v0.06

import java.util.*;

/**
 * An organised collection of documents that belong to a patient. The documents are collected by their clinical function
 */
public class XdsFolder extends Resource {

    /**
     * contain the set of codes specifying the type of clinical activity that resulted in placing XDS Documents in this XDSFolder
     */
    private List<Coding> code = new ArrayList<Coding>();

    /**
     * Represents the title of the Folder
     */
    private String_ title;

    /**
     * the subject of care medical record Identifier as defined by the Document Source.
     */
    private Identifier patientId;

    /**
     * A globally unique identifier for a community
     */
    private String_ homeCommunity;

    /**
     * Comments associated with the Folder
     */
    private String_ comments;

    public List<Coding> getCode() { 
      return this.code;
    }

    public String_ getTitle() { 
      return this.title;
    }

    public void setTitle(String_ value) { 
      this.title = value;
    }

    public Identifier getPatientId() { 
      return this.patientId;
    }

    public void setPatientId(Identifier value) { 
      this.patientId = value;
    }

    public String_ getHomeCommunity() { 
      return this.homeCommunity;
    }

    public void setHomeCommunity(String_ value) { 
      this.homeCommunity = value;
    }

    public String_ getComments() { 
      return this.comments;
    }

    public void setComments(String_ value) { 
      this.comments = value;
    }


}

