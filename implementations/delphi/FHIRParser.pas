unit FHIRParser;

interface

// FHIR v0.01 generated 19:37 Apr 30, 2012

uses
  SysUtils, Classes, ActiveX, StringSupport, DateSupport, IdSoapMsXml, FHIRParserBase, FHIRBase, FHIRResources, MsXmlParser, JSON;

Type

  TFHIRXmlParser = class (TFHIRXmlParserBase)
  protected
    function ParseExtension(element : IXmlDomElement) : TExtension;
    function ParseConstraintElement(element : IXmlDomElement) : TConstraintElement;
    function ParseConstraintElementMapping(element : IXmlDomElement) : TConstraintElementMapping;
    function ParseConstraintElementAggregation(element : IXmlDomElement) : TConstraintElementAggregation;
    function ParseConstraintElementValue(element : IXmlDomElement) : TConstraintElementValue;
    function ParseConstraint(element : IXmlDomElement) : TConstraint;
    function ParseNarrativeImage(element : IXmlDomElement) : TNarrativeImage;
    function ParseNarrativeMap(element : IXmlDomElement) : TNarrativeMap;
    function ParseNarrative(element : IXmlDomElement) : TNarrative;
    function ParseCoding(element : IXmlDomElement) : TCoding;
    function ParseInterval_Quantity(element : IXmlDomElement) : TInterval_Quantity;
    function ParseInterval_DateTime(element : IXmlDomElement) : TInterval_DateTime;
    function ParseInterval_Date(element : IXmlDomElement) : TInterval_Date;
    function ParseQuantity(element : IXmlDomElement) : TQuantity;
    function ParseChoiceValue(element : IXmlDomElement) : TChoiceValue;
    function ParseChoice(element : IXmlDomElement) : TChoice;
    function ParseAttachment(element : IXmlDomElement) : TAttachment;
    function ParseRatio(element : IXmlDomElement) : TRatio;
    function ParseCodeableConcept(element : IXmlDomElement) : TCodeableConcept;
    function ParseIdentifier(element : IXmlDomElement) : TIdentifier;
    function ParseScheduleRepeat(element : IXmlDomElement) : TScheduleRepeat;
    function ParseSchedule(element : IXmlDomElement) : TSchedule;
    function ParseContact(element : IXmlDomElement) : TContact;
    function ParseAddressPart(element : IXmlDomElement) : TAddressPart;
    function ParseAddress(element : IXmlDomElement) : TAddress;
    function ParseHumanNamePart(element : IXmlDomElement) : THumanNamePart;
    function ParseHumanName(element : IXmlDomElement) : THumanName;
    function ParseHumanId(element : IXmlDomElement) : THumanId;
    function ParseConformancePublisher(element : IXmlDomElement) : TConformancePublisher;
    function ParseConformanceSoftware(element : IXmlDomElement) : TConformanceSoftware;
    function ParseConformanceOperation(element : IXmlDomElement) : TConformanceOperation;
    function ParseConformanceOperationTransaction(element : IXmlDomElement) : TConformanceOperationTransaction;
    function ParseConformanceOperationSearch(element : IXmlDomElement) : TConformanceOperationSearch;
    function ParseConformanceOperationCreate(element : IXmlDomElement) : TConformanceOperationCreate;
    function ParseConformance(element : IXmlDomElement) : TConformance;
    function ParseDocumentAuthor(element : IXmlDomElement) : TDocumentAuthor;
    function ParseDocumentAttestor(element : IXmlDomElement) : TDocumentAttestor;
    function ParseDocumentSection(element : IXmlDomElement) : TDocumentSection;
    function ParseDocumentSectionAuthor(element : IXmlDomElement) : TDocumentSectionAuthor;
    function ParseDocument(element : IXmlDomElement) : TDocument;
    function ParseMessageResponse(element : IXmlDomElement) : TMessageResponse;
    function ParseMessage(element : IXmlDomElement) : TMessage;
    function ParseMessageConformancePublisher(element : IXmlDomElement) : TMessageConformancePublisher;
    function ParseMessageConformanceSoftware(element : IXmlDomElement) : TMessageConformanceSoftware;
    function ParseMessageConformanceEvent(element : IXmlDomElement) : TMessageConformanceEvent;
    function ParseMessageConformanceEventRequest(element : IXmlDomElement) : TMessageConformanceEventRequest;
    function ParseMessageConformanceEventResponse(element : IXmlDomElement) : TMessageConformanceEventResponse;
    function ParseMessageConformance(element : IXmlDomElement) : TMessageConformance;
    function ParseAgent(element : IXmlDomElement) : TAgent;
    function ParseAnimalRelatedEntity(element : IXmlDomElement) : TAnimalRelatedEntity;
    function ParseAnimal(element : IXmlDomElement) : TAnimal;
    function ParsePrescriptionDispense(element : IXmlDomElement) : TPrescriptionDispense;
    function ParsePrescriptionMedicine(element : IXmlDomElement) : TPrescriptionMedicine;
    function ParsePrescriptionMedicineActiveIngredient(element : IXmlDomElement) : TPrescriptionMedicineActiveIngredient;
    function ParsePrescriptionMedicineInactiveIngredient(element : IXmlDomElement) : TPrescriptionMedicineInactiveIngredient;
    function ParsePrescriptionAdministrationRequest(element : IXmlDomElement) : TPrescriptionAdministrationRequest;
    function ParsePrescriptionAdministrationRequestDosageInstruction(element : IXmlDomElement) : TPrescriptionAdministrationRequestDosageInstruction;
    function ParsePrescription(element : IXmlDomElement) : TPrescription;
    function ParsePatient(element : IXmlDomElement) : TPatient;
    function ParseOrganizationName(element : IXmlDomElement) : TOrganizationName;
    function ParseOrganizationAccreditation(element : IXmlDomElement) : TOrganizationAccreditation;
    function ParseOrganizationRelatedOrganization(element : IXmlDomElement) : TOrganizationRelatedOrganization;
    function ParseOrganization(element : IXmlDomElement) : TOrganization;
    function ParseDocumentConformancePublisher(element : IXmlDomElement) : TDocumentConformancePublisher;
    function ParseDocumentConformanceSoftware(element : IXmlDomElement) : TDocumentConformanceSoftware;
    function ParseDocumentConformanceDocument(element : IXmlDomElement) : TDocumentConformanceDocument;
    function ParseDocumentConformance(element : IXmlDomElement) : TDocumentConformance;
    function ParseLabReportRequestDetail(element : IXmlDomElement) : TLabReportRequestDetail;
    function ParseLabReportResultGroup(element : IXmlDomElement) : TLabReportResultGroup;
    function ParseLabReportResultGroupResult(element : IXmlDomElement) : TLabReportResultGroupResult;
    function ParseLabReportResultGroupResultReferenceRange(element : IXmlDomElement) : TLabReportResultGroupResultReferenceRange;
    function ParseLabReport(element : IXmlDomElement) : TLabReport;
    function ParsePersonQualification(element : IXmlDomElement) : TPersonQualification;
    function ParsePersonLanguage(element : IXmlDomElement) : TPersonLanguage;
    function ParsePersonRelatedPerson(element : IXmlDomElement) : TPersonRelatedPerson;
    function ParsePerson(element : IXmlDomElement) : TPerson;
    function ParseResource(element : IxmlDomElement) : TFHIRResource; override;
  end;

  TFHIRXmlComposer = class (TFHIRXmlComposerBase)
  protected
    procedure ComposeExtension(name : string; elem : TExtension);
    procedure ComposeConstraintElement(name : string; elem : TConstraintElement);
    procedure ComposeConstraintElementMapping(name : string; elem : TConstraintElementMapping);
    procedure ComposeConstraintElementAggregation(name : string; elem : TConstraintElementAggregation);
    procedure ComposeConstraintElementValue(name : string; elem : TConstraintElementValue);
    procedure ComposeConstraint(name : string; elem : TConstraint);
    procedure ComposeNarrativeImage(name : string; elem : TNarrativeImage);
    procedure ComposeNarrativeMap(name : string; elem : TNarrativeMap);
    procedure ComposeNarrative(name : string; elem : TNarrative);
    procedure ComposeCoding(name : string; elem : TCoding);
    procedure ComposeInterval_Quantity(name : string; elem : TInterval_Quantity);
    procedure ComposeInterval_DateTime(name : string; elem : TInterval_DateTime);
    procedure ComposeInterval_Date(name : string; elem : TInterval_Date);
    procedure ComposeQuantity(name : string; elem : TQuantity);
    procedure ComposeChoiceValue(name : string; elem : TChoiceValue);
    procedure ComposeChoice(name : string; elem : TChoice);
    procedure ComposeAttachment(name : string; elem : TAttachment);
    procedure ComposeRatio(name : string; elem : TRatio);
    procedure ComposeCodeableConcept(name : string; elem : TCodeableConcept);
    procedure ComposeIdentifier(name : string; elem : TIdentifier);
    procedure ComposeScheduleRepeat(name : string; elem : TScheduleRepeat);
    procedure ComposeSchedule(name : string; elem : TSchedule);
    procedure ComposeContact(name : string; elem : TContact);
    procedure ComposeAddressPart(name : string; elem : TAddressPart);
    procedure ComposeAddress(name : string; elem : TAddress);
    procedure ComposeHumanNamePart(name : string; elem : THumanNamePart);
    procedure ComposeHumanName(name : string; elem : THumanName);
    procedure ComposeHumanId(name : string; elem : THumanId);
    procedure ComposeConformancePublisher(name : string; elem : TConformancePublisher);
    procedure ComposeConformanceSoftware(name : string; elem : TConformanceSoftware);
    procedure ComposeConformanceOperation(name : string; elem : TConformanceOperation);
    procedure ComposeConformanceOperationTransaction(name : string; elem : TConformanceOperationTransaction);
    procedure ComposeConformanceOperationSearch(name : string; elem : TConformanceOperationSearch);
    procedure ComposeConformanceOperationCreate(name : string; elem : TConformanceOperationCreate);
    procedure ComposeConformance(name : string; elem : TConformance);
    procedure ComposeDocumentAuthor(name : string; elem : TDocumentAuthor);
    procedure ComposeDocumentAttestor(name : string; elem : TDocumentAttestor);
    procedure ComposeDocumentSection(name : string; elem : TDocumentSection);
    procedure ComposeDocumentSectionAuthor(name : string; elem : TDocumentSectionAuthor);
    procedure ComposeDocument(name : string; elem : TDocument);
    procedure ComposeMessageResponse(name : string; elem : TMessageResponse);
    procedure ComposeMessage(name : string; elem : TMessage);
    procedure ComposeMessageConformancePublisher(name : string; elem : TMessageConformancePublisher);
    procedure ComposeMessageConformanceSoftware(name : string; elem : TMessageConformanceSoftware);
    procedure ComposeMessageConformanceEvent(name : string; elem : TMessageConformanceEvent);
    procedure ComposeMessageConformanceEventRequest(name : string; elem : TMessageConformanceEventRequest);
    procedure ComposeMessageConformanceEventResponse(name : string; elem : TMessageConformanceEventResponse);
    procedure ComposeMessageConformance(name : string; elem : TMessageConformance);
    procedure ComposeAgent(name : string; elem : TAgent);
    procedure ComposeAnimalRelatedEntity(name : string; elem : TAnimalRelatedEntity);
    procedure ComposeAnimal(name : string; elem : TAnimal);
    procedure ComposePrescriptionDispense(name : string; elem : TPrescriptionDispense);
    procedure ComposePrescriptionMedicine(name : string; elem : TPrescriptionMedicine);
    procedure ComposePrescriptionMedicineActiveIngredient(name : string; elem : TPrescriptionMedicineActiveIngredient);
    procedure ComposePrescriptionMedicineInactiveIngredient(name : string; elem : TPrescriptionMedicineInactiveIngredient);
    procedure ComposePrescriptionAdministrationRequest(name : string; elem : TPrescriptionAdministrationRequest);
    procedure ComposePrescriptionAdministrationRequestDosageInstruction(name : string; elem : TPrescriptionAdministrationRequestDosageInstruction);
    procedure ComposePrescription(name : string; elem : TPrescription);
    procedure ComposePatient(name : string; elem : TPatient);
    procedure ComposeOrganizationName(name : string; elem : TOrganizationName);
    procedure ComposeOrganizationAccreditation(name : string; elem : TOrganizationAccreditation);
    procedure ComposeOrganizationRelatedOrganization(name : string; elem : TOrganizationRelatedOrganization);
    procedure ComposeOrganization(name : string; elem : TOrganization);
    procedure ComposeDocumentConformancePublisher(name : string; elem : TDocumentConformancePublisher);
    procedure ComposeDocumentConformanceSoftware(name : string; elem : TDocumentConformanceSoftware);
    procedure ComposeDocumentConformanceDocument(name : string; elem : TDocumentConformanceDocument);
    procedure ComposeDocumentConformance(name : string; elem : TDocumentConformance);
    procedure ComposeLabReportRequestDetail(name : string; elem : TLabReportRequestDetail);
    procedure ComposeLabReportResultGroup(name : string; elem : TLabReportResultGroup);
    procedure ComposeLabReportResultGroupResult(name : string; elem : TLabReportResultGroupResult);
    procedure ComposeLabReportResultGroupResultReferenceRange(name : string; elem : TLabReportResultGroupResultReferenceRange);
    procedure ComposeLabReport(name : string; elem : TLabReport);
    procedure ComposePersonQualification(name : string; elem : TPersonQualification);
    procedure ComposePersonLanguage(name : string; elem : TPersonLanguage);
    procedure ComposePersonRelatedPerson(name : string; elem : TPersonRelatedPerson);
    procedure ComposePerson(name : string; elem : TPerson);
    procedure ComposeResource(resource : TFHIRResource); override;
  end;

  TFHIRJsonParser = class (TFHIRJsonParserBase)
  protected
    function ParseExtension : TExtension;
    function ParseConstraintElement : TConstraintElement;
    function ParseConstraintElementMapping : TConstraintElementMapping;
    function ParseConstraintElementAggregation : TConstraintElementAggregation;
    function ParseConstraintElementValue : TConstraintElementValue;
    function ParseConstraint : TConstraint;
    function ParseNarrativeImage : TNarrativeImage;
    function ParseNarrativeMap : TNarrativeMap;
    function ParseNarrative : TNarrative;
    function ParseCoding : TCoding;
    function ParseInterval_Quantity : TInterval_Quantity;
    function ParseInterval_DateTime : TInterval_DateTime;
    function ParseInterval_Date : TInterval_Date;
    function ParseQuantity : TQuantity;
    function ParseChoiceValue : TChoiceValue;
    function ParseChoice : TChoice;
    function ParseAttachment : TAttachment;
    function ParseRatio : TRatio;
    function ParseCodeableConcept : TCodeableConcept;
    function ParseIdentifier : TIdentifier;
    function ParseScheduleRepeat : TScheduleRepeat;
    function ParseSchedule : TSchedule;
    function ParseContact : TContact;
    function ParseAddressPart : TAddressPart;
    function ParseAddress : TAddress;
    function ParseHumanNamePart : THumanNamePart;
    function ParseHumanName : THumanName;
    function ParseHumanId : THumanId;
    function ParseConformancePublisher : TConformancePublisher;
    function ParseConformanceSoftware : TConformanceSoftware;
    function ParseConformanceOperation : TConformanceOperation;
    function ParseConformanceOperationTransaction : TConformanceOperationTransaction;
    function ParseConformanceOperationSearch : TConformanceOperationSearch;
    function ParseConformanceOperationCreate : TConformanceOperationCreate;
    function ParseConformance : TConformance;
    function ParseDocumentAuthor : TDocumentAuthor;
    function ParseDocumentAttestor : TDocumentAttestor;
    function ParseDocumentSection : TDocumentSection;
    function ParseDocumentSectionAuthor : TDocumentSectionAuthor;
    function ParseDocument : TDocument;
    function ParseMessageResponse : TMessageResponse;
    function ParseMessage : TMessage;
    function ParseMessageConformancePublisher : TMessageConformancePublisher;
    function ParseMessageConformanceSoftware : TMessageConformanceSoftware;
    function ParseMessageConformanceEvent : TMessageConformanceEvent;
    function ParseMessageConformanceEventRequest : TMessageConformanceEventRequest;
    function ParseMessageConformanceEventResponse : TMessageConformanceEventResponse;
    function ParseMessageConformance : TMessageConformance;
    function ParseAgent : TAgent;
    function ParseAnimalRelatedEntity : TAnimalRelatedEntity;
    function ParseAnimal : TAnimal;
    function ParsePrescriptionDispense : TPrescriptionDispense;
    function ParsePrescriptionMedicine : TPrescriptionMedicine;
    function ParsePrescriptionMedicineActiveIngredient : TPrescriptionMedicineActiveIngredient;
    function ParsePrescriptionMedicineInactiveIngredient : TPrescriptionMedicineInactiveIngredient;
    function ParsePrescriptionAdministrationRequest : TPrescriptionAdministrationRequest;
    function ParsePrescriptionAdministrationRequestDosageInstruction : TPrescriptionAdministrationRequestDosageInstruction;
    function ParsePrescription : TPrescription;
    function ParsePatient : TPatient;
    function ParseOrganizationName : TOrganizationName;
    function ParseOrganizationAccreditation : TOrganizationAccreditation;
    function ParseOrganizationRelatedOrganization : TOrganizationRelatedOrganization;
    function ParseOrganization : TOrganization;
    function ParseDocumentConformancePublisher : TDocumentConformancePublisher;
    function ParseDocumentConformanceSoftware : TDocumentConformanceSoftware;
    function ParseDocumentConformanceDocument : TDocumentConformanceDocument;
    function ParseDocumentConformance : TDocumentConformance;
    function ParseLabReportRequestDetail : TLabReportRequestDetail;
    function ParseLabReportResultGroup : TLabReportResultGroup;
    function ParseLabReportResultGroupResult : TLabReportResultGroupResult;
    function ParseLabReportResultGroupResultReferenceRange : TLabReportResultGroupResultReferenceRange;
    function ParseLabReport : TLabReport;
    function ParsePersonQualification : TPersonQualification;
    function ParsePersonLanguage : TPersonLanguage;
    function ParsePersonRelatedPerson : TPersonRelatedPerson;
    function ParsePerson : TPerson;
    function ParseResource : TFHIRResource; override;
  end;

  TFHIRJsonComposer = class (TFHIRJsonComposerBase)
  protected
    procedure ComposeExtension(name : string; elem : TExtension);
    procedure ComposeConstraintElement(name : string; elem : TConstraintElement);
    procedure ComposeConstraintElementMapping(name : string; elem : TConstraintElementMapping);
    procedure ComposeConstraintElementAggregation(name : string; elem : TConstraintElementAggregation);
    procedure ComposeConstraintElementValue(name : string; elem : TConstraintElementValue);
    procedure ComposeConstraint(name : string; elem : TConstraint);
    procedure ComposeNarrativeImage(name : string; elem : TNarrativeImage);
    procedure ComposeNarrativeMap(name : string; elem : TNarrativeMap);
    procedure ComposeNarrative(name : string; elem : TNarrative);
    procedure ComposeCoding(name : string; elem : TCoding);
    procedure ComposeInterval_Quantity(name : string; elem : TInterval_Quantity);
    procedure ComposeInterval_DateTime(name : string; elem : TInterval_DateTime);
    procedure ComposeInterval_Date(name : string; elem : TInterval_Date);
    procedure ComposeQuantity(name : string; elem : TQuantity);
    procedure ComposeChoiceValue(name : string; elem : TChoiceValue);
    procedure ComposeChoice(name : string; elem : TChoice);
    procedure ComposeAttachment(name : string; elem : TAttachment);
    procedure ComposeRatio(name : string; elem : TRatio);
    procedure ComposeCodeableConcept(name : string; elem : TCodeableConcept);
    procedure ComposeIdentifier(name : string; elem : TIdentifier);
    procedure ComposeScheduleRepeat(name : string; elem : TScheduleRepeat);
    procedure ComposeSchedule(name : string; elem : TSchedule);
    procedure ComposeContact(name : string; elem : TContact);
    procedure ComposeAddressPart(name : string; elem : TAddressPart);
    procedure ComposeAddress(name : string; elem : TAddress);
    procedure ComposeHumanNamePart(name : string; elem : THumanNamePart);
    procedure ComposeHumanName(name : string; elem : THumanName);
    procedure ComposeHumanId(name : string; elem : THumanId);
    procedure ComposeConformancePublisher(name : string; elem : TConformancePublisher);
    procedure ComposeConformanceSoftware(name : string; elem : TConformanceSoftware);
    procedure ComposeConformanceOperation(name : string; elem : TConformanceOperation);
    procedure ComposeConformanceOperationTransaction(name : string; elem : TConformanceOperationTransaction);
    procedure ComposeConformanceOperationSearch(name : string; elem : TConformanceOperationSearch);
    procedure ComposeConformanceOperationCreate(name : string; elem : TConformanceOperationCreate);
    procedure ComposeConformance(name : string; elem : TConformance);
    procedure ComposeDocumentAuthor(name : string; elem : TDocumentAuthor);
    procedure ComposeDocumentAttestor(name : string; elem : TDocumentAttestor);
    procedure ComposeDocumentSection(name : string; elem : TDocumentSection);
    procedure ComposeDocumentSectionAuthor(name : string; elem : TDocumentSectionAuthor);
    procedure ComposeDocument(name : string; elem : TDocument);
    procedure ComposeMessageResponse(name : string; elem : TMessageResponse);
    procedure ComposeMessage(name : string; elem : TMessage);
    procedure ComposeMessageConformancePublisher(name : string; elem : TMessageConformancePublisher);
    procedure ComposeMessageConformanceSoftware(name : string; elem : TMessageConformanceSoftware);
    procedure ComposeMessageConformanceEvent(name : string; elem : TMessageConformanceEvent);
    procedure ComposeMessageConformanceEventRequest(name : string; elem : TMessageConformanceEventRequest);
    procedure ComposeMessageConformanceEventResponse(name : string; elem : TMessageConformanceEventResponse);
    procedure ComposeMessageConformance(name : string; elem : TMessageConformance);
    procedure ComposeAgent(name : string; elem : TAgent);
    procedure ComposeAnimalRelatedEntity(name : string; elem : TAnimalRelatedEntity);
    procedure ComposeAnimal(name : string; elem : TAnimal);
    procedure ComposePrescriptionDispense(name : string; elem : TPrescriptionDispense);
    procedure ComposePrescriptionMedicine(name : string; elem : TPrescriptionMedicine);
    procedure ComposePrescriptionMedicineActiveIngredient(name : string; elem : TPrescriptionMedicineActiveIngredient);
    procedure ComposePrescriptionMedicineInactiveIngredient(name : string; elem : TPrescriptionMedicineInactiveIngredient);
    procedure ComposePrescriptionAdministrationRequest(name : string; elem : TPrescriptionAdministrationRequest);
    procedure ComposePrescriptionAdministrationRequestDosageInstruction(name : string; elem : TPrescriptionAdministrationRequestDosageInstruction);
    procedure ComposePrescription(name : string; elem : TPrescription);
    procedure ComposePatient(name : string; elem : TPatient);
    procedure ComposeOrganizationName(name : string; elem : TOrganizationName);
    procedure ComposeOrganizationAccreditation(name : string; elem : TOrganizationAccreditation);
    procedure ComposeOrganizationRelatedOrganization(name : string; elem : TOrganizationRelatedOrganization);
    procedure ComposeOrganization(name : string; elem : TOrganization);
    procedure ComposeDocumentConformancePublisher(name : string; elem : TDocumentConformancePublisher);
    procedure ComposeDocumentConformanceSoftware(name : string; elem : TDocumentConformanceSoftware);
    procedure ComposeDocumentConformanceDocument(name : string; elem : TDocumentConformanceDocument);
    procedure ComposeDocumentConformance(name : string; elem : TDocumentConformance);
    procedure ComposeLabReportRequestDetail(name : string; elem : TLabReportRequestDetail);
    procedure ComposeLabReportResultGroup(name : string; elem : TLabReportResultGroup);
    procedure ComposeLabReportResultGroupResult(name : string; elem : TLabReportResultGroupResult);
    procedure ComposeLabReportResultGroupResultReferenceRange(name : string; elem : TLabReportResultGroupResultReferenceRange);
    procedure ComposeLabReport(name : string; elem : TLabReport);
    procedure ComposePersonQualification(name : string; elem : TPersonQualification);
    procedure ComposePersonLanguage(name : string; elem : TPersonLanguage);
    procedure ComposePersonRelatedPerson(name : string; elem : TPersonRelatedPerson);
    procedure ComposePerson(name : string; elem : TPerson);
    procedure ComposeResource(resource : TFHIRResource); override;
  end;


