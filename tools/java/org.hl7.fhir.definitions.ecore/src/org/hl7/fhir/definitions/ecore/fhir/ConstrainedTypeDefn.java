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
 * A representation of the model object '<em><b>Constrained Type Defn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn#getConstrains <em>Constrains</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn#getDetails <em>Details</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getConstrainedTypeDefn()
 * @model
 * @generated
 */
public interface ConstrainedTypeDefn extends CompositeTypeDefn {
	/**
	 * Returns the value of the '<em><b>Constrains</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrains</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrains</em>' containment reference.
	 * @see #setConstrains(CompositeTypeDefn)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getConstrainedTypeDefn_Constrains()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CompositeTypeDefn getConstrains();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn#getConstrains <em>Constrains</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constrains</em>' containment reference.
	 * @see #getConstrains()
	 * @generated
	 */
	void setConstrains(CompositeTypeDefn value);

	/**
	 * Returns the value of the '<em><b>Details</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.Invariant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getConstrainedTypeDefn_Details()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Invariant> getDetails();

} // ConstrainedTypeDefn
