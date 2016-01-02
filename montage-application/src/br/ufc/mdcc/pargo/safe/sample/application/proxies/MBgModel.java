package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.TblPortProvides;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.TblPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MBgModel extends MontageShelfComputationComponent{

	private TblPortProvides tblPortProvides;
	
	private TblPortUses tblPortUsesA;
	private TblPortUses tblPortUsesB;
	
	private GoPortTask goPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		// TODO Auto-generated method stub
		
	}

}
