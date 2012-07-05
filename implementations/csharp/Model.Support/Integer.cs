using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Model
{
    public partial class Integer
    {
        public static bool TryParse( string value, out Integer result)
        {
            Int32 intValue;  
            bool succ = Int32.TryParse(value, out intValue);

            if (succ)
            {
                result = new Integer(intValue);
                return true;
            }
            else
            {
                result = null;
                return false;
            }
        }

        public static Integer Parse(string value)
        {
            Integer result = null;

            if (TryParse(value, out result))
                return result;
            else 
                throw new FhirValueFormatException("Not an integer value");
        }
    }
  
}
