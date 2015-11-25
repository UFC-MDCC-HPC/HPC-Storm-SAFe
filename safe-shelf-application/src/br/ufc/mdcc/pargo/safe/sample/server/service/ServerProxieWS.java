package br.ufc.mdcc.pargo.safe.sample.server.service;

import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.application.proxies.ServerComponentProxie;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.sample.server.service.IServerProxieWS")
public class ServerProxieWS implements IServerProxieWS{

	ServerComponentProxie serverProxie;
	
	@Override
	public void setServerProxie(ServerComponentProxie serverProxie) {
		this.serverProxie = serverProxie;
		
	}

	@Override
	public void sendMessage(String message) {
		this.serverProxie.sendMessage(message);
	}

}
