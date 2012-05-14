package org.hl7.fhir.instance.test;

import java.io.File;

public class SingleTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
      ResourceTest r = new ResourceTest();
      r.setSource(new File("C:\\workspace\\projects\\org.hl7.fhir\\publish\\person.xml"));
      r.test();
      System.out.println("Completed OK");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
