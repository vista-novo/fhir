using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Parsers;
using System.Xml;
using System.IO;

namespace HL7.Fhir.Instance.Tests
{

    [TestClass]
    public class TestResourceParser
    {
        [TestMethod]
        public void TestEnumParsing()
        {
            Code<LabReport.LabReportStatus> c =
                Code<LabReport.LabReportStatus>.Parse("final");

            Assert.AreEqual(LabReport.LabReportStatus.Final, c.Value);

            Code<LabReport.LabResultFlag> f =
                Code<LabReport.LabResultFlag>.Parse("++");

            Assert.AreEqual(LabReport.LabResultFlag.PlusPlus, f.Value);
        }

        [TestMethod]
        public void TestInstantParsing()
        {
            Instant i = Instant.Parse("2011-03-04T11:45:33+11:00");

            //Assert.AreEqual("2011-03-04T11:45:33+11:00", i.ToString());
        }

        [TestMethod]
        public void TestParsePrimitive()
        {
            string xmlString = "<someElem id='piet'>true</someElem>";

            XmlTextReader r = new XmlTextReader(new StringReader(xmlString));
            r.Read();

            string id;
            FhirBoolean result = XmlPrimitiveParser.ParseFhirBoolean(r, out id);
            Assert.AreEqual(true,result.Value);
            Assert.AreEqual("piet",id);
        }

        [TestMethod]
        public void TestParseSimpleComposite()
        {
            string xmlString = @"<x xmlns='http://hl7.org/fhir'>
                                    <code>G44.1</code>
                                    <system>http://hl7.org/fhir/sid/icd-10</system>
                                 </x>";

            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            XmlReader r =  XmlReader.Create(new StringReader(xmlString), settings);
    
            r.Read();
  
            Coding result = XmlCodingParser.ParseCoding(r);
            Assert.AreEqual("G44.1", result.Code.Value);
            Assert.AreEqual("http://hl7.org/fhir/sid/icd-10", result.System.Value.ToString());
            Assert.IsNull(result.Display);
        }


        [TestMethod]
        public void TestParseLargeComposite()
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            XmlReader r = XmlReader.Create(new StreamReader(@"C:\Users\Ewout\Documents\tst.xml"), settings);

            while (!r.IsStartElement()) ;           

            LabReport rep = XmlLabReportParser.ParseLabReport(r);
        }
          

    }
}
