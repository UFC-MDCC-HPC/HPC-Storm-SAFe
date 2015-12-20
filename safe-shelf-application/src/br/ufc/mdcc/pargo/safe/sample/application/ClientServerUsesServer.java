package br.ufc.mdcc.pargo.safe.sample.application;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.ServerEnvPortProxie;

public class ClientServerUsesServer extends HShelfUsesPort{

	public void setPort(Integer port){
		((ServerEnvPortProxie)this.providesPort).setPort(port);
	}
}
