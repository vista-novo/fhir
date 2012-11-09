package org.hl7.fhir.definitions.generators.specification;
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
import java.io.OutputStream;
import java.net.URI;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ExtensionDefn;
import org.hl7.fhir.definitions.model.ExtensionDefn.ContextType;
import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.instance.formats.XmlComposer;
//import org.hl7.fhir.instance.model.Factory;
import org.hl7.fhir.instance.model.Factory;
import org.hl7.fhir.instance.model.Narrative;
import org.hl7.fhir.instance.model.Narrative.NarrativeStatus;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.instance.model.Profile.Binding;
import org.hl7.fhir.instance.model.Profile.BindingConformance;
import org.hl7.fhir.instance.model.Profile.BindingType;
import org.hl7.fhir.instance.model.Profile.Concept;
import org.hl7.fhir.instance.model.Profile.Definition;
import org.hl7.fhir.instance.model.Profile.ExtensionContext;
import org.hl7.fhir.instance.model.Profile.Mapping;
import org.hl7.fhir.instance.model.Profile.Status;
import org.hl7.fhir.instance.model.Profile.Type;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class ProfileGenerator {

  public Profile generate(ProfileDefn profile, OutputStream stream, String html) throws Exception {
    Profile p = new Profile();
    p.setName(Factory.newString_(profile.metadata("name")));
    p.setAuthor(p.new Author());
    p.getAuthor().setName(Factory.newString_(profile.metadata("author.name")));
    if (profile.hasMetadata("author.reference"))
      p.getAuthor().getReference().add(Factory.newUri(profile.metadata("author.reference")));
//  <code> opt Zero+ Coding assist with indexing and finding</code>
    if (profile.hasMetadata("intention"))
      throw new Exception("profile intention is not supported any more ("+p.getName()+")");
    if (profile.hasMetadata("description"))
      p.setDescription(Factory.newString_(profile.metadata("description")));
    if (profile.hasMetadata("evidence"))
      throw new Exception("profile evidence is not supported any more ("+p.getName()+")");
    if (profile.hasMetadata("comments"))
      throw new Exception("profile comments is not supported any more ("+p.getName()+")");
    Status s = p.new Status();
    p.setStatus(s);
    if (profile.hasMetadata("date"))
      s.setDate(Factory.newDateTime(profile.metadata("date").substring(0, 10)));

    if (profile.hasMetadata("status")) 
      s.setCode(Profile.ResourceProfileStatus.fromCode(profile.metadata("status")));
    
    for (ResourceDefn resource : profile.getResources()) {
      Profile.Resource c = p.new Resource();
      p.getResource().add(c);
      c.setType(Factory.newCode(resource.getRoot().typeCode()));
      // we don't profile URI when we generate in this mode - we are generating an actual statement, not a re-reference
      if (!"".equals(resource.getRoot().getProfileName()))
        c.setName(Factory.newString_(resource.getRoot().getProfileName()));
      // no purpose element here
      defineElement(p, c, resource.getRoot(), resource.getName());
    }
    for (ExtensionDefn ex : profile.getExtensions())
      p.getExtensionDefn().add(generateExtensionDefn(ex, p));
    for (BindingSpecification b : profile.getBindings()) 
      p.getBinding().add(generateBinding(b, p));
    XhtmlNode div = new XhtmlNode();
    div.setName("div");
    div.setNodeType(NodeType.Element);
    div.getChildNodes().add(new XhtmlParser().parseFragment(html));
    p.setText(new Narrative());
    p.getText().setStatus(NarrativeStatus.generated);
    p.getText().setDiv(div);
    XmlComposer comp = new XmlComposer();
    comp.compose(stream, p, true, false);
    
    return p;
  }

  private Binding generateBinding(BindingSpecification src, Profile p) throws Exception {
    Binding dst = p.new Binding();
    dst.setName(Factory.newString_(src.getName()));
    dst.setDefinition(Factory.newString_(src.getDefinition()));
    dst.setType(convert(src.getBinding()));
    dst.setConformance(convert(src.getBindingStrength()));
    dst.setReference(Factory.newUri(src.getReference()));
    for (DefinedCode dc : src.getCodes()) {
      Concept cd = p.new Concept();
      cd.setCode(Factory.newCode(dc.getCode()));
      cd.setDisplay(Factory.newString_(dc.getDisplay()));
      cd.setDefinition(Factory.newString_(dc.getDefinition()));
      cd.setSystem(dc.hasSystem() ? Factory.newUri(dc.getSystem()) : null);
      dst.getConcept().add(cd);
   }
    
    return dst;
  }

  private BindingConformance convert(org.hl7.fhir.definitions.model.BindingSpecification.BindingStrength bindingStrength) throws Exception {
    if (bindingStrength == org.hl7.fhir.definitions.model.BindingSpecification.BindingStrength.Preferred)
      return BindingConformance.preferred;
    if (bindingStrength == org.hl7.fhir.definitions.model.BindingSpecification.BindingStrength.Required)
      return BindingConformance.required;
    if (bindingStrength == org.hl7.fhir.definitions.model.BindingSpecification.BindingStrength.Suggested)
      return BindingConformance.example;
    throw new Exception("unknown value BindingStrength."+bindingStrength.toString());
  }

  private BindingType convert(org.hl7.fhir.definitions.model.BindingSpecification.Binding binding) throws Exception {
    if (binding == org.hl7.fhir.definitions.model.BindingSpecification.Binding.CodeList)
      return BindingType.codelist;
    if (binding == org.hl7.fhir.definitions.model.BindingSpecification.Binding.Reference)
      return BindingType.reference;
    if (binding == org.hl7.fhir.definitions.model.BindingSpecification.Binding.Special)
      return BindingType.special;
    if (binding == org.hl7.fhir.definitions.model.BindingSpecification.Binding.ValueSet)
      return BindingType.valueset;

    throw new Exception("unknown value Binding."+binding.toString());
  }

  private org.hl7.fhir.instance.model.Profile.ExtensionDefn generateExtensionDefn(ExtensionDefn src, Profile p) throws Exception {
    org.hl7.fhir.instance.model.Profile.ExtensionDefn dst = p.new ExtensionDefn();
    dst.setCode(Factory.newCode(src.getCode()));
    dst.getContext().add(Factory.newString_(src.getContext()));
    dst.setContextType(convertContextType(src.getType()));
    
    ElementDefn dSrc = src.getDefinition();
    Definition dDst = p.new Definition();
    dst.setDefinition(dDst);
    
    dDst.setShort(Factory.newString_(dSrc.getShortDefn()));
    dDst.setFormal(Factory.newString_(dSrc.getDefinition()));
    dDst.setComments(Factory.newString_(dSrc.getComments()));
    if (dSrc.getMaxCardinality() == null)
      dDst.setMax(Factory.newString_("*"));
    else
      dDst.setMax(Factory.newString_(dSrc.getMaxCardinality().toString()));
    dDst.setMin(Factory.newInteger(dSrc.getMinCardinality()));
    dDst.setMustSupport(Factory.newBoolean(dSrc.isMustSupport()));
    dDst.setMustUnderstand(Factory.newBoolean(dSrc.isMustUnderstand()));
    // dDst.
    for (TypeRef t : dSrc.getTypes()) {
      Type type = p.new Type();
      type.setCode(Factory.newCode(t.summary()));
      dDst.getType().add(type);
    }
    if (dSrc.hasRimMapping()) {
      Mapping m = p.new Mapping();
      m.setMap(Factory.newString_("RIM"));
      m.setTarget(Factory.newString_(dSrc.getRimMapping()));
      dDst.getMapping().add(m);
    }
    dDst.setBinding(Factory.newString_(dSrc.getBindingName()));
    return dst;
  }


  private ExtensionContext convertContextType(ContextType type) throws Exception {
    if (type == ContextType.DataType)
      return ExtensionContext.datatype;
    if (type == ContextType.Resource)
      return ExtensionContext.resource;
    if (type == ContextType.Extension)
      return ExtensionContext.extension;
    if (type == ContextType.Mapping)
      return ExtensionContext.mapping;
    
    throw new Exception("unknown value ContextType."+type.toString());
  }

  private void defineElement(Profile p, Profile.Resource c, ElementDefn e, String path) throws Exception {
    Profile.Element_ ce = p.new Element_();
    c.getElement().add(ce);
    ce.setPath(Factory.newString_(path));
    if (!"".equals(e.getProfileName()))
      ce.setName(Factory.newString_(e.getProfileName()));
    ce.setDefinition(p.new Definition());
    if (!"".equals(e.getComments()))
      ce.getDefinition().setComments(Factory.newString_(e.getComments()));
    if (!"".equals(e.getShortDefn()))
      ce.getDefinition().setShort(Factory.newString_(e.getShortDefn()));
    if (!"".equals(e.getDefinition()))
      ce.getDefinition().setFormal(Factory.newString_(e.getDefinition()));
    
    
    // no purpose here
    ce.getDefinition().setMin(Factory.newInteger(e.getMinCardinality()));
    ce.getDefinition().setMax(Factory.newString_(e.getMaxCardinality() == null ? "*" : e.getMaxCardinality().toString()));
    for (TypeRef t : e.getTypes()) {
      Type type = p.new Type();
      type.setCode(Factory.newCode(t.summaryFormal()));
      ce.getDefinition().getType().add(type);
    }
    // ce.setConformance(getType(e.getConformance()));
    if (!"".equals(e.getCondition()))
      ce.getDefinition().getCondition().add(Factory.newId(e.getCondition()));
    // we don't know mustSupport here
    ce.getDefinition().setMustUnderstand(Factory.newBoolean(e.isMustUnderstand()));
    // todo: mappings
    // we don't have anything to say about constraints on resources
    if (!"".equals(e.getBindingName()))
      ce.getDefinition().setBinding(Factory.newString_(e.getBindingName()));
    
    if( e.hasAggregation() )
    {
      ce.setBundled(Factory.newBoolean(true));
      Type t = p.new Type();
      ce.getDefinition().getType().add(t);
      t.setProfile(Factory.newUri(e.getAggregation()));
    }
    
    for (ElementDefn child : e.getElements()) {
      defineElement(p, c, child, path+"."+child.getName());
    }
  }

  
}
