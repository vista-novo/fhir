package org.hl7.fhir.utilities.tests;

import org.hl7.fhir.utilities.xhtml.XhtmlParser;

// todo: I should use DUnit - in a hurry, do it later

public class XhtmlParserTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new XhtmlParserTests().runTests();

	}
	
	public final static String IMPROPER_AMPERSAND = "<html><body><tag attribute=\"this&that\"></body></html>";

	public void runTests() {
		try {
			new XhtmlParser().parse(IMPROPER_AMPERSAND, "html");
			System.out.println("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
