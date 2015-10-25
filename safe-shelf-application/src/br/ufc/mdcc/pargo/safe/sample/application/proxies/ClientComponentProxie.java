package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;

public class ClientComponentProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		ClientTaskPortProxie task = new ClientTaskPortProxie();
		task.setName("task-client");
		ClientEnvPortProxie env = new ClientEnvPortProxie();
		env.setName("env-client");
		
		System.out.println("TASK-CLIENT URL: "+ HShelfSession.getValue("task-client"));
		System.out.println("ENV-CLIENT URL: "+HShelfSession.getValue("env-client"));
		
		try {
			this.services.setTaskPort(task);
			this.services.setProvidesPort(env);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
