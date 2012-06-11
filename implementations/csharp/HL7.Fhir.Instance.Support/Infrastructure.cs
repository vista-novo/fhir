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

using System;
using System.Collections.Generic;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Support
{
    public class Element
    {
    }

    public enum DataAbsentReason
    {
        unknown, //	The value is not known
        asked, //		The source human does not know the value
        temp, //		There is reason to expect (from the workflow) that the value may become known
        notasked, //		The workflow didn't lead to this value being known
        masked, //	 	The information is not available due to security, privacy or related reasons
        unsupported, //	 	The source system wasn't capable of supporting this element
        astext, //	 	The content of the data is represented as text (see below)
        error //	 	Some system or workflow process error means that the information is not available
    }

    public class FhirType : Element
    {
        public DataAbsentReason dataAbsentReason { get; set; }
    }

    public class Ordered : FhirType
    {
    }

    public class Base64Binary : FhirType
    {
        public byte[] value { get; set; }
    }

    public class Code : FhirType
    {
        public string value { get; set; }
    }

    public class DateTime_ : Ordered {
        public System.DateTime value { get; set; }
    }
	
    public class Decimal : Ordered 
    {
        public decimal value { get; set; }
    }

    public class HumanDate : Ordered
    {
        public string value { get; set; }
    }

    public class Id : FhirType
    {
        public string value { get; set; }
    }

    public class String_ : FhirType 
    {
	  public String value { get; set; }
    }

    public class Uri_ : FhirType
    {
        public System.Uri value { get; set; }
    }

    public class Integer_ : FhirType
    {
        public int value { get; set; }
    }

    public class ResourceReference<T> where T : Resource
    {

        // type of T: Resource Type

        /**
         * Id of the reference
         */
        public String id { get; set; }

        /**
         * Specific version Id of resource referenced
         */
        public String version { get; set; }

        /**
         * Text alternative for the resource
         */
        public String text { get; set; }

        /**
         * resolved resource
         */
        public T resource { get; set; }
    }
   
  
    public class Resource
    {
        public Resource()
        {
            extensions = new List<Extension>();
            text = new Narrative();
        }

        /**
	     * Master resource Id, in all resources
	     */
        public Id id { get; set; }

        /**
         * Extensions
         */
        public List<Extension> extensions { get; set; }

        /**
         * Text summary of resource, for human interpretation
         */
        public Narrative text { get; set; }

    }
}
