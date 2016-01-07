package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.client.service.ClientProxieWS;
import br.ufc.mdcc.pargo.safe.sample.client.service.IClientProxieWS;
import br.ufc.mdcc.pargo.safe.sample.port.ApplicationPort_A;

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
		
		try {
			this.services.registerTaskPort(task);
			this.services.setProvidesPort(env);
			this.services.registerUsesPort("client-uses-A", IHShelfPortTypes.NO_TYPE);
			
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
			HShelfUsesPort usesPort = (HShelfUsesPort)this.services.getPort("client-uses-A");
			((ApplicationPort_A)usesPort.getProvidesPort()).requestMessage();
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
