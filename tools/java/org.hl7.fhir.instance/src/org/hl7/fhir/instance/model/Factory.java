package org.hl7.fhir.instance.model;

import java.net.URI;
import java.net.URISyntaxException;

import org.hl7.fhir.instance.model.Contact.ContactSystem;

/*
Copyright (c) 2011-2013, HL7, Inc
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



public class Factory {

  public static Id newId(String value) {
    if (value == null)
      return null;
    Id res = new Id();
    res.setValue(value);
    return res;
	}

  public static String_ newString_(String value) {
    if (value == null)
      return null;
    String_ res = new String_();
    res.setValue(value);
    return res;
  }

  public static Uri newUri(String value) throws URISyntaxException {
    if (value == null)
      return null;
    Uri res = new Uri();
    res.setValue(new URI(value));
    return res;
  }

  public static DateTime newDateTime(String value) {
    if (value == null)
      return null;
    DateTime res = new DateTime();
    res.setValue(value);
    return res;
  }

  public static Date newDate(String value) {
    if (value == null)
      return null;
    Date res = new Date();
    res.setValue(value);
    return res;
  }

  public static Code newCode(String value) {
    if (value == null)
      return null;
    Code res = new Code();
    res.setValue(value);
    return res;
  }

  public static Integer newInteger(int value) {
    Integer res = new Integer();
    res.setValue(value);
    return res;
  }
  
  public static Integer newInteger(java.lang.Integer value) {
    if (value == null)
      return null;
    Integer res = new Integer();
    res.setValue(value);
    return res;
  }
  
  public static Boolean newBoolean(boolean value) {
    Boolean res = new Boolean();
    res.setValue(value);
    return res;
  }
  
  public static Contact newContact(ContactSystem system, String value) {
	Contact res = new Contact();
	res.setSystemSimple(system);
	res.setValue(newString_(value));
	return res;
  }

	public static Extension newExtension(String uri, Type value, boolean evenIfNull) throws Exception {
		if (!evenIfNull && value == null)
			return null;
		Extension e = new Extension();
		e.setUrlSimple(new URI(uri));
		e.setValue(value);
	  return e;
  }

	public static CodeableConcept newCodeableConcept(String code, String system, String display) throws Exception {
		CodeableConcept cc = new CodeableConcept();
		Coding c = new Coding();
		c.setCodeSimple(code);
		c.setSystemSimple(new URI(system));
		c.setDisplaySimple(display);
		cc.getCoding().add(c);
	  return cc;
  }

	public static ResourceReference makeResourceReference(String type, String url) throws Exception {
	  ResourceReference rr = new ResourceReference();
	  rr.setTypeSimple(type);
	  rr.setReferenceSimple(url);
	  return rr;
  }
  
}
