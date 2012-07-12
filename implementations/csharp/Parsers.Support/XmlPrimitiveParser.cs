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
    public static partial class XmlPrimitiveParser
    {
        public static XHtml ParseXHtml(XmlReader reader, ErrorList errors)
        {       
            try
            {
                var result = XHtml.Parse(reader.ReadOuterXml());
                return result;
            }
            catch (FhirValueFormatException ex)
            {
                errors.Add(ex.Message, (IXmlLineInfo)reader);
            }

            return null;
        }


        public static Code<T> ParseCode<T>(XmlReader reader, ErrorList errors)
            where T : struct, IConvertible
        {
            ElementContent content = parsePrimitiveElement(reader, errors);

            try
            {
                var result = Code<T>.Parse(content.Value);

                if (content.Id != null) result.ReferralId = content.Id;
                if (content.Dar.HasValue) result.Dar = content.Dar;

                return result;
            }
            catch (FhirValueFormatException ex)
            {
                errors.Add(ex.Message, (IXmlLineInfo)reader);
            }

            return null;
        }


        public static FhirDateTime ParseFhirDateTime(XmlReader reader, ErrorList errors)
        {
            ElementContent content = parsePrimitiveElement(reader, errors);

            try
            {
                var result = FhirDateTime.Parse(content.Value);

                if (content.Id != null) result.ReferralId = content.Id;
                if (content.Dar.HasValue) result.Dar = content.Dar;

                return result;
            }
            catch (FhirValueFormatException ex)
            {
                errors.Add(ex.Message, (IXmlLineInfo)reader);
            }

            return null;
        }


        private static ElementContent parsePrimitiveElement(XmlReader reader, ErrorList errors)
        {
            ElementContent result = XmlUtils.ParseElementContent(reader, errors);
            string elementName = reader.LocalName;

            try
            {
                result.Value = reader.ReadElementContentAsString();
            }
            catch (XmlException xe)
            {
                errors.Add( 
                    String.Format("Primitive content cannot be read from element {0}: {1}", elementName,
                        xe.Message), (IXmlLineInfo)reader );
            }

            return result;
        }
    }
}
