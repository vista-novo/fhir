using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Model
{
    public partial class FhirBoolean
    {
        public static bool TryParse( string value, out FhirBoolean result)
        {
            if (value == "1" || value == "true")
            {
                result = new FhirBoolean(true);
                return true;
            }

            if (value == "0" || value == "false")
            {
                result = new FhirBoolean(false);
                return true;
            }

            result = null;
            return false; 
        }

        public static FhirBoolean Parse(string value)
        {
            FhirBoolean result = null;

            if (TryParse(value, out result))
                return result;
            else
                throw new FhirValueFormatException("Booleans can be either 0, 1, true of false");
        }
    }
  
}
