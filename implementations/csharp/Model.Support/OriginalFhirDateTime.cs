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
using HL7.Fhir.Instance.Model;

namespace HL7.Fhir.Instance.Model
{
    // A date, date-time or partial date (e.g. just year or year + month).  
    // If hours and minutes are specified, a timezone must be populated. 
    // The format is a union of the schema types gYear, gYearMonth, date, and dateTime. 
    // Seconds may be provided but may also be ignored.  Dates must be valid dates.
    public class OriginalFhirDateTime : Primitive
    {
        public enum FhirDateTimeKind
        {
            Year,           // gYear
            YearMonth,      // gYearMonth
            Date,           // date
            DateTime,       // datetime
            DateTimeHHMM    // datetime, without seconds
        }

        protected FhirDateTime()
        {
            // prohibit direct construction
        }


        public static FhirDateTime ForYear(int year)
        {
            return new FhirDateTime() 
                { 
                    Kind = FhirDateTimeKind.Year,
                    Year = year
                };
        }


        public static FhirDateTime ForYearMonth(int year, int month)
        {
            return new FhirDateTime()
            {
                Kind = FhirDateTimeKind.YearMonth,
                Year = year, Month = month
            };
        }


        public static FhirDateTime ForDate(int year, int month, int day)
        {
            return new FhirDateTime()
            {
                Kind = FhirDateTimeKind.Date,
                Year = year, Month = month, Day = day
            };
        }


        public static FhirDateTime ForLocalDateTime(int year, int month, int day,
                            int hour, int min, int sec = -1)
        {
            // Take current offset for the local offset. Might be incorrect because of DST.
            return ForDateTime(DateTimeOffset.Now.Offset, year, month, day, hour, min, sec);
        }


        public static FhirDateTime ForDateTimeUtc(int year, int month, int day,
                                            int hour, int min, int sec = -1)
        {
            return ForDateTime(new TimeSpan(0, 0, 0), year, month, day, hour, min, sec);
        }


        public static FhirDateTime ForDateTime(TimeSpan utcOffset, int year, int month, int day,
            int hour, int min, int sec = -1)
        {
            var originalDateTime = FhirDateTime.ForDate(year, month, day);

            originalDateTime.Hour = hour; originalDateTime.Minutes = min;

            if (sec != -1)
            {
                originalDateTime.Kind = FhirDateTimeKind.DateTime;
                originalDateTime.Seconds = sec;
            }
            else
            {
                originalDateTime.Kind = FhirDateTimeKind.DateTimeHHMM;
                originalDateTime.Seconds = 0;
            }

            // Convert to UTC
            var utcDateTime = new DateTimeOffset( originalDateTime.Year, originalDateTime.Month, originalDateTime.Day,
                    originalDateTime.Hour, originalDateTime.Minutes, originalDateTime.Seconds, utcOffset )
                        .ToUniversalTime();
            
            return FromDateTime(utcDateTime.UtcDateTime, originalDateTime.Kind);
        }


        public static FhirDateTime FromDateTime(DateTime value, FhirDateTimeKind precision)
        {
            if( isTimePrecision(precision) )
            {
                if (value.Kind == DateTimeKind.Unspecified)
                    throw new ArgumentException("DateTime value has unspecified timezone. " +
                                "Please explicitly convert to Utc or local time");
            }

            FhirDateTime result = new FhirDateTime();

            result.copyFromDateTimeUtc(value.ToUniversalTime());
            result.Kind = precision;

            return result;
        }

        public FhirDateTimeKind Kind { private set; get; }

      
        private void copyFromDateTimeUtc(DateTime source)
        {
            if (source.Kind != DateTimeKind.Utc)
                throw new ArgumentException("Internal error: using non-UTC time to initialize object");

            Year = source.Year;
            Month = source.Month;
            Day = source.Day;
            Hour = source.Hour;
            Minutes = source.Minute;
            Seconds = source.Second;
        }


        private bool tryParse(string xsdString, string format)
        {
            DateTimeOffset parsedValue;

            bool parseSuccessful = DateTimeOffset.TryParseExact(xsdString, format,
                null, System.Globalization.DateTimeStyles.AssumeLocal, out parsedValue);

            if(parseSuccessful)
                copyFromDateTimeUtc(parsedValue.ToUniversalTime().UtcDateTime);

            return parseSuccessful;
        }

        public DateTime AsUtcDateTime()
        {
            if( isTimePrecision(Kind) )
            {
                switch (Kind)
                {
                    case FhirDateTimeKind.DateTimeHHMM:
                        return new DateTime(Year, Month, Day, Hour, Minutes, 0, DateTimeKind.Utc);
                    case FhirDateTimeKind.DateTime:
                        return new DateTime(Year, Month, Day, Hour, Minutes, Seconds, DateTimeKind.Utc);
                    default:
                        throw new Exception("Internal error: DateTime kind unknown");
                }
            }
            else
                throw new InvalidOperationException("There is no time information, so cannot convert to DateTime. " +
                        "Use Year, Month and Day properties instead.");
        }


