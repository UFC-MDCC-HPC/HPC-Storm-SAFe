package br.ufc.mdcc.pargo.safe.sample.server.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.application.proxies.ServerComponentProxie;

@WebService
public interface IServerProxieWS {

	@WebMethod
	public void setServerProxie(ServerComponentProxie serverProxie);
	@WebMethod
	public void sendMessage(String message);
}
