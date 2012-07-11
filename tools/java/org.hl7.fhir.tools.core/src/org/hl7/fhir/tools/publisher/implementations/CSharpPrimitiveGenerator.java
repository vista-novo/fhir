package org.hl7.fhir.tools.publisher.implementations;

import java.util.List;

import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn;

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
public class CSharpPrimitiveGenerator extends GenBlock {

	CSharpResourceGenerator rgen = new CSharpResourceGenerator();
	
	public GenBlock generatePrimitives( List<PrimitiveTypeDefn> primitives,
						Definitions definitions) throws Exception
	{
		begin();
		
		inc( rgen.header(definitions.getDate(), definitions.getVersion()) );
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			for( PrimitiveTypeDefn primitive : definitions.getPrimitives())
			{
				// All time types reuse FhirDateTime and
				// don't need their own primitive classes
				if( !primitive.getName().equals("date") && 
					 !primitive.getName().equals("dateTime") &&
					 !primitive.getName().equals("instant"))
				{
					primitiveType(primitive);
					ln();
				}
			}
		es("}");
		
		return end();
	}
 
	
	public GenBlock primitiveType( PrimitiveTypeDefn primitive ) throws Exception
	{
		begin();
		
		String className = GeneratorUtils.mapPrimitiveToFhirCSharpType(primitive.getName());
		
		String csharpPrimitive = GeneratorUtils.mapPrimitiveToCSharpType(primitive.getName()); 
		
		ln( "// " + primitive.getAnnotations().getDefinition() );
		ln("public partial class "); 
			nl( className ); 
			nl( " : ");
			nl( "Primitive<" );
				nl( csharpPrimitive );
			nl(">");
	    bs("{");
	    	// Generate constructor, taking one parameter - the primitive value
	        ln("public " + className);
	        	nl("(" + csharpPrimitive + " value)");
	        	nl(": base(value) { }");
	        ln();
	        
	        // Generate the cast from a C# primitive to the Fhir primitive
	        ln("public static implicit operator ");
	        	nl(className);
	        	nl("(" + csharpPrimitive + " value)");
	        bs("{");
	            ln( "return new " );
	            	nl(className + "(value);");
	        es("}");
	        ln();
	        
	        // Generate the cast from the Fhir primitive to the C# primitive
	        ln("public static implicit operator ");
	        	nl(csharpPrimitive);
	        	nl("(" + className + " value)");
	        bs("{");
	            ln("return value.Value;");
	        es("}");
	        ln();
	        
	    es("}");
		
	    return end();
	}
}
