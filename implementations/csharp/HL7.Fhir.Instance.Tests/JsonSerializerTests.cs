using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Newtonsoft.Json;
using System.IO;
using HL7.Fhir.Instance.Model;
using HL7.Fhir.Instance.Serializers;

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class JsonSerializerTests
    {
        [TestMethod]
        public void SerializePrimitive()
        {
            string result = writeStuff(writer =>
                 {
                     FhirBoolean bl = new FhirBoolean(true);
                     JSonPrimitiveSerializer.Serialize(writer, bl);
                 });

            Assert.AreEqual("{\"x\":\"true\"}",result);

            result = writeStuff(writer =>
            {
                FhirBoolean bl = new FhirBoolean(null);
                bl.Dar = DataAbsentReason.Notasked;
                JSonPrimitiveSerializer.Serialize(writer, bl);
            });

            Assert.AreEqual("{\"x\":{\"dataAbsentReason\":\"Notasked\"}}", result);

            result = writeStuff(writer =>
            {
                FhirBoolean bl = new FhirBoolean(false);
                bl.ReferralId = "3141";
                JSonPrimitiveSerializer.Serialize(writer, bl);
            });

            Assert.AreEqual("{\"x\":{\"id\":\"3141\",\"value\":\"false\"}}", result);
        }


        private string writeStuff(Action<JsonWriter> action)
        {
            var sw = new StringWriter();
            JsonWriter writer = new JsonTextWriter(sw);

            writer.WriteStartObject();
            writer.WritePropertyName("x");

            action(writer);

            writer.WriteEndObject();

            return sw.ToString();
        }
    }
}
