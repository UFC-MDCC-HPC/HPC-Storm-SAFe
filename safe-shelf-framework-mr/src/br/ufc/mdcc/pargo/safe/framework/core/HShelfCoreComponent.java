package br.ufc.mdcc.pargo.safe.framework.core;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowServices;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class HShelfCoreComponent extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		HShelfWorkflowServices workflowServices = new HShelfWorkflowServices();
		workflowServices.setName("workflow-services-port-provides");
		try {
			this.services.setProvidesPort(workflowServices);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
