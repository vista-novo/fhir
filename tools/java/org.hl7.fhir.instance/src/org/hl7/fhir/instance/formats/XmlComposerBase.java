package org.hl7.fhir.instance.formats;

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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.utilities.xhtml.*;
import org.hl7.fhir.utilities.xml.*;

public abstract class XmlComposerBase extends XmlBase {
  
  protected IXMLWriter xml;
  private boolean htmlPretty;
  
  public void compose(OutputStream stream, Resource resource, boolean pretty) throws Exception {
    XMLWriter writer = new XMLWriter(stream, "UTF-8");
    writer.setPretty(pretty);
    writer.start();
    compose(writer, resource, pretty);
    writer.close();
  }
  
  public void compose(OutputStream stream, Resource resource, boolean pretty, boolean htmlPretty) throws Exception {
    XMLWriter writer = new XMLWriter(stream, "UTF-8");
    writer.setPretty(pretty);
    writer.start();
    compose(writer, resource, htmlPretty);
    writer.close();
  }
  
  public void compose(IXMLWriter writer, Resource resource, boolean htmlPretty) throws Exception {
    this.htmlPretty = htmlPretty;
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
  }
    
  protected void composeString(String name, String value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value);
  }
  
  protected void composeURI(String name, java.net.URI value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value.toString());
  }
  
  protected void composeUri(String name, java.net.URI value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, value.toString());
    }
  }  
  protected void composeBigDecimal(String name, BigDecimal value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value.toString());
  }
  
  protected void composeDecimal(String name, BigDecimal value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, value.toString());
    }
  }
  

  protected void composeInt(String name, java.lang.Integer value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value.toString());
  }

  protected void composeInteger(String name, java.lang.Integer value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, java.lang.Integer.toString(value));
    }
  }
  
  protected void composeBool(String name, java.lang.Boolean value) throws Exception {
    if (value != null)
      xml.element(FHIR_NS, name, value.toString());
  }
  
  protected void composeXhtml(String name, XhtmlNode html) throws Exception {
    XhtmlComposer comp = new XhtmlComposer();
    // name is also found in the html and should the same
    // ? check that
    boolean oldPretty = xml.isPretty();
    xml.setPretty(htmlPretty);
    xml.namespace(XhtmlComposer.XHTML_NS, null);
    comp.compose(xml, html);
    xml.setPretty(oldPretty);
  }
  
  protected void composeBytes(String name, byte[] content) throws Exception {
    if (content != null) {
      byte[] encodeBase64 = Base64.encodeBase64(content);
      composeString(name, new String(encodeBase64));
    }
  }  

  protected void composeBase64Binary(String name, Base64Binary value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      composeBytes(name, value.getValue());
    }
  }
  
  protected void composeBase64Binary(String name, byte[] value) throws Exception {
    composeBytes(name, value);
  }
  
  
  protected void composeId(String name, Id value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeId(String name, String value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, value);
    }
  }
  
  
  protected void composeCode(String name, Code value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, value.getValue());
    }
  }
  
  protected void composeCode(String name, String value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, value);
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
      xml.element(FHIR_NS, name, java.lang.Boolean.toString(value.getValue()));
    }
  }
  
  protected void composeBoolean(String name, java.lang.Boolean value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, value.toString());
    }
  }
    
  protected void composeInstant(String name, Instant value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, dateToXml(value.getValue()));
    }
  }
  
  protected void composeInteger(String name, Integer value) throws Exception {
    if (value != null) {
      composeTypeAttributes(value);
      xml.element(FHIR_NS, name, java.lang.Integer.toString(value.getValue()));
    }
  }
  
  protected void composeDate(String name, java.util.Calendar value) throws Exception {
	  if (value != null) {
	      xml.element(FHIR_NS, name, dateToXml(value));
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

    protected void composeDateTime(String name, String value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, value);
    }
  }

  protected void composeString_(String name, String value) throws Exception {
    if (value != null) {
      xml.element(FHIR_NS, name, value);
    }
  }
  
  
}
