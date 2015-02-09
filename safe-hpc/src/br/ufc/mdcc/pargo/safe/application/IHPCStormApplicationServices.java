package br.ufc.mdcc.pargo.safe.application;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public interface IHPCStormApplicationServices {

	 public IHPCStormPort getUsesPort();
	 public void setProvidesPort(IHPCStormPort provides);
}
