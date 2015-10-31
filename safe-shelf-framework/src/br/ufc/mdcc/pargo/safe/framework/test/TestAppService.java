package br.ufc.mdcc.pargo.safe.framework.test;

import br.ufc.mdcc.pargo.safe.framework.application.biding.HShelfApplicationBidingServerFacade;

public class TestAppService {

	public static void main(String[] args) {
		HShelfApplicationBidingServerFacade facadeServer = new HShelfApplicationBidingServerFacade();
		facadeServer.startServer();
	}
}
