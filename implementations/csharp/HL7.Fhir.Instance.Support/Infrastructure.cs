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
