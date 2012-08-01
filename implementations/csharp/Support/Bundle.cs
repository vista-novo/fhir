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
    public class Bundle
    {
        public string Title { get; set; }
        public DateTimeOffset LastUpdated { get; set; }
        public string Id { get; set; }
        public Uri SelfLink { get; set; }

        public List<BundleEntry> Entries { get; private set; }

        public ErrorList Errors { get; private set; }
       

        public Bundle()
        {
            Errors = new ErrorList();
            Entries = new List<BundleEntry>();
        }

        public static Bundle Load(XmlReader reader)
        {
            SyndicationFeed feed = SyndicationFeed.Load(reader);

            Bundle result = new Bundle()
                {
                    Title = feed.Title.Text,
                    LastUpdated = feed.LastUpdatedTime,
                    Id = feed.Id,
                    SelfLink = getSelfLink(feed.Links),
                };

            result.loadItems(feed.Items);

            return result;
        }


        private void loadItems( IEnumerable<SyndicationItem> items )
        {
            Entries.Clear();

            foreach (SyndicationItem item in items)
            {
                Errors.DefaultContext = String.Format("Entry '{0}'", item.Id);

                BundleEntry result = new BundleEntry()
                {
                    Title = item.Title.Text,
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
                    Content = getContents(item.Content, Errors),
                    Summary = item.Summary.Text
                };


                Errors.DefaultContext = null;

                Entries.Add(result);
            }
        }


        public void Save(XmlWriter writer)
        {
            SyndicationFeed result = new SyndicationFeed();

            result.Title = new TextSyndicationContent(Title);
            result.LastUpdatedTime = LastUpdated;
            result.Id = Id;
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
                newItem.Links.Add(SyndicationLink.CreateSelfLink(entry.SelfLink));
                newItem.Id = entry.Id;
                newItem.LastUpdatedTime = entry.LastUpdated;
                newItem.PublishDate = entry.Published;
                newItem.Authors.Add(new SyndicationPerson(null, entry.AuthorName, entry.AuthorUri));
                newItem.Categories.Add(new SyndicationCategory(entry.ResourceType, Util.ATOM_CATEGORY_NAMESPACE, null));
                newItem.Content = SyndicationContent.CreateXmlContent(getContents(entry.Content));
                newItem.Summary = SyndicationContent.CreateXhtmlContent(entry.Summary);

                result.Add(newItem);
            }

            return result;
        }



        private static Uri getSelfLink( IEnumerable<SyndicationLink> links )
        {
             return links.
                Where(l => l.RelationshipType != null &&
                    l.RelationshipType.ToLower() == "self" && l.Uri != null)
                                  .Select(sl => sl.Uri).FirstOrDefault();
        }

        private static Resource getContents(SyndicationContent content, ErrorList errors)
        {
            if (content.Type != "text/xml") return null;

            System.ServiceModel.Syndication.XmlSyndicationContent xmlcontent =
                    (XmlSyndicationContent)content;

            // WARNING! In .NET 4.5, the XmlReader returned by GetReaderAtContent()
            // reads the initial element twice if you wrap it in another XmlReader.
            // Hence, I do a clean ex- and import of the xml. This is time and
            // memory consuming, but is a necessary work-around as far as I can see.
            string contentAsString = xmlcontent.GetReaderAtContent().ReadInnerXml();
            return ResourceParser.ParseResourceFromXml(contentAsString, errors);
        }

        private XmlReader getContents(Resource r)
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


    public class BundleEntry
    {
        public string Title { get; set; }
        public Uri SelfLink { get; set; }
        public string Id { get; set; }
        public DateTimeOffset LastUpdated { get; set; }
        public DateTimeOffset Published { get; set; }
        public string AuthorName { get; set; }
        public string AuthorUri { get; set; }
        public string ResourceType { get; set; }

        public Resource Content { get; set; }

        public string Summary { get; set; } 
    }
}
