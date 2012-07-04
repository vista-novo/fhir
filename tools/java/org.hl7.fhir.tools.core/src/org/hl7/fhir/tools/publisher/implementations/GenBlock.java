package org.hl7.fhir.tools.publisher.implementations;

import java.util.Arrays;
import java.util.Stack;

/*
Copyright (c) 2011-2012, HL7, Inc
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
   list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
   this list of conditions and the following disclaimer in the documentation 
   and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
   endorse or promote products derived from this software without specific 
   prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

*/
public class GenBlock {

	Stack<Integer> leftMargin = new Stack<Integer>();
	
	private int currentMargin = 0;
	private int currentPos = 0;
	
	private StringBuilder block = new StringBuilder();
	
	public GenBlock()
	{
	}
	
	public void begin()
	{
		leftMargin.push(currentMargin);
		currentMargin = currentPos;
	}
 
	public GenBlock end() throws Exception
	{
		if( leftMargin.isEmpty() )
			throw new Exception( "Unmatched number of begin/end blocks: end without begin");
		
		currentMargin = leftMargin.pop();
		//currentPos = currentMargin;
		
		return this;
	}
	
	public GenBlock ln(String line)
	{
		if( line == null ) line = "(null)";
		
		if( currentPos > currentMargin )
		{
			block.append("\r\n");
			block.append(genMargin(currentMargin));
			currentPos = currentMargin;
		}
		
		if( line.equals("") )
		{
			block.append("\r\n");
			block.append(genMargin(currentMargin));
		}
		else
			nl(line);
	
		return this;
	}
	
	public GenBlock ln() throws Exception
	{
		return ln("");
	}
	
	public GenBlock nl(String literal)
	{
		if( literal == null ) literal = "(null)";
		
		literal = literal.replace("\t", "    ");
		
		block.append(literal);
		currentPos += literal.length();
		
		return this;
	}
	
	public String buildContents() throws Exception
	{
		if( !leftMargin.isEmpty() )
			throw new Exception( "Unmatched number of begin/end blocks: begin without end" );
		return block.toString();
	}
	
	private String genMargin(int size)
	{
		if( size == 0 ) return "";
		
		char[] charArray = new char[size];
		Arrays.fill(charArray,' ');
		return new String(charArray);
	}
}
