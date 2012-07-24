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
        public static string BuildPolymorphicName(string elementName, Type elementType)
        {
            return null;
        }

        public static void SerializeAttributes(JsonWriter writer, Data elem)
        {
            if (elem.ReferralId != null)
            {
                writer.WritePropertyName("_id");
                writer.WriteValue(elem.ReferralId);
            }

            if (elem.Dar.HasValue)
            {
                writer.WritePropertyName("dataAbsentReason");
                writer.WriteValue(EnumHelper.EnumToString(elem.Dar.Value,
                    typeof(DataAbsentReason)));
            }
        }

        public static void SerializeAttributes(IFhirWriter writer, Data elem)
        {
            if (elem.ReferralId != null)
                writer.WriteRefId(elem.ReferralId);

            if (elem.Dar.HasValue)
                writer.WriteDar(EnumHelper.EnumToString(elem.Dar.Value,typeof(DataAbsentReason)));
        }
    }
}
