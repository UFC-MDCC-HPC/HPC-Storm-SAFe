package br.ufc.mapreduce.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class DataSinkSTUB extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
	}

}
