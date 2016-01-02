package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.FitsPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.JpgPortProvides;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MJpeg extends MontageShelfComputationComponent{

	private JpgPortProvides jpgPortProvides;
	private FitsPortUses fitsPortUses;
	private GoPortTask GoPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		// TODO Auto-generated method stub
		
	}

}
