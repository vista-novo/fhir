package org.hl7.fhir.instance.model;

public class ResourceFactory {

    public static Resource createResource(String name) throws Exception {
        if ("Conformance".equals(name))
            return new Conformance();
        if ("Document".equals(name))
            return new Document();
        if ("Device".equals(name))
            return new Device();
        if ("Message".equals(name))
            return new Message();
        if ("MessageConformance".equals(name))
            return new MessageConformance();
        if ("Agent".equals(name))
            return new Agent();
        if ("Animal".equals(name))
            return new Animal();
        if ("Prescription".equals(name))
            return new Prescription();
        if ("Organization".equals(name))
            return new Organization();
        if ("Admission".equals(name))
            return new Admission();
        if ("Group".equals(name))
            return new Group();
        if ("InterestOfCare".equals(name))
            return new InterestOfCare();
        if ("Specimen".equals(name))
            return new Specimen();
        if ("Patient".equals(name))
            return new Patient();
        if ("DocumentConformance".equals(name))
            return new DocumentConformance();
        if ("LabReport".equals(name))
            return new LabReport();
        if ("Person".equals(name))
            return new Person();
        else
            throw new Exception("Unknown Resource Name '"+name+"'");
    }

    public static Element createType(String name) throws Exception {
        if ("Extensions".equals(name))
            return new Extension();
        if ("Coding".equals(name))
            return new Coding();
        if ("Count".equals(name))
            return new Count();
        if ("Quantity".equals(name))
            return new Quantity();
        if ("Attachment".equals(name))
            return new Attachment();
        if ("Money".equals(name))
            return new Money();
        if ("Distance".equals(name))
            return new Distance();
        if ("Contact".equals(name))
            return new Contact();
        if ("Constraint".equals(name))
            return new Constraint();
        if ("Interval<Quantity>".equals(name))
            return new Interval<Quantity>();
        if ("HumanId".equals(name))
            return new HumanId();
        if ("Schedule".equals(name))
            return new Schedule();
        if ("Choice".equals(name))
            return new Choice();
        if ("HumanName".equals(name))
            return new HumanName();
        if ("Address".equals(name))
            return new Address();
        if ("Duration".equals(name))
            return new Duration();
        if ("Ratio".equals(name))
            return new Ratio();
        if ("CodeableConcept".equals(name))
            return new CodeableConcept();
        if ("Interval<Date>".equals(name))
            return new Interval<Date>();
        if ("Identifier".equals(name))
            return new Identifier();
        if ("Narrative".equals(name))
            return new Narrative();
        if ("Interval<DateTime>".equals(name))
            return new Interval<DateTime>();
        else
            throw new Exception("Unknown Type Name '"+name+"'");
    }

}

