package org.hl7.fhir.definitions.generators.specification;

import java.io.OutputStream;
import java.net.URISyntaxException;

import org.hl7.fhir.definitions.model.ProfileDefn;
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
    p.getAuthor().getReference().add(Factory.newUri(profile.metadata("author.reference")));
    if (profile.hasMetadata("intention"))
      p.setIntention(Factory.newString_(profile.metadata("intention")));
    if (profile.hasMetadata("description"))
      p.setIntention(Factory.newString_(profile.metadata("description")));
    if (profile.hasMetadata("evidence"))
      p.setIntention(Factory.newString_(profile.metadata("evidence")));
    if (profile.hasMetadata("comments"))
      p.setIntention(Factory.newString_(profile.metadata("comments")));
    if (profile.hasMetadata("date"))
      p.setDate(Factory.newDateTime(profile.metadata("date")));
    p.getEndorser().add(p.new Endorser());
    p.getEndorser().get(0).setName(Factory.newString_(profile.metadata("endorser.name")));
    p.getEndorser().get(0).setReference(Factory.newUri(profile.metadata("endorser.reference")));

//    <code> opt Zero+ Coding assist with indexing and finding</code>
//    <status> mand code draft | testing | production | withdrawn | superceded</status>

//    <endorser> opt  <!-- Zero+ (Organisation or individual) -->
//     <name> mand string Name of the recognised endorser</name>
//     <reference> opt uri Web reference to the endorser</reference>
//    </endorser>
//    <changes> cond string notes about changes since last version</changes>
//    <supercedes> opt Zero+ uri references to previous versions</supercedes>
//    <profile> opt Zero+ uri other profiles that apply (i.e. code binding rules)</profile>
//    <resource> mand Zero+ Constraint Resource Type with constraints</resource>
//    <binding> mand  <!-- Zero+ -->
//     <name> mand string concept domain name</name>
//     <type> mand code binding type</type>
//     <details> cond string extra details - see notes</details>
//     <reference> cond uri source of binding content</reference>
//     <code> cond Zero+ Coding enumerated codes that are the binding</code>
//    </binding>
//    <extensions> opt See Extensions   See Extensions </extensions>
//    <text> mand Narrative Text summary of resource profile for human interpretation</text>
//  </Profile>    
//    
  }
  
}
