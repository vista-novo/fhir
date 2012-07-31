using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Serializers
{
    public class XmlFhirWriter : IFhirWriter
    {
        private XmlWriter xw;

        public XmlFhirWriter(XmlWriter xwriter)
        {
            xw = xwriter;
        }

        public void WriteStartRootObject(string name)
        {
            xw.WriteStartDocument();
            WriteStartElement(name);
        }

        public void WriteEndRootObject()
        {
            WriteEndElement();
            xw.WriteEndDocument();
        }

        public void WriteStartElement(string name)
        {
            xw.WriteStartElement(name, Util.FHIRNS);            
        }

        public void WriteEndElement()
        {
            xw.WriteEndElement();
        }

        public void WriteStartComplexContent()
        {
            // Nothing
        }

        public void WriteEndComplexContent()
        {
            // Nothing
        }

        public void WriteSimpleContent(string value)
        {
            xw.WriteValue(value);
        }

        public void WriteValue(string value)
        {
            xw.WriteValue(value);
        }

        public void WriteStartXhtmlElement(string name)
        {
//            xw.WriteStartElement(name, Util.XHTMLNS);
        }

        public void WriteXhtmlContent(string xhtml)
        {
            // Write xhtml directly into the output stream,
            // the xhtml <div> becomes part of the elements
            // of the type, just like the other FHIR elements
            xw.WriteRaw(xhtml);
        }

        public void WriteEndXhtmlElement()
        {
        }

        public void WriteStartArrayElement(string name)
        {
            // Nothing
        }

        public void WriteStartArrayMember(string name)
        {
            WriteStartElement(name);
        }

        public void WriteEndArrayMember()
        {
            WriteEndElement();
        }

        public void WriteEndArrayElement()
        {
            // Nothing
        }


        public void WriteRefId(string id)
        {
            xw.WriteAttributeString("id", id);
        }

        public void WriteDar(string reason)
        {
            xw.WriteAttributeString("dataAbsentReason", reason);
        }

        void IDisposable.Dispose()
        {
            ((IDisposable)xw).Dispose();
        }
    }
}
