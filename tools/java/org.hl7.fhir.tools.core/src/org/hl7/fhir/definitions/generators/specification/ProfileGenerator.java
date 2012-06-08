package org.hl7.fhir.definitions.generators.specification;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.instance.formats.XmlComposer;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.model.Factory;
import org.hl7.fhir.instance.model.Narrative;
import org.hl7.fhir.instance.model.Narrative.NarrativeStatus;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class ProfileGenerator {

  public Profile generate(ProfileDefn profile, OutputStream stream, String html) throws Exception {
    Profile p = new Profile();
    p.setId(profile.metadata("id"));
    p.setName(profile.metadata("name"));
    p.setAuthor(p.new Author());
    p.getAuthor().setName(profile.metadata("author.name"));
    if (profile.hasMetadata("author.reference"))
      p.getAuthor().setReference(new URI(profile.metadata("author.reference")));
//  <code> opt Zero+ Coding assist with indexing and finding</code>
    if (profile.hasMetadata("intention"))
      p.setIntention(profile.metadata("intention"));
    if (profile.hasMetadata("description"))
      p.setDescription(profile.metadata("description"));
    if (profile.hasMetadata("evidence"))
      p.getEvidence().add(new URI(profile.metadata("evidence")));
    if (profile.hasMetadata("comments"))
      p.setComments(profile.metadata("comments"));
    if (profile.hasMetadata("date"))
      p.setDate(profile.metadata("date").substring(0, 10));
    p.getEndorser().add(p.new Endorser());
    p.getEndorser().get(0).setName(profile.metadata("endorser.name"));
    if (profile.hasMetadata("endorser.reference"))
      p.getEndorser().get(0).setReference(new URI(profile.metadata("endorser.reference")));
    if (profile.hasMetadata("changes"))
      p.setIntention(profile.metadata("changes"));
    if (profile.hasMetadata("supercedes"))
      p.getSupercedes().add(new URI(profile.metadata("supercedes")));

    if (profile.hasMetadata("status")) 
      p.setStatus(Profile.ResourceProfileStatus.fromCode(profile.metadata("status")));
    
    for (ElementDefn e : profile.getResources()) {
      Profile.Resource c = p.new Resource();
      p.getResource().add(c);
      c.setType(e.typeCode());
      // we don't profile URI when we generate in this mode - we are generating an actual statement, not a re-reference
      if (!"".equals(e.getProfileName()))
        c.setName(e.getProfileName());
      // no purpose element here
      defineElement(p, c, e, e.getName());
    }
    
    XhtmlNode div = new XhtmlNode();
    div.setName("div");
    div.setNodeType(NodeType.Element);
    div.getChildNodes().add(new XhtmlParser().parseFragment(html));
    p.setText(new Narrative());
    p.getText().setStatus(NarrativeStatus.generated);
    p.getText().setDiv(div);
    XmlComposer comp = new XmlComposer();
    comp.compose(stream, p, true);
    
    return p;
  }

  private void defineElement(Profile p, Profile.Resource c, ElementDefn e, String path) throws Exception {
    Profile.Element_ ce = p.new Element_();
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
    for (TypeRef t : e.getTypes())
      ce.getType().add(t.summaryFormal()); 
    // ce.setConformance(getType(e.getConformance()));
    if (!"".equals(e.getCondition()))
      ce.setCondition(e.getCondition());
    // we don't know mustSupport here
    if (e.isMustUnderstand()) 
      ce.setMustUnderstand(e.isMustUnderstand());
    // todo: mappings
    // we don't have anything to say about constraints on resources
    if (!"".equals(e.getBindingName()))
      ce.setBinding(e.getBindingName());
    
    if( e.hasAggregation() )
    {
    	Profile.ResourceA res = p.new ResourceA();
    	res.setAggregated(true);
   		res.setProfile(new URI(e.getAggregation()) );
    	ce.setResource(res);
    }
    
    for (ElementDefn child : e.getElements()) {
      defineElement(p, c, child, path+"."+child.getName());
    }
  }

  
}
