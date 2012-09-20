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
using System.ServiceModel.Syndication;
using System.Xml.Linq;
using HL7.Fhir.Instance.Parsers;
using System.IO;
using HL7.Fhir.Instance.Serializers;

namespace HL7.Fhir.Instance.Support
{
    public partial class Bundle
    {
        public string Title { get; set; }
        public DateTimeOffset? LastUpdated { get; set; }
        public string Id { get; set; }
        public Uri SelfLink { get; set; }

        public List<BundleEntry> Entries { get; private set; }

        public Bundle()
        {
            Entries = new List<BundleEntry>();
        }


        public ErrorList Validate()
        {
            ErrorList errors = new ErrorList();
            string context = String.Format("Feed '{0}'", Id);

            if (String.IsNullOrWhiteSpace(Title))
                errors.Add("Feed must contain a title", context);

            if (String.IsNullOrWhiteSpace(Id))
                errors.Add("Feed must have an id", context);

            if (SelfLink == null || String.IsNullOrWhiteSpace(SelfLink.ToString()))
                errors.Add("Feed must have a link of type 'self'", context);

            Entries.ForEach(entry => errors.AddRange(entry.Validate()));

            return errors;
        }


        private const string GDATA_NAMESPACE = "http://schemas.google.com/g/2005";
        private const string ETAG_LABEL = "etag";
        private readonly XmlQualifiedName ETAG = new XmlQualifiedName(ETAG_LABEL, GDATA_NAMESPACE);
    }
      
    public class BundleEntry
    {
        public string VersionId { get; set; }
        public string Title { get; set; }
        public Uri SelfLink { get; set; }
        public string Id { get; set; }
        public DateTimeOffset? LastUpdated { get; set; }
        public DateTimeOffset? Published { get; set; }
        public string AuthorName { get; set; }
        public string AuthorUri { get; set; }
        public string ResourceType { get; set; }

        public Resource Content { get; set; }
        public bool IsDeletion { get; set; }

        public string Summary { get; set; }

        public ErrorList Validate()
        {
            ErrorList errors = new ErrorList();
            string context = String.Format("Entry '{0}'", Id);

            if (String.IsNullOrWhiteSpace(Title))
                errors.Add("Entry must contain a title", context);

            if (SelfLink == null || SelfLink.ToString() == String.Empty)
                errors.Add("Entry must have a link of type 'self'", context);

            if (String.IsNullOrWhiteSpace(Id))
                errors.Add("Entry must have an id", context);

            if (String.IsNullOrWhiteSpace(AuthorName))
                errors.Add("Entry must have at least one author with a name", context);

            return errors;
        }
    }
}
