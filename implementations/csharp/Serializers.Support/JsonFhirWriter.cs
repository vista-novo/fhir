using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Newtonsoft.Json;

namespace HL7.Fhir.Instance.Serializers
{
    public class JsonFhirWriter : IFhirWriter
    {
        private JsonWriter jw;
        
        public JsonFhirWriter(JsonWriter jwriter)
        {
            jw = jwriter;
        }

        public void WriteStartRootObject(string name)
        {
            jw.WriteStartObject();
            jw.WritePropertyName(name);
        }

        public void WriteEndRootObject()
        {
            jw.WriteEndObject();
        }

        public void WriteStartElement(string name)
        {
            jw.WritePropertyName(name);
        }

        public void WriteEndElement()
        {
            // Nothing
        }

        public void WriteStartComplexContent()
        {
            jw.WriteStartObject();
        }

        public void WriteEndComplexContent()
        {
            jw.WriteEndObject();
        }

        public void WriteSimpleContent(string value)
        {
            jw.WritePropertyName("value");
            jw.WriteValue(value);
        }

        public void WriteValue(string value)
        {
            jw.WriteValue(value);
        }

        public void WriteStartXhtmlElement(string name)
        {
            // In Json, the serialization of Xhtml is the same as other elements
            WriteStartElement(name);
        }

        public void WriteXhtmlContent(string xhtml)
        {
            WriteValue(xhtml);
        }

        public void WriteEndXhtmlElement()
        {
            WriteEndElement();
        }

        public void WriteStartArrayElement(string name)
        {
            jw.WritePropertyName(name);
            jw.WriteStartArray();
        }

        public void WriteStartArrayMember(string name)
        {
            // Nothing
        }

        public void WriteEndArrayMember()
        {
            // Nothing
        }

        public void WriteEndArrayElement()
        {
            jw.WriteEndArray();
        }

        public void WriteRefId(string id)
        {
            jw.WritePropertyName("_id");
            jw.WriteValue(id);
        }

        public void WriteDar(string reason)
        {
            jw.WritePropertyName("dataAbsentReason");
            jw.WriteValue(reason);
        }
    }
}
