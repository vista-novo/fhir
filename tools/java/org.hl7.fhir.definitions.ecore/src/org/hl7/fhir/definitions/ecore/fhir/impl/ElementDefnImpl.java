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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.hl7.fhir.definitions.ecore.fhir.BindingRef;
import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.Binding;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;
import org.hl7.fhir.definitions.ecore.fhir.Mapping;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Defn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getTodo <em>Todo</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getMaxCardinality <em>Max Cardinality</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#isAllowDAR <em>Allow DAR</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#isMustUnderstand <em>Must Understand</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getInvariant <em>Invariant</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#isMustSupport <em>Must Support</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getShortDefn <em>Short Defn</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getCommitteeNotes <em>Committee Notes</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getExampleValue <em>Example Value</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getTargetUri <em>Target Uri</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getFixedValue <em>Fixed Value</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getAggregation <em>Aggregation</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#isInherited <em>Inherited</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getContent <em>Content</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl#getBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementDefnImpl extends EObjectImpl implements ElementDefn {
	/**
	 * The default value of the '{@link #getTodo() <em>Todo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTodo()
	 * @generated
	 * @ordered
	 */
	protected static final String TODO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTodo() <em>Todo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTodo()
	 * @generated
	 * @ordered
	 */
	protected String todo = TODO_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxCardinality() <em>Max Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_CARDINALITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxCardinality() <em>Max Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCardinality()
	 * @generated
	 * @ordered
	 */
	protected int maxCardinality = MAX_CARDINALITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinCardinality() <em>Min Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_CARDINALITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinCardinality() <em>Min Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinCardinality()
	 * @generated
	 * @ordered
	 */
	protected int minCardinality = MIN_CARDINALITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowDAR() <em>Allow DAR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDAR()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_DAR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowDAR() <em>Allow DAR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowDAR()
	 * @generated
	 * @ordered
	 */
	protected boolean allowDAR = ALLOW_DAR_EDEFAULT;

	/**
	 * The default value of the '{@link #isMustUnderstand() <em>Must Understand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMustUnderstand()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MUST_UNDERSTAND_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMustUnderstand() <em>Must Understand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMustUnderstand()
	 * @generated
	 * @ordered
	 */
	protected boolean mustUnderstand = MUST_UNDERSTAND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvariant() <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariant()
	 * @generated
	 * @ordered
	 */
	protected Invariant invariant;

	/**
	 * The default value of the '{@link #isMustSupport() <em>Must Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMustSupport()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MUST_SUPPORT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMustSupport() <em>Must Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMustSupport()
	 * @generated
	 * @ordered
	 */
	protected boolean mustSupport = MUST_SUPPORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeRef> types;

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
	 * The default value of the '{@link #getShortDefn() <em>Short Defn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortDefn()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_DEFN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShortDefn() <em>Short Defn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortDefn()
	 * @generated
	 * @ordered
	 */
	protected String shortDefn = SHORT_DEFN_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected String definition = DEFINITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRequirements() <em>Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected String requirements = REQUIREMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected String comments = COMMENTS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mappings;

	/**
	 * The default value of the '{@link #getCommitteeNotes() <em>Committee Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommitteeNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMITTEE_NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommitteeNotes() <em>Committee Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommitteeNotes()
	 * @generated
	 * @ordered
	 */
	protected String committeeNotes = COMMITTEE_NOTES_EDEFAULT;

	/**
	 * The default value of the '{@link #getExampleValue() <em>Example Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExampleValue()
	 * @generated
	 * @ordered
	 */
	protected static final String EXAMPLE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExampleValue() <em>Example Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExampleValue()
	 * @generated
	 * @ordered
	 */
	protected String exampleValue = EXAMPLE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProfileName() <em>Profile Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROFILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProfileName() <em>Profile Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProfileName()
	 * @generated
	 * @ordered
	 */
	protected String profileName = PROFILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetUri() <em>Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetUri()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetUri() <em>Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetUri()
	 * @generated
	 * @ordered
	 */
	protected String targetUri = TARGET_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixedValue() <em>Fixed Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedValue()
	 * @generated
	 * @ordered
	 */
	protected static final String FIXED_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixedValue() <em>Fixed Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedValue()
	 * @generated
	 * @ordered
	 */
	protected String fixedValue = FIXED_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAggregation() <em>Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregation()
	 * @generated
	 * @ordered
	 */
	protected static final String AGGREGATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAggregation() <em>Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregation()
	 * @generated
	 * @ordered
	 */
	protected String aggregation = AGGREGATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInherited()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INHERITED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInherited() <em>Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInherited()
	 * @generated
	 * @ordered
	 */
	protected boolean inherited = INHERITED_EDEFAULT;

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
	 * The cached value of the '{@link #getContent() <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected ElementDefn content;

	/**
	 * The cached value of the '{@link #getBinding() <em>Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinding()
	 * @generated
	 * @ordered
	 */
	protected BindingRef binding;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementDefnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FhirPackage.Literals.ELEMENT_DEFN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTodo() {
		return todo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTodo(String newTodo) {
		String oldTodo = todo;
		todo = newTodo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__TODO, oldTodo, todo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxCardinality() {
		return maxCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxCardinality(int newMaxCardinality) {
		int oldMaxCardinality = maxCardinality;
		maxCardinality = newMaxCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__MAX_CARDINALITY, oldMaxCardinality, maxCardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinCardinality() {
		return minCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCardinality(int newMinCardinality) {
		int oldMinCardinality = minCardinality;
		minCardinality = newMinCardinality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__MIN_CARDINALITY, oldMinCardinality, minCardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowDAR() {
		return allowDAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowDAR(boolean newAllowDAR) {
		boolean oldAllowDAR = allowDAR;
		allowDAR = newAllowDAR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__ALLOW_DAR, oldAllowDAR, allowDAR));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMustUnderstand() {
		return mustUnderstand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMustUnderstand(boolean newMustUnderstand) {
		boolean oldMustUnderstand = mustUnderstand;
		mustUnderstand = newMustUnderstand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__MUST_UNDERSTAND, oldMustUnderstand, mustUnderstand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invariant getInvariant() {
		if (invariant != null && invariant.eIsProxy()) {
			InternalEObject oldInvariant = (InternalEObject)invariant;
			invariant = (Invariant)eResolveProxy(oldInvariant);
			if (invariant != oldInvariant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.ELEMENT_DEFN__INVARIANT, oldInvariant, invariant));
			}
		}
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invariant basicGetInvariant() {
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvariant(Invariant newInvariant) {
		Invariant oldInvariant = invariant;
		invariant = newInvariant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__INVARIANT, oldInvariant, invariant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMustSupport() {
		return mustSupport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMustSupport(boolean newMustSupport) {
		boolean oldMustSupport = mustSupport;
		mustSupport = newMustSupport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__MUST_SUPPORT, oldMustSupport, mustSupport));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeRef> getTypes() {
		if (types == null) {
			types = new EObjectContainmentEList<TypeRef>(TypeRef.class, this, FhirPackage.ELEMENT_DEFN__TYPES);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingRef getBinding() {
		if (binding != null && binding.eIsProxy()) {
			InternalEObject oldBinding = (InternalEObject)binding;
			binding = (BindingRef)eResolveProxy(oldBinding);
			if (binding != oldBinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.ELEMENT_DEFN__BINDING, oldBinding, binding));
			}
		}
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingRef basicGetBinding() {
		return binding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinding(BindingRef newBinding) {
		BindingRef oldBinding = binding;
		binding = newBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__BINDING, oldBinding, binding));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortDefn() {
		return shortDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortDefn(String newShortDefn) {
		String oldShortDefn = shortDefn;
		shortDefn = newShortDefn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__SHORT_DEFN, oldShortDefn, shortDefn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(String newDefinition) {
		String oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRequirements() {
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirements(String newRequirements) {
		String oldRequirements = requirements;
		requirements = newRequirements;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__REQUIREMENTS, oldRequirements, requirements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComments(String newComments) {
		String oldComments = comments;
		comments = newComments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__COMMENTS, oldComments, comments));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, FhirPackage.ELEMENT_DEFN__MAPPINGS);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommitteeNotes() {
		return committeeNotes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommitteeNotes(String newCommitteeNotes) {
		String oldCommitteeNotes = committeeNotes;
		committeeNotes = newCommitteeNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__COMMITTEE_NOTES, oldCommitteeNotes, committeeNotes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExampleValue() {
		return exampleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExampleValue(String newExampleValue) {
		String oldExampleValue = exampleValue;
		exampleValue = newExampleValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__EXAMPLE_VALUE, oldExampleValue, exampleValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProfileName(String newProfileName) {
		String oldProfileName = profileName;
		profileName = newProfileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__PROFILE_NAME, oldProfileName, profileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetUri() {
		return targetUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetUri(String newTargetUri) {
		String oldTargetUri = targetUri;
		targetUri = newTargetUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__TARGET_URI, oldTargetUri, targetUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFixedValue() {
		return fixedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedValue(String newFixedValue) {
		String oldFixedValue = fixedValue;
		fixedValue = newFixedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__FIXED_VALUE, oldFixedValue, fixedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAggregation() {
		return aggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregation(String newAggregation) {
		String oldAggregation = aggregation;
		aggregation = newAggregation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__AGGREGATION, oldAggregation, aggregation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInherited() {
		return inherited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInherited(boolean newInherited) {
		boolean oldInherited = inherited;
		inherited = newInherited;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__INHERITED, oldInherited, inherited));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementDefn> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<ElementDefn>(ElementDefn.class, this, FhirPackage.ELEMENT_DEFN__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementDefn getContent() {
		if (content != null && content.eIsProxy()) {
			InternalEObject oldContent = (InternalEObject)content;
			content = (ElementDefn)eResolveProxy(oldContent);
			if (content != oldContent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FhirPackage.ELEMENT_DEFN__CONTENT, oldContent, content));
			}
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementDefn basicGetContent() {
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContent(ElementDefn newContent) {
		ElementDefn oldContent = content;
		content = newContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FhirPackage.ELEMENT_DEFN__CONTENT, oldContent, content));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FhirPackage.ELEMENT_DEFN__TYPES:
				return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
			case FhirPackage.ELEMENT_DEFN__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
			case FhirPackage.ELEMENT_DEFN__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case FhirPackage.ELEMENT_DEFN__TODO:
				return getTodo();
			case FhirPackage.ELEMENT_DEFN__MAX_CARDINALITY:
				return getMaxCardinality();
			case FhirPackage.ELEMENT_DEFN__MIN_CARDINALITY:
				return getMinCardinality();
			case FhirPackage.ELEMENT_DEFN__ALLOW_DAR:
				return isAllowDAR();
			case FhirPackage.ELEMENT_DEFN__MUST_UNDERSTAND:
				return isMustUnderstand();
			case FhirPackage.ELEMENT_DEFN__INVARIANT:
				if (resolve) return getInvariant();
				return basicGetInvariant();
			case FhirPackage.ELEMENT_DEFN__MUST_SUPPORT:
				return isMustSupport();
			case FhirPackage.ELEMENT_DEFN__TYPES:
				return getTypes();
			case FhirPackage.ELEMENT_DEFN__NAME:
				return getName();
			case FhirPackage.ELEMENT_DEFN__SHORT_DEFN:
				return getShortDefn();
			case FhirPackage.ELEMENT_DEFN__DEFINITION:
				return getDefinition();
			case FhirPackage.ELEMENT_DEFN__REQUIREMENTS:
				return getRequirements();
			case FhirPackage.ELEMENT_DEFN__COMMENTS:
				return getComments();
			case FhirPackage.ELEMENT_DEFN__MAPPINGS:
				return getMappings();
			case FhirPackage.ELEMENT_DEFN__COMMITTEE_NOTES:
				return getCommitteeNotes();
			case FhirPackage.ELEMENT_DEFN__EXAMPLE_VALUE:
				return getExampleValue();
			case FhirPackage.ELEMENT_DEFN__PROFILE_NAME:
				return getProfileName();
			case FhirPackage.ELEMENT_DEFN__TARGET_URI:
				return getTargetUri();
			case FhirPackage.ELEMENT_DEFN__FIXED_VALUE:
				return getFixedValue();
			case FhirPackage.ELEMENT_DEFN__AGGREGATION:
				return getAggregation();
			case FhirPackage.ELEMENT_DEFN__INHERITED:
				return isInherited();
			case FhirPackage.ELEMENT_DEFN__ELEMENTS:
				return getElements();
			case FhirPackage.ELEMENT_DEFN__CONTENT:
				if (resolve) return getContent();
				return basicGetContent();
			case FhirPackage.ELEMENT_DEFN__BINDING:
				if (resolve) return getBinding();
				return basicGetBinding();
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
			case FhirPackage.ELEMENT_DEFN__TODO:
				setTodo((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__MAX_CARDINALITY:
				setMaxCardinality((Integer)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__MIN_CARDINALITY:
				setMinCardinality((Integer)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__ALLOW_DAR:
				setAllowDAR((Boolean)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__MUST_UNDERSTAND:
				setMustUnderstand((Boolean)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__INVARIANT:
				setInvariant((Invariant)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__MUST_SUPPORT:
				setMustSupport((Boolean)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__TYPES:
				getTypes().clear();
				getTypes().addAll((Collection<? extends TypeRef>)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__NAME:
				setName((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__SHORT_DEFN:
				setShortDefn((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__DEFINITION:
				setDefinition((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__REQUIREMENTS:
				setRequirements((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__COMMENTS:
				setComments((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends Mapping>)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__COMMITTEE_NOTES:
				setCommitteeNotes((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__EXAMPLE_VALUE:
				setExampleValue((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__PROFILE_NAME:
				setProfileName((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__TARGET_URI:
				setTargetUri((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__FIXED_VALUE:
				setFixedValue((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__AGGREGATION:
				setAggregation((String)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__INHERITED:
				setInherited((Boolean)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ElementDefn>)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__CONTENT:
				setContent((ElementDefn)newValue);
				return;
			case FhirPackage.ELEMENT_DEFN__BINDING:
				setBinding((BindingRef)newValue);
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
			case FhirPackage.ELEMENT_DEFN__TODO:
				setTodo(TODO_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__MAX_CARDINALITY:
				setMaxCardinality(MAX_CARDINALITY_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__MIN_CARDINALITY:
				setMinCardinality(MIN_CARDINALITY_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__ALLOW_DAR:
				setAllowDAR(ALLOW_DAR_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__MUST_UNDERSTAND:
				setMustUnderstand(MUST_UNDERSTAND_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__INVARIANT:
				setInvariant((Invariant)null);
				return;
			case FhirPackage.ELEMENT_DEFN__MUST_SUPPORT:
				setMustSupport(MUST_SUPPORT_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__TYPES:
				getTypes().clear();
				return;
			case FhirPackage.ELEMENT_DEFN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__SHORT_DEFN:
				setShortDefn(SHORT_DEFN_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__REQUIREMENTS:
				setRequirements(REQUIREMENTS_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__COMMENTS:
				setComments(COMMENTS_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__MAPPINGS:
				getMappings().clear();
				return;
			case FhirPackage.ELEMENT_DEFN__COMMITTEE_NOTES:
				setCommitteeNotes(COMMITTEE_NOTES_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__EXAMPLE_VALUE:
				setExampleValue(EXAMPLE_VALUE_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__PROFILE_NAME:
				setProfileName(PROFILE_NAME_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__TARGET_URI:
				setTargetUri(TARGET_URI_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__FIXED_VALUE:
				setFixedValue(FIXED_VALUE_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__AGGREGATION:
				setAggregation(AGGREGATION_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__INHERITED:
				setInherited(INHERITED_EDEFAULT);
				return;
			case FhirPackage.ELEMENT_DEFN__ELEMENTS:
				getElements().clear();
				return;
			case FhirPackage.ELEMENT_DEFN__CONTENT:
				setContent((ElementDefn)null);
				return;
			case FhirPackage.ELEMENT_DEFN__BINDING:
				setBinding((BindingRef)null);
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
			case FhirPackage.ELEMENT_DEFN__TODO:
				return TODO_EDEFAULT == null ? todo != null : !TODO_EDEFAULT.equals(todo);
			case FhirPackage.ELEMENT_DEFN__MAX_CARDINALITY:
				return maxCardinality != MAX_CARDINALITY_EDEFAULT;
			case FhirPackage.ELEMENT_DEFN__MIN_CARDINALITY:
				return minCardinality != MIN_CARDINALITY_EDEFAULT;
			case FhirPackage.ELEMENT_DEFN__ALLOW_DAR:
				return allowDAR != ALLOW_DAR_EDEFAULT;
			case FhirPackage.ELEMENT_DEFN__MUST_UNDERSTAND:
				return mustUnderstand != MUST_UNDERSTAND_EDEFAULT;
			case FhirPackage.ELEMENT_DEFN__INVARIANT:
				return invariant != null;
			case FhirPackage.ELEMENT_DEFN__MUST_SUPPORT:
				return mustSupport != MUST_SUPPORT_EDEFAULT;
			case FhirPackage.ELEMENT_DEFN__TYPES:
				return types != null && !types.isEmpty();
			case FhirPackage.ELEMENT_DEFN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FhirPackage.ELEMENT_DEFN__SHORT_DEFN:
				return SHORT_DEFN_EDEFAULT == null ? shortDefn != null : !SHORT_DEFN_EDEFAULT.equals(shortDefn);
			case FhirPackage.ELEMENT_DEFN__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case FhirPackage.ELEMENT_DEFN__REQUIREMENTS:
				return REQUIREMENTS_EDEFAULT == null ? requirements != null : !REQUIREMENTS_EDEFAULT.equals(requirements);
			case FhirPackage.ELEMENT_DEFN__COMMENTS:
				return COMMENTS_EDEFAULT == null ? comments != null : !COMMENTS_EDEFAULT.equals(comments);
			case FhirPackage.ELEMENT_DEFN__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case FhirPackage.ELEMENT_DEFN__COMMITTEE_NOTES:
				return COMMITTEE_NOTES_EDEFAULT == null ? committeeNotes != null : !COMMITTEE_NOTES_EDEFAULT.equals(committeeNotes);
			case FhirPackage.ELEMENT_DEFN__EXAMPLE_VALUE:
				return EXAMPLE_VALUE_EDEFAULT == null ? exampleValue != null : !EXAMPLE_VALUE_EDEFAULT.equals(exampleValue);
			case FhirPackage.ELEMENT_DEFN__PROFILE_NAME:
				return PROFILE_NAME_EDEFAULT == null ? profileName != null : !PROFILE_NAME_EDEFAULT.equals(profileName);
			case FhirPackage.ELEMENT_DEFN__TARGET_URI:
				return TARGET_URI_EDEFAULT == null ? targetUri != null : !TARGET_URI_EDEFAULT.equals(targetUri);
			case FhirPackage.ELEMENT_DEFN__FIXED_VALUE:
				return FIXED_VALUE_EDEFAULT == null ? fixedValue != null : !FIXED_VALUE_EDEFAULT.equals(fixedValue);
			case FhirPackage.ELEMENT_DEFN__AGGREGATION:
				return AGGREGATION_EDEFAULT == null ? aggregation != null : !AGGREGATION_EDEFAULT.equals(aggregation);
			case FhirPackage.ELEMENT_DEFN__INHERITED:
				return inherited != INHERITED_EDEFAULT;
			case FhirPackage.ELEMENT_DEFN__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case FhirPackage.ELEMENT_DEFN__CONTENT:
				return content != null;
			case FhirPackage.ELEMENT_DEFN__BINDING:
				return binding != null;
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
		result.append(" (todo: ");
		result.append(todo);
		result.append(", maxCardinality: ");
		result.append(maxCardinality);
		result.append(", minCardinality: ");
		result.append(minCardinality);
		result.append(", allowDAR: ");
		result.append(allowDAR);
		result.append(", mustUnderstand: ");
		result.append(mustUnderstand);
		result.append(", mustSupport: ");
		result.append(mustSupport);
		result.append(", name: ");
		result.append(name);
		result.append(", shortDefn: ");
		result.append(shortDefn);
		result.append(", definition: ");
		result.append(definition);
		result.append(", requirements: ");
		result.append(requirements);
		result.append(", comments: ");
		result.append(comments);
		result.append(", committeeNotes: ");
		result.append(committeeNotes);
		result.append(", exampleValue: ");
		result.append(exampleValue);
		result.append(", profileName: ");
		result.append(profileName);
		result.append(", targetUri: ");
		result.append(targetUri);
		result.append(", fixedValue: ");
		result.append(fixedValue);
		result.append(", aggregation: ");
		result.append(aggregation);
		result.append(", inherited: ");
		result.append(inherited);
		result.append(')');
		return result.toString();
	}

} //ElementDefnImpl
