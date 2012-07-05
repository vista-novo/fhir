using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HL7.Fhir.Instance.Support
{
    public class Code<T> : Primitive<T>
    {
        public Code(T value)
            : base(value)
        {
        }

        public static implicit operator Code<T>(T value)
        {
            return new Code<T>(value);
        }

        public static implicit operator T(Code<T> value)
        {
            return value.Value;
        }
    }
}
