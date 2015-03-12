package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.framework.HPCStormWorkflowComponent;
import br.ufc.mdcc.pargo.safe.framework.IHPCStormWorkflowComponent;

public class HPCStormWorkflowFactory {
	
	private static IHPCStormWorkflowComponent workflowComponent;
	
	public static IHPCStormWorkflowComponent createWorkflowComponent(){
		if(workflowComponent==null)
			workflowComponent = new HPCStormWorkflowComponent();
		return workflowComponent;
	}

}
