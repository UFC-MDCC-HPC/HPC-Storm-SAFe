package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.IHPCStormApplicationServices;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormApplicationServices services;
	private HPCStormSAFeSWL saFeSWL;
	private HPCStormWorkflowEngine engine;
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		
	}
	
	public void setServices(IHPCStormApplicationServices services){
		this.services = services;
	}
	
}
