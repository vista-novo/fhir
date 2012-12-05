package org.hl7.fhir.tools.publisher;

/*
 Copyright (c) 2011-2012, HL7, Inc
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification, 
 are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
 list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
 this list of conditions and the following disclaimer in the documentation 
 and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
 endorse or promote products derived from this software without specific 
 prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 POSSIBILITY OF SUCH DAMAGE.

 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.hl7.fhir.definitions.Config;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.generators.specification.DictHTMLGenerator;
import org.hl7.fhir.definitions.generators.specification.DictXMLGenerator;
import org.hl7.fhir.definitions.generators.specification.ProfileGenerator;
import org.hl7.fhir.definitions.generators.specification.SchematronGenerator;
import org.hl7.fhir.definitions.generators.specification.TerminologyNotesGenerator;
import org.hl7.fhir.definitions.generators.specification.XmlSpecGenerator;
import org.hl7.fhir.definitions.generators.xsd.SchemaGenerator;
import org.hl7.fhir.definitions.model.BindingSpecification;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.Example;
import org.hl7.fhir.definitions.model.Example.ExampleType;
import org.hl7.fhir.definitions.model.ProfileDefn;
import org.hl7.fhir.definitions.model.RegisteredProfile;
import org.hl7.fhir.definitions.model.ResourceDefn;
import org.hl7.fhir.definitions.model.BindingSpecification.Binding;
import org.hl7.fhir.definitions.parsers.SourceParser;
import org.hl7.fhir.definitions.validation.ModelValidator;
import org.hl7.fhir.definitions.validation.ProfileValidator;
import org.hl7.fhir.instance.formats.AtomComposer;
import org.hl7.fhir.instance.formats.XmlParser;
import org.hl7.fhir.instance.model.AtomEntry;
import org.hl7.fhir.instance.model.AtomFeed;
import org.hl7.fhir.instance.model.Profile;
import org.hl7.fhir.tools.publisher.implementations.CSharpGenerator;
import org.hl7.fhir.tools.publisher.implementations.DelphiGenerator;
import org.hl7.fhir.tools.publisher.implementations.ECoreOclGenerator;
import org.hl7.fhir.tools.publisher.implementations.JavaGenerator;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.CSFileInputStream;
import org.hl7.fhir.utilities.CSVProcessor;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.SchemaInputSource;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.ZipGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlDocument;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;
import org.hl7.fhir.utilities.xml.NamespaceContextMap;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.hl7.fhir.utilities.xml.XMLWriter;
import org.hl7.fhir.utilities.xml.XhtmlGenerator;
import org.hl7.fhir.utilities.xml.XmlGenerator;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * This is the entry point for the publication method for FHIR The general order
 * of publishing is Check that everything we expect to find is found Load the
 * page.getDefinitions() Produce the specification 1. reference implementations
 * 2. schemas 4. final specification Validate the XML
 * 
 * @author Grahame
 * 
 */
public class Publisher {

	public class ExampleReference {
	  private String type;
	  private String id;
    public ExampleReference(String type, String id) {
      super();
      this.type = type;
      this.id = id;
    }
    public String describe() {
      return type+"|"+id;
    }
    public String getType() {
      return type;
    }
    public String getId() {
      return id;
    }
    
  }

  private SourceParser prsr;
	private PageProcessor page = new PageProcessor();
	private BookMaker book;
  private JavaGenerator javaReferencePlatform;

	private boolean isGenerate;
	private boolean nobook;
	private AtomFeed profileFeed;

	public static void main(String[] args) throws Exception {
		//
		Publisher pub = new Publisher();
		pub.isGenerate = !(args.length > 1 && hasParam(args, "-nogen"));
		pub.nobook = (args.length > 1 && hasParam(args, "-nobook"));
		pub.execute(args[0]);
	}

	private static boolean hasParam(String[] args, String param) {
		for (String a : args)
			if (a.equals(param))
				return true;
		return false;
	}

	public void execute(String folder) throws Exception {

		log("Publish FHIR in folder " + folder);
		registerReferencePlatforms();

		if (initialize(folder)) {
			Utilities.createDirectory(page.getFolders().dstDir);
			
			if (isGenerate) {
        Utilities.clearDirectory(page.getFolders().dstDir);
				Utilities.createDirectory(page.getFolders().dstDir + "html");
				Utilities.createDirectory(page.getFolders().dstDir + "examples");
        Utilities.clearDirectory(page.getFolders().rootDir+"temp"+File.separator+"hl7"+File.separator+"web");
        Utilities.clearDirectory(page.getFolders().rootDir+"temp"+File.separator+"hl7"+File.separator+"dload");
			}
			prsr.parse(page.getGenDate(), page.getVersion());

			if (validate()) {
				if (isGenerate) {
					String eCorePath = page.getFolders().dstDir + "ECoreDefinitions.xml";
					generateECore(prsr.getECoreParseResults(), eCorePath);
					produceSpecification(eCorePath);
				}
				validateXml();
				log("Finished publishing FHIR");
			} else
				log("Didn't publish FHIR due to errors");
		}
	}

	private void generateECore(
			org.hl7.fhir.definitions.ecore.fhir.Definitions eCoreDefinitions,
			String filename) throws IOException {
		Resource resource = new XMLResourceImpl();
		Map<String, String> options = new HashMap<String, String>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		options.put(XMLResource.OPTION_XML_VERSION, "1.0");

		resource.getContents().add(eCoreDefinitions);
		resource.save(new FileOutputStream(filename), options);
	}

	private void registerReferencePlatforms() {
		page.getReferenceImplementations().add(new DelphiGenerator());
		javaReferencePlatform = new JavaGenerator();
    page.getReferenceImplementations().add(javaReferencePlatform);
		page.getReferenceImplementations().add(new CSharpGenerator());
		page.getReferenceImplementations().add(new ECoreOclGenerator());
	}

