package org.hl7.fhir.tools.core.parser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class XmlSpecParser extends InputStreamReader {
	
//	private boolean html = false;
//	
	public XmlSpecParser(InputStream in) {
		super(in);
	}

//	public Root parse() throws Exception {
//	   skipWhitespace(); 
//	   consume('<');
//	   String s = parseToken();
//	   if ("pre".equals(s))
//	   {
//		   consume('>');
//		   html = true;
//		   skipWhitespace(); 
//		   consume('<');
//		   s = parseToken();
//	   }
//	   Root res = new Root();
//	   res.setName(s);
//	   consumeUntil('>');
//	   skipWhitespace();
//	   consume('<');
//	   while (!peekIs('/')) 
//	   {
//		   res.getElements().add(parseElement("."));
//		   skipWhitespace();
//		   consume('<');
//	   }
//	   return res;
//	}
//
//	private Element parseElement(String path) throws Exception {
//		Element e = new Element();
//		e.setName(parseToken());
//		//System.out.println("parse "+e.getName()+" @ "+path);
//		skipWhitespace(); 
//		String s = parseToken();
//		if ("id".equals(s))	{
//			consume('=');
//			consume('"');
//			e.setId(consumeUntil('"'));
//			  skipWhitespace(); 
//	  		  s = parseToken();
//		}
//		if ((!"".equals(s)) && (!"type".equals(s)))
//		{
//		  e.setConformance(pickConformance(s));
//		  skipWhitespace(); 
//  		  s = parseToken();
//		}
//		else
//			e.setConformance(Conformance.Unstated);
//		if (!"".equals(s))
//		{
//  		  if (!"type".equals(s))
//			  throw new Exception("unable to parse element - can't find type");
//  		  consume('=');
//  		  consume('"');
//  		  e.getTypes().addAll(parseTypes(consumeUntil('"')));
//		}
//		consume('>');
//		if (e.getTypes().size() == 1 && e.getTypes().get(0).getName().equals("list"))
//		{
//			consumeUntil('<');
//			if (peekIs('!'))
//			{
//			    consume('!');
//		  	    consume('-');
//			    consume('-');
//				skipWhitespace();
//				String x = parseToken();
//				if (peekIs('+'))
//				{
//					x = x + '+';
//					next();
//				}
//				if ("Zero+".equals(x))
//				{
//					e.setMinCardinality(0);
//					e.setMaxCardinality(null);
//				}
//				else if ("One+".equals(x))
//				{
//					e.setMinCardinality(1);
//					e.setMaxCardinality(null);
//				}
//				else
//					throw new Exception("Unrecognised cardinality "+x);
//		      skipWhitespace();
//			  e.setDoco(consumeUntil("-->").trim());
//  			  consumeUntil('<');
//			}
//		}
//		else
//		{
//			if (e.getConformance() == Conformance.Mandatory || e.getConformance() == Conformance.Unstated)
//				e.setMinCardinality(1);
//			else
//				e.setMinCardinality(0);
//			e.setMaxCardinality(1);
//		  e.setDoco(consumeUntil('<').trim());
//		}
//		
//		while (!peekIs('/'))
//		{
//			   e.getElements().add(parseElement(path+e.getName()+"."));
//			
//			   skipWhitespace();
//			   consume('<');
//		}
//		consumeUntil('>');
//		skipWhitespace(); 
//	
//		return e;
//	}
//
//	
//	
//	private List<Type> parseTypes(String n) throws Exception {
//		ArrayList<Type> a = new ArrayList<Type>();
//		
//		Tokeniser tkn = new Tokeniser(n);
//		while (tkn.more()) {
//			Type t = new Type();
//			t.setName(tkn.next());
//			String p = tkn.next();
//			if (p.equals("(")) {
//				t.getParams().add(tkn.next());
//				p = tkn.next();
//				while (p.equals("|")) {
//					t.getParams().add(tkn.next());
//					p = tkn.next();
//				}
//				if (!p.equals(")"))
//					throw new Exception("Unexpected token '"+p+"' in type "+n);
//				p = tkn.next();
//			}
//			if (!p.equals("|") && !p.equals(""))
//				throw new Exception("Unexpected token '\"+p+\"' in type "+n);
//			a.add(t);
//		}
//		
//		return a;
//	}
//
//	private Conformance pickConformance(String s) throws Exception {
//		if (s.equals("opt"))
//			return Conformance.Optional;
//		if (s.equals("mand"))
//			return Conformance.Mandatory;
//		if (s.equals("cond"))
//			return Conformance.Conditional;
//		if (s.equals("prohibited"))
//			return Conformance.Prohibited;
//		throw new Exception("Unknown Conformance flag: "+s);
//	}
//
//
//	//--- lexing -------------------------------------------------------------
//
//	private int state = 0;
//	private char pc;
//	
//	private char peek() throws Exception
//	{
//	  if (state == 0)
//		  next();
//	  if (state == 1)
//		  return pc;
//	  else
//		  throw new Exception("read past end of source");
//	}
//	
//	private void next() throws Exception
//	{
//		  if (state == 2)
//			  throw new Exception("read past end of source");
//          state = 1;
//		  int i = read();
//		  if (i == -1)
//			  state = 2;
//		  else if (html)
//		  {
//			char c = (char) i;
//			if (c == '<')
//			{
//				do
//				{
//				  c = (char) read();
//				
//				} while (c != '>');
//				next();
//			}
//			else if (c == '&')
//			{
//				StringBuilder b = new StringBuilder();
//				do
//				{
//				  c = (char) read();
//				  if (c != ';')
//					  b.append(c);
//				
//				} while (c != ';');
//				if ("lt".equals(b.toString()))
//					pc = '<';
//				else if ("gt".equals(b.toString()))
//					pc = '>';
//				else if ("amp".equals(b.toString()))
//					pc = '&';
//				else 
//					throw new Exception("unrecognised html escape "+b.toString());
//			}
//			else
//			    pc = c;
//		  }
//		  else
//			    pc = (char) i;
//	}
//
//	private boolean peekIs(char c) throws Exception 
//	{
//		return peek() == c;
//	}
//
//	private String consumeUntil(char c) throws Exception 
//	{
//		StringBuilder s = new StringBuilder();
//		while (!peekIs(c))
//		{
//  		    s.append(peek());
//			next();
//		}
//		next();		
//		return s.toString();
//	}
//
//	private String consumeUntil(String tgt) throws Exception 
//	{
//		StringBuilder s = new StringBuilder();
//		while (state != 2 && (s.length() < tgt.length() || !s.substring(s.length() - tgt.length(), s.length()).equals(tgt)))
//		{
//  		    s.append(peek());
//			next();
//		}
//		if (s.length() < tgt.length() || !s.substring(s.length() - tgt.length(), s.length()).equals(tgt))
//			throw new Exception("unable to find closing "+tgt);
//		
//		return s.substring(0, s.length() - tgt.length());
//	}
//
//	private String parseToken() throws Exception {
//		StringBuilder s = new StringBuilder();
//		while (Character.isJavaIdentifierPart(peek()) || peekIs(':') || peekIs('[') || peekIs(']'))
//		{
//		  s.append(peek());
//		  next();
//		}
//		return s.toString();
//	}
//
//	private void consume(char c) throws Exception {
//		if (!peekIs(c))
//			throw new Exception("unexpected character "+peek()+" expecting "+c);
//		next();
//	}
//
//	private void skipWhitespace() throws Exception {
//		while (Character.isWhitespace(peek())) 
//		{
//		   next();
//		}
//		
//	}
//
	
}
