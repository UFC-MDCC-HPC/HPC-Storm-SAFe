package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.task.ServiceIServerTask;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.task.ServiceServerTaskImplService;

public class ServerTaskPortProxie extends HShelfPort{
	
	public void setPort(Integer port){
		ServiceServerTaskImplService service = new ServiceServerTaskImplService();
		ServiceIServerTask task = service.getServiceServerTaskImplPort();
		task.setPort(port);
	}
	 
	public void initialize(){
		ServiceServerTaskImplService service = new ServiceServerTaskImplService();
		ServiceIServerTask task = service.getServiceServerTaskImplPort();
		task.initialize();
	}
 
}
