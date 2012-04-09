package org.hl7.fhir.definitions.generators.implementations;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.hl7.fhir.definitions.model.ConceptDomain;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeDefn;

import org.hl7.fhir.utilities.Utilities;

/**
 * Generates the delphi reference implementation
 * 
 * todo: the delphi reference implementation depends on too much HL7Connect infrastructure.
 * 
 * @author Grahame
 *
 */
public class DelphiGenerator {

  static final int BUFFER = 2048;

  private DelphiCodeGenerator defCode;
  private DelphiCodeGenerator prsrCode;
  private Definitions definitions;
  
  private Map<ElementDefn, String> typeNames = new HashMap<ElementDefn, String>();

  private List<ElementDefn> enums = new ArrayList<ElementDefn>();
  private List<String> enumNames = new ArrayList<String>();
  private List<ElementDefn> strucs  = new ArrayList<ElementDefn>();
  private List<String> lists = new ArrayList<String>();
  

  private StringBuilder workingParserX;
  private StringBuilder workingSerialiserX;
  private StringBuilder workingParserJ;
  private StringBuilder workingSerialiserJ;
  
  public void generate(ElementDefn root, String superClass) throws Exception {
    typeNames.clear();
    enums.clear();
    strucs.clear();
    enumNames.clear();
        
    for (ElementDefn e : root.getElements()) {
      if (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text"))
        scanNestedTypes(root, root.getName(), e);
    }

    for (ElementDefn e : enums) {
      generateEnum(e);
    }
    for (ElementDefn e : strucs) {
      generateType(e);
    }
   
    if (root.getTypes().size() > 0 && root.getTypes().get(0).getName().equals("GenericType")) {
      for (TypeDefn td : definitions.getKnownTypes()) {
        if (td.getName().equals(root.getName()) && td.hasParams()) {
          for (String pt : td.getParams()) {
            String tn = getTypeName(pt);
            if (tn.equals(pt))
              tn = "T"+tn;
            genGenericResource(root, "T"+root.getName()+"_"+getTitle(pt), tn, superClass);
          }
        }
      }
    } else {
      genResource(root, "T"+root.getName(), superClass);
    }
    
  
  }
  
  private void genGenericResource(ElementDefn root, String tn, String pt, String superClass) throws Exception {
    prsrdefX.append("    function Parse"+tn.substring(1)+"(element : IXmlDomElement) : "+tn+";\r\n");
    srlsdefX.append("    procedure Serialise"+tn.substring(1)+"(name : string; elem : "+tn+");\r\n");
    prsrdefJ.append("    function Parse"+tn.substring(1)+" : "+tn+";\r\n");
    srlsdefJ.append("    procedure Serialise"+tn.substring(1)+"(name : string; elem : "+tn+");\r\n");
    workingParserX = new StringBuilder();
    workingSerialiserX = new StringBuilder();
    workingParserJ = new StringBuilder();
    workingSerialiserJ = new StringBuilder();
    
    StringBuilder def = new StringBuilder();
    StringBuilder defPriv1 = new StringBuilder();
    StringBuilder defPriv2 = new StringBuilder();
    StringBuilder defPub = new StringBuilder();
    StringBuilder impl = new StringBuilder();
    StringBuilder create = new StringBuilder();
    StringBuilder destroy = new StringBuilder();
    StringBuilder assign = new StringBuilder();

    
    for (ElementDefn e : root.getElements()) {
      generateField(e, defPriv1, defPriv2, defPub, impl, create, destroy, assign, tn, pt, true);
    }

    def.append("  {@Class "+tn+"\r\n");
    def.append("    "+root.getDefinition()+"\r\n");
    def.append("  }\r\n");
    def.append("  "+tn+" = class ("+superClass+")\r\n");
    def.append("  private\r\n");
    def.append(defPriv1.toString());
    def.append(defPriv2.toString());
    def.append("  public\r\n");
    def.append("    constructor Create; Override;\r\n");
    def.append("    destructor Destroy; override;\r\n");
    def.append("    procedure Assign(oSource : TAdvObject); override;\r\n");
    def.append("    function Link : "+tn+"; overload;\r\n");
    def.append("    function Clone : "+tn+"; overload;\r\n");
    def.append(defPub.toString());
    def.append("  end;\r\n");
    def.append("\r\n");

    StringBuilder impl2 = new StringBuilder();
    impl2.append("{ "+tn+" }\r\n\r\n");
    impl2.append("constructor "+tn+".Create;\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append(create.toString());
    impl2.append("end;\r\n\r\n");

    impl2.append("destructor "+tn+".Destroy;\r\n");
    impl2.append("begin\r\n");
    impl2.append(destroy.toString());
    impl2.append("  inherited;\r\n");
    impl2.append("end;\r\n\r\n");
    
    impl2.append("procedure "+tn+".Assign(oSource : TAdvObject);\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append(assign.toString());
    impl2.append("end;\r\n\r\n");
    
    impl2.append("function "+tn+".Link : "+tn+";\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := "+tn+"(inherited Link);\r\n");
    impl2.append("end;\r\n\r\n");
    impl2.append("function "+tn+".Clone : "+tn+";\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := "+tn+"(inherited Clone);\r\n");
    impl2.append("end;\r\n\r\n");
    
    defCode.classDefs.add(def.toString());
    defCode.classImpls.add(impl2.toString()+impl.toString());
    defCode.classFwds.add("  "+tn+" = class;\r\n");
    generateParser(tn, false);
  }


  private void genResource(ElementDefn root, String tn, String superClass) throws Exception {
    prsrdefX.append("    function Parse"+root.getName()+"(element : IXmlDomElement) : T"+root.getName()+";\r\n");
    srlsdefX.append("    procedure Serialise"+root.getName()+"(name : string; elem : T"+root.getName()+");\r\n");
    prsrdefJ.append("    function Parse"+root.getName()+" : T"+root.getName()+";\r\n");
    srlsdefJ.append("    procedure Serialise"+root.getName()+"(name : string; elem : T"+root.getName()+");\r\n");
    workingParserX = new StringBuilder();
    workingSerialiserX = new StringBuilder();
    workingParserJ = new StringBuilder();
    workingSerialiserJ = new StringBuilder();

    StringBuilder def = new StringBuilder();
    StringBuilder defPriv1 = new StringBuilder();
    StringBuilder defPriv2 = new StringBuilder();
    StringBuilder defPub = new StringBuilder();
    StringBuilder impl = new StringBuilder();
    StringBuilder create = new StringBuilder();
    StringBuilder destroy = new StringBuilder();
    StringBuilder assign = new StringBuilder();
    impl.append("{ "+tn+" }\r\n\r\n");

    
    for (ElementDefn e : root.getElements()) {
      if (!superClass.equals("TFHIRResource") || (!e.getName().equals("id") && !e.getName().equals("extensions") && !e.getName().equals("text")))
        generateField(e, defPriv1, defPriv2, defPub, impl, create, destroy, assign, tn, "", !superClass.equals("TFHIRResource"));
    }

    def.append("  {@Class "+tn+"\r\n");
    def.append("    "+root.getDefinition()+"\r\n");
    def.append("  }\r\n");
    def.append("  "+tn+" = class ("+superClass+")\r\n");
    def.append("  private\r\n");
    def.append(defPriv1.toString());
    def.append(defPriv2.toString());
    if (superClass.equals("TFHIRResource")) {
      def.append("  protected\r\n");
      def.append("    function GetResourceType : TFHIRResourceType; override;\r\n");      
    }
    def.append("  public\r\n");
    def.append("    constructor Create; Override;\r\n");
    def.append("    destructor Destroy; override;\r\n");
    def.append("    procedure Assign(oSource : TAdvObject); override;\r\n");
    def.append("    function Link : "+tn+"; overload;\r\n");
    def.append("    function Clone : "+tn+"; overload;\r\n");
    def.append(defPub.toString());
    def.append("  end;\r\n");
    def.append("\r\n");
    StringBuilder impl2 = new StringBuilder();
    impl2.append("{ "+tn+" }\r\n\r\n");
    impl2.append("constructor "+tn+".Create;\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append(create.toString());
    impl2.append("end;\r\n\r\n");

    impl2.append("destructor "+tn+".Destroy;\r\n");
    impl2.append("begin\r\n");
    impl2.append(destroy.toString());
    impl2.append("  inherited;\r\n");
    impl2.append("end;\r\n\r\n");
    if (superClass.equals("TFHIRResource")) {
      impl2.append("function "+tn+".GetResourceType : TFHIRResourceType;\r\nbegin\r\n  result := frt"+root.getName()+";\r\nend;\r\n\r\n");       
    }
    
    impl2.append("procedure "+tn+".Assign(oSource : TAdvObject);\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append(assign.toString());
    impl2.append("end;\r\n\r\n");
    
    impl2.append("function "+tn+".Link : "+tn+";\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := "+tn+"(inherited Link);\r\n");
    impl2.append("end;\r\n\r\n");
    impl2.append("function "+tn+".Clone : "+tn+";\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := "+tn+"(inherited Clone);\r\n");
    impl2.append("end;\r\n\r\n");
    defCode.classDefs.add(def.toString());
    defCode.classImpls.add(impl2.toString() + impl.toString());
    defCode.classFwds.add("  "+tn+" = class;\r\n");
    generateParser(tn, superClass.equals("TFHIRResource"));
  }

  private void generateEnum(ElementDefn e) throws Exception {
    String tn = typeNames.get(e);
    ConceptDomain cd = getConceptDomain(e.getConceptDomain());
    
    
    StringBuilder pfx = new StringBuilder();
    for (char c : tn.toCharArray()) {
      if (Character.isUpperCase(c))
        pfx.append(c);
    }
    String prefix = pfx.toString().toLowerCase();
    StringBuilder def = new StringBuilder();
    StringBuilder con = new StringBuilder();
    def.append("  {@Enum "+tn+"\r\n");
    def.append("    "+cd.getDefinition()+"\r\n");
    def.append("  }\r\n");
    def.append("  "+tn+" = (\r\n");
    con.append("  CODES_"+tn+" : Array["+tn+"] of String = (");
    
    int l = cd.getCodes().size();
    int i = 0;
    for (DefinedCode c : cd.getCodes()) {
      i++;
      String cc = c.getCode();
      cc = cc.replace("-", "Minus").replace("+", "Plus").replace(">=", "greaterOrEquals").replace("<=", "lessOrEquals").replace("<", "lessThan").replace(">", "greaterThan");

      cc = prefix + getTitle(cc);
      if (Utilities.isDelphiReservedWord(cc))
        cc = cc + "_";
      if (i == l) {
        def.append("    "+cc+"); {@enum.value "+c.getDefinition()+" }\r\n");
        con.append("'"+c.getCode()+"');");
      }
      else {
        def.append("    "+cc+", {@enum.value "+c.getDefinition()+" }\r\n");
        con.append("'"+c.getCode()+"', ");
      }
    }
    defCode.enumDefs.add(def.toString());
    defCode.enumConsts.add(con.toString());
  }

  private void generateType(ElementDefn e) throws Exception {
    String tn = typeNames.get(e);

    prsrdefX.append("    function Parse"+tn.substring(1)+"(element : IXmlDomElement) : "+tn+";\r\n");
    srlsdefX.append("    procedure Serialise"+tn.substring(1)+"(name : string; elem : "+tn+");\r\n");
    prsrdefJ.append("    function Parse"+tn.substring(1)+" : "+tn+";\r\n");
    srlsdefJ.append("    procedure Serialise"+tn.substring(1)+"(name : string; elem : "+tn+");\r\n");
    workingParserX = new StringBuilder();
    workingSerialiserX = new StringBuilder();
    workingParserJ = new StringBuilder();
    workingSerialiserJ = new StringBuilder();
    
    StringBuilder def = new StringBuilder();
    StringBuilder defPriv1 = new StringBuilder();
    StringBuilder defPriv2 = new StringBuilder();
    StringBuilder defPub = new StringBuilder();
    StringBuilder impl = new StringBuilder();
    StringBuilder create = new StringBuilder();
    StringBuilder destroy = new StringBuilder();
    StringBuilder assign = new StringBuilder();
    
    def.append("  {@Class "+tn+"\r\n");
    def.append("    "+e.getDefinition()+"\r\n");
    def.append("  }\r\n");
    def.append("  "+tn+" = class (TFHIRElement)\r\n");
    impl.append("{ "+tn+" }\r\n\r\n");
    
//    if (hasLists(e)) {
//      s.append("      public "+tn+"()\r\n");
//      s.append("      {\r\n");
//      for (ElementDefn c : e.getElements()) {
//        if (c.unbounded()) {
//          s.append("        "+getElementName(c.getName())+" = new List<"+typeNames.get(c)+">();\r\n");         
//        }
//      }
//      s.append("      }\r\n");
//      s.append("\r\n");
//      
//    }
    for (ElementDefn c : e.getElements()) {
      generateField(c, defPriv1, defPriv2, defPub, impl, create, destroy, assign, tn, "", false);
    }

    def.append("  private\r\n");
    def.append(defPriv1.toString());
    def.append(defPriv2.toString());
    def.append("  public\r\n");
    def.append("    constructor Create; Override;\r\n");
    def.append("    destructor Destroy; override;\r\n");
    def.append("    procedure Assign(oSource : TAdvObject); override;\r\n");
    def.append("    function Link : "+tn+"; overload;\r\n");
    def.append("    function Clone : "+tn+"; overload;\r\n");
    def.append(defPub.toString());
    def.append("  end;\r\n");
    def.append("\r\n");
    StringBuilder impl2 = new StringBuilder();
    impl2.append("{ "+tn+" }\r\n\r\n");
    impl2.append("constructor "+tn+".Create;\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append(create.toString());
    impl2.append("end;\r\n\r\n");

    impl2.append("destructor "+tn+".Destroy;\r\n");
    impl2.append("begin\r\n");
    impl2.append(destroy.toString());
    impl2.append("  inherited;\r\n");
    impl2.append("end;\r\n\r\n");
    
    impl2.append("procedure "+tn+".Assign(oSource : TAdvObject);\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append(assign.toString());
    impl2.append("end;\r\n\r\n");
    
    impl2.append("function "+tn+".Link : "+tn+";\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := "+tn+"(inherited Link);\r\n");
    impl2.append("end;\r\n\r\n");
    impl2.append("function "+tn+".Clone : "+tn+";\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := "+tn+"(inherited Clone);\r\n");
    impl2.append("end;\r\n\r\n");
    
    defCode.classDefs.add(def.toString());
    defCode.classImpls.add(impl2.toString() + impl.toString());
    defCode.classFwds.add("  "+tn+" = class;\r\n");
    generateParser(tn, false);
  }

  private void generateParser(String tn, boolean isResource) {
    String s = workingParserX.toString();
    prsrImpl.append(
            "function TFHIRXmlParser.Parse"+tn.substring(1)+"(element : IXmlDomElement) : "+tn+";\r\n"+
            "var\r\n"+
            "  child : IXMLDOMElement;\r\n");
    
    prsrImpl.append(s.contains("item") ? "  item : IXMLDOMElement;\r\n" : "");
    prsrImpl.append(
            "begin\r\n"+
            "  result := "+tn+".create;\r\n"+
            "  try\r\n"+
            "    result.xmlId := TMsXmlParser.GetAttribute(element, 'xml:Id');\r\n"+
            "    child := TMsXmlParser.FirstChild(element);\r\n"+
            "    while (child <> nil) do\r\n"+
            "    begin\r\n");
    if (isResource)
      prsrImpl.append(
          "      if (child.nodeName = 'id') then\r\n"+
          "        result.id := child.text\r\n"+
          "      else if (child.nodeName = 'text') then\r\n"+
          "        result.text := ParseNarrative(child)\r\n"+
            s);
    else 
      prsrImpl.append("      "+s.substring(11));
    prsrImpl.append(
            "      else\r\n"+
            "         UnknownContent(child);\r\n"+
            "      child := TMsXmlParser.NextSibling(child);\r\n"+
            "    end;\r\n"+
            "\r\n"+
            "    result.link;\r\n"+
            "  finally\r\n"+
            "    result.free;\r\n"+
            "  end;\r\n"+
            "end;\r\n\r\n"
        );

    s = workingSerialiserX.toString();
    prsrImpl.append(
            "procedure TFHIRXmlSerialiser.Serialise"+tn.substring(1)+"(name : string; elem : "+tn+");\r\n");
    if (s.contains("for i := "))
      prsrImpl.append("var\r\n  i : integer;\r\n");
    prsrImpl.append(
            "begin\r\n"+
            "  if (elem = nil) then\r\n    exit;\r\n"+
            "  attribute('xml:Id', elem.xmlId);\r\n"+
            "  FXml.open(name);\r\n");
    if (isResource)
      prsrImpl.append(
          "  Text('id', elem.id);\r\n");
    prsrImpl.append(s);
    if (isResource)
      prsrImpl.append(
            "  SerialiseNarrative('text', elem.text);\r\n");
    prsrImpl.append(
            "  FXml.close(name);\r\n"+
            "end;\r\n\r\n"
        );

    s = workingParserJ.toString();
    prsrImpl.append(
            "function TFHIRJsonParser.Parse"+tn.substring(1)+" : "+tn+";\r\n"+
            "begin\r\n"+
            "  result := "+tn+".create;\r\n"+
            "  try\r\n"+
            "    while (FJson.ItemType <> jpitEnd) do\r\n"+
            "    begin\r\n"+
            "      if (FJson.ItemName = 'xmlId') then\r\n"+
            "        result.xmlId := FJson.itemValue\r\n"+
            s+
            "      else\r\n"+
            "         UnknownContent;\r\n"+
            "    end;\r\n"+
            "\r\n"+
            "    result.link;\r\n"+
            "  finally\r\n"+
            "    result.free;\r\n"+
            "  end;\r\n"+
            "end;\r\n\r\n"
        );

    s = workingSerialiserJ.toString();
    prsrImpl.append(
            "procedure TFHIRJsonSerialiser.Serialise"+tn.substring(1)+"(name : string; elem : "+tn+");\r\n");
    if (s.contains("for i := "))
      prsrImpl.append("var\r\n  i : integer;\r\n");
    prsrImpl.append(
            "begin\r\n"+
            "  if (elem = nil) then\r\n    exit;\r\n"+
            "  FJson.valueObject(name);\r\n"+
            "  Prop('xmlId', elem.xmlId);\r\n");
    if (isResource)
      prsrImpl.append(
          "  Prop('id', elem.id);\r\n");
    prsrImpl.append(s);
    if (isResource)
      prsrImpl.append(
            "  SerialiseNarrative('text', elem.text);\r\n");
    prsrImpl.append(
            "  FJson.finishObject;\r\n"+
            "end;\r\n\r\n"
        );

  }

//  private boolean hasLists(ElementDefn e) {
//    for (ElementDefn c : e.getElements()) {
//      if (c.unbounded())
//        return true;
//    }
//    return false;
//  }

  private void scanNestedTypes(ElementDefn root, String path, ElementDefn e) throws Exception {
    String tn = null;
    if (e.typeCode().equals("code") && e.hasConceptDomain()) {
      ConceptDomain cd = getConceptDomain(e.getConceptDomain());
      if (cd != null && cd.getBindingType() == ConceptDomain.BindingType.CodeList) {
        tn = "T"+getCodeListType(cd.getBinding());
        if (!enumNames.contains(tn)) {
          enumNames.add(tn);
          enums.add(e);
        }
        typeNames.put(e,  tn);
      }
    }
    if (tn == null) {
      if (e.getTypes().size() > 0) {
        tn = getTypeName(e);
        typeNames.put(e,  tn);
      } else {
        if (e.getElements().size() == 1 && e.getElements().get(0).getName().equals("#")) {
          tn = typeNames.get(getElementForPath(root, e.getElements().get(0).typeCode().substring(1)));
          typeNames.put(e,  tn);
        } else {
          tn = "T"+path+getTitle(e.getName());
          strucs.add(e);
          typeNames.put(e,  tn);
          for (ElementDefn c : e.getElements()) {
            scanNestedTypes(root, path+getTitle(e.getName()), c);
          }
        }
      }
    }
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

  private ConceptDomain getConceptDomain(String conceptDomain) {
    for (ConceptDomain cd : definitions.getConceptDomains().values())
      if (cd.getName().equals(conceptDomain))
        return cd;
    return null;
  }

  private void generateField(ElementDefn e, StringBuilder defPriv1, StringBuilder defPriv2, StringBuilder defPub, StringBuilder impl, StringBuilder create, StringBuilder destroy, StringBuilder assign, String cn, String pt, Boolean isType) throws Exception {
    String tn;
    if (e.getTypes().size() > 0 && e.getTypes().get(0).getName().equals("[param]"))
      tn = pt;
    else
      tn = typeNames.get(e);
    if (tn == null) {
      if (e.getName().equals("extension"))
        tn = "TExtension";
      else
        tn = getTypeName(e);
    }
    

    String parse = null;
    if (typeIsSimple(tn)) {
      if (enumNames.contains(tn))
        parse = tn+"(ParseEnum(CODES_"+tn+", child))";
      else if (tn.equals("Integer"))
        parse = "StringToInteger32(child.text)";
      else if (tn.equals("Boolean"))
        parse = "StringToBoolean(child.text)";
      else if (tn.equals("TDateTime"))
        parse = "XMLDateTimeStringToDateTime(child.text)";
      else if (tn.equals("xhtml"))
        parse = "child.xml";
      else
        parse = "child.text";
    }
    String parseJ = null;
    if (typeIsSimple(tn)) {
      if (enumNames.contains(tn))
        parseJ = tn+"(ParseEnum(CODES_"+tn+"))";
      else if (tn.equals("Integer"))
        parseJ = "StringToInteger32(FJson.itemValue)";
      else if (tn.equals("Boolean"))
        parseJ = "StringToBoolean(FJson.itemValue)";
      else if (tn.equals("TDateTime"))
        parseJ = "XMLDateTimeStringToDateTime(FJson.itemValue)";
      else
        parseJ = "FJson.itemValue";
    }
    String srlsd = "Text";
    String srlsdJ = "Prop";
    String srls = "#";
    if (typeIsSimple(tn)) {
      if (enumNames.contains(tn)) {
        srls = "CODES_"+tn+"[#]";
      } else if (tn.equals("Integer")) {
        srls = "IntegerToString(#)";
      } else if (tn.equals("Boolean")) {
        srls = "BooleanToString(#)";
      } else if (tn.equals("TDateTime")) {
        srls = "DateTimeToXMLDateTimeString(#)";
      };
    }
    
    
    String s = getElementName(e.getName()); 
    if (e.unbounded()) {
      String tnl;
      if (tn.contains("{"))
        tnl = tn.substring(0, tn.indexOf('{'))+"List"+tn.substring(tn.indexOf('{'));
      else if (tn.equals("String"))
        tnl = "TStringList";
      else
        tnl = tn+"List";
      s = getTitle(s);
      defPriv1.append("    F"+s+" : "+tnl+";\r\n");
      defPub.append("    {@member "+s+"\r\n");
      defPub.append("      "+e.getDefinition()+"\r\n");
      defPub.append("    }\r\n");
      defPub.append("    property "+s+" : "+tnl+" read F"+getTitle(s)+";\r\n");
      defPub.append("\r\n");
      create.append("  F"+s+" := "+tnl+".Create;\r\n");
      destroy.append("  F"+s+".Free;\r\n");
      assign.append("  F"+s+".Assign("+cn+"(oSource).F"+s+");\r\n");
      
      defineList(tn, tnl);
      if (!typeIsSimple(tn)) {
        if (!e.getName().equals("[type]") && !e.getName().contains("[x]")) {
          parse = "Parse"+tn.substring(1)+"(child)";
          parseJ = "Parse"+tn.substring(1)+"";
          srlsd = "Serialise"+tn.substring(1);
          srlsdJ = "Serialise"+tn.substring(1);
        } else {
          throw new Exception("not supported");
        }
      };
      if (isType) {
        workingParserX.append("      else if (child.nodeName = '"+e.getName()+"') then\r\n"+
            "        result."+s+".Add("+parse+")\r\n");
        workingSerialiserX.append("  for i := 0 to elem."+s+".Count - 1 do\r\n"+
            "    "+srlsd+"('"+e.getName()+"', "+srls.replace("#", "elem."+s+"[i]")+");\r\n");
      }
      else {
        parse = parse.replace("child", "item");
        workingParserX.append("      else if (child.nodeName = '"+Utilities.pluralize(e.getName())+"') then\r\n"+
            "      begin\r\n"+
            "        item := TMsXmlParser.FirstChild(child);\r\n"+
            "        while (item <> nil) do\r\n"+
            "        begin\r\n"+
            "          if (item.nodeName = '"+e.getName()+"') Then\r\n"+
            "            result."+s+".Add("+parse+")\r\n"+
            "          else\r\n"+
            "            UnknownContent(item);\r\n"+
            "          item := TMsXmlParser.NextSibling(item);\r\n"+
            "        end;\r\n"+
            "      end\r\n");
        workingSerialiserX.append("  if elem."+s+".Count > 0 then\r\n"+
            "  begin\r\n"+
            "    FXml.open('"+Utilities.pluralize(e.getName())+"');\r\n"+
            "    for i := 0 to elem."+s+".Count - 1 do\r\n"+
            "      "+srlsd+"('"+e.getName()+"',"+srls.replace("#", "elem."+s+"[i]")+");\r\n"+
            "    FXml.Close('"+Utilities.pluralize(e.getName())+"');\r\n"+
            "  end;\r\n");
      }
      workingParserJ.append("      else if (FJson.ItemName = '"+Utilities.pluralize(e.getName())+"') then\r\n"+
          "      begin\r\n"+
          "        FJson.checkState(jpitArray);\r\n"+
          "        FJson.Next;\r\n"+
          "        while (FJson.ItemType <> jpitEnd) do\r\n"+
          "          result."+s+".Add("+parseJ+");\r\n"+
          "        FJson.Next;\r\n"+
          "      end\r\n");

      workingSerialiserJ.append("  if elem."+s+".Count > 0 then\r\n"+
          "  begin\r\n"+
          "    FJson.valueObject('"+Utilities.pluralize(e.getName())+"');\r\n"+
          "    for i := 0 to elem."+s+".Count - 1 do\r\n"+
          "      "+srlsdJ+"('"+e.getName()+"',"+srls.replace("#", "elem."+s+"[i]")+");\r\n"+
          "    FJson.FinishObject;\r\n"+
          "  end;\r\n");
    } else {
      defPriv1.append("    F"+getTitle(s)+" : "+tn+";\r\n");
      defPriv2.append("    Procedure Set"+getTitle(s)+"(value : "+tn+");\r\n");
      defPub.append("    {@member "+s+"\r\n");
      defPub.append("      "+e.getDefinition()+"\r\n");
      defPub.append("    }\r\n");
      defPub.append("    property "+s+" : "+tn+" read F"+getTitle(s)+" write Set"+getTitle(s)+";\r\n");
      defPub.append("\r\n");
      if (typeIsSimple(tn)) {
        impl.append("Procedure "+cn+".Set"+getTitle(s)+"(value : "+tn+");\r\nbegin\r\n  F"+getTitle(s)+" := value;\r\nend;\r\n\r\n");
        assign.append("  F"+getTitle(s)+" := "+cn+"(oSource).F"+getTitle(s)+";\r\n");
        workingParserX.append("      else if (child.nodeName = '"+e.getName()+"') then\r\n        result."+s+" := "+parse+"\r\n");
        workingSerialiserX.append("  Text('"+e.getName()+"',"+srls.replace("#", "elem."+s)+");\r\n");
        workingParserJ.append("      else if (FJson.ItemName = '"+e.getName()+"') then\r\n        result."+s+" := "+parseJ+"\r\n");
        workingSerialiserJ.append("  Prop('"+e.getName()+"',"+srls.replace("#", "elem."+s)+");\r\n");
      }
      else {
        impl.append("Procedure "+cn+".Set"+getTitle(s)+"(value : "+tn+");\r\nbegin\r\n  F"+getTitle(s)+".free;\r\n  F"+getTitle(s)+" := value;\r\nend;\r\n\r\n");
        destroy.append("  F"+getTitle(s)+".free;\r\n");
        assign.append("  "+s+" := "+cn+"(oSource)."+s+".Clone;\r\n");
        if (e.getName().contains("[x]") && e.getTypes().size() > 1) {
          String pfx = e.getName().replace("[x]", "");
          int t = e.getTypes().size();
          int i = 0;
          for (TypeDefn td : e.getTypes()) {
            if (td.hasParams()) {
              for (String ptn : td.getParams()) {
                workingParserX.append("      else if (child.nodeName = '"+pfx+getTitle(td.getName())+"_"+getTitle(ptn)+"') then\r\n        result."+s+" := Parse"+getTitle(td.getName())+"_"+getTitle(ptn)+"(child)\r\n");
                workingSerialiserX.append("  "+(i==0 ? "if" : "else if")+" elem."+s+" is T"+getTitle(td.getName())+"_"+getTitle(ptn)+" then\r\n    Serialise"+getTitle(td.getName())+"_"+getTitle(ptn)+"('"+pfx+getTitle(td.getName())+"_"+getTitle(ptn)+"', T"+getTitle(td.getName())+"_"+getTitle(ptn)+"(elem."+s+"))"+(i == t-1?";" : "")+"\r\n");
                workingParserJ.append("      else if (FJson.ItemName = '"+pfx+getTitle(td.getName())+"_"+getTitle(ptn)+"') then\r\n        result."+s+" := Parse"+getTitle(td.getName())+"_"+getTitle(ptn)+"\r\n");
                workingSerialiserJ.append("  "+(i==0 ? "if" : "else if")+" elem."+s+" is T"+getTitle(td.getName())+"_"+getTitle(ptn)+" then\r\n    Serialise"+getTitle(td.getName())+"_"+getTitle(ptn)+"('"+pfx+getTitle(td.getName())+"_"+getTitle(ptn)+"', T"+getTitle(td.getName())+"_"+getTitle(ptn)+"(elem."+s+"))"+(i == t-1?";" : "")+"\r\n");
              }
            }
            else { 
              workingParserX.append("      else if (child.nodeName = '"+pfx+getTitle(td.getName())+"') then\r\n        result."+s+" := Parse"+getTitle(td.getName())+"(child)\r\n");
              if (td.getName().equalsIgnoreCase("string")) {
                workingSerialiserX.append("  "+(i==0 ? "if" : "else if")+" elem."+s+" is TFHIRType"+getTitle(td.getName())+" then\r\n    Text('"+pfx+getTitle(td.getName())+"', TFHIRType"+getTitle(td.getName())+"(elem."+s+").value)"+(i == t-1?";" : "")+"\r\n");
                workingSerialiserJ.append("  "+(i==0 ? "if" : "else if")+" elem."+s+" is TFHIRType"+getTitle(td.getName())+" then\r\n    Prop('"+pfx+getTitle(td.getName())+"', TFHIRType"+getTitle(td.getName())+"(elem."+s+").value)"+(i == t-1?";" : "")+"\r\n");
              } else {
                workingSerialiserX.append("  "+(i==0 ? "if" : "else if")+" elem."+s+" is T"+getTitle(td.getName())+" then\r\n    Serialise"+getTitle(td.getName())+"('"+pfx+getTitle(td.getName())+"', T"+getTitle(td.getName())+"(elem."+s+"))"+(i == t-1?";" : "")+"\r\n");
                workingSerialiserJ.append("  "+(i==0 ? "if" : "else if")+" elem."+s+" is T"+getTitle(td.getName())+" then\r\n    Serialise"+getTitle(td.getName())+"('"+pfx+getTitle(td.getName())+"', T"+getTitle(td.getName())+"(elem."+s+"))"+(i == t-1?";" : "")+"\r\n");
              }
              workingParserJ.append("      else if (FJson.ItemName = '"+pfx+getTitle(td.getName())+"') then\r\n        result."+s+" := Parse"+getTitle(td.getName())+"\r\n");
            }
            i++;
          }
          
        } else if (!e.getName().equals("[type]") && !e.getName().contains("[x]")) {
          workingParserX.append("      else if (child.nodeName = '"+e.getName()+"') then\r\n        result."+s+" := Parse"+tn.substring(1)+"(child)\r\n");
          workingSerialiserX.append("  Serialise"+tn.substring(1)+"('"+e.getName()+"', elem."+s+");\r\n");
          workingParserJ.append("      else if (FJson.ItemName = '"+e.getName()+"') then\r\n        result."+s+" := Parse"+tn.substring(1)+"\r\n");
          workingSerialiserJ.append("  Serialise"+tn.substring(1)+"('"+e.getName()+"', elem."+s+");\r\n");
        } else {
          String pfx = e.getName().contains("[x]") ? e.getName().replace("[x]", "") : "";
          int i = 0;
          for (DefinedCode cd : definitions.getPrimitives().values()) {
            workingParserX.append("      else if (child.nodeName = '"+pfx+getTitle(cd.getCode())+"') then\r\n        result."+s+" := Parse"+getTitle(cd.getCode())+"(child)\r\n");
            String ptn = "TFHIRTypeString";
            if (cd.getCode().equals("integer"))
              ptn = "TFHIRTypeInteger";
            else if (cd.getCode().equals("boolean"))
              ptn = "TFHIRTypeBoolean";
            else if (cd.getCode().equals("instant"))
              ptn = "TFHIRTypeDateTime";
            else if (cd.getCode().equals("decimal"))
              ptn = "TFHIRTypeDecimal";
            else if (cd.getCode().equals("base64Binary"))
              ptn = "TFHIRTypeBytes";
            workingSerialiserX.append("  "+(i > 0 ? "else " : "")+"if elem."+s+" is "+ptn+" then\r\n    Serialise"+ptn.substring(9)+"('"+pfx+getTitle(cd.getCode())+"', "+ptn+"(elem."+s+"))\r\n");
            workingParserJ.append("      else if (FJson.ItemName = '"+pfx+getTitle(cd.getCode())+"') then\r\n        result."+s+" := Parse"+getTitle(cd.getCode())+"\r\n");
            workingSerialiserJ.append("  "+(i > 0 ? "else " : "")+"if elem."+s+" is "+ptn+" then\r\n    Serialise"+ptn.substring(9)+"('"+pfx+getTitle(cd.getCode())+"', "+ptn+"(elem."+s+"))\r\n");
            i++;
          }
          for (ElementDefn ed : definitions.getTypes().values()) {
            if (ed.getTypes().get(0).getName().equals("GenericType")) {
              for (TypeDefn td : definitions.getKnownTypes()) {
                if (td.getName().equals(ed.getName()) && td.hasParams()) {
                  for (String ptn : td.getParams()) {
                    workingParserX.append("      else if (child.nodeName = '"+pfx+getTitle(ed.getName())+"_"+getTitle(ptn)+"') then\r\n        result."+s+" := Parse"+getTitle(ed.getName())+"_"+getTitle(ptn)+"(child)\r\n");
                    workingSerialiserX.append("  else if elem."+s+" is T"+getTitle(ed.getName())+"_"+getTitle(ptn)+" then\r\n    Serialise"+getTitle(ed.getName())+"_"+getTitle(ptn)+"('"+pfx+getTitle(ed.getName())+"_"+getTitle(ptn)+"', T"+getTitle(ed.getName())+"_"+getTitle(ptn)+"(elem."+s+"))\r\n");
                    workingParserJ.append("      else if (FJson.ItemName = '"+pfx+getTitle(ed.getName())+"_"+getTitle(ptn)+"') then\r\n        result."+s+" := Parse"+getTitle(ed.getName())+"_"+getTitle(ptn)+"\r\n");
                    workingSerialiserJ.append("  else if elem."+s+" is T"+getTitle(ed.getName())+"_"+getTitle(ptn)+" then\r\n    Serialise"+getTitle(ed.getName())+"_"+getTitle(ptn)+"('"+pfx+getTitle(ed.getName())+"_"+getTitle(ptn)+"', T"+getTitle(ed.getName())+"_"+getTitle(ptn)+"(elem."+s+"))\r\n");
                  }
                }
              }
            } else {
              workingParserX.append("      else if (child.nodeName = '"+pfx+getTitle(ed.getName())+"') then\r\n        result."+s+" := Parse"+getTitle(ed.getName())+"(child)\r\n");
              workingSerialiserX.append("  else if elem."+s+" is T"+getTitle(ed.getName())+" then\r\n    Serialise"+getTitle(ed.getName())+"('"+pfx+getTitle(ed.getName())+"', T"+getTitle(ed.getName())+"(elem."+s+"))\r\n");
              workingParserJ.append("      else if (FJson.ItemName = '"+pfx+getTitle(ed.getName())+"') then\r\n        result."+s+" := Parse"+getTitle(ed.getName())+"\r\n");
              workingSerialiserJ.append("  else if elem."+s+" is T"+getTitle(ed.getName())+" then\r\n    Serialise"+getTitle(ed.getName())+"('"+pfx+getTitle(ed.getName())+"', T"+getTitle(ed.getName())+"(elem."+s+"))\r\n");
            }
          }
          int t = definitions.getStructures().size();
          i = 0;
          for (ElementDefn ed : definitions.getStructures().values()) {
            workingParserX.append("      else if (child.nodeName = '"+pfx+getTitle(ed.getName())+"') then\r\n        result."+s+" := Parse"+getTitle(ed.getName())+"(child)\r\n");
            workingSerialiserX.append("  else if elem."+s+" is T"+getTitle(ed.getName())+" then\r\n    Serialise"+getTitle(ed.getName())+"('"+pfx+getTitle(ed.getName())+"', T"+getTitle(ed.getName())+"(elem."+s+"))"+(i < t-1 ? "" : ";")+"\r\n");
            workingParserJ.append("      else if (FJson.ItemName = '"+pfx+getTitle(ed.getName())+"') then\r\n        result."+s+" := Parse"+getTitle(ed.getName())+"\r\n");
            workingSerialiserJ.append("  else if elem."+s+" is T"+getTitle(ed.getName())+" then\r\n    Serialise"+getTitle(ed.getName())+"('"+pfx+getTitle(ed.getName())+"', T"+getTitle(ed.getName())+"(elem."+s+"))"+(i < t-1 ? "" : ";")+"\r\n");
            i++;
          }
        }
      }
    }

  }

  private void defineList(String tn, String tnl) {
    if (!lists.contains(tnl) && !tnl.startsWith("TFHIRResourceReference") && !tnl.equals("TStringList")) {
      lists.add(tn+"List");
      defCode.classFwds.add("  "+tn+"List = class;\r\n");
      defCode.classDefs.add(
        "  {@Class "+tn+"List\r\n"+
        "    A list of Author\r\n"+
        "  }\r\n"+
        "  {!.Net HL7Connect.FHIR."+tn.substring(1)+"List}\r\n"+
        "  "+tn+"List = class (THL7FHIRObjectList)\r\n"+
        "  private\r\n"+
        "    Function GetItemN(index : Integer) : "+tn+";\r\n"+
        "  public\r\n"+
        "    {@member IndexOf\r\n"+
        "      See if an item is already in the list. returns -1 if not in the list\r\n"+
        "    }\r\n"+
        "    Function IndexOf(value : "+tn+") : Integer;\r\n"+
        "    {@member Item\r\n"+
        "       Get the iIndexth Author. (0 = first item)\r\n"+
        "    }\r\n"+
        "    Function Item(index : Integer) : "+tn+";\r\n"+
        "    {@member Count\r\n"+
        "      The number of items in the collection\r\n"+
        "    }\r\n"+
        "    Function Count : Integer; Overload;\r\n"+
        "    Property Segments[index : Integer] : "+tn+" read GetItemN; default;\r\n"+
        "  End;\r\n"+
        "\r\n"  
          );
      defCode.classImpls.add(
        "{ "+tn+"List }\r\n"+
        "function "+tn+"List.Count: Integer;\r\n"+
        "begin\r\n"+
        "  result := Inherited Count;\r\n"+
        "end;\r\n\r\n"+
        "function "+tn+"List.GetItemN(index: Integer): "+tn+";\r\n"+
        "begin\r\n"+
        "  result := "+tn+"(ObjectByIndex[index]);\r\n"+
        "end;\r\n\r\n"+
        "function "+tn+"List.IndexOf(value: "+tn+"): Integer;\r\n"+
        "begin\r\n"+
        "  result := IndexByReference(value);\r\n"+
        "end;\r\n\r\n"+
        "function "+tn+"List.Item(index: Integer): "+tn+";\r\n"+
        "begin\r\n"+
        "  result := "+tn+"(ObjectByIndex[index]);\r\n"+
        "end;\r\n\r\n"
          ); 
    }
  }

  private boolean typeIsSimple(String tn) {
    if (tn == null)
      return false;
    return tn.equals("String") || tn.equals("Integer") || tn.equals("Boolean") || tn.equals("TDateTime") || enumNames.contains(tn);
  }

  private String getTitle(String name) {
    return name.substring(0, 1).toUpperCase()+ name.substring(1);
  }

  private String getElementName(String name) {
    if (Utilities.isDelphiReservedWord(name))
      return name+"_";
    return name.replace("[x]", "").replace("[type]", "value");
  }

  private String getTypeName(ElementDefn e) throws Exception {
    if (e.getTypes().size() > 1) {
      return "TFHIRType";
    } else if (e.getTypes().size() == 0) {
      throw new Exception("not supported");
    } else {
      return getTypename(e.getTypes().get(0));
    }
  }

  private String getTypename(TypeDefn type) throws Exception {
    if (type.getParams().size() == 1) {     
      if (type.getName().equals("Resource"))
        return "TFHIRResourceReference{"+getTypeName(type.getParams().get(0))+"}";
      else if (type.getName().equals("Interval"))
        return "TInterval_"+type.getParams().get(0);
      else
        throw new Exception("not supported");
    } else if (type.getParams().size() > 1) {
      if (type.getName().equals("Resource"))
        return "TFHIRResourceReference{Resource}";
      else
        throw new Exception("not supported");
    } else {
      return getTypeName(type.getName());
    }
  }

  private String getTypeName(String tn) {
    if (tn == null) {
      return "";
    } else if (tn.equals("string")) {
      return "String";
    } else if (tn.equals("id")) {
      return "String";
    } else if (tn.equals("code")) {
      return "String";
    } else if (tn.equals("integer")) {
      return "Integer";
    } else if (tn.equals("instant")) {
      return "TDateTime";
    } else if (tn.equals("boolean")) {
      return "Boolean";
    } else if (tn.equals("dateTime")) {
      return "String";
    } else if (tn.equals("date")) {
      return "String";
    } else if (tn.equals("uri")) {
      return "String";
    } else if (tn.equals("decimal")) {
      return "TSmartDecimal";      
    } else if (tn.equals("xhtml")) {
      return "TXHtml"; // what should it be?
    } else if (tn.equals("xml:ID")) {
      return "String";
    } else if (tn.equals("base64Binary")) {
      return "TAdvBuffer";
    } else if (tn.equals("*")) {
      return "TFHIRType";
    } else if (tn.equals("Any")) {
      return "Resource";
    } else if (definitions.getConstraints().containsKey(tn)) {
      return getTypeName(definitions.getConstraints().get(tn).getComment());
    } else {
      return "T"+getTitle(tn);
    }
  }
  
  private void zipDelphiFiles(String delphiDir, String dstDir) throws Exception {
    BufferedInputStream origin = null;
    FileOutputStream dest = new FileOutputStream(dstDir+"delphi.zip");
    ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
    byte data[] = new byte[BUFFER];
    File f = new File(delphiDir);
    String files[] = f.list();
    for (int i=0; i < files.length; i++) {
      if (files[i].endsWith(".pas")) {
        FileInputStream fi = new FileInputStream(delphiDir+files[i]);
        origin = new BufferedInputStream(fi, BUFFER);
        ZipEntry entry = new ZipEntry(files[i]);
        out.putNextEntry(entry);
        int count;
        while((count = origin.read(data, 0, BUFFER)) != -1) {
          out.write(data, 0, count);
        }
      }
    }
    out.close();
  }

  
  public void generate(Definitions definitions, String delphiDir, String dstDir, String version, String genDate) throws Exception {
    defCode = new DelphiCodeGenerator(new FileOutputStream(delphiDir+"FHIRResources.pas"));
    defCode.start();
    defCode.name = "FHIRResources";
    defCode.comments.add("FHIR v"+version+" generated "+genDate);
    defCode.uses.add("FHIRBase");
    defCode.uses.add("AdvBuffers");
    defCode.uses.add("DecimalSupport");
    defCode.uses.add("Classes");

    prsrCode = new DelphiCodeGenerator(new FileOutputStream(delphiDir+"FHIRParser.pas"));
    prsrCode.start();
    prsrCode.name = "FHIRParser";
    initParser(version, genDate);
    
    this.definitions = definitions;
    
    generateResource();
    
    for (ElementDefn n : definitions.getInfrastructure().values()) {
      generate(n, "TFHIRElement");
    }
    for (ElementDefn n : definitions.getTypes().values()) {
      generate(n, "TFHIRType");
    }
    
    for (ElementDefn n : definitions.getStructures().values()) {
      generate(n, "TFHIRType");
    }
    
    for (ElementDefn n : definitions.getResources().values()) {
      generate(n, "TFHIRResource");
      prsrRegX.append("  else if element.NodeName = '"+n.getName()+"' Then\r\n    result := Parse"+n.getName()+"(element)\r\n");
      srlsRegX.append("    frt"+n.getName()+": Serialise"+n.getName()+"('"+n.getName()+"', T"+n.getName()+"(resource));\r\n");
      prsrRegJ.append("  else if FJson.ItemName = '"+n.getName()+"' Then\r\n    result := Parse"+n.getName()+"\r\n");
      srlsRegJ.append("    frt"+n.getName()+": Serialise"+n.getName()+"('"+n.getName()+"', T"+n.getName()+"(resource));\r\n");
    }
    
//    for (String n : ini.getPropertyNames("future-resources")) {
//      ElementDefn e = new ElementDefn();
//      e.setName(ini.getStringProperty("future-resources", n));
//      generate(e, definitions.getConceptDomains());
//    }
    defCode.enumConsts.add("  FHIR_GENERATED_VERSION = '"+version+"';\r\n");
    defCode.finish();

    prsrCode.classDefs.add(buildParser());
    prsrCode.classImpls.add(prsrImpl.toString());
    prsrCode.finish();
    zipDelphiFiles(delphiDir, dstDir);    
  }

  private void generateResource() throws Exception {
    String prefix = "frt";
    StringBuilder def = new StringBuilder();
    StringBuilder con = new StringBuilder();
    def.append("  {@Enum TFHIRResourceType\r\n");
    def.append("    Enumeration of known resource types\r\n");
    def.append("  }\r\n");
    def.append("  TFHIRResourceType = (\r\n");
    con.append("  CODES_TFHIRResourceType : Array[TFHIRResourceType] of String = (");
    
    int l = definitions.getDefinedResources().size();
    int i = 0;
    for (String s : definitions.getDefinedResources().keySet()) {
      i++;
      String s2 = prefix + getTitle(s);
      if (Utilities.isDelphiReservedWord(s2))
        s2 = s2 + "_";
      if (i == l) {
        def.append("    "+s2+"); {@enum.value "+definitions.getResourceDefn(s).getDefinition()+" }\r\n");
        con.append("'"+s+"');");
      }
      else {
        def.append("    "+s2+", {@enum.value "+definitions.getResourceDefn(s).getDefinition()+" }\r\n");
        con.append("'"+s+"', ");
      }
    }
    defCode.enumDefs.add(def.toString());
    defCode.enumConsts.add(con.toString());

       

    def = new StringBuilder();
    

    def.append("  {@Class TFHIRResource\r\n");
    def.append("    Base Resource Definition - id, extensions, narrative\r\n");
    def.append("  }\r\n");
    def.append("  TFHIRResource = {abstract} class (TFHIRElement)\r\n");
    def.append("  private\r\n");
    def.append("    FId : String;\r\n");
    def.append("    FText : TNarrative;\r\n");
    def.append("    procedure SetResourceId(value : string);\r\n");
    def.append("    procedure SetText(value : TNarrative);\r\n");
    def.append("  protected\r\n");
    def.append("    function GetResourceType : TFHIRResourceType; virtual; abstract;\r\n");
    def.append("  public\r\n");
    def.append("    constructor Create; override;\r\n");
    def.append("    destructor Destroy; override;\r\n");
    def.append("    procedure Assign(oSource : TAdvObject); override;\r\n");
    def.append("    function Link : TFHIRResource; overload;\r\n");
    def.append("    function Clone : TFHIRResource; overload;\r\n");
    def.append("    Property ResourceType : TFHIRResourceType read GetResourceType;\r\n\r\n");
    def.append("    {@member code\r\n");
    def.append("      The code that identifies the meaning of the extension by reference to the definitions\r\n");
    def.append("    }\r\n");
    def.append("    property id : String read FId write SetResourceId;\r\n\r\n");
    def.append("    {@member text\r\n");
    def.append("      Text summary of resource, for human interpretation\r\n");
    def.append("    }\r\n");
    def.append("    property text : TNarrative read FText write SetText;\r\n");
    def.append("  end;\r\n");
    
    def.append("\r\n");
    StringBuilder impl2 = new StringBuilder();
    impl2.append("{ TFHIRResource }\r\n\r\n");
    impl2.append("constructor TFHIRResource.Create;\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append("end;\r\n\r\n");

    impl2.append("destructor TFHIRResource.Destroy;\r\n");
    impl2.append("begin\r\n");
    impl2.append("  FText.Free;\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append("end;\r\n\r\n");
    
    impl2.append("procedure TFHIRResource.Assign(oSource : TAdvObject);\r\n");
    impl2.append("begin\r\n");
    impl2.append("  inherited;\r\n");
    impl2.append("  FId := TFHIRResource(oSource).FId;\r\n");
    impl2.append("  text := TFHIRResource(oSource).text.Clone;\r\n");
    impl2.append("end;\r\n\r\n");
    
    impl2.append("function TFHIRResource.Link : TFHIRResource;\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := TFHIRResource(inherited Link);\r\n");
    impl2.append("end;\r\n\r\n");
    impl2.append("function TFHIRResource.Clone : TFHIRResource;\r\n");
    impl2.append("begin\r\n");
    impl2.append("  result := TFHIRResource(inherited Clone);\r\n");
    impl2.append("end;\r\n\r\n");
    impl2.append("procedure TFHIRResource.SetResourceId(value : string);\r\n");
    impl2.append("begin\r\n");
    impl2.append("  FId := value;\r\n");
    impl2.append("end;\r\n\r\n");
    impl2.append("procedure TFHIRResource.SetText(value : TNarrative);\r\n");
    impl2.append("begin\r\n");
    impl2.append("  FText.Free;\r\n");
    impl2.append("  FText := value;\r\n");
    impl2.append("end;\r\n\r\n");
    defCode.classDefs.add(def.toString());
    defCode.classImpls.add(impl2.toString());
    defCode.classFwds.add("  TFHIRResource = class;\r\n");
    
  }

  private StringBuilder prsrRegX = new StringBuilder();
  private StringBuilder srlsRegX = new StringBuilder();
  private StringBuilder prsrRegJ = new StringBuilder();
  private StringBuilder srlsRegJ = new StringBuilder();
  private StringBuilder prsrImpl = new StringBuilder();
  private StringBuilder prsrdefX = new StringBuilder();
  private StringBuilder srlsdefX = new StringBuilder();
  private StringBuilder prsrdefJ = new StringBuilder();
  private StringBuilder srlsdefJ = new StringBuilder();
  
  private void initParser(String version, String genDate) {
    prsrCode.uses.add("SysUtils");
    prsrCode.uses.add("Classes");
    prsrCode.uses.add("ActiveX");
    prsrCode.uses.add("StringSupport");
    prsrCode.uses.add("DateSupport");
    prsrCode.uses.add("IdSoapMsXml");
    prsrCode.uses.add("FHIRParserBase");
    prsrCode.uses.add("FHIRBase");
    prsrCode.uses.add("FHIRResources");
    prsrCode.uses.add("MsXmlParser");
    prsrCode.uses.add("JSON");
    prsrCode.comments.add("FHIR v"+version+" generated "+genDate);
    
    prsrImpl.append(
        "{ TFHIRXmlParser }\r\n"+
        "\r\n"
        );
    
  }

  private String buildParser() {
    
    prsrImpl.append(
        "function TFHIRXmlParser.ParseResource(element : IXmlDomElement) : TFHIRResource;\r\n"+
        "begin\r\n"+
        "  if (element = nil) Then\r\n"+
        "    Raise Exception.Create('error - element is nil')\r\n"+
        prsrRegX.toString()+
        "  else\r\n"+
        "    raise Exception.create('Error: the element '+element.NodeName+' is not recognised as a valid resource name');\r\n" +
        "end;\r\n\r\n"
        );

    prsrImpl.append(
        "procedure TFHIRXmlSerialiser.SerialiseResource(resource: TFHIRResource);\r\n"+
        "begin\r\n"+
        "  if (resource = nil) Then\r\n"+
        "    Raise Exception.Create('error - resource is nil');\r\n"+
        "  Case resource.ResourceType of\r\n"+
        srlsRegX.toString()+
        "  else\r\n"+
        "    raise Exception.create('Internal error: the resource type '+CODES_TFHIRResourceType[resource.ResourceType]+' is not a valid resource type');\r\n" +
        "  end;\r\n"+
        "end;\r\n\r\n"
        );

    prsrImpl.append(
        "function TFHIRJsonParser.ParseResource : TFHIRResource;\r\n"+
        "begin\r\n "+
        prsrRegJ.toString().substring(6)+
        "  else\r\n"+
        "    raise Exception.create('error: the element '+FJson.itemName+' is not a valid resource name');\r\n" +
        "end;\r\n\r\n"
        );

    prsrImpl.append(
        "procedure TFHIRJsonSerialiser.SerialiseResource(resource: TFHIRResource);\r\n"+
        "begin\r\n"+
        "  if (resource = nil) Then\r\n"+
        "    Raise Exception.Create('error - resource is nil');\r\n"+
        "  Case resource.ResourceType of\r\n"+
        srlsRegJ.toString()+
        "  else\r\n"+
        "    raise Exception.create('Internal error: the resource type '+CODES_TFHIRResourceType[resource.ResourceType]+' is not a valid resource type');\r\n" +
        "  end;\r\n"+
        "end;\r\n\r\n"
        );

    return
        "  TFHIRXmlParser = class (TFHIRXmlParserBase)\r\n"+
        "  protected\r\n"+
        prsrdefX.toString()+
        "    function ParseResource(element : IxmlDomElement) : TFHIRResource; override;\r\n"+
        "  end;\r\n\r\n"+
        "  TFHIRXmlSerialiser = class (TFHIRXmlSerialiserBase)\r\n"+
        "  protected\r\n"+
        srlsdefX.toString()+
        "    procedure SerialiseResource(resource : TFHIRResource); override;\r\n"+
        "  end;\r\n\r\n"+
        "  TFHIRJsonParser = class (TFHIRJsonParserBase)\r\n"+
        "  protected\r\n"+
        prsrdefJ.toString()+
        "    function ParseResource : TFHIRResource; override;\r\n"+
        "  end;\r\n\r\n"+
        "  TFHIRJsonSerialiser = class (TFHIRJsonSerialiserBase)\r\n"+
        "  protected\r\n"+
        srlsdefJ.toString()+
        "    procedure SerialiseResource(resource : TFHIRResource); override;\r\n"+
        "  end;\r\n\r\n";
  }

}
