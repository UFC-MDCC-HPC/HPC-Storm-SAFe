package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.oper.WSIServerConsumerOperationPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.oper.WSIServerConsumerOperationPortImplService;

public class ServerOperationPortProxie extends HShelfPort{
	
	public void setPort(Integer num){
		WSIServerConsumerOperationPort port;
		WSIServerConsumerOperationPortImplService service = new WSIServerConsumerOperationPortImplService();
		port = service.getWSIServerConsumerOperationPortImplPort();
		port.setPort(num);
	}
	
	public String getMsg(){
		WSIServerConsumerOperationPort port;
		WSIServerConsumerOperationPortImplService service = new WSIServerConsumerOperationPortImplService();
		port = service.getWSIServerConsumerOperationPortImplPort();
		return port.getMsg();
	}
}
