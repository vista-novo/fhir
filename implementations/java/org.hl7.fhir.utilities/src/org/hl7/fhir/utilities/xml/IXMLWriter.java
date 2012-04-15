/*******************************************************************************
 * Crown Copyright (c) 2006, 2009, Copyright (c) 2009, 2009 Jiva Medical.
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

/**
 * Generalize 
 * @author dennisn
 */
public interface IXMLWriter {
	
	public abstract void start() throws IOException;

	public abstract void attribute(String namespace, String name, String value,
			boolean onlyIfNotEmpty) throws IOException;

	public abstract void attribute(String namespace, String name, String value)
			throws IOException;

	public abstract void attribute(String name, String value,
			boolean onlyIfNotEmpty) throws IOException;

	public abstract void attribute(String name, String value)
			throws IOException;

	public abstract void attributeNoLines(String name, String value)
			throws IOException;

//	public abstract XMLNamespace findByNamespace(String namespace);

	public abstract boolean namespaceDefined(String namespace);

//	public abstract XMLNamespace findByAbbreviation(String abbreviation);

	public abstract boolean abbreviationDefined(String abbreviation);

//	public abstract XMLNamespace findDefaultNamespace();

	public abstract String getDefaultNamespace();

	public abstract void namespace(String namespace) throws IOException;

	public abstract void setDefaultNamespace(String namespace) throws IOException;

	public abstract void namespace(String namespace, String abbreviation)
			throws IOException;

	public abstract void comment(String comment, boolean doPretty)
			throws IOException;

	public abstract void open(String namespace, String name) throws IOException;

	public abstract void open(String namespace, String name, String comment)
			throws IOException;

	public abstract void close(String name) throws IOException;

	public abstract void close(String namespace, String name)
			throws IOException;

	public abstract void closeToLevel(int count) throws IOException;

	public abstract void close() throws IOException;

	public abstract void open(String name) throws IOException;

	public abstract void element(String namespace, String name, String content,
			boolean onlyIfNotEmpty) throws IOException;

	public abstract void element(String namespace, String name, String content,
			String comment) throws IOException;

	public abstract void element(String namespace, String name, String content)
			throws IOException;

	public abstract void element(String name, String content,
			boolean onlyIfNotEmpty) throws IOException;

	public abstract void element(String name, String content)
			throws IOException;

	public abstract void text(String content) throws IOException;
	
	public abstract void text(String content, boolean dontEscape) throws IOException;

	public abstract void cData(String text) throws IOException;

	public abstract void writeBytes(byte[] bytes) throws IOException;

	public abstract boolean isPretty() throws IOException;

	public abstract void setPretty(boolean pretty) throws IOException;

	/**
	 * Start comment inserts a <!-- in the stream, but allows the user to 
	 * go on creating xml content as usual, with proper formatting applied etc.
	 * Any comments inserted inside a comment will be terminated with -- > instead of -->
	 * so the comment doesn't close prematurely.
	 * @throws IOException 
	 */
	public abstract void startCommentBlock() throws IOException;

	public abstract void endCommentBlock() throws IOException;

}