using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Serializers
{
    public interface IFhirWriter
    {
        void WriteStartRootObject(string name);
        void WriteEndRootObject();

        void WriteStartElement(string name);
        void WriteEndElement();

        void WriteBeginComplexContent(string name);
        void WriteEndComplexContent();

        void WriteBeginSimpleContent(string name);
        void WriteSimpleContent(string value);
        void WriteEndSimpleContent();

        void WriteBeginXhtmlContent(string name);
        void WriteXhtmlContent(string xhtml);
        void WriteEndXhtmlContent();

        void WriteStartArray(string name);
        void WriteEndArray();

        void WriteRefId(string id);
        void WriteDar(string reason);
    }
}
