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
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl#getResourceParam <em>Resource Param</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl#isTakesAnyResource <em>Takes Any Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeRefImpl extends EObjectImpl implements TypeRef {
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
	 * The default value of the '{@link #getResourceParam() <em>Resource Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceParam()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_PARAM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceParam() <em>Resource Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceParam()
	 * @generated
	 * @ordered
	 */
	protected String resourceParam = RESOURCE_PARAM_EDEFAULT;

	/**
	 * The default value of the '{@link #isTakesAnyResource() <em>Takes Any Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTakesAnyResource()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TAKES_ANY_RESOURCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTakesAnyResource() <em>Takes Any Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTakesAnyResource()
	 * @generated
	 * @ordered
	 */
	protected boolean takesAnyResource = TAKES_ANY_RESOURCE_EDEFAULT;

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
	public String getResourceParam() {
		return resourceParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceParam(String newResourceParam) {
		String oldResourceParam = resourceParam;
		resourceParam = newResourceParam;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_REF__RESOURCE_PARAM, oldResourceParam, resourceParam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTakesAnyResource() {
		return takesAnyResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTakesAnyResource(boolean newTakesAnyResource) {
		boolean oldTakesAnyResource = takesAnyResource;
		takesAnyResource = newTakesAnyResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_REF__TAKES_ANY_RESOURCE, oldTakesAnyResource, takesAnyResource));
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public boolean isGenericTypeRef() {
//		return getBoundParam() != null && 
//				!getName().equals(TypeRef.RESOURCEREF_TYPE_NAME);
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FhirPackage.TYPE_REF__NAME:
				return getName();
			case FhirPackage.TYPE_REF__RESOURCE_PARAM:
				return getResourceParam();
			case FhirPackage.TYPE_REF__TAKES_ANY_RESOURCE:
				return isTakesAnyResource();
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
			case FhirPackage.TYPE_REF__NAME:
				setName((String)newValue);
				return;
			case FhirPackage.TYPE_REF__RESOURCE_PARAM:
				setResourceParam((String)newValue);
				return;
			case FhirPackage.TYPE_REF__TAKES_ANY_RESOURCE:
				setTakesAnyResource((Boolean)newValue);
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
			case FhirPackage.TYPE_REF__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FhirPackage.TYPE_REF__RESOURCE_PARAM:
				setResourceParam(RESOURCE_PARAM_EDEFAULT);
				return;
			case FhirPackage.TYPE_REF__TAKES_ANY_RESOURCE:
				setTakesAnyResource(TAKES_ANY_RESOURCE_EDEFAULT);
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
			case FhirPackage.TYPE_REF__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FhirPackage.TYPE_REF__RESOURCE_PARAM:
				return RESOURCE_PARAM_EDEFAULT == null ? resourceParam != null : !RESOURCE_PARAM_EDEFAULT.equals(resourceParam);
			case FhirPackage.TYPE_REF__TAKES_ANY_RESOURCE:
				return takesAnyResource != TAKES_ANY_RESOURCE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", resourceParam: ");
		result.append(resourceParam);
		result.append(", takesAnyResource: ");
		result.append(takesAnyResource);
		result.append(')');
		return result.toString();
	}

} //TypeRefImpl
