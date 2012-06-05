package org.hl7.fhir.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class TextFile {

	public static List<String> readAllLines(String path) throws IOException
	{
		List<String> result = new ArrayList<String>();
		
		File file = new File(path);
		FileInputStream s = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(s,"UTF-8"));
		
		while( reader.ready() )
			result.add(reader.readLine());
		
		s.close();
		
		return result;
	}
	
	public static void writeAllLines(String path, List<String> lines) throws IOException
	{
		File file = new File(path);
		FileOutputStream s = new FileOutputStream(file);
		OutputStreamWriter sw = new OutputStreamWriter(s, "UTF-8");
		
		for( String line : lines )
			sw.write(line + "\r\n");
		
		sw.flush();
		s.close();
	}
	
	
    public static void stringToFile(String content, String path) throws Exception {
		File file = new File(path);
		FileOutputStream s = new FileOutputStream(file);
		OutputStreamWriter sw = new OutputStreamWriter(s, "UTF-8");
		sw.write(content);
		sw.flush();
		s.close();
	}

    public static String fileToString(String src) throws Exception {
		File file = new File(src);
		FileInputStream s = new FileInputStream(file);
		InputStreamReader sr = new InputStreamReader(s, "UTF-8");
		StringBuilder b = new StringBuilder();
		while (sr.ready()) {
			char c = (char) sr.read();
			b.append(c);
		}
		return b.toString();
	}
}
