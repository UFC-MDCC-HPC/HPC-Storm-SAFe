package br.ufc.mdcc.pargo.safe.framework.workflow;

import br.ufc.mdcc.pargo.safe.framework.port.IHShelfActionFuture;



public class HShelfWorkflowFacade {

	private HShelfWorkflow workflow;
	
	
	public HShelfWorkflowFacade(HShelfWorkflow workflow) {
		this.workflow = workflow;
	}
	
	public void resolve(String compID){
		this.workflow.resolve(compID);
	}
	
	public void deploy(String compID){
		this.workflow.deploy(compID);
	}
	
	public void instantiate(String compID){
		this.workflow.instantiate(compID);
	}
	
	public Object compute(String method, String portName){
		return this.workflow.compute(method, portName);
	}
	
	public IHShelfActionFuture computeActionFuture(String method, String portName){
		return this.workflow.computeActionFuture(method, portName);
	}
	
	public void connect(String compID){
		this.workflow.connect(compID);
	}
}
