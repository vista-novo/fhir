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
    public class RoundtripTest
    {
        [TestMethod]
        public void FullRoundtripOfAllExamples()
        {
            string path = @"..\..\..\..\..\publish\examples";

            Debug.WriteLine("Looking for *.xml files in " + path);

            var files = Directory.EnumerateFiles(path, "*.xml");

            foreach (string file in files.Where(p=>!p.Contains("-roundtrip")))
            {
                string filename = Path.GetFileNameWithoutExtension(file);                    
                baseFilename = Path.Combine(Path.GetDirectoryName(file), filename);

                Debug.WriteLine("Roundtripping " + filename);
                bool isFeed = filename.Contains("examples");

                if( !isFeed )
                {
                    Debug.WriteLine("  Reading from xml...");
                    testSingleResource(file);
                }
                else
                {
                    Debug.WriteLine("  Reading from xml feed...");
                    testFeed(file);
                }

                Debug.WriteLine("  Done!");
            }
        }

        private string baseFilename;

        private void testFeed(string file)
        {
            Support.Bundle bundleResult;
            Support.ErrorList errors = new Support.ErrorList();

            using (XmlReader xr = createReader(file))
            {
                bundleResult = Support.Bundle.Load(xr, errors);

                xr.Close();
            }

            if (errors.Count > 0)
                Debug.WriteLine("=== Xml Feed Parse errors ===" + Environment.NewLine + errors.ToString());
            else
            {
                string jsonFile = baseFilename + "-roundtrip.json";
                string xmlFile = Path.ChangeExtension(jsonFile, ".xml");

                Debug.WriteLine("  Writing Xml feed...");

                using (XmlWriter xw = XmlWriter.Create(xmlFile))
                {
                    bundleResult.Save(xw);
                }
            }
        }


        private void testSingleResource(string file)
        {
            Model.Resource singleResult;
            Support.ErrorList errors = new Support.ErrorList();

            using (XmlReader xr = createReader(file))
            {
                singleResult = ResourceParser.ParseResource(new XmlFhirReader(xr), errors);
                xr.Close();
            }

            if (errors.Count > 0)
                Debug.WriteLine("=== Xml Parse errors ===" + Environment.NewLine + errors.ToString());
            else
            {
                string jsonFile = baseFilename + "-roundtrip.json";

                using (JsonTextWriter w = new JsonTextWriter(new System.IO.StreamWriter(jsonFile)))
                {
                    Debug.WriteLine("  Writing json...");
                    singleResult.Save(w);
                    w.Close();
                }

                testSingleJsonResource(jsonFile);
            }
        }


        private void testSingleJsonResource(string jsonFile)
        {
            Support.ErrorList errors = new Support.ErrorList();
            Model.Resource singleResult;

            using (JsonTextReader jr = new JsonTextReader(new System.IO.StreamReader(jsonFile)))
            {
                Debug.WriteLine("  Reading from json...");
                singleResult = ResourceParser.ParseResource(new JsonFhirReader(jr), errors);
                jr.Close();
            }

            if (errors.Count > 0)
                Debug.WriteLine("=== Json Parse errors ===" + Environment.NewLine + errors.ToString());
            else
            {
                string xmlFile = Path.ChangeExtension(jsonFile, ".xml");
                
                using (XmlWriter xw = new XmlTextWriter(new System.IO.StreamWriter(xmlFile)))
                {
                    Debug.WriteLine("  Writing xml...");
                    singleResult.Save(xw);
                    xw.Close();
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
