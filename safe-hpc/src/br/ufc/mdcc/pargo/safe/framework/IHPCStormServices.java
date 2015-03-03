package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public interface IHPCStormServices {

	public IHPCStormPort getUsesPort(String portName);
	public void setProvidesPort(IHPCStormPort provides);
	public void registerUsesPort(IHPCStormPort uses);
}
