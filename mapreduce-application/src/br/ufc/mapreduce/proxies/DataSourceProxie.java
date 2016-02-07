package br.ufc.mapreduce.proxies;

import br.ufc.mapreduce.ports.env.MRPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class DataSourceProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		MRPort mr = new MRPort();
		mr.setChunk("SOURCE");
		mr.setName("source-provides");
		try {
			this.services.setProvidesPort(mr);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
