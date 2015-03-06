package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.IHPCStormApplicationServices;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLParser;

public class HPCStormWorkflowComponent {

	private IHPCStormApplicationServices services;
	private HPCStormSAFeSWL saFeSWL;
	private SAFeSWLParser safeSWLParser;
	private HPCStormWorkflowEngine engine;
	
	public HPCStormWorkflowComponent() {

		this.safeSWLParser = new SAFeSWLParser();		
		this.engine = new HPCStormWorkflowEngine();
		
	}
	
	public void setServices(IHPCStormApplicationServices services){
		this.services = services;
	}
	
}