	private boolean initialize(String folder) throws Exception {
		page.setDefinitions(new Definitions());
		page.setFolders(new FolderManager(folder));

		log("Checking Source for " + folder);

		List<String> errors = new ArrayList<String>();

		Utilities.checkFolder(page.getFolders().rootDir, errors);
		if (Utilities.checkFile("required", page.getFolders().rootDir,"publish.ini", errors)) {
			Utilities.checkFile("required", page.getFolders().srcDir,"navigation.xml", errors);
			page.setIni(new IniFile(page.getFolders().rootDir + "publish.ini"));
			page.setVersion(page.getIni().getStringProperty("FHIR", "version"));

			prsr = new SourceParser(page, folder,page.getDefinitions());
			prsr.checkConditions(errors);

			Utilities.checkFolder(page.getFolders().xsdDir, errors);
			for (PlatformGenerator gen : page.getReferenceImplementations())
				Utilities.checkFolder(page.getFolders().implDir(gen.getName()),errors);
			Utilities.checkFolder(page.getFolders().umlDir, errors);
			Utilities.checkFile("required", page.getFolders().srcDir, "fhir-all.xsd", errors);
			Utilities.checkFile("required", page.getFolders().srcDir, "header.htm", errors);
			Utilities.checkFile("required", page.getFolders().srcDir, "footer.htm", errors);
			Utilities.checkFile("required", page.getFolders().srcDir, "template.htm", errors);
			Utilities.checkFile("required", page.getFolders().srcDir, "template-book.htm", errors);
			//Utilities.checkFolder(page.getFolders().dstDir, errors);

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
			log("Unable to publish FHIR specification:");
		for (String e : errors) {
			log(e);
		}
		return errors.size() == 0;
	}

	private boolean validate() throws Exception {
		log("Validating");
		ModelValidator val = new ModelValidator(page.getDefinitions());

		List<String> errors = new ArrayList<String>();
		for (String n : page.getDefinitions().getResources().keySet())
			errors.addAll(val.check(n, page.getDefinitions().getResources().get(n)));

   for (ResourceDefn r : page.getDefinitions().getResources().values()) {
     checkExampleLinks(errors, r);
   }
		
		for (String e : errors)
			System.out.println(e);
		return errors.size() == 0;
	}

	
	
	private void checkExampleLinks(List<String> errors, ResourceDefn r) throws Exception {
    for (Example e : r.getExamples()) {
      if (e.getXml() != null) {
        List<ExampleReference> refs = new ArrayList<ExampleReference>(); 
        listLinks(e.getXml().getDocumentElement(), refs);
        for (ExampleReference ref : refs) {
          if (!resolveLink(ref)) { 
            errors.add("Unable to resolve example reference to "+ref.describe()+" in "+e.getPath());
            errors.add("  Possible Ids: "+listTargetIds(ref.getType()));
          }
        }
      }
    } 
  }

  private String listTargetIds(String type) throws Exception {
    StringBuilder b = new StringBuilder();
    ResourceDefn r = page.getDefinitions().getResourceByName(type);
    if (r != null) {
      for (Example e : r.getExamples()) {
        if (!Utilities.noString(e.getId()))
          b.append(e.getId()+", ");
        if (e.getXml().getDocumentElement().getLocalName().equals("feed")) {
          List<Element> entries = new ArrayList<Element>();
          XMLUtil.getNamedChildren(e.getXml().getDocumentElement(), "entry", entries);
          for (Element c : entries) {
            String id = XMLUtil.getNamedChild(c, "id").getTextContent();
            if (id.startsWith("http://hl7.org/fhir/") && id.contains("@"))
              b.append(id.substring(id.indexOf("@")+1)+", ");
            else
              b.append(id+", ");
          }
        }
      }
    } else
      b.append("(unknown resource type)");    
    return b.toString();
  }

  private boolean resolveLink(ExampleReference ref) throws Exception {
    if (!page.getDefinitions().hasResource(ref.getType()))
      return false;
    ResourceDefn r = page.getDefinitions().getResourceByName(ref.getType());
    for (Example e : r.getExamples()) {
      String id = ref.getId();
      if (id.equals(e.getId()))
        return true;
      if (e.getXml().getDocumentElement().getLocalName().equals("feed")) {
        List<Element> entries = new ArrayList<Element>();
        XMLUtil.getNamedChildren(e.getXml().getDocumentElement(), "entry", entries);
        for (Element c : entries) {
          String _id = XMLUtil.getNamedChild(c, "id").getTextContent();
          if (id.equals(_id) || _id.equals("http://hl7.org/fhir/"+ref.getType().toLowerCase()+"/@"+id))
            return true;
        }
      }
    }
    return false;
  }

  private void listLinks(Element xml, List<ExampleReference> refs) throws Exception {
    if (xml.getLocalName().equals("feed")) {
      Element n = XMLUtil.getFirstChild(xml);
      while (n != null) {
        if (n.getLocalName().equals("entry")) {
          Element c = XMLUtil.getNamedChild(n, "content");
          listLinks(XMLUtil.getFirstChild(c), refs);          
        }
        n = XMLUtil.getNextSibling(n);
      }
    } else {
      String n = xml.getLocalName();
      ResourceDefn r = page.getDefinitions().getResourceByName(n);
      if (r == null) 
        throw new Exception("Unable to find resource definition for "+n);
      List<Element> nodes = new ArrayList<Element>();
      nodes.add(xml);
      listLinks("/f:"+n, r.getRoot(), nodes, refs);
    }
  }

  private void listLinks(String path, org.hl7.fhir.definitions.model.ElementDefn d, List<Element> set, List<ExampleReference> refs) throws Exception {
    if (d.typeCode().contains("Resource") && !d.typeCode().equals("Resource")) {
      for (Element m : set) {
        if (XMLUtil.getNamedChild(m, "type") != null && XMLUtil.getNamedChild(m, "id") != null) {
          refs.add(new ExampleReference(XMLUtil.getNamedChild(m, "type").getTextContent(), XMLUtil.getNamedChild(m, "id").getTextContent()));
        }
      }
    }    
    for (org.hl7.fhir.definitions.model.ElementDefn c : d.getElements()) {
      List<Element> cset = new ArrayList<Element>();
      for (Element p : set) 
        XMLUtil.getNamedChildren(p, c.getName(), cset);
      listLinks(path+"/f:"+c.getName(), c, cset, refs);
    }
  }

//  private List<Element> xPathQuery(String path, Element e) throws Exception {
//    NamespaceContext context = new NamespaceContextMap("f", "http://hl7.org/fhir", "h", "http://www.w3.org/1999/xhtml");
//
//    XPathFactory factory = XPathFactory.newInstance();
//    XPath xpath = factory.newXPath();
//    xpath.setNamespaceContext(context);
//    XPathExpression expression= xpath.compile(path);
//    NodeList resultNodes = (NodeList)expression.evaluate(e, XPathConstants.NODESET);
//    List<Element> result = new ArrayList<Element>();
//    for (int i = 0; i < resultNodes.getLength(); i++) {
//      result.add((Element) resultNodes.item(i));
//    }
//    return result;
//  }

  private void produceSpecification(String eCorePath) throws Exception {
		page.setNavigation(new Navigation());
		page.getNavigation().parse(page.getFolders().srcDir + "navigation.xml");
		book = new BookMaker(page);

		XMIResource resource = new XMIResourceImpl();
		resource.load(new CSFileInputStream(eCorePath), null);
		org.hl7.fhir.definitions.ecore.fhir.Definitions eCoreDefs = (org.hl7.fhir.definitions.ecore.fhir.Definitions) resource.getContents().get(0);

		for (PlatformGenerator gen : page.getReferenceImplementations()) {
			log("Produce " + gen.getName() + " Reference Implementation");

			String destDir = page.getFolders().dstDir;
			String implDir = page.getFolders().implDir(gen.getName());

			if (!gen.isECoreGenerator())
				gen.generate(page.getDefinitions(), destDir, implDir, page.getVersion(), page.getGenDate().getTime(), page);
			else
				gen.generate(eCoreDefs, destDir, implDir, page);
		}
		for (PlatformGenerator gen : page.getReferenceImplementations()) {
			if (gen.doesCompile()) {
				log("Compile " + gen.getName() + " Reference Implementation");
				if (!gen.compile(page.getFolders().rootDir, new ArrayList<String>())) {
//					log("Compile " + gen.getName() + " failed");
					throw new Exception("Compile " + gen.getName() + " failed");
				}
			}
		}

		log("Produce Schemas");
		new SchemaGenerator().generate(page.getDefinitions(), page.getIni(), page.getFolders().tmpResDir, page.getFolders().xsdDir, page.getFolders().dstDir, 
		      page.getFolders().srcDir, page.getVersion(), Config.DATE_FORMAT().format(page.getGenDate().getTime()));
		for (ResourceDefn r : page.getDefinitions().getResources().values()) {
			String n = r.getName().toLowerCase();
			SchematronGenerator sch = new SchematronGenerator(new FileOutputStream(page.getFolders().dstDir + n + ".sch"), page);
			sch.generate(r.getRoot(), page.getDefinitions());
			sch.close();
		}

		SchematronGenerator sg = new SchematronGenerator(new FileOutputStream(page.getFolders().dstDir + "fhir-atom.sch"), page);
		sg.generate(page.getDefinitions());
		sg.close();
		
		produceSchemaZip();
		log("Produce Content");
		produceSpec();

		if (!nobook) {
			log("Produce HL7 copy");
			new WebMaker(page.getFolders(), page.getVersion(), page.getIni()).produceHL7Copy();
			log("Produce Archive copy");
			produceArchive();
		}
	}

	private void produceArchive() throws Exception {
		String target = page.getFolders().rootDir + "archive" + File.separator
				+ "v" + page.getVersion() + ".zip";
		File tf = new CSFile(target);
		if (tf.exists())
			tf.delete();

		ZipGenerator zip = new ZipGenerator(target);

		int c = 0;
		String[] files = new CSFile(page.getFolders().dstDir).list();
		for (String f : files) {
			File fn = new CSFile(page.getFolders().dstDir + f);
			if (!fn.isDirectory()) {
				if (f.endsWith(".htm")) {
					String src = TextFile.fileToString(fn.getAbsolutePath());
					String srcn = src
							.replace(
									"Warning: FHIR is a draft specification that is still undergoing development prior to balloting as a full HL7 standard",
									"This is an old version of FHIR retained for archive purposes. Do not use for anything else");
					if (!srcn.equals(src))
						c++;
					srcn = srcn.replace("<body>",
							"<body><div class=\"watermark\"/>").replace(
							"<body class=\"book\">",
							"<body class=\"book\"><div class=\"watermark\"/>");
					zip.addFileSource(f, srcn);
					// Utilities.stringToFile(srcn, target+File.separator+f);
				} else if (f.endsWith(".css")) {
					String src = TextFile.fileToString(fn.getAbsolutePath());
					src = src.replace("#fff", "lightcyan");
					zip.addFileSource(f, src);
					// Utilities.stringToFile(srcn, target+File.separator+f);
				} else
					zip.addFileName(f, fn.getAbsolutePath());
			} else {
				// used to put stuff in sub-directories. clean them out if they
				// still exist
				Utilities.clearDirectory(fn.getAbsolutePath());
				fn.delete();
			}
		}
		if (c < 3)
			throw new Exception("header note replacement in archive failed");
		zip.close();
	}

	private void produceSpec() throws Exception {
		for (String n : page.getIni().getPropertyNames("support"))
			Utilities.copyFile(new CSFile(page.getFolders().srcDir + n),
					new CSFile(page.getFolders().dstDir + n));
		for (String n : page.getIni().getPropertyNames("images"))
			Utilities.copyFile(new CSFile(page.getFolders().imgDir + n),
					new CSFile(page.getFolders().dstDir + n));

    generateCodeSystems();

    profileFeed = new AtomFeed();
		profileFeed.setId("http://hl7.org/fhir/profile/resources");
		profileFeed.setTitle("Resources as Profiles");
		profileFeed.setLink("http://hl7.org/implement/standards/fhir/profiles-resources.xml");
		profileFeed.setUpdated(Calendar.getInstance());
		for (ResourceDefn n : page.getDefinitions().getResources().values()) {
      log(" ...resource "+n.getName());
			produceResource(n);
		}
		for (org.hl7.fhir.definitions.model.ElementDefn n : page.getDefinitions().getStructures().values()) {
      log(" ...diagram "+n.getName());
      generateDiagram(n);
		}
		new AtomComposer().compose(new FileOutputStream(page.getFolders().dstDir + "profiles-resources.xml"), profileFeed, true, false);
		Utilities.copyFile(new CSFile(page.getFolders().dstDir + "profiles-resources.xml"), new CSFile(page.getFolders().dstDir + "examples" + File.separator + "profiles-resources.xml"));
		cloneToXhtml("profiles-resources", "Base Resources defined as profiles (implementation assistance, for derivation and product development)");
		for (String n : page.getIni().getPropertyNames("pages")) {
		  log(" ...page "+n);
			producePage(n, page.getIni().getStringProperty("pages", n));
		}

		
		for (String n : page.getDefinitions().getProfiles().keySet()) {
      log(" ...profile "+n);
			produceProfile(n, page.getDefinitions().getProfiles().get(n));
		}

    log(" ...summaries");
		produceCombinedDictionary();
		Utilities.copyFile(new CSFile(page.getFolders().umlDir + "fhir.eap"),
				new CSFile(page.getFolders().dstDir + "fhir.eap"));
		// todo - collect and zip the xmi files
		// Utilities.copyFile(new CSFile(page.getFolders().umlDir + "fhir.xmi"),
		// new CSFile(page.getFolders().dstDir + "fhir.xmi"));

    log(" ...zips");
    ZipGenerator zip = new ZipGenerator(page.getFolders().dstDir + "examples.zip");
    zip.addFiles(page.getFolders().dstDir + "examples" + File.separator, "", null);
    zip.close();

    zip = new ZipGenerator(page.getFolders().dstDir + "examples-json.zip");
    zip.addFiles(page.getFolders().dstDir, "", ".json");
    zip.close();

    log(" ...zip");
    produceZip();
    
    log("Produce Book Form");
    book.produce();
	}

	private void produceZip() throws Exception {
		File f = new CSFile(page.getFolders().dstDir + "fhir-spec.zip");
		if (f.exists())
			f.delete();
		ZipGenerator zip = new ZipGenerator(page.getFolders().tmpResDir
				+ "fhir-spec.zip");
		zip.addFiles(page.getFolders().dstDir, "", null);
		zip.close();
		Utilities.copyFile(new CSFile(page.getFolders().tmpResDir
				+ "fhir-spec.zip"), f);
	}

	private void produceSchemaZip() throws Exception {
		char sc = File.separatorChar;
		File f = new CSFile(page.getFolders().dstDir + "fhir-all-xsd.zip");
		if (f.exists())
			f.delete();
		ZipGenerator zip = new ZipGenerator(page.getFolders().tmpResDir
				+ "fhir-all-xsd.zip");
		zip.addFiles(page.getFolders().dstDir, "", ".xsd");
		zip.addFiles(page.getFolders().dstDir, "", ".sch");
		zip.addFiles(page.getFolders().rootDir + "tools" + sc + "schematron" + sc, "", ".xsl");
		zip.close();
		Utilities.copyFile(new CSFile(page.getFolders().tmpResDir + "fhir-all-xsd.zip"), f);
	}

	private void produceResource(ResourceDefn resource) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		tmp.deleteOnExit();
		String n = resource.getName().toLowerCase();

		XmlSpecGenerator gen = new XmlSpecGenerator(new FileOutputStream(tmp), n + "-definitions.htm", null, page.getDefinitions());
		gen.generate(resource.getRoot());
		gen.close();
		String xml = TextFile.fileToString(tmp.getAbsolutePath());

		TerminologyNotesGenerator tgen = new TerminologyNotesGenerator(new FileOutputStream(tmp), page);
		tgen.generate(resource.getRoot(), page.getDefinitions().getBindings());
		tgen.close();
		String tx = TextFile.fileToString(tmp.getAbsolutePath());

		DictHTMLGenerator dgen = new DictHTMLGenerator(new FileOutputStream(tmp));
		dgen.generate(resource.getRoot());
		dgen.close();
		
		String dict = TextFile.fileToString(tmp.getAbsolutePath());

		DictXMLGenerator dxgen = new DictXMLGenerator(new FileOutputStream(page.getFolders().dstDir + n + ".dict.xml"));
		dxgen.generate(resource.getRoot(), "HL7");
		dxgen.close();

		generateProfile(resource, n, xml);
		generateDiagram(resource, n);
		
		for (RegisteredProfile p : resource.getProfiles())
			produceProfile(p.getFilename(), p.getProfile());

		for (Example e : resource.getExamples()) {
		  try {
			  processExample(e);
		  } catch (Exception ex) {
		    throw new Exception("processing "+e.getFileTitle(), ex);
//		    throw new Exception(ex.getMessage()+" processing "+e.getFileTitle());
		  }
		}

    String prefix = page.getNavigation().getIndexPrefixForFile(n+".htm");
    if (Utilities.noString(prefix))
      prefix = "3."+Integer.toString(page.getOrderedResources().indexOf(resource.getName())+1);
    SectionTracker st = new SectionTracker(prefix);
    page.getSectionTrackerCache().put(n, st);

    String src = TextFile.fileToString(page.getFolders().srcDir+ "template.htm");
		src = insertSectionNumbers(page.processResourceIncludes(n, resource, xml, tx, dict, src), st, n+".htm");
		TextFile.stringToFile(src, page.getFolders().dstDir + n + ".htm");
			
    String pages = page.getIni().getStringProperty("resource-pages", n);
    if (!Utilities.noString(pages)) {
      for (String p : pages.split(",")) {
        producePage(p, n);
      }
    }
		
		src = TextFile.fileToString(page.getFolders().srcDir+ "template-examples.htm");
		TextFile.stringToFile(insertSectionNumbers(page.processResourceIncludes(n, resource, xml, tx, dict, src), st, n + "-examples.htm"), page.getFolders().dstDir + n + "-examples.htm");
		src = TextFile.fileToString(page.getFolders().srcDir + "template-definitions.htm");
		TextFile.stringToFile(insertSectionNumbers(page.processResourceIncludes(n, resource, xml, tx, dict, src), st, n + "-definitions.htm"), page.getFolders().dstDir + n + "-definitions.htm");
		src = TextFile.fileToString(page.getFolders().srcDir + "template-explanations.htm");
		TextFile.stringToFile(insertSectionNumbers(page.processResourceIncludes(n, resource, xml, tx, dict, src), st, n + "-explanations.htm"), page.getFolders().dstDir + n + "-explanations.htm");
		src = TextFile.fileToString(page.getFolders().srcDir + "template-profiles.htm");
		TextFile.stringToFile(insertSectionNumbers(page.processResourceIncludes(n, resource, xml, tx, dict, src), st, n + "-profiles.htm"), page.getFolders().dstDir + n + "-profiles.htm");

		src = TextFile.fileToString(page.getFolders().srcDir + "template-book.htm").replace("<body>", "<body style=\"margin: 10px\">");
		src = page.processResourceIncludes(n, resource, xml, tx, dict, src);
		cachePage(n + ".htm", src);
		src = TextFile.fileToString(page.getFolders().srcDir + "template-book-ex.htm").replace("<body>", "<body style=\"margin: 10px\">");
		src = page.processResourceIncludes(n, resource, xml, tx, dict, src);
		cachePage(n + "Ex.htm", src);
		src = TextFile.fileToString(page.getFolders().srcDir + "template-book-defn.htm").replace("<body>", "<body style=\"margin: 10px\">");
		src = page.processResourceIncludes(n, resource, xml, tx, dict, src);
		cachePage(n + "Defn.htm", src);

		// xml to json
		// todo - fix this up
		// JsonGenerator jsongen = new JsonGenerator();
		// jsongen.generate(new CSFile(page.getFolders().dstDir+n+".xml"), new
		// File(page.getFolders().dstDir+n+".json"));

		tmp.delete();

	}