implementation

{ TFHIRXmlParser }

function TFHIRXmlParser.ParseExtension(element : IXmlDomElement) : TExtension;
var
  child : IXMLDOMElement;
begin
  result := TExtension.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'code') then
        result.code := child.text
      else if (child.nodeName = 'definition') then
        result.definition := child.text
      else if (child.nodeName = 'ref') then
        result.ref := child.text
      else if (child.nodeName = 'state') then
        result.state := TExtensionState(ParseEnum(CODES_TExtensionState, child))
      else if (child.nodeName = 'valueSid') then
        result.value := ParseSid(child)
      else if (child.nodeName = 'valueDateTime') then
        result.value := ParseDateTime(child)
      else if (child.nodeName = 'valueInteger') then
        result.value := ParseInteger(child)
      else if (child.nodeName = 'valueCode') then
        result.value := ParseCode(child)
      else if (child.nodeName = 'valueDate') then
        result.value := ParseDate(child)
      else if (child.nodeName = 'valueDecimal') then
        result.value := ParseDecimal(child)
      else if (child.nodeName = 'valueUri') then
        result.value := ParseUri(child)
      else if (child.nodeName = 'valueId') then
        result.value := ParseId(child)
      else if (child.nodeName = 'valueBase64Binary') then
        result.value := ParseBase64Binary(child)
      else if (child.nodeName = 'valueOid') then
        result.value := ParseOid(child)
      else if (child.nodeName = 'valueString') then
        result.value := ParseString(child)
      else if (child.nodeName = 'valueBoolean') then
        result.value := ParseBoolean(child)
      else if (child.nodeName = 'valueUuid') then
        result.value := ParseUuid(child)
      else if (child.nodeName = 'valueInstant') then
        result.value := ParseInstant(child)
      else if (child.nodeName = 'valueCoding') then
        result.value := ParseCoding(child)
      else if (child.nodeName = 'valueInterval_Quantity') then
        result.value := ParseInterval_Quantity(child)
      else if (child.nodeName = 'valueInterval_DateTime') then
        result.value := ParseInterval_DateTime(child)
      else if (child.nodeName = 'valueInterval_Date') then
        result.value := ParseInterval_Date(child)
      else if (child.nodeName = 'valueQuantity') then
        result.value := ParseQuantity(child)
      else if (child.nodeName = 'valueChoice') then
        result.value := ParseChoice(child)
      else if (child.nodeName = 'valueAttachment') then
        result.value := ParseAttachment(child)
      else if (child.nodeName = 'valueRatio') then
        result.value := ParseRatio(child)
      else if (child.nodeName = 'valueCodeableConcept') then
        result.value := ParseCodeableConcept(child)
      else if (child.nodeName = 'valueIdentifier') then
        result.value := ParseIdentifier(child)
      else if (child.nodeName = 'valueSchedule') then
        result.value := ParseSchedule(child)
      else if (child.nodeName = 'valueContact') then
        result.value := ParseContact(child)
      else if (child.nodeName = 'valueAddress') then
        result.value := ParseAddress(child)
      else if (child.nodeName = 'valueHumanName') then
        result.value := ParseHumanName(child)
      else if (child.nodeName = 'valueHumanId') then
        result.value := ParseHumanId(child)
      else if (child.nodeName = 'extension') then
        result.Extension.Add(ParseExtension(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeExtension(name : string; elem : TExtension);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('code',elem.code);
  Text('definition',elem.definition);
  Text('ref',elem.ref);
  Text('state',CODES_TExtensionState[elem.state]);
  if elem.value is TFHIRTypeString then
    ComposeString('valueSid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueDateTime', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInteger then
    ComposeInteger('valueInteger', TFHIRTypeInteger(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueCode', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueDate', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeDecimal then
    ComposeDecimal('valueDecimal', TFHIRTypeDecimal(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueUri', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueId', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBytes then
    ComposeBytes('valueBase64Binary', TFHIRTypeBytes(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueOid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueString', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBoolean then
    ComposeBoolean('valueBoolean', TFHIRTypeBoolean(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueUuid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInstant then
    ComposeInstant('valueInstant', TFHIRTypeInstant(elem.value))
  else if elem.value is TCoding then
    ComposeCoding('valueCoding', TCoding(elem.value))
  else if elem.value is TInterval_Quantity then
    ComposeInterval_Quantity('valueInterval_Quantity', TInterval_Quantity(elem.value))
  else if elem.value is TInterval_DateTime then
    ComposeInterval_DateTime('valueInterval_DateTime', TInterval_DateTime(elem.value))
  else if elem.value is TInterval_Date then
    ComposeInterval_Date('valueInterval_Date', TInterval_Date(elem.value))
  else if elem.value is TQuantity then
    ComposeQuantity('valueQuantity', TQuantity(elem.value))
  else if elem.value is TChoice then
    ComposeChoice('valueChoice', TChoice(elem.value))
  else if elem.value is TAttachment then
    ComposeAttachment('valueAttachment', TAttachment(elem.value))
  else if elem.value is TRatio then
    ComposeRatio('valueRatio', TRatio(elem.value))
  else if elem.value is TCodeableConcept then
    ComposeCodeableConcept('valueCodeableConcept', TCodeableConcept(elem.value))
  else if elem.value is TIdentifier then
    ComposeIdentifier('valueIdentifier', TIdentifier(elem.value))
  else if elem.value is TSchedule then
    ComposeSchedule('valueSchedule', TSchedule(elem.value))
  else if elem.value is TContact then
    ComposeContact('valueContact', TContact(elem.value))
  else if elem.value is TAddress then
    ComposeAddress('valueAddress', TAddress(elem.value))
  else if elem.value is THumanName then
    ComposeHumanName('valueHumanName', THumanName(elem.value))
  else if elem.value is THumanId then
    ComposeHumanId('valueHumanId', THumanId(elem.value));
  for i := 0 to elem.Extension.Count - 1 do
    ComposeExtension('extension', elem.Extension[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseExtension : TExtension;
begin
  result := TExtension.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := FJson.itemValue
      else if (FJson.ItemName = 'definition') then
        result.definition := FJson.itemValue
      else if (FJson.ItemName = 'ref') then
        result.ref := FJson.itemValue
      else if (FJson.ItemName = 'state') then
        result.state := TExtensionState(ParseEnum(CODES_TExtensionState))
      else if (FJson.ItemName = 'valueSid') then
        result.value := ParseSid
      else if (FJson.ItemName = 'valueDateTime') then
        result.value := ParseDateTime
      else if (FJson.ItemName = 'valueInteger') then
        result.value := ParseInteger
      else if (FJson.ItemName = 'valueCode') then
        result.value := ParseCode
      else if (FJson.ItemName = 'valueDate') then
        result.value := ParseDate
      else if (FJson.ItemName = 'valueDecimal') then
        result.value := ParseDecimal
      else if (FJson.ItemName = 'valueUri') then
        result.value := ParseUri
      else if (FJson.ItemName = 'valueId') then
        result.value := ParseId
      else if (FJson.ItemName = 'valueBase64Binary') then
        result.value := ParseBase64Binary
      else if (FJson.ItemName = 'valueOid') then
        result.value := ParseOid
      else if (FJson.ItemName = 'valueString') then
        result.value := ParseString
      else if (FJson.ItemName = 'valueBoolean') then
        result.value := ParseBoolean
      else if (FJson.ItemName = 'valueUuid') then
        result.value := ParseUuid
      else if (FJson.ItemName = 'valueInstant') then
        result.value := ParseInstant
      else if (FJson.ItemName = 'valueCoding') then
        result.value := ParseCoding
      else if (FJson.ItemName = 'valueInterval_Quantity') then
        result.value := ParseInterval_Quantity
      else if (FJson.ItemName = 'valueInterval_DateTime') then
        result.value := ParseInterval_DateTime
      else if (FJson.ItemName = 'valueInterval_Date') then
        result.value := ParseInterval_Date
      else if (FJson.ItemName = 'valueQuantity') then
        result.value := ParseQuantity
      else if (FJson.ItemName = 'valueChoice') then
        result.value := ParseChoice
      else if (FJson.ItemName = 'valueAttachment') then
        result.value := ParseAttachment
      else if (FJson.ItemName = 'valueRatio') then
        result.value := ParseRatio
      else if (FJson.ItemName = 'valueCodeableConcept') then
        result.value := ParseCodeableConcept
      else if (FJson.ItemName = 'valueIdentifier') then
        result.value := ParseIdentifier
      else if (FJson.ItemName = 'valueSchedule') then
        result.value := ParseSchedule
      else if (FJson.ItemName = 'valueContact') then
        result.value := ParseContact
      else if (FJson.ItemName = 'valueAddress') then
        result.value := ParseAddress
      else if (FJson.ItemName = 'valueHumanName') then
        result.value := ParseHumanName
      else if (FJson.ItemName = 'valueHumanId') then
        result.value := ParseHumanId
      else if (FJson.ItemName = 'extensions') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Extension.Add(ParseExtension);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeExtension(name : string; elem : TExtension);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('code',elem.code);
  Prop('definition',elem.definition);
  Prop('ref',elem.ref);
  Prop('state',CODES_TExtensionState[elem.state]);
  if elem.value is TFHIRTypeString then
    ComposeString('valueSid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueDateTime', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInteger then
    ComposeInteger('valueInteger', TFHIRTypeInteger(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueCode', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueDate', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeDecimal then
    ComposeDecimal('valueDecimal', TFHIRTypeDecimal(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueUri', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueId', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBytes then
    ComposeBytes('valueBase64Binary', TFHIRTypeBytes(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueOid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueString', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBoolean then
    ComposeBoolean('valueBoolean', TFHIRTypeBoolean(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('valueUuid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInstant then
    ComposeInstant('valueInstant', TFHIRTypeInstant(elem.value))
  else if elem.value is TCoding then
    ComposeCoding('valueCoding', TCoding(elem.value))
  else if elem.value is TInterval_Quantity then
    ComposeInterval_Quantity('valueInterval_Quantity', TInterval_Quantity(elem.value))
  else if elem.value is TInterval_DateTime then
    ComposeInterval_DateTime('valueInterval_DateTime', TInterval_DateTime(elem.value))
  else if elem.value is TInterval_Date then
    ComposeInterval_Date('valueInterval_Date', TInterval_Date(elem.value))
  else if elem.value is TQuantity then
    ComposeQuantity('valueQuantity', TQuantity(elem.value))
  else if elem.value is TChoice then
    ComposeChoice('valueChoice', TChoice(elem.value))
  else if elem.value is TAttachment then
    ComposeAttachment('valueAttachment', TAttachment(elem.value))
  else if elem.value is TRatio then
    ComposeRatio('valueRatio', TRatio(elem.value))
  else if elem.value is TCodeableConcept then
    ComposeCodeableConcept('valueCodeableConcept', TCodeableConcept(elem.value))
  else if elem.value is TIdentifier then
    ComposeIdentifier('valueIdentifier', TIdentifier(elem.value))
  else if elem.value is TSchedule then
    ComposeSchedule('valueSchedule', TSchedule(elem.value))
  else if elem.value is TContact then
    ComposeContact('valueContact', TContact(elem.value))
  else if elem.value is TAddress then
    ComposeAddress('valueAddress', TAddress(elem.value))
  else if elem.value is THumanName then
    ComposeHumanName('valueHumanName', THumanName(elem.value))
  else if elem.value is THumanId then
    ComposeHumanId('valueHumanId', THumanId(elem.value));
  if elem.Extension.Count > 0 then
  begin
    FJson.valueObject('extensions');
    for i := 0 to elem.Extension.Count - 1 do
      ComposeExtension('extension',elem.Extension[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConstraintElement(element : IXmlDomElement) : TConstraintElement;
var
  child : IXMLDOMElement;
begin
  result := TConstraintElement.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'path') then
        result.path := child.text
      else if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'purpose') then
        result.purpose := child.text
      else if (child.nodeName = 'min') then
        result.min := StringToInteger32(child.text)
      else if (child.nodeName = 'max') then
        result.max := child.text
      else if (child.nodeName = 'type') then
        result.type_ := child.text
      else if (child.nodeName = 'conformance') then
        result.conformance := TConformanceType(ParseEnum(CODES_TConformanceType, child))
      else if (child.nodeName = 'condition') then
        result.condition := child.text
      else if (child.nodeName = 'mustSupport') then
        result.mustSupport := StringToBoolean(child.text)
      else if (child.nodeName = 'mustUnderstand') then
        result.mustUnderstand := StringToBoolean(child.text)
      else if (child.nodeName = 'definition') then
        result.definition := child.text
      else if (child.nodeName = 'mapping') then
        result.Mapping.Add(ParseConstraintElementMapping(child))
      else if (child.nodeName = 'aggregation') then
        result.aggregation := ParseConstraintElementAggregation(child)
      else if (child.nodeName = 'valueSet') then
        result.valueSet := child.text
      else if (child.nodeName = 'value') then
        result.Value.Add(ParseConstraintElementValue(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConstraintElement(name : string; elem : TConstraintElement);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('path',elem.path);
  Text('name',elem.name);
  Text('purpose',elem.purpose);
  Text('min',IntegerToString(elem.min));
  Text('max',elem.max);
  Text('type',elem.type_);
  Text('conformance',CODES_TConformanceType[elem.conformance]);
  Text('condition',elem.condition);
  Text('mustSupport',BooleanToString(elem.mustSupport));
  Text('mustUnderstand',BooleanToString(elem.mustUnderstand));
  Text('definition',elem.definition);
  for i := 0 to elem.Mapping.Count - 1 do
    ComposeConstraintElementMapping('mapping', elem.Mapping[i]);
  ComposeConstraintElementAggregation('aggregation', elem.aggregation);
  Text('valueSet',elem.valueSet);
  for i := 0 to elem.Value.Count - 1 do
    ComposeConstraintElementValue('value', elem.Value[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConstraintElement : TConstraintElement;
begin
  result := TConstraintElement.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'path') then
        result.path := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'purpose') then
        result.purpose := FJson.itemValue
      else if (FJson.ItemName = 'min') then
        result.min := StringToInteger32(FJson.itemValue)
      else if (FJson.ItemName = 'max') then
        result.max := FJson.itemValue
      else if (FJson.ItemName = 'type') then
        result.type_ := FJson.itemValue
      else if (FJson.ItemName = 'conformance') then
        result.conformance := TConformanceType(ParseEnum(CODES_TConformanceType))
      else if (FJson.ItemName = 'condition') then
        result.condition := FJson.itemValue
      else if (FJson.ItemName = 'mustSupport') then
        result.mustSupport := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'mustUnderstand') then
        result.mustUnderstand := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'definition') then
        result.definition := FJson.itemValue
      else if (FJson.ItemName = 'mappings') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Mapping.Add(ParseConstraintElementMapping);
        FJson.Next;
      end
      else if (FJson.ItemName = 'aggregation') then
        result.aggregation := ParseConstraintElementAggregation
      else if (FJson.ItemName = 'valueSet') then
        result.valueSet := FJson.itemValue
      else if (FJson.ItemName = 'values') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Value.Add(ParseConstraintElementValue);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConstraintElement(name : string; elem : TConstraintElement);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('path',elem.path);
  Prop('name',elem.name);
  Prop('purpose',elem.purpose);
  Prop('min',IntegerToString(elem.min));
  Prop('max',elem.max);
  Prop('type',elem.type_);
  Prop('conformance',CODES_TConformanceType[elem.conformance]);
  Prop('condition',elem.condition);
  Prop('mustSupport',BooleanToString(elem.mustSupport));
  Prop('mustUnderstand',BooleanToString(elem.mustUnderstand));
  Prop('definition',elem.definition);
  if elem.Mapping.Count > 0 then
  begin
    FJson.valueObject('mappings');
    for i := 0 to elem.Mapping.Count - 1 do
      ComposeConstraintElementMapping('mapping',elem.Mapping[i]);
    FJson.FinishObject;
  end;
  ComposeConstraintElementAggregation('aggregation', elem.aggregation);
  Prop('valueSet',elem.valueSet);
  if elem.Value.Count > 0 then
  begin
    FJson.valueObject('values');
    for i := 0 to elem.Value.Count - 1 do
      ComposeConstraintElementValue('value',elem.Value[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConstraintElementMapping(element : IXmlDomElement) : TConstraintElementMapping;
var
  child : IXMLDOMElement;
begin
  result := TConstraintElementMapping.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'target') then
        result.target := child.text
      else if (child.nodeName = 'map') then
        result.map := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConstraintElementMapping(name : string; elem : TConstraintElementMapping);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('target',elem.target);
  Text('map',elem.map);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConstraintElementMapping : TConstraintElementMapping;
begin
  result := TConstraintElementMapping.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'target') then
        result.target := FJson.itemValue
      else if (FJson.ItemName = 'map') then
        result.map := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConstraintElementMapping(name : string; elem : TConstraintElementMapping);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('target',elem.target);
  Prop('map',elem.map);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConstraintElementAggregation(element : IXmlDomElement) : TConstraintElementAggregation;
var
  child : IXMLDOMElement;
begin
  result := TConstraintElementAggregation.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'aggregated') then
        result.aggregated := StringToBoolean(child.text)
      else if (child.nodeName = 'name') then
        result.name := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConstraintElementAggregation(name : string; elem : TConstraintElementAggregation);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('aggregated',BooleanToString(elem.aggregated));
  Text('name',elem.name);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConstraintElementAggregation : TConstraintElementAggregation;
begin
  result := TConstraintElementAggregation.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'aggregated') then
        result.aggregated := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConstraintElementAggregation(name : string; elem : TConstraintElementAggregation);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('aggregated',BooleanToString(elem.aggregated));
  Prop('name',elem.name);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConstraintElementValue(element : IXmlDomElement) : TConstraintElementValue;
var
  child : IXMLDOMElement;
begin
  result := TConstraintElementValue.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'Sid') then
        result.value := ParseSid(child)
      else if (child.nodeName = 'DateTime') then
        result.value := ParseDateTime(child)
      else if (child.nodeName = 'Integer') then
        result.value := ParseInteger(child)
      else if (child.nodeName = 'Code') then
        result.value := ParseCode(child)
      else if (child.nodeName = 'Date') then
        result.value := ParseDate(child)
      else if (child.nodeName = 'Decimal') then
        result.value := ParseDecimal(child)
      else if (child.nodeName = 'Uri') then
        result.value := ParseUri(child)
      else if (child.nodeName = 'Id') then
        result.value := ParseId(child)
      else if (child.nodeName = 'Base64Binary') then
        result.value := ParseBase64Binary(child)
      else if (child.nodeName = 'Oid') then
        result.value := ParseOid(child)
      else if (child.nodeName = 'String') then
        result.value := ParseString(child)
      else if (child.nodeName = 'Boolean') then
        result.value := ParseBoolean(child)
      else if (child.nodeName = 'Uuid') then
        result.value := ParseUuid(child)
      else if (child.nodeName = 'Instant') then
        result.value := ParseInstant(child)
      else if (child.nodeName = 'Coding') then
        result.value := ParseCoding(child)
      else if (child.nodeName = 'Interval_Quantity') then
        result.value := ParseInterval_Quantity(child)
      else if (child.nodeName = 'Interval_DateTime') then
        result.value := ParseInterval_DateTime(child)
      else if (child.nodeName = 'Interval_Date') then
        result.value := ParseInterval_Date(child)
      else if (child.nodeName = 'Quantity') then
        result.value := ParseQuantity(child)
      else if (child.nodeName = 'Choice') then
        result.value := ParseChoice(child)
      else if (child.nodeName = 'Attachment') then
        result.value := ParseAttachment(child)
      else if (child.nodeName = 'Ratio') then
        result.value := ParseRatio(child)
      else if (child.nodeName = 'CodeableConcept') then
        result.value := ParseCodeableConcept(child)
      else if (child.nodeName = 'Identifier') then
        result.value := ParseIdentifier(child)
      else if (child.nodeName = 'Schedule') then
        result.value := ParseSchedule(child)
      else if (child.nodeName = 'Contact') then
        result.value := ParseContact(child)
      else if (child.nodeName = 'Address') then
        result.value := ParseAddress(child)
      else if (child.nodeName = 'HumanName') then
        result.value := ParseHumanName(child)
      else if (child.nodeName = 'HumanId') then
        result.value := ParseHumanId(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConstraintElementValue(name : string; elem : TConstraintElementValue);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  if elem.value is TFHIRTypeString then
    ComposeString('Sid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('DateTime', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInteger then
    ComposeInteger('Integer', TFHIRTypeInteger(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Code', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Date', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeDecimal then
    ComposeDecimal('Decimal', TFHIRTypeDecimal(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Uri', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Id', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBytes then
    ComposeBytes('Base64Binary', TFHIRTypeBytes(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Oid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('String', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBoolean then
    ComposeBoolean('Boolean', TFHIRTypeBoolean(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Uuid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInstant then
    ComposeInstant('Instant', TFHIRTypeInstant(elem.value))
  else if elem.value is TCoding then
    ComposeCoding('Coding', TCoding(elem.value))
  else if elem.value is TInterval_Quantity then
    ComposeInterval_Quantity('Interval_Quantity', TInterval_Quantity(elem.value))
  else if elem.value is TInterval_DateTime then
    ComposeInterval_DateTime('Interval_DateTime', TInterval_DateTime(elem.value))
  else if elem.value is TInterval_Date then
    ComposeInterval_Date('Interval_Date', TInterval_Date(elem.value))
  else if elem.value is TQuantity then
    ComposeQuantity('Quantity', TQuantity(elem.value))
  else if elem.value is TChoice then
    ComposeChoice('Choice', TChoice(elem.value))
  else if elem.value is TAttachment then
    ComposeAttachment('Attachment', TAttachment(elem.value))
  else if elem.value is TRatio then
    ComposeRatio('Ratio', TRatio(elem.value))
  else if elem.value is TCodeableConcept then
    ComposeCodeableConcept('CodeableConcept', TCodeableConcept(elem.value))
  else if elem.value is TIdentifier then
    ComposeIdentifier('Identifier', TIdentifier(elem.value))
  else if elem.value is TSchedule then
    ComposeSchedule('Schedule', TSchedule(elem.value))
  else if elem.value is TContact then
    ComposeContact('Contact', TContact(elem.value))
  else if elem.value is TAddress then
    ComposeAddress('Address', TAddress(elem.value))
  else if elem.value is THumanName then
    ComposeHumanName('HumanName', THumanName(elem.value))
  else if elem.value is THumanId then
    ComposeHumanId('HumanId', THumanId(elem.value));
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConstraintElementValue : TConstraintElementValue;
begin
  result := TConstraintElementValue.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'Sid') then
        result.value := ParseSid
      else if (FJson.ItemName = 'DateTime') then
        result.value := ParseDateTime
      else if (FJson.ItemName = 'Integer') then
        result.value := ParseInteger
      else if (FJson.ItemName = 'Code') then
        result.value := ParseCode
      else if (FJson.ItemName = 'Date') then
        result.value := ParseDate
      else if (FJson.ItemName = 'Decimal') then
        result.value := ParseDecimal
      else if (FJson.ItemName = 'Uri') then
        result.value := ParseUri
      else if (FJson.ItemName = 'Id') then
        result.value := ParseId
      else if (FJson.ItemName = 'Base64Binary') then
        result.value := ParseBase64Binary
      else if (FJson.ItemName = 'Oid') then
        result.value := ParseOid
      else if (FJson.ItemName = 'String') then
        result.value := ParseString
      else if (FJson.ItemName = 'Boolean') then
        result.value := ParseBoolean
      else if (FJson.ItemName = 'Uuid') then
        result.value := ParseUuid
      else if (FJson.ItemName = 'Instant') then
        result.value := ParseInstant
      else if (FJson.ItemName = 'Coding') then
        result.value := ParseCoding
      else if (FJson.ItemName = 'Interval_Quantity') then
        result.value := ParseInterval_Quantity
      else if (FJson.ItemName = 'Interval_DateTime') then
        result.value := ParseInterval_DateTime
      else if (FJson.ItemName = 'Interval_Date') then
        result.value := ParseInterval_Date
      else if (FJson.ItemName = 'Quantity') then
        result.value := ParseQuantity
      else if (FJson.ItemName = 'Choice') then
        result.value := ParseChoice
      else if (FJson.ItemName = 'Attachment') then
        result.value := ParseAttachment
      else if (FJson.ItemName = 'Ratio') then
        result.value := ParseRatio
      else if (FJson.ItemName = 'CodeableConcept') then
        result.value := ParseCodeableConcept
      else if (FJson.ItemName = 'Identifier') then
        result.value := ParseIdentifier
      else if (FJson.ItemName = 'Schedule') then
        result.value := ParseSchedule
      else if (FJson.ItemName = 'Contact') then
        result.value := ParseContact
      else if (FJson.ItemName = 'Address') then
        result.value := ParseAddress
      else if (FJson.ItemName = 'HumanName') then
        result.value := ParseHumanName
      else if (FJson.ItemName = 'HumanId') then
        result.value := ParseHumanId
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConstraintElementValue(name : string; elem : TConstraintElementValue);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  if elem.value is TFHIRTypeString then
    ComposeString('Sid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('DateTime', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInteger then
    ComposeInteger('Integer', TFHIRTypeInteger(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Code', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Date', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeDecimal then
    ComposeDecimal('Decimal', TFHIRTypeDecimal(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Uri', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Id', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBytes then
    ComposeBytes('Base64Binary', TFHIRTypeBytes(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Oid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('String', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeBoolean then
    ComposeBoolean('Boolean', TFHIRTypeBoolean(elem.value))
  else if elem.value is TFHIRTypeString then
    ComposeString('Uuid', TFHIRTypeString(elem.value))
  else if elem.value is TFHIRTypeInstant then
    ComposeInstant('Instant', TFHIRTypeInstant(elem.value))
  else if elem.value is TCoding then
    ComposeCoding('Coding', TCoding(elem.value))
  else if elem.value is TInterval_Quantity then
    ComposeInterval_Quantity('Interval_Quantity', TInterval_Quantity(elem.value))
  else if elem.value is TInterval_DateTime then
    ComposeInterval_DateTime('Interval_DateTime', TInterval_DateTime(elem.value))
  else if elem.value is TInterval_Date then
    ComposeInterval_Date('Interval_Date', TInterval_Date(elem.value))
  else if elem.value is TQuantity then
    ComposeQuantity('Quantity', TQuantity(elem.value))
  else if elem.value is TChoice then
    ComposeChoice('Choice', TChoice(elem.value))
  else if elem.value is TAttachment then
    ComposeAttachment('Attachment', TAttachment(elem.value))
  else if elem.value is TRatio then
    ComposeRatio('Ratio', TRatio(elem.value))
  else if elem.value is TCodeableConcept then
    ComposeCodeableConcept('CodeableConcept', TCodeableConcept(elem.value))
  else if elem.value is TIdentifier then
    ComposeIdentifier('Identifier', TIdentifier(elem.value))
  else if elem.value is TSchedule then
    ComposeSchedule('Schedule', TSchedule(elem.value))
  else if elem.value is TContact then
    ComposeContact('Contact', TContact(elem.value))
  else if elem.value is TAddress then
    ComposeAddress('Address', TAddress(elem.value))
  else if elem.value is THumanName then
    ComposeHumanName('HumanName', THumanName(elem.value))
  else if elem.value is THumanId then
    ComposeHumanId('HumanId', THumanId(elem.value));
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConstraint(element : IXmlDomElement) : TConstraint;
var
  child : IXMLDOMElement;
begin
  result := TConstraint.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'type') then
        result.type_ := child.text
      else if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'purpose') then
        result.purpose := child.text
      else if (child.nodeName = 'element') then
        result.Element.Add(ParseConstraintElement(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConstraint(name : string; elem : TConstraint);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('type',elem.type_);
  Text('name',elem.name);
  Text('purpose',elem.purpose);
  for i := 0 to elem.Element.Count - 1 do
    ComposeConstraintElement('element', elem.Element[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConstraint : TConstraint;
begin
  result := TConstraint.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'type') then
        result.type_ := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'purpose') then
        result.purpose := FJson.itemValue
      else if (FJson.ItemName = 'elements') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Element.Add(ParseConstraintElement);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConstraint(name : string; elem : TConstraint);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('type',elem.type_);
  Prop('name',elem.name);
  Prop('purpose',elem.purpose);
  if elem.Element.Count > 0 then
  begin
    FJson.valueObject('elements');
    for i := 0 to elem.Element.Count - 1 do
      ComposeConstraintElement('element',elem.Element[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseNarrativeImage(element : IXmlDomElement) : TNarrativeImage;
var
  child : IXMLDOMElement;
begin
  result := TNarrativeImage.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'mimeType') then
        result.mimeType := child.text
      else if (child.nodeName = 'content') then
        result.content := ParseAdvBuffer(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeNarrativeImage(name : string; elem : TNarrativeImage);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('mimeType',elem.mimeType);
  ComposeAdvBuffer('content', elem.content);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseNarrativeImage : TNarrativeImage;
begin
  result := TNarrativeImage.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'mimeType') then
        result.mimeType := FJson.itemValue
      else if (FJson.ItemName = 'content') then
        result.content := ParseAdvBuffer
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeNarrativeImage(name : string; elem : TNarrativeImage);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('mimeType',elem.mimeType);
  ComposeAdvBuffer('content', elem.content);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseNarrativeMap(element : IXmlDomElement) : TNarrativeMap;
var
  child : IXMLDOMElement;
begin
  result := TNarrativeMap.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'text') then
        result.text := child.text
      else if (child.nodeName = 'data') then
        result.data := child.text
      else if (child.nodeName = 'source') then
        result.source := TNarrativeMapSource(ParseEnum(CODES_TNarrativeMapSource, child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeNarrativeMap(name : string; elem : TNarrativeMap);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('text',elem.text);
  Text('data',elem.data);
  Text('source',CODES_TNarrativeMapSource[elem.source]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseNarrativeMap : TNarrativeMap;
begin
  result := TNarrativeMap.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'text') then
        result.text := FJson.itemValue
      else if (FJson.ItemName = 'data') then
        result.data := FJson.itemValue
      else if (FJson.ItemName = 'source') then
        result.source := TNarrativeMapSource(ParseEnum(CODES_TNarrativeMapSource))
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeNarrativeMap(name : string; elem : TNarrativeMap);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('text',elem.text);
  Prop('data',elem.data);
  Prop('source',CODES_TNarrativeMapSource[elem.source]);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseNarrative(element : IXmlDomElement) : TNarrative;
var
  child : IXMLDOMElement;
begin
  result := TNarrative.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'status') then
        result.status := TNarrativeStatus(ParseEnum(CODES_TNarrativeStatus, child))
      else if (child.nodeName = 'xhtml') then
        result.xhtml := ParseFhirXHtmlNode(child)
      else if (child.nodeName = 'image') then
        result.Image.Add(ParseNarrativeImage(child))
      else if (child.nodeName = 'map') then
        result.Map.Add(ParseNarrativeMap(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeNarrative(name : string; elem : TNarrative);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('status',CODES_TNarrativeStatus[elem.status]);
  ComposeFhirXHtmlNode('xhtml', elem.xhtml);
  for i := 0 to elem.Image.Count - 1 do
    ComposeNarrativeImage('image', elem.Image[i]);
  for i := 0 to elem.Map.Count - 1 do
    ComposeNarrativeMap('map', elem.Map[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseNarrative : TNarrative;
begin
  result := TNarrative.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'status') then
        result.status := TNarrativeStatus(ParseEnum(CODES_TNarrativeStatus))
      else if (FJson.ItemName = 'xhtml') then
        result.xhtml := ParseFhirXHtmlNode
      else if (FJson.ItemName = 'images') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Image.Add(ParseNarrativeImage);
        FJson.Next;
      end
      else if (FJson.ItemName = 'maps') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Map.Add(ParseNarrativeMap);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeNarrative(name : string; elem : TNarrative);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('status',CODES_TNarrativeStatus[elem.status]);
  ComposeFhirXHtmlNode('xhtml', elem.xhtml);
  if elem.Image.Count > 0 then
  begin
    FJson.valueObject('images');
    for i := 0 to elem.Image.Count - 1 do
      ComposeNarrativeImage('image',elem.Image[i]);
    FJson.FinishObject;
  end;
  if elem.Map.Count > 0 then
  begin
    FJson.valueObject('maps');
    for i := 0 to elem.Map.Count - 1 do
      ComposeNarrativeMap('map',elem.Map[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseCoding(element : IXmlDomElement) : TCoding;
var
  child : IXMLDOMElement;
begin
  result := TCoding.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'code') then
        result.code := child.text
      else if (child.nodeName = 'system') then
        result.system := child.text
      else if (child.nodeName = 'display') then
        result.display := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeCoding(name : string; elem : TCoding);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('code',elem.code);
  Text('system',elem.system);
  Text('display',elem.display);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseCoding : TCoding;
begin
  result := TCoding.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := FJson.itemValue
      else if (FJson.ItemName = 'system') then
        result.system := FJson.itemValue
      else if (FJson.ItemName = 'display') then
        result.display := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeCoding(name : string; elem : TCoding);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('code',elem.code);
  Prop('system',elem.system);
  Prop('display',elem.display);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseInterval_Quantity(element : IXmlDomElement) : TInterval_Quantity;
var
  child : IXMLDOMElement;
begin
  result := TInterval_Quantity.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'low') then
        result.low := ParseQuantity(child)
      else if (child.nodeName = 'high') then
        result.high := ParseQuantity(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeInterval_Quantity(name : string; elem : TInterval_Quantity);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeQuantity('low', elem.low);
  ComposeQuantity('high', elem.high);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseInterval_Quantity : TInterval_Quantity;
begin
  result := TInterval_Quantity.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'low') then
        result.low := ParseQuantity
      else if (FJson.ItemName = 'high') then
        result.high := ParseQuantity
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeInterval_Quantity(name : string; elem : TInterval_Quantity);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeQuantity('low', elem.low);
  ComposeQuantity('high', elem.high);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseInterval_DateTime(element : IXmlDomElement) : TInterval_DateTime;
var
  child : IXMLDOMElement;
begin
  result := TInterval_DateTime.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'low') then
        result.low := child.text
      else if (child.nodeName = 'high') then
        result.high := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeInterval_DateTime(name : string; elem : TInterval_DateTime);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('low',elem.low);
  Text('high',elem.high);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseInterval_DateTime : TInterval_DateTime;
begin
  result := TInterval_DateTime.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'low') then
        result.low := FJson.itemValue
      else if (FJson.ItemName = 'high') then
        result.high := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeInterval_DateTime(name : string; elem : TInterval_DateTime);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('low',elem.low);
  Prop('high',elem.high);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseInterval_Date(element : IXmlDomElement) : TInterval_Date;
var
  child : IXMLDOMElement;
begin
  result := TInterval_Date.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'low') then
        result.low := child.text
      else if (child.nodeName = 'high') then
        result.high := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeInterval_Date(name : string; elem : TInterval_Date);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('low',elem.low);
  Text('high',elem.high);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseInterval_Date : TInterval_Date;
begin
  result := TInterval_Date.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'low') then
        result.low := FJson.itemValue
      else if (FJson.ItemName = 'high') then
        result.high := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeInterval_Date(name : string; elem : TInterval_Date);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('low',elem.low);
  Prop('high',elem.high);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseQuantity(element : IXmlDomElement) : TQuantity;
var
  child : IXMLDOMElement;
begin
  result := TQuantity.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'value') then
        result.value := ParseSmartDecimal(child)
      else if (child.nodeName = 'status') then
        result.status := TQuantityStatus(ParseEnum(CODES_TQuantityStatus, child))
      else if (child.nodeName = 'units') then
        result.units := child.text
      else if (child.nodeName = 'code') then
        result.code := child.text
      else if (child.nodeName = 'system') then
        result.system := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeQuantity(name : string; elem : TQuantity);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeSmartDecimal('value', elem.value);
  Text('status',CODES_TQuantityStatus[elem.status]);
  Text('units',elem.units);
  Text('code',elem.code);
  Text('system',elem.system);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseQuantity : TQuantity;
begin
  result := TQuantity.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'value') then
        result.value := ParseSmartDecimal
      else if (FJson.ItemName = 'status') then
        result.status := TQuantityStatus(ParseEnum(CODES_TQuantityStatus))
      else if (FJson.ItemName = 'units') then
        result.units := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := FJson.itemValue
      else if (FJson.ItemName = 'system') then
        result.system := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeQuantity(name : string; elem : TQuantity);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeSmartDecimal('value', elem.value);
  Prop('status',CODES_TQuantityStatus[elem.status]);
  Prop('units',elem.units);
  Prop('code',elem.code);
  Prop('system',elem.system);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseChoiceValue(element : IXmlDomElement) : TChoiceValue;
var
  child : IXMLDOMElement;
begin
  result := TChoiceValue.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'code') then
        result.code := child.text
      else if (child.nodeName = 'display') then
        result.display := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeChoiceValue(name : string; elem : TChoiceValue);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('code',elem.code);
  Text('display',elem.display);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseChoiceValue : TChoiceValue;
begin
  result := TChoiceValue.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := FJson.itemValue
      else if (FJson.ItemName = 'display') then
        result.display := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeChoiceValue(name : string; elem : TChoiceValue);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('code',elem.code);
  Prop('display',elem.display);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseChoice(element : IXmlDomElement) : TChoice;
var
  child : IXMLDOMElement;
begin
  result := TChoice.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'code') then
        result.code := child.text
      else if (child.nodeName = 'value') then
        result.Value.Add(ParseChoiceValue(child))
      else if (child.nodeName = 'isOrdered') then
        result.isOrdered := StringToBoolean(child.text)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeChoice(name : string; elem : TChoice);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('code',elem.code);
  for i := 0 to elem.Value.Count - 1 do
    ComposeChoiceValue('value', elem.Value[i]);
  Text('isOrdered',BooleanToString(elem.isOrdered));
  FXml.close(name);
end;

function TFHIRJsonParser.ParseChoice : TChoice;
begin
  result := TChoice.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := FJson.itemValue
      else if (FJson.ItemName = 'values') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Value.Add(ParseChoiceValue);
        FJson.Next;
      end
      else if (FJson.ItemName = 'isOrdered') then
        result.isOrdered := StringToBoolean(FJson.itemValue)
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeChoice(name : string; elem : TChoice);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('code',elem.code);
  if elem.Value.Count > 0 then
  begin
    FJson.valueObject('values');
    for i := 0 to elem.Value.Count - 1 do
      ComposeChoiceValue('value',elem.Value[i]);
    FJson.FinishObject;
  end;
  Prop('isOrdered',BooleanToString(elem.isOrdered));
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseAttachment(element : IXmlDomElement) : TAttachment;
var
  child : IXMLDOMElement;
begin
  result := TAttachment.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'mimeType') then
        result.mimeType := child.text
      else if (child.nodeName = 'data') then
        result.data := ParseAdvBuffer(child)
      else if (child.nodeName = 'url') then
        result.url := child.text
      else if (child.nodeName = 'hash') then
        result.hash := ParseAdvBuffer(child)
      else if (child.nodeName = 'lang') then
        result.lang := child.text
      else if (child.nodeName = 'title') then
        result.title := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeAttachment(name : string; elem : TAttachment);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('mimeType',elem.mimeType);
  ComposeAdvBuffer('data', elem.data);
  Text('url',elem.url);
  ComposeAdvBuffer('hash', elem.hash);
  Text('lang',elem.lang);
  Text('title',elem.title);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseAttachment : TAttachment;
begin
  result := TAttachment.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'mimeType') then
        result.mimeType := FJson.itemValue
      else if (FJson.ItemName = 'data') then
        result.data := ParseAdvBuffer
      else if (FJson.ItemName = 'url') then
        result.url := FJson.itemValue
      else if (FJson.ItemName = 'hash') then
        result.hash := ParseAdvBuffer
      else if (FJson.ItemName = 'lang') then
        result.lang := FJson.itemValue
      else if (FJson.ItemName = 'title') then
        result.title := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeAttachment(name : string; elem : TAttachment);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('mimeType',elem.mimeType);
  ComposeAdvBuffer('data', elem.data);
  Prop('url',elem.url);
  ComposeAdvBuffer('hash', elem.hash);
  Prop('lang',elem.lang);
  Prop('title',elem.title);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseRatio(element : IXmlDomElement) : TRatio;
var
  child : IXMLDOMElement;
begin
  result := TRatio.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'numerator') then
        result.numerator := ParseQuantity(child)
      else if (child.nodeName = 'denominator') then
        result.denominator := ParseQuantity(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeRatio(name : string; elem : TRatio);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeQuantity('numerator', elem.numerator);
  ComposeQuantity('denominator', elem.denominator);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseRatio : TRatio;
begin
  result := TRatio.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'numerator') then
        result.numerator := ParseQuantity
      else if (FJson.ItemName = 'denominator') then
        result.denominator := ParseQuantity
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeRatio(name : string; elem : TRatio);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeQuantity('numerator', elem.numerator);
  ComposeQuantity('denominator', elem.denominator);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseCodeableConcept(element : IXmlDomElement) : TCodeableConcept;
var
  child : IXMLDOMElement;
begin
  result := TCodeableConcept.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'coding') then
        result.Coding.Add(ParseCoding(child))
      else if (child.nodeName = 'text') then
        result.text := child.text
      else if (child.nodeName = 'primary') then
        result.primary := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeCodeableConcept(name : string; elem : TCodeableConcept);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  for i := 0 to elem.Coding.Count - 1 do
    ComposeCoding('coding', elem.Coding[i]);
  Text('text',elem.text);
  Text('primary',elem.primary);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseCodeableConcept : TCodeableConcept;
begin
  result := TCodeableConcept.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'codings') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Coding.Add(ParseCoding);
        FJson.Next;
      end
      else if (FJson.ItemName = 'text') then
        result.text := FJson.itemValue
      else if (FJson.ItemName = 'primary') then
        result.primary := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeCodeableConcept(name : string; elem : TCodeableConcept);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  if elem.Coding.Count > 0 then
  begin
    FJson.valueObject('codings');
    for i := 0 to elem.Coding.Count - 1 do
      ComposeCoding('coding',elem.Coding[i]);
    FJson.FinishObject;
  end;
  Prop('text',elem.text);
  Prop('primary',elem.primary);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseIdentifier(element : IXmlDomElement) : TIdentifier;
var
  child : IXMLDOMElement;
begin
  result := TIdentifier.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'system') then
        result.system := child.text
      else if (child.nodeName = 'id') then
        result.id := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeIdentifier(name : string; elem : TIdentifier);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('system',elem.system);
  Text('id',elem.id);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseIdentifier : TIdentifier;
begin
  result := TIdentifier.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'system') then
        result.system := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeIdentifier(name : string; elem : TIdentifier);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('system',elem.system);
  Prop('id',elem.id);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseScheduleRepeat(element : IXmlDomElement) : TScheduleRepeat;
var
  child : IXMLDOMElement;
begin
  result := TScheduleRepeat.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'frequency') then
        result.frequency := StringToInteger32(child.text)
      else if (child.nodeName = 'when') then
        result.when := TEventTiming(ParseEnum(CODES_TEventTiming, child))
      else if (child.nodeName = 'duration') then
        result.duration := ParseQuantity(child)
      else if (child.nodeName = 'count') then
        result.count := StringToInteger32(child.text)
      else if (child.nodeName = 'end') then
        result.end_ := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeScheduleRepeat(name : string; elem : TScheduleRepeat);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('frequency',IntegerToString(elem.frequency));
  Text('when',CODES_TEventTiming[elem.when]);
  ComposeQuantity('duration', elem.duration);
  Text('count',IntegerToString(elem.count));
  Text('end',elem.end_);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseScheduleRepeat : TScheduleRepeat;
begin
  result := TScheduleRepeat.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'frequency') then
        result.frequency := StringToInteger32(FJson.itemValue)
      else if (FJson.ItemName = 'when') then
        result.when := TEventTiming(ParseEnum(CODES_TEventTiming))
      else if (FJson.ItemName = 'duration') then
        result.duration := ParseQuantity
      else if (FJson.ItemName = 'count') then
        result.count := StringToInteger32(FJson.itemValue)
      else if (FJson.ItemName = 'end') then
        result.end_ := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeScheduleRepeat(name : string; elem : TScheduleRepeat);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('frequency',IntegerToString(elem.frequency));
  Prop('when',CODES_TEventTiming[elem.when]);
  ComposeQuantity('duration', elem.duration);
  Prop('count',IntegerToString(elem.count));
  Prop('end',elem.end_);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseSchedule(element : IXmlDomElement) : TSchedule;
var
  child : IXMLDOMElement;
begin
  result := TSchedule.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'event') then
        result.Event.Add(ParseInterval_dateTime(child))
      else if (child.nodeName = 'repeat') then
        result.repeat_ := ParseScheduleRepeat(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeSchedule(name : string; elem : TSchedule);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  for i := 0 to elem.Event.Count - 1 do
    ComposeInterval_dateTime('event', elem.Event[i]);
  ComposeScheduleRepeat('repeat', elem.repeat_);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseSchedule : TSchedule;
begin
  result := TSchedule.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'events') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Event.Add(ParseInterval_dateTime);
        FJson.Next;
      end
      else if (FJson.ItemName = 'repeat') then
        result.repeat_ := ParseScheduleRepeat
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeSchedule(name : string; elem : TSchedule);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  if elem.Event.Count > 0 then
  begin
    FJson.valueObject('events');
    for i := 0 to elem.Event.Count - 1 do
      ComposeInterval_dateTime('event',elem.Event[i]);
    FJson.FinishObject;
  end;
  ComposeScheduleRepeat('repeat', elem.repeat_);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseContact(element : IXmlDomElement) : TContact;
var
  child : IXMLDOMElement;
begin
  result := TContact.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'system') then
        result.system := TContactSystem(ParseEnum(CODES_TContactSystem, child))
      else if (child.nodeName = 'value') then
        result.value := child.text
      else if (child.nodeName = 'use') then
        result.use := TContactUse(ParseEnum(CODES_TContactUse, child))
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_dateTime(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeContact(name : string; elem : TContact);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('system',CODES_TContactSystem[elem.system]);
  Text('value',elem.value);
  Text('use',CODES_TContactUse[elem.use]);
  ComposeInterval_dateTime('period', elem.period);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseContact : TContact;
begin
  result := TContact.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'system') then
        result.system := TContactSystem(ParseEnum(CODES_TContactSystem))
      else if (FJson.ItemName = 'value') then
        result.value := FJson.itemValue
      else if (FJson.ItemName = 'use') then
        result.use := TContactUse(ParseEnum(CODES_TContactUse))
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_dateTime
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeContact(name : string; elem : TContact);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('system',CODES_TContactSystem[elem.system]);
  Prop('value',elem.value);
  Prop('use',CODES_TContactUse[elem.use]);
  ComposeInterval_dateTime('period', elem.period);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseAddressPart(element : IXmlDomElement) : TAddressPart;
var
  child : IXMLDOMElement;
begin
  result := TAddressPart.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'type') then
        result.type_ := TAddressPartType(ParseEnum(CODES_TAddressPartType, child))
      else if (child.nodeName = 'value') then
        result.value := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeAddressPart(name : string; elem : TAddressPart);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('type',CODES_TAddressPartType[elem.type_]);
  Text('value',elem.value);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseAddressPart : TAddressPart;
begin
  result := TAddressPart.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'type') then
        result.type_ := TAddressPartType(ParseEnum(CODES_TAddressPartType))
      else if (FJson.ItemName = 'value') then
        result.value := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeAddressPart(name : string; elem : TAddressPart);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('type',CODES_TAddressPartType[elem.type_]);
  Prop('value',elem.value);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseAddress(element : IXmlDomElement) : TAddress;
var
  child : IXMLDOMElement;
begin
  result := TAddress.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'use') then
        result.use := TAddressUse(ParseEnum(CODES_TAddressUse, child))
      else if (child.nodeName = 'text') then
        result.text := child.text
      else if (child.nodeName = 'part') then
        result.Part.Add(ParseAddressPart(child))
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_dateTime(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeAddress(name : string; elem : TAddress);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('use',CODES_TAddressUse[elem.use]);
  Text('text',elem.text);
  for i := 0 to elem.Part.Count - 1 do
    ComposeAddressPart('part', elem.Part[i]);
  ComposeInterval_dateTime('period', elem.period);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseAddress : TAddress;
begin
  result := TAddress.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'use') then
        result.use := TAddressUse(ParseEnum(CODES_TAddressUse))
      else if (FJson.ItemName = 'text') then
        result.text := FJson.itemValue
      else if (FJson.ItemName = 'parts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Part.Add(ParseAddressPart);
        FJson.Next;
      end
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_dateTime
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeAddress(name : string; elem : TAddress);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('use',CODES_TAddressUse[elem.use]);
  Prop('text',elem.text);
  if elem.Part.Count > 0 then
  begin
    FJson.valueObject('parts');
    for i := 0 to elem.Part.Count - 1 do
      ComposeAddressPart('part',elem.Part[i]);
    FJson.FinishObject;
  end;
  ComposeInterval_dateTime('period', elem.period);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseHumanNamePart(element : IXmlDomElement) : THumanNamePart;
var
  child : IXMLDOMElement;
begin
  result := THumanNamePart.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'type') then
        result.type_ := TNamePartType(ParseEnum(CODES_TNamePartType, child))
      else if (child.nodeName = 'value') then
        result.value := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeHumanNamePart(name : string; elem : THumanNamePart);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('type',CODES_TNamePartType[elem.type_]);
  Text('value',elem.value);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseHumanNamePart : THumanNamePart;
begin
  result := THumanNamePart.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'type') then
        result.type_ := TNamePartType(ParseEnum(CODES_TNamePartType))
      else if (FJson.ItemName = 'value') then
        result.value := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeHumanNamePart(name : string; elem : THumanNamePart);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('type',CODES_TNamePartType[elem.type_]);
  Prop('value',elem.value);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseHumanName(element : IXmlDomElement) : THumanName;
var
  child : IXMLDOMElement;
begin
  result := THumanName.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'use') then
        result.use := TNameUse(ParseEnum(CODES_TNameUse, child))
      else if (child.nodeName = 'text') then
        result.text := child.text
      else if (child.nodeName = 'part') then
        result.Part.Add(ParseHumanNamePart(child))
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_dateTime(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeHumanName(name : string; elem : THumanName);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('use',CODES_TNameUse[elem.use]);
  Text('text',elem.text);
  for i := 0 to elem.Part.Count - 1 do
    ComposeHumanNamePart('part', elem.Part[i]);
  ComposeInterval_dateTime('period', elem.period);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseHumanName : THumanName;
begin
  result := THumanName.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'use') then
        result.use := TNameUse(ParseEnum(CODES_TNameUse))
      else if (FJson.ItemName = 'text') then
        result.text := FJson.itemValue
      else if (FJson.ItemName = 'parts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Part.Add(ParseHumanNamePart);
        FJson.Next;
      end
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_dateTime
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeHumanName(name : string; elem : THumanName);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('use',CODES_TNameUse[elem.use]);
  Prop('text',elem.text);
  if elem.Part.Count > 0 then
  begin
    FJson.valueObject('parts');
    for i := 0 to elem.Part.Count - 1 do
      ComposeHumanNamePart('part',elem.Part[i]);
    FJson.FinishObject;
  end;
  ComposeInterval_dateTime('period', elem.period);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseHumanId(element : IXmlDomElement) : THumanId;
var
  child : IXMLDOMElement;
begin
  result := THumanId.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'type') then
        result.type_ := ParseCoding(child)
      else if (child.nodeName = 'identifier') then
        result.identifier := ParseIdentifier(child)
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_dateTime(child)
      else if (child.nodeName = 'assigner') then
        result.assigner := ParseFHIRResourceReference{TOrganization}(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeHumanId(name : string; elem : THumanId);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCoding('type', elem.type_);
  ComposeIdentifier('identifier', elem.identifier);
  ComposeInterval_dateTime('period', elem.period);
  ComposeFHIRResourceReference{TOrganization}('assigner', elem.assigner);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseHumanId : THumanId;
begin
  result := THumanId.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'type') then
        result.type_ := ParseCoding
      else if (FJson.ItemName = 'identifier') then
        result.identifier := ParseIdentifier
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_dateTime
      else if (FJson.ItemName = 'assigner') then
        result.assigner := ParseFHIRResourceReference{TOrganization}
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeHumanId(name : string; elem : THumanId);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCoding('type', elem.type_);
  ComposeIdentifier('identifier', elem.identifier);
  ComposeInterval_dateTime('period', elem.period);
  ComposeFHIRResourceReference{TOrganization}('assigner', elem.assigner);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConformancePublisher(element : IXmlDomElement) : TConformancePublisher;
var
  child : IXMLDOMElement;
begin
  result := TConformancePublisher.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConformancePublisher(name : string; elem : TConformancePublisher);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConformancePublisher : TConformancePublisher;
begin
  result := TConformancePublisher.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConformancePublisher(name : string; elem : TConformancePublisher);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConformanceSoftware(element : IXmlDomElement) : TConformanceSoftware;
var
  child : IXMLDOMElement;
begin
  result := TConformanceSoftware.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'version') then
        result.version := child.text
      else if (child.nodeName = 'releaseDate') then
        result.releaseDate := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConformanceSoftware(name : string; elem : TConformanceSoftware);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  Text('version',elem.version);
  Text('releaseDate',elem.releaseDate);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConformanceSoftware : TConformanceSoftware;
begin
  result := TConformanceSoftware.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'version') then
        result.version := FJson.itemValue
      else if (FJson.ItemName = 'releaseDate') then
        result.releaseDate := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConformanceSoftware(name : string; elem : TConformanceSoftware);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  Prop('version',elem.version);
  Prop('releaseDate',elem.releaseDate);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConformanceOperation(element : IXmlDomElement) : TConformanceOperation;
var
  child : IXMLDOMElement;
begin
  result := TConformanceOperation.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'read') then
        result.read := StringToBoolean(child.text)
      else if (child.nodeName = 'vread') then
        result.vread := StringToBoolean(child.text)
      else if (child.nodeName = 'update') then
        result.update := StringToBoolean(child.text)
      else if (child.nodeName = 'delete') then
        result.delete := StringToBoolean(child.text)
      else if (child.nodeName = 'validate') then
        result.validate := StringToBoolean(child.text)
      else if (child.nodeName = 'history') then
        result.history := StringToBoolean(child.text)
      else if (child.nodeName = 'transaction') then
        result.transaction := ParseConformanceOperationTransaction(child)
      else if (child.nodeName = 'search') then
        result.search := ParseConformanceOperationSearch(child)
      else if (child.nodeName = 'create') then
        result.create_ := ParseConformanceOperationCreate(child)
      else if (child.nodeName = 'updates') then
        result.updates := StringToBoolean(child.text)
      else if (child.nodeName = 'schema') then
        result.schema := StringToBoolean(child.text)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConformanceOperation(name : string; elem : TConformanceOperation);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('read',BooleanToString(elem.read));
  Text('vread',BooleanToString(elem.vread));
  Text('update',BooleanToString(elem.update));
  Text('delete',BooleanToString(elem.delete));
  Text('validate',BooleanToString(elem.validate));
  Text('history',BooleanToString(elem.history));
  ComposeConformanceOperationTransaction('transaction', elem.transaction);
  ComposeConformanceOperationSearch('search', elem.search);
  ComposeConformanceOperationCreate('create', elem.create_);
  Text('updates',BooleanToString(elem.updates));
  Text('schema',BooleanToString(elem.schema));
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConformanceOperation : TConformanceOperation;
begin
  result := TConformanceOperation.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'read') then
        result.read := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'vread') then
        result.vread := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'update') then
        result.update := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'delete') then
        result.delete := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'validate') then
        result.validate := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'history') then
        result.history := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'transaction') then
        result.transaction := ParseConformanceOperationTransaction
      else if (FJson.ItemName = 'search') then
        result.search := ParseConformanceOperationSearch
      else if (FJson.ItemName = 'create') then
        result.create_ := ParseConformanceOperationCreate
      else if (FJson.ItemName = 'updates') then
        result.updates := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'schema') then
        result.schema := StringToBoolean(FJson.itemValue)
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConformanceOperation(name : string; elem : TConformanceOperation);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('read',BooleanToString(elem.read));
  Prop('vread',BooleanToString(elem.vread));
  Prop('update',BooleanToString(elem.update));
  Prop('delete',BooleanToString(elem.delete));
  Prop('validate',BooleanToString(elem.validate));
  Prop('history',BooleanToString(elem.history));
  ComposeConformanceOperationTransaction('transaction', elem.transaction);
  ComposeConformanceOperationSearch('search', elem.search);
  ComposeConformanceOperationCreate('create', elem.create_);
  Prop('updates',BooleanToString(elem.updates));
  Prop('schema',BooleanToString(elem.schema));
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConformanceOperationTransaction(element : IXmlDomElement) : TConformanceOperationTransaction;
var
  child : IXMLDOMElement;
begin
  result := TConformanceOperationTransaction.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.Name.Add(child.text)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConformanceOperationTransaction(name : string; elem : TConformanceOperationTransaction);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  for i := 0 to elem.Name.Count - 1 do
    Text('name', elem.Name[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConformanceOperationTransaction : TConformanceOperationTransaction;
begin
  result := TConformanceOperationTransaction.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'names') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Name.Add(FJson.itemValue);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConformanceOperationTransaction(name : string; elem : TConformanceOperationTransaction);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  if elem.Name.Count > 0 then
  begin
    FJson.valueObject('names');
    for i := 0 to elem.Name.Count - 1 do
      Prop('name',elem.Name[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConformanceOperationSearch(element : IXmlDomElement) : TConformanceOperationSearch;
var
  child : IXMLDOMElement;
begin
  result := TConformanceOperationSearch.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'param') then
        result.Param.Add(child.text)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConformanceOperationSearch(name : string; elem : TConformanceOperationSearch);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  for i := 0 to elem.Param.Count - 1 do
    Text('param', elem.Param[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConformanceOperationSearch : TConformanceOperationSearch;
begin
  result := TConformanceOperationSearch.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'params') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Param.Add(FJson.itemValue);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConformanceOperationSearch(name : string; elem : TConformanceOperationSearch);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  if elem.Param.Count > 0 then
  begin
    FJson.valueObject('params');
    for i := 0 to elem.Param.Count - 1 do
      Prop('param',elem.Param[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConformanceOperationCreate(element : IXmlDomElement) : TConformanceOperationCreate;
var
  child : IXMLDOMElement;
begin
  result := TConformanceOperationCreate.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := TResourceIdSource(ParseEnum(CODES_TResourceIdSource, child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConformanceOperationCreate(name : string; elem : TConformanceOperationCreate);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id',CODES_TResourceIdSource[elem.id]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConformanceOperationCreate : TConformanceOperationCreate;
begin
  result := TConformanceOperationCreate.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := TResourceIdSource(ParseEnum(CODES_TResourceIdSource))
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConformanceOperationCreate(name : string; elem : TConformanceOperationCreate);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id',CODES_TResourceIdSource[elem.id]);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseConformance(element : IXmlDomElement) : TConformance;
var
  child : IXMLDOMElement;
begin
  result := TConformance.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'date') then
        result.date := child.text
      else if (child.nodeName = 'publisher') then
        result.publisher := ParseConformancePublisher(child)
      else if (child.nodeName = 'software') then
        result.software := ParseConformanceSoftware(child)
      else if (child.nodeName = 'mode') then
        result.mode := TRestfulConformanceMode(ParseEnum(CODES_TRestfulConformanceMode, child))
      else if (child.nodeName = 'resource') then
        result.resource := ParseConstraint(child)
      else if (child.nodeName = 'operation') then
        result.operation := ParseConformanceOperation(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeConformance(name : string; elem : TConformance);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  Text('date',elem.date);
  ComposeConformancePublisher('publisher', elem.publisher);
  ComposeConformanceSoftware('software', elem.software);
  Text('mode',CODES_TRestfulConformanceMode[elem.mode]);
  ComposeConstraint('resource', elem.resource);
  ComposeConformanceOperation('operation', elem.operation);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseConformance : TConformance;
begin
  result := TConformance.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'date') then
        result.date := FJson.itemValue
      else if (FJson.ItemName = 'publisher') then
        result.publisher := ParseConformancePublisher
      else if (FJson.ItemName = 'software') then
        result.software := ParseConformanceSoftware
      else if (FJson.ItemName = 'mode') then
        result.mode := TRestfulConformanceMode(ParseEnum(CODES_TRestfulConformanceMode))
      else if (FJson.ItemName = 'resource') then
        result.resource := ParseConstraint
      else if (FJson.ItemName = 'operation') then
        result.operation := ParseConformanceOperation
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeConformance(name : string; elem : TConformance);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  Prop('date',elem.date);
  ComposeConformancePublisher('publisher', elem.publisher);
  ComposeConformanceSoftware('software', elem.software);
  Prop('mode',CODES_TRestfulConformanceMode[elem.mode]);
  ComposeConstraint('resource', elem.resource);
  ComposeConformanceOperation('operation', elem.operation);
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentAuthor(element : IXmlDomElement) : TDocumentAuthor;
var
  child : IXMLDOMElement;
begin
  result := TDocumentAuthor.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'time') then
        result.time := child.text
      else if (child.nodeName = 'party') then
        result.party := ParseFHIRResourceReference{Resource}(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentAuthor(name : string; elem : TDocumentAuthor);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('time',elem.time);
  ComposeFHIRResourceReference{Resource}('party', elem.party);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentAuthor : TDocumentAuthor;
begin
  result := TDocumentAuthor.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'time') then
        result.time := FJson.itemValue
      else if (FJson.ItemName = 'party') then
        result.party := ParseFHIRResourceReference{Resource}
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentAuthor(name : string; elem : TDocumentAuthor);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('time',elem.time);
  ComposeFHIRResourceReference{Resource}('party', elem.party);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentAttestor(element : IXmlDomElement) : TDocumentAttestor;
var
  child : IXMLDOMElement;
begin
  result := TDocumentAttestor.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'mode') then
        result.mode := TDocumentAuthenticationMode(ParseEnum(CODES_TDocumentAuthenticationMode, child))
      else if (child.nodeName = 'time') then
        result.time := child.text
      else if (child.nodeName = 'party') then
        result.party := ParseFHIRResourceReference{Resource}(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentAttestor(name : string; elem : TDocumentAttestor);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('mode',CODES_TDocumentAuthenticationMode[elem.mode]);
  Text('time',elem.time);
  ComposeFHIRResourceReference{Resource}('party', elem.party);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentAttestor : TDocumentAttestor;
begin
  result := TDocumentAttestor.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'mode') then
        result.mode := TDocumentAuthenticationMode(ParseEnum(CODES_TDocumentAuthenticationMode))
      else if (FJson.ItemName = 'time') then
        result.time := FJson.itemValue
      else if (FJson.ItemName = 'party') then
        result.party := ParseFHIRResourceReference{Resource}
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentAttestor(name : string; elem : TDocumentAttestor);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('mode',CODES_TDocumentAuthenticationMode[elem.mode]);
  Prop('time',elem.time);
  ComposeFHIRResourceReference{Resource}('party', elem.party);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentSection(element : IXmlDomElement) : TDocumentSection;
var
  child : IXMLDOMElement;
begin
  result := TDocumentSection.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'type') then
        result.type_ := ParseCodeableConcept(child)
      else if (child.nodeName = 'instant') then
        result.instant := XMLDateTimeStringToDateTime(child.text)
      else if (child.nodeName = 'author') then
        result.author := ParseDocumentSectionAuthor(child)
      else if (child.nodeName = 'enterer') then
        result.enterer := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'subject') then
        result.subject := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'informant') then
        result.informant := ParseFHIRResourceReference{TPerson}(child)
      else if (child.nodeName = 'content') then
        result.content := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'section') then
        result.Section.Add(ParseDocumentSection(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentSection(name : string; elem : TDocumentSection);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCodeableConcept('type', elem.type_);
  Text('instant',DateTimeToXMLDateTimeString(elem.instant));
  ComposeDocumentSectionAuthor('author', elem.author);
  ComposeFHIRResourceReference{Resource}('enterer', elem.enterer);
  ComposeFHIRResourceReference{Resource}('subject', elem.subject);
  ComposeFHIRResourceReference{TPerson}('informant', elem.informant);
  ComposeFHIRResourceReference{Resource}('content', elem.content);
  for i := 0 to elem.Section.Count - 1 do
    ComposeDocumentSection('section', elem.Section[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentSection : TDocumentSection;
begin
  result := TDocumentSection.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'type') then
        result.type_ := ParseCodeableConcept
      else if (FJson.ItemName = 'instant') then
        result.instant := XMLDateTimeStringToDateTime(FJson.itemValue)
      else if (FJson.ItemName = 'author') then
        result.author := ParseDocumentSectionAuthor
      else if (FJson.ItemName = 'enterer') then
        result.enterer := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'subject') then
        result.subject := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'informant') then
        result.informant := ParseFHIRResourceReference{TPerson}
      else if (FJson.ItemName = 'content') then
        result.content := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'sections') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Section.Add(ParseDocumentSection);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentSection(name : string; elem : TDocumentSection);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCodeableConcept('type', elem.type_);
  Prop('instant',DateTimeToXMLDateTimeString(elem.instant));
  ComposeDocumentSectionAuthor('author', elem.author);
  ComposeFHIRResourceReference{Resource}('enterer', elem.enterer);
  ComposeFHIRResourceReference{Resource}('subject', elem.subject);
  ComposeFHIRResourceReference{TPerson}('informant', elem.informant);
  ComposeFHIRResourceReference{Resource}('content', elem.content);
  if elem.Section.Count > 0 then
  begin
    FJson.valueObject('sections');
    for i := 0 to elem.Section.Count - 1 do
      ComposeDocumentSection('section',elem.Section[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentSectionAuthor(element : IXmlDomElement) : TDocumentSectionAuthor;
var
  child : IXMLDOMElement;
begin
  result := TDocumentSectionAuthor.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'time') then
        result.time := child.text
      else if (child.nodeName = 'party') then
        result.party := ParseFHIRResourceReference{Resource}(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentSectionAuthor(name : string; elem : TDocumentSectionAuthor);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('time',elem.time);
  ComposeFHIRResourceReference{Resource}('party', elem.party);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentSectionAuthor : TDocumentSectionAuthor;
begin
  result := TDocumentSectionAuthor.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'time') then
        result.time := FJson.itemValue
      else if (FJson.ItemName = 'party') then
        result.party := ParseFHIRResourceReference{Resource}
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentSectionAuthor(name : string; elem : TDocumentSectionAuthor);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('time',elem.time);
  ComposeFHIRResourceReference{Resource}('party', elem.party);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocument(element : IXmlDomElement) : TDocument;
var
  child : IXMLDOMElement;
begin
  result := TDocument.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'instant') then
        result.instant := XMLDateTimeStringToDateTime(child.text)
      else if (child.nodeName = 'type') then
        result.type_ := ParseCodeableConcept(child)
      else if (child.nodeName = 'title') then
        result.title := child.text
      else if (child.nodeName = 'setId') then
        result.setId := child.text
      else if (child.nodeName = 'version') then
        result.version := StringToInteger32(child.text)
      else if (child.nodeName = 'replaces') then
        result.replaces := child.text
      else if (child.nodeName = 'subject') then
        result.subject := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'author') then
        result.Author.Add(ParseDocumentAuthor(child))
      else if (child.nodeName = 'attestor') then
        result.Attestor.Add(ParseDocumentAttestor(child))
      else if (child.nodeName = 'recipient') then
        result.Recipient.Add(ParseFHIRResourceReference{Resource}(child))
      else if (child.nodeName = 'custodian') then
        result.custodian := ParseFHIRResourceReference{TOrganization}(child)
      else if (child.nodeName = 'event') then
        result.event := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'encounter') then
        result.encounter := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'section') then
        result.Section.Add(ParseDocumentSection(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocument(name : string; elem : TDocument);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  Text('instant',DateTimeToXMLDateTimeString(elem.instant));
  ComposeCodeableConcept('type', elem.type_);
  Text('title',elem.title);
  Text('setId',elem.setId);
  Text('version',IntegerToString(elem.version));
  Text('replaces',elem.replaces);
  ComposeFHIRResourceReference{Resource}('subject', elem.subject);
  for i := 0 to elem.Author.Count - 1 do
    ComposeDocumentAuthor('author', elem.Author[i]);
  for i := 0 to elem.Attestor.Count - 1 do
    ComposeDocumentAttestor('attestor', elem.Attestor[i]);
  for i := 0 to elem.Recipient.Count - 1 do
    ComposeFHIRResourceReference{Resource}('recipient', elem.Recipient[i]);
  ComposeFHIRResourceReference{TOrganization}('custodian', elem.custodian);
  ComposeFHIRResourceReference{Resource}('event', elem.event);
  ComposeFHIRResourceReference{Resource}('encounter', elem.encounter);
  for i := 0 to elem.Section.Count - 1 do
    ComposeDocumentSection('section', elem.Section[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocument : TDocument;
begin
  result := TDocument.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'instant') then
        result.instant := XMLDateTimeStringToDateTime(FJson.itemValue)
      else if (FJson.ItemName = 'type') then
        result.type_ := ParseCodeableConcept
      else if (FJson.ItemName = 'title') then
        result.title := FJson.itemValue
      else if (FJson.ItemName = 'setId') then
        result.setId := FJson.itemValue
      else if (FJson.ItemName = 'version') then
        result.version := StringToInteger32(FJson.itemValue)
      else if (FJson.ItemName = 'replaces') then
        result.replaces := FJson.itemValue
      else if (FJson.ItemName = 'subject') then
        result.subject := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'authors') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Author.Add(ParseDocumentAuthor);
        FJson.Next;
      end
      else if (FJson.ItemName = 'attestors') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Attestor.Add(ParseDocumentAttestor);
        FJson.Next;
      end
      else if (FJson.ItemName = 'recipients') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Recipient.Add(ParseFHIRResourceReference{Resource});
        FJson.Next;
      end
      else if (FJson.ItemName = 'custodian') then
        result.custodian := ParseFHIRResourceReference{TOrganization}
      else if (FJson.ItemName = 'event') then
        result.event := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'encounter') then
        result.encounter := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'sections') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Section.Add(ParseDocumentSection);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocument(name : string; elem : TDocument);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  Prop('instant',DateTimeToXMLDateTimeString(elem.instant));
  ComposeCodeableConcept('type', elem.type_);
  Prop('title',elem.title);
  Prop('setId',elem.setId);
  Prop('version',IntegerToString(elem.version));
  Prop('replaces',elem.replaces);
  ComposeFHIRResourceReference{Resource}('subject', elem.subject);
  if elem.Author.Count > 0 then
  begin
    FJson.valueObject('authors');
    for i := 0 to elem.Author.Count - 1 do
      ComposeDocumentAuthor('author',elem.Author[i]);
    FJson.FinishObject;
  end;
  if elem.Attestor.Count > 0 then
  begin
    FJson.valueObject('attestors');
    for i := 0 to elem.Attestor.Count - 1 do
      ComposeDocumentAttestor('attestor',elem.Attestor[i]);
    FJson.FinishObject;
  end;
  if elem.Recipient.Count > 0 then
  begin
    FJson.valueObject('recipients');
    for i := 0 to elem.Recipient.Count - 1 do
      ComposeFHIRResourceReference{Resource}('recipient',elem.Recipient[i]);
    FJson.FinishObject;
  end;
  ComposeFHIRResourceReference{TOrganization}('custodian', elem.custodian);
  ComposeFHIRResourceReference{Resource}('event', elem.event);
  ComposeFHIRResourceReference{Resource}('encounter', elem.encounter);
  if elem.Section.Count > 0 then
  begin
    FJson.valueObject('sections');
    for i := 0 to elem.Section.Count - 1 do
      ComposeDocumentSection('section',elem.Section[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessageResponse(element : IXmlDomElement) : TMessageResponse;
var
  child : IXMLDOMElement;
begin
  result := TMessageResponse.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'code') then
        result.code := TResponseCode(ParseEnum(CODES_TResponseCode, child))
      else if (child.nodeName = 'duplicate') then
        result.duplicate := StringToBoolean(child.text)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessageResponse(name : string; elem : TMessageResponse);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id',elem.id);
  Text('code',CODES_TResponseCode[elem.code]);
  Text('duplicate',BooleanToString(elem.duplicate));
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessageResponse : TMessageResponse;
begin
  result := TMessageResponse.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := TResponseCode(ParseEnum(CODES_TResponseCode))
      else if (FJson.ItemName = 'duplicate') then
        result.duplicate := StringToBoolean(FJson.itemValue)
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessageResponse(name : string; elem : TMessageResponse);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id',elem.id);
  Prop('code',CODES_TResponseCode[elem.code]);
  Prop('duplicate',BooleanToString(elem.duplicate));
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessage(element : IXmlDomElement) : TMessage;
var
  child : IXMLDOMElement;
begin
  result := TMessage.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'threadId') then
        result.threadId := child.text
      else if (child.nodeName = 'instant') then
        result.instant := XMLDateTimeStringToDateTime(child.text)
      else if (child.nodeName = 'event') then
        result.event := child.text
      else if (child.nodeName = 'response') then
        result.response := ParseMessageResponse(child)
      else if (child.nodeName = 'source') then
        result.source := ParseFHIRResourceReference{TDevice}(child)
      else if (child.nodeName = 'destination') then
        result.destination := ParseFHIRResourceReference{TDevice}(child)
      else if (child.nodeName = 'enterer') then
        result.enterer := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'author') then
        result.author := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'responsible') then
        result.responsible := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'effective') then
        result.effective := ParseInterval_dateTime(child)
      else if (child.nodeName = 'reason') then
        result.reason := ParseCodeableConcept(child)
      else if (child.nodeName = 'data') then
        result.data := ParseFHIRResourceReference{Resource}(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessage(name : string; elem : TMessage);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  Text('threadId',elem.threadId);
  Text('instant',DateTimeToXMLDateTimeString(elem.instant));
  Text('event',elem.event);
  ComposeMessageResponse('response', elem.response);
  ComposeFHIRResourceReference{TDevice}('source', elem.source);
  ComposeFHIRResourceReference{TDevice}('destination', elem.destination);
  ComposeFHIRResourceReference{Resource}('enterer', elem.enterer);
  ComposeFHIRResourceReference{Resource}('author', elem.author);
  ComposeFHIRResourceReference{Resource}('responsible', elem.responsible);
  ComposeInterval_dateTime('effective', elem.effective);
  ComposeCodeableConcept('reason', elem.reason);
  ComposeFHIRResourceReference{Resource}('data', elem.data);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessage : TMessage;
begin
  result := TMessage.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'threadId') then
        result.threadId := FJson.itemValue
      else if (FJson.ItemName = 'instant') then
        result.instant := XMLDateTimeStringToDateTime(FJson.itemValue)
      else if (FJson.ItemName = 'event') then
        result.event := FJson.itemValue
      else if (FJson.ItemName = 'response') then
        result.response := ParseMessageResponse
      else if (FJson.ItemName = 'source') then
        result.source := ParseFHIRResourceReference{TDevice}
      else if (FJson.ItemName = 'destination') then
        result.destination := ParseFHIRResourceReference{TDevice}
      else if (FJson.ItemName = 'enterer') then
        result.enterer := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'author') then
        result.author := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'responsible') then
        result.responsible := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'effective') then
        result.effective := ParseInterval_dateTime
      else if (FJson.ItemName = 'reason') then
        result.reason := ParseCodeableConcept
      else if (FJson.ItemName = 'data') then
        result.data := ParseFHIRResourceReference{Resource}
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessage(name : string; elem : TMessage);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  Prop('threadId',elem.threadId);
  Prop('instant',DateTimeToXMLDateTimeString(elem.instant));
  Prop('event',elem.event);
  ComposeMessageResponse('response', elem.response);
  ComposeFHIRResourceReference{TDevice}('source', elem.source);
  ComposeFHIRResourceReference{TDevice}('destination', elem.destination);
  ComposeFHIRResourceReference{Resource}('enterer', elem.enterer);
  ComposeFHIRResourceReference{Resource}('author', elem.author);
  ComposeFHIRResourceReference{Resource}('responsible', elem.responsible);
  ComposeInterval_dateTime('effective', elem.effective);
  ComposeCodeableConcept('reason', elem.reason);
  ComposeFHIRResourceReference{Resource}('data', elem.data);
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessageConformancePublisher(element : IXmlDomElement) : TMessageConformancePublisher;
var
  child : IXMLDOMElement;
