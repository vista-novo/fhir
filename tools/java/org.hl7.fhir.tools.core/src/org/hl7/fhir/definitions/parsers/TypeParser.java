package org.hl7.fhir.definitions.parsers;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.definitions.model.TypeRef;

public class TypeParser {

	public List<TypeRef> parse(String n) throws Exception {
		ArrayList<TypeRef> a = new ArrayList<TypeRef>();
		
		Tokeniser tkn = new Tokeniser(n);
		while (tkn.more()) {
			TypeRef t = new TypeRef();
			t.setName(tkn.next());
			String p = tkn.next();
			if (p.equals("(")) {
				t.getParams().add(tkn.next());
				p = tkn.next();
				while (p.equals("|")) {
					t.getParams().add(tkn.next());
					p = tkn.next();
				}
				if (!p.equals(")"))
					throw new Exception("Unexpected token '"+p+"' in type "+n);
				p = tkn.next();
			}
			if (!p.equals("|") && !p.equals(""))
				throw new Exception("Unexpected token '"+p+"' in type "+n);
			a.add(t);
		}
		
		return a;
	}

	private class Tokeniser {
		private String source;
		private int cursor;
		
		private Tokeniser(String src) {
			source = src;
			cursor = 0;
		}
		
		private boolean more() {
			return cursor < source.length();
		}
		
		private String next() throws Exception {
			while (more() && Character.isWhitespace(source.charAt(cursor)))
				cursor++;
			if (!more())
				return "";
			char c = source.charAt(cursor);
			cursor++;
			if (c == '(' || c == ')' || c == '|' || c == '*')
				return String.valueOf(c);
			else if (Character.isLetter(c) || c == '['  || c == '#'  || c == '@') {
				StringBuilder b = new StringBuilder();
				b.append(c);
				while (more() && (Character.isLetter(source.charAt(cursor)) || Character.isDigit(source.charAt(cursor)) || source.charAt(cursor) == ':' 
						|| source.charAt(cursor) == '[' || source.charAt(cursor) == ']' || source.charAt(cursor) == '@' || source.charAt(cursor) == '.')) {
					b.append(source.charAt(cursor));
					cursor++;
				}
				return b.toString();
			} else 
				throw new Exception("Unexpected token '"+c+"' in type "+source);
		}
	}
	
}
