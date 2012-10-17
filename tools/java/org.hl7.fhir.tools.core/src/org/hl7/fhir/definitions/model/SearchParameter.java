package org.hl7.fhir.definitions.model;
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

public class SearchParameter {
  public enum SearchType {
    integer,  // search parameter must be a simple name 
    string,   // search parameter is a simple string, like a name part
    text,     // search parameter is into a long string - text filter
    date,     // search parameter is onto a date
    token,    // search parameter is on a fixed value string
    qtoken;   // search parameter is onto a pair of fixed value strings, space and value. Space is optional
  }
  public enum RepeatMode {
    single,     // the search parameter may only be used once
    union,       // when the search parameter is used more than once, match resources with any of the values
    intersection // when the search parameter is used more than once, match resources with all of the values
  }
  
  private String code;
  private String description;
  private SearchType type;
  private RepeatMode repeatMode;
  
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public SearchType getType() {
    return type;
  }
  public void setType(SearchType type) {
    this.type = type;
  }
  public SearchParameter(String code, String description, SearchType type, RepeatMode mode) {
    super();
    this.code = code;
    this.description = description;
    this.type = type;
    this.repeatMode = mode;
  }
  public RepeatMode getRepeatMode() {
    return repeatMode;
  }
  public void setRepeatMode(RepeatMode repeatMode) {
    this.repeatMode = repeatMode;
  }  
  
  
}
