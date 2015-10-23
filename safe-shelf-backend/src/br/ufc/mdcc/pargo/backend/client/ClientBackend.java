package br.ufc.mdcc.pargo.backend.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import br.ufc.mdcc.pargo.backend.client.port.env.IServiceClientEnv;
import br.ufc.mdcc.pargo.backend.client.port.tsk.IServiceClientTask;

public class ClientBackend implements IClientBackend{

	private Integer serverPort;
	private Socket connector;
	private ObjectOutputStream output;
	private List<String> buffer;

	private IServiceClientEnv env;
	private IServiceClientTask tsk;
	
	private Semaphore semaphore;
	
	public ClientBackend() {
		
		this.semaphore = new Semaphore(0);
		this.buffer = new ArrayList<String>();
		Thread clientThread = new Thread(){
			@Override
			public void run() {
				
				while(true){
					
					try {Thread.sleep(3000);} 
					catch (InterruptedException e) {e.printStackTrace();}
					if(output!=null){
						sendMessageToServer();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		};
		t.start();
		
		
	}

	
	private void sendMessageToServer() {
		
		if(this.buffer.isEmpty()) return;
		
		String msg = this.buffer.get(0);
		this.buffer.remove(0);
		
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public IServiceClientEnv getEnv() {
		return env;
	}

	public IServiceClientTask getTsk() {
		return tsk;
	}

	public void setEnv(IServiceClientEnv env) {
		this.env = env;
	}

	public void setTsk(IServiceClientTask tsk) {
		this.tsk = tsk;
	}

	
}