begin
  result := TMessageConformancePublisher.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessageConformancePublisher(name : string; elem : TMessageConformancePublisher);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessageConformancePublisher : TMessageConformancePublisher;
begin
  result := TMessageConformancePublisher.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessageConformancePublisher(name : string; elem : TMessageConformancePublisher);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessageConformanceSoftware(element : IXmlDomElement) : TMessageConformanceSoftware;
var
  child : IXMLDOMElement;
begin
  result := TMessageConformanceSoftware.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'version') then
        result.version := child.text
      else if (child.nodeName = 'releaseDate') then
        result.releaseDate := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessageConformanceSoftware(name : string; elem : TMessageConformanceSoftware);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  Text('version',elem.version);
  Text('releaseDate',elem.releaseDate);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessageConformanceSoftware : TMessageConformanceSoftware;
begin
  result := TMessageConformanceSoftware.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'version') then
        result.version := FJson.itemValue
      else if (FJson.ItemName = 'releaseDate') then
        result.releaseDate := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessageConformanceSoftware(name : string; elem : TMessageConformanceSoftware);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  Prop('version',elem.version);
  Prop('releaseDate',elem.releaseDate);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessageConformanceEvent(element : IXmlDomElement) : TMessageConformanceEvent;
var
  child : IXMLDOMElement;
