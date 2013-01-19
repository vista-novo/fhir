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

// Generated on Sat, Jan 19, 2013 17:09+1100 for FHIR v0.07

import java.util.*;

/**
 * [Template] Master Definition
 */
public class Test extends Resource {

    /**
     * Strings with invalid content
     */
    private List<String_> stringErr = new ArrayList<String_>();

    /**
     * Strings with correct content
     */
    private List<String_> stringCorr = new ArrayList<String_>();

    /**
     * Booleans with invalid content
     */
    private List<Boolean> booleanErr = new ArrayList<Boolean>();

    /**
     * Booleans with correct content
     */
    private List<Boolean> booleanCorr = new ArrayList<Boolean>();

    /**
     * Integers with invalid content
     */
    private List<Integer> integerErr = new ArrayList<Integer>();

    /**
     * Integers with correct content
     */
    private List<Integer> integerCorr = new ArrayList<Integer>();

    /**
     * Decimals with invalid content
     */
    private List<Decimal> decimalErr = new ArrayList<Decimal>();

    /**
     * Decimals with correct content
     */
    private List<Decimal> decimalCorr = new ArrayList<Decimal>();

    /**
     * Binaries with invalid content
     */
    private List<Base64Binary> b64Err = new ArrayList<Base64Binary>();

    /**
     * Binaries with correct content
     */
    private List<Base64Binary> b64Corr = new ArrayList<Base64Binary>();

    /**
     * Instants with invalid content
     */
    private List<Instant> instantErr = new ArrayList<Instant>();

    /**
     * Instants with correct content
     */
    private List<Instant> instantCorr = new ArrayList<Instant>();

    /**
     * Uri's with invalid content
     */
    private List<Uri> uriErr = new ArrayList<Uri>();

    /**
     * Uri's with correct content
     */
    private List<Uri> uriCorr = new ArrayList<Uri>();

    public List<String_> getStringErr() { 
      return this.stringErr;
    }

    public List<String_> getStringCorr() { 
      return this.stringCorr;
    }

    public List<Boolean> getBooleanErr() { 
      return this.booleanErr;
    }

    public List<Boolean> getBooleanCorr() { 
      return this.booleanCorr;
    }

    public List<Integer> getIntegerErr() { 
      return this.integerErr;
    }

    public List<Integer> getIntegerCorr() { 
      return this.integerCorr;
    }

    public List<Decimal> getDecimalErr() { 
      return this.decimalErr;
    }

    public List<Decimal> getDecimalCorr() { 
      return this.decimalCorr;
    }

    public List<Base64Binary> getB64Err() { 
      return this.b64Err;
    }

    public List<Base64Binary> getB64Corr() { 
      return this.b64Corr;
    }

    public List<Instant> getInstantErr() { 
      return this.instantErr;
    }

    public List<Instant> getInstantCorr() { 
      return this.instantCorr;
    }

    public List<Uri> getUriErr() { 
      return this.uriErr;
    }

    public List<Uri> getUriCorr() { 
      return this.uriCorr;
    }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Test;
   }


}

