package br.ufc.mdcc.pargo.safe.port.predefined.environment;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

/*-> PROVIDES PARA MÉTODOS ABAIXO: WORKFLOW
 * aplicação deseja consultar o estado de execução do workflow
 * aplicação deseja iniciar/pausar/abortar a execução do workflow
 * aplicação decide aplicar uma reconfiguração ao workflow
 * 
 * -> PROVIDES PARA MÉTODOS ABAIXO: COMPONENTE QUALQUER
 * aplicação deseja verificar sanidade da execução do componente;
 * aplicação deseja introduzir gatilho para monitorar condições do estado da execução do componente;
 * aplicação decide aplicar reconfigurações ao componente (ex: reconfigurações elásticas, de natureza vertical ou horizontal);
 * aplicação deseja verificar status de um componente.
 */
 
public abstract class ApplicationPredefinedPortUses implements IHPCStormEnvironmentPort{

	@Override
	public String getType() {
		return IHPCStormPort.uses;
	}
}
