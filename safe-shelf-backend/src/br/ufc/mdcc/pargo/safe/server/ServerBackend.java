package br.ufc.mdcc.pargo.safe.server;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.backend.app.port.AppEnvPortImpl;
import br.ufc.mdcc.pargo.backend.app.port.IAppEnvPort;
import br.ufc.mdcc.pargo.backend.connector.TCPBinding;

public class ServerBackend implements IServerBackend {

	 
	private List<String> buffer;
	
	private IAppEnvPort appEnvPort;
	private TCPBinding tcpBinding;

	public ServerBackend(TCPBinding tcpBinding) {
		this.buffer = new ArrayList<String>();
		this.appEnvPort = new AppEnvPortImpl();
		this.tcpBinding = tcpBinding;

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
							appEnvPort.receiveMessage(message);
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
	 
}
