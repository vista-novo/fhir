using System;
using System.Collections.Generic;
using HL7.Fhir.Instance.Support;
using System.Xml.Linq;

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

//
// Generated on Fri, Jul 13, 2012 22:37+0200 for FHIR v0.04
//

using HL7.Fhir.Instance.Model;
using System.Xml;

namespace HL7.Fhir.Instance.Parsers
{
    /*
    * Parser for Narrative instances
    */
    public static partial class XmlNarrativeParser
    {
        public static Narrative ParseNarrative(XmlReader reader, ErrorList errors)
        {
            Narrative result = new Narrative();
            string en = reader.LocalName;
            string ns = reader.NamespaceURI;
            
            // Read id/dar from element's attributes
            ElementContent attrs = XmlUtils.ParseElementContent(reader, errors);
            if (attrs.Id != null) result.ReferralId = attrs.Id;
            if (attrs.Dar.HasValue) result.Dar = attrs.Dar;

            // If this is an empty node, return immediately
            if (reader.IsEmptyElement) return result;

            // Read starttag and start parsing
            reader.Read();
            
            // Parse element Narrative.status
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "status" )
                result.Status = XmlPrimitiveParser.ParseCode<Narrative.NarrativeStatus>(reader, errors);
            
            // Parse element Narrative.div
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.XHTMLNS && reader.LocalName == "div" )
                result.Div = XmlPrimitiveParser.ParseXHtml(reader, errors);
            
            // Parse element Narrative.image
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "image" )
            {
                result.Image = new List<Narrative.NarrativeImageComponent>();
                
                while( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "image" )
                    result.Image.Add(XmlNarrativeParser.ParseNarrativeImageComponent(reader, errors));
            }
            
            // Parse element Narrative.map
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "map" )
            {
                result.Map = new List<Narrative.NarrativeMapComponent>();
                
                while( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "map" )
                    result.Map.Add(XmlNarrativeParser.ParseNarrativeMapComponent(reader, errors));
            }
            
            if( !XmlUtils.IsEndElement(reader,en,ns) )
            {
                errors.Add(String.Format("Encountered unrecognized element '{0}' while parsing '{1}'",	reader.LocalName, en), (IXmlLineInfo)reader);
                while (!XmlUtils.IsEndElement(reader, en, ns) || reader.EOF)
                	reader.Skip();
                result = null;
            }
            
            // Read endtag
            reader.Read();
            
            return result;
        }
        
        public static Narrative.NarrativeMapComponent ParseNarrativeMapComponent(XmlReader reader, ErrorList errors)
        {
            Narrative.NarrativeMapComponent result = new Narrative.NarrativeMapComponent();
            string en = reader.LocalName;
            string ns = reader.NamespaceURI;
            
            // Read id/dar from element's attributes
            ElementContent attrs = XmlUtils.ParseElementContent(reader, errors);
            if (attrs.Id != null) result.ReferralId = attrs.Id;
            if (attrs.Dar.HasValue) result.Dar = attrs.Dar;
            
            // Read starttag
            reader.Read();
            
            // Parse element NarrativeMapComponent.text
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "text" )
                result.Text = XmlPrimitiveParser.ParseIdRef(reader, errors);
            
            // Parse element NarrativeMapComponent.data
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "data" )
                result.Data = XmlPrimitiveParser.ParseIdRef(reader, errors);
            
            // Parse element NarrativeMapComponent.source
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "source" )
                result.Source = XmlPrimitiveParser.ParseCode<Narrative.NarrativeMapSource>(reader, errors);
            
            if( !XmlUtils.IsEndElement(reader,en,ns) )
            {
                errors.Add(String.Format("Encountered unrecognized element '{0}' while parsing '{1}'",	reader.LocalName, en), (IXmlLineInfo)reader);
                while (!XmlUtils.IsEndElement(reader, en, ns) || reader.EOF)
                	reader.Skip();
                result = null;
            }
            
            // Read endtag
            reader.Read();
            
            return result;
        }
        
        public static Narrative.NarrativeImageComponent ParseNarrativeImageComponent(XmlReader reader, ErrorList errors)
        {
            Narrative.NarrativeImageComponent result = new Narrative.NarrativeImageComponent();
            string en = reader.LocalName;
            string ns = reader.NamespaceURI;
            
            // Read id/dar from element's attributes
            ElementContent attrs = XmlUtils.ParseElementContent(reader, errors);
            if (attrs.Id != null) result.ReferralId = attrs.Id;
            if (attrs.Dar.HasValue) result.Dar = attrs.Dar;
            
            // Read starttag
            reader.Read();
            
            // Parse element NarrativeImageComponent.mimeType
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "mimeType" )
                result.MimeType = XmlPrimitiveParser.ParseCode(reader, errors);
            
            // Parse element NarrativeImageComponent.content
            if( reader.NodeType == XmlNodeType.Element && reader.NamespaceURI == Util.FHIRNS && reader.LocalName == "content" )
                result.Content = XmlPrimitiveParser.ParseBase64Binary(reader, errors);
            
            if( !XmlUtils.IsEndElement(reader,en,ns) )
            {
                errors.Add(String.Format("Encountered unrecognized element '{0}' while parsing '{1}'",	reader.LocalName, en), (IXmlLineInfo)reader);
                while (!XmlUtils.IsEndElement(reader, en, ns) || reader.EOF)
                	reader.Skip();
                result = null;
            }
            
            // Read endtag
            reader.Read();
            
            return result;
        }
        
    }
}
