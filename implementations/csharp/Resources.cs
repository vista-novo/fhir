using System;
using System.Collections.Generic;

namespace org.hl7.fhir.instance.model
{

  public class Conformance : Resource {
  
    public enum RestfulConformanceMode
    {
      client, // The application acts as a server for this resource
      server // The application acts as a client for this resource
    }

    public enum ResourceIdSource
    {
      client, // The client must provide a unique resource id
      server, // The server defines the id and will reject any client attempt to define it
      either // The client can provide a unique resource id, or the server will define it instead
    }

    public class ConformancePublisher : Element
    {
      public ConformancePublisher()
      {
        address = new List<Address>();
        contact = new List<Contact>();
      }

      /**
       * Name of Organization
       */
      public String_ name { get; set; }

      /**
       * Address of Organization
       */
      public List<Address> address { get; private set; }

      /**
       * Contacts for Organization
       */
      public List<Contact> contact { get; private set; }

    }

    public class ConformanceSoftware : Element
    {
      /**
       * Name software is known by
       */
      public String_ name { get; set; }

      /**
       * Version covered by this statement
       */
      public String_ version { get; set; }

      /**
       * Date this version released
       */
      public DateTime releaseDate { get; set; }

    }

    public class ConformanceOperation : Element
    {
      /**
       * if supported
       */
      public Boolean read { get; set; }

      /**
       * if supported
       */
      public Boolean vread { get; set; }

      /**
       * if supported
       */
      public Boolean update { get; set; }

      /**
       * if supported
       */
      public Boolean delete { get; set; }

      /**
       * if supported
       */
      public Boolean validate { get; set; }

      /**
       * if supported
       */
      public Boolean history { get; set; }

      /**
       * only if supported
       */
      public ConformanceOperationTransaction transaction { get; set; }

      /**
       * only if supported
       */
      public ConformanceOperationSearch search { get; set; }

      /**
       * if supported
       */
      public ConformanceOperationCreate create { get; set; }

      /**
       * if supported
       */
      public Boolean updates { get; set; }

      /**
       * if supported
       */
      public Boolean schema { get; set; }

    }

    public class ConformanceOperationTransaction : Element
    {
      public ConformanceOperationTransaction()
      {
        name = new List<Code>();
      }

      /**
       * transaction names supported
       */
      public List<Code> name { get; private set; }

    }

    public class ConformanceOperationSearch : Element
    {
      public ConformanceOperationSearch()
      {
        param = new List<String_>();
      }

      /**
       * search params supported
       */
      public List<String_> param { get; private set; }

    }

    public class ConformanceOperationCreate : Element
    {
      /**
       * source of id: client | server | either
       */
      public ResourceIdSource id { get; set; }

    }

    /**
     * Date that the conformance statement is published
     */
    public DateTime date { get; set; }

    /**
     * The organization that publishes this conformance statement
     */
    public ConformancePublisher publisher { get; set; }

    /**
     * The software that is covered by this conformance statement
     */
    public ConformanceSoftware software { get; set; }

    /**
     * client | server
     */
    public RestfulConformanceMode mode { get; set; }

    /**
     * Additional other profiles that apply to this conformance statement.
     */
    public List<Uri> profile { get; private set; }

    /**
     * Resource Type with constraints
     */
    public Constraint resource { get; set; }

    /**
     * 
     */
    public ConformanceOperation operation { get; set; }


  }

  public class Document : Resource {
  
    public enum DocumentAuthenticationMode
    {
      personal, // The person authenticated the document in their personal capacity
      professional, // The person authenticated the document in their professional capacity
      legal, // The person authenticated the document and accepted legal responsibility for it's content
      official // The organization authenticated the document as consistent with their policies and procedures
    }

    public class DocumentAuthor : Element
    {
      /**
       * When authoring happened
       */
      public DateTime time { get; set; }

      /**
       * who/what authored the final document
       */
      public ResourceReference<Resource> party { get; set; }

    }

    public class DocumentAttestor : Element
    {
      /**
       * The type of attestation the authenticator offers
       */
      public DocumentAuthenticationMode mode { get; set; }

      /**
       * When document attested
       */
      public DateTime time { get; set; }

      /**
       * who attested the document
       */
      public ResourceReference<Resource> party { get; set; }

    }

    public class DocumentSection : Element
    {
      public DocumentSection()
      {
        section = new List<DocumentSection>();
      }

      /**
       * type of section (recommended)
       */
      public CodeableConcept type { get; set; }

      /**
       * the section creation time (sections are often re-used in several documents).
       */
      public Instant instant { get; set; }

      /**
       * if section author different to document
       */
      public DocumentSectionAuthor author { get; set; }

