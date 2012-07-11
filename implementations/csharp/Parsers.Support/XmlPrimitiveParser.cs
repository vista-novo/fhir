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
        public class FhirElementAttributes
        {
            public string Id { get; set; }
            public string Dar { get; set; }
            public string IdRef { get; set; }
        }

        public static IdRef ParseIdRef(XmlReader elem, out FhirElementAttributes attrs)
        {
            string value = parsePrimitiveElement(elem, out attrs);

            elem.Read();

            return IdRef.Parse(attrs.IdRef);
        }

        public static Code<T> ParseCode<T>(XmlReader reader, out FhirElementAttributes attrs)
            where T : struct, IConvertible
        {
            string value = parsePrimitiveElement(reader, out attrs);
            
            return Code<T>.Parse(value);
        }


        private static string parsePrimitiveElement(XmlReader reader, out FhirElementAttributes attrs)
        {
            attrs = null;

            if (reader.HasAttributes)
            {
                attrs = new FhirElementAttributes();

                while (reader.MoveToNextAttribute())
                {
                    if (reader.LocalName == XmlUtil.IDATTR)
                        attrs.Id = reader.Value;
                    else if (reader.LocalName == XmlUtil.IDREFATTR)
                        attrs.IdRef = reader.Value;
                    else if (reader.LocalName == XmlUtil.DARATTR)
                        attrs.Dar = reader.Value;
                    else if (reader.LocalName == "xmlns")
                        #pragma warning disable 642
                        ;
                        #pragma warning restore 642
                    else

                        throw new ResourceXmlParseError(
                            XmlUtil.ParseError(reader,
                                String.Format("Unsupported attribute '{0}' on element.",
                                    reader.LocalName)));      
                }

                reader.MoveToElement();
            }


            try
            {
                return reader.ReadElementContentAsString();
            }
            catch (XmlException xe)
            {
                throw new ResourceXmlParseError("Primitives cannot be read: " + xe.Message);
            }
        }
    }
}
