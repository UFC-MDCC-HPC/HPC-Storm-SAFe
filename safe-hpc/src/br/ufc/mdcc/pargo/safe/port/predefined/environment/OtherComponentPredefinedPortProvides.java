package br.ufc.mdcc.pargo.safe.port.predefined.environment;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public abstract class OtherComponentPredefinedPortProvides implements IHPCStormEnvironmentPort{

	@Override
	public String getType() {
		return IHPCStormPort.provides;
	}

}
