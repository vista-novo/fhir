/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getDate <em>Date</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getVersion <em>Version</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getPrimitives <em>Primitives</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getEvents <em>Events</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getStructs <em>Structs</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getEReference0 <em>EReference0</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions()
 * @model
 * @generated
 */
public interface Definitions extends NameScope {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Primitives</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitives</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitives</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_Primitives()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrimitiveTypeDefn> getPrimitives();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstrainedTypeDefn> getConstraints();

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.EventDefn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventDefn> getEvents();

	/**
	 * Returns the value of the '<em><b>Profiles</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.ProfileDefn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profiles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profiles</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_Profiles()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProfileDefn> getProfiles();

	/**
	 * Returns the value of the '<em><b>Structs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structs</em>' containment reference.
	 * @see #setStructs(CompositeTypeDefn)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_Structs()
	 * @model containment="true"
	 * @generated
	 */
	CompositeTypeDefn getStructs();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getStructs <em>Structs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structs</em>' containment reference.
	 * @see #getStructs()
	 * @generated
	 */
	void setStructs(CompositeTypeDefn value);

	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(TypeDefn)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getDefinitions_EReference0()
	 * @model
	 * @generated
	 */
	TypeDefn getEReference0();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(TypeDefn value);

} // Definitions
