package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplication;
import br.ufc.mdcc.pargo.safe.factory.HPCStormServicesFactory;
import br.ufc.mdcc.pargo.safe.factory.HPCStormWorkflowFactory;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;




public class HPCStormFramework implements IHPCStormFramework{

	//application component parent
	private HPCStormApplication applicationComponent;
	//workflow component
	private IHPCStormWorkflowComponent workflowComponent;
	//the services object, shared among other SAFe entities
	private IHPCStormServices services;
	
	
	public HPCStormFramework(){
		this.applicationComponent = null;
		this.workflowComponent = HPCStormWorkflowFactory.createWorkflowComponent();
		SAFeConsoleLogger.write("Workflow Component created.");
		this.services = HPCStormServicesFactory.createApplicationServices();
		SAFeConsoleLogger.write("Services created.");
	}
	
	/**
	 * Informs to the framework which application it belongs to. Also sets the services 
	 * object to the application and workflow component.
	 * @param applicationComponent
	 */
	public void setApplicationComponent(
			HPCStormApplication applicationComponent) {
		this.applicationComponent = applicationComponent;
		SAFeConsoleLogger.write("Application parent set in Framework.");
		if(this.applicationComponent!=null)
			this.applicationComponent.setServices((IHPCStormServices)this.services);
		SAFeConsoleLogger.write("Services set in Application.");
		if(this.workflowComponent!=null)
			this.workflowComponent.setServices((IHPCStormServices)this.services);
		SAFeConsoleLogger.write("Services set in Workflow Component.");
	}
	
	 	
	/**
	 * Runs the framework and begins the orchestration.
	 */
	@Override
	public void run() {
		SAFeConsoleLogger.write("Framework Thread started.");
		
		
	}

}
