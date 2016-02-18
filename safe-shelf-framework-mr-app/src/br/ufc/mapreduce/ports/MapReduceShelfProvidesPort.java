package br.ufc.mapreduce.ports;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;

public class MapReduceShelfProvidesPort extends HShelfProvidesPort{

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
