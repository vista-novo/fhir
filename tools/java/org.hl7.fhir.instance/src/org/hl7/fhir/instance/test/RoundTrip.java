package org.hl7.fhir.instance.test;


public class RoundTrip {

  /**
   * @param args
   */
  public static void main(String[] args) {
//    File source = new CSFile(args[0]);
//    File dest = new CSFile(args[1]);
//    
//    FileInputStream in;
//    try {
//      in = new CSFileInputStream(source);
//      XmlParser p = new XmlParser();
//      ResourceOrFeed rf =  p.parseGeneral(in);
//      if (rf.getFeed() != null)
//        new AtomComposer().compose(new FileOutputStream(dest), rf.getFeed(), true);
//      else
//        new XmlComposer().compose(new FileOutputStream(dest), rf.getResource(), true);
//    } catch (Exception e) {
//      try {
//        TextFile.stringToFile(e.toString(), args[1]+".err");
//      } catch (Exception e1) {
//        e1.printStackTrace();
//      }
//    }
    System.out.println("Hello world");
  }

}
