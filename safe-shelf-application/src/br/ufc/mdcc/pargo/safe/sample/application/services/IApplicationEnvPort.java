package br.ufc.mdcc.pargo.safe.sample.application.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IApplicationEnvPort {

	@WebMethod
	public void requestMessage();
	@WebMethod
	public void receiveMessage(String message);
}
