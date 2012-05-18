package org.hl7.fhir.tools.publisher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.generators.specification.DictHTMLGenerator;
import org.hl7.fhir.definitions.generators.specification.DictXMLGenerator;
import org.hl7.fhir.definitions.generators.specification.ProfileGenerator;
import org.hl7.fhir.definitions.generators.specification.TerminologyNotesGenerator;
import org.hl7.fhir.definitions.generators.specification.XmlSpecGenerator;
import org.hl7.fhir.definitions.generators.xsd.SchemaGenerator;
import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.EventDefn;
import org.hl7.fhir.definitions.model.EventUsage;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.TypeDefn;
import org.hl7.fhir.definitions.parsers.SourceParser;
import org.hl7.fhir.definitions.parsers.TypeParser;
import org.hl7.fhir.definitions.validation.ModelValidator;
import org.hl7.fhir.definitions.validator.ProfileValidator;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.model.Constraint;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.tools.publisher.implementations.CSharpGenerator;
import org.hl7.fhir.tools.publisher.implementations.DelphiGenerator;
import org.hl7.fhir.tools.publisher.implementations.ECoreOclGenerator;
import org.hl7.fhir.tools.publisher.implementations.JavaGenerator;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.ZipGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlDocument;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.hl7.fhir.utilities.xml.JsonGenerator;
import org.hl7.fhir.utilities.xml.XhtmlGenerator;
import org.hl7.fhir.utilities.xml.XmlGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * This is the entry point for the publication method for FHIR
 * The general order of publishing is 
 *   Check that everything we expect to find is found
 *   Load the definitions
 *   Produce the specification
 *     1. reference implementations
 *     2. schemas
 *     4. final specification
 *   Validate the XML
 *   
 * @author Grahame
 *
 */
public class Publisher implements Logger {
  public String version;
  public Date genDate;

  private FolderManager folders;
	private IniFile ini;

	private Definitions definitions;
  private SourceParser prsr;
  private List<PlatformGenerator> referenceImplementations = new ArrayList<PlatformGenerator>();
  private Map<String, XhtmlDocument> pages = new HashMap<String, XhtmlDocument>();
  private List<Section> sections;

 
  private HashMap<String, HashMap<String, String>> keywords = new HashMap<String, HashMap<String, String>>();
  private boolean isInternal;
  
	public static void main(String[] args) throws Exception {
//    
	  Publisher pub = new Publisher();
	  pub.isInternal = !(args.length > 1 && args[1] == "-web");
		pub.execute(args[0]);
	}

	public void execute(String folder) throws Exception {
	  
	  log("Publish FHIR in folder "+folder+ (isInternal ? " [internal development mode - including the sandbox, not generating HL7 web site copy or fhir.chm]" : ""));

	  registerReferencePlatforms();
	  
		if (initialize(folder)) {
	    prsr.parse(isInternal);
			validate();
			produceSpecification();
			validateXml();
			System.out.println("Finished publishing FHIR");
		}
	}

  private void registerReferencePlatforms() {
    referenceImplementations.add(new DelphiGenerator());
    referenceImplementations.add(new JavaGenerator());
    referenceImplementations.add(new CSharpGenerator());
    referenceImplementations.add(new ECoreOclGenerator());
  }

  private void registerKeyWord(String word, String filename, String title) {
    word = word.trim();
    if (!filename.endsWith(".htm"))
      filename = filename + ".htm";
    HashMap<String, String> entry = keywords.get(word);
    if (entry == null) {
      entry = new HashMap<String, String>();
      keywords.put(word,  entry);
    }
    if (!entry.containsKey(filename)) 
      entry.put(filename, title);
  }
  
  private boolean	initialize(String folder) throws Exception {
	  definitions = new Definitions();
	  folders = new FolderManager(folder);

	  System.out.println("Checking Source");

	  List<String> errors = new ArrayList<String>();

	  Utilities.checkFolder(folders.rootDir, errors);
	  if (Utilities.checkFile("required", folders.rootDir, "publish.ini", errors)) {
	    ini = new IniFile(folders.rootDir+ "publish.ini");
	    version = ini.getStringProperty("FHIR", "version");
      genDate = new Date(); 
	    
	    prsr = new SourceParser((Logger) this, folder, definitions);
	    prsr.checkConditions(errors);

	    Utilities.checkFolder(folders.xsdDir, errors);
	    for (PlatformGenerator gen : referenceImplementations) 
	      Utilities.checkFolder(folders.implDir(gen.getName()), errors);
	    Utilities.checkFolder(folders.umlDir, errors);
	    Utilities.checkFile("required", folders.srcDir, "fhir-all.xsd", errors);
      Utilities.checkFile("required", folders.srcDir, "header.htm", errors);
      Utilities.checkFile("required", folders.srcDir, "footer.htm", errors);
	    Utilities.checkFile("required", folders.srcDir, "sidebar.htm", errors);
	    Utilities.checkFile("required", folders.srcDir, "template.htm", errors);
	    Utilities.checkFile("required", folders.srcDir, "template-print.htm", errors);
	    Utilities.checkFolder(folders.dstDir, errors);

	    for (String n : ini.getPropertyNames("support"))
	      Utilities.checkFile("support", folders.srcDir, n, errors);
	    for (String n : ini.getPropertyNames("images"))
	      Utilities.checkFile("image", folders.imgDir, n, errors);
	    for (String n : ini.getPropertyNames("schema"))
	      Utilities.checkFile("schema", folders.srcDir, n, errors);
	    for (String n : ini.getPropertyNames("pages"))
	      Utilities.checkFile("page", folders.srcDir, n, errors);

	  }
	  if (errors.size() > 0)
	    System.out.println("Unable to publish FHIR specification:");
	  for (String e : errors) {
	    System.out.println(e);
	  }
	  return errors.size() == 0;
	}


	private boolean validate() throws Exception {
    log("Validating");
		ModelValidator val = new ModelValidator(definitions);

		List<String> errors = new ArrayList<String>();
		for (String n : definitions.getDefinedResources().keySet())
			errors.addAll(val.check(n, definitions.getDefinedResources().get(n)));

		for (String e : errors)
			System.out.println(e);
		return errors.size() == 0;			
	}

