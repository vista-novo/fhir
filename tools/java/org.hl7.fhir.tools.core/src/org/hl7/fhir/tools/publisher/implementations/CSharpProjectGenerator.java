package org.hl7.fhir.tools.publisher.implementations;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.hl7.fhir.utilities.TextFile;

public class CSharpProjectGenerator 
{	
	public void build( String destDir, List<String> cSharpProjectFiles ) throws IOException
	{
		if( !destDir.endsWith(File.separator) )
			destDir += File.separator;
		
		List<String> templateContents = TextFile.readAllLines(destDir + "HL7.Fhir.Instance.csproj.template"); 	
		List<String> itemGroup = buildItemGroupContents(cSharpProjectFiles);
		List<String> outputLines = replaceTemplateVar( templateContents, "@@@PROJECTFILES@@@", itemGroup);
		TextFile.writeAllLines(destDir + "HL7.Fhir.Instance.csproj", outputLines);
	}
	

	private List<String> replaceTemplateVar( List<String> source, String template, List<String> contents)
	{
		List<String> result = new ArrayList<String>();

		for( String line : source)
		{
			if( !line.trim().equals(template) )
				result.add(line);
			else
				result.addAll(contents);
		}
		
		return result;
	}
	
	private List<String> buildItemGroupContents(List<String> files)
	{
		List<String> result = new ArrayList<String>();
		
		for( String fileName : files)
		{
			//  <Compile Include="HL7.Fhir.Instance.Model\Prescription.cs" />

			StringBuilder b = new StringBuilder();
			b.append("\t<Compile Include=\"");
			b.append(fileName);
			b.append("\" />");
			
			result.add(b.toString());
		}
	
		return result;
	}
}