	private void generateDiagram(ResourceDefn resource, String n) throws Exception {
    StringBuilder s = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
    s.append("@startuml\r\n");
    s.append("title "+resource.getName()+"\r\n");
    s.append("skinparam nodesep 10\r\n");
    s.append("skinparam ranksep 10\r\n");
    s.append("skinparam classBackgroundColor Aliceblue\r\n\r\n");
    s.append("skinparam classBorderColor Gray\r\n\r\n");
    s.append("skinparam classArrowColor Navy\r\n\r\n");

    List<org.hl7.fhir.definitions.model.ElementDefn> queue = new ArrayList<org.hl7.fhir.definitions.model.ElementDefn>();
    Map<org.hl7.fhir.definitions.model.ElementDefn, String> names = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
    queue.add(resource.getRoot());
    names.put(resource.getRoot(), resource.getName());
    while (queue.size() > 0) {
      org.hl7.fhir.definitions.model.ElementDefn r = queue.get(0);
      queue.remove(0);
      generateDiagramClass(r, queue, names, s, s2, r == resource.getRoot(), true);
    }  
    s.append("\r\n"+s2);
    s.append("hide methods\r\n");
    s.append("@enduml\r\n");
    TextFile.stringToFile(s.toString(), page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+resource.getName().toLowerCase()+".plantuml-source");
    SourceStringReader rdr = new SourceStringReader(s.toString());
    FileOutputStream png = new FileOutputStream(page.getFolders().dstDir + n + ".png");
    rdr.generateImage(png);
//    FileOutputStream svg = new FileOutputStream(page.getFolders().dstDir + n + ".svg");
//    rdr.generateImage(svg, new FileFormatOption(FileFormat.SVG));
//    FileOutputStream xmi = new FileOutputStream(page.getFolders().dstDir + n + ".xmi");
//    rdr.generateImage(xmi, new FileFormatOption(FileFormat.XMI_STANDARD));
	}
	