      /**
       * The person or device that performed the data entry leading to this section. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
       */
      public ResourceReference<Resource> enterer { get; set; }

      /**
       * if section different to document
       */
      public ResourceReference<Resource> subject { get; set; }

      /**
       * provided information in section
       */
      public ResourceReference<Person> informant { get; set; }

      /**
       * the actual content of the section
       */
      public ResourceReference<Resource> content { get; set; }

      /**
       * nested Section
       */
      public List<DocumentSection> section { get; private set; }

    }

    public class DocumentSectionAuthor : Element
    {
      /**
       * When authoring happened
       */
      public DateTime time { get; set; }

      /**
       * who/what authored the section
       */
      public ResourceReference<Resource> party { get; set; }

    }

    /**
     * the document creation time, when the document first came into being. Where the CDA document is a transform from an original document in some other format, the ClinicalDocument.effectiveTime is the time the original document is created.
     */
    public Instant instant { get; set; }

    /**
     * specifying the particular kind of document (e.g. History and Physical, Discharge Summary, Progress Note)
     */
    public CodeableConcept type { get; set; }

    /**
     * the title of the document
     */
    public String_ title { get; set; }

    /**
     * Represents an identifier that is common across all document revisions
     */
    public Id setId { get; set; }

    /**
     * used to version successive replacement documents
     */
    public Integer version { get; set; }

    /**
     * If this document replaces another
     */
    public Id replaces { get; set; }

    /**
     * who the document is about
     */
    public ResourceReference<Resource> subject { get; set; }

    /**
     * Author (contributed content to document)
     */
    public List<DocumentAuthor> author { get; private set; }

    /**
     * a participant who has attested to the accuracy of the document
     */
    public List<DocumentAttestor> attestor { get; private set; }

    /**
     * expected to receive a copy 
     */
    public List<ResourceReference<Resource>> recipient { get; private set; }

    /**
     * org which maintains the document.
     */
    public ResourceReference<Organization> custodian { get; set; }

    /**
     * the main Act, such as a colonoscopy or an appendectomy, being documented
     */
    public ResourceReference<Resource> event_ { get; set; }

    /**
     * context of the document
     */
    public ResourceReference<Resource> encounter { get; set; }

    /**
     * Document is broken into sections
     */
    public List<DocumentSection> section { get; private set; }


  }

  public class Message : Resource {
  
    public enum ResponseCode
    {
      ok, // The message was accepted and processed without error
      error, // Some internal unexpected error occured - wait and try again. Note - this is usually used for things like database unavailable, which may be expected to resolve, though human intervention may be required
      rejection, // The message was rejected because of some content in it. There is no point in re-sending without change. The response narrative must describe what the issue is
      rules, // The message was rejected because of some event-specific business rules, and it may be possible to modify the request and re-submit (as a different request). The response data must clarify what the change would be, as described by the event definition
      undeliverable // A middleware agent was unable to deliver the message to it's supposed destination
    }

    public class MessageResponse : Element
    {
      /**
       * The id of the message that this a response to
       */
      public Id id { get; set; }

      /**
       * Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not
       */
      public ResponseCode code { get; set; }

      /**
       * True if this is not the first response, because the request message has been received more than once
       */
      public Boolean duplicate { get; set; }

    }

    /**
     * Id of the thread - a series of messages that pertain to the same logical sequence, and are all identified by the same thread identifier
     */
    public Id threadId { get; set; }

    /**
     * Instant the message was sent
     */
    public Instant instant { get; set; }

    /**
     * Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification
     */
    public Code event_ { get; set; }

    /**
     * Information about the the message that this message is a response to - if it is a response
     */
    public MessageResponse response { get; set; }

    /**
     * The source application from which this message originated
     */
    public ResourceReference<Device> source { get; set; }

    /**
     * The destination application which the message is intended for
     */
    public ResourceReference<Device> destination { get; set; }

    /**
     * The person or device that performd the data entry leading to this message. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
     */
    public ResourceReference<Resource> enterer { get; set; }

    /**
     * The logical author of the message - the person or device that decided it should happen. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
     */
    public ResourceReference<Resource> author { get; set; }

    /**
     * The person or organization that accepts overall responsbility for the contents of the message. The implication is that the message event happened under the policies of the responsible party
     */
    public ResourceReference<Resource> responsible { get; set; }

    /**
     * The effective time - the real world time of the even that the message represents. Usually this is just a starting time, but some message events also have an end time (do x for period y)
     */
    public Interval<DateTime> effective { get; set; }

    /**
     * The cause of the event - a reason for why this message is being sent
     */
    public CodeableConcept reason { get; set; }

    /**
     * The actual data of the message - a reference to the focus class of the message. 
     */
    public ResourceReference<Resource> data { get; set; }


  }

