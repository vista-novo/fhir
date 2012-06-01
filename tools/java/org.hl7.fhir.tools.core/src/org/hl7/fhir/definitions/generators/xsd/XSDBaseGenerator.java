package org.hl7.fhir.definitions.generators.xsd;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.DefinedStringPattern;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.PrimitiveType;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.utilities.Utilities;

public class XSDBaseGenerator extends OutputStreamWriter {

  private Definitions definitions;

	private Map<String, ElementDefn> structures = new HashMap<String, ElementDefn>();
	private List<String> typenames = new ArrayList<String>();
//	private List<TypeDefn> datatypes = new ArrayList<TypeDefn>();
//	private Map<String, ConceptDomain> tx;
	private List<String> enums = new ArrayList<String>();
//  private Map<String, PrimitiveType> primitives;
	
	public XSDBaseGenerator(OutputStream out) throws UnsupportedEncodingException {
		super(out, "UTF-8");
	}

	public void generate(String version, String genDate) throws Exception {
    write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
    write("<!-- \r\n");
    write("  © HL7 (http://hl7.org)\r\n");
    write("  Generated on "+genDate+" for FHIR v"+version+" \r\n");
    write("-->\r\n");
    write("<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://hl7.org/fhir\" xmlns:xhtml=\"http://www.w3.org/1999/xhtml\" "+
       "targetNamespace=\"http://hl7.org/fhir\" elementFormDefault=\"qualified\">\r\n");
    write("  <xs:import namespace=\"http://www.w3.org/XML/1998/namespace\"/>\r\n");
    write("  <xs:import namespace=\"http://www.w3.org/1999/xhtml\" schemaLocation=\"xhtml1-strict.xsd\"/>\r\n");

    genPrimitives();
    genDataAbsentReason();
    genResourceReference();
    
    for (ElementDefn e : definitions.getInfrastructure().values())
      genInfrastructure(e);
    for (ElementDefn e : definitions.getTypes().values())
      if (e.getTypes().get(0).getName().equals("GenericType"))
        genGeneric(e);
      else
        genType(e);
    for (DefinedCode cd : definitions.getConstraints().values()) 
      genConstraint(cd);
    for (ElementDefn e : definitions.getStructures().values())
      genStructure(e);
    genExtensionsElement();
    write("</xs:schema>\r\n");
    flush();
	}
	
  private void genExtensionsElement() throws Exception {
    write("  <xs:complexType name=\"Extensions\">\r\n");
    write("    <xs:sequence>\r\n");
    write("      <xs:element name=\"extension\" type=\"Extension\" minOccurs=\"0\" maxOccurs=\"unbounded\">\r\n");
    write("        <xs:annotation>\r\n");
    write("          <xs:documentation>An extension value</xs:documentation>\r\n");
    write("        </xs:annotation>\r\n");
    write("      </xs:element>\r\n");
    write("    </xs:sequence>\r\n");
    write("  </xs:complexType>\r\n");    
  }

  private void genResourceReference() throws Exception {
    write("  <xs:simpleType name=\"ResourceType\">\r\n");
    write("    <xs:restriction base=\"xs:string\">\r\n");
    for (DefinedCode c : definitions.getKnownResources().values()) {
      write("      <xs:enumeration value=\""+c.getCode()+"\">\r\n");
      write("        <xs:annotation>\r\n");
      write("          <xs:documentation>"+Utilities.escapeXml(c.getDefinition())+"</xs:documentation>\r\n");
      write("        </xs:annotation>\r\n");
      write("      </xs:enumeration>\r\n");
    }
    write("    </xs:restriction>\r\n");
    write("  </xs:simpleType>\r\n");
    
    write("  <xs:complexType name=\"ResourceReference\" block=\"extension\">\r\n");
    write("    <xs:sequence>\r\n");
    write("      <xs:element name=\"type\" type=\"ResourceType\" minOccurs=\"0\">\r\n");
    write("        <xs:annotation>\r\n");
    write("          <xs:documentation>the mime type of the content</xs:documentation>\r\n");
    write("        </xs:annotation>\r\n");
    write("      </xs:element>\r\n");
    write("      <xs:element name=\"id\" type=\"id-simple\" minOccurs=\"0\">\r\n");
    write("        <xs:annotation>\r\n");
    write("          <xs:documentation>Id of the reference</xs:documentation>\r\n");
    write("        </xs:annotation>\r\n");
    write("      </xs:element>\r\n");
    write("      <xs:element name=\"version\" type=\"id-simple\" minOccurs=\"0\">\r\n");
    write("        <xs:annotation>\r\n");
    write("          <xs:documentation>Version specific Id of the reference</xs:documentation>\r\n");
    write("        </xs:annotation>\r\n");
    write("      </xs:element>\r\n");
    write("      <xs:element name=\"text\" type=\"xs:string\" minOccurs=\"0\">\r\n");
    write("        <xs:annotation>\r\n");
    write("          <xs:documentation>Text summary for the reference</xs:documentation>\r\n");
    write("        </xs:annotation>\r\n");
    write("      </xs:element>\r\n");
    write("    </xs:sequence>\r\n");
//    write("    <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
    write("    <xs:attribute ref=\"xml:id\"/>\r\n");
    write("  </xs:complexType>\r\n");
  }

