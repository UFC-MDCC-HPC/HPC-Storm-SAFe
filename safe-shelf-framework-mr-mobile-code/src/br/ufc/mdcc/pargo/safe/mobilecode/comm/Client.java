package br.ufc.mdcc.pargo.safe.mobilecode.comm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufc.mdcc.pargo.safe.mobilecode.pckg.SafePackage;
import br.ufc.mdcc.pargo.safe.mobilecode.util.Constants;
import br.ufc.mdcc.pargo.safe.mobilecode.util.FileUtil;

public class Client extends Thread {

	protected ObjectOutputStream out;
	protected ObjectInputStream in;
	protected Socket socket;
	private int sendTimes = 0;

	protected boolean connected = false;

	public void connect(String ip, int port) {
		if (this.connected == true)
			return;

		try {
			 
			this.socket = new Socket(InetAddress.getByName(ip), port);
			this.out = new ObjectOutputStream(socket.getOutputStream());
			this.in = new ObjectInputStream(socket.getInputStream());
			this.connected = true;
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void disconect() {
		try {
			if (socket != null) {
				socket.close();
				out.close();
				in.close();
				this.connected = false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * Funcioanamento normal.
	 */
	public void run() {
 

		this.connect("localhost", Constants.SERVER_PORT);

		
		

	}

	
	
	private void send(SafePackage packet){
		try {
			out.writeObject(packet);
			if(sendTimes%25==0)
				out.reset();
			out.flush();
			
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }

	    this.sendTimes++;
	}

	public void readFileAndSend(String fileName) {
		try {

			String inPath = FileUtil.curDir + "remote" + File.separatorChar;
			inPath += fileName;
			File f = new File(inPath);
			FileInputStream fi = new FileInputStream(inPath);
			BufferedInputStream in = new BufferedInputStream(fi);

			int safePackageSize = 1048576;
			int safePackageSizeClone = safePackageSize;
			int numberSafePackages = 0;
			int data = 0;
			int length = (int) f.length();
			if (length < safePackageSize)
				numberSafePackages = 1;
			else
				numberSafePackages = length / safePackageSize + 1;
			int counter = 0;
			int safePackageNumber = 0;
			int internalSafePackageByteCounter = 0;

			byte[] SafePackage = null;
			SafePackage SafePackageToSend = null;
			while ((data = in.read()) > -1) {
				if (counter % safePackageSize == 0
						&& (length - counter >= safePackageSize)) {

					SafePackage = new byte[safePackageSize];
					safePackageNumber++;
					SafePackageToSend = this.createSafePackageToSend(fileName,
							length, SafePackage);
					SafePackageToSend.setNumber(safePackageNumber);
					SafePackageToSend.setTotal(numberSafePackages);
					internalSafePackageByteCounter = 0;

				} else if (length - counter < safePackageSize
						&& counter % safePackageSize == 0) {

					SafePackage = new byte[length - counter];
					safePackageSizeClone = length - counter;
					safePackageNumber++;
					SafePackageToSend = this.createSafePackageToSend(fileName,
							length, SafePackage);
					SafePackageToSend.setNumber(safePackageNumber);
					SafePackageToSend.setTotal(numberSafePackages);
					internalSafePackageByteCounter = 0;

				}
				SafePackage[internalSafePackageByteCounter] = (byte) data;
				if (internalSafePackageByteCounter == safePackageSizeClone - 1) {
					// sending
					this.send(SafePackageToSend);

				}

				counter++;
				internalSafePackageByteCounter++;
			}// while
			fi.close();
			in.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private SafePackage createSafePackageToSend(String fileName,
			int bigDataSize, byte[] data) {
		SafePackage SafePackageToSend = new SafePackage();
		SafePackageToSend.setCode(Constants.DATA);
		SafePackageToSend.setFileName(fileName);
		SafePackageToSend.setBigDataSize(bigDataSize);
		SafePackageToSend.setData(data);

		return SafePackageToSend;
	}

}
