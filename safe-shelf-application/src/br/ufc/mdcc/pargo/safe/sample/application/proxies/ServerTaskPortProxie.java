package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.task.IServiceServerTask;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.task.ServiceServerTaskImplService;

public class ServerTaskPortProxie extends HShelfPort{
	
	public void connect(){
		ServiceServerTaskImplService service = new ServiceServerTaskImplService();
		IServiceServerTask port = service.getServiceServerTaskImplPort();
		port.connect();
	}
 
}
