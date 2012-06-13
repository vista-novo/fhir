/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Defn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getTodo <em>Todo</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMaxCardinality <em>Max Cardinality</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMinCardinality <em>Min Cardinality</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isAllowDAR <em>Allow DAR</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustUnderstand <em>Must Understand</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getInvariant <em>Invariant</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustSupport <em>Must Support</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getTypes <em>Types</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getName <em>Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getShortDefn <em>Short Defn</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getComments <em>Comments</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getCommitteeNotes <em>Committee Notes</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getExampleValue <em>Example Value</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getProfileName <em>Profile Name</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getTargetUri <em>Target Uri</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getFixedValue <em>Fixed Value</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getAggregation <em>Aggregation</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isInherited <em>Inherited</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getElements <em>Elements</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getContent <em>Content</em>}</li>
 *   <li>{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn()
 * @model
 * @generated
 */
public interface ElementDefn extends EObject {
	/**
	 * Returns the value of the '<em><b>Todo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Todo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Todo</em>' attribute.
	 * @see #setTodo(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Todo()
	 * @model
	 * @generated
	 */
	String getTodo();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getTodo <em>Todo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Todo</em>' attribute.
	 * @see #getTodo()
	 * @generated
	 */
	void setTodo(String value);

	/**
	 * Returns the value of the '<em><b>Max Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Cardinality</em>' attribute.
	 * @see #setMaxCardinality(int)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_MaxCardinality()
	 * @model
	 * @generated
	 */
	int getMaxCardinality();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMaxCardinality <em>Max Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Cardinality</em>' attribute.
	 * @see #getMaxCardinality()
	 * @generated
	 */
	void setMaxCardinality(int value);

	/**
	 * Returns the value of the '<em><b>Min Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Cardinality</em>' attribute.
	 * @see #setMinCardinality(int)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_MinCardinality()
	 * @model
	 * @generated
	 */
	int getMinCardinality();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMinCardinality <em>Min Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Cardinality</em>' attribute.
	 * @see #getMinCardinality()
	 * @generated
	 */
	void setMinCardinality(int value);

	/**
	 * Returns the value of the '<em><b>Allow DAR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow DAR</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow DAR</em>' attribute.
	 * @see #setAllowDAR(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_AllowDAR()
	 * @model
	 * @generated
	 */
	boolean isAllowDAR();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isAllowDAR <em>Allow DAR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow DAR</em>' attribute.
	 * @see #isAllowDAR()
	 * @generated
	 */
	void setAllowDAR(boolean value);

	/**
	 * Returns the value of the '<em><b>Must Understand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Must Understand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Must Understand</em>' attribute.
	 * @see #setMustUnderstand(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_MustUnderstand()
	 * @model
	 * @generated
	 */
	boolean isMustUnderstand();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustUnderstand <em>Must Understand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Must Understand</em>' attribute.
	 * @see #isMustUnderstand()
	 * @generated
	 */
	void setMustUnderstand(boolean value);

	/**
	 * Returns the value of the '<em><b>Invariant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariant</em>' reference.
	 * @see #setInvariant(Invariant)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Invariant()
	 * @model
	 * @generated
	 */
	Invariant getInvariant();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getInvariant <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invariant</em>' reference.
	 * @see #getInvariant()
	 * @generated
	 */
	void setInvariant(Invariant value);

	/**
	 * Returns the value of the '<em><b>Must Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Must Support</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Must Support</em>' attribute.
	 * @see #setMustSupport(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_MustSupport()
	 * @model
	 * @generated
	 */
	boolean isMustSupport();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustSupport <em>Must Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Must Support</em>' attribute.
	 * @see #isMustSupport()
	 * @generated
	 */
	void setMustSupport(boolean value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.TypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeRef> getTypes();

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see #setBinding(BindingRef)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Binding()
	 * @model
	 * @generated
	 */
	BindingRef getBinding();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getBinding <em>Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(BindingRef value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Name()
	 * @model required="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Short Defn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Short Defn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Short Defn</em>' attribute.
	 * @see #setShortDefn(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_ShortDefn()
	 * @model
	 * @generated
	 */
	String getShortDefn();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getShortDefn <em>Short Defn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Defn</em>' attribute.
	 * @see #getShortDefn()
	 * @generated
	 */
	void setShortDefn(String value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' attribute.
	 * @see #setDefinition(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Definition()
	 * @model
	 * @generated
	 */
	String getDefinition();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getDefinition <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' attribute.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' attribute.
	 * @see #setRequirements(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Requirements()
	 * @model
	 * @generated
	 */
	String getRequirements();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getRequirements <em>Requirements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirements</em>' attribute.
	 * @see #getRequirements()
	 * @generated
	 */
	void setRequirements(String value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' attribute.
	 * @see #setComments(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Comments()
	 * @model
	 * @generated
	 */
	String getComments();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getComments <em>Comments</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comments</em>' attribute.
	 * @see #getComments()
	 * @generated
	 */
	void setComments(String value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Committee Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Committee Notes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Committee Notes</em>' attribute.
	 * @see #setCommitteeNotes(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_CommitteeNotes()
	 * @model
	 * @generated
	 */
	String getCommitteeNotes();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getCommitteeNotes <em>Committee Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Committee Notes</em>' attribute.
	 * @see #getCommitteeNotes()
	 * @generated
	 */
	void setCommitteeNotes(String value);

	/**
	 * Returns the value of the '<em><b>Example Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Example Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Example Value</em>' attribute.
	 * @see #setExampleValue(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_ExampleValue()
	 * @model
	 * @generated
	 */
	String getExampleValue();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getExampleValue <em>Example Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Example Value</em>' attribute.
	 * @see #getExampleValue()
	 * @generated
	 */
	void setExampleValue(String value);

	/**
	 * Returns the value of the '<em><b>Profile Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * only in a profile, for unpicking
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Profile Name</em>' attribute.
	 * @see #setProfileName(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_ProfileName()
	 * @model
	 * @generated
	 */
	String getProfileName();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getProfileName <em>Profile Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile Name</em>' attribute.
	 * @see #getProfileName()
	 * @generated
	 */
	void setProfileName(String value);

	/**
	 * Returns the value of the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Uri</em>' attribute.
	 * @see #setTargetUri(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_TargetUri()
	 * @model
	 * @generated
	 */
	String getTargetUri();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getTargetUri <em>Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Uri</em>' attribute.
	 * @see #getTargetUri()
	 * @generated
	 */
	void setTargetUri(String value);

	/**
	 * Returns the value of the '<em><b>Fixed Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed Value</em>' attribute.
	 * @see #setFixedValue(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_FixedValue()
	 * @model
	 * @generated
	 */
	String getFixedValue();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getFixedValue <em>Fixed Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed Value</em>' attribute.
	 * @see #getFixedValue()
	 * @generated
	 */
	void setFixedValue(String value);

	/**
	 * Returns the value of the '<em><b>Aggregation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation</em>' attribute.
	 * @see #setAggregation(String)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Aggregation()
	 * @model
	 * @generated
	 */
	String getAggregation();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getAggregation <em>Aggregation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation</em>' attribute.
	 * @see #getAggregation()
	 * @generated
	 */
	void setAggregation(String value);

	/**
	 * Returns the value of the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inherited</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited</em>' attribute.
	 * @see #setInherited(boolean)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Inherited()
	 * @model
	 * @generated
	 */
	boolean isInherited();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isInherited <em>Inherited</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited</em>' attribute.
	 * @see #isInherited()
	 * @generated
	 */
	void setInherited(boolean value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementDefn> getElements();

	/**
	 * Returns the value of the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' reference.
	 * @see #setContent(ElementDefn)
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#getElementDefn_Content()
	 * @model
	 * @generated
	 */
	ElementDefn getContent();

	/**
	 * Sets the value of the '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getContent <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(ElementDefn value);

} // ElementDefn
