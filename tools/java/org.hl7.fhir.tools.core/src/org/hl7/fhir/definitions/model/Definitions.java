package org.hl7.fhir.definitions.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is the root to all the definitions in FHIR. There are the
 * following kinds of items: 
 *   DefinedResources - a named list of resources that are defined, with element definitions for the resources
 *   Known Resources - a list of Resource names with their definitions for all known definitions, whether defined or not  
 *   Concept Domains - a list of concept domains
 *   Events - a list of message events
 *   Documents - a list of defined document profiles
 *   
 * @author Grahame
 * 
 */
public class Definitions {

  private Map<String, ConceptDomain> conceptDomains = new HashMap<String, ConceptDomain>();
  private Map<String, DefinedCode> knownResources = new HashMap<String, DefinedCode>();
  private Map<String, DefinedCode> futureResources = new HashMap<String, DefinedCode>();
  private List<TypeDefn> knownTypes = new ArrayList<TypeDefn>();
  private Map<String, DefinedCode> constraints = new HashMap<String, DefinedCode>();
  
  private Map<String, DefinedCode> primitives = new HashMap<String, DefinedCode>();
  private Map<String, ElementDefn> types = new HashMap<String, ElementDefn>();
  private Map<String, ElementDefn> structures = new HashMap<String, ElementDefn>();
  private Map<String, ElementDefn> infrastructure = new HashMap<String, ElementDefn>();
  private Map<String, ElementDefn> resources = new HashMap<String, ElementDefn>();
  private Map<String, ElementDefn> specialResources = new HashMap<String, ElementDefn>();
  private Map<String, ElementDefn> definedResources = new HashMap<String, ElementDefn>();

  private Map<String, EventDefn> events = new HashMap<String, EventDefn>();

  public boolean hasResource(String name) {
    return resources.containsKey(name) || specialResources.containsKey(name); // || knownResources.containsKey(name);
  }

  
  public ConceptDomain getConceptDomainByName(String conceptDomain) {
    return conceptDomains.get(conceptDomain);
  }

  public ElementDefn getResourceDefn(String name) throws Exception {
    ElementDefn root = null;
    if (resources.containsKey(name))
      root = resources.get(name);
    if (specialResources.containsKey(name))
      root = specialResources.get(name);
    if (root == null)
      throw new Exception("unable to find resource "+name);
    return root;
  }

  public ElementDefn getElementDefn(String name) throws Exception {
    ElementDefn root = null;
    if (types.containsKey(name))
      root = types.get(name);
    if (structures.containsKey(name))
      root = structures.get(name);
    if (infrastructure.containsKey(name))
      root = infrastructure.get(name);
    if (resources.containsKey(name))
      root = resources.get(name);
    if (specialResources.containsKey(name))
      root = specialResources.get(name);
    if (root == null)
      throw new Exception("unable to find resource "+name);
    return root;
  }


  public Map<String, ConceptDomain> getConceptDomains() {
    return conceptDomains;
  }


  public Map<String, DefinedCode> getPrimitives() {
    return primitives;
  }


  public Map<String, ElementDefn> getTypes() {
    return types;
  }


  public Map<String, ElementDefn> getStructures() {
    return structures;
  }


  public Map<String, ElementDefn> getInfrastructure() {
    return infrastructure;
  }


  public Map<String, ElementDefn> getResources() {
    return resources;
  }


  public Map<String, ElementDefn> getSpecialResources() {
    return specialResources;
  }


  public Map<String, DefinedCode> getKnownResources() {
    return knownResources;
  }


  public Map<String, ElementDefn> getDefinedResources() {
    return definedResources;
  }


  public boolean hasType(String name) {
    for (TypeDefn td : knownTypes) {
      if (td.getName().equals(name))
        return true;
    }
//    return knownTypes 
//        primitives.containsKey(name) || types.containsKey(name) || structures.containsKey(name) || infrastructure.containsKey(name);
    return false;
  }


  public List<TypeDefn> getKnownTypes() {
    return knownTypes;
  }


  public Map<String, DefinedCode> getFutureResources() {
    return futureResources;
  }


  public Map<String, DefinedCode> getConstraints() {
    return constraints;
  }


  public Map<String, EventDefn> getEvents() {
    return events;
  }

  

}
