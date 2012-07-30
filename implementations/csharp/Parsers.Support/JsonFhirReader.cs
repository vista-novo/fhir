using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using HL7.Fhir.Instance.Support;
using Newtonsoft.Json;

namespace HL7.Fhir.Instance.Parsers
{
    public class JsonFhirReader : IFhirReader
    {
        private JsonTextReader jr;

        public JsonFhirReader(JsonTextReader jr)
        {
            this.jr = jr;
        }

        public void MoveToContent()
        {
            throw new NotImplementedException();
        }

        public string CurrentElementName
        {
            get{
                // Path can be strings like a.b[2].c[4]
                // The current element is the last part, sans the array markers
                string pathPart = jr.Path.Split('.').Last();

                if (pathPart[pathPart.Length-1] == ']')
                    pathPart = pathPart.Substring(0, pathPart.IndexOf('['));

                return pathPart;
            }
        }

        public bool IsAtStartElement()
        {
            return jr.TokenType == JsonToken.PropertyName;
        }

        public bool IsAtEndElement()
        {
            return jr.TokenType == JsonToken.EndObject;
        }

        public void ReadEndComplexContent()
        {
            if (IsAtEndElement())
                jr.Read();
            else
                throw new FormatException("Expected to find end of complex content");
        }

        public void SkipContents(string name)
        {
            while (!(IsAtEndElement() && CurrentElementName == name) && jr.Read()) ;
        }

        public bool IsAtXhtmlElement()
        {
            return jr.TokenType == JsonToken.PropertyName;
        }

        public string ReadXhtmlContents()
        {
            // Read away property name
            jr.Read();

            if (jr.TokenType == JsonToken.String)
            {
                string value = (string)jr.Value;
                jr.Read();
                return value;
            }
            else
                throw new FormatException("Xhtml values should be simple strings");
        }

        public int LineNumber
        {
            get { return jr.LineNumber; }
        }

        public int LinePosition
        {
            get { return jr.LinePosition; }
        }

        public void ReadStartArray()
        {
            // Read away name of array property
            jr.Read();

            // Read away array start
            if (jr.TokenType == JsonToken.StartArray)
                jr.Read();
            else
                throw new FormatException("Expected start of array");
        }

        public bool IsAtArrayElement()
        {
            return jr.TokenType != JsonToken.EndArray;
        }

        public void ReadEndArray()
        {
            if (jr.TokenType == JsonToken.EndArray)
                jr.Read();
            else
                throw new FormatException("Expected end of array");
        }


        private void skipPropertyName()
        {
            if (jr.TokenType == JsonToken.PropertyName) jr.Read();
        }


        public string ReadPrimitiveElementContents(out string refid, out string dar)
        {
            refid = null;
            dar = null;
            string elementName = CurrentElementName;
            
            // Read away property name
            skipPropertyName();

            if (jr.TokenType == JsonToken.StartObject)
            {
                // complex primitive
                jr.Read();

                readAttributes(out refid, out dar);

                if (jr.TokenType == JsonToken.PropertyName && (string)jr.Value == "value")
                {
                    jr.Read();
                    return readPrimitiveValue();
                }

                return null;
            }
            else if (jr.TokenType == JsonToken.String)
            {
                // simple primitive
                return readPrimitiveValue();
            }
            else
                throw new FormatException(String.Format("Primitive {0} must be a complex object or a string",elementName));
        }


        private string readPrimitiveValue()
        {
            string value = (string)jr.Value;

            if (value == String.Empty) value = null;

            jr.Read();
            
            return value;
        }


        public bool ReadStartComplexContent(out string refid, out string dar)
        {
            // Read away the complex property's name, if it is there
            skipPropertyName();

            if (jr.TokenType != JsonToken.StartObject)
                throw new FormatException("Expected a StartObject JSon token");

            jr.Read();

            // Check the attributes
            readAttributes(out refid, out dar);

            return true;
        }

        private void readAttributes(out string refid, out string dar)
        {
            refid = null;
            dar = null;

            if (jr.TokenType == JsonToken.PropertyName && (string)jr.Value == "_id")
            {
                refid = jr.ReadAsString();
                jr.Read();
            }

            if (jr.TokenType == JsonToken.PropertyName && (string)jr.Value == "dataAbsentReason")
            {
                dar = jr.ReadAsString();
                jr.Read();
            }

            return;
        }
    }
}
