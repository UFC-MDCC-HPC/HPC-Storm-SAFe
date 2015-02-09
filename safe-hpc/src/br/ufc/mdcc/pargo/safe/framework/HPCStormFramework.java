package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;




public class HPCStormFramework {

	private HPCStormApplicationFramework applicationComponent;
	private HPCStormWorkflowComponent workflowComponent;
	
	public HPCStormFramework(HPCStormApplicationFramework application,
							  HPCStormWorkflowComponent workflow){
		this.applicationComponent = application;
		this.workflowComponent = workflow;
	}
	
}
