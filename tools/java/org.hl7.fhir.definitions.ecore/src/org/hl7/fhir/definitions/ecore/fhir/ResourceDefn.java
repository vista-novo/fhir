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
 * A representation of the model object '<em><b>Resource Defn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#isSandbox <em>Sandbox</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getRoot <em>Root</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getExample <em>Example</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getSearches <em>Searches</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getResourceDefn()
 * @model
 * @generated
 */
public interface ResourceDefn extends NameScope, CompositeTypeDefn {
	/**
	 * Returns the value of the '<em><b>Example</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.Example}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Example</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Example</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getResourceDefn_Example()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Example> getExample();

	/**
	 * Returns the value of the '<em><b>Sandbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sandbox</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sandbox</em>' attribute.
	 * @see #setSandbox(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getResourceDefn_Sandbox()
	 * @model required="true"
	 * @generated
	 */
	boolean isSandbox();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#isSandbox <em>Sandbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sandbox</em>' attribute.
	 * @see #isSandbox()
	 * @generated
	 */
	void setSandbox(boolean value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(ElementDefn)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getResourceDefn_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ElementDefn getRoot();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(ElementDefn value);

	/**
	 * Returns the value of the '<em><b>Searches</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Searches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Searches</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getResourceDefn_Searches()
	 * @model containment="true"
	 *        extendedMetaData="name='search'"
	 * @generated
	 */
	EList<SearchParameter> getSearches();

} // ResourceDefn
