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
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace Hl7.Fhir.Support
{
    public partial class Bundle
    {
        public const string JATOM_VERSION = "version";
        public const string JATOM_DELETED = "deleted";

        public static Bundle Load(JsonReader reader, ErrorList errors)
        {
            JObject feed;
            reader.DateParseHandling = DateParseHandling.DateTimeOffset;

            try
            {
                feed = JObject.Load(reader);
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
                    Title = feed.Value<string>(XATOM_TITLE),
                    LastUpdated = feed.Value<DateTimeOffset?>(XATOM_UPDATED),
                    Id = new Uri(feed.Value<string>(XATOM_ID), UriKind.Absolute),
                    AuthorName = feed[XATOM_AUTHOR] as JArray != null ? feed[XATOM_AUTHOR]
                                    .Select(auth => auth.Value<string>(XATOM_AUTH_NAME))
                                    .FirstOrDefault() : null,
                    AuthorUri = feed[XATOM_AUTHOR] as JArray != null ? feed[XATOM_AUTHOR]
                                    .Select(auth => auth.Value<string>(XATOM_AUTH_URI))
                                    .FirstOrDefault() : null,
                    TotalResults = Int32.Parse(feed.Value<string>(XATOM_TOTALRESULTS))
                };

                result.Links = new UriLinkList();
                result.Links.AddRange( getLinks(feed[XATOM_LINK]) );
            }
            catch (Exception exc)
            {
                errors.Add("Exception while parsing feed attributes: " + exc.Message,
                    String.Format("Feed '{0}'", feed.Value<string>(XATOM_ID)));
                return null;
            }

            if( feed[XATOM_ENTRY] != null )
                result.Entries = result.loadItems(feed[XATOM_ENTRY], errors);

            errors.AddRange(result.Validate());

            return result;
        }

        public static Bundle LoadFromJson(string json, ErrorList errors)
        {
            return Bundle.Load(Util.JsonReaderFromString(json), errors);
        }


        private ManagedEntryList loadItems( JToken token, ErrorList errors )
        {
            var result = new ManagedEntryList(this);

            JArray items = (JArray)token;

            foreach (var item in items)
            {
                result.Add(loadEntry(item, errors));
            }

            return result;
        }

        private BundleEntry loadEntry(JToken entry, ErrorList errors)
        {
            BundleEntry result;

            errors.DefaultContext = "An atom entry";

            string id = entry.Value<string>(XATOM_ID);
            if (id != null)
                errors.DefaultContext = String.Format("Entry '{0}'", id);

            try
            {
                string category = getCategoryFromEntry(entry);

                if (entry.Value<DateTimeOffset?>(JATOM_DELETED) != null)
                    result = new DeletedEntry();
                else if (category == XATOM_CONTENT_BINARY)
                    result = new BinaryEntry();
                else
                    result = new ResourceEntry();

                result.Id = new Uri(id, UriKind.Absolute);

                result.Links = new UriLinkList();
                result.Links.AddRange(getLinks(entry[XATOM_LINK]));


                if (result is DeletedEntry)
                    ((DeletedEntry)result).When = entry.Value<DateTimeOffset>(JATOM_DELETED);
                else
                {
                    ContentEntry ce = (ContentEntry)result;

                    ce.Title = entry.Value<string>(XATOM_TITLE);
                    ce.LastUpdated = entry.Value<DateTimeOffset?>(XATOM_UPDATED);
                    ce.Published = entry.Value<DateTimeOffset?>(XATOM_PUBLISHED);
                    ce.EntryAuthorName = entry[XATOM_AUTHOR] as JArray != null ? entry[XATOM_AUTHOR]
                            .Select(auth => auth.Value<string>(XATOM_AUTH_NAME))
                            .FirstOrDefault() : null;
                    ce.EntryAuthorUri = entry[XATOM_AUTHOR] as JArray != null ? entry[XATOM_AUTHOR]
                            .Select(auth => auth.Value<string>(XATOM_AUTH_URI))
                            .FirstOrDefault() : null;
 
                    if (result is ResourceEntry)
                        ((ResourceEntry)ce).Content = getContents(entry[XATOM_CONTENT], errors);
                    else
                        getBinaryContentsFromEntry(entry[XATOM_CONTENT], (BinaryEntry)ce, errors);
                };
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

        private static string getCategoryFromEntry(JToken item)
        {
            return item[XATOM_CATEGORY] as JArray != null ? item[XATOM_CATEGORY]
                .Where(cat => cat.Value<string>(XATOM_CAT_SCHEME) == ATOM_CATEGORY_RESOURCETYPE_NS)
                .Select(scat => scat.Value<string>(XATOM_CAT_TERM))
                .FirstOrDefault() : null;
        }


        private static Resource getContents(JToken token, ErrorList errors)
        {
            //TODO: This is quite inefficient. The Json parser has just parsed this
            //entry's Resource from json, now we are going to serialize it to as string
            //just to read from it again using a JsonTextReader. But that is what my
            //parser takes as input, so no choice for now...
            string contents = token.ToString();
            JsonTextReader r = new JsonTextReader(new StringReader(contents));
            return FhirParser.ParseResource( new JsonFhirReader(r), errors);
        }

        private static void getBinaryContentsFromEntry(JToken entryContent, BinaryEntry result, ErrorList errors)
        {
            JToken binaryObject = entryContent[XATOM_CONTENT_BINARY];

            if (binaryObject != null)
            {
                result.MediaType = binaryObject.Value<string>(XATOM_CONTENT_BINARY_TYPE);

                JToken binaryContent = binaryObject[XATOM_CONTENT];

                if (binaryContent != null)
                    result.Content = Convert.FromBase64String(binaryContent.ToString());
            }
        }

        public void Save(JsonWriter writer)
        {
            JObject result = new JObject();

            if (!String.IsNullOrWhiteSpace(Title))
                result.Add(new JProperty(XATOM_TITLE, Title));

            if (LastUpdated != null) result.Add(new JProperty(XATOM_UPDATED, LastUpdated));
            if (Util.UriHasValue(Id)) result.Add(new JProperty(XATOM_ID, Id));  
            if (!String.IsNullOrWhiteSpace(AuthorName))
                result.Add(jsonCreateAuthor(AuthorName, AuthorUri));
            if (TotalResults != null) result.Add(new JProperty(XATOM_TOTALRESULTS, TotalResults.ToString()));
            if (Links.Count > 0)
                result.Add(new JProperty(XATOM_LINK, jsonCreateLinkArray(Links)));

            var entryArray = new JArray();

            foreach( var entry in Entries )
            {
                if( entry is ContentEntry )
                    entryArray.Add(jsonCreateContentEntry((ContentEntry)entry));
                else if( entry is DeletedEntry )
                    entryArray.Add(jsonCreateDeletedEntry((DeletedEntry)entry));
            }
            
            result.Add(new JProperty(XATOM_ENTRY, entryArray));

            result.WriteTo(writer);
        }


        public string ToJson()
        {
            StringBuilder resultBuilder = new StringBuilder();
            StringWriter sw = new StringWriter(resultBuilder);
            JsonWriter jw = new JsonTextWriter(sw);
            Save(jw);
            jw.Flush();
            jw.Close();

            return resultBuilder.ToString();
        }


        public byte[] ToJsonBytes()
        {
            return Encoding.UTF8.GetBytes(ToJson());
        }


        private JArray jsonCreateLinkArray(UriLinkList links)
        {
            var result = new JArray();
            
            foreach(var l in links)
                result.Add(jsonCreateLink(l.Rel, l.Uri));

            return result;
        }

        private JObject jsonCreateLink(string rel, Uri link)
        {
            return new JObject(
                new JProperty(XATOM_LINK_REL, rel),
                new JProperty(XATOM_LINK_HREF, link.ToString()));
        }


        private JObject jsonCreateDeletedEntry(DeletedEntry entry)
        {
            JObject newItem = new JObject();

            newItem.Add(new JProperty(JATOM_DELETED, entry.When));
            newItem.Add(new JProperty(XATOM_ID, entry.Id.ToString()));

            if (Util.UriHasValue(entry.Links.SelfLink))
                newItem.Add(new JProperty(XATOM_LINK, new JArray(jsonCreateLink(Util.ATOM_LINKREL_SELF, entry.Links.SelfLink))));

            return newItem;
        }


        private JObject jsonCreateContentEntry(ContentEntry ce)
        {
            JObject newItem = new JObject();

            if (!String.IsNullOrWhiteSpace(ce.Title)) newItem.Add(new JProperty(XATOM_TITLE, ce.Title));
            //if (Util.UriHasValue(ce.SelfLink))
            //    newItem.Add(new JProperty(XATOM_LINK, new JArray(jsonCreateLink(Util.ATOM_LINKREL_SELF, ce.SelfLink))));
            if (Util.UriHasValue(ce.Id)) newItem.Add(new JProperty(XATOM_ID, ce.Id.ToString()));
                
            if (ce.LastUpdated != null) newItem.Add(new JProperty(XATOM_UPDATED, ce.LastUpdated));
            if (ce.Published != null) newItem.Add(new JProperty(XATOM_PUBLISHED, ce.Published));
                
            if (!String.IsNullOrWhiteSpace(ce.EntryAuthorName))
                newItem.Add(jsonCreateAuthor(ce.EntryAuthorName, ce.EntryAuthorUri));
            if (ce.Links.Count > 0)
                newItem.Add(new JProperty(XATOM_LINK, jsonCreateLinkArray(ce.Links)));

            // Note: this is a read-only property, so it is serialized but never parsed
            if (ce.Summary != null)
                newItem.Add(new JProperty(XATOM_SUMMARY, ce.Summary));

            if(ce is ResourceEntry)
            {
                ResourceEntry re = (ResourceEntry)ce;
                
                if (!String.IsNullOrWhiteSpace(re.ResourceType))
                    newItem.Add(new JProperty(XATOM_CATEGORY, new JArray(jsonCreateCategory(re.ResourceType))));

                if (re.Content != null)
                    newItem.Add(new JProperty(XATOM_CONTENT, getContentsAsJObject(re.Content)));
            }
            else if(ce is BinaryEntry)
            {
                BinaryEntry be = (BinaryEntry)ce;

                newItem.Add(new JProperty(XATOM_CATEGORY, new JArray(jsonCreateCategory(XATOM_CONTENT_BINARY))));

                if (be.Content != null)
                {
                    newItem.Add(new JProperty(XATOM_CONTENT, new JObject(
                            new JProperty( XATOM_CONTENT_BINARY, new JObject(
                                new JProperty( XATOM_CONTENT_BINARY_TYPE, be.MediaType ),
                                new JProperty( XATOM_CONTENT, Convert.ToBase64String(be.Content)) ) ) ) ));
                }
            }
            else
                throw new NotSupportedException("Cannot serialize unknown entry type " + ce.GetType().Name);

            return newItem;
        }

        private static JProperty jsonCreateAuthor(string name, string uri)
        {
            JObject author = new JObject(new JProperty(XATOM_AUTH_NAME, name));
            
            if (!String.IsNullOrWhiteSpace(uri))
                author.Add(new JProperty(XATOM_AUTH_URI, uri));

            return new JProperty(XATOM_AUTHOR, new JArray(author));
        }

        private static JObject jsonCreateCategory(string category)
        {
            return new JObject( new JProperty(XATOM_CAT_TERM, category),
                                new JProperty(XATOM_CAT_SCHEME, ATOM_CATEGORY_RESOURCETYPE_NS));
        }


        private JObject getContentsAsJObject(Resource resource)
        {
            StringWriter w = new StringWriter();

            //TODO: This would be much more efficient if we could serialize
            //the resource to a JObject directly
            FhirSerializer.SerializeResource(resource, new JsonTextWriter(w));

            JsonTextReader reader = new JsonTextReader(new StringReader(w.ToString()));
            reader.DateParseHandling = DateParseHandling.None;
            return JObject.Load(reader);
        }



        private static UriLinkList getLinks( JToken token )
        {
            var result = new UriLinkList();
            var links = token as JArray;

            if (links != null)
            {
                foreach (var link in links)
                {
                    if (link.Value<string>(XATOM_LINK_HREF) != null)
                        result.Add(new UriLinkEntry
                        {
                            Rel = link.Value<string>(XATOM_LINK_REL),
                            Uri = new Uri(link.Value<string>(XATOM_LINK_HREF), UriKind.RelativeOrAbsolute)
                        });
                }
            }
            
            return result;
        }
    }
}
