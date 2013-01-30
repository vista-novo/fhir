package org.hl7.fhir.tools.publisher.implementations;

import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;

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
public class CSharpPrimitiveParserGenerator extends GenBlock {

	CSharpModelResourceGenerator rgen;

	private Definitions definitions;

	public Definitions getDefinitions() {
		return definitions;
	}

	public CSharpPrimitiveParserGenerator(Definitions defs) {
		definitions = defs;

		rgen = new CSharpModelResourceGenerator(defs);
	}

	public GenBlock generatePrimitiveParser(List<PrimitiveTypeDefn> primitives)
			throws Exception {
		begin();

		inc(rgen.header(definitions.getDate(), definitions.getVersion()));
		ln();
		ln("using HL7.Fhir.Instance.Model;");
		ln("using System.Xml;");
		ln();
		ln("namespace HL7.Fhir.Instance.Parsers");
		bs("{");
			ln("public static partial class PrimitiveParser");
			bs("{");
				for (PrimitiveTypeDefn primitive : definitions.getPrimitives())
				{
					// Xhtml parser is hand-built, generate the rest
					if( !primitive.getName().equals(TypeRef.XHTML_PSEUDOTYPE_NAME) )
						primitiveTypeParser(primitive);
						
					ln();
				}
			es("}");
		es("}");

		return end();
	}

	public GenBlock primitiveTypeParser(PrimitiveTypeDefn primitive)
			throws Exception {
		begin();

		String csharpPrimitive = GeneratorUtils
				.mapPrimitiveToFhirCSharpType(primitive.getName());

		ln("public static ");
		nl(csharpPrimitive);
		nl(" Parse" + csharpPrimitive);
		nl("(IFhirReader reader, ErrorList errors)");
		bs("{");
			ln("var result = new "); nl(csharpPrimitive); nl("();");
			ln();
        	ln("try");
        	bs("{");
				ln("string currentElementName = reader.CurrentElementName;");
				ln("reader.EnterElement();");
				ln();
            	ln("while (reader.IsAtElement())");
            	bs("{");
                	ln("if (reader.IsAtRefIdElement())");
                	ln("	result.ReferralId = reader.ReadRefIdContents();");
                	ln("else if (reader.IsAtPrimitiveValueElement())");
                    ln("	result.Contents = ");
                    	nl(csharpPrimitive); nl(".Parse(reader.ReadPrimitiveContents()).Contents;");
                	ln("else");
                    bs("{");
                        ln("errors.Add(String.Format(\"Encountered unknown element {0}\", reader.CurrentElementName), reader);");
                        ln("reader.SkipSubElementsFor(currentElementName);");
                    es("}");
            	es("}");
				ln();
				ln("reader.LeaveElement();");
            es("}");       
        	ln("catch (FhirFormatException ex)");
        	bs("{");
            	ln("errors.Add(ex.Message, reader);");
        	es("}");
			ln();
        	ln("return result;");
        es("}");
        	
		return end();
	}
}
