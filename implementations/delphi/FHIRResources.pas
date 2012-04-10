unit FHIRResources;

interface

// FHIR v0.01 generated 10:56 Apr 10, 2012

uses
  FHIRBase, AdvBuffers, DecimalSupport, Classes;

Type
  {@Enum TFHIRResourceType
    Enumeration of known resource types
  }
  TFHIRResourceType = (
    frtConformance, {@enum.value A conformance statement returned by request in an RESTful framework }
    frtDocument, {@enum.value A document that contains FHIR resources }
    frtMessage, {@enum.value A message that contains FHIR resources }
    frtMessageConformance, {@enum.value A conformance statement about how an application uses FHIR messaging }
    frtAgent, {@enum.value A person who represents an organisation, and is authorised to perform actions on it's behalf }
    frtAnimal, {@enum.value An animal that has relevance to the care process -usually this is for animals that are patients. }
    frtPrescription, {@enum.value Directions provided by a prescribing practitioner for a specific medication to be administered to an individual }
    frtPatient, {@enum.value A patient is a person or animal that is receiving care }
    frtOrganization, {@enum.value For any organization/institution/government department that has relevance to the care process }
    frtDocumentConformance, {@enum.value A conformance statement about how one or more FHIR documents }
    frtLabReport, {@enum.value The findings and interpretation of pathology tests performed on tissues and body fluids. This is typically done in a laboratory but may be done in other environments such as at the point of care }
    frtPerson); {@enum.value A person who is involved in the healthcare process }

  {@Enum TExtensionState
    The state of an extension
  }
  TExtensionState = (
    tesMustMinusunderstand, {@enum.value The extension contains information that qualifies or negates another element, and must be understood by an application process the resource }
    tesSuperceded); {@enum.value The extension has been promoted into the main content of the resource, and the content is found at the reference. The extension continues to be defined for backward compatibility }

  {@Enum TConformanceType
    The conformance value for an element
  }
  TConformanceType = (
    tctMandatory, {@enum.value The element is or must always be present without a dataAbsentReason }
    tctConditional, {@enum.value The element may need to be present (with no dataAbsentReasons) depending on the condition }
    tctOptional, {@enum.value The element may or may not be present }
    tctProhibited); {@enum.value The element can not present or will be rejected if received }

  {@Enum TNarrativeStatus
    The status of a resource narrative
  }
  TNarrativeStatus = (
    tnsGenerated, {@enum.value The contents of the narrative are entirely generated from the structured data in the resource. }
    tnsExtensions, {@enum.value The contents of the narrative are entirely generated from the structured data in the resource, and some of the structured data is contained in extensions }
    tnsAdditional); {@enum.value The contents of the narrative contain additional information not found in the structured data }

  {@Enum TNarrativeMapSource
    Which is the source in a Narrative <-> Data mapping
  }
  TNarrativeMapSource = (
    tnmsText, {@enum.value The text is the original data }
    tnmsData); {@enum.value The data is the original data }

  {@Enum TQuantityStatus
    how the Quantity should be understood and represented
  }
  TQuantityStatus = (
    tqsLessThan, {@enum.value The actual value is less than the given value }
    tqsLessOrEquals, {@enum.value The actual value is less than or equal to the given value }
    tqsGreaterOrEquals, {@enum.value The actual value is greater than or equal to the given value }
    tqsGreaterThan); {@enum.value The actual value is greater than the given value }

  {@Enum TEventTiming
    A real world event that a schedule is related to
  }
  TEventTiming = (
    tetHS, {@enum.value event occurs duration before the hour of sleep (or trying to) }
    tetWAKE, {@enum.value event occurs duration after waking }
    tetAC, {@enum.value event occurs duration before a meal (from the latin ante cibus) }
    tetACM, {@enum.value event occurs duration before breakfast (from the latin ante cibus matutinus) }
    tetACD, {@enum.value event occurs duration before lunch (from the latin ante cibus diurnus) }
    tetACV, {@enum.value event occurs duration before dinner (from the latin ante cibus vespertinus) }
    tetPC, {@enum.value event occurs duration after a meal (from the latin post cibus) }
    tetPCM, {@enum.value event occurs duration after breakfast (from the latin post cibus matutinus) }
    tetPCD, {@enum.value event occurs duration after lunch (from the latin post cibus diurnus) }
    tetPCV); {@enum.value event occurs duration after dinner (from the latin post cibus vespertinus) }

  {@Enum TContactSystem
    What kind of contact this is
  }
  TContactSystem = (
    tcsPhone, {@enum.value the value is a telephone number used for voice calls. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required. }
    tcsFax, {@enum.value the value is a fax machine. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required. }
    tcsEmail, {@enum.value the value is an email address }
    tcsUrl); {@enum.value The value is a url. This is intended for various personal contacts including blogs, twitter, facebook etc. Do not use for email addresses }

  {@Enum TContactUse
    How to use this address
  }
  TContactUse = (
    tcuHome, {@enum.value A communication contact at a home; attempted contacts for business purposes might intrude privacy and chances are one will contact family or other household members instead of the person one wishes to call. Typically used with urgent cases, or if no other contacts are available. }
    tcuWork, {@enum.value An office contact. First choice for business related contacts during business hours. }
    tcuTemp, {@enum.value A temporary contact. The period can provide more detailed information. }
    tcuOld, {@enum.value This contact is no longer in use (or was never correct, but retained for records) }
    tcuMobile); {@enum.value A telecommunication device that moves and stays with its owner. May have characteristics of all other use codes, suitable for urgent matters, not the first choice for routine business }

  {@Enum TAddressUse
    The use of an address
  }
  TAddressUse = (
    tauHome, {@enum.value A communication address at a home. }
    tauWork, {@enum.value An office address. First choice for business related contacts during business hours. }
    tauTemp, {@enum.value A temporary address. The period can provide more detailed information. }
    tauOld); {@enum.value This address is no longer in use (or was never correct, but retained for records) }

  {@Enum TAddressPartType
    Type of address part
  }
  TAddressPartType = (
    taptPart, {@enum.value Part of an address line (typically used with an extension that further defines the meaning of the part). }
    taptLine, {@enum.value A line of an address (typically used for street names & numbers, unit details, delivery hints etc) . }
    taptCity, {@enum.value The name of the city, town, village, or other community or delivery centre. }
    taptState, {@enum.value sub-unit of a country with limited sovereignty in a federally organized country. A code may be used if codes are in common use (i.e. US 2 letter state codes). }
    taptCountry, {@enum.value Country. ISO 3166 3 letter codes can be used in place of a full country name. }
    taptZip, {@enum.value A postal code designating a region defined by the postal service. }
    taptDpid); {@enum.value A value that uniquely identifies the postal address. (often used in barcodes). }

  {@Enum TNameUse
    The use of a human name
  }
  TNameUse = (
    tnuUsual, {@enum.value Known as/conventional/the one you normally use }
    tnuOfficial, {@enum.value The formal name as registered in an official (government) registry, but which name might not be commonly used. May be called legal name. }
    tnuTemp, {@enum.value A temporary name. A name valid time can provide more detailed information. This may also be used for temporary names assigned at birth or in emergency situations. }
    tnuAnonymous, {@enum.value Anonymous assigned name, alias, or pseudonym (used to protect a person's identity for privacy reasons) }
    tnuOld, {@enum.value This name is no longer in use (or was never correct, but retained for records) }
    tnuMaiden); {@enum.value A name used prior to marriage. Marriage naming customs vary greatly around the world. This name use is for use by applications that collect and store maiden names. Though the concept of maiden name is often gender specific, the use of this term is not gender specific. The use of this term does not imply any particular history for a person?s name, nor should the maiden name be determined algorithmically }

  {@Enum TNamePartType
    Type of a part of a human name
  }
  TNamePartType = (
    tnptFamily, {@enum.value Family name, this is the name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first name of his father. }
    tnptGiven, {@enum.value Given name. NOTE Not to be called first name since given names do not always come first. . }
    tnptTitle); {@enum.value Part of the name that is acquired as a title due to academic, legal, employment or nobility status etc. NOTE Title name parts include name parts that come after the name, such as qualifications. }

  {@Enum TRestfulConformanceMode
    The mode of a restful conformance statement
  }
  TRestfulConformanceMode = (
    trcmClient, {@enum.value The application acts as a server for this resource }
    trcmServer); {@enum.value The application acts as a client for this resource }

  {@Enum TDocumentAuthenticationMode
    The way in which a person authenticated a document
  }
  TDocumentAuthenticationMode = (
    tdamPersonal, {@enum.value The person authenticated the document in their personal capacity }
    tdamProfessional, {@enum.value The person authenticated the document in their professional capacity }
    tdamLegal); {@enum.value The person authenticated the document and accepted legal responsibility for it's content }

  {@Enum TResponseCode
    The kind of response to a message
  }
  TResponseCode = (
    trcOk, {@enum.value The message was accepted and processed without error }
    trcError, {@enum.value Some internal unexpected error occured - wait and try again. Note - this is usually used for things like database unavailable, which may be expected to resolve, though human intervention may be required }
    trcRejection, {@enum.value The message was rejected because of some content in it. There is no point in re-sending without change. The response narrative must describe what the issue is }
    trcRules, {@enum.value The message was rejected because of some event-specific business rules, and it may be possible to modify the request and re-submit (as a different request). The response data must clarify what the change would be, as described by the event definition }
    trcUndeliverable); {@enum.value A middleware agent was unable to deliver the message to it's supposed destination }

  {@Enum TMessageConformanceEventMode
    The mode of a message conformance statement
  }
  TMessageConformanceEventMode = (
    tmcemSender, {@enum.value The application sends requests and receives responses }
    tmcemReceiver); {@enum.value The application receives requests and sends responses }

  {@Enum TPrescriptionStatus
    The status of a prescription
  }
  TPrescriptionStatus = (
    tpsActive, {@enum.value Patient is using the prescribed medicin }
    tpsCompleted); {@enum.value Prescription is no longer current }

  {@Enum TBooleanYesNo
    Either yes or no, true or false
  }
  TBooleanYesNo = (
    tbynYes, {@enum.value TRUE }
    tbynNo); {@enum.value FALSE }

  {@Enum TLabReportStatus
    The status of a report or result item
  }
  TLabReportStatus = (
    tlrsRegistered, {@enum.value The existence of the result is registered, but there is no result yet available }
    tlrsInterim, {@enum.value This is an initial or interim result: data may be missing or verification not been performed }
    tlrsFinal, {@enum.value The result is complete and verified by the responsible pathologist }
    tlrsAmended, {@enum.value The result has been modified subsequent to being Final, and is complete and verified by the responsible pathologist }
    tlrsCancelled, {@enum.value The result is unavailable because the test was not started or not completed (also sometimes called aborted) }
    tlrsWithdrawn); {@enum.value The result has been withdrawn following previous Final release }

  {@Enum TLabResultFlag
    codes for result flags
  }
  TLabResultFlag = (
    tlrfMinus, {@enum.value  }
    tlrfMinusMinus, {@enum.value  }
    tlrfMinusMinusMinus, {@enum.value  }
    tlrfPlus, {@enum.value  }
    tlrfPlusPlus, {@enum.value  }
    tlrfPlusPlusPlus); {@enum.value  }

  {@Enum TLanguageUse
    How well a person speaks a language
  }
  TLanguageUse = (
    tluNone, {@enum.value The person does not speak the language at all }
    tluPoor, {@enum.value The person has minimal functional capability in the language }
    tluUseable, {@enum.value The person can use the language, but may not be full conversant, particularly with regards to health concepts }
    tluFluent); {@enum.value The person is fully capable of using the language }

Const
  CODES_TFHIRResourceType : Array[TFHIRResourceType] of String = ('Conformance', 'Document', 'Message', 'MessageConformance', 'Agent', 'Animal', 'Prescription', 'Patient', 'Organization', 'DocumentConformance', 'LabReport', 'Person');
  CODES_TExtensionState : Array[TExtensionState] of String = ('must-understand', 'superceded');
  CODES_TConformanceType : Array[TConformanceType] of String = ('Mandatory', 'Conditional', 'Optional', 'Prohibited');
  CODES_TNarrativeStatus : Array[TNarrativeStatus] of String = ('generated', 'extensions', 'additional');
  CODES_TNarrativeMapSource : Array[TNarrativeMapSource] of String = ('text', 'data');
  CODES_TQuantityStatus : Array[TQuantityStatus] of String = ('<', '<=', '>=', '>');
  CODES_TEventTiming : Array[TEventTiming] of String = ('HS', 'WAKE', 'AC', 'ACM', 'ACD', 'ACV', 'PC', 'PCM', 'PCD', 'PCV');
  CODES_TContactSystem : Array[TContactSystem] of String = ('phone', 'fax', 'email', 'url');
  CODES_TContactUse : Array[TContactUse] of String = ('home', 'work', 'temp', 'old', 'mobile');
  CODES_TAddressUse : Array[TAddressUse] of String = ('home', 'work', 'temp', 'old');
  CODES_TAddressPartType : Array[TAddressPartType] of String = ('part', 'line', 'city', 'state', 'country', 'zip', 'dpid');
  CODES_TNameUse : Array[TNameUse] of String = ('usual', 'official', 'temp', 'anonymous', 'old', 'maiden');
  CODES_TNamePartType : Array[TNamePartType] of String = ('family', 'given', 'title');
  CODES_TRestfulConformanceMode : Array[TRestfulConformanceMode] of String = ('client', 'server');
  CODES_TDocumentAuthenticationMode : Array[TDocumentAuthenticationMode] of String = ('personal', 'professional', 'legal');
  CODES_TResponseCode : Array[TResponseCode] of String = ('ok', 'error', 'rejection', 'rules', 'undeliverable');
  CODES_TMessageConformanceEventMode : Array[TMessageConformanceEventMode] of String = ('sender', 'receiver');
  CODES_TPrescriptionStatus : Array[TPrescriptionStatus] of String = ('active', 'completed');
  CODES_TBooleanYesNo : Array[TBooleanYesNo] of String = ('yes', 'no');
  CODES_TLabReportStatus : Array[TLabReportStatus] of String = ('registered', 'interim', 'final', 'amended', 'cancelled', 'withdrawn');
  CODES_TLabResultFlag : Array[TLabResultFlag] of String = ('-', '--', '---', '+', '++', '+++');
  CODES_TLanguageUse : Array[TLanguageUse] of String = ('none', 'poor', 'useable', 'fluent');
  FHIR_GENERATED_VERSION = '0.01';


Type
  TFHIRResource = class;
  TExtensionList = class;
  TExtension = class;
  TConstraintElementMappingList = class;
  TConstraintElementValueList = class;
  TConstraintElement = class;
  TConstraintElementMapping = class;
  TConstraintElementAggregation = class;
  TConstraintElementValue = class;
  TConstraintElementList = class;
  TConstraint = class;
  TNarrativeImage = class;
  TNarrativeMap = class;
  TNarrativeImageList = class;
  TNarrativeMapList = class;
  TNarrative = class;
  TCoding = class;
  TInterval_Quantity = class;
  TInterval_DateTime = class;
  TInterval_Date = class;
  TQuantity = class;
  TChoiceValue = class;
  TChoiceValueList = class;
  TChoice = class;
  TAttachment = class;
  TRatio = class;
  TCodeableConceptCoding = class;
  TCodeableConceptCodingList = class;
  TCodeableConcept = class;
  TIdentifier = class;
  TScheduleRepeat = class;
  TInterval_dateTimeList = class;
  TSchedule = class;
  TContact = class;
  TAddressPart = class;
  TAddressPartList = class;
  TAddress = class;
  THumanNamePart = class;
  THumanNamePartList = class;
  THumanName = class;
  THumanId = class;
  TAddressList = class;
  TContactList = class;
  TConformancePublisher = class;
  TConformanceSoftware = class;
  TConformanceOperation = class;
  TConformanceOperationTransaction = class;
  TConformanceOperationSearch = class;
  TConformanceOperationCreate = class;
  TConformance = class;
  TDocumentAuthor = class;
  TDocumentAttestor = class;
  TDocumentSectionList = class;
  TDocumentSection = class;
  TDocumentSectionAuthor = class;
  TDocumentAuthorList = class;
  TDocumentAttestorList = class;
  TDocument = class;
  TMessageResponse = class;
  TMessage = class;
  TMessageConformancePublisher = class;
  TMessageConformanceSoftware = class;
  TMessageConformanceEvent = class;
  TConstraintList = class;
  TMessageConformanceEventRequest = class;
  TMessageConformanceEventResponse = class;
  TMessageConformanceEventList = class;
  TMessageConformance = class;
  TCodeableConceptList = class;
  THumanIdList = class;
  TAgent = class;
  TAnimalRelatedEntity = class;
  THumanNameList = class;
  TAnimalRelatedEntityList = class;
  TAnimal = class;
  TPrescriptionDispense = class;
  TPrescriptionMedicineActiveIngredientList = class;
  TPrescriptionMedicineInactiveIngredientList = class;
  TPrescriptionMedicine = class;
  TPrescriptionMedicineActiveIngredient = class;
  TPrescriptionMedicineInactiveIngredient = class;
  TPrescriptionAdministrationRequestDosageInstructionList = class;
  TPrescriptionAdministrationRequest = class;
  TScheduleList = class;
  TPrescriptionAdministrationRequestDosageInstruction = class;
  TPrescription = class;
  TPatient = class;
  TOrganizationName = class;
  TOrganizationAccreditation = class;
  TOrganizationRelatedOrganization = class;
  TOrganizationNameList = class;
  TOrganizationAccreditationList = class;
  TOrganizationRelatedOrganizationList = class;
  TOrganization = class;
  TDocumentConformancePublisher = class;
  TDocumentConformanceSoftware = class;
  TDocumentConformanceDocument = class;
  TDocumentConformanceDocumentList = class;
  TDocumentConformance = class;
  TLabReportRequestDetail = class;
  TLabReportResultGroupResultList = class;
  TLabReportResultGroup = class;
  TLabReportResultGroupResultReferenceRangeList = class;
  TLabReportResultGroupResult = class;
  TLabReportResultGroupResultReferenceRange = class;
  TLabReportRequestDetailList = class;
  TLabReportResultGroupList = class;
  TAttachmentList = class;
  TLabReport = class;
  TPersonQualification = class;
  TPersonLanguage = class;
  TPersonRelatedPerson = class;
  TPersonQualificationList = class;
  TPersonLanguageList = class;
  TPersonRelatedPersonList = class;
  TPerson = class;

  {@Class TFHIRResource
    Base Resource Definition - id, extensions, narrative
  }
  TFHIRResource = {abstract} class (TFHIRElement)
  private
    FId : String;
    FText : TNarrative;
    procedure SetResourceId(value : string);
    procedure SetText(value : TNarrative);
  protected
    function GetResourceType : TFHIRResourceType; virtual; abstract;
  public
    constructor Create; override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TFHIRResource; overload;
    function Clone : TFHIRResource; overload;
    Property ResourceType : TFHIRResourceType read GetResourceType;

    {@member code
      The code that identifies the meaning of the extension by reference to the definitions
    }
    property id : String read FId write SetResourceId;

    {@member text
      Text summary of resource, for human interpretation
    }
    property text : TNarrative read FText write SetText;
  end;


  {@Class TExtensionList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ExtensionList}
  TExtensionList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TExtension;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TExtension) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TExtension;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TExtension read GetItemN; default;
  End;


  {@Class TExtension
    Optional Extensions Element - found in all resources
  }
  TExtension = class (TFHIRElement)
  private
    FCode : String;
    FDefinition : String;
    FRef : String;
    FState : TExtensionState;
    FValue : TFHIRType;
    FExtension : TExtensionList;
    Procedure SetCode(value : String);
    Procedure SetDefinition(value : String);
    Procedure SetRef(value : String);
    Procedure SetState(value : TExtensionState);
    Procedure SetValue(value : TFHIRType);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TExtension; overload;
    function Clone : TExtension; overload;
    {@member code
      The code that identifies the meaning of the extension by reference to the definitions
    }
    property code : String read FCode write SetCode;

    {@member definition
      Source of the definition for the code - a namespace or a URL
    }
    property definition : String read FDefinition write SetDefinition;

    {@member ref
      Internal reference to context of the extension - a pointer to an xml:id in the same resource
    }
    property ref : String read FRef write SetRef;

    {@member state
      The state or the extension - whether readers must must understand, or whether it's superceded by being defined in the resource
    }
    property state : TExtensionState read FState write SetState;

    {@member value
      Value of extension - any of the types defined in the data types
    }
    property value : TFHIRType read FValue write SetValue;

    {@member Extension
      Nested Extensions - further extensions that are part of the extension
    }
    property Extension : TExtensionList read FExtension;

  end;


  {@Class TConstraintElementMappingList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ConstraintElementMappingList}
  TConstraintElementMappingList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TConstraintElementMapping;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TConstraintElementMapping) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TConstraintElementMapping;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TConstraintElementMapping read GetItemN; default;
  End;


  {@Class TConstraintElementValueList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ConstraintElementValueList}
  TConstraintElementValueList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TConstraintElementValue;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TConstraintElementValue) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TConstraintElementValue;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TConstraintElementValue read GetItemN; default;
  End;


  {@Class TConstraintElement
    
  }
  TConstraintElement = class (TFHIRElement)
  private
    FPath : String;
    FName : String;
    FPurpose : String;
    FMin : Integer;
    FMax : String;
    FType_ : String;
    FConformance : TConformanceType;
    FCondition : String;
    FMustSupport : Boolean;
    FMustUnderstand : Boolean;
    FDefinition : String;
    FMapping : TConstraintElementMappingList;
    FAggregation : TConstraintElementAggregation;
    FValueSet : String;
    FValue : TConstraintElementValueList;
    Procedure SetPath(value : String);
    Procedure SetName(value : String);
    Procedure SetPurpose(value : String);
    Procedure SetMin(value : Integer);
    Procedure SetMax(value : String);
    Procedure SetType_(value : String);
    Procedure SetConformance(value : TConformanceType);
    Procedure SetCondition(value : String);
    Procedure SetMustSupport(value : Boolean);
    Procedure SetMustUnderstand(value : Boolean);
    Procedure SetDefinition(value : String);
    Procedure SetAggregation(value : TConstraintElementAggregation);
    Procedure SetValueSet(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConstraintElement; overload;
    function Clone : TConstraintElement; overload;
    {@member path
      The path of the element (see the formal definitions)
    }
    property path : String read FPath write SetPath;

    {@member name
      Name this constraint for re-use & unrolling
    }
    property name : String read FName write SetName;

    {@member purpose
      Human summary: why describe this element?
    }
    property purpose : String read FPurpose write SetPurpose;

    {@member min
      Minimum Cardinality
    }
    property min : Integer read FMin write SetMin;

    {@member max
      Maximum Cardinality (a number or *)
    }
    property max : String read FMax write SetMax;

    {@member type_
      Type of the element
    }
    property type_ : String read FType_ write SetType_;

    {@member conformance
      Mandatory|Conditional|Optional|Prohibited
    }
    property conformance : TConformanceType read FConformance write SetConformance;

    {@member condition
      Condition if conformance=Conditional
    }
    property condition : String read FCondition write SetCondition;

    {@member mustSupport
      If the element must be usable
    }
    property mustSupport : Boolean read FMustSupport write SetMustSupport;

    {@member mustUnderstand
      If the element must be understood
    }
    property mustUnderstand : Boolean read FMustUnderstand write SetMustUnderstand;

    {@member definition
      More specific definition
    }
    property definition : String read FDefinition write SetDefinition;

    {@member Mapping
      
    }
    property Mapping : TConstraintElementMappingList read FMapping;

    {@member aggregation
      If context includes aggregation and type=Resource()
    }
    property aggregation : TConstraintElementAggregation read FAggregation write SetAggregation;

    {@member valueSet
      Value set id (only if coded)
    }
    property valueSet : String read FValueSet write SetValueSet;

    {@member Value
      
    }
    property Value : TConstraintElementValueList read FValue;

  end;


  {@Class TConstraintElementMapping
    
  }
  TConstraintElementMapping = class (TFHIRElement)
  private
    FTarget : String;
    FMap : String;
    Procedure SetTarget(value : String);
    Procedure SetMap(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConstraintElementMapping; overload;
    function Clone : TConstraintElementMapping; overload;
    {@member target
      Which mapping this is (v2, CDA, openEHR, etc)
    }
    property target : String read FTarget write SetTarget;

    {@member map
      Details of the mapping
    }
    property map : String read FMap write SetMap;

  end;


  {@Class TConstraintElementAggregation
    If context includes aggregation and type=Resource()
  }
  TConstraintElementAggregation = class (TFHIRElement)
  private
    FAggregated : Boolean;
    FName : String;
    Procedure SetAggregated(value : Boolean);
    Procedure SetName(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConstraintElementAggregation; overload;
    function Clone : TConstraintElementAggregation; overload;
    {@member aggregated
      Whether this resource is aggregated
    }
    property aggregated : Boolean read FAggregated write SetAggregated;

    {@member name
      Reference to a Named Resource Profile
    }
    property name : String read FName write SetName;

  end;


  {@Class TConstraintElementValue
    
  }
  TConstraintElementValue = class (TFHIRElement)
  private
    FName : String;
    FValue : TFHIRType;
    Procedure SetName(value : String);
    Procedure SetValue(value : TFHIRType);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConstraintElementValue; overload;
    function Clone : TConstraintElementValue; overload;
    {@member name
      Reference to another element by element.name
    }
    property name : String read FName write SetName;

    {@member value
      Fixed value: [as defined for type]
    }
    property value : TFHIRType read FValue write SetValue;

  end;


  {@Class TConstraintElementList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ConstraintElementList}
  TConstraintElementList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TConstraintElement;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TConstraintElement) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TConstraintElement;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TConstraintElement read GetItemN; default;
  End;


  {@Class TConstraint
    
  }
  TConstraint = class (TFHIRElement)
  private
    FType_ : String;
    FName : String;
    FPurpose : String;
    FElement : TConstraintElementList;
    Procedure SetType_(value : String);
    Procedure SetName(value : String);
    Procedure SetPurpose(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConstraint; overload;
    function Clone : TConstraint; overload;
    {@member type_
      The Type of the resource being described
    }
    property type_ : String read FType_ write SetType_;

    {@member name
      The name of an aggregation profile
    }
    property name : String read FName write SetName;

    {@member purpose
      Human summary: why describe this resource?
    }
    property purpose : String read FPurpose write SetPurpose;

    {@member Element
      
    }
    property Element : TConstraintElementList read FElement;

  end;


  {@Class TNarrativeImage
    An image referred to directly in the xhtml
  }
  TNarrativeImage = class (TFHIRElement)
  private
    FMimeType : String;
    FContent : TAdvBuffer;
    Procedure SetMimeType(value : String);
    Procedure SetContent(value : TAdvBuffer);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TNarrativeImage; overload;
    function Clone : TNarrativeImage; overload;
    {@member mimeType
      mime type of image
    }
    property mimeType : String read FMimeType write SetMimeType;

    {@member content
      base64 image data
    }
    property content : TAdvBuffer read FContent write SetContent;

  end;


  {@Class TNarrativeMap
    A map from the narrative contents to the resource elements - an assertion that the text describes the some content as the data item describes
  }
  TNarrativeMap = class (TFHIRElement)
  private
    FText : String;
    FData : String;
    FSource : TNarrativeMapSource;
    Procedure SetText(value : String);
    Procedure SetData(value : String);
    Procedure SetSource(value : TNarrativeMapSource);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TNarrativeMap; overload;
    function Clone : TNarrativeMap; overload;
    {@member text
      The narrative end of the mapping
    }
    property text : String read FText write SetText;

    {@member data
      The resource element end of the mapping
    }
    property data : String read FData write SetData;

    {@member source
      Which end of the mapping is the source
    }
    property source : TNarrativeMapSource read FSource write SetSource;

  end;


  {@Class TNarrativeImageList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.NarrativeImageList}
  TNarrativeImageList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TNarrativeImage;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TNarrativeImage) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TNarrativeImage;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TNarrativeImage read GetItemN; default;
  End;


  {@Class TNarrativeMapList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.NarrativeMapList}
  TNarrativeMapList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TNarrativeMap;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TNarrativeMap) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TNarrativeMap;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TNarrativeMap read GetItemN; default;
  End;


  {@Class TNarrative
    A human readable formatted text, including images
  }
  TNarrative = class (TFHIRElement)
  private
    FStatus : TNarrativeStatus;
    FHtml : TXHtml;
    FImage : TNarrativeImageList;
    FMap : TNarrativeMapList;
    Procedure SetStatus(value : TNarrativeStatus);
    Procedure SetHtml(value : TXHtml);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TNarrative; overload;
    function Clone : TNarrative; overload;
    {@member status
      The status of the narrative - whether it is entirely generated (from just the defined data or the extensions too), or whether a human authored it, and it may contain additional data
    }
    property status : TNarrativeStatus read FStatus write SetStatus;

    {@member html
      The actual narrative content, a stripped down version of XHTML
    }
    property html : TXHtml read FHtml write SetHtml;

    {@member Image
      An image referred to directly in the xhtml
    }
    property Image : TNarrativeImageList read FImage;

    {@member Map
      A map from the narrative contents to the resource elements - an assertion that the text describes the some content as the data item describes
    }
    property Map : TNarrativeMapList read FMap;

  end;


  {@Class TCoding
    A reference to a code defined by a terminology system 
  }
  TCoding = class (TFHIRType)
  private
    FCode : String;
    FSystem : String;
    FDisplay : String;
    Procedure SetCode(value : String);
    Procedure SetSystem(value : String);
    Procedure SetDisplay(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TCoding; overload;
    function Clone : TCoding; overload;
    {@member code
      A symbol in syntax defined by the system. The symbol may be a predefined code, or an expression in a syntax defined by the coding system
    }
    property code : String read FCode write SetCode;

    {@member system
      The identification of the system that defines the meaning of the symbol in the code. Can be a simple list of enumerations, a list of codes with meanings, or all the way to a complex semantic web such as SNOMED-CT, whether classification, terminology, or ontology
    }
    property system : String read FSystem write SetSystem;

    {@member display
      A representation of the meaning of the code in the system, following the rules laid out by the system. 
    }
    property display : String read FDisplay write SetDisplay;

  end;


  {@Class TInterval_Quantity
    A set of ordered values defined by a low and high limit. The values may be of type Quantity, date, or dateTime
  }
  TInterval_Quantity = class (TFHIRType)
  private
    FLow : TQuantity;
    FHigh : TQuantity;
    Procedure SetLow(value : TQuantity);
    Procedure SetHigh(value : TQuantity);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TInterval_Quantity; overload;
    function Clone : TInterval_Quantity; overload;
    {@member low
      The low value. The boundary is inclusive.
    }
    property low : TQuantity read FLow write SetLow;

    {@member high
      The high value. The boundary is inclusive. See discussion in specification regarding how the high value boundary is interpreted for dates
    }
    property high : TQuantity read FHigh write SetHigh;

  end;


  {@Class TInterval_DateTime
    A set of ordered values defined by a low and high limit. The values may be of type Quantity, date, or dateTime
  }
  TInterval_DateTime = class (TFHIRType)
  private
    FLow : String;
    FHigh : String;
    Procedure SetLow(value : String);
    Procedure SetHigh(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TInterval_DateTime; overload;
    function Clone : TInterval_DateTime; overload;
    {@member low
      The low value. The boundary is inclusive.
    }
    property low : String read FLow write SetLow;

    {@member high
      The high value. The boundary is inclusive. See discussion in specification regarding how the high value boundary is interpreted for dates
    }
    property high : String read FHigh write SetHigh;

  end;


  {@Class TInterval_Date
    A set of ordered values defined by a low and high limit. The values may be of type Quantity, date, or dateTime
  }
  TInterval_Date = class (TFHIRType)
  private
    FLow : String;
    FHigh : String;
    Procedure SetLow(value : String);
    Procedure SetHigh(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TInterval_Date; overload;
    function Clone : TInterval_Date; overload;
    {@member low
      The low value. The boundary is inclusive.
    }
    property low : String read FLow write SetLow;

    {@member high
      The high value. The boundary is inclusive. See discussion in specification regarding how the high value boundary is interpreted for dates
    }
    property high : String read FHigh write SetHigh;

  end;


  {@Class TQuantity
    A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitary units, and floating currencies
  }
  TQuantity = class (TFHIRType)
  private
    FValue : TSmartDecimal;
    FStatus : TQuantityStatus;
    FUnits : String;
    FCode : String;
    FSystem : String;
    Procedure SetValue(value : TSmartDecimal);
    Procedure SetStatus(value : TQuantityStatus);
    Procedure SetUnits(value : String);
    Procedure SetCode(value : String);
    Procedure SetSystem(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TQuantity; overload;
    function Clone : TQuantity; overload;
    {@member value
      The value of the measured amount. The value includes an implicit precision in the presentation of the value
    }
    property value : TSmartDecimal read FValue write SetValue;

    {@member status
      how the value should be understood and represented - whether the actual value is greater or less than the mesaure due to measurement issues
    }
    property status : TQuantityStatus read FStatus write SetStatus;

    {@member units
      A human readable form of the units
    }
    property units : String read FUnits write SetUnits;

    {@member code
      A computer processible form of the units in some unit representation system
    }
    property code : String read FCode write SetCode;

    {@member system
      The identification of the system that provides the coded form of the unit
    }
    property system : String read FSystem write SetSystem;

  end;


  {@Class TChoiceValue
    A list of possible values for the code
  }
  TChoiceValue = class (TFHIRElement)
  private
    FCode : String;
    FDisplay : String;
    Procedure SetCode(value : String);
    Procedure SetDisplay(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TChoiceValue; overload;
    function Clone : TChoiceValue; overload;
    {@member code
      A possible code or value that the user could have chosen
    }
    property code : String read FCode write SetCode;

    {@member display
      A set of words associated with the code to give it meaning, if any exist
    }
    property display : String read FDisplay write SetDisplay;

  end;


  {@Class TChoiceValueList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ChoiceValueList}
  TChoiceValueList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TChoiceValue;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TChoiceValue) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TChoiceValue;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TChoiceValue read GetItemN; default;
  End;


  {@Class TChoice
    A code taken from a short list of codes that are not defined in a formal code system
  }
  TChoice = class (TFHIRType)
  private
    FCode : String;
    FValue : TChoiceValueList;
    FIsOrdered : Boolean;
    Procedure SetCode(value : String);
    Procedure SetIsOrdered(value : Boolean);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TChoice; overload;
    function Clone : TChoice; overload;
    {@member code
      The code or value that the user selected from the list of possible codes
    }
    property code : String read FCode write SetCode;

    {@member Value
      A list of possible values for the code
    }
    property Value : TChoiceValueList read FValue;

    {@member isOrdered
      Whether the order of the values has an assigned meaning
    }
    property isOrdered : Boolean read FIsOrdered write SetIsOrdered;

  end;


  {@Class TAttachment
    For referring to data content defined in other formats.
  }
  TAttachment = class (TFHIRType)
  private
    FMimeType : String;
    FData : TAdvBuffer;
    FUrl : String;
    FHash : TAdvBuffer;
    FLang : String;
    FTitle : String;
    Procedure SetMimeType(value : String);
    Procedure SetData(value : TAdvBuffer);
    Procedure SetUrl(value : String);
    Procedure SetHash(value : TAdvBuffer);
    Procedure SetLang(value : String);
    Procedure SetTitle(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TAttachment; overload;
    function Clone : TAttachment; overload;
    {@member mimeType
      Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data
    }
    property mimeType : String read FMimeType write SetMimeType;

    {@member data
      The actual data of the attachment - a sequence of bytes. In XML, represented using base64
    }
    property data : TAdvBuffer read FData write SetData;

    {@member url
      An alternative location where the data can be accessed
    }
    property url : String read FUrl write SetUrl;

    {@member hash
      The calculated hash of the data using SHA-256. In XML, represented using base64
    }
    property hash : TAdvBuffer read FHash write SetHash;

    {@member lang
      The language that the attachment is in
    }
    property lang : String read FLang write SetLang;

    {@member title
      A name to display in place of the data
    }
    property title : String read FTitle write SetTitle;

  end;


  {@Class TRatio
    A ratio of two Quantity values - a numerator and a denominator. 
  }
  TRatio = class (TFHIRType)
  private
    FNumerator : TQuantity;
    FDenominator : TQuantity;
    Procedure SetNumerator(value : TQuantity);
    Procedure SetDenominator(value : TQuantity);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TRatio; overload;
    function Clone : TRatio; overload;
    {@member numerator
      The numerator
    }
    property numerator : TQuantity read FNumerator write SetNumerator;

    {@member denominator
      The denominator
    }
    property denominator : TQuantity read FDenominator write SetDenominator;

  end;


  {@Class TCodeableConceptCoding
    A reference to a code defined by a terminology system 
  }
  TCodeableConceptCoding = class (TFHIRElement)
  private
    FCode : String;
    FSystem : String;
    FDisplay : String;
    Procedure SetCode(value : String);
    Procedure SetSystem(value : String);
    Procedure SetDisplay(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TCodeableConceptCoding; overload;
    function Clone : TCodeableConceptCoding; overload;
    {@member code
      A symbol in syntax defined by the system. The symbol may be a predefined code, or an expression in a syntax defined by the coding system
    }
    property code : String read FCode write SetCode;

    {@member system
      The identification of the system that defines the meaning of the symbol in the code. Can be a simple list of enumerations, a list of codes with meanings, or all the way to a complex semantic web such as SNOMED-CT, whether classification, terminology, or ontology
    }
    property system : String read FSystem write SetSystem;

    {@member display
      A representation of the meaning of the code in the system, following the rules laid out by the system. 
    }
    property display : String read FDisplay write SetDisplay;

  end;


  {@Class TCodeableConceptCodingList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.CodeableConceptCodingList}
  TCodeableConceptCodingList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TCodeableConceptCoding;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TCodeableConceptCoding) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TCodeableConceptCoding;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TCodeableConceptCoding read GetItemN; default;
  End;


  {@Class TCodeableConcept
    A concept that may be defined by a formal reference to a terminology or ontology, or may be provided by text
  }
  TCodeableConcept = class (TFHIRType)
  private
    FCoding : TCodeableConceptCodingList;
    FText : String;
    FPrimary : String;
    Procedure SetText(value : String);
    Procedure SetPrimary(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TCodeableConcept; overload;
    function Clone : TCodeableConcept; overload;
    {@member Coding
      A reference to a code defined by a terminology system 
    }
    property Coding : TCodeableConceptCodingList read FCoding;

    {@member text
      A human language representation of the concept as seen/selected/uttered by the user who entered the data, and/or which represents the intended meaning of the user or concept
    }
    property text : String read FText write SetText;

    {@member primary
      Indicates which of the codes in the codings was chosen by a user, if one was chosen directly
    }
    property primary : String read FPrimary write SetPrimary;

  end;


  {@Class TIdentifier
    A technical identifier - identifies some entity uniquely and unambiguously
  }
  TIdentifier = class (TFHIRType)
  private
    FSystem : String;
    FId : String;
    Procedure SetSystem(value : String);
    Procedure SetId(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TIdentifier; overload;
    function Clone : TIdentifier; overload;
    {@member system
      Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data
    }
    property system : String read FSystem write SetSystem;

    {@member id
      The actual data of the attachment
    }
    property id : String read FId write SetId;

  end;


  {@Class TScheduleRepeat
    Only if there is none or one event
  }
  TScheduleRepeat = class (TFHIRElement)
  private
    FFrequency : Integer;
    FWhen : TEventTiming;
    FDuration : TQuantity;
    FCount : Integer;
    FEnd_ : String;
    Procedure SetFrequency(value : Integer);
    Procedure SetWhen(value : TEventTiming);
    Procedure SetDuration(value : TQuantity);
    Procedure SetCount(value : Integer);
    Procedure SetEnd_(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TScheduleRepeat; overload;
    function Clone : TScheduleRepeat; overload;
    {@member frequency
      Event occurs frequency times per duration
    }
    property frequency : Integer read FFrequency write SetFrequency;

    {@member when
      Event occurs duration from common life event
    }
    property when : TEventTiming read FWhen write SetWhen;

    {@member duration
      repeating or event-related duration
    }
    property duration : TQuantity read FDuration write SetDuration;

    {@member count
      number of times to repeat
    }
    property count : Integer read FCount write SetCount;

    {@member end_
      when to stop repeats
    }
    property end_ : String read FEnd_ write SetEnd_;

  end;


  {@Class TInterval_dateTimeList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.Interval_dateTimeList}
  TInterval_dateTimeList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TInterval_dateTime;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TInterval_dateTime) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TInterval_dateTime;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TInterval_dateTime read GetItemN; default;
  End;


  {@Class TSchedule
    A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things did happen, but when they are expected or requested to occur.
  }
  TSchedule = class (TFHIRType)
  private
    FEvent : TInterval_dateTimeList;
    FRepeat_ : TScheduleRepeat;
    Procedure SetRepeat_(value : TScheduleRepeat);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TSchedule; overload;
    function Clone : TSchedule; overload;
    {@member Event
      When the event occurs
    }
    property Event : TInterval_dateTimeList read FEvent;

    {@member repeat_
      Only if there is none or one event
    }
    property repeat_ : TScheduleRepeat read FRepeat_ write SetRepeat_;

  end;


  {@Class TContact
    All kinds of technology mediated contact details for a person or organisation, including telephone, email, etc
  }
  TContact = class (TFHIRType)
  private
    FSystem : TContactSystem;
    FValue : String;
    FUse : TContactUse;
    FPeriod : TInterval_dateTime;
    Procedure SetSystem(value : TContactSystem);
    Procedure SetValue(value : String);
    Procedure SetUse(value : TContactUse);
    Procedure SetPeriod(value : TInterval_dateTime);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TContact; overload;
    function Clone : TContact; overload;
    {@member system
      What kind of contact this is - what communications system is required to make use of the contact
    }
    property system : TContactSystem read FSystem write SetSystem;

    {@member value
      The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address).
    }
    property value : String read FValue write SetValue;

    {@member use
      How to use this address
    }
    property use : TContactUse read FUse write SetUse;

    {@member period
      Time period when the contact was/is in use
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

  end;


  {@Class TAddressPart
    A part of an address
  }
  TAddressPart = class (TFHIRElement)
  private
    FType_ : TAddressPartType;
    FValue : String;
    Procedure SetType_(value : TAddressPartType);
    Procedure SetValue(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TAddressPart; overload;
    function Clone : TAddressPart; overload;
    {@member type_
      Type of address part (see below)
    }
    property type_ : TAddressPartType read FType_ write SetType_;

    {@member value
      The content of the address part
    }
    property value : String read FValue write SetValue;

  end;


  {@Class TAddressPartList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.AddressPartList}
  TAddressPartList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TAddressPart;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TAddressPart) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TAddressPart;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TAddressPart read GetItemN; default;
  End;


  {@Class TAddress
    There is a variety of postal address formats defined around the world. This format defines a superset that is the basis for addresses all around the world 
  }
  TAddress = class (TFHIRType)
  private
    FUse : TAddressUse;
    FText : String;
    FPart : TAddressPartList;
    FPeriod : TInterval_dateTime;
    Procedure SetUse(value : TAddressUse);
    Procedure SetText(value : String);
    Procedure SetPeriod(value : TInterval_dateTime);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TAddress; overload;
    function Clone : TAddress; overload;
    {@member use
      The use of this address
    }
    property use : TAddressUse read FUse write SetUse;

    {@member text
      a full text representation of the address
    }
    property text : String read FText write SetText;

    {@member Part
      A part of an address
    }
    property Part : TAddressPartList read FPart;

    {@member period
      Time period when address was/is in use
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

  end;


  {@Class THumanNamePart
    A part of a name
  }
  THumanNamePart = class (TFHIRElement)
  private
    FType_ : TNamePartType;
    FValue : String;
    Procedure SetType_(value : TNamePartType);
    Procedure SetValue(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : THumanNamePart; overload;
    function Clone : THumanNamePart; overload;
    {@member type_
      Type of name part
    }
    property type_ : TNamePartType read FType_ write SetType_;

    {@member value
      The content of the name part
    }
    property value : String read FValue write SetValue;

  end;


  {@Class THumanNamePartList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.HumanNamePartList}
  THumanNamePartList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : THumanNamePart;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : THumanNamePart) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : THumanNamePart;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : THumanNamePart read GetItemN; default;
  End;


  {@Class THumanName
    A name of a human, or a name given to an animal by a human.
  }
  THumanName = class (TFHIRType)
  private
    FUse : TNameUse;
    FText : String;
    FPart : THumanNamePartList;
    FPeriod : TInterval_dateTime;
    Procedure SetUse(value : TNameUse);
    Procedure SetText(value : String);
    Procedure SetPeriod(value : TInterval_dateTime);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : THumanName; overload;
    function Clone : THumanName; overload;
    {@member use
      The use of this name
    }
    property use : TNameUse read FUse write SetUse;

    {@member text
      a full text representation of the name
    }
    property text : String read FText write SetText;

    {@member Part
      A part of a name
    }
    property Part : THumanNamePartList read FPart;

    {@member period
      Time period when name was/is in use
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

  end;


  {@Class THumanId
    An identifier that humans use. This is different to a system identifier because identifiers that humans use are regularly changed or retired due to human intervention and error. Note that an human identifier may be a system identifier on some master system, but becomes a human identifier elsewhere due to how it is exchanged between humans. Driver's license nunmbers are a good example of this. Also, because human mediated identifiers are often invoked as implicit links to external business processes, such identifiers are often associated with multiple different resources. 
  }
  THumanId = class (TFHIRType)
  private
    FType_ : TCoding;
    FIdentifier : TIdentifier;
    FPeriod : TInterval_dateTime;
    FAssigner : TFHIRResourceReference{TOrganization};
    Procedure SetType_(value : TCoding);
    Procedure SetIdentifier(value : TIdentifier);
    Procedure SetPeriod(value : TInterval_dateTime);
    Procedure SetAssigner(value : TFHIRResourceReference{TOrganization});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : THumanId; overload;
    function Clone : THumanId; overload;
    {@member type_
      The type of the identifier - to allow a particular identifier to be picked elsewhere
    }
    property type_ : TCoding read FType_ write SetType_;

    {@member identifier
      The Actual identifier
    }
    property identifier : TIdentifier read FIdentifier write SetIdentifier;

    {@member period
      Time period during which identifier was valid for use
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

    {@member assigner
      Organisation that issued/manages the identifier
    }
    property assigner : TFHIRResourceReference{TOrganization} read FAssigner write SetAssigner;

  end;


  {@Class TAddressList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.AddressList}
  TAddressList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TAddress;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TAddress) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TAddress;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TAddress read GetItemN; default;
  End;


  {@Class TContactList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ContactList}
  TContactList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TContact;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TContact) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TContact;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TContact read GetItemN; default;
  End;


  {@Class TConformancePublisher
    The organization that publishes this conformance statement
  }
  TConformancePublisher = class (TFHIRElement)
  private
    FName : String;
    FAddress : TAddressList;
    FContact : TContactList;
    Procedure SetName(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConformancePublisher; overload;
    function Clone : TConformancePublisher; overload;
    {@member name
      Name of Organization
    }
    property name : String read FName write SetName;

    {@member Address
      Address of Organization
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      Contacts for Organization
    }
    property Contact : TContactList read FContact;

  end;


  {@Class TConformanceSoftware
    The software that is covered by this conformance statement
  }
  TConformanceSoftware = class (TFHIRElement)
  private
    FName : String;
    FVersion : String;
    FReleaseDate : String;
    Procedure SetName(value : String);
    Procedure SetVersion(value : String);
    Procedure SetReleaseDate(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConformanceSoftware; overload;
    function Clone : TConformanceSoftware; overload;
    {@member name
      Name software is known by
    }
    property name : String read FName write SetName;

    {@member version
      Version covered by this statement
    }
    property version : String read FVersion write SetVersion;

    {@member releaseDate
      Date this version released
    }
    property releaseDate : String read FReleaseDate write SetReleaseDate;

  end;


  {@Class TConformanceOperation
    
  }
  TConformanceOperation = class (TFHIRElement)
  private
    FRead : Boolean;
    FVread : Boolean;
    FUpdate : Boolean;
    FDelete : Boolean;
    FValidate : Boolean;
    FHistory : Boolean;
    FTransaction : TConformanceOperationTransaction;
    FSearch : TConformanceOperationSearch;
    FCreate_ : TConformanceOperationCreate;
    FUpdates : Boolean;
    FSchema : Boolean;
    Procedure SetRead(value : Boolean);
    Procedure SetVread(value : Boolean);
    Procedure SetUpdate(value : Boolean);
    Procedure SetDelete(value : Boolean);
    Procedure SetValidate(value : Boolean);
    Procedure SetHistory(value : Boolean);
    Procedure SetTransaction(value : TConformanceOperationTransaction);
    Procedure SetSearch(value : TConformanceOperationSearch);
    Procedure SetCreate_(value : TConformanceOperationCreate);
    Procedure SetUpdates(value : Boolean);
    Procedure SetSchema(value : Boolean);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConformanceOperation; overload;
    function Clone : TConformanceOperation; overload;
    {@member read
      if supported
    }
    property read : Boolean read FRead write SetRead;

    {@member vread
      if supported
    }
    property vread : Boolean read FVread write SetVread;

    {@member update
      if supported
    }
    property update : Boolean read FUpdate write SetUpdate;

    {@member delete
      if supported
    }
    property delete : Boolean read FDelete write SetDelete;

    {@member validate
      if supported
    }
    property validate : Boolean read FValidate write SetValidate;

    {@member history
      if supported
    }
    property history : Boolean read FHistory write SetHistory;

    {@member transaction
      only if supported
    }
    property transaction : TConformanceOperationTransaction read FTransaction write SetTransaction;

    {@member search
      only if supported
    }
    property search : TConformanceOperationSearch read FSearch write SetSearch;

    {@member create_
      if supported
    }
    property create_ : TConformanceOperationCreate read FCreate_ write SetCreate_;

    {@member updates
      if supported
    }
    property updates : Boolean read FUpdates write SetUpdates;

    {@member schema
      if supported
    }
    property schema : Boolean read FSchema write SetSchema;

  end;


  {@Class TConformanceOperationTransaction
    only if supported
  }
  TConformanceOperationTransaction = class (TFHIRElement)
  private
    FName : TStringList;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConformanceOperationTransaction; overload;
    function Clone : TConformanceOperationTransaction; overload;
    {@member Name
      transaction names supported
    }
    property Name : TStringList read FName;

  end;


  {@Class TConformanceOperationSearch
    only if supported
  }
  TConformanceOperationSearch = class (TFHIRElement)
  private
    FParam : TStringList;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConformanceOperationSearch; overload;
    function Clone : TConformanceOperationSearch; overload;
    {@member Param
      search params supported
    }
    property Param : TStringList read FParam;

  end;


  {@Class TConformanceOperationCreate
    if supported
  }
  TConformanceOperationCreate = class (TFHIRElement)
  private
    FId : String;
    Procedure SetId(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConformanceOperationCreate; overload;
    function Clone : TConformanceOperationCreate; overload;
    {@member id
      source of id: client | server | either
    }
    property id : String read FId write SetId;

  end;


  {@Class TConformance
    A conformance statement returned by request in an RESTful framework
  }
  TConformance = class (TFHIRResource)
  private
    FDate : String;
    FPublisher : TConformancePublisher;
    FSoftware : TConformanceSoftware;
    FMode : TRestfulConformanceMode;
    FResource : TConstraint;
    FOperation : TConformanceOperation;
    Procedure SetDate(value : String);
    Procedure SetPublisher(value : TConformancePublisher);
    Procedure SetSoftware(value : TConformanceSoftware);
    Procedure SetMode(value : TRestfulConformanceMode);
    Procedure SetResource(value : TConstraint);
    Procedure SetOperation(value : TConformanceOperation);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TConformance; overload;
    function Clone : TConformance; overload;
    {@member date
      Date that the conformance statement is published
    }
    property date : String read FDate write SetDate;

    {@member publisher
      The organization that publishes this conformance statement
    }
    property publisher : TConformancePublisher read FPublisher write SetPublisher;

    {@member software
      The software that is covered by this conformance statement
    }
    property software : TConformanceSoftware read FSoftware write SetSoftware;

    {@member mode
      client | server
    }
    property mode : TRestfulConformanceMode read FMode write SetMode;

    {@member resource
      Resource Type with constraints
    }
    property resource : TConstraint read FResource write SetResource;

    {@member operation
      
    }
    property operation : TConformanceOperation read FOperation write SetOperation;

  end;


  {@Class TDocumentAuthor
    Author (contributed content to document)
  }
  TDocumentAuthor = class (TFHIRElement)
  private
    FTime : String;
    FParty : TFHIRResourceReference{Resource};
    Procedure SetTime(value : String);
    Procedure SetParty(value : TFHIRResourceReference{Resource});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentAuthor; overload;
    function Clone : TDocumentAuthor; overload;
    {@member time
      When authoring happened
    }
    property time : String read FTime write SetTime;

    {@member party
      person|device that authored the document
    }
    property party : TFHIRResourceReference{Resource} read FParty write SetParty;

  end;


  {@Class TDocumentAttestor
    a participant who has attested to the accuracy of the document
  }
  TDocumentAttestor = class (TFHIRElement)
  private
    FMode : TDocumentAuthenticationMode;
    FTime : String;
    FParty : TFHIRResourceReference{TPerson};
    Procedure SetMode(value : TDocumentAuthenticationMode);
    Procedure SetTime(value : String);
    Procedure SetParty(value : TFHIRResourceReference{TPerson});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentAttestor; overload;
    function Clone : TDocumentAttestor; overload;
    {@member mode
      The type of attestation the authenticator offers
    }
    property mode : TDocumentAuthenticationMode read FMode write SetMode;

    {@member time
      When document attested
    }
    property time : String read FTime write SetTime;

    {@member party
      the person who attested the document
    }
    property party : TFHIRResourceReference{TPerson} read FParty write SetParty;

  end;


  {@Class TDocumentSectionList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.DocumentSectionList}
  TDocumentSectionList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TDocumentSection;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TDocumentSection) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TDocumentSection;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TDocumentSection read GetItemN; default;
  End;


  {@Class TDocumentSection
    Document is broken into sections
  }
  TDocumentSection = class (TFHIRElement)
  private
    FType_ : TCodeableConcept;
    FInstant : TDateTime;
    FAuthor : TDocumentSectionAuthor;
    FEnterer : TFHIRResourceReference{Resource};
    FSubject : TFHIRResourceReference{Resource};
    FInformant : TFHIRResourceReference{TPerson};
    FContent : TFHIRResourceReference{Resource};
    FSection : TDocumentSectionList;
    Procedure SetType_(value : TCodeableConcept);
    Procedure SetInstant(value : TDateTime);
    Procedure SetAuthor(value : TDocumentSectionAuthor);
    Procedure SetEnterer(value : TFHIRResourceReference{Resource});
    Procedure SetSubject(value : TFHIRResourceReference{Resource});
    Procedure SetInformant(value : TFHIRResourceReference{TPerson});
    Procedure SetContent(value : TFHIRResourceReference{Resource});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentSection; overload;
    function Clone : TDocumentSection; overload;
    {@member type_
      type of section (recommended)
    }
    property type_ : TCodeableConcept read FType_ write SetType_;

    {@member instant
      the section creation time (sections are often re-used in several documents).
    }
    property instant : TDateTime read FInstant write SetInstant;

    {@member author
      if section author different to document
    }
    property author : TDocumentSectionAuthor read FAuthor write SetAuthor;

    {@member enterer
      The person or device that performed the data entry leading to this section. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
    }
    property enterer : TFHIRResourceReference{Resource} read FEnterer write SetEnterer;

    {@member subject
      if section different to document
    }
    property subject : TFHIRResourceReference{Resource} read FSubject write SetSubject;

    {@member informant
      provided information in section
    }
    property informant : TFHIRResourceReference{TPerson} read FInformant write SetInformant;

    {@member content
      the actual content of the section
    }
    property content : TFHIRResourceReference{Resource} read FContent write SetContent;

    {@member Section
      nested Section
    }
    property Section : TDocumentSectionList read FSection;

  end;


  {@Class TDocumentSectionAuthor
    if section author different to document
  }
  TDocumentSectionAuthor = class (TFHIRElement)
  private
    FTime : String;
    FParty : TFHIRResourceReference{Resource};
    Procedure SetTime(value : String);
    Procedure SetParty(value : TFHIRResourceReference{Resource});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentSectionAuthor; overload;
    function Clone : TDocumentSectionAuthor; overload;
    {@member time
      When authoring happened
    }
    property time : String read FTime write SetTime;

    {@member party
      person|device that authored the section
    }
    property party : TFHIRResourceReference{Resource} read FParty write SetParty;

  end;


  {@Class TDocumentAuthorList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.DocumentAuthorList}
  TDocumentAuthorList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TDocumentAuthor;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TDocumentAuthor) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TDocumentAuthor;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TDocumentAuthor read GetItemN; default;
  End;


  {@Class TDocumentAttestorList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.DocumentAttestorList}
  TDocumentAttestorList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TDocumentAttestor;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TDocumentAttestor) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TDocumentAttestor;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TDocumentAttestor read GetItemN; default;
  End;


  {@Class TDocument
    A document that contains FHIR resources
  }
  TDocument = class (TFHIRResource)
  private
    FInstant : TDateTime;
    FType_ : TCodeableConcept;
    FTitle : String;
    FSetId : String;
    FVersion : Integer;
    FReplaces : String;
    FSubject : TFHIRResourceReference{Resource};
    FAuthor : TDocumentAuthorList;
    FAttestor : TDocumentAttestorList;
    FRecipient : TFHIRResourceReferenceList{Resource};
    FCustodian : TFHIRResourceReference{TOrganization};
    FEvent : TFHIRResourceReference{Resource};
    FEncounter : TFHIRResourceReference{Resource};
    FSection : TDocumentSectionList;
    Procedure SetInstant(value : TDateTime);
    Procedure SetType_(value : TCodeableConcept);
    Procedure SetTitle(value : String);
    Procedure SetSetId(value : String);
    Procedure SetVersion(value : Integer);
    Procedure SetReplaces(value : String);
    Procedure SetSubject(value : TFHIRResourceReference{Resource});
    Procedure SetCustodian(value : TFHIRResourceReference{TOrganization});
    Procedure SetEvent(value : TFHIRResourceReference{Resource});
    Procedure SetEncounter(value : TFHIRResourceReference{Resource});
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocument; overload;
    function Clone : TDocument; overload;
    {@member instant
      the document creation time, when the document first came into being. Where the CDA document is a transform from an original document in some other format, the ClinicalDocument.effectiveTime is the time the original document is created.
    }
    property instant : TDateTime read FInstant write SetInstant;

    {@member type_
      specifying the particular kind of document (e.g. History and Physical, Discharge Summary, Progress Note)
    }
    property type_ : TCodeableConcept read FType_ write SetType_;

    {@member title
      the title of the document
    }
    property title : String read FTitle write SetTitle;

    {@member setId
      Represents an identifier that is common across all document revisions
    }
    property setId : String read FSetId write SetSetId;

    {@member version
      used to version successive replacement documents
    }
    property version : Integer read FVersion write SetVersion;

    {@member replaces
      If this document replaces another
    }
    property replaces : String read FReplaces write SetReplaces;

    {@member subject
      the patient or group the document is about
    }
    property subject : TFHIRResourceReference{Resource} read FSubject write SetSubject;

    {@member Author
      Author (contributed content to document)
    }
    property Author : TDocumentAuthorList read FAuthor;

    {@member Attestor
      a participant who has attested to the accuracy of the document
    }
    property Attestor : TDocumentAttestorList read FAttestor;

    {@member Recipient
      should receive a copy of the document
    }
    property Recipient : TFHIRResourceReferenceList{Resource} read FRecipient;

    {@member custodian
      organization which maintains the document.
    }
    property custodian : TFHIRResourceReference{TOrganization} read FCustodian write SetCustodian;

    {@member event
      the main Act, such as a colonoscopy or an appendectomy, being documented
    }
    property event : TFHIRResourceReference{Resource} read FEvent write SetEvent;

    {@member encounter
      context of the document
    }
    property encounter : TFHIRResourceReference{Resource} read FEncounter write SetEncounter;

    {@member Section
      Document is broken into sections
    }
    property Section : TDocumentSectionList read FSection;

  end;


  {@Class TMessageResponse
    Information about the the message that this message is a response to - if it is a response
  }
  TMessageResponse = class (TFHIRElement)
  private
    FId : String;
    FCode : TResponseCode;
    FDuplicate : Boolean;
    Procedure SetId(value : String);
    Procedure SetCode(value : TResponseCode);
    Procedure SetDuplicate(value : Boolean);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessageResponse; overload;
    function Clone : TMessageResponse; overload;
    {@member id
      The id of the message that this a response to
    }
    property id : String read FId write SetId;

    {@member code
      Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not
    }
    property code : TResponseCode read FCode write SetCode;

    {@member duplicate
      True if this is not the first response, because the request message has been received more than once
    }
    property duplicate : Boolean read FDuplicate write SetDuplicate;

  end;


  {@Class TMessage
    A message that contains FHIR resources
  }
  TMessage = class (TFHIRResource)
  private
    FThreadId : String;
    FInstant : TDateTime;
    FEvent : String;
    FResponse : TMessageResponse;
    FSource : TFHIRResourceReference{TDevice};
    FDestination : TFHIRResourceReference{TDevice};
    FEnterer : TFHIRResourceReference{Resource};
    FAuthor : TFHIRResourceReference{Resource};
    FResponsible : TFHIRResourceReference{Resource};
    FEffective : TInterval_dateTime;
    FReason : TCodeableConcept;
    FData : TFHIRResourceReference{Resource};
    Procedure SetThreadId(value : String);
    Procedure SetInstant(value : TDateTime);
    Procedure SetEvent(value : String);
    Procedure SetResponse(value : TMessageResponse);
    Procedure SetSource(value : TFHIRResourceReference{TDevice});
    Procedure SetDestination(value : TFHIRResourceReference{TDevice});
    Procedure SetEnterer(value : TFHIRResourceReference{Resource});
    Procedure SetAuthor(value : TFHIRResourceReference{Resource});
    Procedure SetResponsible(value : TFHIRResourceReference{Resource});
    Procedure SetEffective(value : TInterval_dateTime);
    Procedure SetReason(value : TCodeableConcept);
    Procedure SetData(value : TFHIRResourceReference{Resource});
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessage; overload;
    function Clone : TMessage; overload;
    {@member threadId
      Id of the thread - a series of messages that pertain to the same logical sequence, and are all identified by the same thread identifier
    }
    property threadId : String read FThreadId write SetThreadId;

    {@member instant
      Instant the message was sent
    }
    property instant : TDateTime read FInstant write SetInstant;

    {@member event
      Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification
    }
    property event : String read FEvent write SetEvent;

    {@member response
      Information about the the message that this message is a response to - if it is a response
    }
    property response : TMessageResponse read FResponse write SetResponse;

    {@member source
      The source application from which this message originated
    }
    property source : TFHIRResourceReference{TDevice} read FSource write SetSource;

    {@member destination
      The destination application which the message is intended for
    }
    property destination : TFHIRResourceReference{TDevice} read FDestination write SetDestination;

    {@member enterer
      The person or device that performd the data entry leading to this message. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
    }
    property enterer : TFHIRResourceReference{Resource} read FEnterer write SetEnterer;

    {@member author
      The logical author of the message - the person or device that decided it should happen. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions
    }
    property author : TFHIRResourceReference{Resource} read FAuthor write SetAuthor;

    {@member responsible
      The person or organization that accepts overall responsbility for the contents of the message. The implication is that the message event happened under the policies of the responsible party
    }
    property responsible : TFHIRResourceReference{Resource} read FResponsible write SetResponsible;

    {@member effective
      The effective time - the real world time of the even that the message represents. Usually this is just a starting time, but some message events also have an end time (do x for period y)
    }
    property effective : TInterval_dateTime read FEffective write SetEffective;

    {@member reason
      The cause of the event - a reason for why this message is being sent
    }
    property reason : TCodeableConcept read FReason write SetReason;

    {@member data
      The actual data of the message - a reference to the focus class of the message. 
    }
    property data : TFHIRResourceReference{Resource} read FData write SetData;

  end;


  {@Class TMessageConformancePublisher
    The organization that publishes this conformance statement
  }
  TMessageConformancePublisher = class (TFHIRElement)
  private
    FName : String;
    FAddress : TAddressList;
    FContact : TContactList;
    Procedure SetName(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessageConformancePublisher; overload;
    function Clone : TMessageConformancePublisher; overload;
    {@member name
      Name of Organization
    }
    property name : String read FName write SetName;

    {@member Address
      Address of Organization
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      Contacts for Organization
    }
    property Contact : TContactList read FContact;

  end;


  {@Class TMessageConformanceSoftware
    The software that is covered by this conformance statement
  }
  TMessageConformanceSoftware = class (TFHIRElement)
  private
    FName : String;
    FVersion : String;
    FReleaseDate : String;
    Procedure SetName(value : String);
    Procedure SetVersion(value : String);
    Procedure SetReleaseDate(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessageConformanceSoftware; overload;
    function Clone : TMessageConformanceSoftware; overload;
    {@member name
      Name software is known by
    }
    property name : String read FName write SetName;

    {@member version
      Version covered by this statement
    }
    property version : String read FVersion write SetVersion;

    {@member releaseDate
      Date this version released
    }
    property releaseDate : String read FReleaseDate write SetReleaseDate;

  end;


  {@Class TMessageConformanceEvent
    An event supported by the application
  }
  TMessageConformanceEvent = class (TFHIRElement)
  private
    FCode : String;
    FResource : String;
    FMode : TMessageConformanceEventMode;
    FRequest : TMessageConformanceEventRequest;
    FResponse : TMessageConformanceEventResponse;
    Procedure SetCode(value : String);
    Procedure SetResource(value : String);
    Procedure SetMode(value : TMessageConformanceEventMode);
    Procedure SetRequest(value : TMessageConformanceEventRequest);
    Procedure SetResponse(value : TMessageConformanceEventResponse);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessageConformanceEvent; overload;
    function Clone : TMessageConformanceEvent; overload;
    {@member code
      The code for the event
    }
    property code : String read FCode write SetCode;

    {@member resource
      The focal resource for the event
    }
    property resource : String read FResource write SetResource;

    {@member mode
      The mode of this event declaration - whether application is sender or receiver
    }
    property mode : TMessageConformanceEventMode read FMode write SetMode;

    {@member request
      Information about the request for this event
    }
    property request : TMessageConformanceEventRequest read FRequest write SetRequest;

    {@member response
      Information about the response for this event
    }
    property response : TMessageConformanceEventResponse read FResponse write SetResponse;

  end;


  {@Class TConstraintList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ConstraintList}
  TConstraintList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TConstraint;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TConstraint) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TConstraint;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TConstraint read GetItemN; default;
  End;


  {@Class TMessageConformanceEventRequest
    Information about the request for this event
  }
  TMessageConformanceEventRequest = class (TFHIRElement)
  private
    FResource : TConstraintList;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessageConformanceEventRequest; overload;
    function Clone : TMessageConformanceEventRequest; overload;
    {@member Resource
      Constraint on a resource used in the event request
    }
    property Resource : TConstraintList read FResource;

  end;


  {@Class TMessageConformanceEventResponse
    Information about the response for this event
  }
  TMessageConformanceEventResponse = class (TFHIRElement)
  private
    FResource : TConstraintList;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessageConformanceEventResponse; overload;
    function Clone : TMessageConformanceEventResponse; overload;
    {@member Resource
      Constraint on a resource used in the event response
    }
    property Resource : TConstraintList read FResource;

  end;


  {@Class TMessageConformanceEventList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.MessageConformanceEventList}
  TMessageConformanceEventList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TMessageConformanceEvent;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TMessageConformanceEvent) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TMessageConformanceEvent;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TMessageConformanceEvent read GetItemN; default;
  End;


  {@Class TMessageConformance
    A conformance statement about how an application uses FHIR messaging
  }
  TMessageConformance = class (TFHIRResource)
  private
    FDate : String;
    FPublisher : TMessageConformancePublisher;
    FSoftware : TMessageConformanceSoftware;
    FEvent : TMessageConformanceEventList;
    Procedure SetDate(value : String);
    Procedure SetPublisher(value : TMessageConformancePublisher);
    Procedure SetSoftware(value : TMessageConformanceSoftware);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TMessageConformance; overload;
    function Clone : TMessageConformance; overload;
    {@member date
      Date that the conformance statement is published
    }
    property date : String read FDate write SetDate;

    {@member publisher
      The organization that publishes this conformance statement
    }
    property publisher : TMessageConformancePublisher read FPublisher write SetPublisher;

    {@member software
      The software that is covered by this conformance statement
    }
    property software : TMessageConformanceSoftware read FSoftware write SetSoftware;

    {@member Event
      An event supported by the application
    }
    property Event : TMessageConformanceEventList read FEvent;

  end;


  {@Class TCodeableConceptList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.CodeableConceptList}
  TCodeableConceptList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TCodeableConcept;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TCodeableConcept) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TCodeableConcept;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TCodeableConcept read GetItemN; default;
  End;


  {@Class THumanIdList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.HumanIdList}
  THumanIdList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : THumanId;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : THumanId) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : THumanId;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : THumanId read GetItemN; default;
  End;


  {@Class TAgent
    A person who represents an organisation, and is authorised to perform actions on it's behalf
  }
  TAgent = class (TFHIRResource)
  private
    FPerson : TFHIRResourceReference{TPerson};
    FOrganization : TFHIRResourceReference{TOrganization};
    FRole : TCodeableConceptList;
    FPeriod : TInterval_dateTime;
    FIdentifier : THumanIdList;
    FAddress : TAddressList;
    FContact : TContactList;
    Procedure SetPerson(value : TFHIRResourceReference{TPerson});
    Procedure SetOrganization(value : TFHIRResourceReference{TOrganization});
    Procedure SetPeriod(value : TInterval_dateTime);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TAgent; overload;
    function Clone : TAgent; overload;
    {@member person
      The person who acts as the agent
    }
    property person : TFHIRResourceReference{TPerson} read FPerson write SetPerson;

    {@member organization
      The organisation that is being represented
    }
    property organization : TFHIRResourceReference{TOrganization} read FOrganization write SetOrganization;

    {@member Role
      The way in which the person represents the organisation - what role do they have?
    }
    property Role : TCodeableConceptList read FRole;

    {@member period
      The time period during which the agent was/is authorised to represent the organisation.
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

    {@member Identifier
      An identifier that applies to this person in this role
    }
    property Identifier : THumanIdList read FIdentifier;

    {@member Address
      A postal address for this person playing this role
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      A contact detail address for this person playing this role
    }
    property Contact : TContactList read FContact;

  end;


  {@Class TAnimalRelatedEntity
    Kin, owner, care giver etc
  }
  TAnimalRelatedEntity = class (TFHIRElement)
  private
    FId : THumanId;
    FRole : TCodeableConcept;
    FName : THumanName;
    FAddress : TAddressList;
    FContact : TContactList;
    Procedure SetId(value : THumanId);
    Procedure SetRole(value : TCodeableConcept);
    Procedure SetName(value : THumanName);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TAnimalRelatedEntity; overload;
    function Clone : TAnimalRelatedEntity; overload;
    {@member id
      Identifier for the entity
    }
    property id : THumanId read FId write SetId;

    {@member role
      Type of relationship
    }
    property role : TCodeableConcept read FRole write SetRole;

    {@member name
      Name of the related entity
    }
    property name : THumanName read FName write SetName;

    {@member Address
      An address (usually human, but may be kin)
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      Contact details (usually for humans)
    }
    property Contact : TContactList read FContact;

  end;


  {@Class THumanNameList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.HumanNameList}
  THumanNameList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : THumanName;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : THumanName) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : THumanName;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : THumanName read GetItemN; default;
  End;


  {@Class TAnimalRelatedEntityList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.AnimalRelatedEntityList}
  TAnimalRelatedEntityList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TAnimalRelatedEntity;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TAnimalRelatedEntity) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TAnimalRelatedEntity;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TAnimalRelatedEntity read GetItemN; default;
  End;


  {@Class TAnimal
    An animal that has relevance to the care process -usually this is for animals that are patients.
  }
  TAnimal = class (TFHIRResource)
  private
    FIdentifier : THumanIdList;
    FName : THumanNameList;
    FDob : String;
    FSpecies : TCodeableConcept;
    FStrain : TCodeableConcept;
    FGender : TCodeableConcept;
    FRelatedEntity : TAnimalRelatedEntityList;
    Procedure SetDob(value : String);
    Procedure SetSpecies(value : TCodeableConcept);
    Procedure SetStrain(value : TCodeableConcept);
    Procedure SetGender(value : TCodeableConcept);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TAnimal; overload;
    function Clone : TAnimal; overload;
    {@member Identifier
      Identifier for the animal that is used to identify the person across multiple disparate systems and also for face to face identification of the person
    }
    property Identifier : THumanIdList read FIdentifier;

    {@member Name
      A name associated with the animal. The use code maiden does not apply.
    }
    property Name : THumanNameList read FName;

    {@member dob
      The birth date for the animal
    }
    property dob : String read FDob write SetDob;

    {@member species
      Species for the animal
    }
    property species : TCodeableConcept read FSpecies write SetSpecies;

    {@member strain
      Strain for the animal
    }
    property strain : TCodeableConcept read FStrain write SetStrain;

    {@member gender
      Gender for the Animal
    }
    property gender : TCodeableConcept read FGender write SetGender;

    {@member RelatedEntity
      Kin, owner, care giver etc
    }
    property RelatedEntity : TAnimalRelatedEntityList read FRelatedEntity;

  end;


  {@Class TPrescriptionDispense
    Details of the dispense as requested by the prescriber
  }
  TPrescriptionDispense = class (TFHIRElement)
  private
    FRepeats : Integer;
    FQuantity : TQuantity;
    FDispenser : TFHIRResourceReference{Resource};
    Procedure SetRepeats(value : Integer);
    Procedure SetQuantity(value : TQuantity);
    Procedure SetDispenser(value : TFHIRResourceReference{Resource});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPrescriptionDispense; overload;
    function Clone : TPrescriptionDispense; overload;
    {@member repeats
      Requested number of repeats
    }
    property repeats : Integer read FRepeats write SetRepeats;

    {@member quantity
      Requested quantity per repeat
    }
    property quantity : TQuantity read FQuantity write SetQuantity;

    {@member dispenser
      Person to fullfil the requested dispense
    }
    property dispenser : TFHIRResourceReference{Resource} read FDispenser write SetDispenser;

  end;


  {@Class TPrescriptionMedicineActiveIngredientList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.PrescriptionMedicineActiveIngredientList}
  TPrescriptionMedicineActiveIngredientList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TPrescriptionMedicineActiveIngredient;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TPrescriptionMedicineActiveIngredient) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TPrescriptionMedicineActiveIngredient;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TPrescriptionMedicineActiveIngredient read GetItemN; default;
  End;


  {@Class TPrescriptionMedicineInactiveIngredientList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.PrescriptionMedicineInactiveIngredientList}
  TPrescriptionMedicineInactiveIngredientList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TPrescriptionMedicineInactiveIngredient;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TPrescriptionMedicineInactiveIngredient) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TPrescriptionMedicineInactiveIngredient;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TPrescriptionMedicineInactiveIngredient read GetItemN; default;
  End;


  {@Class TPrescriptionMedicine
    The one single medicatine, vaccine or therapeutic good prescribed in this prescription.
  }
  TPrescriptionMedicine = class (TFHIRElement)
  private
    FProductCode : TCoding;
    FDescription : String;
    FActiveIngredient : TPrescriptionMedicineActiveIngredientList;
    FInactiveIngredient : TPrescriptionMedicineInactiveIngredientList;
    Procedure SetProductCode(value : TCoding);
    Procedure SetDescription(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPrescriptionMedicine; overload;
    function Clone : TPrescriptionMedicine; overload;
    {@member productCode
      Coded representation of medicine
    }
    property productCode : TCoding read FProductCode write SetProductCode;

    {@member description
      Textual description of medicine, including strength and ingredients
    }
    property description : String read FDescription write SetDescription;

    {@member ActiveIngredient
      The substance in the medication formulation that is pharmaceutically active and is responsible for the medication's therapeutic effect
    }
    property ActiveIngredient : TPrescriptionMedicineActiveIngredientList read FActiveIngredient;

    {@member InactiveIngredient
      Ingredients in the medication that are not active
    }
    property InactiveIngredient : TPrescriptionMedicineInactiveIngredientList read FInactiveIngredient;

  end;


  {@Class TPrescriptionMedicineActiveIngredient
    The substance in the medication formulation that is pharmaceutically active and is responsible for the medication's therapeutic effect
  }
  TPrescriptionMedicineActiveIngredient = class (TFHIRElement)
  private
    FProductCode : TCoding;
    FQuantity : TRatio;
    Procedure SetProductCode(value : TCoding);
    Procedure SetQuantity(value : TRatio);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPrescriptionMedicineActiveIngredient; overload;
    function Clone : TPrescriptionMedicineActiveIngredient; overload;
    {@member productCode
      Coded representation of active ingredient
    }
    property productCode : TCoding read FProductCode write SetProductCode;

    {@member quantity
      Quantity of active ingredient expressed in relation to the whole of the prepared medicine
    }
    property quantity : TRatio read FQuantity write SetQuantity;

  end;


  {@Class TPrescriptionMedicineInactiveIngredient
    Ingredients in the medication that are not active
  }
  TPrescriptionMedicineInactiveIngredient = class (TFHIRElement)
  private
    FProductCode : TCoding;
    FQuantity : TRatio;
    Procedure SetProductCode(value : TCoding);
    Procedure SetQuantity(value : TRatio);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPrescriptionMedicineInactiveIngredient; overload;
    function Clone : TPrescriptionMedicineInactiveIngredient; overload;
    {@member productCode
      Coded representation of the inactive ingredient
    }
    property productCode : TCoding read FProductCode write SetProductCode;

    {@member quantity
      Quantity of inactive ingredient expressed in relation to the whole of the prepared medicine
    }
    property quantity : TRatio read FQuantity write SetQuantity;

  end;


  {@Class TPrescriptionAdministrationRequestDosageInstructionList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.PrescriptionAdministrationRequestDosageInstructionList}
  TPrescriptionAdministrationRequestDosageInstructionList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TPrescriptionAdministrationRequestDosageInstruction;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TPrescriptionAdministrationRequestDosageInstruction) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TPrescriptionAdministrationRequestDosageInstruction;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TPrescriptionAdministrationRequestDosageInstruction read GetItemN; default;
  End;


  {@Class TPrescriptionAdministrationRequest
    Instructions for the use of the medication. Includes details about the timing schedule, dosis amounts and additional usage instructions.
  }
  TPrescriptionAdministrationRequest = class (TFHIRElement)
  private
    FDescription : String;
    FTotalPeriodicDosis : TRatio;
    FStart : String;
    FEnd_ : String;
    FDuration : TQuantity;
    FNumberOfAdministrations : Integer;
    FDosageInstruction : TPrescriptionAdministrationRequestDosageInstructionList;
    Procedure SetDescription(value : String);
    Procedure SetTotalPeriodicDosis(value : TRatio);
    Procedure SetStart(value : String);
    Procedure SetEnd_(value : String);
    Procedure SetDuration(value : TQuantity);
    Procedure SetNumberOfAdministrations(value : Integer);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPrescriptionAdministrationRequest; overload;
    function Clone : TPrescriptionAdministrationRequest; overload;
    {@member description
      Textual description of the use of the medication.
    }
    property description : String read FDescription write SetDescription;

    {@member totalPeriodicDosis
      Total dose per day/week or other period when more specific information is missing or cannot be expressed using the timing specifications.
    }
    property totalPeriodicDosis : TRatio read FTotalPeriodicDosis write SetTotalPeriodicDosis;

    {@member start
      First moment on which medication should be taken
    }
    property start : String read FStart write SetStart;

    {@member end_
      Last moment on which medication should be taken
    }
    property end_ : String read FEnd_ write SetEnd_;

    {@member duration
      Total duration of administration
    }
    property duration : TQuantity read FDuration write SetDuration;

    {@member numberOfAdministrations
      Maximum number of separate administrations before the instruction ends.
    }
    property numberOfAdministrations : Integer read FNumberOfAdministrations write SetNumberOfAdministrations;

    {@member DosageInstruction
      Specification of dose and schedule for administration
    }
    property DosageInstruction : TPrescriptionAdministrationRequestDosageInstructionList read FDosageInstruction;

  end;


  {@Class TScheduleList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.ScheduleList}
  TScheduleList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TSchedule;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TSchedule) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TSchedule;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TSchedule read GetItemN; default;
  End;


  {@Class TPrescriptionAdministrationRequestDosageInstruction
    Specification of dose and schedule for administration
  }
  TPrescriptionAdministrationRequestDosageInstruction = class (TFHIRElement)
  private
    FPrecondition : TCodeableConceptList;
    FPrn : TBooleanYesNo;
    FAdditionalInstruction : TCodeableConceptList;
    FRoute : TCodeableConcept;
    FDose : TFHIRType;
    FRate : TQuantity;
    FSchedule : TScheduleList;
    Procedure SetPrn(value : TBooleanYesNo);
    Procedure SetRoute(value : TCodeableConcept);
    Procedure SetDose(value : TFHIRType);
    Procedure SetRate(value : TQuantity);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPrescriptionAdministrationRequestDosageInstruction; overload;
    function Clone : TPrescriptionAdministrationRequestDosageInstruction; overload;
    {@member Precondition
      Precondition for starting the administration specified in this instruction
    }
    property Precondition : TCodeableConceptList read FPrecondition;

    {@member prn
      Pro re nate, "If necessary": Specifies whether administration depens on the state and symptoms of the patient
    }
    property prn : TBooleanYesNo read FPrn write SetPrn;

    {@member AdditionalInstruction
      Additional details to guide administration. Especially relevant for medicine administered by patient
    }
    property AdditionalInstruction : TCodeableConceptList read FAdditionalInstruction;

    {@member route
      Route of administration (oral, nasal, intravenous)
    }
    property route : TCodeableConcept read FRoute write SetRoute;

    {@member dose
      Dose per administration, expressed in units of the (prepared) product
    }
    property dose : TFHIRType read FDose write SetDose;

    {@member rate
      Flow-rate for IV
    }
    property rate : TQuantity read FRate write SetRate;

    {@member Schedule
      Schedule for administration. If multiple are given, they are considered to be active in parrallel
    }
    property Schedule : TScheduleList read FSchedule;

  end;


  {@Class TPrescription
    Directions provided by a prescribing practitioner for a specific medication to be administered to an individual
  }
  TPrescription = class (TFHIRResource)
  private
    FIdentifier : THumanIdList;
    FStatus : TPrescriptionStatus;
    FPatient : TFHIRResourceReference{TPatient};
    FPrescriber : TFHIRResourceReference{TAgent};
    FPrescribed : String;
    FDispense : TPrescriptionDispense;
    FMedicine : TPrescriptionMedicine;
    FAdministrationRequest : TPrescriptionAdministrationRequest;
    FReason : TCodeableConcept;
    Procedure SetStatus(value : TPrescriptionStatus);
    Procedure SetPatient(value : TFHIRResourceReference{TPatient});
    Procedure SetPrescriber(value : TFHIRResourceReference{TAgent});
    Procedure SetPrescribed(value : String);
    Procedure SetDispense(value : TPrescriptionDispense);
    Procedure SetMedicine(value : TPrescriptionMedicine);
    Procedure SetAdministrationRequest(value : TPrescriptionAdministrationRequest);
    Procedure SetReason(value : TCodeableConcept);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPrescription; overload;
    function Clone : TPrescription; overload;
    {@member Identifier
      A identifier used in an external system and associated with this medication
    }
    property Identifier : THumanIdList read FIdentifier;

    {@member status
      Actual status of the prescription
    }
    property status : TPrescriptionStatus read FStatus write SetStatus;

    {@member patient
      The patient the prescription is prescribing medicine for
    }
    property patient : TFHIRResourceReference{TPatient} read FPatient write SetPatient;

    {@member prescriber
      The clinician or doctor prescribing the medication
    }
    property prescriber : TFHIRResourceReference{TAgent} read FPrescriber write SetPrescriber;

    {@member prescribed
      Date/time on which the prescription was written
    }
    property prescribed : String read FPrescribed write SetPrescribed;

    {@member dispense
      Details of the dispense as requested by the prescriber
    }
    property dispense : TPrescriptionDispense read FDispense write SetDispense;

    {@member medicine
      The one single medicatine, vaccine or therapeutic good prescribed in this prescription.
    }
    property medicine : TPrescriptionMedicine read FMedicine write SetMedicine;

    {@member administrationRequest
      Instructions for the use of the medication. Includes details about the timing schedule, dosis amounts and additional usage instructions.
    }
    property administrationRequest : TPrescriptionAdministrationRequest read FAdministrationRequest write SetAdministrationRequest;

    {@member reason
      Diagnosis which is the reason for prescribing this medicine
    }
    property reason : TCodeableConcept read FReason write SetReason;

  end;


  {@Class TPatient
    A patient is a person or animal that is receiving care
  }
  TPatient = class (TFHIRResource)
  private
    FLink_ : TFHIRResourceReferenceList{TPatient};
    FActive : Boolean;
    FPerson : TFHIRResourceReference{TPerson};
    FAnimal : TFHIRResourceReference{TAnimal};
    FProvider : TFHIRResourceReference{TOrganization};
    FIdentifier : THumanIdList;
    FDiet : TCodeableConcept;
    FConfidentiality : TCodeableConcept;
    FRecordLocation : TCodeableConcept;
    Procedure SetActive(value : Boolean);
    Procedure SetPerson(value : TFHIRResourceReference{TPerson});
    Procedure SetAnimal(value : TFHIRResourceReference{TAnimal});
    Procedure SetProvider(value : TFHIRResourceReference{TOrganization});
    Procedure SetDiet(value : TCodeableConcept);
    Procedure SetConfidentiality(value : TCodeableConcept);
    Procedure SetRecordLocation(value : TCodeableConcept);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPatient; overload;
    function Clone : TPatient; overload;
    {@member Link_
      A linked patient record is a record that concerns the same patient. Records are linked after it is realised that at least one was created in error.
    }
    property Link_ : TFHIRResourceReferenceList{TPatient} read FLink_;

    {@member active
      Whether the patient record is in use, or has been removed from active use
    }
    property active : Boolean read FActive write SetActive;

    {@member person
      The person that this patient record is about
    }
    property person : TFHIRResourceReference{TPerson} read FPerson write SetPerson;

    {@member animal
      The animal that this patient record is about
    }
    property animal : TFHIRResourceReference{TAnimal} read FAnimal write SetAnimal;

    {@member provider
      The provider for whom this is a patient record
    }
    property provider : TFHIRResourceReference{TOrganization} read FProvider write SetProvider;

    {@member Identifier
      An identifier that applies to this person as a patient
    }
    property Identifier : THumanIdList read FIdentifier;

    {@member diet
      Dietary restrictions for the patient
    }
    property diet : TCodeableConcept read FDiet write SetDiet;

    {@member confidentiality
      Confidentiality of the patient records
    }
    property confidentiality : TCodeableConcept read FConfidentiality write SetConfidentiality;

    {@member recordLocation
      The location of the paper record for the patient, if there is one
    }
    property recordLocation : TCodeableConcept read FRecordLocation write SetRecordLocation;

  end;


  {@Class TOrganizationName
    A name associated with the organization
  }
  TOrganizationName = class (TFHIRElement)
  private
    FValue : String;
    FPeriod : TInterval_dateTime;
    Procedure SetValue(value : String);
    Procedure SetPeriod(value : TInterval_dateTime);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TOrganizationName; overload;
    function Clone : TOrganizationName; overload;
    {@member value
      The actual name of the organization
    }
    property value : String read FValue write SetValue;

    {@member period
      The period that this name was in use by the organization
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

  end;


  {@Class TOrganizationAccreditation
    The qualifications a person has, including format educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment
  }
  TOrganizationAccreditation = class (TFHIRElement)
  private
    FId : TIdentifier;
    FCode : TCodeableConcept;
    FInstitution : TFHIRResourceReference{TOrganization};
    FPeriod : TInterval_dateTime;
    Procedure SetId(value : TIdentifier);
    Procedure SetCode(value : TCodeableConcept);
    Procedure SetInstitution(value : TFHIRResourceReference{TOrganization});
    Procedure SetPeriod(value : TInterval_dateTime);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TOrganizationAccreditation; overload;
    function Clone : TOrganizationAccreditation; overload;
    {@member id
      The identifier of the accreditation
    }
    property id : TIdentifier read FId write SetId;

    {@member code
      The type of the accreditation
    }
    property code : TCodeableConcept read FCode write SetCode;

    {@member institution
      The organization that confered/confers the accreditation
    }
    property institution : TFHIRResourceReference{TOrganization} read FInstitution write SetInstitution;

    {@member period
      The period for which the accreditation is held
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

  end;


  {@Class TOrganizationRelatedOrganization
    Other organizations who are related to this person. The relationship might be one of several types: sub- or super- orgnizations (i.e. ward in a hospital, owning corporation of a hospital) or partner organizations (i.e. the operating corporation for a hospital)
  }
  TOrganizationRelatedOrganization = class (TFHIRElement)
  private
    FId : THumanId;
    FCode : TCodeableConcept;
    FName : String;
    FAddress : TAddressList;
    FContact : TContactList;
    FPeriod : TInterval_dateTime;
    Procedure SetId(value : THumanId);
    Procedure SetCode(value : TCodeableConcept);
    Procedure SetName(value : String);
    Procedure SetPeriod(value : TInterval_dateTime);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TOrganizationRelatedOrganization; overload;
    function Clone : TOrganizationRelatedOrganization; overload;
    {@member id
      Identifier the related organization - may be a full link to an Organization resource, or some other kind of identifier
    }
    property id : THumanId read FId write SetId;

    {@member code
      Code that specifies how this organization is related to the subject. A code is required.
    }
    property code : TCodeableConcept read FCode write SetCode;

    {@member name
      A name should be specified for the related organization
    }
    property name : String read FName write SetName;

    {@member Address
      Postal addresses may be provided for the related organization
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      Contact details (phone, email etc) may be provided for the related organization
    }
    property Contact : TContactList read FContact;

    {@member period
      The period during which the organizations were related in this fashion
    }
    property period : TInterval_dateTime read FPeriod write SetPeriod;

  end;


  {@Class TOrganizationNameList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.OrganizationNameList}
  TOrganizationNameList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TOrganizationName;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TOrganizationName) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TOrganizationName;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TOrganizationName read GetItemN; default;
  End;


  {@Class TOrganizationAccreditationList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.OrganizationAccreditationList}
  TOrganizationAccreditationList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TOrganizationAccreditation;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TOrganizationAccreditation) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TOrganizationAccreditation;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TOrganizationAccreditation read GetItemN; default;
  End;


  {@Class TOrganizationRelatedOrganizationList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.OrganizationRelatedOrganizationList}
  TOrganizationRelatedOrganizationList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TOrganizationRelatedOrganization;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TOrganizationRelatedOrganization) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TOrganizationRelatedOrganization;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TOrganizationRelatedOrganization read GetItemN; default;
  End;


  {@Class TOrganization
    For any organization/institution/government department that has relevance to the care process
  }
  TOrganization = class (TFHIRResource)
  private
    FCode : TCodeableConcept;
    FIndustryCode : TCodeableConcept;
    FIdentifier : THumanIdList;
    FName : TOrganizationNameList;
    FAddress : TAddressList;
    FContact : TContactList;
    FAccreditation : TOrganizationAccreditationList;
    FRelatedOrganization : TOrganizationRelatedOrganizationList;
    Procedure SetCode(value : TCodeableConcept);
    Procedure SetIndustryCode(value : TCodeableConcept);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TOrganization; overload;
    function Clone : TOrganization; overload;
    {@member code
      The kind of organization that this is
    }
    property code : TCodeableConcept read FCode write SetCode;

    {@member industryCode
      The industry that this organization is involved in
    }
    property industryCode : TCodeableConcept read FIndustryCode write SetIndustryCode;

    {@member Identifier
      Identifier for the organization that is used to identify the organization across multiple disparate systems
    }
    property Identifier : THumanIdList read FIdentifier;

    {@member Name
      A name associated with the organization
    }
    property Name : TOrganizationNameList read FName;

    {@member Address
      An address for the organization
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      A contact detail for the organization
    }
    property Contact : TContactList read FContact;

    {@member Accreditation
      The qualifications a person has, including format educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment
    }
    property Accreditation : TOrganizationAccreditationList read FAccreditation;

    {@member RelatedOrganization
      Other organizations who are related to this person. The relationship might be one of several types: sub- or super- orgnizations (i.e. ward in a hospital, owning corporation of a hospital) or partner organizations (i.e. the operating corporation for a hospital)
    }
    property RelatedOrganization : TOrganizationRelatedOrganizationList read FRelatedOrganization;

  end;


  {@Class TDocumentConformancePublisher
    The organization that publishes this conformance statement
  }
  TDocumentConformancePublisher = class (TFHIRElement)
  private
    FName : String;
    FAddress : TAddressList;
    FContact : TContactList;
    Procedure SetName(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentConformancePublisher; overload;
    function Clone : TDocumentConformancePublisher; overload;
    {@member name
      Name of Organization
    }
    property name : String read FName write SetName;

    {@member Address
      Address of Organization
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      Contacts for Organization
    }
    property Contact : TContactList read FContact;

  end;


  {@Class TDocumentConformanceSoftware
    The software that is covered by this conformance statement
  }
  TDocumentConformanceSoftware = class (TFHIRElement)
  private
    FName : String;
    FVersion : String;
    FReleaseDate : String;
    Procedure SetName(value : String);
    Procedure SetVersion(value : String);
    Procedure SetReleaseDate(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentConformanceSoftware; overload;
    function Clone : TDocumentConformanceSoftware; overload;
    {@member name
      Name software is known by
    }
    property name : String read FName write SetName;

    {@member version
      Version covered by this statement
    }
    property version : String read FVersion write SetVersion;

    {@member releaseDate
      Date this version released
    }
    property releaseDate : String read FReleaseDate write SetReleaseDate;

  end;


  {@Class TDocumentConformanceDocument
    A document definition
  }
  TDocumentConformanceDocument = class (TFHIRElement)
  private
    FName : String;
    FPurpose : String;
    FResource : TConstraintList;
    Procedure SetName(value : String);
    Procedure SetPurpose(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentConformanceDocument; overload;
    function Clone : TDocumentConformanceDocument; overload;
    {@member name
      Name for this particular document profile
    }
    property name : String read FName write SetName;

    {@member purpose
      Human description of this particular profile
    }
    property purpose : String read FPurpose write SetPurpose;

    {@member Resource
      Constraint on a resource used in the document
    }
    property Resource : TConstraintList read FResource;

  end;


  {@Class TDocumentConformanceDocumentList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.DocumentConformanceDocumentList}
  TDocumentConformanceDocumentList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TDocumentConformanceDocument;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TDocumentConformanceDocument) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TDocumentConformanceDocument;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TDocumentConformanceDocument read GetItemN; default;
  End;


  {@Class TDocumentConformance
    A conformance statement about how one or more FHIR documents
  }
  TDocumentConformance = class (TFHIRResource)
  private
    FDate : String;
    FPublisher : TDocumentConformancePublisher;
    FSoftware : TDocumentConformanceSoftware;
    FDocument : TDocumentConformanceDocumentList;
    Procedure SetDate(value : String);
    Procedure SetPublisher(value : TDocumentConformancePublisher);
    Procedure SetSoftware(value : TDocumentConformanceSoftware);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TDocumentConformance; overload;
    function Clone : TDocumentConformance; overload;
    {@member date
      Date that this conformance statement is published
    }
    property date : String read FDate write SetDate;

    {@member publisher
      The organization that publishes this conformance statement
    }
    property publisher : TDocumentConformancePublisher read FPublisher write SetPublisher;

    {@member software
      The software that is covered by this conformance statement
    }
    property software : TDocumentConformanceSoftware read FSoftware write SetSoftware;

    {@member Document
      A document definition
    }
    property Document : TDocumentConformanceDocumentList read FDocument;

  end;


  {@Class TLabReportRequestDetail
    Details concerning a single pathology test requested.
  }
  TLabReportRequestDetail = class (TFHIRElement)
  private
    FRequestOrderId : TIdentifier;
    FReceiverOrderId : TIdentifier;
    FRequestTest : TCodeableConceptList;
    FRequester : TFHIRResourceReference{Resource};
    FClinicalInfo : TFHIRResourceReference{Resource};
    Procedure SetRequestOrderId(value : TIdentifier);
    Procedure SetReceiverOrderId(value : TIdentifier);
    Procedure SetRequester(value : TFHIRResourceReference{Resource});
    Procedure SetClinicalInfo(value : TFHIRResourceReference{Resource});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TLabReportRequestDetail; overload;
    function Clone : TLabReportRequestDetail; overload;
    {@member requestOrderId
      The local ID assigned to the order by the order requester.
    }
    property requestOrderId : TIdentifier read FRequestOrderId write SetRequestOrderId;

    {@member receiverOrderId
      The local ID assigned to the test order by the order filler, usually by the Laboratory Information System (LIS).
    }
    property receiverOrderId : TIdentifier read FReceiverOrderId write SetReceiverOrderId;

    {@member RequestTest
      Identification of pathology test requested,
    }
    property RequestTest : TCodeableConceptList read FRequestTest;

    {@member requester
      Details of the clinician or organisation requesting the laboratory test.
    }
    property requester : TFHIRResourceReference{Resource} read FRequester write SetRequester;

    {@member clinicalInfo
      Details of the clinical information provided to the laboratory along with the original request
    }
    property clinicalInfo : TFHIRResourceReference{Resource} read FClinicalInfo write SetClinicalInfo;

  end;


  {@Class TLabReportResultGroupResultList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.LabReportResultGroupResultList}
  TLabReportResultGroupResultList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TLabReportResultGroupResult;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TLabReportResultGroupResult) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TLabReportResultGroupResult;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TLabReportResultGroupResult read GetItemN; default;
  End;


  {@Class TLabReportResultGroup
    A group of results. Results may be grouped by specimen, or by some value in LabReport.resultGroup.name to describe what binds all the results together.
  }
  TLabReportResultGroup = class (TFHIRElement)
  private
    FName : TCodeableConcept;
    FSpecimen : TFHIRResourceReference{TSpecimen};
    FResult : TLabReportResultGroupResultList;
    Procedure SetName(value : TCodeableConcept);
    Procedure SetSpecimen(value : TFHIRResourceReference{TSpecimen});
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TLabReportResultGroup; overload;
    function Clone : TLabReportResultGroup; overload;
    {@member name
      A code or name that describes the group of results
    }
    property name : TCodeableConcept read FName write SetName;

    {@member specimen
      Details about the individual specimen to which these ?Result group? test results refer, where testing of multiple specimens is required.
    }
    property specimen : TFHIRResourceReference{TSpecimen} read FSpecimen write SetSpecimen;

    {@member Result
      Specific detailed result, including both the value of the result item, and additional information that may be useful for clinical interpretation. Results include whatever specific data items pathology labs report as part of the clinical service; it is not confined to measurements.
    }
    property Result : TLabReportResultGroupResultList read FResult;

  end;


  {@Class TLabReportResultGroupResultReferenceRangeList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.LabReportResultGroupResultReferenceRangeList}
  TLabReportResultGroupResultReferenceRangeList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TLabReportResultGroupResultReferenceRange;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TLabReportResultGroupResultReferenceRange) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TLabReportResultGroupResultReferenceRange;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TLabReportResultGroupResultReferenceRange read GetItemN; default;
  End;


  {@Class TLabReportResultGroupResult
    Specific detailed result, including both the value of the result item, and additional information that may be useful for clinical interpretation. Results include whatever specific data items pathology labs report as part of the clinical service; it is not confined to measurements.
  }
  TLabReportResultGroupResult = class (TFHIRElement)
  private
    FName : TCodeableConcept;
    FValue : TFHIRType;
    FFlag : TLabResultFlag;
    FStatus : TLabReportStatus;
    FComments : String;
    FReferenceRange : TLabReportResultGroupResultReferenceRangeList;
    Procedure SetName(value : TCodeableConcept);
    Procedure SetValue(value : TFHIRType);
    Procedure SetFlag(value : TLabResultFlag);
    Procedure SetStatus(value : TLabReportStatus);
    Procedure SetComments(value : String);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TLabReportResultGroupResult; overload;
    function Clone : TLabReportResultGroupResult; overload;
    {@member name
      Identifies the meaning of the value
    }
    property name : TCodeableConcept read FName write SetName;

    {@member value
      Actual value of the result. Most result values will be numerical measurements, but others may be coded concepts, free text, or multimedia images
    }
    property value : TFHIRType read FValue write SetValue;

    {@member flag
      Flag indicating the abnormal status of the result
    }
    property flag : TLabResultFlag read FFlag write SetFlag;

    {@member status
      The status of the result value
    }
    property status : TLabReportStatus read FStatus write SetStatus;

    {@member comments
      May include statements about significant, unexpected or unreliable. values, or information about the source of the value where this may be relevant to the interpretation of the result.
    }
    property comments : String read FComments write SetComments;

    {@member ReferenceRange
      Guidance on how to interpret the value by comparison to a normal or recommended range
    }
    property ReferenceRange : TLabReportResultGroupResultReferenceRangeList read FReferenceRange;

  end;


  {@Class TLabReportResultGroupResultReferenceRange
    Guidance on how to interpret the value by comparison to a normal or recommended range
  }
  TLabReportResultGroupResultReferenceRange = class (TFHIRElement)
  private
    FMeaning : TCodeableConcept;
    FRange : TFHIRType;
    Procedure SetMeaning(value : TCodeableConcept);
    Procedure SetRange(value : TFHIRType);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TLabReportResultGroupResultReferenceRange; overload;
    function Clone : TLabReportResultGroupResultReferenceRange; overload;
    {@member meaning
      Code for the meaning of the reference range
    }
    property meaning : TCodeableConcept read FMeaning write SetMeaning;

    {@member range
      Actual value of the reference range.  May be a quantity (<20mg/L), an interval (10-20 umol/L), or some text
    }
    property range : TFHIRType read FRange write SetRange;

  end;


  {@Class TLabReportRequestDetailList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.LabReportRequestDetailList}
  TLabReportRequestDetailList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TLabReportRequestDetail;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TLabReportRequestDetail) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TLabReportRequestDetail;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TLabReportRequestDetail read GetItemN; default;
  End;


  {@Class TLabReportResultGroupList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.LabReportResultGroupList}
  TLabReportResultGroupList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TLabReportResultGroup;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TLabReportResultGroup) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TLabReportResultGroup;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TLabReportResultGroup read GetItemN; default;
  End;


  {@Class TAttachmentList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.AttachmentList}
  TAttachmentList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TAttachment;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TAttachment) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TAttachment;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TAttachment read GetItemN; default;
  End;


  {@Class TLabReport
    The findings and interpretation of pathology tests performed on tissues and body fluids. This is typically done in a laboratory but may be done in other environments such as at the point of care
  }
  TLabReport = class (TFHIRResource)
  private
    FStatus : TLabReportStatus;
    FIssued : TDateTime;
    FPatient : TFHIRResourceReference{TPatient};
    FAdmission : TFHIRResourceReference{TAdmission};
    FLaboratory : TFHIRResourceReference{TOrganization};
    FReportId : String;
    FRequestDetail : TLabReportRequestDetailList;
    FReportName : TCodeableConcept;
    FService : TCodeableConcept;
    FDiagnosticTime : String;
    FSpecimen : TFHIRResourceReferenceList{TSpecimen};
    FResultGroup : TLabReportResultGroupList;
    FConclusion : TNarrative;
    FCodedDiagnosis : TCodeableConceptList;
    FRepresentation : TAttachmentList;
    Procedure SetStatus(value : TLabReportStatus);
    Procedure SetIssued(value : TDateTime);
    Procedure SetPatient(value : TFHIRResourceReference{TPatient});
    Procedure SetAdmission(value : TFHIRResourceReference{TAdmission});
    Procedure SetLaboratory(value : TFHIRResourceReference{TOrganization});
    Procedure SetReportId(value : String);
    Procedure SetReportName(value : TCodeableConcept);
    Procedure SetService(value : TCodeableConcept);
    Procedure SetDiagnosticTime(value : String);
    Procedure SetConclusion(value : TNarrative);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TLabReport; overload;
    function Clone : TLabReport; overload;
    {@member status
      The status of the pathology test result as a whole
    }
    property status : TLabReportStatus read FStatus write SetStatus;

    {@member issued
      The date and/or time that the result was issued from the source for the recorded ?Test result status
    }
    property issued : TDateTime read FIssued write SetIssued;

    {@member patient
      The patient about who the report is about
    }
    property patient : TFHIRResourceReference{TPatient} read FPatient write SetPatient;

    {@member admission
      The admission that this diagnostic investigation is associated with
    }
    property admission : TFHIRResourceReference{TAdmission} read FAdmission write SetAdmission;

    {@member laboratory
      The laboratory service that issued the report
    }
    property laboratory : TFHIRResourceReference{TOrganization} read FLaboratory write SetLaboratory;

    {@member reportId
      The local ID assigned to the report by the order filler, usually by the Laboratory Information System (LIS).
    }
    property reportId : String read FReportId write SetReportId;

    {@member RequestDetail
      Details concerning a single pathology test requested.
    }
    property RequestDetail : TLabReportRequestDetailList read FRequestDetail;

    {@member reportName
      Identification of the pathology test performed, sometimes including specimen type.
    }
    property reportName : TCodeableConcept read FReportName write SetReportName;

    {@member service
      The diagnostic service that performs the examination e.g. biochemistry, haematology.
    }
    property service : TCodeableConcept read FService write SetService;

    {@member diagnosticTime
      The diagnostically relevant time for this report
    }
    property diagnosticTime : String read FDiagnosticTime write SetDiagnosticTime;

    {@member Specimen
      Details about the specimen if all individual test results are derived from the same specimen
    }
    property Specimen : TFHIRResourceReferenceList{TSpecimen} read FSpecimen;

    {@member ResultGroup
      A group of results. Results may be grouped by specimen, or by some value in LabReport.resultGroup.name to describe what binds all the results together.
    }
    property ResultGroup : TLabReportResultGroupList read FResultGroup;

    {@member conclusion
      Concise and clinically contextualised narrative interpretation of the pathology test results.
    }
    property conclusion : TNarrative read FConclusion write SetConclusion;

    {@member CodedDiagnosis
      Codes for the conclusion
    }
    property CodedDiagnosis : TCodeableConceptList read FCodedDiagnosis;

    {@member Representation
      Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they must be semantically equivalent.
    }
    property Representation : TAttachmentList read FRepresentation;

  end;


  {@Class TPersonQualification
    The qualifications a person has, including formal educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment
  }
  TPersonQualification = class (TFHIRElement)
  private
    FId : TIdentifier;
    FCode : TCodeableConcept;
    FInstitution : TFHIRResourceReference{TOrganization};
    FPeriod : TInterval_date;
    Procedure SetId(value : TIdentifier);
    Procedure SetCode(value : TCodeableConcept);
    Procedure SetInstitution(value : TFHIRResourceReference{TOrganization});
    Procedure SetPeriod(value : TInterval_date);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPersonQualification; overload;
    function Clone : TPersonQualification; overload;
    {@member id
      The identifier of a qualification
    }
    property id : TIdentifier read FId write SetId;

    {@member code
      The type of the qualification
    }
    property code : TCodeableConcept read FCode write SetCode;

    {@member institution
      The organisation that confered/confers the qualification
    }
    property institution : TFHIRResourceReference{TOrganization} read FInstitution write SetInstitution;

    {@member period
      The period for which a qualification is held
    }
    property period : TInterval_date read FPeriod write SetPeriod;

  end;


  {@Class TPersonLanguage
    A language spoken by the person, with proficiency
  }
  TPersonLanguage = class (TFHIRElement)
  private
    FCode : String;
    FUse : TLanguageUse;
    Procedure SetCode(value : String);
    Procedure SetUse(value : TLanguageUse);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPersonLanguage; overload;
    function Clone : TPersonLanguage; overload;
    {@member code
      A code that identifies the language
    }
    property code : String read FCode write SetCode;

    {@member use
      A code the describes how well the language is spoken
    }
    property use : TLanguageUse read FUse write SetUse;

  end;


  {@Class TPersonRelatedPerson
    Other persons who are related to this person. The relationship might be one of several types: kin (familial or marital), financial or legal (such as guardian), biological (e.g. donor, donation-recipient) or casual (i.e. friend).
  }
  TPersonRelatedPerson = class (TFHIRElement)
  private
    FId : THumanId;
    FRole : TCodeableConcept;
    FName : THumanName;
    FContact : TContactList;
    Procedure SetId(value : THumanId);
    Procedure SetRole(value : TCodeableConcept);
    Procedure SetName(value : THumanName);
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPersonRelatedPerson; overload;
    function Clone : TPersonRelatedPerson; overload;
    {@member id
      Identifier the related person - may be a full link to a Person resource, or some other kind of identifier
    }
    property id : THumanId read FId write SetId;

    {@member role
      Code that specifies how this person is related to the subject. A code is required.
    }
    property role : TCodeableConcept read FRole write SetRole;

    {@member name
      A name should be specified for the related person
    }
    property name : THumanName read FName write SetName;

    {@member Contact
      Contact details (phone, email etc) should be provided for the person
    }
    property Contact : TContactList read FContact;

  end;


  {@Class TPersonQualificationList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.PersonQualificationList}
  TPersonQualificationList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TPersonQualification;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TPersonQualification) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TPersonQualification;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TPersonQualification read GetItemN; default;
  End;


  {@Class TPersonLanguageList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.PersonLanguageList}
  TPersonLanguageList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TPersonLanguage;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TPersonLanguage) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TPersonLanguage;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TPersonLanguage read GetItemN; default;
  End;


  {@Class TPersonRelatedPersonList
    A list of Author
  }
  {!.Net HL7Connect.FHIR.PersonRelatedPersonList}
  TPersonRelatedPersonList = class (THL7FHIRObjectList)
  private
    Function GetItemN(index : Integer) : TPersonRelatedPerson;
  public
    {@member IndexOf
      See if an item is already in the list. returns -1 if not in the list
    }
    Function IndexOf(value : TPersonRelatedPerson) : Integer;
    {@member Item
       Get the iIndexth Author. (0 = first item)
    }
    Function Item(index : Integer) : TPersonRelatedPerson;
    {@member Count
      The number of items in the collection
    }
    Function Count : Integer; Overload;
    Property Segments[index : Integer] : TPersonRelatedPerson read GetItemN; default;
  End;


  {@Class TPerson
    A person who is involved in the healthcare process
  }
  TPerson = class (TFHIRResource)
  private
    FIdentifier : THumanIdList;
    FName : THumanNameList;
    FAddress : TAddressList;
    FContact : TContactList;
    FDob : String;
    FGender : TCodeableConcept;
    FReligion : TCodeableConcept;
    FQualification : TPersonQualificationList;
    FLanguage : TPersonLanguageList;
    FRelatedPerson : TPersonRelatedPersonList;
    Procedure SetDob(value : String);
    Procedure SetGender(value : TCodeableConcept);
    Procedure SetReligion(value : TCodeableConcept);
  protected
    function GetResourceType : TFHIRResourceType; override;
  public
    constructor Create; Override;
    destructor Destroy; override;
    procedure Assign(oSource : TAdvObject); override;
    function Link : TPerson; overload;
    function Clone : TPerson; overload;
    {@member Identifier
      Identifier for the person that is used to identify the person across multiple disparate systems and also for face to face identification of the person
    }
    property Identifier : THumanIdList read FIdentifier;

    {@member Name
      A name associated with the person
    }
    property Name : THumanNameList read FName;

    {@member Address
      An address for the person
    }
    property Address : TAddressList read FAddress;

    {@member Contact
      A contact detail for the person
    }
    property Contact : TContactList read FContact;

    {@member dob
      The birth date for the person
    }
    property dob : String read FDob write SetDob;

    {@member gender
      Administrative Gender
    }
    property gender : TCodeableConcept read FGender write SetGender;

    {@member religion
      The religious denomination to which a person professes affiliation
    }
    property religion : TCodeableConcept read FReligion write SetReligion;

    {@member Qualification
      The qualifications a person has, including formal educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment
    }
    property Qualification : TPersonQualificationList read FQualification;

    {@member Language
      A language spoken by the person, with proficiency
    }
    property Language : TPersonLanguageList read FLanguage;

    {@member RelatedPerson
      Other persons who are related to this person. The relationship might be one of several types: kin (familial or marital), financial or legal (such as guardian), biological (e.g. donor, donation-recipient) or casual (i.e. friend).
    }
    property RelatedPerson : TPersonRelatedPersonList read FRelatedPerson;

  end;


