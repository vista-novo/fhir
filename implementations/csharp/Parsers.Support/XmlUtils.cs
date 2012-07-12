using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using HL7.Fhir.Instance.Support;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Parsers
{
    public class XmlUtils
    {
        public static bool IsEndElement(XmlReader reader, string en, string ns)
        {
            return reader.NodeType == XmlNodeType.EndElement &&
                    reader.LocalName == en && reader.NamespaceURI == ns;
        }

        public static ElementContent ParseElementContent(XmlReader reader, ErrorList errors)
        {
            ElementContent result = new ElementContent();
            string elementName = reader.LocalName;

            if (reader.HasAttributes)
            {
                while (reader.MoveToNextAttribute())
                {
                    if (reader.LocalName == Util.IDATTR)
                        result.Id = reader.Value;
                    else if (reader.LocalName == Util.DARATTR)
                        result.Dar = Code<DataAbsentReason>.Parse(reader.Value);
                    else if (reader.LocalName == "xmlns")
                        #pragma warning disable 642
                        ;
                        #pragma warning restore 642
                    else
                        errors.Add( String.Format("Unsupported attribute '{0}' on element {1}",
                            reader.LocalName, elementName), (IXmlLineInfo)reader);      
                }

                reader.MoveToElement();
            }

            return result;
        }
    }
}
