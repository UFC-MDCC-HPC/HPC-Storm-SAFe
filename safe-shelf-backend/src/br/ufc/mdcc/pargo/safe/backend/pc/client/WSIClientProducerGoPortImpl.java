package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.client.WSIClientProducerGoPort")
public class WSIClientProducerGoPortImpl implements WSIClientProducerGoPort{

	private IClientProducer client;
	
	public WSIClientProducerGoPortImpl(IClientProducer client) {
		this.client = client;
	}
	
	@Override
	public void go() {
		this.client.initialize();
	}

}
