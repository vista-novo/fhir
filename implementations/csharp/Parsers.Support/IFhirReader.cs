using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HL7.Fhir.Instance.Parsers.Support
{
    public interface IFhirReader
    {
        void MoveToContent();

        bool IsAtElement(string name, bool isPolymorph);
        void EnterElement();
        string ReadContents();
        void SkipContents();
        bool HasMoreElements();
        void ExitElement();

        string CurrentElementName { get; }
        int LineNumber { get; }
        int LinePosition { get; }

        bool IsAtArray(string name);
        void EnterArray();
        bool MoveToNextArrayElement(string name);
        void ExitArray();

        string ReadRefId();
        string ReadDar();
    }
}
