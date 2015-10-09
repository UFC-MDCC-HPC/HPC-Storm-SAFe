package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.env.ServiceClientEnvImplService;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.env.ServiceIClientEnv;

public class ClientEnvPortProxie extends HShelfPort{

	public void sendMsg(String msg){
		ServiceClientEnvImplService service = new ServiceClientEnvImplService();
		ServiceIClientEnv port = service.getServiceClientEnvImplPort();
		port.sendMsg(msg);
	}
	
}
