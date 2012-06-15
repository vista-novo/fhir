/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.hl7.fhir.definitions.ecore.fhir.Annotations;
import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
import org.hl7.fhir.definitions.ecore.fhir.TypeDefn;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Defn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeDefnImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeDefnImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeDefnImpl#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypeDefnImpl extends EObjectImpl implements TypeDefn {
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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected Annotations annotations;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected NameScope container;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeDefnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FhirPackage.Literals.TYPE_DEFN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_DEFN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotations getAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotations(Annotations newAnnotations, NotificationChain msgs) {
		Annotations oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_DEFN__ANNOTATIONS, oldAnnotations, newAnnotations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotations(Annotations newAnnotations) {
		if (newAnnotations != annotations) {
			NotificationChain msgs = null;
			if (annotations != null)
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FhirPackage.TYPE_DEFN__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FhirPackage.TYPE_DEFN__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_DEFN__ANNOTATIONS, newAnnotations, newAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameScope getContainer() {
		if (container != null && container.eIsProxy()) {
			InternalEObject oldContainer = (InternalEObject)container;
			container = (NameScope)eResolveProxy(oldContainer);
			if (container != oldContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.TYPE_DEFN__CONTAINER, oldContainer, container));
			}
		}
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameScope basicGetContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(NameScope newContainer) {
		NameScope oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.TYPE_DEFN__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFQN() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FhirPackage.TYPE_DEFN__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
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
			case FhirPackage.TYPE_DEFN__NAME:
				return getName();
			case FhirPackage.TYPE_DEFN__ANNOTATIONS:
				return getAnnotations();
			case FhirPackage.TYPE_DEFN__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
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
			case FhirPackage.TYPE_DEFN__NAME:
				setName((String)newValue);
				return;
			case FhirPackage.TYPE_DEFN__ANNOTATIONS:
				setAnnotations((Annotations)newValue);
				return;
			case FhirPackage.TYPE_DEFN__CONTAINER:
				setContainer((NameScope)newValue);
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
			case FhirPackage.TYPE_DEFN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FhirPackage.TYPE_DEFN__ANNOTATIONS:
				setAnnotations((Annotations)null);
				return;
			case FhirPackage.TYPE_DEFN__CONTAINER:
				setContainer((NameScope)null);
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
			case FhirPackage.TYPE_DEFN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FhirPackage.TYPE_DEFN__ANNOTATIONS:
				return annotations != null;
			case FhirPackage.TYPE_DEFN__CONTAINER:
				return container != null;
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
		result.append(')');
		return result.toString();
	}

} //TypeDefnImpl
