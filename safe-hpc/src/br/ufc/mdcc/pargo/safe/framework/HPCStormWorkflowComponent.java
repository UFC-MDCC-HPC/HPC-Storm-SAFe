package br.ufc.mdcc.pargo.safe.framework;


import br.ufc.mdcc.pargo.safe.port.predefined.environment.WorkflowPredefinedPortProvides;
import br.ufc.mdcc.pargo.safe.port.predefined.environment.WorkflowPredefinedPortUses;
import br.ufc.mdcc.pargo.safe.port.predefined.environment.impl.WorkflowPredefinedPortUsesImpl;
import br.ufc.mdcc.pargo.safe.services.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormServices services;
	private HPCStormSAFeSWL saFeSWL;
	private HPCStormWorkflowEngine engine;
	private WorkflowPredefinedPortUses usesPort;
	private WorkflowPredefinedPortProvides providesPort;
	
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		this.usesPort = new WorkflowPredefinedPortUsesImpl(); 
		
	}
	
	public void setServices(IHPCStormServices services){
		this.services = services;
		SAFeConsoleLogger.write("Registering predef workflow ports.");
		this.services.registerUsesPort(usesPort);
		this.services.setProvidesPort(providesPort);
	}
	
}
