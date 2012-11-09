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
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.instance.model.*;
import org.hl7.fhir.instance.model.Boolean;
import org.hl7.fhir.instance.model.Integer;
import org.hl7.fhir.utilities.xhtml.*;
import org.hl7.fhir.utilities.xml.*;
import org.json.JSONWriter;

public abstract class JsonComposerBase extends XmlBase {
  
  protected JSONWriter json;
  private boolean htmlPretty;
  
  public void compose(OutputStream stream, Resource resource) throws Exception {
    OutputStreamWriter osw = new OutputStreamWriter(stream, "UTF-8");
    JSONWriter writer = new JSONWriter(osw);
    // writer.setPretty(pretty);
    writer.object();
    compose(writer, resource);
    writer.endObject();
    osw.flush();
  }
  
  public void compose(OutputStream stream, AtomFeed feed) throws Exception {
    OutputStreamWriter osw = new OutputStreamWriter(stream, "UTF-8");
    JSONWriter writer = new JSONWriter(osw);
    // writer.setPretty(pretty);
    writer.object();
    compose(writer, feed);
    writer.endObject();
    osw.flush();
  }
  
  public void compose(JSONWriter writer, Resource resource) throws Exception {
    json = writer;
    composeResource(resource);
  }

  public void compose(JSONWriter writer, AtomFeed feed) throws Exception {
    json = writer;
    composeFeed(feed);
  }

  private void composeFeed(AtomFeed feed) throws Exception {
    prop("title", feed.getTitle());
    if (feed.getUpdated() != null)
      prop("updated", dateToXml(feed.getUpdated()));
    prop("id", feed.getId());

    if (feed.getLink() != null) {
      openArray("links");
      json.object();
      prop("rel", "self");
      prop("href", feed.getLink());
      json.endObject();
      closeArray();
    }
    if (feed.getEntryList().size() > 0) {
      openArray("entries");
      for (AtomEntry e : feed.getEntryList())
        composeEntry(e);
      closeArray();
    }
  }

  private void composeEntry(AtomEntry e) throws Exception {
    json.object();
    prop("title", e.getTitle());
    prop("id", e.getId());
    prop("versionId", e.getVersionId());
    if (e.getLink() != null) {
      openArray("links");
      json.object();
      prop("rel", "self");
      prop("href", e.getLink());
      json.endObject();
      closeArray();
    }

    if (e.getUpdated() != null)
      prop("updated", dateToXml(e.getUpdated()));
    if (e.getPublished() != null) 
      prop("published", dateToXml(e.getPublished()));

    openArray("authors");
    json.object();
    prop("name", e.getAuthorName());
    prop("uri", e.getAuthorUri());
    json.endObject();
    closeArray();

    if (e.getCategory() != null) {
      openArray("categories");
      json.object();
      prop("term", e.getCategory());
      prop("scheme", "http://hl7.org/fhir/resource-types");
      json.endObject();
      closeArray();
    }

    open("content");
    composeResource(e.getResource());
    close();
    composeXhtml("summary", e.getSummary());
    json.endObject();  
    
  }

  protected abstract void composeResource(Resource resource) throws Exception;
  
  protected void composeElementAttributes(Element element) throws Exception {
    if (element.getXmlId() != null) 
      prop("_id", element.getXmlId());
  }

  private void prop(String name, String value) throws Exception {
    if (name != null)
      json.key(name);
    json.value(value);
  }

  protected void composeTypeAttributes(Type type) throws Exception {
    composeElementAttributes(type);
  }
    
  protected void composeString(String name, String value) throws Exception {
    if (value != null)
      prop(name, value);
  }
  protected void composeURI(String name, java.net.URI value) throws Exception {
    if (value != null)
      prop(name, value.toString());
  }
  
  protected void composeBigDecimal(String name, BigDecimal value) throws Exception {
    if (value != null)
      prop(name, value.toString());
  }
  

  protected void composeInt(String name, java.lang.Integer value) throws Exception {
    if (value != null)
      prop(name, value.toString());
  }

  protected void composeBool(String name, java.lang.Boolean value) throws Exception {
    if (value != null)
      prop(name, value.toString());
  }
  
  protected void composeXhtml(String name, XhtmlNode html) throws Exception {
    XhtmlComposer comp = new XhtmlComposer();
    comp.setPretty(htmlPretty);
    prop(name, comp.compose(html));
  }
  
  protected void composeBytes(String name, byte[] content) throws Exception {
    if (content != null) {
      byte[] encodeBase64 = Base64.encodeBase64(content);
      composeString(name, new String(encodeBase64));
    }
  }  

  protected void composeBase64Binary(String name, Base64Binary value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      composeBytes(name, value.getValue());
      close();
    }
  }
  
  protected void composeId(String name, Id value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue());
      close();
    }
  }
  
  protected void composeCode(String name, Code value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue());
      close();
    }
  }
  
  protected void composeOid(String name, Oid value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue());
      close();
    }
  }
  
  protected void composeUuid(String name, Uuid value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue());
      close();
    }
  }
  
  protected void composeSid(String name, Sid value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue().toString());
      close();
    }
  }

  protected void composeUri(String name, Uri value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue().toString());
      close();
    }
  }

  protected void composeUri(String name, java.net.URI value) throws Exception {
    composeURI(name, value);
  }


  protected void composeDecimal(String name, Decimal value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue().toString());
      close();
    }
  }
  
  protected void composeString_(String name, String_ value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue());
      close();
    }
  }
  
  protected void composeBoolean(String name, Boolean value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.toString());
      close();
    }
  }
  
  protected void composeBoolean(String name, java.lang.Boolean value) throws Exception {
    if (value != null) {
      open(name);
      prop(name, value.toString());
      close();
    }
  }
  
  protected void composeInstant(String name, Instant value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, dateToXml(value.getValue()));
      close();
    }
  }
  
  protected void composeInteger(String name, Integer value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, java.lang.Integer.toString(value.getValue()));
      close();
    }
  }
  
  protected void composeDate(String name, java.util.Calendar value) throws Exception {
	  if (value != null) {
	      prop(name, dateToXml(value));
	  }
  }
	  
  protected void composeDate(String name, Date value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue());
      close();
    }
  }
  
  protected void composeDateTime(String name, DateTime value) throws Exception {
    if (value != null) {
      open(name);
      composeTypeAttributes(value);
      prop(name, value.getValue());
      close();
    }
  }
  
  protected void open(String name) throws Exception {
    if (name != null) 
      json.key(name);
    json.object();
  }
  
  protected void close() throws Exception {
    json.endObject();
  }
  
  protected void openArray(String name) throws Exception {
    if (name != null) 
      json.key(name);
    json.array();
  }
  
  protected void closeArray() throws Exception {
    json.endArray();
  }
  
}
