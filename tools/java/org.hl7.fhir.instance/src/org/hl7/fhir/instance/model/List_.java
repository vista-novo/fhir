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

// Generated on Sun, Jan 20, 2013 20:00+1100 for FHIR v0.07

import java.util.*;

/**
 * A set of information summarized from a list of other resources
 */
public class List_ extends Resource {

    public enum ListMode {
        working, // This list is the master list, maintained in an ongoing fashion with regular updates as the real world list it is tracking changes
        snapshot, // This list was prepared as a snapshot. It should not be assumed to be current
        changes; // The list is prepared as a statement of changes that have been made or recommended
        public static ListMode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("working".equals(codeString))
          return working;
        if ("snapshot".equals(codeString))
          return snapshot;
        if ("changes".equals(codeString))
          return changes;
        throw new Exception("Unknown ListMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case working: return "working";
            case snapshot: return "snapshot";
            case changes: return "changes";
            default: return "?";
          }
        }
    }

    public class Entry extends Element {
        /**
         * The flag allows the system constructing the list to make one or more statements about the role and significance of the item in the list
         */
        private List<CodeableConcept> flag = new ArrayList<CodeableConcept>();

        /**
         * True if this item is marked as deleted in the list.
         */
        private Boolean deleted;

        /**
         * A reference to the actual resource from which data was derived
         */
        private ResourceReference item;

        public List<CodeableConcept> getFlag() { 
          return this.flag;
        }

        public Boolean getDeleted() { 
          return this.deleted;
        }

        public void setDeleted(Boolean value) { 
          this.deleted = value;
        }

        public ResourceReference getItem() { 
          return this.item;
        }

        public void setItem(ResourceReference value) { 
          this.item = value;
        }

    }

    /**
     * This code defines the purpose of the list - why it was created
     */
    private CodeableConcept code;

    /**
     * The entity responsible for deciding what the contents of the list were
     */
    private ResourceReference source;

    /**
     * The date that the list was prepared
     */
    private DateTime date;

    /**
     * Whether items in the list have a meaningful order
     */
    private Boolean ordered;

    /**
     * How this list was prepared - whether it is a working list that is suitable for being maintained in an ongoing basis, or if it represents a snapshort of a list of items from another source, or whether it is a prepared list where items may be marked as added, modified or deleted
     */
    private ListMode mode;

    /**
     * Entries in this list
     */
    private List<Entry> entry = new ArrayList<Entry>();

    /**
     * If the list is empty, why the list is empty
     */
    private CodeableConcept emptyReason;

    public CodeableConcept getCode() { 
      return this.code;
    }

    public void setCode(CodeableConcept value) { 
      this.code = value;
    }

    public ResourceReference getSource() { 
      return this.source;
    }

    public void setSource(ResourceReference value) { 
      this.source = value;
    }

    public DateTime getDate() { 
      return this.date;
    }

    public void setDate(DateTime value) { 
      this.date = value;
    }

    public Boolean getOrdered() { 
      return this.ordered;
    }

    public void setOrdered(Boolean value) { 
      this.ordered = value;
    }

    public ListMode getMode() { 
      return this.mode;
    }

    public void setMode(ListMode value) { 
      this.mode = value;
    }

    public List<Entry> getEntry() { 
      return this.entry;
    }

    public CodeableConcept getEmptyReason() { 
      return this.emptyReason;
    }

    public void setEmptyReason(CodeableConcept value) { 
      this.emptyReason = value;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.List;
   }


}

