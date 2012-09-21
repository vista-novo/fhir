using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json;
using System.IO;
using HL7.Fhir.Instance.Support;
using HL7.Fhir.Instance.Serializers;
using System.Text.RegularExpressions;

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class BundleTests
    {
        [TestMethod]
        public void TestDeletionGenerators()
        {
            Assert.AreEqual("{ Deleted : {} }", Bundle.GetDeletedContentsAsJson());
            Assert.AreEqual("<Deleted xmlns='http://hl7.org/fhir' />", Bundle.GetDeletedContentsAsXml());
        }

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
                    "\"title\" : \"Resource  1, version 1\"," +
                    "\"id\" : \"@223344\"," +
                    "\"links\" : [{" +
                    "\"rel\" : \"self\"," +
                    "\"href\" : \"http://somewhere.com/@223344/history/@1\"}]," +
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
                    "},{" +
                    "\"title\" : \"Resource  1, version 2\"," +
                    "\"id\" : \"@223344\"," +
                    "\"links\" : [{" +
                    "\"rel\" : \"self\"," +
                    "\"href\" : \"http://somewhere.com/@223344/history/@2\"}]," +
                    "\"updated\" : \"2012-07-25T18:25:24+00:00\"," +
                    "\"published\" : \"2012-08-01T16:21:41+00:00\"," +
                    "\"authors\" : [{" +
                    "\"name\" : \"192.149.74.10\"}]," +
                    "\"categories\" : [{" +
                        "\"term\" : \"LabReport\"," +
                        "\"scheme\" : \"http://hl7.org/fhir/sid/fhir/resource-types\"}]," +
                    "\"content\" : {\"Deleted\" : {} }," +
                    "\"summary\" : \"<div xmlns='http://www.w3.org/1999/xhtml'>This resource has been deleted</div>\"" +
                    "}]}";


            JsonTextReader r = new JsonTextReader(new StringReader(json));
            r.DateParseHandling = DateParseHandling.DateTimeOffset;

            ErrorList errors = new ErrorList();
            Bundle test = Bundle.Load(r,errors);

            Assert.AreEqual(0, errors.Count, errors.ToString());

            Assert.AreEqual("LabReport ordered by last update", test.Title);
            Assert.AreEqual(2012, test.LastUpdated.Value.Year);
            Assert.IsNotNull(test.SelfLink);

            Assert.AreEqual(2, test.Entries.Count);

            Assert.AreEqual(true, test.Entries[1].IsDeletion);
            Assert.AreEqual("<div xmlns='http://www.w3.org/1999/xhtml'>This resource has been deleted</div>", test.Entries[1].Summary);

            StringWriter sw = new StringWriter();
            test.Save(new JsonTextWriter(sw));
            Assert.IsTrue(Regex.IsMatch(sw.ToString(), @"""content""\s*:\s*{\s*""Deleted""\s*:\s*{\s*}\s*}"));

            sw = new StringWriter();
            test.Save(new System.Xml.XmlTextWriter(sw));
            Assert.IsTrue(Regex.IsMatch(sw.ToString(), @"<content.*>\s*<Deleted\s*xmlns=.http://hl7\.org/fhir.\s*>\s*</Deleted>\s*</content>"));

            errors.Clear();
            test = Bundle.Load(System.Xml.XmlReader.Create(new StringReader(sw.ToString())), errors);
            Assert.AreEqual(0, errors.Count);
            Assert.IsTrue(test.Entries[1].IsDeletion);
        }

    }
}
