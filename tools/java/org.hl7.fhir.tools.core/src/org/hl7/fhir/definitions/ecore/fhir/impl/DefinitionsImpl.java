/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.Binding;
import org.hl7.fhir.definitions.ecore.fhir.Constraint;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.EventDefn;
import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;
import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
import org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ProfileDefn;
import org.hl7.fhir.definitions.ecore.fhir.ResourceDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeDefn;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getPrimitives <em>Primitives</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getStructs <em>Structs</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl#getEReference0 <em>EReference0</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefinitionsImpl extends EObjectImpl implements Definitions {
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
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrimitives() <em>Primitives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitives()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimitiveTypeDefn> primitives;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstrainedTypeDefn> constraints;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDefn> events;

	/**
	 * The cached value of the '{@link #getProfiles() <em>Profiles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfiles()
	 * @generated
	 * @ordered
	 */
	protected EList<ProfileDefn> profiles;

	/**
	 * The cached value of the '{@link #getStructs() <em>Structs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructs()
	 * @generated
	 * @ordered
	 */
	protected CompositeTypeDefn structs;

	/**
	 * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference0()
	 * @generated
	 * @ordered
	 */
	protected TypeDefn eReference0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefinitionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FhirPackage.Literals.DEFINITIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BindingDefn> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<BindingDefn>(BindingDefn.class, this, FhirPackage.DEFINITIONS__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.DEFINITIONS__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.DEFINITIONS__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeDefn> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<TypeDefn>(TypeDefn.class, this, FhirPackage.DEFINITIONS__TYPES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.DEFINITIONS__PARENT, oldParent, parent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.DEFINITIONS__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrimitiveTypeDefn> getPrimitives() {
		if (primitives == null) {
			primitives = new EObjectContainmentEList<PrimitiveTypeDefn>(PrimitiveTypeDefn.class, this, FhirPackage.DEFINITIONS__PRIMITIVES);
		}
		return primitives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstrainedTypeDefn> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<ConstrainedTypeDefn>(ConstrainedTypeDefn.class, this, FhirPackage.DEFINITIONS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventDefn> getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList<EventDefn>(EventDefn.class, this, FhirPackage.DEFINITIONS__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProfileDefn> getProfiles() {
		if (profiles == null) {
			profiles = new EObjectContainmentEList<ProfileDefn>(ProfileDefn.class, this, FhirPackage.DEFINITIONS__PROFILES);
		}
		return profiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeTypeDefn getStructs() {
		return structs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructs(CompositeTypeDefn newStructs, NotificationChain msgs) {
		CompositeTypeDefn oldStructs = structs;
		structs = newStructs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FhirPackage.DEFINITIONS__STRUCTS, oldStructs, newStructs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructs(CompositeTypeDefn newStructs) {
		if (newStructs != structs) {
			NotificationChain msgs = null;
			if (structs != null)
				msgs = ((InternalEObject)structs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FhirPackage.DEFINITIONS__STRUCTS, null, msgs);
			if (newStructs != null)
				msgs = ((InternalEObject)newStructs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FhirPackage.DEFINITIONS__STRUCTS, null, msgs);
			msgs = basicSetStructs(newStructs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.DEFINITIONS__STRUCTS, newStructs, newStructs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefn getEReference0() {
		if (eReference0 != null && eReference0.eIsProxy()) {
			InternalEObject oldEReference0 = (InternalEObject)eReference0;
			eReference0 = (TypeDefn)eResolveProxy(oldEReference0);
			if (eReference0 != oldEReference0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.DEFINITIONS__EREFERENCE0, oldEReference0, eReference0));
			}
		}
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDefn basicGetEReference0() {
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference0(TypeDefn newEReference0) {
		TypeDefn oldEReference0 = eReference0;
		eReference0 = newEReference0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.DEFINITIONS__EREFERENCE0, oldEReference0, eReference0));
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FhirPackage.DEFINITIONS__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case FhirPackage.DEFINITIONS__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case FhirPackage.DEFINITIONS__PRIMITIVES:
				return ((InternalEList<?>)getPrimitives()).basicRemove(otherEnd, msgs);
			case FhirPackage.DEFINITIONS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case FhirPackage.DEFINITIONS__EVENTS:
				return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
			case FhirPackage.DEFINITIONS__PROFILES:
				return ((InternalEList<?>)getProfiles()).basicRemove(otherEnd, msgs);
			case FhirPackage.DEFINITIONS__STRUCTS:
				return basicSetStructs(null, msgs);
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
			case FhirPackage.DEFINITIONS__BINDINGS:
				return getBindings();
			case FhirPackage.DEFINITIONS__TYPES:
				return getTypes();
			case FhirPackage.DEFINITIONS__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case FhirPackage.DEFINITIONS__DATE:
				return getDate();
			case FhirPackage.DEFINITIONS__VERSION:
				return getVersion();
			case FhirPackage.DEFINITIONS__PRIMITIVES:
				return getPrimitives();
			case FhirPackage.DEFINITIONS__CONSTRAINTS:
				return getConstraints();
			case FhirPackage.DEFINITIONS__EVENTS:
				return getEvents();
			case FhirPackage.DEFINITIONS__PROFILES:
				return getProfiles();
			case FhirPackage.DEFINITIONS__STRUCTS:
				return getStructs();
			case FhirPackage.DEFINITIONS__EREFERENCE0:
				if (resolve) return getEReference0();
				return basicGetEReference0();
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
			case FhirPackage.DEFINITIONS__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends BindingDefn>)newValue);
				return;
			case FhirPackage.DEFINITIONS__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends TypeDefn>)newValue);
				return;
			case FhirPackage.DEFINITIONS__PARENT:
				setParent((NameScope)newValue);
				return;
			case FhirPackage.DEFINITIONS__DATE:
				setDate((Date)newValue);
				return;
			case FhirPackage.DEFINITIONS__VERSION:
				setVersion((String)newValue);
				return;
			case FhirPackage.DEFINITIONS__PRIMITIVES:
				getPrimitives().clear();
				getPrimitives().addAll((Collection<? extends PrimitiveTypeDefn>)newValue);
				return;
			case FhirPackage.DEFINITIONS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ConstrainedTypeDefn>)newValue);
				return;
			case FhirPackage.DEFINITIONS__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection<? extends EventDefn>)newValue);
				return;
			case FhirPackage.DEFINITIONS__PROFILES:
				getProfiles().clear();
				getProfiles().addAll((Collection<? extends ProfileDefn>)newValue);
				return;
			case FhirPackage.DEFINITIONS__STRUCTS:
				setStructs((CompositeTypeDefn)newValue);
				return;
			case FhirPackage.DEFINITIONS__EREFERENCE0:
				setEReference0((TypeDefn)newValue);
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
			case FhirPackage.DEFINITIONS__BINDINGS:
				getBindings().clear();
				return;
			case FhirPackage.DEFINITIONS__TYPES:
				getTypes().clear();
				return;
			case FhirPackage.DEFINITIONS__PARENT:
				setParent((NameScope)null);
				return;
			case FhirPackage.DEFINITIONS__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case FhirPackage.DEFINITIONS__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case FhirPackage.DEFINITIONS__PRIMITIVES:
				getPrimitives().clear();
				return;
			case FhirPackage.DEFINITIONS__CONSTRAINTS:
				getConstraints().clear();
				return;
			case FhirPackage.DEFINITIONS__EVENTS:
				getEvents().clear();
				return;
			case FhirPackage.DEFINITIONS__PROFILES:
				getProfiles().clear();
				return;
			case FhirPackage.DEFINITIONS__STRUCTS:
				setStructs((CompositeTypeDefn)null);
				return;
			case FhirPackage.DEFINITIONS__EREFERENCE0:
				setEReference0((TypeDefn)null);
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
			case FhirPackage.DEFINITIONS__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case FhirPackage.DEFINITIONS__TYPES:
				return types != null && !types.isEmpty();
			case FhirPackage.DEFINITIONS__PARENT:
				return parent != null;
			case FhirPackage.DEFINITIONS__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case FhirPackage.DEFINITIONS__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case FhirPackage.DEFINITIONS__PRIMITIVES:
				return primitives != null && !primitives.isEmpty();
			case FhirPackage.DEFINITIONS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case FhirPackage.DEFINITIONS__EVENTS:
				return events != null && !events.isEmpty();
			case FhirPackage.DEFINITIONS__PROFILES:
				return profiles != null && !profiles.isEmpty();
			case FhirPackage.DEFINITIONS__STRUCTS:
				return structs != null;
			case FhirPackage.DEFINITIONS__EREFERENCE0:
				return eReference0 != null;
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
		result.append(" (date: ");
		result.append(date);
		result.append(", version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}
	
	
	public static Definitions build( Date date, String version )
	{
		Definitions result = FhirFactory.eINSTANCE.createDefinitions();
		
		result.setDate(date);
		result.setVersion(version);
		
		return result;
	}

} //DefinitionsImpl
