package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.server.WSIServerConsumerGoPort")
public class WSIServerConsumerGoPortImpl implements WSIServerConsumerGoPort{

	IServerConsumer server;
	
	public WSIServerConsumerGoPortImpl(IServerConsumer server) {
		this.server = server;
	}
	
	@Override
	@WebMethod
	public void go() {
		server.initialize();
		
	}

}
