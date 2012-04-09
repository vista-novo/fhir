package org.hl7.fhir.tools.core.xml;

import java.io.*;

import org.w3c.dom.*;

public class XhtmlGenerator {

	public void generate(Document doc, File xhtml, String name) throws Exception {
		FileOutputStream outs = new FileOutputStream(xhtml);
		OutputStreamWriter out = new OutputStreamWriter(outs);
		
		out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n");
		out.write("<head>\r\n");
		out.write(" <title>Example Instance for "+name+"</title>\r\n");
		out.write(" <link rel=\"Stylesheet\" href=\"test.css\" type=\"text/css\" media=\"screen\"/>\r\n");
		out.write("</head>\r\n");
		out.write("<body>\r\n");
		out.write("<pre class=\"xml\">\r\n");

		for (int i = 0; i < doc.getChildNodes().getLength(); i++)
			writeNode(out, doc.getChildNodes().item(i));
		
		out.write("</pre>\r\n");
		out.write("</body>\r\n");
		out.write("</html>\r\n");
		out.flush();
		outs.close();
	}

	private void writeNode(OutputStreamWriter out, Node node) throws Exception {
		if (node.getNodeType() == Node.ELEMENT_NODE)
			writeElement(out, (Element) node);
		else if (node.getNodeType() == Node.TEXT_NODE)
			writeText(out, (Text) node);
		else if (node.getNodeType() == Node.COMMENT_NODE)
			writeComment(out, (Comment) node);
		else if (node.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE)
			writeProcessingInstruction(out, (ProcessingInstruction) node);
		else if (node.getNodeType() != Node.ATTRIBUTE_NODE)
			throw new Exception("Unhandled node type");
	}

	private void writeProcessingInstruction(OutputStreamWriter out, ProcessingInstruction node) {
		
		
	}

	private void writeComment(OutputStreamWriter out, Comment node) throws DOMException, IOException {
		out.write("<span class=\"xmlcomment\">&lt;!-- "+node.getTextContent()+" --&gt;</span>");
	}

	private void writeText(OutputStreamWriter out, Text node) throws DOMException, IOException {
		out.write("<b>"+escapeHtml(node.getTextContent())+"</b>");
	}

	private void writeElement(OutputStreamWriter out, Element node) throws Exception {
		out.write("<span class=\"xmltag\">&lt;"+node.getNodeName()+"</span>");
		if (node.hasAttributes()) {
			out.write("<span class=\"xmlattr\">");
			for (int i = 0; i < node.getAttributes().getLength(); i++) {
				out.write(" "+node.getAttributes().item(i).getNodeName()+"=\""+escapeHtml(node.getAttributes().item(i).getTextContent())+"\"");
			}
			out.write("</span>");
	
		}
		if (node.hasChildNodes()) {
			out.write("<span class=\"xmltag\">&gt;</span>");
			for (int i = 0; i < node.getChildNodes().getLength(); i++)
				writeNode(out, node.getChildNodes().item(i));
			
			out.write("<span class=\"xmltag\">&lt;/"+node.getNodeName()+"&gt;</span>");
		}
		else 
			out.write("<span class=\"xmltag\">/&gt;</span>");
	}
	
	private String escapeHtml(String doco) {
		if (doco == null)
			return "";
		
		StringBuilder b = new StringBuilder();
		for (char c : doco.toCharArray()) {
		  if (c == '<')
			  b.append("&lt;");
		  else if (c == '<')
			  b.append("&gt;");
		  else if (c == '&')
			  b.append("&amp;");
		  else if (c == '\t')
			  b.append("  ");
		  else if (c == '\'')
			  b.append("&apos;");
		  else if (c == '"')
			  b.append("&quot;");
		  else 
			  b.append(c);
		}		
		return b.toString();
	}	
}