  private void generateDiagram(org.hl7.fhir.definitions.model.ElementDefn element) throws Exception {
    StringBuilder s = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
    s.append("@startuml\r\n");
    s.append("title "+element.getName()+"\r\n");
    s.append("skinparam nodesep 10\r\n");
    s.append("skinparam ranksep 10\r\n");
    s.append("skinparam classBackgroundColor Aliceblue\r\n\r\n");
    s.append("skinparam classBorderColor Gray\r\n\r\n");
    s.append("skinparam classArrowColor Navy\r\n\r\n");

    List<org.hl7.fhir.definitions.model.ElementDefn> queue = new ArrayList<org.hl7.fhir.definitions.model.ElementDefn>();
    Map<org.hl7.fhir.definitions.model.ElementDefn, String> names = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
    queue.add(element);
    names.put(element, element.getName());
    while (queue.size() > 0) {
      org.hl7.fhir.definitions.model.ElementDefn r = queue.get(0);
      queue.remove(0);
      generateDiagramClass(r, queue, names, s, s2, r == element, false);
    }  
    s.append("\r\n"+s2);
    s.append("hide methods\r\n");
    s.append("@enduml\r\n");
    TextFile.stringToFile(s.toString(), page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+element.getName().toLowerCase()+".plantuml-source");
    SourceStringReader rdr = new SourceStringReader(s.toString());
    FileOutputStream png = new FileOutputStream(page.getFolders().dstDir + element.getName().toLowerCase() + ".png");
    rdr.generateImage(png);
//    FileOutputStream svg = new FileOutputStream(page.getFolders().dstDir + n + ".svg");
//    rdr.generateImage(svg, new FileFormatOption(FileFormat.SVG));
//    FileOutputStream xmi = new FileOutputStream(page.getFolders().dstDir + n + ".xmi");
//    rdr.generateImage(xmi, new FileFormatOption(FileFormat.XMI_STANDARD));
  }
  
	
	private void generateDiagramClass(org.hl7.fhir.definitions.model.ElementDefn r, List<org.hl7.fhir.definitions.model.ElementDefn> queue, Map<org.hl7.fhir.definitions.model.ElementDefn, String> names, StringBuilder s, StringBuilder s2, boolean entry, boolean resource) throws Exception {
	  String rn; 
    if (names.keySet().contains(r))
      rn = names.get(r);
    else 
      rn = Utilities.capitalize(r.getName());

	  for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
	    if (e.getTypes().size() == 0 || e.typeCode().startsWith("@") || page.getDefinitions().dataTypeIsSharedInfo(e.typeCode())) {
	      String n;
	      org.hl7.fhir.definitions.model.ElementDefn t = null;
	      if (names.keySet().contains(e))
	        n = names.get(e);
	      else if (page.getDefinitions().dataTypeIsSharedInfo(e.typeCode())) {
	        n = e.typeCode();
	        t = page.getDefinitions().getElementDefn(n);
          names.put(t, n);
          queue.add(t);
	      } else {
	        n = Utilities.capitalize(e.getName());
	        names.put(e, n);
          queue.add(e);
	      }
	      String ta = t != null ? "(S, #FFD700)" : "(E, Lemonchiffon)";
	      if (!entry)
          s.append(rn+" << (E, Lemonchiffon) >>  *-"+e.getDir()+"- \""+e.describeCardinality()+"\" "+n+"  << "+ta+" >> : "+e.getName()+"\r\n");
	      else if (resource)
          s.append(rn+" << (R, #FF7700) >> *-"+e.getDir()+"- \""+e.describeCardinality()+"\" "+n+"  << "+ta+" >> : "+e.getName()+"\r\n");
	      else
          s.append(rn+" << (D, #FFA500) >> *-"+e.getDir()+"- \""+e.describeCardinality()+"\" "+n+"  << "+ta+" >> : "+e.getName()+"\r\n");
	    }
	  }
	  if (entry)
	    s2.append("class "+rn+" << (R, #FF7700) >> {\r\n");
	  else if (page.getDefinitions().dataTypeIsSharedInfo(r.typeCode()))
	    s2.append("class "+rn+" << (S, #FFD700) >> {\r\n");
	  else
	    s2.append("class "+rn+" << (E, Lemonchiffon) >> {\r\n");
	  for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
	    if (e.getTypes().size() > 0 && !e.typeCode().startsWith("@") && !page.getDefinitions().dataTypeIsSharedInfo(e.typeCode())) {
	      s2.append("  "+e.getName()+" : "+e.typeCode()+" "+e.describeCardinality()+"\r\n");
	    }
	  }
	  s2.append("  --\r\n}\r\n\r\n");
	}


