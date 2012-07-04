package org.hl7.fhir.definitions.ecore.fhir.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.hl7.fhir.definitions.ecore.fhir.BindingDefn;
import org.hl7.fhir.definitions.ecore.fhir.CompositeTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.ConstrainedTypeDefn;
import org.hl7.fhir.definitions.ecore.fhir.NameScope;
import org.hl7.fhir.definitions.ecore.fhir.ResourceDefn;
import org.hl7.fhir.definitions.ecore.fhir.TypeDefn;

public class NameScopeImpl {

	private NameScope scope;
	
	
	public NameScopeImpl( NameScope scope )
	{
		this.scope = scope;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * List all CompositeTypes that are defined in this scope. This excludes the types
	 * inherited from parent scopes.
	 * <!-- end-user-doc -->
	 */
	public EList<CompositeTypeDefn> getLocalCompositeTypes() {
		EList<CompositeTypeDefn> result = new BasicEList<CompositeTypeDefn>();
		
		for( TypeDefn t : scope.getTypes() )
		{		
			if( t.isComposite() )
				result.add((CompositeTypeDefn)t);
		}
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<ConstrainedTypeDefn> getLocalConstrainedTypes() {
		EList<ConstrainedTypeDefn> result = new BasicEList<ConstrainedTypeDefn>();
		
		for( TypeDefn t : scope.getTypes() )
		{		
			if( t.isConstrained() )
				result.add((ConstrainedTypeDefn)t);
		}
		
		return result;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<ResourceDefn> getLocalResources() {
		EList<ResourceDefn> result = new BasicEList<ResourceDefn>();
		
		for( TypeDefn t : scope.getTypes() )
		{		
			if( t.isResource() )
				result.add((ResourceDefn)t);
		}
		
		return result;
	}

	
	public TypeDefn resolveType( String name ) {
		for( TypeDefn type : scope.getTypes() )
		{
			if( type.getName().equals(name) )
				return type;
		}
		
		if( scope.getContainingScope() != null )
			return scope.getContainingScope().resolveType(name);
		else
			return null;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public BindingDefn resolveBinding( String name ) {
		for( BindingDefn binding : scope.getBindings() )
		{
			if( binding.getName().equals(name) )
				return binding;
		}
		
		if( scope.getContainingScope() != null )
			return scope.getContainingScope().resolveBinding(name);
		else
			return null;
	}

}
