package br.ufc.mdcc.pargo.safe.services;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public interface IHPCStormServices{

	//port registering...
	public IHPCStormPort getUsesPort(IHPCStormPort portName);
	public void setProvidesPort(IHPCStormPort provides);
	public void registerUsesPort(IHPCStormPort uses);
	
	//utilitary classes... TODO
}
