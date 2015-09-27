package br.ufc.mdcc.pargo.safe.port;

import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public abstract class HShelfUsesPort extends HShelfPort {
	public HShelfUsesPort() {
		HShelfConsoleLogger.write("Creating HShelfUsesPort");
	}
	
	public Object getValue(){
		return this.value;
	}
}