  private void genConstraint(DefinedCode cd) throws Exception {
    write("  <xs:complexType name=\""+cd.getCode()+"\">\r\n");
    write("    <xs:complexContent>\r\n");
    write("      <xs:restriction base=\""+cd.getComment()+"\">\r\n");
    write("        <xs:sequence>\r\n");

    ElementDefn elem = definitions.getTypes().get(cd.getComment());
    for (ElementDefn e : elem.getElements()) {
      if (e.getName().equals("[type]"))
        generateAny(elem, e, null);
      else if ((!e.unbounded() && 1 == e.getMaxCardinality()) || Config.SUPPRESS_WRAPPER_ELEMENTS)
        generateElement(elem, e, null);
      else
        generateWrapperElement(elem, e);
    }
    write("        </xs:sequence>\r\n");

    write("        <xs:attribute ref=\"xml:id\"/>\r\n");
    write("      </xs:restriction>\r\n");
    write("    </xs:complexContent>\r\n");
    write("  </xs:complexType>\r\n");

    
  }

  private void genPrimitives() throws Exception {
    for (DefinedCode cd : definitions.getPrimitives().values()) {
      if (cd instanceof PrimitiveType) {
        PrimitiveType pt = (PrimitiveType) cd;
        write("  <xs:complexType name=\""+pt.getCode()+"\">\r\n");
        write("    <xs:simpleContent>\r\n");
        write("      <xs:extension base=\"xs:"+pt.getSchemaType()+"\">\r\n");
//        write("        <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
        write("        <xs:attribute ref=\"xml:id\"/>\r\n");
        write("      </xs:extension>\r\n");
        write("    </xs:simpleContent>\r\n");
        write("  </xs:complexType>\r\n");
      } else {
        DefinedStringPattern sp = (DefinedStringPattern) cd;
        write("  <xs:simpleType name=\""+sp.getCode()+"-simple\">\r\n");
        write("    <xs:restriction base=\"xs:string\">\r\n");
        write("      <xs:pattern value=\""+sp.getRegex()+"\"/>\r\n");
        write("    </xs:restriction>\r\n");
        write("  </xs:simpleType>\r\n");
        write("  <xs:complexType name=\""+sp.getCode()+"\">\r\n");
        write("    <xs:simpleContent>\r\n");
        write("      <xs:extension base=\""+sp.getCode()+"-simple\">\r\n");
//        write("        <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
        write("        <xs:attribute ref=\"xml:id\"/>\r\n");
        write("      </xs:extension>\r\n");
        write("    </xs:simpleContent>\r\n");
        write("  </xs:complexType>\r\n");
      }
    } 
  }

  private void genDataAbsentReason() throws IOException {
    generateEnum("DataAbsentReason");
    write("  <xs:attributeGroup name=\"dataAbsentReason\">\r\n");
    write("    <xs:attribute name=\"dataAbsentReason\" type=\"DataAbsentReason\">\r\n");
    write("      <xs:annotation>\r\n");
    write("        <xs:documentation>Specifies why the normally expected content of the data element is missing</xs:documentation>\r\n");
    write("     </xs:annotation>\r\n");
    write("    </xs:attribute>\r\n");
    write("  </xs:attributeGroup>\r\n");

  }