implementation

{ TFHIRResource }

constructor TFHIRResource.Create;
begin
  inherited;
end;

destructor TFHIRResource.Destroy;
begin
  FText.Free;
  inherited;
end;

procedure TFHIRResource.Assign(oSource : TAdvObject);
begin
  inherited;
  FId := TFHIRResource(oSource).FId;
  text := TFHIRResource(oSource).text.Clone;
end;

function TFHIRResource.Link : TFHIRResource;
begin
  result := TFHIRResource(inherited Link);
end;

function TFHIRResource.Clone : TFHIRResource;
begin
  result := TFHIRResource(inherited Clone);
end;

procedure TFHIRResource.SetResourceId(value : string);
begin
  FId := value;
end;

procedure TFHIRResource.SetText(value : TNarrative);
begin
  FText.Free;
  FText := value;
end;


{ TExtensionList }
function TExtensionList.Count: Integer;
begin
  result := Inherited Count;
end;

function TExtensionList.GetItemN(index: Integer): TExtension;
begin
  result := TExtension(ObjectByIndex[index]);
end;

function TExtensionList.IndexOf(value: TExtension): Integer;
begin
  result := IndexByReference(value);
end;

function TExtensionList.Item(index: Integer): TExtension;
begin
  result := TExtension(ObjectByIndex[index]);
