package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.DirPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.TblPortProvides;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MImgtbl extends MontageShelfComputationComponent{

	private TblPortProvides TblPortProvides;
	private DirPortUses dirPortUses;
	private GoPortTask goPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
	}

}
