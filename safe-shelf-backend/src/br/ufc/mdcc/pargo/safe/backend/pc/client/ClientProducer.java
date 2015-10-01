package br.ufc.mdcc.pargo.safe.backend.pc.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientProducer implements IClientProducer{

	private Integer serverPort;
	private Socket connector;
	private ObjectOutputStream output;
	
	@Override
	public void setServerPort(Integer port) {
		this.serverPort = port;
		
	}

	@Override
	public void sendMsg(String msg) {
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

	@Override
	public void initialize() {
		try {
			this.connector = new Socket(InetAddress.getByName("localhost"),this.serverPort);
			this.output = new ObjectOutputStream(this.connector.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