end;


{ TExtension }

constructor TExtension.Create;
begin
  inherited;
  FExtension := TExtensionList.Create;
end;

destructor TExtension.Destroy;
begin
  FValue.free;
  FExtension.Free;
  inherited;
end;

procedure TExtension.Assign(oSource : TAdvObject);
begin
  inherited;
  FCode := TExtension(oSource).FCode;
  FDefinition := TExtension(oSource).FDefinition;
  FRef := TExtension(oSource).FRef;
  FState := TExtension(oSource).FState;
  value := TExtension(oSource).value.Clone;
  FExtension.Assign(TExtension(oSource).FExtension);
end;

function TExtension.Link : TExtension;
begin
  result := TExtension(inherited Link);
end;

function TExtension.Clone : TExtension;
begin
  result := TExtension(inherited Clone);
end;

{ TExtension }

Procedure TExtension.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TExtension.SetDefinition(value : String);
begin
  FDefinition := value;
end;

Procedure TExtension.SetRef(value : String);
begin
  FRef := value;
end;

Procedure TExtension.SetState(value : TExtensionState);
begin
  FState := value;
end;

Procedure TExtension.SetValue(value : TFHIRType);
begin
  FValue.free;
  FValue := value;
end;


{ TConstraintElementMappingList }
function TConstraintElementMappingList.Count: Integer;
begin
  result := Inherited Count;
