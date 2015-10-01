package br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application.proxies;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class ComponentClientProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		ClientGoPortProxie go = new ClientGoPortProxie();
		go.setName("go-client");
		ClientOperationPortProxie oper = new ClientOperationPortProxie();
		oper.setName("oper-client");
		
		try {
			this.services.setProvidesPort(go);
			this.services.setProvidesPort(oper);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
