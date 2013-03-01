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
using Hl7.Fhir.Model;
using System.Xml.Linq;
using Hl7.Fhir.Parsers;
using System.IO;
using Hl7.Fhir.Serializers;

namespace Hl7.Fhir.Support
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
        public const string XATOM_CONTENT_TYPE = "type";
        public const string XATOM_CONTENT_BINARY_TYPE = "contentType";
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

        private static readonly XNamespace XATOMNS = ATOMPUBNS;
        private static readonly XNamespace XTOMBSTONE = ATOMPUB_TOMBSTONES_NS;
        private static readonly XNamespace XFHIRNS = Util.FHIRNS;

        private static string xValue(XObject elem)
        {
            if (elem == null) return null;

            if (elem is XElement)
                return (elem as XElement).Value;
            if (elem is XAttribute)
                return (elem as XAttribute).Value;

            return null;
        }

        private static string stringValueOrNull(XObject elem)
        {
            string value = xValue(elem);

            return String.IsNullOrEmpty(value) ? null : value;
        }


        private static Uri uriValueOrNull(XObject elem)
        {
            string value = stringValueOrNull(elem);

            return value != null ? new Uri(value) : null;
        }

        public static DateTimeOffset? dateTimeOrNull(XElement elem)
        {
            string value = stringValueOrNull(elem);

            return value != null ?
                Util.ParseIsoDateTime(value) : (DateTimeOffset?)null;
        }

        public static Bundle Load(XmlReader reader, ErrorList errors)
        {
            XElement feed;

            try
            {
                feed = XDocument.Load(reader).Root;
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
                    Title = stringValueOrNull(feed.Element(XATOMNS + XATOM_TITLE)),
                    LastUpdated = dateTimeOrNull(feed.Element(XATOMNS + XATOM_UPDATED)),
                    Id = uriValueOrNull(feed.Element(XATOMNS + XATOM_ID)),
                    Links = getLinksFromSyndication(feed.Elements(XATOMNS+XATOM_LINK)),
                    AuthorName = feed.Elements(XATOMNS+XATOM_AUTHOR).Count() == 0 ? null :
                            stringValueOrNull(feed.Element(XATOMNS+XATOM_AUTHOR)
                                .Element(XATOMNS+XATOM_AUTH_NAME)),
                    AuthorUri = feed.Elements(XATOMNS + XATOM_AUTHOR).Count() == 0 ? null :
                            stringValueOrNull(feed.Element(XATOMNS+XATOM_AUTHOR)
                                .Element(XATOMNS + XATOM_AUTH_URI))
                };
            }
            catch (Exception exc)
            {
                errors.Add("Exception while parsing feed attributes: " + exc.Message,
                    String.Format("Feed '{0}'", feed.Element(XATOMNS + XATOM_ID).Value) );
                return null;
            }

            result.Entries.Clear();
            result.Entries.AddRange( loadEntries( feed.Elements().Where(elem=>
                        (elem.Name == XATOMNS+XATOM_ENTRY ||
                         elem.Name == XTOMBSTONE+XATOM_DELETED_ENTRY)), errors ));

            errors.AddRange(result.Validate());

            return result;
        }

        private static IEnumerable<BundleEntry> loadEntries(IEnumerable<XElement> entries, ErrorList errors)
        {
            return entries.Select(entry =>
                        {
                            if (entry.Name == XATOMNS + XATOM_ENTRY)
                                return (BundleEntry)loadContentItem(entry, errors);
                            if (entry.Name == XTOMBSTONE + XATOM_DELETED_ENTRY)
                                return (BundleEntry)loadDeletedItem(entry, errors);

                            return (BundleEntry)null;
                        });
        }


        public static Bundle LoadFromXml(string xml, ErrorList errors)
        {
            return Bundle.Load(Util.XmlReaderFromString(xml), errors);
        }

        private static DeletedEntry loadDeletedItem(XElement item, ErrorList errors)
        {
            DeletedEntry de = new DeletedEntry();

            try
            {
                errors.DefaultContext = "A deleted entry";

                string id = Bundle.stringValueOrNull(item.Attribute(XATOM_DELETED_REF));
                if (id != null) de.Id = new Uri(id, UriKind.Absolute);
                if (id != null) errors.DefaultContext = String.Format("Entry '{0}'", id);

                string when = Bundle.stringValueOrNull(item.Attribute(XATOM_DELETED_WHEN));
                if (when != null) de.When = Instant.Parse(when).Contents.Value;

                var links = Bundle.getLinksFromSyndication(item.Elements(XATOMNS + XATOM_LINK));
                de.SelfLink = links.SelfLink;
            }
            catch (Exception exc)
            {
                errors.Add("Exception while reading deleted-entry: " + exc.Message);
                return null;
            }
            finally
            {
                errors.DefaultContext = null;
            }

            return de;
        }


        private static ContentEntry loadContentItem( XElement item, ErrorList errors )
        {
            ContentEntry result;

            try
            {
                if( getCategoryFromEntry(item) == XATOM_CONTENT_BINARY )
                    result = new BinaryEntry();
                else
                    result = new ResourceEntry();

                result.Id = uriValueOrNull(item.Element(XATOMNS + XATOM_ID));
                errors.DefaultContext = String.Format("Entry '{0}'", result.Id.ToString());

                result.Title = stringValueOrNull(item.Element(XATOMNS+XATOM_TITLE));
                result.SelfLink = getLinksFromSyndication(item.Elements(XATOMNS + XATOM_LINK)).SelfLink;
                result.LastUpdated = dateTimeOrNull(item.Element(XATOMNS + XATOM_UPDATED));
                result.Published = dateTimeOrNull(item.Element(XATOMNS + XATOM_PUBLISHED)); 
                result.EntryAuthorName = item.Elements(XATOMNS+XATOM_AUTHOR).Count() == 0 ? null :
                            stringValueOrNull(item.Element(XATOMNS+XATOM_AUTHOR)
                                .Element(XATOMNS+XATOM_AUTH_NAME));
                result.EntryAuthorUri = item.Elements(XATOMNS + XATOM_AUTHOR).Count() == 0 ? null :
                            stringValueOrNull(item.Element(XATOMNS + XATOM_AUTHOR)
                                .Element(XATOMNS + XATOM_AUTH_URI));

                XElement content = item.Element(XATOMNS+XATOM_CONTENT);
                if (content != null)
                {
                    if (result is ResourceEntry)
                        ((ResourceEntry)result).Content = getContents(content, errors);
                    else
                    {
                        BinaryEntry be = (BinaryEntry)result;
                        be.Content = getBinaryContents(content, out be.MediaType, errors);
                    }
                }
            }
            catch (Exception exc)
            {
                errors.Add("Exception while reading entry: " + exc.Message);
                return null;
            }
            finally
            {
                errors.DefaultContext = null;
            }

            return result;
        }

        private static byte[] getBinaryContents(XElement content, out string mediaType, ErrorList errors)
        {
            var contentType = stringValueOrNull(content.Attribute(XATOM_CONTENT_TYPE));
            mediaType = null;

            if (contentType != "text/xml")
            {
                errors.Add("Binary entries should be contained in content elements of type text/xml");
                return null;
            }

            XElement binary = content.Element(XFHIRNS + XATOM_CONTENT_BINARY);

            if (binary == null)
            {
                errors.Add("Binary entries must contain an element Binary");
                return null;
            }

            mediaType = stringValueOrNull(binary.Attribute(XATOM_CONTENT_BINARY_TYPE));

            if (mediaType == null)
            {
                errors.Add("Binary entries must contain a Binary element with a contentType attribute");
                return null;
            }

            try
            {
                return Convert.FromBase64String(binary.Value);
            }
            catch (Exception e)
            {
                errors.Add("Cannot parse content of Binary: " + e.Message);
                return null;
            }
        }


        private static string getCategoryFromEntry(XElement item)
        {
            return item.Elements(XATOMNS + XATOM_CATEGORY).Count() == 0 ? null :
                item.Elements(XATOMNS + XATOM_CATEGORY)
                    .Where(cat => stringValueOrNull(cat.Attribute(XATOM_CAT_SCHEME))
                        == ATOM_CATEGORY_RESOURCETYPE_NS)
                    .Select(scat => stringValueOrNull(scat.Attribute(XATOM_CAT_TERM)))
                    .FirstOrDefault();
        }

        private static UriLinkList getLinksFromSyndication(IEnumerable<XElement> links)
        {
            return new UriLinkList(
                links.Select(el => new UriLinkEntry
                {
                    Rel = stringValueOrNull(el.Attribute(XATOM_LINK_REL)),
                    Uri = uriValueOrNull(el.Attribute(XATOM_LINK_HREF))
                }));
        }


        private static Resource getContents(XElement content, ErrorList errors)
        {
            string contentType = stringValueOrNull(content.Attribute(XATOM_CONTENT_TYPE));

            if (contentType != "text/xml")
            {
                errors.Add("Entry should have contents of type 'text/xml'");
                return null;
            }

            return FhirParser.ParseResourceFromXml(content.FirstNode.ToString(), errors);
        }

        public void Save(XmlWriter writer)
        {
            var root = new XElement(XATOMNS+XATOM_FEED);

            if (!String.IsNullOrWhiteSpace(Title)) root.Add(xmlCreateTitle(Title));
            if (Util.UriHasValue(Id)) root.Add(xmlCreateId(Id));
            if (LastUpdated != null) root.Add(new XElement(XATOMNS+XATOM_UPDATED, LastUpdated));
            if (Links.Count > 0)
            {
                foreach(var l in Links)
                    root.Add(xmlCreateLink(l.Rel, l.Uri));
            }
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

        public string ToXml()
        {
            //Note: this will always carry UTF-16 coding in the <?xml> header
            StringBuilder sb = new StringBuilder();
            XmlWriter xw = XmlWriter.Create(sb);
            Save(xw);
            xw.Flush();

#if !NETFX_CORE
            xw.Close();
#endif

            return sb.ToString();
        }


        public byte[] ToXmlBytes()
        {
            MemoryStream stream = new MemoryStream();
            XmlWriterSettings settings = new XmlWriterSettings { Encoding = Encoding.UTF8 };
            XmlWriter xw = XmlWriter.Create(stream, settings);
            Save(xw);
            xw.Flush();

#if !NETFX_CORE 
            xw.Close();
#endif

            return stream.ToArray();
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
            return new XElement(XATOMNS + XATOM_TITLE, new XAttribute(XATOM_CONTENT_TYPE, "text"), title);
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
            XElement result = new XElement(XTOMBSTONE+XATOM_DELETED_ENTRY,
                    new XAttribute(XATOM_DELETED_REF, de.Id.ToString()),
                    new XAttribute(XATOM_DELETED_WHEN, de.When));

            if( Util.UriHasValue(de.SelfLink) )
                result.Add(new XElement(XATOMNS+XATOM_LINK,
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
                        new XAttribute(XATOM_CONTENT_TYPE, "text/xml"),
                        FhirSerializer.SerializeResourceAsXElement(re.Content)));
            }
            else if (entry is BinaryEntry)
            {
                BinaryEntry be = (BinaryEntry)entry;

                result.Add(xmlCreateCategory(XATOM_CONTENT_BINARY, ATOM_CATEGORY_RESOURCETYPE_NS));

                if (be.Content != null)
                    result.Add(new XElement(XATOMNS+XATOM_CONTENT,
                        new XAttribute(XATOM_CONTENT_TYPE, "text/xml"),
                        new XElement(XFHIRNS+XATOM_CONTENT_BINARY,
                            new XAttribute(XATOM_CONTENT_BINARY_TYPE, be.MediaType),
                            new XText(Convert.ToBase64String(be.Content)))));
            }
            else
                throw new NotSupportedException("Cannot serialize unknown entry type " + entry.GetType().Name);

            if (entry.Summary != null)
                result.Add(new XElement(XATOMNS + XATOM_SUMMARY,
                        new XAttribute(XATOM_CONTENT_TYPE, "xhtml"), XElement.Parse(entry.Summary)));

            return result;
        }
    }
}