end;

function TConstraintElementMappingList.GetItemN(index: Integer): TConstraintElementMapping;
begin
  result := TConstraintElementMapping(ObjectByIndex[index]);
end;

function TConstraintElementMappingList.IndexOf(value: TConstraintElementMapping): Integer;
begin
  result := IndexByReference(value);
end;

function TConstraintElementMappingList.Item(index: Integer): TConstraintElementMapping;
begin
  result := TConstraintElementMapping(ObjectByIndex[index]);
end;


{ TConstraintElementValueList }
function TConstraintElementValueList.Count: Integer;
begin
  result := Inherited Count;
end;

function TConstraintElementValueList.GetItemN(index: Integer): TConstraintElementValue;
begin
  result := TConstraintElementValue(ObjectByIndex[index]);
end;

function TConstraintElementValueList.IndexOf(value: TConstraintElementValue): Integer;
begin
  result := IndexByReference(value);
end;

function TConstraintElementValueList.Item(index: Integer): TConstraintElementValue;
begin
  result := TConstraintElementValue(ObjectByIndex[index]);
end;


{ TConstraintElement }

constructor TConstraintElement.Create;
begin
  inherited;
  FMapping := TConstraintElementMappingList.Create;
  FValue := TConstraintElementValueList.Create;
end;

destructor TConstraintElement.Destroy;
begin
  FMapping.Free;
  FAggregation.free;
  FValue.Free;
  inherited;
end;

procedure TConstraintElement.Assign(oSource : TAdvObject);
begin
  inherited;
  FPath := TConstraintElement(oSource).FPath;
  FName := TConstraintElement(oSource).FName;
  FPurpose := TConstraintElement(oSource).FPurpose;
  FMin := TConstraintElement(oSource).FMin;
  FMax := TConstraintElement(oSource).FMax;
  FType_ := TConstraintElement(oSource).FType_;
  FConformance := TConstraintElement(oSource).FConformance;
  FCondition := TConstraintElement(oSource).FCondition;
  FMustSupport := TConstraintElement(oSource).FMustSupport;
  FMustUnderstand := TConstraintElement(oSource).FMustUnderstand;
  FDefinition := TConstraintElement(oSource).FDefinition;
  FMapping.Assign(TConstraintElement(oSource).FMapping);
  aggregation := TConstraintElement(oSource).aggregation.Clone;
  FValueSet := TConstraintElement(oSource).FValueSet;
  FValue.Assign(TConstraintElement(oSource).FValue);
end;

function TConstraintElement.Link : TConstraintElement;
begin
  result := TConstraintElement(inherited Link);
end;

function TConstraintElement.Clone : TConstraintElement;
begin
  result := TConstraintElement(inherited Clone);
end;

{ TConstraintElement }

