package br.ufc.mdcc.pargo.safe.port.predefined.environment;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvironmentPort;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

/* -> PROVIDES PARA MÉTODOS ABAIXO: APLICAÇÃO
 * componente deseja informações sobre a aplicação;
 * componente precisa validar credenciais da aplicação;
 * componente dispara gatilho para informar evento à aplicação.
 */

public abstract class OtherComponentPredefinedPortUses implements IHPCStormEnvironmentPort{

	@Override
	public String getType() {
		return IHPCStormPort.uses;
	}
}
