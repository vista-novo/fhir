package org.hl7.fhir.instance.formats;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.instance.xhtml.*;
import org.hl7.fhir.tools.core.xml.*;

public abstract class XmlComposerBase extends XmlBase {
  
  protected IXMLWriter xml;
  
  public void compose(OutputStream stream, Resource resource, boolean pretty) throws Exception {
    XMLWriter writer = new XMLWriter(stream, "UTF-8");
    writer.setPretty(pretty);
    writer.start();
    compose(writer, resource);
    writer.close();
  }
  
  public void compose(IXMLWriter writer, Resource resource) throws Exception {
    xml = writer;
    xml.setDefaultNamespace(FHIR_NS);
    composeResource(resource);
  }

  protected abstract void composeResource(Resource resource) throws Exception;
  
  protected void composeElementAttributes(Element element) throws Exception {
    if (element.getXmlId() != null) 
      xml.attribute("xml:Id", element.getXmlId());
  }

  protected void composeTypeAttributes(Type type) throws Exception {
    composeElementAttributes(type);
    if (type.getDataAbsentReason() != null) 
      xml.attribute("dataAbsentReason", type.getDataAbsentReason().toCode());
  }
  
  protected void composeResourceReference(String name, ResourceReference value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.open(FHIR_NS, name);
      composeString("type", value.getType());
      composeString("id", value.getId());
      composeString("version", value.getVersion());
      composeString("text", value.getText());
      xml.close(FHIR_NS, name);
    }    
  }
  
  protected void composeString(String name, String value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value);
  }
  protected void composeUri(String name, java.net.URI value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value.toString());
  }
  
  protected void composeBigDecimal(String name, BigDecimal value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value.toString());
  }
  

  protected void composeInt(String name, int value) throws Exception {
    xml.element(FHIR_NS, name, java.lang.Integer.toString(value));
  }

  protected void composeBool(String name, boolean value) throws Exception {
    xml.element(FHIR_NS, name, java.lang.Boolean.toString(value));
  }
  
  protected void composeXhtml(String name, XhtmlNode html) throws Exception {
  }
  
  protected void composeBytes(String name, byte[] content) {
  }  

  protected void composeBase64Binary(String name, Base64Binary value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      // xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeId(String name, Id value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeCode(String name, Code value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeOid(String name, Oid value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeUuid(String name, Uuid value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeSid(String name, Sid value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue().toString());
    }
  }

  protected void composeUri(String name, Uri value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue().toString());
    }
  }

  protected void composeDecimal(String name, Decimal value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue().toString());
    }
  }
  
  protected void composeString_(String name, String_ value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeBoolean(String name, Boolean value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeInstant(String name, Instant value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, new SimpleDateFormat("YYYY-MM-DDTHH:NN:SS").format(value.getValue()));
    }
  }
  
  protected void composeInteger(String name, Integer value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, java.lang.Integer.toString(value.getValue()));
    }
  }
  
  protected void composeDate(String name, Date value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeDateTime(String name, DateTime value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
}
