package org.hl7.fhir.tools.publisher.implementations;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.ConceptDomain;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.utilities.Utilities;

public class JavaComposerXmlGenerator extends OutputStreamWriter {
  public enum JavaGenClass { Structure, Type, Resource, Constraint }

  private Definitions definitions;
  private Map<ElementDefn, String> typeNames = new HashMap<ElementDefn, String>();
  private List<String> typeNameStrings = new ArrayList<String>();
  private List<ElementDefn> enums = new ArrayList<ElementDefn>();
  private List<String> enumNames = new ArrayList<String>();
  private List<ElementDefn> strucs  = new ArrayList<ElementDefn>();
  private List<String> lists = new ArrayList<String>();

  private String context;

  private StringBuilder reg = new StringBuilder();
  private StringBuilder regt = new StringBuilder();
  private StringBuilder regn = new StringBuilder();
  private String genparam;
  
  public JavaComposerXmlGenerator(OutputStream out) throws UnsupportedEncodingException {
    super(out, "UTF-8");
  }

  public void generate(Definitions definitions, String version, Date genDate) throws Exception {

    this.definitions = definitions;
    
    start(version, genDate);
    
    for (ElementDefn n : definitions.getInfrastructure().values()) {
      generate(n, false, false, true);
    }
    
    for (ElementDefn n : definitions.getTypes().values()) {
      if (n.getTypes().size() > 0 && n.getTypes().get(0).getName().equals("GenericType")) {

        for (TypeDefn td : definitions.getKnownTypes()) {
          if (td.getName().equals(n.getName()) && td.hasParams()) {
            for (String pt : td.getParams()) {
              genGeneric(n, n.getName()+"<"+upFirst(pt)+">", pt, false);
              regt.append("    else if (type instanceof "+n.getName()+" && (("+n.getName()+"<Ordered>) type).getType().equals(\""+upFirst(pt)+"\"))\r\n");
              regt.append("      compose"+n.getName()+"_"+upFirst(pt)+"(prefix+\""+n.getName()+"_"+upFirst(pt)+"\", ("+n.getName()+"<"+upFirst(pt)+">) type);\r\n");
//              regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"_"+upFirst(pt)+"\"))\r\n      return true;\r\n");
            }
          }
        }
      } else {
        generate(n, true, false, false);
        regt.append("    else if (type instanceof "+n.getName()+")\r\n       compose"+n.getName()+"(prefix+\""+n.getName()+"\", ("+n.getName()+") type);\r\n");
//        regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return true;\r\n");
      }
    }

    for (DefinedCode n : definitions.getConstraints().values()) {
      generateConstraint(n, true, false, false);
      regt.append("    else if (type instanceof "+n.getCode()+")\r\n       compose"+n.getCode()+"(prefix+\""+n.getCode()+"\", ("+n.getCode()+") type);\r\n");
//      regn.append("    if (xpp.getName().equals(prefix+\""+n.getCode()+"\"))\r\n      return true;\r\n");
    }
    for (ElementDefn n : definitions.getStructures().values()) {
      generate(n, true, false, false);
      regt.append("    else if (type instanceof "+n.getName()+")\r\n       compose"+n.getName()+"(prefix+\""+n.getName()+"\", ("+n.getName()+") type);\r\n");
//      regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return true;\r\n");
    }
    
    for (ElementDefn n : definitions.getResources().values()) {
      generate(n, false, true, true);
      reg.append("    else if (resource instanceof "+n.getName()+")\r\n      compose"+n.getName()+"(\""+n.getName()+"\", ("+n.getName()+")resource);\r\n");
//      regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return true;\r\n");
    }
    
    for (DefinedCode cd : definitions.getPrimitives().values()) {
      String n = upFirst(cd.getCode());
      String t = n;
      if (n.equals("String")) 
        t = "String_";
      
//      if (n.equals("Uri"))
//        t = "Uri";
      regt.append("    else if (type instanceof "+t+")\r\n       compose"+t+"(prefix+\""+n+"\", ("+t+") type);\r\n");
//      regn.append("    if (xpp.getName().equals(prefix+\""+n+"\"))\r\n      return true;\r\n");
    }
    
    finish();
  }

  private String upFirst(String n) {
    return n.substring(0,1).toUpperCase() + n.substring(1);
  }

