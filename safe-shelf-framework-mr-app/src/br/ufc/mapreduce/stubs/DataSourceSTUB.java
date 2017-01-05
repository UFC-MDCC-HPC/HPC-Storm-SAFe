package br.ufc.mapreduce.stubs;

import br.ufc.mapreduce.stubs.ports.env.MRStubProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class DataSourceSTUB extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		MRStubProvidesPort provides = new MRStubProvidesPort();provides.setName("source-provides");
		try {
			this.services.setProvidesPort(provides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
