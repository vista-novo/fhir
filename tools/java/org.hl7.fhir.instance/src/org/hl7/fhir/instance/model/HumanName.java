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
 * A human's name with the ability to identify parts and usage
 */
public class HumanName extends Type {

    public enum NameUse {
        usual, // Known as/conventional/the one you normally use
        official, // The formal name as registered in an official (government) registry, but which name might not be commonly used. May be called "legal name".
        temp, // A temporary name. A name valid time can provide more detailed information. This may also be used for temporary names assigned at birth or in emergency situations.
        nickname, // A name that is used to address the person in an informal manner, but is not part of their formal or usual name
        anonymous, // Anonymous assigned name, alias, or pseudonym (used to protect a person's identity for privacy reasons)
        old, // This name is no longer in use (or was never correct, but retained for records)
        maiden; // A name used prior to marriage. Marriage naming customs vary greatly around the world. This name use is for use by applications that collect and store "maiden" names. Though the concept of maiden name is often gender specific, the use of this term is not gender specific. The use of this term does not imply any particular history for a person's name, nor should the maiden name be determined algorithmically.
        public static NameUse fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("usual".equals(codeString))
          return usual;
        if ("official".equals(codeString))
          return official;
        if ("temp".equals(codeString))
          return temp;
        if ("nickname".equals(codeString))
          return nickname;
        if ("anonymous".equals(codeString))
          return anonymous;
        if ("old".equals(codeString))
          return old;
        if ("maiden".equals(codeString))
          return maiden;
        throw new Exception("Unknown NameUse code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case usual: return "usual";
            case official: return "official";
            case temp: return "temp";
            case nickname: return "nickname";
            case anonymous: return "anonymous";
            case old: return "old";
            case maiden: return "maiden";
            default: return "?";
          }
        }
    }

    /**
     * Identifies the purpose for this name
     */
    private NameUse use;

    /**
     * a full text representation of the name
     */
    private String_ text;

    /**
     * Family name, this is the name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first name of his father.
     */
    private List<String_> family = new ArrayList<String_>();

    /**
     * Given name. NOTE: Not to be called "first name" since given names do not always come first.
     */
    private List<String_> given = new ArrayList<String_>();

    /**
     * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that comes at the start of the name
     */
    private List<String_> prefix = new ArrayList<String_>();

    /**
     * Part of the name that is acquired as a title due to academic, legal, employment or nobility status, etc. and that comes at the end of the name
     */
    private List<String_> suffix = new ArrayList<String_>();

    /**
     * Indicates the period of time when this name was valid for the named person.
     */
    private Period period;

    public NameUse getUse() { 
      return this.use;
    }

    public void setUse(NameUse value) { 
      this.use = value;
    }

    public String_ getText() { 
      return this.text;
    }

    public void setText(String_ value) { 
      this.text = value;
    }

    public List<String_> getFamily() { 
      return this.family;
    }

    public List<String_> getGiven() { 
      return this.given;
    }

    public List<String_> getPrefix() { 
      return this.prefix;
    }

    public List<String_> getSuffix() { 
      return this.suffix;
    }

    public Period getPeriod() { 
      return this.period;
    }

    public void setPeriod(Period value) { 
      this.period = value;
    }


}