  private void genInfrastructure(ElementDefn elem) throws Exception {
    enums.clear();
    String name = elem.getName();
    write("  <xs:complexType name=\""+name+"\">\r\n");
    write("    <xs:sequence>\r\n");

    for (ElementDefn e : elem.getElements()) {
      if (e.getName().equals("[type]"))
        generateAny(elem, e, null);
      else if ((!e.unbounded() && 1 == e.getMaxCardinality()) || Config.SUPPRESS_WRAPPER_ELEMENTS)
        generateElement(elem, e, null);
      else
        generateWrapperElement(elem, e);
    }
    write("    </xs:sequence>\r\n");
    write("  </xs:complexType>\r\n");
    while (!structures.isEmpty())
    {
      String s = structures.keySet().iterator().next();
      generateType(elem, s, structures.get(s));
      structures.remove(s);
    }

    for (String en : enums) {
      generateEnum(en);
    }

  }

  private void genType(ElementDefn elem) throws Exception {
    enums.clear();
    String name = elem.getName();
    write("  <xs:complexType name=\""+name+"\">\r\n");
    write("    <xs:sequence>\r\n");

    for (ElementDefn e : elem.getElements()) {
      if (e.getName().equals("[type]"))
        generateAny(elem, e, null);
    else if ((!e.unbounded() && 1 == e.getMaxCardinality()) || Config.SUPPRESS_WRAPPER_ELEMENTS)
    generateElement(elem, e, null);
  else
    generateWrapperElement(elem, e);
    }
    write("    </xs:sequence>\r\n");
    write("    <xs:attribute ref=\"xml:id\"/>\r\n");
    write("  </xs:complexType>\r\n");
//    write("  <xs:complexType name=\""+name+"\">\r\n");
//    write("    <xs:complexContent>\r\n");
//    write("      <xs:extension base=\"Core"+name+"\">\r\n");
//    write("        <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
//    write("        <xs:attribute ref=\"xml:id\"/>\r\n");
//    write("      </xs:extension>\r\n");
//    write("    </xs:complexContent>\r\n");
//    write("  </xs:complexType>\r\n");

  
    while (!structures.isEmpty())
    {
      String s = structures.keySet().iterator().next();
      generateType(elem, s, structures.get(s));
      structures.remove(s);
    }

    for (String en : enums) {
      generateEnum(en);
    }

  }

  private void genStructure(ElementDefn elem) throws Exception {
    enums.clear();
    String name = elem.getName();
    write("  <xs:complexType name=\""+name+"\">\r\n");
    write("    <xs:sequence>\r\n");

    for (ElementDefn e : elem.getElements()) {
      if (e.getName().equals("[type]"))
        generateAny(elem, e, null);
    else if ((!e.unbounded() && 1 == e.getMaxCardinality()) || Config.SUPPRESS_WRAPPER_ELEMENTS)
    generateElement(elem, e, null);
  else
    generateWrapperElement(elem, e);
    }
    write("    </xs:sequence>\r\n");
//    write("    <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
    write("    <xs:attribute ref=\"xml:id\"/>\r\n");
    write("  </xs:complexType>\r\n");
  
    while (!structures.isEmpty())
    {
      String s = structures.keySet().iterator().next();
      generateType(elem, s, structures.get(s));
      structures.remove(s);
    }

    for (String en : enums) {
      generateEnum(en);
    }

  }

  private void genGeneric(ElementDefn elem) throws Exception {
    enums.clear();
    for (TypeDefn td : definitions.getKnownTypes()) {
      if (td.getName().equals(elem.getName()) && td.hasParams()) {
        for (String pt : td.getParams()) {

          String name = elem.getName()+"_"+upFirst(pt);
          write("  <xs:complexType name=\""+name+"\">\r\n");
          write("    <xs:sequence>\r\n");

          for (ElementDefn e : elem.getElements()) {
            if (e.getName().equals("[type]"))
              generateAny(elem, e, null);
            else if ((!e.unbounded() && 1 == e.getMaxCardinality()) || Config.SUPPRESS_WRAPPER_ELEMENTS)
              generateElement(elem, e, pt);
            else
              generateWrapperElement(elem, e);
          }
          write("    </xs:sequence>\r\n");
          write("    <xs:attribute ref=\"xml:id\"/>\r\n");
          write("  </xs:complexType>\r\n");
//          write("  <xs:complexType name=\""+name+"\">\r\n");
//          write("    <xs:complexContent>\r\n");
//          write("      <xs:extension base=\"Core"+name+"\">\r\n");
//          write("        <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
//          write("        <xs:attribute ref=\"xml:id\"/>\r\n");
//          write("      </xs:extension>\r\n");
//          write("    </xs:complexContent>\r\n");
//          write("  </xs:complexType>\r\n");


          while (!structures.isEmpty())
          {
            String s = structures.keySet().iterator().next();
            generateType(elem, s, structures.get(s));
            structures.remove(s);
          }

          for (String en : enums) {
            generateEnum(en);
          }
        }
      }
    }
  }
  