Procedure TConstraintElement.SetPath(value : String);
begin
  FPath := value;
end;

Procedure TConstraintElement.SetName(value : String);
begin
  FName := value;
end;

Procedure TConstraintElement.SetPurpose(value : String);
begin
  FPurpose := value;
end;

Procedure TConstraintElement.SetMin(value : Integer);
begin
  FMin := value;
end;

Procedure TConstraintElement.SetMax(value : String);
begin
  FMax := value;
end;

Procedure TConstraintElement.SetType_(value : String);
begin
  FType_ := value;
end;

Procedure TConstraintElement.SetConformance(value : TConformanceType);
begin
  FConformance := value;
end;

Procedure TConstraintElement.SetCondition(value : String);
begin
  FCondition := value;
end;

Procedure TConstraintElement.SetMustSupport(value : Boolean);
begin
  FMustSupport := value;
end;

Procedure TConstraintElement.SetMustUnderstand(value : Boolean);
begin
  FMustUnderstand := value;
end;

Procedure TConstraintElement.SetDefinition(value : String);
begin
  FDefinition := value;
end;

Procedure TConstraintElement.SetAggregation(value : TConstraintElementAggregation);
begin
  FAggregation.free;
  FAggregation := value;
end;

Procedure TConstraintElement.SetValueSet(value : String);
begin
  FValueSet := value;
end;


{ TConstraintElementMapping }

constructor TConstraintElementMapping.Create;
begin
  inherited;
end;

destructor TConstraintElementMapping.Destroy;
begin
  inherited;
end;

procedure TConstraintElementMapping.Assign(oSource : TAdvObject);
begin
  inherited;
  FTarget := TConstraintElementMapping(oSource).FTarget;
  FMap := TConstraintElementMapping(oSource).FMap;
end;

function TConstraintElementMapping.Link : TConstraintElementMapping;
begin
  result := TConstraintElementMapping(inherited Link);
end;

function TConstraintElementMapping.Clone : TConstraintElementMapping;
begin
  result := TConstraintElementMapping(inherited Clone);
end;

{ TConstraintElementMapping }

Procedure TConstraintElementMapping.SetTarget(value : String);
begin
  FTarget := value;
end;

Procedure TConstraintElementMapping.SetMap(value : String);
begin
  FMap := value;
end;


{ TConstraintElementAggregation }

constructor TConstraintElementAggregation.Create;
begin
  inherited;
end;

destructor TConstraintElementAggregation.Destroy;
begin
  inherited;
end;

procedure TConstraintElementAggregation.Assign(oSource : TAdvObject);
begin
  inherited;
  FAggregated := TConstraintElementAggregation(oSource).FAggregated;
  FName := TConstraintElementAggregation(oSource).FName;
end;

function TConstraintElementAggregation.Link : TConstraintElementAggregation;
begin
  result := TConstraintElementAggregation(inherited Link);
end;

function TConstraintElementAggregation.Clone : TConstraintElementAggregation;
begin
  result := TConstraintElementAggregation(inherited Clone);
end;

{ TConstraintElementAggregation }

Procedure TConstraintElementAggregation.SetAggregated(value : Boolean);
begin
  FAggregated := value;
end;

Procedure TConstraintElementAggregation.SetName(value : String);
begin
  FName := value;
end;


{ TConstraintElementValue }

constructor TConstraintElementValue.Create;
begin
  inherited;
end;

destructor TConstraintElementValue.Destroy;
begin
  FValue.free;
  inherited;
end;

procedure TConstraintElementValue.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TConstraintElementValue(oSource).FName;
  value := TConstraintElementValue(oSource).value.Clone;
end;

function TConstraintElementValue.Link : TConstraintElementValue;
begin
  result := TConstraintElementValue(inherited Link);
end;

function TConstraintElementValue.Clone : TConstraintElementValue;
begin
  result := TConstraintElementValue(inherited Clone);
end;

{ TConstraintElementValue }

Procedure TConstraintElementValue.SetName(value : String);
begin
  FName := value;
end;

Procedure TConstraintElementValue.SetValue(value : TFHIRType);
begin
  FValue.free;
  FValue := value;
end;


{ TConstraintElementList }
function TConstraintElementList.Count: Integer;
begin
  result := Inherited Count;
end;

function TConstraintElementList.GetItemN(index: Integer): TConstraintElement;
begin
  result := TConstraintElement(ObjectByIndex[index]);
end;

function TConstraintElementList.IndexOf(value: TConstraintElement): Integer;
begin
  result := IndexByReference(value);
end;

function TConstraintElementList.Item(index: Integer): TConstraintElement;
begin
  result := TConstraintElement(ObjectByIndex[index]);
end;


{ TConstraint }

constructor TConstraint.Create;
begin
  inherited;
  FElement := TConstraintElementList.Create;
end;

destructor TConstraint.Destroy;
begin
  FElement.Free;
  inherited;
end;

procedure TConstraint.Assign(oSource : TAdvObject);
begin
  inherited;
  FType_ := TConstraint(oSource).FType_;
  FName := TConstraint(oSource).FName;
  FPurpose := TConstraint(oSource).FPurpose;
  FElement.Assign(TConstraint(oSource).FElement);
end;

function TConstraint.Link : TConstraint;
begin
  result := TConstraint(inherited Link);
end;

function TConstraint.Clone : TConstraint;
begin
  result := TConstraint(inherited Clone);
end;

{ TConstraint }

Procedure TConstraint.SetType_(value : String);
begin
  FType_ := value;
end;

Procedure TConstraint.SetName(value : String);
begin
  FName := value;
end;

Procedure TConstraint.SetPurpose(value : String);
begin
  FPurpose := value;
end;


{ TNarrativeImage }

constructor TNarrativeImage.Create;
begin
  inherited;
end;

destructor TNarrativeImage.Destroy;
begin
  FContent.free;
  inherited;
end;

procedure TNarrativeImage.Assign(oSource : TAdvObject);
begin
  inherited;
  FMimeType := TNarrativeImage(oSource).FMimeType;
  content := TNarrativeImage(oSource).content.Clone;
end;

function TNarrativeImage.Link : TNarrativeImage;
begin
  result := TNarrativeImage(inherited Link);
end;

function TNarrativeImage.Clone : TNarrativeImage;
begin
  result := TNarrativeImage(inherited Clone);
end;

{ TNarrativeImage }

Procedure TNarrativeImage.SetMimeType(value : String);
begin
  FMimeType := value;
end;

Procedure TNarrativeImage.SetContent(value : TAdvBuffer);
begin
  FContent.free;
  FContent := value;
end;


{ TNarrativeMap }

constructor TNarrativeMap.Create;
begin
  inherited;
end;

destructor TNarrativeMap.Destroy;
begin
  inherited;
end;

procedure TNarrativeMap.Assign(oSource : TAdvObject);
begin
  inherited;
  FText := TNarrativeMap(oSource).FText;
  FData := TNarrativeMap(oSource).FData;
  FSource := TNarrativeMap(oSource).FSource;
end;

function TNarrativeMap.Link : TNarrativeMap;
begin
  result := TNarrativeMap(inherited Link);
end;

function TNarrativeMap.Clone : TNarrativeMap;
begin
  result := TNarrativeMap(inherited Clone);
end;

{ TNarrativeMap }

Procedure TNarrativeMap.SetText(value : String);
begin
  FText := value;
end;

Procedure TNarrativeMap.SetData(value : String);
begin
  FData := value;
end;

Procedure TNarrativeMap.SetSource(value : TNarrativeMapSource);
begin
  FSource := value;
end;


{ TNarrativeImageList }
function TNarrativeImageList.Count: Integer;
begin
  result := Inherited Count;
end;

function TNarrativeImageList.GetItemN(index: Integer): TNarrativeImage;
begin
  result := TNarrativeImage(ObjectByIndex[index]);
end;

function TNarrativeImageList.IndexOf(value: TNarrativeImage): Integer;
begin
  result := IndexByReference(value);
end;

function TNarrativeImageList.Item(index: Integer): TNarrativeImage;
begin
  result := TNarrativeImage(ObjectByIndex[index]);
end;


{ TNarrativeMapList }
function TNarrativeMapList.Count: Integer;
begin
  result := Inherited Count;
end;

function TNarrativeMapList.GetItemN(index: Integer): TNarrativeMap;
begin
  result := TNarrativeMap(ObjectByIndex[index]);
end;

function TNarrativeMapList.IndexOf(value: TNarrativeMap): Integer;
begin
  result := IndexByReference(value);
end;

function TNarrativeMapList.Item(index: Integer): TNarrativeMap;
begin
  result := TNarrativeMap(ObjectByIndex[index]);
end;


{ TNarrative }

constructor TNarrative.Create;
begin
  inherited;
  FImage := TNarrativeImageList.Create;
  FMap := TNarrativeMapList.Create;
end;

destructor TNarrative.Destroy;
begin
  FHtml.free;
  FImage.Free;
  FMap.Free;
  inherited;
end;

procedure TNarrative.Assign(oSource : TAdvObject);
begin
  inherited;
  FStatus := TNarrative(oSource).FStatus;
  html := TNarrative(oSource).html.Clone;
  FImage.Assign(TNarrative(oSource).FImage);
  FMap.Assign(TNarrative(oSource).FMap);
end;

function TNarrative.Link : TNarrative;
begin
  result := TNarrative(inherited Link);
end;

function TNarrative.Clone : TNarrative;
begin
  result := TNarrative(inherited Clone);
end;

{ TNarrative }

Procedure TNarrative.SetStatus(value : TNarrativeStatus);
begin
  FStatus := value;
end;

Procedure TNarrative.SetHtml(value : TXHtml);
begin
  FHtml.free;
  FHtml := value;
end;


{ TCoding }

constructor TCoding.Create;
begin
  inherited;
end;

destructor TCoding.Destroy;
begin
  inherited;
end;

procedure TCoding.Assign(oSource : TAdvObject);
begin
  inherited;
  FCode := TCoding(oSource).FCode;
  FSystem := TCoding(oSource).FSystem;
  FDisplay := TCoding(oSource).FDisplay;
end;

function TCoding.Link : TCoding;
begin
  result := TCoding(inherited Link);
end;

function TCoding.Clone : TCoding;
begin
  result := TCoding(inherited Clone);
end;

{ TCoding }

Procedure TCoding.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TCoding.SetSystem(value : String);
begin
  FSystem := value;
end;

Procedure TCoding.SetDisplay(value : String);
begin
  FDisplay := value;
end;


{ TInterval_Quantity }

constructor TInterval_Quantity.Create;
begin
  inherited;
end;

destructor TInterval_Quantity.Destroy;
begin
  FLow.free;
  FHigh.free;
  inherited;
end;

procedure TInterval_Quantity.Assign(oSource : TAdvObject);
begin
  inherited;
  low := TInterval_Quantity(oSource).low.Clone;
  high := TInterval_Quantity(oSource).high.Clone;
end;

function TInterval_Quantity.Link : TInterval_Quantity;
begin
  result := TInterval_Quantity(inherited Link);
end;

function TInterval_Quantity.Clone : TInterval_Quantity;
begin
  result := TInterval_Quantity(inherited Clone);
end;

Procedure TInterval_Quantity.SetLow(value : TQuantity);
begin
  FLow.free;
  FLow := value;
end;

Procedure TInterval_Quantity.SetHigh(value : TQuantity);
begin
  FHigh.free;
  FHigh := value;
end;


{ TInterval_DateTime }

constructor TInterval_DateTime.Create;
begin
  inherited;
end;

destructor TInterval_DateTime.Destroy;
begin
  inherited;
end;

procedure TInterval_DateTime.Assign(oSource : TAdvObject);
begin
  inherited;
  FLow := TInterval_DateTime(oSource).FLow;
  FHigh := TInterval_DateTime(oSource).FHigh;
end;

function TInterval_DateTime.Link : TInterval_DateTime;
begin
  result := TInterval_DateTime(inherited Link);
end;

function TInterval_DateTime.Clone : TInterval_DateTime;
begin
  result := TInterval_DateTime(inherited Clone);
end;

Procedure TInterval_DateTime.SetLow(value : String);
begin
  FLow := value;
end;

Procedure TInterval_DateTime.SetHigh(value : String);
begin
  FHigh := value;
end;


{ TInterval_Date }

constructor TInterval_Date.Create;
begin
  inherited;
end;

destructor TInterval_Date.Destroy;
begin
  inherited;
end;

procedure TInterval_Date.Assign(oSource : TAdvObject);
begin
  inherited;
  FLow := TInterval_Date(oSource).FLow;
  FHigh := TInterval_Date(oSource).FHigh;
end;

function TInterval_Date.Link : TInterval_Date;
begin
  result := TInterval_Date(inherited Link);
end;

function TInterval_Date.Clone : TInterval_Date;
begin
  result := TInterval_Date(inherited Clone);
end;

Procedure TInterval_Date.SetLow(value : String);
begin
  FLow := value;
end;

Procedure TInterval_Date.SetHigh(value : String);
begin
  FHigh := value;
end;


{ TQuantity }

constructor TQuantity.Create;
begin
  inherited;
end;

destructor TQuantity.Destroy;
begin
  FValue.free;
  inherited;
end;

procedure TQuantity.Assign(oSource : TAdvObject);
begin
  inherited;
  value := TQuantity(oSource).value.Clone;
  FStatus := TQuantity(oSource).FStatus;
  FUnits := TQuantity(oSource).FUnits;
  FCode := TQuantity(oSource).FCode;
  FSystem := TQuantity(oSource).FSystem;
end;

function TQuantity.Link : TQuantity;
begin
  result := TQuantity(inherited Link);
end;

function TQuantity.Clone : TQuantity;
begin
  result := TQuantity(inherited Clone);
end;

{ TQuantity }

Procedure TQuantity.SetValue(value : TSmartDecimal);
begin
  FValue.free;
  FValue := value;
end;

Procedure TQuantity.SetStatus(value : TQuantityStatus);
begin
  FStatus := value;
end;

Procedure TQuantity.SetUnits(value : String);
begin
  FUnits := value;
end;

Procedure TQuantity.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TQuantity.SetSystem(value : String);
begin
  FSystem := value;
end;


{ TChoiceValue }

constructor TChoiceValue.Create;
begin
  inherited;
end;

destructor TChoiceValue.Destroy;
begin
  inherited;
end;

procedure TChoiceValue.Assign(oSource : TAdvObject);
begin
  inherited;
  FCode := TChoiceValue(oSource).FCode;
  FDisplay := TChoiceValue(oSource).FDisplay;
end;

function TChoiceValue.Link : TChoiceValue;
begin
  result := TChoiceValue(inherited Link);
end;

function TChoiceValue.Clone : TChoiceValue;
begin
  result := TChoiceValue(inherited Clone);
end;

{ TChoiceValue }

Procedure TChoiceValue.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TChoiceValue.SetDisplay(value : String);
begin
  FDisplay := value;
end;


{ TChoiceValueList }
function TChoiceValueList.Count: Integer;
begin
  result := Inherited Count;
end;

function TChoiceValueList.GetItemN(index: Integer): TChoiceValue;
begin
  result := TChoiceValue(ObjectByIndex[index]);
end;

function TChoiceValueList.IndexOf(value: TChoiceValue): Integer;
begin
  result := IndexByReference(value);
end;

function TChoiceValueList.Item(index: Integer): TChoiceValue;
begin
  result := TChoiceValue(ObjectByIndex[index]);
end;


{ TChoice }

constructor TChoice.Create;
begin
  inherited;
  FValue := TChoiceValueList.Create;
end;

destructor TChoice.Destroy;
begin
  FValue.Free;
  inherited;
end;

procedure TChoice.Assign(oSource : TAdvObject);
begin
  inherited;
  FCode := TChoice(oSource).FCode;
  FValue.Assign(TChoice(oSource).FValue);
  FIsOrdered := TChoice(oSource).FIsOrdered;
end;

function TChoice.Link : TChoice;
begin
  result := TChoice(inherited Link);
end;

function TChoice.Clone : TChoice;
begin
  result := TChoice(inherited Clone);
end;

{ TChoice }

Procedure TChoice.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TChoice.SetIsOrdered(value : Boolean);
begin
  FIsOrdered := value;
end;


{ TAttachment }

constructor TAttachment.Create;
begin
  inherited;
end;

destructor TAttachment.Destroy;
begin
  FData.free;
  FHash.free;
  inherited;
end;

procedure TAttachment.Assign(oSource : TAdvObject);
begin
  inherited;
  FMimeType := TAttachment(oSource).FMimeType;
  data := TAttachment(oSource).data.Clone;
  FUrl := TAttachment(oSource).FUrl;
  hash := TAttachment(oSource).hash.Clone;
  FLang := TAttachment(oSource).FLang;
  FTitle := TAttachment(oSource).FTitle;
end;

function TAttachment.Link : TAttachment;
begin
  result := TAttachment(inherited Link);
end;

function TAttachment.Clone : TAttachment;
begin
  result := TAttachment(inherited Clone);
end;

{ TAttachment }

Procedure TAttachment.SetMimeType(value : String);
begin
  FMimeType := value;
end;

Procedure TAttachment.SetData(value : TAdvBuffer);
begin
  FData.free;
  FData := value;
end;

Procedure TAttachment.SetUrl(value : String);
begin
  FUrl := value;
end;

Procedure TAttachment.SetHash(value : TAdvBuffer);
begin
  FHash.free;
  FHash := value;
end;

Procedure TAttachment.SetLang(value : String);
begin
  FLang := value;
end;

Procedure TAttachment.SetTitle(value : String);
begin
  FTitle := value;
end;


{ TRatio }

constructor TRatio.Create;
begin
  inherited;
end;

destructor TRatio.Destroy;
begin
  FNumerator.free;
  FDenominator.free;
  inherited;
end;

procedure TRatio.Assign(oSource : TAdvObject);
begin
  inherited;
  numerator := TRatio(oSource).numerator.Clone;
  denominator := TRatio(oSource).denominator.Clone;
end;

function TRatio.Link : TRatio;
begin
  result := TRatio(inherited Link);
end;

function TRatio.Clone : TRatio;
begin
  result := TRatio(inherited Clone);
end;

{ TRatio }

Procedure TRatio.SetNumerator(value : TQuantity);
begin
  FNumerator.free;
  FNumerator := value;
end;

Procedure TRatio.SetDenominator(value : TQuantity);
begin
  FDenominator.free;
  FDenominator := value;
end;


{ TCodeableConceptCoding }

constructor TCodeableConceptCoding.Create;
begin
  inherited;
end;

destructor TCodeableConceptCoding.Destroy;
begin
  inherited;
end;

procedure TCodeableConceptCoding.Assign(oSource : TAdvObject);
begin
  inherited;
  FCode := TCodeableConceptCoding(oSource).FCode;
  FSystem := TCodeableConceptCoding(oSource).FSystem;
  FDisplay := TCodeableConceptCoding(oSource).FDisplay;
end;

function TCodeableConceptCoding.Link : TCodeableConceptCoding;
begin
  result := TCodeableConceptCoding(inherited Link);
end;

function TCodeableConceptCoding.Clone : TCodeableConceptCoding;
begin
  result := TCodeableConceptCoding(inherited Clone);
end;

{ TCodeableConceptCoding }

Procedure TCodeableConceptCoding.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TCodeableConceptCoding.SetSystem(value : String);
begin
  FSystem := value;
end;

Procedure TCodeableConceptCoding.SetDisplay(value : String);
begin
  FDisplay := value;
end;


{ TCodeableConceptCodingList }
function TCodeableConceptCodingList.Count: Integer;
begin
  result := Inherited Count;
end;

function TCodeableConceptCodingList.GetItemN(index: Integer): TCodeableConceptCoding;
begin
  result := TCodeableConceptCoding(ObjectByIndex[index]);
end;

function TCodeableConceptCodingList.IndexOf(value: TCodeableConceptCoding): Integer;
begin
  result := IndexByReference(value);
end;

function TCodeableConceptCodingList.Item(index: Integer): TCodeableConceptCoding;
begin
  result := TCodeableConceptCoding(ObjectByIndex[index]);
end;


{ TCodeableConcept }

constructor TCodeableConcept.Create;
begin
  inherited;
  FCoding := TCodeableConceptCodingList.Create;
end;

destructor TCodeableConcept.Destroy;
begin
  FCoding.Free;
  inherited;
end;

procedure TCodeableConcept.Assign(oSource : TAdvObject);
begin
  inherited;
  FCoding.Assign(TCodeableConcept(oSource).FCoding);
  FText := TCodeableConcept(oSource).FText;
  FPrimary := TCodeableConcept(oSource).FPrimary;
end;

function TCodeableConcept.Link : TCodeableConcept;
begin
  result := TCodeableConcept(inherited Link);
end;

function TCodeableConcept.Clone : TCodeableConcept;
begin
  result := TCodeableConcept(inherited Clone);
end;

{ TCodeableConcept }

Procedure TCodeableConcept.SetText(value : String);
begin
  FText := value;
end;

Procedure TCodeableConcept.SetPrimary(value : String);
begin
  FPrimary := value;
end;


{ TIdentifier }

constructor TIdentifier.Create;
begin
  inherited;
end;

destructor TIdentifier.Destroy;
begin
  inherited;
end;

procedure TIdentifier.Assign(oSource : TAdvObject);
begin
  inherited;
  FSystem := TIdentifier(oSource).FSystem;
  FId := TIdentifier(oSource).FId;
end;

function TIdentifier.Link : TIdentifier;
begin
  result := TIdentifier(inherited Link);
end;

function TIdentifier.Clone : TIdentifier;
begin
  result := TIdentifier(inherited Clone);
end;

{ TIdentifier }

Procedure TIdentifier.SetSystem(value : String);
begin
  FSystem := value;
end;

Procedure TIdentifier.SetId(value : String);
begin
  FId := value;
end;


{ TScheduleRepeat }

constructor TScheduleRepeat.Create;
begin
  inherited;
end;

destructor TScheduleRepeat.Destroy;
begin
  FDuration.free;
  inherited;
end;

procedure TScheduleRepeat.Assign(oSource : TAdvObject);
begin
  inherited;
  FFrequency := TScheduleRepeat(oSource).FFrequency;
  FWhen := TScheduleRepeat(oSource).FWhen;
  duration := TScheduleRepeat(oSource).duration.Clone;
  FCount := TScheduleRepeat(oSource).FCount;
  FEnd_ := TScheduleRepeat(oSource).FEnd_;
end;

function TScheduleRepeat.Link : TScheduleRepeat;
begin
  result := TScheduleRepeat(inherited Link);
end;

function TScheduleRepeat.Clone : TScheduleRepeat;
begin
  result := TScheduleRepeat(inherited Clone);
end;

{ TScheduleRepeat }

Procedure TScheduleRepeat.SetFrequency(value : Integer);
begin
  FFrequency := value;
end;

Procedure TScheduleRepeat.SetWhen(value : TEventTiming);
begin
  FWhen := value;
end;

Procedure TScheduleRepeat.SetDuration(value : TQuantity);
begin
  FDuration.free;
  FDuration := value;
end;

Procedure TScheduleRepeat.SetCount(value : Integer);
begin
  FCount := value;
end;

Procedure TScheduleRepeat.SetEnd_(value : String);
begin
  FEnd_ := value;
end;


{ TInterval_dateTimeList }
function TInterval_dateTimeList.Count: Integer;
begin
  result := Inherited Count;
end;

function TInterval_dateTimeList.GetItemN(index: Integer): TInterval_dateTime;
begin
  result := TInterval_dateTime(ObjectByIndex[index]);
end;

function TInterval_dateTimeList.IndexOf(value: TInterval_dateTime): Integer;
begin
  result := IndexByReference(value);
end;

function TInterval_dateTimeList.Item(index: Integer): TInterval_dateTime;
begin
  result := TInterval_dateTime(ObjectByIndex[index]);
end;


{ TSchedule }

constructor TSchedule.Create;
begin
  inherited;
  FEvent := TInterval_dateTimeList.Create;
end;

destructor TSchedule.Destroy;
begin
  FEvent.Free;
  FRepeat_.free;
  inherited;
end;

procedure TSchedule.Assign(oSource : TAdvObject);
begin
  inherited;
  FEvent.Assign(TSchedule(oSource).FEvent);
  repeat_ := TSchedule(oSource).repeat_.Clone;
end;

function TSchedule.Link : TSchedule;
begin
  result := TSchedule(inherited Link);
end;

function TSchedule.Clone : TSchedule;
begin
  result := TSchedule(inherited Clone);
end;

{ TSchedule }

Procedure TSchedule.SetRepeat_(value : TScheduleRepeat);
begin
  FRepeat_.free;
  FRepeat_ := value;
end;


{ TContact }

constructor TContact.Create;
begin
  inherited;
end;

destructor TContact.Destroy;
begin
  FPeriod.free;
  inherited;
end;

procedure TContact.Assign(oSource : TAdvObject);
begin
  inherited;
  FSystem := TContact(oSource).FSystem;
  FValue := TContact(oSource).FValue;
  FUse := TContact(oSource).FUse;
  period := TContact(oSource).period.Clone;
end;

function TContact.Link : TContact;
begin
  result := TContact(inherited Link);
end;

function TContact.Clone : TContact;
begin
  result := TContact(inherited Clone);
end;

{ TContact }

Procedure TContact.SetSystem(value : TContactSystem);
begin
  FSystem := value;
end;

Procedure TContact.SetValue(value : String);
begin
  FValue := value;
end;

Procedure TContact.SetUse(value : TContactUse);
begin
  FUse := value;
end;

Procedure TContact.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ TAddressPart }

constructor TAddressPart.Create;
begin
  inherited;
end;

destructor TAddressPart.Destroy;
begin
  inherited;
end;

procedure TAddressPart.Assign(oSource : TAdvObject);
begin
  inherited;
  FType_ := TAddressPart(oSource).FType_;
  FValue := TAddressPart(oSource).FValue;
end;

function TAddressPart.Link : TAddressPart;
begin
  result := TAddressPart(inherited Link);
end;

function TAddressPart.Clone : TAddressPart;
begin
  result := TAddressPart(inherited Clone);
end;

{ TAddressPart }

Procedure TAddressPart.SetType_(value : TAddressPartType);
begin
  FType_ := value;
end;

Procedure TAddressPart.SetValue(value : String);
begin
  FValue := value;
end;


{ TAddressPartList }
function TAddressPartList.Count: Integer;
begin
  result := Inherited Count;
end;

function TAddressPartList.GetItemN(index: Integer): TAddressPart;
begin
  result := TAddressPart(ObjectByIndex[index]);
end;

function TAddressPartList.IndexOf(value: TAddressPart): Integer;
begin
  result := IndexByReference(value);
end;

function TAddressPartList.Item(index: Integer): TAddressPart;
begin
  result := TAddressPart(ObjectByIndex[index]);
end;


{ TAddress }

constructor TAddress.Create;
begin
  inherited;
  FPart := TAddressPartList.Create;
end;

destructor TAddress.Destroy;
begin
  FPart.Free;
  FPeriod.free;
  inherited;
end;

procedure TAddress.Assign(oSource : TAdvObject);
begin
  inherited;
  FUse := TAddress(oSource).FUse;
  FText := TAddress(oSource).FText;
  FPart.Assign(TAddress(oSource).FPart);
  period := TAddress(oSource).period.Clone;
end;

function TAddress.Link : TAddress;
begin
  result := TAddress(inherited Link);
end;

function TAddress.Clone : TAddress;
begin
  result := TAddress(inherited Clone);
end;

{ TAddress }

Procedure TAddress.SetUse(value : TAddressUse);
begin
  FUse := value;
end;

Procedure TAddress.SetText(value : String);
begin
  FText := value;
end;

Procedure TAddress.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ THumanNamePart }

constructor THumanNamePart.Create;
begin
  inherited;
end;

destructor THumanNamePart.Destroy;
begin
  inherited;
end;

procedure THumanNamePart.Assign(oSource : TAdvObject);
begin
  inherited;
  FType_ := THumanNamePart(oSource).FType_;
  FValue := THumanNamePart(oSource).FValue;
end;

function THumanNamePart.Link : THumanNamePart;
begin
  result := THumanNamePart(inherited Link);
end;

function THumanNamePart.Clone : THumanNamePart;
begin
  result := THumanNamePart(inherited Clone);
end;

{ THumanNamePart }

Procedure THumanNamePart.SetType_(value : TNamePartType);
begin
  FType_ := value;
end;

Procedure THumanNamePart.SetValue(value : String);
begin
  FValue := value;
end;


{ THumanNamePartList }
function THumanNamePartList.Count: Integer;
begin
  result := Inherited Count;
end;

function THumanNamePartList.GetItemN(index: Integer): THumanNamePart;
begin
  result := THumanNamePart(ObjectByIndex[index]);
end;

function THumanNamePartList.IndexOf(value: THumanNamePart): Integer;
begin
  result := IndexByReference(value);
end;

function THumanNamePartList.Item(index: Integer): THumanNamePart;
begin
  result := THumanNamePart(ObjectByIndex[index]);
end;


{ THumanName }

constructor THumanName.Create;
begin
  inherited;
  FPart := THumanNamePartList.Create;
end;

destructor THumanName.Destroy;
begin
  FPart.Free;
  FPeriod.free;
  inherited;
end;

procedure THumanName.Assign(oSource : TAdvObject);
begin
  inherited;
  FUse := THumanName(oSource).FUse;
  FText := THumanName(oSource).FText;
  FPart.Assign(THumanName(oSource).FPart);
  period := THumanName(oSource).period.Clone;
end;

function THumanName.Link : THumanName;
begin
  result := THumanName(inherited Link);
end;

function THumanName.Clone : THumanName;
begin
  result := THumanName(inherited Clone);
end;

{ THumanName }

Procedure THumanName.SetUse(value : TNameUse);
begin
  FUse := value;
end;

