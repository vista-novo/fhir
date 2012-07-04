/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Type Defn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getElements <em>Elements</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getAllowedGenericTypes <em>Allowed Generic Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#isIsUnnamedComponent <em>Is Unnamed Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getCompositeTypeDefn()
 * @model
 * @generated
 */
public interface CompositeTypeDefn extends TypeDefn, NameScope {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn}.
	 * It is bidirectional and its opposite is '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getParentType <em>Parent Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getCompositeTypeDefn_Elements()
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getParentType
	 * @model opposite="parentType" containment="true"
	 *        extendedMetaData="name='element'"
	 * @generated
	 */
	EList<ElementDefn> getElements();

	/**
	 * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.Invariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariants</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getCompositeTypeDefn_Invariants()
	 * @model containment="true"
	 *        extendedMetaData="name='invariant'"
	 * @generated
	 */
	EList<Invariant> getInvariants();

	/**
	 * Returns the value of the '<em><b>Allowed Generic Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.TypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allowed Generic Types</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allowed Generic Types</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getCompositeTypeDefn_AllowedGenericTypes()
	 * @model containment="true"
	 *        extendedMetaData="name='allowedGenericType'"
	 * @generated
	 */
	EList<TypeRef> getAllowedGenericTypes();

	/**
	 * Returns the value of the '<em><b>Is Unnamed Component</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unnamed Component</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unnamed Component</em>' attribute.
	 * @see #setIsUnnamedComponent(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getCompositeTypeDefn_IsUnnamedComponent()
	 * @model
	 * @generated
	 */
	boolean isIsUnnamedComponent();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#isIsUnnamedComponent <em>Is Unnamed Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unnamed Component</em>' attribute.
	 * @see #isIsUnnamedComponent()
	 * @generated
	 */
	void setIsUnnamedComponent(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isGenericType();

} // CompositeTypeDefn
