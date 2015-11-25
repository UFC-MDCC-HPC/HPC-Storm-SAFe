package br.ufc.mdcc.pargo.safe.sample.client.service;

import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.application.proxies.ClientComponentProxie;

@WebService(endpointInterface = "br.ufc.mdcc.pargo.safe.sample.client.service.IClientProxieWS")
public class ClientProxieWS implements IClientProxieWS{

	ClientComponentProxie clientProxie;
	
	@Override
	public void setClientProxie(ClientComponentProxie clientProxie) {
		this.clientProxie = clientProxie;		
	}

	@Override
	public void requestMessage() {
		this.clientProxie.requestMessage();
	}

}