  public class Animal : Resource {
  
    public class AnimalRelatedEntity : Element
    {
      public AnimalRelatedEntity()
      {
        address = new List<Address>();
        contact = new List<Contact>();
      }

      /**
       * Identifier for the entity
       */
      public HumanId id { get; set; }

      /**
       * Type of relationship
       */
      public CodeableConcept role { get; set; }

      /**
       * Name of the related entity
       */
      public HumanName name { get; set; }

      /**
       * An address (usually human, but may be kin)
       */
      public List<Address> address { get; private set; }

      /**
       * Contact details (usually for humans)
       */
      public List<Contact> contact { get; private set; }

    }

    /**
     * Identifier for the animal that is used to identify the person across multiple disparate systems and also for face to face identification of the person
     */
    public List<HumanId> identifier { get; private set; }

    /**
     * A name associated with the animal. The use code maiden does not apply.
     */
    public List<HumanName> name { get; private set; }

    /**
     * The birth date for the animal
     */
    public DateTime dob { get; set; }

    /**
     * Species for the animal
     */
    public CodeableConcept species { get; set; }

    /**
     * Strain for the animal
     */
    public CodeableConcept strain { get; set; }

    /**
     * Gender for the Animal
     */
    public CodeableConcept gender { get; set; }

    /**
     * Kin, owner, care giver etc
     */
    public List<AnimalRelatedEntity> relatedEntity { get; private set; }


  }

  public class Agent : Resource {
  
    /**
     * The person who acts as the agent
     */
    public ResourceReference<Person> person { get; set; }

    /**
     * The organisation that is being represented
     */
    public ResourceReference<Organization> organization { get; set; }

    /**
     * The way in which the person represents the organisation - what role do they have?
     */
    public List<CodeableConcept> role { get; private set; }

    /**
     * The time period during which the agent was/is authorised to represent the organisation.
     */
    public Interval<Date> period { get; set; }

    /**
     * An identifier that applies to this person in this role
     */
    public List<HumanId> identifier { get; private set; }

    /**
     * A postal address for this person playing this role
     */
    public List<Address> address { get; private set; }

    /**
     * A contact detail address for this person playing this role
     */
    public List<Contact> contact { get; private set; }


  }

  public class MessageConformance : Resource {
  
    public enum MessageConformanceEventMode
    {
      sender, // The application sends requests and receives responses
      receiver // The application receives requests and sends responses
    }

    public class MessageConformancePublisher : Element
    {
      public MessageConformancePublisher()
      {
        address = new List<Address>();
        contact = new List<Contact>();
      }

      /**
       * Name of Organization
       */
      public String_ name { get; set; }

      /**
       * Address of Organization
       */
      public List<Address> address { get; private set; }

      /**
       * Contacts for Organization
       */
      public List<Contact> contact { get; private set; }

    }

    public class MessageConformanceSoftware : Element
    {
      /**
       * Name software is known by
       */
      public String_ name { get; set; }

      /**
       * Version covered by this statement
       */
      public String_ version { get; set; }

      /**
       * Date this version released
       */
      public DateTime releaseDate { get; set; }

    }

    public class MessageConformanceEvent : Element
    {
      /**
       * The code for the event
       */
      public Code code { get; set; }

      /**
       * The focal resource for the event
       */
      public Code resource { get; set; }

      /**
       * The mode of this event declaration - whether application is sender or receiver
       */
      public MessageConformanceEventMode mode { get; set; }

      /**
       * Information about the request for this event
       */
      public MessageConformanceEventRequest request { get; set; }

      /**
       * Information about the response for this event
       */
      public MessageConformanceEventResponse response { get; set; }

    }

    public class MessageConformanceEventRequest : Element
    {
      public MessageConformanceEventRequest()
      {
        resource = new List<Constraint>();
      }

      /**
       * Constraint on a resource used in the event request
       */
      public List<Constraint> resource { get; private set; }

    }

    public class MessageConformanceEventResponse : Element
    {
      public MessageConformanceEventResponse()
      {
        resource = new List<Constraint>();
      }

      /**
       * Constraint on a resource used in the event response
       */
      public List<Constraint> resource { get; private set; }

    }

    /**
     * Date that the conformance statement is published
     */
    public DateTime date { get; set; }

    /**
     * The organization that publishes this conformance statement
     */
    public MessageConformancePublisher publisher { get; set; }

    /**
     * The software that is covered by this conformance statement
     */
    public MessageConformanceSoftware software { get; set; }

    /**
     * Additional other profiles that apply to this conformance statement.
     */
    public List<Uri> profile { get; private set; }

