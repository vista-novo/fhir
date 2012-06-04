package org.hl7.fhir.tools.publisher.implementations;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.definitions.model.TypeRef;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.tools.publisher.implementations.CSharpResourceGenerator.GenClass;
import org.hl7.fhir.tools.publisher.implementations.JavaResourceGenerator.JavaGenClass;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.ZipGenerator;

public class CSharpGenerator extends BaseGenerator implements PlatformGenerator {

	public void generate(Definitions definitions, String destDir,
			String implDir, String version, Date genDate, Logger logger)
			throws Exception {

		char sl = File.separatorChar;
		String modelGenerationDir =  implDir + sl + "HL7.Fhir.Instance.Model" + sl;
		
		File f = new File(modelGenerationDir);
		if( !f.exists() )
			f.mkdir();
		
		List<String> filenames = new ArrayList<String>();
		
		// Generate a C# file for each Resource class
		for (String n : definitions.getResources().keySet()) 
		{
			ElementDefn root = definitions.getResourceDefn(n);
			CSharpResourceGenerator cSharpGen = new CSharpResourceGenerator(
					new FileOutputStream(modelGenerationDir + root.getName() + ".cs" ));
		
			filenames.add("HL7.Fhir.Instance.Model" + sl + root.getName()+".cs" );
			cSharpGen.generate(root, definitions.getBindings(), 
					GenClass.Resource, genDate, version );
		}

		// Generate a C# file for each "future" Resource
	    for (DefinedCode cd : definitions.getFutureResources().values()) 
	    {
	        ElementDefn e = new ElementDefn();
	        e.setName(cd.getCode());
	        new CSharpResourceGenerator(
	        	new FileOutputStream(modelGenerationDir+e.getName()+".cs"))
	        		.generate(e, definitions.getBindings(), 
	        				GenClass.Resource, genDate, version);
	        
			filenames.add("HL7.Fhir.Instance.Model" + sl + e.getName()+".cs" );
	    }
		
		// Generate infrastructure classes
		for (String n : definitions.getInfrastructure().keySet()) 
		{
		      ElementDefn root = definitions.getInfrastructure().get(n); 
		      new CSharpResourceGenerator(
		    	new FileOutputStream(modelGenerationDir+root.getName()+".cs"))
		      		.generate(root, definitions.getBindings(), 
		      				GenClass.Structure, genDate, version);
				filenames.add("HL7.Fhir.Instance.Model" + sl + root.getName()+".cs" );
		}

		
		// Generate a C# file for basic types
	    for (String n : definitions.getTypes().keySet())
	    {
	        ElementDefn root = definitions.getTypes().get(n); 
	     
	        GenClass generationType = GenClass.Type;
	        
	        if( root.getName().equals("Quantity"))
	        	generationType = GenClass.Ordered;

	        if( root.typeCode().equals("GenericType"))
	        	generationType = GenClass.Generic;

	        new CSharpResourceGenerator(
	        	new FileOutputStream(modelGenerationDir+root.getName()+".cs"))
	        		.generate(root, definitions.getBindings(), 
	        			generationType, genDate, version);

	        filenames.add("HL7.Fhir.Instance.Model" + sl + root.getName()+".cs" );
	    }

		// Generate a C# file for structured types (HumanName, Address)
	    for (String n : definitions.getStructures().keySet())
	    {
	        ElementDefn root = definitions.getStructures().get(n); 
	        new CSharpResourceGenerator(
	        	new FileOutputStream(modelGenerationDir+root.getName()+".cs"))
	        		.generate(root, definitions.getBindings(), 
	        				GenClass.Type, genDate, version);

	        filenames.add("HL7.Fhir.Instance.Model" + sl + root.getName()+".cs" );
	    }

	    // Generate a C# file for Constrained types (Money, Distance, ...)
	    for (DefinedCode cd : definitions.getConstraints().values()) {
	        ElementDefn root = definitions.getTypes().get(cd.getComment()); 
	        new CSharpResourceGenerator(
	        	new FileOutputStream(modelGenerationDir+cd.getCode()+".cs"))
	        		.generateConstraint(cd.getCode(), root.getName(),
	        				cd.getDefinition(), genDate, version);
			filenames.add("HL7.Fhir.Instance.Model" + sl + cd.getCode()+".cs" );  
	    }

	    // Generate C# project file
	    CSharpProjectGenerator projGen = new CSharpProjectGenerator();
	    projGen.build(implDir, filenames);
	    
		ZipGenerator zip = new ZipGenerator(destDir + "CSharp.zip");
		zip.addFiles(modelGenerationDir, "HL7.Fhir.Instance.Model" +sl, ".cs");
		zip.addFiles(implDir + sl + "HL7.Fhir.Instance.Support" + sl, "HL7.Fhir.Instance.Support" +sl, ".cs");
		zip.addFiles(implDir + sl + "Properties" + sl, "Properties"+sl, ".cs");
		zip.addFiles(implDir + sl, "", ".csproj");
		zip.addFiles(implDir + sl, "", ".sln");
		zip.close();
	}

	public String getName() {
		return "csharp";
	}

	public String getDescription() {
		return "Resource definitions (+ more todo)";
	}

	public String getTitle() {
		return "C#";
	}

}
