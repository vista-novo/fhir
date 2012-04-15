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

public class XMLWriterState {

	private String name;
	private String namespace;
	private boolean children;
	private boolean inComment;
	private boolean pretty;
	
	private XMLNamespace[] namespaceDefns = null;
	
	public void addNamespaceDefn(String namespace, String abbrev) throws IOException {
		XMLNamespace ns;
		ns = getDefnByAbbreviation(abbrev);
		if (ns != null)
			throw new IOException("duplicate namespace declaration on \""+abbrev+"\"");
		ns = new XMLNamespace(namespace, abbrev);
		if (namespaceDefns == null)
			namespaceDefns = new XMLNamespace[] {ns};
		else {
			XMLNamespace[] newns = new XMLNamespace[namespaceDefns.length + 1];
			for (int i = 0; i < namespaceDefns.length; i++) {
				newns[i] = namespaceDefns[i];
			}
			namespaceDefns = newns;
			namespaceDefns[namespaceDefns.length-1] = ns;			
		}
	}

	public XMLNamespace getDefnByNamespace(String namespace) {
		if (namespaceDefns == null)
			return null;
		for (int  i = 0; i < namespaceDefns.length; i++) {
			XMLNamespace element = namespaceDefns[i];
			if (element.getNamespace().equals(namespace))
				return element;
		}
		return null;
	}

	public XMLNamespace getDefnByAbbreviation(String abbreviation) {
		if (namespaceDefns == null)
			return null;
		for (int  i = 0; i < namespaceDefns.length; i++) {
			XMLNamespace element = namespaceDefns[i];
			if (element.getAbbreviation() != null && element.getAbbreviation().equals(abbreviation))
				return element;
		}
		return null;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the namespace
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @param namespace the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * @return the children
	 */
	public boolean hasChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void seeChild() {
		this.children = true;
	}

	public XMLNamespace getDefaultNamespace() {
		if (namespaceDefns == null)
			return null;
		for (int  i = 0; i < namespaceDefns.length; i++) {
			XMLNamespace element = namespaceDefns[i];
			if (element.getAbbreviation() == null)
				return element;
		}
		return null;
	}

	/**
	 * @return the inComment
	 */
	public boolean isInComment() {
		return inComment;
	}

	/**
	 * @param inComment the inComment to set
	 */
	public void setInComment(boolean inComment) {
		this.inComment = inComment;
	}

	/**
	 * @return the pretty
	 */
	public boolean isPretty() {
		return pretty;
	}

	/**
	 * @param pretty the pretty to set
	 */
	public void setPretty(boolean pretty) {
		this.pretty = pretty;
	}

	
}
