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
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getResourceParam <em>Resource Param</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isTakesAnyResource <em>Takes Any Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef()
 * @model
 * @generated
 */
public interface TypeRef extends EObject {	
	public final static String PRIMITIVE_PSEUDOTYPE_NAME = "Primitive";
	public final static String COMPOSITE_PSEUDOTYPE_NAME = "Composite";
	public final static String IDREF_PSEUDOTYPE_NAME = "idref";

	public final static String RESOURCEREF_TYPE_NAME = "ResourceReference";
	
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
	 * Returns the value of the '<em><b>Resource Param</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Param</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Param</em>' attribute.
	 * @see #setResourceParam(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getTypeRef_ResourceParam()
	 * @model
	 * @generated
	 */
	String getResourceParam();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getResourceParam <em>Resource Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Param</em>' attribute.
	 * @see #getResourceParam()
	 * @generated
	 */
	void setResourceParam(String value);

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

} // TypeRef
