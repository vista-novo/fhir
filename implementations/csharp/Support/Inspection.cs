using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HL7.Fhir.Instance.Support
{
    [AttributeUsage(AttributeTargets.Class, Inherited = false, AllowMultiple = false)]
    sealed class FhirResourceAttribute : Attribute
    {
        readonly string name;

        // This is a positional argument
        public FhirResourceAttribute(string name)
        {
            this.name = name;
        }

        public string Name
        {
            get { return name; }
        }

        // This is a named argument
        //public int NamedInt { get; set; }
    }

    [AttributeUsage(AttributeTargets.Class, Inherited = false, AllowMultiple = false)]
    sealed class FhirCompositeAttribute : Attribute
    {
        readonly string name;

        // This is a positional argument
        public FhirCompositeAttribute(string name)
        {
            this.name = name;
        }

        public string Name
        {
            get { return name; }
        }
    }
}
