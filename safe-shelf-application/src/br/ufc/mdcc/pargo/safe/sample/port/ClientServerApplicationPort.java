package br.ufc.mdcc.pargo.safe.sample.port;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.application.ClientServerApplication;
import br.ufc.mdcc.pargo.safe.sample.service.ClientServerApplicationServiceImpl;
import br.ufc.mdcc.pargo.safe.sample.service.IClientServerApplicationService;

public class ClientServerApplicationPort extends HShelfPort{

	private ClientServerApplication application;
	
	public void setClientServerApplication(ClientServerApplication application){
		this.application = application;
	}
	
	public void startService(){
		IClientServerApplicationService service = new ClientServerApplicationServiceImpl();
		service.setApplicationPort(this);
		String url = "http://localhost:10020/app-port";
		Endpoint.publish(url, service);
		System.out.println(url);
	}
	
	public void requestMessage(){
		this.application.requestMessage();
	}
	public void sendMessage(String message){
		this.application.sendMessage(message);
	}
}
