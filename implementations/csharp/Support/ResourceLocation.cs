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


namespace Hl7.Fhir.Support
{
    public static class ResourceLocation
    {
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
            string historyPath = Util.Combine("history", versionId);

            return new Uri(Util.Combine(BuildResourceLocation(collectionName, id).ToString(), historyPath),UriKind.Relative);
        }

        public static string ParseIdFromRestUri(Uri requestUri)
        {
            Regex r = new Regex(@"/\w+/@([^/]+)/?");
            Match result = r.Match(requestUri.ToString());

            if (result.Success)
                return result.Groups[1].Value;
            else
                return null;
        }

        public static string ParseVersionIdFromRestUri(Uri requestUri)
        {
            Regex r = new Regex(@"/\w+/@[^/]+/history/@([^/]+)");
            Match result = r.Match(requestUri.ToString());

            if (result.Success)
                return result.Groups[1].Value;
            else
                return null;
        }

        public static string ParseCollectionNameFromRestUri(Uri requestUri)
        {
            Regex r = new Regex(@"/(\w+)/@[\w]+/?");
            Match result = r.Match(requestUri.ToString());

            if (result.Success)
                return result.Groups[1].Value;
            else
                return null;
        }
    }
}
