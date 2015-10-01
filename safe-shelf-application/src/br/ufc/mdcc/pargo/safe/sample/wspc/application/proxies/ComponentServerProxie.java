package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class ComponentServerProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services  = services;
		
		ServerGoPortProxie go = new ServerGoPortProxie();
		go.setName("go-server");
		ServerOperationPortProxie oper = new ServerOperationPortProxie();
		oper.setName("oper-server");
		
		
		try {
			this.services.setProvidesPort(go);
			this.services.setProvidesPort(oper);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
