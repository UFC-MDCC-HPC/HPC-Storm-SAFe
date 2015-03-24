package br.ufc.mdcc.pargo.safe.port.predefined.environment;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;
import br.ufc.mdcc.pargo.safe.port.annotations.UsesProvidesAnnotation;

/*  -> PROVIDES PARA MÉTODOS ABAIXO: WORKFLOW
 *  workflow deseja resolver um contrato
 *	workflow deseja informar um evento de execução
 *  workflow deseja receber o código SAFeSWL da aplicação
 */
public abstract class WorkflowPredefinedPortUses implements IHPCStormEnvironmentPort{

	@Override
	public String getType() {
		return IHPCStormPort.uses;
	}

	@UsesProvidesAnnotation(key=1)
	public abstract void usesSAFeSWL(HPCStormSAFeSWL safeSWL);
	
}
