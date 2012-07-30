using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HL7.Fhir.Instance.Parsers
{
    public interface IFhirReader
    {
        void MoveToContent();

        string CurrentElementName { get; }

        bool IsAtStartElement();
        bool IsAtEndElement();

        bool ReadStartComplexContent(out string refid, out string dar);
        void ReadEndComplexContent();

        void SkipContents(string name);

        bool IsAtXhtmlElement();
        string ReadXhtmlContents();

        int LineNumber { get; }
        int LinePosition { get; }

        void ReadStartArray();
        bool IsAtArrayElement();
        void ReadEndArray();

        string ReadPrimitiveElementContents(out string refid, out string dar);
    }
}
