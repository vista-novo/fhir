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
    public class CompositeParserTests
    {
       
        [TestMethod]
        public void TestParseEmptyComposite()
        {
            string xmlString = @"<x id='4' xmlns='http://hl7.org/fhir' />";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            Coding result = CodingParser.ParseCoding(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(result);
            Assert.AreEqual("4", result.ReferralId);

            string jsonString = "{ \"someElem\" : { \"_id\" : \"4\" } }";
            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = CodingParser.ParseCoding(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(result);
            Assert.AreEqual("4", result.ReferralId);
        }

        [TestMethod]
        public void TestContinueOnConsecutivePrimitives()
        {
            throw new NotImplementedException();
        }


        [TestMethod]
        public void TestAttributesParsing()
        {
            //string xmlString = "<someElem xmlns='http://hl7.org/fhir' id='12' " +
            //                        "dataAbsentReason='asked'>1234</someElem>";
            string xmlString = "<someElem xmlns='http://hl7.org/fhir' id='12' " +
                                ">1234</someElem>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            IdRef result = PrimitiveParser.ParseIdRef(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual("1234", result.Contents);
            Assert.AreEqual("12", result.ReferralId);
       //     Assert.AreEqual(DataAbsentReason.Asked, result.Dar);

//            string jsonString = "{ \"someElem\" : { \"_id\" : \"12\", \"dataAbsentReason\" : \"asked\", \"value\" : \"1234\" } }";
            string jsonString = "{ \"someElem\" : { \"_id\" : \"12\", \"value\" : \"1234\" } }";

            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = PrimitiveParser.ParseIdRef(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual("1234", result.Contents);
            Assert.AreEqual("12", result.ReferralId);
         //   Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
        }


        [TestMethod]
        public void TestParseLanguageAttribute()
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


        [TestMethod]
        public void TestNarrativeParsing()
        {
            string xmlString = @"<text xmlns='http://hl7.org/fhir'>
                                    <status>generated</status>
                                    <div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>
                                 </text>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            Narrative result = NarrativeParser.ParseNarrative(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Contents);
            Assert.IsTrue(result.Div != null && result.Div.Contents != null);

            string xmlString2 = @"<text xmlns='http://hl7.org/fhir'>
                                    <status>generated</status>
                                    <xhtml:div xmlns:xhtml='http://www.w3.org/1999/xhtml'>Whatever</xhtml:div>
                                 </text>";
            errors.Clear();

            xr = fromString(xmlString2); xr.Read();
            r = new XmlFhirReader(xr);

            result = NarrativeParser.ParseNarrative(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Contents);
            Assert.IsTrue(result.Div != null && result.Div.Contents != null);

            string xmlString3 = @"<text xmlns='http://hl7.org/fhir' xmlns:xhtml='http://www.w3.org/1999/xhtml'>
                                    <status>generated</status>
                                    <xhtml:div>Whatever</xhtml:div>
                                 </text>";
            errors.Clear();

            xr = fromString(xmlString3); xr.Read();
            r = new XmlFhirReader(xr);

            result = NarrativeParser.ParseNarrative(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Contents);
            Assert.IsTrue(result.Div != null && result.Div.Contents != null);

            string jsonString = "{ \"someElem\" : { \"status\" : \"generated\", \"div\" : " +
                "\"<div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>\" } }";

            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = NarrativeParser.ParseNarrative(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(Narrative.NarrativeStatus.Generated, result.Status.Contents);
            Assert.IsTrue(result.Div != null && result.Div.Contents != null);
        }

        [TestMethod]
        public void TestParseSimpleComposite()
        {
            string xmlString = @"<x id='x4' xmlns='http://hl7.org/fhir'>
                                    <system>http://hl7.org/fhir/sid/icd-10</system>
                                    <code>G44.1</code>
                                 </x>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            Coding result = CodingParser.ParseCoding(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual("x4", result.ReferralId);
         //   Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
            Assert.AreEqual("G44.1", result.Code.Contents);
            Assert.AreEqual("http://hl7.org/fhir/sid/icd-10", result.System.Contents.ToString());
            Assert.IsNull(result.Display);

            string jsonString = "{ \"someElem\" : { \"_id\" : \"x4\", " +
                    "\"system\": \"http://hl7.org/fhir/sid/icd-10\", \"code\": \"G44.1\" } }";

            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = CodingParser.ParseCoding(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual("x4", result.ReferralId);
        //    Assert.AreEqual(DataAbsentReason.Asked, result.Dar);
            Assert.AreEqual("G44.1", result.Code.Contents);
            Assert.AreEqual("http://hl7.org/fhir/sid/icd-10", result.System.Contents.ToString());
            Assert.IsNull(result.Display);
        }

        [TestMethod]
        public void TestCompositeWithRepeatingElement()
        {
            string xmlString = @"<x xmlns='http://hl7.org/fhir'><coding><system>http://hl7.org/fhir/sid/icd-10</system><code>R51</code></coding>" +
                "<coding id='1'><system>http://snomed.info</system><code>25064002</code></coding></x>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            CodeableConcept result = CodeableConceptParser.ParseCodeableConcept(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(2, result.Coding.Count);
            Assert.AreEqual("R51", result.Coding[0].Code.Contents);
            Assert.AreEqual("25064002", result.Coding[1].Code.Contents);
            Assert.AreEqual("http://snomed.info/", result.Coding[1].System.Contents.ToString());
            Assert.AreEqual("1", result.Coding[1].ReferralId);


            string jsonString = "{ \"someElem\" : { \"coding\" : [ " +
                "{ \"system\": \"http://hl7.org/fhir/sid/icd-10\", \"code\" : \"R51\"  }," +
                "{ \"_id\":\"1\", \"system\": \"http://snomed.info\", \"code\" : \"25064002\" }" +
                "] } }";

            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = CodeableConceptParser.ParseCodeableConcept(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(2, result.Coding.Count);
            Assert.AreEqual("R51", result.Coding[0].Code.Contents);
            Assert.AreEqual("25064002", result.Coding[1].Code.Contents);
            Assert.AreEqual("http://snomed.info/", result.Coding[1].System.Contents.ToString());
            Assert.AreEqual("1", result.Coding[1].ReferralId);
        }

        [TestMethod]
        public void TestCompositeWithPolymorphicElement()
        {
            string xmlString = @"<extension xmlns='http://hl7.org/fhir'>" +
                "<url>http://hl7connect.healthintersections.com.au/svc/fhir/profile/@iso-21090#name-qualifier</url>" +
                "<ref>n1</ref><valueCode>MID</valueCode></extension>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            Extension result = ExtensionParser.ParseExtension(r, errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(typeof(Code), result.Value.GetType());


            string jsonString = "{ \"extension\" : { " +
                   "\"url\":\"http://hl7connect.healthintersections.com.au/svc/fhir/profile/@iso-21090#name-qualifier\", " +
                   "\"ref\":\"n1\", \"valueCode\" : \"MID\" } }";

            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = ExtensionParser.ParseExtension(new JsonFhirReader(jr), errors);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.AreEqual(typeof(Code), result.Value.GetType());
        }


        [TestMethod]
        public void TestParseUnknownMembersAndRecover()
        {
            string xmlString = @"<x xmlns='http://hl7.org/fhir'><coding><system>http://hl7.org/fhir/sid/icd-10</system><ewout>bla</ewout>" +
                "<code>R51</code></coding>" +
                "<coding id='1'><system>http://snomed.info</system><code>25064002</code></coding><grahame></grahame></x>";

            XmlReader xr = fromString(xmlString); xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            CodeableConcept result = CodeableConceptParser.ParseCodeableConcept(r, errors);
            Assert.AreEqual(2,errors.Count);
            Assert.IsTrue(errors[0].ToString().Contains("ewout"));
            Assert.IsTrue(errors[1].ToString().Contains("grahame"));

            string jsonString = "{ \"someElem\" : { \"coding\" : [ " +
                "{ \"system\": \"http://hl7.org/fhir/sid/icd-10\", \"ewout\" : \"bla\", \"code\" : \"R51\" }," +
                "{ \"_id\":\"1\", \"system\": \"http://snomed.info\", \"code\" : \"25064002\"  }" +
                "], \"grahame\" : \"stuff\" } }";

            JsonTextReader jr = new JsonTextReader(new StringReader(jsonString));
            jr.Read(); jr.Read();
            errors.Clear();
            result = CodeableConceptParser.ParseCodeableConcept(new JsonFhirReader(jr), errors);
            Assert.AreEqual(2, errors.Count);
            Assert.IsTrue(errors[0].ToString().Contains("ewout"));
            Assert.IsTrue(errors[1].ToString().Contains("grahame"));
        }


        [TestMethod]
        public void TestParseNameWithExtensions()
        {
            string xmlString =
@"<Patient xmlns='http://hl7.org/fhir'>
    <details>
        <name>
          <use>official</use>  
          <given>Regina</given>
          <prefix id='n1'>Dr.</prefix>
        </name>
    </details>
    <extension>
      <url>http://hl7.org/fhir/profile/@iso-20190</url>
      <ref>n1</ref>
      <valueCoding>
        <system>oid:2.16.840.1.113883.5.1122</system>       
        <code>AC</code>
      </valueCoding>
    </extension>
    <text>
        <status>generated</status>
        <div xmlns='http://www.w3.org/1999/xhtml'>Whatever</div>
    </text>
</Patient>";

            XmlReader xr = fromString(xmlString);
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            Patient p = (Patient)ResourceParser.ParseResource(r, errors);

            Assert.IsTrue(errors.Count() == 0, errors.ToString());
            Assert.IsNotNull(p);
            Assert.AreEqual(1, p.Extensions.Count());
        }


        [TestMethod]
        public void TestParseLargeComposite()
        {
            XmlReader xr = XmlReader.Create(new StreamReader(@"..\..\..\..\..\publish\diagnosticreport-example.xml"));
            IFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            DiagnosticReport rep = (DiagnosticReport)ResourceParser.ParseResource(r, errors);

            Assert.IsNotNull(rep);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());

            Assert.AreEqual("2011-03-04T08:30:00+11:00", rep.DiagnosticTime.ToString());
            Assert.AreEqual(17, rep.Results.Result.Count);

            throw new NotImplementedException("Check values in the inlined results");
//            Assert.AreEqual(typeof(Quantity), rep.Results.Result[1].Value.GetType());
//            Assert.AreEqual((decimal)5.9, (rep.Results.Result[1].Value as Quantity).Value.Contents);
//            Assert.AreEqual("Neutrophils", rep.Results.Result[8].Name.Coding[0].Display.Contents);
        }

        [TestMethod]
        public void TestParseResourceReference()
        {
            string xmlString = @"<x xmlns='http://hl7.org/fhir'>
                <type>Organization</type>
                <url>http://hl7.org/fhir/organization/@1</url>
                                 </x>";

            XmlReader xr = fromString(xmlString); 
            xr.Read();
            XmlFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            ResourceReference result = ResourceReferenceParser.ParseResourceReference(r, errors);

            Assert.AreEqual("Organization", result.Type.Contents);
            Assert.AreEqual("http://hl7.org/fhir/organization/@1", result.Url.Contents.ToString());


            string xmlNestedString = @"<x xmlns='http://hl7.org/fhir'>
                   <Provider>
                 <identifier>
                    <identifier>  
                      <system>htp://www.acme.org/providers</system>
                      <id>23</id>
                    </identifier>
                  </identifier>
              <details>
                <name>
                  <family>Careful</family>
                  <given>Adam</given>
                  <prefix>Dr</prefix>
                </name>
              </details>

              <organization>
                <type>Organization</type>
                <url>1</url>  
              </organization> 

              <!--   Referring Provider for the first 3 months of 2012   -->
              <role>
                <coding>
                  <system>http://hl7.org/fhir/sid/v2-0286</system>
                  <code>RP</code>
                </coding>
              </role>
  
              <period>
                <start>2012-01-01</start>
                <end>2012-03-31</end>
              </period>
            </Provider>
             </x>";

            xr = fromString(xmlNestedString); xr.Read();
            r = new XmlFhirReader(xr);
            errors = new ErrorList();
            result = ResourceReferenceParser.ParseResourceReference(r, errors);

            Assert.IsNotNull(result.InlinedContent);
            Assert.IsInstanceOfType(result.InlinedContent, typeof(Provider));
            Provider prov = (Provider)result.InlinedContent;
            Assert.AreEqual("1", prov.Organization.Url.ToString());
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
                XmlReader xr = XmlReader.Create(new StringReader(text), settings);
                IFhirReader r = new XmlFhirReader(xr);
                ErrorList errors = new ErrorList();
                DiagnosticReport rep = (DiagnosticReport)ResourceParser.ParseResource(r, errors);
            }

            sw.Stop();

            long bytesPerMs = text.Length * repeats / sw.ElapsedMilliseconds;

            File.WriteAllText(@"c:\temp\speedtest.txt", bytesPerMs.ToString() + " bytes per ms");
            Assert.IsTrue(bytesPerMs > 1024);       // Speed is of course very dependent on debug/release and machine
        }

    }
}