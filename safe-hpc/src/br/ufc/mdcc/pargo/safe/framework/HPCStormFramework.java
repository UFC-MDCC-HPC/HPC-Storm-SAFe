package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.application.IHPCStormApplicationServices;
import br.ufc.mdcc.pargo.safe.factory.HPCStormServicesFactory;
import br.ufc.mdcc.pargo.safe.factory.HPCStormWorkflowFactory;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;




public class HPCStormFramework implements IHPCStormFramework{

	//application component parent
	private HPCStormApplicationFramework applicationComponent;
	//workflow component
	private IHPCStormWorkflowComponent workflowComponent;
	//the services object, shared among other SAFe entities
	private IHPCStormServices applicationServices;
	 
	
	public HPCStormFramework(){
		this.applicationComponent = null;
		this.workflowComponent = HPCStormWorkflowFactory.createWorkflowComponent();
		SAFeConsoleLogger.write("Workflow Component created.");
		this.applicationServices = HPCStormServicesFactory.createApplicationServices();
		SAFeConsoleLogger.write("Services created.");
		
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
			this.applicationComponent.setServices((IHPCStormApplicationServices)this.applicationServices);
		SAFeConsoleLogger.write("Services set in Application.");
		if(this.workflowComponent!=null)
			this.workflowComponent.setServices((IHPCStormApplicationServices)this.applicationServices);
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