    /**
     * An event supported by the application
     */
    public List<MessageConformanceEvent> event_ { get; private set; }


  }

  public class Organization : Resource {
  
    public class OrganizationName : Element
    {
      /**
       * The actual name of the organization
       */
      public String_ value { get; set; }

      /**
       * The period that this name was in use by the organization
       */
      public Interval<Date> period { get; set; }

    }

    public class OrganizationAccreditation : Element
    {
      /**
       * The identifier of the accreditation
       */
      public Identifier id { get; set; }

      /**
       * The type of the accreditation
       */
      public CodeableConcept code { get; set; }

      /**
       * The organization that confered/confers the accreditation
       */
      public ResourceReference<Organization> institution { get; set; }

      /**
       * The period for which the accreditation is held
       */
      public Interval<Date> period { get; set; }

    }

    public class OrganizationRelatedOrganization : Element
    {
      public OrganizationRelatedOrganization()
      {
        address = new List<Address>();
        contact = new List<Contact>();
      }

      /**
       * Identifier the related organization - may be a full link to an Organization resource, or some other kind of identifier
       */
      public HumanId id { get; set; }

      /**
       * Code that specifies how this organization is related to the subject. A code is required.
       */
      public CodeableConcept code { get; set; }

      /**
       * A name should be specified for the related organization
       */
      public String_ name { get; set; }

      /**
       * Postal addresses may be provided for the related organization
       */
      public List<Address> address { get; private set; }

      /**
       * Contact details (phone, email etc) may be provided for the related organization
       */
      public List<Contact> contact { get; private set; }

      /**
       * The period during which the organizations were related in this fashion
       */
      public Interval<Date> period { get; set; }

    }

    /**
     * Identifier for the organization that is used to identify the organization across multiple disparate systems
     */
    public List<HumanId> identifier { get; private set; }

    /**
     * A name associated with the organization
     */
    public List<OrganizationName> name { get; private set; }

    /**
     * An address for the organization
     */
    public List<Address> address { get; private set; }

    /**
     * A contact detail for the organization
     */
    public List<Contact> contact { get; private set; }

    /**
     * The kind of organization that this is
     */
    public CodeableConcept code { get; set; }

    /**
     * The industry that this organization is involved in
     */
    public CodeableConcept industryCode { get; set; }

    /**
     * The qualifications a person has, including format educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment
     */
    public List<OrganizationAccreditation> accreditation { get; private set; }

    /**
     * Other organizations who are related to this person. The relationship might be one of several types: sub- or super- orgnizations (i.e. ward in a hospital, owning corporation of a hospital) or partner organizations (i.e. the operating corporation for a hospital)
     */
    public List<OrganizationRelatedOrganization> relatedOrganization { get; private set; }


  }

  public class Prescription : Resource {
  
    public enum PrescriptionStatus
    {
      active, // Patient is using the prescribed medicin
      completed // Prescription is no longer current
    }

    public enum BooleanYesNo
    {
      yes, // TRUE
      no // FALSE
    }

    public class PrescriptionDispense : Element
    {
      /**
       * Requested number of repeats
       */
      public Integer repeats { get; set; }

      /**
       * Requested quantity per repeat
       */
      public Quantity quantity { get; set; }

      /**
       * Person to fullfil the requested dispense
       */
      public ResourceReference<Resource> dispenser { get; set; }

    }

    public class PrescriptionMedicine : Element
    {
      public PrescriptionMedicine()
      {
        activeIngredient = new List<PrescriptionMedicineActiveIngredient>();
        inactiveIngredient = new List<PrescriptionMedicineInactiveIngredient>();
      }

      /**
       * Coded representation of medicine
       */
      public Coding productCode { get; set; }

      /**
       * Textual description of medicine, including strength and ingredients
       */
      public String_ description { get; set; }

      /**
       * The substance in the medication formulation that is pharmaceutically active and is responsible for the medication's therapeutic effect
       */
      public List<PrescriptionMedicineActiveIngredient> activeIngredient { get; private set; }

      /**
       * Ingredients in the medication that are not active
       */
      public List<PrescriptionMedicineInactiveIngredient> inactiveIngredient { get; private set; }

    }

    public class PrescriptionMedicineActiveIngredient : Element
    {
      /**
       * Coded representation of active ingredient
       */
      public Coding productCode { get; set; }

      /**
       * Quantity of active ingredient expressed in relation to the whole of the prepared medicine
       */
      public Ratio quantity { get; set; }

    }

    public class PrescriptionMedicineInactiveIngredient : Element
    {
      /**
       * Coded representation of the inactive ingredient
       */
      public Coding productCode { get; set; }

      /**
       * Quantity of inactive ingredient expressed in relation to the whole of the prepared medicine
       */
      public Ratio quantity { get; set; }

    }

