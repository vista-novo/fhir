using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json;
using System.IO;

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class BundleTests
    {
        [TestMethod]
        public void TestParseBundle()
        {
            string json = "{ " +
                 "\"title\" : \"LabReport ordered by last update\"," +
                 "\"updated\" : \"2012-08-01T16:21:41+00:00\"," +
                 "\"id\" : \"uuid:649d48c8-86f9-4c86-9408-a69ab86ccf\"," +
                 "\"links\" : [{" +
                     "\"rel\" : \"self\"," +
                     "\"href\" : \"http://somewhere.com\" }]," +
                 "\"entries\" : [{" +
                    "\"title\" : \"Resource  1\"," +
                    "\"id\" : \"@1\"," +
                    "\"links\" : [{" +
                    "\"rel\" : \"self\"," +
                    "\"href\" : \"http://somewhere.com/@1\"}]," +
                    "\"updated\" : \"2012-07-25T18:25:24+00:00\"," +
                    "\"published\" : \"2012-08-01T16:21:41+00:00\"," +
                    "\"authors\" : [{" +
                    "\"name\" : \"192.149.74.10\"}]," +
                    "\"categories\" : [{" +
                        "\"term\" : \"LabReport\"," +
                        "\"scheme\" : \"http://hl7.org/fhir/sid/fhir/resource-types\"}]," +
                    "\"content\" : {" +
                    "\"LabReport\" : {} }," +
                    "\"summary\" : \"<div xmlns='http://www.w3.org/1999/xhtml'>SBT typing</div>\"" +
                  "}]   }";

            JsonTextReader r = new JsonTextReader(new StringReader(json));
            r.DateParseHandling = DateParseHandling.DateTimeOffset;

            JObject j = JObject.Load(r);

            Assert.AreEqual("LabReport ordered by last update", j.Value<string>("title"));
            Assert.IsNull(j.Value<string>("piet"));
            DateTimeOffset peek = j.Value<DateTimeOffset>("updated");
            Assert.AreEqual(2012, peek.Year);

            Assert.IsNotNull(j["links"] as JArray);
        }
    }
}
