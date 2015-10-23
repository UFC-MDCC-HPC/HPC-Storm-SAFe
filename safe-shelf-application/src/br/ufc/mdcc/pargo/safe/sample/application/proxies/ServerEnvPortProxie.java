package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.env.IServiceServerEnv;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.env.ServiceServerEnvImplService;

public class ServerEnvPortProxie extends HShelfPort{
	
	public void setPort(Integer port){
		ServiceServerEnvImplService service = new ServiceServerEnvImplService();
		IServiceServerEnv portWS = service.getServiceServerEnvImplPort();
		portWS.setPort(port);
	}

}
