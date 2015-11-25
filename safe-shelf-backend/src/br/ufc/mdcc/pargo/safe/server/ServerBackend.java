package br.ufc.mdcc.pargo.safe.server;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.backend.connector.TCPBinding;
import br.ufc.mdcc.pargo.backend.server.proxy.stubs.ServerProxieWSService;

public class ServerBackend implements IServerBackend {

	 
	private List<String> buffer;
	
	//private IAppEnvPort appEnvPort;
	//private HShelfApplicationBidingClientFacade appBiding;
	private TCPBinding tcpBinding;
	//private SAFePortProxie safePortProxie;

	public ServerBackend(TCPBinding tcpBinding) {
		this.buffer = new ArrayList<String>();
		//this.appEnvPort = new AppEnvPortImpl();
		//this.appBiding = new HShelfApplicationBidingClientFacade();
		//this.appBiding.setServerLocation("http://localhost:10011/app-env?wsdl");
		this.tcpBinding = tcpBinding;
		//this.safePortProxie = new SAFePortProxie();

		Thread serverThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					 
						if (!buffer.isEmpty()) {
							String message = buffer.get(0);
							buffer.remove(0);
							System.out.println("-SERVER BUFFER SIZE: "+buffer.size());
							/*HShelfApplicationBidingEvent event = new HShelfApplicationBidingEvent();
							event.setEventType(HShelfApplicationBidingEvent.INCOMING_MSG);
							event.setValue("MSG:"+message);
							appBiding.sendEvent(event);*/
							//safePortProxie.sendMessage(message);
							//heron
							sendMessage(message);
							if(message.equals("bye")) break;
						}
 
				}

			}
		};
		serverThread.start();
	}

	@Override
	public void setPort(Integer port) {
		this.tcpBinding.set_server_port(port);
	}

	@Override
	public void connect() {
		 this.tcpBinding.server_connect();
		

	}

	@Override
	public void incomingMessageEvent(String message) {
		this.buffer.add(message);
		System.out.println("+SERVER BUFFER SIZE: "+buffer.size()+"->"+message);
	}
	
	public void sendMessage(String message){
		ServerProxieWSService service = new ServerProxieWSService();
		service.getServerProxieWSPort().sendMessage(message);
	}
	 
}
