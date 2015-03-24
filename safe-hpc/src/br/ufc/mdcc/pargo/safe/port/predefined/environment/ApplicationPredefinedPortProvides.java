package br.ufc.mdcc.pargo.safe.port.predefined.environment;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;
import br.ufc.mdcc.pargo.safe.port.annotations.UsesProvidesAnnotation;

public abstract class ApplicationPredefinedPortProvides implements IHPCStormEnvironmentPort{

	@Override
	public String getType() {
		return IHPCStormPort.provides;
	}
	
	@UsesProvidesAnnotation(key=1)
	public abstract HPCStormSAFeSWL providesSAFeSWL();
}
