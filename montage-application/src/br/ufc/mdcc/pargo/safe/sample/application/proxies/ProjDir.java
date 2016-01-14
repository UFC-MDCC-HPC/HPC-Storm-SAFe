package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.DirPortProvides;

public class ProjDir extends HShelfComponent{

	private DirPortProvides dirPortProvides;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.dirPortProvides = new DirPortProvides();
		this.dirPortProvides.setName("proj-dir-port");
		//GET VALUE FROM WS.GET
		String projValue = "projDir";
		this.dirPortProvides.setValue(projValue);
		try {
			this.services.setProvidesPort(this.dirPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
