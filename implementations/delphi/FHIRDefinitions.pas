unit FHIRDefinitions;

interface

// FHIR v0.01 generated 22:50 Apr 29, 2012

uses
  FHIRDefinitionBase;

function LoadFHIRDefinitions : TFHIRDefinitions;

implementation

procedure addConceptDomainMessageConformanceEventMode(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'MessageConformanceEventMode';
    cd.definition := 'The mode of a message conformance statement';
    cd.bindingType := btCodeList;
    cd.binding := 'message-conformance-event-mode';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('sender', 'The application sends requests and receives responses', ''));
    cd.codes.add(TFHIRDefinedCode.create('receiver', 'The application receives requests and sends responses', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainDataType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'DataType';
    cd.definition := 'The type of an element - one of the FHIR data types';
    cd.bindingType := btSpecial;
    cd.binding := 'DataType';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainMediaType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'MediaType';
    cd.definition := 'The mime type of an attachment';
    cd.bindingType := btExternal;
    cd.binding := 'BCP 13 (RFCs 2045, 2046, 2047, 4288, 4289 and 2049)';
    cd.details := 'http://www.rfc-editor.org/bcp/bcp13.txt';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainNarrativeStatus(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'NarrativeStatus';
    cd.definition := 'The status of a resource narrative';
    cd.bindingType := btCodeList;
    cd.binding := 'narrative-status';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('generated', 'The contents of the narrative are entirely generated from the structured data in the resource.', ''));
    cd.codes.add(TFHIRDefinedCode.create('extensions', 'The contents of the narrative are entirely generated from the structured data in the resource, and some of the structured data is contained in extensions', ''));
    cd.codes.add(TFHIRDefinedCode.create('additional', 'The contents of the narrative contain additional information not found in the structured data', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAgentRole(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AgentRole';
    cd.definition := 'The role a person plays representing an organization';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainPersonRelationship(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'PersonRelationship';
    cd.definition := 'The relationship a person has to the subject, including familial, marital, financial, legal, and casual relationships';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAnimalSpecies(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AnimalSpecies';
    cd.definition := 'The species of an animal';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainIdentifierType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'IdentifierType';
    cd.definition := 'The type of human identifier';
    cd.bindingType := btCodeList;
    cd.binding := 'identifier-type';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('account', 'Account number', 'An identifier that is unique to an account.'));
    cd.codes.add(TFHIRDefinedCode.create('credit', 'Credit Card Number', 'A credit card number (or debit card).'));
    cd.codes.add(TFHIRDefinedCode.create('microchip', 'Microchip Number', 'implanted, for animals, or a worn RFID for humans'));
    cd.codes.add(TFHIRDefinedCode.create('registry', 'A Registry Number', ''));
    cd.codes.add(TFHIRDefinedCode.create('insurance', 'Insurance Scheme Member Number', 'Identifies the person as a member of an insurance scheme.'));
    cd.codes.add(TFHIRDefinedCode.create('national', 'National Healthcare Identifier', 'May not only be used for healthcare.'));
    cd.codes.add(TFHIRDefinedCode.create('ssn', 'National Social Security Number', ''));
    cd.codes.add(TFHIRDefinedCode.create('state', 'State Healthcare Identifier', 'May not only be used for healthcare.'));
    cd.codes.add(TFHIRDefinedCode.create('patient', 'Patient identifier', 'Frequently called MRN (medical record number) or UR (unit record number).'));
    cd.codes.add(TFHIRDefinedCode.create('facility', 'Facility ID', ''));
    cd.codes.add(TFHIRDefinedCode.create('provider', 'Provider number', 'a number allocated to a person as a provider of healthcare resources.'));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAnimalRelationship(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AnimalRelationship';
    cd.definition := 'The relationship of an animal to another entity (person, corporation, or other animal)';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabReportNames(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabReportNames';
    cd.definition := 'codes for report names';
    cd.bindingType := btPreferred;
    cd.binding := 'LOINC';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainPrescriptionStatus(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'PrescriptionStatus';
    cd.definition := 'The status of a prescription';
    cd.bindingType := btCodeList;
    cd.binding := 'prescription-status';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('active', 'Patient is using the prescribed medicin', ''));
    cd.codes.add(TFHIRDefinedCode.create('completed', 'Prescription is no longer current', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainPatientConfidentiality(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'PatientConfidentiality';
    cd.definition := 'The confidentiality of the records associated with this patient';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAddressUse(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AddressUse';
    cd.definition := 'The use of an address';
    cd.bindingType := btCodeList;
    cd.binding := 'address-use';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('home', 'A communication address at a home.', ''));
    cd.codes.add(TFHIRDefinedCode.create('work', 'An office address. First choice for business related contacts during business hours.', ''));
    cd.codes.add(TFHIRDefinedCode.create('temp', 'A temporary address. The period can provide more detailed information.', ''));
    cd.codes.add(TFHIRDefinedCode.create('old', 'This address is no longer in use (or was never correct, but retained for records)', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainNamePartType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'NamePartType';
    cd.definition := 'Type of a part of a human name';
    cd.bindingType := btCodeList;
    cd.binding := 'name-part-type';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('family', 'Family name, this is the name that links to the genealogy. In some cultures (e.g. Eritrea) the family name of a son is the first name of his father.', ''));
    cd.codes.add(TFHIRDefinedCode.create('given', 'Given name. NOTE Not to be called first name since given names do not always come first. .', ''));
    cd.codes.add(TFHIRDefinedCode.create('title', 'Part of the name that is acquired as a title due to academic, legal, employment or nobility status etc. NOTE Title name parts include name parts that come after the name, such as qualifications.', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainContactUse(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'ContactUse';
    cd.definition := 'How to use this address';
    cd.bindingType := btCodeList;
    cd.binding := 'contact-use';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('home', 'A communication contact at a home; attempted contacts for business purposes might intrude privacy and chances are one will contact family or other household members instead of the person one wishes to'+
      ' call. Typically used with urgent cases, or if no other contacts are available.', ''));
    cd.codes.add(TFHIRDefinedCode.create('work', 'An office contact. First choice for business related contacts during business hours.', ''));
    cd.codes.add(TFHIRDefinedCode.create('temp', 'A temporary contact. The period can provide more detailed information.', ''));
    cd.codes.add(TFHIRDefinedCode.create('old', 'This contact is no longer in use (or was never correct, but retained for records)', ''));
    cd.codes.add(TFHIRDefinedCode.create('mobile', 'A telecommunication device that moves and stays with its owner. May have characteristics of all other use codes, suitable for urgent matters, not the first choice for routine business', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainNarrativeMapSource(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'NarrativeMapSource';
    cd.definition := 'Which is the source in a Narrative <-> Data mapping';
    cd.bindingType := btCodeList;
    cd.binding := 'narrative-map-source';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('text', 'The text is the original data', ''));
    cd.codes.add(TFHIRDefinedCode.create('data', 'The data is the original data', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainBooleanYesNo(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'BooleanYesNo';
    cd.definition := 'Either yes or no, true or false';
    cd.bindingType := btCodeList;
    cd.binding := 'boolean-yes-no';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('yes', 'TRUE', ''));
    cd.codes.add(TFHIRDefinedCode.create('no', 'FALSE', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabRequests(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabRequests';
    cd.definition := 'codes for requestable tests';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAnimalGender(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AnimalGender';
    cd.definition := 'The gender of an animal';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAnimalStrain(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AnimalStrain';
    cd.definition := 'The strain of an animal';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainReligion(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'Religion';
    cd.definition := 'The denomination to which a person professes affiliation';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainPrescriptionReason(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'PrescriptionReason';
    cd.definition := 'Medical reason for prescribing a medicine';
    cd.bindingType := btExternal;
    cd.binding := 'ICD-10, ICPC-1';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainContactSystem(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'ContactSystem';
    cd.definition := 'What kind of contact this is';
    cd.bindingType := btCodeList;
    cd.binding := 'contact-system';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('phone', 'the value is a telephone number used for voice calls. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.', ''));
    cd.codes.add(TFHIRDefinedCode.create('fax', 'the value is a fax machine. Use of full international numbers starting with + is recommended to enable automatic dialing support but not required.', ''));
    cd.codes.add(TFHIRDefinedCode.create('email', 'the value is an email address', ''));
    cd.codes.add(TFHIRDefinedCode.create('url', 'The value is a url. This is intended for various personal contacts including blogs, twitter, facebook etc. Do not use for email addresses', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAccreditation(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'Accreditation';
    cd.definition := 'Accreditations an organization may be granted';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainDocumentSectionType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'DocumentSectionType';
    cd.definition := 'Type of a clinical document section';
    cd.bindingType := btPreferred;
    cd.binding := 'LOINC';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabDiagnosisCodes(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabDiagnosisCodes';
    cd.definition := 'Codes for laboratory diagnoses';
    cd.bindingType := btSuggestion;
    cd.binding := 'SNOMED-CT';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabReportStatus(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabReportStatus';
    cd.definition := 'The status of a report or result item';
    cd.bindingType := btCodeList;
    cd.binding := 'lab-report-status';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('registered', 'The existence of the result is registered, but there is no result yet available', ''));
    cd.codes.add(TFHIRDefinedCode.create('interim', 'This is an initial or interim result: data may be missing or verification not been performed', ''));
    cd.codes.add(TFHIRDefinedCode.create('final', 'The result is complete and verified by the responsible pathologist', ''));
    cd.codes.add(TFHIRDefinedCode.create('amended', 'The result has been modified subsequent to being Final, and is complete and verified by the responsible pathologist', ''));
    cd.codes.add(TFHIRDefinedCode.create('cancelled', 'The result is unavailable because the test was not started or not completed (also sometimes called aborted)', ''));
    cd.codes.add(TFHIRDefinedCode.create('withdrawn', 'The result has been withdrawn following previous Final release', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAdministrationPrecondition(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AdministrationPrecondition';
    cd.definition := 'Precondition for administering medication';
    cd.bindingType := btExternal;
    cd.binding := 'NHG Table 25b';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainConformanceType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'ConformanceType';
    cd.definition := 'The conformance value for an element';
    cd.bindingType := btCodeList;
    cd.binding := 'conformance-type';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('Mandatory', 'The element is or must always be present without a dataAbsentReason', ''));
    cd.codes.add(TFHIRDefinedCode.create('Conditional', 'The element may need to be present (with no dataAbsentReasons) depending on the condition', ''));
    cd.codes.add(TFHIRDefinedCode.create('Optional', 'The element may or may not be present', ''));
    cd.codes.add(TFHIRDefinedCode.create('Prohibited', 'The element can not present or will be rejected if received', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAdministrationInstruction(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AdministrationInstruction';
    cd.definition := 'Instructions for administering medication';
    cd.bindingType := btExternal;
    cd.binding := 'NHG Table 25b';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainDataAbsentReason(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'DataAbsentReason';
    cd.definition := 'Used to specify why the normally expected content of the data element is missing';
    cd.bindingType := btCodeList;
    cd.binding := 'data-absent-reason';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('unknown', 'The value is not known', ''));
    cd.codes.add(TFHIRDefinedCode.create('asked', 'The source human does not know the value', ''));
    cd.codes.add(TFHIRDefinedCode.create('temp', 'There is reason to expect (from the workflow) that the value may become known', ''));
    cd.codes.add(TFHIRDefinedCode.create('notasked', 'The workflow didn''t lead to this value being known', ''));
    cd.codes.add(TFHIRDefinedCode.create('masked', 'The information is not available due to security, privacy or related reasons', 'Using masked may be breach of security or confidentiality, but there are times when it''s use is required to support alternate workflows for gaining access to denied information.'));
    cd.codes.add(TFHIRDefinedCode.create('unsupported', 'The source system wasn''t capable of supporting this element', ''));
    cd.codes.add(TFHIRDefinedCode.create('astext', 'The content of the data is represented as text', ''));
    cd.codes.add(TFHIRDefinedCode.create('error', 'Some system or workflow process error means that the information is not available', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabResultNames(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabResultNames';
    cd.definition := 'codes for results';
    cd.bindingType := btPreferred;
    cd.binding := 'LOINC';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainPaperRecordLocation(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'PaperRecordLocation';
    cd.definition := 'A physical location for a record. (Usually site specific)';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainIndustry(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'Industry';
    cd.definition := 'Code for the type of industry';
    cd.bindingType := btReference;
    cd.binding := 'HL7 v3 OrganizationIndustryClass value set';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainDocumentAuthenticationMode(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'DocumentAuthenticationMode';
    cd.definition := 'The way in which a person authenticated a document';
    cd.bindingType := btCodeList;
    cd.binding := 'document-authentication-mode';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('personal', 'The person authenticated the document in their personal capacity', ''));
    cd.codes.add(TFHIRDefinedCode.create('professional', 'The person authenticated the document in their professional capacity', ''));
    cd.codes.add(TFHIRDefinedCode.create('legal', 'The person authenticated the document and accepted legal responsibility for it''s content', ''));
    cd.codes.add(TFHIRDefinedCode.create('official', 'The organization authenticated the document as consistent with their policies and procedures', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainPatientDiet(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'PatientDiet';
    cd.definition := 'casual dietary restrictions associated with this patient';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainMedicationKind(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'MedicationKind';
    cd.definition := 'The kind of medication, vaccine or therapeutic material';
    cd.bindingType := btExternal;
    cd.binding := 'G-Standaard (Netherlands), AMT (Australie)';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAddressPartType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AddressPartType';
    cd.definition := 'Type of address part';
    cd.bindingType := btCodeList;
    cd.binding := 'address-part-type';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('part', 'Part of an address line (typically used with an extension that further defines the meaning of the part).', ''));
    cd.codes.add(TFHIRDefinedCode.create('line', 'A line of an address (typically used for street names & numbers, unit details, delivery hints etc) .', ''));
    cd.codes.add(TFHIRDefinedCode.create('city', 'The name of the city, town, village, or other community or delivery centre.', ''));
    cd.codes.add(TFHIRDefinedCode.create('state', 'sub-unit of a country with limited sovereignty in a federally organized country. A code may be used if codes are in common use (i.e. US 2 letter state codes).', ''));
    cd.codes.add(TFHIRDefinedCode.create('country', 'Country. ISO 3166 3 letter codes can be used in place of a full country name.', ''));
    cd.codes.add(TFHIRDefinedCode.create('zip', 'A postal code designating a region defined by the postal service.', ''));
    cd.codes.add(TFHIRDefinedCode.create('dpid', 'A value that uniquely identifies the postal address. (often used in barcodes).', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabResultGroupNames(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabResultGroupNames';
    cd.definition := 'codes for result groups';
    cd.bindingType := btPreferred;
    cd.binding := 'LOINC';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLanguageUse(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LanguageUse';
    cd.definition := 'How well a person speaks a language';
    cd.bindingType := btCodeList;
    cd.binding := 'language-use';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('none', 'The person does not speak the language at all', ''));
    cd.codes.add(TFHIRDefinedCode.create('poor', 'The person has minimal functional capability in the language', ''));
    cd.codes.add(TFHIRDefinedCode.create('useable', 'The person can use the language, but may not be full conversant, particularly with regards to health concepts', ''));
    cd.codes.add(TFHIRDefinedCode.create('fluent', 'The person is fully capable of using the language', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainQualifications(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'Qualifications';
    cd.definition := 'Formal qualifications, accreditations, and Certifications acquired by a person';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainMessageEvent(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'MessageEvent';
    cd.definition := 'One of the message types defined in FHIR messaging';
    cd.bindingType := btSpecial;
    cd.binding := 'MessageEvent';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainResourceType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'ResourceType';
    cd.definition := 'One of the resource types defined in FHIR messaging';
    cd.bindingType := btSpecial;
    cd.binding := 'ResourceType';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainEventTiming(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'EventTiming';
    cd.definition := 'A real world event that a schedule is related to';
    cd.bindingType := btCodeList;
    cd.binding := 'event-timing';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('HS', 'event occurs duration before the hour of sleep (or trying to)', ''));
    cd.codes.add(TFHIRDefinedCode.create('WAKE', 'event occurs duration after waking', ''));
    cd.codes.add(TFHIRDefinedCode.create('AC', 'event occurs duration before a meal (from the latin ante cibus)', ''));
    cd.codes.add(TFHIRDefinedCode.create('ACM', 'event occurs duration before breakfast (from the latin ante cibus matutinus)', ''));
    cd.codes.add(TFHIRDefinedCode.create('ACD', 'event occurs duration before lunch (from the latin ante cibus diurnus)', ''));
    cd.codes.add(TFHIRDefinedCode.create('ACV', 'event occurs duration before dinner (from the latin ante cibus vespertinus)', ''));
    cd.codes.add(TFHIRDefinedCode.create('PC', 'event occurs duration after a meal (from the latin post cibus)', ''));
    cd.codes.add(TFHIRDefinedCode.create('PCM', 'event occurs duration after breakfast (from the latin post cibus matutinus)', ''));
    cd.codes.add(TFHIRDefinedCode.create('PCD', 'event occurs duration after lunch (from the latin post cibus diurnus)', ''));
    cd.codes.add(TFHIRDefinedCode.create('PCV', 'event occurs duration after dinner (from the latin post cibus vespertinus)', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainResourceIdSource(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'ResourceIdSource';
    cd.definition := 'The system responsible for the provision of a resource unique id';
    cd.bindingType := btCodeList;
    cd.binding := 'resource-id-source';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('client', 'The client must provide a unique resource id', ''));
    cd.codes.add(TFHIRDefinedCode.create('server', 'The server defines the id and will reject any client attempt to define it', ''));
    cd.codes.add(TFHIRDefinedCode.create('either', 'The client can provide a unique resource id, or the server will define it instead', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainDocumentType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'DocumentType';
    cd.definition := 'Type of a clinical document';
    cd.bindingType := btPreferred;
    cd.binding := 'LOINC';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainNameUse(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'NameUse';
    cd.definition := 'The use of a human name';
    cd.bindingType := btCodeList;
    cd.binding := 'name-use';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('usual', 'Known as/conventional/the one you normally use', ''));
    cd.codes.add(TFHIRDefinedCode.create('official', 'The formal name as registered in an official (government) registry, but which name might not be commonly used. May be called legal name.', ''));
    cd.codes.add(TFHIRDefinedCode.create('temp', 'A temporary name. A name valid time can provide more detailed information. This may also be used for temporary names assigned at birth or in emergency situations.', ''));
    cd.codes.add(TFHIRDefinedCode.create('anonymous', 'Anonymous assigned name, alias, or pseudonym (used to protect a person''s identity for privacy reasons)', ''));
    cd.codes.add(TFHIRDefinedCode.create('old', 'This name is no longer in use (or was never correct, but retained for records)', ''));
    cd.codes.add(TFHIRDefinedCode.create('maiden', 'A name used prior to marriage. Marriage naming customs vary greatly around the world. This name use is for use by applications that collect and store maiden names. Though the concept of maiden name is'+
      ' often gender specific, the use of this term is not gender specific. The use of this term does not imply any particular history for a person?s name, nor should the maiden name be determined algorithmically', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainExtensionState(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'ExtensionState';
    cd.definition := 'The state of an extension';
    cd.bindingType := btCodeList;
    cd.binding := 'extension-state';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('must-understand', 'The extension contains information that qualifies or negates another element, and must be understood by an application processing the resource', ''));
    cd.codes.add(TFHIRDefinedCode.create('superceded', 'The extension has been promoted into the main content of the resource, and the content is found at the reference. The extension continues to be defined for backward compatibility', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabResultFlag(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabResultFlag';
    cd.definition := 'codes for result flags';
    cd.bindingType := btCodeList;
    cd.binding := 'lab-result-flag';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('-', '', ''));
    cd.codes.add(TFHIRDefinedCode.create('--', '', ''));
    cd.codes.add(TFHIRDefinedCode.create('---', '', ''));
    cd.codes.add(TFHIRDefinedCode.create('+', '', ''));
    cd.codes.add(TFHIRDefinedCode.create('++', '', ''));
    cd.codes.add(TFHIRDefinedCode.create('+++', '', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainOrganisationType(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'OrganisationType';
    cd.definition := 'The type of an organisation';
    cd.bindingType := btSuggestion;
    cd.binding := 'SNOMED-CT, and the HL7 v3 Entity Code table';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainQuantityStatus(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'QuantityStatus';
    cd.definition := 'how the Quantity should be understood and represented';
    cd.bindingType := btCodeList;
    cd.binding := 'quantity-status';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('<', 'The actual value is less than the given value', ''));
    cd.codes.add(TFHIRDefinedCode.create('<=', 'The actual value is less than or equal to the given value', ''));
    cd.codes.add(TFHIRDefinedCode.create('>=', 'The actual value is greater than or equal to the given value', ''));
    cd.codes.add(TFHIRDefinedCode.create('>', 'The actual value is greater than the given value', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainResponseCode(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'ResponseCode';
    cd.definition := 'The kind of response to a message';
    cd.bindingType := btCodeList;
    cd.binding := 'response-code';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('ok', 'The message was accepted and processed without error', ''));
    cd.codes.add(TFHIRDefinedCode.create('error', 'Some internal unexpected error occured - wait and try again. Note - this is usually used for things like database unavailable, which may be expected to resolve, though human intervention may be required', ''));
    cd.codes.add(TFHIRDefinedCode.create('rejection', 'The message was rejected because of some content in it. There is no point in re-sending without change. The response narrative must describe what the issue is', ''));
    cd.codes.add(TFHIRDefinedCode.create('rules', 'The message was rejected because of some event-specific business rules, and it may be possible to modify the request and re-submit (as a different request). The response data must clarify what the change would be, as described by the event definition', ''));
    cd.codes.add(TFHIRDefinedCode.create('undeliverable', 'A middleware agent was unable to deliver the message to it''s supposed destination', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAdministrationRoute(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AdministrationRoute';
    cd.definition := 'Route by which a medication is administered';
    cd.bindingType := btExternal;
    cd.binding := 'G-Standaard subtable 0007';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabServices(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabServices';
    cd.definition := 'codes for laboratory services';
    cd.bindingType := btReference;
    cd.binding := 'HL7 v2 table 0074';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainRestfulConformanceMode(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'RestfulConformanceMode';
    cd.definition := 'The mode of a restful conformance statement';
    cd.bindingType := btCodeList;
    cd.binding := 'restful-conformance-mode';
    cd.details := '';

    cd.codes.add(TFHIRDefinedCode.create('client', 'The application acts as a server for this resource', ''));
    cd.codes.add(TFHIRDefinedCode.create('server', 'The application acts as a client for this resource', ''));
    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainAdministrativeGender(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'AdministrativeGender';
    cd.definition := 'The gender of a person used for administrative purposes';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainOrganizationRelationship(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'OrganizationRelationship';
    cd.definition := 'The relationship an organization has to the subject, including sub and super organizations, and other kind of relationships such as partner organisations';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainEventReason(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'EventReason';
    cd.definition := 'The reason for an event occurring';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLanguage(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'Language';
    cd.definition := 'A human language';
    cd.bindingType := btExternal;
    cd.binding := 'ISO 639-3';
    cd.details := 'http://www.sil.org/iso639-3/codes.asp';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addConceptDomainLabReferenceRanges(definitions : TFHIRDefinitions);
var
  cd : TFHIRConceptDomain;
begin
  cd := TFHIRConceptDomain.create();
  try
    cd.name := 'LabReferenceRanges';
    cd.definition := 'Code for the meaning of a reference range';
    cd.bindingType := btUnbound;
    cd.binding := '';
    cd.details := '';

    definitions.conceptDomains.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeBoolean_1(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'boolean';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeInteger_2(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'integer';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeDecimal_3(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'decimal';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeBase64Binary_4(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'base64Binary';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeInstant_5(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'instant';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeString_6(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'string';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeUri_7(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'uri';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeCode_8(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'code';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeOid_9(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'oid';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeUuid_10(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'uuid';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeSid_11(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'sid';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeId_12(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'id';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeDate_13(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'date';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeDateTime_14(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'dateTime';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeAttachment_15(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Attachment';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeIdentifier_16(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Identifier';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeCodeableConcept_17(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'CodeableConcept';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeCoding_18(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Coding';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeChoice_19(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Choice';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeQuantity_20(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Quantity';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeDuration_21(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Duration';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeDistance_22(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Distance';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeCount_23(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Count';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeMoney_24(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Money';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeInterval_25(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Interval';

    cd.params.add('Quantity');
    cd.params.add('dateTime');
    cd.params.add('date');
    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeRatio_26(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Ratio';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeHumanId_27(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'HumanId';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeHumanName_28(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'HumanName';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeAddress_29(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Address';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeContact_30(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Contact';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeSchedule_31(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Schedule';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeNarrative_32(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Narrative';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeConstraint_33(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Constraint';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addKnownTypeExtensions_34(definitions : TFHIRDefinitions);
var
  cd : TFHIRTypeDefn;
begin
  cd := TFHIRTypeDefn.create();
  try
    cd.name := 'Extensions';

    definitions.KnownTypes.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnCoding(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Coding', 'A reference to a code defined by a terminology system ', 'A reference to a code defined by a terminology system ', 'Refering to codes is a ubiquitous task in healthcare models', false, 'CV', 'Codes may defined very casually in enumerations, or code lists, up to very formal definitions such as SNOMED-CT - see the v3 core principles for more information', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'code', 'Symbol in syntax defined by the system', 'A symbol in syntax defined by the system. The symbol may be a predefined code, or an expression in a syntax defined by the coding system', 'Need to refer to a particular code in the system', true, 'CV.code', '', '', '', '', 'Unless the CodeableConcept element has a dataAbsentReason, it must contain at least one coding with a code, or a text.', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'system', 'Identity of the terminology system ', 'The identification of the system that defines the meaning of the symbol in the code. Can be a simple list of enumerations, a list of codes with meanings, or all the way to a complex semantic web such '+
      'as SNOMED-CT, whether classification, terminology, or ontology', 'Need to be unambiguous about the source of the definition of the symbol', true, 'CV.codeSystem', 'The identity is a uri. It may be an OID or a UUID, which must be references to the HL7 OID registry, or a URI which either comes from the list of FHIR defined special URIs, or from some system defined'+
      ' elsewhere, in which case the URI should de-reference to establish the system unambiguously', '', '', '', '', '', 'uri', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'display', 'Representation defined by the system', 'A representation of the meaning of the code in the system, following the rules laid out by the system. ', 'Need to be able to carry a human readable meaning of the code for readers that do not recognise the system', false, 'CV.displayName', '', '', 'language?', '', '', '', 'string', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnInterval(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Interval', 'A set of ordered values defined by a low and high limit.', 'A set of ordered values defined by a low and high limit. The values may be of type Quantity, date, or dateTime', 'Need to be able to specify ranges of values or time periods', false, 'IVL', 'Not a duration - that''s a measure of time, but a duration that occurs at a fixed value of time. An interval specifies a range of values; the context of use will specify whether the entire range appli'+
      'es (e.g. "the patient was an inpatient of the hospital for this time range") or one value from the range applies (e.g. "give the patient between 2 and 4 tablets"). If a duration might be required, specify the type as Interval|Duration', '', '', '', '', '', 'GenericType', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'low', 'Low value (Text or elements from specified type)', 'The low value. The boundary is inclusive.', '', true, 'IVL.low', 'If the low element is missing, the meaning is that the low boundary is not known.', '', '', '', 'Unless the Interval element has a dataAbsentReason flag, it must contain a low', '', '[param]', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'high', 'High value (Text or elements from specified type)', 'The high value. The boundary is inclusive. See discussion in specification regarding how the high value boundary is interpreted for dates', '', true, 'IVL.high', 'If the high elements is missing, the meaning is that the high boundary is not known. On intervals over a time period, if the high is missing, it means that the interval is current and ongoing. When th'+
      'e interval applies to a HumanDate, the high value includes any matching date/time. When the interval applies to  other types, the high value is assumed to have arbitrarily high precision', '', '', '', 'Unless the Interval element has a dataAbsentReason flag and is not a humanDate, it must contain a high', '', '[param]', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnQuantity(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Quantity', 'A measured amount (or an amount that can potentially be measured).'+#10+'', 'A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitary units, and floating currencies', 'Need to able to capture all sorts of measured values, even if the measured value are not precisely quantified. Values include exact measures such as 3.51g, customary units such as 3 tablets, currencies such as $100.32USD', false, 'PQ, IVL<PQ>, MO, CO, CD, depending on the values', '', '', '', '', 'The context of use may frequently define what kind of quantity this is, and therefore what kind of units can be used. The context of use may also restrict the values for status.', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'value', 'Numerical value (with implicit precision)', 'The value of the measured amount. The value includes an implicit precision in the presentation of the value', 'Precision is handled implicitly in almost all cases of measurement', true, 'PQ.value, CO.value/code, MO.value, or IVL,high or low depending on the value', 'The implicit precision should always be honoured. Currency has it''s own rules for handling precision', '', '', '', 'Unless the Quantity element has a dataAbsentReason flag, it must contain a value', '', 'decimal', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'QuantityStatus', bsUnspecified, 'status', 'how the value should be understood and represented', 'how the value should be understood and represented - whether the actual value is greater or less than the mesaure due to measurement issues', 'Need a framework for handling measures where the value is <5ug/L or >400mg/L due to the limitations of measuring methodology. ', true, 'IVL properties', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'units', 'unit representation', 'A human readable form of the units', 'There are lots of representations for the units, and in many contexts, particular representations are fixed and required. i.e. mcg for micrograms, and not ug', true, 'PQ.translation.code?', '', '', '', '', 'Unless the Quantity element has a dataAbsentReason flag, it must contain a unit', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'code', 'A coded form of the unit', 'A computer processible form of the units in some unit representation system', 'Need a computable form of the units that is fixed across all forms. UCUM provides this for quantities, but SNOMED-CT provides many arbitrary units of interest.', true, 'PQ.code', 'The preferred system is UCUM, but SNOMED-CT can also be used (for customary units), or ISO 4217 for currency', '', '', '', 'The context of use may additionally require a code from a particular system (Unless the Quantity element has a dataAbsentReason flag)', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'system', 'The system that defines the coded form', 'The identification of the system that provides the coded form of the unit', 'Need to know the system that defines the coded form of the unit', true, 'MO.currency, CO.codeSystem', '', '', '', '', 'Must be present if a code is present', '', 'uri', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnChoice(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Choice', 'A code taken from a short list of codes that are not defined in a formal code system', 'A code taken from a short list of codes that are not defined in a formal code system', 'Questionnaires and the like - assessment scales. There''s no formal terminology underlying them, yet the possible choices affect the interpretation of the code. Because the choice can be quite dynamic'+
      ', the price of setting up formal infrastructure to carry the choices out of band is expensive ', false, 'Maps to an observation', 'Choice is generally used for things like pain scales, questionnaires or formally defined assessment indexes. The possible codes may be ordered with some arbitrarily defined scale. Choice does not fit '+
      'all assessment scales - the more combinatorial the value is, the less likely that Choice will be an appropriate data type', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'code', 'Selected code', 'The code or value that the user selected from the list of possible codes', '', true, 'Observation.value (CD)', 'The "code" might be a numerical choice in a pain scale, for instance, 1 where the choices are 1-5 with associated words for severity of pain', '', '', '', 'Must have a code unless a dataAbsentReason exists', '+', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'value', 'A list of possible values for the code', 'A list of possible values for the code', 'Need to know the possible codes the user could have chosen', true, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'code', 'Possible code', 'A possible code or value that the user could have chosen', 'Need to know the possible codes the user could have chosen', true, '', '', '', '', '', '', '--, -, +, ++', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'display', 'Display for the code', 'A set of words associated with the code to give it meaning, if any exist', 'Sometimes the codes have associated words that give it more more meaning', false, '', 'The code itself may convey sufficient meaning', '', '', '', '', '', 'string', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'isOrdered', 'If the order of the values has meaning', 'Whether the order of the values has an assigned meaning', 'The Choice may come from an ordered scale such as a pain scale or a an assessment scale, or it may be hust a random set of choices that have no particular order', true, '', '', '', '', '', '', '', 'boolean', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnAttachment(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Attachment', '', 'For referring to data content defined in other formats.', 'Many models need to include data defined in other specifications that is complex and opaque to the healthcare model. This includes documents, media recordings, structured data etc', false, 'ED', '', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MediaType', bsUnspecified, 'mimeType', 'the mime type of the content', 'Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data', 'Processors of the data need to be able to tell what the data is', true, 'ED.mediaType', '', '', '', '', '', 'text/plain, image/png', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'data', 'data inline, base64ed', 'The actual data of the attachment - a sequence of bytes. In XML, represented using base64', 'The data needs to able to be transmitted inline', true, 'ED.data', 'When represented in XML, text/? must have the same character encoding as the XML. ', '', 'Should this be handled by an extension? How common is it?', '', '', '', 'base64Binary', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'url', 'uri where the data can be found', 'An alternative location where the data can be accessed', 'The data needs to be transmitted by reference', true, 'ED.reference', 'If both data and url are provided, the url must point to the same content as the data contains. Urls may be relative references, or may be made to transient locations such as a wrapping envelope using'+
      ' cid: though this has ramifications for using signatures', '', 'Sort out relative URL references', '', '', 'http://www.acme.com/logo-small.png', 'uri', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'hash', 'sha-256 hash of the data (base64 )', 'The calculated hash of the data using SHA-256. In XML, represented using base64', 'included so that applications can verify that the contents of a location have not changed, and also so that a signature of the xml content can implicitly sign the content of an image without having to'+
      ' include the data in the instance or reference the url in the signature', false, 'ED.integrityCheck (with ED.integrityCheckAlgorithm = SHA-256', '', '', '', '', '', '', 'base64Binary', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Language', bsUnspecified, 'lang', 'ISO 639-3 language code', 'The language that the attachment is in', 'May need to be able to pick the right language for a person from a list of attachments in different languages', false, 'ED.language', 'note that the v3 lang is ISO 639-2, and this is ISO 639-3', '', '', '', '', 'en-us (US english), es-AR (Argentinian Spanish)', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'title', 'A name to display in place of the data', 'A name to display in place of the data', 'Applications need a name to display to a human user in place of the actual data', false, 'ED.title', '', '', '', '', '', '"Official Corporate Logo"', 'string', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnRatio(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Ratio', 'A ratio of two Quantity values - a numerator and a denominator. ', 'A ratio of two Quantity values - a numerator and a denominator. ', 'Need to able to capture ratios for some measurements (titers) and some rates (costs)', true, 'RTO', '', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'numerator', 'The numerator', 'The numerator', '', true, 'RTO.numerator', '', '', '', '', 'Unless the Interval element has a dataAbsentReason flag, it must contain a numerator', '', 'Quantity', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'denominator', 'The denominator', 'The denominator', '', true, 'RTO.denominator', '', '', '', '', 'Unless the Interval element has a dataAbsentReason flag,it must contain a denominator', '', 'Quantity', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnCodeableConcept(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'CodeableConcept', 'A concept - a reference to a terminology or just  text', 'A concept that may be defined by a formal reference to a terminology or ontology, or may be provided by text', 'This is a common pattern in healthcare - a concept that may be defined by one or more codes from formal definitions including LOINC and SNOMED-CT, and/or defined by the provision of text that captures a human sense of the concept', false, 'CD.displayName', 'Not all terminology uses fit this general pattern. In some cases, models should not use CodeableConcept and use Coding directly and provide their own structure for managing text, codings, translations'+
      ', and the relationship between elements and pre- and post-coordination', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'coding', 'A reference to a code defined by a terminology system ', 'A reference to a code defined by a terminology system ', 'Refering to codes is a ubiquitous task in helathcare models', true, 'CD or CD.translation', 'Codes may defined very casually in enumerations, or code lists, up to very formal definitions such as SNOMED-CT - see the v3 core principles for more information', '', '', '', '', '', 'Coding', true)
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'code', 'Symbol in syntax defined by the system', 'A symbol in syntax defined by the system. The symbol may be a predefined code, or an expression in a syntax defined by the coding system', 'Need to refer to a particular code in the system', true, 'CD.code or CD.translation.code', '', '', '', '', 'Unless the CodeableConcept element has a dataAbsentReason, it must contain at least one coding with a code, or a text.', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'system', 'Identity of the terminology system ', 'The identification of the system that defines the meaning of the symbol in the code. Can be a simple list of enumerations, a list of codes with meanings, or all the way to a complex semantic web such '+
      'as SNOMED-CT, whether classification, terminology, or ontology', 'Need to be unambiguous about the source of the definition of the symbol', true, 'CD.codeSystem or CD.translation.codeSystem', 'The identity is a uri. It may be an OID or a UUID, which must be references to the HL7 OID registry, or a URI which either comes from the list of FHIR defined special URIs, or from some system defined'+
      ' elsewhere, in which case the URI should de-reference to establish the system unambiguously', '', '', '', '', '', 'uri', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'display', 'Representation defined by the system', 'A representation of the meaning of the code in the system, following the rules laid out by the system. ', 'Need to be able to carry a human readable meaning of the code for readers that do not recognise the system', false, 'CD.displayName or CD.translation.displayName', '', '', 'language?', '', '', '', 'string', false)));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'text', 'A plain text representation of the concept', 'A human language representation of the concept as seen/selected/uttered by the user who entered the data, and/or which represents the intended meaning of the user or concept', 'The codes from the terminologies do not always capture the correct meaning with all the nuances of the human, or sometimes there is no appropriate code at all. In these cases, the text is used to capture the full meaning of the source', true, 'CD.originalText', 'Very often the text is the same as a displayName of one of the codings', '', '', '', 'Unless the CodeableConcept element has a dataAbsentReason flag other than "astext", it must contain at least one coding with a code, or a text', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'primary', 'Which code was chosen directly by the user', 'Indicates which of the codes in the codings was chosen by a user, if one was chosen directly', 'Where a user picks an actual code directly, it is useful to note that this is the primary input', false, 'root CD', '', '', '', '', '', '', 'xml:ID', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addTypeElementDefnIdentifier(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Identifier', 'An identifier ', 'A technical identifier - identifies some entity uniquely and unambiguously', 'Need to be able toi identify things with confidence, and be sure that the identification is not subject to misinterpretation', true, 'II', 'the Identifier class is a little looser than II because it allows URIs as well as registered OIDs or GUIDs', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cConditional, 1, 1, '', '', bsUnspecified, 'system', 'The system that defines the id', 'Identifies the type of the data in the attachment and allows a method to be chosen to interpret or render the data', 'Processors of the data need to be able to tell what the data is', true, 'II.root', '', '', '', '', 'Unless the Identifier element has a dataAbsentReason flag, it must contain a an id', 'http://www.acme.com/identifiers/patient', 'uri', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'id', 'the actual identifier', 'The actual data of the attachment', 'The data needs to able to be transmitted inline', true, 'II.extension, or II.root if system indicates OID or GUID', '', '', '', '', 'If the Identifier element is marked as mandatory, it must contain a system', '123456', 'string', false));
    definitions.types.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addStructureElementDefnSchedule(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Schedule', 'A schedule that specifies an event that may occur multiple times', 'A schedule that specifies an event that may occur multiple times. Schedules are not used for recording when things did happen, but when they are expected or requested to occur.', 'Need to able to track schedules. There are several different ways to do scheduling: one or more specified times, a simple rules like three times a day, or to say, x before/after meals, or something like that', true, 'GTS', '  A schedule can be either a list of events - intervals on which the event occurs, or a single event with repeating criteria, or just repeating criteria with no actual event. ', '', '', '', '', '', 'Structure', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'event', 'When the event occurs', 'When the event occurs', '', true, '', '', '', '', '', '', '', 'Interval(dateTime)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'repeat', 'Only if there is none or one event', 'Only if there is none or one event', '', true, '', '', '', '', '', 'There can only be a repeat element if there is none or one event', '', '', false)
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'frequency', 'Event occurs frequency times per duration', 'Event occurs frequency times per duration', '', true, '', '', '', '', '', 'Only one of frequency and when can be present', '', 'integer', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'EventTiming', bsUnspecified, 'when', 'Event occurs duration from common life event', 'Event occurs duration from common life event', '', true, '', '', '', '', '', 'Only one of frequency and when can be present', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'duration', 'repeating or event-related duration', 'repeating or event-related duration', '', true, '', '', '', '', '', '', '', 'Duration', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'count', 'number of times to repeat', 'number of times to repeat', '', true, '', 'An end need not be specified', '', '', '', '', '', 'integer', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'end', 'when to stop repeats', 'when to stop repeats', '', true, '', 'An end need not be specified', '', '', '', 'Only one of count and end can be present', '', 'dateTime', false)));
    definitions.structures.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addStructureElementDefnContact(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Contact', 'All kinds of technology mediated contact details for a person or organisation, including telephone, email, etc', 'All kinds of technology mediated contact details for a person or organisation, including telephone, email, etc', 'Need to track phone, fax, mobile, sms numbers, email addresses, twitter tags, etc', true, 'TEL', '', '', '', '', '', '', 'Structure', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'ContactSystem', bsUnspecified, 'system', 'What kind of contact this is', 'What kind of contact this is - what communications system is required to make use of the contact', '', true, 'TEL.scheme', '', '', '', '', 'A system is required if a value is provided', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'value', 'The actual contact details', 'The actual contact details, in a form that is meaningful to the designated communication system (i.e. phone number or email address).', 'Need to support legacy numbers that are not in a tightly controlled format ', true, 'TEL.url', 'additional out of band data such as extensions, or notes about use of the contact are sometimes included in the value', '', '', '', 'A value is required unless a dataAbsentReason flag is provided on the contact element.', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'ContactUse', bsUnspecified, 'use', 'How to use this address', 'How to use this address', 'Need to track the way a person uses this contact, so a user can choose which is appropriate for their purpose', true, 'TEL.use', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'Time period when the contact was/is in use', 'Time period when the contact was/is in use', '', false, 'TEL.useablePeriod', '', '', '', '', '', '', 'Interval(dateTime)', false));
    definitions.structures.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addStructureElementDefnAddress(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'Address', 'A postal address', 'There is a variety of postal address formats defined around the world. This format defines a superset that is the basis for addresses all around the world ', 'Need to be able to record postal addresses, along with notes about their use', true, 'AD', 'Note: address is for postal addresses, not physical locations', '', '', '', '', '', 'Structure', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AddressUse', bsUnspecified, 'use', 'The use of this address', 'The use of this address', '', true, 'AD.use', '', '', '', '', '', 'Home, Work', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'text', 'Text representation of the address', 'a full text representation of the address', '', true, 'AD.formatted', 'Can provide both a text representation, and parts', '', '', '', 'Either text or at least one part with a value is required unless a dataAbsentReason flag is provided on the name element', '137 Nowhere Street, Erewhon 9132', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, -1, '', '', bsUnspecified, 'part', '', 'A part of an address', '', true, 'ADXP', 'Can provide both a text representation, and parts', '', '', '', 'Either text or at least one part with a value is required unless a dataAbsentReason flag is provided on the name element', '', '', true)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AddressPartType', bsUnspecified, 'type', 'Type of address part (see below)', 'Type of address part (see below)', '', true, 'ADXP.type', '', '', '', '', '', 'Erewhon', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 0, 1, '', '', bsUnspecified, 'value', 'The content of the address part', 'The content of the address part', '', true, 'ADXP.value', '', '', '', '', '', 'City', 'string', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'Time period when address was/is in use', 'Time period when address was/is in use', '', false, 'AD.usablePeriod', '', '', '', '', '', '23-Mar 2010 -> 1-Jul 2010', 'Interval(dateTime)', false));
    definitions.structures.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addStructureElementDefnHumanName(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'HumanName', 'A name of a human, or a name given to an animal by a human.', 'A name of a human, or a name given to an animal by a human.', 'Need to be able to record names, along with notes about their use', true, 'EN', 'Names may be changed, or repudiated, or people may have different names in different contexts. Names may be divided into parts of different type that have variable significance depending on context, t'+
      'hough the division into parts does not always matter. With personal names, the different parts may or may not be imbued with some implicit meaning; various cultures associate different importance with'+
      ' the name parts, and the degree to which systems must care about name parts around the world varies widely.', '', '', '', '', '', 'Structure', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'NameUse', bsUnspecified, 'use', 'The use of this name', 'The use of this name', '', true, 'EN.use', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'text', 'Text representation of the full name', 'a full text representation of the name', '', true, 'EN.formatted', 'Can provide both a text representation, and parts', '', '', '', 'Either text or at least one part with a value is required unless a dataAbsentReason flag is provided on the name element', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, -1, '', '', bsUnspecified, 'part', 'A part of a name', 'A part of a name', '', true, 'ENXP', 'Can provide both a text representation, and parts', '', '', '', 'Either text or at least one part with a value is required unless a dataAbsentReason flag is provided on the name element', '', '', true)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'NamePartType', bsUnspecified, 'type', 'Type of name part (see below)', 'Type of name part', '', true, 'ENXP.type', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 0, 1, '', '', bsUnspecified, 'value', 'The content of the name part', 'The content of the name part', '', true, 'ENXP.value', '', '', '', '', '', '', 'string', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'Time period when name was/is in use', 'Time period when name was/is in use', '', false, 'EN.usablePeriod', '', '', '', '', '', '', 'Interval(dateTime)', false));
    definitions.structures.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addStructureElementDefnHumanId(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'HumanId', 'An identifier that humans use', 'An identifier that humans use. This is different to a system identifier because identifiers that humans use are regularly changed or retired due to human intervention and error. Note that an human ide'+
      'ntifier may be a system identifier on some master system, but becomes a human identifier elsewhere due to how it is exchanged between humans. Driver''s license nunmbers are a good example of this. Als'+
      'o, because human mediated identifiers are often invoked as implicit links to external business processes, such identifiers are often associated with multiple different resources. ', 'Need to be able to work with the many vagaries of human identifiers - that is, identifiers that humans use for things, with the attendent uncertainty and correction features', true, '', '', '', '', '', '', '', 'Structure', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'IdentifierType', bsExtensible, 'type', 'Code for identifier type', 'The type of the identifier - to allow a particular identifier to be picked elsewhere', 'Human identifiers often have some type associated with them that is important to allow the identifier to be picked as a basis for exchange elsewhere, either in other electronic interchanges, or paper forms', false, '', '', '', '', '', '', '', 'Coding', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'identifier', 'Actual identifier', 'The Actual identifier', '', true, '', '', '', '', '', 'An identifier with an id element is required unless a dataAbsentReason flag is provided on the identifier element. If the HumanId is mandatory, then the identifier element is also mandatory', '', 'Identifier', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'Time period when id was valid for use', 'Time period during which identifier was valid for use', '', false, '', '', '', '', '', '', '', 'Interval(dateTime)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'assigner', 'Organisation that issued id', 'Organisation that issued/manages the identifier', '', false, '', '', '', '', '', '', '', 'Resource(Organization)', false));
    definitions.structures.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addInfrastructureElementDefnExtension(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'Extension', '', 'Optional Extensions Element - found in all resources', 'The ability to add extensions in a structured way is what keeps FHIR resources simple', false, 'N/A', '', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'code', 'Code that identifies the meaning of the extension', 'The code that identifies the meaning of the extension by reference to the definitions', '', false, 'N/A', 'The only codes that can be used are those defined using the approved extensibility definitions', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'definition', 'Source of the definition for the code', 'Source of the definition for the code - a namespace or a URL', 'Everyone needs to be able to define extensions, but they also must be governed properly', false, 'N/A', 'The definition may point directly to a computable or human readable definition of the extensibility codes, or it may be a logical URI as declared in some other specification. The definition should be version specific', '', '', '', '', '', 'uri', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'ref', 'Internal reference to context of the extension (xml:id)', 'Internal reference to context of the extension - a pointer to an xml:id in the same resource', '', false, 'N/A', 'The order that extensions appear in is significant - where multiple extensions have the same ref id, they extend the target element in the order in which they appear in the extensions', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'ExtensionState', bsUnspecified, 'state', 'must-understand | superceded', 'The state or the extension - whether readers must must understand, or whether it''s superceded by being defined in the resource', '', true, 'N/A', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'value[x]', 'Value of extension', 'Value of extension - any of the types defined in the data types', '', false, 'N/A', '', '', '', '', 'Either a value or nested extensions may be present, but not both', '', '*', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, -1, '', '', bsUnspecified, 'extension', 'Nested Extensions', 'Nested Extensions - further extensions that are part of the extension', '', false, 'N/A', '', '', '', '', 'Either a value or nested extensions may be present, but not both', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, '#', '', '', '', false, '', '', '', '', '', '', '', '@Extension', false)));
    definitions.infrastructure.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addInfrastructureElementDefnConstraint(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Constraint', '', '', '', false, '', '', '', '', '', '', '', 'Structure', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResourceType', bsUnspecified, 'type', 'The Type of the resource being described', 'The Type of the resource being described', '', false, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Named Resource Profile', 'The name of an aggregation profile', '', false, '', 'This field is the target for a named aggregation definition (aggregation.name)', '', '', '', '', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'purpose', 'Human summary: why describe this resource?', 'Human summary: why describe this resource?', '', false, '', '', '', '', '', '', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'element', '', '', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'path', 'The path of the element (see the formal definitions)', 'The path of the element (see the formal definitions)', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Name this constraint for re-use & unrolling', 'Name this constraint for re-use & unrolling', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'purpose', 'Human summary: why describe this element?', 'Human summary: why describe this element?', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'min', 'Minimum Cardinality', 'Minimum Cardinality', '', false, '', '', '', '', '', '', '', 'integer', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'max', 'Maximum Cardinality (a number or *)', 'Maximum Cardinality (a number or *)', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'DataType', bsUnspecified, 'type', 'Type of the element', 'Type of the element', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ConformanceType', bsUnspecified, 'conformance', 'Mandatory|Conditional|Optional|Prohibited', 'Mandatory|Conditional|Optional|Prohibited', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'condition', 'Condition if conformance=Conditional', 'Condition if conformance=Conditional', '', false, '', '', '', '', '', 'Required if conformance = conditional', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'mustSupport', 'If the element must be usable', 'If the element must be usable', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'mustUnderstand', 'If the element must be understood', 'If the element must be understood', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'definition', 'More specific definition', 'More specific definition', '', false, '', '', '', '', '', '', '', 'string', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'target', 'Which mapping this is (v2, CDA, openEHR, etc)', 'Which mapping this is (v2, CDA, openEHR, etc)', '', false, '', '', '', '', '', '', '', 'string', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'map', 'Details of the mapping', 'Details of the mapping', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'mapping', '', '', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'aggregated', 'Whether this resource is aggregated', 'Whether this resource is aggregated', '', false, '', '', '', '', '', '', '', 'boolean', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Reference to a Named Resource Profile', 'Reference to a Named Resource Profile', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'aggregation', 'If context includes aggregation and type=Resource()', 'If context includes aggregation and type=Resource()', '', false, '', '', '', '', '', 'If context includes aggregation and type=Resource()', '', '', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'valueSet', 'Value set id (only if coded)', 'Value set id (only if coded)', '', false, '', '', '', '', '', '', '', 'string', false))
        .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'name', 'Reference to another element by element.name', 'Reference to another element by element.name', '', false, '', '', '', '', '', 'Either a name or a fixed value is required', '', 'string', false))
        .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, '[type]', 'Fixed value: [as defined for type]', 'Fixed value: [as defined for type]', '', false, '', '', '', '', '', 'Either a name or a fixed value is required', '', '*', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'value', '', '', '', false, '', '', '', '', '', '', '', '', false)));
    definitions.infrastructure.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addInfrastructureElementDefnNarrative(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Narrative', 'A human readable formatted text, including images', 'A human readable formatted text, including images', '', true, '', '', '', '', '', '', '', 'Type', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'NarrativeStatus', bsUnspecified, 'status', 'generated | extensions | additional', 'The status of the narrative - whether it is entirely generated (from just the defined data or the extensions too), or whether a human authored it, and it may contain additional data', '', false, '', '', '', '', '', 'The status is required when the narrative is the full resource narrative, but not required in resource references', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'xhtml', 'limited xhtml content', 'The actual narrative content, a stripped down version of XHTML', '', true, '', 'The contents of the html element are an XHTML fragment containing only the basic html formatting elements described in chapters 7-11 and 15 of the HTML 4.0 standard, <a> elements (either name or href)'+
      ', images, and internally contained stylesheets. The XHTML content may not contain a head, a body, external stylesheet references, scripts, forms, base/link/xlink, frames, iframes, and objects. ', '', '', '', '', '', 'xhtml', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'image', '', 'An image referred to directly in the xhtml', '', true, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MediaType', bsUnspecified, 'mimeType', 'mime type of image', 'mime type of image', '', true, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'content', 'base64 image data', 'base64 image data', '', true, '', '', '', '', '', '', '', 'base64Binary', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'map', '', 'A map from the narrative contents to the resource elements - an assertion that the text describes the some content as the data item describes', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Narrative source (xml:id)', 'The narrative end of the mapping', '', false, '', '', '', '', '', '', '', 'xml:ID', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'data', 'Data source (xml:id)', 'The resource element end of the mapping', '', false, '', '', '', '', '', '', '', 'xml:ID', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'NarrativeMapSource', bsUnspecified, 'source', 'text | data', 'Which end of the mapping is the source', '', false, '', '', '', '', '', '', '', 'code', false)));
    definitions.infrastructure.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Conformance', '', 'A conformance statement returned by request in an RESTful framework', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that the conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'software', '', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'RestfulConformanceMode', bsUnspecified, 'mode', 'client | server', 'client | server', '', false, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResourceType', bsUnspecified, 'resource', 'Resource Type with constraints', 'Resource Type with constraints', '', false, '', '', '', '', '', '', '', 'Constraint', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'operation', '', '', '', false, '', '', '', '', '', 'A resource type is required if the event declaration has multiple focal resources', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'read', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'vread', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'update', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'delete', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'validate', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'history', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'name', 'transaction names supported', 'transaction names supported', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'transaction', 'only if supported', 'only if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'param', 'search params supported', 'search params supported', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'search', 'only if supported', 'only if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResourceIdSource', bsUnspecified, 'id', 'source of id: client | server | either', 'source of id: client | server | either', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'create', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'param', 'update filter params supported', 'update filter params supported', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'updates', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'schema', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance profile for human interpretation', 'Text summary of conformance profile for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnDocument(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Document', 'A document that contains resources', 'A documentation of clinical observations and services that are aggregated together into a single statement of clinical meaning that establishes it''s own context. A clinical document is composed of a '+
      'set of resources that include both human and computer readable portions. A human must attest to the accuracy of the human readable portion, and may authenticate and/or sign the entire whole', 'For document based framework', true, '', '', '', 'Confidentiality? Language? Consent? Signatures', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id = document Id', 'the unique id of a clinical document', 'Each document needs a unique identifier so other documents and underlying infrastructure can reference it', true, '', 'must be globally unique. UUIDs are recommended', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'instant', 'Document Creation Time', 'the document creation time, when the document first came into being. Where the CDA document is a transform from an original document in some other format, the ClinicalDocument.effectiveTime is the time the original document is created.', '', true, '', '', '', '', '', '', '', 'instant', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'DocumentType', bsUnspecified, 'type', 'Document Type (LOINC if possible)', 'specifying the particular kind of document (e.g. History and Physical, Discharge Summary, Progress Note)', '', true, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'title', 'Document Title', 'the title of the document', '', false, '', 'It''s commonly the case that clinical documents do not have a title, and are collectively referred to by the display name of Document.type (e.g. a "consultation" or "progress note"). Where these displ'+
      'ay names are rendered to the clinician, or where the document has a unique title, the Document.title value should be used', '', '', '', '', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'setId', 'Id fixed across all document revisions', 'Represents an identifier that is common across all document revisions', '', true, '', '', '', '', '', 'cannot have both setId and replaces', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'version', 'used to version successive replacement documents', 'used to version successive replacement documents', '', true, '', 'An integer value is recommended', '', '', '', '', '', 'integer', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'replaces', 'If this document replaces another', 'If this document replaces another', '', true, '', '', '', '', '', 'cannot have both setId and replaces', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'subject', 'who the document is about', 'who the document is about', '', true, '', '', '', '', '', '', '', 'Resource(Patient|Group)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'author', 'Author (contributed content to document)', 'Author (contributed content to document)', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'time', 'When authoring happened', 'When authoring happened', '', false, '', '', '', '', '', '', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'party', 'who/what authored the final document', 'who/what authored the final document', '', false, '', '', '', '', '', '', '', 'Resource(Person|Device)', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'attestor', 'attests to accuracy of document', 'a participant who has attested to the accuracy of the document', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'DocumentAuthenticationMode', bsUnspecified, 'mode', 'personal | professional | legal | official', 'The type of attestation the authenticator offers', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'time', 'When document attested', 'When document attested', '', false, '', '', '', '', '', '', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'party', 'who attested the document', 'who attested the document', '', false, '', '', '', '', '', '', '', 'Resource(Person|Organisation)', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'recipient', 'expected to receive a copy ', 'expected to receive a copy ', '', false, '', '', '', '', '', '', '', 'Resource(Person|Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'custodian', 'org which maintains the document.', 'org which maintains the document.', '', false, '', '', '', '', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'event', 'the clinical item being documented', 'the main Act, such as a colonoscopy or an appendectomy, being documented', '', false, '', 'The event needs to be consistent with the type element, though can provide further information if desired', '', '', '', '', '', 'Resource(Any)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'encounter', 'context of the document', 'context of the document', '', false, '', '', '', '', '', '', '', 'Resource(Admission|InterestOfCare)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'section', 'Document is broken into sections', 'Document is broken into sections', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'DocumentSectionType', bsUnspecified, 'type', 'type of section (recommended)', 'type of section (recommended)', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'instant', 'Section Creation Time', 'the section creation time (sections are often re-used in several documents).', '', false, '', '', '', '', '', '', '', 'instant', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'time', 'When authoring happened', 'When authoring happened', '', false, '', '', '', '', '', '', '', 'dateTime', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'party', 'who/what authored the section', 'who/what authored the section', '', false, '', '', '', '', '', '', '', 'Resource(Person|Device)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'author', 'if section author different to document', 'if section author different to document', '', false, '', '', '', '', '', '', '', '', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'enterer', 'The source of the data entry', 'The person or device that performed the data entry leading to this section. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', '', false, '', '', '', '', '', '', '', 'Resource(Person|Device)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'subject', 'if section different to document', 'if section different to document', '', true, '', '', '', '', '', '', '', 'Resource(Person|Group)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'informant', 'provided information in section', 'provided information in section', '', false, '', '', '', '', '', '', '', 'Resource(Person)', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'content', 'the actual content of the section', 'the actual content of the section', '', true, '', '', '', '', '', 'a section must have content or one or more sections', '', 'Resource(Any)', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, '#', 'contents as for a section', 'contents as for a section', '', false, '', '', '', '', '', '', '', '@Document.Section', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, -1, '', '', bsUnspecified, 'section', 'nested Section', 'nested Section', '', false, '', '', '', '', '', 'a section must have content or one or more sections', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of message, for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnMessage(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Message', 'A message that contains resources', 'A message that contains FHIR resources', 'Many implementations are not prepared to use REST, and need a message based infrastructure', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id = Message Id', 'Unique Id for this message', 'Each message needs a unique identifier so other messages and underlying infrastructure can reference it', true, '', 'must be unique within a channel, but should be globally unique. UUIDs are recommended', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'threadId', 'Id of thread of conversation', 'Id of the thread - a series of messages that pertain to the same logical sequence, and are all identified by the same thread identifier', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'instant', 'Instant the message was sent', 'Instant the message was sent', '', true, '', '', '', '', '', '', '', 'instant', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageEvent', bsUnspecified, 'event', 'Code for the event his message represents', 'Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification', '', true, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'response', 'If this is a response', 'Information about the the message that this message is a response to - if it is a response', '', true, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Id of original message', 'The id of the message that this a response to', '', true, '', 'this message must have the same threadId as the original message (including missing if the original message threadId was missing)', '', '', '', '', '', 'id', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResponseCode', bsUnspecified, 'code', 'Type of response to the message', 'Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not', '', true, '', 'This is a generic response to the request message. Specific data for the response will be found in Message.data', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'duplicate', 'if this is not the first response', 'True if this is not the first response, because the request message has been received more than once', '', true, '', 'The request shouldn''t be received more than once if reliable message delivery applies, but mostly it doesn''t', '', '', '', '', '', 'boolean', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'source', 'Message Source Application', 'The source application from which this message originated', '', false, '', '', '', '', '', '', '', 'Resource(Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'destination', 'Message Destination Application', 'The destination application which the message is intended for', '', false, '', '', '', '', '', '', '', 'Resource(Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'enterer', 'The source of the data entry', 'The person or device that performd the data entry leading to this message. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'author', 'The source of the decision', 'The logical author of the message - the person or device that decided it should happen. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'responsible', 'final responsibility for event', 'The person or organization that accepts overall responsbility for the contents of the message. The implication is that the message event happened under the policies of the responsible party', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'effective', 'time of effect', 'The effective time - the real world time of the even that the message represents. Usually this is just a starting time, but some message events also have an end time (do x for period y)', 'Need to know for understanding the content of the message', false, '', 'Usually only for the request, but can be used in a response', '', 'Grahame thinks this is not 80/20. Also, that it reall should be domain modeled, not tucked away here', '', '', '', 'Interval(dateTime)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'EventReason', bsUnspecified, 'reason', 'Cause of event', 'The cause of the event - a reason for why this message is being sent', 'Need to be able to track why resources are being changed and report in the audit log / history of the resource', false, 'ControlAct.reasonCode', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'data', 'The actual content of the message', 'The actual data of the message - a reference to the focus class of the message. ', 'Every message event is about actual data, a single resource, that is identified in the definition of the event, and perhaps some or all linked resources', true, '', 'The data is defined where the transaction type is defined. The transaction data is always aggregated with the transaction resource', '', '', '', 'Mandatory unless the message is a response, in which case the element is optional', '', 'Resource(Any)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of message, for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnMessageConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'MessageConformance', '', 'A conformance statement about how an application uses FHIR messaging', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that the conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'software', '', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'event', '', 'An event supported by the application', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageEvent', bsUnspecified, 'code', 'Declare support for this event', 'The code for the event', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'ResourceType', bsUnspecified, 'resource', 'Which resource if event has multiple', 'The focal resource for the event', '', false, '', '', '', '', '', 'A resource type is required if the event declaration has multiple focal resources', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageConformanceEventMode', bsUnspecified, 'mode', 'Sender | Receiver', 'The mode of this event declaration - whether application is sender or receiver', '', false, '', '', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in request', 'Constraint on a resource used in the event request', '', false, '', '', '', '', '', '', '', 'Constraint', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'request', '', 'Information about the request for this event', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in response', 'Constraint on a resource used in the event response', '', false, '', '', '', '', '', '', '', 'Constraint', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'response', '', 'Information about the response for this event', '', false, '', '', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance statement for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnAgent(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Agent', '', 'A person who represents an organisation, and is authorised to perform actions on it''s behalf', 'Need to track doctors, staff, locums etc for both healthcare providers, funders, etc.', false, 'Role', '', 'PRD (as one example)', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '.id(scope=OBJ)', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'person', 'The person who is the agent', 'The person who acts as the agent', 'Need to be able to track the person who represents the organisation separately', true, '', '', 'PRD-2', '', '', '', '', 'Resource(Person)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'organization', 'The represented organization', 'The organisation that is being represented', 'Need to be able to track the represented organisation separately', true, '', '', 'PRD-10 (-> 14)', '', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', 'AgentRole', bsUnspecified, 'role', 'A role the agent has', 'The way in which the person represents the organisation - what role do they have?', 'Need to know what authority the agent has - what can they do?', true, '', 'A person may have more than one role. At least one role is required - why have an agent who isn''t actually an agent?', 'PRD-1', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'The period for which this agency applies', 'The time period during which the agent was/is authorised to represent the organisation.', 'Agencies are often for a limited period of time, and can be revoked. Even after the agencies is revoked, the fact that it existed must still be recorded', false, '', '', 'PRD-8/9', '', '', '', '', 'Interval(date)', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'A Human identifier for the person as this agent', 'An identifier that applies to this person in this role', 'Often, specific identifies are assigned for the agent', true, '', 'The identifier changes when a new/different person steps into the same role', 'PRD-7', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address that applies for the person as this agent', 'A postal address for this person playing this role', '', false, '', 'i.e. the address is not their personal address. For many agents, this is the same as their work address', 'PRD-3', 'What about place? (PRD-4)', '', '', '', 'Address', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'A contact that applies for the person as this agent', 'A contact detail address for this person playing this role', '', false, '', 'i.e. the contact is not their personal contact. For many agents, this is the same as their work contacts. Note that a person may choose to use a personal mobile phone (for instance) for their contact '+
      'in a given role - in this case, the contact detail will be repeated in the agent resource', 'PRD-5', '', '', '', '', 'Contact', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of the agent, for human interpretation', 'Text summary of the agent, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnAnimal(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Animal', '', 'An animal that has relevance to the care process -usually this is for animals that are patients.', 'Need to be able to track animals - vetinary medicine is an active user of HL7 standards', false, 'NonPersonLivingSubject(classCode=ANM, determinerCode=INST)', 'Animals differ because you need to track species and strain, and also different kind of relationships - owners', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '.id(scope=OBJ)', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'Human identifiers for this animal', 'Identifier for the animal that is used to identify the person across multiple disparate systems and also for face to face identification of the person', 'Animals are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the animal', true, '.scopes[Role](classCode=IDENT)', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'name', 'A name associated with the animal', 'A name associated with the animal. The use code maiden does not apply.', 'Some animals have names, which are assigned by humans for human reasons, and follow human naming patterns', true, '.name', '', '', '', '', '', '', 'HumanName', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dob', 'The birth date for the animal', 'The birth date for the animal', 'Age of the animal drives many clinical processes.', true, '.dateOfBirth', '', '', 'RIM change to support human date (time only - but is this needed in this context?)', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AnimalSpecies', bsUnspecified, 'species', 'Species for the Animal', 'Species for the animal', 'Need to know what kind of animal', true, '.code', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AnimalStrain', bsUnspecified, 'strain', 'Strain for the Animal', 'Strain for the animal', 'May need to know the specific kind within the species', true, '.strainText', '', '', 'Not sure why this is ED in the RIM.  Should probably change to SC.', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AnimalGender', bsUnspecified, 'gender', 'Gender for the Animal', 'Gender for the Animal', 'For managing the animal', true, '.administrativeGenderCode', 'Note that some animals have additional gender not encountered in humans?', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'relatedEntity', 'Kin, owner, care giver etc', 'Kin, owner, care giver etc', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the entity', 'Identifier for the entity', '', false, '', '', '', '', '', '', '', 'HumanId', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'AnimalRelationship', bsUnspecified, 'role', 'Type of relationship', 'Type of relationship', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Name of the related entity', 'Name of the related entity', '', false, '', '', '', '', '', '', '', 'HumanName', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address (usually human, but may be kin)', 'An address (usually human, but may be kin)', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'Contact details (usually for humans)', 'Contact details (usually for humans)', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '[varies]', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of animal, fall back for human interpretation', ' ', '', false, '', '', '', '.text', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnPrescription(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Prescription', '', 'Directions provided by a prescribing practitioner for a specific medication to be administered to an individual', 'Used to record details about the prescribed medication, administration schedule, dosage and dispensing.', false, 'SubstanceAdministration', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'identifier', 'Prescription identification', 'A identifier used in an external system and associated with this medication', 'Prescriptions are almost always assigned specific numerical identifiers', true, '.id', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'PrescriptionStatus', bsUnspecified, 'status', 'Status: Active|Completed', 'Actual status of the prescription', '', true, '.statusCode', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'patient', 'Patient receiving medicine', 'The patient the prescription is prescribing medicine for', '', true, '', '', '', '', '', '', '', 'Resource(Patient)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'prescriber', 'Prescribing doctor', 'The clinician or doctor prescribing the medication', '', false, '', '', '', '', '', '', '', 'Resource(Agent)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'prescribed', 'Date/time prescribed', 'Date/time on which the prescription was written', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dispense', 'Details of included dispense request', 'Details of the dispense as requested by the prescriber', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'repeats', 'Number of repeats', 'Requested number of repeats', '', false, '', 'Default is "1"', '', '', '', '', '', 'integer', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'quantity', 'Quantity per repeat', 'Requested quantity per repeat', '', false, '', '', '', '', '', '', '', 'Quantity', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dispenser', 'Person to fullfil the requested dispense', 'Person to fullfil the requested dispense', '', false, '', '', '', '', '', '', '', 'Resource(Agent|Organization)', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'medicine', 'Prescribed medicine', 'The one single medicatine, vaccine or therapeutic good prescribed in this prescription.', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'MedicationKind', bsUnspecified, 'productCode', 'Coded representation of medicine', 'Coded representation of medicine', '', true, '', '', '', 'Conformance should be "Required", not "Optional"', '', 'Can only be left empty if it cannot be coded', '', 'Coding', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'description', 'Textual description of medicine', 'Textual description of medicine, including strength and ingredients', '', false, '', '', '', '', '', 'Mandatory when medication cannot be coded', '', 'string', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MedicationKind', bsUnspecified, 'productCode', 'Coded representation of active ingredient', 'Coded representation of active ingredient', '', false, '', '', '', '', '', '', '', 'Coding', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'quantity', 'Relative quantity of active ingredient', 'Quantity of active ingredient expressed in relation to the whole of the prepared medicine', '', false, '', '', '', '', '', '', '', 'Ratio', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'activeIngredient', 'Active substance', 'The substance in the medication formulation that is pharmaceutically active and is responsible for the medication''s therapeutic effect', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MedicationKind', bsUnspecified, 'productCode', 'Coded representation of inactive ingredient', 'Coded representation of the inactive ingredient', '', false, '', '', '', '', '', '', '', 'Coding', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'quantity', 'Relative quantity of inactive ingredient', 'Quantity of inactive ingredient expressed in relation to the whole of the prepared medicine', '', false, '', '', '', '', '', '', '', 'Ratio', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'inactiveIngredient', 'Inactive substance', 'Ingredients in the medication that are not active', '', false, '', '', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'administrationRequest', 'Instructions for use', 'Instructions for the use of the medication. Includes details about the timing schedule, dosis amounts and additional usage instructions.', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'description', 'Textual instructions for use', 'Textual description of the use of the medication.', '', false, '', 'Can contain more details than the structured information under this element, but must be in accordance with it. May not contain information about the medicine itself.', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'totalPeriodicDosis', 'Total periodic dosis', 'Total dose per day/week or other period when more specific information is missing or cannot be expressed using the timing specifications.', 'It should be possible, as a last resort, to specify e.g. a daily dosis, even if more specific details are unknown', false, '', '', '', '', '', '', '', 'Ratio', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'start', 'Startdate for administration', 'First moment on which medication should be taken', '', false, '', '', '', '', '', 'Duration is given OR (Start is given AND (Duration OR End is given)) OR (Duration, Start and End are not given)', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'end', 'Enddate for administration', 'Last moment on which medication should be taken', '', false, '', '', '', '', '', 'Duration is given OR (Start is given AND (Duration OR End is given)) OR (Duration, Start and End are not given)', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'duration', 'Total duration of administration', 'Total duration of administration', '', false, '', '', '', '', '', 'Duration is given OR (Start is given AND (Duration OR End is given)) OR (Duration, Start and End are not given)', '', 'Quantity', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'numberOfAdministrations', 'Maximum number of separate administrations', 'Maximum number of separate administrations before the instruction ends.', '', false, '', '', '', '', '', 'Can be given instead of Duration, as specified above', '', 'integer', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', 'AdministrationPrecondition', bsUnspecified, 'precondition', 'Precondition for starting administration', 'Precondition for starting the administration specified in this instruction', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'BooleanYesNo', bsUnspecified, 'prn', 'Pro re nate: Yes|No', 'Pro re nate, "If necessary": Specifies whether administration depens on the state and symptoms of the patient', '', false, '', 'Default is "false"', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', 'AdministrationInstruction', bsUnspecified, 'additionalInstruction', 'Additional instructions', 'Additional details to guide administration. Especially relevant for medicine administered by patient', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AdministrationRoute', bsUnspecified, 'route', 'Route of administration', 'Route of administration (oral, nasal, intravenous)', '', false, '', 'Since the route of administration is generally determined by the choice of medication, it is not necessary to provide a value in route', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'dose[x]', 'Dose per administration', 'Dose per administration, expressed in units of the (prepared) product', '', false, '', 'Dose may be an interval, "2-3 tablets per 4 hours"', '', '', '', '', '', 'Quantity|Interval(Quantity)', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'rate', 'Flow-rate for IV', 'Flow-rate for IV', '', false, '', '', '', '', '', '', '', 'Quantity', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'schedule', 'Schedule for administration', 'Schedule for administration. If multiple are given, they are considered to be active in parrallel', '', false, '', 'Will submit proposal to change Schedule type.', '', '', '', '', '', 'Schedule', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'dosageInstruction', 'Dosage instruction', 'Specification of dose and schedule for administration', '', false, '', 'The can be >1 dosage instruction to support administration of varying doses, resulting in 1 instruction per fixed dose.', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PrescriptionReason', bsUnspecified, 'reason', 'Reason for prescription', 'Diagnosis which is the reason for prescribing this medicine', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of the prescription, for human interpretation', 'Text summary of the prescription, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnPatient(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Patient', '', 'A patient is a person or animal that is receiving care', 'Tracking patient is the center of the healthcare process', false, 'Patient', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '.id(scope=OBJ)', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'link', 'Other patients linked to this resource', 'A linked patient record is a record that concerns the same patient. Records are linked after it is realised that at least one was created in error.', 'Due to the clerical errors associated with the difficulties of identifying humans consistently, duplicate patient records are frequently created in error', true, '', 'More then two patient records may be linked. Note that there is a special transaction for linking patient records in the RESTful context, as record linking consistency must be maintained', '', '', '', '', '', 'Resource(Patient)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'active', 'Whether this patient record is active (in use)', 'Whether the patient record is in use, or has been removed from active use', 'Need to be able to mark a patient record as not to be used because it was created in error', true, '', 'If a record is inactive, and linked to an active record, then future patient/person/record updates should occur on the other patient', '', '', '', '', '', 'boolean', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'person', 'The person who is the patient', 'The person that this patient record is about', 'Need to link this patient record to a known and identifiable person (or animal)', true, '', '', '', '', '', 'Either an animal or a person must be provided, but not both', '', 'Resource(Person)', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'animal', 'The animal which is the patient', 'The animal that this patient record is about', 'Need to link this patient record to a known and identifiable animal (or person)', false, '', '', '', '', '', 'Either an animal or a person must be provided, but not both', '', 'Resource(Animal)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'provider', 'Organization managing the patient', 'The provider for whom this is a patient record', 'Need to know who recognises this patient record', true, '', '', '', 'But is thie same as institution above?', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'An identifier for the person as this patient', 'An identifier that applies to this person as a patient', 'Patients are almos always assigned specific numerical identifiers', true, '', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PatientDiet', bsUnspecified, 'diet', 'Dietary restrictions for the patient', 'Dietary restrictions for the patient', 'Track patients reported dietary restrictions to help with catering requirements', false, '', 'not for specifying medical diets, but for casual dietary restrictions such as vegetarian, diary-free, nut-free, etc', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PatientConfidentiality', bsUnspecified, 'confidentiality', 'Confidentiality of the patient records', 'Confidentiality of the patient records', 'Need to be able to track which patient records are particularly sensitive', false, '', 'Confidentiality tracking also occurs at more detailed points in the medical record', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PaperRecordLocation', bsUnspecified, 'recordLocation', 'Where the paper record is', 'The location of the paper record for the patient, if there is one', 'Track old paper records where these are still in use', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of person, for human interpretation', 'Text summary of person, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnOrganization(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Organization', '', 'For any organization/institution/government department that has relevance to the care process', '', false, 'Organization(classCode=ORG, determinerCode=INST)', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '.id(scope=OBJ)', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'Identifier for this organization', 'Identifier for the organization that is used to identify the organization across multiple disparate systems', 'Organizations are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the organization.', true, '.scopes[Role](classCode=IDENT)', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'name', '', 'A name associated with the organization', 'Need to use the name as the label of the organization', true, '.name', 'Don''t use HumanName since that has many non-organization things in it', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'value', 'A name associated with the organization', 'The actual name of the organization', '', true, '.part[1](type=NULL,qualifier=NULL).value', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When this name is/was in use', 'The period that this name was in use by the organization', 'Organizations have a habit of renaming themselves, and the current and past names are required', false, '.validTime', '', '', 'This is 80%??', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address for the organization', 'An address for the organization', 'May need to keep track of the organizations addresses for contacting, billing or reporting requirements', false, '.address', 'Organization may have multiple addresses with different uses or applicable periods. The use code home is not to be used', '', '', '', '', '', 'Address', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'A contact detail for the organization', 'A contact detail for the organization', 'Human contact for the organization', false, '.telecom', 'The use code home is not to be used. Note that these contacts are not the contact details of people who are employed by or represent the organization, but official contacts for the organization itself', '', '', '', '', '', 'Contact', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'OrganisationType', bsUnspecified, 'code', 'kind of organisation', 'The kind of organization that this is', 'Need to be able to track the kind of organization that this is - different organization types have different uses', false, '.code', 'Organizations can be corporations, wards, sections, clinical teams, government departments, etc. Note that code is generally a classifier of the type of organization; in many applications, codes are u'+
      'sed to identity a particular organization (say, ward) as opposed to another of the same type - these are identifiers, not codes', '', 'Name code is too RIM-like.  Should be typeCode or type.', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Industry', bsUnspecified, 'industryCode', 'kind of industry', 'The industry that this organization is involved in', 'For some organization types, an industry code is required for statistical reporting requirements', false, '.standardIndustryClassCode', '', '', 'Is this really in the 80%??', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'accreditation', '', 'The qualifications a person has, including format educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment', 'For many persons in healthcare, it is necessary to track the qualifications a person has - formal.', false, '.plays[Role](classCode=''QUAL'')', '', '', 'Not sure if qualified & accredited are the same.  Could potentially propose a new classCode', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the accreditation', 'The identifier of the accreditation', 'Allows a link back to a accreditation registry, if one exists', false, '.identifier', '', '', 'Not a humanId?', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Accreditation', bsUnspecified, 'code', 'What kind of accreditation', 'The type of the accreditation', 'commonly used to determine the roles an  organization may perform', false, '.code', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'institution', 'Who conferred it', 'The organization that confered/confers the accreditation', 'May determine the significance of the qualification, and allows a link back to a qualification registry, if one exists', false, '.scopedBy[Organization]', '', '', 'Do we need jurisdiction as well?  (The jurisdiction is often more relevant than the accrediting org.)', '', '', '', 'Resource(Organization)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When the accreditation is valid', 'The period for which the accreditation is held', 'Most accreditations are only conferred for a limited time period and must be re-acquired or forfeited', false, '.effectiveTime[IVL<TS>]', '', '', '', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'relatedOrganization', 'sub-, super-, and partner organisations', 'Other organizations who are related to this person. The relationship might be one of several types: sub- or super- orgnizations (i.e. ward in a hospital, owning corporation of a hospital) or partner o'+
      'rganizations (i.e. the operating corporation for a hospital)', 'Need to be able to track many kinds of organizational relationships and use to determine roles and mediate workflows', false, '', '', '', 'There''s no reason why this wouldn''t point to another resource.  Will map when updated accordingly.', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the organization', 'Identifier the related organization - may be a full link to an Organization resource, or some other kind of identifier', 'may have an identifier for the organization that can be used to source contact details', false, '', '', '', '', '', '', '', 'HumanId', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'OrganizationRelationship', bsUnspecified, 'code', 'How the organizations are related', 'Code that specifies how this organization is related to the subject. A code is required.', 'Need to know how the organization is related', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Name of the organization', 'A name should be specified for the related organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address for the organization', 'Postal addresses may be provided for the related organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'General contact details for the organization', 'Contact details (phone, email etc) may be provided for the related organization', '', false, '', '', '', '', '', '', '', 'Contact', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When the organizations were related', 'The period during which the organizations were related in this fashion', 'Organization relationships are changing all the time', false, '', '', '', '', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '[varies]', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of organization, fall back for human interpretation', 'Text summary of organization, fall back for human interpretation', '', false, '', '', '', '.text', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnDocumentConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'DocumentConformance', '', 'A conformance statement about how one or more FHIR documents', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that this conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'software', 'If this is for an application', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'document', 'document definition', 'A document definition', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name for this particular document profile', 'Name for this particular document profile', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'purpose', 'Human description of this particular profile', 'Human description of this particular profile', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in the document', 'Constraint on a resource used in the document', '', false, '', 'The first resource is the document resource', '', '', '', '', '', 'Constraint', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance profile for human interpretation', 'Text summary of conformance profile for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnLabReport(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'LabReport', '', 'The findings and interpretation of pathology tests performed on tissues and body fluids. This is typically done in a laboratory but may be done in other environments such as at the point of care', 'Use to record any pathology test result, including the result of a test on a specimen taken as part of a composite procedure or operation.', false, '', 'Not to be used for reporting on non-pathology test results e.g. diagnostic imaging, ECG or respiratory function tests. Not to be used to represent an entire cumulative report. This Pathology test resu'+
      'lt archetype represents only one of the result sets that is usually viewed as a vertical in a cumulative test report. A cumulative report is a view that is constructed from the results represented by '+
      'multiple OBSERVATION archetypes. This archetype is suitable for representation of general pathology test results, but not intended to cover full synoptic reports. For these, additional resources are required to represent the data properly', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'LabReportStatus', bsUnspecified, 'status', 'Registered|Interim|Final|Amended|Cancelled|Withdrawn', 'The status of the pathology test result as a whole', 'Labs routinely issue provisional/incomplete reports, or withdraw previously released reports', true, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'issued', 'date issed for current status', 'The date and/or time that the result was issued from the source for the recorded ?Test result status', 'Clinicians need to be able to check the date that the report was released', true, '', 'May be different from LabReport.updated, because that is the status of this record, not the report the record is about', '', '', '', '', '', 'instant', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'patient', 'The patient the report is about', 'The patient about who the report is about', 'Must know the patient context', true, '', '', '', 'need to check the wording -is it about, upon, for?', '', '', '', 'Resource(Patient)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'admission', 'Admission Context', 'The admission that this diagnostic investigation is associated with', 'Some institutions track and file diagnostic reports under a specific admission', false, '', '', '', 'Reckon this is not 80%', '', '', '', 'Resource(Admission)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'laboratory', 'Responsible Laboratory', 'The laboratory service that issued the report', 'Need to know how to contact if there are queries about the results. Also may need to track the source of reports for secondary data analysis', false, '', 'This is not necessarily the source of the atomic reports - it''s the lab that takes responsibility for the clinical report', '', '', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'reportId', 'Id for external references to this report', 'The local ID assigned to the report by the order filler, usually by the Laboratory Information System (LIS).', 'Need to know what identifier to use when making queries about this report from the source laboratory', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'requestDetail', '', 'Details concerning a single pathology test requested.', 'Need to be able to track completion of requests based on reports issued, and also to report what diagnostic test swere requested (not always the same as what is delivered)', false, '', 'Note: Usually there is one test request for each result, however in some circumstances multiple test requests may be represented using a single Pathology test result resource', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'requestOrderId', 'Id assigned by requester', 'The local ID assigned to the order by the order requester.', 'Need to be able to track completion of requests based on reports issued', false, '', 'Equivalent to the Placer Order Identifier', '', 'Reckon this is not 80%', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'receiverOrderId', 'Receiver''s Id for the request', 'The local ID assigned to the test order by the order filler, usually by the Laboratory Information System (LIS).', 'Need to be able to track completion of requests based on reports issued', false, '', 'Usually equivalent to the DICOM Accession Number and the Filler Order Identifier.', '', 'Reckon this is not 80%', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', 'LabRequests', bsUnspecified, 'requestTest', 'Test Requested', 'Identification of pathology test requested,', 'Need to be able to report what diagnostic test swere requested (not always the same as what is delivered)', false, '', 'Useful where the test requested differs from the test actually performed.', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'requester', 'Responsible for request', 'Details of the clinician or organisation requesting the laboratory test.', 'The requesting clinician may need to be contacted concerning the interpretation of the lab report', false, '', '', '', '', '', '', '', 'Resource(Agent|Organization)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'clinicalInfo', 'Clinical information provided', 'Details of the clinical information provided to the laboratory along with the original request', 'Knowing the clinical information may influence the interpretation of the result', false, '', '', '', '', '', '', '', 'Resource(Any)', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'LabReportNames', bsUnspecified, 'reportName', 'Name for the entire report', 'Identification of the pathology test performed, sometimes including specimen type.', 'Need to know what report this is, so clinicians can filter/find the reports they are looking for', true, '', 'A test result may be for a single analyte, or a group of items, including panel tests.', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabServices', bsUnspecified, 'service', 'Biochemistry, Haematology etc', 'The diagnostic service that performs the examination e.g. biochemistry, haematology.', 'Help clinicians filter/find the reports they are looking for', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'diagnosticTime', 'Effective time of diagnostic report', 'The diagnostically relevant time for this report', 'Need to know where in the patient history to file/present this report', true, '', 'The diagnostically relevant time can be derived from the specimen collection times, but the specimen information is not always available, and the exact relationship is not always automatic', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'specimen', 'Specimen (incl. time of collection)', 'Details about the specimen if all individual test results are derived from the same specimen', 'Need to be able to report information about the collected specimens on which the report is based', false, '', 'If the specimen is sufficiently specified with a code in the Test result name, then this additional data may be redundant. If there are multiple specimens, these may be represented per ''Result group''', '', '', '', '', '', 'Resource(Specimen)', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 1, -1, '', '', bsUnspecified, 'resultGroup', '', 'A group of results. Results may be grouped by specimen, or by some value in LabReport.resultGroup.name to describe what binds all the results together.', 'Need to be able to report groups of results, where the result grouping is arbitrary, but meaningful', true, '', 'Many (most) lab reports don''t really have a meaningful group. In these cases, just create a single group with no specimen or name', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabResultGroupNames', bsUnspecified, 'name', 'What defines the group', 'A code or name that describes the group of results', '', true, '', 'For example, the antibody code for a goup of antibody related test, or the organism code for a group of isolate/sensitivities. Leave blank if there is no particular meaning associated with the group', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'specimen', 'Specimen details', 'Details about the individual specimen to which these ?Result group? test results refer, where testing of multiple specimens is required.', 'Need to be able to report information about the collected specimens on which the report is based', false, '', '', '', '', '', '', '', 'Resource(Specimen)', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabResultNames', bsUnspecified, 'name', 'Name or code of the result', 'Identifies the meaning of the value', 'Need to know what the result is about', true, '', 'results are fundamentally a name - value pair with additional clarifying information', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '*unbound*', bsUnspecified, 'value[x]', 'Result. [x] = type name', 'Actual value of the result. Most result values will be numerical measurements, but others may be coded concepts, free text, or multimedia images', 'Need a value for the result', true, '', '', '', '', '', '', '', 'Quantity|CodeableConcept|Attachment|Ratio|Choice|Interval(dateTime)|string', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabResultFlag', bsUnspecified, 'flag', '+ | ++ | +++ | - | -- | --- ', 'Flag indicating the abnormal status of the result', '', true, '', '', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'LabReportStatus', bsUnspecified, 'status', 'Registered|Interim|Final|Amended|Cancelled|Withdrawn', 'The status of the result value', 'Need to track the status of individual results - some results are finalised before the whole report is finalised', true, '', '', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'comments', 'Comments about result', 'May include statements about significant, unexpected or unreliable. values, or information about the source of the value where this may be relevant to the interpretation of the result.', 'Need to be able to provide free text additional information', true, '', '', '', '', '', '', '', 'string', false))
          .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabReferenceRanges', bsUnspecified, 'meaning', 'The meaning of this range', 'Code for the meaning of the reference range', 'Need to be able to say what kind of reference range this is - normal, recommended, therapeutic, or perhaps what state this reference range applies to (i.e. hormonal cycles)', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
          .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'range[x]', 'Reference', 'Actual value of the reference range.  May be a quantity (<20mg/L), an interval (10-20 umol/L), or some text', 'Need to be able to report numerical or text reference ranges, and handle legacy data', false, '', 'Text reference ranges are typically used in endocrinology, or for legacy data with string reference ranges', '', '', '', '', '', 'Quantity|Interval(Quantity)|string', false))
        .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'referenceRange', '', 'Guidance on how to interpret the value by comparison to a normal or recommended range', 'Need to be able to provide multiple reference ranges', true, '', 'Most results only have one reference range. Some non-numerical results don''t have a reference range', '', '', '', '', '', '', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 1, -1, '', '', bsUnspecified, 'result', '', 'Specific detailed result, including both the value of the result item, and additional information that may be useful for clinical interpretation. Results include whatever specific data items pathology'+
      ' labs report as part of the clinical service; it is not confined to measurements.', 'Need to report results with information that assist with interpretation', true, '', '', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'conclusion', 'Clinical Interpretation of test results', 'Concise and clinically contextualised narrative interpretation of the pathology test results.', 'Need to be able to provide a conclusion that is not lost amongst the basic result data', true, '', 'common reports don''t have a conclusion, but some do', '', '', '', '', '', 'Narrative', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', 'LabDiagnosisCodes', bsUnspecified, 'codedDiagnosis', 'Codes for the conclusion', 'Codes for the conclusion', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 1, -1, '', '', bsUnspecified, 'representation', 'Entire Report as issued', 'Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they must be semantically equivalent.', 'Laboratory needs to be able to provide it''s own fully formatted report for clinical fidelity', true, '', 'Possible formats: text/html, text/plain, text/rtf, application/msword, application/pdf, application/rtf, application/vnd.oasis.opendocument.text, application/vnd.openxmlformats-officedocument.wordprocessingml.document', '', '', '', '', '', 'Attachment', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of report, for human interpretation', 'Text summary of report, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addResourceElementDefnPerson(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Person', '', 'A person who is involved in the healthcare process', 'Need to track persons across multiple roles', false, 'Person(classCode=PSN, determinerCode=INST)', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '.id(scope=OBJ)', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'A Human identifier for this person', 'Identifier for the person that is used to identify the person across multiple disparate systems and also for face to face identification of the person', 'People are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the patient.', true, '.plays:Role(classCode=''IDENT'').id', '', 'PID-3', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'name', 'A name associated with the person', 'A name associated with the person', 'Need to be able to track the person by multiple names', true, '.name', 'Person may have multiple names with different uses or applicable periods', 'PID-5, PID-9', '', '', '', '', 'HumanName', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address for the person', 'An address for the person', 'May need to keep track of persons addresses for contacting, billing or reporting requirements and also to help with identification', false, '.addr', 'Person may have multiple addresses with different uses or applicable periods', 'PID-11', '', '', '', '', 'Address', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'A contact detail for the person', 'A contact detail for the person', 'May need to have options for contacting the person urgently, and also to help with identification', false, '.telecom', 'Person may have multiple contacts with different uses or applicable periods', 'PID-13, PID-14', '', '', '', '', 'Contact', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dob', 'The birth date for the person', 'The birth date for the person', 'Age of person drives many clinical processes.', true, '.birthTime', 'At least a estimated year should be provided as a guess if the real dob is unknown', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AdministrativeGender', bsUnspecified, 'gender', 'Administrative Gender', 'Administrative Gender', 'Patient Identification, and also for managing the patient', true, '.administrativeGender', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Religion', bsUnspecified, 'religion', 'Religion of the person', 'The religious denomination to which a person professes affiliation', 'The religion of a person may influence ancilliary processes around the provision of healthcare, and may provide general advice with regard to diet, etc', false, '.religiousAffiliationCode', 'Not all people have a formal religious affiliation', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'qualification', 'Qualifications, Accreditations, Certifications', 'The qualifications a person has, including formal educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment', 'For many persons in healthcare, it is necessary to track the qualifications a person has - formal.', false, '.plays:Role(classCode=''QUAL'')', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the qualification', 'The identifier of a qualification', 'Allows a link back to a qualification registry, if one exists', false, '.identifier', '', '', '', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Qualifications', bsUnspecified, 'code', 'A code for the qualification', 'The type of the qualification', 'commonly used to determine the roles a person may play', false, '.code', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'institution', 'Who conferred it', 'The organisation that confered/confers the qualification', 'May determine the significance of the qualification, and allows a link back to a qualification registry, if one exists', false, '.scopedBy:Organization', '', '', '', '', '', '', 'Resource(Organization)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When the qualification is valid', 'The period for which a qualification is held', 'Some qualifications are only conferred for a limited time period and must be re-acquired or forfeited', false, '.effectiveTime:IVL_TS', 'Formal degrees may have a known start date, but no end date', '', '', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'language', '', 'A language spoken by the person, with proficiency', 'If a patient does not speak the local language, interpreters may be required, so languages spoken and profiency is an important things to keep track of both for patient and other persons of interest', false, '.LanguageCommunicationCode', 'If no language is specified, this *implies* that the default local language is spoken', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'Language', bsUnspecified, 'code', 'ISO 639-3 code for language', 'A code that identifies the language', '', false, '.languageCode', 'So just ISO 639-3?  Not allowing ENG-CA or something?', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LanguageUse', bsUnspecified, 'use', 'How well the language is used', 'A code the describes how well the language is spoken', '', false, '.proficiencyLanguageCode', 'No differentiation is made between spoken and written functionality here', '', '', '', '', '', 'code', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'relatedPerson', 'Kin, Guardians, Agents, Caregivers', 'Other persons who are related to this person. The relationship might be one of several types: kin (familial or marital), financial or legal (such as guardian), biological (e.g. donor, donation-recipient) or casual (i.e. friend).', 'Need to be able to track next of kin, or other people who may need to contacted/consulting regarding the patient''s healthcare status or who might otherwise influence their treatment', false, '.plays:Role(classCode=''REL'')', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the person', 'Identifier the related person - may be a full link to a Person resource, or some other kind of identifier', 'may have an identifier for the person that can be used to source contact details', false, '.scopedBy:Person.identifier', '', '', '', '', '', '', 'HumanId', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'PersonRelationship', bsUnspecified, 'role', 'Type of relationship', 'Code that specifies how this person is related to the subject. A code is required.', 'Need to know how the person is related', false, '.code', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Name of the person', 'A name should be specified for the related person', '', false, '.scopedBy:Person.name', '', '', '', '', '', '', 'HumanName', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'Contact details for the person', 'Contact details (phone, email etc) should be provided for the person', '', false, '.scopedBy:Person.telecom', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of person, for human interpretation', 'Text summary of person, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.resources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addSpecialResourceElementDefnConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Conformance', '', 'A conformance statement returned by request in an RESTful framework', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that the conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'software', '', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'RestfulConformanceMode', bsUnspecified, 'mode', 'client | server', 'client | server', '', false, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResourceType', bsUnspecified, 'resource', 'Resource Type with constraints', 'Resource Type with constraints', '', false, '', '', '', '', '', '', '', 'Constraint', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'operation', '', '', '', false, '', '', '', '', '', 'A resource type is required if the event declaration has multiple focal resources', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'read', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'vread', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'update', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'delete', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'validate', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'history', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'name', 'transaction names supported', 'transaction names supported', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'transaction', 'only if supported', 'only if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'param', 'search params supported', 'search params supported', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'search', 'only if supported', 'only if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResourceIdSource', bsUnspecified, 'id', 'source of id: client | server | either', 'source of id: client | server | either', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'create', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'param', 'update filter params supported', 'update filter params supported', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'updates', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'schema', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance profile for human interpretation', 'Text summary of conformance profile for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.SpecialResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addSpecialResourceElementDefnMessage(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Message', 'A message that contains resources', 'A message that contains FHIR resources', 'Many implementations are not prepared to use REST, and need a message based infrastructure', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id = Message Id', 'Unique Id for this message', 'Each message needs a unique identifier so other messages and underlying infrastructure can reference it', true, '', 'must be unique within a channel, but should be globally unique. UUIDs are recommended', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'threadId', 'Id of thread of conversation', 'Id of the thread - a series of messages that pertain to the same logical sequence, and are all identified by the same thread identifier', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'instant', 'Instant the message was sent', 'Instant the message was sent', '', true, '', '', '', '', '', '', '', 'instant', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageEvent', bsUnspecified, 'event', 'Code for the event his message represents', 'Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification', '', true, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'response', 'If this is a response', 'Information about the the message that this message is a response to - if it is a response', '', true, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Id of original message', 'The id of the message that this a response to', '', true, '', 'this message must have the same threadId as the original message (including missing if the original message threadId was missing)', '', '', '', '', '', 'id', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResponseCode', bsUnspecified, 'code', 'Type of response to the message', 'Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not', '', true, '', 'This is a generic response to the request message. Specific data for the response will be found in Message.data', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'duplicate', 'if this is not the first response', 'True if this is not the first response, because the request message has been received more than once', '', true, '', 'The request shouldn''t be received more than once if reliable message delivery applies, but mostly it doesn''t', '', '', '', '', '', 'boolean', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'source', 'Message Source Application', 'The source application from which this message originated', '', false, '', '', '', '', '', '', '', 'Resource(Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'destination', 'Message Destination Application', 'The destination application which the message is intended for', '', false, '', '', '', '', '', '', '', 'Resource(Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'enterer', 'The source of the data entry', 'The person or device that performd the data entry leading to this message. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'author', 'The source of the decision', 'The logical author of the message - the person or device that decided it should happen. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'responsible', 'final responsibility for event', 'The person or organization that accepts overall responsbility for the contents of the message. The implication is that the message event happened under the policies of the responsible party', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'effective', 'time of effect', 'The effective time - the real world time of the even that the message represents. Usually this is just a starting time, but some message events also have an end time (do x for period y)', 'Need to know for understanding the content of the message', false, '', 'Usually only for the request, but can be used in a response', '', 'Grahame thinks this is not 80/20. Also, that it reall should be domain modeled, not tucked away here', '', '', '', 'Interval(dateTime)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'EventReason', bsUnspecified, 'reason', 'Cause of event', 'The cause of the event - a reason for why this message is being sent', 'Need to be able to track why resources are being changed and report in the audit log / history of the resource', false, 'ControlAct.reasonCode', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'data', 'The actual content of the message', 'The actual data of the message - a reference to the focus class of the message. ', 'Every message event is about actual data, a single resource, that is identified in the definition of the event, and perhaps some or all linked resources', true, '', 'The data is defined where the transaction type is defined. The transaction data is always aggregated with the transaction resource', '', '', '', 'Mandatory unless the message is a response, in which case the element is optional', '', 'Resource(Any)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of message, for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.SpecialResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addSpecialResourceElementDefnMessageConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'MessageConformance', '', 'A conformance statement about how an application uses FHIR messaging', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that the conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'software', '', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'event', '', 'An event supported by the application', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageEvent', bsUnspecified, 'code', 'Declare support for this event', 'The code for the event', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'ResourceType', bsUnspecified, 'resource', 'Which resource if event has multiple', 'The focal resource for the event', '', false, '', '', '', '', '', 'A resource type is required if the event declaration has multiple focal resources', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageConformanceEventMode', bsUnspecified, 'mode', 'Sender | Receiver', 'The mode of this event declaration - whether application is sender or receiver', '', false, '', '', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in request', 'Constraint on a resource used in the event request', '', false, '', '', '', '', '', '', '', 'Constraint', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'request', '', 'Information about the request for this event', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in response', 'Constraint on a resource used in the event response', '', false, '', '', '', '', '', '', '', 'Constraint', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'response', '', 'Information about the response for this event', '', false, '', '', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance statement for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.SpecialResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addSpecialResourceElementDefnDocumentConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'DocumentConformance', '', 'A conformance statement about how one or more FHIR documents', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that this conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'software', 'If this is for an application', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'document', 'document definition', 'A document definition', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name for this particular document profile', 'Name for this particular document profile', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'purpose', 'Human description of this particular profile', 'Human description of this particular profile', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in the document', 'Constraint on a resource used in the document', '', false, '', 'The first resource is the document resource', '', '', '', '', '', 'Constraint', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance profile for human interpretation', 'Text summary of conformance profile for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.SpecialResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Conformance', '', 'A conformance statement returned by request in an RESTful framework', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that the conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'software', '', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'RestfulConformanceMode', bsUnspecified, 'mode', 'client | server', 'client | server', '', false, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResourceType', bsUnspecified, 'resource', 'Resource Type with constraints', 'Resource Type with constraints', '', false, '', '', '', '', '', '', '', 'Constraint', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'operation', '', '', '', false, '', '', '', '', '', 'A resource type is required if the event declaration has multiple focal resources', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'read', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'vread', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'update', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'delete', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'validate', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'history', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'name', 'transaction names supported', 'transaction names supported', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'transaction', 'only if supported', 'only if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'param', 'search params supported', 'search params supported', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'search', 'only if supported', 'only if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResourceIdSource', bsUnspecified, 'id', 'source of id: client | server | either', 'source of id: client | server | either', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'create', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'param', 'update filter params supported', 'update filter params supported', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'updates', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'schema', 'if supported', 'if supported', '', false, '', '', '', '', '', '', '', 'boolean', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance profile for human interpretation', 'Text summary of conformance profile for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnDocument(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Document', 'A document that contains resources', 'A documentation of clinical observations and services that are aggregated together into a single statement of clinical meaning that establishes it''s own context. A clinical document is composed of a '+
      'set of resources that include both human and computer readable portions. A human must attest to the accuracy of the human readable portion, and may authenticate and/or sign the entire whole', 'For document based framework', true, '', '', '', 'Confidentiality? Language? Consent? Signatures', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id = document Id', 'the unique id of a clinical document', 'Each document needs a unique identifier so other documents and underlying infrastructure can reference it', true, '', 'must be globally unique. UUIDs are recommended', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'instant', 'Document Creation Time', 'the document creation time, when the document first came into being. Where the CDA document is a transform from an original document in some other format, the ClinicalDocument.effectiveTime is the time the original document is created.', '', true, '', '', '', '', '', '', '', 'instant', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'DocumentType', bsUnspecified, 'type', 'Document Type (LOINC if possible)', 'specifying the particular kind of document (e.g. History and Physical, Discharge Summary, Progress Note)', '', true, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'title', 'Document Title', 'the title of the document', '', false, '', 'It''s commonly the case that clinical documents do not have a title, and are collectively referred to by the display name of Document.type (e.g. a "consultation" or "progress note"). Where these displ'+
      'ay names are rendered to the clinician, or where the document has a unique title, the Document.title value should be used', '', '', '', '', '', 'string', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'setId', 'Id fixed across all document revisions', 'Represents an identifier that is common across all document revisions', '', true, '', '', '', '', '', 'cannot have both setId and replaces', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'version', 'used to version successive replacement documents', 'used to version successive replacement documents', '', true, '', 'An integer value is recommended', '', '', '', '', '', 'integer', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'replaces', 'If this document replaces another', 'If this document replaces another', '', true, '', '', '', '', '', 'cannot have both setId and replaces', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'subject', 'who the document is about', 'who the document is about', '', true, '', '', '', '', '', '', '', 'Resource(Patient|Group)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'author', 'Author (contributed content to document)', 'Author (contributed content to document)', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'time', 'When authoring happened', 'When authoring happened', '', false, '', '', '', '', '', '', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'party', 'who/what authored the final document', 'who/what authored the final document', '', false, '', '', '', '', '', '', '', 'Resource(Person|Device)', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'attestor', 'attests to accuracy of document', 'a participant who has attested to the accuracy of the document', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'DocumentAuthenticationMode', bsUnspecified, 'mode', 'personal | professional | legal | official', 'The type of attestation the authenticator offers', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'time', 'When document attested', 'When document attested', '', false, '', '', '', '', '', '', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'party', 'who attested the document', 'who attested the document', '', false, '', '', '', '', '', '', '', 'Resource(Person|Organisation)', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'recipient', 'expected to receive a copy ', 'expected to receive a copy ', '', false, '', '', '', '', '', '', '', 'Resource(Person|Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'custodian', 'org which maintains the document.', 'org which maintains the document.', '', false, '', '', '', '', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'event', 'the clinical item being documented', 'the main Act, such as a colonoscopy or an appendectomy, being documented', '', false, '', 'The event needs to be consistent with the type element, though can provide further information if desired', '', '', '', '', '', 'Resource(Any)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'encounter', 'context of the document', 'context of the document', '', false, '', '', '', '', '', '', '', 'Resource(Admission|InterestOfCare)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'section', 'Document is broken into sections', 'Document is broken into sections', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'DocumentSectionType', bsUnspecified, 'type', 'type of section (recommended)', 'type of section (recommended)', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'instant', 'Section Creation Time', 'the section creation time (sections are often re-used in several documents).', '', false, '', '', '', '', '', '', '', 'instant', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'time', 'When authoring happened', 'When authoring happened', '', false, '', '', '', '', '', '', '', 'dateTime', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'party', 'who/what authored the section', 'who/what authored the section', '', false, '', '', '', '', '', '', '', 'Resource(Person|Device)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'author', 'if section author different to document', 'if section author different to document', '', false, '', '', '', '', '', '', '', '', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'enterer', 'The source of the data entry', 'The person or device that performed the data entry leading to this section. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', '', false, '', '', '', '', '', '', '', 'Resource(Person|Device)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'subject', 'if section different to document', 'if section different to document', '', true, '', '', '', '', '', '', '', 'Resource(Person|Group)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'informant', 'provided information in section', 'provided information in section', '', false, '', '', '', '', '', '', '', 'Resource(Person)', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'content', 'the actual content of the section', 'the actual content of the section', '', true, '', '', '', '', '', 'a section must have content or one or more sections', '', 'Resource(Any)', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, '#', 'contents as for a section', 'contents as for a section', '', false, '', '', '', '', '', '', '', '@Document.Section', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, -1, '', '', bsUnspecified, 'section', 'nested Section', 'nested Section', '', false, '', '', '', '', '', 'a section must have content or one or more sections', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of message, for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnMessage(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Message', 'A message that contains resources', 'A message that contains FHIR resources', 'Many implementations are not prepared to use REST, and need a message based infrastructure', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id = Message Id', 'Unique Id for this message', 'Each message needs a unique identifier so other messages and underlying infrastructure can reference it', true, '', 'must be unique within a channel, but should be globally unique. UUIDs are recommended', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'threadId', 'Id of thread of conversation', 'Id of the thread - a series of messages that pertain to the same logical sequence, and are all identified by the same thread identifier', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'instant', 'Instant the message was sent', 'Instant the message was sent', '', true, '', '', '', '', '', '', '', 'instant', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageEvent', bsUnspecified, 'event', 'Code for the event his message represents', 'Code that identifies the event this message represents, and connects it with the event definition in the FHIR specification', '', true, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'response', 'If this is a response', 'Information about the the message that this message is a response to - if it is a response', '', true, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Id of original message', 'The id of the message that this a response to', '', true, '', 'this message must have the same threadId as the original message (including missing if the original message threadId was missing)', '', '', '', '', '', 'id', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'ResponseCode', bsUnspecified, 'code', 'Type of response to the message', 'Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not', '', true, '', 'This is a generic response to the request message. Specific data for the response will be found in Message.data', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'duplicate', 'if this is not the first response', 'True if this is not the first response, because the request message has been received more than once', '', true, '', 'The request shouldn''t be received more than once if reliable message delivery applies, but mostly it doesn''t', '', '', '', '', '', 'boolean', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'source', 'Message Source Application', 'The source application from which this message originated', '', false, '', '', '', '', '', '', '', 'Resource(Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'destination', 'Message Destination Application', 'The destination application which the message is intended for', '', false, '', '', '', '', '', '', '', 'Resource(Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'enterer', 'The source of the data entry', 'The person or device that performd the data entry leading to this message. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'author', 'The source of the decision', 'The logical author of the message - the person or device that decided it should happen. Where there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Device)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'responsible', 'final responsibility for event', 'The person or organization that accepts overall responsbility for the contents of the message. The implication is that the message event happened under the policies of the responsible party', 'Need to know for audit/traceback requirements', false, '', 'Usually only for the request, but can be used in a response', '', '', '', '', '', 'Resource(Person|Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'effective', 'time of effect', 'The effective time - the real world time of the even that the message represents. Usually this is just a starting time, but some message events also have an end time (do x for period y)', 'Need to know for understanding the content of the message', false, '', 'Usually only for the request, but can be used in a response', '', 'Grahame thinks this is not 80/20. Also, that it reall should be domain modeled, not tucked away here', '', '', '', 'Interval(dateTime)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'EventReason', bsUnspecified, 'reason', 'Cause of event', 'The cause of the event - a reason for why this message is being sent', 'Need to be able to track why resources are being changed and report in the audit log / history of the resource', false, 'ControlAct.reasonCode', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'data', 'The actual content of the message', 'The actual data of the message - a reference to the focus class of the message. ', 'Every message event is about actual data, a single resource, that is identified in the definition of the event, and perhaps some or all linked resources', true, '', 'The data is defined where the transaction type is defined. The transaction data is always aggregated with the transaction resource', '', '', '', 'Mandatory unless the message is a response, in which case the element is optional', '', 'Resource(Any)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of message, for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnMessageConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'MessageConformance', '', 'A conformance statement about how an application uses FHIR messaging', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that the conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'software', '', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'event', '', 'An event supported by the application', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageEvent', bsUnspecified, 'code', 'Declare support for this event', 'The code for the event', '', false, '', '', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'ResourceType', bsUnspecified, 'resource', 'Which resource if event has multiple', 'The focal resource for the event', '', false, '', '', '', '', '', 'A resource type is required if the event declaration has multiple focal resources', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MessageConformanceEventMode', bsUnspecified, 'mode', 'Sender | Receiver', 'The mode of this event declaration - whether application is sender or receiver', '', false, '', '', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in request', 'Constraint on a resource used in the event request', '', false, '', '', '', '', '', '', '', 'Constraint', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'request', '', 'Information about the request for this event', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in response', 'Constraint on a resource used in the event response', '', false, '', '', '', '', '', '', '', 'Constraint', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'response', '', 'Information about the response for this event', '', false, '', '', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance statement for human interpretation', ' ', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnAgent(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Agent', '', 'A person who represents an organisation, and is authorised to perform actions on it''s behalf', 'Need to track doctors, staff, locums etc for both healthcare providers, funders, etc.', false, 'Role', '', 'PRD (as one example)', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '.id(scope=OBJ)', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'person', 'The person who is the agent', 'The person who acts as the agent', 'Need to be able to track the person who represents the organisation separately', true, '', '', 'PRD-2', '', '', '', '', 'Resource(Person)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'organization', 'The represented organization', 'The organisation that is being represented', 'Need to be able to track the represented organisation separately', true, '', '', 'PRD-10 (-> 14)', '', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', 'AgentRole', bsUnspecified, 'role', 'A role the agent has', 'The way in which the person represents the organisation - what role do they have?', 'Need to know what authority the agent has - what can they do?', true, '', 'A person may have more than one role. At least one role is required - why have an agent who isn''t actually an agent?', 'PRD-1', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'The period for which this agency applies', 'The time period during which the agent was/is authorised to represent the organisation.', 'Agencies are often for a limited period of time, and can be revoked. Even after the agencies is revoked, the fact that it existed must still be recorded', false, '', '', 'PRD-8/9', '', '', '', '', 'Interval(date)', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'A Human identifier for the person as this agent', 'An identifier that applies to this person in this role', 'Often, specific identifies are assigned for the agent', true, '', 'The identifier changes when a new/different person steps into the same role', 'PRD-7', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address that applies for the person as this agent', 'A postal address for this person playing this role', '', false, '', 'i.e. the address is not their personal address. For many agents, this is the same as their work address', 'PRD-3', 'What about place? (PRD-4)', '', '', '', 'Address', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'A contact that applies for the person as this agent', 'A contact detail address for this person playing this role', '', false, '', 'i.e. the contact is not their personal contact. For many agents, this is the same as their work contacts. Note that a person may choose to use a personal mobile phone (for instance) for their contact '+
      'in a given role - in this case, the contact detail will be repeated in the agent resource', 'PRD-5', '', '', '', '', 'Contact', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of the agent, for human interpretation', 'Text summary of the agent, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnAnimal(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Animal', '', 'An animal that has relevance to the care process -usually this is for animals that are patients.', 'Need to be able to track animals - vetinary medicine is an active user of HL7 standards', false, 'NonPersonLivingSubject(classCode=ANM, determinerCode=INST)', 'Animals differ because you need to track species and strain, and also different kind of relationships - owners', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '.id(scope=OBJ)', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'Human identifiers for this animal', 'Identifier for the animal that is used to identify the person across multiple disparate systems and also for face to face identification of the person', 'Animals are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the animal', true, '.scopes[Role](classCode=IDENT)', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'name', 'A name associated with the animal', 'A name associated with the animal. The use code maiden does not apply.', 'Some animals have names, which are assigned by humans for human reasons, and follow human naming patterns', true, '.name', '', '', '', '', '', '', 'HumanName', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dob', 'The birth date for the animal', 'The birth date for the animal', 'Age of the animal drives many clinical processes.', true, '.dateOfBirth', '', '', 'RIM change to support human date (time only - but is this needed in this context?)', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AnimalSpecies', bsUnspecified, 'species', 'Species for the Animal', 'Species for the animal', 'Need to know what kind of animal', true, '.code', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AnimalStrain', bsUnspecified, 'strain', 'Strain for the Animal', 'Strain for the animal', 'May need to know the specific kind within the species', true, '.strainText', '', '', 'Not sure why this is ED in the RIM.  Should probably change to SC.', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AnimalGender', bsUnspecified, 'gender', 'Gender for the Animal', 'Gender for the Animal', 'For managing the animal', true, '.administrativeGenderCode', 'Note that some animals have additional gender not encountered in humans?', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'relatedEntity', 'Kin, owner, care giver etc', 'Kin, owner, care giver etc', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the entity', 'Identifier for the entity', '', false, '', '', '', '', '', '', '', 'HumanId', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'AnimalRelationship', bsUnspecified, 'role', 'Type of relationship', 'Type of relationship', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Name of the related entity', 'Name of the related entity', '', false, '', '', '', '', '', '', '', 'HumanName', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address (usually human, but may be kin)', 'An address (usually human, but may be kin)', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'Contact details (usually for humans)', 'Contact details (usually for humans)', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '[varies]', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of animal, fall back for human interpretation', ' ', '', false, '', '', '', '.text', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnPrescription(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Prescription', '', 'Directions provided by a prescribing practitioner for a specific medication to be administered to an individual', 'Used to record details about the prescribed medication, administration schedule, dosage and dispensing.', false, 'SubstanceAdministration', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'identifier', 'Prescription identification', 'A identifier used in an external system and associated with this medication', 'Prescriptions are almost always assigned specific numerical identifiers', true, '.id', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'PrescriptionStatus', bsUnspecified, 'status', 'Status: Active|Completed', 'Actual status of the prescription', '', true, '.statusCode', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'patient', 'Patient receiving medicine', 'The patient the prescription is prescribing medicine for', '', true, '', '', '', '', '', '', '', 'Resource(Patient)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'prescriber', 'Prescribing doctor', 'The clinician or doctor prescribing the medication', '', false, '', '', '', '', '', '', '', 'Resource(Agent)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'prescribed', 'Date/time prescribed', 'Date/time on which the prescription was written', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dispense', 'Details of included dispense request', 'Details of the dispense as requested by the prescriber', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'repeats', 'Number of repeats', 'Requested number of repeats', '', false, '', 'Default is "1"', '', '', '', '', '', 'integer', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'quantity', 'Quantity per repeat', 'Requested quantity per repeat', '', false, '', '', '', '', '', '', '', 'Quantity', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dispenser', 'Person to fullfil the requested dispense', 'Person to fullfil the requested dispense', '', false, '', '', '', '', '', '', '', 'Resource(Agent|Organization)', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'medicine', 'Prescribed medicine', 'The one single medicatine, vaccine or therapeutic good prescribed in this prescription.', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', 'MedicationKind', bsUnspecified, 'productCode', 'Coded representation of medicine', 'Coded representation of medicine', '', true, '', '', '', 'Conformance should be "Required", not "Optional"', '', 'Can only be left empty if it cannot be coded', '', 'Coding', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'description', 'Textual description of medicine', 'Textual description of medicine, including strength and ingredients', '', false, '', '', '', '', '', 'Mandatory when medication cannot be coded', '', 'string', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MedicationKind', bsUnspecified, 'productCode', 'Coded representation of active ingredient', 'Coded representation of active ingredient', '', false, '', '', '', '', '', '', '', 'Coding', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'quantity', 'Relative quantity of active ingredient', 'Quantity of active ingredient expressed in relation to the whole of the prepared medicine', '', false, '', '', '', '', '', '', '', 'Ratio', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'activeIngredient', 'Active substance', 'The substance in the medication formulation that is pharmaceutically active and is responsible for the medication''s therapeutic effect', '', false, '', '', '', '', '', '', '', '', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'MedicationKind', bsUnspecified, 'productCode', 'Coded representation of inactive ingredient', 'Coded representation of the inactive ingredient', '', false, '', '', '', '', '', '', '', 'Coding', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'quantity', 'Relative quantity of inactive ingredient', 'Quantity of inactive ingredient expressed in relation to the whole of the prepared medicine', '', false, '', '', '', '', '', '', '', 'Ratio', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'inactiveIngredient', 'Inactive substance', 'Ingredients in the medication that are not active', '', false, '', '', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'administrationRequest', 'Instructions for use', 'Instructions for the use of the medication. Includes details about the timing schedule, dosis amounts and additional usage instructions.', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'description', 'Textual instructions for use', 'Textual description of the use of the medication.', '', false, '', 'Can contain more details than the structured information under this element, but must be in accordance with it. May not contain information about the medicine itself.', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'totalPeriodicDosis', 'Total periodic dosis', 'Total dose per day/week or other period when more specific information is missing or cannot be expressed using the timing specifications.', 'It should be possible, as a last resort, to specify e.g. a daily dosis, even if more specific details are unknown', false, '', '', '', '', '', '', '', 'Ratio', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'start', 'Startdate for administration', 'First moment on which medication should be taken', '', false, '', '', '', '', '', 'Duration is given OR (Start is given AND (Duration OR End is given)) OR (Duration, Start and End are not given)', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'end', 'Enddate for administration', 'Last moment on which medication should be taken', '', false, '', '', '', '', '', 'Duration is given OR (Start is given AND (Duration OR End is given)) OR (Duration, Start and End are not given)', '', 'dateTime', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'duration', 'Total duration of administration', 'Total duration of administration', '', false, '', '', '', '', '', 'Duration is given OR (Start is given AND (Duration OR End is given)) OR (Duration, Start and End are not given)', '', 'Quantity', false))
      .AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'numberOfAdministrations', 'Maximum number of separate administrations', 'Maximum number of separate administrations before the instruction ends.', '', false, '', '', '', '', '', 'Can be given instead of Duration, as specified above', '', 'integer', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', 'AdministrationPrecondition', bsUnspecified, 'precondition', 'Precondition for starting administration', 'Precondition for starting the administration specified in this instruction', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'BooleanYesNo', bsUnspecified, 'prn', 'Pro re nate: Yes|No', 'Pro re nate, "If necessary": Specifies whether administration depens on the state and symptoms of the patient', '', false, '', 'Default is "false"', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', 'AdministrationInstruction', bsUnspecified, 'additionalInstruction', 'Additional instructions', 'Additional details to guide administration. Especially relevant for medicine administered by patient', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AdministrationRoute', bsUnspecified, 'route', 'Route of administration', 'Route of administration (oral, nasal, intravenous)', '', false, '', 'Since the route of administration is generally determined by the choice of medication, it is not necessary to provide a value in route', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'dose[x]', 'Dose per administration', 'Dose per administration, expressed in units of the (prepared) product', '', false, '', 'Dose may be an interval, "2-3 tablets per 4 hours"', '', '', '', '', '', 'Quantity|Interval(Quantity)', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'rate', 'Flow-rate for IV', 'Flow-rate for IV', '', false, '', '', '', '', '', '', '', 'Quantity', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'schedule', 'Schedule for administration', 'Schedule for administration. If multiple are given, they are considered to be active in parrallel', '', false, '', 'Will submit proposal to change Schedule type.', '', '', '', '', '', 'Schedule', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'dosageInstruction', 'Dosage instruction', 'Specification of dose and schedule for administration', '', false, '', 'The can be >1 dosage instruction to support administration of varying doses, resulting in 1 instruction per fixed dose.', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PrescriptionReason', bsUnspecified, 'reason', 'Reason for prescription', 'Diagnosis which is the reason for prescribing this medicine', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of the prescription, for human interpretation', 'Text summary of the prescription, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnPatient(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Patient', '', 'A patient is a person or animal that is receiving care', 'Tracking patient is the center of the healthcare process', false, 'Patient', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '.id(scope=OBJ)', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 0, -1, '', '', bsUnspecified, 'link', 'Other patients linked to this resource', 'A linked patient record is a record that concerns the same patient. Records are linked after it is realised that at least one was created in error.', 'Due to the clerical errors associated with the difficulties of identifying humans consistently, duplicate patient records are frequently created in error', true, '', 'More then two patient records may be linked. Note that there is a special transaction for linking patient records in the RESTful context, as record linking consistency must be maintained', '', '', '', '', '', 'Resource(Patient)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'active', 'Whether this patient record is active (in use)', 'Whether the patient record is in use, or has been removed from active use', 'Need to be able to mark a patient record as not to be used because it was created in error', true, '', 'If a record is inactive, and linked to an active record, then future patient/person/record updates should occur on the other patient', '', '', '', '', '', 'boolean', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'person', 'The person who is the patient', 'The person that this patient record is about', 'Need to link this patient record to a known and identifiable person (or animal)', true, '', '', '', '', '', 'Either an animal or a person must be provided, but not both', '', 'Resource(Person)', false));
    cd.AddChild(TFHIRElementDefn.create(cConditional, 0, 1, '', '', bsUnspecified, 'animal', 'The animal which is the patient', 'The animal that this patient record is about', 'Need to link this patient record to a known and identifiable animal (or person)', false, '', '', '', '', '', 'Either an animal or a person must be provided, but not both', '', 'Resource(Animal)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'provider', 'Organization managing the patient', 'The provider for whom this is a patient record', 'Need to know who recognises this patient record', true, '', '', '', 'But is thie same as institution above?', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'An identifier for the person as this patient', 'An identifier that applies to this person as a patient', 'Patients are almos always assigned specific numerical identifiers', true, '', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PatientDiet', bsUnspecified, 'diet', 'Dietary restrictions for the patient', 'Dietary restrictions for the patient', 'Track patients reported dietary restrictions to help with catering requirements', false, '', 'not for specifying medical diets, but for casual dietary restrictions such as vegetarian, diary-free, nut-free, etc', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PatientConfidentiality', bsUnspecified, 'confidentiality', 'Confidentiality of the patient records', 'Confidentiality of the patient records', 'Need to be able to track which patient records are particularly sensitive', false, '', 'Confidentiality tracking also occurs at more detailed points in the medical record', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'PaperRecordLocation', bsUnspecified, 'recordLocation', 'Where the paper record is', 'The location of the paper record for the patient, if there is one', 'Track old paper records where these are still in use', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of person, for human interpretation', 'Text summary of person, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnOrganization(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Organization', '', 'For any organization/institution/government department that has relevance to the care process', '', false, 'Organization(classCode=ORG, determinerCode=INST)', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '.id(scope=OBJ)', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'Identifier for this organization', 'Identifier for the organization that is used to identify the organization across multiple disparate systems', 'Organizations are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the organization.', true, '.scopes[Role](classCode=IDENT)', '', '', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'name', '', 'A name associated with the organization', 'Need to use the name as the label of the organization', true, '.name', 'Don''t use HumanName since that has many non-organization things in it', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'value', 'A name associated with the organization', 'The actual name of the organization', '', true, '.part[1](type=NULL,qualifier=NULL).value', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When this name is/was in use', 'The period that this name was in use by the organization', 'Organizations have a habit of renaming themselves, and the current and past names are required', false, '.validTime', '', '', 'This is 80%??', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address for the organization', 'An address for the organization', 'May need to keep track of the organizations addresses for contacting, billing or reporting requirements', false, '.address', 'Organization may have multiple addresses with different uses or applicable periods. The use code home is not to be used', '', '', '', '', '', 'Address', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'A contact detail for the organization', 'A contact detail for the organization', 'Human contact for the organization', false, '.telecom', 'The use code home is not to be used. Note that these contacts are not the contact details of people who are employed by or represent the organization, but official contacts for the organization itself', '', '', '', '', '', 'Contact', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'OrganisationType', bsUnspecified, 'code', 'kind of organisation', 'The kind of organization that this is', 'Need to be able to track the kind of organization that this is - different organization types have different uses', false, '.code', 'Organizations can be corporations, wards, sections, clinical teams, government departments, etc. Note that code is generally a classifier of the type of organization; in many applications, codes are u'+
      'sed to identity a particular organization (say, ward) as opposed to another of the same type - these are identifiers, not codes', '', 'Name code is too RIM-like.  Should be typeCode or type.', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Industry', bsUnspecified, 'industryCode', 'kind of industry', 'The industry that this organization is involved in', 'For some organization types, an industry code is required for statistical reporting requirements', false, '.standardIndustryClassCode', '', '', 'Is this really in the 80%??', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'accreditation', '', 'The qualifications a person has, including format educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment', 'For many persons in healthcare, it is necessary to track the qualifications a person has - formal.', false, '.plays[Role](classCode=''QUAL'')', '', '', 'Not sure if qualified & accredited are the same.  Could potentially propose a new classCode', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the accreditation', 'The identifier of the accreditation', 'Allows a link back to a accreditation registry, if one exists', false, '.identifier', '', '', 'Not a humanId?', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Accreditation', bsUnspecified, 'code', 'What kind of accreditation', 'The type of the accreditation', 'commonly used to determine the roles an  organization may perform', false, '.code', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'institution', 'Who conferred it', 'The organization that confered/confers the accreditation', 'May determine the significance of the qualification, and allows a link back to a qualification registry, if one exists', false, '.scopedBy[Organization]', '', '', 'Do we need jurisdiction as well?  (The jurisdiction is often more relevant than the accrediting org.)', '', '', '', 'Resource(Organization)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When the accreditation is valid', 'The period for which the accreditation is held', 'Most accreditations are only conferred for a limited time period and must be re-acquired or forfeited', false, '.effectiveTime[IVL<TS>]', '', '', '', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'relatedOrganization', 'sub-, super-, and partner organisations', 'Other organizations who are related to this person. The relationship might be one of several types: sub- or super- orgnizations (i.e. ward in a hospital, owning corporation of a hospital) or partner o'+
      'rganizations (i.e. the operating corporation for a hospital)', 'Need to be able to track many kinds of organizational relationships and use to determine roles and mediate workflows', false, '', '', '', 'There''s no reason why this wouldn''t point to another resource.  Will map when updated accordingly.', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the organization', 'Identifier the related organization - may be a full link to an Organization resource, or some other kind of identifier', 'may have an identifier for the organization that can be used to source contact details', false, '', '', '', '', '', '', '', 'HumanId', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'OrganizationRelationship', bsUnspecified, 'code', 'How the organizations are related', 'Code that specifies how this organization is related to the subject. A code is required.', 'Need to know how the organization is related', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Name of the organization', 'A name should be specified for the related organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address for the organization', 'Postal addresses may be provided for the related organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'General contact details for the organization', 'Contact details (phone, email etc) may be provided for the related organization', '', false, '', '', '', '', '', '', '', 'Contact', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When the organizations were related', 'The period during which the organizations were related in this fashion', 'Organization relationships are changing all the time', false, '', '', '', '', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '[varies]', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of organization, fall back for human interpretation', 'Text summary of organization, fall back for human interpretation', '', false, '', '', '', '.text', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnDocumentConformance(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'DocumentConformance', '', 'A conformance statement about how one or more FHIR documents', '', false, '', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'ConformanceStatement Id (UUID)', 'Globally unique Conformance Statement Id (Must be a UUID)', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'date', 'Publication Date', 'Date that this conformance statement is published', '', false, '', '', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'publisher', '', 'The organization that publishes this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Publishing Organization', 'Name of Organization', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'address', 'Address of Organization', 'Address of Organization', '', false, '', '', '', '', '', '', '', 'Address', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, -1, '', '', bsUnspecified, 'contact', 'Contacts for Organization', 'Contacts for Organization', '', false, '', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'software', 'If this is for an application', 'The software that is covered by this conformance statement', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name software is known by', 'Name software is known by', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'version', 'Version covered by this statement', 'Version covered by this statement', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'releaseDate', 'Date this version released', 'Date this version released', '', false, '', '', '', '', '', '', '', 'dateTime', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'document', 'document definition', 'A document definition', '', false, '', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'name', 'Name for this particular document profile', 'Name for this particular document profile', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'purpose', 'Human description of this particular profile', 'Human description of this particular profile', '', false, '', '', '', '', '', '', '', 'string', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, -1, '', '', bsUnspecified, 'resource', 'Constraint on a resource used in the document', 'Constraint on a resource used in the document', '', false, '', 'The first resource is the document resource', '', '', '', '', '', 'Constraint', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of conformance profile for human interpretation', 'Text summary of conformance profile for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnLabReport(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'LabReport', '', 'The findings and interpretation of pathology tests performed on tissues and body fluids. This is typically done in a laboratory but may be done in other environments such as at the point of care', 'Use to record any pathology test result, including the result of a test on a specimen taken as part of a composite procedure or operation.', false, '', 'Not to be used for reporting on non-pathology test results e.g. diagnostic imaging, ECG or respiratory function tests. Not to be used to represent an entire cumulative report. This Pathology test resu'+
      'lt archetype represents only one of the result sets that is usually viewed as a vertical in a cumulative test report. A cumulative report is a view that is constructed from the results represented by '+
      'multiple OBSERVATION archetypes. This archetype is suitable for representation of general pathology test results, but not intended to cover full synoptic reports. For these, additional resources are required to represent the data properly', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'LabReportStatus', bsUnspecified, 'status', 'Registered|Interim|Final|Amended|Cancelled|Withdrawn', 'The status of the pathology test result as a whole', 'Labs routinely issue provisional/incomplete reports, or withdraw previously released reports', true, '', '', '', '', '', '', '', 'code', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'issued', 'date issed for current status', 'The date and/or time that the result was issued from the source for the recorded ?Test result status', 'Clinicians need to be able to check the date that the report was released', true, '', 'May be different from LabReport.updated, because that is the status of this record, not the report the record is about', '', '', '', '', '', 'instant', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'patient', 'The patient the report is about', 'The patient about who the report is about', 'Must know the patient context', true, '', '', '', 'need to check the wording -is it about, upon, for?', '', '', '', 'Resource(Patient)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'admission', 'Admission Context', 'The admission that this diagnostic investigation is associated with', 'Some institutions track and file diagnostic reports under a specific admission', false, '', '', '', 'Reckon this is not 80%', '', '', '', 'Resource(Admission)', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'laboratory', 'Responsible Laboratory', 'The laboratory service that issued the report', 'Need to know how to contact if there are queries about the results. Also may need to track the source of reports for secondary data analysis', false, '', 'This is not necessarily the source of the atomic reports - it''s the lab that takes responsibility for the clinical report', '', '', '', '', '', 'Resource(Organization)', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'reportId', 'Id for external references to this report', 'The local ID assigned to the report by the order filler, usually by the Laboratory Information System (LIS).', 'Need to know what identifier to use when making queries about this report from the source laboratory', false, '', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'requestDetail', '', 'Details concerning a single pathology test requested.', 'Need to be able to track completion of requests based on reports issued, and also to report what diagnostic test swere requested (not always the same as what is delivered)', false, '', 'Note: Usually there is one test request for each result, however in some circumstances multiple test requests may be represented using a single Pathology test result resource', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'requestOrderId', 'Id assigned by requester', 'The local ID assigned to the order by the order requester.', 'Need to be able to track completion of requests based on reports issued', false, '', 'Equivalent to the Placer Order Identifier', '', 'Reckon this is not 80%', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'receiverOrderId', 'Receiver''s Id for the request', 'The local ID assigned to the test order by the order filler, usually by the Laboratory Information System (LIS).', 'Need to be able to track completion of requests based on reports issued', false, '', 'Usually equivalent to the DICOM Accession Number and the Filler Order Identifier.', '', 'Reckon this is not 80%', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', 'LabRequests', bsUnspecified, 'requestTest', 'Test Requested', 'Identification of pathology test requested,', 'Need to be able to report what diagnostic test swere requested (not always the same as what is delivered)', false, '', 'Useful where the test requested differs from the test actually performed.', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'requester', 'Responsible for request', 'Details of the clinician or organisation requesting the laboratory test.', 'The requesting clinician may need to be contacted concerning the interpretation of the lab report', false, '', '', '', '', '', '', '', 'Resource(Agent|Organization)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'clinicalInfo', 'Clinical information provided', 'Details of the clinical information provided to the laboratory along with the original request', 'Knowing the clinical information may influence the interpretation of the result', false, '', '', '', '', '', '', '', 'Resource(Any)', false)));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'LabReportNames', bsUnspecified, 'reportName', 'Name for the entire report', 'Identification of the pathology test performed, sometimes including specimen type.', 'Need to know what report this is, so clinicians can filter/find the reports they are looking for', true, '', 'A test result may be for a single analyte, or a group of items, including panel tests.', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabServices', bsUnspecified, 'service', 'Biochemistry, Haematology etc', 'The diagnostic service that performs the examination e.g. biochemistry, haematology.', 'Help clinicians filter/find the reports they are looking for', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'diagnosticTime', 'Effective time of diagnostic report', 'The diagnostically relevant time for this report', 'Need to know where in the patient history to file/present this report', true, '', 'The diagnostically relevant time can be derived from the specimen collection times, but the specimen information is not always available, and the exact relationship is not always automatic', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'specimen', 'Specimen (incl. time of collection)', 'Details about the specimen if all individual test results are derived from the same specimen', 'Need to be able to report information about the collected specimens on which the report is based', false, '', 'If the specimen is sufficiently specified with a code in the Test result name, then this additional data may be redundant. If there are multiple specimens, these may be represented per ''Result group''', '', '', '', '', '', 'Resource(Specimen)', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 1, -1, '', '', bsUnspecified, 'resultGroup', '', 'A group of results. Results may be grouped by specimen, or by some value in LabReport.resultGroup.name to describe what binds all the results together.', 'Need to be able to report groups of results, where the result grouping is arbitrary, but meaningful', true, '', 'Many (most) lab reports don''t really have a meaningful group. In these cases, just create a single group with no specimen or name', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabResultGroupNames', bsUnspecified, 'name', 'What defines the group', 'A code or name that describes the group of results', '', true, '', 'For example, the antibody code for a goup of antibody related test, or the organism code for a group of isolate/sensitivities. Leave blank if there is no particular meaning associated with the group', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'specimen', 'Specimen details', 'Details about the individual specimen to which these ?Result group? test results refer, where testing of multiple specimens is required.', 'Need to be able to report information about the collected specimens on which the report is based', false, '', '', '', '', '', '', '', 'Resource(Specimen)', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabResultNames', bsUnspecified, 'name', 'Name or code of the result', 'Identifies the meaning of the value', 'Need to know what the result is about', true, '', 'results are fundamentally a name - value pair with additional clarifying information', '', '', '', '', '', 'CodeableConcept', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '*unbound*', bsUnspecified, 'value[x]', 'Result. [x] = type name', 'Actual value of the result. Most result values will be numerical measurements, but others may be coded concepts, free text, or multimedia images', 'Need a value for the result', true, '', '', '', '', '', '', '', 'Quantity|CodeableConcept|Attachment|Ratio|Choice|Interval(dateTime)|string', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabResultFlag', bsUnspecified, 'flag', '+ | ++ | +++ | - | -- | --- ', 'Flag indicating the abnormal status of the result', '', true, '', '', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'LabReportStatus', bsUnspecified, 'status', 'Registered|Interim|Final|Amended|Cancelled|Withdrawn', 'The status of the result value', 'Need to track the status of individual results - some results are finalised before the whole report is finalised', true, '', '', '', '', '', '', '', 'code', false))
        .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'comments', 'Comments about result', 'May include statements about significant, unexpected or unreliable. values, or information about the source of the value where this may be relevant to the interpretation of the result.', 'Need to be able to provide free text additional information', true, '', '', '', '', '', '', '', 'string', false))
          .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LabReferenceRanges', bsUnspecified, 'meaning', 'The meaning of this range', 'Code for the meaning of the reference range', 'Need to be able to say what kind of reference range this is - normal, recommended, therapeutic, or perhaps what state this reference range applies to (i.e. hormonal cycles)', false, '', '', '', '', '', '', '', 'CodeableConcept', false))
          .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'range[x]', 'Reference', 'Actual value of the reference range.  May be a quantity (<20mg/L), an interval (10-20 umol/L), or some text', 'Need to be able to report numerical or text reference ranges, and handle legacy data', false, '', 'Text reference ranges are typically used in endocrinology, or for legacy data with string reference ranges', '', '', '', '', '', 'Quantity|Interval(Quantity)|string', false))
        .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'referenceRange', '', 'Guidance on how to interpret the value by comparison to a normal or recommended range', 'Need to be able to provide multiple reference ranges', true, '', 'Most results only have one reference range. Some non-numerical results don''t have a reference range', '', '', '', '', '', '', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 1, -1, '', '', bsUnspecified, 'result', '', 'Specific detailed result, including both the value of the result item, and additional information that may be useful for clinical interpretation. Results include whatever specific data items pathology'+
      ' labs report as part of the clinical service; it is not confined to measurements.', 'Need to report results with information that assist with interpretation', true, '', '', '', '', '', '', '', '', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'conclusion', 'Clinical Interpretation of test results', 'Concise and clinically contextualised narrative interpretation of the pathology test results.', 'Need to be able to provide a conclusion that is not lost amongst the basic result data', true, '', 'common reports don''t have a conclusion, but some do', '', '', '', '', '', 'Narrative', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', 'LabDiagnosisCodes', bsUnspecified, 'codedDiagnosis', 'Codes for the conclusion', 'Codes for the conclusion', '', false, '', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 1, -1, '', '', bsUnspecified, 'representation', 'Entire Report as issued', 'Rich text representation of the entire result as issued by the diagnostic service. Multiple formats are allowed but they must be semantically equivalent.', 'Laboratory needs to be able to provide it''s own fully formatted report for clinical fidelity', true, '', 'Possible formats: text/html, text/plain, text/rtf, application/msword, application/pdf, application/rtf, application/vnd.oasis.opendocument.text, application/vnd.openxmlformats-officedocument.wordprocessingml.document', '', '', '', '', '', 'Attachment', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of report, for human interpretation', 'Text summary of report, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;

procedure addDefinedResourceElementDefnPerson(definitions : TFHIRDefinitions);
var
  cd : TFHIRElementDefn;
begin
  cd := TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'Person', '', 'A person who is involved in the healthcare process', 'Need to track persons across multiple roles', false, 'Person(classCode=PSN, determinerCode=INST)', '', '', '', '', '', '', 'Resource', false);
  try
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'id', 'Master Resource Id, always first in all resources', 'Master Resource Id, always first in all resources', '', false, '.id(scope=OBJ)', '', '', '', '', '', '', 'id', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'identifier', 'A Human identifier for this person', 'Identifier for the person that is used to identify the person across multiple disparate systems and also for face to face identification of the person', 'People are known by a variety of ids. Some institutions maintain several, and most collect identifiers for exchange with other organizations concerning the patient.', true, '.plays:Role(classCode=''IDENT'').id', '', 'PID-3', '', '', '', '', 'HumanId', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'name', 'A name associated with the person', 'A name associated with the person', 'Need to be able to track the person by multiple names', true, '.name', 'Person may have multiple names with different uses or applicable periods', 'PID-5, PID-9', '', '', '', '', 'HumanName', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'address', 'An address for the person', 'An address for the person', 'May need to keep track of persons addresses for contacting, billing or reporting requirements and also to help with identification', false, '.addr', 'Person may have multiple addresses with different uses or applicable periods', 'PID-11', '', '', '', '', 'Address', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'A contact detail for the person', 'A contact detail for the person', 'May need to have options for contacting the person urgently, and also to help with identification', false, '.telecom', 'Person may have multiple contacts with different uses or applicable periods', 'PID-13, PID-14', '', '', '', '', 'Contact', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'dob', 'The birth date for the person', 'The birth date for the person', 'Age of person drives many clinical processes.', true, '.birthTime', 'At least a estimated year should be provided as a guess if the real dob is unknown', '', '', '', '', '', 'dateTime', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'AdministrativeGender', bsUnspecified, 'gender', 'Administrative Gender', 'Administrative Gender', 'Patient Identification, and also for managing the patient', true, '.administrativeGender', '', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Religion', bsUnspecified, 'religion', 'Religion of the person', 'The religious denomination to which a person professes affiliation', 'The religion of a person may influence ancilliary processes around the provision of healthcare, and may provide general advice with regard to diet, etc', false, '.religiousAffiliationCode', 'Not all people have a formal religious affiliation', '', '', '', '', '', 'CodeableConcept', false));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'qualification', 'Qualifications, Accreditations, Certifications', 'The qualifications a person has, including formal educational achievements, accreditations, and current certifications. All these qualifications may be used to determine what roles a person may play in a healthcare environment', 'For many persons in healthcare, it is necessary to track the qualifications a person has - formal.', false, '.plays:Role(classCode=''QUAL'')', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the qualification', 'The identifier of a qualification', 'Allows a link back to a qualification registry, if one exists', false, '.identifier', '', '', '', '', '', '', 'Identifier', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'Qualifications', bsUnspecified, 'code', 'A code for the qualification', 'The type of the qualification', 'commonly used to determine the roles a person may play', false, '.code', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'institution', 'Who conferred it', 'The organisation that confered/confers the qualification', 'May determine the significance of the qualification, and allows a link back to a qualification registry, if one exists', false, '.scopedBy:Organization', '', '', '', '', '', '', 'Resource(Organization)', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'period', 'When the qualification is valid', 'The period for which a qualification is held', 'Some qualifications are only conferred for a limited time period and must be re-acquired or forfeited', false, '.effectiveTime:IVL_TS', 'Formal degrees may have a known start date, but no end date', '', '', '', '', '', 'Interval(date)', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'language', '', 'A language spoken by the person, with proficiency', 'If a patient does not speak the local language, interpreters may be required, so languages spoken and profiency is an important things to keep track of both for patient and other persons of interest', false, '.LanguageCommunicationCode', 'If no language is specified, this *implies* that the default local language is spoken', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'Language', bsUnspecified, 'code', 'ISO 639-3 code for language', 'A code that identifies the language', '', false, '.languageCode', 'So just ISO 639-3?  Not allowing ENG-CA or something?', '', '', '', '', '', 'code', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', 'LanguageUse', bsUnspecified, 'use', 'How well the language is used', 'A code the describes how well the language is spoken', '', false, '.proficiencyLanguageCode', 'No differentiation is made between spoken and written functionality here', '', '', '', '', '', 'code', false)));
    cd.AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'relatedPerson', 'Kin, Guardians, Agents, Caregivers', 'Other persons who are related to this person. The relationship might be one of several types: kin (familial or marital), financial or legal (such as guardian), biological (e.g. donor, donation-recipient) or casual (i.e. friend).', 'Need to be able to track next of kin, or other people who may need to contacted/consulting regarding the patient''s healthcare status or who might otherwise influence their treatment', false, '.plays:Role(classCode=''REL'')', '', '', '', '', '', '', '', false)
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'id', 'Identifier for the person', 'Identifier the related person - may be a full link to a Person resource, or some other kind of identifier', 'may have an identifier for the person that can be used to source contact details', false, '.scopedBy:Person.identifier', '', '', '', '', '', '', 'HumanId', false))
      .AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', 'PersonRelationship', bsUnspecified, 'role', 'Type of relationship', 'Code that specifies how this person is related to the subject. A code is required.', 'Need to know how the person is related', false, '.code', '', '', '', '', '', '', 'CodeableConcept', false))
      .AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'name', 'Name of the person', 'A name should be specified for the related person', '', false, '.scopedBy:Person.name', '', '', '', '', '', '', 'HumanName', false))
      .AddChild(TFHIRElementDefn.create(cUnstated, 0, -1, '', '', bsUnspecified, 'contact', 'Contact details for the person', 'Contact details (phone, email etc) should be provided for the person', '', false, '.scopedBy:Person.telecom', '', '', '', '', '', '', 'Contact', false)));
    cd.AddChild(TFHIRElementDefn.create(cOptional, 0, 1, '', '', bsUnspecified, 'extensions', 'See Extensions', 'See Extensions', '', false, '', '', '', '', '', '', '', '', false));
    cd.AddChild(TFHIRElementDefn.create(cMandatory, 1, 1, '', '', bsUnspecified, 'text', 'Text summary of person, for human interpretation', 'Text summary of person, for human interpretation', '', false, '', '', '', '', '', '', '', 'Narrative', false));
    definitions.DefinedResources.add(cd.Link);
  finally
    cd.free
  end;
end;


function LoadFHIRDefinitions : TFHIRDefinitions;
begin
  result := TFHIRDefinitions.create;
  try
    addConceptDomainMessageConformanceEventMode(result);
    addConceptDomainDataType(result);
    addConceptDomainMediaType(result);
    addConceptDomainNarrativeStatus(result);
    addConceptDomainAgentRole(result);
    addConceptDomainPersonRelationship(result);
    addConceptDomainAnimalSpecies(result);
    addConceptDomainIdentifierType(result);
    addConceptDomainAnimalRelationship(result);
    addConceptDomainLabReportNames(result);
    addConceptDomainPrescriptionStatus(result);
    addConceptDomainPatientConfidentiality(result);
    addConceptDomainAddressUse(result);
    addConceptDomainNamePartType(result);
    addConceptDomainContactUse(result);
    addConceptDomainNarrativeMapSource(result);
    addConceptDomainBooleanYesNo(result);
    addConceptDomainLabRequests(result);
    addConceptDomainAnimalGender(result);
    addConceptDomainAnimalStrain(result);
    addConceptDomainReligion(result);
    addConceptDomainPrescriptionReason(result);
    addConceptDomainContactSystem(result);
    addConceptDomainAccreditation(result);
    addConceptDomainDocumentSectionType(result);
    addConceptDomainLabDiagnosisCodes(result);
    addConceptDomainLabReportStatus(result);
    addConceptDomainAdministrationPrecondition(result);
    addConceptDomainConformanceType(result);
    addConceptDomainAdministrationInstruction(result);
    addConceptDomainDataAbsentReason(result);
    addConceptDomainLabResultNames(result);
    addConceptDomainPaperRecordLocation(result);
    addConceptDomainIndustry(result);
    addConceptDomainDocumentAuthenticationMode(result);
    addConceptDomainPatientDiet(result);
    addConceptDomainMedicationKind(result);
    addConceptDomainAddressPartType(result);
    addConceptDomainLabResultGroupNames(result);
    addConceptDomainLanguageUse(result);
    addConceptDomainQualifications(result);
    addConceptDomainMessageEvent(result);
    addConceptDomainResourceType(result);
    addConceptDomainEventTiming(result);
    addConceptDomainResourceIdSource(result);
    addConceptDomainDocumentType(result);
    addConceptDomainNameUse(result);
    addConceptDomainExtensionState(result);
    addConceptDomainLabResultFlag(result);
    addConceptDomainOrganisationType(result);
    addConceptDomainQuantityStatus(result);
    addConceptDomainResponseCode(result);
    addConceptDomainAdministrationRoute(result);
    addConceptDomainLabServices(result);
    addConceptDomainRestfulConformanceMode(result);
    addConceptDomainAdministrativeGender(result);
    addConceptDomainOrganizationRelationship(result);
    addConceptDomainEventReason(result);
    addConceptDomainLanguage(result);
    addConceptDomainLabReferenceRanges(result);

    result.KnownResources.add(TFHIRDefinedCode.create('Conformance', 'A conformance statement returned by request in an RESTful framework', 'conformance'));
    result.KnownResources.add(TFHIRDefinedCode.create('Document', 'A documentation of clinical observations and services that are aggregated together into a single statement of clinical meaning that establishes it''s own context. A clinical document is composed of a '+
      'set of resources that include both human and computer readable portions. A human must attest to the accuracy of the human readable portion, and may authenticate and/or sign the entire whole', 'document'));
    result.KnownResources.add(TFHIRDefinedCode.create('Message', 'A message that contains FHIR resources', 'message'));
    result.KnownResources.add(TFHIRDefinedCode.create('Animal', 'An animal that has relevance to the care process -usually this is for animals that are patients.', 'animal'));
    result.KnownResources.add(TFHIRDefinedCode.create('Agent', 'A person who represents an organisation, and is authorised to perform actions on it''s behalf', 'agent'));
    result.KnownResources.add(TFHIRDefinedCode.create('MessageConformance', 'A conformance statement about how an application uses FHIR messaging', 'messageconformance'));
    result.KnownResources.add(TFHIRDefinedCode.create('Organization', 'For any organization/institution/government department that has relevance to the care process', 'organization'));
    result.KnownResources.add(TFHIRDefinedCode.create('Prescription', 'Directions provided by a prescribing practitioner for a specific medication to be administered to an individual', 'prescription'));
    result.KnownResources.add(TFHIRDefinedCode.create('InterestOfCare', 'Yet to be defined', 'interestofcare'));
    result.KnownResources.add(TFHIRDefinedCode.create('Admission', 'Yet to be defined', 'admission'));
    result.KnownResources.add(TFHIRDefinedCode.create('Specimen', 'Yet to be defined', 'specimen'));
    result.KnownResources.add(TFHIRDefinedCode.create('Device', 'Yet to be defined', 'device'));
    result.KnownResources.add(TFHIRDefinedCode.create('Patient', 'A patient is a person or animal that is receiving care', 'patient'));
    result.KnownResources.add(TFHIRDefinedCode.create('Group', 'Yet to be defined', 'group'));
    result.KnownResources.add(TFHIRDefinedCode.create('Person', 'A person who is involved in the healthcare process', 'person'));
    result.KnownResources.add(TFHIRDefinedCode.create('LabReport', 'The findings and interpretation of pathology tests performed on tissues and body fluids. This is typically done in a laboratory but may be done in other environments such as at the point of care', 'labreport'));
    result.KnownResources.add(TFHIRDefinedCode.create('DocumentConformance', 'A conformance statement about how one or more FHIR documents', 'documentconformance'));

    result.FutureResources.add(TFHIRDefinedCode.create('InterestOfCare', 'Yet to be defined', 'interestofcare'));
    result.FutureResources.add(TFHIRDefinedCode.create('Admission', 'Yet to be defined', 'admission'));
    result.FutureResources.add(TFHIRDefinedCode.create('Specimen', 'Yet to be defined', 'specimen'));
    result.FutureResources.add(TFHIRDefinedCode.create('Device', 'Yet to be defined', 'device'));
    result.FutureResources.add(TFHIRDefinedCode.create('Group', 'Yet to be defined', 'group'));

    result.Constraints.add(TFHIRDefinedCode.create('Count', 'Count', 'Quantity'));
    result.Constraints.add(TFHIRDefinedCode.create('Money', 'Money', 'Quantity'));
    result.Constraints.add(TFHIRDefinedCode.create('Distance', 'Distance', 'Quantity'));
    result.Constraints.add(TFHIRDefinedCode.create('Duration', 'Duration', 'Quantity'));

    result.Primitives.add(TFHIRDefinedCode.create('sid', 'A system id, which is a uri taken from the list of known definition systems', ''));
    result.Primitives.add(TFHIRDefinedCode.create('dateTime', 'A date, date-time or partial date (e.g. just year or year + month). Generally, there is no timezone, though one may be populated if hours and minutes are specified. The format is a union of the schema'+
      ' types gYear, gYearMonth, date, and dateTime. Seconds may be provided but may also be ignored.  Dates must be valid dates.', ''));
    result.Primitives.add(TFHIRDefinedCode.create('integer', 'A whole number', '32 bit number; for values larger than this, use decimal'));
    result.Primitives.add(TFHIRDefinedCode.create('code', 'A string which has at least one character and no leading or trailing whitespace', ''));
    result.Primitives.add(TFHIRDefinedCode.create('date', 'A date, or partial date (e.g. just year or year + month). There is no timezone. The format is a union of the schema types gYear, gYearMonth, and date.  Dates must be valid dates.', ''));
    result.Primitives.add(TFHIRDefinedCode.create('decimal', 'A rational number, with implicit precision', 'Do not use a IEEE type floating point type, instead use something that works like a true decimal, with inbuilt precision (i.e. Java BigInteger)'));
    result.Primitives.add(TFHIRDefinedCode.create('uri', 'is a string of characters used to identify a name or a resource', 'see http://en.wikipedia.org/wiki/Uniform_resource_identifier'));
    result.Primitives.add(TFHIRDefinedCode.create('id', 'A whole number in the range 0 to 2^64-1, optionally represented in hex, a uuid, an oid, or any other combination of lower-case letters a-z, numerals, "-" and ".", with a length limit of 36 characters', ''));
    result.Primitives.add(TFHIRDefinedCode.create('base64Binary', 'A stream of bytes', 'Base64 encoded in the XML'));
    result.Primitives.add(TFHIRDefinedCode.create('oid', 'An ISO oid', 'See ISO/IEC 8824:1990 ?'));
    result.Primitives.add(TFHIRDefinedCode.create('string', 'A sequence of Unicode characters', 'Note that FHIR strings may not exceed 1MB in size'));
    result.Primitives.add(TFHIRDefinedCode.create('boolean', 'value can be true or false', ''));
    result.Primitives.add(TFHIRDefinedCode.create('uuid', 'A UUID', 'See The Open Group, CDE 1.1 Remote Procedure Call specification, Appendix A.'));
    result.Primitives.add(TFHIRDefinedCode.create('instant', 'An instant in time - known at least to the second', 'Note: For system times, not human times (see below). Timezone is always required'));

    addKnownTypeBoolean_1(result);
    addKnownTypeInteger_2(result);
    addKnownTypeDecimal_3(result);
    addKnownTypeBase64Binary_4(result);
    addKnownTypeInstant_5(result);
    addKnownTypeString_6(result);
    addKnownTypeUri_7(result);
    addKnownTypeCode_8(result);
    addKnownTypeOid_9(result);
    addKnownTypeUuid_10(result);
    addKnownTypeSid_11(result);
    addKnownTypeId_12(result);
    addKnownTypeDate_13(result);
    addKnownTypeDateTime_14(result);
    addKnownTypeAttachment_15(result);
    addKnownTypeIdentifier_16(result);
    addKnownTypeCodeableConcept_17(result);
    addKnownTypeCoding_18(result);
    addKnownTypeChoice_19(result);
    addKnownTypeQuantity_20(result);
    addKnownTypeDuration_21(result);
    addKnownTypeDistance_22(result);
    addKnownTypeCount_23(result);
    addKnownTypeMoney_24(result);
    addKnownTypeInterval_25(result);
    addKnownTypeRatio_26(result);
    addKnownTypeHumanId_27(result);
    addKnownTypeHumanName_28(result);
    addKnownTypeAddress_29(result);
    addKnownTypeContact_30(result);
    addKnownTypeSchedule_31(result);
    addKnownTypeNarrative_32(result);
    addKnownTypeConstraint_33(result);
    addKnownTypeExtensions_34(result);

    addTypeElementDefnCoding(result);
    addTypeElementDefnInterval(result);
    addTypeElementDefnQuantity(result);
    addTypeElementDefnChoice(result);
    addTypeElementDefnAttachment(result);
    addTypeElementDefnRatio(result);
    addTypeElementDefnCodeableConcept(result);
    addTypeElementDefnIdentifier(result);
    addStructureElementDefnSchedule(result);
    addStructureElementDefnContact(result);
    addStructureElementDefnAddress(result);
    addStructureElementDefnHumanName(result);
    addStructureElementDefnHumanId(result);
    addInfrastructureElementDefnExtension(result);
    addInfrastructureElementDefnConstraint(result);
    addInfrastructureElementDefnNarrative(result);
    addResourceElementDefnConformance(result);
    addResourceElementDefnDocument(result);
    addResourceElementDefnMessage(result);
    addResourceElementDefnMessageConformance(result);
    addResourceElementDefnAgent(result);
    addResourceElementDefnAnimal(result);
    addResourceElementDefnPrescription(result);
    addResourceElementDefnPatient(result);
    addResourceElementDefnOrganization(result);
    addResourceElementDefnDocumentConformance(result);
    addResourceElementDefnLabReport(result);
    addResourceElementDefnPerson(result);
    addSpecialResourceElementDefnConformance(result);
    addSpecialResourceElementDefnMessage(result);
    addSpecialResourceElementDefnMessageConformance(result);
    addSpecialResourceElementDefnDocumentConformance(result);
    addDefinedResourceElementDefnConformance(result);
    addDefinedResourceElementDefnDocument(result);
    addDefinedResourceElementDefnMessage(result);
    addDefinedResourceElementDefnMessageConformance(result);
    addDefinedResourceElementDefnAgent(result);
    addDefinedResourceElementDefnAnimal(result);
    addDefinedResourceElementDefnPrescription(result);
    addDefinedResourceElementDefnPatient(result);
    addDefinedResourceElementDefnOrganization(result);
    addDefinedResourceElementDefnDocumentConformance(result);
    addDefinedResourceElementDefnLabReport(result);
    addDefinedResourceElementDefnPerson(result);

    result.Link;
  finally
    result.free
  end;
end;

end.

