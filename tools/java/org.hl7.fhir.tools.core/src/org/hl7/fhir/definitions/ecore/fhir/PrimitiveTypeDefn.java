/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type Defn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getPrimitiveTypeDefn()
 * @model
 * @generated
 */
public interface PrimitiveTypeDefn extends TypeDefn {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getPrimitiveTypeDefn_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // PrimitiveTypeDefn
