package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.go.WSIServerConsumerGoPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.go.WSIServerConsumerGoPortImplService;

public class ServerGoPortProxie extends HShelfPort{
	
	public void go(){
		WSIServerConsumerGoPort port;
		WSIServerConsumerGoPortImplService service = new WSIServerConsumerGoPortImplService();
		port = service.getWSIServerConsumerGoPortImplPort();
		port.go();
	}
}
