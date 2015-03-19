package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.port.predefined.WorkflowPredefinedPortImpl;
import br.ufc.mdcc.pargo.safe.services.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormServices services;
	private HPCStormSAFeSWL saFeSWL;
	private HPCStormWorkflowEngine engine;
	private WorkflowPredefinedPortImpl workflowPredefPort;
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		this.workflowPredefPort = new WorkflowPredefinedPortImpl("pre-def-workflow");
		
	}
	
	public void setServices(IHPCStormServices services){
		this.services = services;
		SAFeConsoleLogger.write("Registering predef workflow port.");
		this.services.registerUsesPort(workflowPredefPort);
	}
	
}
