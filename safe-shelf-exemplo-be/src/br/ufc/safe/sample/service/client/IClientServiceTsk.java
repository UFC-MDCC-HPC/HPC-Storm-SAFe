package br.ufc.safe.sample.service.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IClientServiceTsk {

	@WebMethod
	public void post();
	@WebMethod
	public void send();
}
