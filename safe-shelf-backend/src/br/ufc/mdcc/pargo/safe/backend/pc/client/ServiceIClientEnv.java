package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ServiceIClientEnv {
	
	@WebMethod
	public void sendMsg(String msg);
}
