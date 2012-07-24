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
    public class JsonSerializerTests
    {
        [TestMethod]
        public void SerializePrimitive()
        {
            Action<IFhirWriter> action = writer =>
                 {
                     FhirBoolean bl = new FhirBoolean(true);
                     bl.ToJson(writer);
                 };

            string j = writeStuffJ(action);
            string x = writeStuffX(action);

            Assert.AreEqual("{\"x\":\"true\"}",j);
            Assert.AreEqual("<x xmlns=\"http://hl7.org/fhir\">true</x>", x);

            Action<IFhirWriter> action2 = writer =>
                {
                    FhirBoolean bl = new FhirBoolean(null);
                    bl.Dar = DataAbsentReason.Notasked;
                    bl.ToJson(writer,true);
                };

            j = writeStuffJ(action2);
            x = writeStuffX(action2);

            Assert.AreEqual("{\"x\":{\"dataAbsentReason\":\"notasked\"}}", j);
            Assert.AreEqual("<x dataAbsentReason=\"notasked\" xmlns=\"http://hl7.org/fhir\" />", x);


            Action<IFhirWriter> action3 = writer =>
                {
                    FhirBoolean bl = new FhirBoolean(false);
                    bl.ReferralId = "3141";
                    JsonPrimitiveSerializer.Serialize(writer, bl);
                };

            j = writeStuffJ(action3);
            x = writeStuffX(action3);

            Assert.AreEqual("{\"x\":{\"_id\":\"3141\",\"value\":\"false\"}}", j);
            Assert.AreEqual("<x id=\"3141\" xmlns=\"http://hl7.org/fhir\">false</x>", x);
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

            p.ToJson(writer);

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

            p.ToJson(writer);

            Assert.AreEqual("", sw.ToString());
        }


        [TestMethod]
        public void LoadAndSerializeLargeResource()
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

            var sw = new StringWriter();
            JsonWriter w = new JsonTextWriter(sw);
            IFhirWriter writer = new JsonFhirWriter(w);
            rep.ToJson(writer);

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
