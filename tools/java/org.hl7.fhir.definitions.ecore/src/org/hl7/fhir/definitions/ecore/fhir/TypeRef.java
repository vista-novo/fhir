/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getParam <em>Param</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsAnyResource <em>Is Any Resource</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsAnyDataType <em>Is Any Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef()
 * @model
 * @generated
 */
public interface TypeRef extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Any Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Any Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Any Resource</em>' attribute.
	 * @see #setIsAnyResource(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_IsAnyResource()
	 * @model
	 * @generated
	 */
	boolean isIsAnyResource();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsAnyResource <em>Is Any Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Any Resource</em>' attribute.
	 * @see #isIsAnyResource()
	 * @generated
	 */
	void setIsAnyResource(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Any Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Any Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Any Data Type</em>' attribute.
	 * @see #setIsAnyDataType(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_IsAnyDataType()
	 * @model
	 * @generated
	 */
	boolean isIsAnyDataType();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsAnyDataType <em>Is Any Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Any Data Type</em>' attribute.
	 * @see #isIsAnyDataType()
	 * @generated
	 */
	void setIsAnyDataType(boolean value);

	/**
	 * Returns the value of the '<em><b>Param</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' attribute list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_Param()
	 * @model
	 * @generated
	 */
	EList<String> getParam();

} // TypeRef