    public class PrescriptionAdministrationRequest : Element
    {
      public PrescriptionAdministrationRequest()
      {
        dosageInstruction = new List<PrescriptionAdministrationRequestDosageInstruction>();
      }

      /**
       * Textual description of the use of the medication.
       */
      public String_ description { get; set; }

      /**
       * Total dose per day/week or other period when more specific information is missing or cannot be expressed using the timing specifications.
       */
      public Ratio totalPeriodicDosis { get; set; }

      /**
       * First moment on which medication should be taken
       */
      public DateTime start { get; set; }

      /**
       * Last moment on which medication should be taken
       */
      public DateTime end { get; set; }

      /**
       * Total duration of administration
       */
      public Quantity duration { get; set; }

      /**
       * Maximum number of separate administrations before the instruction ends.
       */
      public Integer numberOfAdministrations { get; set; }

      /**
       * Specification of dose and schedule for administration
       */
      public List<PrescriptionAdministrationRequestDosageInstruction> dosageInstruction { get; private set; }

    }

    public class PrescriptionAdministrationRequestDosageInstruction : Element
    {
      public PrescriptionAdministrationRequestDosageInstruction()
      {
        precondition = new List<CodeableConcept>();
        additionalInstruction = new List<CodeableConcept>();
        schedule = new List<Schedule>();
      }

      /**
       * Precondition for starting the administration specified in this instruction
       */
      public List<CodeableConcept> precondition { get; private set; }

      /**
       * Pro re nate, "If necessary": Specifies whether administration depens on the state and symptoms of the patient
       */
      public BooleanYesNo prn { get; set; }

      /**
       * Additional details to guide administration. Especially relevant for medicine administered by patient
       */
      public List<CodeableConcept> additionalInstruction { get; private set; }

      /**
       * Route of administration (oral, nasal, intravenous)
       */
      public CodeableConcept route { get; set; }

      /**
       * Dose per administration, expressed in units of the (prepared) product
       */
      public Type dose { get; set; }

      /**
       * Flow-rate for IV
       */
      public Quantity rate { get; set; }

      /**
       * Schedule for administration. If multiple are given, they are considered to be active in parrallel
       */
      public List<Schedule> schedule { get; private set; }

    }

    /**
     * A identifier used in an external system and associated with this medication
     */
    public List<HumanId> identifier { get; private set; }

    /**
     * Actual status of the prescription
     */
    public PrescriptionStatus status { get; set; }

    /**
     * The patient the prescription is prescribing medicine for
     */
    public ResourceReference<Patient> patient { get; set; }

    /**
     * The clinician or doctor prescribing the medication
     */
    public ResourceReference<Agent> prescriber { get; set; }

    /**
     * Date/time on which the prescription was written
     */
    public DateTime prescribed { get; set; }

    /**
     * Details of the dispense as requested by the prescriber
     */
    public PrescriptionDispense dispense { get; set; }

    /**
     * The one single medicatine, vaccine or therapeutic good prescribed in this prescription.
     */
    public PrescriptionMedicine medicine { get; set; }

    /**
     * Instructions for the use of the medication. Includes details about the timing schedule, dosis amounts and additional usage instructions.
     */
    public PrescriptionAdministrationRequest administrationRequest { get; set; }

    /**
     * Diagnosis which is the reason for prescribing this medicine
     */
    public CodeableConcept reason { get; set; }


  }

  public class Profile : Resource {
  
    public enum ResourceProfileStatus
    {
      draft, // This profile is still under development
      testing, // this profile was authored for testing purposes (or education/evaluation/evangelisation)
      production, // This profile is ready for use in production systems
      withdrawn, // This profile has been withdrawn
      superceded // This profile was superceded by a more recent version
    }

    public enum ConceptBindingType
    {
      Unbound, // The concept domain is not bound to anything
      CodeList, // The concept domain is bound to a list of supplied codes - only those codes are allowed
      Reference, // The concept domain references some external definition by a provided reference
      Preferred, // The concept domain references a set of preferred terms
      Suggestion, // This profile was superceded by a more recent version
      External // The concept domain is defined by an external authority identified in the reference
    }

    public class ProfileAuthor : Element
    {
      public ProfileAuthor()
      {
        reference = new List<Uri>();
      }

      /**
       * The name of the author
       */
      public String_ name { get; set; }

      /**
       * Reference to the author to assist a user in finding and communicating with the author
       */
      public List<Uri> reference { get; private set; }

    }

    public class ProfileEndorser : Element
    {
      /**
       * The name of the endorsing body
       */
      public String_ name { get; set; }

