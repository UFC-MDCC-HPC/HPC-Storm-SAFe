package br.ufc.mdcc.pargo.safe.workflow;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public class HShelfWorkflow extends HShelfComponent {

	public HShelfWorkflow(String name) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.setName(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	}

}
