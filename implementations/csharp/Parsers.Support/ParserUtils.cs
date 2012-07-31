using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using HL7.Fhir.Instance.Support;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Parsers
{
    public static class ParserUtils
    {
        public static bool IsAtElement(IFhirReader reader, string name, bool isPolymorph = false)
        {
            if (!reader.IsAtStartElement())
                return false;

            if (!isPolymorph)
                return reader.CurrentElementName == name;
            else
                return reader.CurrentElementName.StartsWith(name);
        }

        public static bool IsAtArrayElement(IFhirReader reader, string name, bool isPolymorph = false)
        {
            if (!reader.IsAtArrayElement())
                return false;

            if (!isPolymorph)
                return reader.CurrentElementName == name;
            else
                return reader.CurrentElementName.StartsWith(name);
        }


        public static bool IsAtElementEndingWith(IFhirReader reader, string suffix)
        {
            if (!reader.IsAtStartElement())
                return false;

            return reader.CurrentElementName.EndsWith(suffix);
        }


        public static bool IsAtEndElement(IFhirReader reader, string name)
        {
            return reader.IsAtEndElement() && reader.CurrentElementName == name;
        }

        public static bool IsAtXhtmlElement(IFhirReader reader, string name)
        {
            return reader.IsAtXhtmlElement() && reader.CurrentElementName == name;
        }

    }
}
