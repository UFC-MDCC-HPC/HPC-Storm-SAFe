package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.env.IServiceClientEnv;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.env.ServiceClientEnvImplService;

public class ClientEnvPortProxie extends HShelfPort{

	
	public void setServerPort(Integer port){
		ServiceClientEnvImplService service = new ServiceClientEnvImplService();
		IServiceClientEnv portWS = service.getServiceClientEnvImplPort();
		portWS.setServerPort(port);
	}
	
	public void addMesssageToBuffer(String message){
		ServiceClientEnvImplService service = new ServiceClientEnvImplService();
		IServiceClientEnv portWS = service.getServiceClientEnvImplPort();
		portWS.addMesssageToBuffer(message);
	}
	 
	
}
