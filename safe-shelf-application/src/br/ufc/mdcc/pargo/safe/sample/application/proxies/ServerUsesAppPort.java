package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.sample.port.ApplicationPort_A;

public class ServerUsesAppPort extends HShelfUsesPort{

	public void sendMessage(String message){
		((ApplicationPort_A)this.providesPort).sendMessage(message);
	}
}