      /**
       * Reference to the author to assist a user in finding and communicating with the endorsing body
       */
      public Uri reference { get; set; }

    }

    public class ProfileBinding : Element
    {
      public ProfileBinding()
      {
        code = new List<Coding>();
      }

      /**
       * The name of the concept domain that this profile is declaring a constraint on
       */
      public String_ name { get; set; }

      /**
       * The form of the binding
       */
      public ConceptBindingType type { get; set; }

      /**
       * extra details - see notes
       */
      public String_ details { get; set; }

      /**
       * source of binding content
       */
      public Uri reference { get; set; }

      /**
       * enumerated codes that are the binding
       */
      public List<Coding> code { get; private set; }

    }

    /**
     * A free text natural language name identifying the Template.
     */
    public String_ name { get; set; }

    /**
     * Details of the author who accepts responsibility for publishing the profile
     */
    public ProfileAuthor author { get; set; }

    /**
     * A free text natural language description of the intent and scope of the Template. The purpose is to provide the author’s initial intent for the Template in the language specified below.
     */
    public String_ intention { get; set; }

    /**
     * A set of terms from a controlled reference terminology that may be used to assist with indexing and searching of templates
     */
    public List<Coding> code { get; private set; }

    /**
     * A free text natural language description of the Template. Generally, this field should be used for things such as goals, variable lists, instructions for clinical use and interpretation, literature, examples from paper world, mapping from natural language to HL7 and the model itself, etc
     */
    public String_ description { get; set; }

    /**
     * A description, reference or link to a published medical knowledge that was used in the definition of this Template
     */
    public List<Uri> evidence { get; private set; }

    /**
     * A statement regarding when this Template should not be used, or may be used erroneously. To define roles where the Template should not be used, or should be used with care. This field is used to expand in detail on the iIntention
     */
    public String_ comments { get; set; }

    /**
     * draft | testing | production | withdrawn | superceded
     */
    public ResourceProfileStatus status { get; set; }

    /**
     * The date that the current value for publicationStatus was applied to the Template
     */
    public DateTime date { get; set; }

    /**
     * A list of bodies who have reviewed the Template for clinical accuracy and relevance, and endorsed it for use.
     */
    public List<ProfileEndorser> endorser { get; private set; }

    /**
     * A free text description describing the changes in this version of the profile as compared to the previous version. 
     */
    public String_ changes { get; set; }

    /**
     * A template that is supercded by this template (maybe a  previous version)
     */
    public List<Uri> supercedes { get; private set; }

    /**
     * Additional other profiles that apply to this conformance statement.
     */
    public List<Uri> profile { get; private set; }

    /**
     * Resource Type with constraints
     */
    public List<Constraint> resource { get; private set; }

    /**
     * 
     */
    public List<ProfileBinding> binding { get; private set; }


  }

  public class Patient : Resource {
  
    /**
     * A linked patient record is a record that concerns the same patient. Records are linked after it is realised that at least one was created in error.
     */
    public List<ResourceReference<Patient>> link { get; private set; }

    /**
     * Whether the patient record is in use, or has been removed from active use
     */
    public Boolean active { get; set; }

    /**
     * The person that this patient record is about
     */
    public ResourceReference<Person> person { get; set; }

    /**
     * The animal that this patient record is about
     */
    public ResourceReference<Animal> animal { get; set; }

    /**
     * The provider for whom this is a patient record
     */
    public ResourceReference<Organization> provider { get; set; }

    /**
     * An identifier that applies to this person as a patient
     */
    public List<HumanId> identifier { get; private set; }

    /**
     * Dietary restrictions for the patient
     */
    public CodeableConcept diet { get; set; }

    /**
     * Confidentiality of the patient records
     */
    public CodeableConcept confidentiality { get; set; }

    /**
     * The location of the paper record for the patient, if there is one
     */
    public CodeableConcept recordLocation { get; set; }


  }

  public class Person : Resource {
  
    public enum LanguageUse
    {
      none, // The person does not speak the language at all
      poor, // The person has minimal functional capability in the language
      useable, // The person can use the language, but may not be full conversant, particularly with regards to health concepts
      fluent // The person is fully capable of using the language
    }

    public class PersonQualification : Element
    {
      /**
       * The identifier of a qualification
       */
      public Identifier id { get; set; }

      /**
       * The type of the qualification
       */
      public CodeableConcept code { get; set; }

      /**
       * The organisation that confered/confers the qualification
       */
      public ResourceReference<Organization> institution { get; set; }

      /**
       * The period for which a qualification is held
       */
      public Interval<Date> period { get; set; }

    }

    public class PersonLanguage : Element
    {
      /**
       * A code that identifies the language
       */
      public Code code { get; set; }

