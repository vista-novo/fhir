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
       
        public Bundle()
        {
            Entries = new List<BundleEntry>();
        }

        public static Bundle Load(XmlReader reader, ErrorList errors)
        {
            SyndicationFeed feed = SyndicationFeed.Load(reader);

            Bundle result = new Bundle()
                {
                    Title = feed.Title.Text,
                    LastUpdated = feed.LastUpdatedTime,
                    Id = feed.Id,
                    SelfLink = getSelfLink(feed.Links),
                };

            result.loadItems(feed.Items, errors);

            errors.AddRange(result.Validate());

            return result;
        }


        public ErrorList Validate()
        {
            ErrorList errors = new ErrorList();
            string context = String.Format("Feed '{0}'", Id);

            if( String.IsNullOrWhiteSpace(Title) )
                errors.Add("Feed must contain a title", context);

            if (String.IsNullOrWhiteSpace(Id))
                errors.Add("Feed must have an id", context);

            if (SelfLink == null || String.IsNullOrWhiteSpace(SelfLink.ToString()))
                errors.Add("Feed must have a link of type 'self'", context);

            Entries.ForEach(entry => errors.AddRange(entry.Validate()));

            return errors;
        }


        private void loadItems( IEnumerable<SyndicationItem> items, ErrorList errors )
        {
            Entries.Clear();

            foreach (SyndicationItem item in items)
            {
                errors.DefaultContext = String.Format("Entry '{0}'", item.Id);

                BundleEntry result = new BundleEntry()
                {
                    VersionId = item.AttributeExtensions.ContainsKey(ETAG) ?
                            item.AttributeExtensions[ETAG] : null,
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
                    Content = getContents(item.Content, errors),
                    Summary = item.Summary.Text
                };


                errors.DefaultContext = null;

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


        private const string GDATA_NAMESPACE = "http://schemas.google.com/g/2005";
        private const string ETAG_LABEL = "etag";
        private readonly XmlQualifiedName ETAG = new XmlQualifiedName(ETAG_LABEL, GDATA_NAMESPACE);

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
                newItem.Content = SyndicationContent.CreateXmlContent(getContentsReader(entry.Content));
                newItem.Summary = SyndicationContent.CreateXhtmlContent(entry.Summary);

                if( entry.VersionId != null)
                    newItem.AttributeExtensions.Add(ETAG, entry.VersionId);

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
            if (content.Type != "text/xml")
            {
                errors.Add("Entry should have contents of type 'text/xml'");
                return null;
            }

            // Sigh....why does this have to be hard? I don't WANT an extra
            // root element around the contents...
            StringWriter buffer = new StringWriter();
            content.WriteTo(new XmlTextWriter(buffer),"x", null);
            buffer.GetStringBuilder().Replace("<x type=\"text/xml\">", "");
            buffer.GetStringBuilder().Replace("</x>","");
            return ResourceParser.ParseResourceFromXml(buffer.ToString(), errors);
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


    public class BundleEntry
    {
        public string VersionId { get; set; }
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
