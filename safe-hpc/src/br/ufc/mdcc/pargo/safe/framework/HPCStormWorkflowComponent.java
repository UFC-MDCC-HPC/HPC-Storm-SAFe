package br.ufc.mdcc.pargo.safe.framework;



import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvUsesPort;
import br.ufc.mdcc.pargo.safe.port.predef.ISAFeSWLPort;
import br.ufc.mdcc.pargo.safe.port.predef.SAFeSWLUsesPort;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowComponent implements IHPCStormWorkflowComponent{

	private IHPCStormServices services;
	private HPCStormWorkflowEngine engine;
	/*PREDEF PORTS*/
	private IHPCStormEnvUsesPort safeSWLPort;
	
	
	
	public HPCStormWorkflowComponent() {
		
		this.engine = new HPCStormWorkflowEngine();
		

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
		String flowFile = ((ISAFeSWLPort)this.safeSWLPort).getFlowXMLLocation();
		String archFile = ((ISAFeSWLPort)this.safeSWLPort).getArchXMLLocation();
		
		System.out.println("FLOW: " + flowFile);
		System.out.println("ARCH: " + archFile);
	}

	//testing
	public static void main(String[] args) {
		HPCStormWorkflowComponent w = new HPCStormWorkflowComponent();
		w.run();
	}
	
}
