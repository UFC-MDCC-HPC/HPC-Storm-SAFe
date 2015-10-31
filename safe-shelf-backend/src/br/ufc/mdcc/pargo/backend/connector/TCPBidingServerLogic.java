package br.ufc.mdcc.pargo.backend.connector;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class TCPBidingServerLogic {

	private Integer port;
	private ServerSocket server;
	private Socket client;
	private ObjectInputStream input;
	private Semaphore semaphore;
	private ITCPBindingServerListener serverListener;
	
	public TCPBidingServerLogic() {
		this.semaphore = new Semaphore(0);
	}
	
	public void connect(){
		Thread receiverThread = new Thread() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					server = new ServerSocket(port);
					System.out.println("SERVER IS UP AT PORT " + port + ".");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				receive();
			}
		};

		receiverThread.start();

	}
	
	private void receive() {
		try {
			this.client = server.accept();
			this.input = new ObjectInputStream(client.getInputStream());
			String msg = "";
			do {
				msg = (String) input.readObject();
				
				this.serverListener.incomingMessageEvent(msg);
				
			} while (!msg.equals("bye"));
			this.input.close();
			this.client.close();
			System.out.println("CLIENT CONNECTION CLOSED (SERVER-SIDE).");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setServerListener(ITCPBindingServerListener serverListener) {
		this.serverListener = serverListener;
	}
	
	public void release(){
		this.semaphore.release();
	}
}
