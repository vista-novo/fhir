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
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getEvents <em>Events</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getProfiles <em>Profiles</em>}</li>
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
	 *        extendedMetaData="name='event'"
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

} // Definitions