begin
  result := TMessageConformanceEvent.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'code') then
        result.code := child.text
      else if (child.nodeName = 'resource') then
        result.resource := child.text
      else if (child.nodeName = 'mode') then
        result.mode := TMessageConformanceEventMode(ParseEnum(CODES_TMessageConformanceEventMode, child))
      else if (child.nodeName = 'request') then
        result.request := ParseMessageConformanceEventRequest(child)
      else if (child.nodeName = 'response') then
        result.response := ParseMessageConformanceEventResponse(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessageConformanceEvent(name : string; elem : TMessageConformanceEvent);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('code',elem.code);
  Text('resource',elem.resource);
  Text('mode',CODES_TMessageConformanceEventMode[elem.mode]);
  ComposeMessageConformanceEventRequest('request', elem.request);
  ComposeMessageConformanceEventResponse('response', elem.response);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessageConformanceEvent : TMessageConformanceEvent;
begin
  result := TMessageConformanceEvent.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := FJson.itemValue
      else if (FJson.ItemName = 'resource') then
        result.resource := FJson.itemValue
      else if (FJson.ItemName = 'mode') then
        result.mode := TMessageConformanceEventMode(ParseEnum(CODES_TMessageConformanceEventMode))
      else if (FJson.ItemName = 'request') then
        result.request := ParseMessageConformanceEventRequest
      else if (FJson.ItemName = 'response') then
        result.response := ParseMessageConformanceEventResponse
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessageConformanceEvent(name : string; elem : TMessageConformanceEvent);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('code',elem.code);
  Prop('resource',elem.resource);
  Prop('mode',CODES_TMessageConformanceEventMode[elem.mode]);
  ComposeMessageConformanceEventRequest('request', elem.request);
  ComposeMessageConformanceEventResponse('response', elem.response);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessageConformanceEventRequest(element : IXmlDomElement) : TMessageConformanceEventRequest;
var
  child : IXMLDOMElement;
begin
  result := TMessageConformanceEventRequest.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'resource') then
        result.Resource.Add(ParseConstraint(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessageConformanceEventRequest(name : string; elem : TMessageConformanceEventRequest);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  for i := 0 to elem.Resource.Count - 1 do
    ComposeConstraint('resource', elem.Resource[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessageConformanceEventRequest : TMessageConformanceEventRequest;
begin
  result := TMessageConformanceEventRequest.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'resources') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Resource.Add(ParseConstraint);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessageConformanceEventRequest(name : string; elem : TMessageConformanceEventRequest);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  if elem.Resource.Count > 0 then
  begin
    FJson.valueObject('resources');
    for i := 0 to elem.Resource.Count - 1 do
      ComposeConstraint('resource',elem.Resource[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessageConformanceEventResponse(element : IXmlDomElement) : TMessageConformanceEventResponse;
var
  child : IXMLDOMElement;
begin
  result := TMessageConformanceEventResponse.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'resource') then
        result.Resource.Add(ParseConstraint(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessageConformanceEventResponse(name : string; elem : TMessageConformanceEventResponse);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  for i := 0 to elem.Resource.Count - 1 do
    ComposeConstraint('resource', elem.Resource[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessageConformanceEventResponse : TMessageConformanceEventResponse;
begin
  result := TMessageConformanceEventResponse.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'resources') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Resource.Add(ParseConstraint);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessageConformanceEventResponse(name : string; elem : TMessageConformanceEventResponse);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  if elem.Resource.Count > 0 then
  begin
    FJson.valueObject('resources');
    for i := 0 to elem.Resource.Count - 1 do
      ComposeConstraint('resource',elem.Resource[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseMessageConformance(element : IXmlDomElement) : TMessageConformance;
var
  child : IXMLDOMElement;
begin
  result := TMessageConformance.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'date') then
        result.date := child.text
      else if (child.nodeName = 'publisher') then
        result.publisher := ParseMessageConformancePublisher(child)
      else if (child.nodeName = 'software') then
        result.software := ParseMessageConformanceSoftware(child)
      else if (child.nodeName = 'event') then
        result.Event.Add(ParseMessageConformanceEvent(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeMessageConformance(name : string; elem : TMessageConformance);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  Text('date',elem.date);
  ComposeMessageConformancePublisher('publisher', elem.publisher);
  ComposeMessageConformanceSoftware('software', elem.software);
  for i := 0 to elem.Event.Count - 1 do
    ComposeMessageConformanceEvent('event', elem.Event[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseMessageConformance : TMessageConformance;
begin
  result := TMessageConformance.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'date') then
        result.date := FJson.itemValue
      else if (FJson.ItemName = 'publisher') then
        result.publisher := ParseMessageConformancePublisher
      else if (FJson.ItemName = 'software') then
        result.software := ParseMessageConformanceSoftware
      else if (FJson.ItemName = 'events') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Event.Add(ParseMessageConformanceEvent);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeMessageConformance(name : string; elem : TMessageConformance);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  Prop('date',elem.date);
  ComposeMessageConformancePublisher('publisher', elem.publisher);
  ComposeMessageConformanceSoftware('software', elem.software);
  if elem.Event.Count > 0 then
  begin
    FJson.valueObject('events');
    for i := 0 to elem.Event.Count - 1 do
      ComposeMessageConformanceEvent('event',elem.Event[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseAgent(element : IXmlDomElement) : TAgent;
var
  child : IXMLDOMElement;
begin
  result := TAgent.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'person') then
        result.person := ParseFHIRResourceReference{TPerson}(child)
      else if (child.nodeName = 'organization') then
        result.organization := ParseFHIRResourceReference{TOrganization}(child)
      else if (child.nodeName = 'role') then
        result.Role.Add(ParseCodeableConcept(child))
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_date(child)
      else if (child.nodeName = 'identifier') then
        result.Identifier.Add(ParseHumanId(child))
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeAgent(name : string; elem : TAgent);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  ComposeFHIRResourceReference{TPerson}('person', elem.person);
  ComposeFHIRResourceReference{TOrganization}('organization', elem.organization);
  for i := 0 to elem.Role.Count - 1 do
    ComposeCodeableConcept('role', elem.Role[i]);
  ComposeInterval_date('period', elem.period);
  for i := 0 to elem.Identifier.Count - 1 do
    ComposeHumanId('identifier', elem.Identifier[i]);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseAgent : TAgent;
begin
  result := TAgent.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'person') then
        result.person := ParseFHIRResourceReference{TPerson}
      else if (FJson.ItemName = 'organization') then
        result.organization := ParseFHIRResourceReference{TOrganization}
      else if (FJson.ItemName = 'roles') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Role.Add(ParseCodeableConcept);
        FJson.Next;
      end
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_date
      else if (FJson.ItemName = 'identifiers') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Identifier.Add(ParseHumanId);
        FJson.Next;
      end
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeAgent(name : string; elem : TAgent);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  ComposeFHIRResourceReference{TPerson}('person', elem.person);
  ComposeFHIRResourceReference{TOrganization}('organization', elem.organization);
  if elem.Role.Count > 0 then
  begin
    FJson.valueObject('roles');
    for i := 0 to elem.Role.Count - 1 do
      ComposeCodeableConcept('role',elem.Role[i]);
    FJson.FinishObject;
  end;
  ComposeInterval_date('period', elem.period);
  if elem.Identifier.Count > 0 then
  begin
    FJson.valueObject('identifiers');
    for i := 0 to elem.Identifier.Count - 1 do
      ComposeHumanId('identifier',elem.Identifier[i]);
    FJson.FinishObject;
  end;
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseAnimalRelatedEntity(element : IXmlDomElement) : TAnimalRelatedEntity;
var
  child : IXMLDOMElement;
begin
  result := TAnimalRelatedEntity.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := ParseHumanId(child)
      else if (child.nodeName = 'role') then
        result.role := ParseCodeableConcept(child)
      else if (child.nodeName = 'name') then
        result.name := ParseHumanName(child)
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeAnimalRelatedEntity(name : string; elem : TAnimalRelatedEntity);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeHumanId('id', elem.id);
  ComposeCodeableConcept('role', elem.role);
  ComposeHumanName('name', elem.name);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseAnimalRelatedEntity : TAnimalRelatedEntity;
begin
  result := TAnimalRelatedEntity.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := ParseHumanId
      else if (FJson.ItemName = 'role') then
        result.role := ParseCodeableConcept
      else if (FJson.ItemName = 'name') then
        result.name := ParseHumanName
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeAnimalRelatedEntity(name : string; elem : TAnimalRelatedEntity);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeHumanId('id', elem.id);
  ComposeCodeableConcept('role', elem.role);
  ComposeHumanName('name', elem.name);
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseAnimal(element : IXmlDomElement) : TAnimal;
var
  child : IXMLDOMElement;
begin
  result := TAnimal.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'identifier') then
        result.Identifier.Add(ParseHumanId(child))
      else if (child.nodeName = 'name') then
        result.Name.Add(ParseHumanName(child))
      else if (child.nodeName = 'dob') then
        result.dob := child.text
      else if (child.nodeName = 'species') then
        result.species := ParseCodeableConcept(child)
      else if (child.nodeName = 'strain') then
        result.strain := ParseCodeableConcept(child)
      else if (child.nodeName = 'gender') then
        result.gender := ParseCodeableConcept(child)
      else if (child.nodeName = 'relatedEntity') then
        result.RelatedEntity.Add(ParseAnimalRelatedEntity(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeAnimal(name : string; elem : TAnimal);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  for i := 0 to elem.Identifier.Count - 1 do
    ComposeHumanId('identifier', elem.Identifier[i]);
  for i := 0 to elem.Name.Count - 1 do
    ComposeHumanName('name', elem.Name[i]);
  Text('dob',elem.dob);
  ComposeCodeableConcept('species', elem.species);
  ComposeCodeableConcept('strain', elem.strain);
  ComposeCodeableConcept('gender', elem.gender);
  for i := 0 to elem.RelatedEntity.Count - 1 do
    ComposeAnimalRelatedEntity('relatedEntity', elem.RelatedEntity[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseAnimal : TAnimal;
begin
  result := TAnimal.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'identifiers') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Identifier.Add(ParseHumanId);
        FJson.Next;
      end
      else if (FJson.ItemName = 'names') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Name.Add(ParseHumanName);
        FJson.Next;
      end
      else if (FJson.ItemName = 'dob') then
        result.dob := FJson.itemValue
      else if (FJson.ItemName = 'species') then
        result.species := ParseCodeableConcept
      else if (FJson.ItemName = 'strain') then
        result.strain := ParseCodeableConcept
      else if (FJson.ItemName = 'gender') then
        result.gender := ParseCodeableConcept
      else if (FJson.ItemName = 'relatedEntities') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.RelatedEntity.Add(ParseAnimalRelatedEntity);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeAnimal(name : string; elem : TAnimal);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  if elem.Identifier.Count > 0 then
  begin
    FJson.valueObject('identifiers');
    for i := 0 to elem.Identifier.Count - 1 do
      ComposeHumanId('identifier',elem.Identifier[i]);
    FJson.FinishObject;
  end;
  if elem.Name.Count > 0 then
  begin
    FJson.valueObject('names');
    for i := 0 to elem.Name.Count - 1 do
      ComposeHumanName('name',elem.Name[i]);
    FJson.FinishObject;
  end;
  Prop('dob',elem.dob);
  ComposeCodeableConcept('species', elem.species);
  ComposeCodeableConcept('strain', elem.strain);
  ComposeCodeableConcept('gender', elem.gender);
  if elem.RelatedEntity.Count > 0 then
  begin
    FJson.valueObject('relatedEntities');
    for i := 0 to elem.RelatedEntity.Count - 1 do
      ComposeAnimalRelatedEntity('relatedEntity',elem.RelatedEntity[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePrescriptionDispense(element : IXmlDomElement) : TPrescriptionDispense;
var
  child : IXMLDOMElement;
begin
  result := TPrescriptionDispense.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'repeats') then
        result.repeats := StringToInteger32(child.text)
      else if (child.nodeName = 'quantity') then
        result.quantity := ParseQuantity(child)
      else if (child.nodeName = 'dispenser') then
        result.dispenser := ParseFHIRResourceReference{Resource}(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePrescriptionDispense(name : string; elem : TPrescriptionDispense);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('repeats',IntegerToString(elem.repeats));
  ComposeQuantity('quantity', elem.quantity);
  ComposeFHIRResourceReference{Resource}('dispenser', elem.dispenser);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePrescriptionDispense : TPrescriptionDispense;
begin
  result := TPrescriptionDispense.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'repeats') then
        result.repeats := StringToInteger32(FJson.itemValue)
      else if (FJson.ItemName = 'quantity') then
        result.quantity := ParseQuantity
      else if (FJson.ItemName = 'dispenser') then
        result.dispenser := ParseFHIRResourceReference{Resource}
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePrescriptionDispense(name : string; elem : TPrescriptionDispense);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('repeats',IntegerToString(elem.repeats));
  ComposeQuantity('quantity', elem.quantity);
  ComposeFHIRResourceReference{Resource}('dispenser', elem.dispenser);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePrescriptionMedicine(element : IXmlDomElement) : TPrescriptionMedicine;
var
  child : IXMLDOMElement;
begin
  result := TPrescriptionMedicine.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'productCode') then
        result.productCode := ParseCoding(child)
      else if (child.nodeName = 'description') then
        result.description := child.text
      else if (child.nodeName = 'activeIngredient') then
        result.ActiveIngredient.Add(ParsePrescriptionMedicineActiveIngredient(child))
      else if (child.nodeName = 'inactiveIngredient') then
        result.InactiveIngredient.Add(ParsePrescriptionMedicineInactiveIngredient(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePrescriptionMedicine(name : string; elem : TPrescriptionMedicine);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCoding('productCode', elem.productCode);
  Text('description',elem.description);
  for i := 0 to elem.ActiveIngredient.Count - 1 do
    ComposePrescriptionMedicineActiveIngredient('activeIngredient', elem.ActiveIngredient[i]);
  for i := 0 to elem.InactiveIngredient.Count - 1 do
    ComposePrescriptionMedicineInactiveIngredient('inactiveIngredient', elem.InactiveIngredient[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePrescriptionMedicine : TPrescriptionMedicine;
begin
  result := TPrescriptionMedicine.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'productCode') then
        result.productCode := ParseCoding
      else if (FJson.ItemName = 'description') then
        result.description := FJson.itemValue
      else if (FJson.ItemName = 'activeIngredients') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.ActiveIngredient.Add(ParsePrescriptionMedicineActiveIngredient);
        FJson.Next;
      end
      else if (FJson.ItemName = 'inactiveIngredients') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.InactiveIngredient.Add(ParsePrescriptionMedicineInactiveIngredient);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePrescriptionMedicine(name : string; elem : TPrescriptionMedicine);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCoding('productCode', elem.productCode);
  Prop('description',elem.description);
  if elem.ActiveIngredient.Count > 0 then
  begin
    FJson.valueObject('activeIngredients');
    for i := 0 to elem.ActiveIngredient.Count - 1 do
      ComposePrescriptionMedicineActiveIngredient('activeIngredient',elem.ActiveIngredient[i]);
    FJson.FinishObject;
  end;
  if elem.InactiveIngredient.Count > 0 then
  begin
    FJson.valueObject('inactiveIngredients');
    for i := 0 to elem.InactiveIngredient.Count - 1 do
      ComposePrescriptionMedicineInactiveIngredient('inactiveIngredient',elem.InactiveIngredient[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePrescriptionMedicineActiveIngredient(element : IXmlDomElement) : TPrescriptionMedicineActiveIngredient;
var
  child : IXMLDOMElement;
begin
  result := TPrescriptionMedicineActiveIngredient.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'productCode') then
        result.productCode := ParseCoding(child)
      else if (child.nodeName = 'quantity') then
        result.quantity := ParseRatio(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePrescriptionMedicineActiveIngredient(name : string; elem : TPrescriptionMedicineActiveIngredient);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCoding('productCode', elem.productCode);
  ComposeRatio('quantity', elem.quantity);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePrescriptionMedicineActiveIngredient : TPrescriptionMedicineActiveIngredient;
begin
  result := TPrescriptionMedicineActiveIngredient.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'productCode') then
        result.productCode := ParseCoding
      else if (FJson.ItemName = 'quantity') then
        result.quantity := ParseRatio
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePrescriptionMedicineActiveIngredient(name : string; elem : TPrescriptionMedicineActiveIngredient);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCoding('productCode', elem.productCode);
  ComposeRatio('quantity', elem.quantity);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePrescriptionMedicineInactiveIngredient(element : IXmlDomElement) : TPrescriptionMedicineInactiveIngredient;
var
  child : IXMLDOMElement;
begin
  result := TPrescriptionMedicineInactiveIngredient.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'productCode') then
        result.productCode := ParseCoding(child)
      else if (child.nodeName = 'quantity') then
        result.quantity := ParseRatio(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePrescriptionMedicineInactiveIngredient(name : string; elem : TPrescriptionMedicineInactiveIngredient);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCoding('productCode', elem.productCode);
  ComposeRatio('quantity', elem.quantity);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePrescriptionMedicineInactiveIngredient : TPrescriptionMedicineInactiveIngredient;
begin
  result := TPrescriptionMedicineInactiveIngredient.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'productCode') then
        result.productCode := ParseCoding
      else if (FJson.ItemName = 'quantity') then
        result.quantity := ParseRatio
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePrescriptionMedicineInactiveIngredient(name : string; elem : TPrescriptionMedicineInactiveIngredient);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCoding('productCode', elem.productCode);
  ComposeRatio('quantity', elem.quantity);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePrescriptionAdministrationRequest(element : IXmlDomElement) : TPrescriptionAdministrationRequest;
var
  child : IXMLDOMElement;
begin
  result := TPrescriptionAdministrationRequest.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'description') then
        result.description := child.text
      else if (child.nodeName = 'totalPeriodicDosis') then
        result.totalPeriodicDosis := ParseRatio(child)
      else if (child.nodeName = 'start') then
        result.start := child.text
      else if (child.nodeName = 'end') then
        result.end_ := child.text
      else if (child.nodeName = 'duration') then
        result.duration := ParseQuantity(child)
      else if (child.nodeName = 'numberOfAdministrations') then
        result.numberOfAdministrations := StringToInteger32(child.text)
      else if (child.nodeName = 'dosageInstruction') then
        result.DosageInstruction.Add(ParsePrescriptionAdministrationRequestDosageInstruction(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePrescriptionAdministrationRequest(name : string; elem : TPrescriptionAdministrationRequest);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('description',elem.description);
  ComposeRatio('totalPeriodicDosis', elem.totalPeriodicDosis);
  Text('start',elem.start);
  Text('end',elem.end_);
  ComposeQuantity('duration', elem.duration);
  Text('numberOfAdministrations',IntegerToString(elem.numberOfAdministrations));
  for i := 0 to elem.DosageInstruction.Count - 1 do
    ComposePrescriptionAdministrationRequestDosageInstruction('dosageInstruction', elem.DosageInstruction[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePrescriptionAdministrationRequest : TPrescriptionAdministrationRequest;
begin
  result := TPrescriptionAdministrationRequest.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'description') then
        result.description := FJson.itemValue
      else if (FJson.ItemName = 'totalPeriodicDosis') then
        result.totalPeriodicDosis := ParseRatio
      else if (FJson.ItemName = 'start') then
        result.start := FJson.itemValue
      else if (FJson.ItemName = 'end') then
        result.end_ := FJson.itemValue
      else if (FJson.ItemName = 'duration') then
        result.duration := ParseQuantity
      else if (FJson.ItemName = 'numberOfAdministrations') then
        result.numberOfAdministrations := StringToInteger32(FJson.itemValue)
      else if (FJson.ItemName = 'dosageInstructions') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.DosageInstruction.Add(ParsePrescriptionAdministrationRequestDosageInstruction);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePrescriptionAdministrationRequest(name : string; elem : TPrescriptionAdministrationRequest);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('description',elem.description);
  ComposeRatio('totalPeriodicDosis', elem.totalPeriodicDosis);
  Prop('start',elem.start);
  Prop('end',elem.end_);
  ComposeQuantity('duration', elem.duration);
  Prop('numberOfAdministrations',IntegerToString(elem.numberOfAdministrations));
  if elem.DosageInstruction.Count > 0 then
  begin
    FJson.valueObject('dosageInstructions');
    for i := 0 to elem.DosageInstruction.Count - 1 do
      ComposePrescriptionAdministrationRequestDosageInstruction('dosageInstruction',elem.DosageInstruction[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePrescriptionAdministrationRequestDosageInstruction(element : IXmlDomElement) : TPrescriptionAdministrationRequestDosageInstruction;
var
  child : IXMLDOMElement;
begin
  result := TPrescriptionAdministrationRequestDosageInstruction.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'precondition') then
        result.Precondition.Add(ParseCodeableConcept(child))
      else if (child.nodeName = 'prn') then
        result.prn := TBooleanYesNo(ParseEnum(CODES_TBooleanYesNo, child))
      else if (child.nodeName = 'additionalInstruction') then
        result.AdditionalInstruction.Add(ParseCodeableConcept(child))
      else if (child.nodeName = 'route') then
        result.route := ParseCodeableConcept(child)
      else if (child.nodeName = 'doseQuantity') then
        result.dose := ParseQuantity(child)
      else if (child.nodeName = 'doseInterval_Quantity') then
        result.dose := ParseInterval_Quantity(child)
      else if (child.nodeName = 'rate') then
        result.rate := ParseQuantity(child)
      else if (child.nodeName = 'schedule') then
        result.Schedule.Add(ParseSchedule(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePrescriptionAdministrationRequestDosageInstruction(name : string; elem : TPrescriptionAdministrationRequestDosageInstruction);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  for i := 0 to elem.Precondition.Count - 1 do
    ComposeCodeableConcept('precondition', elem.Precondition[i]);
  Text('prn',CODES_TBooleanYesNo[elem.prn]);
  for i := 0 to elem.AdditionalInstruction.Count - 1 do
    ComposeCodeableConcept('additionalInstruction', elem.AdditionalInstruction[i]);
  ComposeCodeableConcept('route', elem.route);
  if elem.dose is TQuantity then
    ComposeQuantity('doseQuantity', TQuantity(elem.dose))
  else if elem.dose is TInterval_Quantity then
    ComposeInterval_Quantity('doseInterval_Quantity', TInterval_Quantity(elem.dose));
  ComposeQuantity('rate', elem.rate);
  for i := 0 to elem.Schedule.Count - 1 do
    ComposeSchedule('schedule', elem.Schedule[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePrescriptionAdministrationRequestDosageInstruction : TPrescriptionAdministrationRequestDosageInstruction;
begin
  result := TPrescriptionAdministrationRequestDosageInstruction.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'preconditions') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Precondition.Add(ParseCodeableConcept);
        FJson.Next;
      end
      else if (FJson.ItemName = 'prn') then
        result.prn := TBooleanYesNo(ParseEnum(CODES_TBooleanYesNo))
      else if (FJson.ItemName = 'additionalInstructions') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.AdditionalInstruction.Add(ParseCodeableConcept);
        FJson.Next;
      end
      else if (FJson.ItemName = 'route') then
        result.route := ParseCodeableConcept
      else if (FJson.ItemName = 'doseQuantity') then
        result.dose := ParseQuantity
      else if (FJson.ItemName = 'doseInterval_Quantity') then
        result.dose := ParseInterval_Quantity
      else if (FJson.ItemName = 'rate') then
        result.rate := ParseQuantity
      else if (FJson.ItemName = 'schedules') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Schedule.Add(ParseSchedule);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePrescriptionAdministrationRequestDosageInstruction(name : string; elem : TPrescriptionAdministrationRequestDosageInstruction);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  if elem.Precondition.Count > 0 then
  begin
    FJson.valueObject('preconditions');
    for i := 0 to elem.Precondition.Count - 1 do
      ComposeCodeableConcept('precondition',elem.Precondition[i]);
    FJson.FinishObject;
  end;
  Prop('prn',CODES_TBooleanYesNo[elem.prn]);
  if elem.AdditionalInstruction.Count > 0 then
  begin
    FJson.valueObject('additionalInstructions');
    for i := 0 to elem.AdditionalInstruction.Count - 1 do
      ComposeCodeableConcept('additionalInstruction',elem.AdditionalInstruction[i]);
    FJson.FinishObject;
  end;
  ComposeCodeableConcept('route', elem.route);
  if elem.dose is TQuantity then
    ComposeQuantity('doseQuantity', TQuantity(elem.dose))
  else if elem.dose is TInterval_Quantity then
    ComposeInterval_Quantity('doseInterval_Quantity', TInterval_Quantity(elem.dose));
  ComposeQuantity('rate', elem.rate);
  if elem.Schedule.Count > 0 then
  begin
    FJson.valueObject('schedules');
    for i := 0 to elem.Schedule.Count - 1 do
      ComposeSchedule('schedule',elem.Schedule[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePrescription(element : IXmlDomElement) : TPrescription;
var
  child : IXMLDOMElement;
begin
  result := TPrescription.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'identifier') then
        result.Identifier.Add(ParseHumanId(child))
      else if (child.nodeName = 'status') then
        result.status := TPrescriptionStatus(ParseEnum(CODES_TPrescriptionStatus, child))
      else if (child.nodeName = 'patient') then
        result.patient := ParseFHIRResourceReference{TPatient}(child)
      else if (child.nodeName = 'prescriber') then
        result.prescriber := ParseFHIRResourceReference{TAgent}(child)
      else if (child.nodeName = 'prescribed') then
        result.prescribed := child.text
      else if (child.nodeName = 'dispense') then
        result.dispense := ParsePrescriptionDispense(child)
      else if (child.nodeName = 'medicine') then
        result.medicine := ParsePrescriptionMedicine(child)
      else if (child.nodeName = 'administrationRequest') then
        result.administrationRequest := ParsePrescriptionAdministrationRequest(child)
      else if (child.nodeName = 'reason') then
        result.reason := ParseCodeableConcept(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePrescription(name : string; elem : TPrescription);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  for i := 0 to elem.Identifier.Count - 1 do
    ComposeHumanId('identifier', elem.Identifier[i]);
  Text('status',CODES_TPrescriptionStatus[elem.status]);
  ComposeFHIRResourceReference{TPatient}('patient', elem.patient);
  ComposeFHIRResourceReference{TAgent}('prescriber', elem.prescriber);
  Text('prescribed',elem.prescribed);
  ComposePrescriptionDispense('dispense', elem.dispense);
  ComposePrescriptionMedicine('medicine', elem.medicine);
  ComposePrescriptionAdministrationRequest('administrationRequest', elem.administrationRequest);
  ComposeCodeableConcept('reason', elem.reason);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePrescription : TPrescription;
begin
  result := TPrescription.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'identifiers') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Identifier.Add(ParseHumanId);
        FJson.Next;
      end
      else if (FJson.ItemName = 'status') then
        result.status := TPrescriptionStatus(ParseEnum(CODES_TPrescriptionStatus))
      else if (FJson.ItemName = 'patient') then
        result.patient := ParseFHIRResourceReference{TPatient}
      else if (FJson.ItemName = 'prescriber') then
        result.prescriber := ParseFHIRResourceReference{TAgent}
      else if (FJson.ItemName = 'prescribed') then
        result.prescribed := FJson.itemValue
      else if (FJson.ItemName = 'dispense') then
        result.dispense := ParsePrescriptionDispense
      else if (FJson.ItemName = 'medicine') then
        result.medicine := ParsePrescriptionMedicine
      else if (FJson.ItemName = 'administrationRequest') then
        result.administrationRequest := ParsePrescriptionAdministrationRequest
      else if (FJson.ItemName = 'reason') then
        result.reason := ParseCodeableConcept
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePrescription(name : string; elem : TPrescription);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  if elem.Identifier.Count > 0 then
  begin
    FJson.valueObject('identifiers');
    for i := 0 to elem.Identifier.Count - 1 do
      ComposeHumanId('identifier',elem.Identifier[i]);
    FJson.FinishObject;
  end;
  Prop('status',CODES_TPrescriptionStatus[elem.status]);
  ComposeFHIRResourceReference{TPatient}('patient', elem.patient);
  ComposeFHIRResourceReference{TAgent}('prescriber', elem.prescriber);
  Prop('prescribed',elem.prescribed);
  ComposePrescriptionDispense('dispense', elem.dispense);
  ComposePrescriptionMedicine('medicine', elem.medicine);
  ComposePrescriptionAdministrationRequest('administrationRequest', elem.administrationRequest);
  ComposeCodeableConcept('reason', elem.reason);
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePatient(element : IXmlDomElement) : TPatient;
var
  child : IXMLDOMElement;
begin
  result := TPatient.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'link') then
        result.Link_.Add(ParseFHIRResourceReference{TPatient}(child))
      else if (child.nodeName = 'active') then
        result.active := StringToBoolean(child.text)
      else if (child.nodeName = 'person') then
        result.person := ParseFHIRResourceReference{TPerson}(child)
      else if (child.nodeName = 'animal') then
        result.animal := ParseFHIRResourceReference{TAnimal}(child)
      else if (child.nodeName = 'provider') then
        result.provider := ParseFHIRResourceReference{TOrganization}(child)
      else if (child.nodeName = 'identifier') then
        result.Identifier.Add(ParseHumanId(child))
      else if (child.nodeName = 'diet') then
        result.diet := ParseCodeableConcept(child)
      else if (child.nodeName = 'confidentiality') then
        result.confidentiality := ParseCodeableConcept(child)
      else if (child.nodeName = 'recordLocation') then
        result.recordLocation := ParseCodeableConcept(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePatient(name : string; elem : TPatient);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  for i := 0 to elem.Link_.Count - 1 do
    ComposeFHIRResourceReference{TPatient}('link', elem.Link_[i]);
  Text('active',BooleanToString(elem.active));
  ComposeFHIRResourceReference{TPerson}('person', elem.person);
  ComposeFHIRResourceReference{TAnimal}('animal', elem.animal);
  ComposeFHIRResourceReference{TOrganization}('provider', elem.provider);
  for i := 0 to elem.Identifier.Count - 1 do
    ComposeHumanId('identifier', elem.Identifier[i]);
  ComposeCodeableConcept('diet', elem.diet);
  ComposeCodeableConcept('confidentiality', elem.confidentiality);
  ComposeCodeableConcept('recordLocation', elem.recordLocation);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePatient : TPatient;
begin
  result := TPatient.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'links') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Link_.Add(ParseFHIRResourceReference{TPatient});
        FJson.Next;
      end
      else if (FJson.ItemName = 'active') then
        result.active := StringToBoolean(FJson.itemValue)
      else if (FJson.ItemName = 'person') then
        result.person := ParseFHIRResourceReference{TPerson}
      else if (FJson.ItemName = 'animal') then
        result.animal := ParseFHIRResourceReference{TAnimal}
      else if (FJson.ItemName = 'provider') then
        result.provider := ParseFHIRResourceReference{TOrganization}
      else if (FJson.ItemName = 'identifiers') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Identifier.Add(ParseHumanId);
        FJson.Next;
      end
      else if (FJson.ItemName = 'diet') then
        result.diet := ParseCodeableConcept
      else if (FJson.ItemName = 'confidentiality') then
        result.confidentiality := ParseCodeableConcept
      else if (FJson.ItemName = 'recordLocation') then
        result.recordLocation := ParseCodeableConcept
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePatient(name : string; elem : TPatient);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  if elem.Link_.Count > 0 then
  begin
    FJson.valueObject('links');
    for i := 0 to elem.Link_.Count - 1 do
      ComposeFHIRResourceReference{TPatient}('link',elem.Link_[i]);
    FJson.FinishObject;
  end;
  Prop('active',BooleanToString(elem.active));
  ComposeFHIRResourceReference{TPerson}('person', elem.person);
  ComposeFHIRResourceReference{TAnimal}('animal', elem.animal);
  ComposeFHIRResourceReference{TOrganization}('provider', elem.provider);
  if elem.Identifier.Count > 0 then
  begin
    FJson.valueObject('identifiers');
    for i := 0 to elem.Identifier.Count - 1 do
      ComposeHumanId('identifier',elem.Identifier[i]);
    FJson.FinishObject;
  end;
  ComposeCodeableConcept('diet', elem.diet);
  ComposeCodeableConcept('confidentiality', elem.confidentiality);
  ComposeCodeableConcept('recordLocation', elem.recordLocation);
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseOrganizationName(element : IXmlDomElement) : TOrganizationName;
var
  child : IXMLDOMElement;
begin
  result := TOrganizationName.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'value') then
        result.value := child.text
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_date(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeOrganizationName(name : string; elem : TOrganizationName);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('value',elem.value);
  ComposeInterval_date('period', elem.period);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseOrganizationName : TOrganizationName;
begin
  result := TOrganizationName.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'value') then
        result.value := FJson.itemValue
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_date
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeOrganizationName(name : string; elem : TOrganizationName);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('value',elem.value);
  ComposeInterval_date('period', elem.period);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseOrganizationAccreditation(element : IXmlDomElement) : TOrganizationAccreditation;
var
  child : IXMLDOMElement;
begin
  result := TOrganizationAccreditation.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := ParseIdentifier(child)
      else if (child.nodeName = 'code') then
        result.code := ParseCodeableConcept(child)
      else if (child.nodeName = 'institution') then
        result.institution := ParseFHIRResourceReference{TOrganization}(child)
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_date(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeOrganizationAccreditation(name : string; elem : TOrganizationAccreditation);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeIdentifier('id', elem.id);
  ComposeCodeableConcept('code', elem.code);
  ComposeFHIRResourceReference{TOrganization}('institution', elem.institution);
  ComposeInterval_date('period', elem.period);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseOrganizationAccreditation : TOrganizationAccreditation;
begin
  result := TOrganizationAccreditation.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := ParseIdentifier
      else if (FJson.ItemName = 'code') then
        result.code := ParseCodeableConcept
      else if (FJson.ItemName = 'institution') then
        result.institution := ParseFHIRResourceReference{TOrganization}
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_date
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeOrganizationAccreditation(name : string; elem : TOrganizationAccreditation);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeIdentifier('id', elem.id);
  ComposeCodeableConcept('code', elem.code);
  ComposeFHIRResourceReference{TOrganization}('institution', elem.institution);
  ComposeInterval_date('period', elem.period);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseOrganizationRelatedOrganization(element : IXmlDomElement) : TOrganizationRelatedOrganization;
var
  child : IXMLDOMElement;
begin
  result := TOrganizationRelatedOrganization.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := ParseHumanId(child)
      else if (child.nodeName = 'code') then
        result.code := ParseCodeableConcept(child)
      else if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_date(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeOrganizationRelatedOrganization(name : string; elem : TOrganizationRelatedOrganization);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeHumanId('id', elem.id);
  ComposeCodeableConcept('code', elem.code);
  Text('name',elem.name);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  ComposeInterval_date('period', elem.period);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseOrganizationRelatedOrganization : TOrganizationRelatedOrganization;
begin
  result := TOrganizationRelatedOrganization.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := ParseHumanId
      else if (FJson.ItemName = 'code') then
        result.code := ParseCodeableConcept
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_date
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeOrganizationRelatedOrganization(name : string; elem : TOrganizationRelatedOrganization);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeHumanId('id', elem.id);
  ComposeCodeableConcept('code', elem.code);
  Prop('name',elem.name);
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  ComposeInterval_date('period', elem.period);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseOrganization(element : IXmlDomElement) : TOrganization;
var
  child : IXMLDOMElement;
begin
  result := TOrganization.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'identifier') then
        result.Identifier.Add(ParseHumanId(child))
      else if (child.nodeName = 'name') then
        result.Name.Add(ParseOrganizationName(child))
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else if (child.nodeName = 'code') then
        result.code := ParseCodeableConcept(child)
      else if (child.nodeName = 'industryCode') then
        result.industryCode := ParseCodeableConcept(child)
      else if (child.nodeName = 'accreditation') then
        result.Accreditation.Add(ParseOrganizationAccreditation(child))
      else if (child.nodeName = 'relatedOrganization') then
        result.RelatedOrganization.Add(ParseOrganizationRelatedOrganization(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeOrganization(name : string; elem : TOrganization);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  for i := 0 to elem.Identifier.Count - 1 do
    ComposeHumanId('identifier', elem.Identifier[i]);
  for i := 0 to elem.Name.Count - 1 do
    ComposeOrganizationName('name', elem.Name[i]);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  ComposeCodeableConcept('code', elem.code);
  ComposeCodeableConcept('industryCode', elem.industryCode);
  for i := 0 to elem.Accreditation.Count - 1 do
    ComposeOrganizationAccreditation('accreditation', elem.Accreditation[i]);
  for i := 0 to elem.RelatedOrganization.Count - 1 do
    ComposeOrganizationRelatedOrganization('relatedOrganization', elem.RelatedOrganization[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseOrganization : TOrganization;
begin
  result := TOrganization.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'identifiers') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Identifier.Add(ParseHumanId);
        FJson.Next;
      end
      else if (FJson.ItemName = 'names') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Name.Add(ParseOrganizationName);
        FJson.Next;
      end
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else if (FJson.ItemName = 'code') then
        result.code := ParseCodeableConcept
      else if (FJson.ItemName = 'industryCode') then
        result.industryCode := ParseCodeableConcept
      else if (FJson.ItemName = 'accreditations') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Accreditation.Add(ParseOrganizationAccreditation);
        FJson.Next;
      end
      else if (FJson.ItemName = 'relatedOrganizations') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.RelatedOrganization.Add(ParseOrganizationRelatedOrganization);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeOrganization(name : string; elem : TOrganization);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  if elem.Identifier.Count > 0 then
  begin
    FJson.valueObject('identifiers');
    for i := 0 to elem.Identifier.Count - 1 do
      ComposeHumanId('identifier',elem.Identifier[i]);
    FJson.FinishObject;
  end;
  if elem.Name.Count > 0 then
  begin
    FJson.valueObject('names');
    for i := 0 to elem.Name.Count - 1 do
      ComposeOrganizationName('name',elem.Name[i]);
    FJson.FinishObject;
  end;
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  ComposeCodeableConcept('code', elem.code);
  ComposeCodeableConcept('industryCode', elem.industryCode);
  if elem.Accreditation.Count > 0 then
  begin
    FJson.valueObject('accreditations');
    for i := 0 to elem.Accreditation.Count - 1 do
      ComposeOrganizationAccreditation('accreditation',elem.Accreditation[i]);
    FJson.FinishObject;
  end;
  if elem.RelatedOrganization.Count > 0 then
  begin
    FJson.valueObject('relatedOrganizations');
    for i := 0 to elem.RelatedOrganization.Count - 1 do
      ComposeOrganizationRelatedOrganization('relatedOrganization',elem.RelatedOrganization[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentConformancePublisher(element : IXmlDomElement) : TDocumentConformancePublisher;
var
  child : IXMLDOMElement;
begin
  result := TDocumentConformancePublisher.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentConformancePublisher(name : string; elem : TDocumentConformancePublisher);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentConformancePublisher : TDocumentConformancePublisher;
begin
  result := TDocumentConformancePublisher.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentConformancePublisher(name : string; elem : TDocumentConformancePublisher);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentConformanceSoftware(element : IXmlDomElement) : TDocumentConformanceSoftware;
var
  child : IXMLDOMElement;
begin
  result := TDocumentConformanceSoftware.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'version') then
        result.version := child.text
      else if (child.nodeName = 'releaseDate') then
        result.releaseDate := child.text
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentConformanceSoftware(name : string; elem : TDocumentConformanceSoftware);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  Text('version',elem.version);
  Text('releaseDate',elem.releaseDate);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentConformanceSoftware : TDocumentConformanceSoftware;
begin
  result := TDocumentConformanceSoftware.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'version') then
        result.version := FJson.itemValue
      else if (FJson.ItemName = 'releaseDate') then
        result.releaseDate := FJson.itemValue
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentConformanceSoftware(name : string; elem : TDocumentConformanceSoftware);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  Prop('version',elem.version);
  Prop('releaseDate',elem.releaseDate);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentConformanceDocument(element : IXmlDomElement) : TDocumentConformanceDocument;
var
  child : IXMLDOMElement;
begin
  result := TDocumentConformanceDocument.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := child.text
      else if (child.nodeName = 'purpose') then
        result.purpose := child.text
      else if (child.nodeName = 'resource') then
        result.Resource.Add(ParseConstraint(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentConformanceDocument(name : string; elem : TDocumentConformanceDocument);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('name',elem.name);
  Text('purpose',elem.purpose);
  for i := 0 to elem.Resource.Count - 1 do
    ComposeConstraint('resource', elem.Resource[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentConformanceDocument : TDocumentConformanceDocument;
begin
  result := TDocumentConformanceDocument.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := FJson.itemValue
      else if (FJson.ItemName = 'purpose') then
        result.purpose := FJson.itemValue
      else if (FJson.ItemName = 'resources') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Resource.Add(ParseConstraint);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentConformanceDocument(name : string; elem : TDocumentConformanceDocument);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('name',elem.name);
  Prop('purpose',elem.purpose);
  if elem.Resource.Count > 0 then
  begin
    FJson.valueObject('resources');
    for i := 0 to elem.Resource.Count - 1 do
      ComposeConstraint('resource',elem.Resource[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseDocumentConformance(element : IXmlDomElement) : TDocumentConformance;
var
  child : IXMLDOMElement;
begin
  result := TDocumentConformance.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'date') then
        result.date := child.text
      else if (child.nodeName = 'publisher') then
        result.publisher := ParseDocumentConformancePublisher(child)
      else if (child.nodeName = 'software') then
        result.software := ParseDocumentConformanceSoftware(child)
      else if (child.nodeName = 'document') then
        result.Document.Add(ParseDocumentConformanceDocument(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeDocumentConformance(name : string; elem : TDocumentConformance);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  Text('date',elem.date);
  ComposeDocumentConformancePublisher('publisher', elem.publisher);
  ComposeDocumentConformanceSoftware('software', elem.software);
  for i := 0 to elem.Document.Count - 1 do
    ComposeDocumentConformanceDocument('document', elem.Document[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseDocumentConformance : TDocumentConformance;
begin
  result := TDocumentConformance.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'date') then
        result.date := FJson.itemValue
      else if (FJson.ItemName = 'publisher') then
        result.publisher := ParseDocumentConformancePublisher
      else if (FJson.ItemName = 'software') then
        result.software := ParseDocumentConformanceSoftware
      else if (FJson.ItemName = 'documents') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Document.Add(ParseDocumentConformanceDocument);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeDocumentConformance(name : string; elem : TDocumentConformance);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  Prop('date',elem.date);
  ComposeDocumentConformancePublisher('publisher', elem.publisher);
  ComposeDocumentConformanceSoftware('software', elem.software);
  if elem.Document.Count > 0 then
  begin
    FJson.valueObject('documents');
    for i := 0 to elem.Document.Count - 1 do
      ComposeDocumentConformanceDocument('document',elem.Document[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseLabReportRequestDetail(element : IXmlDomElement) : TLabReportRequestDetail;
var
  child : IXMLDOMElement;
begin
  result := TLabReportRequestDetail.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'requestOrderId') then
        result.requestOrderId := ParseIdentifier(child)
      else if (child.nodeName = 'receiverOrderId') then
        result.receiverOrderId := ParseIdentifier(child)
      else if (child.nodeName = 'requestTest') then
        result.RequestTest.Add(ParseCodeableConcept(child))
      else if (child.nodeName = 'requester') then
        result.requester := ParseFHIRResourceReference{Resource}(child)
      else if (child.nodeName = 'clinicalInfo') then
        result.clinicalInfo := ParseFHIRResourceReference{Resource}(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeLabReportRequestDetail(name : string; elem : TLabReportRequestDetail);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeIdentifier('requestOrderId', elem.requestOrderId);
  ComposeIdentifier('receiverOrderId', elem.receiverOrderId);
  for i := 0 to elem.RequestTest.Count - 1 do
    ComposeCodeableConcept('requestTest', elem.RequestTest[i]);
  ComposeFHIRResourceReference{Resource}('requester', elem.requester);
  ComposeFHIRResourceReference{Resource}('clinicalInfo', elem.clinicalInfo);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseLabReportRequestDetail : TLabReportRequestDetail;
begin
  result := TLabReportRequestDetail.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'requestOrderId') then
        result.requestOrderId := ParseIdentifier
      else if (FJson.ItemName = 'receiverOrderId') then
        result.receiverOrderId := ParseIdentifier
      else if (FJson.ItemName = 'requestTests') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.RequestTest.Add(ParseCodeableConcept);
        FJson.Next;
      end
      else if (FJson.ItemName = 'requester') then
        result.requester := ParseFHIRResourceReference{Resource}
      else if (FJson.ItemName = 'clinicalInfo') then
        result.clinicalInfo := ParseFHIRResourceReference{Resource}
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeLabReportRequestDetail(name : string; elem : TLabReportRequestDetail);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeIdentifier('requestOrderId', elem.requestOrderId);
  ComposeIdentifier('receiverOrderId', elem.receiverOrderId);
  if elem.RequestTest.Count > 0 then
  begin
    FJson.valueObject('requestTests');
    for i := 0 to elem.RequestTest.Count - 1 do
      ComposeCodeableConcept('requestTest',elem.RequestTest[i]);
    FJson.FinishObject;
  end;
  ComposeFHIRResourceReference{Resource}('requester', elem.requester);
  ComposeFHIRResourceReference{Resource}('clinicalInfo', elem.clinicalInfo);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseLabReportResultGroup(element : IXmlDomElement) : TLabReportResultGroup;
var
  child : IXMLDOMElement;
begin
  result := TLabReportResultGroup.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := ParseCodeableConcept(child)
      else if (child.nodeName = 'specimen') then
        result.specimen := ParseFHIRResourceReference{TSpecimen}(child)
      else if (child.nodeName = 'result') then
        result.Result.Add(ParseLabReportResultGroupResult(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeLabReportResultGroup(name : string; elem : TLabReportResultGroup);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCodeableConcept('name', elem.name);
  ComposeFHIRResourceReference{TSpecimen}('specimen', elem.specimen);
  for i := 0 to elem.Result.Count - 1 do
    ComposeLabReportResultGroupResult('result', elem.Result[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseLabReportResultGroup : TLabReportResultGroup;
begin
  result := TLabReportResultGroup.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := ParseCodeableConcept
      else if (FJson.ItemName = 'specimen') then
        result.specimen := ParseFHIRResourceReference{TSpecimen}
      else if (FJson.ItemName = 'results') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Result.Add(ParseLabReportResultGroupResult);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeLabReportResultGroup(name : string; elem : TLabReportResultGroup);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCodeableConcept('name', elem.name);
  ComposeFHIRResourceReference{TSpecimen}('specimen', elem.specimen);
  if elem.Result.Count > 0 then
  begin
    FJson.valueObject('results');
    for i := 0 to elem.Result.Count - 1 do
      ComposeLabReportResultGroupResult('result',elem.Result[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseLabReportResultGroupResult(element : IXmlDomElement) : TLabReportResultGroupResult;
var
  child : IXMLDOMElement;
begin
  result := TLabReportResultGroupResult.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'name') then
        result.name := ParseCodeableConcept(child)
      else if (child.nodeName = 'valueQuantity') then
        result.value := ParseQuantity(child)
      else if (child.nodeName = 'valueCodeableConcept') then
        result.value := ParseCodeableConcept(child)
      else if (child.nodeName = 'valueAttachment') then
        result.value := ParseAttachment(child)
      else if (child.nodeName = 'valueRatio') then
        result.value := ParseRatio(child)
      else if (child.nodeName = 'valueChoice') then
        result.value := ParseChoice(child)
      else if (child.nodeName = 'valueInterval_DateTime') then
        result.value := ParseInterval_DateTime(child)
      else if (child.nodeName = 'valueString') then
        result.value := ParseString(child)
      else if (child.nodeName = 'flag') then
        result.flag := TLabResultFlag(ParseEnum(CODES_TLabResultFlag, child))
      else if (child.nodeName = 'status') then
        result.status := TLabReportStatus(ParseEnum(CODES_TLabReportStatus, child))
      else if (child.nodeName = 'comments') then
        result.comments := child.text
      else if (child.nodeName = 'referenceRange') then
        result.ReferenceRange.Add(ParseLabReportResultGroupResultReferenceRange(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeLabReportResultGroupResult(name : string; elem : TLabReportResultGroupResult);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCodeableConcept('name', elem.name);
  if elem.value is TQuantity then
    ComposeQuantity('valueQuantity', TQuantity(elem.value))
  else if elem.value is TCodeableConcept then
    ComposeCodeableConcept('valueCodeableConcept', TCodeableConcept(elem.value))
  else if elem.value is TAttachment then
    ComposeAttachment('valueAttachment', TAttachment(elem.value))
  else if elem.value is TRatio then
    ComposeRatio('valueRatio', TRatio(elem.value))
  else if elem.value is TChoice then
    ComposeChoice('valueChoice', TChoice(elem.value))
  else if elem.value is TInterval_DateTime then
    ComposeInterval_DateTime('valueInterval_DateTime', TInterval_DateTime(elem.value))
  else if elem.value is TFHIRTypeString then
    Text('valueString', TFHIRTypeString(elem.value).value);
  Text('flag',CODES_TLabResultFlag[elem.flag]);
  Text('status',CODES_TLabReportStatus[elem.status]);
  Text('comments',elem.comments);
  for i := 0 to elem.ReferenceRange.Count - 1 do
    ComposeLabReportResultGroupResultReferenceRange('referenceRange', elem.ReferenceRange[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseLabReportResultGroupResult : TLabReportResultGroupResult;
begin
  result := TLabReportResultGroupResult.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'name') then
        result.name := ParseCodeableConcept
      else if (FJson.ItemName = 'valueQuantity') then
        result.value := ParseQuantity
      else if (FJson.ItemName = 'valueCodeableConcept') then
        result.value := ParseCodeableConcept
      else if (FJson.ItemName = 'valueAttachment') then
        result.value := ParseAttachment
      else if (FJson.ItemName = 'valueRatio') then
        result.value := ParseRatio
      else if (FJson.ItemName = 'valueChoice') then
        result.value := ParseChoice
      else if (FJson.ItemName = 'valueInterval_DateTime') then
        result.value := ParseInterval_DateTime
      else if (FJson.ItemName = 'valueString') then
        result.value := ParseString
      else if (FJson.ItemName = 'flag') then
        result.flag := TLabResultFlag(ParseEnum(CODES_TLabResultFlag))
      else if (FJson.ItemName = 'status') then
        result.status := TLabReportStatus(ParseEnum(CODES_TLabReportStatus))
      else if (FJson.ItemName = 'comments') then
        result.comments := FJson.itemValue
      else if (FJson.ItemName = 'referenceRanges') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.ReferenceRange.Add(ParseLabReportResultGroupResultReferenceRange);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeLabReportResultGroupResult(name : string; elem : TLabReportResultGroupResult);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCodeableConcept('name', elem.name);
  if elem.value is TQuantity then
    ComposeQuantity('valueQuantity', TQuantity(elem.value))
  else if elem.value is TCodeableConcept then
    ComposeCodeableConcept('valueCodeableConcept', TCodeableConcept(elem.value))
  else if elem.value is TAttachment then
    ComposeAttachment('valueAttachment', TAttachment(elem.value))
  else if elem.value is TRatio then
    ComposeRatio('valueRatio', TRatio(elem.value))
  else if elem.value is TChoice then
    ComposeChoice('valueChoice', TChoice(elem.value))
  else if elem.value is TInterval_DateTime then
    ComposeInterval_DateTime('valueInterval_DateTime', TInterval_DateTime(elem.value))
  else if elem.value is TFHIRTypeString then
    Prop('valueString', TFHIRTypeString(elem.value).value);
  Prop('flag',CODES_TLabResultFlag[elem.flag]);
  Prop('status',CODES_TLabReportStatus[elem.status]);
  Prop('comments',elem.comments);
  if elem.ReferenceRange.Count > 0 then
  begin
    FJson.valueObject('referenceRanges');
    for i := 0 to elem.ReferenceRange.Count - 1 do
      ComposeLabReportResultGroupResultReferenceRange('referenceRange',elem.ReferenceRange[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseLabReportResultGroupResultReferenceRange(element : IXmlDomElement) : TLabReportResultGroupResultReferenceRange;
var
  child : IXMLDOMElement;
begin
  result := TLabReportResultGroupResultReferenceRange.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'meaning') then
        result.meaning := ParseCodeableConcept(child)
      else if (child.nodeName = 'rangeQuantity') then
        result.range := ParseQuantity(child)
      else if (child.nodeName = 'rangeInterval_Quantity') then
        result.range := ParseInterval_Quantity(child)
      else if (child.nodeName = 'rangeString') then
        result.range := ParseString(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeLabReportResultGroupResultReferenceRange(name : string; elem : TLabReportResultGroupResultReferenceRange);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeCodeableConcept('meaning', elem.meaning);
  if elem.range is TQuantity then
    ComposeQuantity('rangeQuantity', TQuantity(elem.range))
  else if elem.range is TInterval_Quantity then
    ComposeInterval_Quantity('rangeInterval_Quantity', TInterval_Quantity(elem.range))
  else if elem.range is TFHIRTypeString then
    Text('rangeString', TFHIRTypeString(elem.range).value);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseLabReportResultGroupResultReferenceRange : TLabReportResultGroupResultReferenceRange;
begin
  result := TLabReportResultGroupResultReferenceRange.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'meaning') then
        result.meaning := ParseCodeableConcept
      else if (FJson.ItemName = 'rangeQuantity') then
        result.range := ParseQuantity
      else if (FJson.ItemName = 'rangeInterval_Quantity') then
        result.range := ParseInterval_Quantity
      else if (FJson.ItemName = 'rangeString') then
        result.range := ParseString
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeLabReportResultGroupResultReferenceRange(name : string; elem : TLabReportResultGroupResultReferenceRange);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeCodeableConcept('meaning', elem.meaning);
  if elem.range is TQuantity then
    ComposeQuantity('rangeQuantity', TQuantity(elem.range))
  else if elem.range is TInterval_Quantity then
    ComposeInterval_Quantity('rangeInterval_Quantity', TInterval_Quantity(elem.range))
  else if elem.range is TFHIRTypeString then
    Prop('rangeString', TFHIRTypeString(elem.range).value);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseLabReport(element : IXmlDomElement) : TLabReport;
var
  child : IXMLDOMElement;
begin
  result := TLabReport.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'status') then
        result.status := TLabReportStatus(ParseEnum(CODES_TLabReportStatus, child))
      else if (child.nodeName = 'issued') then
        result.issued := XMLDateTimeStringToDateTime(child.text)
      else if (child.nodeName = 'patient') then
        result.patient := ParseFHIRResourceReference{TPatient}(child)
      else if (child.nodeName = 'admission') then
        result.admission := ParseFHIRResourceReference{TAdmission}(child)
      else if (child.nodeName = 'laboratory') then
        result.laboratory := ParseFHIRResourceReference{TOrganization}(child)
      else if (child.nodeName = 'reportId') then
        result.reportId := child.text
      else if (child.nodeName = 'requestDetail') then
        result.RequestDetail.Add(ParseLabReportRequestDetail(child))
      else if (child.nodeName = 'reportName') then
        result.reportName := ParseCodeableConcept(child)
      else if (child.nodeName = 'service') then
        result.service := ParseCodeableConcept(child)
      else if (child.nodeName = 'diagnosticTime') then
        result.diagnosticTime := child.text
      else if (child.nodeName = 'specimen') then
        result.Specimen.Add(ParseFHIRResourceReference{TSpecimen}(child))
      else if (child.nodeName = 'resultGroup') then
        result.ResultGroup.Add(ParseLabReportResultGroup(child))
      else if (child.nodeName = 'conclusion') then
        result.conclusion := ParseNarrative(child)
      else if (child.nodeName = 'codedDiagnosis') then
        result.CodedDiagnosis.Add(ParseCodeableConcept(child))
      else if (child.nodeName = 'representation') then
        result.Representation.Add(ParseAttachment(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposeLabReport(name : string; elem : TLabReport);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  Text('status',CODES_TLabReportStatus[elem.status]);
  Text('issued',DateTimeToXMLDateTimeString(elem.issued));
  ComposeFHIRResourceReference{TPatient}('patient', elem.patient);
  ComposeFHIRResourceReference{TAdmission}('admission', elem.admission);
  ComposeFHIRResourceReference{TOrganization}('laboratory', elem.laboratory);
  Text('reportId',elem.reportId);
  for i := 0 to elem.RequestDetail.Count - 1 do
    ComposeLabReportRequestDetail('requestDetail', elem.RequestDetail[i]);
  ComposeCodeableConcept('reportName', elem.reportName);
  ComposeCodeableConcept('service', elem.service);
  Text('diagnosticTime',elem.diagnosticTime);
  for i := 0 to elem.Specimen.Count - 1 do
    ComposeFHIRResourceReference{TSpecimen}('specimen', elem.Specimen[i]);
  for i := 0 to elem.ResultGroup.Count - 1 do
    ComposeLabReportResultGroup('resultGroup', elem.ResultGroup[i]);
  ComposeNarrative('conclusion', elem.conclusion);
  for i := 0 to elem.CodedDiagnosis.Count - 1 do
    ComposeCodeableConcept('codedDiagnosis', elem.CodedDiagnosis[i]);
  for i := 0 to elem.Representation.Count - 1 do
    ComposeAttachment('representation', elem.Representation[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParseLabReport : TLabReport;
begin
  result := TLabReport.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'status') then
        result.status := TLabReportStatus(ParseEnum(CODES_TLabReportStatus))
      else if (FJson.ItemName = 'issued') then
        result.issued := XMLDateTimeStringToDateTime(FJson.itemValue)
      else if (FJson.ItemName = 'patient') then
        result.patient := ParseFHIRResourceReference{TPatient}
      else if (FJson.ItemName = 'admission') then
        result.admission := ParseFHIRResourceReference{TAdmission}
      else if (FJson.ItemName = 'laboratory') then
        result.laboratory := ParseFHIRResourceReference{TOrganization}
      else if (FJson.ItemName = 'reportId') then
        result.reportId := FJson.itemValue
      else if (FJson.ItemName = 'requestDetails') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.RequestDetail.Add(ParseLabReportRequestDetail);
        FJson.Next;
      end
      else if (FJson.ItemName = 'reportName') then
        result.reportName := ParseCodeableConcept
      else if (FJson.ItemName = 'service') then
        result.service := ParseCodeableConcept
      else if (FJson.ItemName = 'diagnosticTime') then
        result.diagnosticTime := FJson.itemValue
      else if (FJson.ItemName = 'specimen') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Specimen.Add(ParseFHIRResourceReference{TSpecimen});
        FJson.Next;
      end
      else if (FJson.ItemName = 'resultGroups') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.ResultGroup.Add(ParseLabReportResultGroup);
        FJson.Next;
      end
      else if (FJson.ItemName = 'conclusion') then
        result.conclusion := ParseNarrative
      else if (FJson.ItemName = 'codedDiagnoses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.CodedDiagnosis.Add(ParseCodeableConcept);
        FJson.Next;
      end
      else if (FJson.ItemName = 'representations') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Representation.Add(ParseAttachment);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposeLabReport(name : string; elem : TLabReport);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  Prop('status',CODES_TLabReportStatus[elem.status]);
  Prop('issued',DateTimeToXMLDateTimeString(elem.issued));
  ComposeFHIRResourceReference{TPatient}('patient', elem.patient);
  ComposeFHIRResourceReference{TAdmission}('admission', elem.admission);
  ComposeFHIRResourceReference{TOrganization}('laboratory', elem.laboratory);
  Prop('reportId',elem.reportId);
  if elem.RequestDetail.Count > 0 then
  begin
    FJson.valueObject('requestDetails');
    for i := 0 to elem.RequestDetail.Count - 1 do
      ComposeLabReportRequestDetail('requestDetail',elem.RequestDetail[i]);
    FJson.FinishObject;
  end;
  ComposeCodeableConcept('reportName', elem.reportName);
  ComposeCodeableConcept('service', elem.service);
  Prop('diagnosticTime',elem.diagnosticTime);
  if elem.Specimen.Count > 0 then
  begin
    FJson.valueObject('specimen');
    for i := 0 to elem.Specimen.Count - 1 do
      ComposeFHIRResourceReference{TSpecimen}('specimen',elem.Specimen[i]);
    FJson.FinishObject;
  end;
  if elem.ResultGroup.Count > 0 then
  begin
    FJson.valueObject('resultGroups');
    for i := 0 to elem.ResultGroup.Count - 1 do
      ComposeLabReportResultGroup('resultGroup',elem.ResultGroup[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('conclusion', elem.conclusion);
  if elem.CodedDiagnosis.Count > 0 then
  begin
    FJson.valueObject('codedDiagnoses');
    for i := 0 to elem.CodedDiagnosis.Count - 1 do
      ComposeCodeableConcept('codedDiagnosis',elem.CodedDiagnosis[i]);
    FJson.FinishObject;
  end;
  if elem.Representation.Count > 0 then
  begin
    FJson.valueObject('representations');
    for i := 0 to elem.Representation.Count - 1 do
      ComposeAttachment('representation',elem.Representation[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePersonQualification(element : IXmlDomElement) : TPersonQualification;
var
  child : IXMLDOMElement;
begin
  result := TPersonQualification.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := ParseIdentifier(child)
      else if (child.nodeName = 'code') then
        result.code := ParseCodeableConcept(child)
      else if (child.nodeName = 'institution') then
        result.institution := ParseFHIRResourceReference{TOrganization}(child)
      else if (child.nodeName = 'period') then
        result.period := ParseInterval_date(child)
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePersonQualification(name : string; elem : TPersonQualification);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeIdentifier('id', elem.id);
  ComposeCodeableConcept('code', elem.code);
  ComposeFHIRResourceReference{TOrganization}('institution', elem.institution);
  ComposeInterval_date('period', elem.period);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePersonQualification : TPersonQualification;
begin
  result := TPersonQualification.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := ParseIdentifier
      else if (FJson.ItemName = 'code') then
        result.code := ParseCodeableConcept
      else if (FJson.ItemName = 'institution') then
        result.institution := ParseFHIRResourceReference{TOrganization}
      else if (FJson.ItemName = 'period') then
        result.period := ParseInterval_date
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePersonQualification(name : string; elem : TPersonQualification);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeIdentifier('id', elem.id);
  ComposeCodeableConcept('code', elem.code);
  ComposeFHIRResourceReference{TOrganization}('institution', elem.institution);
  ComposeInterval_date('period', elem.period);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePersonLanguage(element : IXmlDomElement) : TPersonLanguage;
var
  child : IXMLDOMElement;
begin
  result := TPersonLanguage.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'code') then
        result.code := child.text
      else if (child.nodeName = 'use') then
        result.use := TLanguageUse(ParseEnum(CODES_TLanguageUse, child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePersonLanguage(name : string; elem : TPersonLanguage);
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('code',elem.code);
  Text('use',CODES_TLanguageUse[elem.use]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePersonLanguage : TPersonLanguage;
begin
  result := TPersonLanguage.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'code') then
        result.code := FJson.itemValue
      else if (FJson.ItemName = 'use') then
        result.use := TLanguageUse(ParseEnum(CODES_TLanguageUse))
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePersonLanguage(name : string; elem : TPersonLanguage);
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('code',elem.code);
  Prop('use',CODES_TLanguageUse[elem.use]);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePersonRelatedPerson(element : IXmlDomElement) : TPersonRelatedPerson;
var
  child : IXMLDOMElement;
begin
  result := TPersonRelatedPerson.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := ParseHumanId(child)
      else if (child.nodeName = 'role') then
        result.role := ParseCodeableConcept(child)
      else if (child.nodeName = 'name') then
        result.name := ParseHumanName(child)
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePersonRelatedPerson(name : string; elem : TPersonRelatedPerson);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  ComposeHumanId('id', elem.id);
  ComposeCodeableConcept('role', elem.role);
  ComposeHumanName('name', elem.name);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePersonRelatedPerson : TPersonRelatedPerson;
begin
  result := TPersonRelatedPerson.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'id') then
        result.id := ParseHumanId
      else if (FJson.ItemName = 'role') then
        result.role := ParseCodeableConcept
      else if (FJson.ItemName = 'name') then
        result.name := ParseHumanName
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePersonRelatedPerson(name : string; elem : TPersonRelatedPerson);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  ComposeHumanId('id', elem.id);
  ComposeCodeableConcept('role', elem.role);
  ComposeHumanName('name', elem.name);
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  FJson.finishObject;
end;

function TFHIRXmlParser.ParsePerson(element : IXmlDomElement) : TPerson;
var
  child : IXMLDOMElement;
begin
  result := TPerson.create;
  try
    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');
    child := TMsXmlParser.FirstChild(element);
    while (child <> nil) do
    begin
      if (child.nodeName = 'id') then
        result.id := child.text
      else if (child.nodeName = 'text') then
        result.text := ParseNarrative(child)
      else if (child.nodeName = 'identifier') then
        result.Identifier.Add(ParseHumanId(child))
      else if (child.nodeName = 'name') then
        result.Name.Add(ParseHumanName(child))
      else if (child.nodeName = 'address') then
        result.Address.Add(ParseAddress(child))
      else if (child.nodeName = 'contact') then
        result.Contact.Add(ParseContact(child))
      else if (child.nodeName = 'dob') then
        result.dob := child.text
      else if (child.nodeName = 'gender') then
        result.gender := ParseCodeableConcept(child)
      else if (child.nodeName = 'religion') then
        result.religion := ParseCodeableConcept(child)
      else if (child.nodeName = 'qualification') then
        result.Qualification.Add(ParsePersonQualification(child))
      else if (child.nodeName = 'language') then
        result.Language.Add(ParsePersonLanguage(child))
      else if (child.nodeName = 'relatedPerson') then
        result.RelatedPerson.Add(ParsePersonRelatedPerson(child))
      else
         UnknownContent(child);
      child := TMsXmlParser.NextSibling(child);
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRXmlComposer.ComposePerson(name : string; elem : TPerson);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  attribute('xml:Id', elem.xmlId);
  FXml.open(name);
  Text('id', elem.id);
  for i := 0 to elem.Identifier.Count - 1 do
    ComposeHumanId('identifier', elem.Identifier[i]);
  for i := 0 to elem.Name.Count - 1 do
    ComposeHumanName('name', elem.Name[i]);
  for i := 0 to elem.Address.Count - 1 do
    ComposeAddress('address', elem.Address[i]);
  for i := 0 to elem.Contact.Count - 1 do
    ComposeContact('contact', elem.Contact[i]);
  Text('dob',elem.dob);
  ComposeCodeableConcept('gender', elem.gender);
  ComposeCodeableConcept('religion', elem.religion);
  for i := 0 to elem.Qualification.Count - 1 do
    ComposePersonQualification('qualification', elem.Qualification[i]);
  for i := 0 to elem.Language.Count - 1 do
    ComposePersonLanguage('language', elem.Language[i]);
  for i := 0 to elem.RelatedPerson.Count - 1 do
    ComposePersonRelatedPerson('relatedPerson', elem.RelatedPerson[i]);
  ComposeNarrative('text', elem.text);
  FXml.close(name);
end;

function TFHIRJsonParser.ParsePerson : TPerson;
begin
  result := TPerson.create;
  try
    while (FJson.ItemType <> jpitEnd) do
    begin
      if (FJson.ItemName = 'xmlId') then
        result.xmlId := FJson.itemValue
      else if (FJson.ItemName = 'identifiers') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Identifier.Add(ParseHumanId);
        FJson.Next;
      end
      else if (FJson.ItemName = 'names') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Name.Add(ParseHumanName);
        FJson.Next;
      end
      else if (FJson.ItemName = 'addresses') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Address.Add(ParseAddress);
        FJson.Next;
      end
      else if (FJson.ItemName = 'contacts') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Contact.Add(ParseContact);
        FJson.Next;
      end
      else if (FJson.ItemName = 'dob') then
        result.dob := FJson.itemValue
      else if (FJson.ItemName = 'gender') then
        result.gender := ParseCodeableConcept
      else if (FJson.ItemName = 'religion') then
        result.religion := ParseCodeableConcept
      else if (FJson.ItemName = 'qualifications') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Qualification.Add(ParsePersonQualification);
        FJson.Next;
      end
      else if (FJson.ItemName = 'languages') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.Language.Add(ParsePersonLanguage);
        FJson.Next;
      end
      else if (FJson.ItemName = 'relatedPeople') then
      begin
        FJson.checkState(jpitArray);
        FJson.Next;
        while (FJson.ItemType <> jpitEnd) do
          result.RelatedPerson.Add(ParsePersonRelatedPerson);
        FJson.Next;
      end
      else
         UnknownContent;
    end;

    result.link;
  finally
    result.free;
  end;
end;

procedure TFHIRJsonComposer.ComposePerson(name : string; elem : TPerson);
var
  i : integer;
begin
  if (elem = nil) then
    exit;
  FJson.valueObject(name);
  Prop('xmlId', elem.xmlId);
  Prop('id', elem.id);
  if elem.Identifier.Count > 0 then
  begin
    FJson.valueObject('identifiers');
    for i := 0 to elem.Identifier.Count - 1 do
      ComposeHumanId('identifier',elem.Identifier[i]);
    FJson.FinishObject;
  end;
  if elem.Name.Count > 0 then
  begin
    FJson.valueObject('names');
    for i := 0 to elem.Name.Count - 1 do
      ComposeHumanName('name',elem.Name[i]);
    FJson.FinishObject;
  end;
  if elem.Address.Count > 0 then
  begin
    FJson.valueObject('addresses');
    for i := 0 to elem.Address.Count - 1 do
      ComposeAddress('address',elem.Address[i]);
    FJson.FinishObject;
  end;
  if elem.Contact.Count > 0 then
  begin
    FJson.valueObject('contacts');
    for i := 0 to elem.Contact.Count - 1 do
      ComposeContact('contact',elem.Contact[i]);
    FJson.FinishObject;
  end;
  Prop('dob',elem.dob);
  ComposeCodeableConcept('gender', elem.gender);
  ComposeCodeableConcept('religion', elem.religion);
  if elem.Qualification.Count > 0 then
  begin
    FJson.valueObject('qualifications');
    for i := 0 to elem.Qualification.Count - 1 do
      ComposePersonQualification('qualification',elem.Qualification[i]);
    FJson.FinishObject;
  end;
  if elem.Language.Count > 0 then
  begin
    FJson.valueObject('languages');
    for i := 0 to elem.Language.Count - 1 do
      ComposePersonLanguage('language',elem.Language[i]);
    FJson.FinishObject;
  end;
  if elem.RelatedPerson.Count > 0 then
  begin
    FJson.valueObject('relatedPeople');
    for i := 0 to elem.RelatedPerson.Count - 1 do
      ComposePersonRelatedPerson('relatedPerson',elem.RelatedPerson[i]);
    FJson.FinishObject;
  end;
  ComposeNarrative('text', elem.text);
  FJson.finishObject;
end;

function TFHIRXmlParser.ParseResource(element : IXmlDomElement) : TFHIRResource;
begin
  if (element = nil) Then
    Raise Exception.Create('error - element is nil')
  else if element.NodeName = 'Conformance' Then
    result := ParseConformance(element)
  else if element.NodeName = 'Document' Then
    result := ParseDocument(element)
  else if element.NodeName = 'Message' Then
    result := ParseMessage(element)
  else if element.NodeName = 'MessageConformance' Then
    result := ParseMessageConformance(element)
  else if element.NodeName = 'Agent' Then
    result := ParseAgent(element)
  else if element.NodeName = 'Animal' Then
    result := ParseAnimal(element)
  else if element.NodeName = 'Prescription' Then
    result := ParsePrescription(element)
  else if element.NodeName = 'Patient' Then
    result := ParsePatient(element)
  else if element.NodeName = 'Organization' Then
    result := ParseOrganization(element)
  else if element.NodeName = 'DocumentConformance' Then
    result := ParseDocumentConformance(element)
  else if element.NodeName = 'LabReport' Then
    result := ParseLabReport(element)
  else if element.NodeName = 'Person' Then
    result := ParsePerson(element)
  else
    raise Exception.create('Error: the element '+element.NodeName+' is not recognised as a valid resource name');
end;

procedure TFHIRXmlComposer.ComposeResource(resource: TFHIRResource);
begin
  if (resource = nil) Then
    Raise Exception.Create('error - resource is nil');
  Case resource.ResourceType of
    frtConformance: ComposeConformance('Conformance', TConformance(resource));
    frtDocument: ComposeDocument('Document', TDocument(resource));
    frtMessage: ComposeMessage('Message', TMessage(resource));
    frtMessageConformance: ComposeMessageConformance('MessageConformance', TMessageConformance(resource));
    frtAgent: ComposeAgent('Agent', TAgent(resource));
    frtAnimal: ComposeAnimal('Animal', TAnimal(resource));
    frtPrescription: ComposePrescription('Prescription', TPrescription(resource));
    frtPatient: ComposePatient('Patient', TPatient(resource));
    frtOrganization: ComposeOrganization('Organization', TOrganization(resource));
    frtDocumentConformance: ComposeDocumentConformance('DocumentConformance', TDocumentConformance(resource));
    frtLabReport: ComposeLabReport('LabReport', TLabReport(resource));
    frtPerson: ComposePerson('Person', TPerson(resource));
  else
    raise Exception.create('Internal error: the resource type '+CODES_TFHIRResourceType[resource.ResourceType]+' is not a valid resource type');
  end;
end;

function TFHIRJsonParser.ParseResource : TFHIRResource;
begin
  if FJson.ItemName = 'Conformance' Then
    result := ParseConformance
  else if FJson.ItemName = 'Document' Then
    result := ParseDocument
  else if FJson.ItemName = 'Message' Then
    result := ParseMessage
  else if FJson.ItemName = 'MessageConformance' Then
    result := ParseMessageConformance
  else if FJson.ItemName = 'Agent' Then
    result := ParseAgent
  else if FJson.ItemName = 'Animal' Then
    result := ParseAnimal
  else if FJson.ItemName = 'Prescription' Then
    result := ParsePrescription
  else if FJson.ItemName = 'Patient' Then
    result := ParsePatient
  else if FJson.ItemName = 'Organization' Then
    result := ParseOrganization
  else if FJson.ItemName = 'DocumentConformance' Then
    result := ParseDocumentConformance
  else if FJson.ItemName = 'LabReport' Then
    result := ParseLabReport
  else if FJson.ItemName = 'Person' Then
    result := ParsePerson
  else
    raise Exception.create('error: the element '+FJson.itemName+' is not a valid resource name');
end;

procedure TFHIRJsonComposer.ComposeResource(resource: TFHIRResource);
begin
  if (resource = nil) Then
    Raise Exception.Create('error - resource is nil');
  Case resource.ResourceType of
    frtConformance: ComposeConformance('Conformance', TConformance(resource));
    frtDocument: ComposeDocument('Document', TDocument(resource));
    frtMessage: ComposeMessage('Message', TMessage(resource));
    frtMessageConformance: ComposeMessageConformance('MessageConformance', TMessageConformance(resource));
    frtAgent: ComposeAgent('Agent', TAgent(resource));
    frtAnimal: ComposeAnimal('Animal', TAnimal(resource));
    frtPrescription: ComposePrescription('Prescription', TPrescription(resource));
    frtPatient: ComposePatient('Patient', TPatient(resource));
    frtOrganization: ComposeOrganization('Organization', TOrganization(resource));
    frtDocumentConformance: ComposeDocumentConformance('DocumentConformance', TDocumentConformance(resource));
    frtLabReport: ComposeLabReport('LabReport', TLabReport(resource));
    frtPerson: ComposePerson('Person', TPerson(resource));
  else
    raise Exception.create('Internal error: the resource type '+CODES_TFHIRResourceType[resource.ResourceType]+' is not a valid resource type');
  end;
end;


end.

