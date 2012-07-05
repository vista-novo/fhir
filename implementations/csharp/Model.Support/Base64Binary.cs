using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Model
{
    public partial class Base64Binary
    {
        public static bool TryParse( string value, out Base64Binary result)
        {
            byte[] b64Value = null;
            bool success = true;

            try
            {
                b64Value = Convert.FromBase64String(value);
            }
            catch
            {
                success = false;
            }

            if(success)
            {
                result = new Base64Binary(b64Value);
                return true;
            }
            else
            {
                result = null;
                return false;
            }
        }

        public static Base64Binary Parse(string value)
        {
            Base64Binary result = null;

            if (TryParse(value, out result))
                return result;
            else 
                throw new FhirValueFormatException("Not an correctly base64 encoded value");
        }
    }
  
}
