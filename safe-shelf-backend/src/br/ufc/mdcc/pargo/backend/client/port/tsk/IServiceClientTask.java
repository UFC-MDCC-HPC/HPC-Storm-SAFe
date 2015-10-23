package br.ufc.mdcc.pargo.backend.client.port.tsk;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IServiceClientTask {

	@WebMethod
	public void connect();
	@WebMethod
	public void post();

}
