package br.ufc.mdcc.pargo.safe.port.predefined;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;
/**
 * Application provides Port
 * @author jefferson
 *
 */
public interface IWorkflowPredefinedPort extends IHPCStormEnvironmentPort{

	public void usesSAFeSWL(HPCStormSAFeSWL safeSWL);

}
