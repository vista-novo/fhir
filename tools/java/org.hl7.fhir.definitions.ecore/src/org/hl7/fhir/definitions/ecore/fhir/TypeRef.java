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
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getBoundParam <em>Bound Param</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isTakesAnyResource <em>Takes Any Resource</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isTakesAnyDataType <em>Takes Any Data Type</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsUnboundGeneric <em>Is Unbound Generic</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsPseudoType <em>Is Pseudo Type</em>}</li>
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
	 * Returns the value of the '<em><b>Bound Param</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Param</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Param</em>' attribute list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_BoundParam()
	 * @model
	 * @generated
	 */
	EList<String> getBoundParam();

	/**
	 * Returns the value of the '<em><b>Takes Any Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Takes Any Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Takes Any Resource</em>' attribute.
	 * @see #setTakesAnyResource(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_TakesAnyResource()
	 * @model
	 * @generated
	 */
	boolean isTakesAnyResource();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isTakesAnyResource <em>Takes Any Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Takes Any Resource</em>' attribute.
	 * @see #isTakesAnyResource()
	 * @generated
	 */
	void setTakesAnyResource(boolean value);

	/**
	 * Returns the value of the '<em><b>Takes Any Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Takes Any Data Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Takes Any Data Type</em>' attribute.
	 * @see #setTakesAnyDataType(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_TakesAnyDataType()
	 * @model
	 * @generated
	 */
	boolean isTakesAnyDataType();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isTakesAnyDataType <em>Takes Any Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Takes Any Data Type</em>' attribute.
	 * @see #isTakesAnyDataType()
	 * @generated
	 */
	void setTakesAnyDataType(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unbound Generic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unbound Generic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unbound Generic</em>' attribute.
	 * @see #setIsUnboundGeneric(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_IsUnboundGeneric()
	 * @model
	 * @generated
	 */
	boolean isIsUnboundGeneric();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsUnboundGeneric <em>Is Unbound Generic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unbound Generic</em>' attribute.
	 * @see #isIsUnboundGeneric()
	 * @generated
	 */
	void setIsUnboundGeneric(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Pseudo Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Pseudo Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Pseudo Type</em>' attribute.
	 * @see #setIsPseudoType(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_IsPseudoType()
	 * @model
	 * @generated
	 */
	boolean isIsPseudoType();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsPseudoType <em>Is Pseudo Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Pseudo Type</em>' attribute.
	 * @see #isIsPseudoType()
	 * @generated
	 */
	void setIsPseudoType(boolean value);

} // TypeRef
