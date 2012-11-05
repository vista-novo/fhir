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
using System.Xml;

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class BundleTests
    {
        [TestMethod]
        public void TestSerializeBundleXml()
        {
            Bundle b = createTestBundle();

            StringWriter w = new StringWriter();
            XmlWriter xw = XmlWriter.Create(w);
            b.Save(xw);
            xw.Flush();
            xw.Close();

            Assert.AreEqual(testBundleAsXml, w.ToString());
        }

        [TestMethod]
        public void TestSerializeBundleJson()
        {
            Bundle b = createTestBundle();

            StringWriter w = new StringWriter();
            JsonWriter jw = new JsonTextWriter(w);
            b.Save(jw);
            jw.Flush();
            jw.Close();

            Assert.AreEqual(testBundleAsJson, w.ToString());
        }


        [TestMethod]
        public void TestParseBundleXml()
        {
            ErrorList errors = new ErrorList();

            Bundle result = Bundle.Load(XmlReader.Create(new StringReader(testBundleAsXml)), errors);

            Assert.AreEqual(0, errors.Count);

            // And serialize again, to see the roundtrip.
            StringWriter w = new StringWriter();
            XmlWriter xw = XmlWriter.Create(w);
            result.Save(xw);
            xw.Flush();
            xw.Close();

            Assert.AreEqual(testBundleAsXml, w.ToString());
        }

        private string testBundleAsXml =
            "<?xml version=\"1.0\" encoding=\"utf-16\"?><feed xmlns=\"http://www.w3.org/2005/Atom\">" +
            "<title type=\"text\">Updates to resource 233</title><id>uuid:0d0dcca9-23b9-4149-8619-65002224c3</id><updated>2012-11-02T14:17:21Z</updated>" +
            "<link rel=\"self\" href=\"http://test.com/fhir/person/@233/history$format=json\" />" +
            "<deleted-entry ref=\"http://test.com/fhir/person/@233\" when=\"2012-11-01T13:15:30Z\" " +
            "xmlns=\"http://purl.org/atompub/tombstones/1.0\"><link rel=\"self\" " +
            "href=\"http://test.com/fhir/person/@233/history/@2\" xmlns=\"http://www.w3.org/2005/Atom\" />" +
            "</deleted-entry>" +
            "<entry p2:etag=\"1\" xmlns:p2=\"http://schemas.google.com/g/2005\"><id>http://test.com/fhir/person/@233</id>" +
            "<title type=\"text\">Resource 233 Version 1</title><summary type=\"xhtml\">" +
            "<div xmlns=\"http://www.w3.org/1999/xhtml\">summary here</div></summary><published>2012-11-02T14:17:21Z</published>" +
            "<updated>2012-11-01T13:04:14Z</updated><author><name>110.143.187.242</name></author>" +
            "<link rel=\"self\" href=\"http://test.com/fhir/person/@233/history/@1\" />" +
            "<category term=\"Person\" scheme=\"http://hl7.org/fhir/sid/fhir/resource-types\" />" +
            "<content type=\"text/xml\"><Person xmlns=\"http://hl7.org/fhir\"><text><status>generated</status>" +
            "<div xmlns=\"http://www.w3.org/1999/xhtml\">summary here</div></text></Person></content></entry>" +
            "<entry p2:etag=\"1\" xmlns:p2=\"http://schemas.google.com/g/2005\"><id>http://test.com/fhir/binary/@99</id>" +
            "<title type=\"text\">Resource 99 Version 1</title><summary type=\"xhtml\"><div xmlns=\'http://www.w3.org/1999/xhtml\'>Binary content</div>" +
            "</summary><published>2012-11-02T14:17:21Z</published><updated>2012-10-31T13:04:14Z</updated><author><name>110.143.187.242</name></author>" +
            "<link rel=\"self\" href=\"http://test.com/fhir/binary/@99/history/@1\" />" +
            "<category term=\"Binary\" scheme=\"http://hl7.org/fhir/sid/fhir/resource-types\" />" +
            "<content type=\"text/xml\"><Binary contentType=\"application/x-test\" xmlns=\"http://hl7.org/fhir\">" +
            "AAECAw==</Binary></content></entry></feed>";

        private string testBundleAsJson = "{\"title\":\"Updates to resource 233\",\"updated\":\"2012-11-02T14:17:21+00:00\","+
            "\"id\":\"uuid:0d0dcca9-23b9-4149-8619-65002224c3\",\"link\":[{\"rel\":\"self\",\"href\":\"http://test.com/fhir/person/@233/history$format=json\"}],"+
            "\"entry\":[{\"title\":\"Resource 233 Version 1\",\"link\":[{\"rel\":\"self\",\"href\":\"http://test.com/fhir/person/@233/history/@1\"}],"+
            "\"id\":\"http://test.com/fhir/person/@233\",\"updated\":\"2012-11-01T13:04:14+00:00\",\"published\":\"2012-11-02T14:17:21+00:00\","+
            "\"author\":[{\"name\":\"110.143.187.242\"}],\"summary\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">summary here</div>\","+
            "\"version\":\"1\",\"category\":[{\"term\":\"Person\",\"scheme\":\"http://hl7.org/fhir/sid/fhir/resource-types\"}],\"content\":"+
            "{\"Person\":{\"text\":{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">summary here</div>\"}}}},"+
            "{\"title\":\"Resource 99 Version 1\",\"link\":[{\"rel\":\"self\",\"href\":\"http://test.com/fhir/binary/@99/history/@1\"}],"+
            "\"id\":\"http://test.com/fhir/binary/@99\",\"updated\":\"2012-10-31T13:04:14+00:00\",\"published\":\"2012-11-02T14:17:21+00:00\","+
            "\"author\":[{\"name\":\"110.143.187.242\"}],\"summary\":\"<div xmlns='http://www.w3.org/1999/xhtml'>Binary content</div>\","+
            "\"version\":\"1\",\"category\":[{\"term\":\"Binary\",\"scheme\":\"http://hl7.org/fhir/sid/fhir/resource-types\"}],"+
            "\"content\":{\"Binary\":{\"contentType\":\"application/x-test\",\"content\":\"AAECAw==\"}}},"+
            "{\"deleted\":\"2012-11-01T13:15:30+00:00\",\"id\":\"http://test.com/fhir/person/@233\",\"link\":[{\"rel\":\"self\","+
            "\"href\":\"http://test.com/fhir/person/@233/history/@2\"}]}]}";


        private static Bundle createTestBundle()
        {
            Bundle b = new Bundle();

            b.Title = "Updates to resource 233";
            b.Id = new Uri("uuid:0d0dcca9-23b9-4149-8619-65002224c3");
            b.LastUpdated = new DateTimeOffset(2012, 11, 2, 14, 17, 21, TimeSpan.Zero);
            b.SelfLink = new Uri("http://test.com/fhir/person/@233/history$format=json");

            ResourceEntry e1 = new ResourceEntry();
            e1.Id = new Uri("http://test.com/fhir/person/@233");
            e1.Title = "Resource 233 Version 1";
            e1.SelfLink = new Uri("http://test.com/fhir/person/@233/history/@1");
            e1.LastUpdated = new DateTimeOffset(2012, 11, 01, 13, 04, 14, TimeSpan.Zero);
            e1.Published = new DateTimeOffset(2012, 11, 2, 14, 17, 21, TimeSpan.Zero);
            e1.AuthorName = "110.143.187.242";
            e1.VersionId = "1";
            e1.Content = new Model.Person()
            {
                Text =
                  new Model.Narrative()
                  {
                      Status = Model.Narrative.NarrativeStatus.Generated,
                      Div = "<div xmlns=\"http://www.w3.org/1999/xhtml\">summary here</div>"
                  }
            };

            DeletedEntry e2 = new DeletedEntry();
            e2.Id = new Uri("http://test.com/fhir/person/@233");
            e2.SelfLink = new Uri("http://test.com/fhir/person/@233/history/@2");
            e2.VersionId = "2";
            e2.When = new DateTimeOffset(2012, 11, 01, 13, 15, 30, TimeSpan.Zero);

            BinaryEntry e3 = new BinaryEntry();
            e3.Id = new Uri("http://test.com/fhir/binary/@99");
            e3.Title = "Resource 99 Version 1";
            e3.SelfLink = new Uri("http://test.com/fhir/binary/@99/history/@1");
            e3.LastUpdated = new DateTimeOffset(2012, 10, 31, 13, 04, 14, TimeSpan.Zero);
            e3.Published = new DateTimeOffset(2012, 11, 2, 14, 17, 21, TimeSpan.Zero);
            e3.AuthorName = "110.143.187.242";
            e3.VersionId = "1";
            e3.MimeType = "application/x-test";
            e3.Content = new byte[] { 0x00, 0x01, 0x02, 0x03 };

            b.Entries.Add(e1);
            b.Entries.Add(e2);
            b.Entries.Add(e3);

            return b;
        }
    }
}
