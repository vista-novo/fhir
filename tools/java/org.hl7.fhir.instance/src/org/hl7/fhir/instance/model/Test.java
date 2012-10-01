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

// Generated on Sun, Sep 16, 2012 06:55+1000 for FHIR v0.06

import java.util.*;

/**
 * [Template] Master Definition
 */
public class Test extends Resource {

    /**
     * Strings with invalid content
     */
    private List<String> stringErr = new ArrayList<String>();

    /**
     * Strings with correct content
     */
    private List<String> stringCorr = new ArrayList<String>();

    /**
     * Booleans with invalid content
     */
    private List<java.lang.Boolean> booleanErr = new ArrayList<java.lang.Boolean>();

    /**
     * Booleans with correct content
     */
    private List<java.lang.Boolean> booleanCorr = new ArrayList<java.lang.Boolean>();

    /**
     * Integers with invalid content
     */
    private List<java.lang.Integer> integerErr = new ArrayList<java.lang.Integer>();

    /**
     * Integers with correct content
     */
    private List<java.lang.Integer> integerCorr = new ArrayList<java.lang.Integer>();

    /**
     * Decimals with invalid content
     */
    private List<java.math.BigDecimal> decimalErr = new ArrayList<java.math.BigDecimal>();

    /**
     * Decimals with correct content
     */
    private List<java.math.BigDecimal> decimalCorr = new ArrayList<java.math.BigDecimal>();

    /**
     * Binaries with invalid content
     */
    private List<byte[]> b64Err = new ArrayList<byte[]>();

    /**
     * Binaries with correct content
     */
    private List<byte[]> b64Corr = new ArrayList<byte[]>();

    /**
     * Instants with invalid content
     */
    private List<java.util.Calendar> instantErr = new ArrayList<java.util.Calendar>();

    /**
     * Instants with correct content
     */
    private List<java.util.Calendar> instantCorr = new ArrayList<java.util.Calendar>();

    /**
     * Uri's with invalid content
     */
    private List<java.net.URI> uriErr = new ArrayList<java.net.URI>();

    /**
     * Uri's with correct content
     */
    private List<java.net.URI> uriCorr = new ArrayList<java.net.URI>();

    public List<String> getStringErr() { 
      return this.stringErr;
    }

    public List<String> getStringCorr() { 
      return this.stringCorr;
    }

    public List<java.lang.Boolean> getBooleanErr() { 
      return this.booleanErr;
    }

    public List<java.lang.Boolean> getBooleanCorr() { 
      return this.booleanCorr;
    }

    public List<java.lang.Integer> getIntegerErr() { 
      return this.integerErr;
    }

    public List<java.lang.Integer> getIntegerCorr() { 
      return this.integerCorr;
    }

    public List<java.math.BigDecimal> getDecimalErr() { 
      return this.decimalErr;
    }

    public List<java.math.BigDecimal> getDecimalCorr() { 
      return this.decimalCorr;
    }

    public List<byte[]> getB64Err() { 
      return this.b64Err;
    }

    public List<byte[]> getB64Corr() { 
      return this.b64Corr;
    }

    public List<java.util.Calendar> getInstantErr() { 
      return this.instantErr;
    }

    public List<java.util.Calendar> getInstantCorr() { 
      return this.instantCorr;
    }

    public List<java.net.URI> getUriErr() { 
      return this.uriErr;
    }

    public List<java.net.URI> getUriCorr() { 
      return this.uriCorr;
    }


}

