/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.TypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl#getParam <em>Param</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl#isIsAnyResource <em>Is Any Resource</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl#isIsAnyDataType <em>Is Any Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeRefImpl extends EObjectImpl implements TypeRef {
	/**
	 * The cached value of the '{@link #getParam() <em>Param</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParam()
	 * @generated
	 * @ordered
	 */
	protected EList<String> param;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAnyResource() <em>Is Any Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAnyResource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ANY_RESOURCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAnyResource() <em>Is Any Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAnyResource()
	 * @generated
	 * @ordered
	 */
	protected boolean isAnyResource = IS_ANY_RESOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAnyDataType() <em>Is Any Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAnyDataType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ANY_DATA_TYPE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAnyDataType() <em>Is Any Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAnyDataType()
	 * @generated
	 * @ordered
	 */
	protected boolean isAnyDataType = IS_ANY_DATA_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FhirPackage.Literals.TYPE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_REF__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAnyResource() {
		return isAnyResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAnyResource(boolean newIsAnyResource) {
		boolean oldIsAnyResource = isAnyResource;
		isAnyResource = newIsAnyResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_REF__IS_ANY_RESOURCE, oldIsAnyResource, isAnyResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAnyDataType() {
		return isAnyDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAnyDataType(boolean newIsAnyDataType) {
		boolean oldIsAnyDataType = isAnyDataType;
		isAnyDataType = newIsAnyDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_REF__IS_ANY_DATA_TYPE, oldIsAnyDataType, isAnyDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParam() {
		if (param == null) {
			param = new EDataTypeUniqueEList<String>(String.class, this, FhirPackage.TYPE_REF__PARAM);
		}
		return param;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FhirPackage.TYPE_REF__PARAM:
				return getParam();
			case FhirPackage.TYPE_REF__NAME:
				return getName();
			case FhirPackage.TYPE_REF__IS_ANY_RESOURCE:
				return isIsAnyResource();
			case FhirPackage.TYPE_REF__IS_ANY_DATA_TYPE:
				return isIsAnyDataType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FhirPackage.TYPE_REF__PARAM:
				getParam().clear();
				getParam().addAll((Collection<? extends String>)newValue);
				return;
			case FhirPackage.TYPE_REF__NAME:
				setName((String)newValue);
				return;
			case FhirPackage.TYPE_REF__IS_ANY_RESOURCE:
				setIsAnyResource((Boolean)newValue);
				return;
			case FhirPackage.TYPE_REF__IS_ANY_DATA_TYPE:
				setIsAnyDataType((Boolean)newValue);
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
			case FhirPackage.TYPE_REF__PARAM:
				getParam().clear();
				return;
			case FhirPackage.TYPE_REF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FhirPackage.TYPE_REF__IS_ANY_RESOURCE:
				setIsAnyResource(IS_ANY_RESOURCE_EDEFAULT);
				return;
			case FhirPackage.TYPE_REF__IS_ANY_DATA_TYPE:
				setIsAnyDataType(IS_ANY_DATA_TYPE_EDEFAULT);
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
			case FhirPackage.TYPE_REF__PARAM:
				return param != null && !param.isEmpty();
			case FhirPackage.TYPE_REF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FhirPackage.TYPE_REF__IS_ANY_RESOURCE:
				return isAnyResource != IS_ANY_RESOURCE_EDEFAULT;
			case FhirPackage.TYPE_REF__IS_ANY_DATA_TYPE:
				return isAnyDataType != IS_ANY_DATA_TYPE_EDEFAULT;
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
		result.append(" (param: ");
		result.append(param);
		result.append(", name: ");
		result.append(name);
		result.append(", isAnyResource: ");
		result.append(isAnyResource);
		result.append(", isAnyDataType: ");
		result.append(isAnyDataType);
		result.append(')');
		return result.toString();
	}

} //TypeRefImpl
