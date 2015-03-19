package br.ufc.mdcc.pargo.safe.services;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public class HPCStormConnection {

	private IHPCStormPort uses;
	private IHPCStormPort provides;
	
	public HPCStormConnection(IHPCStormPort uses, IHPCStormPort provides) {
		this.uses = uses;
		this.provides = provides;
	}
}