      /**
       * A code the describes how well the language is spoken
       */
      public LanguageUse use { get; set; }

    }

    public class PersonRelatedPerson : Element
    {
      public PersonRelatedPerson()
      {
        contact = new List<Contact>();
      }

      /**
       * Identifier the related person - may be a full link to a Person resource, or some other kind of identifier
       */
      public HumanId id { get; set; }

      /**
       * Code that specifies how this person is related to the subject. A code is required.
       */
      public CodeableConcept role { get; set; }

      /**
       * A name should be specified for the related person
       */
      public HumanName name { get; set; }

      /**
       * Contact details (phone, email etc) should be provided for the person
       */
      public List<Contact> contact { get; private set; }

    }

    /**
     * Identifier for the person that is used to identify the person across multiple disparate systems and also for face to face identification of the person
     */
    public List<HumanId> identifier { get; private set; }

    /**
     * A name associated with the person
     */
    public List<HumanName> name { get; private set; }

    /**
     * An address for the person
     */
    public List<Address> address { get; private set; }

    /**
     * A contact detail for the person
     */
    public List<Contact> contact { get; private set; }

    /**
     * The birth date for the person
     */
    public DateTime dob { get; set; }

    /**
     * Administrative Gender
     */
    public CodeableConcept gender { get; set; }

    /**
     * The religious denomination to which a person professes affiliation
     */
    public CodeableConcept religion { get; set; }

    /**
     * The qualifications a person has, including formal educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment
     */
    public List<PersonQualification> qualification { get; private set; }

    /**
     * A language spoken by the person, with proficiency
     */
    public List<PersonLanguage> language { get; private set; }

    /**
     * Other persons who are related to this person. The relationship might be one of several types: kin (familial or marital), financial or legal (such as guardian), biological (e.g. donor, donation-recipient) or casual (i.e. friend).
     */
    public List<PersonRelatedPerson> relatedPerson { get; private set; }


  }

  public class LabReport : Resource {
  
    public enum LabReportStatus
    {
      registered, // The existence of the result is registered, but there is no result yet available
      interim, // This is an initial or interim result: data may be missing or verification not been performed
      final_, // The result is complete and verified by the responsible pathologist
      amended, // The result has been modified subsequent to being Final, and is complete and verified by the responsible pathologist
      cancelled, // The result is unavailable because the test was not started or not completed (also sometimes called aborted)
      withdrawn // The result has been withdrawn following previous Final release
    }

    public enum LabResultFlag
    {
      Minus, // 
      MinusMinus, // 
      MinusMinusMinus, // 
      Plus, // 
      PlusPlus, // 
      PlusPlusPlus // 
    }

    public class LabReportRequestDetail : Element
    {
      public LabReportRequestDetail()
      {
        requestTest = new List<CodeableConcept>();
      }

      /**
       * The local ID assigned to the order by the order requester.
       */
      public Identifier requestOrderId { get; set; }

      /**
       * The local ID assigned to the test order by the order filler, usually by the Laboratory Information System (LIS).
       */
      public Identifier receiverOrderId { get; set; }

      /**
       * Identification of pathology test requested,
       */
      public List<CodeableConcept> requestTest { get; private set; }

      /**
       * Details of the clinician or organisation requesting the laboratory test.
       */
      public ResourceReference<Resource> requester { get; set; }

      /**
       * Details of the clinical information provided to the laboratory along with the original request
       */
      public ResourceReference<Resource> clinicalInfo { get; set; }

    }

    public class LabReportResultGroup : Element
    {
      public LabReportResultGroup()
      {
        result = new List<LabReportResultGroupResult>();
      }

      /**
       * A code or name that describes the group of results
       */
      public CodeableConcept name { get; set; }

      /**
       * Details about the individual specimen to which these ‘Result group’ test results refer, where testing of multiple specimens is required.
       */
      public ResourceReference<Specimen> specimen { get; set; }

      /**
       * Specific detailed result, including both the value of the result item, and additional information that may be useful for clinical interpretation. Results include whatever specific data items pathology labs report as part of the clinical service; it is not confined to measurements.
       */
      public List<LabReportResultGroupResult> result { get; private set; }

    }

    public class LabReportResultGroupResult : Element
    {
      public LabReportResultGroupResult()
      {
        referenceRange = new List<LabReportResultGroupResultReferenceRange>();
      }

      /**
       * Identifies the meaning of the value
       */
      public CodeableConcept name { get; set; }

      /**
       * Actual value of the result. Most result values will be numerical measurements, but others may be coded concepts, free text, or multimedia images
       */
      public Type value { get; set; }

      /**
       * Flag indicating the abnormal status of the result
       */
      public LabResultFlag flag { get; set; }

