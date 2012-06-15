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
 * A representation of the model object '<em><b>Name Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.NameScope#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.NameScope#getTypes <em>Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.NameScope#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getNameScope()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NameScope extends EObject {
	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn}.
	 * It is bidirectional and its opposite is '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getNameScope_Bindings()
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getContainer
	 * @model opposite="container" containment="true"
	 *        extendedMetaData="name='binding'"
	 * @generated
	 */
	EList<BindingDefn> getBindings();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.TypeDefn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getNameScope_Types()
	 * @model containment="true"
	 *        extendedMetaData="name='type'"
	 * @generated
	 */
	EList<TypeDefn> getTypes();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(NameScope)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getNameScope_Parent()
	 * @model transient="true"
	 * @generated
	 */
	NameScope getParent();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.NameScope#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(NameScope value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TypeDefn resolveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<TypeDefn> getTypeByName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<TypeDefn> filterTypes(String name, String scope, String typeKind);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	BindingDefn resolveBinding();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	BindingDefn getBindingByName();

} // NameScope
