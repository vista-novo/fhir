package org.hl7.fhir.definitions.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.parsers.TypeParser;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.instance.model.Profile.Element_;

public class ProfileValidator {

  private Map<Profile.Element_, ArrayList<ElementDefn>> map = new HashMap<Profile.Element_, ArrayList<ElementDefn>>();
  
  private ElementDefn profile;
  private Profile resource;
  private ArrayList<String> errors;

  public void setProfile(ElementDefn profile) {
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
       matchElement(profile, profile.getName());
       
       // now, we run through the resource, adding anything that the profile omitted back to the profile
       // (because profiles are open)
       fillOutElement(profile, profile.getName());
       
       // then we walk the profile checking that the constraints are valid
       inspectConstraints(profile, profile.getName());

       // finally, we walk the resource ensuring that anything that is mandatory is not constrained out in the profile
     }
    return errors;
  }

  private void fillOutElement(ElementDefn profileElement, String path) {
//    int i = 0;
//    for (Element_ e : collectChildren(path)) {
//      ElementDefn m = null;
//      if (i < profileElement.getElements().size()) {
//        m = profileElement.getElements().get(i);
//        if (!m.getName().equals(terminalName(e))) {
//          m = null;
//        }
//      }
//      if (m == null) {
//        ElementDefn n = new ElementDefn();
//        filloutElementDefn(n, e);
//        profileElement.getElements().add(i, n);
//      }
//      else
//        fillOutElement(m, path+"."+m.getName());
//      i++;
//      while (m != null && i < profileElement.getElements().size()) {
//        m = profileElement.getElements().get(i);
//        if (!m.getName().equals(terminalName(e))) 
//          m = null;
//        else
//          i++;
//      } 
//    }
  }

  private String terminalName(Element_ e) {
//    String res = e.getPath().substring(e.getPath().lastIndexOf(".")+1);
//    return res;
    return null;
  }

  private List<Element_> collectChildren(String path) {
//    List<Element_> results = new ArrayList<Constraint.Element_>();
//    for (Element_ r : resource.getResource().get(0).getElement())
//      if (r.getPath().startsWith(path+".") && !r.getPath().substring(path.length()+1).contains(".")) 
//        results.add(r);
//    return results;
    return null;
  }
  
  private void filloutElementDefn(ElementDefn n, Element_ e) {
//    n.setName(terminalName(e));
//    n.setInherited(true);
//    n.setComments(e.getComments());
//    n.setBindingName(e.getBinding());
//    n.setCondition(e.getCondition());
//    n.setDefinition(e.getDefinition());
//    n.setMaxCardinality("*".equals(e.getMax()) ? null : Integer.parseInt(e.getMax()));
//    n.setMinCardinality(e.getMin());
//    n.setMustUnderstand(e.getMustSupport());
//    for (String t : e.getType()) {
//      TypeParser tp = new TypeParser();
//      try {
//        n.getTypes().addAll(tp.parse(t));
//      } catch (Exception ex) {
//        errors.add("invalid type "+t+" on "+e.getPath()+" in underlying resource definition");
//      }
//    }
////    n.getTypes().addAll(e.gett)
////  todo
////    n.setRimMapping(e.get);
////    n.setV2Mapping(e.get);
//    n.setShortDefn(e.getShortDefn());
//    for (Element_ c : collectChildren(e.getPath())) {
//      ElementDefn nc = new ElementDefn();
//      filloutElementDefn(nc, c);
//      n.getElements().add(nc);
//    }
////    todo: children
  }

  
  private void inspectConstraints(ElementDefn profile2, String name) {
    
    
  }

  private void matchElement(ElementDefn element, String path) {
//    Element_ e = getConstraintByPath(path);
//    if (e == null)
//      errors.add("Profile element '"+path+"' not found");
//    else {
//      element.setDerivation(e);
//      ArrayList<ElementDefn> a;
//      if (map.containsKey(e))
//        a = map.get(e);
//      else {
//        a = new ArrayList<ElementDefn>();
//        map.put(e, a);
//      }
//      a.add(element);
//    }
//    for (ElementDefn c : element.getElements()) {
//      matchElement(c, path+"."+c.getName());
//    }
  }

  private Element_ getConstraintByPath(String path) {
//    for (Element_ e : resource.getResource().get(0).getElement())
//      if (e.getPath().equals(path))
//        return e;
    return null;
  }

}
