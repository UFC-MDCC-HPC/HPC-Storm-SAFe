package br.ufc.mdcc.pargo.safe.grammar.arch.contract;

import java.util.ArrayList;
import java.util.List;

public class ArchComponentFunctorApplicationType {

	private String componentRef;
	private List<ArchContextArgumentType> contextArgumentList;
	
	public ArchComponentFunctorApplicationType() {
		this.contextArgumentList = new ArrayList<ArchContextArgumentType>();
	}

	public String getComponentRef() {
		return componentRef;
	}

	public void setComponentRef(String componentRef) {
		this.componentRef = componentRef;
	}
	
	public void addContextArgument(ArchContextArgumentType contextArgument){
		this.contextArgumentList.add(contextArgument);
	}

	public List<ArchContextArgumentType> getContextArgumentList() {
		return contextArgumentList;
	}

	@Override
	public String toString() {
		return "ArchComponentFunctorApplicationType [componentRef="
				+ componentRef + ", contextArgumentList=" + contextArgumentList
				+ "]";
	}
	
}
