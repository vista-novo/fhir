using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Model;
using System.Xml;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Parsers
{
    public class XmlCompositeTypeParser
    {
        public Address.AddressPartComponent parseAddressPartComponent( XmlReader reader )
        {
            string id;

            Address.AddressPartComponent result = new Address.AddressPartComponent();

            //read optional element Address.part.type
            if (reader.LocalName == "type" && reader.NamespaceURI == XmlUtil.FHIRNS)
                result.Type = XmlPrimitiveParser.ParseCode<Address.AddressPartType>(reader, out id);
            //TODO: do something with id

            // read required element Address.part.value
            if (reader.LocalName == "type" && reader.NamespaceURI == XmlUtil.FHIRNS)
                result.Value = XmlPrimitiveParser.ParseFhirString(reader, out id);


            return result;
        }
    }
}
