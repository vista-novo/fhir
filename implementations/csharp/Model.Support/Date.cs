/*
  Copyright (c) 2011-2012, HL7, Inc
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
using HL7.Fhir.Instance.Support;

namespace HL7.Fhir.Instance.Model
{
    public partial class Date
    {
        // No empty constructor - no explicit default value

        public static bool TryParse( string value, out Date result)
        {
            XsdDateTime dateValue;  

            bool succ = XsdDateTime.TryParse(value, out dateValue);

            if (succ && 
                ( dateValue.Kind == XsdDateTime.XsdDateTimeKind.Year ||
                  dateValue.Kind == XsdDateTime.XsdDateTimeKind.YearMonth ||
                  dateValue.Kind == XsdDateTime.XsdDateTimeKind.Date ))
            {
                
                result = new Date(dateValue);
                return true;
            }
            else
            {
                result = null;
                return false;
            }
        }

        public static Date Parse(string value)
        {
            Date result = null;

            if (TryParse(value, out result))
                return result;
            else 
                throw new FhirValueFormatException("Date must be a date/time value with year and/or month and/or day");
        }
       


        public override string ValidateData()
        {
            if(this.Value == null)
                return "Date must have a value";

            if (this.Value.Kind != XsdDateTime.XsdDateTimeKind.DateTime)
                return "Date must be a date/time value with year and/or month and/or day";

            return null;
        }
    }
  
}
