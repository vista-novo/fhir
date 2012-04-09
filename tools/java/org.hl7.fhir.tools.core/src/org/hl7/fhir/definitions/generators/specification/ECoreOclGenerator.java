package org.hl7.fhir.definitions.generators.specification;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;

public class ECoreOclGenerator  extends OutputStreamWriter {

      
  private Map<String, ElementDefn> waitingElements = new HashMap<String, ElementDefn>();

  public ECoreOclGenerator(OutputStream out) throws UnsupportedEncodingException {
    super(out, "UTF-8");
  }
  
  public void generate(Definitions definitions, String version, String genDate) throws Exception {
    writeLine("module _'FHIR.ecore'");
    writeLine("import ecore : 'http://www.eclipse.org/emf/2002/Ecore#/';");
    writeLine("");
    writeLine("package DataTypes : dt = 'http://www.hl7.org/fhir/datatypes'");
    writeLine("{");
    for (String name : definitions.getDefinedResources().keySet()) {
      if (isDataType(name, definitions))
        generateResource(name, definitions.getDefinedResources().get(name));
    }
    writeLine("}");
    writeLine("package Resources : res = 'http://www.hl7.org/fhir/resources'");
    writeLine("{");
    for (String name : definitions.getDefinedResources().keySet()) {
      if (!isDataType(name, definitions))
        generateResource(name, definitions.getDefinedResources().get(name));
    }
    writeLine("}");
    flush();
    close();
  }

  private boolean isDataType(String name, Definitions definitions) {
//    for (TypeDefn t : definitions.getDatatypes())
//      if (t.getName().equals(name))
//        return true;
    return false;
  }

  private void writeLine(String string) throws IOException {
    write(string+"\r\n");    
  }

  private void generateResource(String name, ElementDefn elementDefn) throws Exception {
    generateType(name, elementDefn);
    processWaitingElements();
  }

  private void generateType(String name, ElementDefn elementDefn) throws Exception {
    if (elementDefn.getTypes().size() == 1 && elementDefn.getTypes().get(0).getName().equals("GenericType")) 
      writeLine(addDefn("  class "+name+"<T> extends Type", elementDefn));
    else if (elementDefn.getTypes().size() == 1)
      writeLine(addDefn("  class "+name+" extends "+elementDefn.getTypes().get(0).getName(), elementDefn));
    else
      writeLine(addDefn("  class "+name, elementDefn));
    writeLine("  {");
    for (ElementDefn e : elementDefn.getElements()) {
      generateElement(name, e);
    }
    writeLine("  }");
    writeLine("");
  }

  private void processWaitingElements() throws Exception {
    while (!waitingElements.isEmpty()) {
      String n = waitingElements.keySet().iterator().next();
      ElementDefn e = waitingElements.get(n);
      waitingElements.remove(n);
      generateType(n, e);
    }    
  }

  private void generateElement(String name, ElementDefn e) throws Exception {
    if (e.getElements().size() == 0) {
      if (e.getName().equals("extensions"))
        writeLine(addDefn("    attribute "+e.getName()+" : Extensions;", e));
      else {
        if (e.getTypes().size() == 0)
          throw new Exception("element "+name+"::"+e.getName()+" has no children and no type");
        String n = e.getName();
        if (n.equals("[type]"))
          n = "type";
        if (n.endsWith("[x]"))
          n = n.substring(0, n.length()-3);
        
        if  (e.getTypes().size() > 1)
          writeLine(addDefn("    attribute "+n+" : ?;", e));
        else
        writeLine(addDefn("    attribute "+n+" : "+ecoreType(e.getTypes().get(0))+";", e));
      }
    } else {
      if (e.getElements().size() == 1 && e.getElements().get(0).getName().equals("#")) {
        writeLine(addDefn("    attribute "+e.getName()+" : "+ecoreType(e.getElements().get(0).getTypes().get(0))+";", e));
      }
      else {
        String n = name+"_"+e.getName();
        writeLine(addDefn("    attribute "+e.getName()+" : "+n+";", e));
        waitingElements.put(n, e);
      }
    }
  }

  private String addDefn(String line, ElementDefn e) {
    if (e.getDefinition() == null || e.getDefinition().equals(""))
      return line;
    
    String res = line;
    while (res.length() < 44)
      res = res + " ";
    return res + " -- "+e.getDefinition();
  }

  private String ecoreType(TypeDefn typeDefn) {
    if (typeDefn.getName().equals("string"))
      return "String";
    else if (typeDefn.getName().equals("[param]"))
      return "T";
    else if (typeDefn.getName().equals("*"))
      return "object";
    else if (typeDefn.getName().equals("xml:ID"))
      return "String";  
    else if (typeDefn.getName().charAt(0) == '@')
      return typeDefn.getName().substring(1).replace('.', '_');  
    
    else
      return typeDefn.getName();
  }
  
}
