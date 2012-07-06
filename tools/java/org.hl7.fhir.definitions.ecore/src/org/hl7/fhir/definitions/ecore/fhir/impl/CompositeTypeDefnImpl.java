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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.Example;
import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
import org.hl7.fhir.definitions.ecore.fhir.ResourceDefn;
import org.hl7.fhir.definitions.ecore.fhir.SearchParameter;
import org.hl7.fhir.definitions.ecore.fhir.TypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Type Defn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl#getAllowedGenericTypes <em>Allowed Generic Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl#isIsUnnamedComponent <em>Is Unnamed Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeTypeDefnImpl extends TypeDefnImpl implements CompositeTypeDefn {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementDefn> elements;
	/**
	 * The cached value of the '{@link #getInvariants() <em>Invariants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariants()
	 * @generated
	 * @ordered
	 */
	protected EList<Invariant> invariants;
	/**
	 * The cached value of the '{@link #getAllowedGenericTypes() <em>Allowed Generic Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllowedGenericTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeRef> allowedGenericTypes;

	/**
	 * The default value of the '{@link #isIsUnnamedComponent() <em>Is Unnamed Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnnamedComponent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_UNNAMED_COMPONENT_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsUnnamedComponent() <em>Is Unnamed Component</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUnnamedComponent()
	 * @generated
	 * @ordered
	 */
	protected boolean isUnnamedComponent = IS_UNNAMED_COMPONENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeTypeDefnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FhirPackage.Literals.COMPOSITE_TYPE_DEFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementDefn> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentWithInverseEList<ElementDefn>(ElementDefn.class, this, FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS, FhirPackage.ELEMENT_DEFN__PARENT_TYPE);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Invariant> getInvariants() {
		if (invariants == null) {
			invariants = new EObjectContainmentEList<Invariant>(Invariant.class, this, FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS);
		}
		return invariants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRef> getAllowedGenericTypes() {
		if (allowedGenericTypes == null) {
			allowedGenericTypes = new EObjectContainmentEList<TypeRef>(TypeRef.class, this, FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES);
		}
		return allowedGenericTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUnnamedComponent() {
		return isUnnamedComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnnamedComponent(boolean newIsUnnamedComponent) {
		boolean oldIsUnnamedComponent = isUnnamedComponent;
		isUnnamedComponent = newIsUnnamedComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.COMPOSITE_TYPE_DEFN__IS_UNNAMED_COMPONENT, oldIsUnnamedComponent, isUnnamedComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isGenericType() {
		return getAllowedGenericTypes().size() > 0 &&
					!getName().equals(TypeRef.RESOURCEREF_TYPE_NAME);
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS:
				return ((InternalEList<?>)getInvariants()).basicRemove(otherEnd, msgs);
			case FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES:
				return ((InternalEList<?>)getAllowedGenericTypes()).basicRemove(otherEnd, msgs);
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
			case FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS:
				return getElements();
			case FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS:
				return getInvariants();
			case FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES:
				return getAllowedGenericTypes();
			case FhirPackage.COMPOSITE_TYPE_DEFN__IS_UNNAMED_COMPONENT:
				return isIsUnnamedComponent();
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
			case FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ElementDefn>)newValue);
				return;
			case FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS:
				getInvariants().clear();
				getInvariants().addAll((Collection<? extends Invariant>)newValue);
				return;
			case FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES:
				getAllowedGenericTypes().clear();
				getAllowedGenericTypes().addAll((Collection<? extends TypeRef>)newValue);
				return;
			case FhirPackage.COMPOSITE_TYPE_DEFN__IS_UNNAMED_COMPONENT:
				setIsUnnamedComponent((Boolean)newValue);
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
			case FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS:
				getElements().clear();
				return;
			case FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS:
				getInvariants().clear();
				return;
			case FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES:
				getAllowedGenericTypes().clear();
				return;
			case FhirPackage.COMPOSITE_TYPE_DEFN__IS_UNNAMED_COMPONENT:
				setIsUnnamedComponent(IS_UNNAMED_COMPONENT_EDEFAULT);
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
			case FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS:
				return invariants != null && !invariants.isEmpty();
			case FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES:
				return allowedGenericTypes != null && !allowedGenericTypes.isEmpty();
			case FhirPackage.COMPOSITE_TYPE_DEFN__IS_UNNAMED_COMPONENT:
				return isUnnamedComponent != IS_UNNAMED_COMPONENT_EDEFAULT;
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
		result.append(" (isUnnamedComponent: ");
		result.append(isUnnamedComponent);
		result.append(')');
		return result.toString();
	}
	

} //CompositeTypeDefnImpl
