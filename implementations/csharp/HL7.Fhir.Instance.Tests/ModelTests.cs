using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Tests
{
    [TestClass]
    public class ModelTests
    {
        [TestMethod]
        public void VerifyDefaults()
        {
            FhirBoolean b = new FhirBoolean();
            Assert.AreEqual(false, b.Contents);

            Integer i = new Integer();
            Assert.AreEqual(0, i.Contents);

            FhirDecimal d = new FhirDecimal();
            Assert.AreEqual(0, d.Contents);

            Base64Binary b64 = new Base64Binary();
            Assert.IsNull(b64.Contents);

            FhirString s = new FhirString();
            Assert.IsNull(s.Contents);
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
            Code<LabReport.LabReportStatus> c =
                Code<LabReport.LabReportStatus>.Parse("final");

            Assert.AreEqual(LabReport.LabReportStatus.Final, c.Contents);
            Assert.AreEqual("final", c.ToString());

            Code<LabReport.LabResultFlag> f =
                Code<LabReport.LabResultFlag>.Parse("++");

            Assert.AreEqual(LabReport.LabResultFlag.PlusPlus, f.Contents);

            Assert.AreEqual("++", f.ToString());
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
    }
}
