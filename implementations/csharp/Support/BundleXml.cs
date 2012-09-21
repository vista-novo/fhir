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
                    Id = feed.Id,
                    SelfLink = getSelfLink(feed.Links),
                };
            }
            catch (Exception exc)
            {
                errors.Add("Exception while parsing feed items: " + exc.Message,
                    String.Format("Feed '{0}'", feed.Id) );
                return null;
            }

            result.loadItems(feed.Items, errors);

            errors.AddRange(result.Validate());

            return result;
        }


        private void loadItems( IEnumerable<SyndicationItem> items, ErrorList errors )
        {
            Entries.Clear();

            foreach (SyndicationItem item in items)
            {       
                BundleEntry result;

                try
                {
                    errors.DefaultContext = String.Format("Entry '{0}'", item.Id);

                    result = new BundleEntry()
                    {
                        VersionId = item.AttributeExtensions.ContainsKey(ETAG) ?
                                item.AttributeExtensions[ETAG] : null,
                        Title = item.Title != null && !String.IsNullOrWhiteSpace(item.Title.Text) ?
                                    item.Title.Text : null,
                        SelfLink = getSelfLink(item.Links),
                        Id = item.Id,
                        LastUpdated = item.LastUpdatedTime,
                        Published = item.PublishDate,
                        AuthorName = item.Authors != null ?
                                 item.Authors.Select(auth => auth.Name).FirstOrDefault() : null,
                        AuthorUri = item.Authors != null ?
                                 item.Authors.Select(auth => auth.Uri).FirstOrDefault() : null,
                        ResourceType = item.Categories != null ? item.Categories
                               .Where(cat => cat.Scheme == Support.Util.ATOM_CATEGORY_NAMESPACE)
                               .Select(scat => scat.Name).FirstOrDefault() : null,
                        IsDeletion = isDeletion(item.Content,errors),
                    };

                    if (!result.IsDeletion)
                        result.Content = getContents(item.Content, errors);

                }
                catch (Exception exc)
                {
                    errors.Add( "Exception while reading entry: " + exc.Message );
                    return;
                }
                finally
                {
                    errors.DefaultContext = null;
                }

                Entries.Add(result);
            }
        }

        private bool isDeletion(SyndicationContent content, ErrorList errors)
        {
            string contents = getContentsFromSyndication(content,errors);

            var contentsXml = XElement.Parse(contents);

            if (contentsXml.Name.LocalName == "Deleted" &&
                contentsXml.Name.NamespaceName == Util.FHIRNS)
                return true;
            else
                return false;
        }


        public void Save(XmlWriter writer)
        {
            SyndicationFeed result = new SyndicationFeed();

            if( !String.IsNullOrWhiteSpace(Title) ) result.Title = new TextSyndicationContent(Title);
            if (LastUpdated != null) result.LastUpdatedTime = LastUpdated.Value;
            if( !String.IsNullOrWhiteSpace(Id) ) result.Id = Id;
            if( SelfLink != null && !String.IsNullOrWhiteSpace(SelfLink.ToString()) )
                result.Links.Add(SyndicationLink.CreateSelfLink(SelfLink));

            result.Items = saveItems();

            result.SaveAsAtom10(writer);
        }


        private IEnumerable<SyndicationItem> saveItems()
        {
            List<SyndicationItem> result = new List<SyndicationItem>();

            foreach (BundleEntry entry in Entries)
            {
                SyndicationItem newItem = new SyndicationItem();

                newItem.Title = new TextSyndicationContent(entry.Title);
                if( entry.SelfLink!= null && !String.IsNullOrWhiteSpace(entry.SelfLink.ToString()))
                    newItem.Links.Add(SyndicationLink.CreateSelfLink(entry.SelfLink));
                newItem.Id = entry.Id;
                if (entry.LastUpdated != null) newItem.LastUpdatedTime = entry.LastUpdated.Value;
                if (entry.Published != null) newItem.PublishDate = entry.Published.Value;

                if( !String.IsNullOrWhiteSpace(entry.AuthorName) )
                    newItem.Authors.Add(new SyndicationPerson(null, entry.AuthorName, entry.AuthorUri));
                
                if( !String.IsNullOrWhiteSpace(entry.ResourceType) )
                    newItem.Categories.Add(new SyndicationCategory(entry.ResourceType, Util.ATOM_CATEGORY_NAMESPACE, null));

                if (entry.IsDeletion)
                    newItem.Content = getDeletedSyndicationContent();
                else
                {
                    if(entry.Content != null )
                        newItem.Content = SyndicationContent.CreateXmlContent(getContentsReader(entry.Content));
                }

                if( entry.Summary != null )
                    newItem.Summary = SyndicationContent.CreateXhtmlContent(entry.Summary);

                if( entry.VersionId != null)
                    newItem.AttributeExtensions.Add(ETAG, entry.VersionId);

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


        private static SyndicationContent getDeletedSyndicationContent()
        {
            string deleted = "<x>" + GetDeletedContentsAsXml() + "</x>";
            XmlReader r = XmlReader.Create(new StringReader(deleted));
            return SyndicationContent.CreateXmlContent(r);
        }

        public static string GetDeletedContentsAsXml()
        {
            return String.Format("<Deleted xmlns='{0}' />", Util.FHIRNS);
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