Procedure THumanName.SetText(value : String);
begin
  FText := value;
end;

Procedure THumanName.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ THumanId }

constructor THumanId.Create;
begin
  inherited;
end;

destructor THumanId.Destroy;
begin
  FType_.free;
  FIdentifier.free;
  FPeriod.free;
  FAssigner.free;
  inherited;
end;

procedure THumanId.Assign(oSource : TAdvObject);
begin
  inherited;
  type_ := THumanId(oSource).type_.Clone;
  identifier := THumanId(oSource).identifier.Clone;
  period := THumanId(oSource).period.Clone;
  assigner := THumanId(oSource).assigner.Clone;
end;

function THumanId.Link : THumanId;
begin
  result := THumanId(inherited Link);
end;

function THumanId.Clone : THumanId;
begin
  result := THumanId(inherited Clone);
end;

{ THumanId }

Procedure THumanId.SetType_(value : TCoding);
begin
  FType_.free;
  FType_ := value;
end;

Procedure THumanId.SetIdentifier(value : TIdentifier);
begin
  FIdentifier.free;
  FIdentifier := value;
end;

Procedure THumanId.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;

Procedure THumanId.SetAssigner(value : TFHIRResourceReference{TOrganization});
begin
  FAssigner.free;
  FAssigner := value;
end;


{ TAddressList }
function TAddressList.Count: Integer;
begin
  result := Inherited Count;
end;

function TAddressList.GetItemN(index: Integer): TAddress;
begin
  result := TAddress(ObjectByIndex[index]);
end;

function TAddressList.IndexOf(value: TAddress): Integer;
begin
  result := IndexByReference(value);
end;

function TAddressList.Item(index: Integer): TAddress;
begin
  result := TAddress(ObjectByIndex[index]);
end;


{ TContactList }
function TContactList.Count: Integer;
begin
  result := Inherited Count;
end;

function TContactList.GetItemN(index: Integer): TContact;
begin
  result := TContact(ObjectByIndex[index]);
end;

function TContactList.IndexOf(value: TContact): Integer;
begin
  result := IndexByReference(value);
end;

function TContactList.Item(index: Integer): TContact;
begin
  result := TContact(ObjectByIndex[index]);
end;


{ TConformancePublisher }

constructor TConformancePublisher.Create;
begin
  inherited;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
end;

destructor TConformancePublisher.Destroy;
begin
  FAddress.Free;
  FContact.Free;
  inherited;
end;

procedure TConformancePublisher.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TConformancePublisher(oSource).FName;
  FAddress.Assign(TConformancePublisher(oSource).FAddress);
  FContact.Assign(TConformancePublisher(oSource).FContact);
end;

function TConformancePublisher.Link : TConformancePublisher;
begin
  result := TConformancePublisher(inherited Link);
end;

function TConformancePublisher.Clone : TConformancePublisher;
begin
  result := TConformancePublisher(inherited Clone);
end;

{ TConformancePublisher }

Procedure TConformancePublisher.SetName(value : String);
begin
  FName := value;
end;


{ TConformanceSoftware }

constructor TConformanceSoftware.Create;
begin
  inherited;
end;

destructor TConformanceSoftware.Destroy;
begin
  inherited;
end;

procedure TConformanceSoftware.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TConformanceSoftware(oSource).FName;
  FVersion := TConformanceSoftware(oSource).FVersion;
  FReleaseDate := TConformanceSoftware(oSource).FReleaseDate;
end;

function TConformanceSoftware.Link : TConformanceSoftware;
begin
  result := TConformanceSoftware(inherited Link);
end;

function TConformanceSoftware.Clone : TConformanceSoftware;
begin
  result := TConformanceSoftware(inherited Clone);
end;

{ TConformanceSoftware }

Procedure TConformanceSoftware.SetName(value : String);
begin
  FName := value;
end;

Procedure TConformanceSoftware.SetVersion(value : String);
begin
  FVersion := value;
end;

Procedure TConformanceSoftware.SetReleaseDate(value : String);
begin
  FReleaseDate := value;
end;


{ TConformanceOperation }

constructor TConformanceOperation.Create;
begin
  inherited;
end;

destructor TConformanceOperation.Destroy;
begin
  FTransaction.free;
  FSearch.free;
  FCreate_.free;
  inherited;
end;

procedure TConformanceOperation.Assign(oSource : TAdvObject);
begin
  inherited;
  FRead := TConformanceOperation(oSource).FRead;
  FVread := TConformanceOperation(oSource).FVread;
  FUpdate := TConformanceOperation(oSource).FUpdate;
  FDelete := TConformanceOperation(oSource).FDelete;
  FValidate := TConformanceOperation(oSource).FValidate;
  FHistory := TConformanceOperation(oSource).FHistory;
  transaction := TConformanceOperation(oSource).transaction.Clone;
  search := TConformanceOperation(oSource).search.Clone;
  create_ := TConformanceOperation(oSource).create_.Clone;
  FUpdates := TConformanceOperation(oSource).FUpdates;
  FSchema := TConformanceOperation(oSource).FSchema;
end;

function TConformanceOperation.Link : TConformanceOperation;
begin
  result := TConformanceOperation(inherited Link);
end;

function TConformanceOperation.Clone : TConformanceOperation;
begin
  result := TConformanceOperation(inherited Clone);
end;

{ TConformanceOperation }

Procedure TConformanceOperation.SetRead(value : Boolean);
begin
  FRead := value;
end;

Procedure TConformanceOperation.SetVread(value : Boolean);
begin
  FVread := value;
end;

Procedure TConformanceOperation.SetUpdate(value : Boolean);
begin
  FUpdate := value;
end;

Procedure TConformanceOperation.SetDelete(value : Boolean);
begin
  FDelete := value;
end;

Procedure TConformanceOperation.SetValidate(value : Boolean);
begin
  FValidate := value;
end;

Procedure TConformanceOperation.SetHistory(value : Boolean);
begin
  FHistory := value;
end;

Procedure TConformanceOperation.SetTransaction(value : TConformanceOperationTransaction);
begin
  FTransaction.free;
  FTransaction := value;
end;

Procedure TConformanceOperation.SetSearch(value : TConformanceOperationSearch);
begin
  FSearch.free;
  FSearch := value;
end;

Procedure TConformanceOperation.SetCreate_(value : TConformanceOperationCreate);
begin
  FCreate_.free;
  FCreate_ := value;
end;

Procedure TConformanceOperation.SetUpdates(value : Boolean);
begin
  FUpdates := value;
end;

Procedure TConformanceOperation.SetSchema(value : Boolean);
begin
  FSchema := value;
end;


{ TConformanceOperationTransaction }

constructor TConformanceOperationTransaction.Create;
begin
  inherited;
  FName := TStringList.Create;
end;

destructor TConformanceOperationTransaction.Destroy;
begin
  FName.Free;
  inherited;
end;

procedure TConformanceOperationTransaction.Assign(oSource : TAdvObject);
begin
  inherited;
  FName.Assign(TConformanceOperationTransaction(oSource).FName);
end;

function TConformanceOperationTransaction.Link : TConformanceOperationTransaction;
begin
  result := TConformanceOperationTransaction(inherited Link);
end;

function TConformanceOperationTransaction.Clone : TConformanceOperationTransaction;
begin
  result := TConformanceOperationTransaction(inherited Clone);
end;

{ TConformanceOperationTransaction }


{ TConformanceOperationSearch }

constructor TConformanceOperationSearch.Create;
begin
  inherited;
  FParam := TStringList.Create;
end;

destructor TConformanceOperationSearch.Destroy;
begin
  FParam.Free;
  inherited;
end;

procedure TConformanceOperationSearch.Assign(oSource : TAdvObject);
begin
  inherited;
  FParam.Assign(TConformanceOperationSearch(oSource).FParam);
end;

function TConformanceOperationSearch.Link : TConformanceOperationSearch;
begin
  result := TConformanceOperationSearch(inherited Link);
end;

function TConformanceOperationSearch.Clone : TConformanceOperationSearch;
begin
  result := TConformanceOperationSearch(inherited Clone);
end;

{ TConformanceOperationSearch }


{ TConformanceOperationCreate }

constructor TConformanceOperationCreate.Create;
begin
  inherited;
end;

destructor TConformanceOperationCreate.Destroy;
begin
  inherited;
end;

procedure TConformanceOperationCreate.Assign(oSource : TAdvObject);
begin
  inherited;
  FId := TConformanceOperationCreate(oSource).FId;
end;

function TConformanceOperationCreate.Link : TConformanceOperationCreate;
begin
  result := TConformanceOperationCreate(inherited Link);
end;

function TConformanceOperationCreate.Clone : TConformanceOperationCreate;
begin
  result := TConformanceOperationCreate(inherited Clone);
end;

{ TConformanceOperationCreate }

Procedure TConformanceOperationCreate.SetId(value : String);
begin
  FId := value;
end;


{ TConformance }

constructor TConformance.Create;
begin
  inherited;
end;

destructor TConformance.Destroy;
begin
  FPublisher.free;
  FSoftware.free;
  FResource.free;
  FOperation.free;
  inherited;
end;

function TConformance.GetResourceType : TFHIRResourceType;
begin
  result := frtConformance;
end;

procedure TConformance.Assign(oSource : TAdvObject);
begin
  inherited;
  FDate := TConformance(oSource).FDate;
  publisher := TConformance(oSource).publisher.Clone;
  software := TConformance(oSource).software.Clone;
  FMode := TConformance(oSource).FMode;
  resource := TConformance(oSource).resource.Clone;
  operation := TConformance(oSource).operation.Clone;
end;

function TConformance.Link : TConformance;
begin
  result := TConformance(inherited Link);
end;

function TConformance.Clone : TConformance;
begin
  result := TConformance(inherited Clone);
end;

{ TConformance }

Procedure TConformance.SetDate(value : String);
begin
  FDate := value;
end;

Procedure TConformance.SetPublisher(value : TConformancePublisher);
begin
  FPublisher.free;
  FPublisher := value;
end;

Procedure TConformance.SetSoftware(value : TConformanceSoftware);
begin
  FSoftware.free;
  FSoftware := value;
end;

Procedure TConformance.SetMode(value : TRestfulConformanceMode);
begin
  FMode := value;
end;

Procedure TConformance.SetResource(value : TConstraint);
begin
  FResource.free;
  FResource := value;
end;

Procedure TConformance.SetOperation(value : TConformanceOperation);
begin
  FOperation.free;
  FOperation := value;
end;


{ TDocumentAuthor }

constructor TDocumentAuthor.Create;
begin
  inherited;
end;

destructor TDocumentAuthor.Destroy;
begin
  FParty.free;
  inherited;
end;

procedure TDocumentAuthor.Assign(oSource : TAdvObject);
begin
  inherited;
  FTime := TDocumentAuthor(oSource).FTime;
  party := TDocumentAuthor(oSource).party.Clone;
end;

function TDocumentAuthor.Link : TDocumentAuthor;
begin
  result := TDocumentAuthor(inherited Link);
end;

function TDocumentAuthor.Clone : TDocumentAuthor;
begin
  result := TDocumentAuthor(inherited Clone);
end;

{ TDocumentAuthor }

Procedure TDocumentAuthor.SetTime(value : String);
begin
  FTime := value;
end;

Procedure TDocumentAuthor.SetParty(value : TFHIRResourceReference{Resource});
begin
  FParty.free;
  FParty := value;
end;


{ TDocumentAttestor }

constructor TDocumentAttestor.Create;
begin
  inherited;
end;

destructor TDocumentAttestor.Destroy;
begin
  FParty.free;
  inherited;
end;

procedure TDocumentAttestor.Assign(oSource : TAdvObject);
begin
  inherited;
  FMode := TDocumentAttestor(oSource).FMode;
  FTime := TDocumentAttestor(oSource).FTime;
  party := TDocumentAttestor(oSource).party.Clone;
end;

function TDocumentAttestor.Link : TDocumentAttestor;
begin
  result := TDocumentAttestor(inherited Link);
end;

function TDocumentAttestor.Clone : TDocumentAttestor;
begin
  result := TDocumentAttestor(inherited Clone);
end;

{ TDocumentAttestor }

Procedure TDocumentAttestor.SetMode(value : TDocumentAuthenticationMode);
begin
  FMode := value;
end;

Procedure TDocumentAttestor.SetTime(value : String);
begin
  FTime := value;
end;

Procedure TDocumentAttestor.SetParty(value : TFHIRResourceReference{TPerson});
begin
  FParty.free;
  FParty := value;
end;


{ TDocumentSectionList }
function TDocumentSectionList.Count: Integer;
begin
  result := Inherited Count;
end;

function TDocumentSectionList.GetItemN(index: Integer): TDocumentSection;
begin
  result := TDocumentSection(ObjectByIndex[index]);
end;

function TDocumentSectionList.IndexOf(value: TDocumentSection): Integer;
begin
  result := IndexByReference(value);
end;

function TDocumentSectionList.Item(index: Integer): TDocumentSection;
begin
  result := TDocumentSection(ObjectByIndex[index]);
end;


{ TDocumentSection }

constructor TDocumentSection.Create;
begin
  inherited;
  FSection := TDocumentSectionList.Create;
end;

destructor TDocumentSection.Destroy;
begin
  FType_.free;
  FAuthor.free;
  FEnterer.free;
  FSubject.free;
  FInformant.free;
  FContent.free;
  FSection.Free;
  inherited;
end;

procedure TDocumentSection.Assign(oSource : TAdvObject);
begin
  inherited;
  type_ := TDocumentSection(oSource).type_.Clone;
  FInstant := TDocumentSection(oSource).FInstant;
  author := TDocumentSection(oSource).author.Clone;
  enterer := TDocumentSection(oSource).enterer.Clone;
  subject := TDocumentSection(oSource).subject.Clone;
  informant := TDocumentSection(oSource).informant.Clone;
  content := TDocumentSection(oSource).content.Clone;
  FSection.Assign(TDocumentSection(oSource).FSection);
end;

function TDocumentSection.Link : TDocumentSection;
begin
  result := TDocumentSection(inherited Link);
end;

function TDocumentSection.Clone : TDocumentSection;
begin
  result := TDocumentSection(inherited Clone);
end;

{ TDocumentSection }

Procedure TDocumentSection.SetType_(value : TCodeableConcept);
begin
  FType_.free;
  FType_ := value;
end;

Procedure TDocumentSection.SetInstant(value : TDateTime);
begin
  FInstant := value;
end;

Procedure TDocumentSection.SetAuthor(value : TDocumentSectionAuthor);
begin
  FAuthor.free;
  FAuthor := value;
end;

Procedure TDocumentSection.SetEnterer(value : TFHIRResourceReference{Resource});
begin
  FEnterer.free;
  FEnterer := value;
end;

Procedure TDocumentSection.SetSubject(value : TFHIRResourceReference{Resource});
begin
  FSubject.free;
  FSubject := value;
end;

Procedure TDocumentSection.SetInformant(value : TFHIRResourceReference{TPerson});
begin
  FInformant.free;
  FInformant := value;
end;

Procedure TDocumentSection.SetContent(value : TFHIRResourceReference{Resource});
begin
  FContent.free;
  FContent := value;
end;


{ TDocumentSectionAuthor }

constructor TDocumentSectionAuthor.Create;
begin
  inherited;
end;

destructor TDocumentSectionAuthor.Destroy;
begin
  FParty.free;
  inherited;
end;

procedure TDocumentSectionAuthor.Assign(oSource : TAdvObject);
begin
  inherited;
  FTime := TDocumentSectionAuthor(oSource).FTime;
  party := TDocumentSectionAuthor(oSource).party.Clone;
end;

function TDocumentSectionAuthor.Link : TDocumentSectionAuthor;
begin
  result := TDocumentSectionAuthor(inherited Link);
end;

function TDocumentSectionAuthor.Clone : TDocumentSectionAuthor;
begin
  result := TDocumentSectionAuthor(inherited Clone);
end;

{ TDocumentSectionAuthor }

Procedure TDocumentSectionAuthor.SetTime(value : String);
begin
  FTime := value;
end;

Procedure TDocumentSectionAuthor.SetParty(value : TFHIRResourceReference{Resource});
begin
  FParty.free;
  FParty := value;
end;


{ TDocumentAuthorList }
function TDocumentAuthorList.Count: Integer;
begin
  result := Inherited Count;
end;

function TDocumentAuthorList.GetItemN(index: Integer): TDocumentAuthor;
begin
  result := TDocumentAuthor(ObjectByIndex[index]);
end;

function TDocumentAuthorList.IndexOf(value: TDocumentAuthor): Integer;
begin
  result := IndexByReference(value);
end;

function TDocumentAuthorList.Item(index: Integer): TDocumentAuthor;
begin
  result := TDocumentAuthor(ObjectByIndex[index]);
end;


{ TDocumentAttestorList }
function TDocumentAttestorList.Count: Integer;
begin
  result := Inherited Count;
end;

function TDocumentAttestorList.GetItemN(index: Integer): TDocumentAttestor;
begin
  result := TDocumentAttestor(ObjectByIndex[index]);
end;

function TDocumentAttestorList.IndexOf(value: TDocumentAttestor): Integer;
begin
  result := IndexByReference(value);
end;

function TDocumentAttestorList.Item(index: Integer): TDocumentAttestor;
begin
  result := TDocumentAttestor(ObjectByIndex[index]);
end;


{ TDocument }

constructor TDocument.Create;
begin
  inherited;
  FAuthor := TDocumentAuthorList.Create;
  FAttestor := TDocumentAttestorList.Create;
  FRecipient := TFHIRResourceReferenceList{Resource}.Create;
  FSection := TDocumentSectionList.Create;
end;

destructor TDocument.Destroy;
begin
  FType_.free;
  FSubject.free;
  FAuthor.Free;
  FAttestor.Free;
  FRecipient.Free;
  FCustodian.free;
  FEvent.free;
  FEncounter.free;
  FSection.Free;
  inherited;
end;

function TDocument.GetResourceType : TFHIRResourceType;
begin
  result := frtDocument;
end;

procedure TDocument.Assign(oSource : TAdvObject);
begin
  inherited;
  FInstant := TDocument(oSource).FInstant;
  type_ := TDocument(oSource).type_.Clone;
  FTitle := TDocument(oSource).FTitle;
  FSetId := TDocument(oSource).FSetId;
  FVersion := TDocument(oSource).FVersion;
  FReplaces := TDocument(oSource).FReplaces;
  subject := TDocument(oSource).subject.Clone;
  FAuthor.Assign(TDocument(oSource).FAuthor);
  FAttestor.Assign(TDocument(oSource).FAttestor);
  FRecipient.Assign(TDocument(oSource).FRecipient);
  custodian := TDocument(oSource).custodian.Clone;
  event := TDocument(oSource).event.Clone;
  encounter := TDocument(oSource).encounter.Clone;
  FSection.Assign(TDocument(oSource).FSection);
end;

function TDocument.Link : TDocument;
begin
  result := TDocument(inherited Link);
end;

function TDocument.Clone : TDocument;
begin
  result := TDocument(inherited Clone);
end;

{ TDocument }

Procedure TDocument.SetInstant(value : TDateTime);
begin
  FInstant := value;
end;

Procedure TDocument.SetType_(value : TCodeableConcept);
begin
  FType_.free;
  FType_ := value;
end;

Procedure TDocument.SetTitle(value : String);
begin
  FTitle := value;
end;

Procedure TDocument.SetSetId(value : String);
begin
  FSetId := value;
end;

Procedure TDocument.SetVersion(value : Integer);
begin
  FVersion := value;
end;

Procedure TDocument.SetReplaces(value : String);
begin
  FReplaces := value;
end;

Procedure TDocument.SetSubject(value : TFHIRResourceReference{Resource});
begin
  FSubject.free;
  FSubject := value;
end;

Procedure TDocument.SetCustodian(value : TFHIRResourceReference{TOrganization});
begin
  FCustodian.free;
  FCustodian := value;
end;

Procedure TDocument.SetEvent(value : TFHIRResourceReference{Resource});
begin
  FEvent.free;
  FEvent := value;
end;

Procedure TDocument.SetEncounter(value : TFHIRResourceReference{Resource});
begin
  FEncounter.free;
  FEncounter := value;
end;


{ TMessageResponse }

constructor TMessageResponse.Create;
begin
  inherited;
end;

destructor TMessageResponse.Destroy;
begin
  inherited;
end;

procedure TMessageResponse.Assign(oSource : TAdvObject);
begin
  inherited;
  FId := TMessageResponse(oSource).FId;
  FCode := TMessageResponse(oSource).FCode;
  FDuplicate := TMessageResponse(oSource).FDuplicate;
end;

function TMessageResponse.Link : TMessageResponse;
begin
  result := TMessageResponse(inherited Link);
end;

function TMessageResponse.Clone : TMessageResponse;
begin
  result := TMessageResponse(inherited Clone);
end;

{ TMessageResponse }

Procedure TMessageResponse.SetId(value : String);
begin
  FId := value;
end;

Procedure TMessageResponse.SetCode(value : TResponseCode);
begin
  FCode := value;
end;

Procedure TMessageResponse.SetDuplicate(value : Boolean);
begin
  FDuplicate := value;
end;


{ TMessage }

constructor TMessage.Create;
begin
  inherited;
end;

destructor TMessage.Destroy;
begin
  FResponse.free;
  FSource.free;
  FDestination.free;
  FEnterer.free;
  FAuthor.free;
  FResponsible.free;
  FEffective.free;
  FReason.free;
  FData.free;
  inherited;
end;

function TMessage.GetResourceType : TFHIRResourceType;
begin
  result := frtMessage;
end;

procedure TMessage.Assign(oSource : TAdvObject);
begin
  inherited;
  FThreadId := TMessage(oSource).FThreadId;
  FInstant := TMessage(oSource).FInstant;
  FEvent := TMessage(oSource).FEvent;
  response := TMessage(oSource).response.Clone;
  source := TMessage(oSource).source.Clone;
  destination := TMessage(oSource).destination.Clone;
  enterer := TMessage(oSource).enterer.Clone;
  author := TMessage(oSource).author.Clone;
  responsible := TMessage(oSource).responsible.Clone;
  effective := TMessage(oSource).effective.Clone;
  reason := TMessage(oSource).reason.Clone;
  data := TMessage(oSource).data.Clone;
end;

function TMessage.Link : TMessage;
begin
  result := TMessage(inherited Link);
end;

function TMessage.Clone : TMessage;
begin
  result := TMessage(inherited Clone);
end;

{ TMessage }

Procedure TMessage.SetThreadId(value : String);
begin
  FThreadId := value;
end;

Procedure TMessage.SetInstant(value : TDateTime);
begin
  FInstant := value;
end;

Procedure TMessage.SetEvent(value : String);
begin
  FEvent := value;
end;

Procedure TMessage.SetResponse(value : TMessageResponse);
begin
  FResponse.free;
  FResponse := value;
end;

Procedure TMessage.SetSource(value : TFHIRResourceReference{TDevice});
begin
  FSource.free;
  FSource := value;
end;

Procedure TMessage.SetDestination(value : TFHIRResourceReference{TDevice});
begin
  FDestination.free;
  FDestination := value;
end;

Procedure TMessage.SetEnterer(value : TFHIRResourceReference{Resource});
begin
  FEnterer.free;
  FEnterer := value;
end;

Procedure TMessage.SetAuthor(value : TFHIRResourceReference{Resource});
begin
  FAuthor.free;
  FAuthor := value;
end;

Procedure TMessage.SetResponsible(value : TFHIRResourceReference{Resource});
begin
  FResponsible.free;
  FResponsible := value;
end;

Procedure TMessage.SetEffective(value : TInterval_dateTime);
begin
  FEffective.free;
  FEffective := value;
end;

Procedure TMessage.SetReason(value : TCodeableConcept);
begin
  FReason.free;
  FReason := value;
end;

Procedure TMessage.SetData(value : TFHIRResourceReference{Resource});
begin
  FData.free;
  FData := value;
end;


{ TMessageConformancePublisher }

constructor TMessageConformancePublisher.Create;
begin
  inherited;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
end;

destructor TMessageConformancePublisher.Destroy;
begin
  FAddress.Free;
  FContact.Free;
  inherited;
end;

procedure TMessageConformancePublisher.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TMessageConformancePublisher(oSource).FName;
  FAddress.Assign(TMessageConformancePublisher(oSource).FAddress);
  FContact.Assign(TMessageConformancePublisher(oSource).FContact);
end;

function TMessageConformancePublisher.Link : TMessageConformancePublisher;
begin
  result := TMessageConformancePublisher(inherited Link);
end;

function TMessageConformancePublisher.Clone : TMessageConformancePublisher;
begin
  result := TMessageConformancePublisher(inherited Clone);
end;

{ TMessageConformancePublisher }

Procedure TMessageConformancePublisher.SetName(value : String);
begin
  FName := value;
end;


{ TMessageConformanceSoftware }

constructor TMessageConformanceSoftware.Create;
begin
  inherited;
end;

destructor TMessageConformanceSoftware.Destroy;
begin
  inherited;
end;

procedure TMessageConformanceSoftware.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TMessageConformanceSoftware(oSource).FName;
  FVersion := TMessageConformanceSoftware(oSource).FVersion;
  FReleaseDate := TMessageConformanceSoftware(oSource).FReleaseDate;
end;

function TMessageConformanceSoftware.Link : TMessageConformanceSoftware;
begin
  result := TMessageConformanceSoftware(inherited Link);
end;

function TMessageConformanceSoftware.Clone : TMessageConformanceSoftware;
begin
  result := TMessageConformanceSoftware(inherited Clone);
end;

{ TMessageConformanceSoftware }

Procedure TMessageConformanceSoftware.SetName(value : String);
begin
  FName := value;
end;

Procedure TMessageConformanceSoftware.SetVersion(value : String);
begin
  FVersion := value;
end;

Procedure TMessageConformanceSoftware.SetReleaseDate(value : String);
begin
  FReleaseDate := value;
end;


{ TMessageConformanceEvent }

constructor TMessageConformanceEvent.Create;
begin
  inherited;
end;

destructor TMessageConformanceEvent.Destroy;
begin
  FRequest.free;
  FResponse.free;
  inherited;
end;

procedure TMessageConformanceEvent.Assign(oSource : TAdvObject);
begin
  inherited;
  FCode := TMessageConformanceEvent(oSource).FCode;
  FResource := TMessageConformanceEvent(oSource).FResource;
  FMode := TMessageConformanceEvent(oSource).FMode;
  request := TMessageConformanceEvent(oSource).request.Clone;
  response := TMessageConformanceEvent(oSource).response.Clone;
end;

function TMessageConformanceEvent.Link : TMessageConformanceEvent;
begin
  result := TMessageConformanceEvent(inherited Link);
end;

function TMessageConformanceEvent.Clone : TMessageConformanceEvent;
begin
  result := TMessageConformanceEvent(inherited Clone);
end;

{ TMessageConformanceEvent }

Procedure TMessageConformanceEvent.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TMessageConformanceEvent.SetResource(value : String);
begin
  FResource := value;
end;

Procedure TMessageConformanceEvent.SetMode(value : TMessageConformanceEventMode);
begin
  FMode := value;
end;

Procedure TMessageConformanceEvent.SetRequest(value : TMessageConformanceEventRequest);
begin
  FRequest.free;
  FRequest := value;
end;

Procedure TMessageConformanceEvent.SetResponse(value : TMessageConformanceEventResponse);
begin
  FResponse.free;
  FResponse := value;
end;


{ TConstraintList }
function TConstraintList.Count: Integer;
begin
  result := Inherited Count;
end;

function TConstraintList.GetItemN(index: Integer): TConstraint;
begin
  result := TConstraint(ObjectByIndex[index]);
end;

function TConstraintList.IndexOf(value: TConstraint): Integer;
begin
  result := IndexByReference(value);
end;

function TConstraintList.Item(index: Integer): TConstraint;
begin
  result := TConstraint(ObjectByIndex[index]);
end;


{ TMessageConformanceEventRequest }

constructor TMessageConformanceEventRequest.Create;
begin
  inherited;
  FResource := TConstraintList.Create;
end;

destructor TMessageConformanceEventRequest.Destroy;
begin
  FResource.Free;
  inherited;
end;

procedure TMessageConformanceEventRequest.Assign(oSource : TAdvObject);
begin
  inherited;
  FResource.Assign(TMessageConformanceEventRequest(oSource).FResource);
end;

function TMessageConformanceEventRequest.Link : TMessageConformanceEventRequest;
begin
  result := TMessageConformanceEventRequest(inherited Link);
end;

function TMessageConformanceEventRequest.Clone : TMessageConformanceEventRequest;
begin
  result := TMessageConformanceEventRequest(inherited Clone);
end;

{ TMessageConformanceEventRequest }


{ TMessageConformanceEventResponse }

constructor TMessageConformanceEventResponse.Create;
begin
  inherited;
  FResource := TConstraintList.Create;
end;

destructor TMessageConformanceEventResponse.Destroy;
begin
  FResource.Free;
  inherited;
end;

procedure TMessageConformanceEventResponse.Assign(oSource : TAdvObject);
begin
  inherited;
  FResource.Assign(TMessageConformanceEventResponse(oSource).FResource);
end;

function TMessageConformanceEventResponse.Link : TMessageConformanceEventResponse;
begin
  result := TMessageConformanceEventResponse(inherited Link);
end;

function TMessageConformanceEventResponse.Clone : TMessageConformanceEventResponse;
begin
  result := TMessageConformanceEventResponse(inherited Clone);
end;

{ TMessageConformanceEventResponse }


{ TMessageConformanceEventList }
function TMessageConformanceEventList.Count: Integer;
begin
  result := Inherited Count;
end;

function TMessageConformanceEventList.GetItemN(index: Integer): TMessageConformanceEvent;
begin
  result := TMessageConformanceEvent(ObjectByIndex[index]);
