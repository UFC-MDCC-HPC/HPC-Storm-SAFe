package br.ufc.mdcc.pargo.safe.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import br.ufc.mdcc.pargo.safe.server.port.env.IServiceServerEnv;
import br.ufc.mdcc.pargo.safe.server.port.tsk.IServiceServerTask;

public class ServerBackend implements IServerBackend {

	private Integer port;
	private ServerSocket server;
	private Socket client;
	private ObjectInputStream input;

	private List<String> buffer;
	private IServiceServerEnv env;
	private IServiceServerTask tsk;

	private Semaphore semaphore;

	public ServerBackend() {
		this.buffer = new ArrayList<String>();
		this.semaphore = new Semaphore(0);

		Thread serverThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if (env != null) {
						if (!buffer.isEmpty()) {
							String message = buffer.get(0);
							buffer.remove(0);
							System.out.println("SERVER BUFFER SIZE: "+buffer.size());
							env.sendMessageToApplication(message);
							if(message.equals("bye")) break;
						}

					}
				}

			}
		};
		serverThread.start();
	}

	@Override
	public void setPort(Integer port) {
		this.port = port;
		this.semaphore.release();
	}

	@Override
	public void connect() {
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

	public void receive() {
		try {
			this.client = server.accept();
			this.input = new ObjectInputStream(client.getInputStream());
			String msg = "";
			do {
				msg = (String) input.readObject();
				
				this.buffer.add(msg);
				System.out.println("SERVER BUFFER SIZE: "+this.buffer.size());
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

	public IServiceServerEnv getEnv() {
		return env;
	}

	public void setEnv(IServiceServerEnv env) {
		this.env = env;
	}

	public IServiceServerTask getTsk() {
		return tsk;
	}

	public void setTsk(IServiceServerTask tsk) {
		this.tsk = tsk;
	}

}
