using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HL7.Fhir.Instance.Support
{
    public class XmlUtil
    {
        public const string FHIRNS = "{http://hl7.org/fhir}";
        public const string IDATTR = FHIRNS + "id";

        
    }

    [Serializable]
    public class ResourceXmlParseError : Exception
    {
        public ResourceXmlParseError() { }
        public ResourceXmlParseError(string message) : base(message) { }
        public ResourceXmlParseError(string message, Exception inner) : base(message, inner) { }
        protected ResourceXmlParseError(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }
    }
}
