package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;


public class HShelfLifeCyclePort extends HShelfTaskPort{

	private HShelfComponent component;
	
	public HShelfLifeCyclePort(HShelfComponent component){
		this.component = component;
	}
	
	public void resolve(){
		this.component.resolve();
	}
	
	public void deploy(){
		this.component.deploy();
	}
	
	public void instantiate(){
		this.component.instantiate();
	}
}
