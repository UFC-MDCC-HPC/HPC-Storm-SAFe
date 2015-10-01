package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WSIClientProducerOperationPort {

	@WebMethod
	public void setServerPort(Integer port);
	@WebMethod
	public void sendMsg(String msg);
}
