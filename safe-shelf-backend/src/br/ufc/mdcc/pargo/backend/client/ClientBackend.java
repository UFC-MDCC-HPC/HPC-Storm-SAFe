package br.ufc.mdcc.pargo.backend.client;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.backend.app.port.AppEnvPortImpl;
import br.ufc.mdcc.pargo.backend.app.port.IAppEnvPort;
import br.ufc.mdcc.pargo.backend.connector.TCPBinding;

public class ClientBackend implements IClientBackend{

	
	private List<String> buffer;
	private IAppEnvPort appEnvPort;
	private TCPBinding tcpBinding;
	
	public ClientBackend(TCPBinding tcpBinding) {
		this.appEnvPort = new AppEnvPortImpl();
		this.tcpBinding = tcpBinding;

		this.buffer = new ArrayList<String>();
		Thread clientThread = new Thread(){
			@Override
			public void run() {
				
				while(true){
					
					try {Thread.sleep(1000);} 
					catch (InterruptedException e) {e.printStackTrace();}
					String msg = sendMessageToServer();
				
					if(msg.equals("bye")) break; //just to end this thread...
					
				}
				
			}
		};
		
		clientThread.start();
	}
	
	@Override
	public void setServerPort(Integer port) {
		this.tcpBinding.set_client_to_server_port(port);
	}

	@Override
	public void addMesssageToBuffer(String message) {
		
		this.buffer.add(message);
		System.out.println("+CLIENT BUFFER SIZE: "+this.buffer.size()+"->"+message);
	}

	@Override
	public void connect() {
		this.tcpBinding.client_connect();
	}

	
	private String sendMessageToServer() {
		
		if(this.buffer.isEmpty()) return "";
		String msg = this.buffer.get(0);
		boolean res = this.tcpBinding.client_send_message(msg);
		if(res){
			this.buffer.remove(0);
			System.out.println("-CLIENT BUFFER SIZE: "+this.buffer.size()+"->"+msg);
			return msg;
		}
		return "null";
		
	}

	public void post(){
		this.appEnvPort.requestMessage();
	}
	
}
