package org.hl7.fhir.instance.formats;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import org.hl7.fhir.instance.model.AtomEntry;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xml.IXMLWriter;
import org.hl7.fhir.utilities.xml.XMLWriter;

public class AtomComposer extends XmlBase {
  private IXMLWriter xml;

  public void compose(OutputStream stream, AtomFeed feed, boolean pretty) throws Exception {
    XMLWriter writer = new XMLWriter(stream, "UTF-8");
    writer.setPretty(pretty);
    writer.start();
    compose(writer, feed);
    writer.close();
  }
  
  public void compose(IXMLWriter writer, AtomFeed feed) throws Exception {
    xml = writer;
    xml.setDefaultNamespace(ATOM_NS);
    composeFeed(feed);
  }

  private void composeFeed(AtomFeed feed) throws Exception {
    xml.open(ATOM_NS, "feed");
    if (feed.getTitle() != null)
      xml.element(ATOM_NS, "title", feed.getTitle());
    if (feed.getUpdated() != null)
      xml.element(ATOM_NS, "updated", new SimpleDateFormat("YYYY-MM-DDTHH:NN:SSZ").format(feed.getUpdated()));
    if (feed.getId() != null)
      xml.element(ATOM_NS, "id", feed.getId());
    if (feed.getLink() != null)
      xml.element(ATOM_NS, "link", feed.getLink());
    for (AtomEntry e : feed.getEntryList())
      composeEntry(e);
    xml.close(ATOM_NS, "feed");
  }

  private void composeEntry(AtomEntry e) throws Exception  {
    if (e.getVersionId() != null) {
      xml.namespace(GDATA_NS, "gd");
      xml.attribute(GDATA_NS, "etag", e.getVersionId());
    }
    
    xml.open(ATOM_NS, "entry");
    if (e.getTitle() != null)
      xml.element(ATOM_NS, "title", e.getTitle());
    if (e.getLink() != null) {
      xml.attribute("href", e.getLink());
      xml.element(ATOM_NS, "link", null);
    }
    if (e.getId() != null)
      xml.element(ATOM_NS, "id", e.getId());
    if (e.getUpdated() != null)
      xml.element(ATOM_NS, "updated", dateToXml(e.getUpdated()));
    if (e.getPublished() != null)
      xml.element(ATOM_NS, "published", dateToXml(e.getPublished()));
    xml.open(ATOM_NS, "author");
    if (e.getAuthorName() != null)
      xml.element(ATOM_NS, "name", e.getAuthorName());
    if (e.getAuthorUri() != null)
      xml.element(ATOM_NS, "uri", e.getAuthorUri());
    xml.close(ATOM_NS, "author");
    if (e.getCategory() != null) {      
      xml.attribute("term", e.getCategory());
      xml.attribute("scheme", "http://hl7.org/fhir/sid/fhir/resource-types");
      xml.element(ATOM_NS, "category", null);
    }

    xml.attribute("type", "text/xml");
    xml.open(ATOM_NS, "content");
    xml.namespace(FHIR_NS, null);
    new XmlComposer().compose(xml, e.getResource());
    xml.close(ATOM_NS, "content");
    
    xml.attribute("type", "xhtml");
    xml.open(ATOM_NS, "summary");
    xml.namespace(XhtmlComposer.XHTML_NS, null);
    new XhtmlComposer().compose(xml, e.getSummary());
    xml.close(ATOM_NS, "summary");
    
    xml.close(ATOM_NS, "entry");
  }
}
