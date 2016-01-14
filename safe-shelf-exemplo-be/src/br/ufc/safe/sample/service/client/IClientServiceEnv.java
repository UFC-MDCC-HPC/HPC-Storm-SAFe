package br.ufc.safe.sample.service.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IClientServiceEnv {
	
	@WebMethod
	public void addMessage(String message);
}
