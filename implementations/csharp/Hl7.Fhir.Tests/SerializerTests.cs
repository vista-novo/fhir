using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Newtonsoft.Json;
using System.IO;
using Hl7.Fhir.Model;
using Hl7.Fhir.Serializers;
using System.Xml.Linq;
using System.Xml;
using Hl7.Fhir.Support;
using Hl7.Fhir.Parsers;

namespace Hl7.Fhir.Tests
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
                    NestedExtension = new List<Extension>()
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
                Identifier = new List<Identifier> { new Identifier() { Id = "3141" } },
                Details = new Demographics()
                {
                    BirthDate = new FhirDateTime(1972, 11, 30),
                    Name = new List<HumanName> {
                        new HumanName() { Given = new List<FhirString>() { "Wouter", "Gert" },
                                   Family = new List<FhirString>() { new FhirString() { Contents = "van der", 
                                        Extension = new List<Extension> { new Extension 
                                                        { Url= new Uri("http://hl7.org/fhir/profile/@iso-21090#name-qualifier"),
                                                            Value = new Code("VV") } } }, "Vlies" } } }
                },

                Text = new Narrative()
                 {
                     Status = Narrative.NarrativeStatus.Generated,
                     Div = "<div xmlns='http://www.w3.org/1999/xhtml'>Patient 3141 - Wouter Gert, nov. 30th, 1972</div>"
                 },

                 Contained = new List<Resource>() { new List() { Mode = List.ListMode.Snapshot } }
            };

            Assert.AreEqual(@"<?xml version=""1.0"" encoding=""utf-16""?>" +
                @"<Patient id=""Ab4"" xmlns=""http://hl7.org/fhir"">" +
                @"<text><status value=""generated"" /><div xmlns='http://www.w3.org/1999/xhtml'>Patient 3141 - Wouter Gert, nov. 30th, 1972</div></text>" +
                @"<contained><List><mode value=""snapshot"" /></List></contained>" +
                @"<identifier><id value=""3141"" /></identifier>" +
                @"<details><name>" +
                    @"<family value=""van der"">" +
                        @"<extension><url value=""http://hl7.org/fhir/profile/@iso-21090#name-qualifier"" /><valueCode value=""VV"" /></extension>" +
                    @"</family><family value=""Vlies"" /><given value=""Wouter"" /><given value=""Gert"" /></name>" +
                    @"<birthDate value=""1972-11-30"" /></details>" +
                @"</Patient>", FhirSerializer.SerializeResourceAsXml(p));

            Assert.AreEqual(@"{""Patient"":{""_id"":""Ab4""," +
                 @"""text"":{""status"":{""value"":""generated""},""div"":""<div xmlns='http://www.w3.org/1999/xhtml'>" +
                    @"Patient 3141 - Wouter Gert, nov. 30th, 1972</div>""},"+
                 @"""contained"":[{""List"":{""mode"":{""value"":""snapshot""}}}],"+
                @"""identifier"":[{""id"":{""value"":""3141""}}]," +
                @"""details"":{""name"":[{""family"":[{""value"":""van der""," +
                    @"""extension"":[{""url"":{""value"":""http://hl7.org/fhir/profile/@iso-21090#name-qualifier""},""valueCode"":{""value"":""VV""}}]}," +
                    @"{""value"":""Vlies""}],""given"":[{""value"":""Wouter""},{""value"":""Gert""}]}],""birthDate"":{""value"":""1972-11-30""}}" +
                @"}}", FhirSerializer.SerializeResourceAsJson(p));
        }
    }
}
