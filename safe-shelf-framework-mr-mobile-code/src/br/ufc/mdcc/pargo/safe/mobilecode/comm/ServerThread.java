package br.ufc.mdcc.pargo.safe.mobilecode.comm;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.ufc.mdcc.pargo.safe.mobilecode.pckg.SafePackage;
import br.ufc.mdcc.pargo.safe.mobilecode.util.FileUtil;

/**
 * Thread criada no servidor para tratar um cliente em particular.
 * 
 * @author Jefferson
 *
 */
public class ServerThread extends Thread {

	private Socket client;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Server parent;

	public ServerThread(Socket client, Server parent) {

		this.client = client;
		this.parent = parent;

		try {
			this.out = new ObjectOutputStream(this.client.getOutputStream());
			this.in = new ObjectInputStream(this.client.getInputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void receive() {

		try {
			SafePackage receveid = (SafePackage) in.readObject();
			this.writeData(receveid.getFileName(), receveid.getData());
			out.close();
			in.close();
			client.close();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	public void run() {
		this.receive();
		this.parent.decStartedClients();
	}

	private void writeData(String fileName, byte[] data) {
		String outPath = FileUtil.curDir + "local" + File.separatorChar;
		outPath += fileName;
		FileOutputStream file;
		try {
			file = new FileOutputStream(outPath, true);
			DataOutputStream out = new DataOutputStream(file);
			out.write(data);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
