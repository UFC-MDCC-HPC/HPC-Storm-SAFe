package br.ufc.mdcc.pargo.safe.backend.pc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConsumer implements IServerConsumer{

	private Integer port;
	private String msg;
	private ServerSocket server;
	private Socket client;
	private ObjectInputStream input;
	
	public ServerConsumer() {
		this.msg = "NO MESSAGES YET. SORRY";
	}
	
	@Override
	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String getMsg() {
		return this.msg;
	}

	@Override
	public void initialize() {
		try {
			this.server = new ServerSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t = new Thread(){
			@Override
			public void run() {
				
				receive();
			}
		};
		
		t.start();
		System.out.println("SERVER IS UP AT PORT "+this.port+".");
		
	}

	@Override
	public void receive() {
		try {
			this.client = server.accept();
			this.input = new ObjectInputStream(client.getInputStream());
			
			do{
				this.msg = (String)input.readObject();
			}while(!this.msg.equals("bye"));
			
			this.input.close();
			this.client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
