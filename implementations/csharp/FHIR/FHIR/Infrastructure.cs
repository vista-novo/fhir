using System;
using System.Collections.Generic;

namespace org.hl7.fhir.instance.model
{
    public class Element
    {
    }

    public enum DataAbsentReason
    {
        unknown, //	The value is not known
        asked, //		The source human does not know the value
        temp, //		There is reason to expect (from the workflow) that the value may become known
        notasked, //		The workflow didn't lead to this value being known
        masked, //	 	The information is not available due to security, privacy or related reasons
        unsupported, //	 	The source system wasn't capable of supporting this element
        astext, //	 	The content of the data is represented as text (see below)
        error //	 	Some system or workflow process error means that the information is not available
    }

    public class Type : Element
    {
        public DataAbsentReason dataAbsentReason { get; set; }
    }

    public class Ordered : Type
    {
    }

    public class Base64Binary : Type
    {
        public byte[] value { get; set; }
    }

    public class Code : Type
    {
        public string value { get; set; }
    }

    public class DateTime : Ordered {
        public System.DateTime value { get; set; }
    }
	
    public class Decimal : Ordered 
    {
        public decimal value { get; set; }
    }

    public class HumanDate : Ordered
    {
        public string value { get; set; }
    }

    public class Id : Type
    {
        public string value { get; set; }
    }

    public class Integer : Ordered
    {
        public int value { get; set; }
    }

    public class String_ : Type 
    {
	  public String value { get; set; }
    }

    public class Uri : Type
    {
        public System.Uri value { get; set; }
    }

    public class ResourceReference<T> where T : Resource
    {

        // type of T: Resource Type

        /**
         * Id of the reference
         */
        public String id { get; set; }

        /**
         * Specific version Id of resource referenced
         */
        public String version { get; set; }

        /**
         * Text alternative for the resource
         */
        public String text { get; set; }

        /**
         * resolved resource
         */
        public T resource { get; set; }
    }

    public class Attachment : Type
    {
        /**
         * the mime type of the content
         */
        public String code { get; set; }

        /**
         * data inline, base64ed
         */
        public byte[] data { get; set; }

        /**
         * url where the data can be found
         */
        public Uri url { get; set; }

        /**
         * base64 sha-256 hash of the data
         */
        public byte[] hash { get; set; }

        /**
	     * ISO 639-3 language code
	      */
        public String lang { get; set; }
        public String title { get; set; }
    }

    public class Identifier : Type
    {

        /**
         * The system that defines the id
         */
        public System.Uri system { get; set; }

        /**
         * the actual identifier
         */
        public String id { get; set; }
    }

    public class Coding : Type
    {
        /**
         * Symbol in syntax defined by the system
         */
        public String code;

        /**
         * Identity of the terminology system
         */
        public System.Uri system { get; set; }

        /**
         * Representation defined by the system
         */
        public String displayName { get; set; }
    }

    /**
     * A CodeableConcept represents a represents a field that is usually defined by a formal 
     * reference to a terminology or ontology, but may also be defined by the provision of text. *
     */
    public class CodeableConcept : Type
    {
        public CodeableConcept()
        {
            codings = new List<Coding>();
        }

        /**
         * References to a code defined by a terminology system
         */
        public List<Coding> codings { get; private set; }

        /**
         * A plain text representation of the concept
         */
        public String text { get; set; }

        /**
         * Which coding was chosen directly by the user
         */
        public Coding primary { get; set; }
    }

    /**
     * A code taken from a short list of codes that are not defined in a formal code system. 
     * Choice is generally used for things like pain scales, questionnaires or formally 
     * defined assessment indexes. The possible codes may be ordered with some 
     * arbitrarily defined scale.
     */
    public class Choice : Type
    {

        public Choice()
        {
            List<Value> values = new List<Value>();
        }

        public class Value : Element
        {
            /**
             * Possible code
             */
            public String code { get; set; }

            /**
             * Display for the code
             */
            public String displayName { get; set; }

        }
        /**
         * Selected code
         */
        public String code { get; set; }

        /**
         * A list of possible values for the code
         */
        public List<Value> values { get; private set; }

        /**
         * If the order of the values has meaning
         */
        public bool isOrdered { get; set; }
    }

    /**
     * A measured amount (or an amount that can potentially be measured). 
     */
    public class Quantity : Ordered
    {

        public enum Status
        {
            LessThan, //	The actual value is less than the given value
            lessOrEquals, //	The actual value is less than or equal to the given value
            greaterOrEquals, //	The actual value is greater than or equal to the given value
            greaterThan //	The actual value is greater than the given value
        }


        /**
         * Numerical value (with implicit precision)
         */
        public Decimal value { get; set; }


        /**
         * how the value should be understood and represented
         */
        public Quantity.Status status { get; set; }


        /**
         * unit representation
         */
        public String units { get; set; }


        /**
         * A coded form of the unit
         */
        public String code { get; set; }


        /**
         * The system that defines the coded form
         */
        public Uri system { get; set; }

    }

