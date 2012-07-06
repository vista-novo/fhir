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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.hl7.fhir.definitions.ecore.fhir.Annotations;
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
 * An implementation of the model object '<em><b>Resource Defn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#isSandbox <em>Sandbox</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getExample <em>Example</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getSearches <em>Searches</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#isFuture <em>Future</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDefnImpl extends CompositeTypeDefnImpl implements ResourceDefn {
	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeDefn> types;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<BindingDefn> bindings;

	/**
	 * The default value of the '{@link #isSandbox() <em>Sandbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSandbox()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SANDBOX_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSandbox() <em>Sandbox</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSandbox()
	 * @generated
	 * @ordered
	 */
	protected boolean sandbox = SANDBOX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExample() <em>Example</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExample()
	 * @generated
	 * @ordered
	 */
	protected EList<Example> example;

	/**
	 * The cached value of the '{@link #getSearches() <em>Searches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearches()
	 * @generated
	 * @ordered
	 */
	protected EList<SearchParameter> searches;

	/**
	 * The default value of the '{@link #isFuture() <em>Future</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFuture()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FUTURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFuture() <em>Future</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFuture()
	 * @generated
	 * @ordered
	 */
	protected boolean future = FUTURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDefnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FhirPackage.Literals.RESOURCE_DEFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeDefn> getTypes() {
		if (types == null) {
			types = new EObjectContainmentWithInverseEList<TypeDefn>(TypeDefn.class, this, FhirPackage.RESOURCE_DEFN__TYPES, FhirPackage.TYPE_DEFN__SCOPE);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BindingDefn> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentWithInverseEList<BindingDefn>(BindingDefn.class, this, FhirPackage.RESOURCE_DEFN__BINDINGS, FhirPackage.BINDING_DEFN__PARENT);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Example> getExample() {
		if (example == null) {
			example = new EObjectContainmentEList<Example>(Example.class, this, FhirPackage.RESOURCE_DEFN__EXAMPLE);
		}
		return example;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSandbox() {
		return sandbox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSandbox(boolean newSandbox) {
		boolean oldSandbox = sandbox;
		sandbox = newSandbox;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__SANDBOX, oldSandbox, sandbox));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SearchParameter> getSearches() {
		if (searches == null) {
			searches = new EObjectContainmentEList<SearchParameter>(SearchParameter.class, this, FhirPackage.RESOURCE_DEFN__SEARCHES);
		}
		return searches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFuture() {
		return future;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFuture(boolean newFuture) {
		boolean oldFuture = future;
		future = newFuture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__FUTURE, oldFuture, future));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TypeDefn resolveType(String name) {
		return ns().resolveType(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public BindingDefn resolveBinding(String name) {
		return ns().resolveBinding(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<CompositeTypeDefn> getLocalCompositeTypes() {
		return ns().getLocalCompositeTypes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ConstrainedTypeDefn> getLocalConstrainedTypes() {
		return ns().getLocalConstrainedTypes();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NameScope getContainingScope() {
		return this.getScope();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ResourceDefn> getLocalResources() {
		return ns().getLocalResources();
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
			case FhirPackage.RESOURCE_DEFN__TYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypes()).basicAdd(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBindings()).basicAdd(otherEnd, msgs);
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
			case FhirPackage.RESOURCE_DEFN__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				return ((InternalEList<?>)getExample()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				return ((InternalEList<?>)getSearches()).basicRemove(otherEnd, msgs);
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
			case FhirPackage.RESOURCE_DEFN__TYPES:
				return getTypes();
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				return getBindings();
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				return isSandbox();
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				return getExample();
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				return getSearches();
			case FhirPackage.RESOURCE_DEFN__FUTURE:
				return isFuture();
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
			case FhirPackage.RESOURCE_DEFN__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends TypeDefn>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends BindingDefn>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				setSandbox((Boolean)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				getExample().clear();
				getExample().addAll((Collection<? extends Example>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				getSearches().clear();
				getSearches().addAll((Collection<? extends SearchParameter>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__FUTURE:
				setFuture((Boolean)newValue);
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
			case FhirPackage.RESOURCE_DEFN__TYPES:
				getTypes().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				getBindings().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				setSandbox(SANDBOX_EDEFAULT);
				return;
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				getExample().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				getSearches().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__FUTURE:
				setFuture(FUTURE_EDEFAULT);
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
			case FhirPackage.RESOURCE_DEFN__TYPES:
				return types != null && !types.isEmpty();
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				return sandbox != SANDBOX_EDEFAULT;
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				return example != null && !example.isEmpty();
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				return searches != null && !searches.isEmpty();
			case FhirPackage.RESOURCE_DEFN__FUTURE:
				return future != FUTURE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NameScope.class) {
			switch (derivedFeatureID) {
				case FhirPackage.RESOURCE_DEFN__TYPES: return FhirPackage.NAME_SCOPE__TYPES;
				case FhirPackage.RESOURCE_DEFN__BINDINGS: return FhirPackage.NAME_SCOPE__BINDINGS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NameScope.class) {
			switch (baseFeatureID) {
				case FhirPackage.NAME_SCOPE__TYPES: return FhirPackage.RESOURCE_DEFN__TYPES;
				case FhirPackage.NAME_SCOPE__BINDINGS: return FhirPackage.RESOURCE_DEFN__BINDINGS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (sandbox: ");
		result.append(sandbox);
		result.append(", future: ");
		result.append(future);
		result.append(')');
		return result.toString();
	}

	
	private NameScopeImpl nameScope;
	
	private NameScopeImpl ns()
	{
		if( nameScope == null )
		{
			nameScope = new NameScopeImpl(this);
		}
		
		return nameScope;
	}
	
} //ResourceDefnImpl
