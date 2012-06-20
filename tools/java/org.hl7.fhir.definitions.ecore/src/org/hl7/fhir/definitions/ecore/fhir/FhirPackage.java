/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.hl7.fhir.definitions.ecore.fhir;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.hl7.fhir.definitions.ecore.fhir.FhirFactory
 * @model kind="package"
 * @generated
 */
public interface FhirPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "fhir";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hl7.org/fhir/definitions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fhir";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FhirPackage eINSTANCE = org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl <em>Definitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getDefinitions()
	 * @generated
	 */
	int DEFINITIONS = 0;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl <em>Element Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getElementDefn()
	 * @generated
	 */
	int ELEMENT_DEFN = 1;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.InvariantImpl <em>Invariant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.InvariantImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getInvariant()
	 * @generated
	 */
	int INVARIANT = 2;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl <em>Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getTypeRef()
	 * @generated
	 */
	int TYPE_REF = 3;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.BindingDefnImpl <em>Binding Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.BindingDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingDefn()
	 * @generated
	 */
	int BINDING_DEFN = 4;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.MappingImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 5;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl <em>Resource Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getResourceDefn()
	 * @generated
	 */
	int RESOURCE_DEFN = 6;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ExampleImpl <em>Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ExampleImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getExample()
	 * @generated
	 */
	int EXAMPLE = 7;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinedCodeImpl <em>Defined Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.DefinedCodeImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getDefinedCode()
	 * @generated
	 */
	int DEFINED_CODE = 8;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.PrimitiveTypeDefnImpl <em>Primitive Type Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.PrimitiveTypeDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getPrimitiveTypeDefn()
	 * @generated
	 */
	int PRIMITIVE_TYPE_DEFN = 9;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl <em>Composite Type Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getCompositeTypeDefn()
	 * @generated
	 */
	int COMPOSITE_TYPE_DEFN = 17;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl <em>Constrained Type Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getConstrainedTypeDefn()
	 * @generated
	 */
	int CONSTRAINED_TYPE_DEFN = 10;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeDefnImpl <em>Type Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.TypeDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getTypeDefn()
	 * @generated
	 */
	int TYPE_DEFN = 16;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.NameScope <em>Name Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.NameScope
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getNameScope()
	 * @generated
	 */
	int NAME_SCOPE = 18;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_SCOPE__BINDINGS = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_SCOPE__TYPES = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_SCOPE__PARENT = 2;

	/**
	 * The number of structural features of the '<em>Name Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_SCOPE_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__BINDINGS = NAME_SCOPE__BINDINGS;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__TYPES = NAME_SCOPE__TYPES;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__PARENT = NAME_SCOPE__PARENT;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__DATE = NAME_SCOPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__VERSION = NAME_SCOPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__PROFILES = NAME_SCOPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS__EVENTS = NAME_SCOPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Definitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITIONS_FEATURE_COUNT = NAME_SCOPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Min Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__MIN_CARDINALITY = 1;

	/**
	 * The feature id for the '<em><b>Max Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__MAX_CARDINALITY = 2;

	/**
	 * The feature id for the '<em><b>Allow DAR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__ALLOW_DAR = 3;

	/**
	 * The feature id for the '<em><b>Must Understand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__MUST_UNDERSTAND = 4;

	/**
	 * The feature id for the '<em><b>Must Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__MUST_SUPPORT = 5;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__TYPES = 6;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__MAPPINGS = 7;

	/**
	 * The feature id for the '<em><b>Example Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__EXAMPLE_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__ELEMENTS = 9;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__CONTENT = 10;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__BINDING = 11;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__ANNOTATION = 12;

	/**
	 * The feature id for the '<em><b>Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN__INVARIANT = 13;

	/**
	 * The number of structural features of the '<em>Element Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DEFN_FEATURE_COUNT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Human</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__HUMAN = 2;

	/**
	 * The feature id for the '<em><b>Ocl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__OCL = 3;

	/**
	 * The feature id for the '<em><b>Xpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT__XPATH = 4;

	/**
	 * The number of structural features of the '<em>Invariant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF__NAME = 0;

	/**
	 * The feature id for the '<em><b>Bound Param</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF__BOUND_PARAM = 1;

	/**
	 * The feature id for the '<em><b>Takes Any Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF__TAKES_ANY_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Is Unbound Generic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF__IS_UNBOUND_GENERIC = 3;

	/**
	 * The feature id for the '<em><b>Is Pseudo Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF__IS_PSEUDO_TYPE = 4;

	/**
	 * The number of structural features of the '<em>Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_REF_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__NAME = 1;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__BINDING = 2;

	/**
	 * The feature id for the '<em><b>Strength</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__STRENGTH = 3;

	/**
	 * The feature id for the '<em><b>Artifact Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__ARTIFACT_NAME = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__SOURCE = 5;

	/**
	 * The feature id for the '<em><b>Codes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__CODES = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__ANNOTATIONS = 7;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN__CONTAINER = 8;

	/**
	 * The number of structural features of the '<em>Binding Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_DEFN_FEATURE_COUNT = 9;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DETAILS = 1;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__BINDINGS = NAME_SCOPE__BINDINGS;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__TYPES = NAME_SCOPE__TYPES;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__PARENT = NAME_SCOPE__PARENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__NAME = NAME_SCOPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__ANNOTATIONS = NAME_SCOPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__CONTAINER = NAME_SCOPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__ELEMENTS = NAME_SCOPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__INVARIANTS = NAME_SCOPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Allowed Generic Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__ALLOWED_GENERIC_TYPES = NAME_SCOPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sandbox</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__SANDBOX = NAME_SCOPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Example</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__EXAMPLE = NAME_SCOPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Searches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__SEARCHES = NAME_SCOPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Future</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN__FUTURE = NAME_SCOPE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Resource Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DEFN_FEATURE_COUNT = NAME_SCOPE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__PATH = 2;

	/**
	 * The feature id for the '<em><b>In Book</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE__IN_BOOK = 3;

	/**
	 * The number of structural features of the '<em>Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXAMPLE_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_CODE__CODE = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_CODE__DEFINITION = 1;

	/**
	 * The number of structural features of the '<em>Defined Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_CODE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFN__ANNOTATIONS = 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFN__CONTAINER = 2;

	/**
	 * The number of structural features of the '<em>Type Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFN_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DEFN__NAME = TYPE_DEFN__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DEFN__ANNOTATIONS = TYPE_DEFN__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DEFN__CONTAINER = TYPE_DEFN__CONTAINER;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DEFN__PATTERN = TYPE_DEFN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Xsdtype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DEFN__XSDTYPE = TYPE_DEFN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Primitive Type Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_DEFN_FEATURE_COUNT = TYPE_DEFN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__NAME = TYPE_DEFN__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__ANNOTATIONS = TYPE_DEFN__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__CONTAINER = TYPE_DEFN__CONTAINER;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__BINDINGS = TYPE_DEFN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__TYPES = TYPE_DEFN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__PARENT = TYPE_DEFN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__ELEMENTS = TYPE_DEFN_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__INVARIANTS = TYPE_DEFN_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Allowed Generic Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES = TYPE_DEFN_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Composite Type Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_TYPE_DEFN_FEATURE_COUNT = TYPE_DEFN_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__NAME = COMPOSITE_TYPE_DEFN__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__ANNOTATIONS = COMPOSITE_TYPE_DEFN__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__CONTAINER = COMPOSITE_TYPE_DEFN__CONTAINER;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__BINDINGS = COMPOSITE_TYPE_DEFN__BINDINGS;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__TYPES = COMPOSITE_TYPE_DEFN__TYPES;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__PARENT = COMPOSITE_TYPE_DEFN__PARENT;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__ELEMENTS = COMPOSITE_TYPE_DEFN__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__INVARIANTS = COMPOSITE_TYPE_DEFN__INVARIANTS;

	/**
	 * The feature id for the '<em><b>Allowed Generic Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__ALLOWED_GENERIC_TYPES = COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES;

	/**
	 * The feature id for the '<em><b>Base Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__BASE_TYPE = COMPOSITE_TYPE_DEFN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Details</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN__DETAILS = COMPOSITE_TYPE_DEFN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constrained Type Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_TYPE_DEFN_FEATURE_COUNT = COMPOSITE_TYPE_DEFN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.EventDefnImpl <em>Event Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.EventDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getEventDefn()
	 * @generated
	 */
	int EVENT_DEFN = 11;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFN__CODE = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFN__DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Follow Ups</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFN__FOLLOW_UPS = 2;

	/**
	 * The feature id for the '<em><b>Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFN__USAGES = 3;

	/**
	 * The number of structural features of the '<em>Event Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFN_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.EventUsageImpl <em>Event Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.EventUsageImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getEventUsage()
	 * @generated
	 */
	int EVENT_USAGE = 12;

	/**
	 * The feature id for the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_USAGE__NOTES = 0;

	/**
	 * The feature id for the '<em><b>Request Resources</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_USAGE__REQUEST_RESOURCES = 1;

	/**
	 * The feature id for the '<em><b>Request Aggregations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_USAGE__REQUEST_AGGREGATIONS = 2;

	/**
	 * The feature id for the '<em><b>Response Resources</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_USAGE__RESPONSE_RESOURCES = 3;

	/**
	 * The feature id for the '<em><b>Response Aggregations</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_USAGE__RESPONSE_AGGREGATIONS = 4;

	/**
	 * The number of structural features of the '<em>Event Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_USAGE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ProfileDefnImpl <em>Profile Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ProfileDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getProfileDefn()
	 * @generated
	 */
	int PROFILE_DEFN = 13;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DEFN__RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DEFN__METADATA = 1;

	/**
	 * The number of structural features of the '<em>Profile Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_DEFN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.MetaDataItemImpl <em>Meta Data Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.MetaDataItemImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getMetaDataItem()
	 * @generated
	 */
	int META_DATA_ITEM = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_ITEM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_ITEM__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Meta Data Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_ITEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.SearchParameterImpl <em>Search Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.SearchParameterImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getSearchParameter()
	 * @generated
	 */
	int SEARCH_PARAMETER = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAMETER__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAMETER__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Search Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.BindingRefImpl <em>Binding Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.BindingRefImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingRef()
	 * @generated
	 */
	int BINDING_REF = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_REF__NAME = 0;

	/**
	 * The number of structural features of the '<em>Binding Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_REF_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.AnnotationsImpl <em>Annotations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.AnnotationsImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getAnnotations()
	 * @generated
	 */
	int ANNOTATIONS = 20;

	/**
	 * The feature id for the '<em><b>Short Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__SHORT_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__REQUIREMENTS = 3;

	/**
	 * The feature id for the '<em><b>Rim Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__RIM_MAPPING = 4;

	/**
	 * The feature id for the '<em><b>V2 Mapping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__V2_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Todo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__TODO = 6;

	/**
	 * The feature id for the '<em><b>Committee Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS__COMMITTEE_NOTES = 7;

	/**
	 * The number of structural features of the '<em>Annotations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATIONS_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ProfiledElementDefnImpl <em>Profiled Element Defn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ProfiledElementDefnImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getProfiledElementDefn()
	 * @generated
	 */
	int PROFILED_ELEMENT_DEFN = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__NAME = ELEMENT_DEFN__NAME;

	/**
	 * The feature id for the '<em><b>Min Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__MIN_CARDINALITY = ELEMENT_DEFN__MIN_CARDINALITY;

	/**
	 * The feature id for the '<em><b>Max Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__MAX_CARDINALITY = ELEMENT_DEFN__MAX_CARDINALITY;

	/**
	 * The feature id for the '<em><b>Allow DAR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__ALLOW_DAR = ELEMENT_DEFN__ALLOW_DAR;

	/**
	 * The feature id for the '<em><b>Must Understand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__MUST_UNDERSTAND = ELEMENT_DEFN__MUST_UNDERSTAND;

	/**
	 * The feature id for the '<em><b>Must Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__MUST_SUPPORT = ELEMENT_DEFN__MUST_SUPPORT;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__TYPES = ELEMENT_DEFN__TYPES;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__MAPPINGS = ELEMENT_DEFN__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Example Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__EXAMPLE_VALUE = ELEMENT_DEFN__EXAMPLE_VALUE;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__ELEMENTS = ELEMENT_DEFN__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__CONTENT = ELEMENT_DEFN__CONTENT;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__BINDING = ELEMENT_DEFN__BINDING;

	/**
	 * The feature id for the '<em><b>Annotation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__ANNOTATION = ELEMENT_DEFN__ANNOTATION;

	/**
	 * The feature id for the '<em><b>Invariant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__INVARIANT = ELEMENT_DEFN__INVARIANT;

	/**
	 * The feature id for the '<em><b>Inherited</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__INHERITED = ELEMENT_DEFN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Aggregation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__AGGREGATION = ELEMENT_DEFN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fixed Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__FIXED_VALUE = ELEMENT_DEFN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__TARGET_URI = ELEMENT_DEFN_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Profile Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN__PROFILE_NAME = ELEMENT_DEFN_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Profiled Element Defn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILED_ELEMENT_DEFN_FEATURE_COUNT = ELEMENT_DEFN_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.InvariantRefImpl <em>Invariant Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.InvariantRefImpl
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getInvariantRef()
	 * @generated
	 */
	int INVARIANT_REF = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_REF__NAME = 0;

	/**
	 * The number of structural features of the '<em>Invariant Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_REF_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.BindingType <em>Binding Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingType
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingType()
	 * @generated
	 */
	int BINDING_TYPE = 23;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.BindingStrength <em>Binding Strength</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingStrength
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingStrength()
	 * @generated
	 */
	int BINDING_STRENGTH = 24;

	/**
	 * The meta object id for the '{@link org.hl7.fhir.definitions.ecore.fhir.SearchType <em>Search Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchType
	 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getSearchType()
	 * @generated
	 */
	int SEARCH_TYPE = 25;


	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definitions</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Definitions
	 * @generated
	 */
	EClass getDefinitions();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Definitions#getDate()
	 * @see #getDefinitions()
	 * @generated
	 */
	EAttribute getDefinitions_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Definitions#getVersion()
	 * @see #getDefinitions()
	 * @generated
	 */
	EAttribute getDefinitions_Version();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Definitions#getEvents()
	 * @see #getDefinitions()
	 * @generated
	 */
	EReference getDefinitions_Events();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.Definitions#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Profiles</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Definitions#getProfiles()
	 * @see #getDefinitions()
	 * @generated
	 */
	EReference getDefinitions_Profiles();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn <em>Element Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn
	 * @generated
	 */
	EClass getElementDefn();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMaxCardinality <em>Max Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Cardinality</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMaxCardinality()
	 * @see #getElementDefn()
	 * @generated
	 */
	EAttribute getElementDefn_MaxCardinality();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMinCardinality <em>Min Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Cardinality</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMinCardinality()
	 * @see #getElementDefn()
	 * @generated
	 */
	EAttribute getElementDefn_MinCardinality();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isAllowDAR <em>Allow DAR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow DAR</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isAllowDAR()
	 * @see #getElementDefn()
	 * @generated
	 */
	EAttribute getElementDefn_AllowDAR();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustUnderstand <em>Must Understand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Must Understand</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustUnderstand()
	 * @see #getElementDefn()
	 * @generated
	 */
	EAttribute getElementDefn_MustUnderstand();

	/**
	 * Returns the meta object for the containment reference '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getInvariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invariant</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getInvariant()
	 * @see #getElementDefn()
	 * @generated
	 */
	EReference getElementDefn_Invariant();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustSupport <em>Must Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Must Support</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#isMustSupport()
	 * @see #getElementDefn()
	 * @generated
	 */
	EAttribute getElementDefn_MustSupport();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getTypes()
	 * @see #getElementDefn()
	 * @generated
	 */
	EReference getElementDefn_Types();

	/**
	 * Returns the meta object for the containment reference '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Binding</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getBinding()
	 * @see #getElementDefn()
	 * @generated
	 */
	EReference getElementDefn_Binding();

	/**
	 * Returns the meta object for the containment reference '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getAnnotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotation</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getAnnotation()
	 * @see #getElementDefn()
	 * @generated
	 */
	EReference getElementDefn_Annotation();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getName()
	 * @see #getElementDefn()
	 * @generated
	 */
	EAttribute getElementDefn_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getMappings()
	 * @see #getElementDefn()
	 * @generated
	 */
	EReference getElementDefn_Mappings();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getExampleValue <em>Example Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Example Value</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getExampleValue()
	 * @see #getElementDefn()
	 * @generated
	 */
	EAttribute getElementDefn_ExampleValue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getElements()
	 * @see #getElementDefn()
	 * @generated
	 */
	EReference getElementDefn_Elements();

	/**
	 * Returns the meta object for the reference '{@link org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Content</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ElementDefn#getContent()
	 * @see #getElementDefn()
	 * @generated
	 */
	EReference getElementDefn_Content();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.Invariant <em>Invariant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Invariant
	 * @generated
	 */
	EClass getInvariant();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Invariant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Invariant#getName()
	 * @see #getInvariant()
	 * @generated
	 */
	EAttribute getInvariant_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Invariant#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Invariant#getDescription()
	 * @see #getInvariant()
	 * @generated
	 */
	EAttribute getInvariant_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Invariant#getHuman <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Human</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Invariant#getHuman()
	 * @see #getInvariant()
	 * @generated
	 */
	EAttribute getInvariant_Human();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Invariant#getOcl <em>Ocl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ocl</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Invariant#getOcl()
	 * @see #getInvariant()
	 * @generated
	 */
	EAttribute getInvariant_Ocl();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Invariant#getXpath <em>Xpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xpath</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Invariant#getXpath()
	 * @see #getInvariant()
	 * @generated
	 */
	EAttribute getInvariant_Xpath();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Ref</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeRef
	 * @generated
	 */
	EClass getTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeRef#getName()
	 * @see #getTypeRef()
	 * @generated
	 */
	EAttribute getTypeRef_Name();

	/**
	 * Returns the meta object for the attribute list '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#getBoundParam <em>Bound Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Bound Param</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeRef#getBoundParam()
	 * @see #getTypeRef()
	 * @generated
	 */
	EAttribute getTypeRef_BoundParam();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isTakesAnyResource <em>Takes Any Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Takes Any Resource</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeRef#isTakesAnyResource()
	 * @see #getTypeRef()
	 * @generated
	 */
	EAttribute getTypeRef_TakesAnyResource();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsUnboundGeneric <em>Is Unbound Generic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unbound Generic</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsUnboundGeneric()
	 * @see #getTypeRef()
	 * @generated
	 */
	EAttribute getTypeRef_IsUnboundGeneric();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsPseudoType <em>Is Pseudo Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pseudo Type</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeRef#isIsPseudoType()
	 * @see #getTypeRef()
	 * @generated
	 */
	EAttribute getTypeRef_IsPseudoType();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn <em>Binding Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn
	 * @generated
	 */
	EClass getBindingDefn();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getId()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EAttribute getBindingDefn_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getName()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EAttribute getBindingDefn_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getBinding()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EAttribute getBindingDefn_Binding();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getStrength <em>Strength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strength</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getStrength()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EAttribute getBindingDefn_Strength();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getArtifactName <em>Artifact Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getArtifactName()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EAttribute getBindingDefn_ArtifactName();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getSource()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EAttribute getBindingDefn_Source();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getCodes <em>Codes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Codes</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getCodes()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EReference getBindingDefn_Codes();

	/**
	 * Returns the meta object for the containment reference '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotations</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getAnnotations()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EReference getBindingDefn_Annotations();

	/**
	 * Returns the meta object for the container reference '{@link org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingDefn#getContainer()
	 * @see #getBindingDefn()
	 * @generated
	 */
	EReference getBindingDefn_Container();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Mapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Mapping#getSource()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Mapping#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Details</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Mapping#getDetails()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_Details();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn <em>Resource Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ResourceDefn
	 * @generated
	 */
	EClass getResourceDefn();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getExample <em>Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Example</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getExample()
	 * @see #getResourceDefn()
	 * @generated
	 */
	EReference getResourceDefn_Example();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#isSandbox <em>Sandbox</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sandbox</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#isSandbox()
	 * @see #getResourceDefn()
	 * @generated
	 */
	EAttribute getResourceDefn_Sandbox();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getSearches <em>Searches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Searches</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#getSearches()
	 * @see #getResourceDefn()
	 * @generated
	 */
	EReference getResourceDefn_Searches();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#isFuture <em>Future</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Future</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ResourceDefn#isFuture()
	 * @see #getResourceDefn()
	 * @generated
	 */
	EAttribute getResourceDefn_Future();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.Example <em>Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Example</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Example
	 * @generated
	 */
	EClass getExample();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Example#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Example#getName()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Example#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Example#getDescription()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Example#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Example#getPath()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Example#isInBook <em>In Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Book</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Example#isInBook()
	 * @see #getExample()
	 * @generated
	 */
	EAttribute getExample_InBook();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.DefinedCode <em>Defined Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defined Code</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.DefinedCode
	 * @generated
	 */
	EClass getDefinedCode();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getCode()
	 * @see #getDefinedCode()
	 * @generated
	 */
	EAttribute getDefinedCode_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.DefinedCode#getDefinition()
	 * @see #getDefinedCode()
	 * @generated
	 */
	EAttribute getDefinedCode_Definition();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn <em>Primitive Type Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn
	 * @generated
	 */
	EClass getPrimitiveTypeDefn();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn#getPattern()
	 * @see #getPrimitiveTypeDefn()
	 * @generated
	 */
	EAttribute getPrimitiveTypeDefn_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn#getXsdtype <em>Xsdtype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xsdtype</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.PrimitiveTypeDefn#getXsdtype()
	 * @see #getPrimitiveTypeDefn()
	 * @generated
	 */
	EAttribute getPrimitiveTypeDefn_Xsdtype();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn <em>Constrained Type Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained Type Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn
	 * @generated
	 */
	EClass getConstrainedTypeDefn();

	/**
	 * Returns the meta object for the containment reference '{@link org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn#getBaseType <em>Base Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Type</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn#getBaseType()
	 * @see #getConstrainedTypeDefn()
	 * @generated
	 */
	EReference getConstrainedTypeDefn_BaseType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn#getDetails()
	 * @see #getConstrainedTypeDefn()
	 * @generated
	 */
	EReference getConstrainedTypeDefn_Details();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.TypeDefn <em>Type Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeDefn
	 * @generated
	 */
	EClass getTypeDefn();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.TypeDefn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeDefn#getName()
	 * @see #getTypeDefn()
	 * @generated
	 */
	EAttribute getTypeDefn_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.hl7.fhir.definitions.ecore.fhir.TypeDefn#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Annotations</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeDefn#getAnnotations()
	 * @see #getTypeDefn()
	 * @generated
	 */
	EReference getTypeDefn_Annotations();

	/**
	 * Returns the meta object for the reference '{@link org.hl7.fhir.definitions.ecore.fhir.TypeDefn#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.TypeDefn#getContainer()
	 * @see #getTypeDefn()
	 * @generated
	 */
	EReference getTypeDefn_Container();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn <em>Composite Type Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Type Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn
	 * @generated
	 */
	EClass getCompositeTypeDefn();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getElements()
	 * @see #getCompositeTypeDefn()
	 * @generated
	 */
	EReference getCompositeTypeDefn_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getInvariants <em>Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getInvariants()
	 * @see #getCompositeTypeDefn()
	 * @generated
	 */
	EReference getCompositeTypeDefn_Invariants();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getAllowedGenericTypes <em>Allowed Generic Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Allowed Generic Types</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn#getAllowedGenericTypes()
	 * @see #getCompositeTypeDefn()
	 * @generated
	 */
	EReference getCompositeTypeDefn_AllowedGenericTypes();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.NameScope <em>Name Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Scope</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.NameScope
	 * @generated
	 */
	EClass getNameScope();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.NameScope#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.NameScope#getBindings()
	 * @see #getNameScope()
	 * @generated
	 */
	EReference getNameScope_Bindings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.NameScope#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.NameScope#getTypes()
	 * @see #getNameScope()
	 * @generated
	 */
	EReference getNameScope_Types();

	/**
	 * Returns the meta object for the reference '{@link org.hl7.fhir.definitions.ecore.fhir.NameScope#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.NameScope#getParent()
	 * @see #getNameScope()
	 * @generated
	 */
	EReference getNameScope_Parent();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.BindingRef <em>Binding Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Ref</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingRef
	 * @generated
	 */
	EClass getBindingRef();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.BindingRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingRef#getName()
	 * @see #getBindingRef()
	 * @generated
	 */
	EAttribute getBindingRef_Name();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotations</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations
	 * @generated
	 */
	EClass getAnnotations();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getShortDefinition <em>Short Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Definition</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getShortDefinition()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_ShortDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getDefinition()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_Definition();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getComment()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirements</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getRequirements()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_Requirements();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getRimMapping <em>Rim Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rim Mapping</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getRimMapping()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_RimMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getV2Mapping <em>V2 Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>V2 Mapping</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getV2Mapping()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_V2Mapping();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getTodo <em>Todo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Todo</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getTodo()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_Todo();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.Annotations#getCommitteeNotes <em>Committee Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Committee Notes</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.Annotations#getCommitteeNotes()
	 * @see #getAnnotations()
	 * @generated
	 */
	EAttribute getAnnotations_CommitteeNotes();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn <em>Profiled Element Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profiled Element Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn
	 * @generated
	 */
	EClass getProfiledElementDefn();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#isInherited <em>Inherited</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inherited</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#isInherited()
	 * @see #getProfiledElementDefn()
	 * @generated
	 */
	EAttribute getProfiledElementDefn_Inherited();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getAggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregation</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getAggregation()
	 * @see #getProfiledElementDefn()
	 * @generated
	 */
	EAttribute getProfiledElementDefn_Aggregation();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getFixedValue <em>Fixed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Value</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getFixedValue()
	 * @see #getProfiledElementDefn()
	 * @generated
	 */
	EAttribute getProfiledElementDefn_FixedValue();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getTargetUri <em>Target Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Uri</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getTargetUri()
	 * @see #getProfiledElementDefn()
	 * @generated
	 */
	EAttribute getProfiledElementDefn_TargetUri();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getProfileName <em>Profile Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfiledElementDefn#getProfileName()
	 * @see #getProfiledElementDefn()
	 * @generated
	 */
	EAttribute getProfiledElementDefn_ProfileName();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.InvariantRef <em>Invariant Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant Ref</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.InvariantRef
	 * @generated
	 */
	EClass getInvariantRef();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.InvariantRef#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.InvariantRef#getName()
	 * @see #getInvariantRef()
	 * @generated
	 */
	EAttribute getInvariantRef_Name();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.EventDefn <em>Event Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventDefn
	 * @generated
	 */
	EClass getEventDefn();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.EventDefn#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventDefn#getCode()
	 * @see #getEventDefn()
	 * @generated
	 */
	EAttribute getEventDefn_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.EventDefn#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventDefn#getDefinition()
	 * @see #getEventDefn()
	 * @generated
	 */
	EAttribute getEventDefn_Definition();

	/**
	 * Returns the meta object for the attribute list '{@link org.hl7.fhir.definitions.ecore.fhir.EventDefn#getFollowUps <em>Follow Ups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Follow Ups</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventDefn#getFollowUps()
	 * @see #getEventDefn()
	 * @generated
	 */
	EAttribute getEventDefn_FollowUps();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.EventDefn#getUsages <em>Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usages</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventDefn#getUsages()
	 * @see #getEventDefn()
	 * @generated
	 */
	EReference getEventDefn_Usages();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.EventUsage <em>Event Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Usage</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventUsage
	 * @generated
	 */
	EClass getEventUsage();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.EventUsage#getNotes <em>Notes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Notes</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventUsage#getNotes()
	 * @see #getEventUsage()
	 * @generated
	 */
	EAttribute getEventUsage_Notes();

	/**
	 * Returns the meta object for the attribute list '{@link org.hl7.fhir.definitions.ecore.fhir.EventUsage#getRequestResources <em>Request Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Request Resources</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventUsage#getRequestResources()
	 * @see #getEventUsage()
	 * @generated
	 */
	EAttribute getEventUsage_RequestResources();

	/**
	 * Returns the meta object for the attribute list '{@link org.hl7.fhir.definitions.ecore.fhir.EventUsage#getRequestAggregations <em>Request Aggregations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Request Aggregations</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventUsage#getRequestAggregations()
	 * @see #getEventUsage()
	 * @generated
	 */
	EAttribute getEventUsage_RequestAggregations();

	/**
	 * Returns the meta object for the attribute list '{@link org.hl7.fhir.definitions.ecore.fhir.EventUsage#getResponseResources <em>Response Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Response Resources</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventUsage#getResponseResources()
	 * @see #getEventUsage()
	 * @generated
	 */
	EAttribute getEventUsage_ResponseResources();

	/**
	 * Returns the meta object for the attribute list '{@link org.hl7.fhir.definitions.ecore.fhir.EventUsage#getResponseAggregations <em>Response Aggregations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Response Aggregations</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.EventUsage#getResponseAggregations()
	 * @see #getEventUsage()
	 * @generated
	 */
	EAttribute getEventUsage_ResponseAggregations();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.ProfileDefn <em>Profile Defn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile Defn</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfileDefn
	 * @generated
	 */
	EClass getProfileDefn();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ProfileDefn#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfileDefn#getResources()
	 * @see #getProfileDefn()
	 * @generated
	 */
	EReference getProfileDefn_Resources();

	/**
	 * Returns the meta object for the containment reference list '{@link org.hl7.fhir.definitions.ecore.fhir.ProfileDefn#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadata</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.ProfileDefn#getMetadata()
	 * @see #getProfileDefn()
	 * @generated
	 */
	EReference getProfileDefn_Metadata();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.MetaDataItem <em>Meta Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data Item</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.MetaDataItem
	 * @generated
	 */
	EClass getMetaDataItem();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.MetaDataItem#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.MetaDataItem#getName()
	 * @see #getMetaDataItem()
	 * @generated
	 */
	EAttribute getMetaDataItem_Name();

	/**
	 * Returns the meta object for the attribute list '{@link org.hl7.fhir.definitions.ecore.fhir.MetaDataItem#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.MetaDataItem#getValue()
	 * @see #getMetaDataItem()
	 * @generated
	 */
	EAttribute getMetaDataItem_Value();

	/**
	 * Returns the meta object for class '{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter <em>Search Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search Parameter</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchParameter
	 * @generated
	 */
	EClass getSearchParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getName()
	 * @see #getSearchParameter()
	 * @generated
	 */
	EAttribute getSearchParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getDescription()
	 * @see #getSearchParameter()
	 * @generated
	 */
	EAttribute getSearchParameter_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchParameter#getType()
	 * @see #getSearchParameter()
	 * @generated
	 */
	EAttribute getSearchParameter_Type();

	/**
	 * Returns the meta object for enum '{@link org.hl7.fhir.definitions.ecore.fhir.BindingType <em>Binding Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binding Type</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingType
	 * @generated
	 */
	EEnum getBindingType();

	/**
	 * Returns the meta object for enum '{@link org.hl7.fhir.definitions.ecore.fhir.BindingStrength <em>Binding Strength</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Binding Strength</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.BindingStrength
	 * @generated
	 */
	EEnum getBindingStrength();

	/**
	 * Returns the meta object for enum '{@link org.hl7.fhir.definitions.ecore.fhir.SearchType <em>Search Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Search Type</em>'.
	 * @see org.hl7.fhir.definitions.ecore.fhir.SearchType
	 * @generated
	 */
	EEnum getSearchType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FhirFactory getFhirFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl <em>Definitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.DefinitionsImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getDefinitions()
		 * @generated
		 */
		EClass DEFINITIONS = eINSTANCE.getDefinitions();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITIONS__DATE = eINSTANCE.getDefinitions_Date();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITIONS__VERSION = eINSTANCE.getDefinitions_Version();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINITIONS__EVENTS = eINSTANCE.getDefinitions_Events();

		/**
		 * The meta object literal for the '<em><b>Profiles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINITIONS__PROFILES = eINSTANCE.getDefinitions_Profiles();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl <em>Element Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ElementDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getElementDefn()
		 * @generated
		 */
		EClass ELEMENT_DEFN = eINSTANCE.getElementDefn();

		/**
		 * The meta object literal for the '<em><b>Max Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DEFN__MAX_CARDINALITY = eINSTANCE.getElementDefn_MaxCardinality();

		/**
		 * The meta object literal for the '<em><b>Min Cardinality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DEFN__MIN_CARDINALITY = eINSTANCE.getElementDefn_MinCardinality();

		/**
		 * The meta object literal for the '<em><b>Allow DAR</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DEFN__ALLOW_DAR = eINSTANCE.getElementDefn_AllowDAR();

		/**
		 * The meta object literal for the '<em><b>Must Understand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DEFN__MUST_UNDERSTAND = eINSTANCE.getElementDefn_MustUnderstand();

		/**
		 * The meta object literal for the '<em><b>Invariant</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_DEFN__INVARIANT = eINSTANCE.getElementDefn_Invariant();

		/**
		 * The meta object literal for the '<em><b>Must Support</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DEFN__MUST_SUPPORT = eINSTANCE.getElementDefn_MustSupport();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_DEFN__TYPES = eINSTANCE.getElementDefn_Types();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_DEFN__BINDING = eINSTANCE.getElementDefn_Binding();

		/**
		 * The meta object literal for the '<em><b>Annotation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_DEFN__ANNOTATION = eINSTANCE.getElementDefn_Annotation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DEFN__NAME = eINSTANCE.getElementDefn_Name();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_DEFN__MAPPINGS = eINSTANCE.getElementDefn_Mappings();

		/**
		 * The meta object literal for the '<em><b>Example Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DEFN__EXAMPLE_VALUE = eINSTANCE.getElementDefn_ExampleValue();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_DEFN__ELEMENTS = eINSTANCE.getElementDefn_Elements();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_DEFN__CONTENT = eINSTANCE.getElementDefn_Content();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.InvariantImpl <em>Invariant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.InvariantImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getInvariant()
		 * @generated
		 */
		EClass INVARIANT = eINSTANCE.getInvariant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT__NAME = eINSTANCE.getInvariant_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT__DESCRIPTION = eINSTANCE.getInvariant_Description();

		/**
		 * The meta object literal for the '<em><b>Human</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT__HUMAN = eINSTANCE.getInvariant_Human();

		/**
		 * The meta object literal for the '<em><b>Ocl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT__OCL = eINSTANCE.getInvariant_Ocl();

		/**
		 * The meta object literal for the '<em><b>Xpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT__XPATH = eINSTANCE.getInvariant_Xpath();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl <em>Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.TypeRefImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getTypeRef()
		 * @generated
		 */
		EClass TYPE_REF = eINSTANCE.getTypeRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_REF__NAME = eINSTANCE.getTypeRef_Name();

		/**
		 * The meta object literal for the '<em><b>Bound Param</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_REF__BOUND_PARAM = eINSTANCE.getTypeRef_BoundParam();

		/**
		 * The meta object literal for the '<em><b>Takes Any Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_REF__TAKES_ANY_RESOURCE = eINSTANCE.getTypeRef_TakesAnyResource();

		/**
		 * The meta object literal for the '<em><b>Is Unbound Generic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_REF__IS_UNBOUND_GENERIC = eINSTANCE.getTypeRef_IsUnboundGeneric();

		/**
		 * The meta object literal for the '<em><b>Is Pseudo Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_REF__IS_PSEUDO_TYPE = eINSTANCE.getTypeRef_IsPseudoType();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.BindingDefnImpl <em>Binding Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.BindingDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingDefn()
		 * @generated
		 */
		EClass BINDING_DEFN = eINSTANCE.getBindingDefn();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_DEFN__ID = eINSTANCE.getBindingDefn_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_DEFN__NAME = eINSTANCE.getBindingDefn_Name();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_DEFN__BINDING = eINSTANCE.getBindingDefn_Binding();

		/**
		 * The meta object literal for the '<em><b>Strength</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_DEFN__STRENGTH = eINSTANCE.getBindingDefn_Strength();

		/**
		 * The meta object literal for the '<em><b>Artifact Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_DEFN__ARTIFACT_NAME = eINSTANCE.getBindingDefn_ArtifactName();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_DEFN__SOURCE = eINSTANCE.getBindingDefn_Source();

		/**
		 * The meta object literal for the '<em><b>Codes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_DEFN__CODES = eINSTANCE.getBindingDefn_Codes();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_DEFN__ANNOTATIONS = eINSTANCE.getBindingDefn_Annotations();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_DEFN__CONTAINER = eINSTANCE.getBindingDefn_Container();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.MappingImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__SOURCE = eINSTANCE.getMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__DETAILS = eINSTANCE.getMapping_Details();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl <em>Resource Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ResourceDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getResourceDefn()
		 * @generated
		 */
		EClass RESOURCE_DEFN = eINSTANCE.getResourceDefn();

		/**
		 * The meta object literal for the '<em><b>Example</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEFN__EXAMPLE = eINSTANCE.getResourceDefn_Example();

		/**
		 * The meta object literal for the '<em><b>Sandbox</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_DEFN__SANDBOX = eINSTANCE.getResourceDefn_Sandbox();

		/**
		 * The meta object literal for the '<em><b>Searches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_DEFN__SEARCHES = eINSTANCE.getResourceDefn_Searches();

		/**
		 * The meta object literal for the '<em><b>Future</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_DEFN__FUTURE = eINSTANCE.getResourceDefn_Future();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ExampleImpl <em>Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ExampleImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getExample()
		 * @generated
		 */
		EClass EXAMPLE = eINSTANCE.getExample();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__NAME = eINSTANCE.getExample_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__DESCRIPTION = eINSTANCE.getExample_Description();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__PATH = eINSTANCE.getExample_Path();

		/**
		 * The meta object literal for the '<em><b>In Book</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXAMPLE__IN_BOOK = eINSTANCE.getExample_InBook();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.DefinedCodeImpl <em>Defined Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.DefinedCodeImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getDefinedCode()
		 * @generated
		 */
		EClass DEFINED_CODE = eINSTANCE.getDefinedCode();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINED_CODE__CODE = eINSTANCE.getDefinedCode_Code();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINED_CODE__DEFINITION = eINSTANCE.getDefinedCode_Definition();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.PrimitiveTypeDefnImpl <em>Primitive Type Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.PrimitiveTypeDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getPrimitiveTypeDefn()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_DEFN = eINSTANCE.getPrimitiveTypeDefn();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_DEFN__PATTERN = eINSTANCE.getPrimitiveTypeDefn_Pattern();

		/**
		 * The meta object literal for the '<em><b>Xsdtype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE_DEFN__XSDTYPE = eINSTANCE.getPrimitiveTypeDefn_Xsdtype();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl <em>Constrained Type Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ConstrainedTypeDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getConstrainedTypeDefn()
		 * @generated
		 */
		EClass CONSTRAINED_TYPE_DEFN = eINSTANCE.getConstrainedTypeDefn();

		/**
		 * The meta object literal for the '<em><b>Base Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_TYPE_DEFN__BASE_TYPE = eINSTANCE.getConstrainedTypeDefn_BaseType();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_TYPE_DEFN__DETAILS = eINSTANCE.getConstrainedTypeDefn_Details();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.TypeDefnImpl <em>Type Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.TypeDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getTypeDefn()
		 * @generated
		 */
		EClass TYPE_DEFN = eINSTANCE.getTypeDefn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_DEFN__NAME = eINSTANCE.getTypeDefn_Name();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DEFN__ANNOTATIONS = eINSTANCE.getTypeDefn_Annotations();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DEFN__CONTAINER = eINSTANCE.getTypeDefn_Container();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl <em>Composite Type Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.CompositeTypeDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getCompositeTypeDefn()
		 * @generated
		 */
		EClass COMPOSITE_TYPE_DEFN = eINSTANCE.getCompositeTypeDefn();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_TYPE_DEFN__ELEMENTS = eINSTANCE.getCompositeTypeDefn_Elements();

		/**
		 * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_TYPE_DEFN__INVARIANTS = eINSTANCE.getCompositeTypeDefn_Invariants();

		/**
		 * The meta object literal for the '<em><b>Allowed Generic Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_TYPE_DEFN__ALLOWED_GENERIC_TYPES = eINSTANCE.getCompositeTypeDefn_AllowedGenericTypes();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.NameScope <em>Name Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.NameScope
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getNameScope()
		 * @generated
		 */
		EClass NAME_SCOPE = eINSTANCE.getNameScope();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_SCOPE__BINDINGS = eINSTANCE.getNameScope_Bindings();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_SCOPE__TYPES = eINSTANCE.getNameScope_Types();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_SCOPE__PARENT = eINSTANCE.getNameScope_Parent();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.BindingRefImpl <em>Binding Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.BindingRefImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingRef()
		 * @generated
		 */
		EClass BINDING_REF = eINSTANCE.getBindingRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_REF__NAME = eINSTANCE.getBindingRef_Name();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.AnnotationsImpl <em>Annotations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.AnnotationsImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getAnnotations()
		 * @generated
		 */
		EClass ANNOTATIONS = eINSTANCE.getAnnotations();

		/**
		 * The meta object literal for the '<em><b>Short Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__SHORT_DEFINITION = eINSTANCE.getAnnotations_ShortDefinition();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__DEFINITION = eINSTANCE.getAnnotations_Definition();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__COMMENT = eINSTANCE.getAnnotations_Comment();

		/**
		 * The meta object literal for the '<em><b>Requirements</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__REQUIREMENTS = eINSTANCE.getAnnotations_Requirements();

		/**
		 * The meta object literal for the '<em><b>Rim Mapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__RIM_MAPPING = eINSTANCE.getAnnotations_RimMapping();

		/**
		 * The meta object literal for the '<em><b>V2 Mapping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__V2_MAPPING = eINSTANCE.getAnnotations_V2Mapping();

		/**
		 * The meta object literal for the '<em><b>Todo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__TODO = eINSTANCE.getAnnotations_Todo();

		/**
		 * The meta object literal for the '<em><b>Committee Notes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATIONS__COMMITTEE_NOTES = eINSTANCE.getAnnotations_CommitteeNotes();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ProfiledElementDefnImpl <em>Profiled Element Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ProfiledElementDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getProfiledElementDefn()
		 * @generated
		 */
		EClass PROFILED_ELEMENT_DEFN = eINSTANCE.getProfiledElementDefn();

		/**
		 * The meta object literal for the '<em><b>Inherited</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILED_ELEMENT_DEFN__INHERITED = eINSTANCE.getProfiledElementDefn_Inherited();

		/**
		 * The meta object literal for the '<em><b>Aggregation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILED_ELEMENT_DEFN__AGGREGATION = eINSTANCE.getProfiledElementDefn_Aggregation();

		/**
		 * The meta object literal for the '<em><b>Fixed Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILED_ELEMENT_DEFN__FIXED_VALUE = eINSTANCE.getProfiledElementDefn_FixedValue();

		/**
		 * The meta object literal for the '<em><b>Target Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILED_ELEMENT_DEFN__TARGET_URI = eINSTANCE.getProfiledElementDefn_TargetUri();

		/**
		 * The meta object literal for the '<em><b>Profile Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILED_ELEMENT_DEFN__PROFILE_NAME = eINSTANCE.getProfiledElementDefn_ProfileName();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.InvariantRefImpl <em>Invariant Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.InvariantRefImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getInvariantRef()
		 * @generated
		 */
		EClass INVARIANT_REF = eINSTANCE.getInvariantRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVARIANT_REF__NAME = eINSTANCE.getInvariantRef_Name();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.EventDefnImpl <em>Event Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.EventDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getEventDefn()
		 * @generated
		 */
		EClass EVENT_DEFN = eINSTANCE.getEventDefn();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_DEFN__CODE = eINSTANCE.getEventDefn_Code();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_DEFN__DEFINITION = eINSTANCE.getEventDefn_Definition();

		/**
		 * The meta object literal for the '<em><b>Follow Ups</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_DEFN__FOLLOW_UPS = eINSTANCE.getEventDefn_FollowUps();

		/**
		 * The meta object literal for the '<em><b>Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_DEFN__USAGES = eINSTANCE.getEventDefn_Usages();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.EventUsageImpl <em>Event Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.EventUsageImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getEventUsage()
		 * @generated
		 */
		EClass EVENT_USAGE = eINSTANCE.getEventUsage();

		/**
		 * The meta object literal for the '<em><b>Notes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_USAGE__NOTES = eINSTANCE.getEventUsage_Notes();

		/**
		 * The meta object literal for the '<em><b>Request Resources</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_USAGE__REQUEST_RESOURCES = eINSTANCE.getEventUsage_RequestResources();

		/**
		 * The meta object literal for the '<em><b>Request Aggregations</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_USAGE__REQUEST_AGGREGATIONS = eINSTANCE.getEventUsage_RequestAggregations();

		/**
		 * The meta object literal for the '<em><b>Response Resources</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_USAGE__RESPONSE_RESOURCES = eINSTANCE.getEventUsage_ResponseResources();

		/**
		 * The meta object literal for the '<em><b>Response Aggregations</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_USAGE__RESPONSE_AGGREGATIONS = eINSTANCE.getEventUsage_ResponseAggregations();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.ProfileDefnImpl <em>Profile Defn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.ProfileDefnImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getProfileDefn()
		 * @generated
		 */
		EClass PROFILE_DEFN = eINSTANCE.getProfileDefn();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE_DEFN__RESOURCES = eINSTANCE.getProfileDefn_Resources();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILE_DEFN__METADATA = eINSTANCE.getProfileDefn_Metadata();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.MetaDataItemImpl <em>Meta Data Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.MetaDataItemImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getMetaDataItem()
		 * @generated
		 */
		EClass META_DATA_ITEM = eINSTANCE.getMetaDataItem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA_ITEM__NAME = eINSTANCE.getMetaDataItem_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA_ITEM__VALUE = eINSTANCE.getMetaDataItem_Value();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.impl.SearchParameterImpl <em>Search Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.SearchParameterImpl
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getSearchParameter()
		 * @generated
		 */
		EClass SEARCH_PARAMETER = eINSTANCE.getSearchParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_PARAMETER__NAME = eINSTANCE.getSearchParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_PARAMETER__DESCRIPTION = eINSTANCE.getSearchParameter_Description();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEARCH_PARAMETER__TYPE = eINSTANCE.getSearchParameter_Type();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.BindingType <em>Binding Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.BindingType
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingType()
		 * @generated
		 */
		EEnum BINDING_TYPE = eINSTANCE.getBindingType();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.BindingStrength <em>Binding Strength</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.BindingStrength
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getBindingStrength()
		 * @generated
		 */
		EEnum BINDING_STRENGTH = eINSTANCE.getBindingStrength();

		/**
		 * The meta object literal for the '{@link org.hl7.fhir.definitions.ecore.fhir.SearchType <em>Search Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hl7.fhir.definitions.ecore.fhir.SearchType
		 * @see org.hl7.fhir.definitions.ecore.fhir.impl.FhirPackageImpl#getSearchType()
		 * @generated
		 */
		EEnum SEARCH_TYPE = eINSTANCE.getSearchType();

	}

} //FhirPackage
