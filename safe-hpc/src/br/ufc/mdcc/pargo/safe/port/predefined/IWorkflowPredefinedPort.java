package br.ufc.mdcc.pargo.safe.port.predefined;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;
import br.ufc.mdcc.pargo.safe.port.annotations.UsesProvidesAnnotation;
/**
 * Application provides Port
 * @author jefferson
 *
 */
public interface IWorkflowPredefinedPort extends IHPCStormEnvironmentPort{

	@UsesProvidesAnnotation(key=2)
	public void usesSAFeSWL(HPCStormSAFeSWL safeSWL);

}
