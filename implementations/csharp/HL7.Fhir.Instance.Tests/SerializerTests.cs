using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Newtonsoft.Json;
using System.IO;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Serializers;
using System.Xml.Linq;
using System.Xml;
using HL7.Fhir.Instance.Support;
using HL7.Fhir.Instance.Parsers;

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class SerializerTests
    {
        [TestMethod]
        public void SerializePrimitive()
        {
            Action<IFhirWriter> action = writer =>
                 {
                     FhirBoolean bl = new FhirBoolean(true);
                     bl.Save(writer);
                 };

            string j = writeStuffJ(action);
            string x = writeStuffX(action);

            Assert.AreEqual("{\"x\":\"true\"}",j);
            Assert.AreEqual("<x xmlns=\"http://hl7.org/fhir\">true</x>", x);

            Action<IFhirWriter> action2 = writer =>
                {
                    FhirBoolean bl = new FhirBoolean(null);
                    bl.Dar = DataAbsentReason.Notasked;
                    bl.Save(writer,true);
                };

            j = writeStuffJ(action2);
            x = writeStuffX(action2);

            Assert.AreEqual("{\"x\":{\"dataAbsentReason\":\"notasked\"}}", j);
            Assert.AreEqual("<x dataAbsentReason=\"notasked\" xmlns=\"http://hl7.org/fhir\" />", x);


            Action<IFhirWriter> action3 = writer =>
                {
                    FhirBoolean bl = new FhirBoolean(false);
                    bl.ReferralId = "3141";
                    bl.Save(writer,true);
                };

            j = writeStuffJ(action3);
            x = writeStuffX(action3);

            Assert.AreEqual("{\"x\":{\"_id\":\"3141\",\"value\":\"false\"}}", j);
            Assert.AreEqual("<x id=\"3141\" xmlns=\"http://hl7.org/fhir\">false</x>", x);
        }

        [TestMethod]
        public void TestPolymorphSerialization()
        {
            Extension ext = new Extension()
                {
                    Ref = "3141",
                    Value = new FhirBoolean(true),
                    Extension_ = new List<Extension>()
                        {
                            new Extension()
                            {
                                Value = new Coding() { Code = "R51", System = new Uri("http://hl7.org/fhir/sid/icd-10") } 
                            }
                        }
                };

            Action<IFhirWriter> action = writer => ext.Save(writer);

            string j = writeStuffJ(action);
            string x = writeStuffX(action);

            Assert.AreEqual("{\"x\":{\"ref\":\"3141\",\"valueBoolean\":\"true\",\"extension\":" +
                "[{\"valueCoding\":{\"code\":\"R51\",\"system\":\"http://hl7.org/fhir/sid/icd-10\"}}]}}", j);
            Assert.AreEqual("<x xmlns=\"http://hl7.org/fhir\"><ref>3141</ref><valueBoolean>true</valueBoolean>" +
                            "<extension><valueCoding><code>R51</code><system>http://hl7.org/fhir/sid/icd-10</system>" +
                            "</valueCoding></extension></x>", x);
        }

        [TestMethod]
        public void TestResourceSerialization()
        {
            var sw = new StringWriter();
            JsonWriter w = new JsonTextWriter(sw);
            IFhirWriter writer = new JsonFhirWriter(w);

            Code nl = new Code("dut");
            nl.ReferralId = "lang-1";

            Person p = new Person()
            {
                Id = new Id("34234"),
                Dob = new FhirDateTime(null) { Dar = DataAbsentReason.Notasked },

                Language = new List<Person.PersonLanguageComponent>()
                {
                    new Person.PersonLanguageComponent() { Code = nl, Use = Person.LanguageUse.Fluent },
                    new Person.PersonLanguageComponent() { Code = "cmn", Use = Person.LanguageUse.Useable }
                },

                Name = new List<HumanName>()
                {
                    new HumanName()
                    {
                        Use = HumanName.NameUse.Official,
                        Part = new List<HumanName.HumanNamePartComponent>()
                            {
                                new HumanName.HumanNamePartComponent() 
                                {
                                    Type = HumanName.NamePartType.Given,
                                    Value = "Karen"
                                },
                                new HumanName.HumanNamePartComponent() 
                                {
                                    ReferralId = "n1",
                                    Type = HumanName.NamePartType.Family,
                                    Value = "van"
                                }
                            }
                    }
                 },

                 Text = new Narrative()
                 {
                     Status = Narrative.NarrativeStatus.Generated,
                     Div = XElement.Parse("<div xmlns='http://www.w3.org/1999/xhtml'>stuff</div>")            
                 }
            };

            p.Save(writer);

            Assert.AreEqual("{\"Person\":{\"id\":{\"value\":\"34234\"},\"name\":" +
                "[{\"use\":\"official\",\"part\":[{\"type\":\"given\",\"value\":\"Karen\"}"+
                ",{\"_id\":\"n1\",\"type\":\"family\",\"value\":\"van\"}]}],\"dob\":"+
                "{\"dataAbsentReason\":\"notasked\"},\"language\":[{\"code\":"+
                "{\"_id\":\"lang-1\",\"value\":\"dut\"},\"use\":{\"value\":\"fluent\"}},"+
                "{\"code\":{\"value\":\"cmn\"},\"use\":{\"value\":\"useable\"}}],\"text\":"+
                "{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">stuff</div>\"}}}", sw.ToString());

            sw = new StringWriter();
            XmlWriter wx = new XmlTextWriter(sw);
            writer = new XmlFhirWriter(wx);

            p.Save(writer);

            Assert.AreEqual("<?xml version=\"1.0\" encoding=\"utf-16\"?><Person xmlns=\"http://hl7.org/fhir\">" +
                "<id>34234</id><name><use>official</use><part><type>given</type><value>Karen</value></part>" +
                "<part id=\"n1\"><type>family</type><value>van</value></part></name><dob dataAbsentReason=\"notasked\" />" +
                "<language><code id=\"lang-1\">dut</code><use>fluent</use></language><language><code>cmn</code>" +
                "<use>useable</use></language><text><status>generated</status>" +
                "<div xmlns=\"http://www.w3.org/1999/xhtml\">stuff</div></text></Person>", sw.ToString());
        }


        [TestMethod]
        public void LoadAndSerializeLargeResource()
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

            XmlReader xr = XmlReader.Create(new StreamReader(@"..\..\..\..\..\publish\labreport-example.xml"), settings);
            IFhirReader r = new XmlFhirReader(xr);

            ErrorList errors = new ErrorList();
            LabReport rep = (LabReport)ResourceParser.ParseResource(r, errors);

            Assert.IsNotNull(rep);
            Assert.IsTrue(errors.Count() == 0, errors.ToString());

            var sw = new StringWriter();
            JsonWriter w = new JsonTextWriter(sw);
            IFhirWriter writer = new JsonFhirWriter(w);
            rep.Save(writer);

            string result = sw.ToString();
        }
        
        private string writeStuffJ(Action<IFhirWriter> action)
        {
            var sw = new StringWriter();
            JsonWriter w = new JsonTextWriter(sw);
            IFhirWriter writer = new JsonFhirWriter(w);

            writer.WriteStartComplexContent();
            writer.WriteStartElement("x");

            action(writer);

            writer.WriteEndElement();
            writer.WriteEndComplexContent();

            return sw.ToString();
        }


        private string writeStuffX(Action<IFhirWriter> action)
        {
            var sw = new StringWriter();
            XmlWriter w = new XmlTextWriter(sw);
            IFhirWriter writer = new XmlFhirWriter(w);

            writer.WriteStartComplexContent();
            writer.WriteStartElement("x");

            action(writer);

            writer.WriteEndElement();
            writer.WriteEndComplexContent();

            return sw.ToString();
        }
    }
}