    public class Duration : Quantity 
    {
    }

    /**
     * A set of ordered values defined by a low and high limit.  
     */
    public class Interval< T> : Type where T : Ordered
    {

        /**
         * Low value
         */
        public T low { get; set; }

        /**
         * High value
         */
        public T high { get; set; }

    }

    /**
     * A ratio of two Quantity values - a numerator and a denominator. 
     */
    public class Ratio : Type
    {


        /**
         * The numerator
         */
        public Quantity numerator { get; set; }

        /**
         * The denominator
         */
        public Quantity denominator { get; set; }
    }

    public abstract class Structure : Element
    {
    }

    /*
     * An identifier that humans use
     */
    public class HumanId : Structure
    {

        /**
         * Code for identifier type
         */
        public Coding type { get; set; }

        /**
         * Actual identifier
         */
        public Identifier identifier { get; set; }

        /**
         * Time period when id was valid for use
         */
        public Interval<HumanDate> period { get; set; }
        /**
         * Organisation that issued id
         */
        public ResourceReference<Organization> assigner { get; set; }

    }

    /**
     * Names have various parts that may have different significance. Names may be 
     * changed, or repudiated, or people may have different names in different contexts.
     */
    public class HumanName : Structure
    {
        public HumanName()
        {
            parts = new List<Part>();
        }

        public enum NamePartType
        {
            family, // Family name, this is the name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first name of his father.
            given, // Given name. NOTE Not to be called first name since given names do not always come first. .
            title // Part of the name that is acquired as a title due to academic, legal, employment or nobility status etc. NOTE Title name parts include name parts that come after the name, such as qualifications.
        }

        public class Part : Element
        {
            /**
             * Type of name part
             */
            public NamePartType type { get; set; }

            /**
             * The content of the name part
             */
            public String value { get; set; }

        }

        public enum NameUse
        {
            usual, // Known as/conventional/the one you normally use
            official, // 	The formal name as registered in an official (government) registry, but which name might not be commonly used. May be called legal name.
            temp, // 	A temporary name. A name valid time can provide more detailed information. This may also be used for temporary names assigned at birth or in emergency situations.
            anonymous, // 	Anonymous assigned name, alias, or pseudonym (used to protect a person's identity for privacy reasons)
            old, // 	This name is no longer in use (or was never correct, but retained for records)
            maiden // 	A name used prior to marriage. Marriage naming customs vary greatly around the world. This name use is for use by applications that collect and store maiden names. Though the concept of maiden name is often gender specific, the use of this term is not gender specific. The use of this term does not imply any particular history for a person‘s name, nor should the maiden name be determined algorithmically
        }

        /**
         * The use of this name
         */
        public NameUse use { get; set; }

        /**
         * Text representation of the name
         */
        public String text;

        /**
         * Parts of the name
         */
        public List<Part> parts { get; private set; }

        /**
         * Time period when the name was in use
         */
        public Interval<HumanDate> period { get; set; }
    }

    /**
     * There is a variety of postal address formats defined around the world. 
     * This format defines a superset that can be used in all locations to 
     * describe all known addresses.
     */
    public class Address : Structure
    {
        public Address()
        {
            parts = new List<Part>();
        }

        public enum AddressPartType
        {
            part, // Part of an address line (typically used with an extension that further defines the meaning of the part).
            line, // A line of an address (typically used for street names & numbers, unit details, delivery hints etc) .
            city, // The name of the city, town, village, or other community or delivery centre.
            state, // sub-unit of a country with limited sovereignty in a federally organized country. A code may be used if codes are in common use (i.e. US 2 letter state codes).
            country, // Country. ISO 3166 3 letter codes can be used in place of a full country name.
            zip, // A postal code designating a region defined by the postal service.
            dpid // A value that uniquely identifies the postal address. (often used in barcodes).	
        }

        public class Part
        {
            /**
             * Type of address part
             */
            public AddressPartType type { get; set; }

            /**
             * The content of the address part
             */
            public String value { get; set; }
        }

        public enum AddressUse
        {
            home, // A communication address at a home.
            work, // An office address. First choice for business related contacts during business hours.
            temp, // A temporary address. The period can provide more detailed information.
            old // This address is no longer in use (or was never correct, but retained for records)	
        }

        /**
         * The use of this address
         */
        public AddressUse use { get; set; }

        /**
         * Text representation of the address
         */
        public Narrative text { get; set; }

        /**
         * Parts of the address
         */
        public List<Part> parts { get; set; }

        /**
         * Time period when the address was in use
         */
        public Interval<HumanDate> period { get; set; }
    }

    /**
     * All kinds of technology mediated contact details for a person or organisation, including telephone, email, etc.
     */
    public class Contact : Structure
    {
        public enum ContactUse
        {
            home, // A communication contact at a home; attempted contacts for business purposes might intrude privacy and chances are one will contact family or other household members instead of the person one wishes to call. Typically used with urgent cases, or if no other contacts are available.
            work, // An office contact. First choice for business related contacts during business hours.
            temp, // A temporary contact. The period can provide more detailed information.
            old, // This contact is no longer in use (or was never correct, but retained for records)
            mobile // A telecommunication device that moves and stays with its owner. May have characteristics of all other use codes, suitable for urgent matters, not the first choice for routine business
        }

