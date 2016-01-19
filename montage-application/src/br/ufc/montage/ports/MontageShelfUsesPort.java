package br.ufc.montage.ports;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;

public class MontageShelfUsesPort extends HShelfUsesPort{
	
	public String getValue() {
		return ((MontageShelfProvidesPort)this.providesPort).getValue();
	}

	public void setValue(String value) {
		((MontageShelfProvidesPort)this.providesPort).setValue(value);
	}
}
