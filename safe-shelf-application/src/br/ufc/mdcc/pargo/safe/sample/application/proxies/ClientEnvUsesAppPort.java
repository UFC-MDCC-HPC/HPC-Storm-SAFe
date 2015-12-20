package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.sample.port.ApplicationPort_A;

public class ClientEnvUsesAppPort extends HShelfUsesPort{

	public void requestMessage(){
		((ApplicationPort_A)this.providesPort).requestMessage();
	}
}
