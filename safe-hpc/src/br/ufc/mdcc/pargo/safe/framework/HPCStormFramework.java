package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.exception.HPCStormException;
import br.ufc.mdcc.pargo.safe.factory.HPCStormConnectionRepositoryFactory;
import br.ufc.mdcc.pargo.safe.factory.HPCStormServicesFactory;
import br.ufc.mdcc.pargo.safe.factory.HPCStormWorkflowFactory;
import br.ufc.mdcc.pargo.safe.port.IHPCStormProvides;
import br.ufc.mdcc.pargo.safe.port.IHPCStormUses;
import br.ufc.mdcc.pargo.safe.port.conn.IHPCStormConnectionRepository;
import br.ufc.mdcc.pargo.safe.port.conn.UsesProvidesConnection;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;




public class HPCStormFramework implements IHPCStormFramework{

	//application component parent
	private HPCStormApplicationFramework applicationComponent;
	//workflow component
	private IHPCStormWorkflowComponent workflowComponent;
	//the services object, shared among other SAFe entities
	private IHPCStormServices services;
	//
	IHPCStormConnectionRepository connRep = HPCStormConnectionRepositoryFactory.getHPCStormConnectorService();
	
	public HPCStormFramework(){
		this.applicationComponent = null;
		this.workflowComponent = HPCStormWorkflowFactory.createWorkflowComponent();
		SAFeConsoleLogger.write("Workflow Component created.");
		this.services = HPCStormServicesFactory.createApplicationServices();
		SAFeConsoleLogger.write("Services created.");
		
		//adding predefined ports via connect method TODO
		
	}
	
	/**
	 * Informs to the framework which application it belongs to. Also sets the services 
	 * object to the application and workflow component.
	 * @param applicationComponent
	 */
	public void setApplicationComponent(
			HPCStormApplicationFramework applicationComponent) {
		this.applicationComponent = applicationComponent;
		SAFeConsoleLogger.write("Application parent set in Framework.");
		if(this.applicationComponent!=null)
			this.applicationComponent.setServices((IHPCStormServices)this.services);
		SAFeConsoleLogger.write("Services set in Application.");
		if(this.workflowComponent!=null)
			this.workflowComponent.setServices((IHPCStormServices)this.services);
		SAFeConsoleLogger.write("Services set in Workflow Component.");
	}
	
	private void connectAllPredefPorts(){
		//TODO WARNING! THIS IS JUST A TEST
		String id = this.connectPorts("swl-u-id", "swl-p-id");
	 	UsesProvidesConnection up = this.connRep.getConnection(id);
	 	up.run();
	}
	 
	
	/**
	 * Runs the framework and begins the orchestration.
	 */
	@Override
	public void run() {
		SAFeConsoleLogger.write("Framework Thread started.");
		this.connectAllPredefPorts();
		
	}

	@Override
	public String connectPorts(String usesId, String providesId) {
		String id = null;
		IHPCStormUses<?> uses = this.services.getUsesPort(usesId);
		IHPCStormProvides<?> provides = this.services.getProvidesPort(providesId);
		//TODO you have to test the type first...
		try {
			 id = this.connRep.createConnection(uses, provides);
			SAFeConsoleLogger.write("Conn "+id+" created.");
		} catch (HPCStormException e) {
			e.printStackTrace();
		}
		return id;
	}
	
}
