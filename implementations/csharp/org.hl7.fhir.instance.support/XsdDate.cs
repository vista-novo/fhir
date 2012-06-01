using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace org.hl7.fhir.instance.support
{
    public class XsdDate
    {
        private XsdDate()
        {
            // avoid direct construction
        }


        public static XsdDate ForYear(int year)
        {
            return new XsdDate() 
                { 
                    Kind = XsdDateKind.Year,
                    _dateValue = new DateTime(year,1,1)
                };
        }


        public static XsdDate ForYearMonth(int year, int month)
        {
            return new XsdDate()
            {
                Kind = XsdDateKind.YearMonth,
                _dateValue = new DateTime(year, month, 1)
            };
        }


        public static XsdDate ForDate(int year, int month, int day)
        {
            return new XsdDate()
            {
                Kind = XsdDateKind.Date,
                _dateValue = new DateTime(year, month, day)
            };
        }


        public static XsdDate ForDateTime(DateTime value, XsdDateKind precision)
        {
            return new XsdDate()
            {
                Kind = precision,
                _dateValue = cleanDateTime(value, precision)
            };
        }

        public enum XsdDateKind
        {
            Year,           // gYear
            YearMonth,      // gYearMonth
            Date            // date
        }

        public XsdDateKind Kind { private set; get; }
        
        private DateTime _dateValue;

        public static bool TryParse(string xsdDate, out XsdDate result )
        {
            result = new XsdDate();

            if (result.tryParse(xsdDate, "yyyy"))
                result.Kind = XsdDateKind.Year;
            else if (result.tryParse(xsdDate, "yyyy-mm"))
                result.Kind = XsdDateKind.YearMonth;
            else if (result.tryParse(xsdDate, "yyyy-mm-dd"))
                result.Kind = XsdDateKind.Date;
            else
                return false;

            return true;
        }

        public static XsdDate Parse(string xsdDate)
        {
            XsdDate result;

            if (XsdDate.TryParse(xsdDate, out result))
                return result;
            else
                throw new FormatException("Given date is not in expected xsd format");
        }

        private bool tryParse(string xsdString, string format)
        {
            return DateTime.TryParseExact(xsdString, format,
                null, System.Globalization.DateTimeStyles.AssumeLocal,
                out _dateValue);
        }

        public DateTime AsDateTime()
        {
            return cleanDateTime(_dateValue, Kind);
        }

        public int Year
        {
            get
            {
                return _dateValue.Year;
            }
        }

        public int Month
        {
            get
            {
                if (Kind != XsdDateKind.Year)
                    return _dateValue.Month;
                else
                    throw new InvalidOperationException("Value does not specify a month");
            }
        }

        public int Day
        {
            get
            {
                if( Kind != XsdDateKind.Year && Kind != XsdDateKind.YearMonth )
                    return _dateValue.Year;
                else
                    throw new InvalidOperationException("Value does not specify a day");
            }
        }

        private static DateTime cleanDateTime(DateTime value, XsdDateKind precision)
        {
            if (precision == XsdDateKind.Year)
                return new DateTime(value.Year, 1, 1);
            else if (precision == XsdDateKind.YearMonth)
                return new DateTime(value.Year, value.Month, 1);
            else if (precision == XsdDateKind.Date)
                return new DateTime(value.Year, value.Month, value.Day);
            else
                throw new Exception("Internal error: unsupported XsdDateKind precision");
        }
    }
}