end;

function TMessageConformanceEventList.IndexOf(value: TMessageConformanceEvent): Integer;
begin
  result := IndexByReference(value);
end;

function TMessageConformanceEventList.Item(index: Integer): TMessageConformanceEvent;
begin
  result := TMessageConformanceEvent(ObjectByIndex[index]);
end;


{ TMessageConformance }

constructor TMessageConformance.Create;
begin
  inherited;
  FEvent := TMessageConformanceEventList.Create;
end;

destructor TMessageConformance.Destroy;
begin
  FPublisher.free;
  FSoftware.free;
  FEvent.Free;
  inherited;
end;

function TMessageConformance.GetResourceType : TFHIRResourceType;
begin
  result := frtMessageConformance;
end;

procedure TMessageConformance.Assign(oSource : TAdvObject);
begin
  inherited;
  FDate := TMessageConformance(oSource).FDate;
  publisher := TMessageConformance(oSource).publisher.Clone;
  software := TMessageConformance(oSource).software.Clone;
  FEvent.Assign(TMessageConformance(oSource).FEvent);
end;

function TMessageConformance.Link : TMessageConformance;
begin
  result := TMessageConformance(inherited Link);
end;

function TMessageConformance.Clone : TMessageConformance;
begin
  result := TMessageConformance(inherited Clone);
end;

{ TMessageConformance }

Procedure TMessageConformance.SetDate(value : String);
begin
  FDate := value;
end;

Procedure TMessageConformance.SetPublisher(value : TMessageConformancePublisher);
begin
  FPublisher.free;
  FPublisher := value;
end;

Procedure TMessageConformance.SetSoftware(value : TMessageConformanceSoftware);
begin
  FSoftware.free;
  FSoftware := value;
end;


{ TCodeableConceptList }
function TCodeableConceptList.Count: Integer;
begin
  result := Inherited Count;
end;

function TCodeableConceptList.GetItemN(index: Integer): TCodeableConcept;
begin
  result := TCodeableConcept(ObjectByIndex[index]);
end;

function TCodeableConceptList.IndexOf(value: TCodeableConcept): Integer;
begin
  result := IndexByReference(value);
end;

function TCodeableConceptList.Item(index: Integer): TCodeableConcept;
begin
  result := TCodeableConcept(ObjectByIndex[index]);
end;


{ THumanIdList }
function THumanIdList.Count: Integer;
begin
  result := Inherited Count;
end;

function THumanIdList.GetItemN(index: Integer): THumanId;
begin
  result := THumanId(ObjectByIndex[index]);
end;

function THumanIdList.IndexOf(value: THumanId): Integer;
begin
  result := IndexByReference(value);
end;

function THumanIdList.Item(index: Integer): THumanId;
begin
  result := THumanId(ObjectByIndex[index]);
end;


{ TAgent }

constructor TAgent.Create;
begin
  inherited;
  FRole := TCodeableConceptList.Create;
  FIdentifier := THumanIdList.Create;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
end;

destructor TAgent.Destroy;
begin
  FPerson.free;
  FOrganization.free;
  FRole.Free;
  FPeriod.free;
  FIdentifier.Free;
  FAddress.Free;
  FContact.Free;
  inherited;
end;

function TAgent.GetResourceType : TFHIRResourceType;
begin
  result := frtAgent;
end;

procedure TAgent.Assign(oSource : TAdvObject);
begin
  inherited;
  person := TAgent(oSource).person.Clone;
  organization := TAgent(oSource).organization.Clone;
  FRole.Assign(TAgent(oSource).FRole);
  period := TAgent(oSource).period.Clone;
  FIdentifier.Assign(TAgent(oSource).FIdentifier);
  FAddress.Assign(TAgent(oSource).FAddress);
  FContact.Assign(TAgent(oSource).FContact);
end;

function TAgent.Link : TAgent;
begin
  result := TAgent(inherited Link);
end;

function TAgent.Clone : TAgent;
begin
  result := TAgent(inherited Clone);
end;

{ TAgent }

Procedure TAgent.SetPerson(value : TFHIRResourceReference{TPerson});
begin
  FPerson.free;
  FPerson := value;
end;

Procedure TAgent.SetOrganization(value : TFHIRResourceReference{TOrganization});
begin
  FOrganization.free;
  FOrganization := value;
end;

Procedure TAgent.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ TAnimalRelatedEntity }

constructor TAnimalRelatedEntity.Create;
begin
  inherited;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
end;

destructor TAnimalRelatedEntity.Destroy;
begin
  FId.free;
  FRole.free;
  FName.free;
  FAddress.Free;
  FContact.Free;
  inherited;
end;

procedure TAnimalRelatedEntity.Assign(oSource : TAdvObject);
begin
  inherited;
  id := TAnimalRelatedEntity(oSource).id.Clone;
  role := TAnimalRelatedEntity(oSource).role.Clone;
  name := TAnimalRelatedEntity(oSource).name.Clone;
  FAddress.Assign(TAnimalRelatedEntity(oSource).FAddress);
  FContact.Assign(TAnimalRelatedEntity(oSource).FContact);
end;

function TAnimalRelatedEntity.Link : TAnimalRelatedEntity;
begin
  result := TAnimalRelatedEntity(inherited Link);
end;

function TAnimalRelatedEntity.Clone : TAnimalRelatedEntity;
begin
  result := TAnimalRelatedEntity(inherited Clone);
end;

{ TAnimalRelatedEntity }

Procedure TAnimalRelatedEntity.SetId(value : THumanId);
begin
  FId.free;
  FId := value;
end;

Procedure TAnimalRelatedEntity.SetRole(value : TCodeableConcept);
begin
  FRole.free;
  FRole := value;
end;

Procedure TAnimalRelatedEntity.SetName(value : THumanName);
begin
  FName.free;
  FName := value;
end;


{ THumanNameList }
function THumanNameList.Count: Integer;
begin
  result := Inherited Count;
end;

function THumanNameList.GetItemN(index: Integer): THumanName;
begin
  result := THumanName(ObjectByIndex[index]);
end;

function THumanNameList.IndexOf(value: THumanName): Integer;
begin
  result := IndexByReference(value);
end;

function THumanNameList.Item(index: Integer): THumanName;
begin
  result := THumanName(ObjectByIndex[index]);
end;


{ TAnimalRelatedEntityList }
function TAnimalRelatedEntityList.Count: Integer;
begin
  result := Inherited Count;
end;

function TAnimalRelatedEntityList.GetItemN(index: Integer): TAnimalRelatedEntity;
begin
  result := TAnimalRelatedEntity(ObjectByIndex[index]);
end;

function TAnimalRelatedEntityList.IndexOf(value: TAnimalRelatedEntity): Integer;
begin
  result := IndexByReference(value);
end;

function TAnimalRelatedEntityList.Item(index: Integer): TAnimalRelatedEntity;
begin
  result := TAnimalRelatedEntity(ObjectByIndex[index]);
end;


{ TAnimal }

constructor TAnimal.Create;
begin
  inherited;
  FIdentifier := THumanIdList.Create;
  FName := THumanNameList.Create;
  FRelatedEntity := TAnimalRelatedEntityList.Create;
end;

destructor TAnimal.Destroy;
begin
  FIdentifier.Free;
  FName.Free;
  FSpecies.free;
  FStrain.free;
  FGender.free;
  FRelatedEntity.Free;
  inherited;
end;

function TAnimal.GetResourceType : TFHIRResourceType;
begin
  result := frtAnimal;
end;

procedure TAnimal.Assign(oSource : TAdvObject);
begin
  inherited;
  FIdentifier.Assign(TAnimal(oSource).FIdentifier);
  FName.Assign(TAnimal(oSource).FName);
  FDob := TAnimal(oSource).FDob;
  species := TAnimal(oSource).species.Clone;
  strain := TAnimal(oSource).strain.Clone;
  gender := TAnimal(oSource).gender.Clone;
  FRelatedEntity.Assign(TAnimal(oSource).FRelatedEntity);
end;

function TAnimal.Link : TAnimal;
begin
  result := TAnimal(inherited Link);
end;

function TAnimal.Clone : TAnimal;
begin
  result := TAnimal(inherited Clone);
end;

{ TAnimal }

Procedure TAnimal.SetDob(value : String);
begin
  FDob := value;
end;

Procedure TAnimal.SetSpecies(value : TCodeableConcept);
begin
  FSpecies.free;
  FSpecies := value;
end;

Procedure TAnimal.SetStrain(value : TCodeableConcept);
begin
  FStrain.free;
  FStrain := value;
end;

Procedure TAnimal.SetGender(value : TCodeableConcept);
begin
  FGender.free;
  FGender := value;
end;


{ TPrescriptionDispense }

constructor TPrescriptionDispense.Create;
begin
  inherited;
end;

destructor TPrescriptionDispense.Destroy;
begin
  FQuantity.free;
  FDispenser.free;
  inherited;
end;

procedure TPrescriptionDispense.Assign(oSource : TAdvObject);
begin
  inherited;
  FRepeats := TPrescriptionDispense(oSource).FRepeats;
  quantity := TPrescriptionDispense(oSource).quantity.Clone;
  dispenser := TPrescriptionDispense(oSource).dispenser.Clone;
end;

function TPrescriptionDispense.Link : TPrescriptionDispense;
begin
  result := TPrescriptionDispense(inherited Link);
end;

function TPrescriptionDispense.Clone : TPrescriptionDispense;
begin
  result := TPrescriptionDispense(inherited Clone);
end;

{ TPrescriptionDispense }

Procedure TPrescriptionDispense.SetRepeats(value : Integer);
begin
  FRepeats := value;
end;

Procedure TPrescriptionDispense.SetQuantity(value : TQuantity);
begin
  FQuantity.free;
  FQuantity := value;
end;

Procedure TPrescriptionDispense.SetDispenser(value : TFHIRResourceReference{Resource});
begin
  FDispenser.free;
  FDispenser := value;
end;


{ TPrescriptionMedicineActiveIngredientList }
function TPrescriptionMedicineActiveIngredientList.Count: Integer;
begin
  result := Inherited Count;
end;

function TPrescriptionMedicineActiveIngredientList.GetItemN(index: Integer): TPrescriptionMedicineActiveIngredient;
begin
  result := TPrescriptionMedicineActiveIngredient(ObjectByIndex[index]);
end;

function TPrescriptionMedicineActiveIngredientList.IndexOf(value: TPrescriptionMedicineActiveIngredient): Integer;
begin
  result := IndexByReference(value);
end;

function TPrescriptionMedicineActiveIngredientList.Item(index: Integer): TPrescriptionMedicineActiveIngredient;
begin
  result := TPrescriptionMedicineActiveIngredient(ObjectByIndex[index]);
end;


{ TPrescriptionMedicineInactiveIngredientList }
function TPrescriptionMedicineInactiveIngredientList.Count: Integer;
begin
  result := Inherited Count;
end;

function TPrescriptionMedicineInactiveIngredientList.GetItemN(index: Integer): TPrescriptionMedicineInactiveIngredient;
begin
  result := TPrescriptionMedicineInactiveIngredient(ObjectByIndex[index]);
end;

function TPrescriptionMedicineInactiveIngredientList.IndexOf(value: TPrescriptionMedicineInactiveIngredient): Integer;
begin
  result := IndexByReference(value);
end;

function TPrescriptionMedicineInactiveIngredientList.Item(index: Integer): TPrescriptionMedicineInactiveIngredient;
begin
  result := TPrescriptionMedicineInactiveIngredient(ObjectByIndex[index]);
end;


{ TPrescriptionMedicine }

constructor TPrescriptionMedicine.Create;
begin
  inherited;
  FActiveIngredient := TPrescriptionMedicineActiveIngredientList.Create;
  FInactiveIngredient := TPrescriptionMedicineInactiveIngredientList.Create;
end;

destructor TPrescriptionMedicine.Destroy;
begin
  FProductCode.free;
  FActiveIngredient.Free;
  FInactiveIngredient.Free;
  inherited;
end;

procedure TPrescriptionMedicine.Assign(oSource : TAdvObject);
begin
  inherited;
  productCode := TPrescriptionMedicine(oSource).productCode.Clone;
  FDescription := TPrescriptionMedicine(oSource).FDescription;
  FActiveIngredient.Assign(TPrescriptionMedicine(oSource).FActiveIngredient);
  FInactiveIngredient.Assign(TPrescriptionMedicine(oSource).FInactiveIngredient);
end;

function TPrescriptionMedicine.Link : TPrescriptionMedicine;
begin
  result := TPrescriptionMedicine(inherited Link);
end;

function TPrescriptionMedicine.Clone : TPrescriptionMedicine;
begin
  result := TPrescriptionMedicine(inherited Clone);
end;

{ TPrescriptionMedicine }

Procedure TPrescriptionMedicine.SetProductCode(value : TCoding);
begin
  FProductCode.free;
  FProductCode := value;
end;

Procedure TPrescriptionMedicine.SetDescription(value : String);
begin
  FDescription := value;
end;


{ TPrescriptionMedicineActiveIngredient }

constructor TPrescriptionMedicineActiveIngredient.Create;
begin
  inherited;
end;

destructor TPrescriptionMedicineActiveIngredient.Destroy;
begin
  FProductCode.free;
  FQuantity.free;
  inherited;
end;

procedure TPrescriptionMedicineActiveIngredient.Assign(oSource : TAdvObject);
begin
  inherited;
  productCode := TPrescriptionMedicineActiveIngredient(oSource).productCode.Clone;
  quantity := TPrescriptionMedicineActiveIngredient(oSource).quantity.Clone;
end;

function TPrescriptionMedicineActiveIngredient.Link : TPrescriptionMedicineActiveIngredient;
begin
  result := TPrescriptionMedicineActiveIngredient(inherited Link);
end;

function TPrescriptionMedicineActiveIngredient.Clone : TPrescriptionMedicineActiveIngredient;
begin
  result := TPrescriptionMedicineActiveIngredient(inherited Clone);
end;

{ TPrescriptionMedicineActiveIngredient }

Procedure TPrescriptionMedicineActiveIngredient.SetProductCode(value : TCoding);
begin
  FProductCode.free;
  FProductCode := value;
end;

Procedure TPrescriptionMedicineActiveIngredient.SetQuantity(value : TRatio);
begin
  FQuantity.free;
  FQuantity := value;
end;


{ TPrescriptionMedicineInactiveIngredient }

constructor TPrescriptionMedicineInactiveIngredient.Create;
begin
  inherited;
end;

destructor TPrescriptionMedicineInactiveIngredient.Destroy;
begin
  FProductCode.free;
  FQuantity.free;
  inherited;
end;

procedure TPrescriptionMedicineInactiveIngredient.Assign(oSource : TAdvObject);
begin
  inherited;
  productCode := TPrescriptionMedicineInactiveIngredient(oSource).productCode.Clone;
  quantity := TPrescriptionMedicineInactiveIngredient(oSource).quantity.Clone;
end;

function TPrescriptionMedicineInactiveIngredient.Link : TPrescriptionMedicineInactiveIngredient;
begin
  result := TPrescriptionMedicineInactiveIngredient(inherited Link);
end;

function TPrescriptionMedicineInactiveIngredient.Clone : TPrescriptionMedicineInactiveIngredient;
begin
  result := TPrescriptionMedicineInactiveIngredient(inherited Clone);
end;

{ TPrescriptionMedicineInactiveIngredient }

Procedure TPrescriptionMedicineInactiveIngredient.SetProductCode(value : TCoding);
begin
  FProductCode.free;
  FProductCode := value;
end;

Procedure TPrescriptionMedicineInactiveIngredient.SetQuantity(value : TRatio);
begin
  FQuantity.free;
  FQuantity := value;
end;


{ TPrescriptionAdministrationRequestDosageInstructionList }
function TPrescriptionAdministrationRequestDosageInstructionList.Count: Integer;
begin
  result := Inherited Count;
end;

function TPrescriptionAdministrationRequestDosageInstructionList.GetItemN(index: Integer): TPrescriptionAdministrationRequestDosageInstruction;
begin
  result := TPrescriptionAdministrationRequestDosageInstruction(ObjectByIndex[index]);
end;

function TPrescriptionAdministrationRequestDosageInstructionList.IndexOf(value: TPrescriptionAdministrationRequestDosageInstruction): Integer;
begin
  result := IndexByReference(value);
end;

function TPrescriptionAdministrationRequestDosageInstructionList.Item(index: Integer): TPrescriptionAdministrationRequestDosageInstruction;
begin
  result := TPrescriptionAdministrationRequestDosageInstruction(ObjectByIndex[index]);
end;


{ TPrescriptionAdministrationRequest }

constructor TPrescriptionAdministrationRequest.Create;
begin
  inherited;
  FDosageInstruction := TPrescriptionAdministrationRequestDosageInstructionList.Create;
end;

destructor TPrescriptionAdministrationRequest.Destroy;
begin
  FTotalPeriodicDosis.free;
  FDuration.free;
  FDosageInstruction.Free;
  inherited;
end;

procedure TPrescriptionAdministrationRequest.Assign(oSource : TAdvObject);
begin
  inherited;
  FDescription := TPrescriptionAdministrationRequest(oSource).FDescription;
  totalPeriodicDosis := TPrescriptionAdministrationRequest(oSource).totalPeriodicDosis.Clone;
  FStart := TPrescriptionAdministrationRequest(oSource).FStart;
  FEnd_ := TPrescriptionAdministrationRequest(oSource).FEnd_;
  duration := TPrescriptionAdministrationRequest(oSource).duration.Clone;
  FNumberOfAdministrations := TPrescriptionAdministrationRequest(oSource).FNumberOfAdministrations;
  FDosageInstruction.Assign(TPrescriptionAdministrationRequest(oSource).FDosageInstruction);
end;

function TPrescriptionAdministrationRequest.Link : TPrescriptionAdministrationRequest;
begin
  result := TPrescriptionAdministrationRequest(inherited Link);
end;

function TPrescriptionAdministrationRequest.Clone : TPrescriptionAdministrationRequest;
begin
  result := TPrescriptionAdministrationRequest(inherited Clone);
end;

{ TPrescriptionAdministrationRequest }

Procedure TPrescriptionAdministrationRequest.SetDescription(value : String);
begin
  FDescription := value;
end;

Procedure TPrescriptionAdministrationRequest.SetTotalPeriodicDosis(value : TRatio);
begin
  FTotalPeriodicDosis.free;
  FTotalPeriodicDosis := value;
end;

Procedure TPrescriptionAdministrationRequest.SetStart(value : String);
begin
  FStart := value;
end;

Procedure TPrescriptionAdministrationRequest.SetEnd_(value : String);
begin
  FEnd_ := value;
end;

Procedure TPrescriptionAdministrationRequest.SetDuration(value : TQuantity);
begin
  FDuration.free;
  FDuration := value;
end;

Procedure TPrescriptionAdministrationRequest.SetNumberOfAdministrations(value : Integer);
begin
  FNumberOfAdministrations := value;
end;


{ TScheduleList }
function TScheduleList.Count: Integer;
begin
  result := Inherited Count;
end;

function TScheduleList.GetItemN(index: Integer): TSchedule;
begin
  result := TSchedule(ObjectByIndex[index]);
end;

function TScheduleList.IndexOf(value: TSchedule): Integer;
begin
  result := IndexByReference(value);
end;

function TScheduleList.Item(index: Integer): TSchedule;
begin
  result := TSchedule(ObjectByIndex[index]);
end;


{ TPrescriptionAdministrationRequestDosageInstruction }

constructor TPrescriptionAdministrationRequestDosageInstruction.Create;
begin
  inherited;
  FPrecondition := TCodeableConceptList.Create;
  FAdditionalInstruction := TCodeableConceptList.Create;
  FSchedule := TScheduleList.Create;
end;

destructor TPrescriptionAdministrationRequestDosageInstruction.Destroy;
begin
  FPrecondition.Free;
  FAdditionalInstruction.Free;
  FRoute.free;
  FDose.free;
  FRate.free;
  FSchedule.Free;
  inherited;
end;

procedure TPrescriptionAdministrationRequestDosageInstruction.Assign(oSource : TAdvObject);
begin
  inherited;
  FPrecondition.Assign(TPrescriptionAdministrationRequestDosageInstruction(oSource).FPrecondition);
  FPrn := TPrescriptionAdministrationRequestDosageInstruction(oSource).FPrn;
  FAdditionalInstruction.Assign(TPrescriptionAdministrationRequestDosageInstruction(oSource).FAdditionalInstruction);
  route := TPrescriptionAdministrationRequestDosageInstruction(oSource).route.Clone;
  dose := TPrescriptionAdministrationRequestDosageInstruction(oSource).dose.Clone;
  rate := TPrescriptionAdministrationRequestDosageInstruction(oSource).rate.Clone;
  FSchedule.Assign(TPrescriptionAdministrationRequestDosageInstruction(oSource).FSchedule);
end;

function TPrescriptionAdministrationRequestDosageInstruction.Link : TPrescriptionAdministrationRequestDosageInstruction;
begin
  result := TPrescriptionAdministrationRequestDosageInstruction(inherited Link);
end;

function TPrescriptionAdministrationRequestDosageInstruction.Clone : TPrescriptionAdministrationRequestDosageInstruction;
begin
  result := TPrescriptionAdministrationRequestDosageInstruction(inherited Clone);
end;

{ TPrescriptionAdministrationRequestDosageInstruction }

Procedure TPrescriptionAdministrationRequestDosageInstruction.SetPrn(value : TBooleanYesNo);
begin
  FPrn := value;
end;

Procedure TPrescriptionAdministrationRequestDosageInstruction.SetRoute(value : TCodeableConcept);
begin
  FRoute.free;
  FRoute := value;
end;

Procedure TPrescriptionAdministrationRequestDosageInstruction.SetDose(value : TFHIRType);
begin
  FDose.free;
  FDose := value;
end;

Procedure TPrescriptionAdministrationRequestDosageInstruction.SetRate(value : TQuantity);
begin
  FRate.free;
  FRate := value;
end;


{ TPrescription }

constructor TPrescription.Create;
begin
  inherited;
  FIdentifier := THumanIdList.Create;
end;

destructor TPrescription.Destroy;
begin
  FIdentifier.Free;
  FPatient.free;
  FPrescriber.free;
  FDispense.free;
  FMedicine.free;
  FAdministrationRequest.free;
  FReason.free;
  inherited;
end;

function TPrescription.GetResourceType : TFHIRResourceType;
begin
  result := frtPrescription;
end;

procedure TPrescription.Assign(oSource : TAdvObject);
begin
  inherited;
  FIdentifier.Assign(TPrescription(oSource).FIdentifier);
  FStatus := TPrescription(oSource).FStatus;
  patient := TPrescription(oSource).patient.Clone;
  prescriber := TPrescription(oSource).prescriber.Clone;
  FPrescribed := TPrescription(oSource).FPrescribed;
  dispense := TPrescription(oSource).dispense.Clone;
  medicine := TPrescription(oSource).medicine.Clone;
  administrationRequest := TPrescription(oSource).administrationRequest.Clone;
  reason := TPrescription(oSource).reason.Clone;
end;

function TPrescription.Link : TPrescription;
begin
  result := TPrescription(inherited Link);
end;

function TPrescription.Clone : TPrescription;
begin
  result := TPrescription(inherited Clone);
end;

{ TPrescription }

Procedure TPrescription.SetStatus(value : TPrescriptionStatus);
begin
  FStatus := value;
end;

Procedure TPrescription.SetPatient(value : TFHIRResourceReference{TPatient});
begin
  FPatient.free;
  FPatient := value;
end;

Procedure TPrescription.SetPrescriber(value : TFHIRResourceReference{TAgent});
begin
  FPrescriber.free;
  FPrescriber := value;
end;

Procedure TPrescription.SetPrescribed(value : String);
begin
  FPrescribed := value;
end;

Procedure TPrescription.SetDispense(value : TPrescriptionDispense);
begin
  FDispense.free;
  FDispense := value;
end;

Procedure TPrescription.SetMedicine(value : TPrescriptionMedicine);
begin
  FMedicine.free;
  FMedicine := value;
end;

Procedure TPrescription.SetAdministrationRequest(value : TPrescriptionAdministrationRequest);
begin
  FAdministrationRequest.free;
  FAdministrationRequest := value;
end;

Procedure TPrescription.SetReason(value : TCodeableConcept);
begin
  FReason.free;
  FReason := value;
end;


{ TPatient }

constructor TPatient.Create;
begin
  inherited;
  FLink_ := TFHIRResourceReferenceList{TPatient}.Create;
  FIdentifier := THumanIdList.Create;
end;

destructor TPatient.Destroy;
begin
  FLink_.Free;
  FPerson.free;
  FAnimal.free;
  FProvider.free;
  FIdentifier.Free;
  FDiet.free;
  FConfidentiality.free;
  FRecordLocation.free;
  inherited;
end;

function TPatient.GetResourceType : TFHIRResourceType;
begin
  result := frtPatient;
end;

procedure TPatient.Assign(oSource : TAdvObject);
begin
  inherited;
  FLink_.Assign(TPatient(oSource).FLink_);
  FActive := TPatient(oSource).FActive;
  person := TPatient(oSource).person.Clone;
  animal := TPatient(oSource).animal.Clone;
  provider := TPatient(oSource).provider.Clone;
  FIdentifier.Assign(TPatient(oSource).FIdentifier);
  diet := TPatient(oSource).diet.Clone;
  confidentiality := TPatient(oSource).confidentiality.Clone;
  recordLocation := TPatient(oSource).recordLocation.Clone;
end;

function TPatient.Link : TPatient;
begin
  result := TPatient(inherited Link);
end;

function TPatient.Clone : TPatient;
begin
  result := TPatient(inherited Clone);
end;

{ TPatient }

Procedure TPatient.SetActive(value : Boolean);
begin
  FActive := value;
end;

Procedure TPatient.SetPerson(value : TFHIRResourceReference{TPerson});
begin
  FPerson.free;
  FPerson := value;
end;

Procedure TPatient.SetAnimal(value : TFHIRResourceReference{TAnimal});
begin
  FAnimal.free;
  FAnimal := value;
end;

Procedure TPatient.SetProvider(value : TFHIRResourceReference{TOrganization});
begin
  FProvider.free;
  FProvider := value;
end;

Procedure TPatient.SetDiet(value : TCodeableConcept);
begin
  FDiet.free;
  FDiet := value;
end;

Procedure TPatient.SetConfidentiality(value : TCodeableConcept);
begin
  FConfidentiality.free;
  FConfidentiality := value;
end;

Procedure TPatient.SetRecordLocation(value : TCodeableConcept);
begin
  FRecordLocation.free;
  FRecordLocation := value;
end;


{ TOrganizationName }

constructor TOrganizationName.Create;
begin
  inherited;
end;

destructor TOrganizationName.Destroy;
begin
  FPeriod.free;
  inherited;
end;

procedure TOrganizationName.Assign(oSource : TAdvObject);
begin
  inherited;
  FValue := TOrganizationName(oSource).FValue;
  period := TOrganizationName(oSource).period.Clone;
end;

function TOrganizationName.Link : TOrganizationName;
begin
  result := TOrganizationName(inherited Link);
end;

function TOrganizationName.Clone : TOrganizationName;
begin
  result := TOrganizationName(inherited Clone);
end;

{ TOrganizationName }

Procedure TOrganizationName.SetValue(value : String);
begin
  FValue := value;
end;

Procedure TOrganizationName.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ TOrganizationAccreditation }

constructor TOrganizationAccreditation.Create;
begin
  inherited;
end;

destructor TOrganizationAccreditation.Destroy;
begin
  FId.free;
  FCode.free;
  FInstitution.free;
  FPeriod.free;
  inherited;
end;

procedure TOrganizationAccreditation.Assign(oSource : TAdvObject);
begin
  inherited;
  id := TOrganizationAccreditation(oSource).id.Clone;
  code := TOrganizationAccreditation(oSource).code.Clone;
  institution := TOrganizationAccreditation(oSource).institution.Clone;
  period := TOrganizationAccreditation(oSource).period.Clone;
end;

function TOrganizationAccreditation.Link : TOrganizationAccreditation;
begin
  result := TOrganizationAccreditation(inherited Link);
end;

function TOrganizationAccreditation.Clone : TOrganizationAccreditation;
begin
  result := TOrganizationAccreditation(inherited Clone);
end;

{ TOrganizationAccreditation }

Procedure TOrganizationAccreditation.SetId(value : TIdentifier);
begin
  FId.free;
  FId := value;
end;

Procedure TOrganizationAccreditation.SetCode(value : TCodeableConcept);
begin
  FCode.free;
  FCode := value;
end;

Procedure TOrganizationAccreditation.SetInstitution(value : TFHIRResourceReference{TOrganization});
begin
  FInstitution.free;
  FInstitution := value;
end;

Procedure TOrganizationAccreditation.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ TOrganizationRelatedOrganization }

constructor TOrganizationRelatedOrganization.Create;
begin
  inherited;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
end;

destructor TOrganizationRelatedOrganization.Destroy;
begin
  FId.free;
  FCode.free;
  FAddress.Free;
  FContact.Free;
  FPeriod.free;
  inherited;
end;

procedure TOrganizationRelatedOrganization.Assign(oSource : TAdvObject);
begin
  inherited;
  id := TOrganizationRelatedOrganization(oSource).id.Clone;
  code := TOrganizationRelatedOrganization(oSource).code.Clone;
  FName := TOrganizationRelatedOrganization(oSource).FName;
  FAddress.Assign(TOrganizationRelatedOrganization(oSource).FAddress);
  FContact.Assign(TOrganizationRelatedOrganization(oSource).FContact);
  period := TOrganizationRelatedOrganization(oSource).period.Clone;
end;

