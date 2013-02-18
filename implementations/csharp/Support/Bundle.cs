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
//using HL7.Fhir.Instance.Serializers;

namespace HL7.Fhir.Instance.Support
{
    public partial class Bundle
    {
        public string Title { get; set; }
        public DateTimeOffset? LastUpdated { get; set; }
        public Uri Id { get; set; }
        public UriLinkList Links { get; set; }

        public string AuthorName { get; set; }
        public string AuthorUri { get; set; }


        public List<BundleEntry> Entries { get; private set; }

        public Bundle()
        {
            Entries = new List<BundleEntry>();
            Links = new UriLinkList();
        }


        public ResourceEntry CreateResourceEntry() { return new ResourceEntry(this); }
        public DeletedEntry CreateDeletedEntry() { return new DeletedEntry(this); }
        public BinaryEntry CreateBinaryEntry() { return new BinaryEntry(this); }

        public ErrorList Validate()
        {
            ErrorList errors = new ErrorList();
            string context = String.Format("Feed '{0}'", Id);

            if (String.IsNullOrWhiteSpace(Title))
                errors.Add("Feed must contain a title", context);

            if (!Util.UriHasValue(Id))
                errors.Add("Feed must have an id", context);

            if (!Id.IsAbsoluteUri)
                errors.Add("Feed id must be an absolute URI", context);

            if (LastUpdated == null)
                errors.Add("Feed must have a updated date", context);

            Entries.ForEach(entry => errors.AddRange(entry.Validate()));

            return errors;
        }

        public static string ATOM_CATEGORY_RESOURCETYPE_NS = "http://hl7.org/fhir/resource-types";
        public static string ATOMPUB_TOMBSTONES_NS = "http://purl.org/atompub/tombstones/1.0";
        public static string ATOMPUBNS = "http://www.w3.org/2005/Atom";
    }


    public abstract class BundleEntry
    {
        internal BundleEntry(Bundle parent)
        {
            this.Parent = parent;
        }

        public Uri SelfLink { get; set; }
        public Uri Id { get; set; }
        public Bundle Parent { private set; get; }

        public virtual ErrorList Validate()
        {
            ErrorList errors = new ErrorList();
            errors.DefaultContext = String.Format("Entry '{0}'", Id);

            // SelfLink is no longer mandatory since a resource may not yet
            // have an established resource URL when using Atom to post batches
            // of new resources.
            //if (SelfLink == null || SelfLink.ToString() == String.Empty)
            //    errors.Add("Entry must have a link of type 'self'", context);

            if (Util.UriHasValue(SelfLink) && !SelfLink.IsAbsoluteUri)
                errors.Add("An entry self-link must be an absolute URI");

            if (Id == null || String.IsNullOrWhiteSpace(Id.ToString()))
                errors.Add("Entry must have an id");

            if (!Id.IsAbsoluteUri)
                errors.Add("Entry id must be an absolute URI");

            return errors;
        }

        public abstract string Summary { get; }
    }


    public class DeletedEntry : BundleEntry
    {
        internal DeletedEntry(Bundle parent) : base(parent) { }

        public DateTimeOffset When { get; set; }

        public override string Summary
        {
            get
            {
                return "<div xmlns='http://www.w3.org/1999/xhtml'>This resource has been deleted " +
                    "on " + When.ToString() + "</div>";
            }
        }
    }

    public abstract class ContentEntry : BundleEntry
    {
        internal ContentEntry(Bundle parent) : base(parent) { }

        public string Title { get; set; }

        public DateTimeOffset? LastUpdated { get; set; }
        public DateTimeOffset? Published { get; set; }
        public string EntryAuthorName { get; set; }
        public string EntryAuthorUri { get; set; }

        public string AuthorName 
        {
            get
            {
                if (!String.IsNullOrEmpty(EntryAuthorName))
                    return EntryAuthorName;
                else
                    return Parent.AuthorName;
            }
        }

        public string AuthorUri
        {
            get
            {
                if (!String.IsNullOrEmpty(EntryAuthorUri))
                    return EntryAuthorUri;
                else
                    return Parent.AuthorUri;
            }
        }

        public override ErrorList Validate()
        {
            ErrorList errors = base.Validate();

            if (String.IsNullOrWhiteSpace(Title))
                errors.Add("Entry must contain a title");

            if (String.IsNullOrWhiteSpace(AuthorName))
                errors.Add("Entry, or its parent feed, must have at least one author with a name");

            if (LastUpdated == null)
                errors.Add("Entry must have an updated date");

            return errors;
        } 
    }

    public class BinaryEntry : ContentEntry
    {
        internal BinaryEntry(Bundle parent) : base(parent) { }

        public string MediaType;
        public byte[] Content { get; set; }

        public override ErrorList Validate()
        {
            ErrorList errors = base.Validate();

            if (Content == null)
                errors.Add("Entry must contain (possibly 0-length) data");

            if (MediaType == null)
                errors.Add("Entry must contain a contentType");

            return errors;
        }

        public override string Summary
        {
            get
            {
                return "<div xmlns='http://www.w3.org/1999/xhtml'>Binary content</div>";
            }
        }  
    }

    public class ResourceEntry : ContentEntry
    {
        internal ResourceEntry(Bundle parent) : base(parent) { }

        public string ResourceType { get; private set; }

        // Provide the content by either giving a Resource (for FHIR resources)
        // or supplying binary data to represent a blob in the feed.
        private Resource _content;
        public Resource Content 
        { 
            get
            {
                return _content;
            }

            set
            {
                _content = value;
                ResourceType = ModelInfo.FhirCsTypeToString[_content.GetType()];
            }
 
        }

        public override ErrorList Validate()
        {
            ErrorList errors = base.Validate();

            if (Content == null)
                errors.Add("Entry must contain Resource data, Content may not be null");

            if( ResourceType == null )
                errors.Add("Entry specify the resource's type in ResourceType");

            return errors;
        }

        public override string Summary
        {
            get
            {
                if(Content != null && Content.Text != null && Content.Text.Div != null)
                    return (string)Content.Text.Div;
                else
                    return null;
            }
        }
    }
}
