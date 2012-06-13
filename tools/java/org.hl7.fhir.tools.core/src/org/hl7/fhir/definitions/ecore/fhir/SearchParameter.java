/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getCode <em>Code</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getDescription <em>Description</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getSearchParameter()
 * @model
 * @generated
 */
public interface SearchParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getSearchParameter_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getSearchParameter_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.hl7.fhir.definitions.ecore.fhir.SearchType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchType
	 * @see #setType(SearchType)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getSearchParameter_Type()
	 * @model
	 * @generated
	 */
	SearchType getType();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchType
	 * @see #getType()
	 * @generated
	 */
	void setType(SearchType value);

} // SearchParameter
