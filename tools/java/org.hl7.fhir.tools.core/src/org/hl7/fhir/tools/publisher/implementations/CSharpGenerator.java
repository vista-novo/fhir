package org.hl7.fhir.tools.publisher.implementations;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.hl7.fhir.definitions.model.DefinedCode;
import org.hl7.fhir.definitions.model.Definitions;
import org.hl7.fhir.definitions.model.ElementDefn;
import org.hl7.fhir.tools.publisher.PlatformGenerator;
import org.hl7.fhir.utilities.Logger;
import org.hl7.fhir.utilities.ZipGenerator;

public class CSharpGenerator extends BaseGenerator implements PlatformGenerator {

	public void generate(Definitions definitions, String destDir,
			String implDir, String version, Date genDate, Logger logger)
			throws Exception {

		char sl = File.separatorChar;
		String modelGenerationDir =  implDir + sl + "org.hl7.fhir.instance.model" + sl;
		
		// Generate a C# file for each Resource class
		for (String n : definitions.getDefinedResources().keySet()) 
		{
			ElementDefn root = definitions.getResourceDefn(n);
			CSharpResourceGenerator cSharpGen = new CSharpResourceGenerator(
					new FileOutputStream(modelGenerationDir + root.getName() + ".cs" ));
		
			cSharpGen.generate(root, definitions.getBindings(), genDate, version );
		}

		//TODO: Generate infrastructure classes
		
		// TODO: Generate a C# file for each "future" Resources
		
		// TODO: Generate a C# file for basic  types

		// TODO: Generate a C# file for structured types
		
		// TODO: Generate a C# file for each Valueset as enum
//		for (DefinedCode n : definitions.getFutureResources().values()) {
//			ElementDefn e = new ElementDefn();
//			e.setName(n.getDefinition());
//			cSharpGen.generate(e, definitions.getBindings());
//		}


		ZipGenerator zip = new ZipGenerator(destDir + "CSharp.zip");
		zip.addFiles(implDir, "", ".cs");
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
