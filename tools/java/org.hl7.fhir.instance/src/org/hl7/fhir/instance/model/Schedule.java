package org.hl7.fhir.instance.model;

/*
  Copyright (c) 2011-2012, HL7, Inc.
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

// Generated on Sat, Nov 10, 2012 22:50+1100 for FHIR v0.06

import java.util.*;

/**
 * A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things did happen, but when they are expected or requested to occur.
 */
public class Schedule extends Type {

    public enum EventTiming {
        HS, // event occurs [duration] before the hour of sleep (or trying to)
        WAKE, // event occurs [duration] after waking
        AC, // event occurs [duration] before a meal (from the Latin ante cibus)
        ACM, // event occurs [duration] before breakfast (from the Latin ante cibus matutinus)
        ACD, // event occurs [duration] before lunch (from the Latin ante cibus diurnus)
        ACV, // event occurs [duration] before dinner (from the Latin ante cibus vespertinus)
        PC, // event occurs [duration] after a meal (from the Latin post cibus)
        PCM, // event occurs [duration] after breakfast (from the Latin post cibus matutinus)
        PCD, // event occurs [duration] after lunch (from the Latin post cibus diurnus)
        PCV; // event occurs [duration] after dinner (from the Latin post cibus vespertinus) 
        public static EventTiming fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("HS".equals(codeString))
          return HS;
        if ("WAKE".equals(codeString))
          return WAKE;
        if ("AC".equals(codeString))
          return AC;
        if ("ACM".equals(codeString))
          return ACM;
        if ("ACD".equals(codeString))
          return ACD;
        if ("ACV".equals(codeString))
          return ACV;
        if ("PC".equals(codeString))
          return PC;
        if ("PCM".equals(codeString))
          return PCM;
        if ("PCD".equals(codeString))
          return PCD;
        if ("PCV".equals(codeString))
          return PCV;
        throw new Exception("Unknown EventTiming code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case HS: return "HS";
            case WAKE: return "WAKE";
            case AC: return "AC";
            case ACM: return "ACM";
            case ACD: return "ACD";
            case ACV: return "ACV";
            case PC: return "PC";
            case PCM: return "PCM";
            case PCD: return "PCD";
            case PCV: return "PCV";
            default: return "?";
          }
        }
    }

    public enum UnitsOfTime {
        s, // second
        min, // minute
        h, // hour
        d, // day
        wk, // week
        mo, // month
        a; // year
        public static UnitsOfTime fromCode(String codeString) throws Exception {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("s".equals(codeString))
          return s;
        if ("min".equals(codeString))
          return min;
        if ("h".equals(codeString))
          return h;
        if ("d".equals(codeString))
          return d;
        if ("wk".equals(codeString))
          return wk;
        if ("mo".equals(codeString))
          return mo;
        if ("a".equals(codeString))
          return a;
        throw new Exception("Unknown UnitsOfTime code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case s: return "s";
            case min: return "min";
            case h: return "h";
            case d: return "d";
            case wk: return "wk";
            case mo: return "mo";
            case a: return "a";
            default: return "?";
          }
        }
    }

    public class Repeat extends Element {
        /**
         * Indicates how often the event should occur.
         */
        private java.lang.Integer frequency;

        /**
         * Identifies the occurrence of daily life that determine timing
         */
        private EventTiming when;

        /**
         * How long each repetition should last
         */
        private java.math.BigDecimal duration;

        /**
         * the units of time for the duration
         */
        private UnitsOfTime units;

        /**
         * A total count of the desired number of repetitions
         */
        private java.lang.Integer count;

        /**
         * When to stop repeats
         */
        private String end;

        public java.lang.Integer getFrequency() { 
          return this.frequency;
        }

        public void setFrequency(java.lang.Integer value) { 
          this.frequency = value;
        }

        public EventTiming getWhen() { 
          return this.when;
        }

        public void setWhen(EventTiming value) { 
          this.when = value;
        }

        public java.math.BigDecimal getDuration() { 
          return this.duration;
        }

        public void setDuration(java.math.BigDecimal value) { 
          this.duration = value;
        }

        public UnitsOfTime getUnits() { 
          return this.units;
        }

        public void setUnits(UnitsOfTime value) { 
          this.units = value;
        }

        public java.lang.Integer getCount() { 
          return this.count;
        }

        public void setCount(java.lang.Integer value) { 
          this.count = value;
        }

        public String getEnd() { 
          return this.end;
        }

        public void setEnd(String value) { 
          this.end = value;
        }

    }

    /**
     * Identifies specific time periods when the event should occur
     */
    private List<Period> event = new ArrayList<Period>();

    /**
     * Identifies a repeating pattern to the intended time periods. 
     */
    private Repeat repeat;

    public List<Period> getEvent() { 
      return this.event;
    }

    public Repeat getRepeat() { 
      return this.repeat;
    }

    public void setRepeat(Repeat value) { 
      this.repeat = value;
    }


}

