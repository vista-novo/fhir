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

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class XmlParserTests
    {
        [TestMethod]
        public void TestParsePrimitive()
        {
            string xmlString = "<someElem>true</someElem>";
            XmlReader r = fromString(xmlString); r.Read();
            ErrorList errors = new ErrorList();
            FhirBoolean result = XmlPrimitiveParser.ParseFhirBoolean(r, errors);
            Assert.AreEqual(true, result.Contents);
        }

        [TestMethod]
        public void TestParseEmptyPrimitive()
        {
            string xmlString = "<someElem dataAbsentReason='asked' />";

            XmlReader r = fromString(xmlString); r.Read();
            ErrorList errors = new ErrorList();
            FhirBoolean result = XmlPrimitiveParser.ParseFhirBoolean(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
            Assert.IsNotNull(result);
            Assert.IsNull(result.Contents);

            //TODO: Is this a '' value, or an empty/null value?
            string xmlString2 = "<someElem dataAbsentReason='asked'></someElem>";
            r = fromString(xmlString2); r.Read();
            errors.Clear();
            result = XmlPrimitiveParser.ParseFhirBoolean(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
            Assert.IsNotNull(result);
            Assert.IsNull(result.Contents);
        }


        [TestMethod]
        public void TestParseEmptyComposite()
        {
            string xmlString = @"<x dataAbsentReason='asked' xmlns='http://hl7.org/fhir' />";

            XmlReader r = fromString(xmlString); r.Read();

            ErrorList errors = new ErrorList();
            Coding result = XmlCodingParser.ParseCoding(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(result);
            Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
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

        [TestMethod]
        public void TestAttributesParsing()
        {
            string xmlString = "<someElem xmlns='http://hl7.org/fhir' id='12' " +
                                    "dataAbsentReason='asked'>1234</someElem>";

            XmlReader r = fromString(xmlString); r.Read();

            ErrorList errors = new ErrorList();
            IdRef result = XmlPrimitiveParser.ParseIdRef(r, errors);
            Assert.AreEqual("1234", result.Contents);
            Assert.AreEqual("12", result.ReferralId);
            Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
        }


        [TestMethod]
        public void TestNarrativeParsing()
        {
            string xmlString = @"<text xmlns='http://hl7.org/fhir'>
                                    <status>generated</status>
                                    <div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>
                                 </text>";

            XmlReader r = fromString(xmlString); r.Read();

            ErrorList errors = new ErrorList();
            Narrative result = XmlNarrativeParser.ParseNarrative(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Contents);
            Assert.IsTrue(result.Div != null && result.Div.Contents != null);

            string xmlString2 = @"<text xmlns='http://hl7.org/fhir'>
                                    <status>generated</status>
                                    <xhtml:div xmlns:xhtml='http://www.w3.org/1999/xhtml'>Whatever</xhtml:div>
                                 </text>";
            errors.Clear();
            r = fromString(xmlString2); r.Read();
            result = XmlNarrativeParser.ParseNarrative(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Contents);
            Assert.IsTrue(result.Div != null && result.Div.Contents != null);

            string xmlString3 = @"<text xmlns='http://hl7.org/fhir' xmlns:xhtml='http://www.w3.org/1999/xhtml'>
                                    <status>generated</status>
                                    <xhtml:div>Whatever</xhtml:div>
                                 </text>";
            errors.Clear();
            r = fromString(xmlString3); r.Read();
            result = XmlNarrativeParser.ParseNarrative(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Contents);
            Assert.IsTrue(result.Div != null && result.Div.Contents != null);
        }

        [TestMethod]
        public void TestParseSimpleComposite()
        {
            string xmlString = @"<x id='x4' dataAbsentReason='asked' xmlns='http://hl7.org/fhir'>
                                    <code>G44.1</code>
                                    <system>http://hl7.org/fhir/sid/icd-10</system>
                                 </x>";

            XmlReader r = fromString(xmlString); r.Read();

            ErrorList errors = new ErrorList();
            Coding result = XmlCodingParser.ParseCoding(r, errors);
            Assert.AreEqual("x4", result.ReferralId);
            Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
            Assert.AreEqual("G44.1", result.Code.Contents);
            Assert.AreEqual("http://hl7.org/fhir/sid/icd-10", result.System.Contents.ToString());
            Assert.IsNull(result.Display);
        }

        [TestMethod]
        public void TestParseUnknownMembersAndRecover()
        {
            string xmlString = @"<a xmlns='http://hl7.org/fhir'>
                                 <x>
                                    <code>G44.1</code>
                                    <ewout>hoi</ewout>
                                    <system>http://hl7.org/fhir/sid/icd-10</system>
                                 </x>
                                 <y>
                                    <code>G44.2</code>
                                    <system>http://hl7.org/fhir/sid/icd-10</system>
                                 </y>
                                 </a>";

            XmlReader r = fromString(xmlString); r.Read();
            r.Read();

            ErrorList errors = new ErrorList();
            Coding result = XmlCodingParser.ParseCoding(r, errors);
            Assert.IsTrue(errors.Count > 0);
            Assert.IsNull(result);

            errors.Clear();
            result = XmlCodingParser.ParseCoding(r, errors);
            Assert.IsTrue(errors.Count == 0, errors.ToString());
            Assert.AreEqual("G44.2", result.Code.Contents);
        }

        [TestMethod]
        public void TestParseLargeComposite()
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            XmlReader r = XmlReader.Create(new StreamReader(@"..\..\..\..\..\publish\labreport-example.xml"), settings);

            ErrorList errors = new ErrorList();
            LabReport rep = (LabReport)XmlResourceParser.ParseResource(r, errors);

            Assert.IsNotNull(rep);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
        }

        [TestMethod]
        public void TestParsePerformance()
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            string text = File.ReadAllText(@"..\..\..\..\..\publish\labreport-example.xml");
            int repeats = 25;

            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            
            sw.Start();
            
            for (int i = 0; i < repeats; i++)
            {            
                XmlReader r = XmlReader.Create(new StringReader(text), settings);
                ErrorList errors = new ErrorList();
                LabReport rep = (LabReport)XmlResourceParser.ParseResource(r, errors);
            }
            
            sw.Stop();

            long bytesPerMs = text.Length*repeats / sw.ElapsedMilliseconds;
            
            File.WriteAllText(@"c:\temp\speedtest.txt", bytesPerMs.ToString() + " bytes per ms");
            Assert.IsTrue(bytesPerMs > 1024);       // Speed is of course very dependent on debug/release and machine
        }

        [TestMethod]
        public void TestParseNameWithExtensions()
        {
            string xmlString =
@"<Person xmlns='http://hl7.org/fhir'>
    <id>34234</id>
    <name>
      <use>official</use>  
      <part id='n1'>
        <type>prefix</type>
        <value>Dr. phil..</value>
      </part>
      <part>
        <type>given</type>
        <value>Regina</value>
      </part>
    </name>
    <extension>
      <code>name-qualifier</code>
      <profile>http://hl7.org/fhir/profile/@iso-20190</profile>
      <ref>n1</ref>
      <valueCoding>
        <code>AC</code>
        <system>oid:2.16.840.1.113883.5.1122</system>
      </valueCoding>
    </extension>
    <text>
        <status>generated</status>
        <div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>
    </text>
</Person>";

            XmlReader r = fromString(xmlString);

            ErrorList errors = new ErrorList();
            Person p = (Person)XmlResourceParser.ParseResource(r, errors);

            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(p);
            Assert.AreEqual(1, p.Extension.Count());
        }
    }
}