  private void produceSpecification() throws Exception {
    sections = new ArrayList<Section>();
    for (ElementDefn root : definitions.getDefinedResources().values())
      registerElementDefnInIndex(root, root.getName().toLowerCase()+".htm", root.getName());
    for (ElementDefn root : definitions.getInfrastructure().values())
      registerElementDefnInIndex(root, "xml.htm", root.getName());
    for (ElementDefn root : definitions.getTypes().values())
      registerElementDefnInIndex(root, "datatypes.htm", root.getName());
    for (DefinedCode c : definitions.getPrimitives().values())
      registerKeyWord(c.getCode(), "datatypes.htm", "Data Types");

    parseSidebar(sections);

    for (PlatformGenerator gen : referenceImplementations)
    {
      log("Produce "+gen.getName()+" Reference Implementation");
      gen.generate(definitions, folders.dstDir, folders.implDir(gen.getName()), version, genDate, this);
    }
    log("Produce Schemas");
    new SchemaGenerator().generate(definitions, ini, folders.tmpResDir, folders.xsdDir, folders.dstDir, folders.srcDir, version, Config.DATE_FORMAT().format(genDate));
    produceSchemaZip();
    log("Produce Specification");
    produceSpec(); 
    if (!isInternal) {
      produceCHM();
      produceHL7Copy();
    }
  }

  
	private void produceHL7Copy() throws Exception {
	  log("Produce HL7 copy");
    Utilities.clearDirectory(folders.rootDir+"temp\\hl7\\dload");
    Utilities.clearDirectory(folders.rootDir+"temp\\hl7\\web");
    String[] files = new File(folders.dstDir).list();
    for (String f : files) {
      if (f.endsWith(".htm")) {
        String src = Utilities.fileToString(folders.dstDir+f);
        int i = src.indexOf("</body>");
        if (i > 0)
          src = src.substring(0, i) + google()+src.substring(i);
        XhtmlDocument doc = new XhtmlParser().parse(src);
        replaceDownloadUrls(doc);
        new XhtmlComposer().compose(new FileOutputStream(folders.rootDir+"temp\\hl7\\web\\"+f), doc);
      } else if (f.endsWith(".chm") || f.endsWith(".eap") || f.endsWith(".zip")) 
        Utilities.copyFile(new File(folders.dstDir+f), new File(folders.rootDir+"\\temp\\hl7\\dload\\"+f));
      else
        Utilities.copyFile(new File(folders.dstDir+f), new File(folders.rootDir+"\\temp\\hl7\\web\\"+f));
    }

    File f = new File(folders.rootDir+"archive\\fhir-web-"+version+".zip");
    if (f.exists())
      f.delete();
    ZipGenerator zip = new ZipGenerator(folders.rootDir+"archive\\fhir-hl7-"+version+"-web.zip");
    zip.addFiles(folders.rootDir+"temp\\hl7\\web\\", "", null);
    zip.close();  
    zip = new ZipGenerator(folders.rootDir+"archive\\fhir-hl7-"+version+"-dload.zip");
    zip.addFiles(folders.rootDir+"temp\\hl7\\dload\\", "", null);
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

  private void produceCHM() throws Exception {
    String hhc = "C:\\Program Files (x86)\\HTML Help Workshop\\hhc.exe";
    if (!(new File(hhc).exists())) {
      hhc = "C:\\Program Files\\HTML Help Workshop\\hhc.exe";
      if (!(new File(hhc).exists())) {
        log("Not producing CHM - Help Compiler not found");
        return; 
      }
    }

    log("Produce CHM");
	  // if not windows then....?
	  Utilities.clearDirectory(folders.rootDir+"temp\\chm");
	  File chm = new File(folders.dstDir+"fhir.chm");
	  chm.delete();
    if (chm.exists()) {
      List<String> command = new ArrayList<String>();
      command.add("cmd");
      command.add("del");
      command.add(folders.dstDir+"fhir.chm");
   
      ProcessBuilder builder = new ProcessBuilder(command);
      builder.directory(new File(folders.dstDir));
      final Process process = builder.start();
      process.waitFor();
      
      if (chm.exists()) 
        throw new Exception("Deleting CHM file failed");
    }

    String[] files = new File(folders.dstDir).list();
    for (String f : files) {
      if (!f.endsWith("htm") || f.endsWith("xml.htm"))
        Utilities.copyFile(new File(folders.dstDir+f), new File(folders.rootDir+"temp\\chm\\"+f));
    }
	  
    String src = Utilities.fileToString(folders.rootDir+"\\tools\\chm\\fhir.hhp");
    Utilities.stringToFile(src.replace("%fhir%", folders.dstDir), folders.rootDir+"\\temp\\chm\\fhir.hhp");
    Utilities.copyFile(new File(folders.rootDir+"\\tools\\chm\\words.stp"), new File(folders.rootDir+"\\temp\\chm\\words.stp"));
    StringBuilder s = new StringBuilder();
    buildHHC(s);
    Utilities.stringToFile(s.toString(), folders.rootDir+"\\temp\\chm\\fhir.hhc");
    s = new StringBuilder();
    buildHHK(s);
    Utilities.stringToFile(s.toString(), folders.rootDir+"\\temp\\chm\\fhir.hhk");

    List<String> command = new ArrayList<String>();
    command.add(hhc);
    command.add(folders.rootDir+"\\temp\\chm\\fhir.hhp");
 
    ProcessBuilder builder = new ProcessBuilder(command);
    builder.directory(new File(folders.rootDir+"\\temp\\chm"));

    final Process process = builder.start();
    log("wait: "+Integer.toString(process.waitFor()));
    if (!chm.exists())
      throw new Exception("Generation of CHM file failed");
  }

  private void buildHHK(StringBuilder s) {
    s.append("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n");
    s.append("<HTML>\r\n");
    s.append("<HEAD>\r\n");
    s.append("<meta name=\"GENERATOR\" content=\"Microsoft&reg; HTML Help Workshop 4.1\">\r\n");
    s.append("<!-- Sitemap 1.0 -->\r\n");
    s.append("</HEAD><BODY>\r\n");
    s.append("<UL>\r\n");
    List<String> names = new ArrayList<String>();
    names.addAll(keywords.keySet());
    Collections.sort(names, String.CASE_INSENSITIVE_ORDER);
    
    for (String k : names) {
      s.append("  <LI> <OBJECT type=\"text/sitemap\">\r\n");
      s.append("      <param name=\"Name\" value=\""+k+"\">\r\n");
      for (String r : keywords.get(k).keySet()) {
        s.append("     <param name=\"Name\" value=\""+keywords.get(k).get(r)+"\">\r\n");
        s.append("     <param name=\"Local\" value=\""+r+"\">\r\n");
      }

      s.append("    </OBJECT>\r\n");
    }
    s.append("</UL>\r\n");
    s.append("</BODY></HTML>\r\n");
  }

  private void buildHHC(StringBuilder s) throws IOException {
    s.append("<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\r\n");
    s.append("<HTML>\r\n");
    s.append("<HEAD>\r\n");
    s.append("<meta name=\"GENERATOR\" content=\"Microsoft&reg; HTML Help Workshop 4.1\">\r\n");
    s.append("<!-- Sitemap 1.0 -->\r\n");
    s.append("</HEAD><BODY>\r\n");
    s.append("<OBJECT type=\"text/site properties\">\r\n");
    s.append("  <param name=\"Window Styles\" value=\"0x800025\">\r\n");
    s.append("</OBJECT>\r\n");
    s.append("<UL>\r\n");
    for (Section sect : sections) {
      s.append("  <LI> <OBJECT type=\"text/sitemap\">\r\n");
      s.append("      <param name=\"Name\" value=\""+sect.name+"\">\r\n");
      s.append("    </OBJECT>\r\n");
      s.append("  <UL>\r\n");
      for (SectionEntry se : sect.contents) {
        s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
        s.append("       <param name=\"Name\" value=\""+se.title+"\">\r\n");
        s.append("       <param name=\"Local\" value=\""+se.name+".htm\">\r\n");
        s.append("      </OBJECT>\r\n");
        Utilities.copyFile(new File(folders.dstDir+"print-"+se.name+".htm"), new File(folders.rootDir+"\\temp\\chm\\"+se.name+".htm"));
      }
      s.append("  </UL>\r\n");
    }
    s.append("  <LI> <OBJECT type=\"text/sitemap\">\r\n");
    s.append("      <param name=\"Name\" value=\"Appendices\">\r\n");
    s.append("    </OBJECT>\r\n");
    s.append("  <UL>\r\n");
    s.append("    <LI> <OBJECT type=\"text/sitemap\">\r\n");
    s.append("       <param name=\"Name\" value=\"Examples\">\r\n");
    s.append("      </OBJECT>\r\n");
    s.append("    <UL>\r\n");
    List<String> names = new ArrayList<String>();
    names.addAll(definitions.getDefinedResources().keySet());
    Collections.sort(names);
    for (String name : names) {
      s.append("      <LI> <OBJECT type=\"text/sitemap\">\r\n");
      s.append("         <param name=\"Name\" value=\""+definitions.getDefinedResources().get(name).getName()+"\">\r\n");
      s.append("         <param name=\"Local\" value=\""+name.toLowerCase()+".xml.htm\">\r\n");
      s.append("        </OBJECT>\r\n");
    }

    s.append("    </UL>\r\n");
    s.append("  </UL>\r\n");
    s.append("</UL>\r\n");
    s.append("</BODY></HTML>\r\n");
  }

  private void produceSpec() throws Exception {
		for (String n : ini.getPropertyNames("support")) 
			Utilities.copyFile(new File(folders.srcDir + n), new File(folders.dstDir + n));
		for (String n : ini.getPropertyNames("images")) 
			Utilities.copyFile(new File(folders.imgDir + n), new File(folders.dstDir + n));

		for (ElementDefn n : definitions.getDefinedResources().values())
			produceResource(n);
		for (String n : ini.getPropertyNames("pages"))
			producePage(n);

		for (String n : definitions.getProfiles().keySet())
		  produceProfile(n, definitions.getProfiles().get(n));
		
		produceCombinedDictionary();
		Utilities.copyFile(new File(folders.umlDir + "fhir.eap"), new File(folders.dstDir + "fhir.eap"));
// todo - collect and zip the xmi files
		// Utilities.copyFile(new File(folders.umlDir + "fhir.xmi"), new File(folders.dstDir + "fhir.xmi"));
		
		produceZip();
		produceBookForm();
	}



  private class SectionEntry {
    private String name;
    private String title;
  }
  
	private class Section {
	  private String name;
	  private List<SectionEntry> contents = new ArrayList<SectionEntry>();
	}
	
	private void produceBookForm() throws FileNotFoundException, Exception {
	  String src = Utilities.fileToString(folders.srcDir+"book.htm");
	  src = processPageIncludes(folders.srcDir+"book.htm", src);
	  XhtmlDocument doc = new XhtmlParser().parse(src);
	  XhtmlNode body = doc.getElement("html").getElement("body");
	  addTOC(sections, body);	  
	  addContent(sections, body);
	  addReferenceIds(body);
	  new XhtmlComposer().compose(new FileOutputStream(folders.dstDir+"fhir-book.htm"), doc); 
	}

	private class RefTarget {
	  XhtmlNode parent;
	  int index;
	}
  private void addReferenceIds(XhtmlNode body) {
    Map<String, RefTarget> tgts = new HashMap<String, Publisher.RefTarget>();
    List<XhtmlNode> refs = new ArrayList<XhtmlNode>();
    buildIndex(refs, tgts, body, false);
    for (XhtmlNode a : refs) {
      if (a.getAttributes().get("href").startsWith("#")) {
        RefTarget r = tgts.get(a.getAttributes().get("href").substring(1));
        if (r != null) {
          int n = r.index + 1;
          while (n < r.parent.getChildNodes().size() && r.parent.getChildNodes().get(n).getNodeType() != NodeType.Element)
            n++;
          if (n < r.parent.getChildNodes().size()) {
            XhtmlNode h = r.parent.getChildNodes().get(n);
            if (h.getName().startsWith("h")) {
              String s = h.allText();
              if (s.contains(":"))
                a.addText(" (§"+s.substring(0, s.indexOf(':'))+")");
            }
            
          }
        }
        else
          log("unable to resolve reference to "+a.getAttributes().get("href").substring(1)+" on "+a.allText());
      }
    }    
  }

  private void buildIndex(List<XhtmlNode> refs, Map<String, RefTarget> tgts, XhtmlNode focus, boolean started) {
    int i = 0;
    for (XhtmlNode child : focus.getChildNodes()) {
      if (started) {
        if ("a".equals(child.getName()) && child.getAttributes().containsKey("name")) {
          RefTarget r = new RefTarget();
          r.parent = focus;
          r.index = i;
          tgts.put(child.getAttributes().get("name"), r);
        }
        if ("a".equals(child.getName()) && child.getAttributes().containsKey("href")) {
          //System.out.println("found "+child.getAttributes().get("href"));
          refs.add(child);
        }

        if (child.getNodeType() == NodeType.Element && !child.getName().equals("pre"))
          buildIndex(refs, tgts, child, true);
      } else if ("hr".equals(child.getName()))
        started = true;
      i++;
    }
    
  }

  private void addContent(List<Section> sections, XhtmlNode body) throws Exception {
    XhtmlNode e = body.getElement("contents");
    XhtmlNode div = body.addTag(body.getChildNodes().indexOf(e), "div");
    body.getChildNodes().remove(e);

    int i1 = 0;
    for (Section s : sections) {
      i1++;
      XhtmlNode divS = div.addTag("div");
      divS.attribute("class", "section");
      XhtmlNode h1 = divS.addTag("h1");
      h1.addText(Integer.toString(i1)+": "+s.name);

      int i2 = 0;
      int i3 = 0;
      int i4 = 0;
      for (SectionEntry n : s.contents) {
        i2++;
        i3 = 0;
        i4 = 0;
        XhtmlNode divT = divS.addTag("div");
        XhtmlNode a = divT.addTag("a");
        a.attribute("name", n.name);
        a.addText(" "); // work around for a browser bug

        boolean first = true;
        XhtmlDocument page = pages.get(n.name+".htm");
        if (page == null)
          throw new Exception("No content found for "+n.name+".htm");
        if (page.getElement("html") == null)
          throw new Exception("No 'html' tag found in "+n.name+".htm");
        if (page.getElement("html").getElement("body") == null)
          throw new Exception("No 'body' tag found in "+n.name+".htm");
        XhtmlNode pageBody = page.getElement("html").getElement("body");
        for (XhtmlNode child : pageBody.getChildNodes()) {
          if (child.getNodeType() == NodeType.Element) {
            fixReferences(child, n.name);
          }
          if ("h1".equals(child.getName())) {
            if (!first)
              throw new Error("?? ("+n.name+".h1 repeated) ");
            first = false;
            registerKeyWord(child.allText(), n.name+".htm", n.title);
            child.setName("h2");
            child.addText(0, Integer.toString(i1)+"."+Integer.toString(i2)+": ");

          } else if ("h2".equals(child.getName())) {
            i3++;
            i4 = 0;
            registerKeyWord(child.allText(), n.name+".htm", n.title);
            child.setName("h3");
            child.addText(0, Integer.toString(i1)+"."+Integer.toString(i2)+"."+Integer.toString(i3)+": ");
          } else if ("h3".equals(child.getName())) {
            i4++;
            registerKeyWord(child.allText(), n.name+".htm", n.title);
            child.setName("h4");
            child.addText(0, Integer.toString(i1)+"."+Integer.toString(i2)+"."+Integer.toString(i3)+"."+Integer.toString(i4)+": ");
          } else if ("h4".equals(child.getName())) {
            child.setName("h5");
          }
        }
        divT.getChildNodes().addAll(pageBody.getChildNodes());
      }
    }

  }

  
  private void fixReferences(XhtmlNode node, String name) {
    for (XhtmlNode child : node.getChildNodes()) {
      if (child.getNodeType() == NodeType.Element) {
        fixReferences(child, name);
      }    
    }
    if (node.getName().equals("a")) {
      
      if (node.getAttributes().containsKey("name")) {
        String lname = node.getAttributes().get("name");
        node.getAttributes().put("name", name+"."+lname);
        //System.out.println("found anchor "+name+"."+lname);
      } else { 
        String s = node.getAttributes().get("href");
        if (s == null || s.length() == 0)
          throw new Error("empty \"a\" tag");
        if (s.startsWith("#")) {
          s = "#"+name+"."+s.substring(1);
        } else if (s.startsWith("http:") || s.startsWith("https:")) {
          s = s;
        } else {
          int i = s.indexOf('.');
          if (i == -1)
            throw new Error("unable to understand ref: '"+s+"'");

          if (s.contains("#")) {
            int j = s.indexOf('#');
            s = "#"+s.substring(0, i)+"."+s.substring(j+1);
          } else if (s.endsWith(".htm")) {
            s = "#"+s.substring(0, i);
          } else {
            if (!s.endsWith(".zip") && !s.endsWith(".xsd") && !s.endsWith(".xml") && !s.endsWith(".eap") && !s.endsWith(".xmi"))
              System.out.println("odd ref: "+s+" in "+node.allText());
            s = s;
          }

        }
        node.getAttributes().put("href", s);
        //System.out.println("reference to "+s); 
      }
    }
  }

  private void addTOC(List<Section> sections, XhtmlNode body) {
    XhtmlNode e = body.getElement("index");
    XhtmlNode div = body.addTag(body.getChildNodes().indexOf(e), "div");
    body.getChildNodes().remove(e);
	  div.attribute("class", "toc");
	  div.addText("\r\n  ");
	  int i1 = 0;
    XhtmlNode p = div.addTag("p");
    p.addText("\r\n    ");
    for (Section s : sections) {
      i1++;
      p.addText(Integer.toString(i1)+": "+s.name);
      p.addTag("br");
      p.addText("\r\n      ");
      int i2 = 0;
      for (SectionEntry n : s.contents) {
        i2++;
        p.addText(XhtmlNode.NBSP+XhtmlNode.NBSP+Integer.toString(i1)+"."+Integer.toString(i2)+": ");

        XhtmlNode a = p.addTag("a");
        a.attribute("href", "#"+n.name);
        a.addText(n.title);
        p.addTag("br");
        p.addText("\r\n     ");
      }
    }
    div.addText("\r\n  ");
  }

  private void parseSidebar(List<Section> sections) throws Exception,
      FileNotFoundException {
    XhtmlNode doc = new XhtmlParser().parseFragment(new FileInputStream(folders.srcDir+"sidebar.htm"));
	  int i = 0;
	  Section sect = null;
	  while (i < doc.getChildNodes().size()) {
	    XhtmlNode n = doc.getChildNodes().get(i);
	    if ("h2".equals(n.getName())) {
	      sect = new Section();
	      sections.add(sect);
	      sect.name = n.allText();
	    } else if ("ul".equals(n.getName())) {
	      for (XhtmlNode g : n.getChildNodes()) {
	        if (g.getNodeType() == NodeType.Element && g.getName().equals("li") && g.getChildNodes().size() == 1) {
	          XhtmlNode a = g.getElement("a");
	          if (a != null) {
	            SectionEntry e = new SectionEntry();
	            e.name = a.getAttributes().get("href").replace(".htm", "");
	            e.title = a.allText();
	            registerKeyWord(e.title, e.name, e.title);
	            sect.contents.add(e);
	          }
	        }
	      }
	    }
      i++;
	  }
  }

//	private void producePattern(String n) throws Exception {
//    // this output is produced into a scratch directry. It is only produced to allow them to manually merged back into the appropriate source page
//		TypeDefn t = new TypeParser().parse(n).get(0);
//		ElementDefn el = definitions.getDefinedResources().get(t.getName());
//		Utilities.stringToFile(xmlForDt(n)+tsForDt(n), folders.tmpResDir+t.getName()+".htm");
//	}
//
//	private void produceDataType(String n) throws Exception {
//    // this output is produced into a scratch directry. It is only produced to allow them to manually merged back into the appropriate source page
//		TypeDefn t = new TypeParser().parse(n).get(0);
//		ElementDefn el = definitions.getDefinedResources().get(t.getName());
//		if (el != null) 
//			Utilities.stringToFile(xmlForDt(n)+tsForDt(n), folders.tmpResDir+t.getName()+".htm");
//	}

	private void produceZip() throws Exception {
	  File f = new File(folders.dstDir+"fhir-spec.zip");
	  if (f.exists())
	    f.delete();
    ZipGenerator zip = new ZipGenerator(folders.tmpResDir+"fhir-spec.zip");
    zip.addFiles(folders.dstDir, "", null);
    zip.close();
    Utilities.copyFile(new File(folders.tmpResDir+"fhir-spec.zip"), f);
  }

	private void produceSchemaZip() throws Exception {
    File f = new File(folders.dstDir+"fhir-all-xsd.zip");
    if (f.exists())
      f.delete();
    ZipGenerator zip = new ZipGenerator(folders.tmpResDir+"fhir-all-xsd.zip");
    zip.addFiles(folders.dstDir, "", ".xsd");
    zip.close();
    Utilities.copyFile(new File(folders.tmpResDir+"fhir-all-xsd.zip"), f);
  }
	
	private void registerElementDefnInIndex(ElementDefn n, String filename, String title) {
	  registerKeyWord(n.getName(), filename, title);
	  for (ElementDefn c : n.getElements())
	    registerElementDefnInIndex(c, filename, title);	  
	}
	
  private void produceResource(ElementDefn root) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		String n = root.getName().toLowerCase();
	
		XmlSpecGenerator gen = new XmlSpecGenerator(new FileOutputStream(tmp));
		gen.generate(root);
		String xml = Utilities.fileToString(tmp.getAbsolutePath());

		TerminologyNotesGenerator tgen = new TerminologyNotesGenerator(new FileOutputStream(tmp));
		tgen.generate(root, definitions.getConceptDomains());
		String tx = Utilities.fileToString(tmp.getAbsolutePath());

		DictHTMLGenerator dgen = new DictHTMLGenerator(new FileOutputStream(tmp));
		dgen.generate(root);
		String dict = Utilities.fileToString(tmp.getAbsolutePath());

		DictXMLGenerator dxgen = new DictXMLGenerator(new FileOutputStream(folders.dstDir+n+".dict.xml"));
		dxgen.generate(root, "HL7");

		generateProfile(root, n);
		
		File xmlf = new File(folders.srcDir+n+File.separatorChar+n+"-example.xml");
		if (!xmlf.exists())
		  xmlf = new File(folders.sndBoxDir+n+File.separatorChar+n+"-example.xml");
		File umlf = new File(folders.imgDir+n+".png");

		String src = Utilities.fileToString(folders.srcDir + "template.htm");
		src = processResourceIncludes(n, root, xml, tx, dict, src);
		Utilities.stringToFile(src, folders.dstDir + n+".htm");

		src = Utilities.fileToString(folders.srcDir + "template-print.htm").replace("<body>", "<body style=\"margin: 20px\">");
		src = processResourceIncludes(n, root, xml, tx, dict, src);
		Utilities.stringToFile(src, folders.dstDir + "print-"+n+".htm");
		Utilities.copyFile(umlf, new File(folders.dstDir+n+".png"));				
    src = Utilities.fileToString(folders.srcDir + "template-book.htm").replace("<body>", "<body style=\"margin: 10px\">");
    src = processResourceIncludes(n, root, xml, tx, dict, src);
    cachePage(n+".htm", src);

		// xml to xhtml of xml
		// first pass is to strip the xsi: stuff. seems to need double processing in order to delete namespace crap
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); 
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xdoc = builder.parse(new FileInputStream(xmlf));
		XmlGenerator xmlgen = new XmlGenerator();
		xmlgen.generate(xdoc.getDocumentElement(), new File(folders.dstDir+n+".xml"), "http://www.hl7.org/fhir", xdoc.getDocumentElement().getLocalName());