        public enum ContactSystem
        {
            phone, // the value is a telephone number used for voice calls. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.
            fax, // the value is a fax machine. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.
            email, // the value is an email address
            url // The value is a url. This is intended for various personal contacts including blogs, twitter, facebook etc. Do not use for email addresses
        }

        /**
         * What kind of contact this is
         */
        public ContactSystem system { get; set; }

        /**
         * The actual contact details
         */
        public String value { get; set; }

        /**
         * How to use this address
         */
        public ContactUse use { get; set; }

        /**
         * Time period when the contact was in use
         */
        public Interval<HumanDate> period { get; set; }
    }

    /**
     * A schedule that specifies an event that may occur multiple times. 
     * Schedules are not used for recording when things did happen, 
     * but when they are expected or requested to occur. A schedule can
     * be either a list of events - intervals on which the event occurs, 
     * or a single event with repeating criteria, or just repeating 
     * criteria with no actual event. 
     *
     */
    public class Schedule : Structure
    {
        public Schedule()
        {
            events = new List<Interval<HumanDate>>();
        }
        public enum EventTiming
        {
            HS, // event occurs duration before the hour of sleep (or trying to)
            WAKE, // event occurs duration after waking
            AC, // event occurs duration before a meal (from the latin ante cibus)
            ACM, // event occurs duration before breakfast (from the latin ante cibus matutinus)
            ACD, // event occurs duration before lunch (from the latin ante cibus diurnus)
            ACV, // event occurs duration before dinner (from the latin ante cibus vespertinus)
            PC, // event occurs duration after a meal (from the latin post cibus)
            PCM, // event occurs duration after breakfast (from the latin post cibus matutinus)
            PCD, // event occurs duration after lunch (from the latin post cibus diurnus)
            PCV // event occurs duration after dinner (from the latin post cibus vespertinus)
        }

        public class Repeat
        {

            /**
             * Event occurs frequency times per duration
             */
            public int frequency { get; set; }

            /**
             * Event occurs duration from common life event
             */
            public EventTiming when { get; set; }

            /**
             * repeating or event-related duration
             */
            public Duration duration { get; set; }

            /**
             * number of times to repeat 
             */
            public int count { get; set; }

            /**
             * when to stop repeats
             */
            public HumanDate end { get; set; }
        }

        /**
         * When the event occurs
         */
        public List<Interval<HumanDate>> events { get; private set; }

        /**
         * Only if there is none or one event 
         */
        public Repeat repeat { get; set; }
    }

    public class Narrative
    {
        public Narrative()
        {
            images = new List<Image>();
            mappings = new List<Mapping>();

        }
        public enum MappingSource
        {
            text,
            data
        }

        public class Mapping
        {
            /**
             * Narrative source id
             */
            public String text { get; set; }

            /**
             * Data source
             */
            public Element data { get; set; }

            /**
             * which is source
             */
            public MappingSource source { get; set; }
        }

        public class Image
        {
            /**
             * mime type of image
             */
            public String mimeType { get; set; }

            /**
             * content of image
             */
            public byte[] content { get; set; }
        }

        public enum NarrativeStatus
        {
            generated,
            extensions,
            additional
        }

        /**
         * generated | extensions | additional
         */
        public NarrativeStatus status { get; set; }

        /**
         * limited xhtml content
         */
        public char[] xhtml { get; set; }

        public List<Image> images { get; set; }

        public List<Mapping> mappings { get; set; }

    }

    public class Extension : Element
    {
        public Extension()
        {
            extension = new List<Extension>();
        }

        public enum ExtensionState
        {
            mustMinusunderstand, // The extension contains information that qualifies or negates another element, and must be understood by an application process the resource
            superceded // The extension has been promoted into the main content of the resource, and the content is found at the reference. The extension continues to be defined for backward compatibility
        }
    
        /**
         * code that identifies the meaning of the extension
         */
        public String code { get; set; }

        /**
         * Source of the definition for the code
         */
        public Uri definition { get; set; }

        /**
         * Internal reference to context of the extension
         */
        public Element reference { get; set; }

        /**
         * Whether the extension must be understood
         */
        public ExtensionState state { get; set; }

        /**
         * the value of the extension (can recurse)
         */
        public Type value { get; set; }

        public List<Extension> extension { get; set; }
    }

    public class Resource
    {
        public Resource()
        {
            extensions = new List<Extension>();
            text = new Narrative();
        }

        /**
	     * Master resource Id, in all resources
	     */
        public Id id { get; set; }

        /**
         * Extensions
         */
        public List<Extension> extensions { get; set; }

        /**
         * Text summary of resource, for human interpretation
         */
        public Narrative text { get; set; }

    }

    public class Constraint
    {
    }
}
