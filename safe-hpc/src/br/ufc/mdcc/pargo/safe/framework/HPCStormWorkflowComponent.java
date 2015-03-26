package br.ufc.mdcc.pargo.safe.framework;



import br.ufc.mdcc.pargo.safe.port.predefined.env.SAFeSWLUsesPort;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormServices services;
	private HPCStormSAFeSWL saFeSWL;
	private HPCStormWorkflowEngine engine;
	/*PREDEF PORTS*/
	private SAFeSWLUsesPort<HPCStormSAFeSWL> saFeSWLUsesPort;
	
	
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		this.saFeSWLUsesPort = new SAFeSWLUsesPort<HPCStormSAFeSWL>(HPCStormSAFeSWL.class); 
		this.saFeSWLUsesPort.setComponent(this);
	}
	
	public void setServices(IHPCStormServices services){
		this.services = services;
		SAFeConsoleLogger.write("Registering predef workflow ports.");
		this.services.registerUsesPort(saFeSWLUsesPort);
		
	}

	@Override
	public void setSAFeSWL(HPCStormSAFeSWL in) {
		this.saFeSWL = in;
	}
	
}
