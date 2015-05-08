package br.ufc.mdcc.pargo.safe.framework;



import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormServices services;
	private HPCStormSAFeSWL saFeSWL;
	private HPCStormWorkflowEngine engine;
	/*PREDEF PORTS*/
	
	
	
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		
	}
	
	public void setServices(IHPCStormServices services){
		this.services = services;
		SAFeConsoleLogger.write("Registering predef workflow ports.");
		
		
	}

	@Override
	public void setSAFeSWL(HPCStormSAFeSWL in) {
		this.saFeSWL = in;
	}
	
}
