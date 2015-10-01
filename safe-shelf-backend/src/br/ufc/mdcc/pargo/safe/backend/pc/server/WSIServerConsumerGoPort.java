package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WSIServerConsumerGoPort {
	@WebMethod
	public void go();
}
