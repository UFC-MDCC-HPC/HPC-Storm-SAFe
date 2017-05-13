package br.ufc.mdcc.pargo.safe.v6.impl;

import java.util.List;
import java.util.Random;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.v6.ISAFeActionFuture;
import br.ufc.mdcc.pargo.safe.v6.ISAFeTaskPort;

public class SAFeWorkflow extends SAFeComponent{
	
	private ISAFeSWLFlowParser flow;
	private SAFeFramework framework;

	public void setSAFeFramework(SAFeFramework framework){
		this.framework = framework;
	}
	
	public void setFlow(ISAFeSWLFlowParser flow) {
		this.flow = flow;
		flow.setWorkflow(this);
	}
	
	public void go(){
		this.flow.run();
	}
	
	public void invoke(String portId,String actionId) {
	
		List<ISAFeTaskPort> ports = this.framework.lookUpActionPort("workflow", portId);
		for(ISAFeTaskPort port:ports){
			port.invoke(actionId);
		}
	}

	
	public void invoke(String portId, String actionId, ISAFeActionFuture actionFuture) {
		
		Random rand = new Random();
		int  n = rand.nextInt(2);
		actionFuture.setValue(n);
	}

}
