package br.ufc.mdcc.pargo.safe.server.port.env;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IServiceServerEnv {

	@WebMethod
	public void setPort(Integer port);
	
	public void sendMessageToApplication(String message);
}
