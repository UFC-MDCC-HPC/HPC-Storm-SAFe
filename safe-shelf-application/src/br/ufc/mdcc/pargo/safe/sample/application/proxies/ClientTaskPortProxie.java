package br.ufc.mdcc.pargo.safe.sample.application.proxies;



import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.task.IServiceClientTask;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.task.ServiceClientTaskImplService;

public class ClientTaskPortProxie extends HShelfPort{
	
	
	public void connect(){
		ServiceClientTaskImplService service = new ServiceClientTaskImplService();
		IServiceClientTask port = service.getServiceClientTaskImplPort();
		port.connect();
	}

	public void post(){
		ServiceClientTaskImplService service = new ServiceClientTaskImplService();
		IServiceClientTask port = service.getServiceClientTaskImplPort();
		port.post();
	}
	 
}
