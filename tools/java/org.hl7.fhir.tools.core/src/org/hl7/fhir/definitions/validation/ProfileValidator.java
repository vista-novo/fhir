package org.hl7.fhir.definitions.validation;
/*
Copyright (c) 2011-2012, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.parsers.TypeParser;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.instance.model.Profile.Element_;

public class ProfileValidator {

  private Map<Profile.Element_, ArrayList<ElementDefn>> map = new HashMap<Profile.Element_, ArrayList<ElementDefn>>();
  
  private ResourceDefn profile;
  private Profile resource;
  private ArrayList<String> errors;

  public void setProfile(ResourceDefn profile) {
    this.profile = profile; 
  }

  public void setResource(Profile resource) {
    this.resource = resource;
  }

  public List<String> evaluate() {
    map.clear();
    errors = new ArrayList<String>();
     if (profile == null)
       errors.add("no profile provided");
     else if (resource == null) 
       errors.add("no resouce provided");
     else {
       // what we need to do is map the profile definitions against the resource
       // first, we check the stated names against the resource names, and map to the backbone
       matchElement(profile, profile.getRoot(), profile.getName());
       
       // now, we run through the resource, adding anything that the profile omitted back to the profile
       // (because profiles are open)
       fillOutElement(profile.getRoot(), profile.getName());
       
       // then we walk the profile checking that the constraints are valid
       inspectConstraints(profile, profile.getName());

       // finally, we walk the resource ensuring that anything that is mandatory is not constrained out in the profile
     }
    return errors;
  }

  private void fillOutElement(ElementDefn profileElement, String path) {
    int i = 0;
    for (Element_ e : collectChildren(path)) {
      ElementDefn m = null;
      if (i < profileElement.getElements().size()) {
        m = profileElement.getElements().get(i);
        if (!m.getName().equals(terminalName(e))) {
          m = null;
        }
      }
      if (m == null) {
        ElementDefn n = new ElementDefn();
        filloutElementDefn(n, e);
        profileElement.getElements().add(i, n);
      }
      else
        fillOutElement(m, path+"."+m.getName());
      i++;
      while (m != null && i < profileElement.getElements().size()) {
        m = profileElement.getElements().get(i);
        if (!m.getName().equals(terminalName(e))) 
          m = null;
        else
          i++;
      } 
    }
  }

  private String terminalName(Element_ e) {
    String res = e.getPath().substring(e.getPath().lastIndexOf(".")+1);
    return res;
  }

  private List<Element_> collectChildren(String path) {
    List<Element_> results = new ArrayList<Element_>();
    for (Element_ r : resource.getResource().get(0).getElement())
      if (r.getPath().startsWith(path+".") && !r.getPath().substring(path.length()+1).contains(".")) 
        results.add(r);
    return results;
  }
  
  private void filloutElementDefn(ElementDefn n, Element_ e) {
    n.setName(terminalName(e));
    n.setInherited(true);
    n.setComments(e.getDefinition().getComments());
    n.setBindingName(e.getBinding());
    n.setShortDefn(e.getDefinition().getShort());
    n.setDefinition(e.getDefinition().getFormal());
    n.setMaxCardinality("*".equals(e.getDefinition().getMax()) ? null : Integer.parseInt(e.getDefinition().getMax()));
    n.setMinCardinality(e.getDefinition().getMin());
    n.setMustUnderstand(e.getDefinition().getMustSupport());
    for (String t : e.getDefinition().getType()) {
      TypeParser tp = new TypeParser();
      try {
        n.getTypes().addAll(tp.parse(t));
      } catch (Exception ex) {
        errors.add("invalid type "+t+" on "+e.getPath()+" in underlying resource definition");
      }
    }
//    n.getTypes().addAll(e.gett)
//  todo
//    n.setRimMapping(e.get);
//    n.setV2Mapping(e.get);
    for (Element_ c : collectChildren(e.getPath())) {
      ElementDefn nc = new ElementDefn();
      filloutElementDefn(nc, c);
      n.getElements().add(nc);
    }
////    todo: children
  }

  
  private void inspectConstraints(ResourceDefn profile2, String name) {
    
    
  }

  private void matchElement(ResourceDefn resource, ElementDefn element, String path) {
    Element_ e = getConstraintByPath(path);
    if (e == null)
      errors.add("Profile element '"+path+"' not found");
    else {
      element.setDerivation(e);
      completeFromDerivation(element, e);
      ArrayList<ElementDefn> a;
      if (map.containsKey(e))
        a = map.get(e);
      else {
        a = new ArrayList<ElementDefn>();
        map.put(e, a);
      }
      a.add(element);
    }
    for (ElementDefn c : element.getElements()) {
      matchElement(resource, c, path+"."+c.getName());
    }
  }

  private void completeFromDerivation(ElementDefn target, Element_ source) {
    if (!target.hasComments())
      target.setComments(source.getDefinition().getComments());
    if (!target.hasBindingName())
      target.setBindingName(source.getBinding());
    if (!target.hasShortDefn())
      target.setShortDefn(source.getDefinition().getShort());
    if (!target.hasDefinition())
      target.setDefinition(source.getDefinition().getFormal());    
  }

  private Element_ getConstraintByPath(String path) {
    for (Element_ e : resource.getResource().get(0).getElement())
      if (e.getPath().equals(path))
        return e;
    return null;
  }

}
