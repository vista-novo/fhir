using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Parsers;
using System.Xml;
using System.Xml.Linq;
using System.IO;
using HL7.Fhir.Instance.Support;
using Newtonsoft.Json;


namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class PrimitiveParserTests
    {
        [TestMethod]
        public void TestContinueOnEmptyElements()
        {
            string xmlString = "<x xmlns='http://hl7.org/fhir'><someElem value='true' id='3141' /><someElem2 /></x>";
            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader xfr = new XmlFhirReader(xr);
            xfr.MoveToContent();
            Assert.AreEqual("x", xfr.CurrentElementName);
            Assert.IsTrue(xfr.IsAtElement());

            xfr.EnterElement();
            Assert.AreEqual("someElem", xfr.CurrentElementName);
            xfr.LeaveElement();
            Assert.IsTrue(xfr.IsAtElement());
            xfr.EnterElement();
            Assert.AreEqual("someElem2", xfr.CurrentElementName);
            xfr.LeaveElement();
            xfr.LeaveElement();
        }

        [TestMethod]
        public void TestParsePrimitive()
        {
            string xmlString = "<someElem value='true' id='3141' />";
            XmlReader xr = fromString(xmlString); xr.Read();
            ErrorList errors = new ErrorList();
            FhirBoolean result = PrimitiveParser.ParseFhirBoolean(new XmlFhirReader(xr), errors);
            Assert.IsTrue(errors.Count == 0, errors.ToString());
            Assert.AreEqual(true, result.Contents);
            Assert.AreEqual("3141", result.ReferralId);

            string jsonString = "{\"someElem\": { \"value\" : \"true\", \"_id\" : \"3141\" } }";
            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = PrimitiveParser.ParseFhirBoolean(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count == 0, errors.ToString());
            Assert.AreEqual(true, result.Contents);
            Assert.AreEqual("3141", result.ReferralId);
        }

        [TestMethod]
        public void TestParsePrimitiveWithIllegalAttribute()
        {
            string xmlString = "<someElem value='true' unknownattr='yes' />";
            XmlReader xr = fromString(xmlString); xr.Read();
            ErrorList errors = new ErrorList();
            FhirBoolean result = PrimitiveParser.ParseFhirBoolean(new XmlFhirReader(xr), errors);
            Assert.IsTrue(errors.Count == 1);
            Assert.IsTrue(errors[0].Message.Contains("unknownattr"));

            string jsonString = "{\"someElem\": { \"value\" : \"true\", \"unknownattr\" : \"yes\" } }";
            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = PrimitiveParser.ParseFhirBoolean(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count == 1);
            Assert.IsTrue(errors[0].Message.Contains("unknownattr"));
        }


        [TestMethod]
        public void TestParseEmptyPrimitive()
        {
            string xmlString = "<someElem id='4' />";
            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            FhirString result = PrimitiveParser.ParseFhirString(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(result);
            Assert.IsNull(result.Contents);
            Assert.AreEqual("4", result.ReferralId);

            string xmlString2 = "<someElem id='4' value='' />";
            xr = fromString(xmlString2); xr.Read();
            r = new XmlFhirReader(xr);

            errors.Clear();
            result = PrimitiveParser.ParseFhirString(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(result);
            Assert.AreEqual("4", result.ReferralId);
            Assert.AreEqual("", result.Contents);

            string jsonString = "{ \"someElem\" : { \"_id\" : \"4\" } }";
            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = PrimitiveParser.ParseFhirString(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(result);
            Assert.AreEqual("4", result.ReferralId);
            Assert.IsNull(result.Contents);

            jsonString = "{ \"someElem\" : { \"_id\" : \"4\", \"value\" : \"\" } }";
            jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = PrimitiveParser.ParseFhirString(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual("4", result.ReferralId);
            Assert.IsNotNull(result);
            Assert.AreEqual("", result.Contents);
        }


        [TestMethod]
        public void TestParseExtendedPrimitive()
        {
            throw new NotImplementedException();
        }


        [TestMethod]
        public void TestParseExtendedPrimitiveWithOtherElements()
        {
            throw new NotImplementedException();
        }


        private XmlReader fromString(string s)
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            XmlReader r = XmlReader.Create(new StringReader(s), settings);

            return r;
        }

    }
}