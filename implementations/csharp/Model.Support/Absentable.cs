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

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HL7.Fhir.Instance.Model
{
    public class Absentable
    {
        public Nullable<HL7.Fhir.Instance.Model.DataAbsentReason> Dar { get; set; }
    }

    public class Absentable<T> : Absentable where T: Data
    {
        public T Value { get; set; }


        public Absentable(T value)
        {
            this.Value = value;
        }

        public Absentable()
        {
        }

        public Absentable(T value, HL7.Fhir.Instance.Model.DataAbsentReason dar)
        {
            this.Value = value;
            this.Dar = dar;
        }

        public override bool Equals(object other)
        {
            if (other == null) return false;

            if (Value.Equals(other) && typeof(Absentable).IsAssignableFrom(other.GetType()))
            {
                return Dar.Equals(((Absentable)other).Dar);
            }
            else
                return false;
        }

        public override int GetHashCode()
        {
            return Value.GetHashCode() ^ Dar.GetHashCode();
        }

        public override string ToString()
        {
            string result = Value.ToString();

            if (Dar.HasValue)
                result += " (dar: " + Dar.ToString() + ")";

            return result;
        }

        public static implicit operator Absentable<T>(T value)
        {
            return new Absentable<T>(value);
        }


        public static explicit operator T(Absentable<T> value)
        {
            return value.Value;
        }

        public string ValidateData()
        {
            // Cannot introduce incorrect data, so validation depends
            // on our nested actual value of the element
            return Value.ValidateData();
        }
    }
}
