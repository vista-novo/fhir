package org.hl7.fhir.tools.core.publish;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.zip.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.hl7.fhir.tools.core.model.*;
import org.hl7.fhir.tools.core.parser.*;
import org.hl7.fhir.tools.core.utilities.Utilities;
import org.hl7.fhir.tools.core.xml.*;
import org.w3c.dom.Document;


public class Publisher {
	private String srcDir;
	private String imgDir;
	private String xsdDir;
	private String dstDir;
	private String javaDir;
	private String javaParserDir;
	private String cSharpDir;
	private String umlDir;
	private CSharpResourceGenerator cSharpGen;
	private JavaFactoryGenerator jFactoryGen;
	private JavaParserFactoryGenerator jParserFactoryGen;
	
	private IniFile ini;
	private List<ConceptDomain> conceptDomains;
	private Map<String, ElementDefn> definitions = new HashMap<String, ElementDefn>();
	private Schema schema;
	private List<DefinedCode> resCodes = new ArrayList<DefinedCode>();
	private Map<String, String> csvSrcs = new HashMap<String, String>();
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new Publisher().execute(args[0]);
	}
	
	public void execute(String arg) throws Exception {
		srcDir = arg+File.separatorChar+"source"+File.separatorChar;
		imgDir = arg+File.separatorChar+"images"+File.separatorChar;
		xsdDir = arg+File.separatorChar+"schema"+File.separatorChar;
		dstDir = arg+File.separatorChar+"publish"+File.separatorChar;
		umlDir = arg+File.separatorChar+"uml"+File.separatorChar;
		javaDir =  arg+File.separatorChar+"tools"+File.separatorChar+"java"+File.separatorChar+"org.hl7.fhir.tools.core"+File.separatorChar+"src"+
				   File.separatorChar+"org"+File.separatorChar+"hl7"+File.separatorChar+"fhir"+File.separatorChar+"instance"+File.separatorChar+"model"+File.separatorChar;
		javaParserDir =  arg+File.separatorChar+"tools"+File.separatorChar+"java"+File.separatorChar+"org.hl7.fhir.tools.core"+File.separatorChar+"src"+
				   File.separatorChar+"org"+File.separatorChar+"hl7"+File.separatorChar+"fhir"+File.separatorChar+"instance"+File.separatorChar+"parser"+File.separatorChar;
		cSharpDir = arg+File.separatorChar+"tools"+File.separatorChar+"csharp"+File.separatorChar+"FHIR"+File.separatorChar+"FHIR"+File.separatorChar;
		
		ini = new IniFile(arg+File.separatorChar+"publish.ini");
		System.out.println("publish FHIR from "+srcDir+" to "+dstDir);
		definitions.clear();
		csvSrcs.clear();
		
		loadConceptDomains();
		
		String[] names = ini.getPropertyNames("support");
		for (String s : names) {
			System.out.println("copy support file "+s);
			copyFile(new File(srcDir + s), new File(dstDir + s));
		}
		
		names = ini.getPropertyNames("patterns");
		for (String s : names) {
			System.out.println("pattern "+s);
			processPattern(s);
		}
		
		names = ini.getPropertyNames("types");
		for (String s : names) {
			System.out.println("type "+s);
			processDataType(s);
		}
		
		names = ini.getPropertyNames("datatypes");
		for (String s : names) {
			System.out.println("data type "+s);
			processDataType(s);
		}
		
		names = ini.getPropertyNames("images");
		for (String s : names) {
			System.out.println("copy support file "+s);
			copyFile(new File(imgDir + s), new File(dstDir + s));
		}
		
		cSharpGen = new CSharpResourceGenerator(new FileOutputStream(cSharpDir+"Resources.cs"));
		cSharpGen.start();
		jFactoryGen = new JavaFactoryGenerator(new FileOutputStream(javaDir+"ResourceFactory.java"));
		jParserFactoryGen = new JavaParserFactoryGenerator(new FileOutputStream(javaParserDir+"ResourceParserFactory.java"));
		
		names = ini.getPropertyNames("resources");
		for (String s : names) {
			System.out.println("process resource "+s);
			processResource(s);				
		}				
		
		names = ini.getPropertyNames("future-resources");
		for (String s : names) {
			ElementDefn e = new ElementDefn();
			e.setName(ini.getStringProperty("future-resources", s));
			new JavaResourceGenerator(new FileOutputStream(javaDir+e.getName()+".java")).generate(e, conceptDomains);
			new JavaParserGenerator(new FileOutputStream(javaParserDir+e.getName()+"Parser.java")).generate(e, conceptDomains);
			jFactoryGen.registerResource(s,  e.getName());
			jParserFactoryGen.registerResource(s,  e.getName());
			cSharpGen.generate(e, conceptDomains);
			resCodes.add(new DefinedCode(ini.getStringProperty("future-resources", s), "Yet to be defined", s));				
		}				
		cSharpGen.finish();
		jFactoryGen.generate();
		jParserFactoryGen.generate();
		
		names = ini.getPropertyNames("schema");
		for (String s : names) {
			System.out.println("process schema "+s);
			processSchema(s);
		}				

		names = ini.getPropertyNames("pages");
		for (String s : names) {
			System.out.println("process page "+s);
			processPage(s);
		}

		
		System.out.println("Combined dictionary");

		FileOutputStream fos = new FileOutputStream(dstDir+"fhir.dict.xml");
		DictXMLGenerator dxgen = new DictXMLGenerator(fos);
		dxgen.setConceptDomains(conceptDomains);
		dxgen.generate(definitions.values(), "HL7");
		fos.close();

		System.out.println("Combined schema");
		produceCombinedSchema();
		
		zipJavaFiles();
		zipCSharpFiles();
		zipCSVFiles();
		copyFile(new File(umlDir + "fhir.eap"), new File(dstDir + "fhir.eap"));
		copyFile(new File(umlDir + "fhir.xmi"), new File(dstDir + "fhir.xmi"));

		System.out.println("Load schema");
		loadSchema();
		System.out.println("..Loaded");
		
		
		names = ini.getPropertyNames("resources");
		for (String s : names) {
			System.out.println("validate resource "+s);
			validateBySchema(dstDir, s);
		}				

		System.out.println("Finished publishing FHIR");
    }

	static final int BUFFER = 2048;

	private void zipJavaFiles() throws Exception {
		BufferedInputStream origin = null;
		FileOutputStream dest = new FileOutputStream(dstDir+"java.zip");
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		byte data[] = new byte[BUFFER];
		File f = new File(javaDir);
		String[] files = f.list();
		for (int i=0; i < files.length; i++) {
			if (files[i].endsWith(".java")) {
				FileInputStream fi = new FileInputStream(javaDir+files[i]);
				origin = new BufferedInputStream(fi, BUFFER);
				ZipEntry entry = new ZipEntry("model"+File.separator+files[i]);
				out.putNextEntry(entry);
				int count;
				while((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
			}
        }

		f = new File(javaParserDir);
		files = f.list();
		for (int i=0; i < files.length; i++) {
			if (files[i].endsWith(".java")) {
				FileInputStream fi = new FileInputStream(javaParserDir+files[i]);
				origin = new BufferedInputStream(fi, BUFFER);
				ZipEntry entry = new ZipEntry("parser"+File.separator+files[i]);
				out.putNextEntry(entry);
				int count;
				while((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
			}
        }
        out.close();

	}

	private void zipCSharpFiles() throws Exception {
		BufferedInputStream origin = null;
		FileOutputStream dest = new FileOutputStream(dstDir+"csharp.zip");
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		byte data[] = new byte[BUFFER];
		File f = new File(cSharpDir);
		String files[] = f.list();
		for (int i=0; i < files.length; i++) {
			if (files[i].endsWith(".cs")) {
				FileInputStream fi = new FileInputStream(cSharpDir+files[i]);
				origin = new BufferedInputStream(fi, BUFFER);
				ZipEntry entry = new ZipEntry(files[i]);
				out.putNextEntry(entry);
				int count;
				while((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
			}
        }
        out.close();
	}

	private void zipCSVFiles() throws Exception {
		BufferedInputStream origin = null;
		FileOutputStream dest = new FileOutputStream(dstDir+"csv.zip");
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		byte data[] = new byte[BUFFER];

		for (String n : csvSrcs.keySet()) {
			FileInputStream fi = new FileInputStream(csvSrcs.get(n));
			origin = new BufferedInputStream(fi, BUFFER);
			ZipEntry entry = new ZipEntry(n+".csv");
			out.putNextEntry(entry);
			int count;
			while((count = origin.read(data, 0, BUFFER)) != -1) {
				out.write(data, 0, count);
			}

		}
		out.close();

	}

	private void processSchema(String s) throws Exception {
		String xsd = Utilities.fileToString(srcDir + s);
		xsd = processSchemaIncludes(s, xsd);
		Utilities.stringToFile(xsd, dstDir + s);
		Utilities.stringToFile(xsd, xsdDir + s);	
	}

	private void loadConceptDomains() throws Exception {
		System.out.println("Load Concept Domains");
		ConceptDomainsParser parser = new ConceptDomainsParser(new FileInputStream(new File(srcDir+"terminologies"+File.separatorChar+"concept-domains.csv")));
		conceptDomains = parser.parse();
		for (ConceptDomain cd : conceptDomains) {
			if (cd.getBindingType() == BindingType.CodeList) {
				
				File file = new File(srcDir+"terminologies"+File.separatorChar+cd.getBinding()+".csv");
				if (!file.exists())
					throw new Exception("code source file not found for "+cd.getName()+": "+file.getAbsolutePath());
				CodeListParser cparser = new CodeListParser(new FileInputStream(file));
				cparser.parse(cd.getCodes());
			}
		}

	}

	private void produceCombinedSchema() throws Exception {
		String src = Utilities.fileToString(srcDir + "fhir-all.xsd");
		src = processSchemaIncludes("fhir-all.xsd", src);
		Utilities.stringToFile(src, dstDir + "fhir-all.xsd");
		Utilities.stringToFile(src, xsdDir + "fhir-all.xsd");
		
	}

	private void processDataType(String s) throws Exception {
		TypeParser tp = new TypeParser();
		TypeDefn t = tp.parse(s).get(0);
		File csv = new File(srcDir+"datatypes"+File.separatorChar+t.getName()+".csv");
		if (csv.exists()) {
			CSVParser p = new CSVParser(new FileInputStream(csv));
			ElementDefn el = p.parse();
			
			ModelValidator val = new ModelValidator();
			for (String n : ini.getPropertyNames("resources"))
				val.defineResource(ini.getStringProperty("resources", n));
			for (String n : ini.getPropertyNames("future-resources"))
			  	val.defineResource(ini.getStringProperty("future-resources", n));
			val.setDataTypes(ini.getPropertyNames("datatypes"));
			val.setDataTypes(ini.getPropertyNames("types"));
			val.setConceptDomains(conceptDomains);
			String[] errors = val.check(el);
			for (String e : errors)
				System.out.println(e);
			if (errors.length > 0)
				throw new Exception("unable to complete publication when an error occurs");			
			definitions.put(t.getName(), el);
			
			SchemaGenerator gen = new SchemaGenerator(new FileOutputStream(new File(xsdDir+"datatypes"+File.separatorChar+t.getName()+".xsd")));
			gen.setDataTypes(ini.getPropertyNames("datatypes"));
			gen.generate(el, conceptDomains);

			JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(xsdDir+"datatypes"+File.separatorChar+t.getName()+".java"));
			jgen.generate(el, conceptDomains);
			
			JavaParserGenerator jpgen = new JavaParserGenerator(new FileOutputStream(xsdDir+"datatypes"+File.separatorChar+t.getName()+"Parser.java"));
			jpgen.setTypeNames(jgen.getTypeNames());
			jpgen.generate(el, conceptDomains);
			
		}
	}

	private void processPattern(String s) throws Exception {
		TypeParser tp = new TypeParser();
		TypeDefn t = tp.parse(s).get(0);
		File csv = new File(srcDir+"datatypes"+File.separatorChar+t.getName()+".csv");
		if (!csv.exists()) 
			throw new Exception("Unable to find pattern "+s);
		
		CSVParser p = new CSVParser(new FileInputStream(csv));
		ElementDefn el = p.parse();

		ModelValidator val = new ModelValidator();
		for (String n : ini.getPropertyNames("resources"))
			val.defineResource(ini.getStringProperty("resources", n));
		for (String n : ini.getPropertyNames("future-resources"))
			val.defineResource(ini.getStringProperty("future-resources", n));
		val.setDataTypes(ini.getPropertyNames("datatypes"));
		val.setDataTypes(ini.getPropertyNames("types"));
		val.setConceptDomains(conceptDomains);
		String[] errors = val.check(el);
		for (String e : errors)
			System.out.println(e);
		if (errors.length > 0)
			throw new Exception("unable to complete publication when an error occurs");			
		definitions.put(t.getName(), el);

		SchemaGenerator gen = new SchemaGenerator(new FileOutputStream(new File(xsdDir+"datatypes"+File.separatorChar+t.getName()+".xsd")));
		gen.setDataTypes(ini.getPropertyNames("datatypes"));
		gen.generate(el, conceptDomains);

		JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(xsdDir+"datatypes"+File.separatorChar+t.getName()+".java"));
		jgen.generate(el, conceptDomains);

		JavaParserGenerator jpgen = new JavaParserGenerator(new FileOutputStream(xsdDir+"datatypes"+File.separatorChar+t.getName()+"Parser.java"));
		jpgen.setTypeNames(jgen.getTypeNames());
		jpgen.generate(el, conceptDomains);
		
		Utilities.stringToFile(xmlForDt(s)+tsForDt(s), xsdDir+"datatypes"+File.separatorChar+t.getName()+".htm");
	}

	public void copyFile(File sourceFile, File destFile) throws IOException {
	    if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

	    FileChannel source = null;
	    FileChannel destination = null;

	    try {
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        destination.transferFrom(source, 0, source.size());
	    }
	    finally {
	        if(source != null) {
	            source.close();
	        }
	        if(destination != null) {
	            destination.close();
	        }
	    }
	}


	private void processPage(String file) throws Exception {
		String src = Utilities.fileToString(srcDir + file);
		src = processPageIncludes(file, src);

		Utilities.stringToFile(src, dstDir + file);

		src = Utilities.fileToString(srcDir + file);
		src = processPageIncludesForPrinting(file, src);

		Utilities.stringToFile(src, dstDir + "print-"+file);
		
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
				src = s1+Utilities.fileToString(srcDir + "header.htm")+s3;
			else if (com[0].equals("sidebar"))
				src = s1+Utilities.fileToString(srcDir + "sidebar.htm")+s3;
			else if (com[0].equals("title"))
				src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
			else if (com[0].equals("name"))
				src = s1+name+s3;
			else if (com[0].equals("maindiv"))
				src = s1+"<div class=\"content\">"+s3;
			else if (com[0].equals("/maindiv"))
				src = s1+"</div>"+s3;
			else if (com[0].equals("resourcecodes"))
				src = s1 + genResCodes() + s3;
			else if (com[0].equals("resimplall"))
				src = s1 + genResImplList() + s3;
			
			else 
				throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
		}
		return src;
	}
	
	private String processSchemaIncludes(String filename, String src) throws Exception {
		while (src.contains("<!--%") || src.contains("<%"))
		{
			int i2;
			String s1;
			String s2;
			String s3;

			int i1 = src.indexOf("<!--%");
			if (i1 > -1) {
				i2 = src.indexOf("%-->");
				s1 = src.substring(0, i1);
				s2 = src.substring(i1 + 5, i2).trim();
				s3 = src.substring(i2 + 4);
			} else {
				i1 = src.indexOf("<%");
				i2 = src.indexOf("%>");
				s1 = src.substring(0, i1);
				s2 = src.substring(i1 + 2, i2).trim();
				s3 = src.substring(i2 + 2);
			}	
					
			String[] com = s2.split(" ");
			if (com.length != 1)
				throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+filename);
			else if (com[0].equals("date"))
				src = s1+new Date().toString()+s3;
			else if (com[0].equals("resources")) {
				StringBuilder includes = new StringBuilder();
				for (String n : ini.getPropertyNames("resources")) 
					includes.append("  <xs:include schemaLocation=\""+n+".xsd\"/>\r\n");
				src = s1+includes.toString()+s3;
			}
			else if (com[0].equals("resourceEnum")) {
				StringBuilder enums = new StringBuilder();
				for (DefinedCode c : resCodes) {
					enums.append("        <xs:enumeration value=\""+c.getCode()+"\">\r\n");
					enums.append("          <xs:annotation>\r\n");
					enums.append("            <xs:documentation>"+Utilities.escapeXml(c.getDefinition())+"</xs:documentation>\r\n");
					enums.append("          </xs:annotation>\r\n");
					enums.append("        </xs:enumeration>\r\n");
				}
				src = s1+enums.toString()+s3;
			}
			else 
				throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+filename);
		}
		return src;
	}
	
	
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
			else if (com[0].equals("sidebar"))
				src = s1+s3;
			else if (com[0].equals("title"))
				src = s1+name.toUpperCase().substring(0, 1)+name.substring(1)+s3;
			else if (com[0].equals("name"))
				src = s1+name+s3;
			else if (com[0].equals("maindiv"))
				src = s1+s3;
			else if (com[0].equals("/maindiv"))
				src = s1+s3;
			else if (com[0].equals("resourcecodes"))
				src = s1 + genResCodes() + s3;
			else if (com[0].equals("resimplall"))
				src = s1 + genResImplList() + s3;
			
			else 
				throw new Exception("Instruction <%"+s2+"%> not understood parsing page "+file);
		}
		return src;
	}	

	

	private String genResCodes() {
		StringBuilder html = new StringBuilder();
		for (DefinedCode c : resCodes) {
			html.append("  <tr><td><a href=\""+c.getComment()+".htm\">"+c.getCode()+"</a></td><td>"+Utilities.escapeXml(c.getDefinition())+"</td></tr>");
			
		}				
		return html.toString();
		
	}

	private String genResImplList() {
		StringBuilder html = new StringBuilder();
		List<String> res = new ArrayList<String>();
		for (String n: ini.getPropertyNames("resources"))
			res.add(n);
		for (DefinedCode c : resCodes) {
			if (res.contains(c.getComment()))
				html.append("  <tr><td>"+c.getCode()+"</td><td><a href=\""+c.getComment()+".dict.xml\">Definitions</a></td><td><a href=\""+c.getComment()+".xsd\">Schema</a></td><td><a href=\""+c.getComment()+".xml\">Example</a></td><td><a href=\""+c.getComment()+".json\">JSON Example</a></td>\r\n");
		}				
		return html.toString();
		
	}

	private String tsForDt(String dt) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		FileOutputStream fos = new FileOutputStream(tmp);
		TxSpecGenerator gen = new TxSpecGenerator(fos);
		gen.generate(definitions.get(dt), conceptDomains);
		fos.close();
		String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
		tmp.delete();
		return val;
	}

	private String xmlForDt(String dt) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
		FileOutputStream fos = new FileOutputStream(tmp);
		XmlSpecGenerator gen = new XmlSpecGenerator(fos);
		gen.generate(definitions.get(dt));
		fos.close();
		String val = Utilities.fileToString(tmp.getAbsolutePath())+"\r\n";
		tmp.delete();
		return val;	
	}

	private void processResource(String name) throws Exception {
		File tmp = File.createTempFile("tmp", ".tmp");
				
		File csvf = new File(srcDir+name+File.separatorChar+name+".csv");
		if (!csvf.exists())
			throw new Exception("unable to find definitions spreadsheet "+csvf.getName());
		csvSrcs.put(name, csvf.getAbsolutePath());
		CSVParser cparser = new CSVParser(new FileInputStream(csvf));
		ElementDefn root = cparser.parse();

		jFactoryGen.registerResource(name,  root.getName());
		jParserFactoryGen.registerResource(name,  root.getName());
		resCodes.add(new DefinedCode(root.getName(), root.getDefinition(), name));
		ModelValidator val = new ModelValidator();
		for (String n : ini.getPropertyNames("resources"))
			val.defineResource(ini.getStringProperty("resources", n));
		for (String n : ini.getPropertyNames("future-resources"))
		  	val.defineResource(ini.getStringProperty("future-resources", n));
		val.setDataTypes(ini.getPropertyNames("datatypes"));
		val.setDataTypes(ini.getPropertyNames("types"));
		val.setConceptDomains(conceptDomains);
		String[] errors = val.check(root);
		for (String e : errors)
			System.out.println(e);
		if (errors.length > 0)
			throw new Exception("unable to complete publication when an error occurs");

		definitions.put(root.getName(), root);
				
//		CSVGenerator cgen = new CSVGenerator(new FileOutputStream(csvf));
//		cgen.generate(root);
		
		SchemaGenerator sgen = new SchemaGenerator(new FileOutputStream(new File(xsdDir+name+".xsd")));
		sgen.setDataTypes(ini.getPropertyNames("datatypes"));
		sgen.generate(root, conceptDomains);

		sgen = new SchemaGenerator(new FileOutputStream(new File(dstDir+name+".xsd")));
		sgen.setDataTypes(ini.getPropertyNames("datatypes"));
		sgen.generate(root, conceptDomains);

		JavaResourceGenerator jgen = new JavaResourceGenerator(new FileOutputStream(javaDir+root.getName()+".java"));
		jgen.generate(root, conceptDomains);
		cSharpGen.generate(root, conceptDomains);
		
		JavaParserGenerator jpgen = new JavaParserGenerator(new FileOutputStream(javaParserDir+root.getName()+"Parser.java"));
		jpgen.setTypeNames(jgen.getTypeNames());
		jpgen.generate(root, conceptDomains);
		
		FileOutputStream fos = new FileOutputStream(tmp);
		XmlSpecGenerator gen = new XmlSpecGenerator(fos);
		gen.generate(root);
		fos.close();
		String xml = Utilities.fileToString(tmp.getAbsolutePath());

		TxSpecGenerator tgen = new TxSpecGenerator(new FileOutputStream(tmp));
		tgen.generate(root, conceptDomains);
		fos.close();
		String tx = Utilities.fileToString(tmp.getAbsolutePath());
        
		fos = new FileOutputStream(tmp);
		DictHTMLGenerator dgen = new DictHTMLGenerator(fos);
		dgen.generate(root);
		fos.close();
		String dict = Utilities.fileToString(tmp.getAbsolutePath());
		
		fos = new FileOutputStream(dstDir+name+".dict.xml");
		DictXMLGenerator dxgen = new DictXMLGenerator(fos);
		dxgen.generate(root, "HL7");
		fos.close();

		
		File xmlf = new File(srcDir+name+File.separatorChar+name+".xml");
		if (!xmlf.exists())
			throw new Exception("unable to find XML example "+xmlf.getName());

		File umlf = new File(imgDir+name+".png");
		if (!umlf.exists())
			throw new Exception("unable to find UML class diagram "+umlf.getName());
 
		String src = Utilities.fileToString(srcDir + "template.htm");
		src = processResourceIncludes(name, root, xml, tx, dict, src);
		Utilities.stringToFile(src, dstDir + name+".htm");

		src = Utilities.fileToString(srcDir + "template-print.htm");
		src = processResourceIncludes(name, root, xml, tx, dict, src);
		Utilities.stringToFile(src, dstDir + "print-"+name+".htm");
		
		// producing the output
		copyFile(new File(srcDir+name+File.separatorChar+name+".csv"), new File(dstDir+name+".csv"));
		copyFile(umlf, new File(dstDir+name+".png"));				
		
		// xml to xhtml of xml
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true); 
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xdoc = builder.parse(new FileInputStream(xmlf));

		XmlGenerator xmlgen = new XmlGenerator();
		xmlgen.generate(xdoc.getDocumentElement(), new File(dstDir+name+".xml"), "http://www.hl7.org/fhir", xdoc.getDocumentElement().getLocalName());
				
		builder = factory.newDocumentBuilder();
		xdoc = builder.parse(new FileInputStream(new File(dstDir+name+".xml")));

		XhtmlGenerator xhtml = new XhtmlGenerator();
		xhtml.generate(xdoc, new File(dstDir+name+".xml.htm"), name.toUpperCase().substring(0, 1)+name.substring(1));
		
		// xml to json
		JsonGenerator jsongen = new JsonGenerator();
		jsongen.generate(new File(dstDir+name+".xml"), new File(dstDir+name+".json"));
		
		tmp.delete();
	}

	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema"; 
	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	
	private void loadSchema() throws Exception {
        StreamSource[] sources = new StreamSource[1];
        sources[0] = new StreamSource(new FileInputStream(dstDir+"fhir-all.xsd"));
        	
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schemaFactory.setErrorHandler(new MyErrorHandler(false));
        schemaFactory.setResourceResolver(new MyResourceResolver(dstDir));
        schema = schemaFactory.newSchema(sources);	
        
	}
	private void validateBySchema(String dir, String name) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(false);
		factory.setSchema(schema);
		DocumentBuilder builder = factory.newDocumentBuilder();
		MyErrorHandler err = new MyErrorHandler(true);
		builder.setErrorHandler(err);
		builder.parse(new FileInputStream(new File(dir+name+".xml")));
		if (err.getErrors().size() > 0)
			throw new Exception("Resource Example "+name+" failed schema validation");
		
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
				src = s1+Utilities.fileToString(srcDir + "header.htm")+s3;
			else if (com[0].equals("sidebar"))
				src = s1+Utilities.fileToString(srcDir + "sidebar.htm")+s3;
			else if (com[0].equals("title"))
				src = s1+root.getName()+s3;
			else if (com[0].equals("name"))
				src = s1+name+s3;
			else if (com[0].equals("definition"))
				src = s1+root.getDefinition()+s3;
			else if (com[0].equals("xml"))
				src = s1+xml+s3;
			else if (com[0].equals("tx"))
				src = s1+tx+s3;
			else if (com[0].equals("plural"))
				src = s1+Utilities.pluralize(name)+s3;
			else if (com[0].equals("notes"))
				src = s1+Utilities.fileToString(srcDir + name+File.separatorChar+name+".htm")+s3;
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

	private boolean isSpecial(String name) {
		String[] names = ini.getPropertyNames("Special");
		for (String s : names)
			if (s.equals(name))
				return true;
		return false;
	}				


	
}
