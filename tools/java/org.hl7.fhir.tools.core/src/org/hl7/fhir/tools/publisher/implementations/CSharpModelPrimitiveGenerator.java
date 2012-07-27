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
public class CSharpModelPrimitiveGenerator extends GenBlock {

	CSharpModelResourceGenerator rgen;
	
	private Definitions definitions;
	
	
	public Definitions getDefinitions() {
		return definitions;
	}

	
	public CSharpModelPrimitiveGenerator(Definitions defs)
	{
		definitions = defs;
		
		rgen = new CSharpModelResourceGenerator(defs);
	}

	
	public GenBlock generatePrimitives( List<PrimitiveTypeDefn> primitives ) throws Exception
	{
		begin();
		
		inc( rgen.header(definitions.getDate(), definitions.getVersion()) );
		
		ln("namespace HL7.Fhir.Instance.Model");
		bs("{");
			for( PrimitiveTypeDefn primitive : definitions.getPrimitives())
			{
				primitiveType(primitive);
				ln();
			}
		es("}");
		
		return end();
	}
 
	
	public GenBlock primitiveType( PrimitiveTypeDefn primitive ) throws Exception
	{
		begin();
		
		String className = GeneratorUtils.mapPrimitiveToFhirCSharpType(primitive.getName());
		
		String csharpPrimitive = GeneratorUtils.mapPrimitiveToCSharpType(primitive.getName()); 
		boolean isNullablePrimitive = csharpPrimitive.endsWith("?");
		
		ln( "// " + primitive.getAnnotations().getDefinition() );
		ln("public partial class "); 
			nl( className ); 
			nl( " : ");
			nl( "Primitive<" );
				nl( csharpPrimitive );
			nl(">");
	    bs("{");
	    	if( primitive.getPattern() != null )
	    	{
	    		ln("// Must conform to the pattern ");
	    			nl( "\"" + primitive.getPattern() + "\"" );
        		ln("public const string PATTERN = @");
        			nl("\"" + primitive.getPattern() + "\";");
        		ln();
        	}
        
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
	        // This is an explicit cast because you'll lose information about
	        // dataAbsentReasons, refid, extensions
	        ln("public static explicit operator ");
	        	nl(csharpPrimitive);
	        	nl("(" + className + " value)");
	        bs("{");
	            ln("return value.Contents;");
	        es("}");
	        ln();
	        
	        // If the FhirPrimitive represents data using a C# nullable
	        // primitive, generate another cast from the FhirPrimitive to the
	        // non-nullable C# primitive.
	        if( isNullablePrimitive )
	        {
	        	String nonNullablePrimitive = csharpPrimitive.substring(0, csharpPrimitive.length()-1);
	        	
	        	ln("public static explicit operator ");
	        		nl(nonNullablePrimitive);
	        		nl("(" + className + " source)");
	        	bs("{");
		            ln("if (source.Contents.HasValue)");
		            ln("	return source.Contents.Value;");
		            ln("else");
		            ln("	throw new InvalidCastException();");
		        es("}");
	        }
	    es("}");
		
	    return end();
	}
}
