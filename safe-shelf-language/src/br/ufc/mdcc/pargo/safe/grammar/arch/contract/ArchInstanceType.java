package br.ufc.mdcc.pargo.safe.grammar.arch.contract;

import java.util.ArrayList;
import java.util.List;

public class ArchInstanceType {

	private String instanceRef;
	private ArchComponentFunctorApplicationType componentFunctorApplication;
	private List<ArchUnitMappingType> unitMappingList;
	private List<ArchFacetAddressType> facetAddresList;
	
	public ArchInstanceType() {
		this.unitMappingList = new ArrayList<ArchUnitMappingType>();
		this.facetAddresList = new ArrayList<ArchFacetAddressType>();
	}

	public String getInstanceRef() {
		return instanceRef;
	}

	public void setInstanceRef(String instanceRef) {
		this.instanceRef = instanceRef;
	}

	public ArchComponentFunctorApplicationType getComponentFunctorApplication() {
		return componentFunctorApplication;
	}

	public void setComponentFunctorApplication(
			ArchComponentFunctorApplicationType componentFunctorApplication) {
		this.componentFunctorApplication = componentFunctorApplication;
	}
	
	public void addUnitMappingType(ArchUnitMappingType unitMappingType){
		this.unitMappingList.add(unitMappingType);
	}
	
	public void addFacetAddressType(ArchFacetAddressType facetAddressType){
		this.facetAddresList.add(facetAddressType);
	}

	public List<ArchUnitMappingType> getUnitMappingList() {
		return unitMappingList;
	}

	public List<ArchFacetAddressType> getFacetAddresList() {
		return facetAddresList;
	}

	@Override
	public String toString() {
		return "ArchInstanceType [instanceRef=" + instanceRef
				+ ", componentFunctorApplication="
				+ componentFunctorApplication + ", unitMappingList="
				+ unitMappingList + ", facetAddresList=" + facetAddresList
				+ "]";
	}
	
}
