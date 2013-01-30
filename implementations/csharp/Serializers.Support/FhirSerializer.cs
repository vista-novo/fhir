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
using HL7.Fhir.Instance.Model;
using System.IO;
using Newtonsoft.Json;
using System.Xml.Linq;
using System.Xml;

namespace HL7.Fhir.Instance.Serializers
{
    public partial class FhirSerializer
    {

        public static byte[] ResourceAsJsonBytes(Resource resource, Encoding encoding = null)
        {
            if (encoding == null) encoding = Encoding.Unicode;

            MemoryStream stream = new MemoryStream();

            var sw = new StreamWriter(stream, encoding);
            sw.Write(ResourceAsJson(resource));
            sw.Close();

            return stream.ToArray();
        }


        public static string ResourceAsJson(Resource resource)
        {
            StringBuilder resultBuilder = new StringBuilder();

            StringWriter sw = new StringWriter(resultBuilder);
            JsonWriter jw = new JsonTextWriter(sw);
            FhirSerializer.Save(resource, jw);

            return resultBuilder.ToString();
        }

        public static XDocument ResourceAsXElement(Resource resource)
        {
            return XDocument.Parse(ResourceAsXml(resource));
        }

        public static string ResourceAsXml(Resource resource)
        {
            //Note: this will always carry UTF-16 coding in the <?xml> header
            StringBuilder sb = new StringBuilder();
            XmlWriter xw = XmlWriter.Create(sb);
            resource.Save(xw);
            xw.Close();

            return sb.ToString();
        }

        public static byte[] ResourceAsXmlBytes(Resource resource, Encoding encoding = null)
        {
            if (encoding == null) encoding = Encoding.Unicode;

            MemoryStream stream = new MemoryStream();
            XmlWriterSettings settings = new XmlWriterSettings { Encoding = encoding };
            XmlWriter xw = XmlWriter.Create(stream, settings);
            resource.Save(xw);
            xw.Flush();
            xw.Close();

            return stream.ToArray();
        }
    }
}
