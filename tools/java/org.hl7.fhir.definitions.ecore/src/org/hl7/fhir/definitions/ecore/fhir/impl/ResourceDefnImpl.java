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
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getAllowedGenericTypes <em>Allowed Generic Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#isSandbox <em>Sandbox</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getExample <em>Example</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl#getSearches <em>Searches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDefnImpl extends EObjectImpl implements ResourceDefn {
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
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeDefn> types;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected NameScope parent;

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
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected ElementDefn root;

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
	public EList<BindingDefn> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentWithInverseEList<BindingDefn>(BindingDefn.class, this, FhirPackage.RESOURCE_DEFN__BINDINGS, FhirPackage.BINDING_DEFN__CONTAINER);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeDefn> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<TypeDefn>(TypeDefn.class, this, FhirPackage.RESOURCE_DEFN__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameScope getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (NameScope)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.RESOURCE_DEFN__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameScope basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(NameScope newParent) {
		NameScope oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__PARENT, oldParent, parent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__ANNOTATIONS, oldAnnotations, newAnnotations);
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
				msgs = ((InternalEObject)annotations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FhirPackage.RESOURCE_DEFN__ANNOTATIONS, null, msgs);
			if (newAnnotations != null)
				msgs = ((InternalEObject)newAnnotations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FhirPackage.RESOURCE_DEFN__ANNOTATIONS, null, msgs);
			msgs = basicSetAnnotations(newAnnotations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__ANNOTATIONS, newAnnotations, newAnnotations));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.RESOURCE_DEFN__CONTAINER, oldContainer, container));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementDefn> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<ElementDefn>(ElementDefn.class, this, FhirPackage.RESOURCE_DEFN__ELEMENTS);
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
			invariants = new EObjectContainmentEList<Invariant>(Invariant.class, this, FhirPackage.RESOURCE_DEFN__INVARIANTS);
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
			allowedGenericTypes = new EObjectContainmentEList<TypeRef>(TypeRef.class, this, FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES);
		}
		return allowedGenericTypes;
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
	public ElementDefn getRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoot(ElementDefn newRoot, NotificationChain msgs) {
		ElementDefn oldRoot = root;
		root = newRoot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__ROOT, oldRoot, newRoot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(ElementDefn newRoot) {
		if (newRoot != root) {
			NotificationChain msgs = null;
			if (root != null)
				msgs = ((InternalEObject)root).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FhirPackage.RESOURCE_DEFN__ROOT, null, msgs);
			if (newRoot != null)
				msgs = ((InternalEObject)newRoot).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FhirPackage.RESOURCE_DEFN__ROOT, null, msgs);
			msgs = basicSetRoot(newRoot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.RESOURCE_DEFN__ROOT, newRoot, newRoot));
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
	public TypeDefn resolveType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeDefn> getTypeByName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeDefn> filterTypes(String name, String scope, String typeKind) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingDefn resolveBinding() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingDefn getBindingByName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__ANNOTATIONS:
				return basicSetAnnotations(null, msgs);
			case FhirPackage.RESOURCE_DEFN__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__INVARIANTS:
				return ((InternalEList<?>)getInvariants()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES:
				return ((InternalEList<?>)getAllowedGenericTypes()).basicRemove(otherEnd, msgs);
			case FhirPackage.RESOURCE_DEFN__ROOT:
				return basicSetRoot(null, msgs);
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
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				return getBindings();
			case FhirPackage.RESOURCE_DEFN__TYPES:
				return getTypes();
			case FhirPackage.RESOURCE_DEFN__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case FhirPackage.RESOURCE_DEFN__NAME:
				return getName();
			case FhirPackage.RESOURCE_DEFN__ANNOTATIONS:
				return getAnnotations();
			case FhirPackage.RESOURCE_DEFN__CONTAINER:
				if (resolve) return getContainer();
				return basicGetContainer();
			case FhirPackage.RESOURCE_DEFN__ELEMENTS:
				return getElements();
			case FhirPackage.RESOURCE_DEFN__INVARIANTS:
				return getInvariants();
			case FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES:
				return getAllowedGenericTypes();
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				return isSandbox();
			case FhirPackage.RESOURCE_DEFN__ROOT:
				return getRoot();
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				return getExample();
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				return getSearches();
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
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends BindingDefn>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends TypeDefn>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__PARENT:
				setParent((NameScope)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__NAME:
				setName((String)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__ANNOTATIONS:
				setAnnotations((Annotations)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__CONTAINER:
				setContainer((NameScope)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ElementDefn>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__INVARIANTS:
				getInvariants().clear();
				getInvariants().addAll((Collection<? extends Invariant>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES:
				getAllowedGenericTypes().clear();
				getAllowedGenericTypes().addAll((Collection<? extends TypeRef>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				setSandbox((Boolean)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__ROOT:
				setRoot((ElementDefn)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				getExample().clear();
				getExample().addAll((Collection<? extends Example>)newValue);
				return;
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				getSearches().clear();
				getSearches().addAll((Collection<? extends SearchParameter>)newValue);
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
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				getBindings().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__TYPES:
				getTypes().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__PARENT:
				setParent((NameScope)null);
				return;
			case FhirPackage.RESOURCE_DEFN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FhirPackage.RESOURCE_DEFN__ANNOTATIONS:
				setAnnotations((Annotations)null);
				return;
			case FhirPackage.RESOURCE_DEFN__CONTAINER:
				setContainer((NameScope)null);
				return;
			case FhirPackage.RESOURCE_DEFN__ELEMENTS:
				getElements().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__INVARIANTS:
				getInvariants().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES:
				getAllowedGenericTypes().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				setSandbox(SANDBOX_EDEFAULT);
				return;
			case FhirPackage.RESOURCE_DEFN__ROOT:
				setRoot((ElementDefn)null);
				return;
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				getExample().clear();
				return;
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				getSearches().clear();
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
			case FhirPackage.RESOURCE_DEFN__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case FhirPackage.RESOURCE_DEFN__TYPES:
				return types != null && !types.isEmpty();
			case FhirPackage.RESOURCE_DEFN__PARENT:
				return parent != null;
			case FhirPackage.RESOURCE_DEFN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FhirPackage.RESOURCE_DEFN__ANNOTATIONS:
				return annotations != null;
			case FhirPackage.RESOURCE_DEFN__CONTAINER:
				return container != null;
			case FhirPackage.RESOURCE_DEFN__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case FhirPackage.RESOURCE_DEFN__INVARIANTS:
				return invariants != null && !invariants.isEmpty();
			case FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES:
				return allowedGenericTypes != null && !allowedGenericTypes.isEmpty();
			case FhirPackage.RESOURCE_DEFN__SANDBOX:
				return sandbox != SANDBOX_EDEFAULT;
			case FhirPackage.RESOURCE_DEFN__ROOT:
				return root != null;
			case FhirPackage.RESOURCE_DEFN__EXAMPLE:
				return example != null && !example.isEmpty();
			case FhirPackage.RESOURCE_DEFN__SEARCHES:
				return searches != null && !searches.isEmpty();
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
		if (baseClass == TypeDefn.class) {
			switch (derivedFeatureID) {
				case FhirPackage.RESOURCE_DEFN__NAME: return FhirPackage.TYPE_DEFN__NAME;
				case FhirPackage.RESOURCE_DEFN__ANNOTATIONS: return FhirPackage.TYPE_DEFN__ANNOTATIONS;
				case FhirPackage.RESOURCE_DEFN__CONTAINER: return FhirPackage.TYPE_DEFN__CONTAINER;
				default: return -1;
			}
		}
		if (baseClass == CompositeTypeDefn.class) {
			switch (derivedFeatureID) {
				case FhirPackage.RESOURCE_DEFN__ELEMENTS: return FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS;
				case FhirPackage.RESOURCE_DEFN__INVARIANTS: return FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS;
				case FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES: return FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES;
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
		if (baseClass == TypeDefn.class) {
			switch (baseFeatureID) {
				case FhirPackage.TYPE_DEFN__NAME: return FhirPackage.RESOURCE_DEFN__NAME;
				case FhirPackage.TYPE_DEFN__ANNOTATIONS: return FhirPackage.RESOURCE_DEFN__ANNOTATIONS;
				case FhirPackage.TYPE_DEFN__CONTAINER: return FhirPackage.RESOURCE_DEFN__CONTAINER;
				default: return -1;
			}
		}
		if (baseClass == CompositeTypeDefn.class) {
			switch (baseFeatureID) {
				case FhirPackage.COMPOSITE_TYPE_DEFN__ELEMENTS: return FhirPackage.RESOURCE_DEFN__ELEMENTS;
				case FhirPackage.COMPOSITE_TYPE_DEFN__INVARIANTS: return FhirPackage.RESOURCE_DEFN__INVARIANTS;
				case FhirPackage.COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES: return FhirPackage.RESOURCE_DEFN__ALLOWED_GENERIC_TYPES;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", sandbox: ");
		result.append(sandbox);
		result.append(')');
		return result.toString();
	}

} //ResourceDefnImpl
