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
// Generated on Sat, Jan 19, 2013 01:24-0700 for FHIR v0.07
//

using HL7.Fhir.Instance.Model;
using System.Xml;

namespace HL7.Fhir.Instance.Parsers
{
    /*
    * Parser for ResourceReference instances
    */
    public static partial class ResourceReferenceParser
    {
        public static ResourceReference ParseResourceReference(IFhirReader reader, ErrorList errors, 
            ResourceReference existingInstance = null ) 
        {
            ResourceReference result = existingInstance != null ? existingInstance : new ResourceReference();
            string en = reader.CurrentElementName;
            
            // Read id/dar from element's attributes and read starttag
            string refId;
            bool hasContent = reader.ReadStartComplexContent(out refId);
            result.ReferralId = refId;
            
            // If this is an empty (xml) node, return immediately
            if (!hasContent) return result;
            
            // Parse element ResourceReference.type
            if( ParserUtils.IsAtElement(reader, "type") )
                result.Type = PrimitiveParser.ParseCode(reader, errors);
            
            // Parse element ResourceReference.id
            if( ParserUtils.IsAtElement(reader, "id") )
                result.Id = PrimitiveParser.ParseFhirUri(reader, errors);
            
            // Parse element ResourceReference.version
            if( ParserUtils.IsAtElement(reader, "version") )
                result.Version = PrimitiveParser.ParseFhirUri(reader, errors);
            
            // Parse element ResourceReference.display
            if( ParserUtils.IsAtElement(reader, "display") )
                result.Display = PrimitiveParser.ParseFhirString(reader, errors);

            if (ParserUtils.IsAtNestedResource(reader))
            {
                result.InlinedContent = ResourceParser.ParseResource(reader, errors);
            }

            if( !ParserUtils.IsAtEndElement(reader, en) )
            {
                errors.Add(String.Format("Encountered unrecognized element '{0}' while parsing '{1}'",	reader.CurrentElementName, en), reader);
                reader.SkipContents(en);
                result = null;
            }
            
            // Read endtag
            reader.ReadEndComplexContent();
            
            return result;
        }
        
    }
}
