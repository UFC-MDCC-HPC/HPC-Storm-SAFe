package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.application.IHPCStormApplicationServices;
import br.ufc.mdcc.pargo.safe.factory.HPCStormServicesFactory;
import br.ufc.mdcc.pargo.safe.factory.HPCStormWorkflowFactory;




public class HPCStormFramework extends Thread{

	

	private HPCStormApplicationFramework applicationComponent;
	private HPCStormWorkflowComponent workflowComponent;
	private IHPCStormServices applicationServices;
	
	public HPCStormFramework(){
		this.applicationComponent = null;
		this.workflowComponent = HPCStormWorkflowFactory.createWorkflowComponent();
		this.applicationServices = HPCStormServicesFactory.createApplicationServices();
	}
	
	public HPCStormFramework(HPCStormApplicationFramework application,
							  HPCStormWorkflowComponent workflow){
		this.setApplicationComponent(application);
		this.setWorkflowComponent(workflow);
	}
	
	public void setWorkflowComponent(HPCStormWorkflowComponent workflowComponent) {
		this.workflowComponent = workflowComponent;
	}

	/**
	 * Informs to the framework which application it belongs to. Also sets the services 
	 * object to the application and workflow component.
	 * @param applicationComponent
	 */
	public void setApplicationComponent(
			HPCStormApplicationFramework applicationComponent) {
		this.applicationComponent = applicationComponent;
		if(this.applicationComponent!=null)
			this.applicationComponent.setServices((IHPCStormApplicationServices)this.applicationServices);
		if(this.workflowComponent!=null)
			this.workflowComponent.setServices((IHPCStormApplicationServices)this.applicationServices);
		
	}
	
	
	
}
