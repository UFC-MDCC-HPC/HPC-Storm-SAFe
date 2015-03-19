package br.ufc.mdcc.pargo.safe.port.predefined;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;

 
public interface IApplicationPredefinedPort extends IHPCStormEnvironmentPort{

	public HPCStormSAFeSWL providesSAFeSWL();
}
