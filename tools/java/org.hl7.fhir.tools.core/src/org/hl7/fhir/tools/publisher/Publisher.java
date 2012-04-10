package org.hl7.fhir.tools.publisher;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.hl7.fhir.definitions.generators.specification.DictHTMLGenerator;
import org.hl7.fhir.definitions.generators.specification.DictXMLGenerator;
import org.hl7.fhir.definitions.generators.specification.TerminologyNotesGenerator;
import org.hl7.fhir.definitions.generators.specification.XmlSpecGenerator;
import org.hl7.fhir.definitions.generators.xsd.SchemaGenerator;
import org.hl7.fhir.definitions.model.*;
import org.hl7.fhir.definitions.parsers.*;
import org.hl7.fhir.definitions.validation.ModelValidator;
import org.hl7.fhir.tools.core.xml.*;
import org.hl7.fhir.tools.publisher.implementations.CSharpGenerator;
import org.hl7.fhir.tools.publisher.implementations.DelphiGenerator;
import org.hl7.fhir.tools.publisher.implementations.ECoreOclFormatGenerator;
import org.hl7.fhir.tools.publisher.implementations.ECoreOclGenerator;
import org.hl7.fhir.tools.publisher.implementations.JavaGenerator;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.Utilities;
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


	public static void main(String[] args) throws Exception {
		new Publisher().execute(args[0]);
	}

	public void execute(String folder) throws Exception {
	  log("Publish FHIR in folder "+folder);

	  registerReferencePlatforms();
	  
		if (initialize(folder)) {
	    prsr.parse();
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

  private boolean	initialize(String folder) throws Exception {
	  definitions = new Definitions();
	  folders = new FolderManager(folder);

	  System.out.println("Checking Source");

	  List<String> errors = new ArrayList<String>();

	  Utilities.checkFolder(folders.rootDir, errors);
	  if (Utilities.checkFile("required", folders.rootDir, "publish.ini", errors)) {
	    ini = new IniFile(folders.rootDir+ "publish.ini");
	    version = ini.getStringProperty("FHIR", "version");
      genDate = new Date(); // new SimpleDateFormat("EEE, MMM d, yyyy").format();  full = genDateFull = new SimpleDateFormat("HH:mm MMM d, yyyy").format(new Date());
	    
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
    for (PlatformGenerator gen : referenceImplementations)
    {
      log("Produce "+gen.getName()+" Reference Implementation");
      gen.generate(definitions, folders.dstDir, folders.implDir(gen.getName()), version, genDate, this);
    }
    log("Produce Schemas");
    log("Produce Specification");
    new SchemaGenerator().generate(definitions, ini, folders.tmpResDir, folders.xsdDir, folders.dstDir, folders.srcDir, version, new SimpleDateFormat("HH:mm MMM d, yyyy").format(genDate)); 
    log("Produce ECore");
    produceSpec(); 
  }

  
	private void produceSpec() throws Exception {
		for (String n : ini.getPropertyNames("support")) 
			Utilities.copyFile(new File(folders.srcDir + n), new File(folders.dstDir + n));	
		for (String n : ini.getPropertyNames("images")) 
			Utilities.copyFile(new File(folders.imgDir + n), new File(folders.dstDir + n));

//		for (String n : ini.getPropertyNames("patterns")) 
//			producePattern(n);
//		for (String n : ini.getPropertyNames("types")) 
//			produceDataType(n);
//		for (String n : ini.getPropertyNames("datatypes")) 
//			produceDataType(n);
		for (ElementDefn n : definitions.getDefinedResources().values())
			produceResource(n);
//		for (DefinedCode n : definitions.getFutureResources().values())
//			produceFutureResource(n);
		for (String n : ini.getPropertyNames("pages"))
			producePage(n);

		produceCombinedDictionary();
		Utilities.copyFile(new File(folders.umlDir + "fhir.eap"), new File(folders.dstDir + "fhir.eap"));
		Utilities.copyFile(new File(folders.umlDir + "fhir.xmi"), new File(folders.dstDir + "fhir.xmi"));
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

		File xmlf = new File(folders.srcDir+n+File.separatorChar+"example.xml");
		File umlf = new File(folders.imgDir+n+".png");

		String src = Utilities.fileToString(folders.srcDir + "template.htm");
		src = processResourceIncludes(n, root, xml, tx, dict, src);
		Utilities.stringToFile(src, folders.dstDir + n+".htm");

		src = Utilities.fileToString(folders.srcDir + "template-print.htm");
		src = processResourceIncludes(n, root, xml, tx, dict, src);
		Utilities.stringToFile(src, folders.dstDir + "print-"+n+".htm");
		Utilities.copyFile(umlf, new File(folders.dstDir+n+".png"));				

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


//	private void produceFutureResource(String n) throws Exception {
//		ElementDefn e = new ElementDefn();
//		e.setName(ini.getStringProperty("future-resources", n));
//	}


	private void producePage(String file) throws Exception {
		String src = Utilities.fileToString(folders.srcDir + file);
		src = processPageIncludes(file, src);
		Utilities.stringToFile(src, folders.dstDir + file);
		src = Utilities.fileToString(folders.srcDir + file);
		src = processPageIncludesForPrinting(file, src);
		Utilities.stringToFile(src, folders.dstDir + "print-"+file);
	}

	public class MyErrorHandler implements ErrorHandler {

	  private boolean trackErrors;
	  private List<String> errors = new ArrayList<String>();
	  
	  public MyErrorHandler(boolean trackErrors) {
	    this.trackErrors = trackErrors;
	  }

	  @Override
	  public void error(SAXParseException arg0) throws SAXException {
	    if (trackErrors) {
	      System.out.println("error: " + arg0.toString());
	      errors.add(arg0.toString());
	    }
	  }

	  @Override
	  public void fatalError(SAXParseException arg0) throws SAXException {
	    System.out.println("fatal error: " + arg0.toString());

	  }

	  public List<String> getErrors() {
	    return errors;
	  }

	  @Override
	  public void warning(SAXParseException arg0) throws SAXException {
	  //  System.out.println("warning: " + arg0.toString());

	  }

	}

	public class MyLSInput implements LSInput {

	  private FileInputStream stream;

	  public MyLSInput(FileInputStream fileInputStream) {
	    this.stream = fileInputStream;
	  }

	  @Override
	  public String getBaseURI() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  @Override
	  public InputStream getByteStream() {
	    return stream;
	  }

	  @Override
	  public boolean getCertifiedText() {
	    // TODO Auto-generated method stub
	    return false;
	  }

	  @Override
	  public Reader getCharacterStream() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  @Override
	  public String getEncoding() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  @Override
	  public String getPublicId() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  @Override
	  public String getStringData() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  @Override
	  public String getSystemId() {
	    // TODO Auto-generated method stub
	    return null;
	  }

	  @Override
	  public void setBaseURI(String baseURI) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void setByteStream(InputStream byteStream) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void setCertifiedText(boolean certifiedText) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void setCharacterStream(Reader characterStream) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void setEncoding(String encoding) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void setPublicId(String publicId) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void setStringData(String stringData) {
	    // TODO Auto-generated method stub

	  }

	  @Override
	  public void setSystemId(String systemId) {
	    // TODO Auto-generated method stub

	  }
	} 
	
	public class MyResourceResolver implements LSResourceResolver {

	  private String dir;
	  
	  public MyResourceResolver(String dir) {
	    this.dir = dir;
	  }

	  @Override
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

		for (String n : ini.getPropertyNames("resources")) {
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
			if (com.length == 2 && com[0].equals("dt")) {
				src = s1+xmlForDt(com[1])+tsForDt(com[1])+s3;
			} else if (com.length != 1)
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
        src = s1+genDate+s3;
			else if (com[0].equals("maindiv"))
				src = s1+"<div class=\"content\">"+s3;
			else if (com[0].equals("/maindiv"))
				src = s1+"</div>"+s3;
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
        src = s1+new SimpleDateFormat("EEE, MMM d, yyyy").format(new Date())+s3;
			else if (com[0].equals("maindiv"))
				src = s1+s3;
			else if (com[0].equals("/maindiv"))
				src = s1+s3;
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
        src = s1+new SimpleDateFormat("EEE, MMM d, yyyy").format(new Date())+s3;
			else if (com[0].equals("definition"))
				src = s1+root.getDefinition()+s3;
			else if (com[0].equals("xml"))
				src = s1+xml+s3;
			else if (com[0].equals("tx"))
				src = s1+tx+s3;
			else if (com[0].equals("plural"))
				src = s1+Utilities.pluralize(name)+s3;
			else if (com[0].equals("notes"))
				src = s1+Utilities.fileToString(folders.srcDir + name+File.separatorChar+name+".htm")+s3;
			else if (com[0].equals("dictionary"))
				src = s1+dict+s3;
			else if (com[0].equals("resurl")) {
				if (isSpecial(name))
					src = s1+"This special resource has no associated URL"+s3;
				else
					src = s1+"The relative url is /"+Utilities.pluralize(name)+s3;
			} else 
				throw new Exception("Instruction <%"+s2+"%> not understood parsing resource "+name);

		}
		return src;
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

  @Override
  public void log(String content) {
    System.out.println(content);    
  }

}
