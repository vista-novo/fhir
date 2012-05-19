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
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.parsers.SourceParser;
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
 *   Load the page.getDefinitions()
 *   Produce the specification
 *     1. reference implementations
 *     2. schemas
 *     4. final specification
 *   Validate the XML
 *   
 * @author Grahame
 *
 */
public class Publisher {

  private SourceParser prsr;
  private ChmMaker chm;
  private PageProcessor page = new PageProcessor();
  private BookMaker book;
  
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
    page.getReferenceImplementations().add(new DelphiGenerator());
    page.getReferenceImplementations().add(new JavaGenerator());
    page.getReferenceImplementations().add(new CSharpGenerator());
    page.getReferenceImplementations().add(new ECoreOclGenerator());
  }

  private boolean	initialize(String folder) throws Exception {
	  page.setDefinitions(new Definitions());
	  page.setFolders(new FolderManager(folder));

	  System.out.println("Checking Source");

	  List<String> errors = new ArrayList<String>();

	  Utilities.checkFolder(page.getFolders().rootDir, errors);
	  if (Utilities.checkFile("required", page.getFolders().rootDir, "publish.ini", errors)) {
      Utilities.checkFile("required", page.getFolders().srcDir, "navigation.xml", errors);
	    page.setIni(new IniFile(page.getFolders().rootDir+ "publish.ini"));
	    page.setVersion(page.getIni().getStringProperty("FHIR", "version"));


	    prsr = new SourceParser((Logger) page, folder, page.getDefinitions());
	    prsr.checkConditions(errors);

	    Utilities.checkFolder(page.getFolders().xsdDir, errors);
	    for (PlatformGenerator gen : page.getReferenceImplementations()) 
	      Utilities.checkFolder(page.getFolders().implDir(gen.getName()), errors);
	    Utilities.checkFolder(page.getFolders().umlDir, errors);
	    Utilities.checkFile("required", page.getFolders().srcDir, "fhir-all.xsd", errors);
      Utilities.checkFile("required", page.getFolders().srcDir, "header.htm", errors);
      Utilities.checkFile("required", page.getFolders().srcDir, "footer.htm", errors);
	    Utilities.checkFile("required", page.getFolders().srcDir, "template.htm", errors);
	    Utilities.checkFile("required", page.getFolders().srcDir, "template-print.htm", errors);
	    Utilities.checkFolder(page.getFolders().dstDir, errors);

	    for (String n : page.getIni().getPropertyNames("support"))
	      Utilities.checkFile("support", page.getFolders().srcDir, n, errors);
	    for (String n : page.getIni().getPropertyNames("images"))
	      Utilities.checkFile("image", page.getFolders().imgDir, n, errors);
	    for (String n : page.getIni().getPropertyNames("schema"))
	      Utilities.checkFile("schema", page.getFolders().srcDir, n, errors);
	    for (String n : page.getIni().getPropertyNames("pages"))
	      Utilities.checkFile("page", page.getFolders().srcDir, n, errors);

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
		ModelValidator val = new ModelValidator(page.getDefinitions());

		List<String> errors = new ArrayList<String>();
		for (String n : page.getDefinitions().getDefinedResources().keySet())
			errors.addAll(val.check(n, page.getDefinitions().getDefinedResources().get(n)));

		for (String e : errors)
			System.out.println(e);
		return errors.size() == 0;			
	}

  private void produceSpecification() throws Exception {
    page.setNavigation(new Navigation());
    page.getNavigation().parse(page.getFolders().srcDir+"navigation.xml");
    chm = new ChmMaker(page.getNavigation(),  page.getFolders(), page.getDefinitions());
    book = new BookMaker(page, chm);


    for (PlatformGenerator gen : page.getReferenceImplementations())
    {
      log("Produce "+gen.getName()+" Reference Implementation");
      gen.generate(page.getDefinitions(), page.getFolders().dstDir, page.getFolders().implDir(gen.getName()), page.getVersion(), page.getGenDate(), page);
    }
    log("Produce Schemas");
    new SchemaGenerator().generate(page.getDefinitions(), page.getIni(), page.getFolders().tmpResDir, page.getFolders().xsdDir, page.getFolders().dstDir, page.getFolders().srcDir, page.getVersion(), Config.DATE_FORMAT().format(page.getGenDate()));
    produceSchemaZip();
    log("Produce Specification");
    produceSpec(); 
    if (!isInternal) {
      log("Produce fhir.chm");
      chm.produce();
      log("Produce HL7 copy");
      new WebMaker().produceHL7Copy();
    }
  }

  
    private void produceSpec() throws Exception {
		for (String n : page.getIni().getPropertyNames("support")) 
			Utilities.copyFile(new File(page.getFolders().srcDir + n), new File(page.getFolders().dstDir + n));
		for (String n : page.getIni().getPropertyNames("images")) 
			Utilities.copyFile(new File(page.getFolders().imgDir + n), new File(page.getFolders().dstDir + n));

		for (ElementDefn n : page.getDefinitions().getDefinedResources().values())
			produceResource(n);
		for (String n : page.getIni().getPropertyNames("pages"))
			producePage(n);

		for (String n : page.getDefinitions().getProfiles().keySet())
		  produceProfile(n, page.getDefinitions().getProfiles().get(n));
		
		produceCombinedDictionary();
		Utilities.copyFile(new File(page.getFolders().umlDir + "fhir.eap"), new File(page.getFolders().dstDir + "fhir.eap"));
// todo - collect and zip the xmi files
		// Utilities.copyFile(new File(page.getFolders().umlDir + "fhir.xmi"), new File(page.getFolders().dstDir + "fhir.xmi"));
		
		produceZip();
		book.produce();
	}


	private void produceZip() throws Exception {
	  File f = new File(page.getFolders().dstDir+"fhir-spec.zip");
	  if (f.exists())
	    f.delete();
    ZipGenerator zip = new ZipGenerator(page.getFolders().tmpResDir+"fhir-spec.zip");
    zip.addFiles(page.getFolders().dstDir, "", null);
    zip.close();
    Utilities.copyFile(new File(page.getFolders().tmpResDir+"fhir-spec.zip"), f);
  }

	private void produceSchemaZip() throws Exception {
    File f = new File(page.getFolders().dstDir+"fhir-all-xsd.zip");
    if (f.exists())
      f.delete();
    ZipGenerator zip = new ZipGenerator(page.getFolders().tmpResDir+"fhir-all-xsd.zip");
    zip.addFiles(page.getFolders().dstDir, "", ".xsd");
    zip.close();
    Utilities.copyFile(new File(page.getFolders().tmpResDir+"fhir-all-xsd.zip"), f);
  }
	
  private void produceResource(ElementDefn root) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		String n = root.getName().toLowerCase();
	
		XmlSpecGenerator gen = new XmlSpecGenerator(new FileOutputStream(tmp));
		gen.generate(root);
		String xml = Utilities.fileToString(tmp.getAbsolutePath());

		TerminologyNotesGenerator tgen = new TerminologyNotesGenerator(new FileOutputStream(tmp));
		tgen.generate(root, page.getDefinitions().getConceptDomains());
		String tx = Utilities.fileToString(tmp.getAbsolutePath());

		DictHTMLGenerator dgen = new DictHTMLGenerator(new FileOutputStream(tmp));
		dgen.generate(root);
		String dict = Utilities.fileToString(tmp.getAbsolutePath());

		DictXMLGenerator dxgen = new DictXMLGenerator(new FileOutputStream(page.getFolders().dstDir+n+".dict.xml"));
		dxgen.generate(root, "HL7");

		generateProfile(root, n);
		
		String first = "";
		if (new File(page.getFolders().srcDir+n+File.separatorChar+n+"-first.htm").exists())
		  first = Utilities.fileToString(page.getFolders().srcDir+n+File.separatorChar+n+"-first.htm");
		
		File xmlf = new File(page.getFolders().srcDir+n+File.separatorChar+n+"-example.xml");
		if (!xmlf.exists())
		  xmlf = new File(page.getFolders().sndBoxDir+n+File.separatorChar+n+"-example.xml");
		File umlf = new File(page.getFolders().imgDir+n+".png");

		String src = Utilities.fileToString(page.getFolders().srcDir + "template.htm");
		src = page.processResourceIncludes(n, root, xml, tx, dict, src, first);
		Utilities.stringToFile(src, page.getFolders().dstDir + n+".htm");

		src = Utilities.fileToString(page.getFolders().srcDir + "template-print.htm").replace("<body>", "<body style=\"margin: 20px\">");
		src = page.processResourceIncludes(n, root, xml, tx, dict, src, first);
		Utilities.stringToFile(src, page.getFolders().dstDir + "print-"+n+".htm");
		Utilities.copyFile(umlf, new File(page.getFolders().dstDir+n+".png"));				
    src = Utilities.fileToString(page.getFolders().srcDir + "template-book.htm").replace("<body>", "<body style=\"margin: 10px\">");
    src = page.processResourceIncludes(n, root, xml, tx, dict, src, first);
    cachePage(n+".htm", src);

		// xml to xhtml of xml
		// first pass is to strip the xsi: stuff. seems to need double processing in order to delete namespace crap
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); 
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xdoc = builder.parse(new FileInputStream(xmlf));
		XmlGenerator xmlgen = new XmlGenerator();
		xmlgen.generate(xdoc.getDocumentElement(), new File(page.getFolders().dstDir+n+".xml"), "http://www.hl7.org/fhir", xdoc.getDocumentElement().getLocalName());

		// reload it now
		builder = factory.newDocumentBuilder();
		xdoc = builder.parse(new FileInputStream(new File(page.getFolders().dstDir+n+".xml")));
		XhtmlGenerator xhtml = new XhtmlGenerator();
		xhtml.generate(xdoc, new File(page.getFolders().dstDir+n+".xml.htm"), n.toUpperCase().substring(0, 1)+n.substring(1));
		// xml to json
		JsonGenerator jsongen = new JsonGenerator();
		jsongen.generate(new File(page.getFolders().dstDir+n+".xml"), new File(page.getFolders().dstDir+n+".json"));

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
		pgen.generate(p, new FileOutputStream(page.getFolders().dstDir+n+".profile.xml"));
  }

  private void produceProfile(String filename, ProfileDefn profile) throws Exception {
    File tmp = File.createTempFile("tmp", ".tmp");
  
    // you have to validate a profile, because it has to merged with it's base resource to fill out all the missing bits
    validateProfile(profile);
    
    XmlSpecGenerator gen = new XmlSpecGenerator(new FileOutputStream(tmp));
    gen.generate(profile);
    String xml = Utilities.fileToString(tmp.getAbsolutePath());
    
    ProfileGenerator pgen = new ProfileGenerator();
    pgen.generate(profile, new FileOutputStream(page.getFolders().dstDir+filename+".profile.xml"));
//
//    TerminologyNotesGenerator tgen = new TerminologyNotesGenerator(new FileOutputStream(tmp));
//    tgen.generate(root, page.getDefinitions().getConceptDomains());
//    String tx = Utilities.fileToString(tmp.getAbsolutePath());
//
//    DictHTMLGenerator dgen = new DictHTMLGenerator(new FileOutputStream(tmp));
//    dgen.generate(root);
//    String dict = Utilities.fileToString(tmp.getAbsolutePath());
//
//    DictXMLGenerator dxgen = new DictXMLGenerator(new FileOutputStream(page.getFolders().dstDir+n+".dict.xml"));
//    dxgen.generate(root, "HL7");
//
//    File xmlf = new File(page.getFolders().srcDir+n+File.separatorChar+"example.xml");
//    File umlf = new File(page.getFolders().imgDir+n+".png");
//
    String src = Utilities.fileToString(page.getFolders().srcDir + "template-profile.htm");
    src = page.processProfileIncludes(filename, profile, xml, src);
    Utilities.stringToFile(src, page.getFolders().dstDir + filename+".htm");
//
//    src = Utilities.fileToString(page.getFolders().srcDir + "template-print.htm").replace("<body>", "<body style=\"margin: 20px\">");
//    src = processResourceIncludes(n, root, xml, tx, dict, src);
//    Utilities.stringToFile(src, page.getFolders().dstDir + "print-"+n+".htm");
//    Utilities.copyFile(umlf, new File(page.getFolders().dstDir+n+".png"));        
//    src = Utilities.fileToString(page.getFolders().srcDir + "template-book.htm").replace("<body>", "<body style=\"margin: 10px\">");
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
//    xmlgen.generate(xdoc.getDocumentElement(), new File(page.getFolders().dstDir+n+".xml"), "http://www.hl7.org/fhir", xdoc.getDocumentElement().getLocalName());
//
//    // reload it now
//    builder = factory.newDocumentBuilder();
//    xdoc = builder.parse(new FileInputStream(new File(page.getFolders().dstDir+n+".xml")));
//    XhtmlGenerator xhtml = new XhtmlGenerator();
//    xhtml.generate(xdoc, new File(page.getFolders().dstDir+n+".xml.htm"), n.toUpperCase().substring(0, 1)+n.substring(1));
//    // xml to json
//    JsonGenerator jsongen = new JsonGenerator();
//    jsongen.generate(new File(page.getFolders().dstDir+n+".xml"), new File(page.getFolders().dstDir+n+".json"));
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
//		e.setName(page.getIni().getStringProperty("future-resources", n));
//	}


	private Profile loadResourceProfile(String name) throws FileNotFoundException, Exception {
	  XmlParser xml = new XmlParser();
	  return (Profile) xml.parse(new FileInputStream(page.getFolders().dstDir+name+".profile.xml"));
}

  private void producePage(String file) throws Exception {
		String src = Utilities.fileToString(page.getFolders().srcDir + file);
		src = page.processPageIncludes(file, src);
		Utilities.stringToFile(src, page.getFolders().dstDir + file);
		src = Utilities.fileToString(page.getFolders().srcDir + file).replace("<body>", "<body style=\"margin: 20px\">");
		src = page.processPageIncludesForPrinting(file, src);
		Utilities.stringToFile(src, page.getFolders().dstDir + "print-"+file);
		
    src = Utilities.fileToString(page.getFolders().srcDir + file).replace("<body>", "<body style=\"margin: 10px\">");
    src = page.processPageIncludesForBook(file, src);
		cachePage(file, src);
	}

	private void cachePage(String filename, String source) throws Exception {
	  try {
	    // log("parse "+filename);
	    book.getPages().put(filename,  new XhtmlParser().parse(source));
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
		sources[0] = new StreamSource(new FileInputStream(page.getFolders().dstDir+"fhir-all.xsd"));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schemaFactory.setErrorHandler(new MyErrorHandler(false));
		schemaFactory.setResourceResolver(new MyResourceResolver(page.getFolders().dstDir));
		Schema schema = schemaFactory.newSchema(sources);	

		for (String n : page.getDefinitions().getDefinedResources().keySet()) {
		  log("Validate "+n);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setValidating(false);
			factory.setSchema(schema);
			DocumentBuilder builder = factory.newDocumentBuilder();
			MyErrorHandler err = new MyErrorHandler(true);
			builder.setErrorHandler(err);
			builder.parse(new FileInputStream(new File(page.getFolders().dstDir+n+".xml")));
			if (err.getErrors().size() > 0) 
				throw new Exception("Resource Example "+n+" failed schema validation");
		}
	}

  private void produceCombinedDictionary() throws FileNotFoundException,
	UnsupportedEncodingException, Exception, IOException {
		FileOutputStream fos = new FileOutputStream(page.getFolders().dstDir+"fhir.dict.xml");
		DictXMLGenerator dxgen = new DictXMLGenerator(fos);
		dxgen.setConceptDomains(page.getDefinitions().getConceptDomains());
		dxgen.generate(page.getDefinitions().getDefinedResources().values(), "HL7");
		fos.close();
	}

	public void log(String content) {
	  page.log(content);        
	}


}
