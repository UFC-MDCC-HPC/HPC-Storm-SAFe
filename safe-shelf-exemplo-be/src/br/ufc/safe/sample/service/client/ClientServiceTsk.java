package br.ufc.safe.sample.service.client;

import javax.jws.WebService;

import br.ufc.safe.sample.cmp.ClientBE;

@WebService(endpointInterface="br.ufc.safe.sample.service.client.IClientServiceTsk")
public class ClientServiceTsk implements IClientServiceTsk{

	private ClientBE clientBE;

	public ClientServiceTsk(ClientBE clientBE) {
		this.clientBE = clientBE;
	}
	
	@Override
	public void post() {
		this.clientBE.post();
		
	}

	@Override
	public void send() {
		this.clientBE.send();
	}

	 
}
