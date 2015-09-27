package br.ufc.mdcc.pargo.safe.port;

import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public abstract class HShelfProvidesPort extends HShelfPort{

	public HShelfProvidesPort() {
		HShelfConsoleLogger.write("Creating HShelfProvidesPort");
	}
	
	public void setValue(Object value){
		this.value = value;
	}
}
