package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServices;

public class SAFeComponent implements ISAFeComponent{

	private ISAFeServices services;
	private String componentId;
	
	@Override
	public void setServices(ISAFeServices services) {
		this.services = services;
	}

	@Override
	public void setComponentId(String componentId) {
		this.componentId = componentId;
		
	}
	
	public ISAFeServices getServices() {
		return services;
	}

	public String getComponentId() {
		return componentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((componentId == null) ? 0 : componentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SAFeComponent other = (SAFeComponent) obj;
		if (componentId == null) {
			if (other.componentId != null)
				return false;
		} else if (!componentId.equals(other.componentId))
			return false;
		return true;
	}
	
	

}
