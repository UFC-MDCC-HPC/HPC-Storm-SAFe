package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.env.ServiceIServerEnv;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.env.ServiceServerEnvImplService;

public class ServerEnvPortProxie extends HShelfPort{
	
	public String getMsg() {
		ServiceServerEnvImplService service = new ServiceServerEnvImplService();
		ServiceIServerEnv port = service.getServiceServerEnvImplPort();
		return port.getMsg();
	}

}
