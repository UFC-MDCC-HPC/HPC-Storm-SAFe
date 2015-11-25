package br.ufc.mdcc.pargo.safe.sample.client.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.application.proxies.ClientComponentProxie;

@WebService
public interface IClientProxieWS {

	@WebMethod
	public void setClientProxie(ClientComponentProxie clientProxie);
	@WebMethod
	public void requestMessage();
}
