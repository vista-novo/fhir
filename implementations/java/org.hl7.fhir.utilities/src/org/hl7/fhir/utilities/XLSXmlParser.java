package org.hl7.fhir.utilities;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XLSXmlParser {

  private static final String XLS_NS = "urn:schemas-microsoft-com:office:spreadsheet";

  public class Row extends ArrayList<String> {  private static final long serialVersionUID = 1L; }
  
  public class Sheet {
    public Row columns;
    public List<Row> rows = new ArrayList<Row>();

    public String getColumn(int row, String column) throws Exception {
      int c = -1;
      String s = "";
      for (int i = 0; i < columns.size(); i++) {
        s = s + ","+columns.get(i);
        if (columns.get(i).equalsIgnoreCase(column))
          c = i;
      }
      if (c == -1)
        return ""; // throw new Exception("unable to find column "+column+" in "+s.substring(1));
      else if (rows.get(row).size() <= c)
        return "";
      else
        return rows.get(row).get(c);
    }
  }
  
  private Map<String, Sheet> sheets;
  private Document xml;
  private String name;
  
  public XLSXmlParser(InputStream in, String name) throws Exception {
    this.name = name;
    xml = parseXml(in);
    sheets = new HashMap<String, Sheet>();
    readXml();
  }

  private Document parseXml(InputStream in) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse(in);
  }

  private void readXml() throws Exception {
    Element root = xml.getDocumentElement();
    check(root.getNamespaceURI().equals(XLS_NS), "Spreadsheet namespace incorrect");
    check(root.getNodeName().equals("Workbook"), "Spreadsheet element name incorrect");
    Node node = root.getFirstChild();
    while (node != null) {
      if (node.getNodeName().equals("Worksheet"))
        processWorksheet((Element)node);
      node = node.getNextSibling();
    }
  }
  
  private Integer rowIndex;
  private void processWorksheet(Element node) throws Exception {
    Sheet sheet = new Sheet();
    sheets.put(node.getAttributeNS(XLS_NS, "Name"), sheet);
    NodeList table = node.getElementsByTagNameNS(XLS_NS, "Table");
    check(table.getLength() == 1, "multiple table elements");
    NodeList rows = ((Element)table.item(0)).getElementsByTagNameNS(XLS_NS, "Row");
    check(rows.getLength() > 0, "empty sheet");
    rowIndex = 1;
    sheet.columns = readRow((Element) rows.item(0));
    for (int i = 1; i < rows.getLength(); i++) {
      rowIndex++;
      sheet.rows.add(readRow((Element) rows.item(i)));
    }
    
  }

  private Row readRow(Element row) throws Exception {
    Row res = new Row();
    int ndx = 1;    
    NodeList cells = row.getElementsByTagNameNS(XLS_NS, "Cell");
    for (int i = 0; i < cells.getLength(); i++) {
      Element cell = (Element) cells.item(i);
      if (cell.hasAttributeNS(XLS_NS, "Index")) {
        int index = Integer.parseInt(cell.getAttributeNS(XLS_NS, "Index"));
        while (ndx < index) {
          res.add("");
          ndx++;
        }
      }
      res.add(readData(cell, ndx, res.size() > 0 ? res.get(0) : "?"));
      ndx++;      
    }
    return res;
  }

  private String readData(Element cell, int col, String s) throws Exception {
    NodeList data = cell.getElementsByTagNameNS(XLS_NS, "Data");
    if (data.getLength() == 0)
      return "";
    check(data.getLength() == 1, "Multiple Data encountered ("+Integer.toString(data.getLength())+" @ col "+Integer.toString(col)+" - "+cell.getTextContent()+" ("+s+"))");
    Element d = (Element) data.item(0);
    String type = d.getAttributeNS(XLS_NS, "Type");
    if ("Boolean".equals(type)) {
      if (d.getTextContent().equals("1"))
        return "True";
      else
        return "False";
    } else if ("String".equals(type)) {
      return d.getTextContent();
    } else if ("Number".equals(type)) {
      return d.getTextContent();
    } else if ("DateTime".equals(type)) {
      return d.getTextContent();
    } else 
      throw new Exception("Cell Type is not known ("+d.getAttributeNodeNS(XLS_NS, "Type")+") in "+getLocation());
  }

  private void check(boolean test, String message) throws Exception {
    if (!test)
      throw new Exception(message+" in "+getLocation());
  }
  
  private String getLocation() {
    return name+", row "+rowIndex.toString();
  }

  public Map<String, Sheet> getSheets() {
    return sheets;
  }

  
}
