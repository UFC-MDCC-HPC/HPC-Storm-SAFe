package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.DirPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.HdrPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.TblPortProvides;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MProjExec extends MontageShelfComputationComponent{

	private TblPortProvides TblPortProvides;
	
	private DirPortUses dirPortUsesIn;
	private DirPortUses dirPortUsesOut;
	private HdrPortUses hdrPortUses;
	private GoPortTask goPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		// TODO Auto-generated method stub
		
	}

}
