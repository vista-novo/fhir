using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using HL7.Fhir.Instance.Model;
//using HL7.Fhir.Instance.Parsers;
using System.Xml;
using System.Xml.Linq;
using System.IO;
//using HL7.Fhir.Instance.Support;
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

            verifyContinueOnEmptyElements(xfr);

            string jsonString = @"{ ""x"" : 
                                        { ""someElem"" : { ""value"" : ""true"", ""_id"" : ""3141"" },
                                          ""someElem2"" : {} } }";
            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); 
            JsonFhirReader jfr = new JsonFhirReader(jr);

            verifyContinueOnEmptyElements(jfr);
        }


        private static void verifyContinueOnEmptyElements(IFhirReader xfr)
        {
            xfr.MoveToContent();
            Assert.AreEqual("x", xfr.CurrentElementName);
            xfr.EnterElement();

            Assert.IsTrue(xfr.IsAtFhirElement());
            Assert.AreEqual("someElem", xfr.CurrentElementName);
            xfr.EnterElement();
            Assert.IsTrue(xfr.HasMoreElements());
            xfr.SkipSubElementsFor("someElem");
            xfr.LeaveElement();

            Assert.IsTrue(xfr.IsAtFhirElement());
            Assert.AreEqual("someElem2", xfr.CurrentElementName);
            xfr.EnterElement();
            Assert.IsFalse(xfr.HasMoreElements());
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
            string xmlString =
                @"<dateOfBirth xmlns='http://hl7.org/fhir' value='1972-11-30'>
                    <extension>
                       <url value='http://hl7.org/fhir/profile/@iso-21090#nullFlavor' />
                       <valueCode value='UNK' />
                    </extension>
                  </dateOfBirth>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            verifyParseExtendedPrimitive(r);

            string jsonString = @"{ ""dateOfBirth"" : 
                                { 
                                    ""value"" : ""1972-11-30"",
                                    ""extension"" : [
                                    {
                                        ""url"" : { ""value"" : ""http://hl7.org/fhir/profile/@iso-21090#nullFlavor"" },
                                        ""valueCode"" : { ""value"" : ""UNK"" }
                                    } ]
                                }
                            }";

            var jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            JsonFhirReader jfr = new JsonFhirReader(jr);

            verifyParseExtendedPrimitive(jfr);
        }

        private static void verifyParseExtendedPrimitive(IFhirReader r)
        {
            ErrorList errors = new ErrorList();
            Date result = PrimitiveParser.ParseDate(r, errors);
            Assert.AreEqual(0, errors.Count);
            Assert.AreEqual("1972-11-30", result.Contents);
            Assert.AreEqual(1, result.Extensions.Count);
            Assert.AreEqual("http://hl7.org/fhir/profile/@iso-21090#nullFlavor", result.Extensions[0].Url.ToString());
            Assert.IsTrue(result.Extensions[0].Value is Code);
            Assert.AreEqual("UNK", ((Code)result.Extensions[0].Value).Contents);
        }


        [TestMethod]
        public void TestParseExtendedPrimitiveWithOtherElements()
        {
            string xmlString =
                @"<dateOfBirth xmlns='http://hl7.org/fhir' value='1972-11-30'>
                    <crap />
                    <extension>
                       <url value='http://hl7.org/fhir/profile/@iso-21090#nullFlavor' />
                       <valueCode value='UNK' />
                    </extension>
                  </dateOfBirth>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            Date result = PrimitiveParser.ParseDate(r, errors);
            Assert.AreNotEqual(0, errors.Count);
            Assert.IsTrue(errors.ToString().Contains("crap"));

            xmlString =
                @"<dateOfBirth xmlns='http://hl7.org/fhir' value='1972-11-30'>
                    <crap xmlns=""http://furore.com"" />
                    <extension>
                       <url value='http://hl7.org/fhir/profile/@iso-21090#nullFlavor' />
                       <valueCode value='UNK' />
                    </extension>
                  </dateOfBirth>";

            xr = fromString(xmlString); xr.Read();
            r = new XmlFhirReader(xr);

            errors.Clear();
            result = PrimitiveParser.ParseDate(r, errors);
            Assert.AreNotEqual(0, errors.Count);
            Assert.IsTrue(errors.ToString().Contains("crap"));




            string jsonString = @"{ ""dateOfBirth"" : 
                                { 
                                    ""value"" : ""1972-11-30"",
                                    ""crap"" : {},
                                    ""extension"" : [
                                    {
                                        ""url"" : { ""value"" : ""http://hl7.org/fhir/profile/@iso-21090#nullFlavor"" },
                                        ""valueCode"" : { ""value"" : ""UNK"" }
                                    } ]
                                }
                            }";

            var jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            JsonFhirReader jfr = new JsonFhirReader(jr);
            errors.Clear();
            result = PrimitiveParser.ParseDate(jfr, errors);
            Assert.AreNotEqual(0, errors.Count);
            Assert.IsTrue(errors.ToString().Contains("crap"));
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