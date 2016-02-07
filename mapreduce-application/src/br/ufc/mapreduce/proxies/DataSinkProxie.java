package br.ufc.mapreduce.proxies;

import br.ufc.mapreduce.ports.env.MRPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class DataSinkProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		MRPort mr = new MRPort();
		mr.setName("sink-provides");
		try {
			this.services.setProvidesPort(mr);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
