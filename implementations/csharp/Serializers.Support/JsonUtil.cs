using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Newtonsoft.Json;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Serializers
{
    public class JsonUtil
    {
        public static void SerializeElementArray<T>(JsonWriter writer, List<T> elements,
                    Action<JsonWriter,T> serializer)
        {
            writer.WriteStartArray();
            foreach(T element in elements)
            {
                serializer(writer,element);
            }
            writer.WriteEndArray();
        }

        public static void SerializeAttributes(JsonWriter writer, Data elem)
        {
            if (elem.ReferralId != null)
            {
                writer.WritePropertyName("@id");
                writer.WriteValue(elem.ReferralId);
            }

            if (elem.Dar.HasValue)
            {
                writer.WritePropertyName("@dataAbsentReason");
                writer.WriteValue(elem.Dar.Value.ToString());
            }
        }
    }
}
