package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.task.ServiceClientTaskImplService;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.task.ServiceIClientTask;

public class ClientTaskPortProxie extends HShelfPort{
	
	public void setServerPort(Integer serverPort){
		ServiceClientTaskImplService service = new ServiceClientTaskImplService();
		ServiceIClientTask port = service.getServiceClientTaskImplPort();
		port.setServerPort(serverPort);
	}
	
	public void initialize(){
		ServiceClientTaskImplService service = new ServiceClientTaskImplService();
		ServiceIClientTask port = service.getServiceClientTaskImplPort();
		port.initialize();
	}
	
	 
}
