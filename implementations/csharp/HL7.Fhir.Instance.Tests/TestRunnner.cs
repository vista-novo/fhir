using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;
using HL7.Fhir.Instance.Parsers;
using HL7.Fhir.Instance.Serializers;
using System.Xml;
using Newtonsoft.Json;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Diagnostics;

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class TestRunnner
    {
        [TestMethod]
        public void FullRoundtripOfAllExamples()
        {
            string path = @"..\..\..\..\..\publish\examples";

            Debug.WriteLine("Looking for *.xml files in " + path);

            var files = Directory.EnumerateFiles(path, "*.xml");

            foreach (string file in files)
            {
                Support.ErrorList errors = new Support.ErrorList();

                try
                {
                    string filename = Path.GetFileNameWithoutExtension(file);
                    string baseFilename = Path.Combine(Path.GetDirectoryName(file), filename);

                    Debug.WriteLine("Roundtripping " + filename);

                    using (XmlReader xr = createReader(file))
                    {
                        Debug.WriteLine("  Reading from xml...");
                        Model.Resource resource = ResourceParser.ParseResource(new XmlFhirReader(xr), errors);
                        xr.Close();

                        if (errors.Count > 0)
                            Debug.WriteLine("=== Xml Parse errors ===" + Environment.NewLine + errors.ToString());
                        else
                        {
                            string jsonFile = baseFilename + "-roundtrip.json";
                            using (JsonTextWriter w = new JsonTextWriter(new System.IO.StreamWriter(jsonFile)))
                            {
                                Debug.WriteLine("  Writing json...");
                                resource.Save(w);
                                w.Close();
                            }

                            using(JsonTextReader jr = new JsonTextReader(new System.IO.StreamReader(jsonFile)))
                            {
                                Debug.WriteLine("  Reading from json...");
                                Model.Resource r2 = ResourceParser.ParseResource(new JsonFhirReader(jr), errors);
                                jr.Close();

                                if (errors.Count > 0)
                                    Debug.WriteLine("=== Json Parse errors ===" + Environment.NewLine + errors.ToString());
                                else
                                {
                                    string xmlFile = Path.ChangeExtension(jsonFile, ".xml");
                                    using (XmlWriter xw = new XmlTextWriter(new System.IO.StreamWriter(xmlFile)))
                                    {
                                        Debug.WriteLine("  Writing xml...");
                                        r2.Save(xw);
                                        xw.Close();
                                    }

                                    Debug.WriteLine("  Done!");
                                }

                            }
                        }
                        errors.Clear();
                    }
                }
                catch (Exception e)
                {
                    Debug.WriteLine("Unexpected exception: ");
                    Debug.WriteLine(e.Message);
                }
            }
        }

        private static XmlReader createReader(string filename)
        {
            var settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;

           return XmlReader.Create(filename, settings);
        }
    }
}
