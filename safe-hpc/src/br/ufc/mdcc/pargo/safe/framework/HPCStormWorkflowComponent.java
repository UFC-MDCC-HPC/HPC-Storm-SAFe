package br.ufc.mdcc.pargo.safe.framework;



import br.ufc.mdcc.pargo.safe.exception.HPCStormException;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvUsesPort;
import br.ufc.mdcc.pargo.safe.port.predef.ISAFeSWLPort;
import br.ufc.mdcc.pargo.safe.port.predef.SAFeSWLUsesPort;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormServices services;
	private HPCStormWorkflowEngine engine;
	private HPCStormSAFeSWL safeSWL;
	/*PREDEF PORTS*/
	private IHPCStormEnvUsesPort safeSWLPort;
	
	
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		this.safeSWL = new HPCStormSAFeSWL();

	}
	
	public void setServices(IHPCStormServices services){
		this.services = services;
		SAFeConsoleLogger.write("Registering predef workflow ports.");
		if(services!=null){
			//At this point, the port is created and connected to provides, inside the port code.
			//Later, the connection must no be inside the port code.
			this.safeSWLPort = new SAFeSWLUsesPort();
			SAFeConsoleLogger.write("SAFeSWLUsesPort created");
			this.services.registerUsesPort(safeSWLPort);
		}
	}
	
	/**
	 * Runs workflow component
	 */
	public void run(){
		
		//getting information form predef ports
		String flowFileName = ((ISAFeSWLPort)this.safeSWLPort).getFlowXMLLocation();
		String archFileName = ((ISAFeSWLPort)this.safeSWLPort).getArchXMLLocation();
		
		//creating safeSWL objetc
		this.safeSWL.setFlowFileName(flowFileName);
		this.safeSWL.setArchFileName(archFileName);
		
		//Engine...
		this.engine.setSafeSWL(this.safeSWL);
		
		try {
			SAFeConsoleLogger.write("Starting engines...");
			this.engine.run();
		} catch (HPCStormException e) {
			 
			e.printStackTrace();
		}
		
		
	}

	//testing
	public static void main(String[] args) {
		HPCStormWorkflowComponent w = new HPCStormWorkflowComponent();
		w.run();
	}
	
}