  private void start(String version, Date genDate) throws Exception {

    write("package org.hl7.fhir.instance.formats;\r\n");
    write("\r\n");
    write("// Copyright HL7 (http://www.hl7.org). Generated on "+new SimpleDateFormat(Config.STANDARD_DATE_FORMAT).format(genDate)+" for FHIR v"+version+"\r\n");
    write("\r\n");
    write("import org.hl7.fhir.instance.model.*;\r\n");
    write("import org.hl7.fhir.instance.model.Integer;\r\n");
    write("import org.hl7.fhir.instance.model.Boolean;\r\n");
  //  write("import java.util.*;\r\n");
    write("\r\n");
    write("public class XmlComposer extends XmlComposerBase {\r\n");
    write("\r\n");
  }

  private void genGeneric(ElementDefn n, String tn, String pt, boolean listsAreWrapped) throws Exception {
    typeNames.clear();
    typeNameStrings.clear();
    enums.clear();
    strucs.clear();
    enumNames.clear();
    genparam = pt;
    for (ElementDefn e : n.getElements()) {
      scanNestedTypes(n, n.getName(), e);
    }
    typeNames.put(n, tn);
//    write("  protected "+tn+" parse"+tn.replace("<", "_").replace(">", "")+"(XmlPullParser xpp) throws Exception {\r\n");
    context = n.getName();

    genInner(n, true, false, listsAreWrapped);
    
    for (ElementDefn e : strucs) {
      genInner(e, true, false, listsAreWrapped);
    }

  }

  private void generate(ElementDefn n, boolean hasDataAbsentReason, boolean contentsHaveDataAbsentReason, boolean listsAreWrapped) throws Exception {
    typeNames.clear();
    typeNameStrings.clear();
    enums.clear();
    strucs.clear();
    enumNames.clear();
    for (ElementDefn e : n.getElements()) {
      // if (!n.typeCode().equals("Resource") || (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text")))
        scanNestedTypes(n, n.getName(), e);
    }
    context = n.getName();

    genInner(n, hasDataAbsentReason, contentsHaveDataAbsentReason, listsAreWrapped);
    
    for (ElementDefn e : strucs) {
      genInner(e, hasDataAbsentReason, contentsHaveDataAbsentReason, listsAreWrapped);
    }

  }

  private void generateConstraint(DefinedCode cd, boolean hasDataAbsentReason, boolean contentsHaveDataAbsentReason, boolean listsAreWrapped) throws Exception {
    typeNames.clear();
    typeNameStrings.clear();
    enums.clear();
    strucs.clear();
    enumNames.clear();
    context = cd.getCode();
    ElementDefn n = definitions.getTypes().get(cd.getComment());
    
    typeNames.put(n, cd.getCode());
    for (ElementDefn e : n.getElements()) {
//      if (!n.typeCode().equals("Resource") || (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text")))
        scanNestedTypes(n, n.getName(), e);
    }

    genInner(n, hasDataAbsentReason, contentsHaveDataAbsentReason, listsAreWrapped);
    
    for (ElementDefn e : strucs) {
      genInner(e, hasDataAbsentReason, contentsHaveDataAbsentReason, listsAreWrapped);
    }

  }

  private void genInner(ElementDefn n, boolean hasDataAbsentReason, boolean contentsHaveDataAbsentReason, boolean listsAreWrapped) throws IOException, Exception {
    String tn = typeNames.containsKey(n) ? typeNames.get(n) : n.getName();
    
    write("  private void compose"+upFirst(tn).replace(".", "").replace("<", "_").replace(">", "")+"(String name, "+tn+" element) throws Exception {\r\n");
    write("    if (element != null) {\r\n");
    if (hasDataAbsentReason && !tn.contains("."))
      write("      composeTypeAttributes(element);\r\n");
    else
      write("      composeElementAttributes(element);\r\n");
    write("      xml.open(FHIR_NS, name);\r\n");
    for (ElementDefn e : n.getElements()) 
      genElement(n, e, contentsHaveDataAbsentReason, listsAreWrapped);
    write("      xml.close(FHIR_NS, name);\r\n");
    write("    }\r\n");    
    write("  }\r\n\r\n");    
  }

  private String pathClass(String tn) {
    return tn.substring(0, tn.indexOf('.'));
  }

  private String pathNode(String tn) {
    return tn.substring(tn.indexOf('.')+1);
  }

