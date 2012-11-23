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
 * A representation of the model object '<em><b>Defined Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getCode <em>Code</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinedCode()
 * @model
 * @generated
 */
public interface DefinedCode extends EObject {
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
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinedCode_Code()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' attribute.
	 * @see #setDefinition(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinedCode_Definition()
	 * @model required="true"
	 *        extendedMetaData="kind='attribute'"
	 * @generated
	 */
	String getDefinition();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getDefinition <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' attribute.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(String value);

} // DefinedCode
