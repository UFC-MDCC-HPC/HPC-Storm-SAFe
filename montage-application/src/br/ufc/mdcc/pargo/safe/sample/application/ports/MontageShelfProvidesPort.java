package br.ufc.mdcc.pargo.safe.sample.application.ports;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;

public class MontageShelfProvidesPort extends HShelfProvidesPort{

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
