/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constrained Type Defn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl#getDetails <em>Details</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstrainedTypeDefnImpl extends TypeDefnImpl implements ConstrainedTypeDefn {
	/**
   * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getBaseType()
   * @generated
   * @ordered
   */
	protected TypeRef baseType;

	/**
   * The cached value of the '{@link #getDetails() <em>Details</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDetails()
   * @generated
   * @ordered
   */
	protected EList<Invariant> details;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected ConstrainedTypeDefnImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return FhirPackage.Literals.CONSTRAINED_TYPE_DEFN;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public TypeRef getBaseType() {
    return baseType;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetBaseType(TypeRef newBaseType, NotificationChain msgs) {
    TypeRef oldBaseType = baseType;
    baseType = newBaseType;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE, oldBaseType, newBaseType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void setBaseType(TypeRef newBaseType) {
    if (newBaseType != baseType) {
      NotificationChain msgs = null;
      if (baseType != null)
        msgs = ((InternalEObject)baseType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE, null, msgs);
      if (newBaseType != null)
        msgs = ((InternalEObject)newBaseType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE, null, msgs);
      msgs = basicSetBaseType(newBaseType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE, newBaseType, newBaseType));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EList<Invariant> getDetails() {
    if (details == null) {
      details = new EObjectContainmentEList<Invariant>(Invariant.class, this, FhirPackage.CONSTRAINED_TYPE_DEFN__DETAILS);
    }
    return details;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE:
        return basicSetBaseType(null, msgs);
      case FhirPackage.CONSTRAINED_TYPE_DEFN__DETAILS:
        return ((InternalEList<?>)getDetails()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE:
        return getBaseType();
      case FhirPackage.CONSTRAINED_TYPE_DEFN__DETAILS:
        return getDetails();
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
      case FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE:
        setBaseType((TypeRef)newValue);
        return;
      case FhirPackage.CONSTRAINED_TYPE_DEFN__DETAILS:
        getDetails().clear();
        getDetails().addAll((Collection<? extends Invariant>)newValue);
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
      case FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE:
        setBaseType((TypeRef)null);
        return;
      case FhirPackage.CONSTRAINED_TYPE_DEFN__DETAILS:
        getDetails().clear();
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
      case FhirPackage.CONSTRAINED_TYPE_DEFN__BASE_TYPE:
        return baseType != null;
      case FhirPackage.CONSTRAINED_TYPE_DEFN__DETAILS:
        return details != null && !details.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConstrainedTypeDefnImpl
