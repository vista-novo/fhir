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
 * A Response to an order
 */
public class OrderResponse extends Resource {

    public enum OrderOutcomeCode {
        pending, // 
        review, // 
        rejected, // 
        error, // 
        accepted, // 
        cancelled, // 
        aborted, // 
        complete; // 
        public static OrderOutcomeCode fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("pending".equals(codeString))
          return pending;
        if ("review".equals(codeString))
          return review;
        if ("rejected".equals(codeString))
          return rejected;
        if ("error".equals(codeString))
          return error;
        if ("accepted".equals(codeString))
          return accepted;
        if ("cancelled".equals(codeString))
          return cancelled;
        if ("aborted".equals(codeString))
          return aborted;
        if ("complete".equals(codeString))
          return complete;
        throw new Exception("Unknown OrderOutcomeCode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case pending: return "pending";
            case review: return "review";
            case rejected: return "rejected";
            case error: return "error";
            case accepted: return "accepted";
            case cancelled: return "cancelled";
            case aborted: return "aborted";
            case complete: return "complete";
            default: return "?";
          }
        }
    }

    /**
     * The order this is a response to
     */
    private ResourceReference request;

    /**
     * When the response was made
     */
    private DateTime date;

    /**
     * Who made the rResponse
     */
    private ResourceReference who;

    /**
     * If required by policy
     */
    private ResourceReference authority;

    /**
     * How much the request will/did cost
     */
    private Money cost;

    /**
     * The status of the response
     */
    private OrderOutcomeCode code;

    /**
     * Additional description of the response
     */
    private String_ description;

    /**
     * Details of the outcome of performing the order
     */
    private List<ResourceReference> fulfillment = new ArrayList<ResourceReference>();

    public ResourceReference getRequest() { 
      return this.request;
    }

    public void setRequest(ResourceReference value) { 
      this.request = value;
    }

    public DateTime getDate() { 
      return this.date;
    }

    public void setDate(DateTime value) { 
      this.date = value;
    }

    public ResourceReference getWho() { 
      return this.who;
    }

    public void setWho(ResourceReference value) { 
      this.who = value;
    }

    public ResourceReference getAuthority() { 
      return this.authority;
    }

    public void setAuthority(ResourceReference value) { 
      this.authority = value;
    }

    public Money getCost() { 
      return this.cost;
    }

    public void setCost(Money value) { 
      this.cost = value;
    }

    public OrderOutcomeCode getCode() { 
      return this.code;
    }

    public void setCode(OrderOutcomeCode value) { 
      this.code = value;
    }

    public String_ getDescription() { 
      return this.description;
    }

    public void setDescription(String_ value) { 
      this.description = value;
    }

    public List<ResourceReference> getFulfillment() { 
      return this.fulfillment;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.OrderResponse;
   }


}

