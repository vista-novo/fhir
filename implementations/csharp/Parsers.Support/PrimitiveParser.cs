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
        public static XHtml ParseXHtml(IFhirReader reader, ErrorList errors)
        {
            var contents = reader.ReadXhtmlContents();

            try
            {
                var result = XHtml.Parse(contents);
                return result;
            }
            catch (FhirValueFormatException ex)
            {
                errors.Add(ex.Message, reader);
            }

            return null;
        }
        

        public static Code<T> ParseCode<T>(IFhirReader reader, ErrorList errors)
            where T : struct, IConvertible
        {
            string refId;
            string dar;
            var contents = reader.ReadPrimitiveElementContents(out refId, out dar);

            try
            {
                var result = Code<T>.Parse(contents);

                // Read id/dar from element's attributes
                result.ReferralId = refId;
                result.Dar = (DataAbsentReason?)Code<DataAbsentReason>.Parse(dar);

                return result;
            }
            catch (FhirValueFormatException ex)
            {
                errors.Add(ex.Message, reader);
            }

            return null;
        }
    }
}
