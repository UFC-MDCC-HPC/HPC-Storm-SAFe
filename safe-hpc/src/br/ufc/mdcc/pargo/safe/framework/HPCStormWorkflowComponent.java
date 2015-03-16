package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.IHPCStormServices;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormServices services;
	private HPCStormSAFeSWL saFeSWL;
	private HPCStormWorkflowEngine engine;
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		
	}
	
	public void setServices(IHPCStormServices services){
		this.services = services;
	}
	
}
