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

namespace HL7.Fhir.Instance.Parsers
{
    public class XmlFhirReader : IFhirReader
    {
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
            get { return xr.LocalName; }
        }

        public bool IsAtStartElement()
        {
            return xr.NodeType == XmlNodeType.Element && xr.NamespaceURI == Support.Util.FHIRNS;
        }

        public bool IsAtEndElement()
        {
            return xr.NodeType == XmlNodeType.EndElement && xr.NamespaceURI == Support.Util.FHIRNS;
        }

        public bool IsAtXhtmlElement()
        {
            return xr.NodeType == XmlNodeType.Element && xr.NamespaceURI == Support.Util.XHTMLNS;
        }

        public void ReadEndComplexContent()
        {
            xr.ReadEndElement();
        }

        public string ReadXhtmlContents()
        {
            return xr.ReadOuterXml();
        }

        public void SkipContents(string name)
        {
            while (!isEndElement(xr, name) && !xr.EOF)
                xr.Skip();
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


        public void ReadStartArray()
        {
            // Nothing
        }

        public bool IsAtArrayElement()
        {
            return IsAtStartElement();
        }

        public void ReadEndArray()
        {
            // Nothing
        }

        public string ReadPrimitiveElementContents(out string refid)
        {
            readAttributes(out refid);

            return readContents();
        }

        public bool ReadStartComplexContent(out string refid)
        {
            readAttributes(out refid);

            if (!xr.IsEmptyElement)
            {
                xr.ReadStartElement();
                return true;
            }
            else
                return false;
        }


        private string readContents()
        {
            string result = null;

            if (!xr.IsEmptyElement)
                result = xr.ReadElementContentAsString();
            else
            {
                result = null;
                xr.Read();
            }
                
            if (result == String.Empty) result = null;

            return result;
        }


        private void readAttributes(out string id)
        {
            id = null;
        //    dar = null;

            string elementName = xr.LocalName;

            if (xr.HasAttributes)
            {
                while (xr.MoveToNextAttribute())
                {
                    if (xr.LocalName == Util.IDATTR)
                        id = xr.Value;
                 //   else if (xr.LocalName == Util.DARATTR)
                //        dar = xr.Value;
                    else
                    {
                        if (xr.NamespaceURI == Util.XMLNS)
#pragma warning disable 642
                            ;
#pragma warning restore 642
                        else
                           throw new FormatException(String.Format("Unsupported attribute '{0}' on element {1}",
                                   xr.LocalName, elementName));
                    }
                }

                xr.MoveToElement();
            }
        }
    }
}
