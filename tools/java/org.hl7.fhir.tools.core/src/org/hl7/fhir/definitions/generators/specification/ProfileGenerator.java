package org.hl7.fhir.definitions.generators.specification;

import java.io.OutputStream;

import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.instance.model.Id;
import org.hl7.fhir.instance.model.Profile;

public class ProfileGenerator {

  public void generate(ProfileDefn profile, OutputStream stream) {
    Profile p = new Profile();
    p.setId(new Id());
    p.getId().setValue(profile.metadata("id"));
//    p.
    
    
//    
//    <name> mand string Informal name for this profile</name>
//    <author> mand  <!-- (Organisation or individual) -->
//     <name> mand string Name of the recognised author</name>
//     <reference> opt Zero+ uri Web reference to the author</reference>
//    </author>
//    <intention> opt string Why this profile was written</intention>
//    <code> opt Zero+ Coding assist with indexing and finding</code>
//    <description> mand string natural language description of the Template</description>
//    <evidence> opt Zero+ uri Supporting evidence for the design</evidence>
//    <comments> opt string Guidance for use, usage notes, etc</comments>
//    <status> mand code draft | testing | production | withdrawn | superceded</status>
//    <date> mand dateTime date for given status</date>
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
