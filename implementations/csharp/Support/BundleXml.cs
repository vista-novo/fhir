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
        public const string XATOM_FEED = "feed";
        public const string XATOM_DELETED_ENTRY = "deleted-entry";
        public const string XATOM_DELETED_WHEN = "when";
        public const string XATOM_DELETED_REF = "ref";
        public const string XATOM_LINK = "link";
        public const string XATOM_LINK_REL = "rel";
        public const string XATOM_LINK_HREF = "href";
        public const string XATOM_CONTENT_BINARY = "Binary";
        public const string XATOM_CONTENT_TYPE = "contentType";
        public const string XATOM_TITLE = "title";
        public const string XATOM_UPDATED = "updated";
        public const string XATOM_ID = "id";
        public const string XATOM_ENTRY = "entry";
        public const string XATOM_PUBLISHED = "published";
        public const string XATOM_AUTHOR = "author";
        public const string XATOM_AUTH_NAME = "name";
        public const string XATOM_AUTH_URI = "uri";
        public const string XATOM_CATEGORY = "category";
        public const string XATOM_CAT_TERM = "term";
        public const string XATOM_CAT_SCHEME = "scheme";
        public const string XATOM_CONTENT = "content";
        public const string XATOM_SUMMARY = "summary";

        public static Bundle Load(XmlReader reader, ErrorList errors)
        {
            SyndicationFeed feed;

            try
            {
                feed = SyndicationFeed.Load(reader);
            }
            catch (Exception exc)
            {
                errors.Add("Exception while loading feed: " + exc.Message);
                return null;
            }

            Bundle result;

            try
            {
                result = new Bundle()
                {
                    Title = feed.Title != null && !String.IsNullOrWhiteSpace(feed.Title.Text) ?
                                feed.Title.Text : null,
                    LastUpdated = (feed.LastUpdatedTime == DateTimeOffset.MinValue) ? (DateTimeOffset?)null : feed.LastUpdatedTime,
                    Id = new Uri(feed.Id, UriKind.Absolute),
                    Links = getLinksFromSyndication(feed.Links),
                    AuthorName = feed.Authors != null ?
                                    feed.Authors.Select(auth => auth.Name).FirstOrDefault() : null,
                    AuthorUri = feed.Authors != null ?
                                 feed.Authors.Select(auth => auth.Uri).FirstOrDefault() : null

                };
            }
            catch (Exception exc)
            {
                errors.Add("Exception while parsing feed attributes: " + exc.Message,
                    String.Format("Feed '{0}'", feed.Id) );
                return null;
            }

            result.Entries.Clear();
            result.loadContentItems(feed.Items, errors);
            result.loadDeletedItems(feed.ElementExtensions, errors);

            errors.AddRange(result.Validate());

            return result;
        }

        private void loadDeletedItems(SyndicationElementExtensionCollection extensions, ErrorList errors)
        {
            foreach (SyndicationElementExtension extension in extensions.Where(
                        ext => ext.OuterName == XATOM_DELETED_ENTRY && ext.OuterNamespace == ATOMPUB_TOMBSTONES_NS))
            {
                DeletedEntry de = new DeletedEntry(this);

                try
                {
                    errors.DefaultContext = "A deleted entry";

                    XmlReader extensionReader = extension.GetReader();
                    XElement deletedExtension = (XElement)(XElement.ReadFrom(extensionReader));
                    XAttribute id = deletedExtension.Attribute(XATOM_DELETED_REF);

                    if (id != null) errors.DefaultContext = String.Format("Entry '{0}'", id);

                    XAttribute when = deletedExtension.Attribute(XATOM_DELETED_WHEN);

                    XElement self = deletedExtension.Elements(XName.Get(XATOM_LINK,ATOMPUBNS))
                        .Where(el => el.Attribute(XATOM_LINK_REL) != null &&
                                    el.Attribute(XATOM_LINK_REL).Value == Util.ATOM_LINKREL_SELF).FirstOrDefault();
   
                    if (when != null) de.When = Instant.Parse(when.Value).Contents.Value;
                    if (id != null) de.Id = new Uri(id.Value, UriKind.Absolute);
                    if (self != null && self.Attribute(XATOM_LINK_HREF) != null ) 
                                de.SelfLink = new Uri(self.Attribute(XATOM_LINK_HREF).Value, UriKind.Absolute);
                }
                catch (Exception exc)
                {
                    errors.Add("Exception while reading deleted-entry: " + exc.Message);
                    return;
                }
                finally
                {
                    errors.DefaultContext = null;
                }

                Entries.Add(de);
            }
        }

        private void loadContentItems( IEnumerable<SyndicationItem> items, ErrorList errors )
        {
            foreach (SyndicationItem item in items)
            {
                ContentEntry result;

                try
                {
                    errors.DefaultContext = String.Format("Entry '{0}'", item.Id);

                    if( getCategoryFromEntry(item) == XATOM_CONTENT_BINARY )
                        result = new BinaryEntry(this);
                    else
                        result = new ResourceEntry(this);

                    result.Title = item.Title != null && !String.IsNullOrWhiteSpace(item.Title.Text) ?
                                    item.Title.Text : null;
                    result.SelfLink = getLinksFromSyndication(item.Links).SelfLink;
                    result.Id = new Uri(item.Id,UriKind.Absolute);
                    result.LastUpdated = (item.LastUpdatedTime == DateTimeOffset.MinValue) ?
                                    (DateTimeOffset?)null : item.LastUpdatedTime;
                    result.Published = (item.PublishDate == DateTimeOffset.MinValue) ?
                                    (DateTimeOffset?)null : item.PublishDate;
                    result.EntryAuthorName = item.Authors != null ?
                                 item.Authors.Select(auth => auth.Name).FirstOrDefault() : null;
                    result.EntryAuthorUri = item.Authors != null ?
                                 item.Authors.Select(auth => auth.Uri).FirstOrDefault() : null;

                    if (result is ResourceEntry)
                        ((ResourceEntry)result).Content = getContents(item.Content, errors);
                    else
                        getBinaryContentsFromSyndication(item.Content, (BinaryEntry)result, errors);
                }
                catch (Exception exc)
                {
                    errors.Add("Exception while reading entry: " + exc.Message);
                    return;
                }
                finally
                {
                    errors.DefaultContext = null;
                }

                Entries.Add(result);
            }
        }

        private static void getBinaryContentsFromSyndication(SyndicationContent content, BinaryEntry result, ErrorList errors)
        {
            string contents = getContentsFromSyndication(content, errors);
            XElement binary = null;

            try
            {
                binary = XElement.Parse(contents);
            }
            catch (XmlException e)
            {
                errors.Add("Cannot parse Binary: " + e.Message);
                return;
            }

            XAttribute contentType = binary.Attribute(XName.Get(XATOM_CONTENT_TYPE));

            if (contentType != null)
                result.MediaType = contentType.Value;

            try
            {
                result.Content = Convert.FromBase64String(binary.FirstNode.ToString());
            }
            catch (Exception e)
            {
                errors.Add("Cannot parse content of Binary: " + e.Message);
            }
        }


        private string getCategoryFromEntry(SyndicationItem item)
        {
            return item.Categories != null ? item.Categories
                               .Where(cat => cat.Scheme == ATOM_CATEGORY_RESOURCETYPE_NS)
                               .Select(scat => scat.Name).FirstOrDefault() : null;
        }


        private readonly XNamespace XATOMNS = ATOMPUBNS;

        public void Save(XmlWriter writer)
        {
            var root = new XElement(XATOMNS+XATOM_FEED);

            if (!String.IsNullOrWhiteSpace(Title)) root.Add(xmlCreateTitle(Title));
            if (Util.UriHasValue(Id)) root.Add(xmlCreateId(Id));
            if (LastUpdated != null) root.Add(new XElement(XATOMNS+XATOM_UPDATED, LastUpdated));
            if (Links.Count > 0)
                Links.ForEach( l => root.Add(xmlCreateLink(l.Rel, l.Uri)));
            if (!String.IsNullOrWhiteSpace(AuthorName))
                root.Add(xmlCreateAuthor(AuthorName, AuthorUri));

            foreach (var entry in Entries)
            {
                if( entry is ContentEntry )
                    root.Add( xmlCreateContentEntry((ContentEntry)entry));
                else if(entry is DeletedEntry)
                    root.Add( xmlCreateDeletedEntry((DeletedEntry)entry));
                else
                    throw new ArgumentException("Don't know how to serialize an entry of type " + entry.GetType().ToString());
            }

            var result = new XDocument(root);
            result.WriteTo(writer);
        }

        private XElement xmlCreateId(Uri id)
        {
            return new XElement(XATOMNS + XATOM_ID, id.ToString());
        }

        private XElement xmlCreateLink(string rel, Uri uri)
        {
            return new XElement(XATOMNS+XATOM_LINK,
                            new XAttribute(XATOM_LINK_REL, rel), new XAttribute(XATOM_LINK_HREF, uri.ToString()));
        }

        private XElement xmlCreateTitle(string title)
        {
            return new XElement(XATOMNS + XATOM_TITLE, new XAttribute("type", "text"), title);
        }


        private XElement xmlCreateCategory(string name, string scheme)
        {
            var result = new XElement(XATOMNS+XATOM_CATEGORY);

            if(!String.IsNullOrEmpty(name))
                result.Add(new XAttribute(XATOM_CAT_TERM,name));

            if(!String.IsNullOrEmpty(scheme))
                result.Add(new XAttribute(XATOM_CAT_SCHEME,scheme));

            return result;
        }

        private XElement xmlCreateDeletedEntry(DeletedEntry de)
        {
            XElement result = new XElement(XName.Get(XATOM_DELETED_ENTRY, ATOMPUB_TOMBSTONES_NS),
                    new XAttribute(XATOM_DELETED_REF, de.Id.ToString()),
                    new XAttribute(XATOM_DELETED_WHEN, de.When));

            if( Util.UriHasValue(de.SelfLink) )
                result.Add(new XElement(XName.Get(XATOM_LINK, ATOMPUBNS),
                        new XAttribute(XATOM_LINK_REL, Util.ATOM_LINKREL_SELF),
                        new XAttribute(XATOM_LINK_HREF, de.SelfLink.ToString())));

            return result;
        }

        private XElement xmlCreateAuthor(string name, string uri)
        {
            var result = new XElement(XATOMNS + XATOM_AUTHOR);

            if( !String.IsNullOrEmpty(name) )
                result.Add( new XElement(XATOMNS + XATOM_AUTH_NAME, name));

            if( !String.IsNullOrEmpty(uri) )
                result.Add(new XElement(XATOMNS + XATOM_AUTH_URI, uri));

            return result;
        }

        private XElement xmlCreateContentEntry(ContentEntry entry)
        {
            //Note: this handles both BinaryEntry and ResourceEntry

            XElement result = new XElement(XATOMNS + XATOM_ENTRY);

            result.Add(xmlCreateTitle(entry.Title));
            if (Util.UriHasValue(entry.SelfLink))
                result.Add(xmlCreateLink(Util.ATOM_LINKREL_SELF,entry.SelfLink));
            result.Add(xmlCreateId(entry.Id));

            if (entry.LastUpdated != null) result.Add(new XElement(XATOMNS + XATOM_UPDATED, entry.LastUpdated.Value));
            if (entry.Published != null) result.Add(new XElement(XATOMNS + XATOM_PUBLISHED, entry.Published.Value));
            
            if (!String.IsNullOrWhiteSpace(entry.EntryAuthorName))
                   result.Add(xmlCreateAuthor(entry.EntryAuthorName, entry.EntryAuthorUri));
           

            if (entry is ResourceEntry)
            {
                ResourceEntry re = (ResourceEntry)entry;

                if (!String.IsNullOrWhiteSpace(re.ResourceType))
                    result.Add(xmlCreateCategory(re.ResourceType, ATOM_CATEGORY_RESOURCETYPE_NS));

                if (re.Content != null)
                    result.Add(new XElement(XATOMNS + XATOM_CONTENT,
                        new XAttribute("type", "text/xml"),
                        FhirSerializer.SerializeResourceAsXElement(re.Content)));
            }
            else if (entry is BinaryEntry)
            {
                BinaryEntry be = (BinaryEntry)entry;

                result.Add(xmlCreateCategory(XATOM_CONTENT_BINARY, ATOM_CATEGORY_RESOURCETYPE_NS));

                if (be.Content != null)
                    result.Add(new XElement(XATOMNS+XATOM_CONTENT,
                        new XAttribute("type", "text/xml"),
                        new XElement(XATOMNS+XATOM_CONTENT_BINARY,
                            new XAttribute(XATOM_CONTENT_TYPE, be.MediaType),
                            new XText(Convert.ToBase64String(be.Content)))));
            }
            else
                throw new NotSupportedException("Cannot serialize unknown entry type " + entry.GetType().Name);

            if (entry.Summary != null)
                result.Add(new XElement(XATOMNS + XATOM_SUMMARY,
                        new XAttribute("type", "xhtml"), XElement.Parse(entry.Summary)));

            return result;
        }


        private static UriLinkList getLinksFromSyndication( IEnumerable<SyndicationLink> links )
        {
            return new UriLinkList(links.Select(fl => new UriLinkEntry { Rel = fl.RelationshipType, Uri = fl.Uri }));
        }


        private static Resource getContents(SyndicationContent content, ErrorList errors)
        {
            string contents = getContentsFromSyndication(content, errors);
            return FhirParser.ParseResourceFromXml(contents, errors);
        }


        private static string getContentsFromSyndication(SyndicationContent content, ErrorList errors)
        {
            if (content.Type != "text/xml")
            {
                errors.Add("Entry should have contents of type 'text/xml'");
                return null;
            }

            // Sigh....why does this have to be hard? I don't WANT an extra
            // root element around the contents...
            StringWriter buffer = new StringWriter();
            content.WriteTo(new XmlTextWriter(buffer), "x", null);
            buffer.GetStringBuilder().Replace("<x type=\"text/xml\">", "");
            buffer.GetStringBuilder().Replace("</x>", "");

            return buffer.ToString();
        }
    }
}
