/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Search Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getSearchType()
 * @model
 * @generated
 */
public enum SearchType implements Enumerator {
	/**
	 * The '<em><b>Integer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGER_VALUE
	 * @generated
	 * @ordered
	 */
	INTEGER(0, "integer", "integer"),

	/**
	 * The '<em><b>Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_VALUE
	 * @generated
	 * @ordered
	 */
	NAME(1, "name", "name"),

	/**
	 * The '<em><b>Text</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT(2, "text", "text"),

	/**
	 * The '<em><b>Token</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOKEN_VALUE
	 * @generated
	 * @ordered
	 */
	TOKEN(3, "token", "token"),

	/**
	 * The '<em><b>Qtoken</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QTOKEN_VALUE
	 * @generated
	 * @ordered
	 */
	QTOKEN(4, "qtoken", "EEnumLiteral0");

	/**
	 * The '<em><b>Integer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Integer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTEGER
	 * @model name="integer"
	 * @generated
	 * @ordered
	 */
	public static final int INTEGER_VALUE = 0;

	/**
	 * The '<em><b>Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME
	 * @model name="name"
	 * @generated
	 * @ordered
	 */
	public static final int NAME_VALUE = 1;

	/**
	 * The '<em><b>Text</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Text</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT
	 * @model name="text"
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_VALUE = 2;

	/**
	 * The '<em><b>Token</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Token</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOKEN
	 * @model name="token"
	 * @generated
	 * @ordered
	 */
	public static final int TOKEN_VALUE = 3;

	/**
	 * The '<em><b>Qtoken</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Qtoken</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QTOKEN
	 * @model name="qtoken" literal="EEnumLiteral0"
	 * @generated
	 * @ordered
	 */
	public static final int QTOKEN_VALUE = 4;

	/**
	 * An array of all the '<em><b>Search Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SearchType[] VALUES_ARRAY =
		new SearchType[] {
			INTEGER,
			NAME,
			TEXT,
			TOKEN,
			QTOKEN,
		};

	/**
	 * A public read-only list of all the '<em><b>Search Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SearchType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Search Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SearchType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SearchType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Search Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SearchType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SearchType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Search Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SearchType get(int value) {
		switch (value) {
			case INTEGER_VALUE: return INTEGER;
			case NAME_VALUE: return NAME;
			case TEXT_VALUE: return TEXT;
			case TOKEN_VALUE: return TOKEN;
			case QTOKEN_VALUE: return QTOKEN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SearchType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SearchType
