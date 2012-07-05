using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Support
{
    public static class XmlPrimitiveParser
    {
        public static FhirString ParseString(XElement elem, out string id)
        {
            return new FhirString(parsePrimitiveElement(elem, out id));
        }

        public static FhirBoolean ParseBoolean(XElement elem, out string id)
        {
            string value = parsePrimitiveElement(elem, out id);

            return FhirBoolean.Parse(value);
        }

        public static Base64Binary ParseInteger(XElement elem, out string id)
        {
            string value = parsePrimitiveElement(elem, out id);

            return Base64Binary.Parse(value);
        }

        public static FhirDecimal ParseDecimal(XElement elem, out string id)
        {
            string value = parsePrimitiveElement(elem, out id);

            return FhirDecimal.Parse(value);
        }

        public static XsdDateTime ParseInstant(XElement elem, out string id)
        {
            string value = parsePrimitiveElement(elem, out id);

            return Instant.Parse(value);
        }


        public static FhirUri ParseUri(XElement elem, out string id)
        {
            string value = parsePrimitiveElement(elem, out id);

            return FhirUri.Parse(value);
        }

        private static string parsePrimitiveElement(XElement primitive, out string id)
        {
            if (primitive.HasElements)
                throw new ResourceXmlParseError("Primitives cannot contain nested elements");

            if (primitive.HasAttributes)
            {
                if (primitive.FirstAttribute.Name == XmlUtil.IDATTR)
                    id = primitive.FirstAttribute.Value;
                else
                    throw new ResourceXmlParseError("Primitive cannot have attributes other than 'id'");
            }
            else
                id = null;

            return primitive.Value;
        }
    }
}
