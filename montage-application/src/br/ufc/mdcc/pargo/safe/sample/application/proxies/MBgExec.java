package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.DirPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.TblPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MBgExec extends MontageShelfComputationComponent{

	private TblPortUses tblPortUsesA;
	private TblPortUses tblPortUsesB;
	
	private DirPortUses dirPortUsesIn;
	private DirPortUses dirPortUsesOut;
	
	private GoPortTask goPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		// TODO Auto-generated method stub
		
	}

}
