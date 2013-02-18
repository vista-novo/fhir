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
        public void SerializeElement()
        {
            Identifier id = new Identifier
                {
                    InternalId = "3141",
                    Use = Identifier.IdentifierUse.Official,
                    Label = "SSN",
                    System = new Uri("http://hl7.org/fhir/sid/us-ssn"),
                    Id = "000111111",
                    Period = new Period() { Start = new FhirDateTime(2001, 1, 2), End = new FhirDateTime(2010, 3, 4) },
                    Assigner = new ResourceReference { Type = "Organization", Url = new Uri("../organization/@123", UriKind.Relative), Display = "HL7, Inc" }
                };


            Assert.AreEqual(@"<?xml version=""1.0"" encoding=""utf-16""?>" +
                    @"<element id=""3141"" xmlns=""http://hl7.org/fhir"">" +
                        @"<use value=""official"" />" +
                        @"<label value=""SSN"" />" +
                        @"<system value=""http://hl7.org/fhir/sid/us-ssn"" />" +
                        @"<id value=""000111111"" />" +
                        @"<period><start value=""2001-01-02"" /><end value=""2010-03-04"" /></period>" +
                        @"<assigner><type value=""Organization"" /><url value=""../organization/@123"" /><display value=""HL7, Inc"" /></assigner>" +
                     @"</element>", FhirSerializer.SerializeElementAsXml(id));

            Assert.AreEqual(
                @"{""_id"":""3141"",""use"":{""value"":""official""},""label"":{""value"":""SSN""}," +
                @"""system"":{""value"":""http://hl7.org/fhir/sid/us-ssn""},""id"":{""value"":""000111111""}," +
                @"""period"":{""start"":{""value"":""2001-01-02""},""end"":{""value"":""2010-03-04""}}," +
                @"""assigner"":{""type"":{""value"":""Organization""},""url"":{""value"":""../organization/@123""}," +
                @"""display"":{""value"":""HL7, Inc""}}}", FhirSerializer.SerializeElementAsJson(id));
        }


        [TestMethod]
        public void PolymorphAndArraySerialization()
        {
            Extension ext = new Extension()
                {
                    Url = new Uri("http://hl7.org/fhir/profiles/@3141#test"),
                    Value = new FhirBoolean(true),
                    NestedExtensions = new List<Extension>()
                        {
                            new Extension()
                            {
                                Value = new Coding() { Code = "R51", System = new Uri("http://hl7.org/fhir/sid/icd-10") } 
                            }
                        }
                };

            Assert.AreEqual(@"<?xml version=""1.0"" encoding=""utf-16""?>" +
                @"<element xmlns=""http://hl7.org/fhir""><url value=""http://hl7.org/fhir/profiles/@3141#test"" /><valueBoolean value=""true"" />" +
                @"<extension><valueCoding><system value=""http://hl7.org/fhir/sid/icd-10"" /><code value=""R51"" /></valueCoding></extension>" +
                @"</element>", FhirSerializer.SerializeElementAsXml(ext));
            Assert.AreEqual(
                @"{""url"":{""value"":""http://hl7.org/fhir/profiles/@3141#test""},""valueBoolean"":{""value"":""true""}," +
                @"""extension"":[{""valueCoding"":{""system"":{""value"":""http://hl7.org/fhir/sid/icd-10""},""code"":{""value"":""R51""}}}]}",
                FhirSerializer.SerializeElementAsJson(ext));
        }

        [TestMethod]
        public void ResourceWithExtensionAndNarrative()
        {
            Patient p = new Patient()
            {
                InternalId = "Ab4",
                Identifiers = new List<Identifier> { new Identifier() { Id = "3141" } },
                Details = new Demographics()
                {
                    BirthDate = new FhirDateTime(1972, 11, 30),
                    Names = new List<HumanName> {
                        new HumanName() { Givens = new List<FhirString>() { "Wouter", "Gert" },
                                   Familys = new List<FhirString>() { new FhirString() { Contents = "van der", 
                                        Extensions = new List<Extension> { new Extension 
                                                        { Url= new Uri("http://hl7.org/fhir/profile/@iso-21090#name-qualifier"),
                                                            Value = new Code("VV") } } }, "Vlies" } } }
                },

                Text = new Narrative()
                 {
                     Status = Narrative.NarrativeStatus.Generated,
                     Div = "<div xmlns='http://www.w3.org/1999/xhtml'>Patient 3141 - Wouter Gert, nov. 30th, 1972</div>"
                 }
            };

            Assert.AreEqual(@"<?xml version=""1.0"" encoding=""utf-16""?>" +
                @"<Patient id=""Ab4"" xmlns=""http://hl7.org/fhir""><identifier><id value=""3141"" /></identifier>" +
                @"<details><name>" +
                    @"<family value=""van der"">" +
                        @"<extension><url value=""http://hl7.org/fhir/profile/@iso-21090#name-qualifier"" /><valueCode value=""VV"" /></extension>" +
                    @"</family><family value=""Vlies"" /><given value=""Wouter"" /><given value=""Gert"" /></name>" +
                    @"<birthDate value=""1972-11-30"" /></details>" +
                @"<text><status value=""generated"" /><div xmlns='http://www.w3.org/1999/xhtml'>Patient 3141 - Wouter Gert, nov. 30th, 1972</div></text>" +
                @"</Patient>", FhirSerializer.SerializeResourceAsXml(p));

            Assert.AreEqual(@"{""Patient"":{""_id"":""Ab4"",""identifier"":[{""id"":{""value"":""3141""}}]," +
                @"""details"":{""name"":[{""family"":[{""value"":""van der""," +
                    @"""extension"":[{""url"":{""value"":""http://hl7.org/fhir/profile/@iso-21090#name-qualifier""},""valueCode"":{""value"":""VV""}}]}," +
                    @"{""value"":""Vlies""}],""given"":[{""value"":""Wouter""},{""value"":""Gert""}]}],""birthDate"":{""value"":""1972-11-30""}}," +
                @"""text"":{""status"":{""value"":""generated""},""div"":""<div xmlns='http://www.w3.org/1999/xhtml'>" +
                    @"Patient 3141 - Wouter Gert, nov. 30th, 1972</div>""}}}", FhirSerializer.SerializeResourceAsJson(p));
        }
    }
}
