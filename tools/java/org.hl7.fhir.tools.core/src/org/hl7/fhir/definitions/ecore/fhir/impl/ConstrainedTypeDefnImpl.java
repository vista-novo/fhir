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

import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constrained Type Defn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl#getConstrains <em>Constrains</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl#getDetails <em>Details</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstrainedTypeDefnImpl extends CompositeTypeDefnImpl implements ConstrainedTypeDefn {
	/**
	 * The cached value of the '{@link #getConstrains() <em>Constrains</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrains()
	 * @generated
	 * @ordered
	 */
	protected CompositeTypeDefn constrains;

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
	public CompositeTypeDefn getConstrains() {
		return constrains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstrains(CompositeTypeDefn newConstrains, NotificationChain msgs) {
		CompositeTypeDefn oldConstrains = constrains;
		constrains = newConstrains;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS, oldConstrains, newConstrains);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstrains(CompositeTypeDefn newConstrains) {
		if (newConstrains != constrains) {
			NotificationChain msgs = null;
			if (constrains != null)
				msgs = ((InternalEObject)constrains).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS, null, msgs);
			if (newConstrains != null)
				msgs = ((InternalEObject)newConstrains).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS, null, msgs);
			msgs = basicSetConstrains(newConstrains, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS, newConstrains, newConstrains));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
			case FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS:
				return basicSetConstrains(null, msgs);
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
			case FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS:
				return getConstrains();
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
			case FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS:
				setConstrains((CompositeTypeDefn)newValue);
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
			case FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS:
				setConstrains((CompositeTypeDefn)null);
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
			case FhirPackage.CONSTRAINED_TYPE_DEFN__CONSTRAINS:
				return constrains != null;
			case FhirPackage.CONSTRAINED_TYPE_DEFN__DETAILS:
				return details != null && !details.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConstrainedTypeDefnImpl
