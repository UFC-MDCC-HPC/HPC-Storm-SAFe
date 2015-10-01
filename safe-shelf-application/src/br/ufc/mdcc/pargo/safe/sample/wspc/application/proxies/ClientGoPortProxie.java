package br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.go.WSIClientProducerGoPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.go.WSIClientProducerGoPortImplService;

public class ClientGoPortProxie extends HShelfPort{
	
	public void go(){
		
		WSIClientProducerGoPort port;
		WSIClientProducerGoPortImplService service;
		
		service = new WSIClientProducerGoPortImplService();
		port = service.getWSIClientProducerGoPortImplPort(); //só funciona se o ws tiver no ar
		
		port.go();
	}
}
