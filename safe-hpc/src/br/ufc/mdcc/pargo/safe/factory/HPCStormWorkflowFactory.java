package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.framework.HPCStormWorkflowComponent;

public class HPCStormWorkflowFactory {
	
	private static HPCStormWorkflowComponent workflowComponent;
	
	public static HPCStormWorkflowComponent createWorkflowComponent(){
		if(workflowComponent==null)
			workflowComponent = new HPCStormWorkflowComponent();
		return workflowComponent;
	}

}
