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
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Support
{
    public class ErrorList : List<ErrorList.Error>
    {
        public class Error
        {
            public int? Line { get; set; }
            public int? Pos { get; set; }
            public string Message { get; set; }
            public string Context { get; set; }
        }


        public void Add(string message, string context, IXmlLineInfo pos)
        {         
            this.Add(message, context, pos.LineNumber, pos.LinePosition);
        }

        public void Add(string message, string context, int? line, int? pos)
        {
            this.Add( new Error { Message = message, Context = context,
                                Line = line, Pos = pos } );
        }

        public void Add(string message, string context)
        {
            this.Add(message,context,null,null);
        }

        public void Add(string message, int line, int pos)
        {
            this.Add(message, null, null, null);
        }

        public void Add(string message, IXmlLineInfo pos)
        {
            this.Add(message, null, pos);
        }

        public void Add(string message)
        {
        }

        public override string ToString()
        {
            if (this.Count() == 0)
                return "No errors.";

            return String.Join(", ", this.Select( e => e.Message ));
        }
    }
}
