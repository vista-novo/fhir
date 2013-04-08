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
    public class ResourceLocationTests
    {
        [TestMethod]
        public void ValidateUriAssertions()
        {
            Uri abs = new Uri("http://www.nu.nl", UriKind.RelativeOrAbsolute);
            Assert.IsTrue(abs.IsAbsoluteUri);

            abs = new Uri("http://www.nu.nl");
            Assert.IsTrue(abs.IsAbsoluteUri);

            var notabs = new Uri("server/index.htm", UriKind.RelativeOrAbsolute);
            Assert.IsFalse(notabs.IsAbsoluteUri);
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

        [TestMethod]
        public void Tryout()
        {
            ResourceLocation rl = new ResourceLocation("http://fhir.server.com/svc/patient/@1");

        }
    }
}
