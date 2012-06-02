package org.hl7.fhir.utilities;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends InputStreamReader {
	
	public CSVReader(InputStream in) {
		super(in);
	}

	protected boolean parseBoolean(String column) {
		if (column == null)
			return false;
		else if (column.equalsIgnoreCase("y") || column.equalsIgnoreCase("yes") || column.equalsIgnoreCase("true") || column.equalsIgnoreCase("1"))
			return true;
		else
			return false;
	}

	protected String getColumn(String[] titles, String[] values, String column) throws Exception {
		int c = -1;
		String s = "";
		for (int i = 0; i < titles.length; i++) {
			s = s + ","+titles[i];
			if (titles[i].equalsIgnoreCase(column))
				c = i;
		}
		if (c == -1)
			return ""; // throw new Exception("unable to find column "+column+" in "+s.substring(1));
		else if (values.length <= c)
			return "";
		else
			return values[c];
	}

	protected String[] parseLine() throws Exception {
		List<String> res = new ArrayList<String>();
		StringBuilder b = new StringBuilder();
		boolean inQuote = false;

		while (inQuote || (peek() != '\r' && peek() != '\n')) {
			char c = peek();
			next();
			if (c == '"') 
				inQuote = !inQuote;
			else if (!inQuote && c == ',') {
				res.add(b.toString().trim());
				b = new StringBuilder();
			}
			else 
				b.append(c);
		}
		res.add(b.toString().trim());
		while (ready() && (peek() == '\r' || peek() == '\n')) {
			next();
		}
		
		String[] r = new String[] {};
		r = res.toArray(r);
		return r;
		
	}

	private int state = 0;
	private char pc;
	
	private char peek() throws Exception
	{
	  if (state == 0)
		  next();
	  if (state == 1)
		  return pc;
	  else
		  throw new Exception("read past end of source");
	}
	
	private void next() throws Exception
	{
		  if (state == 2)
			  throw new Exception("read past end of source");
          state = 1;
		  int i = read();
		  if (i == -1)
			  state = 2;
		  else 
			  pc = (char) i;
	}

}
