package br.ufc.mdcc.pargo.safe.sample.application.ports.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.MontageShelfComputationComponent;

public class GoPortTask extends HShelfTaskPort{

	private MontageShelfComputationComponent component;
	
	public GoPortTask(MontageShelfComputationComponent component) {
		this.component = component;
	}
	
	public void go(){
		this.component.go();
	}
}
