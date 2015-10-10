package br.ufc.mdcc.pargo.safe.framework.workflow;

import java.util.List;

public class HShelfWorkflowFacade {

	private HShelfWorkflow workflow;
	
	
	public HShelfWorkflowFacade(HShelfWorkflow workflow) {
		this.workflow = workflow;
	}
	
	public void resolve(String contract, String compID){
		this.workflow.resolve(contract, compID);
	}
	
	public void deploy(String compID){
		this.workflow.deploy(compID);
	}
	
	public void instantiate(String compID){
		this.workflow.instantiate(compID);
	}
	
	public void compute(String method, String portName, List<HShelfArgValueType> argValueTypeList){
		this.workflow.compute(method, portName,argValueTypeList);
	}
}