/*
 * Candidate diagram source for Alex Henket. Retired for now
  private void generateDiagramSource(ResourceDefn resource) throws Exception {
    XMLWriter w = new XMLWriter(new FileOutputStream(page.getFolders().rootDir+"temp"+File.separator+"diagram"+File.separator+resource.getName().toLowerCase()+".diagram-source"), "UTF-8");
    w.setPretty(true);
    w.start();
    w.attribute("name", resource.getName());
    w.open("diagram");
    List<org.hl7.fhir.definitions.model.ElementDefn> queue = new ArrayList<org.hl7.fhir.definitions.model.ElementDefn>();
    Map<org.hl7.fhir.definitions.model.ElementDefn, String> names = new HashMap<org.hl7.fhir.definitions.model.ElementDefn, String>(); 
    queue.add(resource.getRoot());
    names.put(resource.getRoot(), resource.getName());
    while (queue.size() > 0) {
      org.hl7.fhir.definitions.model.ElementDefn r = queue.get(0);
      queue.remove(0);
      generateDiagramClass(r, queue, names, w, r == resource.getRoot());
    }
    w.close("diagram");
    w.close();
  }

  private void generateDiagramClass(org.hl7.fhir.definitions.model.ElementDefn r, List<org.hl7.fhir.definitions.model.ElementDefn> queue, Map<org.hl7.fhir.definitions.model.ElementDefn, String> names, XMLWriter w, boolean entry) throws Exception {
    w.attribute("name", names.get(r));
    if (entry) 
      w.attribute("entry", "yes");
    w.open("class");
    for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
      if (e.getTypes().size() > 0) {
        w.attribute("name", e.getName());
        w.attribute("type", e.typeCode());
        w.attribute("cardinality", e.describeCardinality());
        w.open("attribute");
        w.close("attribute");        
      }
    }
    for (org.hl7.fhir.definitions.model.ElementDefn e : r.getElements()) {
      if (e.getTypes().size() == 0) {
        w.attribute("name", e.getName());
        w.attribute("cardinality", e.describeCardinality());
        String n;
        if (names.keySet().contains(e))
          n = names.get(e);
        else {
          n = Utilities.capitalize(e.getName());
          names.put(e, n);
          queue.add(e);
        }
        w.attribute("target", n);
        w.open("association");
        w.close("association");
        //queue.add(e);
      }
    }
    w.close("class");
    
  }
*/
	
  private void cloneToXhtml(String n, String description) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document xdoc = builder.parse(new CSFileInputStream(new CSFile(page
				.getFolders().dstDir + n + ".xml")));
		XhtmlGenerator xhtml = new XhtmlGenerator(null);
		xhtml.generate(xdoc,
				new CSFile(page.getFolders().dstDir + n + ".xml.htm"), n
						.toUpperCase().substring(0, 1) + n.substring(1),
				description);
	}

	private void processExample(Example e) throws Exception {
		if (e.getType() == ExampleType.Tool)
			return;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		String n = e.getFileTitle();

		if (!e.getPath().exists())
		  throw new Exception("unable to find example file");

		// strip the xsi: stuff. seems to need double processing in order to
		// delete namespace crap
		Document xdoc = e.getXml() == null ? builder.parse(new CSFileInputStream(e.getPath())) : e.getXml();
		XmlGenerator xmlgen = new XmlGenerator();
		if (xdoc.getDocumentElement().getLocalName().equals("feed"))
		  xmlgen.generate(xdoc.getDocumentElement(), new CSFile(page.getFolders().dstDir + n + ".xml"), "http://www.w3.org/2005/Atom", xdoc.getDocumentElement().getLocalName());
		else {
		  xmlgen.generate(xdoc.getDocumentElement(), new CSFile(page.getFolders().dstDir + n + ".xml"), "http://hl7.org/fhir", xdoc.getDocumentElement().getLocalName());
		}

		// generate the json version (use the java reference platform)
    try {
      javaReferencePlatform.convertToJson(page.getFolders().dstDir, page.getFolders().dstDir + n + ".xml", page.getFolders().dstDir + n + ".json");
    } catch (Throwable t) {
      t.printStackTrace(System.err);
      TextFile.stringToFile(t.getMessage(), page.getFolders().dstDir + n + ".json");
    }
    String json;
    try {
      json = Utilities.escapeXml(new JSONObject(TextFile.fileToString(page.getFolders().dstDir + n + ".json")).toString(2));
    } catch (Throwable t) {
      t.printStackTrace(System.err);
      json = t.getMessage();
    }
    
    String head = 
    "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\">\r\n<head>\r\n <title>"+Utilities.escapeXml(e.getDescription())+"</title>\r\n <link rel=\"Stylesheet\" href=\"fhir.css\" type=\"text/css\" media=\"screen\"/>\r\n"+
    "</head>\r\n<body>\r\n<p>&nbsp;</p>\r\n<div class=\"example\">\r\n<p>"+Utilities.escapeXml(e.getDescription())+"</p>\r\n<pre class=\"json\">\r\n";
    String tail = "\r\n</pre>\r\n</div>\r\n</body>\r\n</html>\r\n";
    TextFile.stringToFile(head+json+tail, page.getFolders().dstDir + n + ".json.htm");
    e.setJson("<div class=\"example\">\r\n<p>"+Utilities.escapeXml(e.getDescription())+"</p>\r\n<pre class=\"json\">\r\n"+json+"\r\n</pre>\r\n</div>\r\n");  

		// reload it now, xml to xhtml of xml
		builder = factory.newDocumentBuilder();
		xdoc = builder.parse(new CSFileInputStream(new CSFile(page.getFolders().dstDir + n + ".xml")));
		XhtmlGenerator xhtml = new XhtmlGenerator(new ExampleAdorner(page.getDefinitions()));
		xhtml.generate(xdoc, new CSFile(page.getFolders().dstDir + n + ".xml.htm"), n.toUpperCase().substring(0, 1) + n.substring(1), Utilities.noString(e.getId()) ? e.getDescription() : e.getDescription()+" (id = \""+e.getId()+"\")");
		if (e.isInBook()) {
			XhtmlDocument d = new XhtmlParser().parse(new CSFileInputStream(page.getFolders().dstDir + n + ".xml.htm"));
			XhtmlNode pre = d.getElement("html").getElement("body").getElement("div");
			e.setXhtm(new XhtmlComposer().compose(pre));
		}
		if (!Utilities.noString(e.getId()))
      Utilities.copyFile(new CSFile(page.getFolders().dstDir + n + ".xml"), new CSFile(page.getFolders().dstDir + "examples" + File.separator + n + "("+e.getId()+").xml"));
		else
		  Utilities.copyFile(new CSFile(page.getFolders().dstDir + n + ".xml"), new CSFile(page.getFolders().dstDir + "examples" + File.separator + n + ".xml"));
	}

	private void generateProfile(ResourceDefn root, String n, String xmlSpec)	throws Exception, FileNotFoundException {
		ProfileDefn p = new ProfileDefn();
		p.putMetadata("id", root.getName().toLowerCase());
		p.putMetadata("name", n);
		p.putMetadata("author.name", "todo (committee)");
		p.putMetadata("author.ref", "todo");
		p.putMetadata("description", "Basic Profile. "+ root.getRoot().getDefinition());
		p.putMetadata("status", "testing");
		p.putMetadata("date", new SimpleDateFormat("yyyy-MM-dd", new Locale("en", "US")).format(new Date()));
		p.getResources().add(root);
		ProfileGenerator pgen = new ProfileGenerator();
		Profile rp = pgen.generate(p, new FileOutputStream(page.getFolders().dstDir + n + ".profile.xml"), xmlSpec);
		Utilities.copyFile(new CSFile(page.getFolders().dstDir + n+ ".profile.xml"), new CSFile(page.getFolders().dstDir+ "examples" + File.separator + n + ".profile.xml"));
		addToResourceFeed(rp, root.getName().toLowerCase());
		saveAsPureHtml(rp, new FileOutputStream(page.getFolders().dstDir+ "html" + File.separator + n + ".htm"));
	}

	private void saveAsPureHtml(Profile resource, FileOutputStream stream) throws Exception {
		XhtmlDocument html = new XhtmlDocument();
		html.setNodeType(NodeType.Document);
		html.addComment("Generated by automatically by FHIR Tooling");
		XhtmlNode doc = html.addTag("html");
		XhtmlNode head = doc.addTag("head");
		XhtmlNode work = head.addTag("title");
		work.addText("test title");
		work = head.addTag("link");
		work.setAttribute("rel", "Stylesheet");
		work.setAttribute("href", "/css/fhir.css");
		work.setAttribute("type", "text/css");
		work.setAttribute("media", "screen");
		work = doc.addTag("body");
		if ((resource.getText() != null) && (resource.getText().getDiv() != null)) {
			work.getAttributes().putAll(resource.getText().getDiv().getAttributes());
			work.getChildNodes().addAll(resource.getText().getDiv().getChildNodes());
		}
		XhtmlComposer xml = new XhtmlComposer();
		xml.setPretty(false);
		xml.compose(stream, html);
	}

	private void addToResourceFeed(Profile profile, String id) {
		AtomEntry e = new AtomEntry();
		e.setId("http://hl7.org/fhir/profile/" + id);
		e.setLink("http://hl7.org/implement/standards/fhir/" + id+ ".profile.xml");
		e.setTitle("Resource \"" + id+ "\" as a profile (to help derivation)");
		e.setUpdated(page.getGenDate());
		e.setPublished(page.getGenDate());
		e.setAuthorName("HL7, Inc");
		e.setAuthorUri("http://hl7.org");
		e.setCategory("Profile");
		e.setResource(profile);
		e.setSummary(profile.getText().getDiv());
		profileFeed.getEntryList().add(e);
	}

	private void produceProfile(String filename, ProfileDefn profile)
			throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		tmp.deleteOnExit();

		// you have to validate a profile, because it has to be merged with it's
		// base resource to fill out all the missing bits
		validateProfile(profile);

		XmlSpecGenerator gen = new XmlSpecGenerator(new FileOutputStream(tmp), null, "http://hl7.org/fhir/", page.getDefinitions());
		gen.generate(profile);
		gen.close();
		String xml = TextFile.fileToString(tmp.getAbsolutePath());

		ProfileGenerator pgen = new ProfileGenerator();
		pgen.generate(profile, new FileOutputStream(page.getFolders().dstDir
				+ filename + ".profile.xml"), xml);
		Utilities.copyFile(new CSFile(page.getFolders().dstDir + filename
				+ ".profile.xml"), new CSFile(page.getFolders().dstDir
				+ "examples" + File.separator + filename + ".profile.xml"));

		TerminologyNotesGenerator tgen = new TerminologyNotesGenerator(new FileOutputStream(tmp), page);
		tgen.generate(profile);
		tgen.close();
		String tx = TextFile.fileToString(tmp.getAbsolutePath());
		//
		// DictHTMLGenerator dgen = new DictHTMLGenerator(new
		// FileOutputStream(tmp));
		// dgen.generate(root);
		// String dict = Utilities.fileToString(tmp.getAbsolutePath());
		//
		// DictXMLGenerator dxgen = new DictXMLGenerator(new
		// FileOutputStream(page.getFolders().dstDir+n+".dict.xml"));
		// dxgen.generate(root, "HL7");
		//
		// File xmlf = new
		// File(page.getFolders().srcDir+n+File.separatorChar+"example.xml");
		// File umlf = new CSFile(page.getFolders().imgDir+n+".png");
		//
		String src = TextFile.fileToString(page.getFolders().srcDir
				+ "template-profile.htm");
		src = page.processProfileIncludes(filename, profile, xml, tx, src);
		TextFile.stringToFile(src, page.getFolders().dstDir + filename + ".htm");
		//
		// src = Utilities.fileToString(page.getFolders().srcDir +
		// "template-print.htm").replace("<body>",
		// "<body style=\"margin: 20px\">");
		// src = processResourceIncludes(n, root, xml, tx, dict, src);
		// Utilities.stringToFile(src, page.getFolders().dstDir +
		// "print-"+n+".htm");
		// Utilities.copyFile(umlf, new
		// File(page.getFolders().dstDir+n+".png"));
		// src = Utilities.fileToString(page.getFolders().srcDir +
		// "template-book.htm").replace("<body>",
		// "<body style=\"margin: 10px\">");
		// src = processResourceIncludes(n, root, xml, tx, dict, src);
		// cachePage(n+".htm", src);
		//
		// xml to xhtml of xml
		// first pass is to strip the xsi: stuff. seems to need double
		// processing in order to delete namespace crap
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xdoc = builder.parse(new CSFileInputStream(
				page.getFolders().dstDir + filename + ".profile.xml"));
		XmlGenerator xmlgen = new XmlGenerator();
		xmlgen.generate(xdoc.getDocumentElement(), tmp, "http://hl7.org/fhir",
				xdoc.getDocumentElement().getLocalName());

		// reload it now
		builder = factory.newDocumentBuilder();
		xdoc = builder.parse(new CSFileInputStream(tmp.getAbsolutePath()));
		XhtmlGenerator xhtml = new XhtmlGenerator(null);
		xhtml.generate(xdoc, new CSFile(page.getFolders().dstDir + filename
				+ ".profile.xml.htm"), "Profile", profile.metadata("name"));
		// // xml to json
		// JsonGenerator jsongen = new JsonGenerator();
		// jsongen.generate(new CSFile(page.getFolders().dstDir+n+".xml"), new
		// File(page.getFolders().dstDir+n+".json"));
		//
		tmp.delete();

	}

	private void validateProfile(ProfileDefn profile)
			throws FileNotFoundException, Exception {
		for (ResourceDefn c : profile.getResources()) {
			Profile resource = loadResourceProfile(c.getName());
			ProfileValidator v = new ProfileValidator();
			v.setCandidate(c);
			v.setProfile(resource);
			List<String> errors = v.evaluate();
			if (errors.size() > 0)
				throw new Exception("Error validating "+ profile.metadata("name") + ": " + errors.toString());
		}
	}

	// private void produceFutureResource(String n) throws Exception {
	// ElementDefn e = new ElementDefn();
	// e.setName(page.getIni().getStringProperty("future-resources", n));
	// }

	private Profile loadResourceProfile(String name)
			throws FileNotFoundException, Exception {
		XmlParser xml = new XmlParser();
		try {
		return (Profile) xml.parse(new CSFileInputStream(page.getFolders().dstDir + name.toLowerCase() + ".profile.xml"));
		} catch (Exception e) {
		  throw new Exception("error parsing "+name, e);
		}
	}

	private void producePage(String file, String logicalName) throws Exception {
		String src = TextFile.fileToString(page.getFolders().srcDir + file);
		src = page.processPageIncludes(file, src);
		// before we save this page out, we're going to figure out what it's index is, and number the headers if we can
		
		if (!Utilities.noString(logicalName)) {
		  if (!page.getSectionTrackerCache().containsKey(logicalName)) {
		    String prefix = page.getNavigation().getIndexPrefixForFile(logicalName+".htm");
		    if (Utilities.noString(prefix))
		      throw new Exception("No indexing home for logical place "+logicalName);
		    page.getSectionTrackerCache().put(logicalName, new SectionTracker(prefix));
		  }
		  src = insertSectionNumbers(src, page.getSectionTrackerCache().get(logicalName), file);
		}
		TextFile.stringToFile(src, page.getFolders().dstDir + file);		

		src = TextFile.fileToString(page.getFolders().srcDir + file).replace("<body>", "<body style=\"margin: 10px\">");
		src = page.processPageIncludesForBook(file, src);
		cachePage(file, src);
	}

	private String insertSectionNumbers(String src, SectionTracker st, String link) throws Exception  {
    try {
      XhtmlDocument doc = new XhtmlParser().parse(src);
      insertSectionNumbersInNode(doc, st, link);
      return new XhtmlComposer().compose(doc);
    } catch (Exception e) {
      throw new Exception("Exception processing "+link+": "+e.getMessage(), e);
    } 
  }

  private void insertSectionNumbersInNode(XhtmlNode node, SectionTracker st, String link) throws Exception {
    if (node.getNodeType() == NodeType.Element && (node.getName().equals("h1") || node.getName().equals("h2") || node.getName().equals("h3") ||
         node.getName().equals("h4") || node.getName().equals("h5") || node.getName().equals("h6"))) {
      String v = st.getIndex(Integer.parseInt(node.getName().substring(1)));
      TocEntry t = new TocEntry(v, node.allText(), link);
      page.getToc().put(v, t);      
      node.addText(" ");
      XhtmlNode span = node.addTag("span");
      span.setAttribute("class", "sectioncount");
      span.addText(v);
      XhtmlNode a = span.addTag("a");
      a.setAttribute("name", v);
      a.addText(" "); // bug in some browsers?
    }
    if (node.getNodeType() == NodeType.Document || (node.getNodeType() == NodeType.Element && !(node.getName().equals("div") && "sidebar".equals(node.getAttribute("class"))))) {
      for (XhtmlNode n : node.getChildNodes()) {
        insertSectionNumbersInNode(n, st, link);
      }
    }
  }

  private void cachePage(String filename, String source) throws Exception {
		try {
			// log("parse "+filename);
			book.getPages().put(filename, new XhtmlParser().parse(source));
		} catch (Exception e) {
			throw new Exception("error parsing page " + filename + ": "
					+ e.getMessage() + "in source\r\n" + source);
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
			// System.out.println("warning: " + arg0.toString());

		}

		public List<String> getErrors() {
			return errors;
		}

	}

	public class MyResourceResolver implements LSResourceResolver {

		private String dir;

		public MyResourceResolver(String dir) {
			this.dir = dir;
		}

		public LSInput resolveResource(final String type,
				final String namespaceURI, final String publicId,
				String systemId, final String baseURI) {
			// System.out.println(type+", "+namespaceURI+", "+publicId+", "+systemId+", "+baseURI);
			try {
	      if (!new CSFile(dir + systemId).exists())
	        return null;
				return new SchemaInputSource(new CSFileInputStream(new CSFile(dir + systemId)), publicId, systemId, namespaceURI);
			} catch (Exception e) {
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
		log(".. Loading schemas");
		StreamSource[] sources = new StreamSource[2];
		sources[0] = new StreamSource(new CSFileInputStream(
				page.getFolders().dstDir + "fhir-all.xsd"));
		sources[1] = new StreamSource(new CSFileInputStream(
				page.getFolders().dstDir + "fhir-atom.xsd"));
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schemaFactory.setErrorHandler(new MyErrorHandler(false));
		schemaFactory.setResourceResolver(new MyResourceResolver(page
				.getFolders().dstDir));
		Schema schema = schemaFactory.newSchema(sources);
		log(".... done");

		for (ResourceDefn r : page.getDefinitions().getResources().values()) {
			for (Example e : r.getExamples()) {
				String n = e.getFileTitle();
				validateXmlFile(schema, n);
			}
		}
		validateXmlFile(schema, "profiles-resources");

		log("Reference Platform Validation.");

		for (ResourceDefn r : page.getDefinitions().getResources().values()) {
			for (Example e : r.getExamples()) {
				String n = e.getFileTitle();
				log(" ...validate " + n);
				validateRoundTrip(schema, n);
			}
		}
		validateRoundTrip(schema, "profiles-resources");
	}

	private void validateXmlFile(Schema schema, String n) throws Exception {
		char sc = File.separatorChar;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(false);
		factory.setSchema(schema);
		DocumentBuilder builder = factory.newDocumentBuilder();
		MyErrorHandler err = new MyErrorHandler(true);
		builder.setErrorHandler(err);
		Document doc = builder.parse(new CSFileInputStream(new CSFile(page.getFolders().dstDir + n + ".xml")));
		if (err.getErrors().size() > 0)
			throw new Exception("Resource Example " + n	+ " failed schema validation");
		File tmpTransform = File.createTempFile("tmp", ".xslt");
		tmpTransform.deleteOnExit();
		File tmpOutput = File.createTempFile("tmp", ".xml");
		tmpOutput.deleteOnExit();
		String sch = doc.getDocumentElement().getNodeName().toLowerCase();
		if (sch.equals("feed"))
			sch = "fhir-atom";

		try {
		  Utilities.transform(page.getFolders().rootDir + "tools"+sc+"schematron"+sc,	page.getFolders().dstDir + sch + ".sch", page.getFolders().rootDir + "tools"+sc+"schematron"+sc+"iso_svrl_for_xslt1.xsl",	tmpTransform.getAbsolutePath());
		  Utilities.transform(page.getFolders().rootDir + "tools"+sc+"schematron"+sc,	page.getFolders().dstDir + n + ".xml", tmpTransform.getAbsolutePath(), tmpOutput.getAbsolutePath());
		} catch (Throwable t) {
		  throw new Exception("Error validating "+page.getFolders().dstDir + n + ".xml with schematrons", t);
		}

		factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		builder = factory.newDocumentBuilder();
		doc = builder.parse(new CSFileInputStream(tmpOutput.getAbsolutePath()));
		NodeList nl = doc.getDocumentElement().getElementsByTagNameNS("http://purl.oclc.org/dsdl/svrl", "failed-assert");
		if (nl.getLength() > 0) {
			page.log("Schematron Validation Failed for " + n + ".xml:");
			for (int i = 0; i < nl.getLength(); i++) {
				Element e = (Element) nl.item(i);
				page.log("  @" + e.getAttribute("location") + ": "+ e.getTextContent());
			}
		}
	}

	private void validateRoundTrip(Schema schema, String n) throws Exception {
		for (PlatformGenerator gen : page.getReferenceImplementations()) {
			if (gen.doesTest()) {
				gen.loadAndSave(page.getFolders().dstDir, page.getFolders().dstDir + n + ".xml", page.getFolders().tmpResDir + "tmp.xml");
				compareXml(n, gen.getName(), page.getFolders().dstDir + n	+ ".xml", page.getFolders().tmpResDir + "tmp.xml");
			}
		}
	}

	private void compareXml(String t, String n, String fn1, String fn2)
			throws Exception {
		char sc = File.separatorChar;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		dbf.setCoalescing(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setIgnoringComments(true);
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc1 = db.parse(new CSFile(fn1));
		doc1.normalizeDocument();
		stripWhitespaceAndComments(doc1);

		Document doc2 = db.parse(new CSFile(fn2));
		doc2.normalizeDocument();
		stripWhitespaceAndComments(doc2);

		XmlGenerator xmlgen = new XmlGenerator();
		File tmp1 = File.createTempFile("xml", ".xml");
		tmp1.deleteOnExit();
		xmlgen.generate(doc1.getDocumentElement(), tmp1, doc1
				.getDocumentElement().getNamespaceURI(), doc1
				.getDocumentElement().getLocalName());
		File tmp2 = File.createTempFile("xml", ".xml");
		tmp2.deleteOnExit();
		xmlgen.generate(doc2.getDocumentElement(), tmp2, doc2
				.getDocumentElement().getNamespaceURI(), doc2
				.getDocumentElement().getLocalName());

		if (!TextFile.fileToString(tmp1.getAbsolutePath()).equals(
				TextFile.fileToString(tmp2.getAbsolutePath()))) {
			page.log("file " + t+ " did not round trip perfectly in XML in platform " + n);
			if (new CSFile(System.getenv("ProgramFiles(X86)")+sc+"WinMerge"+sc+"WinMergeU.exe")
					.exists()) {

				List<String> command = new ArrayList<String>();
				command.add("\""+System.getenv("ProgramFiles(X86)")+sc+"WinMerge"+sc+"WinMergeU.exe"+"\" \""
						+ tmp1.getAbsolutePath()
						+ "\" \""
						+ tmp2.getAbsolutePath() + "\"");

				ProcessBuilder builder = new ProcessBuilder(command);
				builder.directory(new CSFile(page.getFolders().rootDir));
				final Process process = builder.start();
				process.waitFor();
			}

		}
	}

	private void stripWhitespaceAndComments(Node node) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element e = (Element) node;
			Map<String, String> attrs = new HashMap<String, String>();
			for (int i = e.getAttributes().getLength() - 1; i >= 0; i--) {
				attrs.put(e.getAttributes().item(i).getNodeName(), e
						.getAttributes().item(i).getNodeValue());
				e.removeAttribute(e.getAttributes().item(i).getNodeName());
			}
			for (String n : attrs.keySet()) {
				e.setAttribute(n, attrs.get(n));
			}
		}
		for (int i = node.getChildNodes().getLength() - 1; i >= 0; i--) {
			Node c = node.getChildNodes().item(i);
			if (c.getNodeType() == Node.TEXT_NODE
					&& c.getTextContent().trim().length() == 0)
				node.removeChild(c);
			else if (c.getNodeType() == Node.TEXT_NODE)
				c.setTextContent(c.getTextContent().trim());
			else if (c.getNodeType() == Node.COMMENT_NODE)
				node.removeChild(c);
			else if (c.getNodeType() == Node.ELEMENT_NODE)
				stripWhitespaceAndComments(c);
		}
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			node.appendChild(node.getOwnerDocument().createTextNode("\r\n"));
		}

	}

	private void produceCombinedDictionary() throws FileNotFoundException,
			UnsupportedEncodingException, Exception, IOException {
		FileOutputStream fos = new FileOutputStream(page.getFolders().dstDir
				+ "fhir.dict.xml");
		DictXMLGenerator dxgen = new DictXMLGenerator(fos);
		dxgen.setConceptDomains(page.getDefinitions().getBindings());
		dxgen.generate(page.getDefinitions().getResources().values(), "HL7");
		dxgen.close();
		fos.close();
	}

  public void log(String content) {
    page.log(content);
  }

