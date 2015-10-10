package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class ServerComponentProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services  = services;
		
		ServerTaskPortProxie task = new ServerTaskPortProxie();
		task.setName("task-server");
		ServerEnvPortProxie env = new ServerEnvPortProxie();
		env.setName("env-server");
		
		
		try {
			this.services.setTaskPort(task);
			this.services.setProvidesPort(env);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
