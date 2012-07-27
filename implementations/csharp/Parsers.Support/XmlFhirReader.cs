using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Parsers
{
    public class XmlFhirReader : IFhirReader
    {
        private XmlReader xr;

        public XmlFhirReader(XmlReader xr)
        {
            if (xr.Settings.IgnoreWhitespace != true ||
                xr.Settings.IgnoreProcessingInstructions != true ||
                xr.Settings.IgnoreComments != true)
                throw new ArgumentException("XmlReader should have its settings set to ignore comments, pi's and whitespace");

            this.xr = xr;
        }

        public void MoveToContent()
        {
            xr.MoveToContent();
        }

        public bool IsAtElement(string name, bool isPolymorph = false)
        {
            if (xr.NodeType != XmlNodeType.Element)
                return false;

            if( xr.NamespaceURI != Util.FHIRNS )
                return false;

            if( !isPolymorph )
                return xr.LocalName == name;
            else
                return xr.LocalName.StartsWith(name);
        }

        public bool IsAtElementEndingWith(string suffix)
        {
            if (xr.NodeType != XmlNodeType.Element)
                return false;

            if (xr.NamespaceURI != Util.FHIRNS)
                return false;

            return xr.LocalName.EndsWith(suffix);
        }


        public void EnterElement()
        {
            xr.ReadStartElement();
        }

        public string ReadContents()
        {
            string result = null;

            if (!xr.IsEmptyElement)
               result = xr.ReadElementContentAsString();

            if (result == String.Empty)
                  result = null;

            return result;
        }

        public void SkipContents(string name)
        {
            while (!isEndElement(xr, name, Util.XHTMLNS) || xr.EOF)
                xr.Skip();
        }

        private static bool isEndElement(XmlReader reader, string en, string ns)
        {
            return reader.NodeType == XmlNodeType.EndElement &&
                    reader.LocalName == en && reader.NamespaceURI == ns;
        }

        public bool HasMoreElements
        {
            get
            {
                return xr.NodeType != XmlNodeType.EndElement;
            }
        }

        public void ExitElement()
        {
            xr.ReadEndElement();
        }

        public string CurrentElementName
        {
            get { return xr.LocalName; }
        }

        public int LineNumber
        {
            get { return ((IXmlLineInfo)xr).LineNumber; }
        }

        public int LinePosition
        {
            get { return ((IXmlLineInfo)xr).LinePosition; }
        }

        public bool IsAtArray(string name)
        {
            throw new NotImplementedException();
        }

        public void EnterArray()
        {
            throw new NotImplementedException();
        }

        public bool MoveToNextArrayElement(string name)
        {
            throw new NotImplementedException();
        }

        public void ExitArray()
        {
            throw new NotImplementedException();
        }

        public string ReadRefId()
        {
            string id, dar;

            readAttributes(out id, out dar);
            return id;
        }

        public string ReadDar()
        {
            string id, dar;

            readAttributes(out id, out dar);
            return dar;
        }


        private void readAttributes(out string id, out string dar)
        {
            id = null;
            dar = null;

            if (xr.HasAttributes)
            {
                while (xr.MoveToNextAttribute())
                {
                    if (xr.LocalName == Util.IDATTR)
                        id = xr.Value;
                    else if (xr.LocalName == Util.DARATTR)
                        dar = xr.Value;
                    //else
                    //{
                    //    if (reader.NamespaceURI == Util.XMLNS)
                    //        #pragma warning disable 642
                    //        ;
                    //        #pragma warning restore 642
                    //    else
                    //        errors.Add( String.Format("Unsupported attribute '{0}' on element {1}",
                    //               reader.LocalName, elementName), reader);      
                    //}
                }

                xr.MoveToElement();
            }
        }
    }
}
