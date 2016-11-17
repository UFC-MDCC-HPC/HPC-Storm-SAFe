package br.ufc.mdcc.pargo.safe.mobilecode.comm;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufc.mdcc.pargo.safe.mobilecode.util.Constants;

/**
 * Servidor de conexoes. Para cliente, uma nova Thread e criada.
 * 
 * @author Jefferson
 * 
 */
public class Server extends Thread {

	private ServerSocket serverSocket;
	private String serverIp;

	private int startedClients;

	// public static final IPrinter printer = new MemoPrinter();

	public Server() {

		// peagndo o meu ip
		try {
			InetAddress addr = InetAddress.getLocalHost();
			this.serverIp = addr.getHostAddress();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		// criando o ServerSocket
		try {
			this.serverSocket = new ServerSocket(Constants.SERVER_PORT);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void run() {
		System.out.println("SERVER STARTED AT PORT "+Constants.SERVER_PORT);
		this.waitingConnection();
	}

	/**
	 * Espera por conexoes.
	 *
	 */
	private void waitingConnection() {

		while (true) {
			// aceitando a conexao
			try {
				Socket client = this.serverSocket.accept();
				ServerThread serverThread = new ServerThread(client, this);
				serverThread.start();
				this.startedClients++;
			} catch (Exception ex) {
				ex.printStackTrace();
				break;
			}
		}

	}

	public String getServerIp() {
		return serverIp;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public int getStartedClients() {
		return startedClients;
	}

	public void decStartedClients() {

		this.startedClients = (startedClients == 0) ? startedClients
				: startedClients - 1;
	}

}
