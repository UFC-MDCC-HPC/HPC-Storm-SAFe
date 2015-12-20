package br.ufc.mdcc.pargo.safe.sample.application;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.ClientEnvPortProxie;

public class ClientServerUsesClient extends HShelfUsesPort{

	public void setServerPort(Integer port){
		
		((ClientEnvPortProxie)this.providesPort).setServerPort(port);
	}
	
	public void addMesssageToBuffer(String message){
		((ClientEnvPortProxie)this.providesPort).addMesssageToBuffer(message);
	}
}
