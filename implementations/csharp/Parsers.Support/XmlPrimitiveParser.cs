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
        public static Code<T> ParseCode<T>(XmlReader reader, out string id)
            where T : struct, IConvertible
        {
            string value = parsePrimitiveElement(reader, out id);

            return Code<T>.Parse(value);
        }


        //private static string parsePrimitiveElement(XElement primitive, out string id)
        //{
        //    if (primitive.HasElements)
        //        throw new ResourceXmlParseError("Primitives cannot contain nested elements");

        //    if (primitive.HasAttributes)
        //    {
        //        if (primitive.FirstAttribute.Name == XmlUtil.IDATTR)
        //            id = primitive.FirstAttribute.Value;
        //        else
        //            throw new ResourceXmlParseError("Primitive cannot have attributes other than 'id'");
        //    }
        //    else
        //        id = null;

        //    return primitive.Value;
        //}


        private static string parsePrimitiveElement(XmlReader reader, out string id)
        {
            id = null;

            if (reader.HasAttributes)
            {
                while (reader.MoveToNextAttribute())
                {
                    if (reader.LocalName == XmlUtil.IDATTR && reader.NamespaceURI == XmlUtil.FHIRNS)
                        id = reader.Value;
                    else
                        throw new ResourceXmlParseError("Primitive cannot have attributes other than 'id'");      
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
