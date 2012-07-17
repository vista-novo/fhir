using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Newtonsoft.Json;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Serializers
{
    public class JsonHumanNameSerializer
    {
        public static void SerializeHumanNamePartComponent(JsonWriter writer, HumanName.HumanNamePartComponent value)
        {
            Resource r;

            if (r.GetType() == typeof(Patient))
            {
            }
        }

        public static void SerializeHumanName(JsonWriter writer, HumanName value)
        {
            writer.WriteStartObject();

            JsonUtil.SerializeAttributes(writer, value);

            if (value.Use != null)
            {
                writer.WritePropertyName("name");
                JSonPrimitiveSerializer.Serialize(writer,value.Use);
            }

            if (value.Part != null && value.Part.Count > 0)
            {
                writer.WritePropertyName("part");
                JsonUtil.SerializeElementArray(writer, value.Part,
                 (w, m) => { JsonHumanNameSerializer.SerializeHumanNamePartComponent(w, m); });
            }

            writer.WriteEndObject();
        }
    }
}
