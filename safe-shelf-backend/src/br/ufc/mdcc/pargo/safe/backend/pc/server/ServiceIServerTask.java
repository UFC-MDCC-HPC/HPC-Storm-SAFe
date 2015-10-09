package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServiceIServerTask {

	@WebMethod
	public void setPort(Integer port);
	@WebMethod
	public void initialize();
}
