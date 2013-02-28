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
using Hl7.Fhir;
using Hl7.Fhir.Model;
using Hl7.Fhir.Support;
using System.Net;
using Hl7.Fhir.Parsers;
using Hl7.Fhir.Serializers;
using System.IO;



namespace Hl7.Fhir.Client
{
    public class FhirClient
    {
        //TODO: _include
        //TODO: Binaries

        public Uri FhirEndpoint { get; private set; }


        public FhirClient(Uri endpoint)
        {
            FhirEndpoint = endpoint;
            PreferredFormat = ContentType.ResourceFormat.Xml;
        }


        /// <summary>
        /// Get a conformance statement for the system
        /// </summary>
        /// <param name="useOptionsVerb">If true, uses the Http OPTIONS verb to get the conformance, otherwise uses the /metadata endpoint</param>
        /// <returns>A Conformance resource, or null if the server did not return status 200</returns>
        public Conformance Conformance(bool useOptionsVerb = false)
        {
            string path = useOptionsVerb ? "" : Util.RESTOPER_METADATA;
            var req = createRequest(path, false);
            req.Method = useOptionsVerb ? "OPTIONS" : "GET";

            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.OK)
            {
                Resource result = parseResource();

                if (!(result is Conformance))
                    throw new InvalidOperationException(
                        String.Format("Received a resource of type {0}, expected a Conformance resource", result.GetType().Name));

                return (Conformance)result;
            }
            else
                return null;
        }