function TOrganizationRelatedOrganization.Link : TOrganizationRelatedOrganization;
begin
  result := TOrganizationRelatedOrganization(inherited Link);
end;

function TOrganizationRelatedOrganization.Clone : TOrganizationRelatedOrganization;
begin
  result := TOrganizationRelatedOrganization(inherited Clone);
end;

{ TOrganizationRelatedOrganization }

Procedure TOrganizationRelatedOrganization.SetId(value : THumanId);
begin
  FId.free;
  FId := value;
end;

Procedure TOrganizationRelatedOrganization.SetCode(value : TCodeableConcept);
begin
  FCode.free;
  FCode := value;
end;

Procedure TOrganizationRelatedOrganization.SetName(value : String);
begin
  FName := value;
end;

Procedure TOrganizationRelatedOrganization.SetPeriod(value : TInterval_dateTime);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ TOrganizationNameList }
function TOrganizationNameList.Count: Integer;
begin
  result := Inherited Count;
end;

function TOrganizationNameList.GetItemN(index: Integer): TOrganizationName;
begin
  result := TOrganizationName(ObjectByIndex[index]);
end;

function TOrganizationNameList.IndexOf(value: TOrganizationName): Integer;
begin
  result := IndexByReference(value);
end;

function TOrganizationNameList.Item(index: Integer): TOrganizationName;
begin
  result := TOrganizationName(ObjectByIndex[index]);
end;


{ TOrganizationAccreditationList }
function TOrganizationAccreditationList.Count: Integer;
begin
  result := Inherited Count;
end;

function TOrganizationAccreditationList.GetItemN(index: Integer): TOrganizationAccreditation;
begin
  result := TOrganizationAccreditation(ObjectByIndex[index]);
end;

function TOrganizationAccreditationList.IndexOf(value: TOrganizationAccreditation): Integer;
begin
  result := IndexByReference(value);
end;

function TOrganizationAccreditationList.Item(index: Integer): TOrganizationAccreditation;
begin
  result := TOrganizationAccreditation(ObjectByIndex[index]);
end;


{ TOrganizationRelatedOrganizationList }
function TOrganizationRelatedOrganizationList.Count: Integer;
begin
  result := Inherited Count;
end;

function TOrganizationRelatedOrganizationList.GetItemN(index: Integer): TOrganizationRelatedOrganization;
begin
  result := TOrganizationRelatedOrganization(ObjectByIndex[index]);
end;

function TOrganizationRelatedOrganizationList.IndexOf(value: TOrganizationRelatedOrganization): Integer;
begin
  result := IndexByReference(value);
end;

function TOrganizationRelatedOrganizationList.Item(index: Integer): TOrganizationRelatedOrganization;
begin
  result := TOrganizationRelatedOrganization(ObjectByIndex[index]);
end;


{ TOrganization }

constructor TOrganization.Create;
begin
  inherited;
  FIdentifier := THumanIdList.Create;
  FName := TOrganizationNameList.Create;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
  FAccreditation := TOrganizationAccreditationList.Create;
  FRelatedOrganization := TOrganizationRelatedOrganizationList.Create;
end;

destructor TOrganization.Destroy;
begin
  FCode.free;
  FIndustryCode.free;
  FIdentifier.Free;
  FName.Free;
  FAddress.Free;
  FContact.Free;
  FAccreditation.Free;
  FRelatedOrganization.Free;
  inherited;
end;

function TOrganization.GetResourceType : TFHIRResourceType;
begin
  result := frtOrganization;
end;

procedure TOrganization.Assign(oSource : TAdvObject);
begin
  inherited;
  code := TOrganization(oSource).code.Clone;
  industryCode := TOrganization(oSource).industryCode.Clone;
  FIdentifier.Assign(TOrganization(oSource).FIdentifier);
  FName.Assign(TOrganization(oSource).FName);
  FAddress.Assign(TOrganization(oSource).FAddress);
  FContact.Assign(TOrganization(oSource).FContact);
  FAccreditation.Assign(TOrganization(oSource).FAccreditation);
  FRelatedOrganization.Assign(TOrganization(oSource).FRelatedOrganization);
end;

function TOrganization.Link : TOrganization;
begin
  result := TOrganization(inherited Link);
end;

function TOrganization.Clone : TOrganization;
begin
  result := TOrganization(inherited Clone);
end;

{ TOrganization }

Procedure TOrganization.SetCode(value : TCodeableConcept);
begin
  FCode.free;
  FCode := value;
end;

Procedure TOrganization.SetIndustryCode(value : TCodeableConcept);
begin
  FIndustryCode.free;
  FIndustryCode := value;
end;


{ TDocumentConformancePublisher }

constructor TDocumentConformancePublisher.Create;
begin
  inherited;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
end;

destructor TDocumentConformancePublisher.Destroy;
begin
  FAddress.Free;
  FContact.Free;
  inherited;
end;

procedure TDocumentConformancePublisher.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TDocumentConformancePublisher(oSource).FName;
  FAddress.Assign(TDocumentConformancePublisher(oSource).FAddress);
  FContact.Assign(TDocumentConformancePublisher(oSource).FContact);
end;

function TDocumentConformancePublisher.Link : TDocumentConformancePublisher;
begin
  result := TDocumentConformancePublisher(inherited Link);
end;

function TDocumentConformancePublisher.Clone : TDocumentConformancePublisher;
begin
  result := TDocumentConformancePublisher(inherited Clone);
end;

{ TDocumentConformancePublisher }

Procedure TDocumentConformancePublisher.SetName(value : String);
begin
  FName := value;
end;


{ TDocumentConformanceSoftware }

constructor TDocumentConformanceSoftware.Create;
begin
  inherited;
end;

destructor TDocumentConformanceSoftware.Destroy;
begin
  inherited;
end;

procedure TDocumentConformanceSoftware.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TDocumentConformanceSoftware(oSource).FName;
  FVersion := TDocumentConformanceSoftware(oSource).FVersion;
  FReleaseDate := TDocumentConformanceSoftware(oSource).FReleaseDate;
end;

function TDocumentConformanceSoftware.Link : TDocumentConformanceSoftware;
begin
  result := TDocumentConformanceSoftware(inherited Link);
end;

function TDocumentConformanceSoftware.Clone : TDocumentConformanceSoftware;
begin
  result := TDocumentConformanceSoftware(inherited Clone);
end;

{ TDocumentConformanceSoftware }

Procedure TDocumentConformanceSoftware.SetName(value : String);
begin
  FName := value;
end;

Procedure TDocumentConformanceSoftware.SetVersion(value : String);
begin
  FVersion := value;
end;

Procedure TDocumentConformanceSoftware.SetReleaseDate(value : String);
begin
  FReleaseDate := value;
end;


{ TDocumentConformanceDocument }

constructor TDocumentConformanceDocument.Create;
begin
  inherited;
  FResource := TConstraintList.Create;
end;

destructor TDocumentConformanceDocument.Destroy;
begin
  FResource.Free;
  inherited;
end;

procedure TDocumentConformanceDocument.Assign(oSource : TAdvObject);
begin
  inherited;
  FName := TDocumentConformanceDocument(oSource).FName;
  FPurpose := TDocumentConformanceDocument(oSource).FPurpose;
  FResource.Assign(TDocumentConformanceDocument(oSource).FResource);
end;

function TDocumentConformanceDocument.Link : TDocumentConformanceDocument;
begin
  result := TDocumentConformanceDocument(inherited Link);
end;

function TDocumentConformanceDocument.Clone : TDocumentConformanceDocument;
begin
  result := TDocumentConformanceDocument(inherited Clone);
end;

{ TDocumentConformanceDocument }

Procedure TDocumentConformanceDocument.SetName(value : String);
begin
  FName := value;
end;

Procedure TDocumentConformanceDocument.SetPurpose(value : String);
begin
  FPurpose := value;
end;


{ TDocumentConformanceDocumentList }
function TDocumentConformanceDocumentList.Count: Integer;
begin
  result := Inherited Count;
end;

function TDocumentConformanceDocumentList.GetItemN(index: Integer): TDocumentConformanceDocument;
begin
  result := TDocumentConformanceDocument(ObjectByIndex[index]);
end;

function TDocumentConformanceDocumentList.IndexOf(value: TDocumentConformanceDocument): Integer;
begin
  result := IndexByReference(value);
end;

function TDocumentConformanceDocumentList.Item(index: Integer): TDocumentConformanceDocument;
begin
  result := TDocumentConformanceDocument(ObjectByIndex[index]);
end;


{ TDocumentConformance }

constructor TDocumentConformance.Create;
begin
  inherited;
  FDocument := TDocumentConformanceDocumentList.Create;
end;

destructor TDocumentConformance.Destroy;
begin
  FPublisher.free;
  FSoftware.free;
  FDocument.Free;
  inherited;
end;

function TDocumentConformance.GetResourceType : TFHIRResourceType;
begin
  result := frtDocumentConformance;
end;

procedure TDocumentConformance.Assign(oSource : TAdvObject);
begin
  inherited;
  FDate := TDocumentConformance(oSource).FDate;
  publisher := TDocumentConformance(oSource).publisher.Clone;
  software := TDocumentConformance(oSource).software.Clone;
  FDocument.Assign(TDocumentConformance(oSource).FDocument);
end;

function TDocumentConformance.Link : TDocumentConformance;
begin
  result := TDocumentConformance(inherited Link);
end;

function TDocumentConformance.Clone : TDocumentConformance;
begin
  result := TDocumentConformance(inherited Clone);
end;

{ TDocumentConformance }

Procedure TDocumentConformance.SetDate(value : String);
begin
  FDate := value;
end;

Procedure TDocumentConformance.SetPublisher(value : TDocumentConformancePublisher);
begin
  FPublisher.free;
  FPublisher := value;
end;

Procedure TDocumentConformance.SetSoftware(value : TDocumentConformanceSoftware);
begin
  FSoftware.free;
  FSoftware := value;
end;


{ TLabReportRequestDetail }

constructor TLabReportRequestDetail.Create;
begin
  inherited;
  FRequestTest := TCodeableConceptList.Create;
end;

destructor TLabReportRequestDetail.Destroy;
begin
  FRequestOrderId.free;
  FReceiverOrderId.free;
  FRequestTest.Free;
  FRequester.free;
  FClinicalInfo.free;
  inherited;
end;

procedure TLabReportRequestDetail.Assign(oSource : TAdvObject);
begin
  inherited;
  requestOrderId := TLabReportRequestDetail(oSource).requestOrderId.Clone;
  receiverOrderId := TLabReportRequestDetail(oSource).receiverOrderId.Clone;
  FRequestTest.Assign(TLabReportRequestDetail(oSource).FRequestTest);
  requester := TLabReportRequestDetail(oSource).requester.Clone;
  clinicalInfo := TLabReportRequestDetail(oSource).clinicalInfo.Clone;
end;

function TLabReportRequestDetail.Link : TLabReportRequestDetail;
begin
  result := TLabReportRequestDetail(inherited Link);
end;

function TLabReportRequestDetail.Clone : TLabReportRequestDetail;
begin
  result := TLabReportRequestDetail(inherited Clone);
end;

{ TLabReportRequestDetail }

Procedure TLabReportRequestDetail.SetRequestOrderId(value : TIdentifier);
begin
  FRequestOrderId.free;
  FRequestOrderId := value;
end;

Procedure TLabReportRequestDetail.SetReceiverOrderId(value : TIdentifier);
begin
  FReceiverOrderId.free;
  FReceiverOrderId := value;
end;

Procedure TLabReportRequestDetail.SetRequester(value : TFHIRResourceReference{Resource});
begin
  FRequester.free;
  FRequester := value;
end;

Procedure TLabReportRequestDetail.SetClinicalInfo(value : TFHIRResourceReference{Resource});
begin
  FClinicalInfo.free;
  FClinicalInfo := value;
end;


{ TLabReportResultGroupResultList }
function TLabReportResultGroupResultList.Count: Integer;
begin
  result := Inherited Count;
end;

function TLabReportResultGroupResultList.GetItemN(index: Integer): TLabReportResultGroupResult;
begin
  result := TLabReportResultGroupResult(ObjectByIndex[index]);
end;

function TLabReportResultGroupResultList.IndexOf(value: TLabReportResultGroupResult): Integer;
begin
  result := IndexByReference(value);
end;

function TLabReportResultGroupResultList.Item(index: Integer): TLabReportResultGroupResult;
begin
  result := TLabReportResultGroupResult(ObjectByIndex[index]);
end;


{ TLabReportResultGroup }

constructor TLabReportResultGroup.Create;
begin
  inherited;
  FResult := TLabReportResultGroupResultList.Create;
end;

destructor TLabReportResultGroup.Destroy;
begin
  FName.free;
  FSpecimen.free;
  FResult.Free;
  inherited;
end;

procedure TLabReportResultGroup.Assign(oSource : TAdvObject);
begin
  inherited;
  name := TLabReportResultGroup(oSource).name.Clone;
  specimen := TLabReportResultGroup(oSource).specimen.Clone;
  FResult.Assign(TLabReportResultGroup(oSource).FResult);
end;

function TLabReportResultGroup.Link : TLabReportResultGroup;
begin
  result := TLabReportResultGroup(inherited Link);
end;

function TLabReportResultGroup.Clone : TLabReportResultGroup;
begin
  result := TLabReportResultGroup(inherited Clone);
end;

{ TLabReportResultGroup }

Procedure TLabReportResultGroup.SetName(value : TCodeableConcept);
begin
  FName.free;
  FName := value;
end;

Procedure TLabReportResultGroup.SetSpecimen(value : TFHIRResourceReference{TSpecimen});
begin
  FSpecimen.free;
  FSpecimen := value;
end;


{ TLabReportResultGroupResultReferenceRangeList }
function TLabReportResultGroupResultReferenceRangeList.Count: Integer;
begin
  result := Inherited Count;
end;

function TLabReportResultGroupResultReferenceRangeList.GetItemN(index: Integer): TLabReportResultGroupResultReferenceRange;
begin
  result := TLabReportResultGroupResultReferenceRange(ObjectByIndex[index]);
end;

function TLabReportResultGroupResultReferenceRangeList.IndexOf(value: TLabReportResultGroupResultReferenceRange): Integer;
begin
  result := IndexByReference(value);
end;

function TLabReportResultGroupResultReferenceRangeList.Item(index: Integer): TLabReportResultGroupResultReferenceRange;
begin
  result := TLabReportResultGroupResultReferenceRange(ObjectByIndex[index]);
end;


{ TLabReportResultGroupResult }

constructor TLabReportResultGroupResult.Create;
begin
  inherited;
  FReferenceRange := TLabReportResultGroupResultReferenceRangeList.Create;
end;

destructor TLabReportResultGroupResult.Destroy;
begin
  FName.free;
  FValue.free;
  FReferenceRange.Free;
  inherited;
end;

procedure TLabReportResultGroupResult.Assign(oSource : TAdvObject);
begin
  inherited;
  name := TLabReportResultGroupResult(oSource).name.Clone;
  value := TLabReportResultGroupResult(oSource).value.Clone;
  FFlag := TLabReportResultGroupResult(oSource).FFlag;
  FStatus := TLabReportResultGroupResult(oSource).FStatus;
  FComments := TLabReportResultGroupResult(oSource).FComments;
  FReferenceRange.Assign(TLabReportResultGroupResult(oSource).FReferenceRange);
end;

function TLabReportResultGroupResult.Link : TLabReportResultGroupResult;
begin
  result := TLabReportResultGroupResult(inherited Link);
end;

function TLabReportResultGroupResult.Clone : TLabReportResultGroupResult;
begin
  result := TLabReportResultGroupResult(inherited Clone);
end;

{ TLabReportResultGroupResult }

Procedure TLabReportResultGroupResult.SetName(value : TCodeableConcept);
begin
  FName.free;
  FName := value;
end;

Procedure TLabReportResultGroupResult.SetValue(value : TFHIRType);
begin
  FValue.free;
  FValue := value;
end;

Procedure TLabReportResultGroupResult.SetFlag(value : TLabResultFlag);
begin
  FFlag := value;
end;

Procedure TLabReportResultGroupResult.SetStatus(value : TLabReportStatus);
begin
  FStatus := value;
end;

Procedure TLabReportResultGroupResult.SetComments(value : String);
begin
  FComments := value;
end;


{ TLabReportResultGroupResultReferenceRange }

constructor TLabReportResultGroupResultReferenceRange.Create;
begin
  inherited;
end;

destructor TLabReportResultGroupResultReferenceRange.Destroy;
begin
  FMeaning.free;
  FRange.free;
  inherited;
end;

procedure TLabReportResultGroupResultReferenceRange.Assign(oSource : TAdvObject);
begin
  inherited;
  meaning := TLabReportResultGroupResultReferenceRange(oSource).meaning.Clone;
  range := TLabReportResultGroupResultReferenceRange(oSource).range.Clone;
end;

function TLabReportResultGroupResultReferenceRange.Link : TLabReportResultGroupResultReferenceRange;
begin
  result := TLabReportResultGroupResultReferenceRange(inherited Link);
end;

function TLabReportResultGroupResultReferenceRange.Clone : TLabReportResultGroupResultReferenceRange;
begin
  result := TLabReportResultGroupResultReferenceRange(inherited Clone);
end;

{ TLabReportResultGroupResultReferenceRange }

Procedure TLabReportResultGroupResultReferenceRange.SetMeaning(value : TCodeableConcept);
begin
  FMeaning.free;
  FMeaning := value;
end;

Procedure TLabReportResultGroupResultReferenceRange.SetRange(value : TFHIRType);
begin
  FRange.free;
  FRange := value;
end;


{ TLabReportRequestDetailList }
function TLabReportRequestDetailList.Count: Integer;
begin
  result := Inherited Count;
end;

function TLabReportRequestDetailList.GetItemN(index: Integer): TLabReportRequestDetail;
begin
  result := TLabReportRequestDetail(ObjectByIndex[index]);
end;

function TLabReportRequestDetailList.IndexOf(value: TLabReportRequestDetail): Integer;
begin
  result := IndexByReference(value);
end;

function TLabReportRequestDetailList.Item(index: Integer): TLabReportRequestDetail;
begin
  result := TLabReportRequestDetail(ObjectByIndex[index]);
end;


{ TLabReportResultGroupList }
function TLabReportResultGroupList.Count: Integer;
begin
  result := Inherited Count;
end;

function TLabReportResultGroupList.GetItemN(index: Integer): TLabReportResultGroup;
begin
  result := TLabReportResultGroup(ObjectByIndex[index]);
end;

function TLabReportResultGroupList.IndexOf(value: TLabReportResultGroup): Integer;
begin
  result := IndexByReference(value);
end;

function TLabReportResultGroupList.Item(index: Integer): TLabReportResultGroup;
begin
  result := TLabReportResultGroup(ObjectByIndex[index]);
end;


{ TAttachmentList }
function TAttachmentList.Count: Integer;
begin
  result := Inherited Count;
end;

function TAttachmentList.GetItemN(index: Integer): TAttachment;
begin
  result := TAttachment(ObjectByIndex[index]);
end;

function TAttachmentList.IndexOf(value: TAttachment): Integer;
begin
  result := IndexByReference(value);
end;

function TAttachmentList.Item(index: Integer): TAttachment;
begin
  result := TAttachment(ObjectByIndex[index]);
end;


{ TLabReport }

constructor TLabReport.Create;
begin
  inherited;
  FRequestDetail := TLabReportRequestDetailList.Create;
  FSpecimen := TFHIRResourceReferenceList{TSpecimen}.Create;
  FResultGroup := TLabReportResultGroupList.Create;
  FCodedDiagnosis := TCodeableConceptList.Create;
  FRepresentation := TAttachmentList.Create;
end;

destructor TLabReport.Destroy;
begin
  FPatient.free;
  FAdmission.free;
  FLaboratory.free;
  FRequestDetail.Free;
  FReportName.free;
  FService.free;
  FSpecimen.Free;
  FResultGroup.Free;
  FConclusion.free;
  FCodedDiagnosis.Free;
  FRepresentation.Free;
  inherited;
end;

function TLabReport.GetResourceType : TFHIRResourceType;
begin
  result := frtLabReport;
end;

procedure TLabReport.Assign(oSource : TAdvObject);
begin
  inherited;
  FStatus := TLabReport(oSource).FStatus;
  FIssued := TLabReport(oSource).FIssued;
  patient := TLabReport(oSource).patient.Clone;
  admission := TLabReport(oSource).admission.Clone;
  laboratory := TLabReport(oSource).laboratory.Clone;
  FReportId := TLabReport(oSource).FReportId;
  FRequestDetail.Assign(TLabReport(oSource).FRequestDetail);
  reportName := TLabReport(oSource).reportName.Clone;
  service := TLabReport(oSource).service.Clone;
  FDiagnosticTime := TLabReport(oSource).FDiagnosticTime;
  FSpecimen.Assign(TLabReport(oSource).FSpecimen);
  FResultGroup.Assign(TLabReport(oSource).FResultGroup);
  conclusion := TLabReport(oSource).conclusion.Clone;
  FCodedDiagnosis.Assign(TLabReport(oSource).FCodedDiagnosis);
  FRepresentation.Assign(TLabReport(oSource).FRepresentation);
end;

function TLabReport.Link : TLabReport;
begin
  result := TLabReport(inherited Link);
end;

function TLabReport.Clone : TLabReport;
begin
  result := TLabReport(inherited Clone);
end;

{ TLabReport }

Procedure TLabReport.SetStatus(value : TLabReportStatus);
begin
  FStatus := value;
end;

Procedure TLabReport.SetIssued(value : TDateTime);
begin
  FIssued := value;
end;

Procedure TLabReport.SetPatient(value : TFHIRResourceReference{TPatient});
begin
  FPatient.free;
  FPatient := value;
end;

Procedure TLabReport.SetAdmission(value : TFHIRResourceReference{TAdmission});
begin
  FAdmission.free;
  FAdmission := value;
end;

Procedure TLabReport.SetLaboratory(value : TFHIRResourceReference{TOrganization});
begin
  FLaboratory.free;
  FLaboratory := value;
end;

Procedure TLabReport.SetReportId(value : String);
begin
  FReportId := value;
end;

Procedure TLabReport.SetReportName(value : TCodeableConcept);
begin
  FReportName.free;
  FReportName := value;
end;

Procedure TLabReport.SetService(value : TCodeableConcept);
begin
  FService.free;
  FService := value;
end;

Procedure TLabReport.SetDiagnosticTime(value : String);
begin
  FDiagnosticTime := value;
end;

Procedure TLabReport.SetConclusion(value : TNarrative);
begin
  FConclusion.free;
  FConclusion := value;
end;


{ TPersonQualification }

constructor TPersonQualification.Create;
begin
  inherited;
end;

destructor TPersonQualification.Destroy;
begin
  FId.free;
  FCode.free;
  FInstitution.free;
  FPeriod.free;
  inherited;
end;

procedure TPersonQualification.Assign(oSource : TAdvObject);
begin
  inherited;
  id := TPersonQualification(oSource).id.Clone;
  code := TPersonQualification(oSource).code.Clone;
  institution := TPersonQualification(oSource).institution.Clone;
  period := TPersonQualification(oSource).period.Clone;
end;

function TPersonQualification.Link : TPersonQualification;
begin
  result := TPersonQualification(inherited Link);
end;

function TPersonQualification.Clone : TPersonQualification;
begin
  result := TPersonQualification(inherited Clone);
end;

{ TPersonQualification }

Procedure TPersonQualification.SetId(value : TIdentifier);
begin
  FId.free;
  FId := value;
end;

Procedure TPersonQualification.SetCode(value : TCodeableConcept);
begin
  FCode.free;
  FCode := value;
end;

Procedure TPersonQualification.SetInstitution(value : TFHIRResourceReference{TOrganization});
begin
  FInstitution.free;
  FInstitution := value;
end;

Procedure TPersonQualification.SetPeriod(value : TInterval_date);
begin
  FPeriod.free;
  FPeriod := value;
end;


{ TPersonLanguage }

constructor TPersonLanguage.Create;
begin
  inherited;
end;

destructor TPersonLanguage.Destroy;
begin
  inherited;
end;

procedure TPersonLanguage.Assign(oSource : TAdvObject);
begin
  inherited;
  FCode := TPersonLanguage(oSource).FCode;
  FUse := TPersonLanguage(oSource).FUse;
end;

function TPersonLanguage.Link : TPersonLanguage;
begin
  result := TPersonLanguage(inherited Link);
end;

function TPersonLanguage.Clone : TPersonLanguage;
begin
  result := TPersonLanguage(inherited Clone);
end;

{ TPersonLanguage }

Procedure TPersonLanguage.SetCode(value : String);
begin
  FCode := value;
end;

Procedure TPersonLanguage.SetUse(value : TLanguageUse);
begin
  FUse := value;
end;


{ TPersonRelatedPerson }

constructor TPersonRelatedPerson.Create;
begin
  inherited;
  FContact := TContactList.Create;
end;

destructor TPersonRelatedPerson.Destroy;
begin
  FId.free;
  FRole.free;
  FName.free;
  FContact.Free;
  inherited;
end;

procedure TPersonRelatedPerson.Assign(oSource : TAdvObject);
begin
  inherited;
  id := TPersonRelatedPerson(oSource).id.Clone;
  role := TPersonRelatedPerson(oSource).role.Clone;
  name := TPersonRelatedPerson(oSource).name.Clone;
  FContact.Assign(TPersonRelatedPerson(oSource).FContact);
end;

function TPersonRelatedPerson.Link : TPersonRelatedPerson;
begin
  result := TPersonRelatedPerson(inherited Link);
end;

function TPersonRelatedPerson.Clone : TPersonRelatedPerson;
begin
  result := TPersonRelatedPerson(inherited Clone);
end;

{ TPersonRelatedPerson }

Procedure TPersonRelatedPerson.SetId(value : THumanId);
begin
  FId.free;
  FId := value;
end;

Procedure TPersonRelatedPerson.SetRole(value : TCodeableConcept);
begin
  FRole.free;
  FRole := value;
end;

Procedure TPersonRelatedPerson.SetName(value : THumanName);
begin
  FName.free;
  FName := value;
end;


{ TPersonQualificationList }
function TPersonQualificationList.Count: Integer;
begin
  result := Inherited Count;
end;

function TPersonQualificationList.GetItemN(index: Integer): TPersonQualification;
begin
  result := TPersonQualification(ObjectByIndex[index]);
end;

function TPersonQualificationList.IndexOf(value: TPersonQualification): Integer;
begin
  result := IndexByReference(value);
end;

function TPersonQualificationList.Item(index: Integer): TPersonQualification;
begin
  result := TPersonQualification(ObjectByIndex[index]);
end;


{ TPersonLanguageList }
function TPersonLanguageList.Count: Integer;
begin
  result := Inherited Count;
end;

function TPersonLanguageList.GetItemN(index: Integer): TPersonLanguage;
begin
  result := TPersonLanguage(ObjectByIndex[index]);
end;

function TPersonLanguageList.IndexOf(value: TPersonLanguage): Integer;
begin
  result := IndexByReference(value);
end;

function TPersonLanguageList.Item(index: Integer): TPersonLanguage;
begin
  result := TPersonLanguage(ObjectByIndex[index]);
end;


{ TPersonRelatedPersonList }
function TPersonRelatedPersonList.Count: Integer;
begin
  result := Inherited Count;
end;

function TPersonRelatedPersonList.GetItemN(index: Integer): TPersonRelatedPerson;
begin
  result := TPersonRelatedPerson(ObjectByIndex[index]);
end;

function TPersonRelatedPersonList.IndexOf(value: TPersonRelatedPerson): Integer;
begin
  result := IndexByReference(value);
end;

function TPersonRelatedPersonList.Item(index: Integer): TPersonRelatedPerson;
begin
  result := TPersonRelatedPerson(ObjectByIndex[index]);
end;


{ TPerson }

constructor TPerson.Create;
begin
  inherited;
  FIdentifier := THumanIdList.Create;
  FName := THumanNameList.Create;
  FAddress := TAddressList.Create;
  FContact := TContactList.Create;
  FQualification := TPersonQualificationList.Create;
  FLanguage := TPersonLanguageList.Create;
  FRelatedPerson := TPersonRelatedPersonList.Create;
end;

destructor TPerson.Destroy;
begin
  FIdentifier.Free;
  FName.Free;
  FAddress.Free;
  FContact.Free;
  FGender.free;
  FReligion.free;
  FQualification.Free;
  FLanguage.Free;
  FRelatedPerson.Free;
  inherited;
end;

function TPerson.GetResourceType : TFHIRResourceType;
begin
  result := frtPerson;
end;

procedure TPerson.Assign(oSource : TAdvObject);
begin
  inherited;
  FIdentifier.Assign(TPerson(oSource).FIdentifier);
  FName.Assign(TPerson(oSource).FName);
  FAddress.Assign(TPerson(oSource).FAddress);
  FContact.Assign(TPerson(oSource).FContact);
  FDob := TPerson(oSource).FDob;
  gender := TPerson(oSource).gender.Clone;
  religion := TPerson(oSource).religion.Clone;
  FQualification.Assign(TPerson(oSource).FQualification);
  FLanguage.Assign(TPerson(oSource).FLanguage);
  FRelatedPerson.Assign(TPerson(oSource).FRelatedPerson);
end;

function TPerson.Link : TPerson;
begin
  result := TPerson(inherited Link);
end;

function TPerson.Clone : TPerson;
begin
  result := TPerson(inherited Clone);
end;

{ TPerson }

Procedure TPerson.SetDob(value : String);
begin
  FDob := value;
end;

Procedure TPerson.SetGender(value : TCodeableConcept);
begin
  FGender.free;
  FGender := value;
end;

Procedure TPerson.SetReligion(value : TCodeableConcept);
begin
  FReligion.free;
  FReligion := value;
end;


end.

