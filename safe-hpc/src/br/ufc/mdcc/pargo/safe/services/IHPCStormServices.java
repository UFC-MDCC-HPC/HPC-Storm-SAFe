package br.ufc.mdcc.pargo.safe.services;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public interface IHPCStormServices{

	public IHPCStormPort getUsesPort(IHPCStormPort portName);
	public void setProvidesPort(IHPCStormPort provides);
	public void registerUsesPort(IHPCStormPort uses);
	 
}
