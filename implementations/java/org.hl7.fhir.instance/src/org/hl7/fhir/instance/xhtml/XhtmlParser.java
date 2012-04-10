package org.hl7.fhir.instance.xhtml;

import org.xmlpull.v1.XmlPullParser;

public class XhtmlParser {

  private XmlPullParser xpp;

  public XhtmlParser(XmlPullParser xpp) {
    super();
    this.xpp = xpp;
  }

  public XhtmlNode parseHtmlNode() throws Exception {
    XhtmlNode res = new XhtmlNode();
    res.setNodeType(NodeType.Element);
    res.setName(xpp.getName());
    
    int eventType = xpp.next();
    while (eventType != XmlPullParser.END_TAG) {
      if (eventType == XmlPullParser.TEXT) {
        res.addText(xpp.getText());
        xpp.next();
      } else if (eventType == XmlPullParser.COMMENT) {
        res.addComment(xpp.getText());
        xpp.next();
      } else if (eventType == XmlPullParser.START_TAG)
        res.getChildNodes().add(parseHtmlNode());
      else
        throw new Exception("Unhandled XHTML feature: "+Integer.toString(eventType));
      eventType = xpp.getEventType();
    }
    xpp.next();
    return res;
  }  
  
}
