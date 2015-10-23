package br.ufc.mdcc.pargo.safe.server.port.tsk;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IServiceServerTask {

	@WebMethod
	public void connect();
}
