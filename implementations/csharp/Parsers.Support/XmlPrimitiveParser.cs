using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Xml;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Parsers
{
    public static partial class PrimitiveParser
    {
        public static Code<T> ParseCode<T>(IFhirReader reader, ErrorList errors)
            where T : struct, IConvertible
        {
            reader.EnterElement();
            var contents = reader.ReadContents();

            if (contents != null)
            {
                try
                {
                    var result = Code<T>.Parse(contents);
                    
                    // Read id/dar from element's attributes
                    result.ReferralId = reader.ReadRefId();
                    result.Dar = (DataAbsentReason)Code<DataAbsentReason>.Parse(reader.ReadDar());

                    return result;
                }
                catch (FhirValueFormatException ex)
                {
                    errors.Add(ex.Message, reader);
                }
            }

            return null;
        }
    }
}