  private void genElement(ElementDefn root, ElementDefn e, boolean contentsHaveDataAbsentReason, boolean listsAreWrapped) throws Exception {
    String name = e.getName();
    if (name.endsWith("[x]") || name.equals("[type]")) {
      String en = name.endsWith("[x]") ? name.replace("[x]", "") : "value";
      String pfx = name.endsWith("[x]") ? name.replace("[x]", "") : "";
      write("      composeType(\""+pfx+"\", element.get"+upFirst(en)+"());\r\n");
    } else {
      String comp = null;
      String en = null;
      ConceptDomain cd = definitions.getConceptDomainByName(e.getConceptDomain());
      String tn = typeName(root, e, !contentsHaveDataAbsentReason, false);
      if (e.typeCode().equals("code") && cd != null && cd.getBindingType() == ConceptDomain.BindingType.CodeList) {
        en = typeNames.get(e); // getCodeListType(cd.getBinding());
        comp = null;
      } else {   
        if (name.equals("extensions")) {
          name = "extension";
          tn = "Extension";
        }
        if (tn.equals("char[]"))
          tn = "xhtml";
        else if (tn.equals("code")) {
          tn = "Code";
          comp = "composeCode";
        } else if (tn.equals("uri"))
          tn = "Uri";
        if (tn.contains("Resource(")) {
          comp = "composeResourceReference";
          tn = "ResourceReference";
        } else if (tn.contains("("))
          comp = "compose"+PrepGenericName(tn);
        else if (tn.startsWith(context) && !tn.equals(context)) {
          comp = "compose"+upFirst(tn).replace(".", "");
        } else
          comp = "compose"+upFirst(tn).replace(".", "");
      }
      
      if (name.equals("extension")) {
        String s = contentsHaveDataAbsentReason ? "Extensions" : "Extension"; 
        write("      if (element.get"+s+"().size() > 0) {\r\n");
        write("        xml.open(FHIR_NS, \"extensions\");\r\n");
        write("        for (Extension e : element.get"+s+"()) \r\n");
        write("          composeExtension(\"extension\", e);\r\n");
        write("        xml.close(FHIR_NS, \"extensions\");\r\n");
        write("      }\r\n");
      } else if (e.unbounded()) {
        if (listsAreWrapped && !Config.SUPPRESS_WRAPPER_ELEMENTS) {          
          write("      if (element.get"+upFirst(name)+"().size() > 0) {\r\n");
          write("        xml.open(FHIR_NS, \""+Utilities.pluralizeMe(name)+"\");\r\n");
          write("        for ("+tn+" e : element.get"+upFirst(name)+"()) \r\n");
          write("          "+comp+"(\""+name+"\", e);\r\n");
          write("        xml.close(FHIR_NS, \""+Utilities.pluralizeMe(name)+"\");\r\n");
          write("      }\r\n");
        } else {
          write("      for ("+(tn.contains("(") ? PrepGenericTypeName(tn) : tn)+" e : element.get"+upFirst(name)+"()) \r\n");
          write("        "+comp+"(\""+name+"\", e);\r\n");
        }
      } else if (en != null) {
        write("      if (element.get"+upFirst(name)+"() != null)\r\n");
        write("        composeString(\""+name+"\", element.get"+upFirst(name)+"().toCode());\r\n");        
      } else {
        write("      "+comp+"(\""+name+"\", element.get"+upFirst(name)+"());\r\n");
      }
    }
  }

  private String PrepGenericTypeName(String tn) {
    int i = tn.indexOf('(');
    return tn.substring(0, i)+"<"+upFirst(tn.substring(i+1).replace(")", ">"));
  }

  private String PrepGenericName(String tn) {
    int i = tn.indexOf('(');
    return tn.substring(0, i)+"_"+upFirst(tn.substring(i+1).replace(")", ""));
  }

  private String typeName(ElementDefn root, ElementDefn elem, boolean usePrimitive, boolean formal) throws Exception {
    String t = elem.typeCode();
    if (usePrimitive && definitions.getPrimitives().containsKey(t)) {
      if (t.equals("boolean"))
        return formal ? "boolean" : "Bool";
      else if (t.equals("integer"))
        return "int";
      else if (t.equals("decimal"))
        return formal ? "BigDecimal" : "BigDecimal";
      else if (t.equals("base64Binary"))
        return formal ? "byte[]" : "bytes";
      else if (t.equals("instant"))
        return formal ? "java.util.Date" : "Date";
      else if (t.equals("uri"))
        return formal ? "java.net.URI" : "Uri";
      else 
        return "String";
    } else if (elem.getTypes().size() == 0) {
      if (elem.getElements().size() == 1 && elem.getElements().get(0).getName().equals("#")) { 
        if (typeNames.containsKey(elem) && typeNames.get(elem) != null)
          return typeNames.get(elem);
        else  
          return root.getName();      
      } else
        return typeNames.get(elem);
    } else if (typeNames.containsKey(elem))
      return typeNames.get(elem);
    else
      return upFirst(t);
  }
  
