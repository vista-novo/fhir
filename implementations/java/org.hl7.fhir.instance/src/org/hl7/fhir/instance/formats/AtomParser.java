package org.hl7.fhir.instance.formats;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hl7.fhir.instance.model.AtomEntry;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.instance.model.ResourceReference;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.xmlpull.v1.XmlPullParser;

public class AtomParser extends XmlBase {
  public AtomFeed parse(InputStream input) throws Exception {
    XmlPullParser xpp = loadXml(input);
  
    if (!xpp.getNamespace().equals(ATOM_NS))
      throw new Exception("This does not appear to be an atom feed (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return parseAtom(xpp);
  }
  
  public AtomFeed parse(XmlPullParser xpp) throws Exception {
    if (!xpp.getNamespace().equals(ATOM_NS))
      throw new Exception("This does not appear to be an atom feed (wrong namespace '"+xpp.getNamespace()+"') (@ /)");
    return parseAtom(xpp);
  }

  private String parseString(XmlPullParser xpp) throws Exception {
    if (xpp.next() != XmlPullParser.TEXT)
      throw new Exception("No text in String");
    String res = xpp.getText();
    if (xpp.next() != XmlPullParser.END_TAG)
      throw new Exception("Bad String Structure");
    xpp.next();
    return res;
  }
  
  private AtomFeed parseAtom(XmlPullParser xpp) throws Exception {
    AtomFeed res = new AtomFeed();

    if (!xpp.getName().equals("feed"))
      throw new Exception("This does not appear to be an atom feed (wrong name '"+xpp.getName()+"') (@ /)");
    
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id"))
        res.setId(parseString(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("link"))
        res.setLink(parseString(xpp));
      else if(eventType == XmlPullParser.START_TAG && xpp.getName().equals("updated"))
        res.setUpdated(parseDate(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("entry"))
        res.getEntryList().add(parseEntry(xpp));
      else
        throw new Exception("Bad Xml parsing Agent");
      eventType = nextNoWhitespace(xpp);
    }

    return res;  
  }

  private AtomEntry parseEntry(XmlPullParser xpp) throws Exception {
    AtomEntry res = new AtomEntry();
    
    int eventType = nextNoWhitespace(xpp);
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("title")) {
        res.setTitle(parseString(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("id"))
        res.setId(parseString(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("link"))
        res.setLink(parseString(xpp));
      else if(eventType == XmlPullParser.START_TAG && xpp.getName().equals("updated"))
        res.setUpdated(parseDate(xpp));
      else if(eventType == XmlPullParser.START_TAG && xpp.getName().equals("published"))
        res.setPublished(parseDate(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("category"))
        res.setCategory(parseString(xpp));
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("author")) {
        eventType = nextNoWhitespace(xpp);
        while (eventType != XmlPullParser.END_TAG) {
          if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("name")) {
            res.setAuthorName(parseString(xpp));
          } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("uri"))
            res.setAuthorUri(parseString(xpp));
          else
            throw new Exception("Bad Xml parsing entry.author");
          eventType = nextNoWhitespace(xpp);
        }
      }
      else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("content")) {
        nextNoWhitespace(xpp);
        XmlParser p = new XmlParser();
        res.setResource(p.parse(xpp));
      } else if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("summary")) {
        nextNoWhitespace(xpp);
        res.setSummary(new XhtmlParser().parseHtmlNode(xpp));
      } else
        throw new Exception("Bad Xml parsing entry");
      eventType = nextNoWhitespace(xpp);
    }

    return res;  
  }

  private Date parseDate(XmlPullParser xpp) throws Exception {
    return xmlToDate(parseString(xpp));    
  }

}
