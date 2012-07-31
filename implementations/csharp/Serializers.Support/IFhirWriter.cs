using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Serializers
{
    public interface IFhirWriter : IDisposable
    {
        void WriteStartRootObject(string name);
        void WriteEndRootObject();

        void WriteStartElement(string name);
        void WriteEndElement();

        void WriteStartComplexContent();
        void WriteEndComplexContent();

        void WriteSimpleContent(string value);
        void WriteValue(string value);

        void WriteStartXhtmlElement(string name);
        void WriteXhtmlContent(string xhtml);
        void WriteEndXhtmlElement();

        void WriteStartArrayElement(string name);
        void WriteStartArrayMember(string name);
        void WriteEndArrayMember();
        void WriteEndArrayElement();

        void WriteRefId(string id);
        void WriteDar(string reason);
    }
}
