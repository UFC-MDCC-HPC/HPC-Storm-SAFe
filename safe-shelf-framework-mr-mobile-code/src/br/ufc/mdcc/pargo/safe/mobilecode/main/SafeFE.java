package br.ufc.mdcc.pargo.safe.mobilecode.main;

import br.ufc.mdcc.pargo.safe.mobilecode.comm.Server;
import br.ufc.mdcc.pargo.safe.mobilecode.util.Constants;

public class SafeFE {

	public static void main(String[] args) {
		Constants.SERVER_PORT = 10010;
		Server server = new Server();
		server.start();
	}
}
