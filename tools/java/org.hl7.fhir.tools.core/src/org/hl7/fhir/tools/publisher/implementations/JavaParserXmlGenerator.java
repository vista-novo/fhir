package org.hl7.fhir.tools.publisher.implementations;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.utilities.Utilities;

public class JavaParserXmlGenerator extends OutputStreamWriter {
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
  
  public JavaParserXmlGenerator(OutputStream out) throws UnsupportedEncodingException {
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
              genGeneric(n, n.getName()+"<"+upFirst(pt)+">", pt);
              regt.append("    else if (xpp.getName().equals(prefix+\""+n.getName()+"_"+upFirst(pt)+"\"))\r\n      return parse"+n.getName()+"_"+upFirst(pt)+"(xpp);\r\n");
              regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"_"+upFirst(pt)+"\"))\r\n      return true;\r\n");
            }
          }
        }
      } else {
        generate(n, true, false, false);
        regt.append("    else if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return parse"+n.getName()+"(xpp);\r\n");
        regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return true;\r\n");
      }
    }

    for (DefinedCode n : definitions.getConstraints().values()) {
      generateConstraint(n, true, false, false);
      regt.append("    else if (xpp.getName().equals(prefix+\""+n.getCode()+"\"))\r\n      return parse"+n.getCode()+"(xpp);\r\n");
      regn.append("    if (xpp.getName().equals(prefix+\""+n.getCode()+"\"))\r\n      return true;\r\n");
    }
    for (ElementDefn n : definitions.getStructures().values()) {
      generate(n, true, false, false);
      regt.append("    else if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return parse"+n.getName()+"(xpp);\r\n");
      regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return true;\r\n");
    }
    
    for (ElementDefn n : definitions.getResources().values()) {
      generate(n, false, true, true);
      reg.append("    else if (xpp.getName().equals(\""+n.getName()+"\"))\r\n      return parse"+n.getName()+"(xpp);\r\n");
      regn.append("    if (xpp.getName().equals(prefix+\""+n.getName()+"\"))\r\n      return true;\r\n");
    }
    
    for (DefinedCode cd : definitions.getPrimitives().values()) {
      String n = upFirst(cd.getCode());
      String t = n;
      if (n.equals("String"))
        t = "String_";
//      if (n.equals("Uri"))
//        t = "URI";
      regt.append("    else if (xpp.getName().equals(prefix+\""+n+"\"))\r\n      return parse"+t+"(xpp);\r\n");
      regn.append("    if (xpp.getName().equals(prefix+\""+n+"\"))\r\n      return true;\r\n");
    }
    
    finish();
  }

  private String upFirst(String n) {
    return n.substring(0,1).toUpperCase() + n.substring(1);
  }

  private void start(String version, Date genDate) throws Exception {
    write("package org.hl7.fhir.instance.formats;\r\n");
    write("\r\n/*\r\n"+Config.FULL_LICENSE_CODE+"*/\r\n\r\n");
    write("// Generated on "+Config.DATE_FORMAT().format(genDate)+" for FHIR v"+version+"\r\n\r\n");
    write("import org.hl7.fhir.instance.model.*;\r\n");
    write("import org.xmlpull.v1.*;\r\n");
  //  write("import java.util.*;\r\n");
    write("\r\n");
    write("public class XmlParser extends XmlParserBase {\r\n");
    write("\r\n");
  }

  private void genGeneric(ElementDefn n, String tn, String pt) throws Exception {
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

    genInner(n, true, false, false);
    
    for (ElementDefn e : strucs) {
      genInner(e, true, false, false);
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
    boolean bUseOwner = false;
    
    String pn = tn.contains("<") ? "\""+tn.substring(tn.indexOf('<')+1).replace(">", "") + "\"" : "";
    
    if (tn.contains(".")) {
      write("  private "+tn+" parse"+upFirst(tn).replace(".", "").replace("<", "_").replace(">", "")+"(XmlPullParser xpp, "+pathClass(tn)+" owner) throws Exception {\r\n");
      write("    "+tn+" res = owner.new "+pathNode(tn)+"("+pn+");\r\n");
      bUseOwner = true;
    } else {
      write("  private "+tn+" parse"+upFirst(tn).replace(".", "").replace("<", "_").replace(">", "")+"(XmlPullParser xpp) throws Exception {\r\n");
      write("    "+tn+" res = new "+tn+"("+pn+");\r\n");
    }
    if (hasDataAbsentReason && !tn.contains("."))
      write("    parseTypeAttributes(xpp, res);\r\n");
    else
      write("    parseElementAttributes(xpp, res);\r\n");
    write("    int eventType = nextNoWhitespace(xpp);\r\n");
    write("    while (eventType != XmlPullParser.END_TAG) {\r\n");
    boolean first = true;
    for (ElementDefn e : n.getElements()) {
//      if (!n.typeCode().equals("Resource") || (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text"))) {
        genElement(n, e, first, contentsHaveDataAbsentReason, bUseOwner, listsAreWrapped);
        first = false;
      //}
    }
    write("      } else\r\n");
    write("        unknownContent(xpp);\r\n");
    write("      eventType = nextNoWhitespace(xpp);\r\n");
    write("    }\r\n");
    write("    return res;\r\n");
    write("  }\r\n\r\n");    
  }

  private String pathClass(String tn) {
    return tn.substring(0, tn.indexOf('.'));
  }

  private String pathNode(String tn) {
    return tn.substring(tn.indexOf('.')+1);
  }

  private void genElement(ElementDefn root, ElementDefn e, boolean first, boolean contentsHaveDataAbsentReason, boolean bUseOwner, boolean listsAreWrapped) throws Exception {
    String name = e.getName();
    if (name.endsWith("[x]") || name.equals("[type]")) {
      String en = name.endsWith("[x]") ? name.replace("[x]", "") : "value";
      String pfx = name.endsWith("[x]") ? name.replace("[x]", "") : "";
      write("      "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && nameIsTypeName(xpp, \""+pfx+"\")) {\r\n");
      write("        res.set"+upFirst(en)+"(parseType(\""+en+"\", xpp));\r\n");
    } else {
      String prsr = null;
      BindingSpecification cd = definitions.getBindingByName(e.getBindingName());
      if (e.typeCode().equals("code") && cd != null && cd.getBinding() == BindingSpecification.Binding.CodeList) {
        String en = typeNames.get(e); // getCodeListType(cd.getBinding());
        prsr = en+".fromCode(parseString(xpp))";
      } else {   
        String tn = typeName(root, e, !contentsHaveDataAbsentReason, false).replace(".", "");
        if (name.equals("extensions")) {
          name = "extension";
          tn = "Extension";
        }
        if (tn.equals("char[]"))
          tn = "xhtml";
        if (tn.contains("Resource("))
          prsr = "parseResourceReference(xpp)";
        else if (tn.contains("("))
          prsr = "parse"+PrepGenericName(tn)+"(xpp)";
        else if (tn.startsWith(context) && !tn.equals(context)) {
          if (bUseOwner)
            prsr = "parse"+upFirst(tn)+"(xpp, owner)";
          else
            prsr = "parse"+upFirst(tn)+"(xpp, res)";
        } else
          if ((!contentsHaveDataAbsentReason || !e.isAllowDAR()) && "Uri".equals(tn))
            prsr = "parseURI(xpp)";
          else if ((!contentsHaveDataAbsentReason || !e.isAllowDAR()) && "Instant".equals(tn))
            prsr = "parseInstantSimple(xpp)";
          else
            prsr = "parse"+upFirst(tn)+"(xpp)";
      }
      
      if (name.equals("extension")) {
        write("      "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\"extensions\")) {\r\n");
        write("        eventType = nextNoWhitespace(xpp);\r\n");
        write("        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\"extension\")) {\r\n");
        if (contentsHaveDataAbsentReason) 
          write("          res.getExtensions().add(parseExtension(xpp));\r\n");
        else
          write("          res.getExtension().add(parseExtension(xpp));\r\n");
        write("          eventType = nextNoWhitespace(xpp);\r\n");
        write("        }\r\n");
        write("        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals(\""+Utilities.pluralizeMe(name)+"\"))\r\n");
        write("          throw new Exception(\"XML Error in requestDetails\");\r\n");          
      } else if (e.unbounded()) {
        if (listsAreWrapped && !Config.SUPPRESS_WRAPPER_ELEMENTS) {          
          write("      "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+Utilities.pluralizeMe(name)+"\")) {\r\n");
          write("        eventType = nextNoWhitespace(xpp);\r\n");
          write("        while (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+name+"\")) {\r\n");
          write("          res.get"+upFirst(name)+"().add("+prsr+");\r\n");
          write("          eventType = nextNoWhitespace(xpp);\r\n");
          write("        }\r\n");
          write("        if (eventType != XmlPullParser.END_TAG || !xpp.getName().equals(\""+Utilities.pluralizeMe(name)+"\"))\r\n");
          write("          throw new Exception(\"XML Error in requestDetails\");\r\n");          
        } else {
          write("      "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+name+"\")) {\r\n");
          write("        res.get"+upFirst(name)+"().add("+prsr+");\r\n");
        }
      } else {
        write("      "+(!first ? "} else " : "")+"if (eventType == XmlPullParser.START_TAG && xpp.getName().equals(\""+name+"\")) {\r\n");
        write("        res.set"+upFirst(name)+"("+prsr+");\r\n");
      }
    }
  }

  private String PrepGenericName(String tn) {
    int i = tn.indexOf('(');
    return tn.substring(0, i)+"_"+upFirst(tn.substring(i+1).replace(")", ""));
  }

  private String typeName(ElementDefn root, ElementDefn elem, boolean usePrimitive, boolean formal) throws Exception {
    String t = elem.typeCode();
    if ((usePrimitive || !elem.isAllowDAR()) && definitions.getPrimitives().containsKey(t)) {
      if (t.equals("boolean"))
        return formal ? "boolean" : "Bool";
      else if (t.equals("integer"))
        return "int";
      else if (t.equals("decimal"))
        return formal ? "BigDecimal" : "BigDecimal";
      else if (t.equals("base64Binary"))
        return formal ? "byte[]" : "bytes";
      else if (t.equals("instant"))
        return formal ? "java.util.Date" : "Instant";
      else if (t.equals("uri"))
        return formal ? "java.net.URI" : "Uri";
      else 
        return "String";
    } else if (elem.typeCode().startsWith("@")) { 
      if (typeNames.containsKey(elem) && typeNames.get(elem) != null)
        return typeNames.get(elem);
      else  
        return root.getName();      
    } else if (elem.getTypes().size() == 0) {
        return typeNames.get(elem);
    } else if (typeNames.containsKey(elem))
      return typeNames.get(elem);
    else
      return upFirst(t);
  }
  
  private void finish() throws Exception {
    write("  @Override\r\n");
    write("  protected Resource parseResource(XmlPullParser xpp) throws Exception {\r\n");
    write("    "+reg.toString().substring(9));
    write("    return null;\r\n");
    write("  }\r\n\r\n");
    write("  protected Type parseType(String prefix, XmlPullParser xpp) throws Exception {\r\n");
    write("    "+regt.toString().substring(9));
    write("    throw new Exception(\"Unknown type \"+xpp.getName());\r\n");
    write("  }\r\n\r\n");

    write("  private boolean nameIsTypeName(XmlPullParser xpp, String prefix) {\r\n");
    write("    "+regn.toString());
    write("    return false;\r\n");
    write("  }\r\n");
    
    
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
    if (e.typeCode().equals("code") && e.hasBinding()) {
      BindingSpecification cd = definitions.getBindingByName(e.getBindingName());
      if (cd != null && cd.getBinding() == BindingSpecification.Binding.CodeList) {
        tn = getCodeListType(cd.getReference());
        if (!enumNames.contains(tn)) {
          enumNames.add(tn);
          enums.add(e);
        }
        typeNames.put(e,  rootOf(path)+"."+upFirst(tn.substring(1)));
      }
    }
    if (tn == null) {
      if (e.getTypes().size() > 0 && !e.typeCode().startsWith("@")) {
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
        typeNames.put(e,  tn);
      } else {
        if (e.typeCode().startsWith("@")) {
          tn = typeNames.get(getElementForPath(root, e.typeCode().substring(1)));
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
