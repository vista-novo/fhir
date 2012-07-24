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

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class TestRunnner
    {
        [TestMethod]
        public void FullRoundtripOfAllExamples()
        {
            string path = @"..\..\..\..\..\publish\examples";

            Console.WriteLine("Looking for *.xml files in " + path);

            var files = Directory.EnumerateFiles(path, "*.xml");

            foreach (string file in files)
            {
                Support.ErrorList errors = new Support.ErrorList();

                try
                {
                    Console.WriteLine("Reading from xml file " + file);

                    using (XmlReader r = createReader(file))
                    {
                        Model.Resource resource = XmlResourceParser.ParseResource(r, errors);
                        if (errors.Count > 0)
                            Console.WriteLine("Parse errors:" + errors.ToString());
                        else
                        {
                            Console.WriteLine("Writing json");
                            string jsonFile = Path.ChangeExtension(file, "json");
                            using (JsonTextWriter wr = new JsonTextWriter(new System.IO.StreamWriter(jsonFile)))
                            {
                                resource.ToJson(wr);
                                wr.Close();
                            }
                        }
                        errors.Clear();
                    }
                }
                catch (Exception e)
                {
                    Console.WriteLine("Unexpected exception: ");
                    Console.WriteLine(e.Message);
                }
            }

            Console.WriteLine("Ready....press enter to quit");

            Console.ReadLine();
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