		// reload it now
		builder = factory.newDocumentBuilder();
		xdoc = builder.parse(new FileInputStream(new File(folders.dstDir+n+".xml")));
		XhtmlGenerator xhtml = new XhtmlGenerator();
		xhtml.generate(xdoc, new File(folders.dstDir+n+".xml.htm"), n.toUpperCase().substring(0, 1)+n.substring(1));
		// xml to json
		JsonGenerator jsongen = new JsonGenerator();
		jsongen.generate(new File(folders.dstDir+n+".xml"), new File(folders.dstDir+n+".json"));

		tmp.delete();
		
	}

  private void generateProfile(ElementDefn root, String n) throws Exception,
      FileNotFoundException {
    ProfileDefn p = new ProfileDefn();
		p.putMetadata("id", "1");
    p.putMetadata("name", n);
    p.putMetadata("author.name", "todo (committee)");
    p.putMetadata("author.ref", "todo");
    p.putMetadata("description", root.getDefinition());
    p.putMetadata("comments", "Basic Profile for ");
    p.putMetadata("status", "testing");
    p.putMetadata("date", new SimpleDateFormat("yyyymmdd", new Locale("en", "US")).format(new Date()));
    p.putMetadata("endorser.name", "HL7");
    p.putMetadata("endorser.ref", "http://www.hl7.org");
    p.getResources().add(root);
		ProfileGenerator pgen = new ProfileGenerator();
		pgen.generate(p, new FileOutputStream(folders.dstDir+n+".profile.xml"));
  }

  private void produceProfile(String filename, ProfileDefn profile) throws Exception {
    File tmp = File.createTempFile("tmp", ".tmp");
  
    // you have to validate a profile, because it has to merged with it's base resource to fill out all the missing bits
    validateProfile(profile);
    
    XmlSpecGenerator gen = new XmlSpecGenerator(new FileOutputStream(tmp));
    gen.generate(profile);
    String xml = Utilities.fileToString(tmp.getAbsolutePath());
    
    ProfileGenerator pgen = new ProfileGenerator();
    pgen.generate(profile, new FileOutputStream(folders.dstDir+filename+".profile.xml"));
//
//    TerminologyNotesGenerator tgen = new TerminologyNotesGenerator(new FileOutputStream(tmp));
//    tgen.generate(root, definitions.getConceptDomains());
//    String tx = Utilities.fileToString(tmp.getAbsolutePath());
//
//    DictHTMLGenerator dgen = new DictHTMLGenerator(new FileOutputStream(tmp));
//    dgen.generate(root);
//    String dict = Utilities.fileToString(tmp.getAbsolutePath());
//
//    DictXMLGenerator dxgen = new DictXMLGenerator(new FileOutputStream(folders.dstDir+n+".dict.xml"));
//    dxgen.generate(root, "HL7");
//
//    File xmlf = new File(folders.srcDir+n+File.separatorChar+"example.xml");
//    File umlf = new File(folders.imgDir+n+".png");
//
    String src = Utilities.fileToString(folders.srcDir + "template-profile.htm");
    src = processProfileIncludes(filename, profile, xml, src);
    Utilities.stringToFile(src, folders.dstDir + filename+".htm");
//
//    src = Utilities.fileToString(folders.srcDir + "template-print.htm").replace("<body>", "<body style=\"margin: 20px\">");
//    src = processResourceIncludes(n, root, xml, tx, dict, src);
//    Utilities.stringToFile(src, folders.dstDir + "print-"+n+".htm");
//    Utilities.copyFile(umlf, new File(folders.dstDir+n+".png"));        
//    src = Utilities.fileToString(folders.srcDir + "template-book.htm").replace("<body>", "<body style=\"margin: 10px\">");
//    src = processResourceIncludes(n, root, xml, tx, dict, src);
//    cachePage(n+".htm", src);
//
//    // xml to xhtml of xml
//    // first pass is to strip the xsi: stuff. seems to need double processing in order to delete namespace crap
//    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//    factory.setNamespaceAware(true); 
//    DocumentBuilder builder = factory.newDocumentBuilder();
//    Document xdoc = builder.parse(new FileInputStream(xmlf));
//    XmlGenerator xmlgen = new XmlGenerator();
//    xmlgen.generate(xdoc.getDocumentElement(), new File(folders.dstDir+n+".xml"), "http://www.hl7.org/fhir", xdoc.getDocumentElement().getLocalName());
//
//    // reload it now
//    builder = factory.newDocumentBuilder();
//    xdoc = builder.parse(new FileInputStream(new File(folders.dstDir+n+".xml")));
//    XhtmlGenerator xhtml = new XhtmlGenerator();
//    xhtml.generate(xdoc, new File(folders.dstDir+n+".xml.htm"), n.toUpperCase().substring(0, 1)+n.substring(1));
//    // xml to json
//    JsonGenerator jsongen = new JsonGenerator();
//    jsongen.generate(new File(folders.dstDir+n+".xml"), new File(folders.dstDir+n+".json"));
//
    tmp.delete();
    
  }


