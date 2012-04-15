package org.hl7.fhir.utilities.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.hl7.fhir.utilities.Utilities;
import org.json.JSONObject;
import org.json.XML;


public class JsonGenerator {

	public void generate(File source, File dest) throws Exception {
		String xml = Utilities.fileToString(source.getAbsolutePath());
		JSONObject json = XML.toJSONObject(xml);
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream((dest)));
		json.write(writer);
		writer.flush();
		writer.close();
	}
}
