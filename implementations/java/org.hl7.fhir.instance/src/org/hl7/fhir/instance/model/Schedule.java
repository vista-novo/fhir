package org.hl7.fhir.instance.model;

// © HL7 (http://www.hl7.org)  Generated on 10:56 Apr 10, 2012 for FHIR v0.01

import java.util.*;

/**
 * A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things did happen, but when they are expected or requested to occur.
 */
public class Schedule extends Type {

    public enum EventTiming {
        HS, // event occurs duration before the hour of sleep (or trying to)
        WAKE, // event occurs duration after waking
        AC, // event occurs duration before a meal (from the latin ante cibus)
        ACM, // event occurs duration before breakfast (from the latin ante cibus matutinus)
        ACD, // event occurs duration before lunch (from the latin ante cibus diurnus)
        ACV, // event occurs duration before dinner (from the latin ante cibus vespertinus)
        PC, // event occurs duration after a meal (from the latin post cibus)
        PCM, // event occurs duration after breakfast (from the latin post cibus matutinus)
        PCD, // event occurs duration after lunch (from the latin post cibus diurnus)
        PCV; // event occurs duration after dinner (from the latin post cibus vespertinus)
        public static EventTiming fromCode(String code) throws Exception {
            if (code == null || "".equals(code))
                return null;
        if ("HS".equals(code))
          return HS;
        if ("WAKE".equals(code))
          return WAKE;
        if ("AC".equals(code))
          return AC;
        if ("ACM".equals(code))
          return ACM;
        if ("ACD".equals(code))
          return ACD;
        if ("ACV".equals(code))
          return ACV;
        if ("PC".equals(code))
          return PC;
        if ("PCM".equals(code))
          return PCM;
        if ("PCD".equals(code))
          return PCD;
        if ("PCV".equals(code))
          return PCV;
        throw new Exception("Unknown EventTiming code '"+code+"'");
        }
    }

    public class Repeat extends Element {
        /**
         * Event occurs frequency times per duration
         */
        private int frequency;

        /**
         * Event occurs duration from common life event
         */
        private EventTiming when;

        /**
         * repeating or event-related duration
         */
        private Duration duration;

        /**
         * number of times to repeat
         */
        private int count;

        /**
         * when to stop repeats
         */
        private String end;

        public int getFrequency() { 
          return this.frequency;
        }

        public void setFrequency(int value) { 
          this.frequency = value;
        }

        public EventTiming getWhen() { 
          return this.when;
        }

        public void setWhen(EventTiming value) { 
          this.when = value;
        }

        public Duration getDuration() { 
          return this.duration;
        }

        public void setDuration(Duration value) { 
          this.duration = value;
        }

        public int getCount() { 
          return this.count;
        }

        public void setCount(int value) { 
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
     * When the event occurs
     */
    private List<Interval<DateTime>> event = new ArrayList<Interval<DateTime>>();

    /**
     * Only if there is none or one event
     */
    private Repeat repeat;

    public List<Interval<DateTime>> getEvent() { 
      return this.event;
    }

    public Repeat getRepeat() { 
      return this.repeat;
    }

    public void setRepeat(Repeat value) { 
      this.repeat = value;
    }


}

