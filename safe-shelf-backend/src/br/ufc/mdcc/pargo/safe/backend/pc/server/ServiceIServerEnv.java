package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServiceIServerEnv {

	@WebMethod
	public String getMsg();
}
