package br.ufc.mapreduce.swing.ports;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;

public class MapReduceShelfUsesPort extends HShelfUsesPort{
	
	public String getValue() {
		return ((MapReduceShelfProvidesPort)this.providesPort).getValue();
	}

	public void setValue(String value) {
		((MapReduceShelfProvidesPort)this.providesPort).setValue(value);
	}
}
