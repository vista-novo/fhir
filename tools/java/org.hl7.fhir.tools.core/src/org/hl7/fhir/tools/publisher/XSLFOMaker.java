package org.hl7.fhir.tools.publisher;

import java.io.File;

import net.sf.saxon.Transform;


public class XSLFOMaker {
	/**
	 * This is class that will take the BookMaker output and produce a XSL-FO version of it.
	 * This uses a generic XHTML to XSL-FO transform to do its dirty work.
	 *   
	 * @author Jean Duteau
	 *
	 */
	private PageProcessor page;
	
	public XSLFOMaker(PageProcessor page) {
		this.page = page;
	}

	public void produce() {
	    String target = page.getFolders().dstDir + File.separator;
	    String transformDir = page.getFolders().javaDir;
	    
	    new Transform().doTransform(new String[] {"-o:"+target+"fhir-book.xmlfo", "-s:"+target+"fhir-book.htm", "-xsl:" + transformDir + "xhtml2fo.xsl"}, "");
	}

}
