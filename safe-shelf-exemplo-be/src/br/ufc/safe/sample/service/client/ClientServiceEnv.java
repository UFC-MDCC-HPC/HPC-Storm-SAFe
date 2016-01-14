package br.ufc.safe.sample.service.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.safe.sample.cmp.ClientBE;

@WebService(endpointInterface="br.ufc.safe.sample.service.client.IClientServiceEnv")
public class ClientServiceEnv implements IClientServiceEnv{

	private ClientBE clientBE;

	
	public ClientServiceEnv(ClientBE clientBE) {
		this.clientBE = clientBE;
	}

	@Override
	@WebMethod
	public void addMessage(String message) {
		this.clientBE.addMessage(message);
	}

}
