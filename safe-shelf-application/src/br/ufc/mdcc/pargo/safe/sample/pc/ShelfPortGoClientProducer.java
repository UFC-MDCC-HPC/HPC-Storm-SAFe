package br.ufc.mdcc.pargo.safe.sample.pc;

import br.ufc.mdcc.pargo.safe.port.dflt.HShelfGoPort;

public class ShelfPortGoClientProducer extends HShelfGoPort{

	
	ShelfClientProducer client;
	
	@Override
	public void go() {
		client.run();
	}

}
