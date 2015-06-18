package br.ufc.mdcc.pargo.safe.framework;

public class HPCStormObjectRepository {

	private static HPCStormWorkflowEngine workflowEngine = null;

	public static void setWorkflowEngine(HPCStormWorkflowEngine we) {
		if (workflowEngine == null)
			workflowEngine = we;
	}
	
	public static HPCStormWorkflowEngine getWorkflowEngine(){
		return workflowEngine;
	}
}
