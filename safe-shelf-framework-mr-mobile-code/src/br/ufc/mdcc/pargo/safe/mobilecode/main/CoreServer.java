package br.ufc.mdcc.pargo.safe.mobilecode.main;

import br.ufc.mdcc.pargo.safe.mobilecode.comm.Client;
import br.ufc.mdcc.pargo.safe.mobilecode.util.Constants;

public class CoreServer {
	
	public static void main(String[] args) {
		
		Client client = new Client();
		Constants.SERVER_PORT = 10010;
		client.connect("localhost", Constants.SERVER_PORT);
		client.readFileAndSend("morphufc.zip");
	}

}
