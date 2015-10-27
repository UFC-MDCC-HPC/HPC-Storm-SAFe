package br.ufc.mdcc.pargo.backend.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import br.ufc.mdcc.pargo.backend.app.stubs.ApplicationEnvPortImplService;
import br.ufc.mdcc.pargo.backend.app.stubs.IApplicationEnvPort;

public class ClientBackend implements IClientBackend{

	private Integer serverPort;
	private Socket connector;
	private ObjectOutputStream output;
	private List<String> buffer;

	 
	
	private Semaphore semaphore;
	
	public ClientBackend() {
		
		this.semaphore = new Semaphore(0);
		this.buffer = new ArrayList<String>();
		Thread clientThread = new Thread(){
			@Override
			public void run() {
				
				while(true){
					
					try {Thread.sleep(1000);} 
					catch (InterruptedException e) {e.printStackTrace();}
					if(output!=null){
						String msg = sendMessageToServer();
						if(msg.equals("bye")) break;
					}
				}
				
			}
		};
		
		clientThread.start();
	}
	
	@Override
	public void setServerPort(Integer port) {
		this.serverPort = port;
		this.semaphore.release();
	}

	@Override
	public void addMesssageToBuffer(String message) {
		
		this.buffer.add(message);
		System.out.println("CLIENT BUFFER SIZE: "+this.buffer.size());
	}

	@Override
	public void connect() {
		
		Thread t = new Thread(){
			public void run() {
				try {
					semaphore.acquire();
					connector = new Socket(InetAddress.getByName("localhost"),serverPort);
					output = new ObjectOutputStream(connector.getOutputStream());
					System.out.println("CLIENT CONNECTED TO SERVER IN PORT "+serverPort);
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

	
	private String sendMessageToServer() {
		
		if(this.buffer.isEmpty()) return "";
		
		String msg = this.buffer.get(0);
		this.buffer.remove(0);
		System.out.println("CLIENT BUFFER SIZE: "+this.buffer.size());
		try {
			output.writeObject(msg);
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(msg.equals("bye")){
			try {
				output.close();
				System.out.println("CLIENT CONNECTION CLOSED (CLIENT-SIDE).");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return msg;
		
	}

	@Override
	public void requestMessage() {
		ApplicationEnvPortImplService service = new ApplicationEnvPortImplService();
		IApplicationEnvPort port = service.getApplicationEnvPortImplPort();
		port.requestMessage();
	}

	
}