        /// <summary>
        /// Fetches the latest version of a resource
        /// </summary>
        /// <param name="id">The id of the Resource to fetch</param>
        /// <typeparam name="TResource">The type of resource to fetch</typeparam>
        /// <returns>The requested resource, or null if the server did not return status 200</returns>
        public TResource Read<TResource>(string id) where TResource : Resource
        {
            var collection = getCollectionForResourceName(typeof(TResource));
            var req = createRequest(ResourceLocation.BuildResourceLocation(collection, id), false);
            req.Method = "GET";
            
            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.OK)
                return (TResource)parseResource();
            else
                return null;
        }

        
        /// <summary>
        /// Fetches a specific version of a resource
        /// </summary>
        /// <param name="id">The id of the resource to fetch</param>
        /// <param name="versionId">The version id of the resource to fetch</param>
        /// <typeparam name="TResource">The type of resource to fetch</typeparam>
        /// <returns></returns>
        public TResource VRead<TResource>(string id, string versionId) where TResource : Resource
        {
            var collection = getCollectionForResourceName(typeof(TResource));
            Uri vReadLocation = ResourceLocation.BuildVersionedResourceLocation(collection, id, versionId);
            var req = createRequest(vReadLocation.ToString(), false);
            req.Method = "GET";

            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.OK)
                return (TResource)parseResource();
            else
                return null;
        }


        /// <summary>
        /// Update (or create) a resource
        /// </summary>
        /// <param name="resource">The updated resource content</param>
        /// <param name="id">The id of the resource to be updated</param>
        /// <param name="versionId">If not null, the version of the resource that is being updated</param>
        /// <typeparam name="TResource">The type of resource that is being updated</typeparam>
        /// <returns>The resource as updated on the server, or null if the update failed.</returns>
        /// <remarks>
        /// <para>The returned resource need not be the same as the resources passed as a parameter,
        /// since the server may have updated or changed part of the data because of business rules.</para>
        /// <para>If there was no existing resource to update with the given id, the server may allow the client
        /// to create the resource instead. If so, it returns status code 201 (Created) instead of 200. If
        /// the resource did not exist and creation using the id given by the client if forbidden, a
        /// 405 (Method Not Allowed) is returned.</para>
        /// <para>If a versionId parameter is provided, the update will only succeed if the last version
        /// on the server corresponds to that versionId. This allows the client to detect update conflicts.
        /// If a conflict arises, Update returns null and the result status code will be 409 (Conflict). If
        /// the server requires version-aware updates but the client does not provide the versionId parameter,
        /// Update also returns null, but the result status code will be 412 (Preconditions failed).</para></remarks>
        public TResource Update<TResource>(TResource resource, string id, string versionId = null)
                        where TResource : Resource
        {
            string contentType = ContentType.BuildContentType(PreferredFormat, false);
            string collection = getCollectionForResourceName(typeof(TResource));

            byte[] data = PreferredFormat == ContentType.ResourceFormat.Xml ?
                FhirSerializer.SerializeResourceAsXmlBytes(resource) :
                FhirSerializer.SerializeResourceAsJsonBytes(resource);

            var req = createRequest(ResourceLocation.BuildResourceLocation(collection, id), false);

            req.Method = "PUT";
            req.ContentType = contentType;
            setRequestBody(req, data);

            if (versionId != null)
            {
                string versionUrl = Util.Combine(FhirEndpoint.ToString(), 
                    ResourceLocation.BuildVersionedResourceLocation(collection, id, versionId).ToString());
                req.Headers[HttpRequestHeader.ContentLocation] = versionUrl;
            }

            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.Created || LastResponseDetails.Result == HttpStatusCode.OK)
                return (TResource)parseResource();
            else
                return null;
        }


        /// <summary>
        /// Delete a resource
        /// </summary>
        /// <param name="id">id of the resource to delete</param>
        /// <typeparam name="TResource">The type of the resource to delete</typeparam>
        /// <returns>true if the delete succeeded, or false otherwise</returns>
        public bool Delete<TResource>(string id) where TResource : Resource
        {
            var collection = getCollectionForResourceName(typeof(TResource));
            var req =
                  createRequest(ResourceLocation.BuildResourceLocation(collection, id), false);
            req.Method = "DELETE";

            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.NoContent)
                return true;
            else
                return false;
        }


        /// <summary>
        /// Create a resource
        /// </summary>
        /// <param name="resource">The resource instance to create</param>
        /// <param name="newId">Newly assigned id by server after successful creation</param>
        /// <returns>The resource as created on the server, or null if the create failed.</returns>
        /// <typeparam name="TResource">The type of resource to create</typeparam>
        /// <remarks><para>The returned resource need not be the same as the resources passed as a parameter,
        /// since the server may have updated or changed part of the data because of business rules.</para>
        /// <para>When the resource was created, but newId is null, the server failed to return the new
        /// id in the Http Location header.</para>
        /// </remarks>
        public TResource Create<TResource>(TResource resource, out string newId) where TResource : Resource
        {
            string contentType = ContentType.BuildContentType(PreferredFormat, false);
            string collection = getCollectionForResourceName(typeof(Resource));

            byte[] data = PreferredFormat == ContentType.ResourceFormat.Xml ?
                FhirSerializer.SerializeResourceAsXmlBytes(resource) :
                FhirSerializer.SerializeResourceAsJsonBytes(resource);

            var req = createRequest(collection, false);
            req.Method = "POST";
            req.ContentType = contentType;
            setRequestBody(req, data);
         
            doRequest(req);

            newId = null;

            if (LastResponseDetails.Result == HttpStatusCode.Created)
            {
                var result = parseResource();
                if (LastResponseDetails.Location != null)
                    newId = ResourceLocation.ParseIdFromRestUri(new Uri(LastResponseDetails.Location));
                return (TResource)result;
            }
            else
                return null;
        }


        /// <summary>
        /// Retrieve the version history for a specific resource instance
        /// </summary>
        /// <param name="id">The id of the resource to get the history for</param>
        /// <param name="lastUpdate">If provided, only get updates on or after the given point in time</param>
        /// <typeparam name="TResource">The type of resource to get the history for</typeparam>
        /// <returns>A Bundle listing all versions for the given resource id</returns>
	    public Bundle History<TResource>(string id, DateTimeOffset? lastUpdate = null ) where TResource : Resource
        {
            var collection = getCollectionForResourceName(typeof(TResource));
            var path = Util.Combine(ResourceLocation.BuildResourceLocation(collection, id).ToString(),
                                Util.RESTOPER_HISTORY);

            var req = createRequest(path, true);
            req.Method = "GET";
            
            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.OK)
                return parseBundle();
            else
                return null;
        }

       
        /// <summary>
        /// Retrieve the version history for all resources of a certain type
        /// </summary>
        /// <param name="lastUpdate">If provided, only get updates on or after the given point in time</param>
        /// <typeparam name="TResource">The type of resource to get the history for</typeparam>
        /// <returns>A Bundle listing all versions for all resources of the given type</returns>
        public Bundle History<TResource>(DateTimeOffset? lastUpdate = null ) where TResource : Resource
        {
            var collection = getCollectionForResourceName(typeof(TResource));
            var path = Util.Combine(collection, Util.RESTOPER_HISTORY);
            var req = createRequest(path, true);
            req.Method = "GET";

            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.OK)
                return parseBundle();
            else
                return null;
        }


        /// <summary>
        /// Retrieve the version history of any resource on the server
        /// </summary>
        /// <param name="lastUpdate">If provided, only get updates on or after the given point in time</param>
        /// <returns>A Bundle listing all versions of all resource on the server</returns>
        public Bundle History(DateTimeOffset? lastUpdate = null)
        {
            var req = createRequest(Util.RESTOPER_HISTORY, true);
            req.Method = "GET";

            doRequest(req);

            if (LastResponseDetails.Result == HttpStatusCode.OK)
                return parseBundle();
            else
                return null;
        }


        /// <summary>
        /// Validates whether the contents of the resource would be acceptable as an update
        /// </summary>
        /// <param name="lastUpdate"></param>
        /// <returns></returns>
        public IssueReport Validate(string id, BundleEntry resource)
        {
            // Shoudn't this be a PUT instead of a POST?
            throw new NotImplementedException();
        }

        /// <summary>
        /// Search for resources based on search criteria
        /// </summary>
        /// <param name="type"></param>
        /// <param name="parameters"></param>
        /// <returns></returns>
        public Bundle Search(ResourceType type, Dictionary<string,string> parameters)
        {
               throw new NotImplementedException();
        }

	   
        /// <summary>
        /// Send a batched update to the server
        /// </summary>
        /// <param name="lastUpdate"></param>
        /// <returns></returns>
        public Bundle Batch(Bundle batch)
        {
               throw new NotImplementedException();
        }


        public ContentType.ResourceFormat PreferredFormat { get; set; }

        private HttpWebRequest createRequest(Uri path, bool forBundle)
        {
            return createRequest(path.ToString(), forBundle);
        }

        private string getCollectionForResourceName(Type type)
        {
            return type.Name.ToLowerInvariant();
        }

        private HttpWebRequest createRequest(string path, bool forBundle)
        {
            Uri endpoint = new Uri( Util.Combine(FhirEndpoint.ToString(), path) );

            //if( PreferredFormat == ContentType.ResourceFormat.Json )
            //    endpoint = addParam(endpoint, ContentType.FORMAT_PARAM, ContentType.FORMAT_PARAM_JSON);
            //if (PreferredFormat == ContentType.ResourceFormat.Xml)
            //    endpoint = addParam(endpoint, ContentType.FORMAT_PARAM, ContentType.FORMAT_PARAM_XML);

            var req = (HttpWebRequest)HttpWebRequest.Create(endpoint);
            req.UserAgent = "FhirClient for FHIR " + Model.ModelInfo.Version;

            if (PreferredFormat == ContentType.ResourceFormat.Xml)
                req.Accept = ContentType.BuildContentType(ContentType.ResourceFormat.Xml, forBundle);
            else if (PreferredFormat == ContentType.ResourceFormat.Json)
                req.Accept = ContentType.BuildContentType(ContentType.ResourceFormat.Json, forBundle);
            else
                throw new ArgumentException("PreferrredFormat was set to an unsupported seralization format");

            return req;
        }

        private static Uri addParam(Uri original, string paramName, string paramValue)
        {
            string url = original.GetLeftPart(UriPartial.Path);

            url += String.IsNullOrEmpty(original.Query) ? "?" : original.Query + "&";
            url += paramName + "=" + paramValue;

            return new Uri(url);
        }


        public ResponseDetails LastResponseDetails { get; private set; }

        private void doRequest(HttpWebRequest req)
        {
            HttpWebResponse response = (HttpWebResponse)req.GetResponseNoEx();

            try
            {
                LastResponseDetails = ResponseDetails.FromHttpWebResponse(response);
            }
            finally
            {
                response.Close();
            }
        }

        private Resource parseResource()
        {
            string data = LastResponseDetails.BodyAsString();
            string contentType = LastResponseDetails.ContentType;

            ErrorList parseErrors = new ErrorList();
            Resource result;

            ContentType.ResourceFormat format = ContentType.GetResourceFormatFromContentType(contentType);

            switch (format)
            {
                case ContentType.ResourceFormat.Json:
                    result = FhirParser.ParseResourceFromJson(data, parseErrors);
                    break;
                case ContentType.ResourceFormat.Xml:
                    result = FhirParser.ParseResourceFromXml(data, parseErrors);
                    break;
                default:
                    throw new FhirParseException("Cannot decode resource: unrecognized content type");
            }

            if (parseErrors.Count() > 0)
                throw new FhirParseException(data, parseErrors,
                    "Failed to parse the resource data: " + parseErrors.ToString());

            return result;
        }


        private Bundle parseBundle()
        {
            string data = LastResponseDetails.BodyAsString();
            string contentType = LastResponseDetails.ContentType;

            ErrorList parseErrors = new ErrorList();
            Bundle result;

            ContentType.ResourceFormat format = ContentType.GetResourceFormatFromContentType(contentType);

            switch (format)
            {
                case ContentType.ResourceFormat.Json:
                    result = Bundle.LoadFromJson(data, parseErrors);
                    break;
                case ContentType.ResourceFormat.Xml:
                    result = Bundle.LoadFromXml(data, parseErrors);
                    break;
                default:
                    throw new FhirParseException("Cannot decode bundle: unrecognized content type");
            }

            if (parseErrors.Count() > 0)
                throw new FhirParseException(data, parseErrors,
                    "Failed to parse the bundle data: " + parseErrors.ToString());

            return result;
        }

        private void setRequestBody(HttpWebRequest request, byte[] data)
        {
            Stream outs = request.GetRequestStream();
            outs.Write(data, 0, (int)data.Length);
            outs.Flush();
            outs.Close();
        }

    }
}