private void validateProfile(ProfileDefn profile) throws FileNotFoundException, Exception {
    for (ElementDefn c : profile.getResources()) {
      Profile resource = loadResourceProfile(c.getName());
      ProfileValidator v = new ProfileValidator();
      v.setProfile(c);
      v.setResource(resource);
      List<String> errors = v.evaluate();
      if (errors.size() > 0)
        throw new Exception("Error validating "+profile.metadata("name")+": "+errors.toString());
    }
  }

//	private void produceFutureResource(String n) throws Exception {
//		ElementDefn e = new ElementDefn();
//		e.setName(ini.getStringProperty("future-resources", n));
//	}


	private Profile loadResourceProfile(String name) throws FileNotFoundException, Exception {
	  XmlParser xml = new XmlParser();
	  return (Profile) xml.parse(new FileInputStream(folders.dstDir+name+".profile.xml"));
}

  private void producePage(String file) throws Exception {
		String src = Utilities.fileToString(folders.srcDir + file);
		src = processPageIncludes(file, src);
		Utilities.stringToFile(src, folders.dstDir + file);
		src = Utilities.fileToString(folders.srcDir + file).replace("<body>", "<body style=\"margin: 20px\">");
		src = processPageIncludesForPrinting(file, src);
		Utilities.stringToFile(src, folders.dstDir + "print-"+file);
		
    src = Utilities.fileToString(folders.srcDir + file).replace("<body>", "<body style=\"margin: 10px\">");
    src = processPageIncludesForBook(file, src);
		cachePage(file, src);
	}

	private void cachePage(String filename, String source) throws Exception {
	  try {
	    // log("parse "+filename);
	    pages.put(filename,  new XhtmlParser().parse(source));
	  } catch (Exception e) {
	    throw new Exception("error parsing page "+filename+": "+e.getMessage());
	  }
  }

  public class MyErrorHandler implements ErrorHandler {

	  private boolean trackErrors;
	  private List<String> errors = new ArrayList<String>();
	  
	  public MyErrorHandler(boolean trackErrors) {
	    this.trackErrors = trackErrors;
	  }

    public void error(SAXParseException arg0) throws SAXException {
    if (trackErrors) {
    System.out.println("error: " + arg0.toString());
    errors.add(arg0.toString());
  }
      
    }

    public void fatalError(SAXParseException arg0) throws SAXException {
    System.out.println("fatal error: " + arg0.toString());
      
    }

    public void warning(SAXParseException arg0) throws SAXException {
    //  System.out.println("warning: " + arg0.toString());
      
    }

    public List<String> getErrors() {
      return errors;
    }
    
    
	}

	public class MyLSInput implements LSInput {

	  private FileInputStream stream;

	  public MyLSInput(FileInputStream fileInputStream) {
	    this.stream = fileInputStream;
	  }

	  public String getBaseURI() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  public InputStream getByteStream() {
	    return stream;
	  }

	  public boolean getCertifiedText() {
	    // TODO Auto-generated method stub
	    return false;
	  }

	  public Reader getCharacterStream() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  public String getEncoding() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  public String getPublicId() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  public String getStringData() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  public String getSystemId() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  public void setBaseURI(String baseURI) {
	    // TODO Auto-generated method stub

	  }

	  public void setByteStream(InputStream byteStream) {
	    // TODO Auto-generated method stub

	  }

	  public void setCertifiedText(boolean certifiedText) {
	    // TODO Auto-generated method stub

	  }

	  public void setCharacterStream(Reader characterStream) {
	    // TODO Auto-generated method stub

	  }

	  public void setEncoding(String encoding) {
	    // TODO Auto-generated method stub

	  }

	  public void setPublicId(String publicId) {
	    // TODO Auto-generated method stub

	  }

	  public void setStringData(String stringData) {
	    // TODO Auto-generated method stub

	  }

	  public void setSystemId(String systemId) {
	    // TODO Auto-generated method stub

	  }
	} 
	
	public class MyResourceResolver implements LSResourceResolver {

	  private String dir;
	  
	  public MyResourceResolver(String dir) {
	    this.dir = dir;
	  }

	  public LSInput resolveResource(final String type, final String namespaceURI, final String publicId, String systemId, final String baseURI) {
	    System.out.println(type+", "+namespaceURI+", "+publicId+", "+systemId+", "+baseURI);
	    if (!(namespaceURI.equals("http://www.hl7.org/fhir") || namespaceURI.equals("http://www.w3.org/1999/xhtml")))
	      return null;
	      try {
	      return new MyLSInput(new FileInputStream(new File(dir + systemId)));
	    } catch (FileNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	      return null;
	    }

	  }


	}

	
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema"; 
	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	private void validateXml() throws Exception {
    log("Validating XML");
		StreamSource[] sources = new StreamSource[1];
		sources[0] = new StreamSource(new FileInputStream(folders.dstDir+"fhir-all.xsd"));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schemaFactory.setErrorHandler(new MyErrorHandler(false));
		schemaFactory.setResourceResolver(new MyResourceResolver(folders.dstDir));
		Schema schema = schemaFactory.newSchema(sources);	

		for (String n : definitions.getDefinedResources().keySet()) {
		  log("Validate "+n);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setValidating(false);
			factory.setSchema(schema);
			DocumentBuilder builder = factory.newDocumentBuilder();
			MyErrorHandler err = new MyErrorHandler(true);
			builder.setErrorHandler(err);
			builder.parse(new FileInputStream(new File(folders.dstDir+n+".xml")));
			if (err.getErrors().size() > 0) 
				throw new Exception("Resource Example "+n+" failed schema validation");
		}
	}


	private boolean isSpecial(String name) {
		return definitions.getSpecialResources().containsKey(name);
	}		

	private String processPageIncludes(String file,	String src) throws Exception {
		while (src.contains("<%"))
		{
			int i1 = src.indexOf("<%");
			int i2 = src.indexOf("%>");
			String s1 = src.substring(0, i1);
			String s2 = src.substring(i1 + 2, i2).trim();
			String s3 = src.substring(i2+2);
			String name = file.substring(0,file.indexOf(".")); 

			String[] com = s2.split(" ");
			if (com.length == 2 && com[0].equals("dt")) 
			  src = s1+xmlForDt(com[1])+tsForDt(com[1])+s3;
			else if (com.length == 2 && com[0].equals("dictionary"))
			  src = s1+dictForDt(com[1])+s3;
			else if (com.length != 1)
			  throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
			else if (com[0].equals("header"))
			  src = s1+Utilities.fileToString(folders.srcDir + "header.htm")+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
			else if (com[0].equals("sidebar"))
				src = s1+Utilities.fileToString(folders.srcDir + "sidebar.htm")+s3;
			else if (com[0].equals("title"))
				src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
			else if (com[0].equals("name"))
				src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+version+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
			else if (com[0].equals("maindiv"))
				src = s1+"<div class=\"content\">"+s3;
			else if (com[0].equals("/maindiv"))
				src = s1+"</div>"+s3;
			else if (com[0].equals("events"))
			  src = s1 + getEventsTable()+ s3;
			else if (com[0].equals("resourcecodes"))
				src = s1 + genResCodes() + s3;
      else if (com[0].equals("resimplall"))
        src = s1 + genResImplList() + s3;
      else if (com[0].equals("impllist"))
        src = s1 + genReferenceImplList() + s3;

			else 
				throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
		}
		return src;
	}

	private String dictForDt(String dt) throws Exception {
   
    File tmp = File.createTempFile("tmp", ".tmp");
    FileOutputStream fos = new FileOutputStream(tmp);
    DictHTMLGenerator gen = new DictHTMLGenerator(fos);
    TypeParser tp = new TypeParser();
    TypeDefn t = tp.parse(dt).get(0);
    ElementDefn e = definitions.getElementDefn(t.getName());
    if (e == null)
      throw new Exception("unable to find definition for "+dt);
    gen.generate(e);
    fos.close();
    String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
    tmp.delete();
    return val; 
    
  }

  private String getEventsTable() {
/*
<table clas="grid">
 <tr><th>Code</th><th>Description</th><th>Request Resources</th><th>Response Resources</th><th>Further messages</th></tr>
 <tr><td>admin-create</td><td>Create an Administrative resource </td><td>One of Person, Animal, Device, Organization, Agent, or Patient</td><td>(none)</td><td>N/A</td></tr>
 <tr><td>admin-update</td><td>Update an administrative resource. Noe that there is no delete, since administrative resources are never really deleted - 
   some have status or period elements for this use</td><td>One of Person, Animal, Device, Organization, Agent, or Patient</td><td>(none)</td><td>N/A</td></tr>
 <tr><td>patient-link</td><td>Link two or patients</td><td>Two or more patient</td><td>(none)</td><td>N/A</td></tr>
 <tr><td>provide-lab-report</td><td>Send a lab report</td><td>Primary: LabReport<br/>Aggregated: Patient+Person/Animal, Any specimens, Any resource linked in clinical information</td><td>(none)</td><td>N/A</td></tr>
<!--
 <tr><td>Code</td><td>Name / Description</td><td>Request Resources</td><td>Response Resources</td><td>Further transactions</td></tr>
 -->
 </table>

 * 
 */
	  List<String> codes = new ArrayList<String>();
	  codes.addAll(definitions.getEvents().keySet());
	  Collections.sort(codes);
	  StringBuilder s = new StringBuilder();
	  s.append("<table class=\"grid\">\r\n");
	  s.append(" <tr><th>Code</th><th>Description</th><th>Request</th><th>Response</th><th>Notes</th></tr>\r\n");
	  for (String c : codes) {
	    EventDefn e = definitions.getEvents().get(c);
      if (e.getUsages().size() == 1) {
        EventUsage u = e.getUsages().get(0);
        s.append(" <tr><td>"+e.getCode()+"</td><td>"+e.getDefinition()+"</td>");
        s.append("<td>"+describeMsg(u.getRequestResources(), u.getRequestAggregations())+"</td><td>"+
            describeMsg(u.getResponseResources(), u.getResponseAggregations())+"</td><td>"+
            combineNotes(e.getFollowUps(), u.getNotes())+"</td></tr>\r\n");
      } else {
        boolean first = true;
        for (EventUsage u : e.getUsages()) {
          if (first)
            s.append(" <tr><td rowspan=\""+Integer.toString(e.getUsages().size())+"\">"+e.getCode()+"</td><td rowspan=\""+Integer.toString(e.getUsages().size())+"\">"+e.getDefinition()+"</td>");
          else
            s.append(" <tr>");
          first = false;
          s.append("<td>"+describeMsg(u.getRequestResources(), u.getRequestAggregations())+"</td><td>"+
              describeMsg(u.getResponseResources(), u.getResponseAggregations())+"</td><td>"+
              combineNotes(e.getFollowUps(), u.getNotes())+"</td></tr>\r\n");
        }
	    }
	  }
    s.append("</table>\r\n");
    return s.toString();
  }

  private String combineNotes(List<String> followUps, String notes) {
    String s = "";
    if (notes != null && !notes.equals(""))
      s = notes;
    if (followUps.size() > 0)
      if (s != "")
        s = s + "<br/>Follow ups: "+Utilities.asCSV(followUps);
      else
        s = "Follow ups: "+Utilities.asCSV(followUps);
    return s;      
  }

  private String describeMsg(List<String> resources, List<String> aggregations) {
    if (resources.size() == 0 && aggregations.size() == 0)
      return "<font color=\"silver\">--</font>";
    else {
      String s = resources.size() == 0 ? "" : Utilities.asCSV(resources);
      
      if (aggregations.size() == 0)
        return s;
      else
        return s + "<br/>"+Utilities.asHtmlBr("&nbsp;"+resources.get(0), aggregations)+"";
    }      
  }

  private String genReferenceImplList() {
	  StringBuilder s = new StringBuilder();
	  for (PlatformGenerator gen : referenceImplementations) {
	    s.append("<li><b><a href=\""+gen.getName()+".zip\">"+gen.getTitle()+"</a></b>: "+Utilities.escapeXml(gen.getDescription())+"</li>\r\n");
	  }
    return s.toString();
  }

  /*
	 .
</p>
<p>
<b><a href="csharp.zip">C#</a></b>: Resource definitions (+ more todo) 
</p>

	 */

	private String processPageIncludesForPrinting(String file, String src) throws Exception {
		while (src.contains("<%"))
		{
			int i1 = src.indexOf("<%");
			int i2 = src.indexOf("%>");
			String s1 = src.substring(0, i1);
			String s2 = src.substring(i1 + 2, i2).trim();
			String s3 = src.substring(i2+2);
			String name = file.substring(0,file.indexOf(".")); 

			String[] com = s2.split(" ");
			if (com.length == 2 && com[0].equals("dt"))
				src = s1+xmlForDt(com[1])+tsForDt(com[1])+s3;
      else if (com.length == 2 && com[0].equals("dictionary"))
        src = s1+dictForDt(com[1])+s3;
			else if (com.length != 1)
				throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
      else if (com[0].equals("header"))
        src = s1+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
			else if (com[0].equals("sidebar"))
				src = s1+s3;
			else if (com[0].equals("title"))
				src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
			else if (com[0].equals("name"))
				src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
			else if (com[0].equals("maindiv"))
				src = s1+s3;
			else if (com[0].equals("/maindiv"))
				src = s1+s3;
      else if (com[0].equals("events"))
        src = s1 + getEventsTable()+ s3;
			else if (com[0].equals("resourcecodes"))
				src = s1 + genResCodes() + s3;
			else if (com[0].equals("resimplall"))
				src = s1 + genResImplList() + s3;
      else if (com[0].equals("impllist"))
        src = s1 + genReferenceImplList() + s3;
			else 
				throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
		}
		return src;
	}	

  private String processPageIncludesForBook(String file, String src) throws Exception {
    while (src.contains("<%"))
    {
      int i1 = src.indexOf("<%");
      int i2 = src.indexOf("%>");
      String s1 = src.substring(0, i1);
      String s2 = src.substring(i1 + 2, i2).trim();
      String s3 = src.substring(i2+2);
      String name = file.substring(0,file.indexOf(".")); 

      String[] com = s2.split(" ");
      if (com.length == 2 && com[0].equals("dt"))
        src = s1+xmlForDt(com[1])+tsForDt(com[1])+s3;
      else if (com.length == 2 && com[0].equals("dictionary"))
        src = s1+dictForDt(com[1])+s3;
      else if (com.length != 1)
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
      else if (com[0].equals("header"))
        src = s1+s3;
      else if (com[0].equals("footer"))
        src = s1+s3;
      else if (com[0].equals("sidebar"))
        src = s1+s3;
      else if (com[0].equals("title"))
        src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
      else if (com[0].equals("name"))
        src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
      else if (com[0].equals("maindiv"))
        src = s1+s3;
      else if (com[0].equals("/maindiv"))
        src = s1+s3;
      else if (com[0].equals("events"))
        src = s1 + getEventsTable()+ s3;
      else if (com[0].equals("resourcecodes"))
        src = s1 + genResCodes() + s3;
      else if (com[0].equals("resimplall"))
        src = s1 + genResImplList() + s3;
      else if (com[0].equals("impllist"))
        src = s1 + genReferenceImplList() + s3;
      else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
    }
    return src;
  } 



	private String processResourceIncludes(String name, ElementDefn root, String xml, String tx, String dict, String src) throws Exception {
		while (src.contains("<%"))
		{
			int i1 = src.indexOf("<%");
			int i2 = src.indexOf("%>");
			String s1 = src.substring(0, i1);
			String s2 = src.substring(i1 + 2, i2).trim();
			String s3 = src.substring(i2+2);

			String[] com = s2.split(" ");
			if (com.length != 1)
				throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+name);
      else if (com[0].equals("header"))
        src = s1+Utilities.fileToString(folders.srcDir + "header.htm")+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
			else if (com[0].equals("sidebar"))
				src = s1+Utilities.fileToString(folders.srcDir + "sidebar.htm")+s3;
			else if (com[0].equals("title"))
				src = s1+root.getName()+s3;
			else if (com[0].equals("name"))
				src = s1+name+s3;
      else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
			else if (com[0].equals("definition"))
				src = s1+root.getDefinition()+s3;
			else if (com[0].equals("xml"))
				src = s1+xml+s3;
			else if (com[0].equals("tx"))
				src = s1+tx+s3;
			else if (com[0].equals("plural"))
				src = s1+Utilities.pluralizeMe(name)+s3;
			else if (com[0].equals("notes")) {
			  if (new File(folders.sndBoxDir + name+File.separatorChar+name+"-notes.xhtml").exists())
	        src = s1+Utilities.fileToString(folders.sndBoxDir + name+File.separatorChar+name+"-notes.xhtml")+s3;
			  else
			    src = s1+Utilities.fileToString(folders.srcDir + name+File.separatorChar+name+"-notes.xhtml")+s3;
			} else if (com[0].equals("dictionary"))
				src = s1+dict+s3;
			else if (com[0].equals("resurl")) {
				if (isSpecial(name))
					src = s1+"This special resource has no associated URL"+s3;
				else
					src = s1+"The relative url is /"+Utilities.pluralizeMe(name)+s3;
			} else 
				throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+name);

		}
		return src;
	}

  private String processProfileIncludes(String filename, ProfileDefn profile, String xml, String src) throws Exception {
    while (src.contains("<%"))
    {
      int i1 = src.indexOf("<%");
      int i2 = src.indexOf("%>");
      String s1 = src.substring(0, i1);
      String s2 = src.substring(i1 + 2, i2).trim();
      String s3 = src.substring(i2+2);

      String[] com = s2.split(" ");
      if (com.length != 1)
        throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+filename);
      else if (com[0].equals("header"))
        src = s1+Utilities.fileToString(folders.srcDir + "header.htm")+s3;
      else if (com[0].equals("footer"))
        src = s1+Utilities.fileToString(folders.srcDir + "footer.htm")+s3;
      else if (com[0].equals("sidebar"))
        src = s1+Utilities.fileToString(folders.srcDir + "sidebar.htm")+s3;
      else if (com[0].equals("title"))
        src = s1+profile.getMetadata().get("name").get(0)+s3;
      else if (com[0].equals("name"))
        src = s1+filename+s3;
      else if (com[0].equals("date")) {
        Date d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(profile.getMetadata().get("date").get(0));
        src = s1+Config.DATE_FORMAT().format(d)+s3;
      } else if (com[0].equals("version"))
        src = s1+ini.getStringProperty("FHIR", "version")+s3;
      else if (com[0].equals("gendate"))
        src = s1+Config.DATE_FORMAT().format(new Date())+s3;
      else if (com[0].equals("definition"))
        src = s1+profile.getMetadata().get("description").get(0)+s3;
      else if (com[0].equals("status"))
        src = s1+describeStatus(profile.getMetadata().get("status").get(0))+s3;
      else if (com[0].equals("author"))
        src = s1+profile.getMetadata().get("author.name").get(0)+s3;
      else if (com[0].equals("xml"))
        src = s1+xml+s3;
      else if (com[0].equals("profilelist"))
        src = s1+"profiles the "+profile.getMetadata().get("resource").get(0)+" Resource"+s3;
      else if (com[0].equals("tx"))
        src = s1+"todo"+s3;
      else if (com[0].equals("plural"))
        src = s1+Utilities.pluralizeMe(filename)+s3;
      else if (com[0].equals("notes"))
        src = s1+"todo" /*Utilities.fileToString(folders.srcDir + filename+File.separatorChar+filename+".htm")*/ +s3;
      else if (com[0].equals("dictionary"))
        src = s1+"todo"+s3;
      else if (com[0].equals("resurl")) {
          src = s1+"The id of this profile is "+profile.getMetadata().get("id").get(0)+s3;
      } else 
        throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+filename);
    }
    return src;
  }


	private String describeStatus(String s) {
    if (s.equals("draft"))
      return "as a draft";
    if (s.equals("testing"))
      return "for testing";
    if (s.equals("production"))
      return "for production use";
    if (s.equals("withdrawn"))
      return "as withdrawn from use";
    if (s.equals("superceded"))
      return "as superceded";
    return "with unknown status '" +s+'"';
  }

  private void produceCombinedDictionary() throws FileNotFoundException,
	UnsupportedEncodingException, Exception, IOException {
		FileOutputStream fos = new FileOutputStream(folders.dstDir+"fhir.dict.xml");
		DictXMLGenerator dxgen = new DictXMLGenerator(fos);
		dxgen.setConceptDomains(definitions.getConceptDomains());
		dxgen.generate(definitions.getDefinedResources().values(), "HL7");
		fos.close();
	}


	private String tsForDt(String dt) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		FileOutputStream fos = new FileOutputStream(tmp);
		TerminologyNotesGenerator gen = new TerminologyNotesGenerator(fos);
		TypeParser tp = new TypeParser();
		TypeDefn t = tp.parse(dt).get(0);
		ElementDefn e = definitions.getElementDefn(t.getName());
		if (e == null)
			throw new Exception("unable to find definition for "+dt);
		gen.generate(e, definitions.getConceptDomains());
		fos.close();
		String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
		tmp.delete();
		return val;
	}

	
	private String xmlForDt(String dt) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		FileOutputStream fos = new FileOutputStream(tmp);
		XmlSpecGenerator gen = new XmlSpecGenerator(fos);
		TypeParser tp = new TypeParser();
		TypeDefn t = tp.parse(dt).get(0);
		ElementDefn e = definitions.getElementDefn(t.getName());
		if (e == null)
			throw new Exception("unable to find definition for "+dt);
		gen.generate(e);
		fos.close();
		String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
		tmp.delete();
		return val;	
	}

	private String genResCodes() {
		StringBuilder html = new StringBuilder();
		for (DefinedCode c : definitions.getKnownResources().values()) {
			html.append("  <tr><td><a href=\""+c.getComment()+".htm\">"+c.getCode()+"</a></td><td>"+Utilities.escapeXml(c.getDefinition())+"</td></tr>");

		}				
		return html.toString();
	}

	private String genResImplList() {
		StringBuilder html = new StringBuilder();
		List<String> res = new ArrayList<String>();
		for (ElementDefn n: definitions.getDefinedResources().values())
			res.add(n.getName());
		for (DefinedCode c : definitions.getKnownResources().values()) {
			if (res.contains(c.getComment()))
				html.append("  <tr><td>"+c.getCode()+"</td><td><a href=\""+c.getComment()+".dict.xml\">Definitions</a></td><td><a href=\""+c.getComment()+".xsd\">Schema</a></td><td><a href=\""+c.getComment()+".xml\">Example</a></td><td><a href=\""+c.getComment()+".json\">JSON Example</a></td>\r\n");
		}				
		return html.toString();

	}

	public void log(String content) {
	  System.out.println(content);        
	}


}
