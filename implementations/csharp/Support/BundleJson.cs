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
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace HL7.Fhir.Instance.Support
{
    public partial class Bundle
    {
        public const string JATOM_TITLE = "title";
        public const string JATOM_UPDATED = "updated";
        public const string JATOM_ID = "id";
        public const string JATOM_LINK = "link";
        public const string JATOM_ENTRY = "entry";
        public const string JATOM_PUBLISHED = "published";
        public const string JATOM_AUTHOR = "author";
        public const string JATOM_AUTH_NAME = "name";
        public const string JATOM_AUTH_URI = "uri";
        public const string JATOM_CATEGORY = "category";
        public const string JATOM_CAT_TERM = "term";
        public const string JATOM_CAT_SCHEME = "scheme";
        public const string JATOM_CONTENT = "content";
        public const string JATOM_SUMMARY = "summary";
        public const string JATOM_VERSION = "version";
        public const string JATOM_DELETED = "deleted";

        public static Bundle Load(JsonReader reader, ErrorList errors)
        {
            return null;

            //JObject feed;
            //reader.DateParseHandling = DateParseHandling.DateTimeOffset;

            //try
            //{
            //    feed = JObject.Load(reader);
            //}
            //catch (Exception exc)
            //{
            //    errors.Add("Exception while loading feed: " + exc.Message);
            //    return null;
            //}

            //Bundle result;

            //try
            //{
            //    result = new Bundle()
            //    {
            //        Title = feed.Value<string>(JATOM_TITLE),
            //        LastUpdated = feed.Value<DateTimeOffset>(JATOM_UPDATED),
            //        Id = feed.Value<string>(JATOM_ID),
            //        SelfLink = getSelfLink(feed[JATOM_LINKS])
            //    };
            //}
            //catch (Exception exc)
            //{
            //    errors.Add("Exception while parsing feed items: " + exc.Message,
            //        String.Format("Feed '{0}'", feed.Value<string>(JATOM_ID)));
            //    return null;
            //}

            //result.loadItems(feed[JATOM_ENTRIES], errors);

            //errors.AddRange(result.Validate());

            //return result;
        }


        private void loadItems( JToken token, ErrorList errors )
        {
            //Entries.Clear();

            //if( token as JArray != null )
            //{
            //    JArray items = (JArray)token;

            //    foreach(var item in items)
            //    {
            //        BundleEntry result;

            //        string id = item.Value<string>(JATOM_ID);
            //        errors.DefaultContext = String.Format("Entry '{0}'", id);

            //        try
            //        {
            //            result = new BundleEntry()
            //            {
            //                VersionId = item.Value<string>(JATOM_VERSION) != null ?
            //                                 item.Value<string>(JATOM_VERSION) : null,
            //                Title = item.Value<string>(JATOM_TITLE),
            //                SelfLink = getSelfLink(item[JATOM_LINKS]),
            //                Id = id,
            //                LastUpdated = item.Value<DateTimeOffset>(JATOM_UPDATED),
            //                Published = item.Value<DateTimeOffset>(JATOM_PUBLISHED),

            //                AuthorName = item[JATOM_AUTHORS] as JArray != null ? item[JATOM_AUTHORS]
            //                        .Select(auth => auth.Value<string>(JATOM_AUTH_NAME))
            //                        .FirstOrDefault() : null,
            //                AuthorUri = item[JATOM_AUTHORS] as JArray != null ? item[JATOM_AUTHORS]
            //                        .Select(auth => auth.Value<string>(JATOM_AUTH_URI))
            //                        .FirstOrDefault() : null,

            //                ResourceType = item[JATOM_CATEGORIES] as JArray != null ? item[JATOM_CATEGORIES]
            //                        .Where(cat => cat.Value<string>(JATOM_CAT_SCHEME) ==
            //                                        Support.Util.ATOM_CATEGORY_NAMESPACE)
            //                        .Select(scat => scat.Value<string>(JATOM_CAT_TERM))
            //                        .FirstOrDefault() : null,
            //                IsDeletion = isDeletion(item[JATOM_CONTENT]),
            //            };

            //            if (!result.IsDeletion)
            //                result.Content = getContents(item[JATOM_CONTENT], errors);

            //        }
            //        catch (Exception exc)
            //        {
            //            errors.Add("Exception while reading entry: " + exc.Message);
            //            return;
            //        }
            //        finally
            //        {
            //            errors.DefaultContext = null;
            //        }

            //        Entries.Add(result);
            //    }
            //}
        }


        private static Resource getContents(JToken token, ErrorList errors)
        {
            //TODO: This is quite inefficient. The Json parser has just parsed this
            //entry's Resource from json, now we are going to serialize it to as string
            //just to read from it again using a JsonTextReader. But that is what my
            //parser takes as input, so no choice for now...
            string contents = token.ToString();
            JsonTextReader r = new JsonTextReader(new StringReader(contents));
            return ResourceParser.ParseResource( new JsonFhirReader(r), errors);
        }


        public void Save(JsonWriter writer)
        {
            JObject result = new JObject();

            if (!String.IsNullOrWhiteSpace(Title))
                result.Add(new JProperty(JATOM_TITLE, Title));

            if (LastUpdated != null) result.Add(new JProperty(JATOM_UPDATED, LastUpdated));
            if (Util.UriHasValue(Id)) result.Add(new JProperty(JATOM_ID, Id));
            if (Util.UriHasValue(SelfLink))
                result.Add(new JProperty(JATOM_LINK, new JArray(createSelfLink(SelfLink))));

            var entries = createContentEntries().Concat(createDeletedEntries());

            result.Add(new JProperty(JATOM_ENTRY, new JArray(entries)));

            result.WriteTo(writer);
        }

        private JObject createSelfLink(Uri selfLink)
        {
            return new JObject(
                new JProperty(XATOM_LINK_REL, XATOM_LINK_SELF),
                new JProperty(XATOM_LINK_HREF, selfLink.ToString()));
        }


        private IEnumerable<JObject> createDeletedEntries()
        {
            List<JObject> result = new List<JObject>();

            foreach (BundleEntry entry in Entries.Where(be => be is DeletedEntry))
            {
                JObject newItem = new JObject();
                DeletedEntry de = (DeletedEntry)entry;

                newItem.Add(new JProperty(JATOM_DELETED, de.When));
                newItem.Add(new JProperty(JATOM_ID, de.Id.ToString()));

                if (Util.UriHasValue(de.SelfLink))
                    newItem.Add(new JProperty(JATOM_LINK, new JArray(createSelfLink(de.SelfLink))));

                result.Add(newItem);
            }

            return result;
        }


        private IEnumerable<JObject> createContentEntries()
        {
            List<JObject> result = new List<JObject>();

            foreach (BundleEntry entry in Entries.Where(be => be is ContentEntry))
            {
                //Note: this handles both BinaryEntry and ResourceEntry

                ContentEntry ce = (ContentEntry)entry;
                JObject newItem = new JObject();

                if (!String.IsNullOrWhiteSpace(ce.Title)) newItem.Add(new JProperty(JATOM_TITLE, ce.Title));
                if (Util.UriHasValue(ce.SelfLink))
                    newItem.Add(new JProperty(JATOM_LINK, new JArray(createSelfLink(ce.SelfLink))));
                if (Util.UriHasValue(ce.Id)) newItem.Add(new JProperty(JATOM_ID, ce.Id.ToString()));
                
                if (ce.LastUpdated != null) newItem.Add(new JProperty(JATOM_UPDATED, ce.LastUpdated));
                if (ce.Published != null) newItem.Add(new JProperty(JATOM_PUBLISHED, ce.Published));
                
                if (!String.IsNullOrWhiteSpace(ce.AuthorName))
                {
                    JObject author = new JObject(new JProperty(JATOM_AUTH_NAME, ce.AuthorName));
                    if (!String.IsNullOrWhiteSpace(ce.AuthorUri))
                        author.Add(new JProperty(JATOM_AUTH_URI, ce.AuthorUri));

                    newItem.Add(new JProperty(JATOM_AUTHOR, new JArray(author)));
                }

                if (entry.Summary != null)
                    newItem.Add(new JProperty(JATOM_SUMMARY, entry.Summary));

                if (entry.VersionId != null)
                    newItem.Add(new JProperty(JATOM_VERSION, entry.VersionId));

                if(entry is ResourceEntry)
                {
                    ResourceEntry re = (ResourceEntry)entry;
                
                    if (!String.IsNullOrWhiteSpace(re.ResourceType))
                        newItem.Add(new JProperty(JATOM_CATEGORY, new JArray(createCategory(re.ResourceType))));

                    if (re.Content != null)
                        newItem.Add(new JProperty(JATOM_CONTENT, getContentsAsJObject(re.Content)));
                }
                else if(entry is BinaryEntry)
                {
                    BinaryEntry be = (BinaryEntry)entry;

                    newItem.Add(new JProperty(JATOM_CATEGORY, new JArray(createCategory(XATOM_CONTENT_BINARY))));

                    if (be.Content != null)
                    {
                        newItem.Add(new JProperty(JATOM_CONTENT, new JObject(
                                new JProperty( XATOM_CONTENT_BINARY, new JObject(
                                    new JProperty( XATOM_CONTENT_TYPE, be.MimeType ),
                                    new JProperty( JATOM_CONTENT, Convert.ToBase64String(be.Content)) ) ) ) ));
                    }
                }
                else
                    throw new NotSupportedException("Cannot serialize unknown entry type " + entry.GetType().Name);

                result.Add(newItem);
            }

            return result;
        }

        private static JObject createCategory(string category)
        {
            return new JObject( new JProperty(JATOM_CAT_TERM, category),
                                new JProperty(JATOM_CAT_SCHEME, ATOM_CATEGORY_NAMESPACE));
        }


        private JObject getContentsAsJObject(Resource resource)
        {
            StringWriter w = new StringWriter();

            //TODO: This would be much more efficient if we could serialize
            //the resource to a JObject directly
            resource.Save(new JsonTextWriter(w));

            JsonTextReader reader = new JsonTextReader(new StringReader(w.ToString()));
            reader.DateParseHandling = DateParseHandling.None;
            return JObject.Load(reader);
        }



        private static Uri getSelfLink( JToken token )
        {
            if (token as JArray != null)
            {
                JArray links = (JArray)token;

                 return new Uri((from link in links
                 where link.Value<string>("rel") != null &&
                         link.Value<string>("rel").ToLower() == "self" &&
                         link.Value<string>("href") != null
                 select link.Value<string>("href")).FirstOrDefault());
            }
            else
                return null;
        }
    }
}
