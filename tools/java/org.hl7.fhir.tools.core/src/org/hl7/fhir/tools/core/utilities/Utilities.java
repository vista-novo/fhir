package org.hl7.fhir.tools.core.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Utilities {

	 /**
     * Returns the plural form of the word in the string.
     * 
     * Examples:
     * 
     * <pre>
     *   inflector.pluralize(&quot;post&quot;)               #=&gt; &quot;posts&quot;
     *   inflector.pluralize(&quot;octopus&quot;)            #=&gt; &quot;octopi&quot;
     *   inflector.pluralize(&quot;sheep&quot;)              #=&gt; &quot;sheep&quot;
     *   inflector.pluralize(&quot;words&quot;)              #=&gt; &quot;words&quot;
     *   inflector.pluralize(&quot;the blue mailman&quot;)   #=&gt; &quot;the blue mailmen&quot;
     *   inflector.pluralize(&quot;CamelOctopus&quot;)       #=&gt; &quot;CamelOctopi&quot;
     * </pre>
     * 
     * 
     * 
     * Note that if the {@link Object#toString()} is called on the supplied object, so this method works for non-strings, too.
     * 
     * 
     * @param word the word that is to be pluralized.
     * @return the pluralized form of the word, or the word itself if it could not be pluralized
     * @see #singularize(Object)
     */
    public static String pluralize( String word ) {
    	Inflector inf = new Inflector();
    	return inf.pluralize(word);
    }
    
    public static void stringToFile(String content, String dst) throws Exception {
		File file = new File(dst);
		FileOutputStream s = new FileOutputStream(file);
		OutputStreamWriter sw = new OutputStreamWriter(s);
		sw.write(content);
		sw.flush();
		s.close();
	}

    public static String fileToString(String src) throws Exception {
		File file = new File(src);
		FileInputStream s = new FileInputStream(file);
		InputStreamReader sr = new InputStreamReader(s);
		StringBuilder b = new StringBuilder();
		while (sr.ready()) {
			char c = (char) sr.read();
			b.append(c);
		}
		return b.toString();
	}

	public static boolean IsInteger(String string) {
		try {
			int i = Integer.parseInt(string);
			return i != i+1;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String escapeXml(String doco) {
		if (doco == null)
			return "";
		
		StringBuilder b = new StringBuilder();
		for (char c : doco.toCharArray()) {
		  if (c == '<')
			  b.append("&lt;");
		  else if (c == '<')
			  b.append("&gt;");
		  else if (c == '&')
			  b.append("&amp;");
		  else 
			  b.append(c);
		}		
		return b.toString();
	}

	public static boolean isCSharpReservedWord(String word) {
	    if (word.equals("abstract")) return true;
	    if (word.equals("as")) return true;
	    if (word.equals("base")) return true;
	    if (word.equals("bool")) return true;
	    if (word.equals("break")) return true;
	    if (word.equals("byte")) return true;
	    if (word.equals("case")) return true;
	    if (word.equals("catch")) return true;
	    if (word.equals("char")) return true;
	    if (word.equals("checked")) return true;
	    if (word.equals("class")) return true;
	    if (word.equals("const")) return true;
	    if (word.equals("continue")) return true;
	    if (word.equals("decimal")) return true;
	    if (word.equals("default")) return true;
	    if (word.equals("delegate")) return true;
	    if (word.equals("do")) return true;
	    if (word.equals("double")) return true;
	    if (word.equals("else")) return true;
	    if (word.equals("enum")) return true;
	    if (word.equals("event")) return true;
	    if (word.equals("explicit")) return true;
	    if (word.equals("extern")) return true;
	    if (word.equals("false")) return true;
	    if (word.equals("finally")) return true;
	    if (word.equals("fixed")) return true;
	    if (word.equals("float")) return true;
	    if (word.equals("for")) return true;
	    if (word.equals("foreach")) return true;
	    if (word.equals("goto")) return true;
	    if (word.equals("if")) return true;
	    if (word.equals("implicit")) return true;
	    if (word.equals("in")) return true;
	    if (word.equals("in(genericmodifier)")) return true;
	    if (word.equals("int")) return true;
	    if (word.equals("interface")) return true;
	    if (word.equals("internal")) return true;
	    if (word.equals("is")) return true;
	    if (word.equals("lock")) return true;
	    if (word.equals("long")) return true;
	    if (word.equals("namespace")) return true;
	    if (word.equals("new")) return true;
	    if (word.equals("null")) return true;
	    if (word.equals("object")) return true;
	    if (word.equals("operator")) return true;
	    if (word.equals("out")) return true;
	    if (word.equals("out(genericmodifier)")) return true;
	    if (word.equals("override")) return true;
	    if (word.equals("params")) return true;
	    if (word.equals("private")) return true;
	    if (word.equals("protected")) return true;
	    if (word.equals("public")) return true;
	    if (word.equals("readonly")) return true;
	    if (word.equals("ref")) return true;
	    if (word.equals("return")) return true;
	    if (word.equals("sbyte")) return true;
	    if (word.equals("sealed")) return true;
	    if (word.equals("short")) return true;
	    if (word.equals("sizeof")) return true;
	    if (word.equals("stackalloc")) return true;
	    if (word.equals("static")) return true;
	    if (word.equals("string")) return true;
	    if (word.equals("struct")) return true;
	    if (word.equals("switch")) return true;
	    if (word.equals("this")) return true;
	    if (word.equals("throw")) return true;
	    if (word.equals("true")) return true;
	    if (word.equals("try")) return true;
	    if (word.equals("typeof")) return true;
	    if (word.equals("uint")) return true;
	    if (word.equals("ulong")) return true;
	    if (word.equals("unchecked")) return true;
	    if (word.equals("unsafe")) return true;
	    if (word.equals("ushort")) return true;
	    if (word.equals("using")) return true;
	    if (word.equals("virtual")) return true;
	    if (word.equals("void")) return true;
	    if (word.equals("volatile")) return true;
	    if (word.equals("while")) return true;
	    return false;
	}
	
	public static boolean isJavaReservedWord(String word) {
		if (word.equals("abstract")) return true; 	
		if (word.equals("assert")) return true;
		if (word.equals("boolean")) return true;
		if (word.equals("break")) return true; 	
		if (word.equals("byte")) return true; 	
		if (word.equals("case")) return true;
		if (word.equals("catch")) return true; 	
		if (word.equals("char")) return true; 	
		if (word.equals("class")) return true; 	
		if (word.equals("const")) return true; 	
		if (word.equals("continue")) return true; 	
		if (word.equals("default")) return true;
		if (word.equals("double")) return true; 	
		if (word.equals("do")) return true; 	
		if (word.equals("else")) return true; 	
		if (word.equals("enum")) return true; 	
		if (word.equals("extends")) return true; 	
		if (word.equals("false")) return true;
		if (word.equals("final")) return true; 	
		if (word.equals("finally")) return true; 	
		if (word.equals("float")) return true; 	
		if (word.equals("for")) return true; 	
		if (word.equals("goto")) return true; 	
		if (word.equals("if")) return true;
		if (word.equals("implements")) return true; 	
		if (word.equals("import")) return true; 	
		if (word.equals("instanceof")) return true; 	
		if (word.equals("int")) return true; 	
		if (word.equals("interface")) return true; 	
		if (word.equals("long")) return true;
		if (word.equals("native")) return true; 	
		if (word.equals("new")) return true; 	
		if (word.equals("null")) return true; 	
		if (word.equals("package")) return true; 	
		if (word.equals("private")) return true; 	
		if (word.equals("protected")) return true;
		if (word.equals("public")) return true; 	
		if (word.equals("return")) return true; 	
		if (word.equals("short")) return true; 	
		if (word.equals("static")) return true; 	
		if (word.equals("strictfp")) return true; 	
		if (word.equals("super")) return true;
		if (word.equals("switch")) return true; 	
		if (word.equals("synchronized")) return true; 	
		if (word.equals("this")) return true; 	
		if (word.equals("throw")) return true; 	
		if (word.equals("throws")) return true; 	
		if (word.equals("transient")) return true;
		if (word.equals("true")) return true; 	
		if (word.equals("try")) return true; 	
		if (word.equals("void")) return true; 	
		if (word.equals("volatile")) return true;
		if (word.equals("while")) return true;
		return false;
	}
	
	
}