      /**
       * The status of the result value
       */
      public LabReportStatus status { get; set; }

      /**
       * May include statements about significant, unexpected or unreliable. values, or information about the source of the value where this may be relevant to the interpretation of the result.
       */
      public String_ comments { get; set; }

      /**
       * Guidance on how to interpret the value by comparison to a normal or recommended range
       */
      public List<LabReportResultGroupResultReferenceRange> referenceRange { get; private set; }

    }

    public class LabReportResultGroupResultReferenceRange : Element
    {
      /**
       * Code for the meaning of the reference range
       */
      public CodeableConcept meaning { get; set; }

      /**
       * Actual value of the reference range.  May be a quantity (<20mg/L), an interval (10-20 umol/L), or some text
       */
      public Type range { get; set; }

    }

    /**
     * The status of the pathology test result as a whole
     */
    public LabReportStatus status { get; set; }

    /**
     * The date and/or time that the result was issued from the source for the recorded ‘Test result status
     */
    public Instant issued { get; set; }

    /**
     * The patient about who the report is about
     */
    public ResourceReference<Patient> patient { get; set; }

    /**
     * The admission that this diagnostic investigation is associated with
     */
    public ResourceReference<Admission> admission { get; set; }

    /**
     * The laboratory service that issued the report
     */
    public ResourceReference<Organization> laboratory { get; set; }

    /**
     * The local ID assigned to the report by the order filler, usually by the Laboratory Information System (LIS).
     */
    public Id reportId { get; set; }

    /**
     * Details concerning a single pathology test requested.
     */
    public List<LabReportRequestDetail> requestDetail { get; private set; }

    /**
     * Identification of the pathology test performed, sometimes including specimen type.
     */
    public CodeableConcept reportName { get; set; }

    /**
     * The diagnostic service that performs the examination e.g. biochemistry, haematology.
     */
    public CodeableConcept service { get; set; }

    /**
     * The diagnostically relevant time for this report
     */
    public DateTime diagnosticTime { get; set; }

    /**
     * Details about the specimen if all individual test results are derived from the same specimen
     */
    public List<ResourceReference<Specimen>> specimen { get; private set; }

    /**
     * A group of results. Results may be grouped by specimen, or by some value in LabReport.resultGroup.name to describe what binds all the results together.
     */
    public List<LabReportResultGroup> resultGroup { get; private set; }

    /**
     * Concise and clinically contextualised narrative interpretation of the pathology test results.
     */
    public Narrative conclusion { get; set; }

    /**
     * Codes for the conclusion
     */
    public List<CodeableConcept> codedDiagnosis { get; private set; }

    /**
     * Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they must be semantically equivalent.
     */
    public List<Attachment> representation { get; private set; }


  }

  public class DocumentConformance : Resource {
  
    public class DocumentConformancePublisher : Element
    {
      public DocumentConformancePublisher()
      {
        address = new List<Address>();
        contact = new List<Contact>();
      }

      /**
       * Name of Organization
       */
      public String_ name { get; set; }

      /**
       * Address of Organization
       */
      public List<Address> address { get; private set; }

      /**
       * Contacts for Organization
       */
      public List<Contact> contact { get; private set; }

    }

    public class DocumentConformanceSoftware : Element
    {
      /**
       * Name software is known by
       */
      public String_ name { get; set; }

      /**
       * Version covered by this statement
       */
      public String_ version { get; set; }

      /**
       * Date this version released
       */
      public DateTime releaseDate { get; set; }

    }

    public class DocumentConformanceDocument : Element
    {
      public DocumentConformanceDocument()
      {
        resource = new List<Constraint>();
      }

      /**
       * Name for this particular document profile
       */
      public String_ name { get; set; }

      /**
       * Human description of this particular profile
       */
      public String_ purpose { get; set; }

      /**
       * Constraint on a resource used in the document
       */
      public List<Constraint> resource { get; private set; }

    }

    /**
     * Date that this conformance statement is published
     */
    public DateTime date { get; set; }

    /**
     * The organization that publishes this conformance statement
     */
    public DocumentConformancePublisher publisher { get; set; }

    /**
     * The software that is covered by this conformance statement
     */
    public DocumentConformanceSoftware software { get; set; }

    /**
     * Additional other profiles that apply to this conformance statement.
     */
    public List<Uri> profile { get; private set; }

    /**
     * A document definition
     */
    public List<DocumentConformanceDocument> document { get; private set; }


  }

  public class Yet to be defined : Resource {
  

  }

  public class Yet to be defined : Resource {
  

  }

  public class Yet to be defined : Resource {
  

  }

  public class Yet to be defined : Resource {
  

  }

  public class Yet to be defined : Resource {
  

  }

}

