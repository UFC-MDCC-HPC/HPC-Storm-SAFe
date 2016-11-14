package br.ufc.mdcc.pargo.safe.framework.core;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowServicesProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class HShelfCoreComponent extends HShelfComponent{
	
	
	public static final String WORKFLOW_SERVICES_PRV = "workflow-services-port-provides";
	public static final String WORKFLOW_SERVICES_USE = "workflow-services-port-uses";
	

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		HShelfWorkflowServicesProvidesPort workflowServices = new HShelfWorkflowServicesProvidesPort();
		workflowServices.setName(HShelfCoreComponent.WORKFLOW_SERVICES_PRV);
		try {
			this.services.setProvidesPort(workflowServices);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
