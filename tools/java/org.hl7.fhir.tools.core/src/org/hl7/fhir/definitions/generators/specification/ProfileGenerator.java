package org.hl7.fhir.definitions.generators.specification;

import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ElementDefn.Conformance;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.instance.formats.XmlComposer;
import org.hl7.fhir.instance.model.Constraint;
import org.hl7.fhir.instance.model.Constraint.ConformanceType;
import org.hl7.fhir.instance.model.Constraint.Element_;
import org.hl7.fhir.instance.model.Factory;
import org.hl7.fhir.instance.model.Id;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.instance.model.Profile.Author;
import org.hl7.fhir.instance.model.String_;

public class ProfileGenerator {

  public void generate(ProfileDefn profile, OutputStream stream) throws Exception {
    Profile p = new Profile();
    p.setId(Factory.newId(profile.metadata("id")));
    p.setName(Factory.newString_(profile.metadata("name")));
    p.setAuthor(p.new Author());
    p.getAuthor().setName(Factory.newString_(profile.metadata("author.name")));
    if (profile.hasMetadata("author.reference"))
      p.getAuthor().getReference().add(Factory.newUri(profile.metadata("author.reference")));
//  <code> opt Zero+ Coding assist with indexing and finding</code>
    if (profile.hasMetadata("intention"))
      p.setIntention(Factory.newString_(profile.metadata("intention")));
    if (profile.hasMetadata("description"))
      p.setDescription(Factory.newString_(profile.metadata("description")));
    if (profile.hasMetadata("evidence"))
      p.getEvidence().add(Factory.newUri(profile.metadata("evidence")));
    if (profile.hasMetadata("comments"))
      p.setComments(Factory.newString_(profile.metadata("comments")));
    if (profile.hasMetadata("date"))
      p.setDate(Factory.newDateTime(profile.metadata("date")));
    p.getEndorser().add(p.new Endorser());
    p.getEndorser().get(0).setName(Factory.newString_(profile.metadata("endorser.name")));
    if (profile.hasMetadata("endorser.reference"))
      p.getEndorser().get(0).setReference(Factory.newUri(profile.metadata("endorser.reference")));
    if (profile.hasMetadata("changes"))
      p.setIntention(Factory.newString_(profile.metadata("changes")));
    if (profile.hasMetadata("supercedes"))
      p.getSupercedes().add(Factory.newUri(profile.metadata("supercedes")));

    if (profile.hasMetadata("status")) 
      p.setStatus(Profile.ResourceProfileStatus.fromCode(profile.metadata("status")));
    
    for (ElementDefn e : profile.getResources()) {
      Constraint c = new Constraint();
      p.getResource().add(c);
      c.setType(e.typeCode());
      // we don't profile URI when we generate in this mode - we are generating an actual statement, not a re-reference
      if (!"".equals(e.getProfileName()))
        c.setName(e.getProfileName());
      // no purpose element here
      defineElement(c, e, e.getName());
    }
      
      
    XmlComposer comp = new XmlComposer();
    comp.compose(stream, p, true);
  }

  private void defineElement(Constraint c, ElementDefn e, String path) {
    Constraint.Element_ ce = c.new Element_();
    c.getElement().add(ce);
    ce.setPath(path);
    if (!"".equals(e.getProfileName()))
      ce.setName(e.getProfileName());
    if (!"".equals(e.getComments()))
      ce.setComments(e.getComments());
    if (!"".equals(e.getShortDefn()))
      ce.setShortDefn(e.getShortDefn());
    if (!"".equals(e.getDefinition()))
      ce.setDefinition(e.getDefinition());
    
    // no purpose here
    ce.setMin(e.getMinCardinality());
    ce.setMax(e.getMaxCardinality() == null ? "*" : e.getMaxCardinality().toString());
    for (TypeDefn t : e.getTypes())
      ce.getType().add(t.summaryFormal()); 
    ce.setConformance(getType(e.getConformance()));
    if (!"".equals(e.getCondition()))
      ce.setCondition(e.getCondition());
    // we don't know mustSupport here
    if (e.isMustUnderstand()) 
      ce.setMustUnderstand(e.isMustUnderstand());
    // todo: mappings
    // we don't have anything to say about constraints on resources
    if (!"".equals(e.getBindingName()))
      ce.setBinding(e.getBindingName());
    
    for (ElementDefn child : e.getElements()) {
      defineElement(c, child, path+"."+child.getName());
    }
  }

  private ConformanceType getType(Conformance conformance) {
    if (conformance == Conformance.Unstated)
      return ConformanceType.Optional;
    if (conformance == Conformance.Mandatory) 
      return ConformanceType.Mandatory;
    if (conformance == Conformance.Conditional) 
      return ConformanceType.Conditional;
    if (conformance == Conformance.Optional)
      return ConformanceType.Optional;
    if (conformance == Conformance.Prohibited)
      return ConformanceType.Prohibited;
    else
      return null;
  }
  
}
