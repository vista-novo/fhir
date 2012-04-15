/*******************************************************************************
 * Crown Copyright (c) 2006, 2007, Copyright (c) 2006, 2007 Jiva Medical.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jiva Medical - initial API and implementation
 *******************************************************************************/

package org.hl7.fhir.utilities.xml;

import java.io.IOException;
import java.util.Vector;

public class XMLWriterStateStack {

	private Vector<XMLWriterState> items = new Vector<XMLWriterState>();

	public int size(){
		return items.size();
	}
	
	public boolean empty(){
		return items.size() == 0;
	}
	
	public XMLWriterState current() throws IOException {
		if (empty())
			throw new IOException("stack is empty trying to get current");
		return (XMLWriterState)items.get(items.size() - 1);
	}
	
	
	public void push(XMLWriterState element) {
		items.add(element);		
	}
		
	public void clear () {
		if (items != null)
		  items.clear();
	}

	public void pop() throws IOException {
		if (empty())
			throw new IOException("stack is empty trying to pop");
		if (current().isInComment())
			throw new IOException("Must close a comment sequence in the element in which it was started");
		
		items.remove(items.size() - 1);		
	}

	public XMLWriterState item(int index) {
		return (XMLWriterState)items.get(index);
	}

	public boolean inComment() {
		for (int i = 0; i < items.size(); i++) {
			if (((XMLWriterState)items.get(i)).isInComment())
				return true;					
		}
		return false;
	}

}
