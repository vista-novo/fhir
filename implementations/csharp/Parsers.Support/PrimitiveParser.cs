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
using System.Xml.Linq;
using System.Xml;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Parsers
{
    public static partial class PrimitiveParser
    {
        public static XHtml ParseXHtml(IFhirReader reader, ErrorList errors)
        {
            var contents = reader.ReadXhtmlContents();

            try
            {
                var result = XHtml.Parse(contents);
                return result;
            }
            catch (FhirValueFormatException ex)
            {
                errors.Add(ex.Message, reader);
            }

            return null;
        }
        

        public static Code<T> ParseCode<T>(IFhirReader reader, ErrorList errors)
            where T : struct, IConvertible
        {
            try
            {
                string contents = null;
                string refId = null;
                
                while (!reader.IsAtElementEnd())
                {
                    if (reader.IsAtRefIdElement())
                    	refId = reader.ReadRefIdContents();
                    else if (reader.IsAtPrimitiveValueElement())
                    	contents = reader.ReadPrimitiveContents();
                    else
                    errors.Add(String.Format("Encountered unknown element {0}", reader.CurrentElementName), reader);
                }
                
                if (!String.IsNullOrEmpty(contents))
                {
                    var result = Code<T>.Parse(contents);
                    
                    if (!String.IsNullOrEmpty(refId))
                    	result.ReferralId = refId;
                    
                    return result;
                }
                
                return null;
            }
            catch (FhirValueFormatException ex)
            {
                errors.Add(ex.Message, reader);
            }
            
            return null;
        }       
    }
}
