/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Defn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.PrimitiveTypeDefnImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.PrimitiveTypeDefnImpl#getXsdtype <em>Xsdtype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeDefnImpl extends TypeDefnImpl implements PrimitiveTypeDefn {
	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getXsdtype() <em>Xsdtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsdtype()
	 * @generated
	 * @ordered
	 */
	protected static final String XSDTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXsdtype() <em>Xsdtype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXsdtype()
	 * @generated
	 * @ordered
	 */
	protected String xsdtype = XSDTYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeDefnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FhirPackage.Literals.PRIMITIVE_TYPE_DEFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.PRIMITIVE_TYPE_DEFN__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getXsdtype() {
		return xsdtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setXsdtype(String newXsdtype) {
		String oldXsdtype = xsdtype;
		xsdtype = newXsdtype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.PRIMITIVE_TYPE_DEFN__XSDTYPE, oldXsdtype, xsdtype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FhirPackage.PRIMITIVE_TYPE_DEFN__PATTERN:
				return getPattern();
			case FhirPackage.PRIMITIVE_TYPE_DEFN__XSDTYPE:
				return getXsdtype();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FhirPackage.PRIMITIVE_TYPE_DEFN__PATTERN:
				setPattern((String)newValue);
				return;
			case FhirPackage.PRIMITIVE_TYPE_DEFN__XSDTYPE:
				setXsdtype((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FhirPackage.PRIMITIVE_TYPE_DEFN__PATTERN:
				setPattern(PATTERN_EDEFAULT);
				return;
			case FhirPackage.PRIMITIVE_TYPE_DEFN__XSDTYPE:
				setXsdtype(XSDTYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FhirPackage.PRIMITIVE_TYPE_DEFN__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
			case FhirPackage.PRIMITIVE_TYPE_DEFN__XSDTYPE:
				return XSDTYPE_EDEFAULT == null ? xsdtype != null : !XSDTYPE_EDEFAULT.equals(xsdtype);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (pattern: ");
		result.append(pattern);
		result.append(", xsdtype: ");
		result.append(xsdtype);
		result.append(')');
		return result.toString();
	}

} //PrimitiveTypeDefnImpl
