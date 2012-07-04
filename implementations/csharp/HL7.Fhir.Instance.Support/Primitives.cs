/*
  Copyright (c) 2011-2012, HL7, Inc
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  

*/


namespace HL7.Fhir.Instance.Support
{
    public class Primitive<T> : Primitive
    {
        public Primitive(T value)
        {
            this.Value = value;
        }

        public Primitive()
        {
        }

        public T Value { get; set; }

        public override bool Equals(object other)
        {
            if(other == null) return false;
            return Value.Equals(other);
        }

        public override int GetHashCode()
        {
            return Value.GetHashCode();
        }

        public override string ToString()
        {
            return Value.ToString();
        }

        public static implicit operator Primitive<T>(T value)
        {
            return new Primitive<T>(value);
        }

        public static implicit operator T(Primitive<T> value)
        {
            return value.Value;
        }
    }

    public class Base64Binary : Primitive<byte[]> { }
    public class FhirBoolean : Primitive<bool> { }
    public class Id : Primitive<string> { }
    public class Oid : Primitive<string> { }
    public class Uuid : Primitive<string> { }
    public class FhirUri : Primitive<System.Uri> { }
    public class Sid : Primitive<System.Uri> { }
    public class FhirString : Primitive<System.String> { }
    public class Code : Code<string> { }
    public class Code<T> : Primitive<T> { }
    public class Instant : Primitive<FhirDateTime> { }
    public class FhirDecimal : Primitive<decimal> { }
    public class Integer : Primitive<int> { }
}
