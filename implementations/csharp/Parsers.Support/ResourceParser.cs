using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Support;
using System.Xml;
using System.IO;

namespace HL7.Fhir.Instance.Parsers
{
    public partial class ResourceParser
    {
        public static Resource ParseResourceFromXml(string data, ErrorList errors)
        {
            XmlReader reader = fromString(data);
            reader.MoveToContent();

            return ParseResource(new XmlFhirReader(reader),errors);
        }

        private static XmlReader fromString(string s)
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            XmlReader r = XmlReader.Create(new StringReader(s), settings);

            return r;
        }
    }
}
