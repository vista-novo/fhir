/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.hl7.fhir.definitions.ecore.fhir.Annotations;
import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.BindingRef;
import org.hl7.fhir.definitions.ecore.fhir.Binding;
import org.hl7.fhir.definitions.ecore.fhir.BindingStrength;
import org.hl7.fhir.definitions.ecore.fhir.BindingType;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.Constraint;
import org.hl7.fhir.definitions.ecore.fhir.DefinedCode;
import org.hl7.fhir.definitions.ecore.fhir.Definitions;
import org.hl7.fhir.definitions.ecore.fhir.ElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.EventDefn;
import org.hl7.fhir.definitions.ecore.fhir.EventUsage;
import org.hl7.fhir.definitions.ecore.fhir.Example;
import org.hl7.fhir.definitions.ecore.fhir.FhirFactory;
import org.hl7.fhir.definitions.ecore.fhir.FhirPackage;
import org.hl7.fhir.definitions.ecore.fhir.Invariant;
import org.hl7.fhir.definitions.ecore.fhir.InvariantRef;
import org.hl7.fhir.definitions.ecore.fhir.Mapping;
import org.hl7.fhir.definitions.ecore.fhir.MetaDataItem;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
import org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ProfileDefn;
import org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn;
import org.hl7.fhir.definitions.ecore.fhir.ResourceDefn;
import org.hl7.fhir.definitions.ecore.fhir.SearchParameter;
import org.hl7.fhir.definitions.ecore.fhir.SearchType;
import org.hl7.fhir.definitions.ecore.fhir.TypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeRef;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FhirPackageImpl extends EPackageImpl implements FhirPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exampleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definedCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constrainedTypeDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeTypeDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameScopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profiledElementDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass profileDefnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass searchParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bindingTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bindingStrengthEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum searchTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.hl7.fhir.definitions.ecore.fhir.FhirPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FhirPackageImpl() {
		super(eNS_URI, FhirFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FhirPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FhirPackage init() {
		if (isInited) return (FhirPackage)EPackage.Registry.INSTANCE.getEPackage(FhirPackage.eNS_URI);

		// Obtain or create and register package
		FhirPackageImpl theFhirPackage = (FhirPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FhirPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FhirPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFhirPackage.createPackageContents();

		// Initialize created meta-data
		theFhirPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFhirPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FhirPackage.eNS_URI, theFhirPackage);
		return theFhirPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinitions() {
		return definitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_Date() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinitions_Version() {
		return (EAttribute)definitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitions_Events() {
		return (EReference)definitionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefinitions_Profiles() {
		return (EReference)definitionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementDefn() {
		return elementDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDefn_MaxCardinality() {
		return (EAttribute)elementDefnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDefn_MinCardinality() {
		return (EAttribute)elementDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDefn_AllowDAR() {
		return (EAttribute)elementDefnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDefn_MustUnderstand() {
		return (EAttribute)elementDefnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDefn_Invariant() {
		return (EReference)elementDefnEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDefn_MustSupport() {
		return (EAttribute)elementDefnEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDefn_Types() {
		return (EReference)elementDefnEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDefn_Binding() {
		return (EReference)elementDefnEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDefn_Annotation() {
		return (EReference)elementDefnEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDefn_Name() {
		return (EAttribute)elementDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDefn_Mappings() {
		return (EReference)elementDefnEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementDefn_ExampleValue() {
		return (EAttribute)elementDefnEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDefn_Elements() {
		return (EReference)elementDefnEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementDefn_Content() {
		return (EReference)elementDefnEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariant() {
		return invariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariant_Name() {
		return (EAttribute)invariantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariant_Description() {
		return (EAttribute)invariantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariant_Human() {
		return (EAttribute)invariantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariant_Ocl() {
		return (EAttribute)invariantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariant_Xpath() {
		return (EAttribute)invariantEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeRef() {
		return typeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeRef_Name() {
		return (EAttribute)typeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeRef_BoundParam() {
		return (EAttribute)typeRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeRef_TakesAnyResource() {
		return (EAttribute)typeRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeRef_IsUnboundGeneric() {
		return (EAttribute)typeRefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeRef_IsPseudoType() {
		return (EAttribute)typeRefEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingDefn() {
		return bindingDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingDefn_Id() {
		return (EAttribute)bindingDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingDefn_Name() {
		return (EAttribute)bindingDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingDefn_Binding() {
		return (EAttribute)bindingDefnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingDefn_Strength() {
		return (EAttribute)bindingDefnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingDefn_ArtifactName() {
		return (EAttribute)bindingDefnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingDefn_Source() {
		return (EAttribute)bindingDefnEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingDefn_Codes() {
		return (EReference)bindingDefnEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingDefn_Annotations() {
		return (EReference)bindingDefnEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingDefn_Parent() {
		return (EReference)bindingDefnEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_Source() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_Details() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDefn() {
		return resourceDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDefn_Example() {
		return (EReference)resourceDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDefn_Sandbox() {
		return (EAttribute)resourceDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceDefn_Searches() {
		return (EReference)resourceDefnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDefn_Future() {
		return (EAttribute)resourceDefnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExample() {
		return exampleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExample_Name() {
		return (EAttribute)exampleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExample_Description() {
		return (EAttribute)exampleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExample_Path() {
		return (EAttribute)exampleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExample_InBook() {
		return (EAttribute)exampleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinedCode() {
		return definedCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinedCode_Code() {
		return (EAttribute)definedCodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinedCode_Definition() {
		return (EAttribute)definedCodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeDefn() {
		return primitiveTypeDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTypeDefn_Pattern() {
		return (EAttribute)primitiveTypeDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTypeDefn_Xsdtype() {
		return (EAttribute)primitiveTypeDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstrainedTypeDefn() {
		return constrainedTypeDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstrainedTypeDefn_BaseType() {
		return (EReference)constrainedTypeDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstrainedTypeDefn_Details() {
		return (EReference)constrainedTypeDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeDefn() {
		return typeDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeDefn_Name() {
		return (EAttribute)typeDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeDefn_Annotations() {
		return (EReference)typeDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeDefn_Parent() {
		return (EReference)typeDefnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeTypeDefn() {
		return compositeTypeDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeTypeDefn_Elements() {
		return (EReference)compositeTypeDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeTypeDefn_Invariants() {
		return (EReference)compositeTypeDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeTypeDefn_AllowedGenericTypes() {
		return (EReference)compositeTypeDefnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameScope() {
		return nameScopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameScope_Bindings() {
		return (EReference)nameScopeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNameScope_Types() {
		return (EReference)nameScopeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingRef() {
		return bindingRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingRef_Name() {
		return (EAttribute)bindingRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotations() {
		return annotationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_ShortDefinition() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_Definition() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_Comment() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_Requirements() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_RimMapping() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_V2Mapping() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_Todo() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotations_CommitteeNotes() {
		return (EAttribute)annotationsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfiledElementDefn() {
		return profiledElementDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfiledElementDefn_Inherited() {
		return (EAttribute)profiledElementDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfiledElementDefn_Aggregation() {
		return (EAttribute)profiledElementDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfiledElementDefn_FixedValue() {
		return (EAttribute)profiledElementDefnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfiledElementDefn_TargetUri() {
		return (EAttribute)profiledElementDefnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProfiledElementDefn_ProfileName() {
		return (EAttribute)profiledElementDefnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvariantRef() {
		return invariantRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInvariantRef_Name() {
		return (EAttribute)invariantRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventDefn() {
		return eventDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventDefn_Code() {
		return (EAttribute)eventDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventDefn_Definition() {
		return (EAttribute)eventDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventDefn_FollowUps() {
		return (EAttribute)eventDefnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventDefn_Usages() {
		return (EReference)eventDefnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventUsage() {
		return eventUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventUsage_Notes() {
		return (EAttribute)eventUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventUsage_RequestResources() {
		return (EAttribute)eventUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventUsage_RequestAggregations() {
		return (EAttribute)eventUsageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventUsage_ResponseResources() {
		return (EAttribute)eventUsageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventUsage_ResponseAggregations() {
		return (EAttribute)eventUsageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProfileDefn() {
		return profileDefnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProfileDefn_Resources() {
		return (EReference)profileDefnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProfileDefn_Metadata() {
		return (EReference)profileDefnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaDataItem() {
		return metaDataItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaDataItem_Name() {
		return (EAttribute)metaDataItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetaDataItem_Value() {
		return (EAttribute)metaDataItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSearchParameter() {
		return searchParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchParameter_Name() {
		return (EAttribute)searchParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchParameter_Description() {
		return (EAttribute)searchParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSearchParameter_Type() {
		return (EAttribute)searchParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBindingType() {
		return bindingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBindingStrength() {
		return bindingStrengthEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSearchType() {
		return searchTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FhirFactory getFhirFactory() {
		return (FhirFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		definitionsEClass = createEClass(DEFINITIONS);
		createEAttribute(definitionsEClass, DEFINITIONS__DATE);
		createEAttribute(definitionsEClass, DEFINITIONS__VERSION);
		createEReference(definitionsEClass, DEFINITIONS__PROFILES);
		createEReference(definitionsEClass, DEFINITIONS__EVENTS);

		elementDefnEClass = createEClass(ELEMENT_DEFN);
		createEAttribute(elementDefnEClass, ELEMENT_DEFN__NAME);
		createEAttribute(elementDefnEClass, ELEMENT_DEFN__MIN_CARDINALITY);
		createEAttribute(elementDefnEClass, ELEMENT_DEFN__MAX_CARDINALITY);
		createEAttribute(elementDefnEClass, ELEMENT_DEFN__ALLOW_DAR);
		createEAttribute(elementDefnEClass, ELEMENT_DEFN__MUST_UNDERSTAND);
		createEAttribute(elementDefnEClass, ELEMENT_DEFN__MUST_SUPPORT);
		createEReference(elementDefnEClass, ELEMENT_DEFN__TYPES);
		createEReference(elementDefnEClass, ELEMENT_DEFN__MAPPINGS);
		createEAttribute(elementDefnEClass, ELEMENT_DEFN__EXAMPLE_VALUE);
		createEReference(elementDefnEClass, ELEMENT_DEFN__ELEMENTS);
		createEReference(elementDefnEClass, ELEMENT_DEFN__CONTENT);
		createEReference(elementDefnEClass, ELEMENT_DEFN__BINDING);
		createEReference(elementDefnEClass, ELEMENT_DEFN__ANNOTATION);
		createEReference(elementDefnEClass, ELEMENT_DEFN__INVARIANT);

		invariantEClass = createEClass(INVARIANT);
		createEAttribute(invariantEClass, INVARIANT__NAME);
		createEAttribute(invariantEClass, INVARIANT__DESCRIPTION);
		createEAttribute(invariantEClass, INVARIANT__HUMAN);
		createEAttribute(invariantEClass, INVARIANT__OCL);
		createEAttribute(invariantEClass, INVARIANT__XPATH);

		typeRefEClass = createEClass(TYPE_REF);
		createEAttribute(typeRefEClass, TYPE_REF__NAME);
		createEAttribute(typeRefEClass, TYPE_REF__BOUND_PARAM);
		createEAttribute(typeRefEClass, TYPE_REF__TAKES_ANY_RESOURCE);
		createEAttribute(typeRefEClass, TYPE_REF__IS_UNBOUND_GENERIC);
		createEAttribute(typeRefEClass, TYPE_REF__IS_PSEUDO_TYPE);

		bindingDefnEClass = createEClass(BINDING_DEFN);
		createEAttribute(bindingDefnEClass, BINDING_DEFN__ID);
		createEAttribute(bindingDefnEClass, BINDING_DEFN__NAME);
		createEAttribute(bindingDefnEClass, BINDING_DEFN__BINDING);
		createEAttribute(bindingDefnEClass, BINDING_DEFN__STRENGTH);
		createEAttribute(bindingDefnEClass, BINDING_DEFN__ARTIFACT_NAME);
		createEAttribute(bindingDefnEClass, BINDING_DEFN__SOURCE);
		createEReference(bindingDefnEClass, BINDING_DEFN__CODES);
		createEReference(bindingDefnEClass, BINDING_DEFN__ANNOTATIONS);
		createEReference(bindingDefnEClass, BINDING_DEFN__PARENT);

		mappingEClass = createEClass(MAPPING);
		createEAttribute(mappingEClass, MAPPING__SOURCE);
		createEAttribute(mappingEClass, MAPPING__DETAILS);

		resourceDefnEClass = createEClass(RESOURCE_DEFN);
		createEAttribute(resourceDefnEClass, RESOURCE_DEFN__SANDBOX);
		createEReference(resourceDefnEClass, RESOURCE_DEFN__EXAMPLE);
		createEReference(resourceDefnEClass, RESOURCE_DEFN__SEARCHES);
		createEAttribute(resourceDefnEClass, RESOURCE_DEFN__FUTURE);

		exampleEClass = createEClass(EXAMPLE);
		createEAttribute(exampleEClass, EXAMPLE__NAME);
		createEAttribute(exampleEClass, EXAMPLE__DESCRIPTION);
		createEAttribute(exampleEClass, EXAMPLE__PATH);
		createEAttribute(exampleEClass, EXAMPLE__IN_BOOK);

		definedCodeEClass = createEClass(DEFINED_CODE);
		createEAttribute(definedCodeEClass, DEFINED_CODE__CODE);
		createEAttribute(definedCodeEClass, DEFINED_CODE__DEFINITION);

		primitiveTypeDefnEClass = createEClass(PRIMITIVE_TYPE_DEFN);
		createEAttribute(primitiveTypeDefnEClass, PRIMITIVE_TYPE_DEFN__PATTERN);
		createEAttribute(primitiveTypeDefnEClass, PRIMITIVE_TYPE_DEFN__XSDTYPE);

		constrainedTypeDefnEClass = createEClass(CONSTRAINED_TYPE_DEFN);
		createEReference(constrainedTypeDefnEClass, CONSTRAINED_TYPE_DEFN__BASE_TYPE);
		createEReference(constrainedTypeDefnEClass, CONSTRAINED_TYPE_DEFN__DETAILS);

		eventDefnEClass = createEClass(EVENT_DEFN);
		createEAttribute(eventDefnEClass, EVENT_DEFN__CODE);
		createEAttribute(eventDefnEClass, EVENT_DEFN__DEFINITION);
		createEAttribute(eventDefnEClass, EVENT_DEFN__FOLLOW_UPS);
		createEReference(eventDefnEClass, EVENT_DEFN__USAGES);

		eventUsageEClass = createEClass(EVENT_USAGE);
		createEAttribute(eventUsageEClass, EVENT_USAGE__NOTES);
		createEAttribute(eventUsageEClass, EVENT_USAGE__REQUEST_RESOURCES);
		createEAttribute(eventUsageEClass, EVENT_USAGE__REQUEST_AGGREGATIONS);
		createEAttribute(eventUsageEClass, EVENT_USAGE__RESPONSE_RESOURCES);
		createEAttribute(eventUsageEClass, EVENT_USAGE__RESPONSE_AGGREGATIONS);

		profileDefnEClass = createEClass(PROFILE_DEFN);
		createEReference(profileDefnEClass, PROFILE_DEFN__RESOURCES);
		createEReference(profileDefnEClass, PROFILE_DEFN__METADATA);

		metaDataItemEClass = createEClass(META_DATA_ITEM);
		createEAttribute(metaDataItemEClass, META_DATA_ITEM__NAME);
		createEAttribute(metaDataItemEClass, META_DATA_ITEM__VALUE);

		searchParameterEClass = createEClass(SEARCH_PARAMETER);
		createEAttribute(searchParameterEClass, SEARCH_PARAMETER__NAME);
		createEAttribute(searchParameterEClass, SEARCH_PARAMETER__DESCRIPTION);
		createEAttribute(searchParameterEClass, SEARCH_PARAMETER__TYPE);

		typeDefnEClass = createEClass(TYPE_DEFN);
		createEAttribute(typeDefnEClass, TYPE_DEFN__NAME);
		createEReference(typeDefnEClass, TYPE_DEFN__ANNOTATIONS);
		createEReference(typeDefnEClass, TYPE_DEFN__PARENT);

		compositeTypeDefnEClass = createEClass(COMPOSITE_TYPE_DEFN);
		createEReference(compositeTypeDefnEClass, COMPOSITE_TYPE_DEFN__ELEMENTS);
		createEReference(compositeTypeDefnEClass, COMPOSITE_TYPE_DEFN__INVARIANTS);
		createEReference(compositeTypeDefnEClass, COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES);

		nameScopeEClass = createEClass(NAME_SCOPE);
		createEReference(nameScopeEClass, NAME_SCOPE__TYPES);
		createEReference(nameScopeEClass, NAME_SCOPE__BINDINGS);

		bindingRefEClass = createEClass(BINDING_REF);
		createEAttribute(bindingRefEClass, BINDING_REF__NAME);

		annotationsEClass = createEClass(ANNOTATIONS);
		createEAttribute(annotationsEClass, ANNOTATIONS__SHORT_DEFINITION);
		createEAttribute(annotationsEClass, ANNOTATIONS__DEFINITION);
		createEAttribute(annotationsEClass, ANNOTATIONS__COMMENT);
		createEAttribute(annotationsEClass, ANNOTATIONS__REQUIREMENTS);
		createEAttribute(annotationsEClass, ANNOTATIONS__RIM_MAPPING);
		createEAttribute(annotationsEClass, ANNOTATIONS__V2_MAPPING);
		createEAttribute(annotationsEClass, ANNOTATIONS__TODO);
		createEAttribute(annotationsEClass, ANNOTATIONS__COMMITTEE_NOTES);

		profiledElementDefnEClass = createEClass(PROFILED_ELEMENT_DEFN);
		createEAttribute(profiledElementDefnEClass, PROFILED_ELEMENT_DEFN__INHERITED);
		createEAttribute(profiledElementDefnEClass, PROFILED_ELEMENT_DEFN__AGGREGATION);
		createEAttribute(profiledElementDefnEClass, PROFILED_ELEMENT_DEFN__FIXED_VALUE);
		createEAttribute(profiledElementDefnEClass, PROFILED_ELEMENT_DEFN__TARGET_URI);
		createEAttribute(profiledElementDefnEClass, PROFILED_ELEMENT_DEFN__PROFILE_NAME);

		invariantRefEClass = createEClass(INVARIANT_REF);
		createEAttribute(invariantRefEClass, INVARIANT_REF__NAME);

		// Create enums
		bindingTypeEEnum = createEEnum(BINDING_TYPE);
		bindingStrengthEEnum = createEEnum(BINDING_STRENGTH);
		searchTypeEEnum = createEEnum(SEARCH_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		definitionsEClass.getESuperTypes().add(this.getNameScope());
		resourceDefnEClass.getESuperTypes().add(this.getCompositeTypeDefn());
		primitiveTypeDefnEClass.getESuperTypes().add(this.getTypeDefn());
		constrainedTypeDefnEClass.getESuperTypes().add(this.getTypeDefn());
		compositeTypeDefnEClass.getESuperTypes().add(this.getTypeDefn());
		compositeTypeDefnEClass.getESuperTypes().add(this.getNameScope());
		profiledElementDefnEClass.getESuperTypes().add(this.getElementDefn());

		// Initialize classes and features; add operations and parameters
		initEClass(definitionsEClass, Definitions.class, "Definitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefinitions_Date(), ecorePackage.getEDate(), "date", null, 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefinitions_Version(), ecorePackage.getEString(), "version", null, 1, 1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefinitions_Profiles(), this.getProfileDefn(), null, "profiles", null, 0, -1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefinitions_Events(), this.getEventDefn(), null, "events", null, 0, -1, Definitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementDefnEClass, ElementDefn.class, "ElementDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementDefn_Name(), ecorePackage.getEString(), "name", null, 1, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementDefn_MinCardinality(), ecorePackage.getEInt(), "minCardinality", null, 1, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementDefn_MaxCardinality(), ecorePackage.getEInt(), "maxCardinality", null, 1, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementDefn_AllowDAR(), ecorePackage.getEBoolean(), "allowDAR", null, 0, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementDefn_MustUnderstand(), ecorePackage.getEBoolean(), "mustUnderstand", null, 0, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementDefn_MustSupport(), ecorePackage.getEBoolean(), "mustSupport", null, 0, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDefn_Types(), this.getTypeRef(), null, "types", null, 0, -1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDefn_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementDefn_ExampleValue(), ecorePackage.getEString(), "exampleValue", null, 0, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDefn_Elements(), this.getElementDefn(), null, "elements", null, 0, -1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDefn_Content(), this.getElementDefn(), null, "content", null, 0, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDefn_Binding(), this.getBindingRef(), null, "binding", null, 0, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDefn_Annotation(), this.getAnnotations(), null, "annotation", null, 1, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementDefn_Invariant(), this.getInvariantRef(), null, "invariant", null, 0, 1, ElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invariantEClass, Invariant.class, "Invariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvariant_Name(), ecorePackage.getEString(), "name", null, 1, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvariant_Description(), ecorePackage.getEString(), "description", null, 0, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvariant_Human(), ecorePackage.getEString(), "human", null, 1, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvariant_Ocl(), ecorePackage.getEString(), "ocl", null, 0, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInvariant_Xpath(), ecorePackage.getEString(), "xpath", null, 1, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeRefEClass, TypeRef.class, "TypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeRef_BoundParam(), ecorePackage.getEString(), "boundParam", null, 0, -1, TypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeRef_TakesAnyResource(), ecorePackage.getEBoolean(), "takesAnyResource", null, 0, 1, TypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeRef_IsUnboundGeneric(), ecorePackage.getEBoolean(), "isUnboundGeneric", null, 0, 1, TypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeRef_IsPseudoType(), ecorePackage.getEBoolean(), "isPseudoType", null, 0, 1, TypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingDefnEClass, BindingDefn.class, "BindingDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingDefn_Id(), ecorePackage.getEInt(), "id", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingDefn_Name(), ecorePackage.getEString(), "name", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingDefn_Binding(), this.getBindingType(), "binding", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingDefn_Strength(), this.getBindingStrength(), "strength", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingDefn_ArtifactName(), ecorePackage.getEString(), "artifactName", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBindingDefn_Source(), ecorePackage.getEString(), "source", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingDefn_Codes(), this.getDefinedCode(), null, "codes", null, 0, -1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingDefn_Annotations(), this.getAnnotations(), null, "annotations", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingDefn_Parent(), this.getNameScope(), this.getNameScope_Bindings(), "parent", null, 1, 1, BindingDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapping_Source(), ecorePackage.getEString(), "source", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_Details(), ecorePackage.getEString(), "details", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceDefnEClass, ResourceDefn.class, "ResourceDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceDefn_Sandbox(), ecorePackage.getEBoolean(), "sandbox", null, 1, 1, ResourceDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDefn_Example(), this.getExample(), null, "example", null, 1, -1, ResourceDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceDefn_Searches(), this.getSearchParameter(), null, "searches", null, 0, -1, ResourceDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDefn_Future(), ecorePackage.getEBoolean(), "future", null, 0, 1, ResourceDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exampleEClass, Example.class, "Example", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExample_Name(), ecorePackage.getEString(), "name", null, 1, 1, Example.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExample_Description(), ecorePackage.getEString(), "description", null, 0, 1, Example.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExample_Path(), ecorePackage.getEString(), "path", null, 1, 1, Example.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExample_InBook(), ecorePackage.getEBoolean(), "inBook", null, 0, 1, Example.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definedCodeEClass, DefinedCode.class, "DefinedCode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefinedCode_Code(), ecorePackage.getEString(), "code", null, 1, 1, DefinedCode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefinedCode_Definition(), ecorePackage.getEString(), "definition", null, 1, 1, DefinedCode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeDefnEClass, PrimitiveTypeDefn.class, "PrimitiveTypeDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTypeDefn_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, PrimitiveTypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveTypeDefn_Xsdtype(), ecorePackage.getEString(), "xsdtype", null, 1, 1, PrimitiveTypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constrainedTypeDefnEClass, ConstrainedTypeDefn.class, "ConstrainedTypeDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrainedTypeDefn_BaseType(), this.getTypeRef(), null, "baseType", null, 1, 1, ConstrainedTypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstrainedTypeDefn_Details(), this.getInvariant(), null, "details", null, 1, -1, ConstrainedTypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventDefnEClass, EventDefn.class, "EventDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventDefn_Code(), ecorePackage.getEString(), "code", null, 1, 1, EventDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventDefn_Definition(), ecorePackage.getEString(), "definition", null, 1, 1, EventDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventDefn_FollowUps(), ecorePackage.getEString(), "followUps", null, 0, -1, EventDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventDefn_Usages(), this.getEventUsage(), null, "usages", null, 1, -1, EventDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventUsageEClass, EventUsage.class, "EventUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventUsage_Notes(), ecorePackage.getEString(), "notes", null, 0, 1, EventUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventUsage_RequestResources(), ecorePackage.getEString(), "requestResources", null, 0, -1, EventUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventUsage_RequestAggregations(), ecorePackage.getEString(), "requestAggregations", null, 0, -1, EventUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventUsage_ResponseResources(), ecorePackage.getEString(), "responseResources", null, 0, -1, EventUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventUsage_ResponseAggregations(), ecorePackage.getEString(), "responseAggregations", null, 0, -1, EventUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(profileDefnEClass, ProfileDefn.class, "ProfileDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProfileDefn_Resources(), this.getResourceDefn(), null, "resources", null, 1, -1, ProfileDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProfileDefn_Metadata(), this.getMetaDataItem(), null, "metadata", null, 0, -1, ProfileDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaDataItemEClass, MetaDataItem.class, "MetaDataItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetaDataItem_Name(), ecorePackage.getEString(), "name", null, 1, 1, MetaDataItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaDataItem_Value(), ecorePackage.getEString(), "value", null, 0, -1, MetaDataItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(searchParameterEClass, SearchParameter.class, "SearchParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSearchParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, SearchParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchParameter_Description(), ecorePackage.getEString(), "description", null, 0, 1, SearchParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSearchParameter_Type(), this.getSearchType(), "type", null, 1, 1, SearchParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeDefnEClass, TypeDefn.class, "TypeDefn", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeDefn_Name(), ecorePackage.getEString(), "name", null, 1, 1, TypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeDefn_Annotations(), this.getAnnotations(), null, "annotations", null, 1, 1, TypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeDefn_Parent(), this.getNameScope(), this.getNameScope_Types(), "parent", null, 0, 1, TypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(typeDefnEClass, ecorePackage.getEString(), "getFQN", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compositeTypeDefnEClass, CompositeTypeDefn.class, "CompositeTypeDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeTypeDefn_Elements(), this.getElementDefn(), null, "elements", null, 0, -1, CompositeTypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeTypeDefn_Invariants(), this.getInvariant(), null, "invariants", null, 0, -1, CompositeTypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeTypeDefn_AllowedGenericTypes(), this.getTypeRef(), null, "allowedGenericTypes", null, 0, -1, CompositeTypeDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameScopeEClass, NameScope.class, "NameScope", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNameScope_Types(), this.getTypeDefn(), this.getTypeDefn_Parent(), "types", null, 0, -1, NameScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNameScope_Bindings(), this.getBindingDefn(), this.getBindingDefn_Parent(), "bindings", null, 0, -1, NameScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(nameScopeEClass, this.getTypeDefn(), "resolveType", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nameScopeEClass, this.getTypeDefn(), "getTypeByName", 0, -1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(nameScopeEClass, this.getTypeDefn(), "filterTypes", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "scope", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "typeKind", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nameScopeEClass, this.getBindingDefn(), "resolveBinding", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(nameScopeEClass, this.getBindingDefn(), "getBindingByName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bindingRefEClass, BindingRef.class, "BindingRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, BindingRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationsEClass, Annotations.class, "Annotations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotations_ShortDefinition(), ecorePackage.getEString(), "shortDefinition", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotations_Definition(), ecorePackage.getEString(), "definition", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotations_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotations_Requirements(), ecorePackage.getEString(), "requirements", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotations_RimMapping(), ecorePackage.getEString(), "rimMapping", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotations_V2Mapping(), ecorePackage.getEString(), "v2Mapping", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotations_Todo(), ecorePackage.getEString(), "todo", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotations_CommitteeNotes(), ecorePackage.getEString(), "committeeNotes", null, 0, 1, Annotations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(profiledElementDefnEClass, ProfiledElementDefn.class, "ProfiledElementDefn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProfiledElementDefn_Inherited(), ecorePackage.getEBoolean(), "inherited", null, 0, 1, ProfiledElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfiledElementDefn_Aggregation(), ecorePackage.getEString(), "aggregation", null, 0, 1, ProfiledElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfiledElementDefn_FixedValue(), ecorePackage.getEString(), "fixedValue", null, 0, 1, ProfiledElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfiledElementDefn_TargetUri(), ecorePackage.getEString(), "targetUri", null, 0, 1, ProfiledElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfiledElementDefn_ProfileName(), ecorePackage.getEString(), "profileName", null, 0, 1, ProfiledElementDefn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invariantRefEClass, InvariantRef.class, "InvariantRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInvariantRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, InvariantRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(bindingTypeEEnum, BindingType.class, "BindingType");
		addEEnumLiteral(bindingTypeEEnum, BindingType.UNBOUND);
		addEEnumLiteral(bindingTypeEEnum, BindingType.CODE_LIST);
		addEEnumLiteral(bindingTypeEEnum, BindingType.VALUE_SET);
		addEEnumLiteral(bindingTypeEEnum, BindingType.REFERENCE);
		addEEnumLiteral(bindingTypeEEnum, BindingType.SPECIAL);

		initEEnum(bindingStrengthEEnum, BindingStrength.class, "BindingStrength");
		addEEnumLiteral(bindingStrengthEEnum, BindingStrength.UNSTATED);
		addEEnumLiteral(bindingStrengthEEnum, BindingStrength.REQUIRED);
		addEEnumLiteral(bindingStrengthEEnum, BindingStrength.PREFERRED);
		addEEnumLiteral(bindingStrengthEEnum, BindingStrength.SUGGESTED);

		initEEnum(searchTypeEEnum, SearchType.class, "SearchType");
		addEEnumLiteral(searchTypeEEnum, SearchType.INTEGER);
		addEEnumLiteral(searchTypeEEnum, SearchType.STRING);
		addEEnumLiteral(searchTypeEEnum, SearchType.TEXT);
		addEEnumLiteral(searchTypeEEnum, SearchType.DATE);
		addEEnumLiteral(searchTypeEEnum, SearchType.TOKEN);
		addEEnumLiteral(searchTypeEEnum, SearchType.QTOKEN);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (getDefinitions_Events(), 
		   source, 
		   new String[] {
			 "name", "event"
		   });		
		addAnnotation
		  (getElementDefn_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getElementDefn_MinCardinality(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getElementDefn_MaxCardinality(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getElementDefn_AllowDAR(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getElementDefn_MustUnderstand(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getElementDefn_MustSupport(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getElementDefn_Types(), 
		   source, 
		   new String[] {
			 "name", "type"
		   });		
		addAnnotation
		  (getElementDefn_Mappings(), 
		   source, 
		   new String[] {
			 "name", "mapping"
		   });		
		addAnnotation
		  (getElementDefn_ExampleValue(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getElementDefn_Elements(), 
		   source, 
		   new String[] {
			 "name", "element"
		   });		
		addAnnotation
		  (getInvariant_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getInvariant_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getInvariant_Human(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getInvariant_Ocl(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getInvariant_Xpath(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });			
		addAnnotation
		  (getBindingDefn_Source(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getBindingDefn_Codes(), 
		   source, 
		   new String[] {
			 "name", "code"
		   });		
		addAnnotation
		  (getResourceDefn_Searches(), 
		   source, 
		   new String[] {
			 "name", "search"
		   });		
		addAnnotation
		  (getExample_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getExample_Description(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getExample_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getExample_InBook(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDefinedCode_Code(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getDefinedCode_Definition(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getPrimitiveTypeDefn_Pattern(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getConstrainedTypeDefn_Details(), 
		   source, 
		   new String[] {
			 "name", "detail"
		   });		
		addAnnotation
		  (getEventDefn_Code(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getEventDefn_Definition(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getEventDefn_FollowUps(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getEventDefn_Usages(), 
		   source, 
		   new String[] {
			 "name", "usage"
		   });		
		addAnnotation
		  (getProfileDefn_Resources(), 
		   source, 
		   new String[] {
			 "name", "resource"
		   });		
		addAnnotation
		  (getCompositeTypeDefn_Elements(), 
		   source, 
		   new String[] {
			 "name", "element"
		   });		
		addAnnotation
		  (getCompositeTypeDefn_Invariants(), 
		   source, 
		   new String[] {
			 "name", "invariant"
		   });		
		addAnnotation
		  (getCompositeTypeDefn_AllowedGenericTypes(), 
		   source, 
		   new String[] {
			 "name", "allowedGenericType"
		   });		
		addAnnotation
		  (getNameScope_Types(), 
		   source, 
		   new String[] {
			 "name", "type",
			 "namespace", ""
		   });		
		addAnnotation
		  (getNameScope_Bindings(), 
		   source, 
		   new String[] {
			 "name", "binding"
		   });		
		addAnnotation
		  (getBindingRef_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getAnnotations_ShortDefinition(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });		
		addAnnotation
		  (getAnnotations_Definition(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAnnotations_Comment(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAnnotations_Requirements(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAnnotations_RimMapping(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAnnotations_V2Mapping(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAnnotations_Todo(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });		
		addAnnotation
		  (getAnnotations_CommitteeNotes(), 
		   source, 
		   new String[] {
			 "kind", "element"
		   });			
		addAnnotation
		  (getInvariantRef_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute"
		   });
	}

} //FhirPackageImpl