	private void generateEnum(String en) throws IOException {
		write("  <xs:simpleType name=\""+en+"\">\r\n");
		write("    <xs:restriction base=\"xs:string\">\r\n");
		for (DefinedCode c : definitions.getBindingByName(en).getCodes()) {
			write("      <xs:enumeration value=\""+Utilities.escapeXml(c.getCode())+"\">\r\n");
			write("        <xs:annotation>\r\n");
			write("          <xs:documentation>"+Utilities.escapeXml(c.getDefinition())+"</xs:documentation>\r\n");
			write("        </xs:annotation>\r\n");
			write("      </xs:enumeration>\r\n");
		}
		write("    </xs:restriction>\r\n");
		write("  </xs:simpleType>\r\n");
	}

	private void generateType(ElementDefn root, String name, ElementDefn struc) throws IOException, Exception {
		write("  <xs:complexType name=\""+name+"\">\r\n");
		write("    <xs:sequence>\r\n");
		
		for (ElementDefn e : struc.getElements()) {
			if (e.getName().equals("[type]"))
				generateAny(root, e, null);
			else if ((!e.unbounded() && 1 == e.getMaxCardinality()) || Config.SUPPRESS_WRAPPER_ELEMENTS)
				generateElement(root, e, null);
			else
				generateWrapperElement(root, e);
		}
		write("    </xs:sequence>\r\n");
    write("    <xs:attribute ref=\"xml:id\"/>\r\n");
		write("  </xs:complexType>\r\n");
	}

