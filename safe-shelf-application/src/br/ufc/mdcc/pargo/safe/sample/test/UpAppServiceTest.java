package br.ufc.mdcc.pargo.safe.sample.test;

import br.ufc.mdcc.pargo.safe.sample.port.ClientServerApplicationPort;

public class UpAppServiceTest {

	public static void main(String[] args) {
		ClientServerApplicationPort port = new ClientServerApplicationPort();
		port.startService();
	}
}
