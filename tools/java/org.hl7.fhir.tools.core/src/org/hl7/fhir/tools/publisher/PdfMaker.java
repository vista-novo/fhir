package org.hl7.fhir.tools.publisher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;

import org.hl7.fhir.utilities.Utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * This is class that will take the BookMaker output and produce a PDF file based off of it.
 *   
 * @author Jean Duteau
 *
 */
public class PdfMaker {
	private PageProcessor page;
	
	public PdfMaker(PageProcessor page) {
		this.page = page;
	}

	public void produce() throws FileNotFoundException, Exception {
	    String target = page.getFolders().dstDir + File.separator;
	    
	    String src = Utilities.fileToString(target+"fhir-book.htm");
	    FileOutputStream pdfBook = new FileOutputStream(target+"fhir-book.pdf");
	    XMLWorkerHelper pdfMaker = XMLWorkerHelper.getInstance();
	    Document document = new Document();
	    PdfWriter writer = PdfWriter.getInstance(document, pdfBook);
	    document.open();

	    pdfMaker.parseXHtml(
	    		writer, 
	    		document, 
	    		new StringReader(src));
	    document.close();	    
	}
}
