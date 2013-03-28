using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Hl7.Fhir.Model;
using System.Xml.Linq;
using Hl7.Fhir.Support;

namespace Hl7.Fhir.Tests
{
    [TestClass]
    public class ModelTests
    {
        [TestMethod]
        public void ValidateUriAssertions()
        {
            Uri abs = new Uri("http://www.nu.nl", UriKind.RelativeOrAbsolute);
            Assert.IsTrue(abs.IsAbsoluteUri);

            abs = new Uri("http://www.nu.nl");
            Assert.IsTrue(abs.IsAbsoluteUri);
        }


        [TestMethod]
        public void ValidateElementAssertions()
        {
            XElement xr = new XElement("root",
                        new XElement("child", "value"),
                        new XElement("child", "value2"));

            Assert.IsNull(xr.Element("childx"));
            Assert.AreEqual(0,xr.Elements("childx").Count());
            Assert.AreEqual("value",xr.Element("child").Value);
        }

        [TestMethod]
        public void ValidateEncodingNameAssertions()
        {
            Assert.AreEqual(Encoding.UTF8.HeaderName, Encoding.UTF8.WebName);
        }

        [TestMethod]
        public void VerifyCastOperators()
        {
            FhirBoolean b = true;
            FhirBoolean bn = (bool?)null;
            FhirBoolean bn2 = new FhirBoolean(null);
            FhirBoolean bn3 = new FhirBoolean(false);

            Assert.AreEqual(true, b.Contents);
            Assert.IsNotNull(bn);
            Assert.IsNull(bn.Contents);

            bool rb = (bool)b;
            Assert.AreEqual(true, rb);

            bool? rbn = (bool?)b;
            Assert.AreEqual(true, rbn);

            bool? rbn2 = (bool?)bn;
            Assert.IsFalse(rbn2.HasValue);
            Assert.IsNull(rbn2);

            try
            {
                bool rb2 = (bool)bn;
                Assert.Fail();
            }
            catch (InvalidCastException)
            {
            }
        }


        [TestMethod]
        public void TestEnumParsing()
        {
            var c = Code<Address.AddressUse>.Parse("temp");
            Assert.AreEqual(Address.AddressUse.Temp, c.Contents);
            Assert.AreEqual("temp", c.ToString());

            var f = Code<Quantity.QuantityCompararator>.Parse(">");
            Assert.AreEqual(Quantity.QuantityCompararator.GreaterThan, f.Contents);
            Assert.AreEqual(">", f.ToString());
        }


        [TestMethod]
        public void TestInstantParsing()
        {
            Instant ins = Instant.Parse("2011-03-04T14:45:33Z");
            Assert.AreEqual("2011-03-04T14:45:33+00:00", ins.ToString());

            Instant ins2 = Instant.Parse("2011-03-04T14:45:33+02:00");
            Assert.AreEqual("2011-03-04T14:45:33+02:00", ins2.ToString());

            Instant ins4 = Instant.Parse("2012-04-14T10:35:23+00:00");
            Assert.AreEqual("2012-04-14T10:35:23+00:00", ins4.ToString());
            
            try
            {
                Instant dummy = Instant.Parse("2011-03-04T11:45:33");
                Assert.Fail();
            }
            catch(Exception) {}

            Instant ins5 = Instant.FromDateTimeUtc(2011,3,4,16,45,33);
            Assert.AreEqual("2011-03-04T16:45:33+00:00", ins5.ToString());      
        }

        [TestMethod]
        public void TestDateTimeHandling()
        {
            FhirDateTime dt = FhirDateTime.Parse("2010-01-01");

            Assert.AreEqual("2010-01-01", dt.ToString());

            FhirDateTime dt2 = new FhirDateTime(1972, 11, 30, 15, 10);
            Assert.IsTrue(dt2.ToString().StartsWith("1972-11-30T15:10"));
        }

        [TestMethod]
        public void TestUrlParsing()
        {
            Assert.AreEqual("1", ResourceLocation.ParseIdFromRestUri("/patient/@1"));
            Assert.AreEqual("1", ResourceLocation.ParseIdFromRestUri("/patient/@1/history/@3"));
            Assert.AreEqual("1", ResourceLocation.ParseIdFromRestUri("../patient/@1"));
            Assert.AreEqual("1", ResourceLocation.ParseIdFromRestUri("../patient/@1/history/@3"));
            Assert.AreEqual("1", ResourceLocation.ParseIdFromRestUri("patient/@1"));
            Assert.AreEqual("1", ResourceLocation.ParseIdFromRestUri("patient/@1/history/@3"));

            Assert.AreEqual("3", ResourceLocation.ParseVersionIdFromRestUri("/patient/@1/history/@3"));
            Assert.AreEqual("3", ResourceLocation.ParseVersionIdFromRestUri("../patient/@1/history/@3"));
            Assert.AreEqual("3", ResourceLocation.ParseVersionIdFromRestUri("patient/@1/history/@3"));
        }

        [TestMethod]
        public void TestUrlBuilding()
        {
            Assert.AreEqual("patient/@1", ResourceLocation.BuildResourceLocation("patient", "1").ToString());
            Assert.AreEqual("http://www.nu.nl/patient/@1", ResourceLocation.BuildResourceLocation(new Uri("http://www.nu.nl"), "patient", "1").ToString());
            Assert.AreEqual("patient/@1/history/@3", ResourceLocation.BuildVersionedResourceLocation("patient", "1", "3").ToString());
            Assert.AreEqual("patient/@1/history/@3", ResourceLocation.BuildVersionedResourceLocation(new Uri("patient/@1",UriKind.Relative), "3").ToString());
            Assert.AreEqual("http://www.nu.nl/patient/@1/history/@3", 
                ResourceLocation.BuildVersionedResourceLocation(new Uri("http://www.nu.nl"), "patient", "1", "3").ToString());
        }

        [TestMethod]
        public void DetermineCollectionName()
        {
            Patient p = new Patient();

            Assert.AreEqual("patient", ResourceLocation.GetCollectionNameForResource(p));
            Assert.AreEqual("patient", ResourceLocation.GetCollectionNameForResource(p.GetType()));
        }
    }
}
