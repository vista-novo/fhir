/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.hl7.fhir.definitions.ecore.fhir.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FhirFactoryImpl extends EFactoryImpl implements FhirFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FhirFactory init() {
		try {
			FhirFactory theFhirFactory = (FhirFactory)EPackage.Registry.INSTANCE.getEFactory("http://hl7.org/fhir/definitions"); 
			if (theFhirFactory != null) {
				return theFhirFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FhirFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FhirFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FhirPackage.DEFINITIONS: return createDefinitions();
			case FhirPackage.ELEMENT_DEFN: return createElementDefn();
			case FhirPackage.INVARIANT: return createInvariant();
			case FhirPackage.TYPE_REF: return createTypeRef();
			case FhirPackage.BINDING_DEFN: return createBindingDefn();
			case FhirPackage.MAPPING: return createMapping();
			case FhirPackage.RESOURCE_DEFN: return createResourceDefn();
			case FhirPackage.EXAMPLE: return createExample();
			case FhirPackage.DEFINED_CODE: return createDefinedCode();
			case FhirPackage.PRIMITIVE_TYPE_DEFN: return createPrimitiveTypeDefn();
			case FhirPackage.CONSTRAINED_TYPE_DEFN: return createConstrainedTypeDefn();
			case FhirPackage.EVENT_DEFN: return createEventDefn();
			case FhirPackage.EVENT_USAGE: return createEventUsage();
			case FhirPackage.PROFILE_DEFN: return createProfileDefn();
			case FhirPackage.META_DATA_ITEM: return createMetaDataItem();
			case FhirPackage.SEARCH_PARAMETER: return createSearchParameter();
			case FhirPackage.COMPOSITE_TYPE_DEFN: return createCompositeTypeDefn();
			case FhirPackage.ANNOTATIONS: return createAnnotations();
			case FhirPackage.PROFILED_ELEMENT_DEFN: return createProfiledElementDefn();
			case FhirPackage.INVARIANT_REF: return createInvariantRef();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FhirPackage.BINDING_TYPE:
				return createBindingTypeFromString(eDataType, initialValue);
			case FhirPackage.BINDING_STRENGTH:
				return createBindingStrengthFromString(eDataType, initialValue);
			case FhirPackage.SEARCH_TYPE:
				return createSearchTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FhirPackage.BINDING_TYPE:
				return convertBindingTypeToString(eDataType, instanceValue);
			case FhirPackage.BINDING_STRENGTH:
				return convertBindingStrengthToString(eDataType, instanceValue);
			case FhirPackage.SEARCH_TYPE:
				return convertSearchTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definitions createDefinitions() {
		DefinitionsImpl definitions = new DefinitionsImpl();
		return definitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementDefn createElementDefn() {
		ElementDefnImpl elementDefn = new ElementDefnImpl();
		return elementDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invariant createInvariant() {
		InvariantImpl invariant = new InvariantImpl();
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRef createTypeRef() {
		TypeRefImpl typeRef = new TypeRefImpl();
		return typeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingDefn createBindingDefn() {
		BindingDefnImpl bindingDefn = new BindingDefnImpl();
		return bindingDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDefn createResourceDefn() {
		ResourceDefnImpl resourceDefn = new ResourceDefnImpl();
		return resourceDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Example createExample() {
		ExampleImpl example = new ExampleImpl();
		return example;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinedCode createDefinedCode() {
		DefinedCodeImpl definedCode = new DefinedCodeImpl();
		return definedCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypeDefn createPrimitiveTypeDefn() {
		PrimitiveTypeDefnImpl primitiveTypeDefn = new PrimitiveTypeDefnImpl();
		return primitiveTypeDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstrainedTypeDefn createConstrainedTypeDefn() {
		ConstrainedTypeDefnImpl constrainedTypeDefn = new ConstrainedTypeDefnImpl();
		return constrainedTypeDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventDefn createEventDefn() {
		EventDefnImpl eventDefn = new EventDefnImpl();
		return eventDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventUsage createEventUsage() {
		EventUsageImpl eventUsage = new EventUsageImpl();
		return eventUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileDefn createProfileDefn() {
		ProfileDefnImpl profileDefn = new ProfileDefnImpl();
		return profileDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaDataItem createMetaDataItem() {
		MetaDataItemImpl metaDataItem = new MetaDataItemImpl();
		return metaDataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchParameter createSearchParameter() {
		SearchParameterImpl searchParameter = new SearchParameterImpl();
		return searchParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeTypeDefn createCompositeTypeDefn() {
		CompositeTypeDefnImpl compositeTypeDefn = new CompositeTypeDefnImpl();
		return compositeTypeDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotations createAnnotations() {
		AnnotationsImpl annotations = new AnnotationsImpl();
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfiledElementDefn createProfiledElementDefn() {
		ProfiledElementDefnImpl profiledElementDefn = new ProfiledElementDefnImpl();
		return profiledElementDefn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantRef createInvariantRef() {
		InvariantRefImpl invariantRef = new InvariantRefImpl();
		return invariantRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingType createBindingTypeFromString(EDataType eDataType, String initialValue) {
		BindingType result = BindingType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBindingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingStrength createBindingStrengthFromString(EDataType eDataType, String initialValue) {
		BindingStrength result = BindingStrength.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBindingStrengthToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchType createSearchTypeFromString(EDataType eDataType, String initialValue) {
		SearchType result = SearchType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSearchTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FhirPackage getFhirPackage() {
		return (FhirPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FhirPackage getPackage() {
		return FhirPackage.eINSTANCE;
	}

} //FhirFactoryImpl
