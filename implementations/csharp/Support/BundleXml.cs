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
                    LastUpdated = feed.LastUpdatedTime,
                    Id = new Uri(feed.Id, UriKind.Absolute),
                    SelfLink = getSelfLink(feed.Links),
                };
            }
            catch (Exception exc)
            {
                errors.Add("Exception while parsing feed items: " + exc.Message,
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
                        ext => ext.OuterName == "deleted-entry" && ext.OuterNamespace == ATOMPUB_TOMBSTONES_NS))
            {
                DeletedEntry de = new DeletedEntry();

                try
                {
                    errors.DefaultContext = "A deleted entry";

                   
                    XmlReader extensionReader = extension.GetReader();
                    XElement deletedExtension = (XElement)(XElement.ReadFrom(extensionReader));

                    XAttribute eTag = deletedExtension.Attribute(XName.Get(ETAG_LABEL, GDATA_NAMESPACE));
                    XAttribute when = deletedExtension.Attribute("when");
                    XAttribute id = deletedExtension.Attribute("ref");

                    XElement self = deletedExtension.Elements(XName.Get("link",ATOMPUBNS)).Where(el => el.Attribute("rel") != null &&
                                    el.Attribute("rel").Value == "self").FirstOrDefault();
   
                    if (eTag != null) de.VersionId = eTag.Value;
                    if (when != null) de.When = Instant.Parse(when.Value).Contents.Value;
                    if (id != null) de.Id = new Uri(id.Value, UriKind.RelativeOrAbsolute);
                    if (self != null && self.Attribute("href") != null ) 
                                de.SelfLink = new Uri(self.Attribute("href").Value, UriKind.Absolute);
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

                    if( getCategoryFromEntry(item) == "Binary" )
                        result = new BinaryEntry();
                    else
                        result = new ResourceEntry();

                    result.VersionId = item.AttributeExtensions.ContainsKey(ETAG) ?
                                item.AttributeExtensions[ETAG] : null;
                    result.Title = item.Title != null && !String.IsNullOrWhiteSpace(item.Title.Text) ?
                                    item.Title.Text : null;
                    result.SelfLink = getSelfLink(item.Links);
                    result.Id = new Uri(item.Id,UriKind.RelativeOrAbsolute);
                    result.LastUpdated = item.LastUpdatedTime;
                    result.Published = item.PublishDate;
                    result.AuthorName = item.Authors != null ?
                                 item.Authors.Select(auth => auth.Name).FirstOrDefault() : null;
                    result.AuthorUri = item.Authors != null ?
                                 item.Authors.Select(auth => auth.Uri).FirstOrDefault() : null;

                    if (result is ResourceEntry)
                    {
                        ((ResourceEntry)result).Content = getContents(item.Content, errors);
                    }
                    else
                    {
                        getBinaryContentsFromSyndication(item.Content, result, errors);
                    }
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

        private static void getBinaryContentsFromSyndication(SyndicationContent content, ContentEntry result, ErrorList errors)
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

            XAttribute contentType = binary.Attribute(XName.Get("contentType"));

            if (contentType != null)
                ((BinaryEntry)result).MimeType = contentType.Value;

            try
            {
                ((BinaryEntry)result).Content = Convert.FromBase64String(binary.FirstNode.ToString());
            }
            catch (Exception e)
            {
                errors.Add("Cannot parse content of Binary: " + e.Message);
            }
        }


        private string getCategoryFromEntry(SyndicationItem item)
        {
            return item.Categories != null ? item.Categories
                               .Where(cat => cat.Scheme == ATOM_CATEGORY_NAMESPACE)
                               .Select(scat => scat.Name).FirstOrDefault() : null;
        }


        public void Save(XmlWriter writer)
        {
            SyndicationFeed result = new SyndicationFeed();

            if( !String.IsNullOrWhiteSpace(Title) ) result.Title = new TextSyndicationContent(Title);
            if (LastUpdated != null) result.LastUpdatedTime = LastUpdated.Value;
            if (Util.UriHasValue(Id)) result.Id = Id.ToString();
            if (Util.UriHasValue(SelfLink))
                result.Links.Add(SyndicationLink.CreateSelfLink(SelfLink));

            result.Items = createContentItems();
            addDeletedItemsAsExtensions(result.ElementExtensions);
            
            result.SaveAsAtom10(writer);
        }


        private void addDeletedItemsAsExtensions(SyndicationElementExtensionCollection extensions)
        {
            foreach (BundleEntry entry in Entries.Where(be=>be is DeletedEntry))
            {
                DeletedEntry de = (DeletedEntry)entry;

                XElement extension = new XElement(XName.Get("deleted-entry", ATOMPUB_TOMBSTONES_NS),
                        new XAttribute("ref", de.Id.ToString()),
                        new XAttribute("when", de.When));

                if( Util.UriHasValue(de.SelfLink) )
                    extension.Add(new XElement(XName.Get("link", ATOMPUBNS),
                            new XAttribute("rel", "self"),
                            new XAttribute("href", de.SelfLink.ToString())));

                extensions.Add(extension);
            }
        }


        private IEnumerable<SyndicationItem> createContentItems()
        {
            List<SyndicationItem> result = new List<SyndicationItem>();

            foreach (BundleEntry entry in Entries.Where(be=>be is ContentEntry))
            {
                //Note: this handles both BinaryEntry and ResourceEntry

                SyndicationItem newItem = new SyndicationItem();
                ContentEntry ce = (ContentEntry)entry;

                newItem.Title = new TextSyndicationContent(ce.Title);
                if (Util.UriHasValue(SelfLink))
                    newItem.Links.Add(SyndicationLink.CreateSelfLink(entry.SelfLink));
                newItem.Id = entry.Id.ToString();

                if (ce.LastUpdated != null) newItem.LastUpdatedTime = ce.LastUpdated.Value;
                if (ce.Published != null) newItem.PublishDate = ce.Published.Value;

                if (!String.IsNullOrWhiteSpace(ce.AuthorName))
                    newItem.Authors.Add(new SyndicationPerson(null, ce.AuthorName, ce.AuthorUri));

                if (ce.Summary != null)
                    newItem.Summary = SyndicationContent.CreateXhtmlContent(ce.Summary);

                if (entry.VersionId != null)
                    newItem.AttributeExtensions.Add(ETAG, entry.VersionId);

                if (entry is ResourceEntry)
                {
                    ResourceEntry re = (ResourceEntry)entry;

                    if (!String.IsNullOrWhiteSpace(re.ResourceType))
                        newItem.Categories.Add(new SyndicationCategory(re.ResourceType, ATOM_CATEGORY_NAMESPACE, null));

                    if (re.Content != null)
                        newItem.Content = SyndicationContent.CreateXmlContent(getContentsReader(re.Content));
                }
                else if (entry is BinaryEntry)
                {
                    BinaryEntry be = (BinaryEntry)entry;

                    newItem.Categories.Add(new SyndicationCategory("Binary", ATOM_CATEGORY_NAMESPACE, null));

                    if (be.Content != null)
                    {
                        var xmlContent = XmlSyndicationContent.CreateXmlContent(
                            new XElement(XName.Get("Binary", Util.FHIRNS),
                                new XAttribute("contentType", be.MimeType),
                                new XText(Convert.ToBase64String(be.Content))));

                        newItem.Content = xmlContent;
                    }
                }

                result.Add(newItem);
            }
            
            return result;
        }


        private static Uri getSelfLink( IEnumerable<SyndicationLink> links )
        {
             //return links.
             //   Where(l => l.RelationshipType != null &&
             //       l.RelationshipType.ToLower() == "self" && l.Uri != null)
             //                     .Select(sl => sl.Uri).FirstOrDefault();

             return
                 (from link in links
                 where link.RelationshipType != null &&
                         link.RelationshipType.ToLower() == "self" &&
                         link.Uri != null
                 select link.Uri).FirstOrDefault();
        }


        private static Resource getContents(SyndicationContent content, ErrorList errors)
        {
            string contents = getContentsFromSyndication(content, errors);
            return ResourceParser.ParseResourceFromXml(contents, errors);
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

        private XmlReader getContentsReader(Resource r)
        {
            StringWriter buffer = new System.IO.StringWriter();
            XmlTextWriter writer = new XmlTextWriter(buffer);

            // Add wrapper root element, which will be skipped in the <content> element
            writer.WriteStartElement("x");
            r.Save(writer);
            writer.WriteEndElement();

            return XmlReader.Create(new StringReader(buffer.ToString()));
        }
    }
}
