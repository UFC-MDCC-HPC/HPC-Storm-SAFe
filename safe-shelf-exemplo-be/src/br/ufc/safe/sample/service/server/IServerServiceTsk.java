package br.ufc.safe.sample.service.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IServerServiceTsk {

	@WebMethod
	public void get();
	@WebMethod
	public void request();
}
