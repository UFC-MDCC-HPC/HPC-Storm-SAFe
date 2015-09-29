package br.ufc.mdcc.pargo.safe.sample.cca;

import br.ufc.mdcc.pargo.safe.port.dflt.HShelfGoPort;

public class ShelfPortGoClient extends HShelfGoPort{

	
	ShelfClientComponent client;
	
	@Override
	public void go() {
		client.run();
	}

}
