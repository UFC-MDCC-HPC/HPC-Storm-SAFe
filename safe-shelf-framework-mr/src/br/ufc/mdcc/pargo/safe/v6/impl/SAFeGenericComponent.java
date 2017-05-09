package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServices;

public class SAFeGenericComponent implements ISAFeComponent{

	protected ISAFeServices services;
	protected String componentId;
	
	@Override
	public void setServices(ISAFeServices services) {
		this.services = services;
		
	}

	@Override
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	@Override
	public ISAFeServices getServices() {
		return this.services;
	}

	@Override
	public String getComponentId() {
		return this.componentId;
	}

}