        public DateTime AsLocalDateTime()
        {
            return AsUtcDateTime().ToLocalTime();
        }


        public int Year
        {
            get; private set;
        }

        private int _month;

        public int Month
        {
            get
            {
                if (Kind != FhirDateTimeKind.Year)
                    return _month;
                else
                    throw new InvalidOperationException("Value does not specify a month");
            }

            private set { _month = value; }
        }

        private int _day;

        public int Day
        {
            get
            {
                if (Kind != FhirDateTimeKind.Year && Kind != FhirDateTimeKind.YearMonth)
                    return _day;
                else
                    throw new InvalidOperationException("Value does not specify a day");
            }

            private set { _day = value; }
        }

        private int _hour;

        public int Hour
        {
            get
            {
                if (isTimePrecision(Kind))
                    return _hour;
                else
                    throw new InvalidOperationException("Value does not specify an hour");
            }

            private set { _hour = value; }
        }


        private int _minutes;

        public int Minutes
        {
            get
            {
                if (isTimePrecision(Kind)) 
                    return _minutes;
                else
                    throw new InvalidOperationException("Value does not specify minutes");
            }

            private set { _minutes = value; }
        }


        private int _seconds;

        public int Seconds
        {
            get
            {
                if (Kind == FhirDateTimeKind.DateTime)
                    return _seconds;
                else
                    throw new InvalidOperationException("Value does not specify seconds");
            }

            private set { _seconds = value; }
        }


        private static bool isTimePrecision(FhirDateTimeKind precision)
        {
            return precision == FhirDateTimeKind.DateTime || precision != FhirDateTimeKind.DateTimeHHMM;
        }


        public override string ToString()
        {
            switch (Kind)
            {
                case FhirDateTimeKind.Year:
                    return String.Format("{0:D4}",Year);
                case FhirDateTimeKind.YearMonth:
                    return String.Format("{0:D4}-{1:D2}", Year, Month);
                case FhirDateTimeKind.Date:
                    return String.Format("{0:D4}-{1:D2}-{2:D2}", Year, Month, Day);
                case FhirDateTimeKind.DateTimeHHMM:
                    return String.Format("{0:D4}-{1:D2}-{2:D2}T{3:D2}:{4:D2}Z", Year, Month, Day, Hour, Minutes);
                case FhirDateTimeKind.DateTime:
                    return String.Format("{0:D4}-{1:D2}-{2:D2}T{3:D2}:{4:D2}:{5:D2}Z", Year, Month, Day, Hour, Minutes, Seconds);
                default:
                    throw new Exception("Internal error: unrecognized date/time kind.");
            }
        }

        public static bool TryParse(string xsdDate, FhirDateTimeKind requiredPrecision, out FhirDateTime result)
        {
            bool success = TryParse(xsdDate, out result);

            return success && (requiredPrecision == result.Kind);
        }

        public static bool TryParse(string xsdDate, out FhirDateTime result)
        {
            result = new FhirDateTime();

            int dateLength = xsdDate.Length;

            // Due to shortcut evaluation with dateLength, calling the 
            // expensive parse operation unneccessary is avoided
            if (dateLength >= 20 && result.tryParse(xsdDate, "yyyy-MM-dd'T'hh:mm:ssK"))
                result.Kind = FhirDateTimeKind.DateTime;
            else if (dateLength >= 17 && result.tryParse(xsdDate, "yyyy-MM-dd'T'hh:mmK"))
                result.Kind = FhirDateTimeKind.DateTimeHHMM;
            else if (dateLength == 10 && result.tryParse(xsdDate, "yyyy-MM-dd"))
                result.Kind = FhirDateTimeKind.Date;
            else if (dateLength == 7 && result.tryParse(xsdDate, "yyyy-MM"))
                result.Kind = FhirDateTimeKind.YearMonth;
            else if (dateLength == 4 && result.tryParse(xsdDate, "yyyy"))
                result.Kind = FhirDateTimeKind.Year;
            else
                return false;

            return true;
        }

        public static FhirDateTime Parse(string xsdDate)
        {
            FhirDateTime result;

            if (FhirDateTime.TryParse(xsdDate, out result))
                return result;
            else
                throw new FhirValueFormatException("Date/time is not in expected format");
        }

        public static FhirDateTime Parse(string xsdDate, FhirDateTimeKind requiredPrecision)
        {
            FhirDateTime result = Parse(xsdDate);

            if (result.Kind == requiredPrecision)
                return result;

            throw new FhirValueFormatException("Date/time is not of required precision");
        }
    }




}