//  public void logNoEoln(String content) {
//    page.logNoEoln(content);
//  }

  private void generateCodeSystems() throws Exception {
    for (BindingSpecification bs : page.getDefinitions().getBindings().values())
      if (bs.getBinding() == Binding.CodeList)
        generateCodeSystem(bs.getReference().substring(1)+".htm", bs);
  }
  
  private void generateCodeSystem(String filename, BindingSpecification cd) throws Exception {
    TextFile.stringToFile(page.processPageIncludes(filename, TextFile.fileToString(page.getFolders().srcDir+"template-tx.htm")), page.getFolders().dstDir+filename);
    String src = page.processPageIncludesForBook(filename, TextFile.fileToString(page.getFolders().srcDir+"template-tx.htm"));
    cachePage(filename, src);
    
  /*  
    String src = TextFile.fileToString(page.getFolders().srcDir + file);
    src = page.processPageIncludes(file, src);
    TextFile.stringToFile(src, page.getFolders().dstDir + file);
    src = TextFile.fileToString(page.getFolders().srcDir + file).replace("<body>", "<body class=\"book\">");
    src = page.processPageIncludesForPrinting(file, src);
    TextFile.stringToFile(src, page.getFolders().dstDir + "print-" + file);

    src = TextFile.fileToString(page.getFolders().srcDir + file).replace(
        "<body>", "<body style=\"margin: 10px\">");
    src = page.processPageIncludesForBook(file, src);
    cachePage(file, src);
*/
//    pages.
//    String fn = getFolders().dstDir+File.separator+cd.getReference().substring(1)+".htm";
//    if (!new File(fn).exists()) {
//      generateCodeSystem(fn, cd);
//    }      
    
  }
//  private void generateCodeSystem(String filename, BindingSpecification cd) throws Exception {
//    TextFile.stringToFile(page.processPageIncludes(filename, TextFile.fileToString(page.getFolders().srcDir+"template-tx.htm")), filename);
//  }  
//  String s = page.getFolders().dstDir+File.separator+cd.getReference().substring(1)+".htm";
//  if (!new File(s).exists()) {
//    generateCodeSystem(s, cd);
//  }
//  
//  String s = page.getFolders().dstDir+File.separator+cd.getReference().substring(1)+".htm";
//  if (!new File(s).exists()) {
//    generateCodeSystem(s, cd);
//  }

}
