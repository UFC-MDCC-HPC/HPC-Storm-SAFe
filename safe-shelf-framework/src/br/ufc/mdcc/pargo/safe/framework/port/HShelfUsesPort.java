package br.ufc.mdcc.pargo.safe.framework.port;

public class HShelfUsesPort extends HShelfEnvironmentPort{

	protected HShelfProvidesPort providesPort;

	public void setProvidesPort(HShelfProvidesPort providesPort) {
		this.providesPort = providesPort;
	}
	
}
