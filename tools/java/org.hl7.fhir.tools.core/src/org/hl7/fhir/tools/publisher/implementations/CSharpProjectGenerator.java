package org.hl7.fhir.tools.publisher.implementations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class CSharpProjectGenerator 
{	
	public void build( String destDir, List<String> cSharpProjectFiles ) throws IOException
	{
//		if( !destDir.endsWith(File.separator) )
//			destDir += File.separator;
//		
//		Path p = Paths.get(destDir + "HL7.Fhir.Instance.csproj.template");	
//		List<String> templateContents = 
//				Files.readAllLines(p,Charset.forName("UTF-8"));
//		
//		List<String> itemGroup = buildItemGroupContents(cSharpProjectFiles);
//		List<String> outputLines = replaceTemplateVar( templateContents, "@@@PROJECTFILES@@@", itemGroup);
//		
//		Path outPath = Paths.get(destDir + "HL7.Fhir.Instance.csproj");
//		Files.write(outPath, outputLines, Charset.forName("UTF-8"));
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
	
	private void addProjectHeader( OutputStreamWriter writer )
	{
//		writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
//		"<Project ToolsVersion=\"4.0\" DefaultTargets=\"Build\" xmlns=\"http://schemas.microsoft.com/developer/msbuild/2003\">" +
//		"<PropertyGroup>" +
//		"<Configuration Condition=\" '$(Configuration)' == '' \">Debug</Configuration>" +
//		"<Platform Condition=\" '$(Platform)' == '' \">AnyCPU</Platform>" +
//		"<ProductVersion>8.0.30703</ProductVersion>" +
//		"<SchemaVersion>2.0</SchemaVersion>" +
//		"<ProjectGuid>{3CA811D7-19A7-43AC-A403-1F35E4EC2BFC}</ProjectGuid>" +
//		"<OutputType>Library</OutputType>" +
//		"<AppDesignerFolder>Properties</AppDesignerFolder>" +
//		"<RootNamespace>HL7.Fhir.Instance</RootNamespace>" +
//		"<AssemblyName>HL7.Fhir.Instance</AssemblyName>" +
//		"<TargetFrameworkVersion>v4.0</TargetFrameworkVersion>" +
//		"<FileAlignment>512</FileAlignment>" +
//		"</PropertyGroup>" +
//		"<PropertyGroup Condition=\" '$(Configuration)|$(Platform)' == 'Debug|AnyCPU' \">" +
//		"<DebugSymbols>true</DebugSymbols>" +
//		"<DebugType>full</DebugType>" +
//		"<Optimize>false</Optimize>" +
//		"<OutputPath>bin\Debug\</OutputPath>" +
//		"<DefineConstants>DEBUG;TRACE</DefineConstants>" +
//		"<ErrorReport>prompt</ErrorReport>" +
//		"<WarningLevel>4</WarningLevel>" +
//  </PropertyGroup>
//  <PropertyGroup Condition=\" '$(Configuration)|$(Platform)' == 'Release|AnyCPU' \">
//    <DebugType>pdbonly</DebugType>
//    <Optimize>true</Optimize>
//    <OutputPath>bin\Release\</OutputPath>
//    <DefineConstants>TRACE</DefineConstants>
//    <ErrorReport>prompt</ErrorReport>
//    <WarningLevel>4</WarningLevel>
//  </PropertyGroup>
//  <ItemGroup>
//    <Reference Include=\"System\" />
//    <Reference Include=\"System.Core\" />
//    <Reference Include=\"System.Xml.Linq\" />
//    <Reference Include=\"System.Data.DataSetExtensions\" />
//    <Reference Include=\"Microsoft.CSharp\" />
//    <Reference Include=\"System.Data\" />
//    <Reference Include=\"System.Xml\" />
//  </ItemGroup>");
	}
	
}
