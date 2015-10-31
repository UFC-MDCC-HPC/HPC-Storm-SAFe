package br.ufc.mdcc.pargo.backend.connector;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;

public class TCPBidingClientLogic {

	private Integer server_port;
	private String server_host="localhost";
	private Socket connector;
	private ObjectOutputStream output;
	
	private Semaphore semaphore;
	public boolean connected = false;
	
	public TCPBidingClientLogic() {
		this.semaphore = new Semaphore(0);
	}
	
	public void connect_to_server(){
		Thread t = new Thread(){
			public void run() {
				try {
					semaphore.acquire();
					connector = new Socket(InetAddress.getByName(server_host),server_port);
					output = new ObjectOutputStream(connector.getOutputStream());
					connected = true;
					System.out.println("CLIENT CONNECTED TO SERVER IN PORT "+server_port);
				} catch (UnknownHostException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			};
		};
		t.start();

	}
	
	public void send_message_to_server(String message){
		if (output==null) return;
		try {
			output.writeObject(message);
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(message.equals("bye")){
			try {
				output.close();
				System.out.println("CLIENT CONNECTION CLOSED (CLIENT-SIDE).");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void setServer_port(Integer server_port) {
		this.server_port = server_port;
	}

	public void setServer_host(String server_host) {
		this.server_host = server_host;
	}
	
	public void release(){
		this.semaphore.release();
	}
	
}
