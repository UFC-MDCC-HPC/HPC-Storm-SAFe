package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WSIClientProducerGoPort {

	@WebMethod
	public void go();
}
