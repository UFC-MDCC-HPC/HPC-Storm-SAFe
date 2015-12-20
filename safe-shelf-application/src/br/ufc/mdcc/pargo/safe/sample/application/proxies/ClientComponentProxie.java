package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.client.service.ClientProxieWS;
import br.ufc.mdcc.pargo.safe.sample.client.service.IClientProxieWS;

public class ClientComponentProxie extends HShelfComponent {

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		ClientTaskPortProxie task = new ClientTaskPortProxie();
		task.setName("task-client");
		ClientEnvPortProxie env = new ClientEnvPortProxie();
		env.setName("env-client");

		System.out.println("TASK-CLIENT URL: "
				+ HShelfSession.getValue("task-client"));
		System.out.println("ENV-CLIENT URL: "
				+ HShelfSession.getValue("env-client"));

		ClientEnvUsesAppPort usesAppPort = new ClientEnvUsesAppPort();
		usesAppPort.setName("client-uses-A");
		
		try {
			this.services.setTaskPort(task);
			this.services.setProvidesPort(env);
			this.services.registerUsesPort(usesAppPort);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//heron idea
		this.startService();
	}

	// uses!
	public void requestMessage() {
		try {
			ClientEnvUsesAppPort port_A_uses = (ClientEnvUsesAppPort) this.services
					.getProvidesPort("client-uses-A");
			port_A_uses.requestMessage();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startService() {

		IClientProxieWS service = new ClientProxieWS();
		service.setClientProxie(this);
		String url = "http://localhost:10030/client-service-port";
		Endpoint.publish(url, service);
		System.out.println(url);
	}

}
