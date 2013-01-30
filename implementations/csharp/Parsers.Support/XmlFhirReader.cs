/*
  Copyright (c) 2011-2012, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  

*/

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using HL7.Fhir.Instance.Support;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Parsers
{
    public class XmlFhirReader : IFhirReader
    {
        public const string XHTMLELEM = "div";
        public const string IDATTR = "id";
        public const string VALUEATTR = "value";
        public const string LANGATTR = "lang";


        private XmlReader xr;

        public XmlFhirReader(XmlReader xr)
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            this.xr = XmlReader.Create(xr, settings);
        }

        public void MoveToContent()
        {
            xr.MoveToContent();
        }

        public string CurrentElementName
        {
            get
            {
                if (xr.NodeType == XmlNodeType.Element)
                    return xr.LocalName;
                else
                    return "#attribute";
            }
        }


        public void EnterElement()
        {
            _lastEncounteredPrimitiveValue = null;
            _lastEncounteredRefIdValue = null;
            _lastEncounteredLanguageValue = null;

            readAttributes();

            if (!xr.IsEmptyElement)
                xr.ReadStartElement();
        }


        public bool IsAtElement()
        {
            return
                IsAtXhtmlElement() ||
                IsAtPrimitiveValueElement() ||
                IsAtLanguageElement() ||
                IsAtRefIdElement() ||
                isAtFhirElement();
        }


        private bool isAtFhirElement()
        {
            return xr.NodeType == XmlNodeType.Element && xr.NamespaceURI == Support.Util.FHIRNS;
        }

        public bool IsAtXhtmlElement()
        {
            return xr.NodeType == XmlNodeType.Element && xr.NamespaceURI == Support.Util.XHTMLNS &&
                xr.LocalName == XHTMLELEM;
        }

        public string ReadXhtmlContents()
        {
            return xr.ReadOuterXml();
        }


        private string _lastEncounteredPrimitiveValue = null;

        public bool IsAtPrimitiveValueElement()
        {
            return _lastEncounteredPrimitiveValue != null;
        }

        public string ReadPrimitiveContents()
        {
            string result = _lastEncounteredPrimitiveValue;
            _lastEncounteredPrimitiveValue = null;
            return result;
        }

        private string _lastEncounteredRefIdValue = null;

        public bool IsAtRefIdElement()
        {
            return _lastEncounteredRefIdValue != null;
        }

        public string ReadRefIdContents()
        {
            string result = _lastEncounteredRefIdValue;
            _lastEncounteredRefIdValue = null;
            return result;
        }

        private string _lastEncounteredLanguageValue = null;

        public bool IsAtLanguageElement()
        {
            return _lastEncounteredLanguageValue != null;
        }

        public string ReadLanguageContents()
        {
            string result = _lastEncounteredLanguageValue;
            _lastEncounteredLanguageValue = null;
            return result;
        }

        public void LeaveElement()
        {
            if (xr.NodeType == XmlNodeType.EndElement)
                xr.ReadEndElement();
            else if (xr.IsEmptyElement)
                xr.Read();
            else
                throw new FhirFormatException("Expected end of element");
        }


        public void SkipSubElementsFor(string name)
        {
            if (xr.IsEmptyElement)
                xr.Read();
            else
            {
                while (!isEndElement(xr, name) && !xr.EOF)
                    xr.Skip();
            }
        }


        private static bool isEndElement(XmlReader reader, string en)
        {
            //Note: this will even find a closing element if it is the same name but
            //another namespace. Too bad. Cannot assume it is FHIRNS, since it might
            //be xhtml (Narrative.div) element too.
            return reader.NodeType == XmlNodeType.EndElement && reader.LocalName == en;
        }


        public int LineNumber
        {
            get { return ((IXmlLineInfo)xr).LineNumber; }
        }

        public int LinePosition
        {
            get { return ((IXmlLineInfo)xr).LinePosition; }
        }


        public void EnterArray()
        {
            if (xr.NodeType != XmlNodeType.Element)
                throw new FhirFormatException("Expected a (repeating) element from FHIR namespace");
        }

        public bool IsAtArrayMember()
        {
            return isAtFhirElement();
        }

        public void LeaveArray()
        {
            // Nothing
        }

       
        private void readAttributes()
        {
            string elementName = xr.LocalName;

            if (xr.HasAttributes)
            {
                while (xr.MoveToNextAttribute())
                {
                    if (xr.LocalName == IDATTR && xr.NamespaceURI == "")
                        _lastEncounteredRefIdValue = xr.Value;
                    else if (xr.LocalName == VALUEATTR && xr.NamespaceURI == "")
                        _lastEncounteredPrimitiveValue = xr.Value;
                    else if (xr.LocalName == LANGATTR && xr.Prefix == "xml")
                        _lastEncounteredLanguageValue = xr.Value;
                    else
                    {
                        if (xr.NamespaceURI == Util.XMLNS)
#pragma warning disable 642
                            ;
#pragma warning restore 642
                        else
                            throw new FhirFormatException(String.Format("Unsupported attribute '{0}' on element {1}",
                                    xr.LocalName, elementName));
                    }
                }

                xr.MoveToElement();
            }
        }
    }
}
