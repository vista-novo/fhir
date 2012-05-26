package org.hl7.fhir.tools.publisher;

import java.io.File;
import java.io.FileOutputStream;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.ZipGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlDocument;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class WebMaker {

  private FolderManager folders;
  private String version;
  
  
  public WebMaker(FolderManager folders, String version) {
    super();
    this.folders = folders;
    this.version = version;
  }

  public void produceHL7Copy() throws Exception {
    Utilities.clearDirectory(folders.rootDir+"temp"+File.separator+"hl7"+File.separator+"dload");
    Utilities.clearDirectory(folders.rootDir+"temp"+File.separator+"hl7"+File.separator+"web");
    String[] files = new File(folders.dstDir).list();
    for (String f : files) {
      if (f.endsWith(".htm")) {
        String src = Utilities.fileToString(folders.dstDir+f);
        int i = src.indexOf("</body>");
        if (i > 0)
          src = src.substring(0, i) + google()+src.substring(i);
//        try {
          XhtmlDocument doc = new XhtmlParser().parse(src);
          replaceDownloadUrls(doc);
          new XhtmlComposer().compose(new FileOutputStream(folders.rootDir+"temp"+File.separator+"hl7"+File.separator+"web"+File.separator+f), doc);
//        } catch (Exception e) {
//          throw new Exception("exception processing: "+src+": "+e.getMessage());
//        }
      } else if (f.endsWith(".chm") || f.endsWith(".eap") || f.endsWith(".zip")) 
        Utilities.copyFile(new File(folders.dstDir+f), new File(folders.rootDir+"temp"+File.separator+"hl7"+File.separator+"dload"+File.separator+f));
      else if (!f.matches(Config.VERSION_REGEX))
        Utilities.copyFile(new File(folders.dstDir+f), new File(folders.rootDir+"temp"+File.separator+"hl7"+File.separator+"web"+File.separator+f));
    }

    File f = new File(folders.rootDir+"archive"+File.separator+"fhir-web-"+version+".zip");
    if (f.exists())
      f.delete();
    ZipGenerator zip = new ZipGenerator(folders.rootDir+"archive\\fhir-hl7-"+version+"-web.zip");
    zip.addFiles(folders.rootDir+"temp"+File.separator+"hl7"+File.separator+"web"+File.separator, "", null);
    zip.addFiles(folders.dstDir+"v"+version+File.separator, "v"+version+File.separator, null);
    zip.close();  
    zip = new ZipGenerator(folders.rootDir+"archive"+File.separator+"fhir-hl7-"+version+"-dload.zip");
    zip.addFiles(folders.rootDir+"temp"+File.separator+"hl7"+File.separator+"dload"+File.separator, "", null);
    zip.addFiles(folders.dstDir+"v"+version+File.separator+"bin"+File.separator, "v"+version+File.separator, null);
    zip.close();  
    
  }

  private void replaceDownloadUrls(XhtmlNode node) {
    if (node.getNodeType() == NodeType.Document || node.getNodeType() == NodeType.Element) {
      if ("a".equals(node.getName()) && node.getAttributes().containsKey("href")) {
        String s = node.getAttributes().get("href");
        String sl = s.toLowerCase();
        if (sl.endsWith(".chm") || sl.endsWith(".eap") || sl.endsWith(".zip")) 
          node.getAttributes().put("href", "/documentcenter/public/standards/FHIR/"+s);
      }
      for (XhtmlNode child : node.getChildNodes()) 
        replaceDownloadUrls(child);
    }
    
  }

  private String google() {
    return
        "<script src=\"/includes/GoogleAnalyticsAddFileTracking.js\" type=\"text/javascript\"></script>\r\n"+
        "<script type=\"text/javascript\">\r\n"+
        "  var _gaq = _gaq || [];\r\n"+
        "  _gaq.push(['_setAccount', 'UA-676355-1']);\r\n"+
        "  _gaq.push(['_setDomainName', '.hl7.org']);\r\n"+
        "  _gaq.push(['_trackPageview']);\r\n"+
        "  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();\r\n"+
        "</script>\r\n";
  }


}