	private void generateAny(ElementDefn root, ElementDefn e, String prefix) throws Exception {
		write("      <xs:choice minOccurs=\""+e.getMinCardinality().toString()+"\" maxOccurs=\"1\">\r\n");
		if (e.hasDefinition()) {
			write("        <xs:annotation>\r\n");
			write("          <xs:documentation>"+Utilities.escapeXml(e.getDefinition())+"</xs:documentation>\r\n");
			write("        </xs:annotation>\r\n");
		}
		for (TypeDefn t : definitions.getKnownTypes()) {
		  if (!definitions.getInfrastructure().containsKey(t.getName()) && !definitions.getConstraints().containsKey(t.getName())) {
		    String en = prefix != null ? prefix + upFirst(t.getName()) : t.getName();
		    if (t.hasParams()) {
		      for (String p : t.getParams()) {
		        write("       <xs:element name=\""+en+"_"+upFirst(p)+"\">\r\n");				
		        write("         <xs:complexType>\r\n");
		        write("           <xs:complexContent>\r\n");
		        write("             <xs:extension base=\""+t.getName()+"_"+upFirst(p)+"\">\r\n");
		        write("               <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
		        write("             </xs:extension>\r\n");
		        write("           </xs:complexContent>\r\n");
		        write("         </xs:complexType>\r\n");
		        write("       </xs:element>\r\n");        
		      }
		    } else {
          //write("       <xs:element name=\""+t.getName()+"\" type=\""+t.getName()+"\"/>\r\n");        
          write("       <xs:element name=\""+en+"\">\r\n");
          write("         <xs:complexType>\r\n");
          write("           <xs:complexContent>\r\n");
          write("             <xs:extension base=\""+t.getName()+"\">\r\n");
          write("               <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
          write("             </xs:extension>\r\n");
          write("           </xs:complexContent>\r\n");
          write("         </xs:complexType>\r\n");
          write("       </xs:element>\r\n");        
		    }
		  }
		}
    write("       <xs:element name=\""+(prefix == null ? "" : prefix)+"Resource\">\r\n");       
    write("         <xs:complexType>\r\n");
    write("           <xs:complexContent>\r\n");
    write("             <xs:extension base=\"ResourceReference\">\r\n");
    write("               <xs:attributeGroup ref=\"dataAbsentReason\"/>\r\n");
    write("             </xs:extension>\r\n");
    write("           </xs:complexContent>\r\n");
    write("         </xs:complexType>\r\n");
    write("       </xs:element>\r\n");        
		write("      </xs:choice>\r\n");
	}

	private void generateWrapperElement(ElementDefn root, ElementDefn e) throws Exception {
		write("      <xs:element name=\""+Utilities.pluralizeMe(e.getName())+"\" minOccurs=\""+e.getMinCardinality().toString()+"\" maxOccurs=\"1\">\r\n");
		write("        <xs:complexType>\r\n");
		write("          <xs:sequence>\r\n");
		write("            ");
		if (e.getTypes().size() > 1) {
			if (!e.getName().contains("[x]"))
				throw new Exception("Element has multiple types as a choice doesn't have a [x] in the element name");
			write("<xs:choice minOccurs=\"0\">\r\n");
			if (e.hasDefinition()) {
				write("            <xs:annotation>\r\n");
				write("              <xs:documentation>"+Utilities.escapeXml(e.getDefinition())+"</xs:documentation>\r\n");
				write("            </xs:annotation>\r\n");
			}
			for (TypeDefn t : e.getTypes()) {
				String tn = encodeType(e, t, false);
				String n = e.getName().replace("[x]", tn.toUpperCase().substring(0, 1) + tn.substring(1));
				write("            <xs:element name=\""+n+"\" type=\""+encodeType(e, t, true)+"\"/>\r\n");
			}
			write("          </xs:choice>\r\n");
		} else {

			if (e.typeCode().startsWith("@"))
				write("<xs:element name=\""+e.getName()+"\" type=\""+e.typeCode().substring(1)+"\" ");
			else if (e.getTypes().size() == 0 && e.getElements().size() > 0)
			{
				int i = 0;
				String tn = root.getName()+"."+upFirst(e.getName())+ (i == 0 ? "" : Integer.toString(i));
//				while (typenames.contains(tn)) {
//					i++;
//					tn = root.getName()+"."+upFirst(e.getName())+ (i == 0 ? "" : Integer.toString(i));
//				}
				write("<xs:element name=\""+e.getName()+"\" type=\""+tn+"\" ");
				structures.put(tn, e);
				typenames.add(tn);
			}
			else if (e.getTypes().size() == 1)
				write("<xs:element name=\""+e.getName()+"\" type=\""+encodeType(e, e.getTypes().get(0), true)+"\" ");
			else
				throw new Exception("how do we get here?");

			write("minOccurs=\"0\"");
			write(" maxOccurs=\"unbounded\"");

			if (e.hasDefinition()) {					
				write(">\r\n");
				write("              <xs:annotation>\r\n");
				write("                <xs:documentation>"+Utilities.escapeXml(e.getDefinition())+"</xs:documentation>\r\n");
				write("              </xs:annotation>\r\n");
				write("            </xs:element>\r\n");
			}
			else
				write("/>\r\n");
		}
		write("          </xs:sequence>\r\n");
		write("        </xs:complexType>\r\n");

		write("      </xs:element>\r\n");
	}

	private void generateElement(ElementDefn root, ElementDefn e, String paramType) throws Exception {
		List<TypeDefn> types = e.getTypes();
		if (types.size() > 1 || (types.size() == 1 && types.get(0).getName().equals("*"))) {
			if (!e.getName().contains("[x]"))
				throw new Exception("Element has multiple types as a choice doesn't have a [x] in the element name '"+e.getName()+"' in resource "+root.getName());
      generateAny(root, e, e.getName().replace("[x]", ""));
//			write("<xs:choice>\r\n");
//			if (e.hasDefinition()) {
//				write("        <xs:annotation>\r\n");
//				write("          <xs:documentation>"+Utilities.escapeXml(e.getDefinition())+"</xs:documentation>\r\n");
//				write("        </xs:annotation>\r\n");
//			}
//			if (types.size() == 1)
//			  types = definitions.getKnownTypes();			
//			for (TypeDefn t : types) {
//			  if (!definitions.getInfrastructure().containsKey(t.getName())) {
//			    if (t.hasParams()) {
//			      for (String p : t.getParams()) {
//			        String tn = t.getName()+"_"+upFirst(p);
//			        String n = e.getName().replace("[x]", upFirst(tn));
//			        write("        <xs:element name=\""+n+"\" type=\""+tn+"\"/>\r\n");
//
//			      }			    
//			    } else {
//			      String tn = encodeType(e, t, false);
//			      String n = e.getName().replace("[x]", upFirst(tn));
//			      write("        <xs:element name=\""+n+"\" type=\""+encodeType(e, t, true)+"\"/>\r\n");
//			    }
//			  }
//			}
//			write("      </xs:choice>\r\n");
		} else {
	    write("      ");
			if ("extensions".equals(e.getName()))
				write("<xs:element name=\""+e.getName()+"\" type=\"Extensions\" ");
			else if ("xhtml".equals(e.getName()))
        write("<xs:element ref=\"xhtml:div\" ");
			else if (e.typeCode().startsWith("@"))
        write("<xs:element name=\""+e.getName()+"\" type=\""+e.typeCode().substring(1)+"\" ");
			else if (types.size() == 0 && e.getElements().size() > 0)
			{
				int i = 0;
				String tn = root.getName()+"."+upFirst(e.getName())+ (i == 0 ? "" : Integer.toString(i));
//				while (typenames.contains(tn)) {
//					i++;
//					tn = root.getName()+"."+upFirst(e.getName())+ (i == 0 ? "" : Integer.toString(i));
//				}
				write("<xs:element name=\""+e.getName()+"\" type=\""+tn+"\" ");
			  structures.put(tn, e);
				typenames.add(tn);
			}
			else if (types.size() == 1) {
			  if (types.get(0).getName().equals("[param]") && paramType != null)
	        write("<xs:element name=\""+e.getName()+"\" type=\""+paramType+"\" ");
			  else
			    write("<xs:element name=\""+e.getName()+"\" type=\""+encodeType(e, types.get(0), true)+"\" ");
			} else
				throw new Exception("how do we get here? "+e.getName()+" in "+root.getName()+" "+Integer.toString(types.size()));
			
      write("minOccurs=\""+e.getMinCardinality().toString()+"\"");
      if (e.unbounded())
        write(" maxOccurs=\"unbounded\"");
      else
        write(" maxOccurs=\"1\"");

			if (e.hasDefinition()) {
				write(">\r\n");
				write("        <xs:annotation>\r\n");
				write("          <xs:documentation>"+Utilities.escapeXml(e.getDefinition())+"</xs:documentation>\r\n");
				write("        </xs:annotation>\r\n");
				write("      </xs:element>\r\n");
			}
			else {
				write("/>\r\n");
			}
		}
	}


	private String upFirst(String name) {
		return name.toUpperCase().charAt(0)+name.substring(1);
	}

	private String encodeType(ElementDefn e, TypeDefn type, boolean params) throws Exception {
		if ("Resource".equals(type.getName()))
			return "ResourceReference";
		else if ("xml:ID".equalsIgnoreCase(type.getName())) 
		  return "id-simple";
		else if (params && definitions.getPrimitives().containsKey(type.getName()) && definitions.getPrimitives().get(type.getName()) instanceof PrimitiveType)
		  return "xs:"+((PrimitiveType) definitions.getPrimitives().get(type.getName())).getSchemaType();
		else if (type.getName().equals("code")) {
			String en = null;
			if (e.hasConceptDomain()) {
				BindingSpecification cd = definitions.getBindingByName(e.getBindingName());
				if (cd != null && cd.getBinding() == BindingSpecification.Binding.CodeList) {
					en = cd.getName();
					enums.add(en);
					return en;
				}
			}
			return "code-simple";

		} else if (!type.hasParams() || !params) {
		  if (params && definitions.getPrimitives().containsKey(type.getName()) && !e.unbounded())
	      return type.getName()+"-simple";
		  else
		    return type.getName();
		} else if (type.getParams().size() > 1)
			throw new Exception("multiple type parameters are only supported on resource ("+type.summary()+")");
		else
			return type.getName()+"_"+upFirst(type.getParams().get(0));
	}



  public void setDefinitions(Definitions definitions) {
    this.definitions = definitions;
  }
}
