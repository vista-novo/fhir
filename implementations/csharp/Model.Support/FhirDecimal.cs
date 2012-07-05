using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Model
{
    public partial class FhirDecimal
    {
        public static bool TryParse( string value, out FhirDecimal result)
        {
            decimal decimalValue;  
            bool succ = Decimal.TryParse(value, out decimalValue);

            if (succ)
            {
                result = new FhirDecimal(decimalValue);
                return true;
            }
            else
            {
                result = null;
                return false;
            }
        }

        public static FhirDecimal Parse(string value)
        {
            FhirDecimal result = null;

            if (TryParse(value, out result))
                return result;
            else 
                throw new FhirValueFormatException("Not a decimal value");
        }
    }
  
}
