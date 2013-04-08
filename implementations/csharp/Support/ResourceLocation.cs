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
using System.Net;
using System.Text.RegularExpressions;
using Hl7.Fhir.Model;
using System.Reflection;
using Hl7.Fhir.Client;


namespace Hl7.Fhir.Support
{
    public class ResourceLocation
    {
        public const string BINARY_COLLECTION_NAME = "binary";

        public static string GetCollectionNameForResource(Resource r)
        {
            if (r == null) return null;

            return GetCollectionNameForResource(r.GetType());
        }

        public static string GetCollectionNameForResource(Type t)
        {
#if NETFX_CORE
            if(typeof(Resource).GetTypeInfo().IsAssignableFrom(t.GetTypeInfo()))
#else
            if (typeof(Resource).IsAssignableFrom(t))
#endif
                return ModelInfo.GetResourceNameForType(t).ToLower();
            else
                throw new ArgumentException(String.Format("Cannot determine collection name, type {0} is " +
                        "not a resource type", t.Name));
        }


        public static Uri BuildResourceLocation(Uri baseUri, string collectionName, string id)
        {
            return new Uri(Util.Combine(baseUri.ToString(),
                BuildResourceLocation(collectionName, id).ToString()), UriKind.Absolute);
        }

        public static Uri BuildResourceLocation(string collectionName, string id)
        {
            return new Uri(Util.Combine(collectionName, "@" + id), UriKind.Relative);
        }

        public static Uri BuildVersionedResourceLocation(Uri baseUri, string collectionName, string id, string versionId)
        {            
            return new Uri(Util.Combine(baseUri.ToString(),
                            BuildVersionedResourceLocation(collectionName, id, versionId).ToString()), UriKind.Absolute);
        }

        public static Uri BuildVersionedResourceLocation(string collectionName, string id, string versionId)
        {
            //string historyPath = Util.Combine("history", "@" + versionId);

            return BuildVersionedResourceLocation( BuildResourceLocation(collectionName, id), versionId );
        }

        public static Uri BuildVersionedResourceLocation(Uri resourceId, string versionId)
        {
            string historyPath = Util.Combine("history", "@" + versionId);

            return new Uri(Util.Combine(resourceId.ToString(), historyPath), UriKind.RelativeOrAbsolute);
        }

        public static string ParseIdFromRestUri(Uri requestUri)
        {
            if (requestUri == null) return null;

            return ParseIdFromRestUri(requestUri.ToString());
        }

        public static string ParseIdFromRestUri(string requestUri)
        {
            if (requestUri == null) return null;

            Regex r = new Regex(@"\w+/@([^/]+)/?");
            Match result = r.Match(requestUri);

            if (result.Success)
                return result.Groups[1].Value;
            else
                return null;
        }

        public static string ParseVersionIdFromRestUri(Uri requestUri)
        {
            if (requestUri == null) return null;

            return ParseVersionIdFromRestUri(requestUri.ToString());
        }

        public static string ParseVersionIdFromRestUri(string requestUri)
        {
            if (requestUri == null) return null;

            Regex r = new Regex(@"\w+/@[^/]+/history/@([^/]+)");
            Match result = r.Match(requestUri);

            if (result.Success)
                return result.Groups[1].Value;
            else
                return null;
        }

        public static string ParseCollectionNameFromRestUri(Uri requestUri)
        {
            if (requestUri == null) return null;

            return ParseCollectionNameFromRestUri(requestUri.ToString());
        }

        public static string ParseCollectionNameFromRestUri(string requestUri)
        {
            if (requestUri == null) return null;

            Regex r = new Regex(@"(\w+)/@[\w]+/?");
            Match result = r.Match(requestUri);

            if (result.Success)
                return result.Groups[1].Value;
            else
            {
                var parts = requestUri.Split('/');
                foreach (var part in parts)
                {
                    if (ModelInfo.IsKnownResource(part))
                        return part;
                }

                return null;
            }
             
        }


        private UriBuilder _location;

        public ResourceLocation()
        {
            _location = new UriBuilder();
        }

        public ResourceLocation(string location)
        {
            _location = new UriBuilder(location);
            parseLocationParts();
        }

        public ResourceLocation(Uri location)
        {
            _location = new UriBuilder(location);
            parseLocationParts();
        }

        public string Scheme
        {
            get { return _location.Scheme; }
            set { _location.Scheme = value; }
        }

        public string Host 
        {
            get { return _location.Host; }
            set { _location.Host = value; }
        }

        public int Port
        {
            get { return _location.Port; }
            set { _location.Port = value; }
        }



        public string Fragment
        {
            get { return _location.Fragment; }
            set { _location.Fragment = value; }
        }

        public string Query
        {
            get { return _location.Query; }
            set { _location.Query = value; }
        }

        public string Service { get; set; }
        public string Operation { get; set; }
        public string Collection { get; set; }
        public string Id { get; set; }
        public string VersionId { get; set; }

        private const string DUMMY_PATH = "http://hl7.org";

        private static readonly string[] resourceCollections = ModelInfo.SupportedResources.Select(res => res.ToLower()).ToArray();

        private bool isResourceCollection(string part)
        {
            return resourceCollections.Contains(part);
        }

        private void parseLocationParts()
        {
            Service = null;
            Operation = null;
            Collection = null;
            Id = null;
            VersionId = null;

            if (!String.IsNullOrEmpty(_location.Path))
            {
                var path = _location.Path.Trim('/');

                // The empty path, /, used for batch and conformance
                if (String.Empty == path)
                    return;

                // Parse <service>/<resourcetype>/@<id>/history/@<version>
                var instancePattern = @"^(?:(.*)/)?(\w+)/@([^/]+)(?:/(history)(?:/@([^/]+))?)?$";

                Regex instanceRegEx = new Regex(instancePattern);
                var match = instanceRegEx.Match(path);
              
                if (match.Success)
                {
                    if (match.Groups[4].Success)
                        VersionId = match.Groups[4].Value;
                    if (match.Groups[3].Success)
                        Operation = match.Groups[3].Value;
                    Id = match.Groups[2].Value;
                    Collection = match.Groups[1].Value;
                    if (match.Groups[0].Success)
                        Service = match.Groups[0].Value;

                    return;
                }
                                
                var parts = _location.Path.Split('/');
                var lastPart = parts[parts.Length - 1];
                var serviceParts = parts.Length;

                // Check for <service>/<resourcetype>/<operation>
                if( parts.Length >= 2 && isResourceCollection(parts[parts.Length - 2]) )
                {
                    Operation = parts[parts.Length - 1];
                    Collection = parts[parts.Length - 2];
                    serviceParts = parts.Length - 2;
                }

                // Check for <service>/<history|metadata>
                else if (lastPart == Util.RESTOPER_METADATA || lastPart == Util.RESTOPER_HISTORY)
                {
                    Operation = lastPart;
                    serviceParts = parts.Length - 1;                    
                }

                // Check for <service>/<resourcetype>
                else if (isResourceCollection(lastPart))
                {
                    Collection = lastPart;
                    serviceParts = parts.Length - 1;
                }

                // Assume any remaining parts are part of the Service path
                Service = serviceParts > 0 ? String.Join("/", parts, 0, serviceParts) : null;
            }
        }
    }
}