  private void finish() throws Exception {
    write("  @Override\r\n");
    write("  protected void composeResource(Resource resource) throws Exception {\r\n");
    write("    "+reg.toString().substring(9));
    write("    else\r\n");
    write("      throw new Exception(\"Unhanded resource type\");\r\n");
    write("  }\r\n\r\n");
    write("  @SuppressWarnings(\"unchecked\")\r\n");
    write("  protected void composeType(String prefix, Type type) throws Exception {\r\n");
    write("    if (type == null)\r\n");
    write("      ;\r\n");
    write(regt.toString());
    write("    else\r\n");
    write("      throw new Exception(\"Unhanded type\");\r\n");
    write("  }\r\n\r\n");
//
//    write("  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) {\r\n");
//    write("    "+regn.toString());
//    write("    return false;\r\n");
//    write("  }\r\n");
//    
    
    write("}\r\n");
    write("\r\n");
    flush();
  }

  private String getCodeListType(String binding) {
    StringBuilder b = new StringBuilder();
    boolean up = true;
    for (char ch: binding.toCharArray()) {
      if (ch == '-')
        up = true;
      else if (up) {
        b.append(Character.toUpperCase(ch));
        up = false;
      }
      else        
        b.append(ch);
    }
    return b.toString();
  }

  private void scanNestedTypes(ElementDefn root, String path, ElementDefn e) throws Exception {
    String tn = null;
    if (e.typeCode().equals("code") && e.hasConceptDomain()) {
      ConceptDomain cd = definitions.getConceptDomainByName(e.getConceptDomain());
      if (cd != null && cd.getBindingType() == ConceptDomain.BindingType.CodeList) {
        tn = getCodeListType(cd.getBinding());
        if (!enumNames.contains(tn)) {
          enumNames.add(tn);
          enums.add(e);
        }
        typeNames.put(e,  rootOf(path)+"."+tn);
      }
    }
    if (tn == null) {
      if (e.getTypes().size() > 0) {
        tn = e.typeCode();
        if (tn.equals("[param]"))
          tn = genparam;
        else if (tn.equalsIgnoreCase("xml:ID"))
          tn ="String";
        else if (tn.equalsIgnoreCase("Xhtml")) 
          tn = "char[]";
        else if (tn.equalsIgnoreCase("*"))
          tn ="Type";
        else if (tn.equals("string"))
          tn = "String_";
        if (tn.contains("<"))
          tn = tn.substring(0, tn.indexOf('<')+1)+tn.substring(tn.indexOf('<')+1, tn.indexOf('<')+2).toUpperCase()+tn.substring(tn.indexOf('<')+2);
        typeNames.put(e,  tn);
      } else {
        if (e.getElements().size() == 1 && e.getElements().get(0).getName().equals("#")) {
          tn = typeNames.get(getElementForPath(root, e.getElements().get(0).typeCode().substring(1)));
          typeNames.put(e,  tn);
        } else {
          tn = upFirst(e.getName());
          if (tn.equals("Element"))
            tn = "Element_";
          if (!e.getName().equals("extensions"))
            strucs.add(e);
          if (typeNameStrings.contains(tn)) {
            char i = 'A';
            while (typeNameStrings.contains(tn+i))
              i++;
            tn = tn + i;
          }
          typeNameStrings.add(tn);
          tn = path+"."+tn;
          typeNames.put(e,  tn);
          for (ElementDefn c : e.getElements()) {
            scanNestedTypes(root, path, c);
          }
        }
      }
    } 
  }

  private String rootOf(String path) {
    int i = path.indexOf('.');
    return i == -1 ? path : path.substring(0, i);
  }

  private Object getElementForPath(ElementDefn root, String pathname) throws Exception {
    String[] path = pathname.split("\\.");
    if (!path[0].equals(root.getName()))
      throw new Exception("Element Path '"+pathname+"' is not legal in this context");
    ElementDefn res = root;
    for (int i = 1; i < path.length; i++)
    {
      String en = path[i];
      if (en.length() == 0)
        throw new Exception("Improper path "+pathname);
      ElementDefn t = res.getElementByName(en);
      if (t == null) {
        throw new Exception("unable to resolve "+pathname);
      }
      res = t; 
    }
    return res;

  }

  
}
