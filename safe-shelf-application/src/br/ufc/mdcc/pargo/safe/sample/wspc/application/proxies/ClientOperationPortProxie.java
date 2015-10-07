package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper.WSIClientProducerOperationPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper.WSIClientProducerOperationPortImplService;

public class ClientOperationPortProxie extends HShelfPort{

	
	
	public void setServerPort(Integer num){
		WSIClientProducerOperationPortImplService service = new WSIClientProducerOperationPortImplService();
		WSIClientProducerOperationPort port;
		port = service.getWSIClientProducerOperationPortImplPort();
		port.setServerPort(num);
	}
	
	public void sendMsg(String msg){
		WSIClientProducerOperationPortImplService service = new WSIClientProducerOperationPortImplService();
		WSIClientProducerOperationPort port;
		port = service.getWSIClientProducerOperationPortImplPort();
		port.sendMsg(msg);
	}
}
