package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.server.service.IServerProxieWS;
import br.ufc.mdcc.pargo.safe.sample.server.service.ServerProxieWS;

public class ServerComponentProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services  = services;
		
		ServerTaskPortProxie task = new ServerTaskPortProxie();
		task.setName("task-server");
		ServerEnvPortProxie env = new ServerEnvPortProxie();
		env.setName("env-server");
		
		System.out.println("TASK-SERVER URL: "+ HShelfSession.getValue("task-server"));
		System.out.println("ENV-SERVER URL: "+HShelfSession.getValue("env-server"));
		
		ServerUsesAppPort usesAppPort = new ServerUsesAppPort();
		usesAppPort.setName("server-uses-A");
		
		try {
			this.services.setTaskPort(task);
			this.services.setProvidesPort(env);
			this.services.registerUsesPort(usesAppPort);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.startService();
	}

	public void sendMessage(String message){
		try {
			ServerUsesAppPort port_A_uses = (ServerUsesAppPort) this.services
					.getProvidesPort("server-uses-A");
			port_A_uses.sendMessage(message);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startService(){
		IServerProxieWS service = new ServerProxieWS();
		service.setServerProxie(this);
		String url = "http://localhost:10040/server-service-port";
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	
}
